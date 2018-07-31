/**
 * This package contain the class which is used for generic Platform Api's.
 */
package com.springiot.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.controllers.ignoreControllers.PeformanceControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;

import com.springiot.swagger.response.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class is a controller for generic Platform Api's.This class includes
 * performance of a device,also all the API's related to performnace db.
 * 
 * @author tanvigarg
 * 
 */
@Controller
@Api(value = "/", description = "Performance of the device")
public class PerformanceController extends PeformanceControllerCUD {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get the details of performance of all devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/performance/servicestatus/device/get/all", notes = "Get all parameters of device from Service table", response = GenericPerformanceServiceStatusDevicesGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id") })

	@RequestMapping(value = "/performance/servicestatus/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceServicestatusDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("4", map, request, response);
		return message;

	}

	/**
	 * To get the details of performance of all devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/performance/status/device/get/all", notes = "Get all parameters of device from Status table", response = GenericPerformanceServiceStatusDevicesGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "acess_key", value = "Specific user has the URL permissions"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID") })

	@RequestMapping(value = "/performance/status/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceStatusDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("7", map, request, response);
		return message;

	}

	/**
	 * To get the details of performance of single parameter of device.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/performanceservice/device/get/single", notes = "Get details for single parameter of device of Status table")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires user key of user the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	@RequestMapping(value = "/performanceservice/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message performanceDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("9", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/many", notes = "Get details of multiple parameters of device from Status table", response = GenericPerformanceServiceStatusDevicesGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })
	/**
	 * To get the details of multiple parameters of a device.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performanceservice/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performanceDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("10", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/all", notes = "Get deatils of all parameters of device from Status table")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })
	/**
	 * To get the details of performance of all devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performanceservice/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("11", map, request, response);
		return message;

	}

	/**
	 * To get the details of performance of all devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/performancestaus/device/get/all", notes = "Get deatils of all parameters of device from Service table")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	@RequestMapping(value = "/performancestaus/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceServiceDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("12", map, request, response);
		return message;

	}

	/**
	 * To get the details of multiple parameters of a device.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/performancestatus/device/get/many", notes = "Get a list of specific multiple parameters of device from Service table")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	@RequestMapping(value = "/performancestatus/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performanceServiceDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("13", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performancestatus/device/get/single", notes = "Get deatils of single parameter of device from Service table")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })
	/**
	 * To get the details of performance of single parameter of a device.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performancestatus/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message performanceServiceDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("14", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/device/get/services", notes = "get services deatils of device", response = PerformanceDeviceGetServicesSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device ID"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })

	/**
	 * To get the details of services of all devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/device/get/services", method = RequestMethod.POST)
	public @ResponseBody Message performanceDeviceGetServices(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("15", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/service/multipledevices/get/many", notes = "Get a list of specific multiple parameters of devices from Service table", response = GenericPerformanceServiceStatusDevicesGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "pivot_data_required", value = "Whether pivot data is required or not can be 0 or 1.'0' means pivot data and '1' means pivot data with alias ") })
	/**
	 * To get the details of multiple parameters of multiple devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/service/multipledevices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performanceGetDeviceByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = null;

		if (map.containsKey("pivot_data_required")) {

			LinkedHashMap<String, String> pivotMap = new LinkedHashMap<>();
			pivotMap.put("device_id", map.get("device_id").toString());
			pivotMap.put("service_name", map.get("service_name").toString());
			pivotMap.put("data_source", map.get("data_source").toString());
			pivotMap.put("from_date", map.get("from_date").toString());
			pivotMap.put("end_date", map.get("end_date").toString());
			pivotMap.put("limit", "");
			pivotMap.put("offset", "");
			pivotMap.put("table_name", "performance_performanceservice");
			// pivotMap.put("db_name",
			// "xfusion_development_performance_spider_node");
			pivotMap.put("in_condition", "");

			if (map.get("pivot_data_required").toString().equalsIgnoreCase("1")) {

				message = genericProcess.GenericProcedureCalling("431", pivotMap, request, response);

			} else if (map.get("pivot_data_required").toString().equalsIgnoreCase("2")) {
				message = genericProcess.GenericProcedureCalling("435", pivotMap, request, response);

			}

		} else {
			// To call the procedure required for data processing.
			message = genericProcess.GenericProcedureCalling("18", map, request, response);

		}

		return message;
	}

	@ApiOperation(value = "/performance/status/multipledevices/get/many", notes = "Get a list of specific multiple parameters of devices from Status table")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })
	/**
	 * To get the details of multiple parameters of multiple devices.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/status/multipledevices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message PerformancStatuseGetDeviceByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("19", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/all", notes = "Get all devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get all devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("36", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/many", notes = "Get many parameters of devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get many devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryDeviceGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("37", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/single", notes = "Get single parameter of devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get single devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryDeviceGetSingle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("38", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/inventorystatus/device/get/all", notes = "Get all parameter of devices from performance inventory status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })
	/**
	 * To get all devices from performance inventory status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/inventorystatus/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryStatusDeviceGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("39", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/inventorystatus/device/get/many", notes = "Get many parameters of devices from performance inventory statys")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source") })
	/**
	 * To get many devices from performance inventory status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/inventorystatus/device/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryStatusDeviceGetMany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("40", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/inventorystatus/device/get/single", notes = "Get single parameter of device from performance inventory statys")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source") })
	/**
	 * To get single devices from performance inventory status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/inventorystatus/device/get/single", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryStatusDeviceGetSingle(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("41", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/all/count", notes = "Get count of all parametrs of devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get count of all devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("42", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/all/limit", notes = "Get limited list of all parametrs of devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get limit list of all devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("43", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceservice/device/get/all/count", notes = "Get count of all parametrs of devices from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get count of all devices from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceservice/device/get/all/count", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetAllCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("44", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceservice/device/get/all/limit", notes = "Get limited list of all parametrs of devices from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get limited list of all devices from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceservice/device/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetAllLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("45", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/many/count", notes = "Get  count of many parametrs of devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get many count on devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetManyCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("46", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/many/limit", notes = "Get limit on many parameters of devices from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get many limit on devices from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/many/limit", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryDeviceGetManyLimit(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("47", map, request, response);
		return message;

	}

	@ApiOperation(value = "/inventorystatus/device/get/all/without/data", notes = "Get all parameter of device list without data from performance inventory status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })
	/**
	 * To get all device list without data from performance inventory status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventorystatus/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventorystatusDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("48", map, request, response);
		return message;

	}

	@ApiOperation(value = "/inventorystatus/device/get/many/without/data", notes = "Get many parametrs of device list without data from performance status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source") })
	/**
	 * To get many device list without data from performance status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventorystatus/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventorystatusDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Message message = null;
		/*
		 * To call the procedure required for data processing.
		 */

		if (map.containsKey("pivot_data_required")) {

			LinkedHashMap<String, String> pivotMap = new LinkedHashMap<>();
			pivotMap.put("device_id", map.get("device_id").toString());
			pivotMap.put("service_name", map.get("service_name").toString());
			pivotMap.put("data_source", map.get("data_source").toString());
			pivotMap.put("from_date", map.get("from_date").toString());
			pivotMap.put("end_date", map.get("end_date").toString());
			pivotMap.put("limit", map.get("limit").toString());
			pivotMap.put("offset", map.get("offset").toString());
			pivotMap.put("table_name", "performance_inventorystatus");
			// pivotMap.put("db_name",
			// "xfusion_development_performance_spider_node");
			pivotMap.put("in_condition", "");

			if (map.get("pivot_data_required").toString().equalsIgnoreCase("1")) {

				message = genericProcess.GenericProcedureCalling("431", pivotMap, request, response);

			} else if (map.get("pivot_data_required").toString().equalsIgnoreCase("2")) {
				message = genericProcess.GenericProcedureCalling("435", pivotMap, request, response);

			}

		} else {
			// To call the procedure required for data processing.
			message = genericProcess.GenericProcedureCalling("49", map, request, response);

		}
		return message;

	}

	@ApiOperation(value = "/inventorystatus/device/get/single/without/data", notes = "Get single parametrs of device without data from performance status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source") })
	/**
	 * To get single device list without data from performance status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@RequestMapping(value = "/inventorystatus/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message inventorystatusDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("50", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceinventory/device/get/all/limit/without/data", notes = "Get all parameters of device list with limit and without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get all limited device list without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceinventory/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("51", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceinventory/device/get/all/without/data", notes = "Get all parameters of device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get all device list without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceinventory/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("52", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceinventory/device/get/many/limit/without/data", notes = "Get many parametrs of limited device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get many limited list without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceinventory/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("53", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceinventory/device/get/many/without/data", notes = "Get many parameters of device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get many list without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceinventory/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("54", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceinventory/device/get/single/limit/without/dat", notes = "Get single parameter of limited device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get single limited device without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceinventory/device/get/single/limit/without/dat", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetSingleLimitWithoutDat(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("55", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceinventory/device/get/single/without/data", notes = "Get single parameter of device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get single device without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceinventory/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceinventoryDeviceGetingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("56", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/all/limit/without/data", notes = "Get all parameters of limited device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get all limit device without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/device/get/all/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetAllLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("57", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/all/without/data", notes = "Get all parameters of device list without data from performance inventory")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get all device without data from performance inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetAllWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("58", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/many/limit/without/data", notes = "Get many parameters of limited device list without data from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get many limit device list without data from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/device/get/many/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetManyLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("59", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/many/without/data", notes = "Get many parameters of device list without data from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get many device list without data from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("60", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/single/limit/without/data", notes = "Get single parameters of limited device list without data from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date"),
			@ApiImplicitParam(name = "limit", value = "Requires limit"),
			@ApiImplicitParam(name = "offset", value = "Requires offset value") })
	/**
	 * To get single limit device list without data from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/device/get/single/limit/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetSingleLimitWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("61", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/device/get/single/without/data", notes = "Get single parameter of device list without data from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get single device list without data from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("62", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performanceservice/devices/get/many/without/data", notes = "Get many parameters of device list without data from performance service")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get many device list without data from performance service.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performanceservice/devices/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message performanceserviceDevicesGetManyWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("63", map, request, response);
		return message;

	}

	@ApiOperation(value = "/servicestatus/device/get/all/without/data", notes = "Get all parameters of device without data from service status", response = GenericServiceBiHourlyDeviceGetAllWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })
	/**
	 * To get all device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/servicestatus/device/get/all/without/data", method = RequestMethod.POST)
	public @ResponseBody Message servicestatusDeviceGetAllWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("64", map, request, response);
		return message;

	}

	@ApiOperation(value = "/servicestatus/device/get/many/without/data", notes = "Get many parameters of device without data from service status", response = GenericServiceDeviceGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "pivot_data_required", value = "Whether pivot data is required or not can be 0 or 1.'0' means pivot data and '1' means pivot data with alias ") })
	/**
	 * To get many device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/servicestatus/device/get/many/without/data", method = RequestMethod.POST)
	public @ResponseBody Message servicestatusDeviceGetManyWithoutData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = null;
		/*
		 * To call the procedure required for data processing.
		 */

		if (map.containsKey("pivot_data_required")) {

			LinkedHashMap<String, String> pivotMap = new LinkedHashMap<>();
			pivotMap.put("device_id", map.get("device_id").toString());
			pivotMap.put("service_name", map.get("service_name").toString());
			pivotMap.put("data_source", map.get("data_source").toString());
			pivotMap.put("from_date", "");
			pivotMap.put("end_date", "");
			pivotMap.put("limit", "");
			pivotMap.put("offset", "");
			pivotMap.put("table_name", "performance_servicestatus");
			// pivotMap.put("db_name",
			// "xfusion_development_performance_spider_node");
			pivotMap.put("in_condition", "");

			if (map.get("pivot_data_required").toString().equalsIgnoreCase("1")) {

				message = genericProcess.GenericProcedureCalling("431", pivotMap, request, response);

			} else if (map.get("pivot_data_required").toString().equalsIgnoreCase("2")) {
				message = genericProcess.GenericProcedureCalling("435", pivotMap, request, response);

			}

		} else {
			// To call the procedure required for data processing.
			message = genericProcess.GenericProcedureCalling("65", map, request, response);

		}
		return message;

	}

	@ApiOperation(value = "/servicestatus/device/get/single/without/data", notes = "Get single parameter of device without data from service status", response = ServicestatusDeviceGetSingleWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source") })
	/**
	 * To get single device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/servicestatus/device/get/single/without/data", method = RequestMethod.POST)
	public @ResponseBody Message servicestatusDeviceGetSingleWithoutData(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("66", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performane/servicestatus/devices/get/many", notes = "Get single parameter of device without data from service status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "pivot_data_required", value = "Whether pivot data is required or not can be 0 or 1.'0' means pivot data and '1' means pivot data with alias ") })
	/**
	 * To get single device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performane/servicestatus/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performaneServicestatusDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = null;
		/*
		 * To call the procedure required for data processing.
		 */

		if (map.containsKey("pivot_data_required")) {

			LinkedHashMap<String, String> pivotMap = new LinkedHashMap<>();
			pivotMap.put("device_id", map.get("device_id").toString());
			pivotMap.put("service_name", map.get("service_name").toString());
			pivotMap.put("data_source", map.get("data_source").toString());
			pivotMap.put("from_date", "");
			pivotMap.put("end_date", "");
			pivotMap.put("limit", "");
			pivotMap.put("offset", "");
			pivotMap.put("table_name", "performance_servicestatus");
			// pivotMap.put("db_name",
			// "xfusion_development_performance_spider_node");
			pivotMap.put("in_condition", "");

			if (map.get("pivot_data_required").toString().equalsIgnoreCase("1")) {

				message = genericProcess.GenericProcedureCalling("431", pivotMap, request, response);

			} else if (map.get("pivot_data_required").toString().equalsIgnoreCase("2")) {
				message = genericProcess.GenericProcedureCalling("435", pivotMap, request, response);

			}

		} else {
			// To call the procedure required for data processing.
			message = genericProcess.GenericProcedureCalling("68", map, request, response);

		}
		return message;

	}

	@ApiOperation(value = "/performance/performanceinventory/device/get/single/count", notes = "Get single parameter of device without data from service status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get single device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performance/performanceinventory/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message performancePerformanceinventoryDeviceGetSingleCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("143", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceservice/device/get/many/count", notes = "Get single parameter of device without data from service status", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get single device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performance/performanceservice/device/get/many/count", method = RequestMethod.POST)
	public @ResponseBody Message performancePerformanceserviceDeviceGetManyCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("144", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/performanceservice/device/get/single/count", notes = "Get single parameter of device without data from service status")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })
	/**
	 * To get single device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performance/performanceservice/device/get/single/count", method = RequestMethod.POST)
	public @ResponseBody Message performancePerformanceserviceDeviceGetSingleCount(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("145", map, request, response);
		return message;

	}

	@ApiOperation(value = "/performance/servicestatus/devices/get/all", notes = "Get single parameter of device without data from service status", response = GenericPerformanceServiceStatusDevicesGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })
	/**
	 * To get single device without data from service status.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 * 
	 */

	@RequestMapping(value = "/performance/servicestatus/devices/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceServicestatusDevicesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("320", map, request, response);
		return message;

	}

	/**
	 * This api is used to retrieve data of services of inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/performance/performanceinventory/devices/get/many", notes = "Get data of multiple parameters of multiple devices of inventory", response = GenericPerformanceServiceStatusDevicesGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies service name"),
			@ApiImplicitParam(name = "data_source", value = "Requies data source"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })

	@RequestMapping(value = "/performance/performanceinventory/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message performanceInventoryDevicesGetMany(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("436", map, request, response);
		return message;

	}

	/**
	 * This api is used to retrieve data of services of inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/device/get/all/commands", notes = "Get data  commands of  device", response = DeviceGetCommandsSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })

	@RequestMapping(value = "/device/get/all/commands", method = RequestMethod.POST)
	public @ResponseBody Message xfusiondevicegetallcommands(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("466", map, request, response);
		return message;

	}

	/**
	 * This api is used to retrieve data of services of inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/performance/performancecommand/devices/get/many", notes = "Get data of multiple parameters of multiple devices of inventory", response = PerformanceCommandDevicesGetManySwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "command_id", value = "Requies command_id "),
			@ApiImplicitParam(name = "limit", value = "Requies limit"),
			@ApiImplicitParam(name = "offset", value = "Requies offset"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })

	@RequestMapping(value = "/performance/performancecommand/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message xfusionperformanceperformancecommanddevicesgetmany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("464", map, request, response);
		return message;

	}

	/**
	 * This api is used to retrieve data of services of inventory.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @param map,the
	 *            input parameters specified by the user.
	 *
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/performance/commandstatus/devices/get/many", notes = "Get data of multiple parameters of multiple devices of inventory", response = PerformanceCommandDevicesGetManySwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "command_id", value = "Requies command_id "),
			@ApiImplicitParam(name = "limit", value = "Requies limit"),
			@ApiImplicitParam(name = "offset", value = "Requies offset"),
			@ApiImplicitParam(name = "from_date", value = "Requires start date"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date") })

	@RequestMapping(value = "/performance/commandstatus/devices/get/many", method = RequestMethod.POST)
	public @ResponseBody Message xfusionperformancecommandstatusdevicesgetmany(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("465", map, request, response);
		return message;

	}
}
