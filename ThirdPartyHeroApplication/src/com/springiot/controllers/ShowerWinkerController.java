/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling for Shower Winker Component.
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
import com.springiot.swagger.response.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Generic
 * Procedure Calling for Shower Winker Component..
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "File Report Process.")
public class ShowerWinkerController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Api To get Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker", notes = "To get Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinker(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("256", map, null);
		return message;
	}

	/**
	 * Api To get Front Winker analysis in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/analysis", notes = "To get Front Winker analysis in Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("257", map, null);
		return message;
	}

	/**
	 * Api To get Front Winker conclusion in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/conclusion", notes = "To get Front Winker conclusion in Final Report", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("258", map, null);
		return message;
	}

	/**
	 * Api To get Header of Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/header", notes = "To get Header of Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("259", map, null);
		return message;
	}

	/**
	 * Api To get Images in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/images", notes = "To get Images in Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_first_component", value = "Required Is First Component ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before", value = "Required Is Before", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("260", map, null);
		return message;
	}

	/**
	 * Api To get Front Winker Observation in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/observation", notes = "To get Front Winker Observation in Final Report", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("261", map, null);
		return message;
	}

	/**
	 * Api To get Front Winker Result in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/result", notes = "To get Front Winker Result in Final Report", response = HeroFinalReportShowerGetFrontWinkerResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("262", map, null);
		return message;
	}

	/**
	 * Api To get signature in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/signature", notes = "To get signature in Front Winker Final Report", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("263", map, null);
		return message;
	}

	/**
	 * Api To get Testing Version of Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/front/winker/testing/Version", notes = "To get Testing Version of Front Winker Final Report", response = GenericFinalReportGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/front/winker/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetFrontWinkerTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("264", map, null);
		return message;
	}

	/**
	 * Api To get Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker", notes = "To get Rear Winker Final Report", response = HeroFinalReportShowerGetRearWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinker(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("265", map, null);
		return message;
	}

	/**
	 * To insert Analysis in Front Winker Final Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/insert/analysis", notes = "To insert Analysis in Front Winker Final Report", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/insert/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerInsertAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("266", map, null);
		return message;
	}

	/**
	 * Api To insert Observation in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/insert/observation", notes = "To insert Observation in Front Winker Final Report", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_observation", value = "Required Observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/insert/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerInsertObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("267", map, null);
		return message;
	}

	/**
	 * Api To insert conclusion in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/insert/conclusion", notes = "To insert conclusion in Front Winker Final Report", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_conclusion", value = "Required Conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/insert/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontwinkerInsertConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("268", map, null);
		return message;
	}

	/**
	 * Api To insert Result in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/insert/result", notes = "To insert Result in Front Winker Final Report", response = HeroFinalReportShowerFrontWinkerInsertResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_result", value = "Required Result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/insert/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerInsertResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("269", map, null);
		return message;
	}

	/**
	 * Api To insert Signature in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/insert/signature", notes = "To insert Signature in Front Winker Final Report", response = HeroFinalReportShowerFrontWinkerInsertSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_tested_by_id", value = "Required Tested by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_verified_by_id", value = "Required Verified by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_approved_by_id", value = "Required approved by id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/insert/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerInsertSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("270", map, null);
		return message;
	}

	/**
	 * Api To insert Images in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/insert/images", notes = "To insert Images in Front Winker Final Report", response = HeroFinalReportShowerFrontWinkerInsertImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_name", value = "Required Image Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_path", value = "Required Image Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_description", value = "Required Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before_test", value = "Required is Before Test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_first_component", value = "Required is First Component", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/insert/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerInsertImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("271", map, null);
		return message;
	}

	/**
	 * Api To Delete Images from Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/delete/images", notes = "To Delete Images from Front Winker Final Report", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Image ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerDeleteImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("272", map, null);
		return message;
	}

	/**
	 * Api To Delete Observations from Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/delete/observation", notes = "To Delete Observations from Front Winker Final Report", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Observation ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/delete/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerDeleteObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("273", map, null);
		return message;
	}

	/**
	 * Api To Update in Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/update", notes = "To Update in Front Winker Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required winker ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_item1", value = "Required First Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_item2", value = "Required Second Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_requirement_and_specification_item1", value = "Required test Requirement and Specification for First Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_requirement_and_specification_item2", value = "Required test Requirement and Specification for Second Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_before_test_result_item1", value = "Required before Test Result of First Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_before_test_result_item2", value = "Required before Test Result of Second Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_before_test_result_item1", value = "Required before Test Result of First Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_before_test_result_item2", value = "Required before Test Result of Second Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_after_test_result_item1", value = "Required after Test Result of First Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_after_test_result_item2", value = "Required after Test Result of Second Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_after_test_result_item1", value = "Required after Test Result of First Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_after_test_result_item2", value = "Required after Test Result of Second Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_before_test_judgement", value = "Required before Test Judgement for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_before_test_judgement", value = "Required before Test Judgement for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_after_test_judgement", value = "Required after Test Judgement for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_after_test_judgement", value = "Required after Test Judgement for Component n2", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/update", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerUpdate(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("274", map, null);
		return message;
	}

	/**
	 * Api To final submit of update for Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/update/final/submit", notes = "To get Front Winker Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Required is Field is editable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/update/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerUpdateFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("275", map, null);
		return message;
	}

	/**
	 * Api To update header of Front Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/update/header", notes = "To update header of Front Winker Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_no", value = "Required Inspection Lot Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_date", value = "Required Inspection Lot Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_part_mfg_date", value = "Required Part Manufacturing Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_qty", value = "Required Inspection Lot Query", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_type", value = "Required Testing Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_objective", value = "Required Objective", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_part_modification_detail", value = "Required Part Modification Detail", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_standard", value = "Required Test Standard", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_condition", value = "Required Test Condition", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_method", value = "Required Test Method", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_duration", value = "Required Test Duration", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Winker ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/update/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerFrontWinkerUpdateHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("276", map, null);
		return message;
	}

	/**
	 * Api To Delete images from Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/delete/images", notes = "To Delete Images from Rear Winker Final Report", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Winker ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerDeleteImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("277", map, null);
		return message;
	}

	/**
	 * Api To get Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/delete/observation", notes = "To get Rear Winker Final Report", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Winker ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/delete/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerDeleteObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("278", map, null);
		return message;
	}

	/**
	 * Api To Insert Analysis in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/insert/analysis", notes = "To Insert Analysis in Rear Winker Final Report", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/insert/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerInsertAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("279", map, null);
		return message;
	}

	/**
	 * Api To Insert Conclusion in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/insert/conclusion", notes = "To Insert Conclusion in Rear Winker Final Report", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_conclusion", value = "Required Conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/insert/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerInsertConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("280", map, null);
		return message;
	}

	/**
	 * Api To Insert Images in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/insert/images", notes = "To Insert Images in Rear Winker Final Report", response = HeroFinalReportShowerRearWinkerInsertImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_name", value = "Required Image Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_path", value = "Required Image Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_description", value = "Required Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before_test", value = "Required is Before Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_first_component", value = "Required is First Component", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/insert/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerInsertImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("281", map, null);
		return message;
	}

	/**
	 * Api To Insert observation in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/insert/observation", notes = "To Insert Observations in Rear Winker Final Report", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_observation", value = "Required Observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/insert/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerInsertObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("282", map, null);
		return message;
	}

	/**
	 * Api To Insert Result in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/insert/result", notes = "To Insert Results in Rear Winker Final Report", response = GenericFinalReportInsertResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_result", value = "Required Result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/insert/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerInsertResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("283", map, null);
		return message;
	}

	/**
	 * Api To Insert signature in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/insert/signature", notes = "To Insert Signatures in Rear Winker Final Report", response = HeroFinalReportShowerRearWinkerInsertSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_tested_by_id", value = "Required Id of Tested by", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_verified_by_id", value = "Required Id of Verified by", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_approved_by_id", value = "Required Id of Approved by", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/insert/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerInsertSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("284", map, null);
		return message;
	}

	/**
	 * Api To Update in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/update", notes = "To Update in Rear Winker Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required winker ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_item1", value = "Required First Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_item2", value = "Required Second Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_requirement_and_specification_item1", value = "Required test Requirement and Specification for First Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_requirement_and_specification_item2", value = "Required test Requirement and Specification for Second Item", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_before_test_result_item1", value = "Required before Test Result of First Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_before_test_result_item2", value = "Required before Test Result of Second Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_before_test_result_item1", value = "Required before Test Result of First Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_before_test_result_item2", value = "Required before Test Result of Second Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_after_test_result_item1", value = "Required after Test Result of First Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_after_test_result_item2", value = "Required after Test Result of Second Item for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_after_test_result_item1", value = "Required after Test Result of First Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_after_test_result_item2", value = "Required after Test Result of Second Item for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_before_test_judgement", value = "Required before Test Judgement for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_before_test_judgement", value = "Required before Test Judgement for Component n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n1_after_test_judgement", value = "Required after Test Judgement for Component n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_n2_after_test_judgement", value = "Required after Test Judgement for Component n2", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/update", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerUpdate(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("285", map, null);
		return message;
	}

	/**
	 * Api To Final Submit of update for Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/update/final/submit", notes = "To Final Submit of Rear Winker Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Required is Field edit successful", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/update/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerUpdateFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("286", map, null);
		return message;
	}

	/**
	 * Api To update header of Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/update/header", notes = "To update header of Rear Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_no", value = "Required Inspection Lot Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_date", value = "Required Inspection Lot Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_part_mfg_date", value = "Required Part Manufacturing Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_qty", value = "Required Inspection Lot Query", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_type", value = "Required Testing Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_objective", value = "Required Objective", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_part_modification_detail", value = "Required Part Modification Detail", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_standard", value = "Required Test Standard", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_condition", value = "Required Test Condition", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_method", value = "Required Test Method", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_duration", value = "Required Test Duration", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Winker ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/update/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerRearWinkerUpdateHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("287", map, null);
		return message;
	}

	/**
	 * Api To get Rear Winker Analysis in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/analysis", notes = "To get Rear Winker Analysis in Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("288", map, null);
		return message;
	}

	/**
	 * Api To get Rear Winker conclusion in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/conclusion", notes = "To get conclusion in Rear Winker Final Report", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("289", map, null);
		return message;
	}

	/**
	 * Api To get Header of Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/header", notes = "To get Header of Rear Winker Final Report", response = HeroFinalReportShowerGetRearWinkerHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("290", map, null);
		return message;
	}

	/**
	 * Api To get Images in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/images", notes = "To get Images in Rear Winker Final Report", response = HeroFinalReportShowerGetRearWinkerImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_first_component", value = "Required Is First Component ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before", value = "Required Is Before", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("291", map, null);
		return message;
	}

	/**
	 * Api To get Rear Winker Observation in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/observation", notes = "To get Rear Winker Observation in Final Report", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("292", map, null);
		return message;
	}

	/**
	 * Api To get Rear Winker Result in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/result", notes = "To get Rear Winker Result in Final Report", response = GenericFinalReportGetResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("293", map, null);
		return message;
	}

	/**
	 * Api To get signature in Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/signature", notes = "To get signature in Rear Winker Final Report", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("294", map, null);
		return message;
	}

	/**
	 * Api To get Testing Version of Rear Winker Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/rear/winker/testing/Version", notes = "To get Testing Version of Rear Winker Final Report", response = GenericFinalReportGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/rear/winker/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetRearWinkerTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("295", map, null);
		return message;
	}

}
