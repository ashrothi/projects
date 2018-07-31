/**
 * This package contain the controller class for Third Party Application apis.
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
import com.springiot.services.UserService;
import com.springiot.swagger.response.UserCreateSwagger;
import com.springiot.swagger.response.UserDeleteSwagger;
import com.springiot.swagger.response.UserUpdateSwagger;
import com.springiot.swagger.response.UsersGetAllSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application for User Operation
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class UserController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private UserService userService;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Create User
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
	@ApiOperation(value = "/user/create", notes = "To Create User", response = UserCreateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "email", value = "Requires the Email Address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "Requires the password", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password_question", value = "Requires the password question", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password_answer", value = "Requires the password answer", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_approved", value = "Requires Is approved", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires specific csv attribute ID", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires specific csv attribute value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "mac_address", value = "Requires the mac_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "last_active_on", value = "Requires last_active_on ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "allow_conn_to_barc", value = "Requires allow_conn_to_barc", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ram", value = "Requires ram", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cpu", value = "Requires cpu", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ip_address", value = "Requires ip_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "os", value = "Requires os", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role", value = "Requires auth_role", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role_id", value = "Requires auth_role_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role_accesskey", value = "Requires auth_role_accesskey", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_key", value = "Requires application_key", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public @ResponseBody Message userCreate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = userService.UserCreate(map, request, response);
		return message;
	}

	/**
	 * To update basic information of user.
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
	@ApiOperation(value = "/user/update", notes = "To update basic information of user.", response = UserUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "edit_user_id", value = "Requires the updated user id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "email", value = "Requires the email Address of particular user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of particular user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires specific csv attribute ID", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires specific csv attribute value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id of user", required = true, access = "query", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "mac_address", value = "Requires the mac_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "last_active_on", value = "Requires last_active_on ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "allow_conn_to_barc", value = "Requires allow_conn_to_barc", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ram", value = "Requires ram", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cpu", value = "Requires cpu", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ip_address", value = "Requires ip_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "os", value = "Requires os", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role", value = "Requires auth_role", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role_id", value = "Requires auth_role_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role_accesskey", value = "Requires auth_role_accesskey", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_key", value = "Requires application_key", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public @ResponseBody Message userUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = userService.UserUpdate(map, request, response);
		return message;
	}

	/**
	 * To delete the user.
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
	@ApiOperation(value = "/user/delete", notes = "To delete the user.", response = UserDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "delete_user_id", value = "Requires to delete specific user id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires to delete specific id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public @ResponseBody Message userDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = userService.UserDelete(map, request, response);
		return message;
	}

	/**
	 * Returns all the user and their details from all the application in which
	 * given user is present
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
	@ApiOperation(value = "/users/get/all", notes = "Returns all the user and their details from all the application in which given user is present", response = UsersGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of user", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/users/get/all", method = RequestMethod.POST)
	public @ResponseBody Message usersGetALL(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = userService.UserGetALL(map, request, response);
		return message;
	}

	/**
	 * To Release user Organization
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
	 */
	@ApiOperation(value = "/user/organization/release", notes = "To Release user Organization ")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires the id ", required = true, access = "query", paramType = "query", dataType = "String") })

	
	@RequestMapping(value = "/user/organization/release", method = RequestMethod.POST)
	public @ResponseBody Message userOrganizationRelease(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("16", map, null, request, response);
		return message;
	}

	/**
	 * To get all user Organization
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
	 */
	@ApiOperation(value = "/user/organization/get/all", notes = "To get all user  Organization")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	
	@RequestMapping(value = "/user/organization/get/all", method = RequestMethod.POST)
	public @ResponseBody Message userOrganizationGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("17", map, null, request, response);
		return message;
	}

	/**
	 * To get user Organization Get All By OrgId
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
	 */
	@ApiOperation(value = "/user/organization/get/by/org/id", notes = "To get user Organization Get All By OrgId")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires the id ", required = true, access = "query", paramType = "query", dataType = "String") })

	
	@RequestMapping(value = "/user/organization/get/by/org/id", method = RequestMethod.POST)
	public @ResponseBody Message userOrganizationGetAllByOrgId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("18", map, null, request, response);
		return message;
	}

	/**
	 * To delete user Organization
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
	 */
	@ApiOperation(value = "/user/organization/delete", notes = "To delete user Organization ")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires the id ", required = true, access = "query", paramType = "query", dataType = "String") })

	
	@RequestMapping(value = "/user/organization/delete", method = RequestMethod.POST)
	public @ResponseBody Message userOrganizationDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("24", map, null, request, response);
		return message;
	}
}
