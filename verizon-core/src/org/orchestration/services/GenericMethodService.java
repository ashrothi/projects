/**
 * This package contain the Service class of  GlobeTouch Application
 */
package org.orchestration.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.orchestration.constant.OrchestrationProcessParameter;
import org.orchestration.genericService.OrchestrationGenericService;
import org.orchestration.http.client.OrchestrationHttpURLCalling;
import org.orchestration.http.client.OrchestrationSoapApiCalling;
import org.orchestration.response.model.OrchestrationMessage;

/**
 * 
 * This class work as a Service class for Generic Method for API Calling .
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/OrchestrationApiConfiguration.properties")
@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
public class GenericMethodService {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	Logger logger = Logger.getLogger(GenericMethodService.class);
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	Environment environment;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OrchestrationGenericProcess orchestrationGenericProcess;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OrchestrationHttpURLCalling urlCalling;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OrchestrationSoapApiCalling urlSoapCalling;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OrchestrationGenericService genericService;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OrchestrationProcessParameter processParameter;

	/**
	 * To Validate the Authentication Parameter of each API defined in Group.The
	 * Purpose of this method is:
	 * 
	 * 1.To Check If Authentication Parameter required.
	 * 
	 * 2.If Token is required than get Authentication Parameter from database
	 * with its active bit.
	 * 
	 * 3.If Authentication Parameter is active than add it into
	 * requestParameterList.
	 * 
	 * 4.If Authentication Parameter is not active than it will call
	 * authentication API of End Node and get the Authentication Parameter and
	 * insert it into database as well as add it into requestParameterList.
	 * 
	 * 5.If First Time API is calling and Database does'nt have Authentication
	 * Parameter in that case also we have to follow point 4.
	 * 
	 * @param urlResponse
	 *            -Set of APIs exist in their respective group
	 * @param requestParameterList
	 *            -Set of input Parameters
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            urlPassingParameter like host ,url ,headers
	 * @param response
	 * @return urlResponse with Authentication Parameter
	 * @throws Exception
	 */

	public List<Map<String, Object>> tokenValid(List<Map<String, Object>> urlResponse,
			List<Map<String, String>> requestParameterList, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initializing response
		 */

		List<Map<String, Object>> urlWithTokenResponse = new LinkedList<>();

		/*
		 * To get each API object from Group
		 */
		for (Map<String, Object> apiMap : urlResponse) {
			try {
				/**
				 * To Check if API need Authentication Parameter
				 */

				if (String.valueOf(apiMap.get("api_is_token_required")).equalsIgnoreCase("true")) {
					/**
					 * If API need Authentication Parameter than setting
					 * urlPassingParameter in passingMap to call Procedure to
					 * get Authentication Parameter from database
					 */
					Map<String, String> passingMap = new LinkedHashMap<>();
					passingMap.put("api_group_id", String.valueOf(apiMap.get("api_group_id")));
					passingMap.put("api_id", String.valueOf(apiMap.get("api_id")));
					passingMap.put("token_response", String.valueOf(apiMap.get("token_response")));
					passingMap.put("node_address_id", String.valueOf(apiMap.get("node_address_id")));
					/**
					 * Calling Procedure to get Authentication Parameter
					 */
					OrchestrationMessage tokenMessage = orchestrationGenericProcess
							.GenericOrchestrationProcedureCalling("2", passingMap, null, request, response);
					/**
					 * If response from GenericOrchestrationProcedureCalling is
					 * valid
					 */
					if (tokenMessage.isValid()) {
						/**
						 * Casting response in List<Map<String, Object>> format
						 */
						List<Map<String, Object>> tokenResponse = (List<Map<String, Object>>) tokenMessage.getObject();
						/*
						 * Checking the size of list
						 */

						if (tokenResponse.size() > 0) {
							/**
							 * To Check the parameterVAlidationMap of token it
							 * is active or not If it is 1 than it is active
							 */

							if (String.valueOf(tokenResponse.get(0).get("token_status")).equalsIgnoreCase("2")) {
								String[] string = String.valueOf(apiMap.get("token_response")).split(",");

								for (int j = 0; j < string.length; j++) {
									if (string[j].contains("token") || string[j].contains("Token")) {
										/**
										 * Append Authorization Parameter in
										 * requestParameterList
										 */

										apiMap.put(string[j].trim(), tokenResponse.get(0).get("token"));
										requestParameterList.get(0).put(string[j],
												String.valueOf(tokenResponse.get(0).get("token")));

									} else {
										apiMap.put(string[j].trim(), tokenResponse.get(0).get("token"));
										requestParameterList.get(0).put(string[j],
												String.valueOf(tokenResponse.get(0).get("token")));

									}
								}

							} else {
								/**
								 * For Making end-node api url
								 */

								String hostUrl = String.valueOf(apiMap.get("api_host_address"))
										+ String.valueOf(apiMap.get("api_token_api"));

								/**
								 * urlPassingParameter->parameter to call
								 * end-node API
								 */

								String urlPassingParameter = String.valueOf(apiMap.get("token_parameter"));
								/**
								 * Method To get Authorization Parameter
								 */
								passingMap.putAll(requestParameterList.get(0));
								Map<String, String> authToken = getToken(hostUrl, urlPassingParameter, request,
										response, passingMap, String.valueOf(apiMap.get("api_method_type")));
								/**
								 * To Check if authToken is empty
								 */
								if (authToken != null) {
									/**
									 * Remove token key from Map and add
									 * Authorization Parameter
									 */

									apiMap.putAll(authToken);
									requestParameterList.get(0).putAll(authToken);
									/**
									 * To insert Audit Log
									 */
									auditLogInsert(
											String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
											String.valueOf(apiMap.get("api_group_id")),
											String.valueOf(apiMap.get("api_id")),
											Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))),
											"Token Management ",
											String.valueOf(environment.getProperty("log.status.token.success")),
											"Token", String.valueOf(authToken), request);
								} else {
									/**
									 * To insert Audit Log
									 */
									auditLogInsert(
											String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
											String.valueOf(apiMap.get("api_group_id")),
											String.valueOf(apiMap.get("api_id")),
											Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
											"Token Management ",
											String.valueOf(environment.getProperty("log.status.token.failure")),
											"Token", String.valueOf(authToken), request);
									return null;
								}

							}
						}

					}

				}
				urlWithTokenResponse.add(apiMap);
				/**
				 * Inserting Audit for Getting Token
				 */

			} catch (Exception e) {
				/**
				 * To Print Exception if it comes in console and throw exception
				 */
				logger.setLevel(org.apache.log4j.Level.ERROR);
				logger.setPriority(Priority.ERROR);
				logger.error("ERROR", e);
				e.printStackTrace();
				urlWithTokenResponse.get(0).put("tokenError", "");
				auditLogInsert(String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
						String.valueOf(apiMap.get("api_group_id")), String.valueOf(apiMap.get("api_id")),
						Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))), "Token Management  ",
						String.valueOf(environment.getProperty("log.status.token.failure")), "Token Error",
						String.valueOf(e.getMessage()), request);

			}
		} /**
			 * Returning Set of APIs with TOken if it required
			 */
		return urlWithTokenResponse;
	}

	/**
	 * This Method is used to call both ASYNC or SYNC Group of OL.The following
	 * Steps will be followed in this Method:
	 * 
	 * 1.It will get the set of APIs to be called as per the group id passed
	 * with respect to country_code and ICCID passed to get their respective
	 * host addresses of End Node APIs.
	 * 
	 * 2.It will check if the Group is ASYNC or SYNC
	 * 
	 * i. If the group is ASYNC it will follow the steps define below:
	 * 
	 * a.Call urlParameterValidator method to validate the client parameters
	 * with its mapping defined in the database.
	 * 
	 * b.Call tokenValid method to get the token for the APIs whose
	 * is_token_required field is true.
	 * 
	 * c.Call dataTransformater method to transform the all API of group with
	 * its parameter values
	 * 
	 * d.Call executeNotificationtoKafka method to push the transformed data
	 * into the kafka Queue.
	 * 
	 * ii.If the group is SYNC it will follow the steps define below:
	 * 
	 * a.Call urlParameterValidator method to validate the client parameters
	 * with its mapping defined in the database.
	 * 
	 * b.Call tokenValid method to get the token for the APIs whose
	 * is_token_required field is true.
	 * 
	 * c.Call getUrlParameters method to transform the all API to get its header
	 * and body parameters.
	 * 
	 * d.Call getOrchestrationData method to call the end node APIs and store
	 * the response parameters in Input Parameter Map.
	 * 
	 * 3.Send the Response of the Method.
	 * 
	 * 
	 * 
	 * @param group_id
	 * @param parameterMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ResponseEntity<?> genericExecuteApiMethod(int group_id, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Initialization of response message
		 */
		OrchestrationMessage responseMessage = new OrchestrationMessage();
		Map<String, Object> responseMap = new LinkedHashMap<>();
		/**
		 * To get Custom error code as per API group.
		 */
		Map<String, Object> errorMAp = getErrorCodes(group_id, request, response);

		try {
			/**
			 * To Check if tracking_message_header is not Empty
			 */

			responseMap.put("tracking_message_header", String.valueOf(parameterMap.get("tracking_message_header")));
			/**
			 * Adding group id to parameter from configuration defined in
			 * ApiConfiguration.properties
			 */
			parameterMap.put("api_group_id", String.valueOf(group_id));

			/**
			 * Calling Procedure to get set of API which need to be validated
			 * ,transformed and forwarded to kafka queue
			 */

			OrchestrationMessage getUrlsMessage = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("1",
					parameterMap, null, request, response);

			/**
			 * To check if response is valid
			 */
			if (getUrlsMessage.isValid()) {
				/**
				 * Casting response in List<Map<String, Object>> format
				 */
				List<Map<String, Object>> urlResponse = (List<Map<String, Object>>) getUrlsMessage.getObject();

				if (urlResponse.size() > 0) {

					if (urlResponse.get(0).get("api_group_type").toString().equalsIgnoreCase("ASYNC")) {
						/**
						 * Declaration of List to store parameterMap
						 */
						List<Map<String, String>> requestParameterList = new LinkedList<>();
						/*
						 * Adding parameterMap in requestParameterList
						 */
						requestParameterList.add(parameterMap);
						/**
						 * Calling Method to Validate the Parameter
						 */
						Map<String, Map<String, String>> validatedParameterList = urlParameterValidator(urlResponse,
								requestParameterList, request, response);
						/**
						 * If parameters are valid than the
						 * validatedParameterList size will be 0.
						 */
						if (validatedParameterList.size() == 0) {
							/**
							 * To get the Token from end nodes in API's where
							 * token is required
							 */
							List<Map<String, Object>> tokenResponseList = tokenValid(urlResponse, requestParameterList,
									request, response);
							if (tokenResponseList == null) {

								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("3");

								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
								ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(
										":" + "Process Fail Issue in token Management " + responseMap.toString()));
								return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
							}

							/**
							 * To Transformed the data for API's to be called in
							 * the format of their respective calling format
							 */
							List<Map<String, Object>> transformedDataList = dataTransformater(tokenResponseList,
									requestParameterList, request, response);
							/**
							 * To check the size of transformedDataList.If data
							 * transformed successfully than the size will be
							 * more than 0 else list will be null
							 */
							if (transformedDataList.size() > 0) {
								/**
								 * Calling Method to Push Data in Kafka queue
								 */
								Boolean kafkaStatus = executeNotificationtoKafka(transformedDataList, "publisher",
										request, response);
								/**
								 * To Check kafkaStatus.It will be true if data
								 * pushed successfully in kafka else it will be
								 * false
								 */
								if (kafkaStatus) {
									/**
									 * Inserting Audit Log for data pushed
									 * successfully in kafka
									 */
									auditLogInsert(parameterMap.get("tracking_message_header"),
											String.valueOf(group_id), null,
											Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))),
											"Pushed to kafka",
											String.valueOf(
													environment.getProperty("log.status.kafka.execution.success")),
											"template", String.valueOf(transformedDataList).replaceAll(",", "|:")
													.replaceAll("\'", "\\\\'").replaceAll("\'", "\\\\'"),
											request);
									/**
									 * Response Of API
									 */
									// responseMessage.setDescription(
									// "Your Request has succesfully Registered
									// and forwarded for Processing");
									responseMessage.setObject(responseMap);
									// responseMessage.setValid(true);
									return new ResponseEntity<>(responseMap, HttpStatus.ACCEPTED);
								} else {
									/**
									 * Inserting Audit Log for data not pushed
									 * successfully in kafka
									 */
									auditLogInsert(parameterMap.get("tracking_message_header"),
											String.valueOf(group_id), null,
											Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
											"Kafka issue encoutered  ",
											String.valueOf(
													environment.getProperty("log.status.kafka.execution.failure")),
											"template", String.valueOf(transformedDataList).replaceAll(",", "|:")
													.replaceAll("\'", "\\\\'").replaceAll("\'", "\\\\'"),
											request);
									/**
									 * Response Of API
									 */
									Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("3");

									Map<String, Object> ErrorMessage = new HashMap<String, Object>(
											(Map) ErrorMessageMap);
									ErrorMessage.remove("priority");
									ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
									ErrorMessage.put("description",
											ErrorMessage.get("description").toString()
													.concat(":"
															+ "Kafka issue Encountered... Unable to process the request. "
															+ responseMap.toString()));

									return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

								}
							} else {
								auditLogInsert(parameterMap.get("tracking_message_header"), String.valueOf(group_id),
										null, Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
										"Transformation issue encoutered  ",
										String.valueOf(environment.getProperty("log.status.transformation.failure")),
										"template", String.valueOf(transformedDataList).replaceAll(",", "|:")
												.replaceAll("\'", "\\\\'"),
										request);
								/**
								 * Response Of API
								 */
								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("4");

								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
								ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(
										":" + "Data Transformation issue encoutered " + responseMap.toString()));
								return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

							}

						} else {
							/**
							 * Response Of API
							 */
							auditLogInsert(parameterMap.get("tracking_message_header"), String.valueOf(group_id), null,
									Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
									"Invalid Parameter",
									String.valueOf(environment.getProperty("log.status.transformation.failure")),
									"Invalid Parameter List", String.valueOf(validatedParameterList)
											.replaceAll(",", "|:").replaceAll("\'", "\\\\'"),
									request);
							if (validatedParameterList.containsKey("mandatoryParameterMap")) {
								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("1");

								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
								ErrorMessage.put("description",
										ErrorMessage.get("description").toString().concat(":"
												+ "Process Fail Invalid Parameter " + validatedParameterList
														.get("mandatoryParameterMap").toString()));
								return new ResponseEntity<>(ErrorMessage, HttpStatus.BAD_REQUEST);
							} else {
								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("2");

								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
								ErrorMessage.put("description",
										ErrorMessage.get("description").toString().concat(":"
												+ "Process Fail Invalid Parameter " + validatedParameterList
														.get("notSupportParameterMap").toString()));
								return new ResponseEntity<>(ErrorMessage, HttpStatus.BAD_REQUEST);
							}

						}
					} else {
						Object responseFromEndNode = null;
						/**
						 * Declaration of List to store parameterMap
						 */
						List<Map<String, String>> requestParameterList = new LinkedList<>();
						/*
						 * Adding parameterMap in requestParameterList
						 */
						requestParameterList.add(parameterMap);

						/**
						 * To Validate Parameter
						 */
						Map<String, Map<String, String>> validatedParameterList = urlParameterValidator(urlResponse,
								requestParameterList, request, response);
						/**
						 * To check if validatedParameterList size is zero
						 */
						if (validatedParameterList.size() == 0) {
							/**
							 * To get the Token from end nodes in API's where
							 * token is required
							 */
							List<Map<String, Object>> tokenResponseList = tokenValid(urlResponse, requestParameterList,
									request, response);

							for (Map<String, Object> map : tokenResponseList) {

								String hostUrl = String.valueOf(map.get("api_host_address"))
										.concat(String.valueOf(map.get("api_url")));

								/**
								 * Get Parameter for API calling
								 */
								List<Map<String, Object>> urlList = new LinkedList<>();
								urlList.add(map);
								Map<String, Object> passindMAp = getUrlParameters(urlList, parameterMap, request);
								/**
								 * Checking passindMAp is not null
								 */

								if (passindMAp != null) {
									Map<String, String> headerParameterMap = new LinkedHashMap<>();
									headerParameterMap = (Map<String, String>) passindMAp.get("header_parameter");
									StringBuilder builder = new StringBuilder();

									/**
									 * To set header Parameter
									 */
									if (String.valueOf(map.get("api_api_type")).equalsIgnoreCase("REST")) {
										if (headerParameterMap != null) {
											for (String key : headerParameterMap.keySet()) {
												builder.append(key + "=" + headerParameterMap.get(key) + "&");
											}
											if (builder.length() > 0) {
												builder.deleteCharAt(builder.lastIndexOf("&"));
											}

											String newhostUrl = hostUrl.concat("?" + String.valueOf(builder));

											responseFromEndNode = urlCalling.getOrchestrationData(newhostUrl,
													String.valueOf(passindMAp.get("body_parameter")),
													headerParameterMap, map.get("api_method_type").toString());
										} else {
											/**
											 * To get Body Parameter
											 */
											responseFromEndNode = urlCalling.getOrchestrationData(hostUrl,
													String.valueOf(passindMAp.get("body_parameter")), null,
													map.get("api_method_type").toString());

										}
									} else if (String.valueOf(map.get("api_api_type")).equalsIgnoreCase("SOAP")) {

										Object responseFromEndNodeNew = urlSoapCalling.getData(hostUrl,
												String.valueOf(passindMAp.get("body_parameter")), headerParameterMap);
										if (responseFromEndNodeNew.toString().contains("responseCode:200")) {
											JSONObject json = XML.toJSONObject(String.valueOf(responseFromEndNodeNew));

											responseFromEndNode = "responseCode:200" + json.toString();

										} else {
											Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp
													.get("3");

											Map<String, Object> ErrorMessage = new HashMap<String, Object>(
													(Map) ErrorMessageMap);
											ErrorMessage.remove("priority");
											ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
											ErrorMessage.put("description",
													ErrorMessage.get("description").toString().concat(":"
															+ "Process Fail  " + responseFromEndNodeNew.toString()));

											return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
										}

									}
								}

								/**
								 * To cast response in Json
								 */

								if (responseFromEndNode.toString().contains("error")
										|| !responseFromEndNode.toString().contains("responseCode:200")) {

									auditLogInsert(
											String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
											String.valueOf(map.get("api_group_id")), String.valueOf(map.get("api_id")),
											Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
											"Sync API Calling",
											String.valueOf(environment.getProperty("log.status.response.failure")),
											"End Node API Response ", String.valueOf(responseFromEndNode)
													.replaceAll(",", "|:").replaceAll("\'", "\\\\'"),
											request);
									Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("3");

									Map<String, Object> ErrorMessage = new HashMap<String, Object>(
											(Map) ErrorMessageMap);
									ErrorMessage.remove("priority");
									ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
									ErrorMessage.put("description", ErrorMessage.get("description").toString()
											.concat(":" + "Process Fail  " + responseFromEndNode.toString()));

									return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

								}
								Map<String, String> responseMapParameter = parse(
										String.valueOf(responseFromEndNode)
												.substring(responseFromEndNode.toString().indexOf("responseCode:200")
														+ 16),
										new LinkedHashMap<String, String>(), String.valueOf(group_id),
										map.get("api_id").toString());

								parameterMap.putAll(responseMapParameter);

								auditLogInsert(
										String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
										String.valueOf(map.get("api_group_id")), String.valueOf(map.get("api_id")),
										Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))),
										"Sync API Calling",
										String.valueOf(environment.getProperty("log.status.response.success")),
										"End Node API Response ",
										String.valueOf(responseFromEndNode)
												.substring(
														responseFromEndNode.toString().indexOf("responseCode:200") + 16)
												.replaceAll(",", "|:").replaceAll("\'", "\\\\'"),
										request);
							}
							/**
							 * API response of all sync API being called
							 */

							return new ResponseEntity<>(
									String.valueOf(responseFromEndNode.toString().substring(
											responseFromEndNode.toString().indexOf("responseCode:200") + 16)),
									HttpStatus.ACCEPTED);

						} else {
							/**
							 * API response
							 */

							auditLogInsert(String.valueOf(parameterMap.get("tracking_message_header")),
									String.valueOf(group_id), null,
									Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
									"Invalid Parameter ",
									String.valueOf(environment.getProperty("log.status.response.failure")),
									"Invalid Parameter API Response ", String.valueOf(validatedParameterList)
											.replaceAll(",", "|:").replaceAll("\'", "\\\\'"),
									request);
							if (validatedParameterList.containsKey("mandatoryParameterMap")) {
								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("1");

								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
								ErrorMessage.put("description",
										ErrorMessage.get("description").toString().concat(":"
												+ "Process Fail Invalid Parameter " + String
														.valueOf(validatedParameterList.get("mandatoryParameterMap"))));
								return new ResponseEntity<>(ErrorMessage, HttpStatus.BAD_REQUEST);
							} else {
								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("2");

								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
								ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(":"
										+ "Process Fail Invalid Parameter "
										+ String.valueOf(validatedParameterList.get("notSupportParameterMap"))));
								return new ResponseEntity<>(ErrorMessage, HttpStatus.BAD_REQUEST);
							}

						}
					}

				} else {
					/**
					 * Response Of API
					 */
					auditLogInsert(String.valueOf(parameterMap.get("tracking_message_header")),
							String.valueOf(group_id), null,
							Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
							"Invalid COUNTRY Code ",
							String.valueOf(environment.getProperty("log.status.response.failure")),
							"Invalid COUNTRY Code ",
							String.valueOf(responseMap).replaceAll(",", "|:").replaceAll("\'", "\\\\'"), request);

					Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("1");

					Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
					ErrorMessage.remove("priority");
					ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
					ErrorMessage.put("description", ErrorMessage.get("description").toString()
							.concat(":" + "Invalid Country Code " + responseMap.toString()));

					return new ResponseEntity<>(ErrorMessage, HttpStatus.BAD_REQUEST);
				}

			} else {
				/**
				 * Response Of API
				 */
				auditLogInsert(String.valueOf(parameterMap.get("tracking_message_header")), String.valueOf(group_id),
						null, Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
						"Internal Issue Occured From Database ",
						String.valueOf(environment.getProperty("log.status.response.failure")), "Error ",
						String.valueOf(responseMap).replaceAll(",", "|:").replaceAll("\'", "\\\\'"), request);

				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("3");

				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
				ErrorMessage.put("description", ErrorMessage.get("description").toString()
						.concat(":" + "Process Fail " + responseMap.toString()));
				return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

			}

		} catch (

		Exception e) {
			/**
			 * To print the exception if it comes and return exception
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			auditLogInsert(parameterMap.get("tracking_message_header"),
					String.valueOf(environment.getProperty("group.id.auth")), null,
					Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
					"Internal Issue encoutered  ",
					String.valueOf(environment.getProperty("log.status.kafka.execution.failure")), "template",
					String.valueOf(e.getMessage()).replaceAll(",", "|:").replaceAll("\'", "\\\\'"), request);
			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMAp.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
			ErrorMessage.put("description",
					ErrorMessage.get("description").toString().concat(":" + "Process Fail " + responseMap.toString()));
			return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	/**
	 * Inserting Audit Log with its required Parameter
	 * 
	 * @param tracking_message_header
	 * @param api_group_id
	 * @param api_id
	 * @param is_successful
	 * @param message
	 * @param state_id
	 * @param name
	 * @param value
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public void auditLogInsert(String tracking_message_header, String api_group_id, String api_id, int is_successful,
			String message, String state_id, String name, String value, HttpServletRequest request) throws Exception {
		try {
			/**
			 * To get list of Procedures from mvc-dispatcher-servlet.xml
			 */
			Map<String, Object> errorLogMap = processParameter.getMaps();
			/**
			 * Calling Procedure to insert Audit Log
			 */

			genericService.executeOrchestrationProcesure(null, errorLogMap.get("6").toString(), tracking_message_header,
					api_group_id, api_id, is_successful, message, state_id, name.toString().replaceAll(",", "|#@|"),
					value.toString().replaceAll(",", "|#@|"), request.getAttribute("user_name"));

		} catch (Exception e) {
			/**
			 * To Print Exception if it comes in console and throw exception
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * Method To call end Node APi to get Authorization parameter defined in
	 * token response
	 * 
	 * @param hostUrl
	 *            End Node API URL
	 * @param urlPassingParameter
	 *            Passing Parameter of API
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            urlPassingParameter like host ,url ,headers
	 * @param response
	 * @param passingMap
	 *            parameter Map to add response parameter with its value
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	private Map<String, String> getToken(String hostUrl, String urlPassingParameter, HttpServletRequest request,
			HttpServletResponse response, Map<String, String> passingMap, String methodType) throws Exception {
		/**
		 * Calling End Node API
		 */
		Object newToken = urlCalling.getOrchestrationData(hostUrl, urlPassingParameter, null, methodType);
		try {

			/**
			 * Initializing authMap which will store Authorization Parameter
			 * with its value
			 */

			Map<String, String> authMap = new LinkedHashMap<>();
			/**
			 * To check if response is empty from API called.
			 */

			/**
			 * To get all token_response in array of String
			 */
			String[] responseParameter = passingMap.get("token_response").split(",");
			/**
			 * To get each Authorization parameter with its value from response
			 */

			for (int i = 0; i < responseParameter.length; i++) {
				/**
				 * Casting response in String format
				 */

				if (newToken.toString().contains("responseCode:200")) {
					String responseString = String.valueOf(
							newToken.toString().substring(newToken.toString().indexOf("responseCode:200") + 16));

					String token = responseString.substring(
							responseString.indexOf(responseParameter[i]) + responseParameter[i].length() + 3);

					String[] authToken = token.split("\"");
					/**
					 * Storing Authorization parameter with its value
					 */

					authMap.put(responseParameter[i], authToken[0]);
				} else {
					auditLogInsert(String.valueOf(passingMap.get("tracking_message_header")),
							String.valueOf(passingMap.get("api_group_id")), String.valueOf(passingMap.get("api_id")),
							Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))), "Token ",
							String.valueOf(environment.getProperty("log.status.token.failure")), "Token Response",
							String.valueOf(newToken), request);
					return null;
				}

			}

			for (String key : authMap.keySet()) {
				/**
				 * To insert Token in Database
				 */
				if (key.contains("token") || key.contains("Token")) {
					passingMap.put("token", String.valueOf(authMap.get(key)));
				}
			}
			/**
			 * Inserting Token in Database
			 */
			orchestrationGenericProcess.GenericOrchestrationProcedureCalling("3", passingMap, null, request, response);
			/**
			 * Returning authMap Authorization parameter with its value
			 */
			auditLogInsert(String.valueOf(passingMap.get("tracking_message_header")),
					String.valueOf(passingMap.get("api_group_id")), String.valueOf(passingMap.get("api_id")),
					Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))), "Token ",
					String.valueOf(environment.getProperty("log.status.token.success")), "Token Response",
					String.valueOf(newToken), request);
			return authMap;

		} catch (Exception e) {
			/**
			 * To Print Exception if it comes in console and throw exception
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			auditLogInsert(String.valueOf(passingMap.get("tracking_message_header")),
					String.valueOf(passingMap.get("api_group_id")), String.valueOf(passingMap.get("api_id")),
					Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))), "Token ",
					String.valueOf(environment.getProperty("log.status.token.failure")), "Token Error Response",
					String.valueOf(newToken), request);
			return null;
		}

	}

	/**
	 * To Validate the Parameter
	 * 
	 * @param tokenResponse
	 * @param requestParameterList
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public Map<String, Map<String, String>> urlParameterValidator(List<Map<String, Object>> tokenResponse,
			List<Map<String, String>> requestParameterList, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initializing response List
		 */
		Map<String, Map<String, String>> responseParameter = new LinkedHashMap<>();
		try {
			/*
			 * To get each API object from Group
			 */
			Map<String, String> notSupportParameterMap = new LinkedHashMap<>();
			Map<String, String> mandatoryParameterMap = new LinkedHashMap<>();
			for (Map<String, Object> apiMap : tokenResponse) {

				StringBuilder validatedParameterValue = new StringBuilder();
				StringBuilder validatedParameterName = new StringBuilder();
				/**
				 * Splitting Parameter to get all
				 * input_parameters_client_parameter with its validations to
				 * validate parameter
				 */

				String[] parameterDatalength = String.valueOf(apiMap.get("input_parameters_length")).split("\\#\\$\\#");
				String[] parameterDataRegex = String.valueOf(apiMap.get("input_parameters_regex")).split("\\#\\$\\#");
				String[] parameterDataGMParameter = String.valueOf(apiMap.get("input_parameters_client_parameter"))
						.split(",");
				String[] parameterDataGMParameterValue = String
						.valueOf(apiMap.get("input_parameters_client_parameter_value")).split(",");
				String[] inputParameterValue = String.valueOf(apiMap.get("input_parameters_name")).split(",");
				String[] inputParameterRequiredValue = String.valueOf(apiMap.get("input_parameters_is_required"))
						.split(",");
				String[] inputParameterRegexDescription = String
						.valueOf(apiMap.get("input_parameters_regex_description")).split("\\#\\$\\#");
				/**
				 * Getting Each Parameter with its validation constraints
				 */
				for (int i = 0; i < parameterDataGMParameter.length; i++) {
					/**
					 * To get parameter mapping with user's Parameter on the
					 * basis of mandatory parameter and value not supported
					 */
					if (!parameterDataGMParameter[i].equalsIgnoreCase("null")
							&& !String.valueOf(apiMap.get("token_response")).contains(parameterDataGMParameter[i])) {
						String parameterValue = String
								.valueOf(requestParameterList.get(0).get(parameterDataGMParameter[i]));
						if (inputParameterRequiredValue[i].equalsIgnoreCase("1")) {
							if (!parameterValue.equalsIgnoreCase("")) {
								Map<String, String> parameterVAlidationMap = validate(parameterValue,
										parameterDatalength[i], parameterDataRegex[i], parameterDataGMParameter[i],
										inputParameterRegexDescription[i]);
								/**
								 * If Parameter is Valid
								 */
								if (parameterVAlidationMap != null) {
									notSupportParameterMap.put(parameterDataGMParameter[i],
											parameterVAlidationMap.toString());

									validatedParameterName.append(parameterDataGMParameter[i] + ",");
									validatedParameterValue
											.append(String
													.valueOf(parameterVAlidationMap.get(parameterDataGMParameter[i])
															.concat(String.valueOf(parameterVAlidationMap
																	.get(parameterDataGMParameter[i]))))
													.replaceAll(",", "") + ",");
								} else {
									validatedParameterName.append(parameterDataGMParameter[i] + ",");
									validatedParameterValue.append(
											String.valueOf(requestParameterList.get(0).get(parameterDataGMParameter[i]))
													+ ",");
								}
							} else {
								mandatoryParameterMap.put(parameterDataGMParameter[i], " is Mandatory Parameter");
							}

						} else {
							/**
							 * If parameter is optional than its value will be 0
							 * .Here we will validate parameter only in case is
							 * some value comes.
							 */
							if (inputParameterRequiredValue[i].equalsIgnoreCase("0")
									&& !parameterValue.equalsIgnoreCase("")) {
								Map<String, String> parameterVAlidationMap = validate(parameterValue,
										parameterDatalength[i], parameterDataRegex[i], parameterDataGMParameter[i],
										inputParameterRegexDescription[i]);
								/**
								 * If Parameter is Valid
								 */
								if (parameterVAlidationMap != null) {

									notSupportParameterMap.put(parameterDataGMParameter[i],
											parameterVAlidationMap.toString());

									validatedParameterName.append(parameterDataGMParameter[i] + ",");
									validatedParameterValue
											.append(String
													.valueOf(parameterVAlidationMap.get(parameterDataGMParameter[i])
															.concat(String.valueOf(parameterVAlidationMap
																	.get(parameterDataGMParameter[i]))))
													.replaceAll(",", "") + ",");
								} else {
									validatedParameterName.append(parameterDataGMParameter[i] + ",");
									validatedParameterValue.append(
											String.valueOf(requestParameterList.get(0).get(parameterDataGMParameter[i]))
													+ ",");
								}
							}
						}

					} else {
						/**
						 * Adding Parameter for Logs
						 */
						validatedParameterName.append(inputParameterValue[i] + ",");
						validatedParameterValue.append(String.valueOf(parameterDataGMParameterValue[i]) + ",");
					}

				}
				if (notSupportParameterMap.size() > 0) {
					responseParameter.put("notSupportParameterMap", notSupportParameterMap);
				}
				if (mandatoryParameterMap.size() > 0) {
					responseParameter.put("mandatoryParameterMap", mandatoryParameterMap);
				}
				if (responseParameter.size() > 0) {
					/**
					 * To Insert Audit Of API Parameter if parameter is valid
					 */
					auditLogInsert(String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
							String.valueOf(apiMap.get("api_group_id")), String.valueOf(apiMap.get("api_id")),
							Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
							"Parameter is not  valid",
							String.valueOf(environment.getProperty("log.status.validation.failure")),
							String.valueOf(validatedParameterName), String.valueOf(validatedParameterValue), request);
				} else {
					/**
					 * To Insert Audit Of API Parameter if its not valid
					 */

					auditLogInsert(String.valueOf(requestParameterList.get(0).get("tracking_message_header")),
							String.valueOf(apiMap.get("api_group_id")), String.valueOf(apiMap.get("api_id")),
							Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))),
							"Parameter is valid",
							String.valueOf(environment.getProperty("log.status.validation.success")),
							String.valueOf(validatedParameterName), String.valueOf(validatedParameterValue), request);
				}

			}
			return responseParameter;
		} catch (Exception e) {
			/**
			 * To Print Exception if it comes in console and throw exception
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			return null;

		}
	}

	/**
	 * This Method will Validate Parameter on the basis of :
	 * 
	 * 1.Length : It will check the length of the parameter defined in
	 * configuration database that to defined in the following sub checks:
	 * 
	 * i .less than (<): in this parameterDatalength is defined in >x format.
	 * 
	 * ii. greater than(>):in this parameterDatalength is defined in <x format.
	 * 
	 * iii equals(=):in this parameterDatalength is defined in =x format.
	 * 
	 * iv between(x <value <y):in this parameterDatalength is defined in xandy
	 * format.
	 * 
	 * 
	 * 2.Regex : It will check the regex of the parameter defined in
	 * configuration database .It will compile the regex using Pattern and
	 * Matcher class.
	 * 
	 * @param parameterValue
	 *            It contains client value
	 * 
	 * @param parameterDatalength
	 *            It contains length defined in database for respective
	 *            parameter
	 * 
	 * @param parameterDataRegex
	 *            It contains the Regex defined for the given parameter in
	 *            database
	 * 
	 * @param parameterDataGMParameter
	 *            It contains the mapping of the client parameter with api
	 *            parameters
	 * @param inputParameterRegexDescription
	 * 
	 * @return If parameter is valid returns null else return invalid parameter
	 */
	private Map<String, String> validate(String parameterValue, String parameterDatalength, String parameterDataRegex,
			String parameterDataGMParameter, String inputParameterRegexDescription) {
		/**
		 * validationMap return parameter with their parameterVAlidationMap
		 */

		Map<String, String> validationMap = new LinkedHashMap<>();
		try {

			/**
			 * If no Constraint defined than parameter parameterVAlidationMap
			 * will be true
			 */
			if (parameterDatalength.equalsIgnoreCase("null") && parameterDataRegex.equalsIgnoreCase("null")) {
				return null;
			}

			/**
			 * To check if length is > than given length
			 */
			if (!parameterDatalength.equalsIgnoreCase("null")) {

				if (parameterDatalength.contains(">")) {

					int length = Integer.parseInt(parameterDatalength.substring(parameterDatalength.indexOf(">") + 1));

					if (parameterValue.length() < length) {
						validationMap.put(parameterDataGMParameter,
								" is not valid,Length should be " + parameterDatalength);

					}
				}
				/**
				 * To check if length is < than given length
				 */
				if (parameterDatalength.contains("<")) {

					int length = Integer.parseInt(parameterDatalength.substring(parameterDatalength.indexOf("<") + 1));

					if (parameterValue.length() > length) {

						validationMap.put(parameterDataGMParameter, "length should be " + parameterDatalength);

					}
				}
				/**
				 * To check if length is between the given length
				 */
				if (parameterDatalength.contains("and")) {

					String[] lengths = parameterDatalength.split("and");

					if (!(parameterValue.length() < Integer.parseInt(lengths[0]))
							&& !(parameterValue.length() > Integer.parseInt(lengths[1]))) {

						validationMap.put(parameterDataGMParameter,
								" is not valid,Length should be between " + parameterDatalength);

					}

				}
				/**
				 * To check if length is equals to given length
				 */
				if (parameterDatalength.contains("=")) {

					int length = Integer.parseInt(parameterDatalength.substring(parameterDatalength.indexOf("=") + 1));

					if (parameterValue.length() != length) {

						validationMap.put(parameterDataGMParameter,
								" is not valid ,Length should be equals to " + length);

					}
				}

				/**
				 * To Check if Parameter has same length
				 */

			}
			/**
			 * If Regex Constraint is there
			 */
			if (!parameterDataRegex.equalsIgnoreCase("null")) {

				Pattern pattern = Pattern.compile(parameterDataRegex);
				Matcher matcher = pattern.matcher(parameterValue.trim());

				if (!matcher.matches()) {
					validationMap.put(parameterDataGMParameter, " is not valid, " + inputParameterRegexDescription);

				}

			}
			/***
			 * Returns validationMap
			 */
			if (validationMap.size() > 0) {
				return validationMap;
			} else {
				return null;
			}

		} catch (Exception e) {
			/**
			 * If exception comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			/**
			 * To bypass the internal error
			 */
			return null;

		}

	}

	/**
	 * This Method is used to push the transformed data to the kafka queue by
	 * fetching kafka config from database by passing kafka type.i.e weather it
	 * is producer or subscriber of the kafka.This Method will take the data
	 * Which needs to send in List<Map<String, Object>> and transform it in json
	 * format and than fetch data from DB of Kafka and than push it in defined
	 * Kafka Queue
	 * 
	 * @param tokenResponse
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the Boolean bit of success or failure
	 * @throws Exception
	 */
	public Boolean executeNotificationtoKafka(List<Map<String, Object>> tokenResponse, String kafka_type,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			/**
			 * Transforming coming data in json string format
			 */

			String commandNotificationJson = new Gson().toJson(tokenResponse);
			/**
			 * To check if string is not null
			 */
			if (commandNotificationJson != null) {
				/**
				 * To get kafka config from database
				 */
				Map<String, String> map = new LinkedHashMap<>();
				map.put("kafka_type", kafka_type);
				/**
				 * Calling generic Procedure to get kafka config
				 */

				OrchestrationMessage message = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("5",
						map, null, request, response);

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
							String.valueOf(kafkaConfigData.get(0).get("topic_name")), "ip", commandNotificationJson);
					logger.setLevel(org.apache.log4j.Level.INFO);
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
					 * If data published successfully it will send true in
					 * return
					 */
					return true;
				} else {
					/*
					 * If data not published successfully it will send false in
					 * return
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
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method is used to transform the each API call which is defined in the
	 * group API and will be called by Streaming layer.The process this method
	 * follow are as follow
	 * 
	 * 1. Split the following parameters in String Array:
	 * 
	 * 
	 * i.input_parameters_client_parameter
	 * 
	 * ii.input_parameters_name
	 * 
	 * iii.input_parameters_client_parameter_value
	 * 
	 * iv.input_parameter_is_header
	 * 
	 * v.api_response_parameter_value
	 * 
	 * 
	 * 2.Map the each parameter with its mapped parameter with client or static
	 * value or a response parameter of API and store it in new String List name
	 * inputParameterValue.
	 * 
	 * 3.Remove key which will be not used by Streaming and add few new key for
	 * the streaming use.
	 * 
	 * 4.Will insert Audit log for each API being transformed
	 * 
	 * 
	 * 
	 * @param tokenResponse
	 * @param requestParameterList
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public List<Map<String, Object>> dataTransformater(List<Map<String, Object>> tokenResponse,
			List<Map<String, String>> requestParameterList, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To get each API set from group
		 */
		for (Map<String, Object> apiMap : tokenResponse) {
			try {
				/**
				 * Splitting Parameter To Transform
				 */

				String[] parameterGMParameter = String.valueOf(apiMap.get("input_parameters_client_parameter"))
						.split(",");
				String[] inputParameterName = String.valueOf(apiMap.get("input_parameters_name")).split(",");
				String[] parameterDataGMParameterValue = String
						.valueOf(apiMap.get("input_parameters_client_parameter_value")).split(",");
				String[] isHeaderParameterValue = String.valueOf(apiMap.get("input_parameter_is_header")).split(",");

				String[] responseParameterValue = String.valueOf(apiMap.get("api_response_parameter_value")).split(",");
				List<String> inputParameterValue = new LinkedList<>();
				/**
				 * To get each Parameter to transform it accordingly
				 */
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < inputParameterName.length; i++) {
					/**
					 * to check mapping client parameter
					 */
					if (!parameterGMParameter[i].equalsIgnoreCase("null")) {
						if (apiMap.get(parameterGMParameter[i]) != null) {
							inputParameterValue.add(String.valueOf(apiMap.get(parameterGMParameter[i])));
						} else {
							inputParameterValue.add(requestParameterList.get(0).get(parameterGMParameter[i]));
						}
						/**
						 * To check the mapping with static value
						 */
					} else if (!parameterDataGMParameterValue[i].equalsIgnoreCase("null")) {

						inputParameterValue.add(parameterDataGMParameterValue[i]);
						/**
						 * to check the mapping with response parameter
						 */
					} else if (!responseParameterValue[i].equalsIgnoreCase("null")) {

						inputParameterValue.add(responseParameterValue[i]);
					} else {
						/**
						 * To check the mapping with input parameter value with
						 * input parameter map
						 */
						inputParameterValue.add(String.valueOf(apiMap.get(inputParameterName[i])));
					}
					/**
					 * To add parameter in URL if its isHeaderParameterValue
					 * value of i is 1
					 */
					if (isHeaderParameterValue[i].equalsIgnoreCase("1")
							&& !inputParameterName[i].equalsIgnoreCase("Authorization")) {
						if (!parameterDataGMParameterValue[i].equalsIgnoreCase("null")) {

							builder.append(String.valueOf(inputParameterName[i]) + "="
									+ parameterDataGMParameterValue[i] + "&");
						} else if (!parameterGMParameter[i].equalsIgnoreCase("null")) {

							builder.append(String.valueOf(inputParameterName[i]) + "="
									+ String.valueOf(apiMap.get(parameterGMParameter[i])) + "&");
						} else {

							builder.append(String.valueOf(inputParameterName[i]) + "="
									+ String.valueOf(apiMap.get(inputParameterName[i])) + "&");
						}
					}

					/**
					 * To remove Unused Parameter and Add Parameter which will
					 * be used by Streaming
					 */

					apiMap.remove("input_parameters_client_parameter");
					apiMap.remove("input_parameters_client_parameter_value");
					apiMap.remove("input_parameters_regex");
					apiMap.remove("input_parameters_regex_description");
					apiMap.remove("input_parameters_is_required");
					apiMap.remove("input_parameters_length");
					apiMap.remove("input_parameters_data_type");
					apiMap.remove("api_is_token_required");
					apiMap.remove("api_globetouch_endnode");
					apiMap.remove("token_parameter");
					apiMap.remove("token_response");
					apiMap.remove("input_parameters_api_group_id");
					apiMap.remove("response_api_url");
					apiMap.remove("response_parameter_name");
					apiMap.remove("response_parameter_api_id");
					apiMap.remove("response_parameter_api_group_id");
					apiMap.remove("respose_api_name");
					apiMap.remove("api_response_parameter_id");
					apiMap.remove("input_parameters_response_parameter_id");
					apiMap.remove("api_response_parameter_value");
					apiMap.remove("api_token_api");
					apiMap.put("tracking_message_header", requestParameterList.get(0).get("tracking_message_header"));
					apiMap.put("tmp_variable", "");
					apiMap.put("retry_no", 0);
					apiMap.put("user_name", request.getHeader("user_name"));
					apiMap.put("returnUrl", String.valueOf(requestParameterList.get(0).get("returnUrl")));
					apiMap.put("requestId", String.valueOf(requestParameterList.get(0).get("requestId")));
					// requestParameterList.get(0).remove("api_group_id");
					// apiMap.putAll(requestParameterList.get(0));
				}
				/**
				 * To Check if inputParameterValue is not null
				 */
				if (builder.length() > 0) {
					String url = String.valueOf(apiMap.get("api_url"));
					apiMap.remove("api_url");
					builder.deleteCharAt(builder.lastIndexOf("&"));
					apiMap.put("api_url", url + "?" + builder.toString());
				}
				if (inputParameterValue.size() > 0) {

					/**
					 * To add input_parameters_value in current API set
					 */
					apiMap.put("input_parameters_value",
							String.valueOf(inputParameterValue).replaceAll("\\[", "").replaceAll("\\]", ""));

					/**
					 * Audit Log Insert for Transformation done successfully
					 */
					auditLogInsert(String.valueOf(apiMap.get("tracking_message_header")),
							String.valueOf(apiMap.get("api_group_id")), String.valueOf(apiMap.get("api_id")),
							Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))),
							"API urlPassingParameter is transformed",
							String.valueOf(environment.getProperty("log.status.transformation.success")),
							String.valueOf(apiMap.get("input_parameters_name")),
							String.valueOf(apiMap.get("input_parameters_value")), request);
				}

			} catch (Exception e) {
				/**
				 * To Print exception if it comes
				 */
				logger.setLevel(org.apache.log4j.Level.ERROR);
				logger.setPriority(Priority.ERROR);
				logger.error("ERROR", e);
				e.printStackTrace();
				/**
				 * Audit Log Insert for Transformation not done.
				 */
				auditLogInsert(String.valueOf(tokenResponse.get(0).get("tracking_message_header")),
						String.valueOf(tokenResponse.get(0).get("api_group_id")), String.valueOf(apiMap.get("api_id")),
						Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))),
						"Transformation Failure",
						String.valueOf(environment.getProperty("log.status.transformation.failure")),
						String.valueOf("Error "), String.valueOf(e.getMessage()), request);
				return null;

			}
		}
		/**
		 * Return Statement
		 */
		return tokenResponse;
	}

	/**
	 * This Method is used to get the URL parameter of end nodes API to call it
	 * .The process this method do is as follow:
	 * 
	 * 1. Split the following parameters in String Array: *
	 * 
	 * i.input_parameters_client_parameter
	 * 
	 * ii.input_parameters_name
	 * 
	 * iii.input_parameters_client_parameter_value
	 * 
	 * iv.input_parameter_is_header
	 * 
	 * v.api_response_parameter_value
	 * 
	 * 
	 * 2.Add Header parameters in headerMAp
	 * 
	 * 3.For compiling body parameters it follow the following steps:
	 * 
	 * i.Compile the api_template using Pattern and Matcher class. ii.replace
	 * <parameterName> with its value on the basis of mapping defined in DB from
	 * one of this 2 MAPS:
	 * 
	 * a.requesParameterMap
	 * 
	 * b.staticParamMAp
	 * 
	 * ii.Storing whole transformed body parameters in StringBuider sb.
	 * 
	 * 
	 * 4.Add both headerMap and Body parameters in parameterMAp.
	 * 
	 * 5.returns parameterMAp.
	 * 
	 * 
	 * @param urlResponse
	 *            List of Group API
	 * @param requesParameterMap
	 *            Map of input parameter
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public Map<String, Object> getUrlParameters(List<Map<String, Object>> urlResponse,
			Map<String, String> requesParameterMap, HttpServletRequest request) throws Exception {
		Map<String, Object> parameterMAp = new LinkedHashMap<>();
		/**
		 * To get Each API set from Group
		 */
		for (Map<String, Object> apiMap : urlResponse) {

			try {
				/**
				 * Splitting parameter to set body and header parameters
				 */

				String[] parameterGMParameter = String.valueOf(apiMap.get("input_parameters_client_parameter"))
						.split(",");
				String[] inputParameterName = String.valueOf(apiMap.get("input_parameters_name")).split(",");
				String[] parameterDataGMParameterValue = String
						.valueOf(apiMap.get("input_parameters_client_parameter_value")).split(",");
				String[] parameterIsHeaderValue = String.valueOf(apiMap.get("input_parameter_is_header")).split(",");
				String[] responseParameterValue = String.valueOf(apiMap.get("api_response_parameter_value")).split(",");
				StringBuffer sb = new StringBuffer();

				Map<String, String> staticParamMAp = new LinkedHashMap<>();
				Map<String, String> responseParameterValueMAp = new LinkedHashMap<>();

				for (int i = 0; i < parameterDataGMParameterValue.length; i++) {
					if (!parameterDataGMParameterValue[i].equalsIgnoreCase("null")) {
						staticParamMAp.put(inputParameterName[i], parameterDataGMParameterValue[i]);
						responseParameterValueMAp.put(inputParameterName[i], responseParameterValue[i]);
					}

				}
				/**
				 * Initializing header Map to store the header parameter
				 */
				Map<String, String> headerMAp = new LinkedHashMap<>();
				for (int i = 0; i < inputParameterName.length; i++) {
					/**
					 * To get Header Parameter
					 */

					if (parameterIsHeaderValue[i].equalsIgnoreCase("1")) {

						if (!parameterGMParameter[i].equalsIgnoreCase("null")) {

							headerMAp.put(inputParameterName[i], requesParameterMap.get(parameterGMParameter[i]));
						} else if (!parameterDataGMParameterValue[i].equalsIgnoreCase("null")) {

							headerMAp.put(inputParameterName[i], parameterDataGMParameterValue[i]);
						} else if (!responseParameterValue[i].equalsIgnoreCase("null")) {

							headerMAp.put(inputParameterName[i], responseParameterValue[i]);
						} else {

							headerMAp.put(inputParameterName[i], String.valueOf(apiMap.get(inputParameterName[i])));
						}

					} else {

						/**
						 * To get Body Parameter
						 */

						if (String.valueOf(apiMap.get("api_api_type")).equalsIgnoreCase("REST")) {
							Pattern pattern = Pattern.compile("<.+?>");
							Matcher matcher = pattern.matcher(String.valueOf(apiMap.get("api_template")));

							if (sb.length() == 0) {
								while (matcher.find()) {
									String match_case = matcher.group(0);

									if (match_case.replaceAll("[<,>]", "").contains("#&#")) {
										String match_case_value = String
												.valueOf(requesParameterMap.get(match_case.replaceAll("[<,>]", "")));
										matcher.appendReplacement(sb, match_case_value);
									}
									if (requesParameterMap.containsKey(match_case.replaceAll("[<,>]", ""))) {
										String match_case_value = String
												.valueOf(requesParameterMap.get(match_case.replaceAll("[<,>]", "")));
										matcher.appendReplacement(sb, match_case_value);
									} else {
										String match_case_value = "";
										matcher.appendReplacement(sb, match_case_value);
									}
									if (staticParamMAp.containsKey(match_case.replaceAll("[<,>]", ""))) {

										String match_case_value = staticParamMAp
												.get(match_case.replaceAll("[<,>]", ""));

										matcher.appendReplacement(sb, match_case_value);
									}
									if (!responseParameterValue[i].equalsIgnoreCase("null")) {
										String match_case_value = requesParameterMap.get(responseParameterValue[i]);

										matcher.appendReplacement(sb, match_case_value);

									}

								}
								matcher.appendTail(sb);
							}
						} else if (String.valueOf(apiMap.get("api_api_type")).equalsIgnoreCase("SOAP")) {
							Pattern pattern = Pattern.compile("@@.+?@@");
							Matcher matcher = pattern.matcher(String.valueOf(apiMap.get("api_template")));

							if (sb.length() == 0) {
								while (matcher.find()) {
									String match_case = matcher.group(0);

									if (match_case.replaceAll("[@@]", "").contains("#&#")) {
										String match_case_value = String
												.valueOf(requesParameterMap.get(match_case.replaceAll("[@@]", "")));
										matcher.appendReplacement(sb, match_case_value);
									} else if (requesParameterMap.containsKey(match_case.replaceAll("[@@]", ""))) {
										String match_case_value = String
												.valueOf(requesParameterMap.get(match_case.replaceAll("[@@]", "")));
										matcher.appendReplacement(sb, match_case_value);
									} else if (staticParamMAp.containsKey(match_case.replaceAll("[@@]", ""))) {

										String match_case_value = staticParamMAp.get(match_case.replaceAll("[@@]", ""));

										matcher.appendReplacement(sb, match_case_value);
									}
								}
								matcher.appendTail(sb);
							}
						}

					}
					/**
					 * To remove Unused Parameter
					 */
					apiMap.remove("input_parameters_client_parameter");
					apiMap.remove("input_parameters_client_parameter_value");
					apiMap.remove("input_parameters_regex");
					apiMap.remove("input_parameters_length");
					apiMap.remove("input_parameters_data_type");
					apiMap.remove("api_is_token_required");
					apiMap.remove("api_globetouch_endnode");
					apiMap.remove("token_parameter");
					apiMap.remove("token_response");
					apiMap.remove("input_parameters_api_group_id");
					apiMap.remove("response_api_url");
					apiMap.remove("response_parameter_name");
					apiMap.remove("response_parameter_api_id");
					apiMap.remove("response_parameter_api_group_id");
					apiMap.remove("respose_api_name");
					apiMap.remove("api_response_parameter_id");
					apiMap.remove("input_parameters_response_parameter_id");
					apiMap.remove("api_response_parameter_value");

				}

				/**
				 * Adding body_parameter and header_parameter in parameterMAp
				 */

				parameterMAp.put("body_parameter", sb);
				parameterMAp.put("header_parameter", headerMAp);
				/**
				 * Insert Audit Log for
				 */
				auditLogInsert(String.valueOf(requesParameterMap.get("tracking_message_header")),
						String.valueOf(apiMap.get("api_group_id")), String.valueOf(apiMap.get("api_id")),
						Integer.parseInt(String.valueOf(environment.getProperty("success.bit"))), "SYNC API",
						String.valueOf(environment.getProperty("log.status.response.success")), "API Parameter",
						String.valueOf(parameterMAp), request);

			} catch (Exception e) {
				/**
				 * To Print Exception if it comes
				 */
				logger.setLevel(org.apache.log4j.Level.ERROR);
				logger.setPriority(Priority.ERROR);
				logger.error("ERROR", e);
				e.printStackTrace();
				auditLogInsert(String.valueOf(requesParameterMap.get("tracking_message_header")),
						String.valueOf(apiMap.get("api_group_id")), String.valueOf(apiMap.get("api_id")),
						Integer.parseInt(String.valueOf(environment.getProperty("failure.bit"))), "SYNC API",
						String.valueOf(environment.getProperty("log.status.response.failure")), "ERROR ",
						String.valueOf(e.getMessage()), request);
				return null;

			}
		}
		return parameterMAp;
	}

	/**
	 * it is recursive method which executed till all json object convert to
	 * hashmap.
	 * 
	 * @param json:Json
	 *            String containing Json Object and Json Array
	 * @param map:It
	 *            hold all parameter and value which is extract from json
	 *            variable
	 * @return:HashMap<String, String> map which havin all parameter and value
	 * 
	 * 
	 */
	public Map<String, String> parse(String json, Map<String, String> map, String group_id, String api_id) {
		try {
			/**
			 * Initializing Json Factory
			 */
			JsonFactory factory = new JsonFactory();
			/**
			 * Initializing ObjectMapper
			 */
			ObjectMapper mapper = new ObjectMapper(factory);
			/**
			 * Initializing JsonNode
			 */
			JsonNode rootNode = mapper.readTree(json);
			/**
			 * Initializing Iterator
			 */
			Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.getFields();
			/**
			 * Iterating Json till its last value
			 */
			while (fieldsIterator.hasNext()) {
				/**
				 * To get Response parameter value
				 */
				Map.Entry<String, JsonNode> field = fieldsIterator.next();

				/**
				 * To put response key and value in map
				 */
				map.put("#$#" + field.getKey() + "#&#" + api_id + "#&#" + group_id, String.valueOf(field.getValue()));
				/**
				 * Parsing Response as per their format
				 */
				if ((String.valueOf(field.getValue()).startsWith("{")
						&& String.valueOf(field.getValue()).endsWith("}"))) {

					parse(String.valueOf(field.getValue()), map, group_id, api_id);

				}
				if ((String.valueOf(field.getValue()).startsWith("\"")
						&& String.valueOf(field.getValue()).endsWith("\""))) {

					parse(String.valueOf(field.getValue()), map, group_id, api_id);

				}
				if (String.valueOf(field.getValue()).startsWith("[{")
						&& String.valueOf(field.getValue()).endsWith("}]")) {

					parseJsonArray(String.valueOf(field.getValue()), map, group_id, api_id);

				}
			}
		} catch (Exception e) {
			/**
			 * To Print Exception if it comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
		}
		/**
		 * Return Response Map
		 */
		return map;
	}

	/**
	 * parseJsonArray(String jsonArray,HashMap<String, String> map) :This Method
	 * is use to convert json object to map of parameter and value
	 * 
	 * @param jsonArray:String
	 *            of json Array
	 * @param map:HashMap<String,
	 *            String> map havin all parameter and value extract form json
	 */
	public void parseJsonArray(String jsonArray, Map<String, String> map, String group_id, String api_id) {
		try {

			JSONArray jsonArray1 = new JSONArray(jsonArray);
			for (int i = 0; i < jsonArray1.length(); i++) {
				JSONObject json = jsonArray1.getJSONObject(i);
				Iterator<String> keys = json.keys();

				while (keys.hasNext()) {
					String key = keys.next();
					map.put("#$#" + key + "#&#" + api_id + "#&#" + group_id, String.valueOf(json.get(key)));

				}

			}
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
		}
	}

	/**
	 * This method is use to validate user this method will be called by
	 * interface API THis method will call the procedure of Database by passing
	 * user_name and password and if it gets success response than it will send
	 * success response else false response
	 * 
	 * 
	 * @param user_name
	 *            user name of the client which need to be validated
	 * @param password
	 *            password of the user defined in the Database
	 * @param ip
	 *            IP of the user from where the API being called
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	public ResponseEntity<?> validateUser(String user_name, String password, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initializing the response message
		 */
		OrchestrationMessage responseMessage = new OrchestrationMessage();
		try {
			/**
			 * Parameter Map with the required parameter to call the API
			 */
			Map<String, String> map = new LinkedHashMap<>();
			map.put("user_name", user_name);
			map.put("password", password);
			map.put("ip", request.getRemoteHost());
			/**
			 * Calling GenericOrchestrationProcedureCalling Method to call the
			 * procedure to validate the user.
			 */
			OrchestrationMessage message = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("4", map,
					null, request, response);
			/**
			 * To response is Valid
			 */
			if (message.isValid()) {
				/**
				 * Casting response in List<Map<String, Object>> format.
				 */
				List<Map<String, Object>> formattedList = (List<Map<String, Object>>) message.getObject();

				/**
				 * TO check if valid bit of user is 1
				 */
				if (formattedList.get(0).get("is_valid").toString().equalsIgnoreCase("1")) {
					/**
					 * To send response of Method
					 */
					responseMessage.setObject(formattedList.get(0));

					return new ResponseEntity<>(responseMessage.getObject(), HttpStatus.ACCEPTED);
				} else {
					/**
					 * To send response of Method
					 */

					return new ResponseEntity<>("Invalid User", HttpStatus.UNAUTHORIZED);
				}
			} else {
				/**
				 * To send response of Method
				 */

				return new ResponseEntity<>("Invalid User", HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			/**
			 * To send response of Method
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();

			return new ResponseEntity<>("Invalid User", HttpStatus.UNAUTHORIZED);
		}

	}

	/**
	 * 
	 * This method is used to store all the custom error code of OL when the
	 * APllication of interface is being deployed.This method will call only
	 * when custom error codes in the Constant class is null and store all the
	 * error code by calling the DB.
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public Map<String, Object> getErrorCodes(int group_id, HttpServletRequest request, HttpServletResponse response) {
		/**
		 * To check if Error Map in Constant class is empty
		 */

		/**
		 * initialize response message
		 */
		OrchestrationMessage message;
		Map<String, Object> errorMap = new LinkedHashMap<>();
		try {
			/**
			 * Calling GenericOrchestrationProcedureCalling Method to call the
			 * procedure to validate the user.
			 */
			Map<String, String> passinMap = new LinkedHashMap<>();

			passinMap.put("api_group_id", String.valueOf(group_id));
			message = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("9", passinMap, null, request,
					response);
			/**
			 * To check response is Valid
			 */

			if (message.isValid()) {

				/**
				 * Casting response in List<Map<String, Object>> format.
				 */
				List<Map<String, Object>> formattedList = (List<Map<String, Object>>) message.getObject();
				if (formattedList.size() > 0) {
					/**
					 * To Store Custom Error Codes
					 */
					for (Map<String, Object> map : formattedList) {
						errorMap.put(map.get("priority").toString(), map);
					}

				}
			}
		} catch (Exception e) {
			/**
			 * To Print if Exception Occurs
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
		}
		return errorMap;

	}

	/**
	 * API to get Logs application wise on the basis of their user_name between
	 * the given dates
	 * 
	 * @param start_time
	 *            Contains start_time
	 * @param end_time
	 *            Contains end_time
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	public ResponseEntity<?> auditLogByUser(String user_name, String start_time, String end_time,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * Initializing the response message
		 */
		Map<String, Object> errorMap = getErrorCodes(0, request, response);
		OrchestrationMessage responseMessage = new OrchestrationMessage();
		try {
			/**
			 * Parameter Map with the required parameter to call the API
			 */
			Map<String, String> map = new LinkedHashMap<>();
			map.put("user_name", user_name);
			map.put("start_time", start_time);
			map.put("end_time", end_time);
			/**
			 * Calling GenericOrchestrationProcedureCalling Method to call the
			 * procedure to validate the user.
			 */
			OrchestrationMessage message = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("7", map,
					null, request, response);
			/**
			 * To check response is Valid
			 */
			if (message.isValid()) {
				/**
				 * Casting response in List<Map<String, Object>> format.
				 */
				List<Map<String, Object>> formattedList = (List<Map<String, Object>>) message.getObject();
				/**
				 * To send response of Method
				 */

				return new ResponseEntity<>(formattedList, HttpStatus.ACCEPTED);

			} else {
				/**
				 * To send response of Method
				 */
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
				ErrorMessage.put("description",
						ErrorMessage.get("description").toString().concat(":" + "Process Fail "));
				return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			/**
			 * To send response of Method
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			responseMessage.setDescription("Process Fail " + e.getMessage());

			responseMessage.setValid(false);
			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
			ErrorMessage.remove("priority");
			ErrorMessage.put("description",
					ErrorMessage.get("description").toString().concat(":" + "Process Fail " + e.getMessage()));
			return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * API to get Logs log_id wise
	 * 
	 * @param log_id
	 *            Contains log_id to gets its all logs
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	public ResponseEntity<?> auditLogById(String tracking_message_header, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initializing the response message
		 */
		Map<String, Object> errorMap = getErrorCodes(0, request, response);
		OrchestrationMessage responseMessage = new OrchestrationMessage();
		try {
			/**
			 * Parameter Map with the required parameter to call the API
			 */
			Map<String, String> map = new LinkedHashMap<>();
			map.put("tracking_message_header", tracking_message_header);
			/**
			 * Calling GenericOrchestrationProcedureCalling Method to call the
			 * procedure to validate the user.
			 */
			OrchestrationMessage message = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("8", map,
					null, request, response);
			/**
			 * To response is Valid
			 */
			if (message.isValid()) {
				/**
				 * Casting response in List<Map<String, Object>> format.
				 */
				List<Map<String, Object>> formattedList = (List<Map<String, Object>>) message.getObject();

				/**
				 * To send response of Method
				 */
				return new ResponseEntity<>(formattedList, HttpStatus.ACCEPTED);

			} else {
				/**
				 * To send response of Method
				 */
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
				ErrorMessage.remove("priority");
				ErrorMessage.put("description",
						ErrorMessage.get("description").toString().concat(":" + "Process Fail "));
				return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

			}
		} catch (Exception e) {
			/**
			 * To send response of Method
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
			responseMessage.setDescription("Process Fail " + e.getMessage());

			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.put("error_code", ErrorMessage.get("error_code"));
			ErrorMessage.remove("priority");
			ErrorMessage.put("description",
					ErrorMessage.get("description").toString().concat(":" + "Process Fail " + e.getMessage()));
			return new ResponseEntity<>(ErrorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	/**
	 * 
	 * This method is used to store all the custom error code of OL when the
	 * APllication of interface is being deployed.This method will call only
	 * when custom error codes in the Constant class is null and store all the
	 * error code by calling the DB.
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	public List<Map<String, Object>> getNotificationTemplate(int group_id, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To check if Error Map in Constant class is empty
		 */

		/**
		 * initialize response message
		 */
		OrchestrationMessage message;
		List<Map<String, Object>> responseTemplateMap = new LinkedList<>();
		try {
			/**
			 * Calling GenericOrchestrationProcedureCalling Method to call the
			 * procedure to validate the user.
			 */
			Map<String, String> passinMap = new LinkedHashMap<>();

			passinMap.put("api_group_id", String.valueOf(group_id));
			message = orchestrationGenericProcess.GenericOrchestrationProcedureCalling("10", passinMap, null, request,
					response);
			/**
			 * To check response is Valid
			 */

			if (message.isValid()) {

				/**
				 * Casting response in List<Map<String, Object>> format.
				 */
				responseTemplateMap = (List<Map<String, Object>>) message.getObject();

			}
		} catch (Exception e) {
			/**
			 * To Print if Exception Occurs
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
		}
		return responseTemplateMap;

	}
}
