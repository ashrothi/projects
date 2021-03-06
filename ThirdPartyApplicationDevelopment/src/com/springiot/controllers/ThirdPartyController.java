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
import com.springiot.services.ThirdPartyServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class is used for defining the api controller for performing operation by 
 * both calling the third party procedure and Platform API.
 * 
 * @author Mandeep Singh
 */
@Controller
@Api(value = "/", description = "Registration and Operations ")
public class ThirdPartyController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private ThirdPartyServices thirdPartyServices;
	
	/**
	 * To call detail about trips covered by the vehicle within the specific time.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/vehicle/calculate/trips", notes = "Get details of parameter from single device of Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass the user_key for the validation.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass the user_name for the validation.", paramType = "Header"),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data."),
			@ApiImplicitParam(name = "from_date", value = "Here pass start date in epoch format for getting data in specific time interval."),
			@ApiImplicitParam(name = "end_date", value = "Here pass end date in epoch format for getting data in specific time interval.") })
	@RequestMapping(value = "/vehicle/calculate/trips", method = RequestMethod.POST)
	public @ResponseBody Message vehicleCalculateTrips(@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		Message message = thirdPartyServices.tripServices("3", map, request, response);

		return message;
	}
}
