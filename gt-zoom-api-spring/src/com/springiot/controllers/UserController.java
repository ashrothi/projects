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
import com.springiot.services.UserServices;
import com.springiot.swagger.response.GenericThirdPartyInsertUpdateDeleteSwagger;
import com.springiot.swagger.response.UsersGetSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class works as controller for APIs for managing the video of the TRIP.
 * 
 * @author Mandeep Singh
 * @creation_date : 28-03-2018 
 */
@Controller
public class UserController {
	// Autowired is used to inject the object dependency implicitly.
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private UserServices userService;
	
	/**
	 * To insert the new user. 
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/insert", notes = "To insert the new user.", response = GenericThirdPartyInsertUpdateDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "Requires mail id of new user for registration.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "Requires password for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_id", value = "Requires id of roles assigned to new user.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "Requires name of roles assigned to new user.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group_id", value = "Requires group id of new user.", required = true, access = "query", paramType = "query", dataType = "String") })
	
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/insert", method = RequestMethod.POST)
	public @ResponseBody Message userInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = userService.UserCreate(map, request, response);
		return message;
	}

	/**
	 * To get all the user under a user.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/users/get/all", notes = "To get all the user under a user.", response = UsersGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/users/get/all", method = RequestMethod.POST)
	public @ResponseBody Message usersGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("19", map, null, request, response);
		return message;
	}
	
	/**
	 * To get a user by it's id.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/get/by/id", notes = "To get a user by it's id.", response = UsersGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id of user.", required = true, access = "query", paramType = "query", dataType = "String")})
	
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/users/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message userGetById(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("20", map, null, request, response);
		return message;
	}
}
