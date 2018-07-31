/**
 * Thise package contain two classes which is use to publish data to kafka topic
 * 1)AuditLogPublisher:-This class is use to check response code and accordingly publish data to kafka Topic through
 * 	KafkaPublisher Class.
 * 2)KafkaPublisher Class:- It set connection with zookeeper and topic and having method to push data to kafka topic
 */

package org.kafka.publish

import org.streaming.kafka.KafkaProcessing
import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.streaming.kafka.KafkaProcessing
import org.apache.hadoop.mapreduce.v2.app.webapp.App
import org.apache.spark.sql.SaveMode
//import org.streaming.generic.DynamicQuery
import java.sql._
import org.streaming.rule.config.Configuration
//import com.orchastration.logger.OrchastrationLogger

import scala.collection.immutable.Map
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._
import scala.collection.JavaConversions._
import org.apache.spark.sql.DataFrame

import org.apache.spark.sql.Row

import org.apache.spark.scheduler.MapStatus
import scala.util.control.Breaks._
import scala.collection.JavaConversions._
import scala.collection.immutable.HashMap
import play.api.libs.json._
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import org.streaming.kafka.KafkaProcessing
import com.fasterxml.jackson.module.scala.JsonScalaEnumeration
import org.apache.spark.sql.types.StringType
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
import org.streaming.rule.processing.RuleProcess
import com.orchastration.logger.TCPLogger
import org.streaming.db.DBConnection

/**
 * AuditLogPublisher class is use to check Response json according to response code it will publish data to kafka topic
 * and update tmp_param table with its reponse parameter .it convert json to hashmap[String,String] and return it for futher use
 * havin 3 methods:
 * 1)successAndFailiurPublisher:-This method check response_json_code and update dataframe  with updateDataFrame method
 * 																pulish data to Notification,Retry,Audit_Log Topic according to response code.
 * 2)updateDataFrame:-that method is use to update json which is going to push in kafka topic
 * 										with parameter (ie. is_successfull,retry_no,responseCode etc)
 * 3)insertToParamTable:-This method use to convert response json parameter to Hashmap[String,String]
 */
class AuditLogPublisher {

