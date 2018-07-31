/**
 * This package contain the controller class to create APIs for inventory data.
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

import com.springiot.controllers.ignoreControllers.DeviceInventoryControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         APIs to retrieve the inventory(device) metadata from xFusion
 *         database.
 */
@Controller
@Api(value = "/", description = "Retrieve the inventory(device) metadata from xFusion database ")
public class DeviceInventoryController extends DeviceInventoryControllerCUD {
	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get list of devices suggestions registered at gateway.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/suggestion", notes = "List of devices suggestions registered at gateway", response = DeviceGetSuggestionSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "organization_path", value = "Requires the path of organization", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/suggestion", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetSuggestion(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("16", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get list of devices based on user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/get/device/by/user", notes = "Retrieve list of devices based on user", response = GenericGetDeviceSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/get/device/by/user", method = RequestMethod.POST)
	public @ResponseBody Message getDeviceByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("17", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get the type of device.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/type", notes = "Retrieve the type of device", response = DeviceGetTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user", required = true, access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/device/get/type", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */

		Message message = genericProcess.GenericProcedureCallingMetaData("25", map, request, response);
		/*
		 * Return the response message.
		 */

		return message;

	}

	/**
	 * To retrieve the cities where device is inserted.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/city", notes = "Returns the cities where device is inserted", response = DeviceGetCitySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/city", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetCity(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("26", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve device status(up or down) based on device type.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/metadata/status/by/type", notes = "Returns device status(up or down) based on device type", response = DeviceGetMetadataStatusByTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires the type of cdevice", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/metadata/status/by/type", method = RequestMethod.POST)
	public @ResponseBody Message deviceMetadataStatusByType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("32", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get physical inventory of devices.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/metadata", notes = "Retrieve physical inventory of devices", response = DeviceGetMetadataSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/metadata", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadata(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCallingMetaData("67", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve metadata status by device type count..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/device/get/metadata/status/by/type/count", notes = "Retrieve metadata status by device type count")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires the device type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status as integer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/metadata/status/by/type/count", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByTypeCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("104", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve metadata status by device type with limit.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/device/get/metadata/status/by/type/limit", notes = "Retrieve metadata status by device type with limit", response = DeviceGetMetadataStatusByTypeLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires the device type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "host_status ", value = "Requires the host status", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/metadata/status/by/type/limit", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByTypeLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("105", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve vendors by device.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/device/get/vendors", notes = "Retrieve vendors by device", response = GenericDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_technology", value = "Requires the int value for device technology", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/vendors", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetVendors(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("197", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve devices data for all technology.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/all/technology", notes = "Retrieve devices data for all technology", response = GenericDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/all/technology", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllTechnology(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("198", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve device type by vendor.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/all/device/type/by/vendor", notes = "Retrieve device type by vendor", response = GenericDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vendor_id", value = "Requires the int value for vendor id", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/all/device/type/by/vendor", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllDeviceTypeByVendor(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("199", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve status of device
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/device/get/status", notes = "Retrieve status of device", response = DeviceGetStatusSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/status", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetStatus(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("268", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve status for devices by status of metadata table
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/metadata/status/by/status", notes = "Retrieve status for devices by status of metadata table", response = DeviceGetMetadataStatusByStatusSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status_type", value = "Requires the int value for status type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the int value for limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the int value for offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/metadata/status/by/status", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByStatus(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("269", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve all device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/model/get/all", notes = "Retrieve all device model", response = DeviceModelGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/model/get/all", method = RequestMethod.POST)
	public @ResponseBody Message deviceModelGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("270", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve all device models by device type.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/all/device/models/by/type", notes = "Retrieve all device models by device type", response = DeviceGetAllDeviceModelsByTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/all/device/models/by/type", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllDeviceModelsByType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("272", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve all device models by device type.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/device/get/properties", notes = "Retrieve al device models by device type", response = DeviceGetPropertiesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the id of devicemodel", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/properties", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetProperties(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("273", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve all device templates by device metadata.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/all/templates", notes = "Retrieve all device templates by device metadata", response = DeviceGetAllTemplatesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/all/templates", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllTemplates(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("274", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To update the status of devices.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/data/get/datatype", notes = "To update the status of devices.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/data/get/datatype", method = RequestMethod.POST)
	public @ResponseBody Message dataGetDatatype(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("277", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get the metadata status from status count.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/metadata/status/by/status/count", notes = "To get the metadata status from status count", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "status_type", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/device/get/metadata/status/by/status/count", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByStatusCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("278", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get Get all devices from service and inventory table.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/service/inventory/status/device/get/all", notes = "Get all devices from service and inventory table", response = ServiceInventoryStatusDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "show_bit", value = "Requies service name", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/service/inventory/status/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message serviceInventoryStatusDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("295", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get the color list.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/colour/get/colour", notes = "To get the colour list", response = ColourGetColourSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/colour/get/colour", method = RequestMethod.POST)
	public @ResponseBody Message ColourGetColour(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("318", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get charts.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/charts/get/charts", notes = "To get charts", response = GetChartsCountrySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/charts/get/charts", method = RequestMethod.POST)
	public @ResponseBody Message ChartsGetCharts(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("319", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get priorities of devices.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/priorities", notes = "To get priorities of devices", response = GenericDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/priorities", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetPriorities(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("336", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To properties of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/model/properties", notes = "To properties of device model", response = DeviceGetModelPropertiesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/model/properties", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetModelProperties(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("339", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To properties of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/model/error/codes", notes = "To properties of device model", response = DeviceGetModelErrorCodesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/model/error/codes", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetModelErrorCodes(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("340", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get model services of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/model/services", notes = "To get model services of device model", response = DeviceGetModelServiceSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/model/services", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetModelServices(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("341", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get model services of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/tags/get/tags", notes = "To get model services of device model", response = TagsGetTagsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/tags/get/tags", method = RequestMethod.POST)
	public @ResponseBody Message tagsGetTags(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("400", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get parent device suggestion of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/parent/device/suggestion", notes = "To get parent device suggestion of device model", response = GenericGetDeviceSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "parent_device_id", value = "Requires the parent device id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/parent/device/suggestion", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetParentDeviceSuggestion(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("403", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get parent device suggestion of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/model/get/all/by/device/technology", notes = "To get parent device suggestion of device model", response = DeviceModelGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_technology_id", value = "Requires the device technology id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/model/get/all/by/device/technology", method = RequestMethod.POST)
	public @ResponseBody Message deviceModelGetAllByDeviceTechnology(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("404", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get all types of device of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/all/types", notes = "To get all types of device of device model", response = GenericDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/all/types", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllTypes(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("406", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get all types of device of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/all/vendor", notes = "To get all types of device of device model", response = GenericDeviceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/all/vendor", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllVendor(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("407", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get all types of device of device model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/search", notes = "To get all types of device of device model", response = DeviceSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model", value = "Requires the device model", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_country", value = "Requires the name of country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_state", value = "Requires the name of state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_city", value = "Requires the name of city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_tags", value = "Requires the tags used for device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_alias", value = "Requires the alias used for device", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/search", method = RequestMethod.POST)
	public @ResponseBody Message deviceSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("410", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get device tags by model.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/tags/by/model", notes = "To get device tags by model", response = DeviceGetTagsByModelSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model", value = "Requires the device model", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "tags", value = "Requires the tags values", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/device/get/tags/by/model", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetTagsByModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("413", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve service name and data source on the basis of device model
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/model/get/service/data/source", notes = "To get service and datasouce on the basis of device model", response = DeviceModelGetServiceDataSourceSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/device/model/get/service/data/source", method = RequestMethod.POST)
	public @ResponseBody Message deviceModelGetServiceDataSource(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("415", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve all service name and data source
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/service/datasource/get/all", notes = "To get device tags by model", response = ServiceDatasourceGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/service/datasource/get/all", method = RequestMethod.POST)
	public @ResponseBody Message serviceDatasourceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("421", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To inherit device template on the basis of templated id
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/template/inherit", notes = "To inherit device template", response = DeviceTemplateInherit.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "template_id", value = "Requires the id of temaplate"),
			@ApiImplicitParam(name = "template_name", value = "Requires the name of temaplate"),
			@ApiImplicitParam(name = "model_name", value = "Requires the name of model"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/device/template/inherit", method = RequestMethod.POST)
	public @ResponseBody Message deviceTemplateInherit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("437", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To inherit default device templates
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/template/default", notes = "To inherit device template", response = DeviceTemplateDefault.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/device/template/default", method = RequestMethod.POST)
	public @ResponseBody Message deviceTemplateInheritDefault(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("438", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get the device simulation controls
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/simulation/controls", notes = "To inherit device template", response = ActionGetActionSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/device/simulation/controls", method = RequestMethod.POST)
	public @ResponseBody Message deviceSimulationControls(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("440", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get the device simulation controls
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/commands/by/device", notes = "To inherit device template", response = DeviceGetCommandsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "command_id", value = "Requires the  command_id") })
	@RequestMapping(value = "/device/get/commands/by/device", method = RequestMethod.POST)
	public @ResponseBody Message xfusiondevicegetcommandsbydevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("462", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get the device simulation controls
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/get/command/parameters/by/id", notes = "To inherit device template", response = DeviceGetCommandParametersByIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "device_id", value = "Requires the  device_id") })
	@RequestMapping(value = "/device/get/command/parameters/by/id", method = RequestMethod.POST)
	public @ResponseBody Message xfusiondevicegetcommandparametersbyid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("463", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}
}
