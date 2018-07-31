/**
 * This package contains the Controller for GMR Application.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * To Import Classes to access their functionality
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericServices;
import com.springiot.swagger.response.AlertDeviceTypeGetAllLimitSwagger;
import com.springiot.swagger.response.DeviceGetMetadataStatusByTypeLimitSwagger;
import com.springiot.swagger.response.ExcelDownloadSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Generic
 * Procedure Calling.
 * 
 * @author tanvigarg
 *
 */
@Controller
public class GenericController {

	@Autowired
	private GenericServices genericServices;

	/**
	 * To Get the device Meta data status on the basis of limit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/device/get/metadata/status/by/type/limit", notes = "To Get the device Meta data", response = DeviceGetMetadataStatusByTypeLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_type", value = "Requires the Device type", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "in_condition", value = "Requires condition for server side filtering", required = true, access = "query", paramType = "query", dataType = "Int") })
	@RequestMapping(value = "/device/get/metadata/status/by/type/limit", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByTypeLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericServices.getMetadataStatusByTypeLimit(map, request, response);
		return message;
	}

	/**
	 * To Get the alerts in the basis of devices
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/alert/device/type/get/all/limit", notes = "To Get the device Meta data", response = AlertDeviceTypeGetAllLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_type", value = "Requires the Device type", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "is_correlated", value = "Requires the is correlated bit for Correlated Rules", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for server side filtering", required = true, access = "query", paramType = "query", dataType = "Int") })
	@RequestMapping(value = "/alert/device/type/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message alertDeviceTypeGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request) {
		Message message = genericServices.alertDeviceTypeGetAllLimit(map, request);
		return message;
	}

	/**
	 * To Get the device Meta data status on the basis of limit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/excel/download", notes = "To Get the device Meta data", response = ExcelDownloadSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_type", value = "Requires the Device type", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "in_condition", value = "Requires condition for server side filtering", required = true, access = "query", paramType = "query", dataType = "Int") })
	@RequestMapping(value = "/excel/download", method = RequestMethod.POST)
	public @ResponseBody Message excelDownload(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericServices.excelDownload(map, request, response);
		return message;
	}

	/**
	 * To Get the device Meta data status on the basis of limit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/get/device/by/user", notes = "To Get the device Meta data", response = DeviceGetMetadataStatusByTypeLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/get/device/by/user", method = RequestMethod.POST)
	public @ResponseBody Message getDeviceByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericServices.getDeviceByUser(map, request, response);
		return message;
	}

	/**
	 * To Get the device Meta data status on the basis of limit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/device/get/metadata/status/by/type/limit/by/registration/no", notes = "To Get the device Meta data", response = DeviceGetMetadataStatusByTypeLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "reg_no", value = "Requires reg_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_type", value = "Requires the Device type", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "in_condition", value = "Requires condition for server side filtering", required = true, access = "query", paramType = "query", dataType = "Int") })
	@RequestMapping(value = "/device/get/metadata/status/by/type/limit/by/registration/no", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByTypeLimitByRegisteration(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		Message message = genericServices.getMetadataStatusByTypeLimitByRegistrationNumber(map, request, response);
		return message;
	}
}
