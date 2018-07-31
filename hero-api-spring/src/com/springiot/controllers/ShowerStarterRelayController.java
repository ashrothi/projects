/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling for Shower Starter Relay Component.
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
 * Procedure Calling for Shower Starter Relay Component..
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "File Report Process.")
public class ShowerStarterRelayController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Api To get Starter Relay Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay", notes = "To get Starter Relay Final Report", response = HeroFinalReportShowerStarterGetRelaySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelay(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("296", map, null);
		return message;
	}

	/**
	 * Api To get analysis in Starter Relay Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/analysis", notes = "To get analysis in Starter Relay Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("297", map, null);
		return message;
	}

	/**
	 * Api To get conclusion in Starter Relay Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/conclusion", notes = "To get conclusion in Starter Relay Final Report", response = GenericFinalReportGetConclusionSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("298", map, null);
		return message;
	}

	/**
	 * Api To get Header of Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/header", notes = "To get Header of Shower Starter Final Report", response = HeroFinalReportShowerStarterGetRelayHeaderSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("299", map, null);
		return message;
	}

	/**
	 * Api To get Images in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/images", notes = "To get Images in Shower Starter Final Report", response = HeroFinalReportShowerStarterGetRelayImagesSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("300", map, null);
		return message;
	}

	/**
	 * Api To get Observation in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/observation", notes = "To get  Observation in Shower Starter Final Report", response = GenericFinalReportGetObservationSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("301", map, null);
		return message;
	}

	/**
	 * Api To get Result in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/result", notes = "To get Result in Shower Starter Final Report", response = HeroFinalReportShowerStarterGetRelayResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("302", map, null);
		return message;
	}

	/**
	 * Api To get signature in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/signature", notes = "To get signature in Shower Starter Final Report", response = HeroFinalReportShowerStarterGetRelaySignatureSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelaySignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("303", map, null);
		return message;
	}

	/**
	 * Api To get Testing Version of Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/get/relay/testing/Version", notes = "To get Testing Version of Shower Starter Final Report", response = HeroFinalReportShowerStarterGetRelayTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/get/relay/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterGetRelayTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("304", map, null);
		return message;
	}

	/**
	 * To insert Analysis in Shower Starter Final Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/insert/relay/analysis", notes = "To insert Analysis in Shower Starter Final Report", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/insert/relay/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterInsertRelayAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("305", map, null);
		return message;
	}

	/**
	 * Api To insert conclusion in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/insert/relay/conclusion", notes = "To insert conclusion in Shower Starter Final Report", response = GenericFinalReportInsertConclusionSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/insert/relay/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterInsertRelayConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("306", map, null);
		return message;
	}

	/**
	 * Api To insert Images in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/insert/relay/images", notes = "To insert Images in Shower Starter Final Report", response = HeroFinalReportShowerStarterInsertRelayImagesSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/insert/relay/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterInsertRelayImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("307", map, null);
		return message;
	}

	/**
	 * Api To insert Observation in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/insert/relay/observation", notes = "To insert Observation in Shower Starter Final Report", response = GenericFinalReportInsertObservationSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/insert/relay/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterInsertRelayObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("308", map, null);
		return message;
	}

	/**
	 * Api To insert Result in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/insert/relay/result", notes = "To insert Result in Shower Starter Final Report", response = HeroFinalReportShowerStarterInsertRelayResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_result", value = "Required Result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/insert/relay/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterInsertRelayResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("309", map, null);
		return message;
	}

	/**
	 * Api To insert Signature in Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/insert/relay/signature", notes = "To insert Signature in Shower Starter Final Report", response = HeroFinalReportShowerStarterInsertRelaySignatureSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/insert/relay/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterInsertRelaySignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("310", map, null);
		return message;
	}

	/**
	 * Api To Delete Images from Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/delete/relay/images", notes = "To Delete Images from Shower Starter Final Report", response = HeroFinalReportShowerStarterDeleteRelayImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Image ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/delete/relay/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterDeleteRelayImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("311", map, null);
		return message;
	}

	/**
	 * Api To Delete Observations from Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/delete/relay/observation", notes = "To Delete Observations from Shower Starter Final Report", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Observation ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/delete/relay/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterDeleteRelayObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("312", map, null);
		return message;
	}

	/**
	 * Api To update header of Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/update/relay/header", notes = "To update header of Shower Starter Final Report", response = HeroFinalReportShowerStarterUpdateRelayHeaderSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/update/relay/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterUpdateRelayHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("313", map, null);
		return message;
	}

	/**
	 * Api To final submit of update for Shower Starter Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/update/relay/final/submit", notes = "To Final Submit Shower Starter Final Report", response = HeroFinalReportShowerStarterUpdateRelayFinalSubmitSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/shower/starter/update/relay/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerStarterUpdateRelayFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("314", map, null);
		return message;
	}

}
