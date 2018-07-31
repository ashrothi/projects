/**
 * This package contain the class used for all device details requires for logs in alerts
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
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class is used for all device details requires for
 *         logs in alerts
 *
 */

@Controller
@Api(value = "/", description = "For all device details requires for logs in alerts")
public class EventController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To get all the devices from performance eventstatus.
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
	@ApiOperation(value = "/performance/eventstatus/device/get/all", notes = "To get all the devices from performance eventstatus", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/performance/eventstatus/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceEventStatusDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		Message message = genericProcess.GenericProcedureCalling("250", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get count of device status.
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
	@ApiOperation(value = "/performance/eventstatus/device/get/all/count", notes = "Returns count of device status", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/performance/eventstatus/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message performanceEventStatusDeviceGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("251", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get limited num of rows of device status based on limit and offsets.
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
	@ApiOperation(value = "/performance/eventstatus/device/get/all/limit", notes = "returns limited num of rows of device status based on limit and offsets", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset for required data", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/performance/eventstatus/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message performanceEventStatusDeviceGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("252", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	// {Changes===}
	/**
	 * To get multiple devices status from performance eventstatus.
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
	@ApiOperation(value = "/performance/eventstatus/device/get/many", notes = " To get multiple devices status from performance eventstatus", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("376", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get single devices status from performance eventstatus.
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
	@ApiOperation(value = "/performance/eventstatus/device/get/single", notes = "To get single devices status from performance eventstatus", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("377", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	

	}

	/**
	 * To get all multiple devices status from performance eventstatus.
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
	@ApiOperation(value = "/performance/eventstatus/devices/get/all", notes = " To get all multiple devices status from performance eventstatus", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/devices/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusDevicesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("378", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many devices status from performance eventstatus.
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
	@ApiOperation(value = "/performance/eventstatus/devices/get/many", notes = "To get many  devices status from performance eventstatus", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		Message message = genericProcess.GenericProcedureCalling("379", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get all devices from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/all", notes = " To get all devices from performance performanceevent", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("380", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get all devices with limit from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/all/limit", notes = "To get all devices with limit from performance performanceevent", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("381", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get count of all devices from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/all/count", notes = "To get count of all devices from performance performanceevent", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("382", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many devices from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/many", notes = " To get many devices from performance performanceevent", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/performance/performanceevent/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetMany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("383", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get all devices with limit from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/many/count", notes = "To get all devices with limit from performance performanceevent", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetManyCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("384", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many devices with limit from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/many/limit", notes = "To get many devices with limit from performance performanceevent", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetManyLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("385", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get single device with limit from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/single", notes = "To get single device with limit from performance performanceevent", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetSingle(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("386", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get count of single devices with limit from performance
	 * performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/single/count", notes = "To get count of single devices with limit from performance performanceevent", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetSingleCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("387", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get single device log with limit from performance performanceevent.
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
	@ApiOperation(value = "/performance/performanceevent/device/get/single/limit", notes = "To  get single device log with limit from performance performanceevent", response = GenericPerformanceEventStatusDevicesGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Require the start date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/performanceevent/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventDeviceGetSingleLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("388", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get all the device type from performance performanceevent.
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
	@ApiOperation(value = "/performance/eventstatus/device/type/get/all", notes = "To get all the device type from performance performanceevent", response = GenericPerformanceEventStatusAlertDeviceTypeGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/performance/eventstatus/device/type/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceEventStatusDeviceTypeGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("389", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get the count of all device type from performance performanceevent.
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
	@ApiOperation(value = "/performance/eventstatus/device/type/get/all/count", notes = "To get the count of all device type from performance performanceevent", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/performance/eventstatus/device/type/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message performanceEventStatusDeviceTypeGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("390", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get limited number of rows of device status based on limit and
	 * offsets.
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
	@ApiOperation(value = "/performance/eventstatus/device/type/get/all/limit", notes = "To get limited num of rows of device status based on limit and offsets", response = GenericPerformanceEventStatusAlertDeviceTypeGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Limit of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Offset for required data", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/performance/eventstatus/device/type/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message performanceEventStatusDeviceTypeGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Message message = genericProcess.GenericProcedureCalling("391", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}
}
