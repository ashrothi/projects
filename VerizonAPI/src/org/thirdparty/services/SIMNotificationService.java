/**
 * This Package contains Services of Verizon API.
 */
package org.thirdparty.services;

import java.lang.reflect.Type;
import java.util.Collection;
/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@SuppressWarnings({ "unused" })
public class SIMNotificationService {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericMethodService methodService;
	@Autowired
	private OrchestrationGenericProcess orchestrationGenericProcess;
	@Autowired
	private GenericProcess genericProcess;

	@SuppressWarnings("unchecked")
	public ResponseEntity<?> simActivated(String notificationData, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			/**
			 * 
			 * /** Defining parameter Map which will be passing to OL core for
			 * validation and transformation and pushing data in kafka queue for
			 * ASYNC APIs or for SYNC API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core
			 * to send the call to endnodes.
			 */

			JsonModification.parse(notificationData, parameterMap);

			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("country", "IN");

			System.out.println("parameterMap " + parameterMap);
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			List<Map<String, Object>> dataToPush = new LinkedList<>();
			Message message = genericProcess.GenericProcedureCalling("2", parameterMap, null, request, response);
			if (message.isValid()) {

				dataToPush = (List<Map<String, Object>>) message.getObject();
				dataToPush.get(0).putAll(parameterMap);
			}

			List<Map<String, Object>> tokenResponse = new LinkedList<>();
			tokenResponse.add(dataToPush.get(0));

			Boolean status = methodService.executeNotificationtoKafka(tokenResponse, "notification_publisher", request,
					response);
			/**
			 * Returning Response
			 */
			if (status) {
				return new ResponseEntity<>(notificationData, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>("Error Occured", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * Returning Response
			 */
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