  /**
   * successAndFailiurPublisher:-This method check response_json_code and update dataframe  with updateDataFrame method
   * pulish data to Notification,Retry,Audit_Log Topic according to response code.
   * 1)check response code and responses json if response is not correct it will publish data to failiure topic with response not correct issue
   * 2)it update response with some extra parameter befrore push data to kafak
   * 3)insert responses paramas to tmp_param table of spark sql
   */
  def successAndFailiurPublisher(input_params_value:Map[String,String],response_json_code: String, t: Row, list_data_frame: java.util.ArrayList[String], list_api_id: java.util.ArrayList[String],
    incomingAPI: DataFrame): Boolean = {
    var response_json = response_json_code
    var response_code = Configuration.invalid_http_output_response_code
    var response_json_code_update = response_json_code

    try {
      response_json = String.valueOf(response_json_code.split("#\\$#")(2))
      response_code = String.valueOf(response_json_code.split("#\\$#")(1))
      
      println("response json:-" + String.valueOf(response_json))
//      TCPLogger.logger.info("response json:-" + String.valueOf(response_json))
    } catch {
      //if http reponse is not up to mark 
      case t: Throwable =>
        t.printStackTrace() // TODO: handle error
        TCPLogger.printStream.append(t.getMessage)

        response_json_code_update = "#$#" + response_code + "#$#" + response_json_code
    }
       //reponseParamMap variable will store all response json parameter and value
        var reponseParamMap = new java.util.HashMap[String, String];

      //Convert response json to hashmap[string,string] and insert into reponseParamMap variable
      JsonModification.parse(response_json, reponseParamMap);

      var input_params_value_tmp = input_params_value ++ reponseParamMap
      
//      reponseParamMap.toMap;
      
       println("response paramas:-" + input_params_value_tmp)
      TCPLogger.logger.info("response paramas:-" + input_params_value_tmp)
    /**
     * If API called successfully
     */
       
    
    //    if (response_code.trim().equalsIgnoreCase("200")) {
    if (Configuration.success_reponse_code.contains(response_code.trim())) {
      println("when response true")

      /*//reponseParamMap variable will store all response json parameter and value 
      var reponseParamMap = new java.util.HashMap[String, String];

      //Convert response json to hashmap[string,string] and insert into reponseParamMap variable
      JsonModification.parse(response_json, reponseParamMap);

      println("response paramas:-" + reponseParamMap)*/

      //convert Row[String] to Data frame

      val rowRDD: RDD[Row] = KafkaProcessing.sqlContext.sparkContext.makeRDD(t :: Nil)

      val dataframe = KafkaProcessing.sqlContext.createDataFrame(rowRDD, t.schema)

      //update date frame add some extra parameter which will use in notification,retry and audit log streaming
      var kafka_message = updateDataFrame(dataframe, response_json_code)

      println(kafka_message)
      TCPLogger.logger.info(kafka_message)

      var api_group_id: String = String.valueOf(t.getAs[Long](Configuration.api_group_id_param))
      var api_id: String = String.valueOf(t.getAs[Long](Configuration.api_id_param))
      var tracking_message_header = t.getAs[String](Configuration.tracking_message_header)
     

      var query = Configuration.notificationProcedure.
        replace(Configuration.api_group_id_param, api_group_id)
        .replace(Configuration.api_id_param, api_id)
        .replace(Configuration.response_code_param, String.valueOf(response_code))

      //push data to Notification and Audit Log Topic    
      /*  var query=   Configuration.notificationProcedure.
          replace(Configuration.api_group_id_param, String.valueOf(t.getAs[String](Configuration.api_group_id_param)))
          .replace(Configuration.api_id_param, String.valueOf(t.getAs[String](Configuration.api_id_param)))
          .replace(Configuration.response_code_param, String.valueOf(response_code))*/

      
       
        println(query)
      TCPLogger.logger.info(query)
      var db=new DBConnection()
      try{        
      if(! Configuration.connection.isValid(1)  ||Configuration.connection.isClosed()  ){      
        
      Configuration.connection= db.createConnection(Configuration.driverName, Configuration.dbConnectionUrl);
    
      }
      }catch {
        case t: Throwable => t.printStackTrace() // TODO: handle error
        Configuration.connection= db.createConnection(Configuration.driverName, Configuration.dbConnectionUrl);
        
      };
      
      
      var output = Configuration.db.executeSqlQuery(query, Configuration.connection)
      
      for (i <- 0 to output.size() - 1) {
        
        
        println(output)
     TCPLogger.logger.info("Query Output: -"+output)
        var notification_template: String = String.valueOf(output.get(i).get(Configuration.notifiation_template_template))
        var notification_template_final = notification_template.replace("@" + Configuration.tracking_message_header, tracking_message_header)
          .replace("@" + Configuration.response_param, response_json)
          .replace("@" + Configuration.api_group_id_param, api_group_id)
          .replace("@" + Configuration.api_id_param, api_id)
          
       /*   .replace("@"+Configuration.return_url+"@", return_url)
          .replace("@"+Configuration.ban_param+"@", ban_value)
          .replace("@"+Configuration.request_id_param+"@", request_id_value)
            .replace("@"+Configuration.planId_param+"@", planId_value)*/
            if(input_params_value_tmp.contains("notificationParam")){
          var columnName=input_params_value_tmp.get("notificationParam").get.split("-#-");
          if(columnName.length>0){
             TCPLogger.logger.info("--inside collumn loop--"+columnName.apply(0))
        	  println(":"+columnName.apply(0)+":"+columnName.length+":"+columnName.size);
            var tempCoulmn =input_params_value.get(columnName.apply(0).trim()).get.split("-#-")
            for(i <- 0 to tempCoulmn.length-1){
              for(j <- 0 to columnName.length-1){
                println("--map inside notification Param--"+input_params_value)
                
                 input_params_value_tmp += (columnName.apply(j).trim() -> input_params_value.get(columnName.apply(j).trim()).get.split("-#-").apply(i))
              }
              println("--map after notification Param--"+input_params_value_tmp)
//              input_params_value_tmp.put(columnName.apply(j).trim(), input_params_value_tmp.get(columnName.apply(0).trim()).get.split("-#-").apply(i))
                 var rp:RuleProcess= new RuleProcess;
        var notification_template_final_string= rp.RestSoapBody(input_params_value_tmp, notification_template_final, "rest")
        
     /*   var notification_template_url_change= urlChange(notification_template_final_string)
        notification_template_url_change= inputNotification(input_params_value,notification_template_url_change)*/
        
        println("----------final sucess Notification template---"+notification_template_final_string)
          TCPLogger.logger.info("----------final sucess Notification template---"+notification_template_final_string)
        Configuration.kafkaPublisher.publishToKafka(Configuration.responseTopic, notification_template_final_string)
            
          }
        }
        }
            else{
                 var rp:RuleProcess= new RuleProcess;
                var notification_template_final_string= rp.RestSoapBody(input_params_value_tmp, notification_template_final, "rest")
        
     /*   var notification_template_url_change= urlChange(notification_template_final_string)
        notification_template_url_change= inputNotification(input_params_value,notification_template_url_change)*/
        
              println("----------final sucess Notification template---"+notification_template_final_string)
              TCPLogger.logger.info("----------final sucess Notification template---"+notification_template_final_string)
              Configuration.kafkaPublisher.publishToKafka(Configuration.responseTopic, notification_template_final_string)
            }
       
      }

      var audit_string = pushAuditLogIntoKafkaTopic(api_group_id, api_id, tracking_message_header, Configuration.is_sucessful_true_param_value,
        String.valueOf(response_code), Configuration.audi_log_success_name, response_json_code.replaceAll("\"", ""))

      //      Configuration.kafkaPublisher.publishToKafka(Configuration.responseTopic, kafka_message)

      Configuration.kafkaPublisher.publishToKafka(Configuration.auditLogTopic, audit_string)

      /**
       * here Remove api ID from list_api_id variable because it is called and
       * add its output json to list_data_frame variable for futhur use
       */

      list_data_frame.add(kafka_message)
      list_api_id.remove(String.valueOf(t.getAs[String](Configuration.api_id_param)))

      insertToParamTable(reponseParamMap.toMap, t.getAs[String](Configuration.api_group_id_param), t.getAs[String](Configuration.api_id_param))
      return true;
      /**
       * ager api sucess call hui to fetch their reponse parameters and insert data to param_response_table and
       * push data to notification
       */
    } else {

      /**
       * when response code is for not successfully called API (not equals to 200)
       * There is two cases
       * 1)For Permanent failiure it will push stream to Notification and Audit_Log Topic
       * 2)For some Response code like server_down(ie. 500) it will push data to Retry_Topic
       */

      println("when response false")
      TCPLogger.logger.info("when response false")
      var audit_log_name=reponseParamMap.get("restrictedOperation")+":"+reponseParamMap.get("errorName")

      //convert Row[String] to Data frame

      val rowRDD: RDD[Row] = KafkaProcessing.sqlContext.sparkContext.makeRDD(t :: Nil)

      val dataframe = KafkaProcessing.sqlContext.createDataFrame(rowRDD, t.schema)

      //update date frame add some extra parameter which will use in notification,retry and audit log streaming
      var kafka_message = updateDataFrame(dataframe, response_json_code_update)

      println(kafka_message)
      TCPLogger.logger.info(kafka_message)
      /**
       * here Remove api ID from list_api_id variable because it is called and
       * add its output json to list_data_frame variable for futhur use
       */

      list_data_frame.add(kafka_message)

      list_api_id.remove(String.valueOf(t.getAs[String](Configuration.api_id_param)))

      //                Configuration.kafkaPublisher.publishToKafka(Configuration.retryTopic, kafka_message)

      println("remaning list count size:-" + list_api_id.size())

      /**
       * In failiure case we fetch all upper api which is sucess full and those api which is not called yet
       * and create data frame with update its column according to failiure startus
       */
      for (i <- 0 to list_api_id.size() - 1) {
        var tmp_df = incomingAPI.filter(col(Configuration.api_id_param).equalTo(list_api_id(i)))
        println("api Name:- "+tmp_df.first().getAs[String]("api_name"))
        var tmp_kafka_message = updateDataFrame(tmp_df, Configuration.uper_api_failiure)
        list_data_frame.add(tmp_kafka_message)
      }
     

      /**
       * that complete data frame publish to kafka.
       * If permanent failiure it will push to Audit_Log kafka topic .
       * else publish to Retry Topic
       */

      var api_group_id: String = String.valueOf(t.getAs[Long](Configuration.api_group_id_param))
      var api_id: String = String.valueOf(t.getAs[Long](Configuration.api_id_param))
      var tracking_message_header = t.getAs[String](Configuration.tracking_message_header)

      //      if (response_code.trim().equalsIgnoreCase("401") || response_code.trim().equalsIgnoreCase("0")) {        
      if (Configuration.retry_reponse_code.contains(response_code.trim())) {
        println("============Inside  Retry Condition ===============")
        TCPLogger.logger.info("============Inside  Retry Condition ===============")
        Configuration.kafkaPublisher.publishToKafka(Configuration.retryTopic, list_data_frame.toString())

        var audit_string = pushAuditLogIntoKafkaTopic(api_group_id, api_id, tracking_message_header, Configuration.is_sucessful_fail_param_value,
          String.valueOf(response_code),audit_log_name /*Configuration.audi_log_retry_name*/, list_data_frame.toString().replaceAll("\"", ""))

        Configuration.kafkaPublisher.publishToKafka(Configuration.auditLogTopic, audit_string)
      } //         if(Configuration.failiure_reponse_code.contains(response_code.trim())){
      else {

        println("============Inside  permanent failiure method==============")
        TCPLogger.logger.info("============Inside  permanent failiure method==============")

        var query = Configuration.notificationProcedure.
          replace(Configuration.api_group_id_param, api_group_id)
          .replace(Configuration.api_id_param, api_id)
          .replace(Configuration.response_code_param, String.valueOf(response_code))

        println(query)
        TCPLogger.logger.info(query)

        var output = Configuration.db.executeSqlQuery(query, Configuration.connection)
        for (i <- 0 to output.size() - 1) {
          println(output)
          var notification_template: String = String.valueOf(output.get(i).get(Configuration.notifiation_template_template))
          var notification_template_final = notification_template.replace("@" + Configuration.tracking_message_header, tracking_message_header)
            .replace("@" + Configuration.response_param, response_json)
            .replace("@" + Configuration.api_group_id_param, api_group_id)
            .replace("@" + Configuration.api_id_param, api_id)
            /*.replace("@"+Configuration.return_url+"@", return_url)
            .replace("@"+Configuration.ban_param+"@", ban_value)
          .replace("@"+Configuration.request_id_param+"@", request_id_value)
          .replace("@"+Configuration.planId_param+"@", planId_value)*/
            
            
             if(input_params_value_tmp.contains("notificationParam")){
          var columnName=input_params_value_tmp.get("notificationParam").get.split("-#-");
          
          
          if(columnName.length>0){
        	  
            var tempCoulmn =input_params_value_tmp.get(columnName.apply(0).trim()).get.split("-#-")
              println("tempColumn length :"+tempCoulmn.length);
            println("columnName length :"+columnName.length);
            for(i <- 0 to tempCoulmn.length-1){
              for(j <- 0 to columnName.length-1){
                println("i:"+i+" ,j:"+j+columnName.apply(j).trim());
                  input_params_value_tmp += (columnName.apply(j).trim() -> input_params_value.get(columnName.apply(j).trim()).get.split("-#-").apply(i))
              }
//              input_params_value_tmp.put(columnName.apply(j).trim(), input_params_value_tmp.get(columnName.apply(0).trim()).get.split("-#-").apply(i))
               var rp:RuleProcess= new RuleProcess;
        var notification_template_final_string= rp.RestSoapBody(input_params_value_tmp, notification_template_final, "rest")
        
//        var notification_template_url_change= urlChange(notification_template_final_string)
        
//       notification_template_url_change= inputNotification(input_params_value,notification_template_url_change)
        println("----------final sucess Notification template---"+notification_template_final_string)
        TCPLogger.logger.info("----------final sucess Notification template---"+notification_template_final_string)
        
        
          Configuration.kafkaPublisher.publishToKafka(Configuration.responseTopic, notification_template_final_string)
            }
          }
        }
        
             else{
                var rp:RuleProcess= new RuleProcess;
              var notification_template_final_string= rp.RestSoapBody(input_params_value_tmp, notification_template_final, "rest")
        
//        var notification_template_url_change= urlChange(notification_template_final_string)
        
//       notification_template_url_change= inputNotification(input_params_value,notification_template_url_change)
        println("----------final sucess Notification template---"+notification_template_final_string)
        TCPLogger.logger.info("----------final sucess Notification template---"+notification_template_final_string)
        
        
          Configuration.kafkaPublisher.publishToKafka(Configuration.responseTopic, notification_template_final_string)
             }
         
        }

        /**
         * yaha apan ko success api ke basis per uska notification json DB se lana he than convert that json to
         * accordingly and push it to notification string
         */
        var audit_string = pushAuditLogIntoKafkaTopic(api_group_id, api_id, tracking_message_header, Configuration.is_sucessful_fail_param_value,
          String.valueOf(response_code),audit_log_name/* Configuration.audi_log_failiure_name*/, response_json_code.replaceAll("\"", ""))

        //        	Configuration.kafkaPublisher.publishToKafka(Configuration.auditLogTopic, list_data_frame.toString())
        Configuration.kafkaPublisher.publishToKafka(Configuration.auditLogTopic, audit_string)
      }

      list_api_id.clear();

      return false;

    }

  }

