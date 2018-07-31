/**
 * This package contain RuleProcess Class which apply all logic on RDD[String] and handel all failiure cases.
 */
package org.streaming.rule.processing

//import com.orchastration.logger.OrchastrationLogger
import org.streaming.kafka.KafkaProcessing
import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.streaming.kafka.KafkaProcessing
//import org.apache.hadoop.mapreduce.v2.app.webapp.App
//import org.apache.spark.sql.SaveMode
//import org.streaming.generic.DynamicQuery
import java.sql._
import org.streaming.rule.config.Configuration
import scala.collection.immutable.Map
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._
import scala.collection.JavaConversions._
//import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Row

import org.apache.spark.scheduler.MapStatus
import scala.util.control.Breaks._
import scala.collection.JavaConversions._
import scala.collection.immutable.HashMap
import play.api.libs.json._
import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import java.lang.reflect.Type
import org.streaming.kafka.KafkaProcessing
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
//import org.apache.spark.sql.types.StructType
import org.apache.spark.api.java.JavaRDD
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.Dataset
import org.apache.commons.lang.StringUtils
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.streaming.notification.http.client.HttpURLCalling
import org.streaming.json.JsonModification
import org.apache.spark.sql.catalyst.expressions.Literal
import org.apache.spark.sql.functions.udf
import java.util.Date
import org.apache.spark.sql.DataFrame
import org.kafka.publish.AuditLogPublisher
import org.streaming.notification.http.client.SoapApiCalling
import org.json.JSONObject
import org.json.XML
import com.orchastration.logger.TCPLogger
import java.lang.Long

/**
 * RuleProcess class contain following methods
 * 1)createJsonRdd(jsonRdd: RDD[String]):-
 * 			a)handel corrupt json,if json is corrupted it send data to audit_log and notification kafka topic with parmanent failiure message
 * 			b)fetch dataframe from RDD according to group_id and order by sequence_id.
 * 			c)validate input parameter with validateParams method which set all input parameter which containing response param value
 * 			d)set body of Rest and Soap API so it will call api directly
 *
 * 2)validateParams(row: Row,audiLogPublisher:AuditLogPublisher,incomingAPI:DataFrame,list_data_frame:java.util.ArrayList[String],
 *      list_api_id:java.util.ArrayList[String]):
 *      a)It validate all input parameter and set its parameter_name and parameter_value to hashmap.
 *      b)If any input parameter having value refrence to response value of uper sequence api
 *      (i.e : #$#parameter_name#&#api_id#&#group_id) .if fetch param value mapped with parameter_name ,api_id and group_id
 *
 *  3)RestSoapBody(input_params_value:Map[String,String],api_template:String,api_type:String):
 *  		It manipulate template according to rest and soap api and set it to body of api calling.
 */
class RuleProcess() extends Serializable {

