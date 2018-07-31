/**
 * This package contain the controller class for session management.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.OperationalService;
import com.springiot.swagger.response.UserSessionCheckSwaggerResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to create apis for session
 * management.
 */
@ApiIgnore
@Controller
@Api(value = "/", description = "Expire the user's session")
public class SessionController {

	@Autowired
	private OperationalService operationalService;

	/**
	 * To check the session of user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/session/check", notes = "To check the session of user", response = UserSessionCheckSwaggerResponse.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "application_key", value = "Requies the application key") })

	@RequestMapping(value = "/user/session/check", method = RequestMethod.POST)
	public @ResponseBody Message userSessionCheck(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */

		Message message = operationalService.userSessionCheck(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To check the session of user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/session/update", notes = "To check the session of user")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "delete_previous_session", value = "Requires int value for delete previous session"),
			@ApiImplicitParam(name = "create_new_session", value = "Requies the int value of create_new_session"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "application_key", value = "Requies the application key") })

	@RequestMapping(value = "/user/session/update", method = RequestMethod.POST)
	public @ResponseBody Message userSessionUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = operationalService.userSessionUpdate(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}
}
