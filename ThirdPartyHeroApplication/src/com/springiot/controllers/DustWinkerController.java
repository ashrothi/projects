/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling for Dust Testing of Winker Component.
 */
package com.springiot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.HeroFinalReportShowerGetFrontWinkerHeaderSwagger;
import com.springiot.swagger.response.HeroFinalReportShowerGetFrontWinkerImagesSwagger;
import com.springiot.swagger.response.HeroFinalReportShowerGetFrontWinkerSwagger;
import com.springiot.swagger.response.GenericFinalReportGetAnalysisSwagger;
import com.springiot.swagger.response.GenericFinalReportGetConclusionSwagger;
import com.springiot.swagger.response.GenericFinalReportGetObservationSwagger;
import com.springiot.swagger.response.GenericFinalReportInsertAnalysisSwagger;
import com.springiot.swagger.response.GenericFinalReportInsertConclusionSwagger;
import com.springiot.swagger.response.GenericFinalReportInsertObservationSwagger;
import com.springiot.swagger.response.GenericFinalReportInsertResultSwagger;
import com.springiot.swagger.response.GenericFinalReportGetSignatureSwagger;
import com.springiot.swagger.response.HeroFinalReportInsertRelayImagesSwagger;
import com.springiot.swagger.response.GenericFinalReportGetResultSwagger;
import com.springiot.swagger.response.GenericFinalReportUpdateSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to control APIs using Generic 
 * Procedure Calling for both Front and Rear Winker Component for Dust Testing.
 * 
 * @author Mandeep Singh
 *
 */
@Controller
@Api(value = "/", description = "File Report Process.")
public class DustWinkerController {

