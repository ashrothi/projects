/**
 * This package contains the class which is used as a controller to create apis for alerts.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springiot.swagger.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         apis for alerts(events). Modified by:Ankita Shrothi
 */

@Controller
@Api(value = "/", description = "Fetching Details of Alerts generated")
public class AlertController {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get all alerts of devices from eventstatus table.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "Retrieve all active alerts of a particular device", notes = "Retrieve all active alerts of a particular device ", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/eventstatus/alert/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("360", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve counts of all device alerts from eventstatus table.
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
	@ApiOperation(value = "Retrieve the count of all active alerts of a particular device", notes = "Retrieve the count of all active alerts of a particular device", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("361", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve device alerts with limits from eventstatus table.
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
	@ApiOperation(value = "Retrieve all active alerts of a particular device with limit", notes = "Retrieve all active alerts of a particular device with limit", response = GenericPerformanceEventStatusAlertDeviceTypeGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit(range) of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset for required data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("362", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve many device alerts from eventstatus table.
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
	@ApiOperation(value = "Retrieve multiple active alerts of a particular device", notes = "Retrieve multiple active alerts of a particular device", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceGetMany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("363", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve single device alerts from eventstatus table.
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
	@ApiOperation(value = "Retrieve single active alert of a particular device", notes = "Retrieve single active alert of a particular device", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceGetSingle(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("364", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve all devices alerts from eventstatus table.
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
	@ApiOperation(value = "Retrieve all active alerts of a multiple devices", notes = "Retrieve all active alerts of a multiple devices", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/devices/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDevicesGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("365", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To retrieve many device alerts from eventstatus table .
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
	@ApiOperation(value = "Retrieve multiple active alerts of a multiple devices", notes = "Retrieve multiple active alerts of a multiple devices", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDevicesGetMany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("366", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve all historical alerts of a particular device.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Retrieve all historical alerts of a particular device", notes = " Retrieve all historical alerts of a particular device.", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch), required = true", access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("367", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve the count of all historical alerts of a particular device
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
	@ApiOperation(value = "Retrieve the count of all historical alerts of a particular device", notes = "Retrieve the count of all historical alerts of a particular device", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for	Server Side Filtering", required = true, access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("368", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve all historical alerts of a particular device with limit
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
	@ApiOperation(value = "Retrieve all historical alerts of a particular device with limit", notes = "Retrieve all historical alerts of a particular device with limit", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit(range) of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("369", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve specific historical alerts of a particular device based on service
	 * name and data source
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
	@ApiOperation(value = "Retrieve specific historical alerts of a particular device based on service name and data source", notes = "Retrieve specific historical alerts of a particular device based on service nameand data source", response = GenericPerformanceEventAlertDeviceGetSwagger.class)

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetMany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("370", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve the count of historical alerts of a particular device based on
	 * service name and data source
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
	@ApiOperation(value = "Retrieve the count of historical alerts of a particular device based on service name and data source", notes = "Retrieve the count of historical alerts of a particular device based on service name and data source", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetManyCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("371", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve historical alerts of a particular device based on service name and
	 * data source with limit
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
	@ApiOperation(value = "Retrieve historical alerts of a particular device based on service name and data source with limit", notes = "Retrieve historical alerts of a particular device based on service name and data source with limit", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit(range) of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetManyLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("372", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve historical alerts of a particular device based on single service
	 * name and data source with limit
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
	@ApiOperation(value = "Retrieve historical alerts of a particular device based on single service name and data source with limit", notes = "Retrieve historical alerts of a particular device based on single service name and data source with limit", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/performanceevent/alert/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message PerformancePerformanceeventAlertDeviceGetSingle(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("373", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve the count of historical alerts of a particular device based on
	 * single service name and data source
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
	@ApiOperation(value = "Retrieve the count of historical alerts of a particular device based on single service name and data source", notes = "Retrieve the count of historical alerts of a particular device based on single service name and data source", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performanceevent/alert/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceeventAlertDeviceGetSingleCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("374", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve historical alerts of a particular device based on single service
	 * name and data source with limit
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
	@ApiOperation(value = "Retrieve historical alerts of a particular device based on single service name and data source with limit", notes = "Retrieve historical alerts of a particular device based on single service name and data source with limit", response = GenericPerformanceEventAlertDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requires the particular service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source", value = "Requires the particular data source", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the date where it starts from(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the date where it ends(in epoch)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit(range) of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset for required data", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/performanceevent/alert/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceeventAlertDeviceGetSingleLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("375", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve all active alerts of a particular device based on device type
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
	@ApiOperation(value = "Retrieve all active alerts of a particular device based on device type", notes = "Retrieve all active alerts of a particular device based on device type", response = GenericPerformanceEventStatusAlertDeviceTypeGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/performance/eventstatus/alert/device/type/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceTypeGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("392", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve the count of active alerts of a particular device based on device
	 * type
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
	@ApiOperation(value = "Retrieve the count of active alerts of a particular device based on device type", notes = "Retrieve the count of active alerts of a particular device based on device type", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_correlated", value = "Requires is_correlated bit for whether rule is correlated or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/performance/eventstatus/alert/device/type/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceTypeGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("393", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve all active alerts of a particular device with limit
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
	@ApiOperation(value = "Retrieve all active alerts of a particular device with limit", notes = "Retrieve all active alerts of a particular device with limit", response = PerformanceEventstatusAlertDeviceTypeGetAllLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit(range) of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset for required data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_correlated", value = "Requires is_correlated bit for whether rule is correlated or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/eventstatus/alert/device/type/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceTypeGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("394", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve the count of active alerts of a particular device based on device
	 * type
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
	@ApiOperation(value = "Retrieve the count of historical alerts of a particular device based on device type", notes = "Retrieve the count of active alerts of a particular device based on device type", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_correlated", value = "Requires is_correlated bit for whether rule is correlated or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/performance/performanceevent/alert/device/type/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceperformanceeventAlertDeviceTypeGetAllCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("467", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * Retrieve all active alerts of a particular device with limit
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
	@ApiOperation(value = "Retrieve all historical alerts of a particular device with limit", notes = "Retrieve all active alerts of a particular device with limit", response = PerformanceEventstatusAlertDeviceTypeGetAllLimitSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit(range) of data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset for required data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requires the from_date for required data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end_date for required data", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_correlated", value = "Requires is_correlated bit for whether rule is correlated or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/performanceevent/alert/device/type/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceperformanceeventAlertDeviceTypeGetAllLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("468", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}
}
