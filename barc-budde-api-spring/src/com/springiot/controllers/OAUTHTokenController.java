/**
 * This package contain the controller class for OAuthEngine ApI's
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
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
import com.springiot.services.OAUTHTokenServices;
import com.springiot.swagger.response.ForgotPasswordSwagger;
import com.springiot.swagger.response.OauthTokenExpireSwagger;
import com.springiot.swagger.response.OauthTokenSwagger;
import com.springiot.swagger.response.PasswordResetSwagger;
import com.springiot.swagger.response.PasswordUpdateSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for audit logs.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class OAUTHTokenController {

	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private OAUTHTokenServices tokenServices;

	/**
	 * To authenticate the user from OAuth Engine.
	 * 
	 * @param user_name
	 * @param password
	 * @param application_id
	 * @return message
	 */
	@ApiOperation(value = "/oauth/token", notes = "Retrive access token for the authentication purposes", response = OauthTokenSwagger.class)
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "user_name", defaultValue = "preeti.burad@teramatrix.co") @RequestParam String user_name,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "application_id", defaultValue = "9a959887-5946-11e6-9bb0-fe984cc15272") @RequestParam String application_id) {

		Message message = tokenServices.oauthToken(user_name, password, application_id, req, res);

		return message;
	}

	/**
	 * To Expire Oauth Engine and Application Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/oauth/token/expire", notes = "To Expire Oauth Engine and Application Token", response = OauthTokenExpireSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })
	@RequestMapping(value = "/oauth/token/expire", method = RequestMethod.POST)
	public @ResponseBody Message oauthTokenExpire(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = tokenServices.oauthTokenExpire(map, request, response);

		return message;
	}

	/**
	 * When you Forgot Password and want to reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/forgotpassword", notes = "When you Forgot Password and want to reset Password", response = ForgotPasswordSwagger.class)

	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_id", value = "Required User Id") })
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody Message forgotPassword(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = tokenServices.forgotPassword(map, request, response);

		return message;
	}

	/**
	 * To Expire Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/passwordupdate", notes = "To Expire Token", response = PasswordUpdateSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "current_password", value = "Requires the current password of user"),
			@ApiImplicitParam(name = "new_password", value = "Requires the new password of user") })
	@RequestMapping(value = "/passwordupdate", method = RequestMethod.POST)
	public @ResponseBody Message passwordUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = tokenServices.passwordUpdate(map, request, response);

		return message;
	}

	/**
	 * To Reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/passwordreset", notes = "To Reset Password", response = PasswordResetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "access_code", value = "Requires the reset code which recevied from forgot password API"),
			@ApiImplicitParam(name = "newpassword", value = "Requires the new password") })
	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody Message passwordReset(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = tokenServices.passwordReset(map, request, response);

		return message;
	}

	/**
	 * To authenticate the user from OAuth Engine.
	 * 
	 * @param user_name
	 * @param password
	 * @param application_id
	 * @return message
	 */
	@ApiOperation(value = "/desktop/oauth/token", notes = "Retrive access token for the authentication purposes", response = OauthTokenSwagger.class)
	@RequestMapping(value = "/desktop/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message desktopOauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "user_name", defaultValue = "preeti.burad@teramatrix.co") @RequestParam String user_name,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "application_id", defaultValue = "9a959887-5946-11e6-9bb0-fe984cc15272") @RequestParam String application_id,
			@ApiParam(name = "mac_address", defaultValue = "10:25:ss:ww") @RequestParam String mac_address,
			@ApiParam(name = "ram", defaultValue = "4GB") @RequestParam String ram,
			@ApiParam(name = "cpu", defaultValue = "i3") @RequestParam String cpu,
			@ApiParam(name = "ip_address", defaultValue = "192.168.1.111") @RequestParam String ip_address,
			@ApiParam(name = "os", defaultValue = "windows/ubuntu") @RequestParam String os) {

		Message message = tokenServices.desktopOauthToken(user_name, password, application_id, mac_address, ram, cpu,
				ip_address, os, req, res);

		return message;
	}

	/**
	 * To Reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/roles/get/all", notes = "To Reset Password", response = PasswordResetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "access_code", value = "Requires the reset code which recevied from forgot password API"),
			@ApiImplicitParam(name = "newpassword", value = "Requires the new password") })
	@RequestMapping(value = "/roles/get/all", method = RequestMethod.POST)
	public @ResponseBody Message rolesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = tokenServices.rolesGetAll(map, request, response);

		return message;
	}

}