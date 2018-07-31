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
public class BillPayController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private InterfaceServices billPayServices;
	
	/**
	 * This controller is used for the API which will check status in every 2 second from DB..
	 * 
	 * @param req
	 *            : Here pass the object of request type.
	 * @param res
	 *            : Here pass the object of response type.
	 * @param group_id
	 *            : Here pass the API group id for which user wants information.
	 * @return Message object containing the API response.
	 */
	@ApiOperation(value = "/billpay/gimmi/setup/registration", notes = "This API stores Payment Agreement Details and call BSS API (/ppAddOrder/userPurchaseExternalExtraPassBatchAPI).", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authToken", value = "Here pass authToken.", required = true, paramType = "Header"),
			@ApiImplicitParam(name = "interfaceId", value = "Here pass interfaceId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "securityEntity", value = "Here pass securityEntity.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "securityEntityValue", value = "Here pass securityEntityValue.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "action", value = "Here pass action.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "actionReference", value = "Here pass actionReference.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consumerReturnUrl", value = "Here pass consumerReturnUrl.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transactionDescription", value = "Here pass transactionDescription.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "accountNumber", value = "Here pass accountNumber.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "amount", value = "Here pass amount.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "domain", value = "Here pass domain.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "countryCode", value = "Here pass countryCode.", required = true, access = "query", paramType = "query", dataType = "String")
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/billpay/gimmi/setup/registration", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> billPayGimmiSetupRegistration(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> message = billPayServices.genericCalling(map, "105", request, response);
		return message;
	}
	
	/**
	 * This controller is used for the API which will check status in every 2 second from DB..
	 * 
	 * @param req
	 *            : Here pass the object of request type.
	 * @param res
	 *            : Here pass the object of response type.
	 * @param group_id
	 *            : Here pass the API group id for which user wants information.
	 * @return Message object containing the API response.
	 */
	@ApiOperation(value = "/billpay/gimmi/enquiry", notes = "This API stores Payment Agreement Details and call BSS API (/ppAddOrder/userPurchaseExternalExtraPassBatchAPI).", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authToken", value = "Here pass authToken.", required = true, paramType = "Header"),
			@ApiImplicitParam(name = "interfaceId", value = "Here pass interfaceId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "securityEntity", value = "Here pass securityEntity.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "securityEntityValue", value = "Here pass securityEntityValue.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "action", value = "Here pass action.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "billPayTokenId", value = "Here pass billPayTokenId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "countryCode", value = "Here pass countryCode.", required = true, access = "query", paramType = "query", dataType = "String")
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/billpay/gimmi/enquiry", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> billPayGimmiEnquiry(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> message = billPayServices.genericCalling(map, "106", request, response);
		return message;
	}
	
	/**
	 * This controller is used for the API which will check status in every 2 second from DB..
	 * 
	 * @param req
	 *            : Here pass the object of request type.
	 * @param res
	 *            : Here pass the object of response type.
	 * @param group_id
	 *            : Here pass the API group id for which user wants information.
	 * @return Message object containing the API response.
	 */
	@ApiOperation(value = "/billpay/payment/operation", notes = "This API stores Payment Agreement Details and call BSS API (/ppAddOrder/userPurchaseExternalExtraPassBatchAPI).", response = OauthTokenSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authToken", value = "Here pass authToken.", required = true, paramType = "Header"),
			@ApiImplicitParam(name = "interfaceId", value = "Here pass interfaceId.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "amount", value = "Here pass amount.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "accountNumber", value = "Here pass accountNumber.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "secondaryNumber", value = "Here pass secondaryNumber.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "paymentType", value = "Here pass paymentType.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "finInstrumentReferenceType", value = "Here pass finInstrumentReferenceType.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "finInstrumentReference", value = "Here pass finInstrumentReference.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "countryCode", value = "Here pass countryCode.", required = true, access = "query", paramType = "query", dataType = "String")
	})
	// Parameters for calling this method is map,request and response
	@RequestMapping(value = "/billpay/payment/operation", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> billPayPaymentOperation(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> message = billPayServices.genericCalling(map, "107", request, response);
		return message;
	}
	
}
