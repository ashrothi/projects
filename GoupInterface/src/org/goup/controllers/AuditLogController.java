/**
 * This Package contains controllers of Third Party Orchestration API.
 */
package org.goup.controllers;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.services.AuditServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class use as @Controller to call all API's Defined In Orchestration
 * Interface for getting Audit Logs responses
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@ApiIgnore
public class AuditLogController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private AuditServices auditServices;

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
	@ApiOperation(value = "/get/all/audit/log", notes = "Returns all the logs for the specific application between the start date and end date provided by user and the application will be recognized by the token entered by the user.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_time", value = "Here pass start time i.e. initial time from which user wants to get log", required = true, access = "query", paramType = "query", dataType = "long"),
			@ApiImplicitParam(name = "end_time", value = "Here pass end time i.e the time till which user wants to get logs ", required = true, access = "query", paramType = "query", dataType = "long") })

	@RequestMapping(value = "/get/all/audit/log", method = RequestMethod.POST)
	public ResponseEntity<?> notificationAuditbyToken(@RequestParam long start_time, @RequestParam long end_time,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */

		ResponseEntity<?> responseMessage = auditServices.auditLogGetAll(String.valueOf(start_time / 1000),
				String.valueOf(end_time / 1000), request, response);
		return responseMessage;
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
	@ApiOperation(value = "/audit/log/by/id", notes = "This api returns all the logs for the specific application on the basis of Log Id which was returned when any notification api was called as log_id.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "log_id", value = "Here pass the notification id i.e. the notification_id user gets at the time of calling any notification api.", required = true, access = "query", paramType = "query", dataType = "long") })

	@RequestMapping(value = "/audit/log/by/id", method = RequestMethod.POST)
	public ResponseEntity<?> notificationAuditLogByLogId(@RequestParam String log_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */

		ResponseEntity<?> responseMessage = auditServices.auditLogGetById(log_id, request, response);
		return responseMessage;
	}

}
