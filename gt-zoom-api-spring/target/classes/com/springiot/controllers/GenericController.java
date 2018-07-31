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
import com.springiot.swagger.response.CityGetByStateSwagger;
import com.springiot.swagger.response.GenericGetAllSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Generic
 * Procedure Calling.
 * 
 * @author Ankita Shrothi
 * @Updated_by Mandeep Singh
 * @updated_on 06-04-2018
 */
@Controller
public class GenericController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get the state by country id.
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
	@ApiOperation(value = "/state/get/by/country", notes = "To get the state by country id.", response = GenericGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "country_id", value = "Requires the country id", required = true, access = "query", paramType = "query", dataType = "String") })

	
	 /* Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/state/get/by/country", method = RequestMethod.POST)
	public @ResponseBody Message GTZoomstateGetByCountryId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		 /* Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("7", map, null, request, response);
		return message;
	}
	
	/**
	 * To get the country.
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

	@ApiOperation(value = "/get/country", notes = "To get the country.", response = GenericGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })

	
	 /* Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/get/country", method = RequestMethod.POST)
	public @ResponseBody Message countryGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		 /* Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("8", map, null, request, response);
		return message;
	}

	/**
	 * To get the city by state id.
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

	@ApiOperation(value = "/city/get/by/state", notes = "To get the city by state id.", response = CityGetByStateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "state_id", value = "Requires the state id", required = true, access = "query", paramType = "query", dataType = "String") })

	
	 /* Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/city/get/by/state", method = RequestMethod.POST)
	public @ResponseBody Message cityGetByStateId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		 /* Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("9", map, null, request, response);
		return message;
	}

}
