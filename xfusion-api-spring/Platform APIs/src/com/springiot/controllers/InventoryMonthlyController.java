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
 *         on the basis of monthly.
 */
@Controller
@Api(value = "/", description = "Retrieve the inventory data on monthly basis")
public class InventoryMonthlyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */
	@Autowired
	private GenericProcess genericProcess;


	/**
	 * To get single device without data from inventory on basis of monthly .
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
	@ApiOperation(value = "/inventory/monthly/device/get/single/without/data", notes = "Get single device without data from inventory on basis of monthly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("299", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get get single limit device data without data on monthly table.
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
	@ApiOperation(value = "/inventory/monthly/device/get/single/limit/without/data", notes = "To get single limit device data without data on monthly table", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/monthly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("300", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get single device without data from inventory on basis of monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/single/limit", notes = "Get single device without data from inventory  on basis of monthly", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/monthly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("301", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get single device without data from inventory on basis of monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/single/count", notes = "Get single device without data from inventory  on basis of monthly", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("302", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To retrieve single device data from monthly table.
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
	@ApiOperation(value = "/inventory/monthly/device/get/single", notes = "To retrieve single device data from monthly table", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("303", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many parameters from device without data.
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
	@ApiOperation(value = "/inventory/monthly/device/get/many/without/data", notes = "To get many parameters from device without data", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("304", map, request, response);
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
	@ApiOperation(value = "/inventory/monthly/device/get/many/limit/without/data", notes = "To get many parameters from device with limit without data", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/monthly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("305", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To single device without data from inventory on basis of monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/many/limit", notes = "Get single device without data from inventory  on basis of monthly", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/monthly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("306", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get single device without data from inventory on basis of monthly
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
	@ApiOperation(value = "/inventory/monthly/device/get/many/count", notes = "Get single device without data from inventory on basis of monthly", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("307", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get single device without data from inventory on basis of monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/many", notes = "Get single device without data from inventory on basis of monthly", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requires service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("308", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get single device without data from inventory on basis of monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/all/without/data", notes = "Get single device without data from inventory  on basis of monthly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("309", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get all device without data from inventory monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/all/limit/without/data", notes = "Get all device without data from inventory monthly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/monthly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("310", map, request, response);
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
	@ApiOperation(value = "/inventory/monthly/device/get/all/limit", notes = "To get all parameters for devices with all limit and without data", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),

	})
	@RequestMapping(value = "/inventory/monthly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("311", map, request, response);
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
	@ApiOperation(value = "/inventory/monthly/device/get/all/count", notes = " To get all parameters for devices with all limit and without data", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("312", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;


	}

	/**
	 * To get single device without data from inventory on basis of monthly.
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
	@ApiOperation(value = "/inventory/monthly/device/get/all", notes = "Get single device without data from inventory on basis of monthly", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "user_key", value = "requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/inventory/monthly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message InventoryMonthlyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("313", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/inventory/monthly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from inventory monthly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
	 * To get multiple devices data for multiple data sources and service names
	 * from inventory monthly
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventory/monthly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("448", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
