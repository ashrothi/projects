
/**
 * This package contain the class which is used to create manual and dynamic commands template.
 */
package com.springiot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.controllers.ignoreControllers.CommandControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         manual and dynamic commands template and push them on IoT Hub.
 * 
 */

@Controller
@Api(value = "/", description = "API's for retreiving the command status of device")
public class CommandController extends CommandControllerCUD {
	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;


	/**
	 * To Retrieve the command status of device",
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
	@ApiOperation(value = "Retrieve the command status of device", notes = "Retrieve the command status of device")
	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/performance/commandstatus/devices/get/all", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetAllVendor(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCallingMetaData("412", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}