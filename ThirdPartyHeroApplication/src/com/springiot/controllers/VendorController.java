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
	 * Api To get Final Report Vendor.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/get/vendor", notes = "To get the Final Report Vendor", response = GenericFinalReportGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Here pass test Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Here pass test End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_name", value = "Here pass compenent name which is tested.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_name", value = "Here pass test name performed on the component.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/vendor", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetVendor(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("341", map, null);
		return message;
	}

	/**
	 * To get the Final Report Version.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/final/report/get/version", notes = "To get the Final Report Version", response = HeroFinalReportRoRelayGetVendorSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "start_date", value = "Here pass test Start Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Here pass test End Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "component_name", value = "Here pass compenent name which is tested.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "test_name", value = "Here pass test name performed on the component.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_code", value = "Here pass vendor code of the component.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/final/report/get/version", method = RequestMethod.POST)
	public @ResponseBody Message heroFinalReportGetVersion(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("342", map, null);
		return message;
	}
}
