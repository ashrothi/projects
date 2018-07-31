/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.springiot.services.GrafanaServices;
import com.springiot.services.ThirdPartyServices;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used retrieve all vehicles or state
 * of vehicle or the type of vehicle or retrieve all vehicles based on some
 * specific criteria
 * 
 * @author Garima Joshi
 * @creation_date 27-02-2018
 */
@Controller
public class GrafanaController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GrafanaServices grafanaServices;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To call detail about trips covered by the vehicle within the specific
	 * time.
	 * 
	 * @param map
	 *            : Here pass the required parameters for API call.
	 * @return Return the response message.
	 */
	/*@ApiOperation(value = "/grafana/vehicle/details", notes = "Get details of parameter from single device of Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass the  limit for fetching data.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass the  offset for fetching data.", paramType = "Header"),
			@ApiImplicitParam(name = "limit", value = "Here pass start date in epoch format for getting data in specific time interval."),
			@ApiImplicitParam(name = "offset", value = "Here pass end date in epoch format for getting data in specific time interval.") })
	@RequestMapping(value = "/grafana/vehicle/details", method = RequestMethod.POST)
	public @ResponseBody Object grafanaVehicleDetailsApi(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Object message = grafanaServices.grafanaVehicleDetails(map, request, response);

		return message;
	}*/
	
	
	/**
	 * This API is base API used to add the datasource in Grafana as well as
	 * check the connectivity of the server.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/", method = {RequestMethod.GET}, headers = { "*/*"})
	public @ResponseBody Message testConnection(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = grafanaServices.testConnection(request, response);

		return message;
	}

	/**
	 * This API returns the metrics based on the input after calling Platform
	 * API.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/search", method = RequestMethod.POST)
	public @ResponseBody Object findMetricOptions(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */

		Object message = grafanaServices.findMetricOptions(request, response);

		return message;
	}

	/**
	 * This API returns the metrics based on the input after calling Platform
	 * API.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/query", method = RequestMethod.POST)

	public @ResponseBody Object returnMetrics(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Object responseObject = grafanaServices.returnMetrics(request, response);

		return responseObject;
	}

	/**
	 * This API returns the annotations after calling Platform API.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/annotations", method = RequestMethod.POST)

	public @ResponseBody List<Map<String, Object>> annotations(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<Map<String, Object>> responseObject = grafanaServices.annotations(request, response);

		return responseObject;
	}
}