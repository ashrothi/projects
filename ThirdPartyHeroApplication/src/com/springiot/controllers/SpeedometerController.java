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
public class SpeedometerController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Api To get Header of Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/header", notes = "To get Header of Speedometer Final Report", response = HeroFinalReportShowerGetFrontWinkerHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("343", map, null);
		return message;
	}

	/**
	 * Api To get Speedometer analysis in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/analysis", notes = "To get Speedometer analysis in Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("344", map, null);
		return message;
	}

	/**
	 * Api To get Speedometer conclusion in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/conclusion", notes = "To get Speedometer conclusion in Final Report", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("345", map, null);
		return message;
	}

	/**
	 * Api To get Images in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/images", notes = "To get Images in Speedometer Final Report", response = HeroFinalReportShowerGetFrontWinkerImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required Is First Component ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before", value = "Required Is Before", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("346", map, null);
		return message;
	}

	/**
	 * Api To get Speedometer Observation in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/observation", notes = "To get Speedometer Observation in Final Report", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("347", map, null);
		return message;
	}

	/**
	 * Api To get signature in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/signature", notes = "To get signature in Speedometer Final Report", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("348", map, null);
		return message;
	}

	/**
	 * Api To get Testing Version of Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/testing/Version", notes = "To get Testing Version of Speedometer Final Report", response = GenericFinalReportGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("349", map, null);
		return message;
	}

	/**
	 * Api To get Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer", notes = "To get Speedometer Final Report", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometer(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("350", map, null);
		return message;
	}

	/**
	 * Api To get Speedometer Result in Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/speedometer/result", notes = "To get Speedometer Result in Final Report", response = HeroFinalReportShowerGetFrontWinkerResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/speedometer/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetSpeedometerResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("351", map, null);
		return message;
	}

	/**
	 * Api To insert Images in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/insert/images", notes = "To insert Images in Speedometer Final Report", response = HeroFinalReportShowerFrontWinkerInsertImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required Image Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required Image Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is Before Test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required is First Component", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/insert/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerInsertImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("352", map, null);
		return message;
	}

	/**
	 * Api To insert Observation in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/insert/observation", notes = "To insert Observation in Speedometer Final Report", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required Observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/insert/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerInsertObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("353", map, null);
		return message;
	}

	/**
	 * Api To insert Result in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/insert/result", notes = "To insert Result in Speedometer Final Report", response = HeroFinalReportShowerFrontWinkerInsertResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required Result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/insert/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerInsertResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("354", map, null);
		return message;
	}

	/**
	 * Api To insert Signature in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/insert/signature", notes = "To insert Signature in Speedometer Final Report", response = HeroFinalReportShowerFrontWinkerInsertSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required Tested by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required Verified by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved by id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/insert/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerInsertSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("355", map, null);
		return message;
	}

	/**
	 * To insert Analysis in Speedometer Final Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/insert/analysis", notes = "To insert Analysis in Speedometer Final Report", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/insert/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerInsertAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("356", map, null);
		return message;
	}

	/**
	 * Api To insert conclusion in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/insert/conclusion", notes = "To insert conclusion in Speedometer Final Report", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required Conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/insert/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerInsertConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("357", map, null);
		return message;
	}

	/**
	 * Api To Delete Images from Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/delete/images", notes = "To Delete Images from Speedometer Final Report", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required Image ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerDeleteImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("358", map, null);
		return message;
	}

	/**
	 * Api To Delete Observations from Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/delete/observation", notes = "To Delete Observations from Speedometer Final Report", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required Observation ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/delete/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerDeleteObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("359", map, null);
		return message;
	}

	/**
	 * Api To Update in Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/update", notes = "To Update in Speedometer Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_1st_specification", value = "Required ic_1st_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_1st_before_test", value = "Required ic_1st_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_1st_after_test", value = "Required ic_1st_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_1st_diffrence", value = "Required ic_1st_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_2nd_specification", value = "Required ic_2nd_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_2nd_before_test", value = "Required ic_2nd_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_2nd_after_test", value = "Required ic_2nd_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_2st_diffrence", value = "Required ic_2st_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_3rd_specification", value = "Required ic_3rd_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_3rd_before_test", value = "Required ic_3rd_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_3rd_after_test", value = "Required ic_3rd_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ic_3st_diffrence", value = "Required ic_3st_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_ic_result", value = "Required in_ic_3rd_result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sopo_specification", value = "Required sopo_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sopo_before_test", value = "Required sopo_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sopo_after_test", value = "Required sopo_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sopo_diffrence", value = "Required sopo_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sopo_result", value = "Required sopo_result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "rtfd_specification", value = "Required rtfd_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "rtfd_before_test", value = "Required rtfd_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "rtfd_after_test", value = "Required rtfd_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "rtfd_diffrence", value = "Required rtfd_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "rtfd_result", value = "Required rtfd_result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "paft_specification", value = "Required paft_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "paft_before_test", value = "Required paft_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "paft_after_test", value = "Required paft_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "paft_diffrence", value = "Required paft_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "paft_result", value = "Required paft_result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ir_specification", value = "Required ir_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ir_before_test", value = "Required ir_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ir_after_test", value = "Required ir_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ir_diffrence", value = "Required ir_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "ir_result", value = "Required ir_result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "wic_specification", value = "Required wic_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "wic_before_test", value = "Required wic_before_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "wic_after_test", value = "Required wic_after_test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "wic_diffrence", value = "Required wic_diffrence", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "wic_result", value = "Required wic_result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/update", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerUpdate(
			@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = genericProcess.GenericProcedureCalling("360", map, null);
		return message;
	}

	/**
	 * Api To final submit of update for Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/update/final/submit", notes = "To get Speedometer Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required is Field is editable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/update/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerUpdateFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("361", map, null);
		return message;
	}

	/**
	 * Api To update header of Speedometer Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/update/header", notes = "To update header of Speedometer Final Report", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_no", value = "Required inspection_lot_no", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_qty", value = "Required inspection_lot_qty", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_date", value = "Required inspection_lot_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_mfg_date", value = "Required part_mfg_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_detail", value = "Required part_modification_detail", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_duration", value = "Required test_duration", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_condition_as_per_specification", value = "Required test_condition_as_per_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_condition_as_per_specification_image", value = "Required test_condition_as_per_specification_image", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_actual_condition", value = "Required test_actual_condition", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_actual_condition_image", value = "Required test_actual_condition_image", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_type", value = "Required testing_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/update/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerUpdateHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("362", map, null);
		return message;
	}
}
