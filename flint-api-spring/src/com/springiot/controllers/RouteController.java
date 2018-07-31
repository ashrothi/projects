/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.CustomerServices;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used for CRUD for Customer and
 * manage Customer details
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@EnableAsync
public class RouteController {
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To insert route price
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
	@ApiOperation(value = "/flint/route/price/insert", notes = "To insert route price", response = FlintCloseTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "route_origin", value = "Requires route_origin", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "route_destination", value = "Requires route_destination", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id ", value = "Requires vehicle_id  ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "truck_capacity_group", value = "Requires truck_capacity_group", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "charges ", value = "Requires charges ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "max_response_time", value = "Requires max_response_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "intravel_time", value = "Requires intravel_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type_id", value = "Requires vehicle_type_id", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/route/price/insert", method = RequestMethod.POST)
	public @ResponseBody Message flintroutepriceinsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("103", map, null, request, response);
		return message;
	}

	/**
	 * To update route price
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
	@ApiOperation(value = "/flint/route/price/update", notes = "To update route price", response = FlintCloseTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "truck_capacity_group", value = "Requires truck_capacity_group", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "charges ", value = "Requires charges ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "max_response_time", value = "Requires max_response_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "intravel_time", value = "Requires intravel_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "route_id", value = "Requires route_id", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/route/price/update", method = RequestMethod.POST)
	public @ResponseBody Message flintroutepriceupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("108", map, null, request, response);
		return message;
	}

	/**
	 * To get all route price
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
	@ApiOperation(value = "/flint/route/price/get/all", notes = "To get all route price", response = FlintCloseTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/route/price/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintroutepricegetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("106", map, null, request, response);
		return message;
	}

	/**
	 * To delete route price
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
	@ApiOperation(value = "/flint/route/price/delete", notes = "To delete route price", response = FlintCloseTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "route_id", value = "Requires route_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/route/price/delete", method = RequestMethod.POST)
	public @ResponseBody Message flintroutepricedelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("109", map, null, request, response);
		return message;
	}
}
