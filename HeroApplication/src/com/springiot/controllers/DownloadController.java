/**
 * This package contain the controller class for Download Reports.
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
import com.springiot.services.DownloadPDFService;
import com.springiot.services.DownloadServices;
import com.springiot.swagger.response.DownloadDailyHornReportSwagger;
import com.springiot.swagger.response.DownloadDailyLockReportSwagger;
import com.springiot.swagger.response.DownloadDailyPlannerExcelReportSwagger;
import com.springiot.swagger.response.DownloadDailyPlannerReportSwagger;
import com.springiot.swagger.response.DownloadDailyRelayReportSwagger;
import com.springiot.swagger.response.DownloadDailySideStandReportSwagger;
import com.springiot.swagger.response.DownloadSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Download
 * Reports.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "Hero Application for Downloading the files ")
public class DownloadController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private DownloadServices downloadServices;

	@Autowired
	private DownloadPDFService downloadPDFService;

	/**
	 * To Download Excel file from the respective API's by entering their
	 * request type and parameters to call the API
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download", notes = "To Download Excel file from the respective API's by entering their request type and parameters to call the API",response=DownloadSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "requestType", value = "Required Request Type ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "operation_parameter", value = "Required Parameter to call that particular api to get its data.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public @ResponseBody Message componentGetSettingHistory(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = downloadServices.DownloadGenericProcedureCalling(map);
		return message;
	}

	/**
	 * To Download File Of Daily Report Of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/horn/report", notes = "To Download File Of Daily Report Of Horn",response=DownloadDailyHornReportSwagger.class)
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
	@RequestMapping(value = "/download/daily/horn/report", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyReportHorn(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = downloadServices.downloadDailyReportHorn(map);
		return message;
	}

	/**
	 * To Download File Of Daily Report Of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/relay/report", notes = "To Download File Of Daily Report Of Relay",response=DownloadDailyRelayReportSwagger.class)
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
	@RequestMapping(value = "/download/daily/relay/report", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyReportRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = downloadServices.downloadDailyReportRelay(map);
		return message;
	}

	/**
	 * To Download File Of Daily Report Of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/side/stand/report", notes = "To Download File  Of Daily Report Of Side Stand",response=DownloadDailySideStandReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Required Page", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Required Page Size", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/side/stand/report", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyReportSS(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = downloadServices.downloadDailyReportSS(map);
		return message;
	}

	/**
	 * To Download File Of Planner Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/planner/report", notes = "To Download File  Of  Planner Report",response=DownloadDailyPlannerReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_number", value = "Required Planner Number ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "download_bit", value = "Required download_bit", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/planner/report", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyPlanner(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = downloadPDFService.downloadDailyPlanner(map, req, res);
		return message;
	}

	/**
	 * To Download File Of Excel Planner Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/planner/excel/report", notes = "To Download File  Of Excel Planner Report",response=DownloadDailyPlannerExcelReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_number", value = "Required Planner Number ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/planner/excel/report", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyExcelPlanner(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = downloadServices.downloadDailyPlanner(map, req, res);
		return message;
	}

	/**
	 * To Download File Of Lock Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/download/daily/lock/report", notes = "To Download File  Of Lock Report",response=DownloadDailyLockReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Required Page", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Required Page Size", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/download/daily/lock/report", method = RequestMethod.POST)
	public @ResponseBody Message downloadDailyExcelReportLock(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = downloadServices.downloadDailyExcelReportLock(map);
		return message;
	}

}
