/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import java.net.URI;
/**
 * To Import Classes to access their functionality
 */
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.VehicleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used for CRUD for Vehicle and manage
 * Vehicle details
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@EnableAsync
public class VehicleController {
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private VehicleService vehicleService;

	/**
	 * To get all the vehicle.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * 
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/get/all", notes = "To get all the vehicle.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "header", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "header", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/vehicle/get/all", method = RequestMethod.POST)
	public @ResponseBody Message vehicleGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("6", map, null, request, response);
		return message;
	}

	/**
	 * To get all the vehicle on the basis of device type.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * 
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/get/all/by/device/type", notes = "To get all the vehicle on the basis of device type.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_type", value = "Requires device type", required = true, access = "header", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/vehicle/get/all/by/device/type", method = RequestMethod.POST)
	public @ResponseBody Message vehicleGetAllByDeviceType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("11", map, null, request, response);
		return message;
	}

	/**
	 * To get the device details by vehicle id.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * 
	 * @throws Exception
	 */
	@ApiOperation(value = "/get/device/details/by/vehicle/id", notes = "To get the device details by vehicle id.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle id", required = true, access = "header", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/get/device/details/by/vehicle/id", method = RequestMethod.POST)
	public @ResponseBody Message getDeviceDetailsByVehicle_id(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("12", map, null, request, response);
		return message;
	}

	/**
	 * To call the data of performance status. This will give complete data of
	 * each service.
	 * 
	 * @param map
	 *            : Here pass the required parameters for API call.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/performance/status/device/get/all", notes = "Get all parameters from Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data.") })

	@RequestMapping(value = "/performance/status/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceStatusDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Message message = xfusionService.performanceDeviceGetAllStatus(map,
		// request, response);
		Message responseMessage = vehicleService.getPerformanceServiceStatusGetMany(map, request);

		return responseMessage;
	}

	/**
	 * To get the vehicle details by vehicle id.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * 
	 * @throws Exception
	 */
	@ApiOperation(value = "/get/vehicle/details/by/vehicle/id", notes = "To get the vehicle details by vehicle id.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle id", required = true, access = "header", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/get/vehicle/details/by/vehicle/id", method = RequestMethod.POST)
	public @ResponseBody Message getVehicleDetailsByVehicle_id(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("16", map, null, request, response);
		return message;
	}

	/**
	 * To call the data of performance status. This will give complete data of
	 * each service.
	 * 
	 * @param map
	 *            : Here pass the required parameters for API call.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/kpi/get/all", notes = "Get all parameters from Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data."),
			@ApiImplicitParam(name = "data_source", value = "Here pass data_source for which user wants data."),
			@ApiImplicitParam(name = "service_name", value = "Here pass service_name for which user wants data."),
			@ApiImplicitParam(name = "from_date", value = "Here pass from_date for which user wants data."),
			@ApiImplicitParam(name = "end_date", value = "Here pass end_date for which user wants data."),
			@ApiImplicitParam(name = "limit", value = "Here pass limit for which user wants data."),
			@ApiImplicitParam(name = "offset", value = "Here pass offset for which user wants data."),
			@ApiImplicitParam(name = "in_condition", value = "Here pass in_condition for which user wants data.") })

	@RequestMapping(value = "/device/kpi/get/all", method = RequestMethod.POST)
	public @ResponseBody Message deviceKpiGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Message message = xfusionService.performanceDeviceGetAllStatus(map,
		// request, response);
		Message responseMessage = vehicleService.deviceKpiGetAll(map, request);

		return responseMessage;
	}
	/**
	 * To get the device frames on the basis of vehicle id and trip start time.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * 
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/frame/get", notes = "To get the device frames on the basis of vehicle id and trip start time.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires device id of user", required = true, access = "header", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_start", value = "Requires trip start time ", required = true, access = "header", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/device/frame/get", method = RequestMethod.POST)
	public @ResponseBody Message deviceFrameGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("23", map, null, request, response);
		return message;
	}
	
	/**
	 * To insert the device frames on the basis of vehicle id and trip start time.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * 
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/frame/insert", notes = "To insert the device frames on the basis of vehicle id and trip start time.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires device id of user", required = true, access = "header", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "number_of_frames", value = "Requires number of frames", required = true, access = "header", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "folder_path", value = "Requires path of the folder", required = true, access = "header", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_start", value = "Requires trip start time ", required = true, access = "header", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/device/frame/insert", method = RequestMethod.POST)
	public @ResponseBody Message deviceFrameInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("24", map, null, request, response);
		return message;
	}
}
