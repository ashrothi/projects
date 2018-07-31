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
import com.springiot.services.OrganizationService;
import com.springiot.swagger.response.OrganizationDeleteSwagger;
import com.springiot.swagger.response.OrganizationGetAllSwagger;
import com.springiot.swagger.response.OrganizationInsertSwagger;
import com.springiot.swagger.response.OrganizationUpdateSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application for Organization Operations
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class OrganizationController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private OrganizationService orgService;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Create organization
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
	@ApiOperation(value = "/organization/create", notes = "To Create organization", response = OrganizationInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "state", value = "Requires the state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "name", value = "Requires name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "alias", value = "Requires the alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "city", value = "Requires the city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_approved", value = "Requires Is approved", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "country", value = "Requires the country ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "users_allowed", value = "Requires users_allowed", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "domain_allowed", value = "Requires domain_allowed", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "total_server", value = "Requires the total_server", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "in_srv_connection_time", value = "Requires the in_srv_connection_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "client_connection_time", value = "Requires the client_connection_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parent_org_id", value = "Requires parent_org_id	", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_active", value = "Requires is_active", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "Requires role_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role_id", value = "Requires auth_role_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_key", value = "Requires application_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_start_date", value = "Requires subs_start_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_end_date", value = "Requires subs_end_date", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/create", method = RequestMethod.POST)
	public @ResponseBody Message organizationCreate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("19", map, null, request, response);

		return message;
	}

	/**
	 * To update basic information of organization.
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
	@ApiOperation(value = "/organization/update", notes = "To update basic information of organization.", response = OrganizationUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires the id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "state", value = "Requires the state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "name", value = "Requires name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "alias", value = "Requires the alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "city", value = "Requires the city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_approved", value = "Requires Is approved", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "country", value = "Requires the country ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "users_allowed", value = "Requires users_allowed", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "domain_allowed", value = "Requires domain_allowed", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "total_server", value = "Requires the total_server", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "in_srv_connection_time", value = "Requires the in_srv_connection_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "client_connection_time", value = "Requires the client_connection_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parent_org_id", value = "Requires parent_org_id	", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "Requires role_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "auth_role_id", value = "Requires auth_role_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_key", value = "Requires application_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_start_date", value = "Requires subs_start_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subs_end_date", value = "Requires subs_end_date", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/update", method = RequestMethod.POST)
	public @ResponseBody Message organizationUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = genericProcess.GenericProcedureCalling("23", map, null, request, response);
		return message;
	}

	/**
	 * To delete the organization.
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
	@ApiOperation(value = "/organization/delete", notes = "To delete the organization.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires to delete specific organization id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/delete", method = RequestMethod.POST)
	public @ResponseBody Message organizationDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("20", map, null, request, response);
		return message;
	}

	/**
	 * Returns all the organization and their details from all the application
	 * in which given organization is present
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
	@ApiOperation(value = "/organizations/get/all", notes = "Returns all the organization and their details from all the application in which given organization is present", response = OrganizationGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "user_key to authenticate user to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "user_id to authenticate user to access API", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organizations/get/all", method = RequestMethod.POST)
	public @ResponseBody Message organizationsGetALL(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("21", map, null, request, response);
		return message;
	}

	/**
	 * To get the organization by id
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
	@ApiOperation(value = "/organization/get/by/id", notes = "To get the organization by id.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message organizationgetbyid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("29", map, null, request, response);
		return message;
	}

	/**
	 * To delete the organization access on study
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
	@ApiOperation(value = "/organization/study/access/delete", notes = "To delete the organization access on study ", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires the organization id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires the study id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/study/access/delete", method = RequestMethod.POST)
	public @ResponseBody Message organizationstudyaccessdelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("30", map, null, request, response);
		return message;
	}

	/**
	 * To update the organization access on study by id
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
	@ApiOperation(value = "/organization/study/access/update", notes = "To update the organization access on study by id.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires to delete specific organization id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires study_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "master_ques_var_name", value = "Requires master_ques_var_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "master_ans_var_name", value = "Requires tmaster_ans_var_name", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/study/access/update", method = RequestMethod.POST)
	public @ResponseBody Message organizationstudyaccessupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("31", map, null, request, response);
		return message;
	}

	/**
	 * To get the organization studies access .
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
	@ApiOperation(value = "/organization/study/access/get/all", notes = "To get the organization studies access .", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/study/access/get/all", method = RequestMethod.POST)
	public @ResponseBody Message organizationstudyaccessgetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("32", map, null, request, response);
		return message;
	}

	/**
	 * To get the organization access on study by id.
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
	@ApiOperation(value = "/organization/study/access/get/by/org/id", notes = "To get the organization access on study by id.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/study/access/get/by/org/id", method = RequestMethod.POST)
	public @ResponseBody Message organizationstudyaccessgetbyorgid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("33", map, null, request, response);
		return message;
	}

	/**
	 * To insert the organization access for study.
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
	@ApiOperation(value = "/organization/study/access/insert", notes = "To insert the organization access for study.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires study_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "master_ques_var_name", value = "Requires master_ques_var_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "master_ans_var_name", value = "Requires tmaster_ans_var_name", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/study/access/insert", method = RequestMethod.POST)
	public @ResponseBody Message organizationstudyaccessinsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = orgService.accessInsert( map,  request, response);
//		Message message = genericProcess.GenericProcedureCalling("34", map, null, request, response);
		return message;
	}

	/**
	 * To get the organization access on study by id.
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
	@ApiOperation(value = "/get/organization/roles/by/org/id", notes = "To get the organization access on study by id.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/get/organization/roles/by/org/id", method = RequestMethod.POST)
	public @ResponseBody Message getorganizationrolesbyorgid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("42", map, null, request, response);
		return message;
	}

	/**
	 * To get the organization access on study by id.
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
	@ApiOperation(value = "/is/organization/active", notes = "To get the organization access on study by id.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/is/organization/active", method = RequestMethod.POST)
	public @ResponseBody Message isorganizationactive(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("48", map, null, request, response);
		return message;
	}

	/**
	 * To get the organization access on study by id.
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
	@ApiOperation(value = "/update/organization/state", notes = "To get the organization access on study by id.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_active", value = "Requires is_active", required = true, access = "query", paramType = "query", dataType = "String")})

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/update/organization/state", method = RequestMethod.POST)
	public @ResponseBody Message updateorganizationstate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("49", map, null, request, response);
		return message;
	}

}
