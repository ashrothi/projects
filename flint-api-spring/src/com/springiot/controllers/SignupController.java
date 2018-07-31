/**
 * This package contain the controller class for signup into the GT Zoom Application.
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
import com.springiot.services.SignupServices;
import com.springiot.swagger.response.OauthTokenSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to create new user for the gt
 * zoom application.
 * 
 * @author Mandeep Singh
 * @creation_date 05-03-2018
 */
@Controller
public class SignupController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private SignupServices signUpService;

	@ApiOperation(value = "/user/verification", notes = "To Sign up new user.", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "insert_userKey", value = "Here pass the signup user  login.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insert_user_id", value = "Here pass the signup user id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "company_type", value = "Here pass the company_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "company_name", value = "Here pass company_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "prefered_contact_number", value = "Here pass tprefered_contact_number.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gender", value = "Here pass the gender.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "address", value = "Here pass the address.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "name", value = "Here pass name.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_id", value = "Here pass the application id for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_role", value = "Here pass application_role", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "platform_role", value = "Here pass the platform_role.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role", value = "Here pass the auth_role.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "alias", value = "Here pass the alias.", required = true, access = "query", paramType = "query", dataType = "String"), })
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/user/verification", method = RequestMethod.POST)
	public @ResponseBody Message userVerification(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Message message = signUpService.userVerification(map, request, response);
		return message;
	}
	
	/**
	 * This controller is used to register and sign up new user.
	 * 
	 * @param map
	 *            : Contains all the body parameters.
	 * @param request
	 *            : To get user_key,user_id from http request header.
	 * @param response
	 *            : To send http response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/signup", notes = "To Sign up new user.", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "insert_userKey", value = "Here pass the signup user  login.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insert_user_id", value = "Here pass the signup user id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "company_type", value = "Here pass the company_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "company_name", value = "Here pass company_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "prefered_contact_number", value = "Here pass tprefered_contact_number.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gender", value = "Here pass the gender.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "address", value = "Here pass the address.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "name", value = "Here pass name.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_id", value = "Here pass the application id for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_role", value = "Here pass application_role", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "platform_role", value = "Here pass the platform_role.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role", value = "Here pass the auth_role.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "alias", value = "Here pass the alias.", required = true, access = "query", paramType = "query", dataType = "String"), })
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Message message = signUpService.signUpProcess(map, request, response);
		return message;
	}
}