  def pushAuditLogIntoKafkaTopic(api_group_id: String, api_id: String, tracking_message_header: String, is_successful: String, response_code: String, name: String, response: String): String = {

    try {

      var list = new java.util.ArrayList[java.util.HashMap[String, Object]]()

      var logmap = new java.util.HashMap[String, Object]

      logmap.put(Configuration.tracking_message_header, tracking_message_header);
      logmap.put(Configuration.api_group_id_param, api_group_id);
      logmap.put(Configuration.api_id_param, api_id);
      logmap.put(Configuration.is_sucessful_param, is_successful);
      logmap.put(Configuration.response_code_param, response_code);
      logmap.put(Configuration.audit_log_state_id_param, "1");
      logmap.put(Configuration.audit_log_name, name);
      logmap.put(Configuration.response_param, response.replaceAll("\"", ""));

      list.add(logmap)
      /*
     		var kafkapublisher = new KafkaPublisher().publishToAuditLogKafka(Configuration.auditlogTopicName, new Gson().toJson(list));
			*/
      return new Gson().toJson(list);

    } catch {
      case t: Throwable =>
        t.printStackTrace()
        TCPLogger.printStream.append(t.getMessage)
        return null
    }

  }

  /**
   * updateDataFrame method is use to update json with response json which is going to push in kafka topic
   * It add some extra parameter to dataframe (ie. is_successfull,retry_no,retry_time,responseCode etc)
   * as according to response code.
   */

