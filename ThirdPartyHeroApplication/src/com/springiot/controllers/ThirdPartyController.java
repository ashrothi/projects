/**
 * This package contain the controller class for Third Party Application apis.
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
import com.springiot.services.*;
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class ThirdPartyController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private ThirdPartyServices thirdPartyService;

	/**
	 * To Get Planner Name Detail
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/planner/get/planner/name", notes = "To Get Planner Name  Detail", response = PlannerGetPlannerNameSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/planner/get/planner/name", method = RequestMethod.POST)
	public @ResponseBody Message plannerGetPlannerName(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.getPlannerName("24", map);
		return message;
	}

	/**
	 * To Upload Inventory To upload The excel master list and insert its data
	 * into the given table in DB
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/upload/inventory", notes = "To Upload Inventory", response = UploadInventorySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_name ", value = "File Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path ", value = "File Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_date ", value = "File Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description ", value = "Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userid ", value = "User Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey ", value = "User Key", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/upload/inventory", method = RequestMethod.POST)
	public @ResponseBody Message uploadInventory(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.uploadInventory("17", map);
		return message;
	}

	/**
	 * To Get Final Report Result To manipulate the coming result and return in
	 * group of OK and N.G
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/result", notes = "To Get Final Report Result", response = GenericFinalReportGetResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/result", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.finalReportGetResult("95", map);
		return message;
	}

	/**
	 * To Update Grid Data of Horn Final Report To insert the form data of
	 * updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/grid/data", notes = "To Update Grid Data of Horn Final Report ", response = GenericFinalReportInsertGridDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_updatable ", value = "Required is_updatable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/grid/data", method = RequestMethod.POST)
	public @ResponseBody Message finalReporHornData(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = thirdPartyService.finalReportInsertGrid(map);
		return message;
	}

	/**
	 * To Update Grid Data of Relay final report To insert the form data of
	 * updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/grid/data/relay", notes = "To Update Grid Data of Relay final report", response = GenericFinalReportInsertGridDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_updatable ", value = "Required is_updatable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/grid/data/relay", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInsertGridDataRelay(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = thirdPartyService.finalReportInsertGridRelay(map);
		return message;
	}

	/**
	 * To Update Gride Data of Side Stand Final Report To insert the form data
	 * of updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/grid/data/side/stand", notes = "To Update Gride Data of Side Stand Final Report", response = GenericFinalReportInsertGridDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_updatable ", value = "Required is_updatable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/grid/data/side/stand", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInsertGridDataSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.finalReportInsertGridSideStand(map);
		return message;
	}

	/**
	 * To Update Gride Data of Planner Final Report To insert the form data of
	 * updated value in Planner into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/grid/data/planner", notes = "To Update Gride Data of Planner Final Report", response = GenericFinalReportInsertGridDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_number", value = "Required planner_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version ", value = "Required planner_version", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/grid/data/planner", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInsertGridDataPlanner(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.finalReportInsertGridPlanner(map);
		return message;
	}

	/**
	 * To Upload Calendar Holiday Inventory to upload excel file for annual
	 * holiday into database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/upload/holiday/inventory", notes = "To Upload Calendar Inventory", response = UploadHolidayInventorySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_name ", value = "File Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path ", value = "File Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_date ", value = "File Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description ", value = "Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userid ", value = "User Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey ", value = "User Key", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/upload/holiday/inventory", method = RequestMethod.POST)
	public @ResponseBody Message uploadHolidayInventory(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.uploadHolidayInventory("17", map);
		return message;

	}

	/**
	 * To Insert the Url in url_mapping Table
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/update/url", notes = "To Insert the Url in url_mapping Table", response = UpdateUrlSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/update/url", method = RequestMethod.POST)
	public @ResponseBody Message UpdateUrl(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = thirdPartyService.UpdateUrl(map);
		return message;
	}

	/**
	 * To Update Grid Data of shower starter final report To insert the form
	 * data of updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/grid/data/shower/starter", notes = "To Update Grid Data of shower starter final report", response = GenericFinalReportInsertGridDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_updatable ", value = "Required is_updatable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/grid/data/shower/starter", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInsertGridDataShowerStarter(
			@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = thirdPartyService.finalReportInsertGridDataShowerStarter(map);
		return message;
	}

	/**
	 * To Update Grid Data of lock final report To insert the form data of
	 * updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/grid/data/lock", notes = "To Update Grid Data of lock final report", response = GenericFinalReportInsertGridDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_updatable ", value = "Required is_updatable", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/grid/data/lock", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInsertGridDataLock(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = thirdPartyService.finalReportInsertGridDataLock(map);
		return message;
	}
}
