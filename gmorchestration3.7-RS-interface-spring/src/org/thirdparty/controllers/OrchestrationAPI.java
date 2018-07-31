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

import org.apache.log4j.Logger;
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
import org.thirdparty.request.model.swapHardware;
import org.thirdparty.services.ThirdPartyService;
import org.thirdparty.swagger.response.ApiResponseSwagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	Logger logger = Logger.getLogger(OrchestrationAPI.class);

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

	@ApiOperation(value = "/devices/{deviceId}/simProfiles", notes = "This API is to change SIM Profile on a device.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "deviceId", value = "Requires SIM Number of the Device that will be using the services.", required = true, access = "path", paramType = "path", dataType = "String") })
	@RequestMapping(value = "/devices/{deviceId}/simProfiles", method = RequestMethod.POST)
	public ResponseEntity<?> deviceRegister(@PathVariable String deviceId,
			@ApiParam(name = "simProfileData", value = "Request Body of sim Profile Data."
					+ "countryCode:2-character ISO code of target country.(Mandatory Parameter)"
					+ "targetProfile:Indicates which profile to download to the SIM based on target country..(Mandatory Parameter)( shoulb be either of one.“bootstrap”, “local”)  ") @RequestBody SimProfile simProfileData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String usersJson = gson.toJson(simProfileData);
		return thirdPartyService.simProfiles(usersJson.replaceAll("null", "\"\""), deviceId, request, response);

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
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String usersJson = gson.toJson(deviceSettingData);
		return thirdPartyService.deviceSettings(usersJson.replaceAll("null", "\"\""), deviceId, request, response);
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
	@ApiOperation(value = "/subscribers", notes = "Service to Onboard a new subscriber with a device and maybe add a Demo or Trial WiFi plan.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/subscribers", method = RequestMethod.POST)
	public ResponseEntity<?> onBoarding(
			@ApiParam(name = "onbordingRequestData", value = "Data to OnBoard User. ") @RequestBody OnBoarding onbordingRequestData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String usersJson = gson.toJson(onbordingRequestData);

		return thirdPartyService.onBoarding(usersJson.replaceAll("null", "\"\""), request, response);

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
	@ApiOperation(value = "/subscribers/{ban}", notes = "Service to Update a specific Subscriber", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ban", value = "Requires billing account number created for the subscriber/device.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/subscribers/{ban}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSubscriber(@PathVariable String ban,
			@ApiParam(name = "updateSubscriberRequestData", value = "Data to Update OnBoard User. ") @RequestBody UpdateSubscriber updateSubscriberRequestData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String usersJson = gson.toJson(updateSubscriberRequestData);
		return thirdPartyService.updateSubscriber(usersJson.replaceAll("null", "\"\""), ban, request, response);

	}

	/**
	 * This API is to offboard a specific Subscriber
	 * 
	 * @param offBoardingData
	 * @param ban
	 *            billing account number created for the subscriber/device
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
	@ApiOperation(value = "/subscribers/{ban}/devices/{deviceId}", notes = "This API is to offboard a specific Subscriber", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ban", value = "Requires billing account number created for the subscriber/device.", required = true, access = "path", paramType = "path", dataType = "String"),
			@ApiImplicitParam(name = "deviceId", value = "Requires SIM Number of the Device that will be using the services", required = true, access = "path", paramType = "path", dataType = "String"), })

	@RequestMapping(value = { "/subscribers/{ban}/devices/{deviceId}",
			"/subscribers/{ban}/devices" }, headers = "Accept=*", method = RequestMethod.DELETE)
	public ResponseEntity<?> offBoarding(@PathVariable String ban, @PathVariable() Optional<String> deviceId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.offBoarding(deviceId, ban, request, response);
	}

	/**
	 * This API is used to get order details on a specific account including data
	 * usage.IncludeCanceled = true; returns details of all Active, Queued,
	 * Canceled, and Expired orders.IncludePending = true; returns details of any
	 * pending orders.Data usage details of the active order will always be returned
	 * if there is an active order
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
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
	@ApiOperation(value = "/subscribers/{ban}/orders", notes = "This API is used  to get order details on a specific account including data usage.IncludeCanceled = true; returns details of all Active, Queued, Canceled, and Expired orders.IncludePending = true; returns details of any pending orders.Data usage details of the active order will always be returned if there is an active order", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ban", value = "Requires billing account number created for the subscriber/device.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/subscribers/{ban}/orders", method = RequestMethod.GET)
	public ResponseEntity<?> getSubscriptionDetail(@PathVariable String ban, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return thirdPartyService.getSubscriptionDetail(ban, request, response);

	}

	/**
	 * This API is used to get all offers applicable for a Country. This service
	 * returns the full product catalog.
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
	@ApiOperation(value = "/offers", notes = "This API is used to get all offers applicable for a Country. This service returns the full product catalog.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public ResponseEntity<?> getOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.getOffer(request, response);

	}

	/**
	 * Add Order on a specific account. Service can also be used on an existing
	 * account where carrier terms were never accepted before. As such, all
	 * subscriber details will be provided as done on Onboard API.
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param addOrder
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
	@ApiOperation(value = "/subscribers/{ban}/orders", notes = "Add Order on a specific account. Service can also be used on an existing account where carrier terms were never accepted before. As such, all subscriber details will be provided as done on Onboard API.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ban", value = "Requires billing account number created for the subscriber/device.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/subscribers/{ban}/orders", method = RequestMethod.POST)
	public ResponseEntity<?> addOrder(@PathVariable String ban,
			@ApiParam(name = "addOrder", value = "Data to Add Order ") @RequestBody AddOrder addOrder,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String usersJson = gson.toJson(addOrder);
		return thirdPartyService.addOrder(ban, usersJson.replaceAll("null", "\"\""), request, response);

	}

	/**
	 * Cancel a specific order on a specific account. Carrier to lookup order
	 * details to get payment gateway details like transactionReference in order to
	 * apply any refund necessary to appropriate card
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param orderId
	 *            Order ID which has to be canceled
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
	@ApiOperation(value = "/subscribers/{ban}/orders/{orderId}", notes = "Cancel a specific order on a specific account. Carrier to lookup order details to get payment gateway details like transactionReference in order to apply any refund necessary to appropriate card", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ban", value = "Requires billing account number created for the subscriber/device.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "orderId", value = "Requires unique order id which has to be cancelled.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/subscribers/{ban}/orders/{orderId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> cancelOrder(@PathVariable String ban, @PathVariable String orderId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.cancelOrder(ban, orderId, request, response);

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
	@ApiOperation(value = "/push/notification", notes = "To Push the coming Data from ESIM Notification API to kafka queue", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/push/notification", method = RequestMethod.POST)
	public ResponseEntity<?> pushNotification(@RequestParam Object data, @RequestParam String kafka_type,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.pushNotification(data, kafka_type, request, response);

	}

	/**
	 * Api To call GConnect Group
	 * 
	 * @param data
	 *            GConnect Group data
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/push/gc/api", notes = "Api To call GConnect Group", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/push/gc/api", method = RequestMethod.POST)
	public ResponseEntity<?> gcProfileSwitch(@RequestParam String data, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return thirdPartyService.gcProfileSwitch(data, request, response);

	}

	/**
	 * To Call Onboarding Group from Esim Notification
	 * 
	 * @param data
	 *            Onboarding Data
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/onboarding", notes = "To Call Onboarding Group from Esim Notification.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/onboarding", method = RequestMethod.POST)
	public ResponseEntity<?> onboardingFromEsimNotification(@RequestBody String data, HttpServletRequest request,
			HttpServletResponse response) {

		return thirdPartyService.onboardingFromEsimNotification(data, request, response);

	}

	/**
	 * Service to swap/replace devices on a specific Subscriber account
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
	@ApiOperation(value = "/subscribers/{ban}/devices", notes = "Service to swap/replace devices on a specific Subscriber account", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "returnUrl", value = "URL to send async response. ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ban", value = "Requires billing account number created for the subscriber/device.", required = true, access = "path", paramType = "path", dataType = "String") })

	@RequestMapping(value = "/subscribers/{ban}/devices", method = RequestMethod.POST)
	public ResponseEntity<?> swapOnstarHardware(@PathVariable String ban,
			@ApiParam(name = "swapOnstarHardwareRequestData", value = "Data to swap Onstar Hardware. ") @RequestBody swapHardware swapOnstarHardwareRequestData,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String usersJson = gson.toJson(swapOnstarHardwareRequestData);
		return thirdPartyService.swapOnstarHardware(usersJson.replaceAll("null", "\"\""), ban, request, response);

	}

	/**
	 * To Call Onboarding Group from Esim Notification
	 * 
	 * @param data
	 *            Onboarding Data
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/swapOnstarHardwareRequestData", notes = "To Call Onboarding Group from Esim Notification.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/swapOnstarHardwareRequestData", method = RequestMethod.POST)
	public ResponseEntity<?> swapOnstarHardwareRequestDataFromEsimNotification(@RequestParam String data,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return thirdPartyService.swapHardwareRequestDataFromEsimNotification(data, request, response);

	}

}
