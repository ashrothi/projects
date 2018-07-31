/**
 * This package contain the controller class to create APIs for GeoFenceController data.
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
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetWithoutDataSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Ankita Shrothi This class work as a controller which is used to
 *         create APIs to retrieve the GeoFence(device) metadata from xFusion
 *         database.
 */
@Controller
public class GeoFenceController {
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * Get all the geofence data of the given device Id
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/re/rule/geofence/get/all", notes = "Get all the geofence data of the given device Id", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID") })

	@RequestMapping(value = "/re/rule/geofence/get/all", method = RequestMethod.POST)
	public @ResponseBody Message xfusionReRuleGeofenceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCallingMetaData("456", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
