/**
 * This package contain the controller class for API calling ans publish response for each API. 
 * The swagger document is also initialized in this package which will list down all the API categorized by their controller. 
 */
package com.springiot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.TokenServices;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This controller class maintains the token used for authentication check and
 * validation process.
 *
 */
@Controller
public class TokenController {
	/**
	 * To access functionality of TokenServices service class method.
	 */
	@Autowired
	private TokenServices tokenServices;

	/**
	 * To get randomly generated token for authentication.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	@ApiImplicitParams({
			@ApiImplicitParam(name = "user_name", value = "Requires the name of User", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "Requires the password of User", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "application_id", value = "Requires the unique generated id of application", required = true, paramType = "query", dataType = "String"), })
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String user_name, @RequestParam String password, @RequestParam String application_id,
			@RequestParam(required = false) Integer token_type) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = tokenServices.oauthToken(request, response, user_name, password, application_id, token_type,
				"login");
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To expire token generated.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/oauth/token/expire", notes = "To expire token generated.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/oauth/token/expire", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = tokenServices.oauthTokenExpire(request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}
}
