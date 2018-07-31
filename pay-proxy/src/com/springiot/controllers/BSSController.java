package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.services.InterfaceServices;
import com.springiot.swagger.response.OauthTokenSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class BSSController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private InterfaceServices bssServices;
	
	/**
	 * This controller is used for the API call BSS API (/getUserBatchAPI) and send syn response to payProxy(router).
	 * 
	 * @param map : Contains all the body parameters.
	 * @param request : Here pass the object of request type.
	 * @param response : Here pass the object of response type.
	 * @return Message object containing the API response.
	 */
	@ApiOperation(value = "/bss/getUserBatchAPI", notes = "This API calls BSS API (/getUserBatchAPI) and send syn response to payProxy(router).", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authToken", value = "Here pass authToken.", required = true, paramType = "Header"),
		@ApiImplicitParam(name = "MSISDN", value = "Here pass MSISDN.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "planId", value = "Here pass planId.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "Description", value = "Here pass Description.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "InstanceId", value = "Here pass InstanceId.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "amount", value = "Here pass amount.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "returnURL", value = "Here pass returnURL.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "countryCode", value = "Here pass countryCode.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "PaymentToken", value = "Here pass PaymentToken.", required = false, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "userIdentifierArray", value = "Here array of user identifier.", required = true, access = "query", paramType = "query", dataType = "String")
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/bss/getUserBatchAPI", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> payProxyGetUserBatchAPI(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> message = bssServices.genericCalling(map, "104", request, response);
		return message;
	}
	
	/**
	 * This controller is used for the API to Store Payment Agreement Details into 
	 * BSS and call BSS API (/ppAddOrder/userPurchaseExternalExtraPassBatchAPI) 
	 * and send syn response to payProxy(router).
	 * 
	 * @param map : Contains all the body parameters.
	 * @param request : Here pass the object of request type.
	 * @param response : Here pass the object of response type.
	 * @return Message object containing the API response.
	 */
	@ApiOperation(value = "/bss/update", notes = "This API stores Payment Agreement Details and call BSS API (/ppAddOrder/userPurchaseExternalExtraPassBatchAPI).", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authToken", value = "Here pass authToken.", required = true, paramType = "Header"),
			@ApiImplicitParam(name = "billPayTokenId", value = "Here pass billPayTokenId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "BAN", value = "Here pass BAN.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ICCID", value = "Here pass ICCID.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "PlanId", value = "Here pass PlanId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "InstanceId", value = "Here pass InstanceId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "countryCode", value = "Here pass countryCode.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userIdentifier", value = "Here pass user identifier.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "externalTransactionId", value = "Here pass external transaction id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "externalExtraPassId", value = "Here pass external extra pass id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "activatePurchase", value = "Here pass activate purchanse.", required = true, access = "query", paramType = "query", dataType = "String")
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/bss/update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> payProxyUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> message = bssServices.genericCalling(map, "108", request, response);
		return message;
	}
}
