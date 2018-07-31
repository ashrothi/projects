/**
 * This package contain the controller class for audit logs.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logging.retrievalLogs.RetrievalLogs;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         apis for for audit logs.
 */
@Controller
public class AuditController {
	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To get all the logs for the specific application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Retrieve audit logs for specific application", notes = "Returns all the logs for the specific application", response = AuditLogGetAllLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires User id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/audit/log/get/all", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

//		Integer organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
//		map.put("organization_id", organizationId.toString());

		RetrievalLogs retrievalLogs = new RetrievalLogs();
		Object object = retrievalLogs.GenericProcedureForLogs("109", map, request, response, genericProcess,
				"GenericProcedureLogs", String.class, Map.class, HttpServletRequest.class, HttpServletResponse.class);

		Message message = (Message) object;
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get all the audit logs with limit.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Retrieve audit logs for specific application with limit", notes = "Retrive all the audit logs with limit", response = AuditLogGetAllLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the Limit of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the OffSet of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/audit/log/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		Integer organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
//		map.put("organization_id", organizationId.toString());

		/*
		 * To call the procedure required for data processing.
		 */

		RetrievalLogs retrievalLogs = new RetrievalLogs();
		Object object = retrievalLogs.GenericProcedureForLogs("110", map, request, response, genericProcess,
				"GenericProcedureLogs", String.class, Map.class, HttpServletRequest.class, HttpServletResponse.class);

		Message message = (Message) object;

		// Message message = genericProcess.GenericProcedureCalling("110",
		// map, request, response);

		return message;
		
	}

	/**
	 * To get count of logs for the user of there particular application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Retrieve the count of audit log on the basis of specific application", notes = "Helps to get count of audit logs for the user of their particular application", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/audit/log/count", method = RequestMethod.POST)
	public @ResponseBody Message auditLogCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		// Integer organizationId =
		// Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
		// map.put("organization_id", organizationId.toString());

		/*
		 * To call the procedure required for data processing.
		 */
		RetrievalLogs retrievalLogs = new RetrievalLogs();
		Object object = retrievalLogs.GenericProcedureForLogs("111", map, request, response, genericProcess,
				"GenericProcedureLogs", String.class, Map.class, HttpServletRequest.class, HttpServletResponse.class);

		Message message = (Message) object;

		/*
		 * Return the response message.
		 */
		return message;
		
	}
}
