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
import com.google.gson.Gson;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.*;

/**
 * 
 * This class work as a controller which is used to create apis for audit logs.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class AuditController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get all the logs for the specific application.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/get/all", notes = "Returns all the logs for the specific application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/get/all", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("3", map, null, request, response);
		System.out.println(new Gson().toJson(message));
		return message;
	}

	/**
	 * To insert logs of the user for the particular application
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/insert", notes = "Helps to insert logs of the user for the particular application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "controller_name", value = "Requires the controller name ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "input_parameters", value = "Requires the Input Parameter", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ip_address", value = "Requires the IP Address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "url_accessed", value = "Requires the URL which needs to be accessed", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "session_id", value = "Requires the Session ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "log_type", value = "Requires the log type", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/insert", method = RequestMethod.POST)
	public @ResponseBody Message auditLogInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("5", map, null, request, response);
		return message;
	}

	/**
	 * To get all the audit logs with limit.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/get/all/limit", notes = "Retrive all the audit logs with limit")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the Limit of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the OffSet of logs from where you want the details", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("4", map, null, request, response);
		return message;
	}

	/**
	 * To get count of logs for the user of there particular application.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/audit/log/count", notes = "Helps to get Count of logs for the user of there particular application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/audit/log/count", method = RequestMethod.POST)
	public @ResponseBody Message auditLogCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("2", map, null, request, response);
		return message;
	}

}