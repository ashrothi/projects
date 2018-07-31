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
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetWithoutDataSwagger;
import com.springiot.swagger.response.InventoryMonthlyDeviceGetManyCountSwagger;
import com.springiot.swagger.response.GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger;
import com.springiot.swagger.response.GenericServiceDeviceGetSwagger;

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
 *         on the basis of weekly data.
 */
@Controller
@Api(value = "/", description = "Retrieve the parameters of device on weekly basis from service table")
public class ServiceWeeklyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To get the service parameters of single device without data on weekly
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
	@ApiOperation(value = "/service/weekly/device/get/single/without/data", notes = "To get the service parameters of single device without data on weekly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)

	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/weekly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("181", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/single/limit/without/data", notes = "To get the service parameters with limit for single device without data on weekly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/weekly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("182", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/single/limit", notes = "To get the service parameters with limit for single device without data on weekly basis", response = GenericServiceDeviceGetSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/weekly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("183", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get the count of service parameters for single device on weekly basis
	 * .
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
	@ApiOperation(value = "/service/weekly/device/get/single/count", notes = "To get the count of service parameters for single device on weekly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/weekly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("184", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get the service parameters for single device on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/single", notes = "To get the service parameters for single device on weekly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/weekly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message;

		message = genericProcess.GenericProcedureCalling("185", map, request, response);

		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many service parameters for single device without data on weekly
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
	@ApiOperation(value = "/service/weekly/device/get/many/without/data", notes = "To get many service parameters for single device without data on weekly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/weekly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetManyWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("186", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many service parameters for single device with limit and without
	 * data on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/many/limit/without/data", notes = " To get many service parameters for single device with limit and without data on weekly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
	@RequestMapping(value = "/service/weekly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("187", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many service parameters for single device with limit on weekly
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
	@ApiOperation(value = "/service/weekly/device/get/many/limit", notes = "To get many service parameters for single device with limit on weekly basis", response = GenericServiceDeviceGetSwagger.class)
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
	@RequestMapping(value = "/service/weekly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("188", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get count for many service parameters for single device on weekly
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
	@ApiOperation(value = "/service/weekly/device/get/many/count", notes = "To get count for  many service parameters for single device on weekly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/service/weekly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("189", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get many service parameters for single device on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/many", notes = "To get many service parameters for single device on weekly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/service/weekly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("190", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get service parameters all for device without data on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/all/without/data", notes = "To get service parameters all for device without data on weekly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/service/weekly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetAllWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("191", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get service parameters for all device with limit on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/all/limit/without/data", notes = "To get service parameters for all device with limit on weekly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions")

	})
	@RequestMapping(value = "/service/weekly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("192", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get service parameters for all device on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/all/limit", notes = "To get service parameters for all device on weekly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions")

	})
	@RequestMapping(value = "/service/weekly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("193", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	/**
	 * To get count for service parameters for all device on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/all/count", notes = "To get count for service parameters for all device on weekly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/service/weekly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("194", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		

	}

	/**
	 * To get service parameters for all device on weekly basis.
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
	@ApiOperation(value = "/service/weekly/device/get/all", notes = "To get service parameters for all device on weekly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	@RequestMapping(value = "/service/weekly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message ServiceWeeklyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("195", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}

	@ApiOperation(value = "/service/weekly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from inventory yearly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })
	/**
	 * Get multiple devices data for multiple data sources and service names
	 * from inventory yearly
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/weekly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("451", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
		
	}
}
