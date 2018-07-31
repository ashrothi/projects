/**
 * This Package contains controllers of Third Party Orchestration API.
 */
package org.thirdparty.controllers;

import java.util.Optional;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thirdparty.request.model.AddOrder;
import org.thirdparty.request.model.DeviceSetting;
import org.thirdparty.request.model.OnBoarding;
import org.thirdparty.request.model.SimProfile;
import org.thirdparty.request.model.UpdateSubscriber;
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
	@Autowired
	private ThirdPartyService thirdPartyService;

	/**
	 * This API is to change SIM Profile on a device.
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

	@ApiOperation(value = "/gunFiring", notes = "This API is to escalate the Gun Firing event.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "deviceId", value = "Requires SIM Number of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/gunFiring", method = RequestMethod.POST)
	public ResponseEntity<?> deviceRegister(@PathVariable String deviceId,
			@ApiParam(name = "simProfileData", value = "Request Body of sim Profile Data."
					+ "countryCode:2-character ISO code of target country.(Mandatory Parameter)"
					+ "targetProfile:Indicates which profile to download to the SIM based on target country..(Mandatory Parameter)( shoulb be either of one.“bootstrap”, “local”)  ") @RequestBody UpdateSubscriber simProfileData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.simProfiles(new Gson().toJson(simProfileData).toString(), deviceId, request, response);

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

	@ApiOperation(value = "/houseFire", notes = "This API is Service to escalate House Fire event", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "deviceId", value = "Requires SIM Number of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String")

	})
	@RequestMapping(value = "/houseFire", method = RequestMethod.POST)
	public ResponseEntity<?> deviceCreate(@PathVariable String deviceId,
			@ApiParam(name = "deviceSettingData", value = "Request Body of device Setting Field only populated if requesting network attachment notification rule OR service needs to be enabled .These both are optional parameter. ") @RequestBody UpdateSubscriber deviceSettingData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.deviceSettings(new Gson().toJson(deviceSettingData).toString(), deviceId, request,
				response);
	}

	/**
	 * Service to Onboard a new subscriber with a device and maybe add a Demo or
	 * Trial WiFi plan.
	 * 
	 * @param onbordingRequestData
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
	@ApiOperation(value = "/fieldServiceWorkerSafety", notes = "This API is Service to escalate Field Service Worker Safety event.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/fieldServiceWorkerSafety", method = RequestMethod.POST)
	public ResponseEntity<?> onBoarding(
			@ApiParam(name = "onbordingRequestData", value = "Data to OnBoard User. ") @RequestBody UpdateSubscriber onbordingRequestData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.onBoarding(new Gson().toJson(onbordingRequestData).toString(), request, response);
	}

	/**
	 * Service to Onboard a new subscriber with a device and maybe add a Demo or
	 * Trial WiFi plan.
	 * 
	 * @param onbordingRequestData
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
	@ApiOperation(value = "/emergencyMedical", notes = "This API is Service to escalate Emergency Medical event", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "name", value = "Requires name of event.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/emergencyMedical", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSubscriber(
			@ApiParam(name = "updateSubscriberRequestData", value = "Data to Update OnBoard User. ") @RequestBody UpdateSubscriber updateSubscriberRequestData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.updateSubscriber(new Gson().toJson(updateSubscriberRequestData).toString(), request,
				response);
	}

}
