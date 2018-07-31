
/**
 * This package contain the class which is used to create manual and dynamic commands template.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springiot.response.Message;
import com.springiot.services.CommandService;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for
 * exceuting/pushing APPI's.
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
public class CommandControllerCUD {

	@Autowired
	private CommandService commandService;

	/**
	 * Execute the command of tr069 and user can pass more parameters than
	 * defined as pr the command requirement.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 *            * @param HttpServletRequest,this is required for the headers
	 *            in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/execute/command/tr069", notes = "Execute the command of tr069 and user can pass more parameters than defined as pr the command requirement.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires device_id"),
			@ApiImplicitParam(name = "command_name", value = "Requies the command name"),
			@ApiImplicitParam(name = "user_key", value = "Specific user has the URL permissions"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user is"),
			@ApiImplicitParam(name = "device_name", value = "Requires the device name"),
			@ApiImplicitParam(name = "data", value = "Requires the data") })

	@RequestMapping(value = "/execute/command/tr069", method = RequestMethod.POST)
	public @ResponseBody Message executeApplicationCommand(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To execute the command, call the method.
		 */
		Message message = commandService.ExecuteApplicationCommands(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}
}
