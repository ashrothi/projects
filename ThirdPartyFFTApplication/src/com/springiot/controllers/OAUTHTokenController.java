/**
 * This package contains the Controller for GMR Application.
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
import com.springiot.swagger.response.ReturnOauthTokenSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	 * @throws Exception
	 */
	@ApiOperation(value = "/oauth/token", notes = "Retrive access token for the authentication purposes", response = OauthTokenSwagger.class)
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "user_name", defaultValue = "gmr_celebi@teramatrix.in") @RequestParam String user_name,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "application_id", defaultValue = "9a959887-5946-11e6-9bb0-fe984cc15272") @RequestParam String application_id)
			throws Exception {

		Message message = tokenServices.oauthToken(user_name, password, application_id);

		return message;
	}

	/**
	 * To Return OAuth Engine Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 * @throws Exception
	 */
	@ApiOperation(value = "/returnoauthtoken", notes = "Return OAuth Token", response = ReturnOauthTokenSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the user") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/returnoauthtoken", method = RequestMethod.POST)
	public @ResponseBody Message returnOauthToken(@ApiIgnore @RequestParam Map<String, String> map) throws Exception {

		Message message = tokenServices.returnOauthToken(map);
		return message;
	}

	/**
	 * To Expire Oauth Engine and Application Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 * @throws Exception
	 */
	@ApiOperation(value = "/oauth/token/expire", notes = "To Expire Oauth Engine and Application Token", response = OauthTokenExpireSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })
	@RequestMapping(value = "/oauth/token/expire", method = RequestMethod.POST)
	public @ResponseBody Message oauthTokenExpire(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthTokenExpire(map, request, response);

		return message;
	}

	/**
	 * When you Forgot Password and want to reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 * @throws Exception
	 */
	@ApiOperation(value = "/forgotpassword", notes = "When you Forgot Password and want to reset Password", response = ForgotPasswordSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_id", value = "Required User Id") })
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody Message forgotPassword(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.forgotPassword(map, request, response);

		return message;
	}

	/**
	 * To Expire Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 * @throws Exception
	 */
	@ApiOperation(value = "/passwordupdate", notes = "To Expire Token", response = PasswordUpdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
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
	 * To Reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 * @throws Exception
	 */
	@ApiOperation(value = "/passwordreset", notes = "To Reset Password", response = PasswordResetSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "access_code", value = "Requires the reset code which recevied from forgot password API"),
			@ApiImplicitParam(name = "newpassword", value = "Requires the new password") })
	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody Message passwordReset(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.passwordReset(map, request, response);

		return message;
	}

	/*
	 * This API is used to retrieve the token for security and authentication
	 * for mobile.
	 */
	@RequestMapping(value = "/oauth/mobile/token", method = RequestMethod.POST)

	public @ResponseBody Message oauthMobileToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "licence_key", defaultValue = "1ttpl92") @RequestParam String user_name,
			@ApiParam(name = "gcm_id", defaultValue = "fYiM_2yKjRA:APA91bHvjiKyk_qowggLamZGiz33tkgxCSz7A7_GomAZN_Bwow2Q0VH3r51eDUdUDPpJyubMhlVWTCxx5FkdhGuCs7KvxJgMrYE2wU30P3UVavZYkDPcTeoA9EustfIFnEOQ41jxsxD0") @RequestParam String gcm_id,
			@ApiParam(name = "imei", defaultValue = "385125865068695") @RequestParam String imei,
			@ApiParam(name = "mac_address", defaultValue = "BO:C5:59:3D:F5:91") @RequestParam String mac_address,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthMobileToken(user_name, gcm_id, imei, mac_address, request, response);
		return message;
	}
}