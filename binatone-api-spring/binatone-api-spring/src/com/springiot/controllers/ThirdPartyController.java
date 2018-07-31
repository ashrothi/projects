/**
 * This package contain the controller class for Third Party Application apis.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.ThirdPartyServices;
import com.springiot.swagger.response.BinatoneModelAddFileSwagger;
import com.springiot.swagger.response.BinatoneModelGetFileSwagger;
import com.springiot.swagger.response.DeviceGetMetadataSwagger;
import com.springiot.swagger.response.DeviceGetModelCategoryServiceDatasourceSwagger;
import com.springiot.swagger.response.DeviceGetTagsByModelSwaggerResponse;
import com.springiot.swagger.response.DeviceModelGetAllSwagger;
import com.springiot.swagger.response.DeviceSearchSwagger;
import com.springiot.swagger.response.ExecuteCommandSwagger;
import com.springiot.swagger.response.ExecuteProfileCommandSwagger;
import com.springiot.swagger.response.PerformanceServicestatusDeviceGetAllSwagger;
import com.springiot.swagger.response.PerformanceserviceDeviceGetSingleLimitWithoutDataSwagger;
import com.springiot.swagger.response.RuleEngineDeviceGetByModelSwagger;
import com.springiot.swagger.response.ServiceInventoryStatusDeviceGetManyWithoutDataSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
	private ThirdPartyServices thirdPartyServices;

	/**
	 * To get all Service and Inverntory of particular Service Name and Data
	 * Source Of Device .
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
	@ApiOperation(value = "/service/inventory/status/device/get/many/without/data", notes = "To get all Service and Inverntory of particular Service Name and Data Source Of Device", response = ServiceInventoryStatusDeviceGetManyWithoutDataSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "service_name", value = "Requires Service Name of Model", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "data_source", value = "Requires Data SOurce of Model", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Requires Access Key of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/service/inventory/status/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetModelCategoryService(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request) {
		Message message = thirdPartyServices.serviceInventory(map, request);
		return message;
	}

	/**
	 * To Execute Command with Required particular Service Name and Data Source
	 * Of Device And Required Parameter are Mandatory and Additional Parameter
	 * will be according to the different commands
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
	@ApiOperation(value = "/execute/command/tr069", notes = "To Execute Command with Required particular Service Name and Data Source Of Device And Required Parameter are Mandatory and Additional Parameter will be according to the different commands", response = ExecuteCommandSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "command_name", value = "Requires the name of command", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "device_name", value = "Requires Device Name of Model", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "data", value = "Requires Json of Multiple Service Name and Data Sources", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Requires Access Key of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/execute/command/tr069", method = RequestMethod.POST)
	public @ResponseBody Message updateGetModelCategoryService(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request) {
		Message message = thirdPartyServices.updateServiceInventoryCommand(map, request);
		return message;
	}

	/**
	 * To Get the device Meta data
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
	@ApiOperation(value = "/device/get/metadata", notes = "To Get the device Meta data", response = DeviceGetMetadataSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Requires Access Key of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/device/get/metadata", method = RequestMethod.POST)
	public @ResponseBody Message updateGetXfusionMetaData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request) {
		Message message = thirdPartyServices.getXfusionMetaData(map, request);
		return message;
	}

	/**
	 * To Add the model file
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
	@ApiOperation(value = "/binatone/model/add/file", notes = "To Add the model file", response = BinatoneModelAddFileSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "file_name", value = "Requires file_name", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/binatone/model/add/file", method = RequestMethod.POST)
	public @ResponseBody Message binatoneModelAddFile(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.binatoneModelAddFile(map, request, response);
		return message;
	}

	/**
	 * To Get the device model file
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
	@ApiOperation(value = "/binatone/model/get/file", notes = "To Get the device model file", response = BinatoneModelGetFileSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/binatone/model/get/file", method = RequestMethod.POST)
	public @ResponseBody Message binatoneModelGetFile(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.binatoneModelGetFile(map, request, response);
		return message;
	}

	/**
	 * To Get Performance service status data of given device_id
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
	@ApiOperation(value = "/performance/servicestatus/device/get/all", notes = "To Get Performance service status data of given device_id", response = PerformanceServicestatusDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Requires Access Key of user", required = true, access = "query", paramType = "query", dataType = "String"), })
	@RequestMapping(value = "/performance/servicestatus/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceServicestatusDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.performanceDeviceGetAll(map, request);
		return message;
	}

	/**
	 * To Get Performance Service Data of Single device data without Limit
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
	@ApiOperation(value = "/performanceservice/device/get/single/limit/without/data", notes = "To Get Performance Service Data of Single device data without Limit", response = PerformanceserviceDeviceGetSingleLimitWithoutDataSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/performanceservice/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		Message message = thirdPartyServices.singleLimitWithoutdata(map, request);
		return message;
	}

	/**
	 * To Get the device's All model
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
	@ApiOperation(value = "/device/model/get/all", notes = "To Get the device's All model", response = DeviceModelGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Requires Access Key of user", required = true, access = "query", paramType = "query", dataType = "String"), })
	@RequestMapping(value = "/device/model/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceDeviceModelGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.DeviceModelGetAll(map, request);
		return message;
	}

	// ================
	/**
	 * To Get the device file
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
	@ApiOperation(value = "/device/search", notes = "To Get the device file", response = DeviceSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_model", value = "Requies device_model", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_country", value = "Requies device_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_state", value = "Requires device_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_city", value = "Requires device_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_tags", value = "Requires device_tags", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_alias", value = "Requires device_alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/device/search", method = RequestMethod.POST)
	public @ResponseBody Message deviceService(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.deviceService(map, request);
		return message;
	}

	/**
	 * To get the Model,Category and Their Service and Data Source
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
	@ApiOperation(value = "/device/get/model/category/service/datasource", notes = "To get the Model,Category and Their Service and Data Source", response = DeviceGetModelCategoryServiceDatasourceSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires User Device Id Model", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/device/get/model/category/service/datasource", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetModelCategoryServicesDataSource(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		Message message = thirdPartyServices.deviceGetModelCategoryServicesDataSource(map, request, response);
		return message;
	}

	/**
	 * To Execute Command with Required particular Service Name and Data Source
	 * Of Device And Required Parameter are Mandatory and Additional Parameter
	 * will be according to the different commands
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
	@ApiOperation(value = "/execute/profile/command", notes = "To Execute Command with Required particular Service Name and Data Source Of Device And Required Parameter are Mandatory and Additional Parameter will be according to the different commands", response = ExecuteProfileCommandSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id of User", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_name", value = "Requires the device name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "profile_type", value = "Requires profile_type of command", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "command_name", value = "Requires command Name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key", value = "Requires command Name", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/execute/profile/command", method = RequestMethod.POST)
	public @ResponseBody Message executeProfileCommand(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.executeProfileCommand(map, request, response);
		return message;
	}

	/**
	 * To retrieve tags on the basis of model,in this API,we'll call xFusion
	 * Platform API and set the response after calling API
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
	@ApiOperation(value = "/device/get/tags/by/model", notes = "To get device tags by model", response = DeviceGetTagsByModelSwaggerResponse.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key "),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "device_model", value = "Requires the device model"),
			@ApiImplicitParam(name = "tags", value = "Requires the tags values"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/device/get/tags/by/model", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetTagsByModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request) {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = thirdPartyServices.DeviceGetTagsByModel(map, request);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve devices on the basis of model,in this API,we'll call xFusion
	 * Platform API and set the response after calling API
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
	@ApiOperation(value = "/rule/engine/device/get/by/model", notes = "To get device tags by model", response = RuleEngineDeviceGetByModelSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key "),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/rule/engine/device/get/by/model", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceGetByModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request) {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = thirdPartyServices.ruleEngineDeviceGetByModel(map, request);
		/*
		 * Return the response message.
		 */
		return message;

	}
}
