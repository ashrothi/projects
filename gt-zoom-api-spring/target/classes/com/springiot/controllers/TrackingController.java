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
import com.springiot.services.TrackingServices;
import com.springiot.swagger.response.FlintHistoryTrackingGetAllSwagger;
import com.springiot.swagger.response.FlintLiveTrackingGetAllSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application for Live Tracking
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class TrackingController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private TrackingServices trackingServices;

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
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/live/tracking/get/all", notes = "Retrieve all the Live Tracking ", response = FlintLiveTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),

	})
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/live/tracking/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintLiveTrackingGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = trackingServices.liveTrackingGetAll(map, request, response);
		return message;
	}

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
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/history/tracking/get/all", notes = "Retrieve all the History Tracking ", response = FlintHistoryTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/history/tracking/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintHistoryTrackingGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = trackingServices.flintHistoryTrackingGetAll(map, request, response);
		return message;
	}
	
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
	 * @throws Exception
	 */
	@ApiOperation(value = "/tracking/device/get/all", notes = "Retrieve all the History Tracking ", response = FlintHistoryTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/tracking/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message trackingDeviceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = trackingServices.trackingDeviceGetAll(map, request, response);
		return message;
	}

}
