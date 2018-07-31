/**
 * This package contain the controller class for generic apis.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GatewayService;
import com.springiot.swagger.response.DeviceregisterSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for generic api.
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
public class GenericControllerCUD {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GatewayService gatewayService;

	/**
	 * To register the devices at gateway.
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

	@ApiOperation(value = "/deviceregister", notes = "To register device at gateway", response = DeviceregisterSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user"),
			@ApiImplicitParam(name = "user_key", value = "Requires the key of user"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "gateway_id", value = "Requires the gateway ID"),
			@ApiImplicitParam(name = "protocol", value = "Which protocol is chosen among mqtt,amqp,coap") })

	@RequestMapping(value = "/deviceregister", method = RequestMethod.POST)
	public @ResponseBody Message xfusionUsers(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Call the method to register the device.
		 */
		Message message = gatewayService.deviceRegister(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}
}
