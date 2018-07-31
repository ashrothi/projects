/**
 * This package contain the controller class to create APIs for service data.
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
 * @author Garima Joshi This class work as a controller which is used to create
 *         APIs to retrieve the service(device) metadata from xFusion database
 *         on the basis of bi hourly data.
 */
@Controller
@Api(value = "/", description = "Retrive service data on bi hourly basis")
public class ServiceBiHourlyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */
	@Autowired
	private GenericProcess genericProcess;


	@ApiOperation(value = "/service/bi/hourly/device/get/single/without/data", notes = "Get single device without data from service bi hourly", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
	 * To get single device without data from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message serviceDailyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("84", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/single/limit/without/data", notes = "Get single limit device without data from service bi hourly", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get single limit device without data from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("92", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/single/limit", notes = "Get single limit device from service bi hourly", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get single limit device from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("93", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/single/count", notes = "Get count for single device from service bi hourly", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get count for single device from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("94", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/single", notes = "Get single device from service bi hourly", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get single device from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("95", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/many/without/data", notes = "Get many device without data from service bi hourly", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get many device without data from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("96", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/many/limit/without/data", notes = "Get many with limit device without data from service bi hourly", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get many with limit device without data from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("97", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/many/limit", notes = "Get many device with limit from service bi hourly", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get many device with limit from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("98", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/many/count", notes = "Get many device count from service bi hourly", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get many device count from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("99", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/many", notes = "Get many device from service bi hourly", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get many device from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("100", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/all/without/data", notes = "Get all device without data from service bi hourly", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get all device without data from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("101", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/device/get/all/limit/without/data", notes = "Get all device with limit without data from service bi hourly", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	/**
	 * To get all device with limit without data from service bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("102", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/bi/hourly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from service bi hourly", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
	 * from service Bi hourly.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/bi/hourly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("442", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
