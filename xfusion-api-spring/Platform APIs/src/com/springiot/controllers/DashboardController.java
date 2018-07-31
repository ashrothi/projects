/**
 * This package contain the controller class for dashboard data.
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
import com.springiot.services.OperationalService;
import com.springiot.swagger.response.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         apis for data required for dashboard.
 */

@Controller
@Api(value = "/", description = "API's for dashboard page")
public class DashboardController {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	@Autowired
	private OperationalService operationalService;

	/**
	 * To get device status count for main dashboard.
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
	@ApiOperation(value = "Retrieve the count of up and down devices", notes = "Get device status count for main dashboard", response = DashboardMainGetDeviceStatusCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/dashboard/main/get/device/status/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainGetDeviceStatusCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("90", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get worst performing device for dashboard.
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
	@ApiOperation(value = "Retrieve the worst performing devices", notes = "Get worst performing devices on dashboard", response = DashboardMainWorstPerformingDevicesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/dashboard/main/worst/performing/devices", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainWorstPerformingDevices(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("91", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get worst performing device type for dashboard.
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
	@ApiOperation(value = "Retrieve the worst performing devices", notes = "Get worst performing device type for dashboard", response = DashboardMainWorstPerformingDeviceTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/dashboard/main/worst/performing/device/type", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainWorstPerformingDeviceType(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("103", map, request, response);
			/*
			 * Return the response message.
			 */

			return message;

	}

	/**
	 * To get Get counts of command for dashboard.
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
	@ApiOperation(value = "Retrieve the count of executing/pushing command on device", notes = "Get counts of command for dashboard", response = DashboardMainGetCommandCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/dashboard/main/get/command/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainGetCommandCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("106", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get Get counts of command by device type for dashboard.
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
	@ApiOperation(value = "Retrieve the count of executing/pushing command on device on the basis of device type", notes = "Get counts of command by device type for dashboard", response = DashboardMainGetCommandCountByDeviceTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })


	@RequestMapping(value = "/dashboard/main/get/command/count/by/device/type", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainGetCommandCountByDeviceType(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("107", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get Get counts of device status dashboard.
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
	@ApiOperation(value = "Retrieve the count of device status(whether device is up or down)", notes = "Get count of device status for dashboard", response = DashboardDeviceStatusCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requies the device ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/dashboard/device/status/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardDeviceStatusCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("196", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get worst device type grouped hourly.
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
	@ApiOperation(value = "For fetching worst device types on the basis of hourly down device count ", notes = "Get worst device type grouped hourly", response = DashboardMainWorstDeviceTypeGroupedHourlySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/dashboard/main/worst/device/type/grouped/hourly", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainWorstDeviceTypeGroupedHourly(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("343", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * Get counts of alerts for dashboard.
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
	@ApiOperation(value = "Retrieve the count of alerts generated ", notes = "Get counts of alerts for dashboard", response = DashboardAlertGetCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })


	@RequestMapping(value = "/dashboard/alert/get/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardAlertGetCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("395", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * Get counts of severity for dashboard.
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
	@ApiOperation(value = "Retrieve the count of severity of alerts of a particular device ", notes = "Get counts of severity for dashboard", response = DashboardDeviceSeverityCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requies the device id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_name", value = "Requies the service name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "data_source_name", value = "Requies the data source name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })


	@RequestMapping(value = "/dashboard/device/severity/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardDeviceSeverityCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("396", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * Get counts of severity for dashboard.
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
	@ApiOperation(value = "/dashboard/main/device/with/most/alert/count", notes = "Get counts of severity for dashboard", response = DashboardMainDeviceWithMostAlertCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"), })


	@RequestMapping(value = "/dashboard/main/device/with/most/alert/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMainDeviceWithMostAlertCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("397", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * Display alerts on dashboard(bubble chart)
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Display alerts on dashboard(bubble chart)", notes = "Display alerts on dashboard", response = DashboardAlertCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "alert_timezone", value = "Requies the timezone", required = true, access = "query", paramType = "query"), })


	@RequestMapping(value = "/dashboard/alert/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardAlertCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {


			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCalling("424", map, request, response);
			/*
			 * Return the response message.
			 */

			return message;

	}

	/**
	 * Display message count on the dashboard
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Display message count on the dashboard", notes = "Display message count on the dashboard", response = DashboardMessageCountSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to	 authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the uniqueidentification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date", value = "Requies the from	 date(start date)", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date", value = "Requies the end date", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/dashboard/message/count", method = RequestMethod.POST)
	public @ResponseBody Message dashboardMessageCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			Message message = genericProcess.GenericProcedureCalling("439", map, request, response);
			/*
			 * Return the response message.
			 */
			
			return message;

	}

	/**
	 * Display the logged in users on the dashboard
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "Display the logged in users on the dashboard", notes = "Display the logged in users on the dashboard", response = DashboardUsersLoggedInSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requies the application key", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/dashboard/users/logged/in", method = RequestMethod.POST)
	public @ResponseBody Message dashboardUsersLoggedIn(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			Message message = operationalService.usersLogged(map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
