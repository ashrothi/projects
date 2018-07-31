/**
 * This package contains controllers for providing url for apis.
 */
package com.springiot.controllers;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.XFusionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class is url controller for calling Xfusion PlatForm ApI's.
 * 
 * @author Mandeep Singh
 */
@Controller
@Api(value = "/", description = "Performance of the device")
public class XfusionPerformaceController {

	/**
	 * To access the functionality of the following Class Method
	 */
	@Autowired
	private XFusionService xfusionService;

	/**
	 * To call the data of service status. This will give latest data of each service.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/performance/device/get/all/servicestatus", notes = "Get all parameters from Service table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class,message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class,message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data.") })

	@RequestMapping(value = "/performance/device/get/all/servicestatus", method = RequestMethod.POST)
	public @ResponseBody Message performanceDeviceGetAllServiceStatus(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		Message message = xfusionService.performanceDeviceGetAllServiceStatus(map, request, response);

		return message;
	}

	/**
	 * To call the data of performance status. This will give complete data of each service.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/performance/status/device/get/all", notes = "Get all parameters from Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class,message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class,message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data.")	})
	
	@RequestMapping(value = "/performance/status/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message performanceStatusDeviceGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		Message message = xfusionService.performanceDeviceGetAllStatus(map, request, response);

		return message;
	}

	/**
	 * To get the devices by user. This will give all present device under one user.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/get/device/by/user", notes = "Get deatils of all parameters from device of Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class,message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class,message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data.") })

	@RequestMapping(value = "/get/device/by/user", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllByUser(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		Message message = xfusionService.DeviceGetAllByUser(map, request, response);

		return message;
	}

}