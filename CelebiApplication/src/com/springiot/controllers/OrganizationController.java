/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
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
import com.springiot.services.XFusionService;
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used ,For Organization CRUD
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
	private XFusionService xFusionService;

	/**
	 * To get all Country Code
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
	@ApiOperation(value = "/organization/get/country", notes = "To get all Country Code", response = OrganizationGetCountrySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/get/country", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationCountryGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationCountryGet(map, request, response);
		return responseMessage;
	}

	/**
	 * To get all Organization
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
	@ApiOperation(value = "/organization/get/all", notes = "To get all Organization", response = OrganizationGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/get/all", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationGetAll(map, request, response);
		return responseMessage;
	}

	/**
	 * To get all State by Country Code
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
	@ApiOperation(value = "/organization/get/state", notes = "To get all State by Country Code", response = OrganizationGetStateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "country_id", value = "Requires country_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/get/state", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationStateGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationStateGet(map, request, response);
		return responseMessage;
	}

	/**
	 * To get all City by State Code
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
	@ApiOperation(value = "/organization/get/city", notes = "To get all City by State Code", response = OrganizationGetCitySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "state_id", value = "Requires state_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/get/city", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationCityGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationCityGet(map, request, response);
		return responseMessage;
	}

	/**
	 * To Insert New Organization
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
	@ApiOperation(value = "/organization/insert", notes = "To Insert New Organization", response = OrganizationInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parent_organization", value = "Requires parent_organization", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_name", value = "Requires organization_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "in_city", value = "Requires in_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "in_country", value = "Requires in_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "color_code", value = "Requires color_code", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/insert", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationInsert(map, request, response);
		return responseMessage;
	}

	/**
	 * To Update New Organization
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
	@ApiOperation(value = "/organization/update", notes = "To Update New Organization", response = OrganizationUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_id", value = "Requires organization_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_name", value = "Requires organization_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_alias", value = "Requires organization_alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_city", value = "Requires organization_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "country_id", value = "Requires in_country_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "color_code", value = "Requires color_code", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/update", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationUpdate(map, request, response);
		return responseMessage;
	}

	/**
	 * To Delete Organization
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
	@ApiOperation(value = "/organization/delete", notes = "To Delete Organization", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_id", value = "Requires organization_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/delete", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationDelete(map, request, response);
		return responseMessage;
	}

	/**
	 * To Delete Organization
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
	@ApiOperation(value = "/organization/users/list", notes = "To Delete Organization", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_key", value = "Requires application_key", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/users/list", method = RequestMethod.POST)
	public @ResponseBody Message xfusionOrganizationUsersList(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionOrganizationUsersList(map, request, response);
		return responseMessage;
	}

	/**
	 * To Get Organization by User
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
	@ApiOperation(value = "/organization/get/by/user", notes = "To Get Organization by User ", response = OrganizationGetByUserSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/organization/get/by/user", method = RequestMethod.POST)
	public @ResponseBody Message xfusionGetOrganizationByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionGetOrganizationByUser(map, request, response);
		return responseMessage;
	}
	/**
	 * To Get Organization by User
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
	@ApiOperation(value = "/flint/users/list", notes = "To Get Organization by User ", response = OrganizationGetByUserSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_key", value = "Requires application_key of application", required = true, access = "query", paramType = "query", dataType = "String")})
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/flint/users/list", method = RequestMethod.POST)
	public @ResponseBody Message xfusionGetUserList(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = xFusionService.xfusionGetUserList(map, request, response);
		return responseMessage;
	}

}
