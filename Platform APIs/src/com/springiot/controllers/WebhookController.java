/**
 * This package contains the class which is used as a controller to create apis for webhooks.
 */
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

import com.springiot.controllers.ignoreControllers.WebhookControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Api(value = "/", description = "Create and configure webooks for alerts")
public class WebhookController extends WebhookControllerCUD {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * Retrieve the events specific to webhooks
	 * 
	 * @param map,
	 *            Contains all the input parameters specified by user.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/webhook/get/events", notes = "Retrieve the events specific to webhooks", response = WebhookGetEventsSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requires the global rule ID"), })
	@RequestMapping(value = "/webhook/get/events", method = RequestMethod.POST)
	public @ResponseBody Message webhookGetEvents(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("425", map, request, response);

			// Return the response message.
			return message;

	}

	/**
	 * Retrieve the payload destinations can be datastore or be url
	 * 
	 * @param map,
	 *            Contains all the input parameters specified by user.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/webhook/get/payload/destination", notes = "Retrieve the payload destinations", response = WebhookGetPayloadDestinationSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID"), })
	@RequestMapping(value = "/webhook/get/payload/destination", method = RequestMethod.POST)
	public @ResponseBody Message webhookGetPayloadDestination(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("426", map, request, response);

			// Return the response message.
			return message;

	}

	/**
	 * Retrieve connection schema of payload destination
	 * 
	 * @param map,
	 *            Contains all the input parameters specified by user.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/webhook/get/payload/destination/schema", notes = "Retrieve the payload destinations", response = WebhookGetPayloadDestinationSchemaSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "payload_destination_id", value = "Requires the user ID"), })
	@RequestMapping(value = "/webhook/get/payload/destination/schema", method = RequestMethod.POST)
	public @ResponseBody Message webhookGetPayloadDestinationSchema(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("427", map, request, response);

			// Return the response message.
			return message;

	}

	@RequestMapping(value = "/webhook/test", method = RequestMethod.POST)
	public @ResponseBody String webhookTest(String token, String service_alias, String device_id,
			String data_source_alias, String device_alias, String sys_timestamp, String current_value)
			throws Exception {

		return "Response returns successfully";

	}

}
