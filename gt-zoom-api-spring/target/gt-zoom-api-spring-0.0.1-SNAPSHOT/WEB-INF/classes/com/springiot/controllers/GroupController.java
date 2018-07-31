/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Generic
 * Procedure Calling.
 * 
 * @author Garima Joshi
 *
 */
@Controller
public class GroupController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To insert the group.
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

	@ApiOperation(value = "/group/insert", notes = "To insert the group.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_key", value = "Requires the owner user key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_id", value = "Requires the owner user id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_name", value = "Requires the organization name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_list", value = "Requires the vehicle list", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parent_group_id", value = "Requires the parent group id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "color", value = "Requires the color", required = true, access = "query", paramType = "query", dataType = "String")})

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/group/insert", method = RequestMethod.POST)
	public @ResponseBody Message GroupInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("33", map, null, request, response);
		return message;
	}

	/**
	 * To get all groups.
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

	@ApiOperation(value = "/group/get/all", notes = "To get all groups.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_key", value = "Requires the owner user key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_id", value = "Requires the owner user id", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/group/get/all", method = RequestMethod.POST)
	public @ResponseBody Message groupGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("34", map, null, request, response);
		return message;
	}

	/**
	 * To update the group.
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

	@ApiOperation(value = "/group/update", notes = "To update the group")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_key", value = "Requires the owner user key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_id", value = "Requires the owner user id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group_id", value = "Requires the group id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_name", value = "Requires the organization name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_list", value = "Requires the vehicle list", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parent_group_id", value = "Requires the parent group id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "color", value = "Requires the color", required = true, access = "query", paramType = "query", dataType = "String")})

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/group/update", method = RequestMethod.POST)
	public @ResponseBody Message GroupUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("35", map, null, request, response);
		return message;
	}

	/**
	 * To delete the group.
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

	@ApiOperation(value = "/group/delete", notes = "To delete the group.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_key", value = "Requires the owner user key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "owner_user_id", value = "Requires the owner user id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group_id", value = "Requires the group id", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/group/delete", method = RequestMethod.POST)
	public @ResponseBody Message GroupDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("36", map, null, request, response);
		return message;
	}

}
