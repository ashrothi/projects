/**
 * This package contain the controller class for Download Reports  Escalation..
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
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
import com.springiot.services.EscalationDownloadServices;
import com.springiot.swagger.response.GenericDownloadReportsEscalationSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Download
 * Reports Escalation.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class EscalationDownload {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private EscalationDownloadServices escalationDownloadServices;

	/**
	 * To Send Downloaded File Of Daily Report Of Horn with Escalation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/horn/report/Escalation", notes = "To Send Downloaded File Of Daily Report Of Horn with Escalation",response=GenericDownloadReportsEscalationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Required Page", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Required Page Size", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/horn/report/Escalation", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyReportHorn(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = escalationDownloadServices.downloadDailyReportHorn(map);
		return message;
	}

	/**
	 * To Send Downloaded File Of Daily Report Of Relay with Escalation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/relay/report/Escalation", notes = "To Send Downloaded File Of Daily Report Of Relay with Escalation",response=GenericDownloadReportsEscalationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Required Page", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Required Page Size", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/relay/report/Escalation", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyReportRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = escalationDownloadServices.downloadDailyReportRelay(map);
		return message;
	}

	/**
	 * To send Downloaded File Of Daily Report Of Side Stand with Escalation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/side/stand/report/Escalation", notes = "To send  Downloaded File Of Daily Report Of Side Stand with Escalation",response=GenericDownloadReportsEscalationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Required Page", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Required Page Size", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/side/stand/report/Escalation", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyReportSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = escalationDownloadServices.downloadDailyReportSideStand(map);
		return message;
	}

	/**
	 * To send Downloaded File Of Daily Report Of Planner with Escalation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/planner/report/Escalation", notes = "To send Downloaded File Of Daily Report Of Planner with Escalation",response=GenericDownloadReportsEscalationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_number", value = "Required Planner Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/planner/report/Escalation", method = RequestMethod.POST)
	public @ResponseBody Message downloadPlannerReport(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = escalationDownloadServices.downloadPlannerReport(map, req, res);
		return message;
	}

}
