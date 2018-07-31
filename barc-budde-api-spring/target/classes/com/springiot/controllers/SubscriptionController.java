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
import com.springiot.swagger.response.OrganizationDeleteSwagger;
import com.springiot.swagger.response.OrganizationInsertSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application for subscription Operations
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class SubscriptionController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To insert organization subscription
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get organization_key,organization_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/subscription/insert", notes = "To insert organization subscription", response = OrganizationInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_start_date", value = "Requires subs_start_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_end_date", value = "Requires subs_end_date", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/subscription/insert", method = RequestMethod.POST)
	public @ResponseBody Message organizationsubscriptioninsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("46", map, null, request, response);

		return message;
	}

	/**
	 * To update organization subscription
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get organization_key,organization_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/subscription/update", notes = "To update organization subscription ", response = OrganizationInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_start_date", value = "Requires subs_start_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_end_date", value = "Requires subs_end_date", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/subscription/update", method = RequestMethod.POST)
	public @ResponseBody Message organizationsubscriptionupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("47", map, null, request, response);

		return message;
	}

	/**
	 * To delete organization subscription
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get organization_key,organization_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/subscription/delete", notes = "To delete organization subscription .", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/subscription/delete", method = RequestMethod.POST)
	public @ResponseBody Message organizationsubscriptiondelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("43", map, null, request, response);
		return message;
	}

	/**
	 * To get all organization subscription
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get organization_key,organization_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/subscription/get/all", notes = "To get all  organization subscription", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"), 
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/subscription/get/all", method = RequestMethod.POST)
	public @ResponseBody Message organizationsubscriptiongetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("44", map, null, request, response);
		return message;
	}

	/**
	 * To get organization subscription by org id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get organization_key,organization_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/subscription/get/by/org/id", notes = "To get organization subscription by org id", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/subscription/get/by/org/id", method = RequestMethod.POST)
	public @ResponseBody Message organizationsubscriptiongetbyorgid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("45", map, null, request, response);
		return message;
	}

}
