/**
 * This package contain the controller class for API calling ans publish response for each API. 
 * The swagger document is also initialized in this package which will list down all the API categorized by their controller. 
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
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to create apis for for audit
 * logs.
 */

@Controller
public class AuditController {
	/**
	 * To access functionality of GenericProcess service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get all the logs for the specific application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/audit/log/get/all", notes = "Returns all the logs for the specific application", response = XfusionAuditLogGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/audit/log/get/all", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAll(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("52", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * To get all the audit logs with limit.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/audit/log/get/all/limit", notes = "To get all the audit logs with limit.", response = XfusionAuditLogGetAllLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the Limit of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the OffSet of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/audit/log/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAllLimit(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("56", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * To get count of logs for the user of there particular application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/audit/log/count", notes = "Helps to get Count of logs for the user of there particular application", response = XfusionAuditLogCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires Application Key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the Start Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date of logs from where you want the details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/audit/log/count", method = RequestMethod.POST)
	public @ResponseBody Message auditLogCount(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("57", Map, request, response);

		// return the response
		return message;
		// }
	}
}