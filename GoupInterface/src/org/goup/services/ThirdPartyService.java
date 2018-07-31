/**
 * This Package contains Services of Third Party Orchestration API.
 */
package org.goup.services;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.goup.request.model.Message;
import org.goup.resources.JsonModification;
import org.orchestration.response.model.OrchestrationMessage;
import org.orchestration.services.GenericMethodService;
import org.orchestration.services.OrchestrationGenericProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import scala.util.parsing.combinator.testing.Str;

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
			logger.info(
					"***********************************Pushing Notification to Kafka Queue API*****************************************************");
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
			logger.info("Data Pushing to kafka Status " + status);

			if (status) {
				logger.info(
						"***********************************API End*****************************************************");
				return new ResponseEntity<>("True", HttpStatus.ACCEPTED);
			} else {
				logger.info(
						"***********************************API End*****************************************************");
				return new ResponseEntity<>("False", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			/**
			 * Handling Exception If it comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("Pushing Notification to Kafka Queue API ERROR Exception", e);
			logger.info(
					"***********************************API End*****************************************************");
			return new ResponseEntity<>("False", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> gcProfileSwitch(String data, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To get gc Profile Switch API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("62", request, response);
		try {
			logger.info(
					"***********************************GControl Profile Switch API*****************************************************");

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

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info("Calling Gcontrol API for Property changed after ESim Profile Switch Completed");
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("62", parameterMap, request,
					response);
			/**
			 * Returning Response
			 */
			if (responseMessage.getStatusCode().is2xxSuccessful()) {
				Message message = genericProcess.GenericProcedureCalling("1", parameterMap, null, request, response);
			}
			logger.info(responseMessage);
			logger.info(
					"***********************************API End*****************************************************");
			return responseMessage;
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("GControl Profile Switch  API ERROR Exception", e);

			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description",
					ErrorMessage.get("description").toString().concat(e.getMessage()));/**
																						 * Returning Response
																						 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			logger.info(FinalErrorMessageMap);
			logger.info(
					"***********************************API End*****************************************************");
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