  /**
   * createJsonRdd(jsonRdd: RDD[String]) method is user to extract json string of api from Request_Topic of kafka and manipulate and
   * push it to Audit_Log ,Retry_Topic or Notification Topic of kafka based on success or failiure of API
   * a)handel corrupt json,if json is corrupted it send data to audit_log and notification kafka topic with parmanent failiure message
   * b)fetch dataframe from RDD according to group_id and order by sequence_id.
   * c)validate input parameter with validateParams method which set all input parameter which containing response param value
   * d)set body of Rest and Soap API so it will call api directly
   *
   */
  def createJsonRdd(jsonRdd: RDD[String]): Unit = {

    try {

      /**
       * Kafka Sreams are first put in temporary table and then further manipulations are applied to it like rule execution query
       */
      new SparkSql().generateDataSet(jsonRdd.cache(), KafkaProcessing.sqlContext, Configuration.tempTable)
      var group_api_id: DataFrame = null;

      try {

        /**
         * Fetch unique api_group_id from temp_table of spark sql.
         */
        group_api_id = KafkaProcessing.sqlContext.sql(Configuration.distinct_api_query.replaceAll("table_name", Configuration.tempTable));

      } catch {

        /**
         * If json is corrupted than catch block call
         */
        case t: Throwable => // TODO: handle error
            TCPLogger.printStream.append(t.getMessage)

          //fetch corrupt json string from spark sql table with _corrupt_record column
          var corrup_json = KafkaProcessing.sqlContext.sql(Configuration.corrupt_json_query.replaceAll("table_name", Configuration.tempTable));

          corrup_json.collect().foreach(json_string => {

            var corrupt_json_map: Map[String, String] = new HashMap[String, String]();
            

            /**
             * Fetch important parameter value (i.e :"api_group_id,api_id,parameter_name,parameter_value")
             * from corrupt json for push entry to Audit_Log and Notification kafak Topic
             */
            for (i <- 0 to Configuration.corruptJsonParams.length - 1) {

              var param_name = Configuration.corruptJsonParams.apply(i).trim()
              var param_value = ""
              var pattern = Pattern.compile("\"" + param_name + "\":(.*?),");

              var matcher = pattern.matcher(json_string.getAs[String](Configuration.corrupt_record_param))

              if (matcher.find()) {
                var match_case = matcher.group(1);
                param_value = String.valueOf(match_case).replaceAll("\"", "")

              }

              corrupt_json_map += (param_name -> param_value)

            }

            corrupt_json_map += (Configuration.is_sucessful_param -> Configuration.is_sucessful_fail_param_value)
            corrupt_json_map += (Configuration.response_code_param -> Configuration.corrupt_json_response_code)
            corrupt_json_map += (Configuration.response_param -> json_string.getAs[String](Configuration.corrupt_record_param))
            corrupt_json_map += (Configuration.audit_log_name -> Configuration.corrupt_record_param)
            
            

            //convert all important parameter and value to valid json
            var jsonString: String = Json.toJson(corrupt_json_map).toString()
            
           TCPLogger.logger.info(jsonString)

            //push to kafa Audit_Log Topic
            Configuration.kafkaPublisher.publishToKafka(Configuration.auditLogTopic, jsonString)
          })
      }

      //if json is correct
      if (group_api_id != null && group_api_id.collect().length > 0) {

//       println(group_api_id.collectAsList())

        try{KafkaProcessing.sqlContext.dropTempTable(Configuration.paramTableName)}
        catch {
          case t: Throwable => 
          TCPLogger.printStream.append(t.getMessage)  
            
            
        }
        
        
        
        group_api_id.collect().foreach(group_id => {
      
          

          /* var incomingAPI: DataFrame = KafkaProcessing.sqlContext.sql("select * from " + Configuration.tempTable + "  where" +
            " api_group_id ='" + group_id.getAs[String]("api_group_id") + "' order by api_group_id,api_sequence");*/

          /**
           * Fetch all API of similiar api_group_id from temp_table of Spark sql
           */
          var incomingAPI: DataFrame = KafkaProcessing.sqlContext.sql(Configuration.fetchingAPI_query.replace("table_name", Configuration.tempTable.trim())
            .replaceAll("#" + Configuration.api_group_id_param.trim() + "#", String.valueOf(group_id.getAs[Long](Configuration.api_group_id_param.trim())).trim()));
          
          if (incomingAPI.collect().length > 0) {
          
            // list_api_id is declare to maintain all api_id so we can find out which api is remaining to call 
            var list_api_id = new java.util.ArrayList[String]()
            
            //list_data_frame is declare to maintain all API Response and same structure so we can send it to Retry_Topic
            var list_data_frame = new java.util.ArrayList[String]()
            
            //set all api id of similiar api group to list_api_id variable
            incomingAPI.select(Configuration.api_id_param).rdd.map(r => r(0)).collect().foreach { x => list_api_id.add(String.valueOf(x)) }

            
            var audiLogPublisher = new AuditLogPublisher
            
            var fail_status = false;
            
            /**
             * Start execute logic to each api in RDD[String]
             */
            incomingAPI.collect().foreach(t => {

              //set complete api_url
              var api_url: String = t.getAs[String](Configuration.api_host_address_param) + t.getAs[String](Configuration.api_url_param)
              
              TCPLogger.logger.info("API URL : \n"+api_url)
              //set parameter_header bit (is header or body) parameter
              var api_headers_params_isHeader = t.getAs[String](Configuration.input_parameter_is_header_param).split(",")
              
              //set api_template for rest/Soap API
              var api_template = t.getAs[String](Configuration.api_template_param)
              
              //API Type- Rest/Soap
              var api_type = t.getAs[String](Configuration.api_api_type_param)
              
              var api_method_type=t.getAs[String](Configuration.api_method_type_param)
              /**
               * validateParams method invoke which set all input paramameters value to hashmap[String,String]
               */
              var input_params_value = validateParams(t, audiLogPublisher, incomingAPI, list_data_frame, list_api_id)
              
             println("input_parameters:-" + input_params_value)
             TCPLogger.logger.info("input_parameters:-" + input_params_value)
             
             TCPLogger.logger.info("api_template:"+api_template);
              println("api_template:"+api_template);
              /**
               * Set all parameter value from input_params_value variable to API(Rest/Soap) body template
               */
              var api_body = RestSoapBody(input_params_value, api_template, api_type)

               TCPLogger.logger.info(api_body)
              
              /**
               * Set Api Header paramaters value
               */
              var header_map = new java.util.HashMap[String, String]
              
              var input_parameters = t.getAs[String](Configuration.input_parameters_name_param).split(",");
              for (i <- 0 to api_headers_params_isHeader.length - 1) {
                var is_header = api_headers_params_isHeader.apply(i).toString()
                if (is_header.equalsIgnoreCase("1")) {
                  header_map.put(input_parameters.apply(i), String.valueOf(input_params_value.get(input_parameters.apply(i).toString()).get))
                }

              }

              
              /**
               * Calling Rest/Soap Api and set Response to response_json_code for furthur processing
               * response_json_code formate is:- #$#response_code#$#response_json 
               */
              
              var response_json_code = ""
              
              if(input_params_value.contains("sleepTime")){
                println("inside sleep");
//                Thread.sleep(Integer.valueOf(input_params_value.get("sleepTime").toString()));
                try{
                Thread.sleep(Long.valueOf(input_params_value.get("sleepTime").get.toString().replaceAll(" ", "")));
                }catch {
                  
                  case t: Throwable => t.printStackTrace() // TODO: handle error
                  println("inside catch block"+t.getMessage)
                }
                println("notify");
              }
              if (api_type.toLowerCase().equalsIgnoreCase(Configuration.rest)) {
                var http = new HttpURLCalling()

                api_url=RestSoapBody(input_params_value, api_url, api_type)
                response_json_code = http.getData(api_url, api_body, header_map,api_method_type)
              }
              
              

              /**
               * Calling soap API 
               */
              if (api_type.toLowerCase().equalsIgnoreCase(Configuration.soap)) {
                var soap = new SoapApiCalling

                response_json_code = soap.getData(api_url, api_body, header_map)

                var response_json = String.valueOf(response_json_code.split("#\\$#")(2))
                var response_code = String.valueOf(response_json_code.split("#\\$#")(1));
              
//               TCPLogger.logger.info("response json of soap api:-" + String.valueOf(response_json));
                
                //convert XML Response to json String and set response_json_code accoding to formate
                var json = XML.toJSONObject(response_json);
                response_json_code = "#$#" + response_code + "#$#" + json.toString()
              }

             TCPLogger.logger.info("Whole Response From API:-" + String.valueOf(response_json_code))

              /**
               * successAndFailiurPublisher method is invoke. This method check response code and publish json to kafka accordingly
               * Response code :on sucess of permanent failiure (ie. 200,500) kafka topic:- Notification and Audit_Log
               * Response code :401 kafka topic:- Retry_Topic and Audit_Log
               */
              var status = audiLogPublisher.successAndFailiurPublisher(input_params_value,response_json_code, t, list_data_frame, list_api_id, incomingAPI)

              //Status fail it break loop in failiure or retry case
              if (!status) {
                break
              }
            })

          } else {
            /*
       			 	 * No rule is available for execution
         		*/
           TCPLogger.logger.info("data Not Found");
          }

         TCPLogger.logger.info("all api of group id :-" + group_id.getAs[String](Configuration.api_group_id_param) + "is successfully inserted")
        })
      }

    } catch {
      case t: Throwable =>
        t.printStackTrace() // TODO: handle error
        
        TCPLogger.printStream.append(t.getMessage)

    }

  }

  
  /**
   * validateParams(row: Row,audiLogPublisher:AuditLogPublisher,incomingAPI:DataFrame,list_data_frame:java.util.ArrayList[String],
	 * list_api_id:java.util.ArrayList[String]):
	 * This method is use to set all input parameter and its value to hashmap .if any parameter is from response of uper sequence api.
	 * it execute query and fetch that parameter value from API Response parameter which is already set in tmp_param table 
	 * according to api_id,api_group_id and parameter_name 
	 * a)It validate all input parameter and set its parameter_name and parameter_value to hashmap.
	 * b)If any input parameter having value refrence to response value of uper sequence api
 	 *  (i.e : #$#parameter_name#&#api_id#&#group_id) .it fetch param value mapped with parameter_name ,api_id and group_id from tmp_param table
   */
  def validateParams(row: Row, audiLogPublisher: AuditLogPublisher, incomingAPI: DataFrame, list_data_frame: java.util.ArrayList[String],
    list_api_id: java.util.ArrayList[String]): Map[String, String] = {
//   println("inside validate params")

    var mapStatus: Map[String, String] = new HashMap[String, String]();

    var api_group_id = row.getAs[Object](Configuration.api_group_id_param)
    
    var api_id = row.getAs[Object](Configuration.api_id_param)
    
    var input_parameters = row.getAs[String](Configuration.input_parameters_name_param).split(",");
    
    var input_parameters_value = row.getAs[String](Configuration.input_parameters_value_param).split(",")

//   println("set all params")
    for (i <- 0 to input_parameters.length - 1) {
//     println(input_parameters.apply(i) + ":" + input_parameters_value.apply(i))

      var param_value = input_parameters_value.apply(i);

      /**
       * If parameter value containing formate like #$#parameter_name#&#api_id#&#group_id
       * mean its value from response of that other API. 
       */
      if (param_value != null && param_value.toString().trim().startsWith("#$#")) {
        
        var tmp_value = param_value.split("#\\&#")
        
        /**
         * fetch parameter name which is name through which we find value from 
         * uper API Response parameter which is already set in tmp_param table
         */
        var tmp_param_name = tmp_value.apply(0).replace("#$#", "").trim()
        
        //fetch api id of that Response API
        var tmp_api_id = tmp_value(1).trim()
        
        
        //fetch api _group_id of that Response API
        var tmp_api_group_id = tmp_value(2).trim()

        //println("response_parameter:-" + param_value + ", tmp_value:" + tmp_value + " ,tmp_param_name:-" + tmp_param_name + " ,tmp_api_id:-" + tmp_api_id
         // + " ,tmp_api_group_id" + tmp_api_group_id)

        /*var sqlQuery = "select parameter_value from " + Configuration.paramTableName + " where api_group_id='" +
        tmp_api_group_id + "' and api_id='" + tmp_api_id + "' and parameter_name='" + tmp_param_name + "'"*/

          
        //create query accordingly to fetch parameter value from tmp_param table   
        var sqlQuery = Configuration.parameter_fetching_query.replace("param_table", Configuration.paramTableName.trim())
          .replace("#" + Configuration.api_group_id_param.trim() + "#", tmp_api_group_id.trim())
          .replace("#" + Configuration.api_id_param.trim() + "#", tmp_api_id.trim())
          .replace("#" + Configuration.parameter_name_param.trim() + "#", tmp_param_name.trim())

        TCPLogger.logger.info("sql_query:" + sqlQuery)

        try {
          //set Parameter value to hashmap
          var param_value_df = KafkaProcessing.sqlContext.sql(sqlQuery).collect();
          var param_append = new StringBuilder
          
          
          param_value_df.foreach { x => param_append.append(x.getAs[String]("parameter_value") + ",") }
          param_append.deleteCharAt(param_append.lastIndexOf(","))

          param_value = param_append.toString()
        }
        catch {
        
         /*
          * If parameter is not find in uper API Response than it push data to kafka topic of :- Retry_Topic with parameter not find issue
          */
          case x: Throwable =>
            
            TCPLogger.printStream.append(x.getMessage)
            
             var tmp_input_params_value:Map[String, String]=new HashMap;
             param_value=""
           for (i <- 0 to input_parameters.length - 1) {
              var param_value_tmp = input_parameters_value.apply(i);
              
                  if (param_value_tmp != null && param_value_tmp.toString().trim().startsWith("#$#")) {
                    param_value_tmp=""
                    tmp_input_params_value += (input_parameters.apply(i) -> param_value_tmp)
                  }
                  else {  param_value_tmp="" 
                    tmp_input_params_value += (input_parameters.apply(i) -> param_value_tmp) }
                  
           }
         
          
          
           /* var status = audiLogPublisher.successAndFailiurPublisher(tmp_input_params_value,Configuration.parameter_not_found, row, list_data_frame, list_api_id, incomingAPI)

            if (!status) {
              break
            }*/
        }

        //println("reponse from table:-" + param_value)
        /**
         * Spark sql ki response table me se value le kar aayenge or param_value me dalenge
         */
        mapStatus += (input_parameters.apply(i) -> param_value)
      } else { mapStatus += (input_parameters.apply(i) -> param_value) }

    }

    //return final Hashmap[String,String] of input body parameter and its value 
    return mapStatus;
  }

  
  