  def updateDataFrame(dataFrame: DataFrame, response_json_code: String): String = {
    println("in update data fram method :-" + response_json_code)
    var response_json = response_json_code.split("\\#\\$\\#")(2)
    var response_code = response_json_code.split("\\#\\$\\#")(1)

    var status: String = "true"

    if (!Configuration.success_reponse_code.contains(response_code.trim())) {
      //    if (!response_code.equalsIgnoreCase("200")) {
      status = "false"
    }

    val response: String => String = _ + response_json
    val responseUDF = udf(response)

    val responseCode: String => String = _ + response_code
    val responseCodeUDF = udf(responseCode)

    val is_executed: String => String = _ + status
    val executesUDF = udf(is_executed)

    val retry_time: String => String = _ + String.valueOf(new Date().getTime)
    val retryUDF = udf(retry_time)

    /*val retry_no:  Long => Long = _ +0 
    
    val retryNoUDF = udf(retry_no)*/

    /**
     * updating data frame with given column and it's value set above using udf method of
     * org.apache.spark.sql.functions.udf library
     */

   /* println("================")
    println("Configuration.retry_no_param:-" + Configuration.retry_no_param)
    println("Configuration.retry_time_param:-" + Configuration.retry_time_param)
    println("================")*/

    var updateDataFrame = dataFrame.withColumn(Configuration.response_param, responseUDF(new Column(Configuration.tmp_variable)))
      .withColumn(Configuration.is_sucessful_param, executesUDF(new Column(Configuration.tmp_variable)))
      .withColumn(Configuration.retry_time_param, retryUDF(new Column(Configuration.tmp_variable)))
      .withColumn(Configuration.response_code_param, responseCodeUDF(new Column(Configuration.tmp_variable)))
    //  .withColumn(Configuration.retry_no_param, retryNoUDF(new Column(Configuration.tmp_variable)))

    return updateDataFrame.toJSON.first

  }

