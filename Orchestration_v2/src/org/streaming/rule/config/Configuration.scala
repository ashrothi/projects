/**
 * This package is use to contain Configuration Class which is  use to set all configuration from Sample.config from its client
 * directory
 */
package org.streaming.rule.config

import com.typesafe.config.ConfigFactory
import java.io.File
import org.kafka.publish.KafkaPublisher
import org.streaming.db.DBConnection
import java.sql.Connection
//import com.orchastration.logger.OrchastrationLoggerHourly
import com.orchastration.logger.TCPLogger
/**
 * Object is used to make use of config file and change it dynamically.
 */
object Configuration {
  /**
   * Load the config file provided its location
   */
  val config = ConfigFactory.load(ConfigFactory.parseFile(new File(System.getenv("Orchastration_Engine") + "/template/sample.conf")))

  var tempTable: String = config.getString("org.streaming.temporary.table").toString() //temparory table of spark sql

  var appName: String = config.getString("org.streaming.app.name").toString() //app name of orchestartion Streaming

  var appMaster: String = config.getString("org.streaming.app.master").toString() //master name of orchestartion Streaming

  //  var streamingMaster: String = config.getString("org.streaming.app.master").toString()

  var second: String = config.getString("org.streaming.second").toString() //set timer in second for creating new thread

  var zkpConnection: String = config.getString("org.zookeeper.connection.url").toString() //zookeeper connection url (ie. localhost:2181)

  var brokerList: String = config.getString("org.kafka.metadata.brokerlist").toString() //kafka broker connection url (ie. localhost:9092)

  var notificationTopic: String = config.getString("org.kafka.request.topic").toString() //kafka Request_Topic where input json come from API 

  //Notification Topic where we publish json for success or permanet Failiure
  var responseTopic: String = config.getString("org.kafka.response.topic").toString()

  //Audit_Log Topic where we publish json for success or permanet Failiure for Audit Log
  var auditLogTopic: String = config.getString("org.kafka.audit.log.topic").toString()

  //Retry_Topic for Retrying Stream
  var retryTopic: String = config.getString("org.kafka.retry.topic").toString()

  var consumerGroup: String = config.getString("org.kafka.consumer.group").toString() //Consumer group name for subsrcibe Kafka Topic 

  //Parameter table name of spark sql where we store all response parameter as per api_id and api_group_id 
  var paramTableName: String = config.getString("org.streaming.parameter.table.name").toString()

  //parameter table column name
  var paramTableColumn: String = config.getString("org.streaming.parameter.table.column").toString()

  //parameter table create query
  var paramTableCreateQuery: String = config.getString("org.streaming.parameter.table.create.query").toString()

  //corrupt json parameter name(_corrupt_record) when json is corrupted
  var corruptJsonParams = config.getString("org.streaming.corruptJson.parameter").toString().split(",")

  /**
   * query configuration
   */

  //query for fetching distinct api_group_id from temparory table
  var distinct_api_query: String = config.getString("org.query.distinct.api").toString()

  //corrupt json query to fetch usefull data from corrupt_json
  var corrupt_json_query: String = config.getString("org.query.corrupt_json_query").toString()

  //query to fetch all api of same api_group_id according to its api_sequence_id
  var fetchingAPI_query: String = config.getString("org.query.fetchingAPI_query").toString()

  //query to fetch all parameter according to api_group_id , api_id and parameter_name
  var parameter_fetching_query: String = config.getString("org.query.parameter_fetching_query").toString()

  /**
   * Static parameter name
   */
  var corrupt_record_param = config.getString("org.static_parameter.corrupt_record").toString() //for _corrupt_record

  var is_sucessful_param = config.getString("org.static_parameter.is_sucessful_param_name").toString() // is_successfull parameter

