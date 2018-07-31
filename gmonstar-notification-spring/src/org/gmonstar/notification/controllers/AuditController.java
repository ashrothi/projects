/**
 * This package contain the controller class of  GlobeTouch Application
 */
package org.gmonstar.notification.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gmonstar.notification.response.model.Message;
import org.gmonstar.notification.services.GenericProcess;
import org.gmonstar.notification.swagger.response.AuditLogResponseSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * This class work as a controller which is used to create apis for audit logs.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class AuditController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which Here pass less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * API to get Logs application wise on the basis of their token between the
	 * given dates
	 * 
	 * @param map
	 *            Contains start_time and end_time
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/get/audit/log", notes = "Returns all the logs for the specific application between the start date and end date provided by user and the application will be recognized by the token entered by the user.", response = AuditLogResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token generated to access API in headers", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_time", value = "Here pass start time i.e. initial time from which user wants to get log", required = true, access = "query", paramType = "query", dataType = "long"),
			@ApiImplicitParam(name = "end_time", value = "Here pass end time i.e the time till which user wants to get logs ", required = true, access = "query", paramType = "query", dataType = "long") })

	@RequestMapping(value = "/get/audit/log", method = RequestMethod.POST)
	public @ResponseBody Message notificationAuditbyToken(@RequestParam long start_time, @RequestParam long end_time,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Map<String, String> map = new LinkedHashMap<>();
		map.put("start_time", String.valueOf(start_time / 1000));
		map.put("end_time", String.valueOf(end_time / 1000));
		Message message = genericProcess.GenericProcedureCalling("5", map, null, request, response);
		return message;
	}

	/**
	 * API to get Logs log_id wise
	 * 
	 * @param map
	 *            Contains log_id to gets its all logs
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/audit/log/by/id", notes = "This api returns all the logs for the specific application on the basis of Log Id which was returned when any notification api was called as notification_id.", response = AuditLogResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token generated to access API in headers", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "notification_id", value = "Here pass the notification id i.e. the notification_id user gets at the time of calling any notification api.", required = true, access = "query", paramType = "query", dataType = "long") })

	@RequestMapping(value = "/audit/log/by/id", method = RequestMethod.POST)
	public @ResponseBody Message notificationAuditLogByLogId(@RequestParam long notification_id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */Map<String, String> map = new LinkedHashMap<>();
		map.put("log_id", String.valueOf(notification_id));

		Message message = genericProcess.GenericProcedureCalling("4", map, null, request, response);
		return message;
	}
}
