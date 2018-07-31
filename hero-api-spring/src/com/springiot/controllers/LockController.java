/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling for Lock Component.
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
 * Procedure Calling for Lock Component..
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "File Report Process.")
public class LockController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Api To get Header of Lock Daily Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/daily/report/get/lock/header", notes = "To get Header of Lock Daily Report",response=HeroDailyReportGetLockHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_cycle", value = "Required Cycle", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/daily/report/get/lock/header", method = RequestMethod.POST)
	public @ResponseBody Message heroDailyReportGetLockHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("316", map, null);
		return message;
	}

	/**
	 * Api To get Lock Daily Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/daily/report/get/lock", notes = "To get Lock Daily Report",response=HeroDailyReportGetLockSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_slot_type", value = "Required Slot Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_status", value = "Required Status", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_limit", value = "Required Limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_offset", value = "Required Offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Required Page", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Required Page Size", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_cycle", value = "Required Cycle", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/daily/report/get/lock", method = RequestMethod.POST)
	public @ResponseBody Message heroDailyReportGetLock(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("317", map, null);
		return message;
	}

	/**
	 * Api To get Cycle of Lock Daily Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/daily/report/get/lock/cycle", notes = "To get Cycle of Lock Daily Report",response=HeroDailyReportGetLockCycleSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_device_id", value = "Required Device ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/daily/report/get/lock/cycle", method = RequestMethod.POST)
	public @ResponseBody Message heroDailyReportGetLockCycle(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("318", map, null);
		return message;
	}

	/**
	 * Api To get Count in Lock Daily Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/daily/report/count/lock", notes = "To get Count in Lock Daily Report",response=HeroDailyReportCountLockSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_status", value = "Required Status", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_cycle", value = "Required Cycle", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/daily/report/count/lock", method = RequestMethod.POST)
	public @ResponseBody Message heroDailyReportCountLock(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("319", map, null);
		return message;
	}

	/**
	 * Api To get header of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/header", notes = "To get header of Lock Final Report",response=HeroFinalReportLockGetHeaderSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/get/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("320", map, null);
		return message;
	}

	/**
	 * Api To get analysis of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/analysis", notes = "To get analysis in Lock Final Report",response=GenericFinalReportGetAnalysisSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/get/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("321", map, null);
		return message;
	}

	/**
	 * Api To get conclusion of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/conclusion", notes = "To get conclusion of Lock Final Report",response=GenericFinalReportGetConclusionSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/get/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetConclusion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("322", map, null);
		return message;
	}

	/**
	 * Api To get Images of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/images", notes = "To get Images of Lock Final Report",response=HeroFinalReportLockGetImagesSwagger.class)
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
			@ApiImplicitParam(name = "is_first_component", value = "Required is_first_component ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_before", value = "Required Is Before", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/lock/get/images", method = RequestMethod.POST)

	public @ResponseBody Message heroFinalReportLockGetImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("323", map, null);
		return message;
	}

	/**
	 * Api To get Observation of Lock Final Report.
	 ** 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/observation", notes = "To get  Observation of Lock Final Report",response=GenericFinalReportGetObservationSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/get/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("324", map, null);
		return message;
	}

	/**
	 * Api To get signature in Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/signature", notes = "To get signature in Shower Starter Final Report",response=HeroFinalReportLockGetSignatureSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/get/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("325", map, null);
		return message;
	}

	/**
	 * Api To get Testing Version of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/testing/Version", notes = "To get Testing Version of Lock Final Report",response=HeroFinalReportLockGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/lock/get/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("326", map, null);
		return message;
	}

	/**
	 * To insert Analysis in Lock Final Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/insert/analysis", notes = "To insert Analysis in Lock Final Report",response=GenericFinalReportInsertAnalysisSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/insert/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockInsertAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("327", map, null);
		return message;
	}

	/**
	 * Api To insert conclusion in Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/insert/conclusion", notes = "To insert conclusion in Lock Final Report",response=GenericFinalReportInsertConclusionSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/insert/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockInsertConclusion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("328", map, null);
		return message;
	}

	/**
	 * Api To insert Images in Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/insert/images", notes = "To insert Images in Lock Final Report",response=HeroFinalReportLockInsertImagesSwagger.class)
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
			@ApiImplicitParam(name = "component_index", value = "Required component_index ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/hero/final/report/lock/insert/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockInsertImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("329", map, null);
		return message;
	}

	/**
	 * Api To insert Observation in Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/insert/observation", notes = "To insert Observation in Lock Final Report",response=GenericFinalReportInsertObservationSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/insert/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockInsertObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("330", map, null);
		return message;
	}

	/**
	 * Api To insert Result in Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/insert/result", notes = "To insert Result in Lock Final Report",response=HeroFinalReportLockInsertResultSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/insert/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockInsertResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("331", map, null);
		return message;
	}

	/**
	 * Api To insert Signature in Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/insert/signature", notes = "To insert Signature in Lock Final Report",response=HeroFinalReportLockInsertSignatureSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/insert/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockInsertSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("332", map, null);
		return message;
	}

	/**
	 * Api To update header of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/update/header", notes = "To update header of Lock Final Report",response=HeroFinalReportLockUpdateHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_mfg_date", value = "Required part_mfg_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required Objective", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_details", value = "Required Part Modification Detail", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standard_condition", value = "Required Test Standard", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standard", value = "Required Test Condition", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required Winker ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/lock/update/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockUpdateHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("333", map, null);
		return message;
	}

	/**
	 * Api To final submit of update for Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/update/final/submit", notes = "To Final Update Submit Lock Final Report",response=HeroFinalReportLockUpdateFinalSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_editable", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_from_date", value = "Required is Field is editable", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_end_date", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_testing_version", value = "Required Testing Version ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_is_succesful", value = "Required is Field is editable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/lock/update/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockUpdateFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("334", map, null);
		return message;
	}

	/**
	 * Api To Delete Images from Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/delete/images", notes = "To Delete Images from Lock Final Report",response=HeroFinalReportLockDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Image ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/lock/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockDeleteImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("335", map, null);
		return message;
	}

	/**
	 * Api To Delete Observations from Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/delete/observation", notes = "To Delete Observations from Lock Final Report",response=GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required Observation ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/lock/delete/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockDeleteObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("336", map, null);
		return message;
	}

	/**
	 * Api To get result of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/lock/get/result", notes = "To get result in Lock Final Report",response=HeroFinalReportLockGetResultSwagger.class)
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
	@RequestMapping(value = "/hero/final/report/lock/get/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("337", map, null);
		return message;
	}

	/**
	 * Api To get Grid of Lock Final Report.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/lock", notes = "To get Grid in Lock Final Report",response=HeroFinalReportGetLockSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required Testing Version", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/lock", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportLockGetGrid(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("339", map, null);
		return message;
	}

}
