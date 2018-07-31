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
import com.springiot.services.ThirdPartyServices;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class ThirPartyController {

	@Autowired
	private ThirdPartyServices thirdPartyServices;

	/**
	 * To Get the device Meta data status on the basis of limit
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
	@ApiOperation(value = "/device/get/metadata/status/by/type/limit", notes = "To Get the device Meta data")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_type", value = "Requires the Device type", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "in_condition", value = "Requires condition for server side filtering", required = true, access = "query", paramType = "query", dataType = "Int") })
	@RequestMapping(value = "/device/get/metadata/status/by/type/limit", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByTypeLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.getMetadataStatusByTypeLimit(map, request, response);
		return message;
	}

	/**
	 * To Send Device SOS
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
	@ApiOperation(value = "/fft/device/sos", notes = "To Send Device SOS")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imei", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "licence_key", value = "Requires the licence_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires the latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires longitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "address", value = "Requires address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "remark", value = "Requires remark", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/device/sos", method = RequestMethod.POST)
	public @ResponseBody Message fftSOSDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.sendSOS(map, request, response);
		return message;
	}

	/**
	 * To Get Live Tracking Data
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
	@ApiOperation(value = "/fft/device/live/tracking/data", notes = "To Get Live Tracking Data")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/device/live/tracking/data", method = RequestMethod.POST)
	public @ResponseBody Message fftDeviceLiveTrackingData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.deviceLiveTrackingData(map, request, response);
		return message;
	}

	/**
	 * To Send Device SOS
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
	@ApiOperation(value = "/fft/multiple/log/insert", notes = "To Send Device SOS")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires the Device Id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imei", value = "Requires the host status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "licence_key", value = "Requires the licence_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "geofence_id", value = "Requires the geofence_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "data", value = "Requires the JSON Array of Multiple Records", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/fft/multiple/log/insert", method = RequestMethod.POST)
	public @ResponseBody Message multipleCheckinOut(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = thirdPartyServices.multipleLogsInsert(map, request, response);
		return message;
	}
}
