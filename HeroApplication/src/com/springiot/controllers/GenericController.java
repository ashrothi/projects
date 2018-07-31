/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling.
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;
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
 * Procedure Calling.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "Hero Application ")
public class GenericController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To call /device/get/users/vehicles Api To get Component Setting History
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/component/get/setting/history", notes = "To get Component Setting History", response = ComponentGetSettingHistorySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date datetime", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date datetime", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Testing Id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/get/setting/history", method = RequestMethod.POST)
	public @ResponseBody Message componentGetSettingHistory(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("1", map, null);
		return message;
	}

	/**
	 * To Get Component Settings
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/component/get/settings", notes = "To Get Component Settings", response = ComponentGetSettingsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date datetime", value = "StartDate", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date datetime", value = "EndDate ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing", value = "Testing ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "offset ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/get/settings", method = RequestMethod.POST)
	public @ResponseBody Message component_get_settings(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("2", map, null);
		return message;
	}

	/**
	 * To Get the Component Type
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/component/get/type", notes = "To Get the Component Type", response = ComponentGetTypeSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/get/type", method = RequestMethod.POST)
	public @ResponseBody Message componentGetType(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("3", map, null);
		return message;
	}

	/**
	 * To Update The Component Settings
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/component/update/settings", notes = "To Update The Component Settings", response = ComponentUpdateSettingsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_cycles_to_log", value = "No of Cycle to Log", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "total_testing_hours", value = "Total Testing Hour ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "running_hours_per_day", value = "Running Hour per Day ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "total_available_days", value = "Total Available ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "StartDate ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "EndDate ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "update_reason_id ", value = "Required Update Reason Id. ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/update/settings", method = RequestMethod.POST)
	public @ResponseBody Message componentUpdateSettings(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("4", map, null);
		return message;
	}

	/**
	 * To Get the component List from Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/component/get/list", notes = "To Get the component List from Inventory", response = InventoryComponentGetListSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "StartDate", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "condition", value = "Condition ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_id", value = "Component_ID ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Page ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Page Size ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/component/get/list", method = RequestMethod.POST)
	public @ResponseBody Message inventoryComponentGetList(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("5", map, null);
		return message;
	}

	/**
	 * To Count Component Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/count/components", notes = "To Count Component Data", response = InventoryCountComponentsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_id", value = "Required Component ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/count/components", method = RequestMethod.POST)
	public @ResponseBody Message inventoryCountComponents(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("6", map, null);
		return message;
	}

	/**
	 * To Delete Inventory Location Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/delele/location", notes = "To Delete Inventory Location Data", response = InventoryDeleleLocationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Requires the ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/delele/location", method = RequestMethod.POST)
	public @ResponseBody Message inventoryDeleleLocation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("7", map, null);
		return message;
	}

	/**
	 * To Delete Unplanned Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/delete/unplanned", notes = "To Delete Unplanned Data", response = InventoryDeleteUnplannedSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Id ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/delete/unplanned", method = RequestMethod.POST)
	public @ResponseBody Message inventoryDeleteUnplanned(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("8", map, null);
		return message;
	}

	/**
	 * To Delete the Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/delete/vendor", notes = "To Delete the Vendor", response = InventoryDeleteVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Id ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/delete/vendor", method = RequestMethod.POST)
	public @ResponseBody Message inventoryDeleteVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("9", map, null);
		return message;
	}

	/**
	 * To Get Inventory Distribution Data
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/inventory/distribution", notes = "To Get Inventory Distribution Data", response = InventoryDistributionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_id", value = "Required File Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/distribution", method = RequestMethod.POST)
	public @ResponseBody Message inventoryDistribution(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("10", map, null);
		return message;
	}

	/**
	 * To Get Inventory Location Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/inventory/get/location", notes = "To Get Inventory Location Data", response = InventoryGetLocationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/get/location", method = RequestMethod.POST)
	public @ResponseBody Message inventoryGetLocation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("11", map, null);
		return message;
	}

	/**
	 * To Get Unplanned Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/get/unplanned", notes = "To Get Unplanned Data", response = InventoryGetUnplannedSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "End Date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/get/unplanned", method = RequestMethod.POST)
	public @ResponseBody Message inventoryGetUnplanned(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("12", map, null);
		return message;
	}

	/**
	 * To get Vendor from Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/get/vendor", notes = "To get Vendor from Inventory", response = InventoryGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message inventoryGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("13", map, null);
		return message;
	}

	/**
	 * Inventory to insert Location
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/insert/location", notes = "Inventory to insert Location", response = InventoryInsertLocationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "location", value = "Location ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "Address ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/insert/location", method = RequestMethod.POST)
	public @ResponseBody Message inventoryInsertLocation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("14", map, null);
		return message;
	}

	/**
	 * To Get Testing Type
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/testing/get/type", notes = "To Get Testing Type", response = TestingGetTypeSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/testing/get/type", method = RequestMethod.POST)
	public @ResponseBody Message testingGetType(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("15", map, null);
		return message;
	}

	/**
	 * To Get File Upload History
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/fileupload/get/history", notes = "To Get File Upload History", response = FileuploadGetHistorySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/fileupload/get/history", method = RequestMethod.POST)
	public @ResponseBody Message fileuploadGetHistory(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("16", map, null);
		return message;
	}

	/**
	 * To Insert file upload details
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/fileupload/insert/detail", notes = "To Insert file upload details", response = FileuploadInsertDetailSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_name", value = "Required File Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Required File Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_date", value = "Required File Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userid", value = "Required User Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userkey", value = "Required UserKey", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/fileupload/insert/detail", method = RequestMethod.POST)
	public @ResponseBody Message fileuploadInsertDetail(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("17", map, null);
		return message;
	}

	/**
	 * To Get Fault Sheet uploaded
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/fileupload/sheet/get/fault", notes = "To Get Fault Sheet uploaded", response = FileuploadSheetGetFaultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_id", value = "File Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/fileupload/sheet/get/fault", method = RequestMethod.POST)
	public @ResponseBody Message fileuploadSheetGetFault(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("18", map, null);
		return message;
	}

	/**
	 * To Get File Uploaded sheet Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/fileupload/sheet/get/inventory", notes = "To Get File Uploaded sheet Inventory", response = FileuploadSheetGetInventorySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_id", value = "File Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/fileupload/sheet/get/inventory", method = RequestMethod.POST)
	public @ResponseBody Message fileuploadSheetGetInventory(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("19", map, null);
		return message;
	}

	/**
	 * To Get File Uploaded Status
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/fileupload/update/status", notes = "To Get File Uploaded Status", response = FileuploadUpdateStatusSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_faulty", value = "Is Faulty", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_id", value = "File Id ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/fileupload/update/status", method = RequestMethod.POST)
	public @ResponseBody Message fileuploadUpdateStatus(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("20", map, null);
		return message;
	}

	/**
	 * To Get Inventory Component Update List
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/component/update/list", notes = "To Get Inventory Component Update List", response = InventoryComponentUpdateListSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required ID.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_name", value = "Required Component Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_type", value = "Required Component Type.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_name", value = "Required Vendor Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_number", value = "Required Part Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "hmcl_location", value = "Required HMCL Location.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_test_location", value = "Required Vendor Test Location", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "upload_date ", value = "Required Upload Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "added_to_planner ", value = "Required Planner", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/component/update/list", method = RequestMethod.POST)
	public @ResponseBody Message inventoryComponentUpdateList(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("21", map, null);
		return message;
	}

	/**
	 * To Get Component Delete List
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/component/delete/list", notes = "To Get Component Delete List", response = InventoryComponentDeleteListSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required ID.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/component/delete/list", method = RequestMethod.POST)
	public @ResponseBody Message inventoryComponentDeleteList(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("22", map, null);
		return message;
	}

	/**
	 * To Get Update Reason Detail
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/ineventory/get/update/reason", notes = "To Get Update Reason Detail", response = IneventoryGetUpdateReasonSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/ineventory/get/update/reason", method = RequestMethod.POST)
	public @ResponseBody Message ineventoryGetUpdateReason(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("25", map, null);
		return message;
	}

	/**
	 * To Get Component Setting By Id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/component/get/settings/by/id", notes = "To Get Component Setting By Id", response = ComponentGetSettingsByIdSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/get/settings/by/id", method = RequestMethod.POST)
	public @ResponseBody Message componentGetSettingsById(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("26", map, null);
		return message;
	}

	/**
	 * To Insert Unplaned in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@SuppressWarnings("unchecked")
	@ApiOperation(value = "/inventory/insert/unplanned", notes = "To Insert Unplaned in Inventory", response = InventoryInsertUnplannedSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_type_id", value = "Required Component Type Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_type ", value = "Required Testing Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_name", value = "Required Component Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_code", value = "Required Part Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_id", value = "Required Vendor Id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "hmcl_location_id", value = "Required HMCL Location Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_samples", value = "Required No Of sample.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_samples_sw", value = "Required No Of sample sw.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_samples_ds", value = "Required No Of sample ds.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required Description", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/insert/unplanned", method = RequestMethod.POST)
	public @ResponseBody Message inventoryInsertUnplanned(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("27", map, null);
		List<Map<String, Object>> Responsemap = (List<Map<String, Object>>) message.getObject();
		if (Responsemap.get(0).containsKey("status")) {
			message.setDescription(Responsemap.get(0).get("status").toString());
			message.setValid(false);
			return message;
		} else
			return message;

	}

	/**
	 * To Update Unplaned in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/inventory/update/unplanned", notes = "To Update Unplaned in Inventory", response = InventoryUpdateUnplannedSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_name", value = "Required Component Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_number ", value = "Required Part No", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_sample", value = "Required Noi Of Sample", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_sample_sw", value = "Required Noi Of Sample SW", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "no_of_sample_ds", value = "Required Noi Of Sample DS", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required Planner Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_type", value = "Required Testing Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required In ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "lot_no", value = "Required Lot no.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_id", value = "Required Vendor Id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "hmcl_location_id ", value = "Required HMCL Location Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/update/unplanned", method = RequestMethod.POST)
	public @ResponseBody Message inventoryUpdateUnplanned(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("28", map, null);
		return message;
	}

	/**
	 * To Insert Vendor in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/inventory/insert/vendor", notes = "To Insert Vendor in Inventory", response = InventoryInsertVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "code", value = "Required Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "Required  Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "location_id", value = "Required Testing Location", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/insert/vendor", method = RequestMethod.POST)
	public @ResponseBody Message inventoryInsertVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("31", map, null);
		return message;
	}

	/**
	 * To get the data of horn of Daily Report in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/horn/get/daily/report", notes = "To get the  data of horn of Daily Report in Inventory", response = HornGetDailyReportSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "slot_type", value = "Required Slot Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Page ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Page Size ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/horn/get/daily/report", method = RequestMethod.POST)
	public @ResponseBody Message hornGetDailyReport(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("32", map, null);
		return message;
	}

	/**
	 * To Get Planner Detail
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/planner/get/detail", notes = "To Get Planner Detail", response = PlannerGetDetailSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_number", value = "Required Planner Number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End date.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/planner/get/detail", method = RequestMethod.POST)
	public @ResponseBody Message plannerGetDetail(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("33", map, null);

		return message;
	}

	/**
	 * To Get Planner Equipment Detail
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/planner/equipment/get/detail", notes = "To Get Planner Equipment Detail", response = PlannerEquipmentGetDetailSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required Limit.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required Offset.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_number", value = "Required Planner Number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End date.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/planner/equipment/get/detail", method = RequestMethod.POST)
	public @ResponseBody Message plannerEquipmentGetDetail(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("34", map, null);

		return message;
	}

	/**
	 * To get the repeat data of horn of Daily Report Header in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/daily/report/get/horn/repeat/data", notes = "To get the repeat data of horn of Daily Report Header in Inventory", response = DailyReportGetHornRepeatDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/get/horn/repeat/data", method = RequestMethod.POST)
	public @ResponseBody Message reportGetRepeatData(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("48", map, null);
		return message;
	}

	/**
	 * To get the data of relay of Daily Report in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/daily/report/get/relay", notes = "To get the  data of relay of Daily Report in Inventory", response = DailyReportGetRelaySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "slot_type", value = "Required Slot Type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Page ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Page Size ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/get/relay", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportGetRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("35", map, null);
		return message;
	}

	/**
	 * To get the data of side stand of Daily Report in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/daily/report/get/side/stand", notes = "To get the  data of side stand of Daily Report in Inventory", response = DailyReportGetSideStandSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "Page ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "page_size", value = "Page Size ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/get/side/stand", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportGetSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("36", map, null);
		return message;
	}

	/**
	 * To get the repeat data of relay of Daily Report Header in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/daily/report/get/relay/repeat/data", notes = "To get the repeat data of relay of Daily Report Header in Inventory", response = DailyReportGetRelayRepeatDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/get/relay/repeat/data", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportGetRelayRepeatData(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("37", map, null);
		return message;
	}

	/**
	 * To get the repeat data of side stand of Daily Report Header in Inventory
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/daily/report/get/side/stand/repeat/data", notes = "To get the repeat data of side stand of Daily Report Header in Inventory", response = DailyReportGetSideStandRepeatDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/get/side/stand/repeat/data", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportGetSideStandRepeatData(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("38", map, null);
		return message;
	}

	/**
	 * To get the count of horns of Daily Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/daily/report/count/horn", notes = "To get the count of horns of Daily Report", response = DailyReportCountHornSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/count/horn", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportCountHorn(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("39", map, null);
		return message;
	}

	/**
	 * To get the count of relay of Daily Report
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/daily/report/count/relay", notes = "To get the count of relay of Daily Report", response = DailyReportCountRelaySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status ") })
	@RequestMapping(value = "/daily/report/count/relay", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportCountRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("40", map, null);
		return message;
	}

	/**
	 * To get the count of side stand of Daily Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/daily/report/count/side/stand", notes = "To get the count of side stand of Daily Report", response = DailyReportCountSideStandSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Required Device Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_date", value = "Required Report Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "Required Status ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/daily/report/count/side/stand", method = RequestMethod.POST)
	public @ResponseBody Message dailyReportCountSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("41", map, null);
		return message;
	}

	/**
	 * To get the Machine Parts
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/machine/get/parts", notes = "To get the Machine Parts ", response = MachineGetPartsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "machine_id", value = "Required Machine Id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_modified_date", value = "Required Machine last modified date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/machine/get/parts", method = RequestMethod.POST)
	public @ResponseBody Message machineGetParts(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("43", map, null);
		return message;
	}

	/**
	 * To get the Details of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/machine/get/horn", notes = "To get the Details of Horn", response = MachineGetHornSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_modified_date", value = "Required Machine last modified date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/machine/get/horn", method = RequestMethod.POST)
	public @ResponseBody Message machineGetHorn(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("44", map, null);
		return message;
	}

	/**
	 * To get the Details of Lock
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/machine/get/lock", notes = "To get the Details of Lock", response = MachineGetLockSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_modified_date", value = "Required Machine last modified date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/machine/get/lock", method = RequestMethod.POST)
	public @ResponseBody Message machineGetLock(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("45", map, null);
		return message;
	}

	/**
	 * To get the Details of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/machine/get/relay", notes = "To get the Details of Relay", response = HeroMachineGetRelaySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_modified_date", value = "Required Machine last modified date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/machine/get/relay", method = RequestMethod.POST)
	public @ResponseBody Message heroMachineGetRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("46", map, null);
		return message;
	}

	/**
	 * To get the Details of Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/machine/get/side/stand", notes = "To get the Details of Stand", response = MachineGetSideStandSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_modified_date", value = "Required Machine last modified date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/machine/get/side/stand", method = RequestMethod.POST)
	public @ResponseBody Message machineGetSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("47", map, null);
		return message;
	}

	/**
	 * To Get the Component Name *
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/component/get/name", notes = "To Get the Component Name", response = ComponentGetNameSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/get/name", method = RequestMethod.POST)
	public @ResponseBody Message componentGetName(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("50", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Horn Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/final/report/get/horn/data", notes = "To get the Final Report Data of Horn Header", response = FinalReportGetHornDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/data", method = RequestMethod.POST)
	public @ResponseBody Message finalReportCountHorn(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("53", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Relay Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/final/report/get/relay/data", notes = "To get the Final Report Data of Relay Header", response = FinalReportGetRelayDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/relay/data", method = RequestMethod.POST)
	public @ResponseBody Message finalReportCountRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("54", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Side Stand Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/side/stand/data", notes = "To get the Final Report Data of Side Stand Header", response = FinalReportGetSideStandDataSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/side/stand/data", method = RequestMethod.POST)
	public @ResponseBody Message finalReportCountSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("55", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/horn", notes = "To get the Final Report Data of Horn", response = FinalReportGetHornSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Required From Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHorn(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("56", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/relay", notes = "To get the Final Report Data of Relay", response = FinalReportGetRelaySwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/relay", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetRelay(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("57", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/side/stand", notes = "To get the Final Report Data of Side Stand", response = FinalReportGetSideStandSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/side/stand", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetSideStand(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("58", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Shower Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/tail/lamp/header", notes = "To get the Final Report Data of Shower Header", response = FinalReportShowerGetTailLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/tail/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetShowerData(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("64", map, null);
		return message;
	}

	/**
	 * To get the Final Report Data of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/tail/lamp", notes = "To get the Final Report Data of Shower", response = FinalReportShowerGetTailLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Report Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/tail/lamp", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetShower(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("65", map, null);
		return message;
	}

	/**
	 * To get the Final Report Observation Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/final/report/get/horn/observation", notes = "To get the Final Report Observation Data of Horn", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHornObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("66", map, null);
		return message;
	}

	/**
	 * To get the Final Report Insert Observation Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/horn/observation", notes = "To get the Final Report Insert Observation Data of Horn", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "Observation", value = "Required Observation of the Test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/horn/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInserttHornObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("67", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/ro/horn/get/testing/version", notes = "To get the Final Report Testing Version of Horn", response = FinalReportRoHornGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/ro/horn/get/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoHornGetTestingVersion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("68", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Lock
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/ro/lock/get/testing/version", notes = "To get the Final Report Testing Version of Lock", response = FinalReportRoLockGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/ro/lock/get/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoLockGetTestingVersion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("69", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/ro/relay/get/testing/version", notes = "To get the Final Report Testing Version of Relay", response = FinalReportRoRelayGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/ro/relay/get/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoRelayGetTestingVersion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("70", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/ro/side/stand/get/testing/version", notes = "To get the Final Report Testing Version of Side Stand", response = FinalReportRoSideStandGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/ro/side/stand/get/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoSideStandGetTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("71", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/tail/lamp/testing/Version", notes = "To get the Final Report Testing Version of Shower", response = FinalReportShowerGetTailLampTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/tail/lamp/testing/Version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoShowerGetTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("72", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Dust
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/ro/dust/get/testing/version", notes = "To get the Final Report Testing Version of Dust", response = FinalReportRoDustGetTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/ro/dust/get/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoDustGetTestingVersion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("73", map, null);
		return message;
	}

	/**
	 * To get the Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/lock/observation", notes = "To get the Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/lock/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetLockObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("75", map, null);
		return message;
	}

	/**
	 * To get the Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/relay/observation", notes = "To get the Final Report Observation", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/relay/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetRelayObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("76", map, null);
		return message;
	}

	/**
	 * To get the Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/side/stand/observation", notes = "To get the Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/side/stand/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetSideStandObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("77", map, null);
		return message;
	}

	/**
	 * To get the Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/tail/lamp/observation", notes = "To get the Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/tail/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetShowerObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("78", map, null);
		return message;
	}

	/**
	 * To get the Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/dust/observation", notes = "To get the Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/dust/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetDustObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("79", map, null);
		return message;
	}

	/**
	 * To get the Final Report Before Test Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/horn/before/test/images", notes = "To get the Final Report Before Test Image ", response = FinalReportGetHornBeforeTestImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/before/test/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHornBeforeTestImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("80", map, null);
		return message;
	}

	/**
	 * To get the Final Report After Test Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/horn/after/test/images", notes = "To get the Final Report After Test Image", response = FinalReportGetHornAfterTestImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/after/test/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHornAfterTestImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("81", map, null);
		return message;
	}

	/**
	 * To get the Final Report Update Horn Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/update/horn/header", notes = "To get the Final Report Update Horn Header", response = FinalReportUpdateHornHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective ", value = "Required objective", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_details ", value = "Required Part Modification Details", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standart_condition ", value = "Required Test Standart Condition", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_actual_condition ", value = "Required Test Actual Condition", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/update/horn/header", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetUpdateHornHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("82", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * To Insert the Final Report Image Details
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/horn/insert/images", notes = "To Insert the Final Report Image Details", response = FinalReportHornInsertImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name  ", value = "Required Image Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path ", value = "Required Image Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description ", value = "Required Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test   ", value = "Required is Before Test Bit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/horn/insert/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHornInsertImage(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("83", map, null);
		return message;
	}

	/**
	 * To get the Final Report Get Horn Analysis Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/final/report/get/horn/analysis", notes = "To get the Final Report Get Horn Analysis  Data ", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/analysis", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHornAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("85", map, null);
		return message;
	}

	/**
	 * To get the Final Report Insert Analysis Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/horn/analysis", notes = "To get the Final Report Insert Analysis Data of Horn", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required Analysis of the Test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/horn/analysis", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInserttHornAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("87", map, null);
		return message;
	}

	/**
	 * To get the Final Report Get Horn Conclusion Data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/final/report/get/horn/conclusion", notes = "To get the Final Report Get Horn Conclusion  Data ", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHornConclusion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("86", map, null);
		return message;
	}

	/**
	 * To get the Final Report Insert Conclusion Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/horn/conclusion", notes = "To get the Final Report Insert Conclusion Data of Horn", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required Conclusion of the Test", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/horn/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInserttHornConclusion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("88", map, null);
		return message;
	}

	/**
	 * To get the Final Report Insert Conclusion Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/delete/horn/observation", notes = "To get the Final Report Insert Conclusion Data of Horn", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/delete/horn/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteHeroObservation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("89", map, null);
		return message;
	}

	/**
	 * To get the Final Report Insert Conclusion Data of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/delete/before/after/test/images", notes = "To get the Final Report Insert Conclusion Data of Horn", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/delete/before/after/test/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteHeroTestImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("90", map, null);
		return message;
	}

	/**
	 * To get the Final Report Signature List
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/signature", notes = "To get the Final Report Signature List", response = FinalReportGetSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/signature", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHeroGignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("91", map, null);
		return message;
	}

	/**
	 * To get the Final Report Signature By ID
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/signature/by/id", notes = "To get the Final Report Signature By ID", response = FinalReportGetSignatureByIdSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/signature/by/id", method = RequestMethod.POST)
	public @ResponseBody Message finalReportGetHeroGignatureById(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("92", map, null);
		return message;
	}

	/**
	 * To get the Final Report Delete Signature By ID
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/delete/signature", notes = "To get the Final Report Delete Signature By ID", response = FinalReportDeleteSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/delete/signature", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteHeroGignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("93", map, null);
		return message;
	}

	/**
	 * To the Final Report Insert Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/insert/signature", notes = "To  the Final Report Insert Signature ", response = FinalReportInsertSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path  ", value = "Required Image Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "name   ", value = "Required Image Name", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/insert/signature", method = RequestMethod.POST)
	public @ResponseBody Message finalReportInsertHeroTestImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("94", map, null);
		return message;
	}

	/**
	 * To Update the Final Report Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/update/final/submit", notes = "To Update the Final Report Submit", response = FinalReportUpdateFinalSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required Is Editable Bit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required Is Successfull", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/update/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message finalReportUpdatetHornSubmit(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("96", map, null);
		return message;
	}

	/**
	 * To the Final Report Update Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/update/signature", notes = "To  the Final Report Update Signature ", response = FinalReportUpdateSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path  ", value = "Required Image Path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "name   ", value = "Required Image Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id   ", value = "Required Image Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/update/signature", method = RequestMethod.POST)
	public @ResponseBody Message finalReportUpdateHeroTestImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("97", map, null);
		return message;
	}

	/**
	 * To Get the Dasboard KPI
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/dashboard/get/kpi", notes = "To  Get the Dasboard KPI", response = HeroDashboardGetKpiSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/dashboard/get/kpi", method = RequestMethod.POST)
	public @ResponseBody Message finalDashboardKpi(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("101", map, null);
		return message;
	}

	/**
	 * To Get Dasboard KPI Equipments
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/dashboard/get/kpi/equipments", notes = "To  Get Dasboard KPI Equipments ", response = HeroDashboardGetKpiEquipmentsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/dashboard/get/kpi/equipments", method = RequestMethod.POST)
	public @ResponseBody Message finalDashboardKpiEquipment(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("102", map, null);
		return message;
	}

	/**
	 * To Get Dasboard KPI Equipments
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/dashboard/get/kpi/testing/log/status", notes = "To  Get Dasboard KPI Equipments ", response = HeroDashboardGetKpiTestingLogStatusSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/dashboard/get/kpi/testing/log/status", method = RequestMethod.POST)
	public @ResponseBody Message finalDashboardKpiTestingLogStatus(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("103", map, null);
		return message;
	}

	/**
	 * Hero component Get Default Setting.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/component/get/default/settings", notes = "Hero component Get Default Setting.", response = HeroComponentGetDefaultSettingsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing", value = "Required testing column.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Required limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Required offset", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/component/get/default/settings", method = RequestMethod.POST)
	public @ResponseBody Message HeroComponentGetDefaultSettings(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("105", map, null);
		return message;
	}

	/**
	 * Hero Final Report Insert horn signature.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/horn/signature", notes = "Hero Final Report Insert horn signature.", response = HeroFinalReportInsertHornSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing Version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required testing By ID.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required Verified By ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required Approved By ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/horn/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertHornSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("106", map, null);
		return message;
	}

	/**
	 * Hero Final Report get Horn Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/horn/signature", notes = "Hero Final Report get Horn Signature", response = HeroFinalReportGetHornSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing Version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/horn/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetHornSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("107", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Get Tail Lamp Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/tail/lamp/analysis", notes = "Hero Final Report Shower Get Tail Lamp Analysis", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing Version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/tail/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetTailLampAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("108", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Get Tail Lamp Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/tail/lamp/result", notes = "Hero Final Report Shower Get Tail Lamp Result.", response = HeroFinalReportShowerGetTailLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing Version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/tail/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetTailLampResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("109", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Get Tail Lamp Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/tail/lamp/conclusion", notes = "Hero component Get Default Conclusion", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required Start Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required End Date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing Version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/tail/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetTailLampConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("110", map, null);
		return message;
	}

	/**
	 * Update Hero Final Report Shower Get Tail Lamp Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/update/tail/lamp/header", notes = "Update Hero Final Report Shower Get Tail Lamp Header", response = HeroFinalReportShowerUpdateTailLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_no", value = "Required inspection_lot_no.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_date", value = "Required inspection_lot_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_mfg_date", value = "Required part_mfg_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_qty", value = "Required inspection_lot_qty.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_type", value = "Required testing_type.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_detail", value = "Required part_modification_detail.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standard", value = "Required test_standard.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_condition", value = "Required in_test_condition.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_method", value = "Required test_method.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_duration", value = "Required test_duration.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/update/tail/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerUpdateTailLampHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("111", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}

		return message;
	}

	/**
	 * Update Hero Final Report Shower Get Tail Lamp Grid
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/update/tail/lamp", notes = "Update Hero Final Report Shower Get Tail Lamp Grid", response = HeroFinalReportShowerUpdateTailLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "id", value = "Required ID."),
			@ApiImplicitParam(name = "item1", value = "Required item1."),
			@ApiImplicitParam(name = "item2", value = "Required item2."),
			@ApiImplicitParam(name = "test_requirement_and_specification_item1", value = "Required test_requirement_and_specification_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_requirement_and_specification_item2", value = "Required test_requirement_and_specification_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_before_test_result_item1", value = "Required n1_before_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_before_test_result_item2", value = "Required n1_before_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_before_test_result_item1", value = "Required n2_before_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_before_test_result_item2", value = "Required n2_before_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_after_test_result_item1", value = "Required n1_after_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_after_test_result_item2", value = "Required n1_after_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_after_test_result_item1", value = "Required n2_after_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_after_test_result_item2", value = "Required n2_after_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_before_test_judgement", value = "Required n1_before_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_before_test_judgement", value = "Required n2_before_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_after_test_judgement", value = "Required n1_after_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_after_test_judgement", value = "Required n2_after_test_judgement.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/update/tail/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerUpdateTailLamp(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("112", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Get Tail Lamp Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/insert/tail/lamp/images", notes = "Insert Hero Final Report Shower Get Tail Lamp Image", response = HeroFinalReportShowerInsertTailLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required image_name.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required image_path.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required description.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is_before_test.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required testing_number.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/insert/tail/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertTailLampImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("113", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Get Tail Lamp Before Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/tail/lamp/before/test/images", notes = "Hero Final Report Shower Get Tail Lamp Before Image", response = HeroFinalReportShowerGetTailLampBeforeTestImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required is_first_component.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/tail/lamp/before/test/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetTailLampBeforeTestImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("114", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Get Tail Lamp After Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/tail/lamp/after/test/images", notes = "Hero Final Report Shower Get Tail Lamp After Image", response = HeroFinalReportShowerGetTailLampAfterTestImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required is_first_component.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/tail/lamp/after/test/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetTailLampAfterTestImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("115", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Get Tail Lamp Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/insert/tail/lamp/signature", notes = "Insert Hero Final Report Shower Get Tail Lamp Signature", response = HeroFinalReportShowerInsertTailLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required verified_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/insert/tail/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertTailLampSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("116", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Update Tail Lamp Final Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/update/tail/lamp/final/submit", notes = "Hero Final Report Shower Update Tail Lamp Final Submit", response = HeroFinalReportShowerUpdateTailLampFinalSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required verified_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/update/tail/lamp/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerUpdateTailLampFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("117", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Get Tail Lamp Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/get/tail/lamp/signature", notes = "Hero Final Report Shower Get Tail Lamp Signature", response = HeroFinalReportShowerGetTailLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/get/tail/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetTailLampSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("118", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Tail Lamp Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/tail/lamp/insert/analysis", notes = "Insert Hero Final Report Shower Get Tail Lamp Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/tail/lamp/insert/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerTailLampInsertAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("119", map, null);
		return message;
	}

	/**
	 * Delete Hero Final Report Shower Tail Lamp Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/tail/lamp/delete/images", notes = "Delete Hero Final Report Shower Get Tail Lamp Image", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/tail/lamp/delete/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerTailLampDeleteImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("120", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Tail Lamp Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/tail/lamp/insert/result", notes = "Hero Final Report Shower Insert Tail Lamp Result", response = HeroFinalReportShowerTailLampInsertResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/tail/lamp/insert/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerTailLampInsertResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("121", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Tail Lamp Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/tail/lamp/insert/conclusion", notes = "Hero Final Report Shower Insert Tail Lamp Conclusion.", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/tail/lamp/insert/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerTailLampInsertConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("122", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Tail Lamp Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/tail/lamp/insert/observation", notes = "Hero Final Report Shower Insert Tail Lamp Observation.", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/tail/lamp/insert/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerTailLampInsertObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("123", map, null);
		return message;
	}

	/**
	 * Hero Notification Settings Get Component.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/settings/get/component", notes = "Hero Notification Settings Get Component.", response = HeroNotificationSettingsGetComponentSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/settings/get/component", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationSettingsGetComponent(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("124", map, null);
		return message;
	}

	/**
	 * Hero Notification Settings Get Component Parameter
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/settings/get/component/parameter", notes = "Hero Notification Settings Get Component Parameter", response = HeroNotificationSettingsGetComponentParameterSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_id", value = "Required component id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/settings/get/component/parameter", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationSettingsGetComponentParameter(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("125", map, null);
		return message;
	}

	/**
	 * Notification Settings Insert Rule
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/settings/insert/rule", notes = "Notification Settings Insert Rule", response = HeroNotificationSettingsInsertRuleSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_id", value = "Required component id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "parameter_name", value = "Required parameter_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "zero_cycle_count", value = "Required zero_cycle_count", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/settings/insert/rule", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationSettingsInsertRule(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("126", map, null);
		return message;
	}

	/**
	 * Hero Notification Settings Get Rules
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/settings/get/rules", notes = "Hero Notification Settings Get Rules", response = HeroNotificationSettingsGetRulesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_id", value = "Required component id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/settings/get/rules", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationSettingsGetRules(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("127", map, null);
		return message;
	}

	/**
	 * Hero Notification Settings Update Rule
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/settings/update/rule", notes = "Hero Notification Settings Update Rule", response = HeroNotificationSettingsUpdateRuleSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required In ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "zero_cycle_count", value = "Required zero_cycle_count", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "parameter_name", value = "Required parameter_name", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/settings/update/rule", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationSettingsUpdateRule(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("128", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Deletre Tail Lamp Observation.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/delete/tail/lamp/observation", notes = "Delete Hero Final Report Shower  Tail Lamp Observation.", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_id", value = "Required In ID", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/delete/tail/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerDeleteTailLampObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("129", map, null);
		return message;
	}

	/**
	 * To get all notification
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/get/all", notes = "To get all notification", response = HeroNotificationGetAllSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userKey", value = "Required user key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Required user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Required From Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "to_date ", value = "Required to Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "filter_type ", value = "Required filter_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/get/all", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationGetAll(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("130", map, null);
		return message;
	}

	/**
	 * To get all Alerts
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/get/all/alert", notes = "To get all Alerts", response = HeroNotificationGetAllAlertSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userKey", value = "Required user key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Required user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Required From Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "to_date ", value = "Required to Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "filter_type ", value = "Required filter_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/get/all/alert", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationGetAllAlert(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("131", map, null);
		return message;
	}

	/**
	 * To get Inventory HMCL Location
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/inventory/get/hmcl/location", notes = "To get Inventory  HMCL Location", response = HeroInventoryGetHmclLocationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/inventory/get/hmcl/location", method = RequestMethod.POST)
	public @ResponseBody Message heroInventoryGetHmclLocation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("132", map, null);
		return message;
	}

	/**
	 * To get Escalation Level
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/escalation/get/escalationlevel", notes = "To get Escalation Level", response = HeroNotificationEscalationGetEscalationlevelSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/escalation/get/escalationlevel", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationEscalationGetEscalationlevel(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("133", map, null);
		return message;
	}

	/**
	 * To add Escalation Level
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/escalation/add/escalationlevel", notes = "To add Escalation Level", response = HeroNotificationEscalationAddEscalationlevelSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_code_id", value = "Required notification_code_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Required email", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sms", value = "Required sms", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "duration", value = "Required duration", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/escalation/add/escalationlevel", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationEscalationAddEscalationlevel(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("134", map, null);
		return message;
	}

	/**
	 * To update Escalation Level
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/escalation/update/escalationlevel", notes = "To update Escalation Level", response = HeroNotificationEscalationUpdateEscalationlevelSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_code_id", value = "Required notification_code_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "escalation_level_id", value = "Required escalation_level_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Required email", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sms", value = "Required sms", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "duration", value = "Required duration", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/escalation/update/escalationlevel", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationEscalationUpdateEscalationlevel(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("135", map, null);
		return message;
	}

	/**
	 * To insert HMCL Location
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/inventory/insert/hmcl/location", notes = "To insert HMCL Location", response = HeroInventoryInsertHmclLocationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_location", value = "Required in_location", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_address", value = "Required in_address", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/inventory/insert/hmcl/location", method = RequestMethod.POST)
	public @ResponseBody Message heroInventoryInsertHmclLocation(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("136", map, null);
		return message;
	}

	/**
	 * To insert Action of notification
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/action/insert", notes = "To insert Action of notification", response = HeroNotificationActionInsertSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_id", value = "Required notification_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_code", value = "Required notification_code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_action", value = "Required notification_action", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "additional_parameters", value = "Required additional_parameters", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/action/insert", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationActionInsert(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("137", map, null);
		return message;
	}

	/**
	 * To get all notification code
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/get/notificationcodes", notes = "To get all notification code", response = HeroNotificationGetNotificationcodesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/get/notificationcodes", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationGetNotificationcodes(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("138", map, null);
		return message;
	}

	/**
	 * To delete Escalation Level
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/escalation/delete/escalationlevel", notes = "To delete Escalation Level", response = HeroNotificationEscalationDeleteEscalationlevelSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "escalation_level_id", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_code_id", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/escalation/delete/escalationlevel", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationEscalationDeleteEscalationLevel(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("140", map, null);
		return message;
	}

	/**
	 * To get Relay Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/relay/analysis", notes = "To get Relay Final Report Analysis", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/relay/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetRelayAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("141", map, null);
		return message;
	}

	/**
	 * To get Relay Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/relay/conclusion", notes = "To get Relay Final Report Conclusion", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/relay/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetRelayConclusion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("142", map, null);
		return message;
	}

	/**
	 * To get Relay Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/relay/result", notes = "To get Relay Final Report Result", response = HeroFinalReportGetRelayResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/relay/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetRelayResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("143", map, null);
		return message;
	}

	/**
	 * To get Relay Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/relay/images", notes = "To get Relay Final Report Images", response = HeroFinalReportGetRelayImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required is_first_component.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before", value = "Required is_before.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/relay/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRetRelayImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("144", map, null);
		return message;
	}

	/**
	 * To get Relay Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/relay/signature", notes = "To get Relay Final Report Signature", response = HeroFinalReportGetRelaySignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/relay/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetRelaySignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("145", map, null);
		return message;
	}

	/**
	 * To insert Relay Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/relay/images", notes = "To insert Relay Final Report Images", response = HeroFinalReportInsertRelayImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required image_name.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required image_path.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required description.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is_before_test.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_index", value = "Required component_index.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/relay/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertRelayImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("146", map, null);
		return message;
	}

	/**
	 * To insert Relay Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/relay/analysis", notes = "To insert Relay Final Report Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required analysis.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/relay/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertRelayAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("147", map, null);
		return message;
	}

	/**
	 * To insert Relay Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/relay/conclusion", notes = "To insert Relay Final Report Conclusion ", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required conclusion.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/relay/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertRelayConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("148", map, null);
		return message;
	}

	/**
	 * To insert Relay Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/relay/observation", notes = "To insert Relay Final Report Observation", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required observation.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/relay/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertRelayObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("149", map, null);
		return message;
	}

	/**
	 * To insert Relay Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/relay/result", notes = "To insert Relay Final Report Result", response = HeroFinalReportInsertRelayResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required result.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/relay/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertRelayResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("150", map, null);
		return message;
	}

	/**
	 * To insert Relay Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/relay/signature", notes = "To insert Relay Final Report Signature", response = HeroFinalReportInsertRelaySignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required verified_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/relay/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertRelaySignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("151", map, null);
		return message;
	}

	/**
	 * To delete Relay Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/delete/relay/observation", notes = "To delete Relay Final Report Observation", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/delete/relay/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDeleteRelayObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("152", map, null);
		return message;
	}

	/**
	 * To delete Relay Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/delete/relay/images", notes = "To delete Relay Final Report Images", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/delete/relay/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDeleteRelayImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("153", map, null);
		return message;
	}

	/**
	 * To update Relay Final Report Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/update/relay/header", notes = "To update Relay Final Report Header", response = HeroFinalReportUpdateRelayHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_mfg_date", value = "Required part_mfg_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_details", value = "Required part_modification_details.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standart", value = "Required test_standart.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_condition_mehtod", value = "Required test_condition_mehtod.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/update/relay/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportUpdateRelayHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("154", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * To update Relay Final Report Final Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/update/relay/final/submit", notes = "To update Relay Final Report Final Submit", response = HeroFinalReportUpdateRelayFinalSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required is_editable.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Required from_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number", value = "Required test_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required is_succesful.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/update/relay/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportUpdateRelayFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("155", map, null);
		return message;
	}

	/**
	 * To insert User Seen Notification Status
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/insert/user/notification/seen/status", notes = "To insert User Seen Notification Status", response = HeroNotificationInsertUserNotificationSeenStatusSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "notification_id", value = "Required notification_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userid", value = "Required userid.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Required user_key.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/insert/user/notification/seen/status", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationInsertUserNotificationSeenStatus(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("157", map, null);
		return message;
	}

	/**
	 * To Get Screw Setting.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/get/horn/screw/seting", notes = "To  Get Screw Setting.", response = FinalReportGetHornScrewSetingSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/get/horn/screw/seting", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportScrewSetting(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("158", map, null);
		return message;
	}

	/**
	 * Inventory Component Get Archive
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/component/get/archive", notes = "Inventory Component Get Archive", response = InventoryComponentGetArchiveSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/component/get/archive", method = RequestMethod.POST)
	public @ResponseBody Message inventoryComponentGetArchive(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("160", map, null);
		return message;
	}

	/**
	 * Inventory Component Update Action
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/component/update/action", notes = "Inventory Component  Update Action", response = InventoryComponentUpdateActionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted ", value = "Required is deleted .", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required id .", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/component/update/action", method = RequestMethod.POST)
	public @ResponseBody Message inventoryComponentUpdateAction(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("161", map, null);
		return message;
	}

	/**
	 * To Get Dashboard Get Performance Kpi
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/dashboard/get/performance/kpi", notes = "To  Get Dashboard Get Performance Kpi", response = DashboardGetPerformanceKpiSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/dashboard/get/performance/kpi", method = RequestMethod.POST)
	public @ResponseBody Message dashboardGetPerformanceKpi(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("162", map, null);
		return message;
	}

	/**
	 * To Get Dashboard Get Performance Kpi Alert Notification
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/dashboard/get/performance/kpi/alert/notification", notes = "To  Get Dashboard Get Performance Kpi Alert Notification", response = DashboardGetPerformanceKpiAlertNotificationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/dashboard/get/performance/kpi/alert/notification", method = RequestMethod.POST)
	public @ResponseBody Message dashboardGetPerformanceKpiAlertNotification(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCallingMultipleResult("163", map, null, 2);
		return message;
	}

	/**
	 * To Get Dashboard Get Performance Kpi Alert Notification
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/dashboard/get/performance/kpi/alerts", notes = "To  Get Dashboard Get Performance Kpi Alert Notification", response = DashboardGetPerformanceKpiAlertsSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/dashboard/get/performance/kpi/alerts", method = RequestMethod.POST)
	public @ResponseBody Message dashboardGetPerformanceKpiAlertNotificationTwo(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCallingMultipleResult("164", map, null, 2);
		return message;
	}

	/**
	 * To get Side Stand Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/side/stand/analysis", notes = "To get Side Stand Final Report Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/side/stand/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetSideStandAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("166", map, null);
		return message;
	}

	/**
	 * To get Side Stand Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/side/stand/conclusion", notes = "To get Side Stand Final Report Conclusion", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/side/stand/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetSideStandConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("167", map, null);
		return message;
	}

	/**
	 * To get Side Stand Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/side/stand/result", notes = "To get Side Stand Final Report Result", response = HeroFinalReportGetSideStandResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/side/stand/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetSideStandResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("169", map, null);
		return message;
	}

	/**
	 * To get Side Stand Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/side/stand/images", notes = "To get Side Stand Final Report Images", response = HeroFinalReportGetSideStandImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required is_first_component.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before", value = "Required is_before.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/side/stand/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportSideStandImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("168", map, null);
		return message;
	}

	/**
	 * To get Side Stand Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/get/side/stand/signature", notes = "To get Side Stand Final Report Signature", response = HeroFinalReportGetSideStandSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/side/stand/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetSideStandSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("170", map, null);
		return message;
	}

	/**
	 * To insert Side Stand Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/side/stand/images", notes = "To insert Side Stand Final Report Images", response = HeroFinalReportInsertSideStandImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required image_name.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required image_path.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required description.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is_before_test.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_index", value = "Required component_index.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/side/stand/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertSideStandImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("173", map, null);
		return message;
	}

	/**
	 * To insert Side Stand Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/side/stand/analysis", notes = "To insert Side Stand Final Report Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required analysis.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/side/stand/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertSideStandAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("171", map, null);
		return message;
	}

	/**
	 * To insert Side Stand Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/side/stand/conclusion", notes = "To insert Side Stand Final Report Conclusion", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required conclusion.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/side/stand/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertSideStandConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("172", map, null);
		return message;
	}

	/**
	 * To insert Side Stand Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/side/stand/observation", notes = "To insert Side Stand Final Report Observation ", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required observation.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/side/stand/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertSideStandObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("174", map, null);
		return message;
	}

	/**
	 * To insert Side Stand Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/side/stand/result", notes = "To insert Side Stand Final Report Result", response = HeroFinalReportInsertSideStandResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required result.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/side/stand/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertSideStandResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("175", map, null);
		return message;
	}

	/**
	 * To insert Side Stand Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/insert/side/stand/signature", notes = "To insert Side Stand Final Report Signature", response = HeroFinalReportInsertSideStandSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required verified_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/insert/side/stand/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportInsertSideStandSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("176", map, null);
		return message;
	}

	/**
	 * To update Side Stand Final Report Header
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/update/side/stand/header", notes = "To update Side Stand Final Report Header", response = HeroFinalReportUpdateSideStandHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_mfg_date", value = "Required part_mfg_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_details", value = "Required part_modification_details.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standart", value = "Required test_standart.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_condition_mehtod", value = "Required test_condition_mehtod.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_part_code", value = "Required vendor_part_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_no", value = "Required inspection_lot_no.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_duration", value = "Required test_duration.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_cycle", value = "Required test_cycle.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/update/side/stand/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportUpdateSideStandHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("179", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * To update Side Stand Final Report Final Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/update/side/stand/final/submit", notes = "To update Side Stand Final Report Final Submit", response = HeroFinalReportUpdateSideStandFinalSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required is_editable.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Required from_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number", value = "Required test_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required is_succesful.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/update/side/stand/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportUpdateSideStandFinalSubmit(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("178", map, null);
		return message;
	}

	/**
	 * To delete Side Stand Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/delete/side/stand/observation", notes = "To delete Side Stand Final Report Observation", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/delete/side/stand/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDeleteSideStandObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("180", map, null);
		return message;
	}

	/**
	 * To delete Side Stand Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/delete/side/stand/images", notes = "To delete Side Stand Final Report Images", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/delete/side/stand/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDeleteSideStandImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("181", map, null);
		return message;
	}

	/**
	 * To Get Planner Success Status
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/planner/update/success/status", notes = "To Get Planner Success Status", response = PlannerUpdateSuccessStatusSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_no", value = "Required Planner Number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "prepared_by_id", value = "Required Prepared by ID.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required Approved by ID.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/planner/update/success/status", method = RequestMethod.POST)
	public @ResponseBody Message plannerEquipmentUpdateSuccessStatus(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("182", map, null);

		return message;
	}

	/**
	 * To Get Planner Success Status Detail
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/planner/update/success/status/detail", notes = "To Get Planner Success Status Detail", response = PlannerUpdateSuccessStatusDetailSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_no", value = "Required Planner Number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required Planner Version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/planner/update/success/status/detail", method = RequestMethod.POST)
	public @ResponseBody Message plannerEquipmentUpdateSuccessStatusDetail(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("183", map, null);

		return message;
	}

	/**
	 * To delete Inventory Archive
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/delete/archive", notes = "To delete Inventory Archive", response = InventoryDeleteArchiveSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/delete/archive", method = RequestMethod.POST)
	public @ResponseBody Message heroInventoryDeleteArchive(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("184", map, null);
		return message;
	}

	/**
	 * To get no of Sample Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/get/no/of/sample/shower", notes = "To get no of Sample Shower", response = InventoryGetNoOfSampleShowerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_type_id", value = "Required component_type_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/get/no/of/sample/shower", method = RequestMethod.POST)
	public @ResponseBody Message heroInventoryGetNoOfSampleShower(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("185", map, null);
		return message;
	}

	/**
	 * To get no of Sample Dust
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/get/no/of/sample/dust", notes = "To get no of Sample Dust", response = InventoryGetNoOfSampleDustSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_type_id", value = "Required component_type_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/get/no/of/sample/dust", method = RequestMethod.POST)
	public @ResponseBody Message heroInventoryGetNoOfSampleDust(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("186", map, null);
		return message;
	}

	/**
	 * To get no of Sample RO
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/inventory/get/no/of/sample/ro", notes = "To get no of Sample RO", response = InventoryGetNoOfSampleRoSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_type_id", value = "Required component_type_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/inventory/get/no/of/sample/ro", method = RequestMethod.POST)
	public @ResponseBody Message heroInventoryGetNoOfSampleRo(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("187", map, null);
		return message;
	}

	/**
	 * To get component setting update Default value
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/component/setting/update/default/value", notes = "To get component setting update Default value.", response = ComponentSettingUpdateDefaultValueSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/component/setting/update/default/value", method = RequestMethod.POST)
	public @ResponseBody Message heroComponentSettingUpdateDefaultValue(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("188", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Grid
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp", notes = "To get Dust Head Final Report Grid", response = FinalReportDustGetHeadLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadGrid(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("189", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/analysis", notes = "To get Dust Head Final Report Analysis", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("190", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/conclusion", notes = "To get Dust Head Final Report Conclusion", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("191", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/header", notes = "To get Dust Head Final Report Header", response = FinalReportDustGetHeadLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("192", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/images", notes = "To get Dust Head Final Report Images", response = FinalReportDustGetHeadLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_component_index", value = "Required is_component_index.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before", value = "Required is_before.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadImage(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("193", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Observation
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/observation", notes = "To get Dust Head Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("194", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/result", notes = "To get Dust Head Final Report Result", response = FinalReportDustGetHeadLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetHeadResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("195", map, null);
		return message;
	}

	/**
	 * To get Dust Head Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/head/lamp/signature", notes = "To get Dust Head Final Report Signature", response = FinalReportDustGetHeadLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/head/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetDustHeadSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("196", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Dust Insert Head Lamp Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/head/lamp/images", notes = "Insert Hero Final Report Dust Insert Head Lamp Image", response = FinalReportDustInsertHeadLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required image_name.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required image_path.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required description.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is_before_test.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required testing_number.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/head/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertHeadLampImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("199", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Dust Insert Head Lamp Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/head/lamp/signature", notes = "Insert Hero Final Report Dust Insert Head Lamp Signature", response = FinalReportDustInsertHeadLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required verified_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/head/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertHeadLampSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("202", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Tail Lamp Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/head/lamp/analysis", notes = "Insert Hero Final Report Dust Insert Head Lamp Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/head/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertHeadAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("197", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Tail Lamp Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/head/lamp/result", notes = "Hero Final Report Shower Insert Tail Lamp Result", response = FinalReportDustInsertHeadLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/head/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertHeadResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("201", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Tail Lamp Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/head/lamp/conclusion", notes = "Hero Final Report Shower Insert Tail Lamp Conclusion.", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/head/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertHeadConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("198", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Tail Lamp Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/head/lamp/observation", notes = "Hero Final Report Shower Insert Tail Lamp Observation.", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/head/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertHeadObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("200", map, null);
		return message;
	}

	/**
	 * To Delete Final Report Dust Head Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/delete/head/lamp/images", notes = "To Delete Final Report Dust Head Image", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/delete/head/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteDustHeadImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("203", map, null);
		return message;
	}

	/**
	 * To Update the Final Report Dust Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/update/dust/final/submit", notes = "To Update the Final Report Dust Submit", response = FinalReportUpdateDustFinalSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required Is Editable Bit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required Is Successfull", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/update/dust/final/submit", method = RequestMethod.POST)
	public @ResponseBody Message finalReportUpdatetDustHeadSubmit(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("206", map, null);
		return message;
	}

	/**
	 * 
	 * Update Hero Final Report Shower Get Tail Lamp Grid
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/head/lamp", notes = "Update Hero Final Report Shower Get Tail Lamp Grid", response = HeroFinalReportDustUpdateHeadLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "id", value = "Required ID."),
			@ApiImplicitParam(name = "items", value = "Required items."),
			@ApiImplicitParam(name = "test_requirement_and_specification", value = "Required test_requirement_and_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "before_test_result_n1 ", value = "Required n1_before_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "before_test_result_n2 ", value = "Required n1_before_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "after_test_result_n1 ", value = "Required n1_after_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "after_test_result_n2 ", value = "Required n1_after_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "age_drop_luminious_ensity_n1 ", value = "Required age_drop_luminious_ensity_n1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "age_drop_luminious_ensity_n2 ", value = "Required age_drop_luminious_ensity_n2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "judgement_n1 ", value = "Required n1_after_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "judgement_n2 ", value = "Required n2_after_test_judgement.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/head/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateHeadLamp(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("204", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * 
	 * Update Hero Final Report Shower Get Tail Lamp Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/head/lamp/header", notes = "Update Hero Final Report Shower Get Tail Lamp Header", response = HeroFinalReportDustUpdateHeadLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_no", value = "Required inspection_lot_no.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_date", value = "Required inspection_lot_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_detail", value = "Required part_modification_detail.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_condition_as_per_standard", value = "Required testing_condition_as_per_standard.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_condition_actual_test_condition", value = "Required testing_condition_actual_test_condition.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_duration", value = "Required test_duration.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standard", value = "Required test_standard.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/head/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateHeadLampHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("205", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * To Delete Final Report Dust Head Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/delete/head/lamp/observation", notes = "To Delete Final Report Dust Head Image", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/delete/head/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteDustHeadObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("207", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Grid
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp", notes = "To get Dust Tail Final Report Grid", response = FinalReportDustGetTailLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailGrid(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("209", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/analysis", notes = "To get Dust Tail Final Report Analysis", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailAnalysis(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("210", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/conclusion", notes = "To get Dust Tail Final Report Conclusion", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("211", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/header", notes = "To get Dust Tail Final Report Header", response = FinalReportDustGetTailLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("212", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/images", notes = "To get Tail Head Final Report Images", response = FinalReportDustGetTailLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_component_index", value = "Required is_component_index.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before", value = "Required is_before.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailImage(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("213", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/observation", notes = "To get Dust Tail Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("214", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/result", notes = "To get Dust Tail Final Report Result", response = FinalReportDustGetTailLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustGetTailResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("215", map, null);
		return message;
	}

	/**
	 * To get Dust Tail Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/get/tail/lamp/signature", notes = "To get Dust Tail Final Report Signature", response = FinalReportDustGetTailLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/get/tail/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetDustTailSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("216", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Dust Insert Tail Lamp Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/tail/lamp/images", notes = "Insert Hero Final Report Dust Insert Tail Lamp Image", response = FinalReportDustInsertTailLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required image_name.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required image_path.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required description.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is_before_test.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required testing_number.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/tail/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertTailLampImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("219", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Dust Insert Tail Lamp Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/tail/lamp/signature", notes = "Insert Hero Final Report Dust Insert Tail Lamp Signature", response = FinalReportDustInsertTailLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required verified_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/tail/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertTailLampSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("222", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Dust Tail Lamp Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/tail/lamp/analysis", notes = "Insert Hero Final Report Dust Insert Tail Lamp Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/tail/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertTailAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("217", map, null);
		return message;
	}

	/**
	 * Hero Final Report Dust Insert Tail Lamp Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/tail/lamp/result", notes = "Hero Final Report Dust Insert Tail Lamp Result", response = FinalReportDustInsertTailLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/tail/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertTailResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("221", map, null);
		return message;
	}

	/**
	 * Hero Final Report Dust Insert Tail Lamp Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/tail/lamp/conclusion", notes = "Hero Final Report Dust Insert Tail Lamp Conclusion.", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/tail/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertTailConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("218", map, null);
		return message;
	}

	/**
	 * Hero Final Report Dust Insert Tail Lamp Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/insert/tail/lamp/observation", notes = "Hero Final Report Dust Insert Tail Lamp Observation.", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/insert/tail/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustInsertTailObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("220", map, null);
		return message;
	}

	/**
	 * To Delete Final Report Dust Tail Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/delete/tail/lamp/images", notes = "To Delete Final Report Dust Tail Image", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/delete/tail/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteDustTailImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("223", map, null);
		return message;
	}

	/**
	 * To Update the Final Report Dust Tail Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/update/dust/final/tail/submit", notes = "To Update the Final Report Dust Tail Submit", response = FinalReportUpdateDustFinalTailSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required Is Editable Bit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required Is Successfull", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/update/dust/final/tail/submit", method = RequestMethod.POST)
	public @ResponseBody Message finalReportUpdatetDustTailSubmit(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("226", map, null);
		return message;
	}

	/**
	 * Update Hero Final Report Dust Get Tail Lamp Grid
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/tail/lamp", notes = "Update Hero Final Report Dust Get Tail Lamp Grid", response = HeroFinalReportDustUpdateTailLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "id", value = "Required ID."),
			@ApiImplicitParam(name = "items", value = "Required items."),
			@ApiImplicitParam(name = "test_requirement_and_specification", value = "Required test_requirement_and_specification", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "before_test_result_n1 ", value = "Required n1_before_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "before_test_result_n2 ", value = "Required n1_before_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "after_test_result_n1 ", value = "Required n1_after_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "after_test_result_n2 ", value = "Required n1_after_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "age_drop_luminious_ensity_n1 ", value = "Required age_drop_luminious_ensity_n1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "age_drop_luminious_ensity_n2 ", value = "Required age_drop_luminious_ensity_n2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "judgement_n1 ", value = "Required n1_after_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "judgement_n2 ", value = "Required n2_after_test_judgement.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/tail/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateTailLamp(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("224", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * Update Hero Final Report Dust Get Tail Lamp Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/update/tail/lamp/header", notes = "Update Hero Final Report Dust Get Tail Lamp Header", response = HeroFinalReportDustUpdateTailLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_no", value = "Required inspection_lot_no.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_date", value = "Required inspection_lot_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_detail", value = "Required part_modification_detail.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_condition_as_per_standard", value = "Required testing_condition_as_per_standard.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_condition_actual_test_condition", value = "Required testing_condition_actual_test_condition.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_duration", value = "Required test_duration.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standard", value = "Required test_standard.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/update/tail/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportDustUpdateTailLampHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("225", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * To Delete Final Report Dust Head Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/dust/delete/tail/lamp/observation", notes = "To Delete Final Report Dust Tail Observation", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/dust/delete/tail/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteDustTailObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("227", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Dust Tail
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/ro/dust/get/tail/testing/version", notes = "To get the Final Report Testing Version of Dust", response = FinalReportRoDustGetTailTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/ro/dust/get/tail/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoDustGetTailTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("228", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Grid
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp", notes = "To get Shower Head Final Report Grid", response = FinalReportShowerGetHeadLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadGrid(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("229", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/analysis", notes = "To get Shower Head Final Report Analysis", response = GenericFinalReportGetAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("230", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/conclusion", notes = "To get Shower Head Final Report Conclusion", response = GenericFinalReportGetConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("231", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/header", notes = "To get Shower Head Final Report Header", response = FinalReportShowerGetHeadLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadHeader(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("232", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Images
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/images", notes = "To get Tail Head Final Report Images", response = FinalReportShowerGetHeadLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_component_index", value = "Required is_component_index.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before", value = "Required is_before.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadImage(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("233", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/observation", notes = "To get Shower Head Final Report Observation", response = GenericFinalReportGetObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("234", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/result", notes = "To get Shower Head Final Report Result", response = FinalReportShowerGetHeadLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerGetHeadResult(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("235", map, null);
		return message;
	}

	/**
	 * To get Shower Head Final Report Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/lamp/signature", notes = "To get Shower Head Final Report Signature", response = FinalReportShowerGetHeadLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_id", value = "Required testing_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetDustSignature(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("236", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Insert Head Lamp Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/insert/head/lamp/images", notes = "Insert Hero Final Report Shower Insert Head Lamp Image", response = FinalReportShowerInsertHeadLampImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_name", value = "Required image_name.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Required image_path.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Required description.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_before_test", value = "Required is_before_test.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_number", value = "Required testing_number.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_first_component", value = "Required testing_number.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/insert/head/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertHeadLampImages(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("239", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Insert Head Lamp Signature
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/insert/head/lamp/signature", notes = "Insert Hero Final Report Shower Insert Head Lamp Signature", response = FinalReportShowerInsertHeadLampSignatureSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tested_by_id", value = "Required tested_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "verified_by_id", value = "Required verified_by_id.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved_by_id", value = "Required approved_by_id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/insert/head/lamp/signature", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertHeadLampSignature(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("242", map, null);
		return message;
	}

	/**
	 * Insert Hero Final Report Shower Head Lamp Analysis
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/insert/head/lamp/analysis", notes = "Insert Hero Final Report Shower Insert Head Lamp Analysis", response = GenericFinalReportInsertAnalysisSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "analysis", value = "Required Analysis", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/insert/head/lamp/analysis", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertHeadAnalysis(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("237", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Head Lamp Result
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/insert/head/lamp/result", notes = "Hero Final Report Shower Insert Head Lamp Result", response = FinalReportShowerInsertHeadLampResultSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "result", value = "Required result", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/insert/head/lamp/result", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertHeadResult(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("241", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Head Lamp Conclusion
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/insert/head/lamp/conclusion", notes = "Hero Final Report Shower Insert Head Lamp Conclusion.", response = GenericFinalReportInsertConclusionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "conclusion", value = "Required conclusion", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/insert/head/lamp/conclusion", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertHeadConclusion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("238", map, null);
		return message;
	}

	/**
	 * Hero Final Report Shower Insert Head Lamp Observation
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/insert/head/lamp/observation", notes = "Hero Final Report Shower Insert Head Lamp Observation.", response = GenericFinalReportInsertObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "observation", value = "Required observation", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Required start_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Required end_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required vendor_code.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_version", value = "Required testing_version.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/insert/head/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerInsertHeadObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("240", map, null);
		return message;
	}

	/**
	 * To Delete Final Report Shower Head Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/delete/head/lamp/images", notes = "To Delete Final Report Shower Head Image", response = GenericFinalReportDeleteImagesSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/delete/head/lamp/images", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteShowerHeadImages(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("243", map, null);
		return message;
	}

	/**
	 * To Update the Final Report Shower Head Submit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/update/shower/final/head/submit", notes = "To Update the Final Report Shower Head Submit", response = FinalReportUpdateShowerFinalHeadSubmitSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_editable", value = "Required Is Editable Bit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_number ", value = "Required Test Number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_succesful", value = "Required Is Successfull", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/update/shower/final/head/submit", method = RequestMethod.POST)
	public @ResponseBody Message finalReportUpdatetShowerHeadSubmit(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("246", map, null);
		return message;
	}

	/**
	 * Update Hero Final Report Shower Get Head Lamp Grid
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/update/head/lamp", notes = "Update Hero Final Report Shower Get Head Lamp Grid", response = HeroFinalReportShowerUpdateHeadLampSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "id", value = "Required ID."),
			@ApiImplicitParam(name = "item1", value = "Required item1."),
			@ApiImplicitParam(name = "item2", value = "Required item2."),
			@ApiImplicitParam(name = "test_requirement_and_specification_item1", value = "Required test_requirement_and_specification_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_requirement_and_specification_item2", value = "Required test_requirement_and_specification_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_before_test_result_item1", value = "Required n1_before_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_before_test_result_item2", value = "Required n1_before_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_before_test_result_item1", value = "Required n2_before_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_before_test_result_item2", value = "Required n2_before_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_after_test_result_item1", value = "Required n1_after_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_after_test_result_item2", value = "Required n1_after_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_after_test_result_item1", value = "Required n2_after_test_result_item1.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_after_test_result_item2", value = "Required n2_after_test_result_item2.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_before_test_judgement", value = "Required n1_before_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_before_test_judgement", value = "Required n2_before_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n1_after_test_judgement", value = "Required n1_after_test_judgement.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "n2_after_test_judgement", value = "Required n2_after_test_judgement.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/update/head/lamp", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerUpdateHeadLamp(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("244", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * Update Hero Final Report Shower Get Head Lamp Header
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/update/head/lamp/header", notes = "Update Hero Final Report Shower Get Head Lamp Header", response = HeroFinalReportShowerUpdateHeadLampHeaderSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_no", value = "Required inspection_lot_no.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_date", value = "Required inspection_lot_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_mfg_date", value = "Required part_mfg_date.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inspection_lot_qty", value = "Required inspection_lot_qty.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "testing_type", value = "Required testing_type.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "objective", value = "Required objective.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "part_modification_detail", value = "Required part_modification_detail.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_standard", value = "Required test_standard.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_test_condition", value = "Required in_test_condition.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_method", value = "Required test_method.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_duration", value = "Required test_duration.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Required id.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/update/head/lamp/header", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerUpdateHeadLampHeader(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("245", map, null);
		if (message.isValid()) {
			message.setDescription("Your Data is successfully updated in Database");
			return message;
		}
		return message;
	}

	/**
	 * To Delete Final Report Shower Head Image
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/delete/head/lamp/observation", notes = "To Delete Final Report Shower Head Observation", response = GenericFinalReportDeleteObservationSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/delete/head/lamp/observation", method = RequestMethod.POST)
	public @ResponseBody Message finalReportDeleteShowerHeadObservation(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("247", map, null);
		return message;
	}

	/**
	 * To get the Final Report Testing Version of Shower Head
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/final/report/shower/get/head/testing/version", notes = "To get the Final Report Testing Version of Shower Head", response = FinalReportShowerGetHeadTestingVersionSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Required Vendor Code", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/final/report/shower/get/head/testing/version", method = RequestMethod.POST)
	public @ResponseBody Message finalReportRoShowerGetHeadTestingVersion(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("248", map, null);
		return message;
	}

	/**
	 * To Get Holiday Calendar
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/calendar/get/holidays", notes = "To get the Calender for Holidays", response = HeroCalendarGetHolidaysSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/calendar/get/holidays", method = RequestMethod.POST)
	public @ResponseBody Message heroCalendarGetHolidays(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("249", map, null);
		return message;
	}

	/**
	 * To Update the Holiday
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/calendar/update/holidays", notes = "To Update the Calender for Holidays", response = HeroCalendarUpdateHolidaysSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "holiday ", value = "Required holiday", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "machine_type", value = "Required  machine_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/calendar/update/holidays", method = RequestMethod.POST)
	public @ResponseBody Message heroCalendarUpdateHolidays(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("250", map, null);
		return message;
	}

	/**
	 * To Delete the Holiday from calendar
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/calendar/delete/holidays", notes = "To Delete the Calender for Holidays", response = HeroCalendarDeleteHolidaysSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id ", value = "Required Id", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/calendar/delete/holidays", method = RequestMethod.POST)
	public @ResponseBody Message heroCalendarDeleteHolidays(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("251", map, null);
		return message;
	}

	/**
	 * To insert new Holiday in Calendar
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/calendar/insert/holidays", notes = "To Insert the Calender for Holidays", response = HeroCalendarInsertHolidaysSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "holiday ", value = "Required holiday", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "date ", value = "Required date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "machine_type", value = "Required  machine_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/calendar/insert/holidays", method = RequestMethod.POST)
	public @ResponseBody Message heroCalendarInsertHolidays(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("252", map, null);
		return message;
	}

	/**
	 * To recalculate the Planner
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/recalculate/planner", notes = "To get the Recalculated Planner", response = HeroRecalculatePlannerSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_no", value = "Required planner_no", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_version", value = "Required planner_version", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_date", value = "Required planner_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "planner_name", value = "Required planner_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "recalculate", value = "Required recalculate", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/recalculate/planner", method = RequestMethod.POST)
	public @ResponseBody Message heroRecalculateCalender(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("255", map, null);
		return message;
	}

}
