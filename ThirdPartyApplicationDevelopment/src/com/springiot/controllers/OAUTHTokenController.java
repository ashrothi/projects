/**
 * This package contains controllers for providing url for apis.
 */
package com.springiot.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.OAUTHTokenServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;

/**
 * This class is used for Authorization and Authenticating the user before making any request.
 * 
 * @author Mandeep Singh
 */
@Controller
@Api(value = "/", description = "Authorization and Authentication")
public class OAUTHTokenController {

	/**
	 * To access the functionality of following Class Methods
	 */
	@Autowired
	private OAUTHTokenServices tokenServices;

	/**
	 * This API URL is used for authenticating the Http request from 
	 * the user and also is used for login to the application.
	 * 
	 * @param user_name : Here pass the user name for authenticating the request of login.
	 * @param password : Here pass the password for the user for authenticating the request of login.
	 * @param application_id : Here pass the application id for authenticating the request of login to that application.
	 * @return Return the response message.
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 403, response = Long.class,message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class,message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(
			@ApiParam(name = "user_name", value = "Here pass the user_name for Authenticating the request.") @RequestParam String user_name,
			@ApiParam(name = "password", value = "Here pass the password for Authenticating the request.") @RequestParam String password,
			@ApiParam(name = "application_id", value = "Here pass the application_id for which user is doing login.") @RequestParam String application_id) {

		Message message = tokenServices.oauthToken(user_name, password, application_id);

		return message;
	}

}