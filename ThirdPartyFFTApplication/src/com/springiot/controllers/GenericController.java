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
public class GenericController {
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Release the device
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
	@ApiOperation(value = "/fft/release/device", notes = "To Release the device")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imei", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "licence_key", value = "Requires the licence_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_active", value = "Requires the is_active", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires is_deleted", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/release/device", method = RequestMethod.POST)
	public @ResponseBody Message fftReleaseDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("5", map, null, request, response);
		return message;
	}

	/**
	 * To Insert User Logs.
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
	@ApiOperation(value = "/fft/user/logs/insert", notes = "To Insert User Logs.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "licence_key", value = "Requires the licence_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imei", value = "Requires the imei", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires the geofence_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "log_type", value = "Requires the log_type 0 is for check-in and 1 is for check-out", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/user/logs/insert", method = RequestMethod.POST)
	public @ResponseBody Message fftUserLogInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("8", map, null, request, response);
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
	@ApiOperation(value = "/fft/get/user/info", notes = "To Get User Details.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "licence_key", value = "Requires the licence_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imei", value = "Requires the imei", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gcm_id", value = "Requires the gcm_id", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/get/user/info", method = RequestMethod.POST)
	public @ResponseBody Message fftGetUserInfo(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
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
	@ApiOperation(value = "/fft/get/geofence/report", notes = "To Get User Report.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires the from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date", value = "Requires the end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/get/geofence/report", method = RequestMethod.POST)
	public @ResponseBody Message fftGetGeofenceReport(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("13", map, null, request, response);
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
	@ApiOperation(value = "/fft/user/details/get/all", notes = "To Get User Details.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/user/details/get/all", method = RequestMethod.POST)
	public @ResponseBody Message fftUserDetailsGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("16", map, null, request, response);
		return message;
	}

	/**
	 * To Get All Active Devices.
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
	@ApiOperation(value = "/fft/get/all/active/devices", notes = "To Get All Active Devices.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/get/all/active/devices", method = RequestMethod.POST)
	public @ResponseBody Message fftGetAllActiveDevices(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("12", map, null, request, response);
		return message;
	}

	/**
	 * To Update Last Onliine Time of Device.
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
	@ApiOperation(value = "/fft/user/logs/update", notes = "To Update Last Onliine Time of Device.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires device id of user's Phone", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "last_online_time", value = "Requires last_online_time of user's Phone", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/user/logs/update", method = RequestMethod.POST)
	public @ResponseBody Message fftUserLogsUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("18", map, null, request, response);
		return message;
	}

	/**
	 * To Get Devices to which escalation has to escalated
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
	@ApiOperation(value = "/fft/get/escalation/tab/offline", notes = "To Get Devices to which escalation has to escalated")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/get/escalation/tab/offline", method = RequestMethod.POST)
	public @ResponseBody Message fftGetEscalationTabOffline(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("19", map, null, request, response);
		return message;
	}

	/**
	 * To Get Devices to which escalation has to escalated
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
	@ApiOperation(value = "/fft/escalation/insert", notes = "To Get Devices to which escalation has to escalated")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "licence_key", value = "Requires the licence_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imei", value = "Requires the imei", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "email", value = "Requires the email", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "escalation_time", value = "Requires escalation_time", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_escalated", value = "Requires the is_escalated", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/escalation/insert", method = RequestMethod.POST)
	public @ResponseBody Message fftEscalationInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("20", map, null, request, response);
		return message;
	}

	/**
	 * To Get Devices to which escalation has to escalated
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
	@ApiOperation(value = "/fft/user/licence/get/all", notes = "To Get Devices to which escalation has to escalated")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/user/licence/get/all", method = RequestMethod.POST)
	public @ResponseBody Message fftUserLicenceGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = genericProcess.GenericProcedureCalling("21", map, null, request, response);
		return message;
	}

}
