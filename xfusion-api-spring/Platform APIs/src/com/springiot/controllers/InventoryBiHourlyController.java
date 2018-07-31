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
 *         APIs to retrieve the inventory(device) metadata from xFusion
 *         database.
 */
@Controller
@Api(value = "/", description = "Retrieve the inventory(device) metadata from xFusion database")
public class InventoryBiHourlyController {
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/single/without/data", notes = "Get single device without data from service  on basis of half hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("211", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/single/limit/without/data", notes = "Get single device without data from service  on basis of half hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("212", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/single/limit", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("213", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/single/count", notes = "Get single device without data from service on basis of half hour", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("214", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/single", notes = "Get single device without data from service  on basis of half hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("215", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/many/without/data", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("216", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/many/limit/without/data", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("217", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/many/limit", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("218", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/many/count", notes = "Get single device without data from service on basis of half hour", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("219", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/many", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("220", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/all/without/data", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("221", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/all/limit/without/data", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("222", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/all/limit", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("223", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/all/count", notes = "Get single device without data from service on basis of half hour", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("224", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get single device without data from service daily.
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
	@ApiOperation(value = "/inventory/bi/hourly/device/get/all", notes = "Get single device without data from service on basis of half hour", response = GenericInventoryBiHourlyDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "specific limit you want data"),
			@ApiImplicitParam(name = "offset", value = "specific offset you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/inventory/bi/hourly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message inventoryBiHourlyDeviceGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("225", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	@ApiOperation(value = "/inventory/bi/hourly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from inventory", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
	 * To get multiple devices data for multiple data sources and service names
	 * from inventory Bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventory/bi/hourly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("443", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}
}