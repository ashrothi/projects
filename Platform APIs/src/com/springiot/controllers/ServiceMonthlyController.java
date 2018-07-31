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
 *         on the basis of monthly data.
 */
@Controller
@Api(value = "/", description = "Retrieve the parameters of device on monthly basis from service table")
public class ServiceMonthlyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */
	@Autowired
	private GenericProcess genericProcess;


	/**
	 * To get the service parameters of single device without data on monthly
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
	@ApiOperation(value = "/service/monthly/device/get/single/without/data", notes = "To get the service parameters of single device without data on monthly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/monthly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("151", map, request, response);
			/*
			 * Return the response message.
//			 */
			return message;

	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/single/limit/without/data", notes = "To get the service parameters with limit for single device without data on monthly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("152", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/single/limit", notes = " To get the service parameters with limit for single device without data on monthly basis", response = GenericServiceDeviceGetSwagger.class)
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
	@RequestMapping(value = "/service/monthly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("153", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the count of service parameters for single device on monthly
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
	@ApiOperation(value = "/service/monthly/device/get/single/count", notes = " To get the count of service parameters for single device on monthly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/monthly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("154", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the service parameters for single device on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/single", notes = "To get the service parameters for single device on monthly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/monthly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("155", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device without data on monthly
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
	@ApiOperation(value = "/service/monthly/device/get/many/without/data", notes = "To get many service parameters for single device without data on monthly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/monthly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("156", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device without data on monthly
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
	@ApiOperation(value = "/service/monthly/device/get/many/limit/without/data", notes = " To get many service parameters for single device with limit and without data on monthly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
	@RequestMapping(value = "/service/monthly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("157", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device with limit on monthly
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
	@ApiOperation(value = "/service/monthly/device/get/many/limit", notes = "To get many service parameters for single device with limit on monthly basis", response = GenericServiceDeviceGetSwagger.class)
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
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/monthly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("158", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count for many service parameters for single device on monthly
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
	@ApiOperation(value = "/service/monthly/device/get/many/count", notes = "To get count for  many service parameters for single device on monthly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("159", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/many", notes = " To get many service parameters for single device on monthly basis")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("160", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters all for device without data on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/all/without/data", notes = " To get service parameters all for device without data on monthly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetAllWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("161", map, request, response);
			/*
			 * Return the response message.
			 */

			return message;

	}

	/**
	 * To get service parameters for all device with limit on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/all/limit/without/data", notes = " To get service parameters for all device with limit on monthly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("162", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/all/limit", notes = " To get service parameters for all device on monthly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering"), })
	@RequestMapping(value = "/service/monthly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("163", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count for service parameters for all device on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/all/count", notes = "To get count for service parameters for all device on monthly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("164", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device on monthly basis.
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
	@ApiOperation(value = "/service/monthly/device/get/all", notes = " To get service parameters for all device on monthly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/monthly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message ServiceMonthlyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("165", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/monthly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from service monthly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
	 * from service monthly
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/monthly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("449", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
