/**
 * This Package contains Services of Third Party Orchestration API.
 */
package org.thirdparty.services;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.orchestration.response.model.OrchestrationMessage;
import org.orchestration.services.GenericMethodService;
import org.orchestration.services.OrchestrationGenericProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thirdparty.request.model.Message;
import org.thirdparty.resources.JsonModification;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@SuppressWarnings({ "unchecked", "rawtypes", "serial", "unused", "deprecation" })
public class ThirdPartyService {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	@Autowired(required = true)
	private OrchestrationGenericProcess orchestrationGenericProcess;

	@Autowired
	private GenericProcess genericProcess;
	Logger logger = Logger.getLogger(ThirdPartyService.class);

	/**
	 * This Method is to change SIM Profile on a device.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> simProfiles(String simProfileData, String deviceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * to get custom error codes for respective api
		 */

		try {

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(simProfileData, parameterMap);

			/**
			 * Returning Response
			 */
			return methodService.genericExecuteApiMethod("109", parameterMap, request, response);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is Service to update settings on a device.1.Enable voice services
	 * (GMSA only) 2.Enable network attachment rule.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param deviceSettingData
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> deviceSettings(String deviceSettingData, String deviceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * to get custom error codes for respective api
		 */

		try {

			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(deviceSettingData, parameterMap);
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */

			genericProcess.GenericProcedureCalling("3", parameterMap, null, request, response);

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */

			/**
			 * Returning Response
			 */
			return methodService.genericExecuteApiMethod("110", parameterMap, request, response);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Service to Onboard a new subscriber with a device and maybe add a Demo or
	 * Trial WiFi plan.
	 * 
	 * @param onbordingRequestData
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	public ResponseEntity<?> onBoarding(String onbordingRequestData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get custom error code for Onboarding API
		 */

		try {

			/**
			 * To get user_name and password from the encoded string coming in header in
			 * parameter name Authorization
			 */

			Map<String, String> parameterMap = JsonModification.parse(onbordingRequestData, new LinkedHashMap<>());

			/**
			 * To parse the requestBody parameter in MAP <String,String> format
			 */

			return methodService.genericExecuteApiMethod("111", parameterMap, request, response);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		/**
		 * Send Error If Process Fails
		 */

	}

	/**
	 * This Method is to offboard a specific Subscriber
	 * 
	 * @param offBoardingData
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> offBoarding(Optional<String> deviceId, String ban, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get custom error codes for OffBoarding
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("58", request, response);
		try {
			/**
			 * To get user_name and password from the encoded string coming in header in
			 * parameter name Authorization
			 */
			Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
			/**
			 * Set attribute of user_name and password in request which will be access by OL
			 * core.
			 */
			request.setAttribute("user_name", map.get("user_name"));
			request.setAttribute("password", map.get("password"));

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			if (deviceId.isPresent()) {
				parameterMap.put("iccid", deviceId.get());
			}
			parameterMap.put("ban", ban);
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("userIdentifier", ban);
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			logger.info("parameterMap " + parameterMap);
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */

			ResponseEntity<?> checkUserExistenceResponse = methodService.genericExecuteApiMethod("77", parameterMap,
					request, response);
			if (!checkUserExistenceResponse.getStatusCode().is2xxSuccessful()) {
				/**
				 * Returning Response
				 */
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");
				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> responseParameterMap = JsonModification
					.parse(checkUserExistenceResponse.getBody().toString(), new LinkedHashMap<>());

			if (responseParameterMap.get("userExists") == null) {
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				ErrorMessage.put("description",
						ErrorMessage.get("description").toString().concat("No response from endnode."));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if (responseParameterMap.get("userExists").equalsIgnoreCase("false")) {

				Object notificationTemplate = "[{\"notification_type\":\"webhook\",\"api_url\":\""
						+ parameterMap.get("returnUrl") + "/subscribers/" + parameterMap.get("ban")
						+ "/events/accountClosed\",\"method_type\":\"POST\",\"notification_id\":"
						+ String.valueOf(parameterMap.get("tracking_message_header"))
						+ "\",\"table_name\":\"\",\"table_parameter\":\"\",\"header_parameter\":\" {'Authorization':'Basic R2xvYmV0b3VjaDpPbnN0YXIhNTA='}\",\"db_driver\":\"com.mysql.jdbc.Driver\",\"api_type\":\"REST\",\"db_url\":\"\",\"end_node_name\":\"true\",\"end_node_ip\":\"127.0.0.1\",\"api_group_id\":\"77\",\"api_id\":\"76\",\"body_parameter\":\"{'requestID':'"
						+ String.valueOf(parameterMap.get("tracking_message_header"))
						+ "','eventStatus': {'code':'CMN-INB002','description':'Downstream System Error:user does not exist at end node'},'deviceDetails': {'iccid': '"
						+ responseParameterMap.get("iccid") + "','imsi': '" + responseParameterMap.get("imsi")
						+ "','msisdn': '" + responseParameterMap.get("msisdn") + "'}}\"}]";

				OrchestrationMessage responseMessage = new OrchestrationMessage();
				Map<String, Object> responseMap = new LinkedHashMap<>();
				responseMap.put("tracking_message_header", String.valueOf(parameterMap.get("tracking_message_header")));
				ResponseEntity<?> notificationReq = pushNotification(notificationTemplate, "notification_publisher",
						request, response);
				if (notificationReq.getStatusCode().is2xxSuccessful()) {
					responseMessage
							.setDescription("Your Request has succesfully Registered and forwarded for Processing");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
					return new ResponseEntity<>(responseMessage, HttpStatus.ACCEPTED);

				} else {
					Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

					Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
					ErrorMessage.remove("priority");
					ErrorMessage.put("code", ErrorMessage.get("code"));
					ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(":"
							+ "Kafka issue Encountered... Unable to process the request. " + responseMap.toString()));

					List<Map<String, Object>> ErrorList = new LinkedList<>();
					ErrorList.add(ErrorMessage);
					Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
					FinalErrorMessageMap.put("errors", ErrorList);
					return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}
			parameterMap.putAll(responseParameterMap);
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */

			ResponseEntity<?> checkUserPurchaseExistenceResponse = methodService.genericExecuteApiMethod("78",
					parameterMap, request, response);
			if (!checkUserPurchaseExistenceResponse.getStatusCode().is2xxSuccessful()) {
				/**
				 * Returning Response
				 */
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");
				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> responsePurchaseParameterMap = JsonModification
					.parse(checkUserPurchaseExistenceResponse.getBody().toString(), new LinkedHashMap<>());

			if (responsePurchaseParameterMap.get("entries") != null) {

				/**
				 * Parse ImsiProfileData in json format
				 */
				String purchaseData = new JsonParser().parse(responsePurchaseParameterMap.get("entries")).toString();
				/**
				 * Initialize List to get ImsiProfileData
				 */
				List<Map<String, String>> purchaseDataList = new LinkedList<>();
				/**
				 * To check ImsiProfileData is Array of json object
				 */
				// if (String.valueOf(purchaseData).startsWith("[{") &&
				// String.valueOf(purchaseData).endsWith("}]")) {
				/**
				 * Define type to format ImsiProfileData in List of Map
				 */
				Type listType = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				purchaseDataList = new Gson().fromJson(purchaseData, listType);
				if (purchaseDataList.size() == 0) {
					ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("58", parameterMap,
							request, response);
					return responseMessage;
				}
				StringBuilder planId = new StringBuilder();
				StringBuilder orderId = new StringBuilder();
				for (Map<String, String> map2 : purchaseDataList) {
					planId.append(String.valueOf(map2.get("id")) + "-#-");
					orderId.append(String.valueOf(map2.get("typeEntryId")) + "-#-");
				}
				planId.delete(planId.lastIndexOf("-#-"), planId.lastIndexOf("-#-") + 3);
				orderId.delete(orderId.lastIndexOf("-#-"), orderId.lastIndexOf("-#-") + 3);

				parameterMap.put("ids", planId.toString());
				parameterMap.put("orderId", orderId.toString());
				parameterMap.put("notificationParam", "ids-#-orderId");

				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("79", parameterMap, request,
						response);
				return responseMessage;

				// }
			} else {
				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("58", parameterMap, request,
						response);
				return responseMessage;
			}
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is used to get order details on a specific account including data
	 * usage.includeCancelled = true; returns details of all Active, Queued,
	 * Canceled, and Expired orders.IncludePending = true; returns details of any
	 * pending orders.Data usage details of the active order will always be returned
	 * if there is an active order
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSubscriptionDetail(String ban, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To get Subscription Details API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("60", request, response);
		try {
			/**
			 * To get user_name and password from the encoded string coming in header in
			 * parameter name Authorization
			 */
			Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
			/**
			 * Set attribute of user_name and password in request which will be access by OL
			 * core.
			 */
			request.setAttribute("user_name", map.get("user_name"));
			request.setAttribute("password", map.get("password"));

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("userIdentifier", ban);
			long epoch = System.currentTimeMillis();
			parameterMap.put("tracking_message_header", String.valueOf(epoch));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));

			ResponseEntity<?> checkUserExistenceResponse = methodService.genericExecuteApiMethod("102", parameterMap,
					request, response);
			if (!checkUserExistenceResponse.getStatusCode().is2xxSuccessful()) {

				return checkUserExistenceResponse;
			}
			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> responseParameterMap = JsonModification
					.parse(checkUserExistenceResponse.getBody().toString(), new LinkedHashMap<>());

			if (responseParameterMap.get("userExists") == null) {
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				ErrorMessage.put("description",
						ErrorMessage.get("description").toString().concat("No response from endnode."));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if (responseParameterMap.get("userExists").equalsIgnoreCase("false")) {
				/**
				 * Returning Customize code if some Exception comes
				 */
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("2");
				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				ErrorMessage.put("description",
						" Invalid Parameter ban -".concat(ErrorMessage.get("description").toString()));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
			}

			/**
			 * Checking includeCancelled value to call the EndNode SYNC API accordingly
			 */
			Type listType = new TypeToken<Map<String, Object>>() {
			}.getType();
			/**
			 * Calling OL Core to get Notification Template
			 */
			List<Map<String, Object>> templateMap = (List<Map<String, Object>>) methodService
					.getNotificationTemplate(61, request, response);
			/**
			 * Initializing responseMessage
			 */
			ResponseEntity<?> responseMessage = null;
			/**
			 * Putting Condition as per requirement
			 */
			if (request.getParameter("includeCancelled").equalsIgnoreCase("false")) {
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				responseMessage = methodService.genericExecuteApiMethod("61", parameterMap, request, response);

			}
			if (request.getParameter("includeCancelled").equalsIgnoreCase("true")) {
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				responseMessage = methodService.genericExecuteApiMethod("60", parameterMap, request, response);

			}
			/**
			 * If response is success
			 */
			if (responseMessage.getStatusCode().is2xxSuccessful()) {
				/**
				 * Initializing Final response
				 */
				Map<String, Object> apiResponse = new LinkedHashMap<>();
				/**
				 * Initializing final List to store all the data
				 */
				List<Map<String, Object>> FinalResponse = new LinkedList<>();
				/**
				 * To Store response parameter from End Node
				 */
				Map<String, String> responseParameterFromEndNode = new LinkedHashMap<>();
				JsonModification.parse(String.valueOf(responseMessage.getBody()), responseParameterFromEndNode);
				/**
				 * Assigning data to apiResponse
				 */
				apiResponse = new Gson().fromJson(String.valueOf(responseMessage.getBody().toString()), listType);
				/**
				 * Casting data in List<Map<String, Object>> format
				 */
				Type castingType = new TypeToken<List<Map<String, Object>>>() {
				}.getType();
				List<Map<String, Object>> responseListToManipulate = new Gson()
						.fromJson(responseParameterFromEndNode.get("entries"), castingType);
				/**
				 * Iterating List to manipulate date in requested format
				 */

				if (responseListToManipulate != null && responseListToManipulate.size() > 0) {
					for (Map<String, Object> map2 : responseListToManipulate) {
						StringBuffer responseStringBuilder = new StringBuffer();
						/**
						 * calculating volume in GB which is coming in bytes
						 */
						double volume = 0;
						try {
							volume = Double.parseDouble((map2.get("volume").toString()));
							map2.put("newVol", Math.round(volume / (1024 * 1024)) / 100);
						} catch (Exception e) {
							map2.put("newVol", 0);
						}

						/**
						 * Condition to manipulate data
						 */

						map2.put("planStatus", "Active");
						if (map2.get("suspended").toString().equalsIgnoreCase("true")) {
							map2.put("planStatus", "Suspended");
						}
						if (map2.get("expired").toString().equalsIgnoreCase("true")) {
							map2.put("planStatus", "Expired");
						}
						if (map2.get("removed").toString().equalsIgnoreCase("true")) {
							map2.put("planStatus", "Removed");
						}

						parameterMap.put("planId", map2.get("typeEntryId").toString().replaceAll("\\.0", ""));

						Message message = genericProcess.GenericProcedureCalling("6", parameterMap, null, request,
								response);
						if (message.isValid()) {
							List<Map<String, Object>> planIdResponse = (List<Map<String, Object>>) message.getObject();
							if (planIdResponse.size() > 0) {
								map2.put("typeEntryId", String.valueOf(planIdResponse.get(0).get("gm_plan_id")));
								map2.put("planDuration", String.valueOf(planIdResponse.get(0).get("plan_duration")));

							} else {
								/**
								 * Returning Customize code if some Exception comes
								 */
								Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("2");
								Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
								ErrorMessage.remove("priority");
								ErrorMessage.put("code", ErrorMessage.get("code"));
								ErrorMessage.put("description", ErrorMessage.get("description").toString()
										.concat(":" + "planId value not supported."));
								/**
								 * Returning Response
								 */
								List<Map<String, Object>> ErrorList = new LinkedList<>();
								ErrorList.add(ErrorMessage);
								Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
								FinalErrorMessageMap.put("errors", ErrorList);
								return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
							}
						}
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

						if (map2.get("activationDate") != null) {
							try {
								Date activeDate = sdf.parse(map2.get("activationDate").toString());
								map2.put("activationDate", sdf.format(activeDate));
							} catch (Exception e) {
								map2.put("activationDate", "");
							}

						}

						try {
							Date purchaseDate = sdf.parse(map2.get("created").toString());
							map2.put("created", sdf.format(purchaseDate));
						} catch (Exception e) {
							map2.put("created", "");
						}
						try {
							Date expirationDate = sdf.parse(map2.get("expirationDate").toString());
							map2.put("expirationDate", sdf.format(expirationDate));
						} catch (Exception e) {
							// TODO: handle exception
							map2.put("expirationDate", "");
						}

						if (map2.get("removed").toString().equalsIgnoreCase("false")
								&& map2.get("suspended").toString().equalsIgnoreCase("false")
								&& map2.get("networkActivated").toString().equalsIgnoreCase("false")
								&& map2.get("activationDate") == null) {
							map2.put("activationDate", "");
							map2.put("planStatus", "Queued");
						}
						map2.put("id", map2.get("id").toString().replaceAll("\\.0", ""));
						/**
						 * To compile the template and set the required response
						 */
						Pattern pattern = Pattern.compile("<.+?>");
						Matcher matcher = pattern
								.matcher(String.valueOf(templateMap.get(0).get("notifiation_template_template")));
						/**
						 * To set the template and store it in
						 */
						if (responseStringBuilder.length() == 0) {
							while (matcher.find()) {
								String match_case = matcher.group(0);

								if (map2.containsKey(match_case.replaceAll("[<,>]", ""))) {
									String match_case_value = String
											.valueOf(map2.get(match_case.replaceAll("[<,>]", "")));
									matcher.appendReplacement(responseStringBuilder, match_case_value);
								} else {
									String match_case_value = "";
									matcher.appendReplacement(responseStringBuilder, match_case_value);
								}

							}
							matcher.appendTail(responseStringBuilder);
						}
						/**
						 * Casting String in Map to add in FinalResponse List
						 */
						Map<String, Object> urlResponseMessage = new Gson()
								.fromJson(String.valueOf(responseStringBuilder), listType);
						/**
						 * Adding response in List
						 */
						FinalResponse.add(urlResponseMessage);
					}

				}
				/**
				 * Returning Response By Adding Final List in apiResponse
				 */
				apiResponse = new LinkedHashMap<>();
				apiResponse.put("orderDetails", FinalResponse);
				return new ResponseEntity<>(apiResponse, responseMessage.getStatusCode());
			} else {

				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");
				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);

			}

		} catch (Exception e) {
			/**
			 * If Exception Occurs than to send Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is used to get all offers applicable for a Country. This service
	 * returns the full product catalog.
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get Offer Details API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("59", request, response);

		List<Map<String, Object>> finalResponseList = new LinkedList<>();
		try {
			/**
			 * To get user_name and password from the encoded string coming in header in
			 * parameter name Authorization
			 */
			Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
			/**
			 * Set attribute of user_name and password in request which will be access by OL
			 * core.
			 */
			request.setAttribute("user_name", map.get("user_name"));
			request.setAttribute("password", map.get("password"));
			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", String.valueOf(request.getParameter("country").trim()));
			long epoch = System.currentTimeMillis();
			parameterMap.put("tracking_message_header", String.valueOf(epoch));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			/**
			 * Calling OL Core Method to get the API Response template
			 */
			List<Map<String, Object>> templateMap = (List<Map<String, Object>>) methodService
					.getNotificationTemplate(59, request, response);

			Type listType = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> templateMapParam = new Gson().fromJson(
					String.valueOf(templateMap.get(0).get("notifiation_template_template").toString()), listType);
			List<Map<String, Object>> templateOfferList = (List<Map<String, Object>>) templateMapParam.get("offers");
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("59", parameterMap, request,
					response);
			/**
			 * Initializing api Response
			 */
			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");
				Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> ErrorList = new LinkedList<>();
				ErrorList.add(ErrorMessage);
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorList);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			Map<String, Object> apiResponse = new LinkedHashMap<>();
			apiResponse = new Gson().fromJson(String.valueOf(responseMessage.getBody().toString()), listType);
			/**
			 * Casting externalExtraPasses field from apiResponse in List<Map<String,
			 * Object>>
			 */
			List<Map<String, Object>> responseListToManipulate = (List<Map<String, Object>>) apiResponse
					.get("externalExtraPasses");

			if (responseListToManipulate != null && responseListToManipulate.size() > 0) {

				for (Map<String, Object> map2 : responseListToManipulate) {
					/**
					 * Manipulating Data as per requested data
					 */
					map2.put("validity", map2.get("validityTerm").toString().replaceAll(".0", "")
							.concat(" " + map2.get("validityTermUnit").toString()));
					if (map2.get("volumeUnit").toString().equalsIgnoreCase("GB")) {
						double volume = Double.parseDouble((map2.get("volume").toString()));

						map2.put("newVol", Math.round(volume / (1024 * 1024 * 1024)) / 100);
					}
					if (map2.get("volumeUnit").toString().equalsIgnoreCase("MB")) {
						double volume = Double.parseDouble((map2.get("volume").toString()));

						map2.put("newVol", Math.round(volume / (1024 * 1024)) / 100);
					}
					/**
					 * Map to store response Parameter
					 */
					Map<String, Object> responseParameterMap = new LinkedHashMap<>();
					/**
					 * Too add all template parameter
					 */
					responseParameterMap.putAll(templateOfferList.get(0));
					/**
					 * templateOfferList Parameter to get expected Response
					 */
					for (String mapw : templateOfferList.get(0).keySet()) {
						String value = templateOfferList.get(0).get(mapw).toString().replaceAll("[<,>]", "");
						if (map2.containsKey(value)) {
							responseParameterMap.put(mapw, map2.get(value));
						}
					}
					/**
					 * Adding responseParameterMap in finalResponseList
					 */
					finalResponseList.add(responseParameterMap);

				}

			}
			/**
			 * Returning Response after adding finalResponseList in apiResponse
			 */
			apiResponse = new LinkedHashMap<>();
			apiResponse.put("offers", finalResponseList);
			return new ResponseEntity<>(apiResponse, responseMessage.getStatusCode());
		} catch (Exception e) {
			/**
			 * If Exception Occur than to return Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Add Order on a specific account. Service can also be used on an existing
	 * account where carrier terms were never accepted before. As such, all
	 * subscriber details will be provided as done on Onboard API.
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param addOrder
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> addOrder(String ban, String addOrder, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get Add Order API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("65", request, response);
		try {
			/**
			 * To get user_name and password from the encoded string coming in header in
			 * parameter name Authorization
			 */
			Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
			/**
			 * Set attribute of user_name and password in request which will be access by OL
			 * core.
			 */
			request.setAttribute("user_name", map.get("user_name"));
			request.setAttribute("password", map.get("password"));
			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(addOrder, parameterMap);
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("ban", ban);
			parameterMap.put("addressLine1", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("addressLine2", String.valueOf(parameterMap.get("addressLine2").replace(",", " ")));
			parameterMap.put("address", String.valueOf(parameterMap.get("addressLine1").replace(",", " "))
					.concat(" " + String.valueOf(parameterMap.get("addressLine2").replace(",", " "))));
			parameterMap.put("streetNo", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("userIdentifier", ban);
			parameterMap.put("newPlanId", String.valueOf(parameterMap.get("planId")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			Message message = genericProcess.GenericProcedureCalling("5", parameterMap, null, request, response);
			if (message.isValid()) {
				List<Map<String, Object>> planIdResponse = (List<Map<String, Object>>) message.getObject();
				if (planIdResponse.size() > 0) {
					parameterMap.put("planId", String.valueOf(planIdResponse.get(0).get("bss_plan_id")));

				} else {
					/**
					 * Returning Customize code if some Exception comes
					 */
					Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("2");
					Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
					ErrorMessage.remove("priority");
					ErrorMessage.put("code", ErrorMessage.get("code"));
					ErrorMessage.put("description",
							ErrorMessage.get("description").toString().concat(":" + "planId value not supported."));
					/**
					 * Returning Response
					 */
					List<Map<String, Object>> ErrorList = new LinkedList<>();
					ErrorList.add(ErrorMessage);
					Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
					FinalErrorMessageMap.put("errors", ErrorList);
					return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
				}
			}
			logger.info("parameterMap " + parameterMap);

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			// if (!parameterMap.get("consent").equalsIgnoreCase("true")) {
			//
			// /**
			// * Returning Customize code if some Exception comes
			// */
			// Map<String, Object> ErrorMessageMap = (Map<String, Object>)
			// errorMap.get("2");
			// Map<String, Object> ErrorMessage = new HashMap<String,
			// Object>((Map) ErrorMessageMap);
			// ErrorMessage.remove("priority");
			// ErrorMessage.put("code", ErrorMessage.get("code"));
			// ErrorMessage.put("description",
			// ErrorMessage.get("description").toString().concat(":" + "consent
			// should be true."));
			// /**
			// * Returning Response
			// */
			// List<Map<String, Object>> ErrorList = new LinkedList<>();
			// ErrorList.add(ErrorMessage);
			// Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			// FinalErrorMessageMap.put("errors", ErrorList);
			// return new ResponseEntity<>(FinalErrorMessageMap,
			// HttpStatus.BAD_REQUEST);
			//
			// }
			if (parameterMap.get("transactionReference") == null
					|| parameterMap.get("transactionReference").trim().isEmpty()
					|| parameterMap.get("transactionReference").trim().equalsIgnoreCase("")) {
				String uuid = UUID.randomUUID().toString();

				parameterMap.put("transactionReference", uuid);
			}
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("65", parameterMap, request,
					response);
			/**
			 * Returning Response
			 */
			return responseMessage;
		} catch (Exception e) {

			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Cancel a specific order on a specific account. Carrier to lookup order
	 * details to get payment gateway details like transactionReference in order to
	 * apply any refund necessary to appropriate card
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param orderId
	 *            Order ID which has to be canceled
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> cancelOrder(String ban, String orderId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get Cancel Order API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("66", request, response);
		try {
			/**
			 * To get user_name and password from the encoded string coming in header in
			 * parameter name Authorization
			 */
			Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
			/**
			 * Set attribute of user_name and password in request which will be access by OL
			 * core.
			 */
			request.setAttribute("user_name", map.get("user_name"));
			request.setAttribute("password", map.get("password"));
			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("ban", ban);
			parameterMap.put("orderId", orderId);
			parameterMap.put("userPurchaseId", orderId);
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("instanceId", String.valueOf(request.getParameter("instanceId")));
			parameterMap.put("refundType", String.valueOf(request.getParameter("refundType")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			parameterMap.put("userIdentifier", ban);

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("66", parameterMap, request,
					response);
			/**
			 * Returning Response
			 */
			return responseMessage;

		} catch (Exception e) {

			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * To Push the coming Data from ESIM Notification API to kafka queue
	 * 
	 * @param data
	 * @param request
	 * @param response
	 * @return
	 */

	public ResponseEntity<?> pushNotification(Object data, String kafka_type, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/**
			 * To Cast the data which need to push in kafka queue
			 */
			Type type = new TypeToken<List<Map<String, Object>>>() {
			}.getType();
			List<Map<String, Object>> dataToPush = new Gson().fromJson(data.toString(), type);
			/**
			 * Pushing Data in Kafka
			 */
			Boolean status = methodService.executeNotificationtoKafka(dataToPush, kafka_type, request, response);
			/**
			 * Checking Kafka status and sending response accordingly
			 */
			if (status) {
				return new ResponseEntity<>("True", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>("False", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			/**
			 * Handling Exception If it comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			return new ResponseEntity<>("False", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> gcProfileSwitch(String data, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To get gc Profile Switch API error codes
		 */
		// Map<String, Object> errorMap = methodService.getErrorCodes("62", request,
		// response);
		try {
			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */

			parameterMap.put("tracking_message_header", String.valueOf(parameterMap.get("requestID")));
			parameterMap.put("requestId", String.valueOf(parameterMap.get("requestID")));
			parameterMap.put("ReturnURL", String.valueOf(parameterMap.get("returnUrl")));
			parameterMap.put("old_iccid", String.valueOf(parameterMap.get("targetICCID")));
			parameterMap.put("new_iccid", String.valueOf(parameterMap.get("currentICCID")));
			parameterMap.put("iccid", String.valueOf(parameterMap.get("currentICCID")));
			parameterMap.put("imsi", String.valueOf(parameterMap.get("targetIMSI")));
			parameterMap.put("msisdn", String.valueOf(parameterMap.get("targetMSISDN")));
			parameterMap.put("country", "GC");

			// logger.info("parameterMap " + parameterMap);

			// OrchestrationMessage message =
			// orchestrationGenericProcess.GenericOrchestrationProcedureCalling("1",
			// parameterMap, null, request, response);
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("62", parameterMap, request,
					response);
			/**
			 * Returning Response
			 */
			if (responseMessage.getStatusCode().is2xxSuccessful()) {
				Message message = genericProcess.GenericProcedureCalling("1", parameterMap, null, request, response);
			}
			System.out.println(responseMessage);
			return responseMessage;
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> updateSubscriber(String updateSubscriberRequestData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get update Subscriber API error codes
		 */
		// Map<String, Object> errorMap = methodService.getErrorCodes("68", request,
		// response);
		try {

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(updateSubscriberRequestData, parameterMap);
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */

			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("112", parameterMap, request,
					response);
			/**
			 * Returning Response
			 */
			return responseMessage;
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> onboardingFromEsimNotification(String data, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get Onboarding API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("57", request, response);
		try {
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);
			/**
			 * Checking onb_bit value to call !st Owner or Secand Owner
			 */
			parameterMap.put("country", parameterMap.get("countryCode"));
			if (parameterMap.get("onb_bit").equalsIgnoreCase("1")) {
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				// if (parameterMap.get("consent").equalsIgnoreCase("true")) {
				// if (parameterMap.get("planId").isEmpty()) {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(75, parameterMap,
				// request, response);
				// return responseMessage;
				// }
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(57, parameterMap,
				// request,
				// response);
				// return responseMessage;
				// } else {
				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("75", parameterMap, request,
						response);
				return responseMessage;
				// }

			}
			if (parameterMap.get("onb_bit").equalsIgnoreCase("2")) {
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				// if (parameterMap.get("consent").equalsIgnoreCase("true")) {
				// if (parameterMap.get("planId").isEmpty()) {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(76, parameterMap,
				// request, response);
				// return responseMessage;
				// }
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(73, parameterMap,
				// request,
				// response);
				// return responseMessage;
				// } else {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(76, parameterMap,
				// request,
				// response);
				// return responseMessage;
				// }

				// if (parameterMap.get("consent").equalsIgnoreCase("true")) {
				// if
				// (parameterMap.get("purchaseExist").equalsIgnoreCase("true"))
				// {
				// if (parameterMap.get("planId").isEmpty()) {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(81, parameterMap,
				// request, response);
				// return responseMessage;
				// } else {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(80, parameterMap,
				// request, response);
				// return responseMessage;
				// }
				// } else {
				// if (parameterMap.get("planId").isEmpty()) {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(76, parameterMap,
				// request, response);
				// return responseMessage;
				// } else {
				// ResponseEntity<?> responseMessage =
				// methodService.genericExecuteApiMethod(73, parameterMap,
				// request, response);
				// return responseMessage;
				// }
				// }
				//
				// } else {
				if (parameterMap.get("purchaseExist").equalsIgnoreCase("true")) {
					ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("81", parameterMap,
							request, response);
					return responseMessage;
				} else {
					ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("76", parameterMap,
							request, response);
					return responseMessage;
					// }

				}

			}
		} catch (Exception e) {
			/**
			 * If Exception Occur than to return Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		/**
		 * If Process Fails than to return Error Response
		 */
		return new ResponseEntity<>("issue occured", HttpStatus.BAD_REQUEST);
	}

}
