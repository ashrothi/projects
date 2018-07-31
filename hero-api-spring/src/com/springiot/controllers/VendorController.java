/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling.
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
 * This class work as a controller which is used to create apis to Get Vendor
 * Component wise Procedure Calling.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "Hero Application ")
public class VendorController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get the Final Report Horn Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/ro/horn/get/vendor", notes = "To get the Final Report Horn Vendor", response = HeroFinalReportRoHornGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/ro/horn/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoHornGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("341", map, null);
		return message;
	}

	/**
	 * To get the Final Report Relay Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/ro/relay/get/vendor", notes = "To get the Final Report Relay Vendor", response = HeroFinalReportRoRelayGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/ro/relay/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoRelayGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("342", map, null);
		return message;
	}

	/**
	 * To get the Final Report Side Stand Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/ro/side/stand/get/vendor", notes = "To get the Final Report Side Stand Vendor", response = HeroFinalReportRoSideStandGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/ro/side/stand/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoSideStandGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("343", map, null);
		return message;
	}

	/**
	 * To get the Final Report Lock Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/ro/lock/get/vendor", notes = "To get the Final Report Lock Vendor", response = HeroFinalReportRoLockGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/ro/lock/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoLockGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("344", map, null);
		return message;
	}

	/**
	 * To get the Final Report Shower Tail Lamp Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/tail/lamp/get/vendor", notes = "To get the Final Report Shower Tail Lamp Vendor", response = HeroFinalReportShowerTailLampGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/tail/lamp/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoShowerTailLampGetVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("345", map, null);
		return message;
	}

	/**
	 * To get the Final Report Shower Head Lamp Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/head/lamp/get/vendor", notes = "To get the Final Report Shower Head Lamp Vendor", response = HeroFinalReportShowerHeadLampGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/head/lamp/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoShowerHeadLampGetVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("346", map, null);
		return message;
	}

	/**
	 * To get the Final Report Shower Front Winker Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/front/winker/get/vendor", notes = "To get the Final Report Shower front Winker Vendor", response = HeroFinalReportShowerFrontWinkerGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/front/winker/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoShowerFrontWinkerGetVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("347", map, null);
		return message;
	}

	/**
	 * To get the Final Report Shower Rear Winker Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/rear/winker/get/vendor", notes = "To get the Final Report Shower rear Winker Vendor", response = HeroFinalReportShowerRearWinkerGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/rear/winker/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoShowerRearWinkerGetVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("348", map, null);
		return message;
	}

	/**
	 * To get the Final Report Shower Starter Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/starter/relay/get/vendor", notes = "To get the Final Report Shower Starter Vendor", response = HeroFinalReportShowerStarterRelayGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/starter/relay/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoShowerStarterGetVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("349", map, null);
		return message;
	}

	/**
	 * To get the Final Report Dust Head Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/head/lamp/get/vendor", notes = "To get the Final Report Dust Head Vendor", response = GenericFinalReportGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/head/lamp/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoDustHeadGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("350", map, null);
		return message;
	}

	/**
	 * To get the Final Report Dust Tail Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/dust/tail/lamp/get/vendor", notes = "To get the Final Report Dust Tail Vendor", response = GenericFinalReportGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/dust/tail/lamp/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportRoDustTailGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("351", map, null);
		return message;
	}

	/**
	 * To get the Final Report Dust Tail Vendor
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/final/report/shower/speedometer/get/vendor", notes = "To get the Final Report Dust Tail Vendor", response = GenericFinalReportGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date ", value = "Required Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Required End Date", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/shower/speedometer/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportShowerSpeedometerGetVendor(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("372", map, null);
		return message;
	}

}
