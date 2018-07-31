/**
 * This package contain the service class for command Api.
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.ComandTemplate;
import com.springiot.response.Message;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * This class is defined as service which is used to get to execute command
 * Apis.
 * 
 * @author tanvigarg
 */
@Service
@PropertySource(value = "/WEB-INF/download.properties")
public class CommandService {
	/**
	 * To access functionality of GenericService Class.
	 */
	@Autowired
	private GenericService genericService;
	@Autowired
	Environment environment;
	/**
	 * To access functionality of ProcessParameter Class.
	 */
	@Autowired
	private ProcessParameter processParameter;

	/**
	 * @Auther:Garima Joshi
	 * 
	 *                This method is used to execute the commands apis which
	 *                will push the command template in the topic of kafka.
	 * 
	 * @param apiParameters,
	 *            Contains the parameters passed in calling the API. @return,
	 *            Returns the response message.
	 * 
	 */

	public Message ExecuteApplicationCommands(Map<String, String> apiParameters, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize the object of class Message.
		 */
		Message message = new Message();

		/*
		 * To handle exceptions, Try-catch block is used.
		 */
		try {

			/*
			 * Remove the unnecessary parameters from map of apiParameters.
			 */
			apiParameters.remove("token");
			apiParameters.remove("access_key");
			/*
			 * Call the procedure of metadata database to get command template
			 * and pass its all required parameters from parameters map.
			 */

			Object comandTemplate = genericService.executeProcesureFromMetaData(ComandTemplate.class,
					processParameter.getMaps().get("342").toString(), apiParameters.get("device_id"),
					apiParameters.get("command_name"), String.valueOf(request.getHeader("user_key")),
					String.valueOf(request.getHeader("user_id")));

			/*
			 * Check if data returned by procedure is not null.
			 */
			if (comandTemplate != null) {
				/*
				 * Call the method which will set the command template as per
				 * required format and push the template in one topic of IoT hub
				 * (Kafka).
				 */
				boolean isCommandExecuted = setTemplate(comandTemplate, apiParameters, request, response);

				/*
				 * Check if command published successfully.
				 */
				if (isCommandExecuted) {
					/*
					 * If true, than set the following response to API call.
					 */
					message.setDescription("Command Executed successfully");
					message.setValid(true);
					return message;

				}
				/*
				 * If false, than set the following response to API call.
				 */
				message.setDescription("Command Not Executed successfully");
				message.setValid(false);
				return message;
			} else {

			}

		} catch (Exception exception) {
			/*
			 * Print the exception
			 */
			message.setDescription(exception.getMessage());
			message.setValid(false);
			return message;
		}
		/*
		 * If any error occur set the following response to API call.
		 */
		message.setDescription("Process Fail");
		message.setValid(false);
		return message;
	}

