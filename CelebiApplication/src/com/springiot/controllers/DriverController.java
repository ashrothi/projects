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
import com.google.gson.Gson;
import com.springiot.response.Message;
import com.springiot.services.DriverServices;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.FlintDeleteDriverSwagger;
import com.springiot.swagger.response.FlintDriverInsertSwagger;
import com.springiot.swagger.response.FlintDriverUpdateSwagger;
import com.springiot.swagger.response.FlintGetAllDriverByVehicleSwagger;
import com.springiot.swagger.response.FlintGetDriverSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used for Driver Crud
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class DriverController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private DriverServices driverServices;

	/**
	 * To create new driver and insert its detail
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
	@ApiOperation(value = "/flint/driver/insert", notes = "To create new driver and insert its detail", response = FlintDriverInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the Email Address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name", value = "Requires first_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name", value = "Requires last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country", value = "Requires the country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state", value = "Requires the state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city", value = "Requires the city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number", value = "Requires preferred_number	", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers", value = "Requires phone_numbers", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "Requires address of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "prefered_contact_number", value = "Requires prefered_contact_number", required = true, access = "query", paramType = "query"), })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/driver/insert", method = RequestMethod.POST)
	public @ResponseBody Message flintDriverInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */

		Message message = driverServices.flintDriverCreate(map, request, response);

		return message;

	}

	/**
	 * To Update the driver information
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
	@ApiOperation(value = "/flint/driver/update", notes = "To Update the driver information", response = FlintDriverUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vehicle_user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vehicle_user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "license_key", value = "Requires license_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_inactive", value = "Requires is_deleted", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires is_deleted", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_first_name", value = "Requires driver_first_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_middle_name", value = "Requires driver_middle_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_last_name", value = "Requires driver_last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_contact_number", value = "Requires driver_contact_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_inactive_on", value = "Requires last_inactive_on", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_active_on", value = "Requires last_active_on", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_email_id", value = "Requires driver_email_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_address", value = "Requires driver_address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_city", value = "Requires driver_city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_state", value = "Requires driver_state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driving_license", value = "Requires driving_license", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driving_license_expiry_date", value = "Requires driving_license_expiry_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "driver_country", value = "Requires driver_country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "document_name", value = "Requires document_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "document_path", value = "Requires document_path", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/driver/update", method = RequestMethod.POST)
	public @ResponseBody Message flintUpdateDriver(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */

		Message message = genericProcess.GenericProcedureCalling("66", map, null, request, response);
		System.out.println(new Gson().toJson(message));
		return message;

	}

	/**
	 * To get all the Driver information.
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
	@ApiOperation(value = "/flint/get/driver", notes = "To get all the Driver information.", response = FlintGetDriverSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "license_key", value = "Requires  license_key of driver", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/driver", method = RequestMethod.POST)
	public @ResponseBody Message flintGetDriver(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("67", map, null, request, response);
		return message;
	}

	/**
	 * To Delete the Driver information.
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
	@ApiOperation(value = "/flint/delete/driver", notes = "To Delete the Driver information.", response = FlintDeleteDriverSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "license_key", value = "Requires  license_key of driver", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/delete/driver", method = RequestMethod.POST)
	public @ResponseBody Message flintDeleteDriver(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("85", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Driver information.
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
	@ApiOperation(value = "/flint/get/all/driver/by/vehicle", notes = "To get all the Driver information.", response = FlintGetAllDriverByVehicleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vehicle_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/all/driver/by/vehicle", method = RequestMethod.POST)
	public @ResponseBody Message flintGetAllDriverByVehicle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("86", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Driver information.
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
	@ApiOperation(value = "/flint/get/all/drivers/by/organization", notes = "To get all the Driver information.", response = FlintGetAllDriverByVehicleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id of User", required = true, access = "query", paramType = "query"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/all/drivers/by/organization", method = RequestMethod.POST)
	public @ResponseBody Message flintgetalldriversbyorganization(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("119", map, null, request, response);
		return message;
	}

}