  var response_code_param = config.getString("org.static_parameter.response_code_param_name").toString() //response_code parameter
  var response_param = config.getString("org.static_parameter.response_param_name").toString() // reponse parameter
  var api_group_id_param = config.getString("org.static_parameter.api_group_id").toString() // api_group_id parameter 
  var retry_time_param = config.getString("org.static_parameter.retry_time_param_name").toString() //retry_time parameter
  var retry_no_param = config.getString("org.static_parameter.retry_no_param_name").toString() //retry_no parameter
  var api_id_param = config.getString("org.static_parameter.api_id").toString() //api_id parameter
  var api_host_address_param = config.getString("org.static_parameter.api_host_address").toString() //api_host_address parameter
  var api_url_param = config.getString("org.static_parameter.api_url").toString() //api_url parameter
  var input_parameter_is_header_param = config.getString("org.static_parameter.input_parameter_is_header").toString() //input_parameter_is_header
  var api_template_param = config.getString("org.static_parameter.api_template").toString() //api_template parameter
  var api_api_type_param = config.getString("org.static_parameter.api_api_type").toString() //api_api_type parameter
  var api_method_type_param = config.getString("org.static_parameter.api_method_type").toString() //api_api_method_type parameter
  var input_parameters_name_param = config.getString("org.static_parameter.input_parameters_name").toString() //input_parameters_name 
  var input_parameters_value_param = config.getString("org.static_parameter.input_parameters_value").toString() //input_parameters_value parameter
  var parameter_name_param = config.getString("org.static_parameter.parameter_name").toString() //parameter_name 
  var parameter_value_param = config.getString("org.static_parameter.parameter_value").toString() //parameter_value
   var soap = config.getString("org.static_parameter.soap").toString() //soap api
   var rest = config.getString("org.static_parameter.rest").toString() //rest api
   
   var success_reponse_code=config.getString("org.static_parameter.success_reponse_code").split(",")
   var failiure_reponse_code=config.getString("org.static_parameter.failiure_reponse_code").split(",")
    var retry_reponse_code=config.getString("org.static_parameter.retry_reponse_code").split(",")

   var tracking_message_header=config.getString("org.static_parameter.tracking_message_header").toString() 
   var return_url=config.getString("org.static_parameter.return_url").toString()
   var ban_param=config.getString("org.static_parameter.ban_param").toString()
   var request_id_param=config.getString("org.static_parameter.request_id_param").toString()
   var  planId_param=config.getString("org.static_parameter.planId_param").toString()
   var notifiation_template_template=config.getString("org.static_parameter.notifiation_template_template").toString() 
   
   var tmp_variable = config.getString("org.static_parameter.tmp_variable").toString() //rest api
   
   var errorCode = config.getString("org.static_parameter.errorCode").toString() //error Code
   
   
    /**
     * Static value of parameters
     */

  //Response code for corrupt json
  var corrupt_json_response_code = config.getString("org.static_parameter.corrupt_json_response_code").toString()

  //Reponse code for invalid HTTP response
  var invalid_http_output_response_code = config.getString("org.static_parameter.invalid_http_output_response_code").toString()

  //when API is failed .is_sucessful_fail_param_value bit is set to false
  var is_sucessful_fail_param_value = config.getString("org.static_parameter.is_sucessful_fail_param_value").toString()

  //when API is success.is_sucessful_true_param_value bit is set to true
  var is_sucessful_true_param_value = config.getString("org.static_parameter.is_sucessful_true_param_value").toString()

  /**
   * Static Response issue occure during failiure of orchestrataion laye
   */

  //if parameter is not found in upper api 
  var parameter_not_found = config.getString("org.issues.parameter_not_found").toString()

  //if upper sequence api is failed
  var uper_api_failiure = config.getString("org.issues.uper_api_failiure").toString()

  var dbConnectionUrl:String = config.getString("org.streaming.connection.url").toString()
  
  var driverName:String=config.getString("org.streaming.driver.name").toString()
  
  var notificationProcedure:String = config.getString("org.streaming.procedure.notification_procedure").toString()
  
  
  /**
   * Audit Log Parameter
   */
  
   var audi_log_success_name = config.getString("org.static_parameter.audi_log_success_name").toString() //api_template parameter
  var audi_log_failiure_name = config.getString("org.static_parameter.audi_log_failiure_name").toString() //api_api_type parameter
  var audi_log_retry_name = config.getString("org.static_parameter.audi_log_retry_name").toString() //input_parameters_name 
 var  audit_log_state_id_param = config.getString("org.static_parameter.audit_log_state_id_param").toString() //input_parameters_name 
 
 var audit_log_name=config.getString("org.static_parameter.audit_log_name").toString() //input_parameters_name
  /**
   * Invoke instance of kafakPublisher to publish messages to Kafka Topic
   */
  var kafkaPublisher = new KafkaPublisher()
  kafkaPublisher.setProperties()
  
  var db=new DBConnection()
  var connection:Connection=db.createConnection(Configuration.driverName, Configuration.dbConnectionUrl)

  TCPLogger.logger.info(tempTable + "====" + zkpConnection + "====" + brokerList + "====" + notificationTopic + "====" + responseTopic + "====" + retryTopic + "====" + consumerGroup)

}
