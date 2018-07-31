/**
 * This package contain the controller class to create APIs for service data.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;
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
 *         APIs to retrieve the service(device) metadata from xFusion database
 *         on the basis of hourly data.
 */
@Controller
@Api(value = "/", description = "Retrieve the parameters of device on basis of hourly from service table")
public class ServiceHourlyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */
	@Autowired
	private GenericProcess genericProcess;



	/**
	 * To get the service parameters of single device without data on hourly
	 * basis.
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
	@ApiOperation(value = "/service/hourly/device/get/single/without/data", notes = "To get the service parameters of single device without data on hourly basis")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("127", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/single/limit/without/data", notes = "To get the service parameters with limit for single device without data on hourly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("128", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/single/limit", notes = "To get the service parameters with limit for single device without data on hourly basis", response = GenericServiceDeviceGetSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("129", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the count of service parameters for single device on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/single/count", notes = " To get the count of service parameters for single device on hourly basis")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("130", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the service parameters for single device on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/single", notes = "To get the service parameters for single device on hourly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("131", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device without data on hourly
	 * basis.
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
	@ApiOperation(value = "/service/hourly/device/get/many/without/data", notes = "To get many service parameters for single device without data on hourly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetManyWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("132", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device with limit and without
	 * data on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/many/limit/without/data", notes = "To get many service parameters for single device with limit and without data on hourly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("133", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device with limit on hourly
	 * basis.
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
	@ApiOperation(value = "/service/hourly/device/get/many/limit", notes = "To get many service parameters for single device with limit on hourly basis")
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("134", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count for many service parameters for single device on hourly
	 * basis.
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
	@ApiOperation(value = "/service/hourly/device/get/many/count", notes = " To get count for  many service parameters for single device on hourly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("135", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/many", notes = "To get many service parameters for single device on hourly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("136", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters all for device without data on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/all/without/data", notes = "To get service parameters all for device without data on hourly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetAllWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("137", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device with limit on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/all/limit/without/data", notes = "To get service parameters for all device with limit on hourly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("138", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/all/limit", notes = "To get service parameters for all device on hourly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("139", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count for service parameters for all device on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/all/count", notes = "To get count for service parameters for all device on hourly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("140", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device on hourly basis.
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
	@ApiOperation(value = "/service/hourly/device/get/all", notes = "To get service parameters for all device on hourly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/hourly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message ServiceHourlyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("141", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;
//		/}
	}

	@ApiOperation(value = "/service/hourly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from service hourly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
	 * from service hourly
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/hourly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("455", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
