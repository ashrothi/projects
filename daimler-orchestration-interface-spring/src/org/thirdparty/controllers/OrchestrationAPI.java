/**
 * This Package contains controllers of Third Party Orchestration API.
 */
package org.thirdparty.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thirdparty.request.model.DeviceSetting;
import org.thirdparty.request.model.SwapDeviceProfile;
import org.thirdparty.resources.JsonModification;
import org.thirdparty.services.ThirdPartyService;
import org.thirdparty.swagger.response.ApiResponseSwagger;

import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class OrchestrationAPI {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private ThirdPartyService thirdPartyService;
	static final String country = "Nill";

	/**
	 * Gets List of Device objects as per the size and page number. If parameters
	 * are not provided then first 20 items shall be listed
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/SIMs", notes = "Gets List of Device objects as per the size and page number. If parameters are not provided then first 20 items shall be listed", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "size", value = "size of results to return. ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start", value = "Start Index (0 based) from where results should be retrieved", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/SIMs", method = RequestMethod.GET)
	public ResponseEntity<?> SIMs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();

		map.put("country", country);

		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 1, request, response);
		return responseMessage;

	}

	/**
	 * Returns the details of the SIM for the provided ICCID or IMSI. Either IMSI or
	 * ICCID should be present in the request.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/SIM", notes = "Returns the details of the SIM for the provided ICCID or IMSI. Either IMSI or ICCID should be present in the request.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "iccid", value = "ICCID of the SIM", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imsi", value = "IMSI corresponding to the SIM", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/SIM", method = RequestMethod.GET)
	public ResponseEntity<?> SIM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("imsi", String.valueOf(request.getParameter("imsi")));
		map.put("iccid", String.valueOf(request.getParameter("iccid")));
		map.put("trackingid", String.valueOf(request.getParameter("trackingid")));
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.getSimDetail(map, 2, request, response);
		return responseMessage;
	}

	/**
	 * Returns the details of the SIM for the provided IMSI List
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/SIM ", notes = "Returns the details of the SIM for the provided IMSI List", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })
	@RequestMapping(value = "/SIM", method = RequestMethod.PUT)
	public ResponseEntity<?> SIMs(@ApiParam(name = "ProfileData", value = "List of IMSIs") @RequestBody String imsi,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("imsi", imsi.toString());
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 3, request, response);
		return responseMessage;

	}

	/**
	 * Returns the state of the SIM for provided ICCID
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/getDataUsage", notes = "Returns the state of the SIM for provided ICCID.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "imsi", value = "IMSI corresponding to the SIM", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fromDate", value = "Start Date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "toDate", value = "End Date", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/getDataUsage", method = RequestMethod.GET)
	public ResponseEntity<?> getDataUsages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("imsi", request.getParameter("imsi"));
		map.put("fromDate", request.getParameter("fromDate"));
		map.put("toDate", request.getParameter("toDate"));
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 4, request, response);
		return responseMessage;

	}

	/**
	 * Fetch data usage details for given IMSI List
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/getDataUsage", notes = "Fetch data usage details for given IMSI List")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })
	@RequestMapping(value = "/getDataUsage", method = RequestMethod.PUT)
	public ResponseEntity<?> getDataUsage(@ApiParam(name = "IMSI", value = "List of IMSIs") @RequestBody String IMSI,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IMSI " + IMSI);
		Map<String, String> map = new LinkedHashMap<>();
		map.put("imsi", IMSI.toString());
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 5, request, response);
		return responseMessage;

	}

	/**
	 * Returns the state of the SIM for provided ICCID
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/SIMSessionInfo", notes = "Returns the state of the SIM for provided ICCID.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "imsi", value = "IMSI corresponding to the SIM", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/SIMSessionInfo", method = RequestMethod.GET)
	public ResponseEntity<?> SIMSessionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("imsi", request.getParameter("imsi"));
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 6, request, response);
		return responseMessage;

	}

	/**
	 * Returns the state of the SIM for provided ICCID
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/SIMSessionHistory", notes = "Returns the state of the SIM for provided ICCID.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "imsi", value = "IMSI corresponding to the SIM", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fromDate", value = "Start Date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "toDate", value = "End Date", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/SIMSessionHistory", method = RequestMethod.GET)
	public ResponseEntity<?> SIMSessionHistory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("imsi", request.getParameter("imsi"));
		map.put("fromDate", request.getParameter("fromDate"));
		map.put("toDate", request.getParameter("toDate"));
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 7, request, response);
		return responseMessage;

	}

	/**
	 * Returns the state of the SIM for provided ICCID
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/getSIMState", notes = "Returns the state of the SIM for provided ICCID.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "iccid", value = "Requires ICCID of the Device that will be using the services.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "imsi", value = "Requires IMSI of the Device that will be using the services.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/getSIMState", method = RequestMethod.GET)
	public ResponseEntity<?> getSIMState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("iccid", String.valueOf(request.getParameter("iccid")));
		map.put("imsi", String.valueOf(request.getParameter("imsi")));
		map.put("trackingid", String.valueOf(request.getParameter("trackingid")));
		map.put("country", country);

		ResponseEntity<?> responseMessage = thirdPartyService.getSimStateDetail(map, 8, request, response);
		return responseMessage;

	}

	/**
	 * The API is used to activate SIM which means enabling voice, SMS and data
	 * service across elements of Globetouch connectivity platform.The API expects
	 * provisioning/bootstrap ICCID as mandatory attribute and returns assigned
	 * MSISDN to the SIM for the communication service on operational profile. This
	 * is async API where result/response is sent in a notification API
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/activateSIM/{ICCID}", notes = "The API is used to activate SIM which means enabling voice, SMS and data service across elements of Globetouch connectivity platform.The API expects provisioning/bootstrap ICCID as mandatory attribute and returns assigned MSISDN to the SIM for the communication service on operational profile. This is async API where result/response is sent in a notification API", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ICCID", value = "Requires ICCID of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/activateSIM/{ICCID}", method = RequestMethod.POST)
	public ResponseEntity<?> activateSIM(@PathVariable String ICCID, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("ICCID", ICCID);
		map.put("country", country);
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnURL")));
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 9, request, response);
		return responseMessage;

	}

	/**
	 * The API is used to Suspend SIM which means disabling voice, SMS and data
	 * service across elements of Globetouch connectivity platform.The API expects
	 * provisioning/bootstrap ICCID as mandatory attribute and returns status of
	 * ICCID. This is async API where result/response is sent in a notification API
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/suspendSIM/{ICCID}", notes = "The API is used to Suspend SIM which means disabling voice, SMS and data service across elements of Globetouch connectivity platform.The API expects provisioning/bootstrap ICCID as mandatory attribute and returns status of ICCID. This is async API where result/response is sent in a notification API", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ICCID", value = "Requires ICCID of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/suspendSIM/{ICCID}", method = RequestMethod.POST)
	public ResponseEntity<?> suspendSIM(@PathVariable String ICCID, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("ICCID", ICCID);
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnUrl")));
		map.put("country", country);
		map.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
		map.put("requestId", String.valueOf(request.getHeader("requestId")));
		map.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
		map.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
		map.put("iccid", String.valueOf(ICCID));
		map.put("RequestID", String.valueOf(request.getHeader("requestId")));
		map.put("ReturnURL", String.valueOf(request.getHeader("returnUrl")));
		map.put("host_address", request.getRemoteHost());
		map.put("Accept", String.valueOf(request.getHeader("Accept")));
		map.put("trackingid", String.valueOf(request.getParameter("trackingid")));
		ResponseEntity<?> responseMessage = thirdPartyService.suspendedSIM(map, 10, request, response);
		if (responseMessage.getStatusCode().is2xxSuccessful()) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return responseMessage;

	}

	/**
	 * The API is used to Reactivate SIM after Suspension which means enabling
	 * voice, SMS and data service across elements of Globetouch connectivity
	 * platform.The API expects provisioning/bootstrap ICCID as mandatory attribute
	 * and returns status of ICCID. This is async API where result/response is sent
	 * in a notification API
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/reactivateSIM/{ICCID}", notes = "The API is used to Reactivate SIM after Suspension which means enabling voice, SMS and data service across elements of Globetouch connectivity platform.The API expects provisioning/bootstrap ICCID as mandatory attribute and returns status of ICCID. This is async API where result/response is sent in a notification API", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ICCID", value = "Requires ICCID of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/reactivateSIM/{ICCID}", method = RequestMethod.POST)
	public ResponseEntity<?> reactivateSIM(@PathVariable String ICCID, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("ICCID", ICCID);
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnUrl")));
		map.put("country", country);
		map.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
		map.put("requestId", String.valueOf(request.getHeader("requestId")));
		map.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
		map.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
		map.put("iccid", String.valueOf(ICCID));
		map.put("RequestID", String.valueOf(request.getHeader("requestId")));
		map.put("ReturnURL", String.valueOf(request.getHeader("returnUrl")));
		map.put("host_address", request.getRemoteHost());
		map.put("Accept", String.valueOf(request.getHeader("Accept")));
		map.put("trackingid", String.valueOf(request.getParameter("trackingid")));
		ResponseEntity<?> responseMessage = thirdPartyService.reactivateSim(map, 11, request, response);
		if (responseMessage.getStatusCode().is2xxSuccessful()) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return responseMessage;

	}

	/**
	 * The API is used to Deactivate SIM which means permanently disabling voice,
	 * SMS and data service across elements of Globetouch connectivity platform.The
	 * API expects provisioning/bootstrap ICCID as mandatory attribute and returns
	 * status of ICCID. This is async API where result/response is sent in a
	 * notification API
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/deactivateSIM/{ICCID}", notes = "The API is used to Deactivate SIM which means permanently disabling voice, SMS and data service across elements of Globetouch connectivity platform.The API expects provisioning/bootstrap ICCID as mandatory attribute and returns status of ICCID. This is async API where result/response is sent in a notification API", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ICCID", value = "Requires ICCID of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/deactivateSIM/{ICCID}", method = RequestMethod.POST)
	public ResponseEntity<?> deactivateSIM(@PathVariable String ICCID, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("ICCID", ICCID);
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnURL")));
		map.put("country", country);
		ResponseEntity<?> responseMessage = thirdPartyService.genericCalling(map, 12, request, response);
		return responseMessage;

	}

	/**
	 * The API is used to disable voice, SMS and data services on Old ICCID and
	 * enable the services on new ICCID. This is async API where result/response is
	 * sent in a notification API
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/swapDevice/{ICCID}", notes = "The API is used to disable voice, SMS and data services on Old ICCID and enable the services on new ICCID. This is async API where result/response is sent in a notification API", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ICCID", value = "Requires ICCID of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/swapDevice/{ICCID}", method = RequestMethod.POST)
	public ResponseEntity<?> swapDevice(@PathVariable String ICCID,
			@ApiParam(name = "ProfileData", value = "Request Body of new Profile Data."
					+ "newICCID: New ICCID of the Device that will be using the services.(Mandatory Parameter)") @RequestBody SwapDeviceProfile profile,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("ICCID", ICCID);
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnURL")));
		map.put("country", country);

		return thirdPartyService.genericCalling(map, 13, request, response);

	}

	/**
	 * To Push the coming Data from ESIM Notification API to kafka queue
	 * 
	 * @param data
	 * @param kafka_type
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/notification/{type}", notes = "To Push the coming Data from ESIM Notification API to kafka queue", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "type", value = "Requires type of the Notification  that will be using to send the ntification to client end.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/notification/{type}", method = RequestMethod.POST)
	public ResponseEntity<?> pushNotification(@PathVariable String type, @RequestParam Object data,
			@RequestParam String kafka_type, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return thirdPartyService.pushNotification(type, data, kafka_type, request, response);
	}

	/**
	 * This API is Service to update settings on a device.1.Enable voice services
	 * (GMSA only) 2.Enable network attachment rule.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param deviceSettingData
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/devices/{deviceId}/settings", notes = "This API is Service to update settings on a device.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "deviceId", value = "Requires SIM Number of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String")

	})
	@RequestMapping(value = "/devices/{deviceId}/settings", method = RequestMethod.POST)
	public ResponseEntity<?> deviceCreate(@PathVariable String deviceId,
			@ApiParam(name = "deviceSettingData", value = "Request Body of device Setting Field only populated if requesting network attachment notification rule OR service needs to be enabled .These both are optional parameter. ") @RequestBody DeviceSetting deviceSettingData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		JsonModification.parse(new Gson().toJson(deviceSettingData).trim(), map);
		map.put("ICCID", deviceId);
		map.put("request_id", String.valueOf(request.getHeader("requestId")));
		map.put("return_url", String.valueOf(request.getHeader("returnUrl")));
		map.put("country", country);
		map.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
		map.put("requestId", String.valueOf(request.getHeader("requestId")));
		map.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
		map.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
		map.put("iccid", String.valueOf(deviceId));
		map.put("RequestID", String.valueOf(request.getHeader("requestId")));
		map.put("ReturnURL", String.valueOf(request.getHeader("returnUrl")));
		map.put("host_address", request.getRemoteHost());
		map.put("Accept", String.valueOf(request.getHeader("Accept")));
		ResponseEntity<?> responseMessage = thirdPartyService.getUpdateDevice(map, 2, request, response);
		return responseMessage;

	}

	@ApiOperation(value = "/ping", notes = "This API is Service to update settings on a device.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),

	})
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<?> pingAPI(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getParameter("echo") == null) {

			Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			Map<String, Object> ErrorMessageMap = new LinkedHashMap<>();
			ErrorMessageMap.put("code", "ECH001");
			ErrorMessageMap.put("description", "echo is mandatory");
			FinalErrorMessageMap.put("errors", ErrorMessageMap);
			return new ResponseEntity<>(FinalErrorMessageMap, HttpStatus.BAD_REQUEST);
		} else {
			Map<String, Object> SuccessMap = new LinkedHashMap<>();
			SuccessMap.put("echo", String.valueOf(request.getParameter("echo")));
			return new ResponseEntity<>(SuccessMap, HttpStatus.OK);
		}

	}
}
