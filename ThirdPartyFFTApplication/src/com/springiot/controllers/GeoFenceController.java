/**
 * This package contains the Controller for GMR Application.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * To Import Classes to access their functionality
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.ThirdPartyServices;

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
public class GeoFenceController {
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private ThirdPartyServices thirdPartServices;
	/**
	 * To Get Geofence Coordinate by Id
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
	@ApiOperation(value = "/fft/geofences/coordinates/get/by/id", notes = "To Get Geofence Coordinate by Id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires the Geofence_id", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofences/coordinates/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofencesCoordinatesGetById(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("3", map, null, request, response);
		return message;
	}

	/**
	 * To Get all Geofences
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
	@ApiOperation(value = "/fft/geofences/get/all", notes = "To Get all Geofences")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofences/get/all", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofencesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("4", map, null, request, response);
		return message;
	}

	/**
	 * To Insert new Geofence
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
	@ApiOperation(value = "/fft/geofence/insert", notes = "To Insert new Geofence")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_name", value = "Requires the geofence_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "speed_limit", value = "Requires the speed_limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "color", value = "Requires the color", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_radius", value = "Requires the geofence_radius", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "x_coordinate", value = "Requires the x_coordinate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "y_coordinate", value = "Requires the y_coordinate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "z_coordinate", value = "Requires the z_coordinate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "coordinate_index", value = "Requires the coordinate_index", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofence/insert", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofenceInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("6", map, null, request, response);
		return message;
	}

	/**
	 * To Update new Geofence
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
	@ApiOperation(value = "/fft/geofence/update", notes = "To Update new Geofence")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires geofence_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_name", value = "Requires the geofence_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "speed_limit", value = "Requires the speed_limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "color", value = "Requires the color", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_radius", value = "Requires the geofence_radius", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "x_coordinate", value = "Requires the x_coordinate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "y_coordinate", value = "Requires the y_coordinate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "z_coordinate", value = "Requires the z_coordinate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "coordinate_index", value = "Requires the coordinate_index", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofence/update", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofenceUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = genericProcess.GenericProcedureCalling("7", map, null, request, response);
		if (message.isValid()) {
			Boolean status = thirdPartServices.pushFCMNotificationGeoFenceUpdate(message.getObject());
			if (status == true) {
				return message;
			}

		}
		return message;
	}

	/**
	 * To Insert new Geofence
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
	@ApiOperation(value = "/fft/geofence/assign/to/user", notes = "To Insert new Geofence")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires the geofence_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "assign_user_id", value = "Requires the assign_user_id", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofence/assign/to/user", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofenceAssignToUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("10", map, null, request, response);
		return message;
	}

	/**
	 * To Insert new Geofence
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
	@ApiOperation(value = "/fft/geofences/coordinates/get/all/by/id", notes = "To Get User Details.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_user_id", value = "Requires the user_user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires the geofence_id", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofences/coordinates/get/all/by/id", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofencesCoordinatesGetAllById(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("14", map, null, request, response);
		return message;
	}

	/**
	 * To Insert new Geofence
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
	@ApiOperation(value = "/fft/geofence/delete", notes = "To Insert new Geofence")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires the geofence_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is_deleted", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/geofence/delete", method = RequestMethod.POST)
	public @ResponseBody Message fftGeofenceDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("9", map, null, request, response);
		return message;
	}

}
