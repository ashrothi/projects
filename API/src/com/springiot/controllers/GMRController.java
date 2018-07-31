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
import com.springiot.services.GMRServices;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.GmrTripDetailsInsertSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for GMR .
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class GMRController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private GMRServices gmrServices;

	/**
	 * Service to register AWB with vehicle registration number
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
	@ApiOperation(value = "/awb/register", notes = "Service to register AWB with vehicle registration number ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "Requires registration_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "order_number", value = "Requires order_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "customer_name ", value = "Requires customer_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "customer_email_id ", value = "Requires customer_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "customer_primary_address ", value = "Requires customer_primary_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "customer_secondary_address ", value = "Requires customer_secondary_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "customer_contact_no ", value = "Requires customer_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_lat ", value = "Requires source_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "source_long ", value = "Requires source_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_lat ", value = "Requires destination_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "destination_long ", value = "Requires destination_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_date ", value = "Requires start_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "warehouse_id ", value = "Requires warehouse_id", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/awb/register", method = RequestMethod.POST)
	public @ResponseBody Message tripDetailInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		if (!map.containsKey("registration_number") || !map.containsKey("order_number")
				|| !map.containsKey("source_lat") || !map.containsKey("source_long")
				|| !map.containsKey("destination_lat") || !map.containsKey("destination_long")
				|| !map.containsKey("customer_name") || !map.containsKey("customer_contact_no")
				|| !map.containsKey("warehouse_id")) {
			Message message = new Message();
			message.setDescription(
					"registration_number,order_number,source_lat,source_long,destination_lat,destination_long are mandatory feilds.");
			return message;
		} else {
			Message message = genericProcess.GenericProcedureCalling("18", map, null, request, response);
			return message;
		}

	}

	/**
	 * Service to register AWB with vehicle registration number
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
	@ApiOperation(value = "/get/all/vehicles", notes = "Service to register AWB with vehicle registration number ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/get/all/vehicles", method = RequestMethod.POST)
	public @ResponseBody Message getAllVehicle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = gmrServices.getAllVehicles(map, request, response);
		return message;
	}

	/**
	 * Service to register AWB with vehicle registration number
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
	@ApiIgnore
	@ApiOperation(value = "/gmr/update/open/ticket", notes = "Service to Update the status of AWB. ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "Requires registration_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "order_number", value = "Requires order_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "status_id ", value = "Requires status_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "remarks ", value = "Requires remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cool_dolly_id ", value = "Requires cool_dolly_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "warehouse_id ", value = "Requires warehouse_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/update/open/ticket", method = RequestMethod.POST)
	public @ResponseBody Message gmrupdateopenticket(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		if (!map.containsKey("registration_number") || !map.containsKey("order_number")
				|| !map.containsKey("status_id")) {
			Message message = new Message();
			message.setDescription("registration_number,order_number,status_id are mandatory feilds.");
			return message;
		} else {
			Message message = genericProcess.GenericProcedureCalling("24", map, null, request, response);
			return message;
		}
	}

	/**
	 * Service to register AWB with vehicle registration number
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
	@ApiOperation(value = "/gmr/update/open/ticket/activity", notes = "Service to Update the status of AWB. ", response = GmrTripDetailsInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "Requires registration_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "truck_status", value = "Requires truck_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "tdg", value = "Requires tdg", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "bag", value = "Requires bag", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "untz", value = "Requires untz", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "rlsd", value = "Requires rlsd", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cmbr", value = "Requires rlsd", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cmbrno", value = "Requires rlsd", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/gmr/update/open/ticket/activity", method = RequestMethod.POST)
	public @ResponseBody Message gmrupdateopenticketactivity(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		if (!map.containsKey("registration_number") || !map.containsKey("truck_status")) {
			Message message = new Message();
			message.setDescription("registration_number,order_number,status_id are mandatory feilds.");
			return message;
		} else {
			Message message = genericProcess.GenericProcedureCalling("26", map, null, request, response);
			return message;
		}
	}
}
