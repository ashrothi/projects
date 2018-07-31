/**
 * This package contains the class use to push the data on IoT hub ussing HTTP.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.IoTPublisherService;
import com.springiot.swagger.response.WebhookUpdateEventSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This controller class is used to push the data directly
 *         on IoT hub using HTTP based api.
 *
 */
@ApiIgnore
@Controller
public class IoTPublisherController {

	/**
	 * To access functionality of IoTPublisherService service class method.
	 */
	@Autowired
	private IoTPublisherService publisherService;

	/**
	 * To push the data directly on IoT hub layer using API.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/iothub/publisher", notes = "To push the data directly on IoT hub layer using API.", response = WebhookUpdateEventSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "data", value = "Requires the data to be push on IoT hub"),

	})

	@RequestMapping(value = "/iothub/publisher", method = RequestMethod.POST)
	public @ResponseBody Message executeApplicationCommand(@RequestParam Map<String, String> map) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = publisherService.Publisher(map);
		/*
		 * Return the response message.
		 */
		return message;

	}
}
