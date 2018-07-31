/**
 * This Package contains Services of Third Party Orchestration API.
 */
package org.goup.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This class use as Service to get ALL the AUdit log on the basis of dates or log_id.
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class AuditServices {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	Environment environment;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	Logger logger = Logger.getLogger(AuditServices.class);
	/**
	 * Method to get Logs application wise on the basis of their user_name between the
	 * given dates
	 * 
	 * @param map
	 *            Contains start_time and end_time
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
	public ResponseEntity<?> auditLogGetAll(String start_date, String end_date, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		 * Putting Additional Parameter in MAP which will be used by OL core to
		 * send the call to endnodes.
		 */
		parameterMap.put("start_date", start_date);
		parameterMap.put("end_date", end_date);
		/**
		 * Calling OL Core genericExecuteApiMethod Method to execute the API
		 */
		ResponseEntity<?> responseMessage = methodService.auditLogByUser(map.get("user_name"), start_date, end_date,
				request, response);
		/**
		 * Returning Response
		 */
		return responseMessage;

	}
	/**
	 * Method to get Logs log_id wise
	 * 
	 * @param map
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
	public ResponseEntity<?> auditLogGetById(String tracking_message_header, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		 * Putting Additional Parameter in MAP which will be used by OL core to
		 * send the call to endnodes.
		 */
		parameterMap.put("tracking_message_header", tracking_message_header);
		/**
		 * Calling OL Core genericExecuteApiMethod Method to execute the API
		 */
		ResponseEntity<?> responseMessage = methodService.auditLogById(tracking_message_header, request, response);
		/**
		 * Returning Response
		 */
		return responseMessage;

	}
}
