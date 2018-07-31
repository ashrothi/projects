/**
 * This package contain the class which is used for generic Platform Api's.
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
import com.springiot.services.GenericProcess;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for performance
 * api's.
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
public class PeformanceControllerCUD {
	@Autowired
	private GenericProcess genericProcess;

	

	@ApiOperation(value = "/command/update", notes = "To update the response")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "id", value = "Specific id"),
			@ApiImplicitParam(name = "response", value = "specific response"),
			@ApiImplicitParam(name = "status", value = "specific status"), })
	/**
	 * For command update.
	 * 
	 * @param map
	 * @return message
	 */

	@RequestMapping(value = "/command/update", method = RequestMethod.POST)
	public @ResponseBody Message commandUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("34", map, request, response);
			return message;

	}

	@ApiOperation(value = "/command/insert", notes = "To insert the new command")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "command_name", value = "Specific id"),
			@ApiImplicitParam(name = "command", value = "specific response"), })
	/**
	 * For command update.
	 * 
	 * @param map
	 * @return message
	 */

	@RequestMapping(value = "/command/insert", method = RequestMethod.POST)
	public @ResponseBody Message commandInsert(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCalling("35", map, request, response);
			return message;

	}
}
