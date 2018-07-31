package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.UserService;
import com.springiot.swagger.response.FlintCreateCustomerSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Pooja Singh
 * @since 24-may-2018
 * @version 1.0
 *
 */
@Controller
@EnableAsync
public class UserController {

	private UserService userService;

	/**
	 * Registeration of customer
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
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/create/user", notes = "Registeration of user", response = FlintCreateCustomerSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "email", value = "Requires the Email Address", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "first_name", value = "Requires first_name", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "last_name", value = "Requires last_name", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "country", value = "Requires the country", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "state", value = "Requires the state", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "city", value = "Requires the city", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "preferred_number", value = "Requires preferred_number	", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "phone_numbers", value = "Requires phone_numbers", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "address", value = "Requires address of user", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "prefered_contact_number", value = "Requires prefered_contact_number", required = true, access = "query", paramType = "query"),
		@ApiImplicitParam(name = "user_group", value = "Requires the user_group", required = true, access = "query", paramType = "query")})
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/flint/create/user", method = RequestMethod.POST)
	public @ResponseBody Message flintCreateUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return userService.flintCreateUser(map, request, response);
	}
}
