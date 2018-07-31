/**
 * This Package contains Services of Orchestration API calling.
 */
package com.springiot.services;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springiot.services.GenericProcess;

import com.springiot.request.model.Message;

/**
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Mandeep Singh
 */
@Service
public class InterfaceServices {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This API is to change SIM Profile on a device.
	 * 
	 * @param groupId
	 *            groupId to the particular API need to be called to be
	 *            associated to the subscriber
	 * @param map
	 *            Json Parameter String need to call end node API
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
	@SuppressWarnings("unchecked")
	public ResponseEntity<?> genericCalling(Map<String, String> map, String groupId, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("map:: " + map);
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes(groupId, request, response);
		try {

			/**
			 * Defining parameter Map which will be passing to OL core for
			 * validation and transformation and pushing data in kafka queue for
			 * ASYNC APIs or for SYNC API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core
			 * to send the call to endnodes.
			 */
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			parameterMap.put("country", map.get("countryCode"));
			parameterMap.put("tracking_message_header", String.valueOf(new Date().getTime()));
			parameterMap.putAll(map);

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			System.out.println(" parameterMap " + parameterMap);
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(groupId, parameterMap, request,
					response);

			System.out.println("responseMessage " + responseMessage);
			/**
			 * Returning Response
			 */
			return responseMessage;
		} catch (Exception e) {
			System.out.println("Error: " + e);

			Map<String, Object> ErrorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map) ErrorMessageMap);
			ErrorMessage.remove("priority");
			ErrorMessage.put("code", ErrorMessage.get("code"));
			ErrorMessage.put("description", ErrorMessage.get("description").toString()
					.concat(e.getMessage()));/**
												 * Returning Response
												 */
			List<Map<String, Object>> ErrorList = new LinkedList<>();
			ErrorList.add(ErrorMessage);
			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			FinalErrorMessageMap.put("errors", ErrorList);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
