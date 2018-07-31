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
import com.springiot.swagger.response.CheckOrganizationSwagger;
import com.springiot.swagger.response.SignUpSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to create new user for the gt zoom application.
 * 
 * @author Mandeep Singh
 * @creation_date 05-03-2018
 */
@Controller
public class SignupController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private SignupServices signUpService;

	/**
	 * This controller is used to check if the organization exists in both platform and ThirdParty.
	 * 
	 * @param map : Contains all the body parameters.
	 * @param request : To get user_key,user_id from http request header.
	 * @param response : To send http response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/check/organization", notes = "To check if an organization exists in both Platform and ThirdParty.", response = CheckOrganizationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "organization_name", value = "Here pass the name of organization.", required = true, access = "query", paramType = "query", dataType = "String")
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/check/organization", method = RequestMethod.POST)
	public @ResponseBody Message checkOrganization(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = signUpService.checkOrg(map, request, response);
		return message;
	}
	
	/**
	 * This controller is used to register and sign up new user.
	 * 
	 * @param map : Contains all the body parameters.
	 * @param request : To get user_key,user_id from http request header.
	 * @param response : To send http response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/signup", notes = "To Sign up new user.", response = SignUpSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "root_user_name", value = "Here pass the root username to login.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "root_user_password", value = "Here pass the pssword for root user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "root_application_id", value = "Here pass the applicarion id of auth engine for root user login.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "platform_application_id", value = "Here pass the application id of platform for new user login.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "new_user_name", value = "Here pass the new username to register.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "OTP", value = "Here pass the OTP received on the entered mail id.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "password", value = "Here pass the password to set for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "password_question", value = "Here pass the secret question if password is forgotten.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "password_answer", value = "Here pass the answer of the secret question.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_approved", value = "Here pass the approved bit.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "application_id", value = "Here pass the application id for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "role_id", value = "Here pass the role id of the new registered user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "role_name", value = "Here pass the role name of the new registered user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "fleet_size", value = "Here pass the fleet sie under the new registered user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "first_name", value = "Here pass the First name  for new user for registarion.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "last_name", value = "Here pass the Last name for new user for registarion.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "gender", value = "Here pass the gender of new user for sign up.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "country", value = "Here pass the country for new user for registarion.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "state", value = "Here pass the state for new user for registarion.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "city", value = "Here pass the city for new user for registarion.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "preferred_number", value = "Here pass the main contact number for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "phone_numbers", value = "Here pass the other optional phone numbers for new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "address", value = "Here pass the address of the new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "creation_date", value = "Here pass the date of creation of new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_permanent_address", value = "Here pass if the address is permanent address of new user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "image_path", value = "Here pass the path of image uploaded by user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "currency", value = "Here pass the currency used by the user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "time_format", value = "Here pass the time format which user wants to prefer.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "thumbnail_image_path", value = "Here pass the path of uploaded image's thumbnail image.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "csv_attributes_id", value = "Here pass the id of the csv attributes.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "csv_attributes_alias", value = "Here pass the name of the csv attributes.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "csv_attributes_value", value = "Here pass the values of the csv attributes.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "parent_organization", value = "Here pass the code of the parent organization.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "organization_name", value = "Here pass the name of new organization for this user.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "description", value = "Here pass the description about the organization.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "color_code", value = "Here pass the color code for this organization.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "template_id", value = "Here pass the template id for inheriting.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "template_name", value = "Here pass the template name for inheriting.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "model_name", value = "Here pass the model name which is to be inherited from template.", required = true, access = "query", paramType = "query", dataType = "String"),
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Message signUp(@RequestParam Map<String, String> map, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		Message message = signUpService.signUpProcess(map, request, response);
		return message;
	}
}
