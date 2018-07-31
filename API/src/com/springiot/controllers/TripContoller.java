/**
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
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Generic
 * Procedure Calling.
 * 
 * @author tanvigarg
 *
 */
@Controller
public class TripContoller {
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Insert Trip detail
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
	@ApiOperation(value = "/gmr/trip/details/insert", notes = "To Insert Trip detail ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "title", value = "Requires title", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description ", value = "Requires description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "remarks ", value = "Requires remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "assigned_to ", value = "Requires assigned_to", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_datetime ", value = "Requires trip_datetime", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_time ", value = "Requires start_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_time ", value = "Requires end_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_latitude ", value = "Requires source_latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_longitude ", value = "Requires source_longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_poi_id ", value = "Requires source_poi_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_location ", value = "Requires source_location", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_associated_email ", value = "Requires source_associated_email", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_contact_number ", value = "Requires source_contact_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_remarks ", value = "Requires source_remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_latitude ", value = "Requires destination_latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_longitude ", value = "Requires destination_longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_poi_id ", value = "Requires destination_poi_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_location ", value = "Requires destination_location", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_associated_email ", value = "Requires destination_associated_email", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_contact_number ", value = "Requires destination_contact_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_remarks ", value = "Requires destination_remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id ", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/trip/details/insert", method = RequestMethod.POST)
	public @ResponseBody Message tripDetailInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("11", map, null, request, response);
		return message;
	}

	/**
	 * To Update Trip detail
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
	@ApiOperation(value = "/gmr/trip/details/update", notes = "To Update Trip detail ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "title", value = "Requires title", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description ", value = "Requires description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "remarks ", value = "Requires remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "assigned_to ", value = "Requires assigned_to", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_datetime ", value = "Requires trip_datetime", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_time ", value = "Requires start_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_time ", value = "Requires end_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_latitude ", value = "Requires source_latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_longitude ", value = "Requires source_longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_poi_id ", value = "Requires source_poi_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_location ", value = "Requires source_location", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_associated_email ", value = "Requires source_associated_email", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_contact_number ", value = "Requires source_contact_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_remarks ", value = "Requires source_remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_latitude ", value = "Requires destination_latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_longitude ", value = "Requires destination_longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_poi_id ", value = "Requires destination_poi_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_location ", value = "Requires destination_location", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_associated_email ", value = "Requires destination_associated_email", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_contact_number ", value = "Requires destination_contact_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_remarks ", value = "Requires destination_remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_id ", value = "Requires trip_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "status ", value = "Requires status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_alias ", value = "Requires trip_alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id ", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted ", value = "Requires is_deleted", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/trip/details/update", method = RequestMethod.POST)
	public @ResponseBody Message tripDetailUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("12", map, null, request, response);
		return message;
	}

	/**
	 * To Get Trip Task detail
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
	@ApiOperation(value = "/gmr/open/trips/get/by/vehicle/id", notes = "To Get Trip Task detail ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id ", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/open/trips/get/by/vehicle/id", method = RequestMethod.POST)
	public @ResponseBody Message tripGetDetail(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("13", map, null, request, response);
		return message;
	}

	/**
	 * To Get Trip Activity detail
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
	@ApiOperation(value = "/gmr/open/trips/activity/get/by/trip/alias", notes = "To Get Trip Activity detail ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_alias ", value = "Requires trip_alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/open/trips/activity/get/by/trip/alias", method = RequestMethod.POST)
	public @ResponseBody Message tripOpenActivityGetByTripAliastDetail(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("14", map, null, request, response);
		return message;
	}

	/**
	 * To Get Activity List
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
	@ApiOperation(value = "/gmr/get/activity/list", notes = "To Get Activity List ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id ", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/get/activity/list", method = RequestMethod.POST)
	public @ResponseBody Message gmrGetActivityList(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("15", map, null, request, response);
		return message;
	}

	/**
	 * To Get Close Trip Task detail
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
	@ApiOperation(value = "gmr/close/trips/get/by/vehicle/id", notes = "To Get Close Trip Task detail ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id ", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "gmr/close/trips/get/by/vehicle/id", method = RequestMethod.POST)
	public @ResponseBody Message gmrCloseTripsGetByVehicleId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("16", map, null, request, response);
		return message;
	}

	/**
	 * To Get Close Trip Activity detail
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
	@ApiOperation(value = "gmr/close/trips/activity/get/by/trip/alias", notes = "To Get Close Trip Activity detail ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_alias ", value = "Requires trip_alias", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "gmr/close/trips/activity/get/by/trip/alias", method = RequestMethod.POST)
	public @ResponseBody Message gmrCloseTripsActivityGetByTripAlias(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("17", map, null, request, response);
		return message;
	}
}
