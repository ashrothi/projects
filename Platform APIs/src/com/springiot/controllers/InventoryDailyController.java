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

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetSwagger;
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetWithoutDataSwagger;
import com.springiot.swagger.response.InventoryMonthlyDeviceGetManyCountSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         APIs to retrieve the inventory(device) metadata from xFusion database
 *         on daliy basis.
 */
@Controller
@Api(value = "/", description = "Retrieve the inventory data on daily basis")
public class InventoryDailyController {
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To get all device without data from inventory daily.
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
	@ApiOperation(value = "/inventory/daily/device/get/all/limit/without/data", notes = "Get all device without data from inventory daily", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryDailyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("87", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get all parameters for devices with all limit and without data.
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
	@ApiOperation(value = "/inventory/daily/device/get/all/limit", notes = "To get all parameters for devices with all limit and without data", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("280", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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

	@ApiOperation(value = "/inventory/daily/device/get/single/without/data", notes = "Get single device without data from inventory on daily basis", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("282", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get single limit device data without data on weekly table.
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
	@ApiOperation(value = "/inventory/daily/device/get/single/limit/without/data", notes = "To get single limit device data without data on daily basis", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("283", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/single/limit", notes = "Get single device without data from inventory on daily basis", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("284", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/single/count", notes = "Get single device without data from inventory on daily basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("285", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To retrieve single device data from daily table.
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
	@ApiOperation(value = "/inventory/daily/device/get/single", notes = "To retrieve single device data from daily table", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("286", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many parameters from device without data.
	 * 
	 * @param map,
	 *            * @param HttpServletRequest,this is required for the headers
	 *            in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling. *
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/daily/device/get/many/without/data", notes = " To get many parameters from device without data", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("287", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many parameters from device with limit without data.
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
	@ApiOperation(value = "/inventory/daily/device/get/many/limit/without/data", notes = "To get many parameters from device with limit without data", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("288", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/many/limit", notes = "Get single device without data from inventory on daily basis", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/daily/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("289", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/many/count", notes = "Get single device without data from inventory on daily basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/inventory/daily/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("290", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/many", notes = " Get single device without data from inventory on daily basis", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/inventory/daily/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("291", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/all/without/data", notes = "Get single device without data from inventory on daily basis", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/inventory/daily/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetAllWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("292", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/all/count", notes = " Get single device without data from inventory on daily basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/inventory/daily/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("293", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * Get single device without data from inventory on basis of weekly.
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
	@ApiOperation(value = "/inventory/daily/device/get/all", notes = "Get single device without data from inventory on daily basis", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/inventory/daily/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message InventoryDailyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("294", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	@ApiOperation(value = "/inventory/daily/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from inventory daily", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	/**
	 * Get multiple devices data for multiple data sources and service names
	 * from inventory daily
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventory/daily/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("452", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}
}