	/**
	 * To access functionality of following Class function.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Api To get Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front", notes = "To get grid of Final Report of Dust testing of Front Winker.", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version", required = true, access = "query", paramType = "query"),})
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFront(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("363", map, null);
		return message;
	}

	/**
	 * Api To get Front Winker Version in Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/analysis", notes = "To get Front Winker analysis in Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("364", map, null);
		return message;
	}

	/**
	 * Api To get Conclusion in Front Winker's Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/conclusion", notes = "To get Front Winker conclusion in Final Report", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("365", map, null);
		return message;
	}

	/**
	 * Api to get header of Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/header", notes = "To get Header of Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code", required =true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_number", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("366", map, null);
		return message;
	}

	/**
	 * Api To get Images in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/images", notes = "To get Images in Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_component_index", value = "Here Pass Is First Component ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before", value = "Here Pass Is Before", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("367", map, null);
		return message;
	}

	/**
	 * Api to get Observation of Front Winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/observation", notes = "To get Observation for Front Winker in Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_number", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("368", map, null);
		return message;
	}

	/**
	 * Api to get result in Front Winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/result", notes = "To get result in Front Winker Final Report.", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("369", map, null);
		return message;
	}
	
	/**
	 * Api to get signature in Front Winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/signature", notes = "To get signature in Front Winker Final Report.", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("370", map, null);
		return message;
	}

	/**
	 * Api to get testing version of front winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/testing/Version", notes = "To get Testing Version in Front Winker Final Report", response = GenericFinalReportGetResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("371", map, null);
		return message;
	}

	/**
	 * Api to get vendor code in front winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/front/vendor", notes = "To get Vendor Code in Front Winker Final Report.", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/front/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerFrontVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("372", map, null);
		return message;
	}
	
	/**
	 * Api to insert analysis in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/front/analysis", notes = "To insert analysis in Front Winker Final Report.", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_analysis", value = "Here About analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/front/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerFrontAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("373", map, null);
		return message;
	}

	/**
	 * Api to insert conclusion in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/front/conclusion", notes = "To insert conclusion in Front Winker Final Report.", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_conclusion", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/front/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerFrontConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("374", map, null);
		return message;
	}

	/**
	 * Api to insert images in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/front/images", notes = "To insert images in Front Winker Final Report.", response = HeroFinalReportInsertRelayImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_name", value = "Here Pass Image name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_path", value = "Here Pass Image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_description", value = "Here Pass description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before_test", value = "Here Pass is before test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_component_index", value = "Here Pass index of the component", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/front/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerFrontImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("375", map, null);
		return message;
	}
	
	/**
	 * Api to insert observation in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/front/observation", notes = "To insert observation in Front Winker Final Report.", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_observation", value = "Here Pass observation details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/front/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerFrontObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("376", map, null);
		return message;
	}

	/**
	 * Api to insert result in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/front/result", notes = "To insert Result in Front Winker Final Report.", response = GenericFinalReportInsertResultSwagger	.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_result", value = "Here Pass result after test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/front/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerFrontResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("377", map, null);
		return message;
	}

	/**
	 * To insert signature in Front Winker Final Report
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/front/signature", notes = "To insert Signature in Front Winker Final Report", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_tested_by_id", value = "Here Pass Tested by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_verified_by_id", value = "Here Pass verified by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_approved_by_id", value = "Here Pass Approved by id", required = true, access = "query", paramType = "query"),})
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/front/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerFrontSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("378", map, null);
		return message;
	}
	
	/**
	 * Api to update Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/winker/front", notes = "To to update Front Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version of the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Here Pass id of the part", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_items", value = "Here Pass items", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_requirement_and_specification", value = "Here Pass Requirements and specifications", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_before_test_result_n1", value = "Here Pass test results before test for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_before_test_result_n2", value = "Here Pass test results before test for n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_after_test_result_n1", value = "Here Pass test results after test for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_after_test_result_n2", value = "Here Pass test results after test for n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_in_age_drop_in_luminious_intensity_n1", value = "Here Pass age group for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_in_age_drop_in_luminious_intensity_n2", value = "Here Pass age group for n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_judgement_n1", value = "Here Pass judgement for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_judgement_n2", value = "Here Pass judgement for n2", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/winker/front", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateWinkerFront(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("379", map, null);
		return message;
	}

	/**
	 * Api to update final submit in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/winker/front/final/submit", notes = "To Update final submit in Front Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Here Pass if it is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Here Pass if successfully updated.", required = true, access = "query", paramType = "query"),
			})
	@RequestMapping(value = "/hero/final/report/dust/update/winker/front/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateWinkerFrontFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("380", map, null);
		return message;
	}

	/**
	 * Api to update header in Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/winker/front/header", notes = "To to update header in Front Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_no", value = "Here Pass Inspection Lot Number of Device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_qty", value = "Here Pass Inspection Lot quantity.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_inspection_lot_date", value = "Here Pass Inspection Lot Date of Device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_part_mfg_date", value = "Here Pass Manufacturing date of the part.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_objective", value = "Here Pass Objective of testing.", required = true, access = "query.", paramType = "query"),
			@ApiImplicitParam(name = "in_part_modification_details", value = "Here Pass Modification details of the part.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_duration", value = "Here Pass test duration.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_condition_as_per_specification", value = "Here Pass Test Condition as per specification.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_condition_as_per_specification_image", value = "Here Pass Test condition image as per specification.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_actual_condition", value = "Here Pass Actual Test condition.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_actual_condition_image", value = "Here Pass Actual Test condition image.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_type", value = "Here pass the Testing Type id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/winker/front/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateWinkerFrontHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("381", map, null);
		return message;
	}
	
	/**
	 * Api to submit Final Report of Front Winker.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/winker/front/final/submit", notes = "To Submit Final Report of Front Winker.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Here Pass if final report is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Here Pass if successfully submitted.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/winker/front/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustWinkerFrontFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("382", map, null);
		return message;
	}
	
	/**
	 * Api To Delete images from Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/winker/front/delete/images", notes = "To Delete Images from Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Here Pass testing version", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/winker/front/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustWinkerFrontDeleteImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("383", map, null);
		return message;
	}

	/**
	 * Api To Delete Observations from Front Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/winker/front/delete/observation", notes = "To Delete Observations from Front Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Here Pass testing version", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/winker/front/delete/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustWinkerFrontDeleteObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("384", map, null);
		return message;
	}


	
	
	
	
	/**
	 * Api to get Final Report of dust testing of Rear Winker.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear", notes = "To get grid of Final Report of Dust testing of Rear Winker.", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Here Pass start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass testing version", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRear(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("385", map, null);
		return message;
	}

	/**
	 * Api to get analysis in Final Report of Dust testing of Rear Winker.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/analysis", notes = "To get analysis in Rear Winker Final Report", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("386", map, null);
		return message;
	}

	/**
	 * Api To get conclusion in Rear Winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/conclusion", notes = "To get conclusion in Rear Winker Final Report", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("387", map, null);
		return message;
	}

	/**
	 * Api To get header in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/header", notes = "To get Header in Rear Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_number", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("388", map, null);
		return message;
	}
	
	/**
	 * Api To get Images in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/images", notes = "To get Images in Rear Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_component_index", value = "Here Pass Is First Component ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before", value = "Here Pass Is Before", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("389", map, null);
		return message;
	}
	
	/**
	 * Api to get observation of rear winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/observation", notes = "To get Observation in Rear Winker Final Report.", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_number", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("390", map, null);
		return message;
	}

	/**
	 * Api to get result of rear winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/result", notes = "To get Result in Rear Winker Final Report", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("391", map, null);
		return message;
	}
	
	/**
	 * Api to get signature of rear winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/signature", notes = "To get Signature in Rear Winker Final Report", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("392", map, null);
		return message;
	}

	/**
	 * Api To get Testing version in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/testing/Version", notes = "To get Testing Version in Rear Winker Final Report", response = GenericFinalReportGetResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("393", map, null);
		return message;
	}

	/**
	 * Api to get vendor code of rear winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/get/winker/rear/vendor", notes = "To get Vendor code in Rear Winker Final Report", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/get/winker/rear/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetWinkerRearVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("394", map, null);
		return message;
	}
	
	/**
	 * Api to insert analysis in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/rear/analysis", notes = "To Insert Analysis in Rear Winker Final Report.", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_analysis", value = "Here About analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/rear/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerRearAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("395", map, null);
		return message;
	}

	/**
	 * Api to insert Conclusion in Rear Winker Final Report for dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/rear/conclusion", notes = "To Insert Conclusion in Rear Winker Final Report", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_conclusion", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/rear/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerRearConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("396", map, null);
		return message;
	}

	/**
	 * Api to insert images in rear winker Final Report for Dust testing.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/rear/images", notes = "To insert images in Rear Winker Final Report.", response = HeroFinalReportInsertRelayImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_name", value = "Here Pass Image name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_image_path", value = "Here Pass Image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_description", value = "Here Pass description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before_test", value = "Here Pass is before test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_component_index", value = "Here Pass index of the component", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/rear/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerRearImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("397", map, null);
		return message;
	}
	
	/**
	 * Api to insert observation in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/rear/observation", notes = "To Insert Observation in Rear Winker Final Report", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_observation", value = "Here Pass observation details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/rear/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerRearObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("398", map, null);
		return message;
	}

	/**
	 * Api to insert result in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/rear/result", notes = "To Insert Result in Rear Winker Final Report", response = GenericFinalReportInsertResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_result", value = "Here Pass result after test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/rear/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerRearResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("399", map, null);
		return message;
	}

	/**
	 * To insert signature in rear winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/insert/winker/rear/signature", notes = "To Insert Signature in Rear Winker Final Report", response = GenericFinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_tested_by_id", value = "Here Pass Tested by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_verified_by_id", value = "Here Pass verified by id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_approved_by_id", value = "Here Pass Approved by id", required = true, access = "query", paramType = "query"),})
	@RequestMapping(value = "/hero/final/report/dust/insert/winker/rear/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertWinkerRearSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("400", map, null);
		return message;
	}
	
	/**
	 * Api to update Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/winker/rear", notes = "To Update Rear Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Here Pass id of the part", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version of the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_items", value = "Here Pass items", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_requirement_and_specification", value = "Here Pass Requirements and specifications", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_before_test_result_n1", value = "Here Pass test results before test for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_before_test_result_n2", value = "Here Pass test results before test for n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_after_test_result_n1", value = "Here Pass test results after test for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_after_test_result_n2", value = "Here Pass test results after test for n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_in_age_drop_in_luminious_intensity_n1", value = "Here Pass age group for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_in_age_drop_in_luminious_intensity_n2", value = "Here Pass age group for n2", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_judgement_n1", value = "Here Pass judgement for n1", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_judgement_n2", value = "Here Pass judgement for n2", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/winker/rear", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateWinkerRear(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("401", map, null);
		return message;
	}

	/**
	 * Api to update final submit in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/winker/rear/final/submit", notes = "To Update Final Submit in Rear Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Here Pass if it is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Here Pass if successfully updated.", required = true, access = "query", paramType = "query"),
			})
	@RequestMapping(value = "/hero/final/report/dust/update/winker/rear/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateWinkerRearFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("402", map, null);
		return message;
	}

	/**
	 * Api to update header in Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/winker/rear/header", notes = "To Update Header in Rear Winker Final Report.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing version", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_inspection_lot_no", value = "Here Pass Inspection Lot Number of Device.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_inspection_lot_qty", value = "Here Pass Inspection Lot quantity.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_inspection_lot_date", value = "Here Pass Inspection Lot Date of Device.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_part_mfg_date", value = "Here Pass Manufacturing date of the part.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_objective", value = "Here Pass Objective of testing.", required = true, access = "query.", paramType = "query"),
		@ApiImplicitParam(name = "in_part_modification_details", value = "Here Pass Modification details of the part.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_test_duration", value = "Here Pass test duration.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_test_condition_as_per_specification", value = "Here Pass Test Condition as per specification.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_test_condition_as_per_specification_image", value = "Here Pass Test condition image as per specification.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_test_actual_condition", value = "Here Pass Actual Test condition.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "in_test_actual_condition_image", value = "Here Pass Actual Test condition image.", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "testing_type", value = "Here pass the Testing Type id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/winker/rear/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateWinkerRearHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("403", map, null);
		return message;
	}

	/**
	 * Api to submit Final Report of Rear Winker.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/winker/rear/final/submit", notes = "To Submit Final Report of Rear Winker.", response = GenericFinalReportUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Here Pass if final report is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Here Pass Vendor Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Here Pass Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Here Pass End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Here Pass Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Here Pass if successfully submitted.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/winker/rear/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustWinkerRearFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("404", map, null);
		return message;
	}

	/**
	 * Api To Delete images from Rear Winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/winker/rear/delete/images", notes = "To Delete Images from Rear Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Here Pass testing version", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/winker/rear/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustWinkerRearDeleteImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("405", map, null);
		return message;
	}

	/**
	 * Api To Delete Observations from rear winker Final Report.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/dust/winker/rear/delete/observation", notes = "To Delete Observations from Rear Winker Final Report", response = HeroFinalReportShowerGetFrontWinkerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the device.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Here Pass testing version", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/final/report/dust/winker/rear/delete/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustWinkerRearDeleteObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("406", map, null);
		return message;
	}
}
