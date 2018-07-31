/**
 * This package contain the controller class for audit logs.
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.AuditLogCountSwagger;
import com.springiot.swagger.response.AuditLogGetSwagger;
import com.springiot.swagger.response.AuditLogInsertSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for audit logs.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "Hero Application Audit Controller")
public class AuditController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Call /audit/log/get/all Api to get all Auditt Log
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/get/all", notes = "Returns all the logs for the specific application", response = AuditLogGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/get/all", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAll(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("61", map, null);
		return message;
	}

	/**
	 * To call /audit/log/insert which Helps to insert logs of the user for the
	 * particular application
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/insert", notes = "Helps to insert logs of the user for the particular application", response = AuditLogInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "controller_name", value = "Requires the controller name ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "input_parameters", value = "Requires the Input Parameter", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ip_address", value = "Requires the IP Address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "url_accessed", value = "Requires the URL which needs to be accessed", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "session_id", value = "Requires the Session ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "log_type", value = "Requires the log type", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/insert", method = RequestMethod.POST)
	public @ResponseBody Message auditLogInsert(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("60", map, null);
		return message;
	}

	/**
	 * To call /audit/log/get/all/limit which Helps to get logs of the user for
	 * the particular limit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/get/all/limit", notes = "Helps to get logs of the user for the particular limit", response = AuditLogGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the Limit of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the OffSet of logs from where you want the details", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("62", map, null);
		return message;
	}

	/**
	 * To Call /audit/log/count which Helps to get Count of logs for the user of
	 * there particular application
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/count", notes = "Helps to get Count of logs for the user of there particular application", response = AuditLogCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/count", method = RequestMethod.POST)
	public @ResponseBody Message auditLogCount(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("63", map, null);
		return message;
	}

}
