/**
 * /**
 * This package contains the Controller for GMR Application.
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
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.GmrTripDetailsInsertSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Order
 * Management.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class AWBManagement {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Service to get all open orders
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
	@ApiOperation(value = "/gmr/open/tickets/get/all", notes = "Service to get all open orders ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to_date", value = "Requires to_date", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/open/tickets/get/all", method = RequestMethod.POST)
	public @ResponseBody Message gmropenticketsgetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("19", map, null, request, response);
		return message;
	}

	/**
	 * Service to get all open orders
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
	@ApiOperation(value = "/gmr/open/tickets/activity/get/all", notes = "Service to get all open orders ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "order_number", value = "Requires order_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "Requires registration_number", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/open/tickets/activity/get/all", method = RequestMethod.POST)
	public @ResponseBody Message gmropenticketsactivitygetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("20", map, null, request, response);
		return message;
	}

	/**
	 * Service to get all open orders
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
	@ApiOperation(value = "/gmr/closed/tickets/get/all", notes = "Service to get all open orders ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to_date", value = "Requires to_date", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/closed/tickets/get/all", method = RequestMethod.POST)
	public @ResponseBody Message gmrclosedticketsgetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("21", map, null, request, response);
		return message;
	}

	/**
	 * Service to get all open orders
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
	@ApiOperation(value = "/gmr/closed/tickets/activity/get/all", notes = "Service to get all open orders ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "order_number", value = "Requires order_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "Requires registration_number", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/closed/tickets/activity/get/all", method = RequestMethod.POST)
	public @ResponseBody Message gmrclosedticketsactivitygetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("22", map, null, request, response);
		return message;
	}

	/**
	 * Service to get all open orders
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
	@ApiOperation(value = "/gmr/open/tickets/get/by/order/number", notes = "Service to get all open orders By Order Id ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "order_number", value = "Requires order_number", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/open/tickets/get/by/order/number", method = RequestMethod.POST)
	public @ResponseBody Message gmropenticketsgetbyordernumber(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("25", map, null, request, response);
		return message;
	}
}
