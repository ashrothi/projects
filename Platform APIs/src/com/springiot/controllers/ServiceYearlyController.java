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
 *         on the basis of yearly data.
 */
@Controller
@Api(value = "/", description = "Retrieve the parameters of device on yearly basis from service table")
public class ServiceYearlyController {
	/**
	 * To access functionality of GenericProcess Class function
	 */

	@Autowired
	private GenericProcess genericProcess;



	/**
	 * To get the service parameters of single device without data on yearly
	 * basis
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
	@ApiOperation(value = "/service/yearly/device/get/single/without/data", notes = "To get the service parameters of single device without data on yearly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),

			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("166", map, request, response);
			return message;

	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/single/limit/without/data", notes = " To get the service parameters with limit for single device without data on yearly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
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
	@RequestMapping(value = "/service/yearly/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("167", map, request, response);
			return message;
			/*
			 * Return the response message.
			 */

	}

	/**
	 * To get the service parameters with limit for single device without data
	 * on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/single/limit", notes = "To get the service parameters with limit for single device without data on yearly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/yearly/device/get/single/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetSingleLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("168", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the count of service parameters for single device on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/single/count", notes = "To get the count of service parameters for single device on yearly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetSingleCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("169", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the service parameters for single device on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/single", notes = "To get the service parameters for single device on yearly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("170", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device without data on yearly
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
	@ApiOperation(value = "/service/yearly/device/get/many/without/data", notes = " To get many service parameters for single device without data on yearly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetManyWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("171", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device with limit and without
	 * data on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/many/limit/without/data", notes = "To get many service parameters for single device with limit and without data on yearly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/yearly/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("172", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device with limit on yearly
	 * basis .
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
	@ApiOperation(value = "/service/yearly/device/get/many/limit", notes = "To get many service parameters for single device with limit on yearly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/yearly/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetManyLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("173", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count for many service parameters for single device on yearly
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
	@ApiOperation(value = "/service/yearly/device/get/many/count", notes = "To get count for  many service parameters for single device on yearly basis ")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetManyCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("174", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get many service parameters for single device on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/many", notes = "To get many service parameters for single device on yearly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "data_source", value = "Requires the data source value"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("175", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters all for device without data on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/all/without/data", notes = "To get service parameters all for device without data on yearly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })

	@RequestMapping(value = "/service/yearly/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetAllWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("176", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device with limit on yearly basis .
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
	@ApiOperation(value = "/service/yearly/device/get/all/limit/without/data", notes = "To get service parameters for all device with limit on yearly basis", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/yearly/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("177", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get service parameters for all device on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/all/limit", notes = "To get service parameters for all device on yearly basis", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit value"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset value"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering")

	})
	@RequestMapping(value = "/service/yearly/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("178", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count for service parameters for all device on yearly basis .
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
	@ApiOperation(value = "/service/yearly/device/get/all/count", notes = "To get count for service parameters for all device on yearly basis", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("179", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;


	}

	/**
	 * To get service parameters for all device on yearly basis.
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
	@ApiOperation(value = "/service/yearly/device/get/all", notes = "To get service parameters for all device on yearly basis ")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device id"),
			@ApiImplicitParam(name = "UserKey", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date"),
			@ApiImplicitParam(name = "in_condition", value = "Requies the condition for Server Side Filtering") })
	@RequestMapping(value = "/service/yearly/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message ServiceYearlyDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("180", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "/service/yearly/devices/get/many", notes = "Get multiple devices data for multiple data sources and service names from service yearly", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
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
	 * from service yearly
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/service/yearly/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message serviceBiHourlyDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("447", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
