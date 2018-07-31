/**
 * This Package contains Services of Third Party Orchestration API.
 */
package org.thirdparty.services;

import java.lang.reflect.Type;
import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import org.orchestration.services.GenericMethodService;
import org.orchestration.services.OrchestrationGenericProcess;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thirdparty.request.model.Message;
import org.thirdparty.resources.JsonModification;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import com.google.gson.JsonParser;

import springfox.documentation.spring.web.json.Json;

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
	 * This API is to change SIM Profile on a device.
	 * 
	 * @param groupId
	 *            groupId to the patrticular API need to be called to be associated
	 *            to the subscriber
	 * @param map
	 *            Jasaon Parameter String need to call end notde API
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
	public ResponseEntity<?> genericCalling(Map<String, String> map, int groupId, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(groupId, request, response);
		try {

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
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			parameterMap.put("returnURL", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.putAll(map);
			if (!request.getMethod().equalsIgnoreCase("POST")) {
				parameterMap.put("tracking_message_header", String.valueOf(new Date().getTime()));

			}

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info(" parameterMap " + parameterMap);
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(groupId, parameterMap, request,
					response);

			logger.info("responseMessage " + responseMessage);

			if (responseMessage.getStatusCode().is5xxServerError()) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			/**
			 * Returning Response
			 */
			return responseMessage;
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			LinkedHashMap<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description",
					ErrorMessage.get("description").toString().concat(e.getMessage()));/**
																						 * Returning Response
																						 */

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

	public ResponseEntity<?> pushNotification(String notificationType, Object data, String kafka_type,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> pass = new LinkedHashMap<>();
			pass.put("status", notificationType);
			Message message = genericProcess.GenericThirdPartyProcedureCalling("4", pass, null, request, response);
			/**
			 * To Cast the data which need to push in kafka queue
			 */
			Type type = new TypeToken<List<Map<String, Object>>>() {
			}.getType();
			List<Map<String, Object>> dataToPush = (List<Map<String, Object>>) message.getObject();
			Map<String, String> passingMap = new LinkedHashMap<>();

			JsonModification.parse(data.toString(), passingMap);

			List<Map<String, Object>> templateData = getTemplateData(passingMap, request,
					String.valueOf(dataToPush.get(0).get("template")));

			/**
			 * Pushing Data in Kafka
			 */
			Boolean status = methodService.executeNotificationtoKafka(templateData, kafka_type, request, response);
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

	public ResponseEntity<?> simSuspendedNotification(Map<String, String> passingMap, String kafka_type,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			Message messageReturnUrl = genericProcess.GenericThirdPartyProcedureCalling("2", passingMap, null, request,
					response);
			System.out.println("return_url : " + messageReturnUrl.getObject());

			/**
			 * To Cast the data which need to push in kafka queue
			 */
			List<Map<String, Object>> returnUrl = (List<Map<String, Object>>) messageReturnUrl.getObject();

			Message message = genericProcess.GenericThirdPartyProcedureCalling("4", passingMap, null, request,
					response);
			/**
			 * To Cast the data which need to push in kafka queue
			 */
			List<Map<String, Object>> dataToPush = (List<Map<String, Object>>) message.getObject();

			String tempURL = "";
			String tempHeader = "";
			switch (passingMap.get("status")) {
			case "SIMSuspended":
				if (passingMap.get("trackingid").equalsIgnoreCase("null")
						|| passingMap.get("trackingid").equalsIgnoreCase("")) {
					tempURL = "/notifications/SIMSuspended";
					tempHeader = "'requestId':'" + passingMap.get("requestId") + "','IMSI':'" + passingMap.get("imsi")
							+ "'";

				} else {
					tempURL = "/notifications/SIMSuspended?trackingid=" + passingMap.get("trackingid");
					tempHeader = "'requestId':'" + passingMap.get("requestId") + "','TrackingId':'"
							+ passingMap.get("trackingid") + "','IMSI':'" + passingMap.get("imsi") + "'";
				}
				break;
			case "SIMReactivated":
				if (passingMap.get("trackingid").equalsIgnoreCase("null")
						|| passingMap.get("trackingid").equalsIgnoreCase("")) {
					tempURL = "/notifications/SIMReactivated";
					tempHeader = "'requestId':'" + passingMap.get("requestId") + "','IMSI':'" + passingMap.get("imsi")
							+ "'";
				} else {
					tempURL = "/notifications/SIMReactivated?trackingid=" + passingMap.get("trackingid");
					tempHeader = "'requestId':'" + passingMap.get("requestId") + "','TrackingId':'"
							+ passingMap.get("trackingid") + "','IMSI':'" + passingMap.get("imsi") + "'";
				}
				break;
			default:
				break;
			}

			passingMap.put("returnUrl", String.valueOf(returnUrl.get(0).get("return_url")).concat(tempURL));
			passingMap.put("returnHeader", tempHeader);

			List<Map<String, Object>> templateData = getTemplateData(passingMap, request,
					String.valueOf(dataToPush.get(0).get("template")));

			/**
			 * Pushing Data in Kafka
			 */
			Boolean status = methodService.executeNotificationtoKafka(templateData, kafka_type, request, response);
			/**
			 * Checking Kafka status and sending response accordingly
			 */
			if (status) {
				Message removeNotificationUrl = genericProcess.GenericThirdPartyProcedureCalling("1", passingMap, null,
						request, response);
				return new ResponseEntity<>("", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			/**
			 * Handling Exception If it comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private List<Map<String, Object>> getTemplateData(Map<String, String> passingMap, HttpServletRequest request,
			String template) {
		Pattern pattern = Pattern.compile("<.+?>");
		Matcher matcher = pattern.matcher(String.valueOf(template));
		StringBuffer sb = new StringBuffer();
		if (sb.length() == 0) {
			while (matcher.find()) {
				String match_case = matcher.group(0);

				if (passingMap.containsKey(match_case.replaceAll("[<,>]", ""))) {
					String match_case_value = String.valueOf(passingMap.get(match_case.replaceAll("[<,>]", "")));
					matcher.appendReplacement(sb, match_case_value);
				} else {
					String match_case_value = "";
					matcher.appendReplacement(sb, match_case_value);
				}

			}
			matcher.appendTail(sb);
		}
		Type type = new TypeToken<List<Map<String, Object>>>() {
		}.getType();
		List<Map<String, Object>> templateList = new Gson().fromJson(sb.toString(), type);
		return templateList;
	}

	public void getRequestData(HttpServletRequest request, HttpServletResponse response) {

		/**
		 * Inserting return url respective to request id in third party db
		 */

		Map<String, String> map = new LinkedHashMap<>();

		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnURL")));
		map.put("host_address", String.valueOf(request.getRemoteHost()));
		Message message = genericProcess.GenericThirdPartyProcedureCalling("3", map, null, request, response);

		logger.info("response " + message.getObject());
	}

	public ResponseEntity<?> getSimDetail(Map<String, String> map, int i, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(i, request, response);

		// System.out.println(map);

		if (map.get("iccid").equalsIgnoreCase("null") && map.get("imsi").equalsIgnoreCase("null")) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);

			LinkedHashMap<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("0");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description",
					ErrorMessage.get("description").toString().concat("iccid/imsi is mandatory"));

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			// Returning Response.
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
		} else if (map.get("iccid").equalsIgnoreCase("") && map.get("imsi").equalsIgnoreCase("")) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);

			Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("6");

			LinkedHashMap<String, Object> ErrorMessage = new LinkedHashMap<String, Object>(
					(LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString()
					.concat(" Value of ICCID/IMSI Mandatory parameter is missing"));
			/*
			 * List<Map<String, Object>> ErrorList = new LinkedList<>();
			 * ErrorList.add(ErrorMessage);
			 */
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			// Returning Response.
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
		} else if ((map.get("iccid").equalsIgnoreCase("null") && map.get("imsi").equalsIgnoreCase(""))
				|| (map.get("imsi").equalsIgnoreCase("null") && map.get("iccid").equalsIgnoreCase(""))) {

			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);

			Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("6");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString()
					.concat(" Value of ICCID/IMSI Mandatory parameter is missing"));

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			// Returning Response.
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
		}
		ResponseEntity<?> responseMessage;
		Map<String, String> responseParameterFromEndNode = new LinkedHashMap<>();
		if (!map.containsKey("iccid") || map.get("iccid").equalsIgnoreCase("null")
				|| map.get("iccid").equalsIgnoreCase("")) {

			responseMessage = genericCalling(map, i, request, response);

			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			}

			/**
			 * Calling OL Core to get Notification Template
			 */

			JsonModification.parse(String.valueOf(responseMessage.getBody()), responseParameterFromEndNode);

			map.putAll(responseParameterFromEndNode);
		}
		System.out.println("map " + map);
		ResponseEntity<?> ProfileMappingMessage = getProfileMappingData(17, map, request, response);
		if (!ProfileMappingMessage.getStatusCode().is2xxSuccessful()) {
			return ProfileMappingMessage;
		}

		Map<String, String> profileMappingresponseParameter = new LinkedHashMap<>();
		JsonModification.parse(String.valueOf(ProfileMappingMessage.getBody()), profileMappingresponseParameter);

		if (profileMappingresponseParameter.get("TYPE").equalsIgnoreCase("B")) {

			map.put("iccid", profileMappingresponseParameter.get("ICCID"));
			map.put("imsi", profileMappingresponseParameter.get("IMSI"));

			responseMessage = genericCalling(map, i, request, response);
			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			}
			Map<String, String> bootStrapresponseParameter = new LinkedHashMap<>();
			JsonModification.parse(String.valueOf(responseMessage.getBody()), bootStrapresponseParameter);
			responseParameterFromEndNode.putAll(bootStrapresponseParameter);

		} else {

			map.put("iccid", profileMappingresponseParameter.get("BootstrapICCID"));
			map.put("imsi", profileMappingresponseParameter.get("BootstrapIMSI"));

			responseMessage = genericCalling(map, i, request, response);

			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			}

			Map<String, String> bootStrapresponseParameter = new LinkedHashMap<>();
			JsonModification.parse(String.valueOf(responseMessage.getBody()), bootStrapresponseParameter);

			map.put("iccid", profileMappingresponseParameter.get("ICCID"));
			map.put("imsi", profileMappingresponseParameter.get("IMSI"));

			responseMessage = genericCalling(map, i, request, response);

			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			}

			Map<String, String> localActiveresponseParameter = new LinkedHashMap<>();
			JsonModification.parse(String.valueOf(responseMessage.getBody()), localActiveresponseParameter);

			responseParameterFromEndNode.putAll(localActiveresponseParameter);
			responseParameterFromEndNode.put("iccid", bootStrapresponseParameter.get("iccid"));
			responseParameterFromEndNode.put("imsi", bootStrapresponseParameter.get("imsi"));
			responseParameterFromEndNode.put("msisdn", bootStrapresponseParameter.get("msisdn"));

		}

		if (!responseMessage.getStatusCode().is2xxSuccessful()) {
			return responseMessage;
		}
		System.out.println("********************************************" + responseParameterFromEndNode);
		List<Map<String, Object>> templateMap = (List<Map<String, Object>>) methodService.getNotificationTemplate(i,
				request, response);
		StringBuffer responseStringBuilder = new StringBuffer();
		System.out.println("Template Data " + String.valueOf(templateMap.get(0).get("notifiation_template_template")));
		Pattern pattern = Pattern.compile("<.+?>");
		Matcher matcher = pattern.matcher(String.valueOf(templateMap.get(0).get("notifiation_template_template")));
		/**
		 * To set the template and store it in
		 */
		if (responseStringBuilder.length() == 0) {
			while (matcher.find()) {
				String match_case = matcher.group(0);
				if (responseParameterFromEndNode.containsKey(match_case.replaceAll("[<,>]", ""))) {
					String match_case_value = String
							.valueOf(responseParameterFromEndNode.get(match_case.replaceAll("[<,>]", "")));
					matcher.appendReplacement(responseStringBuilder, match_case_value);
				} else {
					String match_case_value = "";
					matcher.appendReplacement(responseStringBuilder, match_case_value);
				}
			}
			matcher.appendTail(responseStringBuilder);
		}
		// Casting String in Map to add in FinalResponse List
		Type listType = new TypeToken<Map<String, Object>>() {
		}.getType();
		System.out.println("********************************************" + String.valueOf(responseStringBuilder));
		Map<String, Object> urlResponseMessage = new Gson().fromJson(String.valueOf(responseStringBuilder), listType);
		System.out.println("Response Data " + responseMessage.getBody());
		System.out.println("urlResponseMessage Before Data " + urlResponseMessage);

		if (!responseParameterFromEndNode.containsKey("servicePlan")) {
			urlResponseMessage.remove("servicePlan");
		}
		System.out.println("urlResponseMessage After Data " + urlResponseMessage);
		return new ResponseEntity<>(urlResponseMessage, HttpStatus.OK);

	}

	public ResponseEntity<?> getUpdateDevice(Map<String, String> map, int i, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(14, request, response);
		try {
			ResponseEntity<?> responseMessage = genericCalling(map, 14, request, response);

			System.out.println("Map " + map);
			JsonModification.parse(String.valueOf(responseMessage.getBody()), map);
			if (responseMessage.getStatusCode().is2xxSuccessful()) {
				if (map.get("responseCode").equalsIgnoreCase("1")) {
					Map<String, Object> ErrorMessage = new LinkedHashMap<>();
					ErrorMessage.put("code", "UDD003");
					ErrorMessage.put("description", "Device Details Not found");

					/*
					 * List<Map<String, Object>> ErrorList = new LinkedList<>();
					 * ErrorList.add(ErrorMessage);
					 */
					Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
					FinalErrorMessageMap.put("errors", ErrorMessage);

					return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.NOT_FOUND);
				}
				if (map.get("responseCode").equalsIgnoreCase("2") || map.get("responseCode").equalsIgnoreCase("3")
						|| map.get("responseCode").equalsIgnoreCase("5")) {

					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} else {
				return responseMessage;
			}
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);

			Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));
			/*
			 * List<Map<String, Object>> ErrorList = new LinkedList<>();
			 * ErrorList.add(ErrorMessage);
			 */
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method is used for getting SIM details from the GControl.
	 * 
	 * @param map
	 *            : Here pass the map of parameters required to pass.
	 * @param apiGroupId
	 *            : Here pass the api_group_id for calling required API.
	 * @param request
	 * @param response
	 * @return
	 */
	public ResponseEntity<?> getSimStateDetail(Map<String, String> map, int apiGroupId, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get error codes related to SIM state API.
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(apiGroupId, request, response);

		try {
			if (map.get("iccid").equalsIgnoreCase("null") && map.get("imsi").equalsIgnoreCase("null")) {
				logger.setLevel(org.apache.log4j.Level.ERROR);
				logger.setPriority(Priority.ERROR);

				LinkedHashMap<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("0");

				Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				ErrorMessage.put("description",
						ErrorMessage.get("description").toString().concat("iccid/imsi is mandatory"));

				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorMessage);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
			} else if (map.get("iccid").equalsIgnoreCase("") && map.get("imsi").equalsIgnoreCase("")) {
				logger.setLevel(org.apache.log4j.Level.ERROR);
				logger.setPriority(Priority.ERROR);

				Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("6");

				LinkedHashMap<String, Object> ErrorMessage = new LinkedHashMap<String, Object>(
						(LinkedHashMap) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				ErrorMessage.put("description", ErrorMessage.get("description").toString()
						.concat("Value of ICCID/IMSI Mandatory parameter is missing"));
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorMessage);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
			} else if ((map.get("iccid").equalsIgnoreCase("null") && map.get("imsi").equalsIgnoreCase(""))
					|| (map.get("imsi").equalsIgnoreCase("null") && map.get("iccid").equalsIgnoreCase(""))) {

				logger.setLevel(org.apache.log4j.Level.ERROR);
				logger.setPriority(Priority.ERROR);

				Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("6");
				Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
				ErrorMessage.remove("priority");
				ErrorMessage.put("code", ErrorMessage.get("code"));
				ErrorMessage.put("description", ErrorMessage.get("description").toString()
						.concat("Value of ICCID/IMSI Mandatory parameter is missing"));
				Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
				FinalErrorMessageMap.put("errors", ErrorMessage);
				return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
			}
			ResponseEntity<?> responseMessage;
			Map<String, String> responseParameterFromEndNode = new LinkedHashMap<>();
			if (!map.containsKey("iccid") || map.get("iccid").equalsIgnoreCase("null")
					|| map.get("iccid").equalsIgnoreCase("")) {

				responseMessage = genericCalling(map, apiGroupId, request, response);

				if (!responseMessage.getStatusCode().is2xxSuccessful()) {
					return responseMessage;
				}

				/**
				 * Calling OL Core to get Notification Template
				 */

				JsonModification.parse(String.valueOf(responseMessage.getBody()), responseParameterFromEndNode);

				map.putAll(responseParameterFromEndNode);
			}
			System.out.println("map " + map);
			ResponseEntity<?> ProfileMappingMessage = getProfileMappingData(18, map, request, response);
			if (!ProfileMappingMessage.getStatusCode().is2xxSuccessful()) {
				return ProfileMappingMessage;
			}

			Map<String, String> profileMappingresponseParameter = new LinkedHashMap<>();
			JsonModification.parse(String.valueOf(ProfileMappingMessage.getBody()), profileMappingresponseParameter);

			map.put("iccid", profileMappingresponseParameter.get("ICCID"));
			map.put("imsi", profileMappingresponseParameter.get("IMSI"));

			responseMessage = genericCalling(map, apiGroupId, request, response);
			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			}
			Map<String, String> bootStrapresponseParameter = new LinkedHashMap<>();
			JsonModification.parse(String.valueOf(responseMessage.getBody()), bootStrapresponseParameter);
			responseParameterFromEndNode.putAll(bootStrapresponseParameter);

			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			} else if (responseMessage.getStatusCode().is5xxServerError()) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			/**
			 * Returning Response
			 */

			bootStrapresponseParameter.put("iccid", profileMappingresponseParameter.get("BootstrapICCID"));
			bootStrapresponseParameter.put("imsi", profileMappingresponseParameter.get("BootstrapIMSI"));

			return new ResponseEntity<>(bootStrapresponseParameter, HttpStatus.OK);
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);

			LinkedHashMap<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> suspendedSIM(Map<String, String> map, int group_id, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(group_id, request, response);
		try {
			ResponseEntity<?> responseMessage = getProfileMappingData(16, map, request, response);

			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			} else {
				JsonModification.parse(responseMessage.getBody().toString(), map);
				ResponseEntity<?> responseReactivateSimMessage = genericCalling(map, group_id, request, response);

				return responseReactivateSimMessage;
			}

		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);

			Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> reactivateSim(Map<String, String> map, int i, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(11, request, response);
		try {
			ResponseEntity<?> responseMessage = getProfileMappingData(15, map, request, response);

			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
				return responseMessage;
			} else {
				JsonModification.parse(responseMessage.getBody().toString(), map);
				ResponseEntity<?> responseReactivateSimMessage = genericCalling(map, 11, request, response);

				return responseReactivateSimMessage;
			}

		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);

			Map<String, Object> ErrorMessageMap = (LinkedHashMap<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new LinkedHashMap<String, Object>((LinkedHashMap) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString().concat(e.getMessage()));

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorMessage);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> getProfileMappingData(int group_id, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errorMap = methodService.getErrorCodes(group_id, request, response);
		try {
			logger.info(
					"***********************************Publish Profile MappingResp API *****************************************************");

			logger.info("Getting Data from Esim  By calling PublishProfileMappingResp");
			parameterMap.put("country", "NILL");

			ResponseEntity<?> checkProfileExistence = genericCalling(parameterMap, group_id, request, response);
			if (!checkProfileExistence.getStatusCode().is2xxSuccessful()) {

				/**
				 * Returning Response
				 */

				logger.info(
						"***********************************API End*****************************************************");
				return checkProfileExistence;
			}
			System.out.println("checkProfileExistence Response -->" + checkProfileExistence.getBody());

			Map<String, String> profileMappingResponseParameter = JsonModification
					.parse(checkProfileExistence.getBody().toString(), new LinkedHashMap<>());
			logger.info("Response Data from Esim  By calling PublishProfileMappingResp : \n"
					+ profileMappingResponseParameter);

			parameterMap.put("responseCode", profileMappingResponseParameter.get("responseCode"));

			/**
			 * To parse the requestBody parameter in MAP <String,String> format
			 */

			logger.info("responseCode from Esim  By calling PublishProfileMappingResp::"
					+ profileMappingResponseParameter.get("responseCode"));
			if (!profileMappingResponseParameter.get("responseCode").equalsIgnoreCase("0")) {

				if (parameterMap.get("responseCode").equalsIgnoreCase("1")) {
					Map<String, Object> ErrorMessage = new LinkedHashMap<>();
					ErrorMessage.put("code", "UDD003");
					ErrorMessage.put("description", "Device Details Not found");

					/*
					 * List<Map<String, Object>> ErrorList = new LinkedList<>();
					 * ErrorList.add(ErrorMessage);
					 */
					Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
					FinalErrorMessageMap.put("errors", ErrorMessage);

					return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.NOT_FOUND);
				}
				if (parameterMap.get("responseCode").equalsIgnoreCase("2")
						|| parameterMap.get("responseCode").equalsIgnoreCase("3")
						|| parameterMap.get("responseCode").equalsIgnoreCase("5")) {

					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

			/**
			 * To get List of ImsiProfileData to fetch ICCID State
			 */
			String ImsiProfileData = profileMappingResponseParameter.get("ImsiProfileData").replace(":,", ":\"\",")
					.replace(":}", "\"\"}");

			/**
			 * Parse ImsiProfileData in json format
			 */
			String ImsiProfileDataJson = new JsonParser().parse(ImsiProfileData).toString();
			/**
			 * Initialize List to get ImsiProfileData
			 */
			List<Map<String, String>> ImsiProfileDataList = new LinkedList<>();
			/**
			 * To check ImsiProfileData is Array of json object
			 */
			if (String.valueOf(ImsiProfileData).startsWith("[{") && String.valueOf(ImsiProfileData).endsWith("}]")) {
				/**
				 * Define type to format ImsiProfileData in List of Map
				 */
				Type listType = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				ImsiProfileDataList = new Gson().fromJson(ImsiProfileDataJson, listType);
			}
			/**
			 * To check ImsiProfileData is json object
			 */
			if ((String.valueOf(ImsiProfileData).startsWith("{") && String.valueOf(ImsiProfileData).endsWith("}"))) {

				Type listType = new TypeToken<Map<String, String>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				Map<String, String> ImsiProfileDataMap = new Gson().fromJson(ImsiProfileDataJson, listType);
				ImsiProfileDataList.add(ImsiProfileDataMap);

			}
			StringBuilder builder = new StringBuilder();
			/**
			 * Iterating List to get the Iccid state which has been Passed
			 */

			for (Map<String, String> map2 : ImsiProfileDataList) {
				/**
				 * To get the state of iccid being passed by user.
				 */
				if (String.valueOf(map2.get("STATE")).equalsIgnoreCase("A")) {
					/**
					 * If iccid matches than add all parameter of that iccid in parameter map
					 */

					parameterMap.putAll(map2);

					logger.info("Active Profile Data : " + map2);

				}
				/**
				 * To get the bootstrap iccid to call profile switch API
				 */
				if (String.valueOf(map2.get("TYPE")).equalsIgnoreCase("B")) {

					parameterMap.put("BootstrapICCID", String.valueOf(map2.get("ICCID")));
					parameterMap.put("BootstrapIMSI", String.valueOf(map2.get("IMSI")));
					logger.info("BootstrapICCID : " + String.valueOf(map2.get("ICCID")));
				}
				if (String.valueOf(map2.get("TYPE")).equalsIgnoreCase("L")) {

					builder.append(String.valueOf(map2.get("ICCID")) + ",");

				}
			}
			if (builder.toString().contains(",")) {
				builder.deleteCharAt(builder.lastIndexOf(","));
			}

			parameterMap.put("localICCID", builder.toString());
			logger.info("localICCID : " + parameterMap.get("localICCID"));

			if (parameterMap.get("STATE") == null) {

				logger.info("STATE is  " + parameterMap.get("STATE"));
				logger.setLevel(org.apache.log4j.Level.ERROR);

				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<String, Object>((Map) errorMessageMap);
				errorMessage.remove("priority");
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put("description",
						errorMessage.get("description").toString().concat(" ICCID is not configured at End Node."));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(
						"***********************************API End*****************************************************");
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			logger.info(
					"***********************************API End*****************************************************");
			return new ResponseEntity<>(new Gson().toJson(parameterMap), HttpStatus.ACCEPTED);
		} catch (

		Exception e) {
			/**
			 * Handle Exception If it Occurs
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Publish Profile MappingResp API ERROR Exception", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<String, Object>((Map) errorMessageMap);
			errorMessage.remove("priority");
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put("description", errorMessage.get("description").toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(
					"***********************************API End*****************************************************");
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}