  /**
   * insertToParamTable method is use to set response of API to hashmap with key and its value
   * and return list of parameter value hashmap so it will use furtur .
   * it insert all parameter and value to tmp_param table of spark sql
   *
   */
  def insertToParamTable(map: Map[String, String], api_group_id: Object, api_id: Object) = {
    var listMap = new java.util.ArrayList[String]
    map.foreach(x => {

      var mapStatus: Map[String, String] = new HashMap[String, String]();

      //set Static parameter to hashmap
      mapStatus += (Configuration.api_group_id_param -> String.valueOf(api_group_id))
      mapStatus += (Configuration.api_id_param -> String.valueOf(api_id))
      mapStatus += (Configuration.parameter_name_param -> x._1)
      mapStatus += (Configuration.parameter_value_param -> x._2)
      var jsonString: String = Json.toJson(mapStatus).toString()

      listMap.add(jsonString)
    })

    //convert list of hashmap to Data frame through javaRDD
    var anotherPeopleRDD: JavaRDD[String] = new JavaSparkContext(KafkaProcessing.sc).parallelize(listMap)
    var paramsDataFrame = KafkaProcessing.sqlContext.read.json(anotherPeopleRDD)

    /**
     * Insert data to tmp_param table throgh dataframe
     */
    try {
      /**
       * if tmp_param table is already present it will union all previous data with current data and
       * insert it again to param table
       */

      var data = KafkaProcessing.sqlContext.sql("select * from " + Configuration.paramTableName);
      println("show all data frame:======")
      data.unionAll(paramsDataFrame).show()
      data.unionAll(paramsDataFrame).registerTempTable(Configuration.paramTableName)
      println("insert sucessfully")
      TCPLogger.logger.info("insert sucessfully"+data.show())

    } catch {

      /**
       * if param table is not present it create param table with current data
       */
      case t: Throwable =>
        t.getMessage
        paramsDataFrame.registerTempTable(Configuration.paramTableName)
    }

    println("overall response parameter====================")
    TCPLogger.logger.info(KafkaProcessing.sqlContext.sql("select * from " + Configuration.paramTableName).show())

  }
  
  
  
  
   def urlChange(api_template: String): String = {

    try {
      
     
         
         
     
      var pattern = Pattern.compile("@@.+?@@");
      
      //this pattern is in rest body template before and after parameter value
      var replace_case = "@@"
     

      
      /**
       * Here Find match cases and manipulate template with input_parameter value and set all value to template where 
       * it got matched
       */
      var matcher = pattern.matcher(api_template);
      var sb = new StringBuffer()
      println("api_template:-" + api_template)
      TCPLogger.logger.info("api_template:-" + api_template)

      while (matcher.find()) {
        var match_case = matcher.group(0)
        var match_case_value = ""
//        println("match case:-" + match_case)
        var valu:String="";
        
        
         var sqlQuery ="select parameter_value from "+Configuration.paramTableName.trim() +" where parameter_name='"+match_case.replaceAll(replace_case, "")+"'"
         try{
         
         var param_value_df = KafkaProcessing.sqlContext.sql(sqlQuery).collect();
          var param_append = new StringBuilder
          param_value_df.foreach { x => param_append.append(x.getAs[String]("parameter_value") + ",") }
          param_append.deleteCharAt(param_append.lastIndexOf(","))

          match_case_value = param_append.toString()         
         }
         catch {
      case t: Throwable =>
       println( t.getMessage);
       TCPLogger.printStream.append(t.getMessage)
        
    }
//          println(match_case_value)
          valu=Matcher.quoteReplacement(match_case_value); 
//            match_case_value.replaceAll(Pattern.quote("\\$\\$"), Matcher.quoteReplacement("")).trim()
      
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
   
   
   
   def inputNotification(input_params_value: Map[String, String], api_template: String): String = {

    try {
     
      var pattern = Pattern.compile("@#@#.+?@#@#");
      
      //this pattern is in rest body template before and after parameter value
      var replace_case = "@#@#"
      

      println("input parameters:-"+input_params_value);
      TCPLogger.logger.info("input parameters:-"+input_params_value);
      
      /**
       * Here Find match cases and manipulate template with input_parameter value and set all value to template where 
       * it got matched
       */
      var matcher = pattern.matcher(api_template);
      var sb = new StringBuffer()
      println("api_template:-" + api_template)
      TCPLogger.logger.info("input parameters:-"+"api_template:-" + api_template);
      while (matcher.find()) {
          System.out.println("yes");
        var match_case = matcher.group(0)
        var match_case_value = ""
//        println("replace case:"+replace_case)
        
//        System.out.println(match_case.replaceAll(replace_case, ""));
        println("-----match case:-" + match_case+", after replace value"+match_case.replaceAll(replace_case, ""))
//        TCPLogger.logger.info("-----match case:-" + match_case+", after replace value"+match_case.replaceAll(replace_case, ""))
        
        var valu:String="";
        if (input_params_value.contains(match_case.replaceAll(replace_case, ""))) {

          match_case_value = String.valueOf(input_params_value.get(match_case.replaceAll(replace_case, "")).get)
          println("after replace"+match_case_value)
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