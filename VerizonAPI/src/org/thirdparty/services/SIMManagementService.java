/**
 * This Package contains Services of Verizon API.
 */
package org.thirdparty.services;

import java.lang.reflect.Type;
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
public class SIMManagementService {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	@Autowired(required = true)
	private OrchestrationGenericProcess orchestrationGenericProcess;

	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This Method is to change SIM Profile on a device.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created
	 *            for the subscriber
	 * @param simProfileData
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
	public ResponseEntity<?> activateSIM(String deviceId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			/**
			 * To get user_name and password from the encoded string coming in
			 * header in parameter name Authorization
			 */
			Map<String, String> map = AuthService.authenticate(request.getHeader("Authorization"));
			/**
			 * Set attribute of user_name and password in request which will be
			 * access by OL core.
			 */
			request.setAttribute("user_name", map.get("user_name"));
			request.setAttribute("password", map.get("password"));

			/**
			 * Defining parameter Map which will be passing to OL core for
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

			parameterMap.put("ICCID", deviceId);
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("country", "IN");

			System.out.println("parameterMap " + parameterMap);
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			/**
			 * Inserting return url respective to request id in third party db
			 */
			Message message = genericProcess.GenericProcedureCalling("3", parameterMap, null, request, response);

			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(1, parameterMap, request,
					response);
			/**
			 * Returning Response
			 */
			return responseMessage;

		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * Returning Response
			 */
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