	/**
	 * @Auther:Garima Joshi
	 * 
	 *                This method is used to set the commands template as per
	 *                required data format and that updated template is insert
	 *                in database which in return gives command id and using
	 *                that command id and other required data, the command
	 *                template is push in the IoT hub by using one topic of
	 *                kafka.
	 * 
	 * @param apiParameters,
	 *            Contains the parameters passed in calling the API.
	 * 
	 * 			@return, Returns true if process success else false.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	private boolean setTemplate(Object commandTemplate, Map<String, String> apiParameters, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Retrieve user_key and user_id from Headers
		String user_key = request.getHeader("user_key");
		String user_id = request.getHeader("user_id");

		/*
		 * To handle exceptions, Try-catch block is used.
		 */
		try {
			if (commandTemplate instanceof ArrayList) {
				/*
				 * Initialize the Properties class to set the required
				 * properties of kafka and zookeeper with specific IP and port
				 * and number of request.
				 */
				Properties kafkaProperties = new Properties();

				String topicType = String.valueOf(environment.getProperty("topicType"));

				/*
				 * Procedure is being called to retrieve iot hub configurations
				 * like topic name,zookeeper details and kafka details
				 */
				Object iotHubDetails = genericService.executeProcesureFromConfig(null,
						processParameter.getMaps().get("422").toString(), apiParameters.get("device_id"), topicType,
						user_key, user_id);

				// Response retrieved from procedure is converted into list<map>
				List<Map<String, Object>> iotHubList = (List<Map<String, Object>>) iotHubDetails;

				// Retrieve required fields from the procedure
				String topicName = iotHubList.get(0).get("iot_hub_topics_name").toString();
				String zookeeperHost = iotHubList.get(0).get("iot_hub_zookeeper_ip_address").toString();
				String zookeeperPort = iotHubList.get(0).get("iot_hub_zookeeper_port").toString();
				String kafkaHost = iotHubList.get(0).get("iot_hub_event_hub_ip").toString();
				String kafkaPort = iotHubList.get(0).get("iot_hub_event_hub_port").toString();

				String zookeeperDetails = zookeeperHost + ":" + zookeeperPort;
				String kafkaDetails = kafkaHost + ":" + kafkaPort;

				/*
				 * Set all the properties value.
				 */
				kafkaProperties.put("zookeeper.connect", zookeeperDetails);
				kafkaProperties.put("metadata.broker.list", kafkaDetails);
				kafkaProperties.put("serializer.class", "kafka.serializer.StringEncoder");
				kafkaProperties.put("request.required.acks", "1");
				/*
				 * Initialize the ProducerConfig class which will set all the
				 * properties.
				 */
				ProducerConfig producerConfig = new ProducerConfig(kafkaProperties);
				/*
				 * Create the object of Gson with the property that it can
				 * handle null values without giving and exception like
				 * incorrect json.
				 */
				Gson gson = new GsonBuilder().serializeNulls().create();
				/*
				 * Initialize the object of class Type by defining the required
				 * object type which will used in creating json object.
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * Create the list of map to store the parameters and their
				 * values which are passed in "data" field of api parameter.
				 */
				List<Map<String, String>> templateData = gson.fromJson(apiParameters.get("data"), type);

				/*
				 * Initialize the object of class StringBuilder which will
				 * append all required type of data in one object.
				 */
				StringBuilder parameterBuilder = new StringBuilder();
				ComandTemplate command = null;
				StringBuilder builder = new StringBuilder();
				/*
				 * Create the list of command template provided by database
				 * procedure.
				 */
				List<ComandTemplate> list = (List<ComandTemplate>) commandTemplate;

				String template = "";
				/*
				 * check if template send by procedure id not null or empty.
				 */
				if (list.size() > 0 || !(list.isEmpty())) {
					/*
					 * Execute the loop over the size of list for processing
					 * each template.
					 */
					for (int i = 0; i < list.size(); i++) {
						/*
						 * Get the required parameters name from the list.
						 */
						String parameterName = list.get(i).getService_serviceparameter_name().toString();
						/*
						 * Check if parameters name of api are matched with the
						 * parameters name of command template received.
						 */
						if (apiParameters.keySet().toString().contains(parameterName)) {
							/*
							 * if matched, append all parameters name in one
							 * object.
							 */
							parameterBuilder.append(parameterName + ",");
							/*
							 * Append all the values of parameters in another
							 * object.
							 */
							builder.append(apiParameters.get(parameterName) + ",");
						}
						/*
						 * Get the each command as per loop execution.
						 */
						command = list.get(i);
						/*
						 * Store the template in object of string.
						 */
						template = command.getService_commandtemplate_format().toString();
						/*
						 * Split the parameter name with comma and store in
						 * array object.
						 */
						String parameter[] = parameterBuilder.toString().split(",");
						/*
						 * Split the parameter value with comma and store in
						 * array object.
						 */
						String parameterValue[] = builder.toString().split(",");
						/*
						 * Execute the loop for length of array object.
						 */
						for (int k = 0; k < parameter.length; k++) {
							/*
							 * Check if template contains the object values.
							 */
							if (template.contains(parameter[k])) {
								/*
								 * Replace the parameters name in template with
								 * its values.
								 */

								template = template.replace(parameter[k], parameterValue[k]);
							}
						}
					}

					//
					String tmpTemplate = "";

					/*
					 * Execute the loop over templateData by storing its value
					 * in map object.
					 */

					if (!templateData.isEmpty() && templateData.size() > 0) {

						for (Map<String, String> data : templateData) {

							tmpTemplate = template;
							// tmpTemplate="{\"url\":\"files\",
							// \"data\":{\"name\": \"upload\", \"fileType\":\"1
							// Firmware Upgrade Image\", \"<oui>\" :
							// \"<value>\",\"<productClass>\":
							// \"<value>\",\"version\":\"v1\",\"<filename>\":\"<value>\"}}";
							/*
							 * For each loop over keys of map.
							 */

							for (String key : data.keySet()) {

								/*
								 * Check if template contains the parameters
								 * which are stored as key of map.
								 */
								if (tmpTemplate.contains(key)) {
									/*
									 * If true, than check if type parameters is
									 * equal to value String.
									 */
									if (data.get("type").toString().equalsIgnoreCase("string")) {
										// String value="\""+ s.get(key)+"\"";
										/*
										 * If true, than replace all special
										 * characters with required template
										 * format and parameters with values in
										 * string format.
										 */
										// System.out.println("inside key:
										// "+key);
										tmpTemplate = tmpTemplate.replace("<" + key + ">",
												"\"" + "<" + data.get(key) + ">" + "\"");
										tmpTemplate.replaceAll("<", "").replaceAll(">", "").replaceAll("\"\"", "\"");
										// replaceAll("<", "").replaceAll(">",
										// "").replaceAll("\"\"", "\"");
										// System.out.println("tmplt
										// "+tmpTemplate);
									} else {
										/*
										 * If false, than replace all special
										 * characters with required template
										 * format and parameters with values
										 * their type format.
										 */
										tmpTemplate = tmpTemplate.replace("<" + key + ">", "<" + data.get(key) + ">");
										tmpTemplate.replaceAll("<", "").replaceAll(">", "");
									}
								}

							}

							/*
							 * Insert the updated command template in database
							 * by calling procedure which will return the
							 * command id.
							 */
							Object commandId = genericService.executeProcesure(null,
									processParameter.getMaps().get("23").toString(), apiParameters.get("device_id"),
									user_key, user_id, apiParameters.get("command_name"),
									tmpTemplate.replaceAll("<", "").replaceAll(">", "").replaceAll("\"\"", "\""));

							/*
							 * Create the object of map which which store the
							 * required data in key value format like command
							 * id, device id and template.
							 */
							Map<String, Object> formattedDataMap = new HashMap<>();
							/*
							 * Put the key and its value in map object.
							 */
							formattedDataMap.put("command_Id",
									commandId.toString().replaceAll("[^0-9]+", "").replaceAll("\\W", ""));
							formattedDataMap.put("command_Details",
									tmpTemplate.replaceAll("<", "").replaceAll(">", "").replaceAll("\"\"", "\""));
							formattedDataMap.put("device_id", apiParameters.get("device_id"));

							Gson json = new GsonBuilder().serializeNulls().create();

							/*
							 * Convert the map object into json string object.
							 */
							String jsonDataSet = json.toJson(formattedDataMap);

							/*
							 * Following code is used to push the data on MQTT
							 * by creating connection with MQTT on specific port
							 * and define topic name.
							 */
							/*
							 * MqttAsyncClient client = new
							 * MqttAsyncClient("tcp://" + "192.168.1.41" + ":" +
							 * 1883, "binatoneXfusion1");
							 * client.connect().waitForCompletion();
							 * 
							 * client.publish(
							 * "192-168-1-41-1883-Binaton-MQTT-Config", new
							 * MqttMessage(finalDataSet .replaceAll("\\\\", "
							 * ").replaceAll("\"\\{", "\\{").replaceAll("\\}\"",
							 * "\\}").getBytes())); client.disconnect();
							 */
							/*
							 * Initialize the producer of kafka.
							 */
							Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
							/*
							 * Generate the data message to push on kafka on
							 * specified topic of kafka.
							 */

							KeyedMessage<String, String> message = new KeyedMessage<String, String>(topicName, "ip",
									jsonDataSet.replaceAll("\\\\", "").replaceAll("\"\\{", "\\{").replaceAll("\\}\"",
											"\\}"));

							/*
							 * Send the data on kafka.
							 */

							kafkaProducer.send(message);

							/*
							 * Close the kafka producer connection.
							 */
							kafkaProducer.close();
						}

					} else {

						Object commandId = genericService.executeProcesure(null,
								processParameter.getMaps().get("23").toString(), apiParameters.get("device_id"),
								user_key, user_id, apiParameters.get("command_name"),
								template.replaceAll("<", "").replaceAll(">", ""));

						/*
						 * Create the object of map which which store the
						 * required data in key value format like command id,
						 * device id and template.
						 */
						Map<String, Object> formattedDataMap = new HashMap<>();
						/*
						 * Put the key and its value in map object.
						 */
						formattedDataMap.put("command_Id",
								commandId.toString().replaceAll("[^0-9]+", "").replaceAll("\\W", ""));
						formattedDataMap.put("command_Details", template.replaceAll("<", "").replaceAll(">", ""));
						formattedDataMap.put("device_id", apiParameters.get("device_id"));

						Gson json = new GsonBuilder().serializeNulls().create();

						/*
						 * Convert the map object into json string object.
						 */
						String jsonDataSet = json.toJson(formattedDataMap);

						/*
						 * Initialize the producer of kafka.
						 */
						Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
						/*
						 * Generate the data message to push on kafka on
						 * specified topic of kafka.
						 */

						KeyedMessage<String, String> message = new KeyedMessage<String, String>(topicName, "ip",
								jsonDataSet.replaceAll("\\\\", "").replaceAll("\"\\{", "\\{").replaceAll("\\}\"",
										"\\}"));

						/*
						 * Send the data on kafka.
						 */

						kafkaProducer.send(message);

						/*
						 * Close the kafka producer connection.
						 */
						kafkaProducer.close();

					}
					/*
					 * Return true if process execute successfully.
					 */
					return true;
				} else {
					System.out.println("Data not available");
				}
			}
		} catch (Exception exception) {

			exception.printStackTrace();
		}
		/*
		 * Return false if process not execute successfully.
		 */
		return false;
	}
}