  /**
   * RestSoapBody(input_params_value:Map[String,String],api_template:String,api_type:String): 
	 * It manipulate template according to rest and soap api and set it to body of api calling.
   */
  
  def RestSoapBody(input_params_value: Map[String, String], api_template: String, api_type: String): String = {

    try {
     
      var pattern = Pattern.compile("<.+?>");
      
      //this pattern is in rest body template before and after parameter value
      var replace_case = "[<,>]"
      if (api_type.toLowerCase().equalsIgnoreCase(Configuration.soap)) {
//        pattern = Pattern.compile("$.+?$");
        pattern = Pattern.compile("@@.+?@@");
       
        //this pattern is in Soap body template before and after parameter value
         replace_case = "@@"
      }

//      TCPLogger.logger.info("input parameters:-"+input_params_value);
      
      /**
       * Here Find match cases and manipulate template with input_parameter value and set all value to template where 
       * it got matched
       */
      var matcher = pattern.matcher(api_template);
      var sb = new StringBuffer()
      TCPLogger.logger.info("api_template:-" + api_template)

      while (matcher.find()) {
          System.out.println("yes");
        var match_case = matcher.group(0)
        var match_case_value = ""
//        TCPLogger.logger.info("replace case:"+replace_case)
        
        System.out.println(match_case.replaceAll(replace_case, ""));
//        TCPLogger.logger.info("-----match case:-" + match_case+", after replace value"+match_case.replaceAll(replace_case, ""))
        
        var valu:String="";
        if (input_params_value.contains(match_case.replaceAll(replace_case, ""))) {

          match_case_value = String.valueOf(input_params_value.get(match_case.replaceAll(replace_case, "")).get.replaceAll("\"", "").replaceAll("-#-", ","))
//          TCPLogger.logger.info("after replace"+match_case_value)
          
          //yaha per replace karna he delimiter ko "," se
                  
          
          valu=Matcher.quoteReplacement(match_case_value); 
//            match_case_value.replaceAll(Pattern.quote("\\$\\$"), Matcher.quoteReplacement("")).trim()
        }
        
        matcher.appendReplacement(sb, valu.trim())
      }
      matcher.appendTail(sb);

      return sb.toString()
    } catch {
      case t: Throwable =>
        t.printStackTrace() // TODO: handle error
        TCPLogger.printStream.append(t.getMessage)
        return null;
    }
  }

}