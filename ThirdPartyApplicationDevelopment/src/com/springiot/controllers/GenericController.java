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
import com.springiot.services.GenericProcess;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This controller is used for providing APIs on the Third party database procedures.
 * 
 * @author Mandeep Singh
 */
@Controller
@Api(value = "/", description = "Registration and Operations ")
public class GenericController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This API is used for providing the complete information about all vehicles present in database.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/device/get/users/vehicles", notes = "API for providing the complete information about all vehicles present in database.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })

	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header") })
	@RequestMapping(value = "/device/get/users/vehicles", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetUsersVehicles(@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
		return message;
	}

	/**
	 * This api is used for registering the new vehicle into the database.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/device/get/vehicle/registration", notes = "API for registering the new vehicle into the database.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass user_key for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass user_name for authentication.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass unique identifier for the device."),
			@ApiImplicitParam(name = "device_name", value = "Here pass name for the device for showing."),
			@ApiImplicitParam(name = "vehicle_identity_no", value = "Here pass unique vehicle identity number."),
			@ApiImplicitParam(name = "registration_no", value = "Here pass the Registration number of the Vehicle."),
			@ApiImplicitParam(name = "engine_number", value = "Here pass the engine number of the vehicle."),
			@ApiImplicitParam(name = "chassis_number", value = "Here pass the Chassis number of the vehicle."),
			@ApiImplicitParam(name = "model_code", value = "Here pass the Model Code of the vehicle."),
			@ApiImplicitParam(name = "condition", value = "Here pass the physical condition of vehicle."),
			@ApiImplicitParam(name = "fuel_type", value = "Here pass the Fuel type of Vehicle.(Petrol/Diesel/GAS)"),
			@ApiImplicitParam(name = "vehicle_type", value = "Here pass the Type of Vehicle in which device is integrated.(four_wheeler)"),
			@ApiImplicitParam(name = "vechicle_status", value = "Here pass the engine status of the Status.(good)"),
			@ApiImplicitParam(name = "color_code", value = "Here pass the color code of the vehicle."),
			@ApiImplicitParam(name = "purchase_date", value = "Here pass the date when vehicle was bought."),
			@ApiImplicitParam(name = "is_active", value = "Here pass the bit if vehicle is active."),
			@ApiImplicitParam(name = "driver_name", value = "Here pass the name of owner of the vehicle.") })
	@RequestMapping(value = "/device/get/vehicle/registration", method = RequestMethod.POST)
	public @ResponseBody Message insertUsersVehicles(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("2", map, null, request, response);

		return message;
	}
}