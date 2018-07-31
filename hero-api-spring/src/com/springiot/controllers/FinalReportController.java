/**
 * This package contain the controller class for Download FINAL Reports.
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
import com.springiot.services.FinalReportServices;
import com.springiot.swagger.response.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * This class work as a controller which is used to create apis for Download
 * Final Reports Escalation when it will be called.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "File Report Process.")
public class FinalReportController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private FinalReportServices finalReportServices;

	/**
	 * To Submit the Final Report to Get Pdf of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/horn/final/report", notes = "To Submit the Final Report to Get Pdf Of Horn ",response=SubmitHornFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number", value = "Required test_number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/submit/horn/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitHornFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {

		Message message = finalReportServices.submitHornFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/shower/final/report", notes = "To Submit the Final Report to Get Pdf of Shower",response=SubmitShowerFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/shower/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitShoweFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitShowerFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/relay/final/report", notes = "To Submit the Final Report to Get Pdf of Relay",response=SubmitRelayFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/relay/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitRelayFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitRelayFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/side/stand/final/report", notes = "To Submit the Final Report to Get Pdf of Side Stand",response=SubmitSideStandFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/side/stand/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitSideSFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitSideStandFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/dust/head/final/report", notes = "To Submit the Final Report to Get Pdf of Side Stand",response=SubmitDustHeadFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/dust/head/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitDustHeadFinalReport(@RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = finalReportServices.submitDustHeadFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/dust/tail/final/report", notes = "To Submit the Final Report to Get Pdf of Side Stand",response=SubmitDustTailFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/dust/tail/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitDustTailFinalReport(@RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = finalReportServices.submitDustTailFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/shower/head/final/report", notes = "To Submit the Final Report to Get Pdf of Shower",response=SubmitShowerHeadFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/shower/head/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitShowerHeadFinalReport(@RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = finalReportServices.submitShowerHeadFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/shower/front/winker/final/report", notes = "To Submit the Final Report to Get Pdf of Shower",response=SubmitShowerFrontWinkerFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/shower/front/winker/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitShowerFrontWinkerFinalReport(@RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = finalReportServices.submitShowerFrontWrinkerFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/shower/rear/winker/final/report", notes = "To Submit the Final Report to Get Pdf of Shower",response=SubmitShowerRearWinkerFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/shower/rear/winker/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitShowerRearWinkerFinalReport(@RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = finalReportServices.submitShowerRearWinkerFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/shower/starter/relay/final/report", notes = "To Submit the Final Report to Get Pdf of Shower",response=SubmitShowerStarterRelayFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/shower/starter/relay/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitShowerStarterRelayFinalReport(@RequestParam Map<String, String> map,
			HttpServletRequest req, HttpServletResponse res) {
		Message message = finalReportServices.submitShowerStarterRelayFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/lock/final/report", notes = "To Submit the Final Report to Get Pdf of Shower",response=SubmitLockFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/lock/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitLockinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitLockinalReport(map, req, res);
		return message;
	}
	
	/**
	 * To Download final report of Speedometer for Shower testing in Pdf.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @param request : To get user_key, user_id from request header.
	 * @param response : To get response for returning on API call.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/shower/spedometer/final/report", notes = "To Submit the Final Report to Get .pdf of Speedometer.",response=SubmitLockFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/shower/spedometer/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitShowerSpedometerFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitShowerSpedometerFinalReport(map, req, res);
		return message;
	}
	
	/**
	 * To Download final report of Front Winker for Dust testing in Pdf.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @param request : To get user_key, user_id from request header.
	 * @param response : To get response for returning on API call.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/dust/winker/front/final/report", notes = "To Submit the Final Report to Get .pdf of Speedometer.",response=SubmitLockFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/dust/winker/front/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitDustWinkerFrontFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitDustWinkerFrontFinalReport(map, req, res);
		return message;
	}

	/**
	 * To Download final report of Speedometer for Dust testing in Pdf.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @param request : To get user_key, user_id from request header.
	 * @param response : To get response for returning on API call.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/submit/dust/winker/rear/final/report", notes = "To Submit the Final Report to Get .pdf of Speedometer.",response=SubmitLockFinalReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date."),
			@ApiImplicitParam(name = "end_date", value = "Required end_date."),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code."),
			@ApiImplicitParam(name = "test_number", value = "Required testing_version.") })
	@RequestMapping(value = "/submit/dust/winker/rear/final/report", method = RequestMethod.POST)
	public @ResponseBody Message submitDustWinkerRearFinalReport(@RequestParam Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		Message message = finalReportServices.submitDustWinkerRearFinalReport(map, req, res);
		return message;
	}
	
}
