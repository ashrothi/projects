/**
 * This package contain the controller class to create APIs for inventory data.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetWithoutDataSwagger;
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetSwagger;

import com.springiot.swagger.response.InventoryMonthlyDeviceGetManyCountSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import io.swagger.annotations.ApiImplicitParams;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         APIs to retrieve the inventory(device) metadata from xFusion database
 *         on the basis of hours.
 */
@Controller
@Api(value = "/", description = "Retrieve the parameters of device on hourly basis from inventory table")
public class InventoryHourlyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */
	@Autowired
	private GenericProcess genericProcess;


	/**
	 * To get single device without data from inventory on basis of hours.
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
	@ApiOperation(value = "/inventory/hourly/device/get/single/without/data", notes = "Get single device without data from inventory  on basis of hours", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("321", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get single device with limit without static data from inventory on
	 * basis of hours .
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/single/limit/without/data", notes = "Get single device with limit without static data from inventory  on basis of hours", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/hourly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("322", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get single device with limit from inventory on basis of hours.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/single/limit", notes = "Get single device with limit from inventory  on basis of hours", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/hourly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("323", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get count of single device from inventory on basis of hours.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/single/count", notes = "Get count of single device from inventory on basis of hours", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("324", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	
	}

	/**
	 * To get single device from inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/single", notes = "Get single device from inventory  on basis of hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("325", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	
	}

	/**
	 * To get multiple devices data without static data from inventory on basis
	 * of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/many/without/data", notes = "Get multiple devices data without static data from inventory  on basis of hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("326", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get multiple devices data with limit without static data from
	 * inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/many/limit/without/data", notes = "Get multiple devices data with limit without static data from inventory  on basis of hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/hourly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("327", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get many device with limit from inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/many/limit", notes = "Get many device with limit from inventory on basis of hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/hourly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("328", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	
	}

	/**
	 * To get count of many devices from inventory on basis of hours.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/many/count", notes = "Get count of many devices from inventory on basis of hours", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("329", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many device data from inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/many", notes = "Get many device data from inventory  on basis of hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("330", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get all devices without data from inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/all/without/data", notes = "Get all devices without data from inventory on basis of hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("331", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get all devices with limit without data from inventory on basis of
	 * hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/all/limit/without/data", notes = "Get all devices with limit without data from inventory  on basis of hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/hourly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("332", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get all devices with limit from inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/all/limit", notes = "Get all devices with limit from inventory on basis of hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("333", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get count of all devices from inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/all/count", notes = "Get count of all devices from inventory on basis of hour", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("334", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get all device inventory on basis of hour.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/inventory/hourly/device/get/all", notes = "Get all device inventory on basis of hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/hourly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message InventoryHourlyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("335", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	@ApiOperation(value = "/inventory/hourly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from inventory hourly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * Get multiple devices data for multiple data sources and service names
	 * from inventory hourly
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventory/hourly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("454", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}
}
