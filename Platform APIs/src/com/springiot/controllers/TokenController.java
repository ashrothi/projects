/** This package is a controller for authentication with the Authorization
 * Engine
 * 
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

import com.springiot.response.Message;
import com.springiot.services.TokenServices;
import com.springiot.swagger.response.OauthTokenSwaggerResponse;
import com.springiot.swagger.response.PasswordForgotCodeSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class is a controller for authentication with the Authorization
 * Engine,which includes API's for get the token and password reset or password
 * update.
 * 
 * @author tanvigarg
 */

@Controller
@Api(value = "/", description = "For authentication from Authorization Engine")
public class TokenController {
	/**
	 * To access functionality of following Class function.
	 */
	@Autowired
	private TokenServices tokenServices;

	/**
	 * To authenticate the user from OAuth Engine.
	 * 
	 * @param map
	 * @return message
	 * @throws Exception
	 */
	@ApiOperation(value = "/oauth/token", notes = "To get token for the authentication purposes", response = OauthTokenSwaggerResponse.class)
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "user_name", defaultValue = "obd") @RequestParam String user_name,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "application_id", defaultValue = "e8c8bfed-3864-11e6-8051-00ff9de4742d") @RequestParam String application_id)
			throws Exception {

		Message message = tokenServices.oauthToken(user_name, password, application_id, req, res);
		return message;
	}

	/**
	 * This Api is used where user forgot the password.
	 * 
	 * @param map,the
	 *            input parameters specified by user.
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "/forgotpassword", notes = "Forgot Password", response = PasswordForgotCodeSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user") })

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody Message forgotPassword(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.forgotPassword(map, request, response);
		return message;
	}

	/**
	 * This Api is used wher user wants to update the password.
	 * 
	 * @param map,the
	 *            input parameters specified by user.
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(value = "/passwordupdate", notes = "Reset Password", response = PasswordForgotCodeSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the user"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "current_password", value = "Requires the current password of user"),
			@ApiImplicitParam(name = "new_password", value = "Requires the new password of user") })

	@RequestMapping(value = "/passwordupdate", method = RequestMethod.POST)
	public @ResponseBody Message passwordUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.passwordUpdate(map, request, response);
		return message;
	}

	/**
	 * This Api is used when user wants to reset the password.
	 * 
	 * @param map,the
	 *            input parameters specified by user.
	 * @return
	 * @throws Exception
	 */

	@ApiOperation(value = "/passwordreset", notes = "Reset Password", response = PasswordForgotCodeSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the user"),
			@ApiImplicitParam(name = "access_code", value = "Requires the reset code which recevied from forgot password API"),
			@ApiImplicitParam(name = "new_password", value = "Requires the new password") })

	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody Message passwordReset(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.passwordReset(map, request, response);
		return message;
	}

	@ApiIgnore
	@ApiOperation(value = "/oauth/token/expire", notes = "Expire OAuth Token")

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", paramType = "query") })
	@RequestMapping(value = "/oauth/token/expire", method = RequestMethod.POST)
	public @ResponseBody Message oauthTokenExpire(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthTokenExpire(map, request, response);

		return message;
	}
}