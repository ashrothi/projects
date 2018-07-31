/**
 * This package contains the Controller for GMR Application.
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.springiot.services.DownloadServices;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Reports.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class ReportController {
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private DownloadServices downloadServices;

	/**
	 * To get Content of Trip Summary Report
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
	@ApiOperation(value = "/gmr/get/report/trip/summary", notes = "To get Content of Trip Summary  Report ", response = GmrGetReportTripSummarySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/report/trip/summary", method = RequestMethod.POST)
	public @ResponseBody Message tripSummaryReport(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("6", map, null, request, response);
		return message;
	}

	/**
	 * To get Content of Vehicle Detail Report
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
	@ApiOperation(value = "/gmr/get/report/vehicle/details", notes = "To get Content of Vehicle Detail  Report ", response = GmrGetReportVehicleDetailsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/report/vehicle/details", method = RequestMethod.POST)
	public @ResponseBody Message vehicleDetailReport(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("7", map, null, request, response);
		return message;
	}

	/**
	 * To get Content of Alert Report
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
	@ApiOperation(value = "/gmr/get/report/alerts", notes = "To get Content of Alert  Report ", response = GmrGetReportAlertsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/report/alerts", method = RequestMethod.POST)
	public @ResponseBody Message alertStatusReport(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		// map.put("from_date", covertFromEpoch(map.get("from_date")));
		// map.put("end_date", covertFromEpoch(map.get("end_date")));
		Message message = genericProcess.GenericProcedureCalling("8", map, null, request, response);
		return message;
	}

	private String covertFromEpoch(String string) {
		String dateString = string;
		Date d = new Date(Long.parseLong(dateString));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formatted = format.format(d);
		System.out.println(formatted);
		return formatted;
	}

	/**
	 * To get Content of Trip Summary Report
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
	@ApiOperation(value = "/gmr/get/report/download", notes = "To get Content of Trip Summary  Report ", response = GmrGetReportDownloadSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "request_type ", value = "Requires request_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "report_name ", value = "Requires report_name", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/report/download", method = RequestMethod.POST)
	public @ResponseBody Message tripSummaryReportDownload(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		map.put("from_date", covertFromEpoch(map.get("from_date")));
		map.put("end_date", covertFromEpoch(map.get("end_date")));
		Message message = downloadServices.DownloadGenericProcedureCalling(map, request, response);
		return message;
	}

	/**
	 * To get Content of Report Alert Graph
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
	@ApiOperation(value = "/gmr/get/report/alert/graph", notes = "To get Content of Report Alert Graph", response = GmrGetReportAlertGraphSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit ", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/report/alert/graph", method = RequestMethod.POST)
	public @ResponseBody Message gmrGetReportAlertGraph(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("9", map, null, request, response);

		return message;
	}

	/**
	 * To get Content of Report Trip Summary Graph
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
	@ApiOperation(value = "/gmr/get/report/trip/summary/graph", notes = "To get Content of Report Trip Summary Graph", response = GmrGetReportTripSummaryGraphSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit ", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/report/trip/summary/graph", method = RequestMethod.POST)
	public @ResponseBody Message gmrGetReportTripSummaryGraph(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("10", map, null, request, response);

		return message;
	}
}
