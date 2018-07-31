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
import com.springiot.swagger.response.*;
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
	 * @param username
	 * @param password
	 * @param applicationid
	 * @return message
	 */
	@ApiOperation(value = "/oauth/token", notes = "To Login", response = OauthTokenSwagger.class)
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "username", defaultValue = "preeti.burad@teramatrix.co") @RequestParam String username,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "applicationid", defaultValue = "9a959887-5946-11e6-9bb0-fe984cc15272") @RequestParam String applicationid) {

		Message message = tokenServices.oauthToken(username, password, applicationid);

		return message;
	}

	/**
	 * To Return OAuth Engine Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/returnoauthtoken", notes = "Return OAuth Token", response = ReturnoauthtokenSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the user") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/returnoauthtoken", method = RequestMethod.POST)
	public @ResponseBody Message returnOauthToken(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = tokenServices.returnOauthToken(map);
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
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })
	@RequestMapping(value = "/oauth/token/expire", method = RequestMethod.POST)
	public @ResponseBody Message oauthTokenExpire(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = tokenServices.oauthTokenExpire(map);

		return message;
	}

	/**
	 * When you Forgot Password and want to reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/forgotpassword", notes = "When you Forgot Password and want to reset Password", response = ForgotpasswordSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_id", value = "Required User Id") })
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody Message forgotPassword(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = tokenServices.forgotPassword(map);

		return message;
	}

	/**
	 * To Expire Token
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/passwordupdate", notes = "To Expire Token", response = PasswordupdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "userKey", value = "Requires the user key"),
			@ApiImplicitParam(name = "current_password", value = "Requires the current password of user"),
			@ApiImplicitParam(name = "new_password", value = "Requires the new password of user") })
	@RequestMapping(value = "/passwordupdate", method = RequestMethod.POST)
	public @ResponseBody Message passwordUpdate(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = tokenServices.passwordUpdate(map);

		return message;
	}

	/**
	 * To Reset Password
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * @return message
	 */
	@ApiOperation(value = "/passwordreset", notes = "To Reset Password", response = PasswordresetSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "access_code", value = "Requires the reset code which recevied from forgot password API"),
			@ApiImplicitParam(name = "newpassword", value = "Requires the new password") })
	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody Message passwordReset(@ApiIgnore @RequestParam Map<String, String> map) {

		Message message = tokenServices.passwordReset(map);

		return message;
	}

}