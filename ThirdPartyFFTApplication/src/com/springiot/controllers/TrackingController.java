/**
 * This package contains the Controller for GMR Application.
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
import com.springiot.services.TrackingServices;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application
 * 
 * @author tanvigarg
 *
 */
@Controller
public class TrackingController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private TrackingServices trackingServices;

	/**
	 * To Retrieve all the History Tracking
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
	@ApiOperation(value = "/history/tracking/get/all", notes = "Retrieve all the History Tracking ", response = HistoryTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key ", value = "Requires the access key", required = true, access = "query", paramType = "query", dataType = "String"), })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/history/tracking/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintHistoryTrackingGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = trackingServices.flintHistoryTrackingGetAll(map, request, response);
		return message;
	}

	/**
	 * To Retrieve all the Live Tracking
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
	@ApiOperation(value = "/live/tracking/get/all", notes = "Retrieve all the History Tracking ", response = LiveTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "access_key ", value = "Requires the access key", required = true, access = "query", paramType = "query", dataType = "String"), })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/live/tracking/get/all", method = RequestMethod.POST)
	public @ResponseBody Message liveTrackingGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = trackingServices.liveTrackingGetAll(map, request, response);
		return message;
	}

	
}
