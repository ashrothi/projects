/**
 * This package contain the Service class of  GlobeTouch Application
 */
package org.gmonstar.notification.services;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.gmonstar.notification.constant.ProcessParameter;
import org.gmonstar.notification.genericService.GenericService;
import org.gmonstar.notification.http.client.OrchestrationHttpURLCalling;
import org.gmonstar.notification.response.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/ApiConfiguration.properties")
public class NotificationService {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	Environment environment;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private GenericService genericService;
	@Autowired
	private OrchestrationHttpURLCalling httpUrlCalling;
	@Autowired
	private ProcessParameter processParameter;
	Logger logger = Logger.getLogger(NotificationService.class);
	private static final String ORDER_EXPIRE_URL = "/<ban>/event/OrderExpired";

	/**
	 * Method to send email parameters to kafka queue in json format so that
	 * streaming layer will fetch the mail notification data from kafka and send
	 * mail accordingly
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * @param smtp_host
	 *            -host of mail server
	 * @param smtp_port
	 *            -port of mail server
	 * @param smtp_username
	 *            username to access mail server
	 * @param smtp_password
	 *            -password of user
	 * @param subject
	 *            -subject of mail
	 * @param body
	 *            -content of mail body
	 * @param from
	 *            -mail from user
	 * @param to
	 *            -mail to users
	 * @param cc
	 *            -cc users of mail
	 * @param bcc
	 *            -bcc users of mail
	 * @param socket_port
	 *            -socket port of mail server
	 * @param socket_class
	 *            -socket class of mail server
	 * @param smtp_auth
	 *            -smtp_auth permision of mail server to send mail
	 * @param email_title
	 *            -title of email_id you want to send mail from
	 * @param request
	 *            -HttpServletRequest request to get requested machines parameter
	 *            like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	public Message emailNotification(String end_node_name, String smtp_host, String smtp_port, String smtp_username,
			String smtp_password, String subject, String body, String from, String to, String cc, String bcc,
			String email_title, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();

			formattedData.put("end_node_name", end_node_name);
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("notification_type", "email");
			formattedData.put("smtp_host", smtp_host);
			formattedData.put("smtp_port", smtp_port);
			formattedData.put("smtp_username", smtp_username);
			formattedData.put("smtp_password", smtp_password);
			formattedData.put("subject", subject);
			formattedData.put("body", body);
			formattedData.put("from", from);
			formattedData.put("to", to);
			formattedData.put("cc", cc);
			formattedData.put("bcc", bcc);
			formattedData.put("socket_port", environment.getProperty("mail.socket.port"));
			formattedData.put("socket_class", environment.getProperty("mail.socket.class"));
			formattedData.put("smtp_auth", environment.getProperty("mail.smtp.auth"));
			formattedData.put("email_title", email_title);
			formattedData.put("notification_id", notification_id);
			/**
			 * Defining Builders for Input parameters and value
			 */
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|smtp_host|#@|smtp_port|#@|smtp_username|#@|smtp_password|#@|subject|#@|body|#@|from|#@|to|#@|cc|#@|bcc|#@|socket_port|#@|socket_class|#@|smtp_auth|#@|email_title|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + end_node_name + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + formattedData.get("notification_type") + "|#@|"
					+ smtp_host + "|#@|" + smtp_port + "|#@|" + smtp_username + "|#@|" + smtp_password + "|#@|"
					+ subject + "|#@|" + body + "|#@|" + from + "|#@|" + to + "|#@|" + cc + "|#@|" + bcc
					+ formattedData.get("socket_port") + "|#@|" + "|#@|" + formattedData.get("socket_class") + "|#@|"
					+ formattedData.get("smtp_auth") + "|#@|" + email_title + "|#@|" + "NotificationController" + "|#@|"
					+ "mailNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {

				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of Mail API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/*
			 * Pushing Notification in kafka
			 */
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			/*
			 * If its true it will send success response to user otherwise failure response
			 * will be send
			 */
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {
					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}

	}

	/**
	 * To Push the notification to kafka queue with the configuration coming from
	 * database
	 * 
	 * @param formattedData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private Boolean executeNotificationtoKafka(List<Map<String, Object>> formattedData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			/**
			 * Transforming coming data in json string format
			 */
			String commandNotificationJson = new Gson().toJson(formattedData);
			/**
			 * To check if string is not null
			 */
			if (commandNotificationJson != null) {
				/**
				 * To get kafka config from database
				 */
				Map<String, String> map = new LinkedHashMap<>();
				map.put("kafka_type", "publisher");
				/**
				 * Calling generic Procedure to get kafka config
				 */
				Message message = genericProcess.GenericProcedureCalling("2", map, null, request, response);
				/*
				 * To transform response coming from database
				 */
				List<Map<String, Object>> kafkaConfigData = (List<Map<String, Object>>) message.getObject();
				if (message.isValid() && kafkaConfigData.size() > 0) {
					Properties kafkaProperties = new Properties();
					/**
					 * Defining kakfa config as per coming from database
					 */
					kafkaProperties.put("zookeeper.connect", kafkaConfigData.get(0).get("zookeeper_ip") + ":"
							+ kafkaConfigData.get(0).get("zookeeper_port"));

					kafkaProperties.put("metadata.broker.list",
							kafkaConfigData.get(0).get("kafka_ip") + ":" + kafkaConfigData.get(0).get("kafka_port"));
					kafkaProperties.put("serializer.class", "kafka.serializer.StringEncoder");

					kafkaProperties.put("request.required.acks", "1");
					/**
					 * Defining Kafka Producer Config
					 */
					ProducerConfig producerConfig = new ProducerConfig(kafkaProperties);
					/**
					 * KeyedMessage message with data to publish in kafka
					 */
					KeyedMessage<String, String> messageToPublish = new KeyedMessage<String, String>(
							kafkaConfigData.get(0).get("topic_name").toString(), "ip", commandNotificationJson);
					logger.info("data after: \n" + messageToPublish);
					/*
					 * Send the data on kafka.
					 */
					Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
					/**
					 * To Send Data to Kafka
					 */

					kafkaProducer.send(messageToPublish);

					/*
					 * Close the kafka producer connection.
					 */
					kafkaProducer.close();
					/*
					 * If data published successfully it will send true in return
					 */
					return true;
				} else {
					/*
					 * If data not published successfully it will send false in return
					 */
					return false;
				}

			} else {
				/*
				 * If data is null , it will send false in return
				 */
				return false;
			}

		} catch (Exception e) {
			/**
			 * To get exception if it comes
			 */
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to call sms notification with all its server and end user details to
	 * send sms notification
	 * 
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * @param notification_msg
	 *            -Content of the sms to be send to client
	 * @param mobile_nos
	 *            -Mobile nos to whom all messages has to be send
	 * @param smse_username
	 *            SMS server username
	 * @param smse_password
	 *            - SMS server password
	 * @param smse_ip
	 *            -SMS serers ip address
	 * @param smse_port
	 *            -SMS server port no
	 * @param from
	 *            -SMS comming From
	 * @param request
	 *            -HttpServletRequest request to get requested machines parameter
	 *            like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	public Message smsNotification(String end_node_name, String notification_msg, String mobile_nos,
			String smse_username, String smse_password, String smse_ip, String smse_port, String from,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();

			formattedData.put("end_node_name", end_node_name);

			formattedData.put("notification_msg", notification_msg);
			formattedData.put("notification_type", "sms");
			formattedData.put("end_node_name", end_node_name);
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("mobile_nos", mobile_nos);
			formattedData.put("smse_username", smse_username);
			formattedData.put("smse_password", smse_password);
			formattedData.put("smse_ip", smse_ip);
			formattedData.put("smse_port", smse_port);
			formattedData.put("from", from);
			formattedData.put("notification_id", notification_id);
			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/**
			 * Defining Builders for Input parameters and value
			 */
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_msg|#@| notificationtype|#@|mobile_nos|#@|smse_username|#@|smse_password|#@|smse_ip|#@|smse_port|#@|from|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(
					request.getHeader("token") + "|#@|" + end_node_name + "|#@|" + formattedData.get("end_node_ip")
							+ "|#@|" + notification_msg + "|#@|" + formattedData.get("notification_type") + "|#@|"
							+ mobile_nos + "|#@|" + smse_username + "|#@|" + smse_password + "|#@|" + smse_ip + "|#@|"
							+ smse_port + "|#@|" + from + "|#@|" + "NotificationController" + "|#@|" + "smsNotification"
							+ "|#@|" + request.getRemoteHost() + "|#@|" + URI);
			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {
				/**
				 * Inserting Audit Log for Inititiation of SMS API Calling
				 */
				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of SMS API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			/*
			 * Pushing Notification in kafka
			 */
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			/*
			 * If its true it will send success response to user otherwise failure response
			 * will be send
			 */
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {
					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}
	}

	/**
	 * Method for webhook Notification to call api or to send notification in
	 * database with all its detail of end user API as Well as Database credentials
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * @param api_url
	 *            -API url which has to be called
	 * @param body_parameter
	 *            -Body Parameter of API
	 * @param header_parameter
	 *            -Header Parameter (payload) of API
	 * @param api_type
	 *            -Requires api type (SOAP/REST)
	 * @param method_type
	 *            -Requires api type (POST, GET, OPTIONS, DELETE)
	 * @param db_url
	 *            -Requires database url with port ,username and password
	 * @param db_driver
	 *            -Required driver of database to establish connesction with it
	 * @param table_name
	 *            -Table name where data has to be insert
	 * @param table_parameter
	 *            -Column names of table of the give database
	 * @param request
	 *            -HttpServletRequest request to get requested machines parameter
	 *            like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	public Message webHookNotification(String end_node_name, String api_url, String body_parameter,
			String header_parameter, String api_type, String method_type, String db_url, String db_type,
			String table_name, String table_parameter, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();
			if (api_type.equalsIgnoreCase("SOAP")) {
				formattedData.put("end_node_name", end_node_name);
				formattedData.put("end_node_ip", request.getRemoteHost());
				formattedData.put("notification_type", "webhook");
				formattedData.put("api_url", api_url);
				formattedData.put("body_parameter", body_parameter.replaceAll("\",\"", "#\\$#").replaceAll("\":\"", ":")
						.replaceAll("\\{\"", "").replaceAll("\"\\}", ""));
				formattedData.put("header_parameter", header_parameter.replaceAll("\",\"", "#\\$#")
						.replaceAll("\":\"", ":").replaceAll("\\{\"", "").replaceAll("\"\\}", ""));
				formattedData.put("api_type", api_type);
				formattedData.put("method_type", method_type);
				formattedData.put("db_url", db_url);
				formattedData.put("db_driver", environment.getProperty(db_type));
				formattedData.put("table_name", table_name);
				formattedData.put("table_parameter", table_parameter);
				formattedData.put("notification_id", notification_id);
			} else {
				formattedData.put("end_node_name", end_node_name);
				formattedData.put("end_node_ip", request.getRemoteHost());
				formattedData.put("notification_type", "webhook");
				formattedData.put("api_url", api_url);
				formattedData.put("body_parameter", body_parameter.replaceAll("\":\"", "=").replaceAll("\",\"", "&")
						.replaceAll("\\}", "").replaceAll("\\{", "").replaceAll("\"", ""));
				formattedData.put("header_parameter",
						header_parameter.replaceAll("\"", "").replaceAll("\\{", "").replaceAll("\\}", ""));
				formattedData.put("api_type", api_type);
				formattedData.put("method_type", method_type);
				formattedData.put("db_url", db_url);
				formattedData.put("db_driver", environment.getProperty(db_type));
				formattedData.put("table_name", table_name);
				formattedData.put("table_parameter", table_parameter);
				formattedData.put("notification_id", notification_id);
			}

			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/**
			 * Defining Builders for Input parameters and value
			 */
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type|#@|method_type|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + end_node_name + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + formattedData.get("notification_type") + "|#@|"
					+ api_url + "|#@|" + body_parameter + "|#@|" + header_parameter + "|#@|" + api_type + "|#@|"
					+ method_type + "|#@|" + db_url + "|#@|" + formattedData.get("db_driver") + "|#@|" + table_name
					+ "|#@|" + table_parameter + "|#@|" + "NotificationController" + "|#@|" + "webHookNotification"
					+ "|#@|" + request.getRemoteHost() + "|#@|" + URI);

			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {

				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of Webhook API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			/*
			 * Pushing Notification in kafka
			 */
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			/*
			 * If its true it will send success response to user otherwise failure response
			 * will be send
			 */
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}
			/*
			 * Set the response data for api calling..
			 */

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}
	}

	/**
	 * Method to send email parameters to kafka queue in json format so that
	 * streaming layer will fetch the mail notification data from kafka and send
	 * mail accordingly
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * 
	 * @param subject
	 *            -subject of mail
	 * @param body
	 *            -content of mail body
	 * 
	 * @param to
	 *            -mail to users
	 * @param cc
	 *            -cc users of mail
	 * @param bcc
	 *            -bcc users of mail
	 * 
	 * @param request
	 *            -HttpServletRequest request to get requested machines parameter
	 *            like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	public Message emailAutomateNotification(String subject, String body, String to, String cc, String bcc,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();

			formattedData.put("end_node_name", environment.getProperty(request.getRemoteHost()));
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("notification_type", "email");
			formattedData.put("smtp_host", environment.getProperty("mail.smtp.detail"));
			formattedData.put("smtp_port", environment.getProperty("mail.smtp.port"));
			formattedData.put("smtp_username", environment.getProperty("mail.smtp.username"));
			formattedData.put("smtp_password", environment.getProperty("mail.smtp.password"));
			formattedData.put("subject", subject);
			formattedData.put("body", body);
			formattedData.put("from", environment.getProperty("mail.smtp.from"));
			formattedData.put("to", to);
			formattedData.put("cc", cc);
			formattedData.put("bcc", bcc);
			formattedData.put("socket_port", environment.getProperty("mail.socket.port"));
			formattedData.put("socket_class", environment.getProperty("mail.socket.class"));
			formattedData.put("smtp_auth", environment.getProperty("mail.smtp.auth"));
			formattedData.put("email_title", environment.getProperty("mail.smtp.email.title"));
			formattedData.put("notification_id", notification_id);

			/**
			 * Defining Builders for Input parameters and value
			 */
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|smtp_host|#@|smtp_port|#@|smtp_username|#@|smtp_password|#@|subject|#@|body|#@|from|#@|to|#@|cc|#@|bcc|#@|socket_port|#@|socket_class|#@|smtp_auth|#@|email_title|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + formattedData.get("end_node_name") + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + formattedData.get("notification_type") + "|#@|"
					+ formattedData.get("smtp_host") + "|#@|" + formattedData.get("smtp_port") + "|#@|"
					+ formattedData.get("smtp_username") + "|#@|" + formattedData.get("smtp_password") + "|#@|"
					+ subject + "|#@|" + body + "|#@|" + formattedData.get("from") + "|#@|" + to + "|#@|" + cc + "|#@|"
					+ bcc + "|#@|" + formattedData.get("socket_port") + "|#@|" + "|#@|"
					+ formattedData.get("socket_class") + "|#@|" + formattedData.get("smtp_auth") + "|#@|"
					+ formattedData.get("email_title") + "|#@|" + "NotificationController" + "|#@|" + "mailNotification"
					+ "|#@|" + request.getRemoteHost() + "|#@|" + URI);
			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {

				/**
				 * Inserting Audit Log for Inititiation of Mail API Calling
				 */
				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of Mail API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/*
			 * Pushing Notification in kafka
			 */
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			/*
			 * If its true it will send success response to user otherwise failure response
			 * will be send
			 */
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}

	}

	/**
	 * METHOD to call sms notification with all end user details to send sms
	 * notification
	 * 
	 * 
	 * @param notification_msg
	 *            -Content of the sms to be send to client
	 * @param mobile_nos
	 *            -Mobile nos to whom all messages has to be send
	 * @param request
	 *            -HttpServletRequest request to get requested machines parameter
	 *            like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	public Message smsAutomateNotification(String notification_msg, String mobile_nos, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();

			formattedData.put("notification_msg", notification_msg);
			formattedData.put("notification_type", "sms");
			formattedData.put("end_node_name", environment.getProperty(request.getRemoteHost()));
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("mobile_nos", mobile_nos);
			formattedData.put("smse_username", environment.getProperty("sms.smse.username"));
			formattedData.put("smse_password", environment.getProperty("sms.smse.password"));
			formattedData.put("smse_ip", environment.getProperty("sms.smse.ip"));
			formattedData.put("smse_port", environment.getProperty("sms.smse.port"));
			formattedData.put("from", environment.getProperty("sms.from"));
			formattedData.put("notification_id", notification_id);
			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/**
			 * Defining Builders for Input parameters and value
			 */
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_msg|#@|notificationtype|#@|mobile_nos|#@|smse_username|#@|smse_password|#@|smse_ip|#@|smse_port|#@|from|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + formattedData.get("end_node_name") + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + notification_msg + "|#@|"
					+ formattedData.get("notification_type") + "|#@|" + mobile_nos + "|#@|"
					+ formattedData.get("smse_username") + "|#@|" + formattedData.get("smse_password") + "|#@|"
					+ formattedData.get("smse_ip") + "|#@|" + formattedData.get("smse_port") + "|#@|"
					+ formattedData.get("from") + "|#@|" + "NotificationController" + "|#@|" + "smsNotification"
					+ "|#@|" + request.getRemoteHost() + "|#@|" + URI);
			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {

				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of SMS API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			/*
			 * Pushing Notification in kafka
			 */
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			/*
			 * If its true it will send success response to user otherwise failure response
			 * will be send
			 */
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}
			/*
			 * Set the response data for api calling..
			 */

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}
	}

	/**
	 * Method for webhook Notification to call api with all its detail of end user
	 * API credentials
	 * 
	 * @param api_url
	 *            -API url which has to be called
	 * @param body_parameter
	 *            -Body Parameter of API
	 * @param header_parameter
	 *            -Header Parameter (payload) of API
	 * @param api_type
	 *            -Requires api type (SOAP/REST)
	 * @param method_type
	 *            -Requires api type (POST, GET, OPTIONS, DELETE)
	 * @param request
	 *            -HttpServletRequest request to get requested machines parameter
	 *            like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	public Message webHookApiNotification(String api_url, String body_parameter, String header_parameter,
			String method_type, HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();
			JsonParser json = new JsonParser();

			logger.info(json.parse(body_parameter));
			String bodyParameter = json.parse(body_parameter).toString();
			formattedData.put("end_node_name", environment.getProperty("audit.log.kafka"));
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("notification_type", "webhook");
			formattedData.put("api_url", api_url);
			formattedData.put("body_parameter", bodyParameter.replaceAll("\"", "\'"));
			formattedData.put("header_parameter", header_parameter.replaceAll("\"", "\'"));
			formattedData.put("api_type", "REST");
			formattedData.put("method_type", method_type);
			formattedData.put("db_url", environment.getProperty("webhook.db.url"));
			formattedData.put("db_driver", environment.getProperty("MySQL"));
			formattedData.put("table_name", environment.getProperty("webhook.table_name"));
			formattedData.put("table_parameter", environment.getProperty("webhook.table_parameter"));
			formattedData.put("notification_id", notification_id);

			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/**
			 * Defining Builders for Input parameters and value
			 */
			// logger.info(String.valueOf(environment.getProperty("audit.log.initiation")));
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|method_type|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + formattedData.get("end_node_name") + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + formattedData.get("notification_type") + "|#@|"
					+ api_url + "|#@|" + body_parameter + "|#@|" + header_parameter + "|#@|" + "REST" + "|#@|"
					+ formattedData.get("db_url") + "|#@|" + formattedData.get("db_driver") + "|#@|"
					+ formattedData.get("table_name") + "|#@|" + formattedData.get("table_parameter") + "|#@|"
					+ formattedData.get("method_type") + "|#@|" + "NotificationController" + "|#@|"
					+ "webHookNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);
			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {
				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of WebHook API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {
					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}
			/*
			 * Set the response data for api calling..
			 */

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}
	}

	public Message webHookSoapApiNotification(String api_url, String body_parameter, String header_parameter,
			String service_url, String soap_action, String soap_parameter_name, String method_type,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);
		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			Map<String, Object> formattedData = new HashMap<>();

			formattedData.put("end_node_name", environment.getProperty("audit.log.kafka"));
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("notification_type", "webhook");
			formattedData.put("api_url", api_url);
			formattedData.put("body_parameter", body_parameter.replaceAll("\"", "\'"));
			formattedData.put("header_parameter", header_parameter.replaceAll("\"", "\'"));
			formattedData.put("api_type", "SOAP");
			formattedData.put("service_url", service_url);
			formattedData.put("soap_action", soap_action);
			formattedData.put("soap_parameter_name", soap_parameter_name);
			formattedData.put("method_type", method_type);
			formattedData.put("db_url", environment.getProperty("webhook.db.url"));
			formattedData.put("db_driver", environment.getProperty("MySQL"));
			formattedData.put("table_name", environment.getProperty("webhook.table_name"));
			formattedData.put("table_parameter", environment.getProperty("webhook.table_parameter"));
			formattedData.put("notification_id", notification_id);

			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);
			/**
			 * Defining Builders for Input parameters and value
			 */
			// logger.info(String.valueOf(environment.getProperty("audit.log.initiation")));
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type||#@|service_url||#@|soap_action|#@|soap_parameter_name|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|method_type|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + formattedData.get("end_node_name") + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + formattedData.get("notification_type") + "|#@|"
					+ api_url + "|#@|" + body_parameter + "|#@|" + header_parameter + "|#@|" + "SOAP" + "|#@|"
					+ service_url + "|#@|" + soap_action + "|#@|" + soap_parameter_name + "|#@|"
					+ formattedData.get("db_url") + "|#@|" + formattedData.get("db_driver") + "|#@|"
					+ formattedData.get("table_name") + "|#@|" + formattedData.get("table_parameter") + "|#@|"
					+ formattedData.get("method_type") + "|#@|" + "NotificationController" + "|#@|"
					+ "webHookNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);
			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {
				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of WebHook API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {
					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}
			/*
			 * Set the response data for api calling..
			 */

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}
	}

	@SuppressWarnings({ "serial", "unchecked" })
	public Message customNotification(String data, String eventType, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * Initialization of response message
		 */
		Message responseMessage = new Message();
		/**
		 * Generating Unique Id for coming Notification Call
		 */
		long notification_id = new Date().getTime();
		/**
		 * Response MAP with notification id
		 */
		Map<String, String> responseParameterMAp = new LinkedHashMap<>();
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put("notification_id", notification_id);

		try {
			/**
			 * To get all Procedures
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * Setting the all required parameter for streaming to push the notification
			 */
			List<Map<String, Object>> formattedList = new LinkedList<>();
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, Object> formattedData = new HashMap<>();
			/**
			 * Getting Request Parameter
			 */
			Type listType = new TypeToken<Map<String, String>>() {
			}.getType();
			Map<String, String> parameterMAp = new Gson().fromJson(data, listType);
			logger.info("parameterMAp " + parameterMAp);

			String userIdentifier = parameterMAp.get("userIdentifier");
			/**
			 * Initializing Body and Header Parameter string
			 */
			StringBuilder bodyParameter = new StringBuilder();
			StringBuilder headerParameter = new StringBuilder();
			/**
			 * Binding Body Parameter and Header Parameter as per the Notification need to
			 * be send
			 */

			String urlToCall = String.valueOf(environment.getProperty("bss.redshift.api")).replaceAll("<imsi>",
					parameterMAp.get("imsi"));

			logger.info("urlToCall " + urlToCall);
			String redshiftResponse = httpUrlCalling.getOrchestrationData(urlToCall, "", null, "GET");
			logger.info("redshiftResponse " + redshiftResponse);
			if (redshiftResponse.contains("error")
					|| !redshiftResponse.contains("responseCode:200")) {
				/*
				 * Error Response
				 */
				responseMap.put("error_code", "CMN001");
				responseMap.put("description", urlToCall);
				responseMessage.setDescription("Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			} else {
				String responseData = redshiftResponse.substring(16);
				logger.info("responseData " + responseData);
				responseParameterMAp = new Gson().fromJson(responseData, listType);

				if (String.valueOf(responseParameterMAp.get("id")).equalsIgnoreCase("null")
						|| String.valueOf(responseParameterMAp.get("id")).equalsIgnoreCase("")) {
					responseMap.put("error_code", "CMN001");
					responseMap.put("description", urlToCall);
					responseMessage.setDescription("Issue Encountered...... Notificationd Failed .");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(false);
					return responseMessage;
				}

			}

			List<Map<String, String>> planIdResponse = (List<Map<String, String>>) genericService.executeProcesure(null,
					procedureRequestMap.get("6").toString(), parameterMAp.get("userPurchaseId").replaceAll("\\.0", ""));
			parameterMAp.put("userPurchaseId", planIdResponse.get(0).get("gm_plan_id"));
			// Removed + "UNSOL-" on Date 2018-05-16 17:41 for IDT setup
			if (eventType.equalsIgnoreCase("orderExpired")) {

				bodyParameter.append("{\"requestId\":\"" + parameterMAp.get("messageUuid")
						+ "\",\"eventStatus\":{\"code\": \"0\",\"description\": \"Success\"},\"orderDetails\":{\"planId\":\""
						+ parameterMAp.get("userPurchaseId") + "\",\"orderId\":\"" + parameterMAp.get("typeEntryId")
						+ "\",\"instanceId\":\"1\",\"effectiveDate\":\"" + sm.format(new Date())
						+ "\"},\"deviceDetails\":{\"iccid\":\"" + responseParameterMAp.get("staticDonorIccid")
						+ "\",\"imsi\":\"" + responseParameterMAp.get("staticDonorImsi") + "\",\"msisdn\":\""
						+ responseParameterMAp.get("staticDonorMsisdn") + "\"}}");
			}
			if (eventType.equalsIgnoreCase("orderStarted")) {
				bodyParameter.append("{\"requestId\":\"" + parameterMAp.get("messageUuid")
						+ "\",\"eventStatus\":{\"code\": \"0\",\"description\": \"Success\"},\"orderDetails\":{\"planId\":\""
						+ parameterMAp.get("userPurchaseId") + "\",\"orderId\":\"" + parameterMAp.get("typeEntryId")
						+ "\",\"instanceId\":\"1\",\"effectiveDate\":\"" + sm.format(new Date())
						+ "\"},\"deviceDetails\":{\"iccid\":\"" + responseParameterMAp.get("staticDonorIccid")
						+ "\",\"imsi\":\"" + responseParameterMAp.get("staticDonorImsi") + "\",\"msisdn\":\""
						+ responseParameterMAp.get("staticDonorMsisdn") + "\"}}");
			}
			if (eventType.equalsIgnoreCase("dataUsageThresholdMet")) {
				bodyParameter.append("{\"requestId\":\"" + parameterMAp.get("messageUuid")
						+ "\",\"orderDetails\":{\"planId\":\"" + parameterMAp.get("userPurchaseId")
						+ "\",\"orderId\":\"" + parameterMAp.get("typeEntryId")
						+ "\",\"instanceId\":\"1\",\"usedPercentage\":\"80\"},\"deviceDetails\":{\"iccid\":\""
						+ responseParameterMAp.get("staticDonorIccid") + "\",\"imsi\":\""
						+ responseParameterMAp.get("staticDonorImsi") + "\",\"msisdn\":\""
						+ responseParameterMAp.get("staticDonorMsisdn") + "\"}}");
			}
			if (eventType.equalsIgnoreCase("dataConsumed")) {
				bodyParameter.append("{\"requestId\":\"" + parameterMAp.get("messageUuid")
						+ "\",\"orderDetails\":{\"planId\":\"" + parameterMAp.get("userPurchaseId")
						+ "\",\"orderId\":\"" + parameterMAp.get("typeEntryId")
						+ "\",\"instanceId\":\"1\",\"usedPercentage\":\"100\"},\"deviceDetails\":{\"iccid\":\""
						+ responseParameterMAp.get("staticDonorIccid") + "\",\"imsi\":\""
						+ responseParameterMAp.get("staticDonorImsi") + "\",\"msisdn\":\""
						+ responseParameterMAp.get("staticDonorMsisdn") + "\"}}");
			}
			headerParameter.append("{\"Authorization\":\"" + parameterMAp.get("notificationAuthToken") + "\","
					+ "\"Accept\":\"application/json\",\"Accept-Language\":\" en-US\"" + "}");

			String tmp_url = userIdentifier + "/events/" + eventType;

			if (!parameterMAp.get("notificationUrl").endsWith("/")) {
				if (eventType.equalsIgnoreCase("dataConsumed")) {
					tmp_url = "/" + tmp_url.replaceAll("dataConsumed", "dataUsageThresholdMet");
				} else {
					tmp_url = "/" + tmp_url;
				}

			}

			String url = parameterMAp.get("notificationUrl") + tmp_url;

			formattedData.put("end_node_name", environment.getProperty("audit.log.kafka"));
			formattedData.put("end_node_ip", request.getRemoteHost());
			formattedData.put("notification_type", "webhook");
			// formattedData.put("api_url",
			// parameterMAp.get("notificationUrl")+ORDER_EXPIRE_URL);
			formattedData.put("api_url", url);
			formattedData.put("body_parameter", bodyParameter.toString().replaceAll("\"", "\'"));
			formattedData.put("header_parameter", headerParameter.toString().replaceAll("\"", "\'"));
			formattedData.put("api_type", "REST");
			formattedData.put("method_type", "POST");
			formattedData.put("db_url", environment.getProperty("webhook.db.url"));
			formattedData.put("db_driver", environment.getProperty("MySQL"));
			formattedData.put("table_name", environment.getProperty("webhook.table_name"));
			formattedData.put("table_parameter", environment.getProperty("webhook.table_parameter"));
			formattedData.put("notification_id", notification_id);

			/*
			 * Addind Parameter in list
			 */
			formattedList.add(formattedData);

			logger.info("formattedList " + formattedList);
			/**
			 * Defining Builders for Input parameters and value
			 */
			// logger.info(String.valueOf(environment.getProperty("audit.log.initiation")));
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/*
			 * Appending Parameter and their value respectively
			 */
			InputArgumentsName.append(
					"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|method_type|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
			InputArgumentsValue.append(request.getHeader("token") + "|#@|" + formattedData.get("end_node_name") + "|#@|"
					+ formattedData.get("end_node_ip") + "|#@|" + formattedData.get("notification_type") + "|#@|"
					+ parameterMAp.get("notificationUrl") + "|#@|" + bodyParameter + "|#@|" + headerParameter + "|#@|"
					+ "REST" + "|#@|" + formattedData.get("db_url") + "|#@|" + formattedData.get("db_driver") + "|#@|"
					+ formattedData.get("table_name") + "|#@|" + formattedData.get("table_parameter") + "|#@|"
					+ formattedData.get("method_type") + "|#@|" + "NotificationController" + "|#@|"
					+ "webHookNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);
			/**
			 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
			 * at particular value is true
			 */
			if (String.valueOf(environment.getProperty("audit.log.initiation")).equalsIgnoreCase("true")) {
				genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
						request.getRemoteHost(), request.getHeader("token"), 1, "Inititiation of WebHook API Calling",
						InputArgumentsName.toString(), InputArgumentsValue.toString());
			}
			Boolean Status = executeNotificationtoKafka(formattedList, request, response);
			if (Status) {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {

					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 1,
							"Notification Pushed to Queue Successfully to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/**
				 * Success Response
				 */
				responseMessage.setDescription("Notification Pushed to Queue Successfully");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * Inserting Audit Log for Initiation of API Call if the value of Inserting log
				 * at particular value is true
				 */
				if (String.valueOf(environment.getProperty("audit.log.kafka")).equalsIgnoreCase("true")) {
					genericService.executeProcesure(null, procedureRequestMap.get("3").toString(), notification_id,
							request.getRemoteHost(), request.getHeader("token"), 0,
							"Error in pushing notification to kafka", InputArgumentsName.toString(),
							InputArgumentsValue.toString());
				}
				/*
				 * Error Response
				 */
				responseMessage.setDescription("Kafka Issue Encountered...... Notificationd Failed .");
				responseMessage.setObject(responseMap);
				responseMessage.setValid(false);
				return responseMessage;
			}
			/*
			 * Set the response data for api calling..
			 */

		} catch (Exception e) {

			e.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(false);
			return responseMessage;

		}
	}
}
