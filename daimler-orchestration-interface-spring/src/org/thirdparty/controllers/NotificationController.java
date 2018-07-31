/**
 * This Package contains controllers of Third Party Orchestration API.
 */
package org.thirdparty.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thirdparty.resources.JsonModification;
import org.thirdparty.services.ThirdPartyService;
import org.thirdparty.swagger.response.ApiResponseSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class NotificationController {

	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private ThirdPartyService thirdPartyService;

	/**
	 * This is the asynchronous notification sent for activateSIM request after
	 * successfully activating the SIM
	 * 
	 * @param data
	 * @param kafka_type
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(value = "/notifications/SIMActivated", notes = "This is the asynchronous notification sent for activateSIM request after successfully activating the SIM", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/notification/SIMActivated", method = RequestMethod.POST)
	public ResponseEntity<?> pushSIMActivatedNotification(@RequestParam Object data, @RequestParam String kafka_type,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> responseMessage = thirdPartyService.pushNotification("SIMActivated", data, kafka_type,
				request, response);

		return responseMessage;
	}

	/**
	 * This is the asynchronous notification sent for suspendSIM request after
	 * successfully suspending the SIM from service
	 * 
	 * @param data
	 * @param kafka_type
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings({ "serial", "unchecked" })
	/*
	 * @ApiOperation(value = "/notifications/SIMSuspended", notes =
	 * "This is the asynchronous notification sent for suspendSIM request after successfully suspending the SIM from service"
	 * , response = ApiResponseSwagger.class)
	 * 
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(name = "Authorization", value =
	 * "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 "
	 * , required = true, access = "header", paramType = "header", dataType =
	 * "String"),
	 * 
	 * @ApiImplicitParam(name = "type", value =
	 * "Requires type of the Notification  that will be using to send the ntification to client end."
	 * , required = true, access = "path", paramType = "path", dataType =
	 * "String") })
	 * 
	 * @RequestMapping(value = "/notifications/SIMSuspended", method =
	 * RequestMethod.POST) public ResponseEntity<?>
	 * pushSIMSuspendedNotification(@RequestParam Object data, @RequestParam
	 * String kafka_type, HttpServletRequest request, HttpServletResponse
	 * response) throws Exception {
	 * 
	 * ResponseEntity<?> responseMessage =
	 * thirdPartyService.pushNotification("SIMSuspended", data, kafka_type,
	 * request, response);
	 * 
	 * return responseMessage; }
	 */
	@ApiOperation(value = "/notifications/SIMSuspended", notes = "This is the asynchronous notification sent for suspendSIM request after successfully suspending the SIM from service", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Here pass the request id of the request.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "IMSI", value = "Here pass IMSI of the Sunspended SIM.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "TrackingId", value = "Here pass Tracking ID as received in request. If not received this param is not sent.", required = false, access = "header", paramType = "header", dataType = "String") })

	@RequestMapping(value = "/notifications/SIMSuspended", method = RequestMethod.POST)
	public ResponseEntity<?> pushSIMSuspendedNotification(
			@ApiParam(name = "profile", value = "Request Body of Profile Field contains details about the SIM.") @RequestBody Object profile,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(profile.toString());
//		Type type = new TypeToken<Map<String, Object>>() {
//		}.getType();
//
//		Map<String, String> jsonRequest = new HashMap<>();
//		JsonModification.parse(String.valueOf(profile), jsonRequest);
//		System.out.println(jsonRequest.get("errors"));
//
//		BigDecimal bd = new BigDecimal(jsonRequest.get("ICCID").toString());
//		long iccid = bd.longValue();
//		BigDecimal bigd = new BigDecimal(jsonRequest.get("MSISDN").toString());
//		long msisdn = bigd.longValue();
//
//		Map<String, Object> errorMap = (Map<String, Object>) new Gson()
//				.fromJson(String.valueOf(jsonRequest.get("errors")), type);
//
//		BigDecimal bdec = new BigDecimal(errorMap.get("code").toString());
//		long code = bdec.longValue();

		Map<String, String> map = new LinkedHashMap<>();
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("requestId", String.valueOf(request.getHeader("requestId")));
		map.put("trackingid", String.valueOf(request.getParameter("trackingid")));
		map.put("imsi", String.valueOf(request.getHeader("IMSI")));
//		map.put("ICCID", String.valueOf(iccid));
//		map.put("MSISDN", String.valueOf(msisdn));
//		map.put("code", String.valueOf(code));
//		map.put("description", String.valueOf(errorMap.get("description")));
		// Set notificationType.
		map.put("status", "SIMSuspended");
		map.put("api_body", String.valueOf(profile).replaceAll("\"", "'"));
		ResponseEntity<?> responseMessage = thirdPartyService.simSuspendedNotification(map, "publisher", request,
				response);

		return responseMessage;
	}

	/**
	 * This is the asynchronous notification sent for reactivateSIM request
	 * after successfully Reactivating the SIM.
	 * 
	 * @param data
	 * @param kafka_type
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	/*
	 * @ApiOperation(value = "/notifications/SIMReactivated", notes =
	 * "This is the asynchronous notification sent for reactivateSIM request after successfully Reactivating the SIM."
	 * , response = ApiResponseSwagger.class)
	 * 
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(name = "Authorization", value =
	 * "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 "
	 * , required = true, access = "header", paramType = "header", dataType =
	 * "String"),
	 * 
	 * @ApiImplicitParam(name = "type", value =
	 * "Requires type of the Notification  that will be using to send the ntification to client end."
	 * , required = true, access = "path", paramType = "path", dataType =
	 * "String") })
	 * 
	 * @RequestMapping(value = "/notifications/SIMReactivated", method =
	 * RequestMethod.POST) public ResponseEntity<?>
	 * pushSIMReactivatedNotification(@RequestParam Object data, @RequestParam
	 * String kafka_type, HttpServletRequest request, HttpServletResponse
	 * response) throws Exception {
	 * 
	 * ResponseEntity<?> responseMessage =
	 * thirdPartyService.pushNotification("SIMReactivated", data, kafka_type,
	 * request, response);
	 * 
	 * return responseMessage; }
	 */
	@ApiOperation(value = "/notifications/SIMReactivated", notes = "This is the asynchronous notification sent for reactivateSIM request after successfully suspending the SIM from service", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Here pass the request id of the request.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "IMSI", value = "Here pass IMSI of the Sunspended SIM.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "TrackingId", value = "Here pass Tracking ID as received in request. If not received this param is not sent.", required = false, access = "header", paramType = "header", dataType = "String") })

	@RequestMapping(value = "/notifications/SIMReactivated", method = RequestMethod.POST)
	public ResponseEntity<?> pushSIMReactivatedNotification(
			@ApiParam(name = "profile", value = "Request Body of Profile Field contains details about the SIM.") @RequestBody String profile,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(String.valueOf(profile));
		Map<String, String> jsonRequest = new HashMap<>();
		JsonModification.parse(String.valueOf(profile), jsonRequest);
//		BigDecimal bd = new BigDecimal(jsonRequest.get("ICCID").toString());
//		long iccid = bd.longValue();
//		BigDecimal bigd = new BigDecimal(jsonRequest.get("MSISDN").toString());
//		long msisdn = bigd.longValue();
//		Type type = new TypeToken<Map<String, Object>>() {
//		}.getType();
//
//		Map<String, Object> errorMap = (Map<String, Object>) new Gson()
//				.fromJson(String.valueOf(jsonRequest.get("errors")), type);
//
//		BigDecimal bdec = new BigDecimal(errorMap.get("code").toString());
//		long code = bdec.longValue();

		Map<String, String> map = new LinkedHashMap<>();
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("requestId", String.valueOf(request.getHeader("requestId")));
		map.put("trackingid", String.valueOf(request.getParameter("trackingid")));
		map.put("imsi", String.valueOf(request.getHeader("IMSI")));
//		map.put("ICCID", String.valueOf(iccid));
//		map.put("MSISDN", String.valueOf(msisdn));
//		map.put("code", String.valueOf(code));
//		map.put("description", String.valueOf(errorMap.get("description")));
		// Set notificationType.
		map.put("status", "SIMReactivated");
		map.put("api_body", String.valueOf(profile).replaceAll("\"", "'"));
		ResponseEntity<?> responseMessage = thirdPartyService.simSuspendedNotification(map, "publisher", request,
				response);

		return responseMessage;
	}

	/**
	 * This is the asynchronous notification sent for deactivateSIM request
	 * after successfully Deactivating the SIM.
	 * 
	 * @param data
	 * @param kafka_type
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(value = "/notifications/SIMDeactivated", notes = "This is the asynchronous notification sent for deactivateSIM request after successfully Deactivating the SIM.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "type", value = "Requires type of the Notification  that will be using to send the ntification to client end.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/notifications/SIMDeactivated", method = RequestMethod.POST)
	public ResponseEntity<?> pushSIMDeactivatedNotification(@RequestParam Object data, @RequestParam String kafka_type,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> responseMessage = thirdPartyService.pushNotification("SIMDeactivated", data, kafka_type,
				request, response);

		return responseMessage;
	}

	/**
	 * This is the asynchronous notification sent after successfully handled
	 * deviceSwap Request.
	 * 
	 * @param data
	 * @param kafka_type
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(value = "/notifications/deviceSwapped", notes = "This is the asynchronous notification sent after successfully handled deviceSwap Request.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "type", value = "Requires type of the Notification  that will be using to send the ntification to client end.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/notifications/deviceSwapped", method = RequestMethod.POST)
	public ResponseEntity<?> pushdeviceSwappedNotification(@RequestParam Object data, @RequestParam String kafka_type,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> responseMessage = thirdPartyService.pushNotification("deviceSwapped", data, kafka_type,
				request, response);

		return responseMessage;
	}
}
