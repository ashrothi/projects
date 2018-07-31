/**
 * This package contain the controller class for Third Party Application for Flint
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
import com.springiot.services.OAUTHTokenServices;
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/*
 * This class is a controller class used for the retrieval of OAuth token and expiry of token and forgot,update & reset password.
 */
@Controller
public class OAUTHTokenController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private OAUTHTokenServices tokenServices;

	/*
	 * This API is used to retrieve the token for security and authentication.
	 */
	@ApiOperation(value = "/oauth/token", notes = "To login", response = OauthTokenSwagger.class)
	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "user_name", defaultValue = "flint@teramatrix.in") @RequestParam String user_name,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "application_id", defaultValue = "08d31e35-ac87-11e6-b009-fe984cc15272") @RequestParam String application_id)
			throws Exception {

		Message message = tokenServices.oauthToken(user_name, password, application_id);
		return message;
	}

	/*
	 * This API is used to return the token.
	 */
	@ApiOperation(value = "/returnoauthtoken", notes = "Return OAuth Token", response = ReturnoauthtokenSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the user") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/returnoauthtoken", method = RequestMethod.POST)
	public @ResponseBody Message returnOauthToken(@ApiIgnore @RequestParam Map<String, String> map) throws Exception {

		Message message = tokenServices.returnOauthToken(map);
		return message;
	}

	/*
	 * This API is used to expire the token in some specific time.
	 */
	@ApiOperation(value = "/oauth/token/expire", notes = "To Expire Token", response = OauthTokenExpireSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/oauth/token/expire", method = RequestMethod.POST)
	public @ResponseBody Message oauthTokenExpire(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthTokenExpire(map, request, response);
		return message;
	}



	/*
	 * This API is used to retrieve the token for security and authentication
	 * for mobile.
	 */
	@RequestMapping(value = "/oauth/mobile/token", method = RequestMethod.POST)

	public @ResponseBody Message oauthMobileToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "user_name", defaultValue = "1ttpl92") @RequestParam String user_name,
			@ApiParam(name = "gcm_id", defaultValue = "fYiM_2yKjRA:APA91bHvjiKyk_qowggLamZGiz33tkgxCSz7A7_GomAZN_Bwow2Q0VH3r51eDUdUDPpJyubMhlVWTCxx5FkdhGuCs7KvxJgMrYE2wU30P3UVavZYkDPcTeoA9EustfIFnEOQ41jxsxD0") @RequestParam String gcm_id,
			@ApiParam(name = "imei", defaultValue = "385125865068695") @RequestParam String imei,
			@ApiParam(name = "package_name", defaultValue = "com.androind.flint") @RequestParam String package_name,
			@ApiParam(name = "mac_address", defaultValue = "BO:C5:59:3D:F5:91") @RequestParam String mac_address,
			@ApiParam(name = "bluetooth_address", defaultValue = "B0:c5:59:f5:91:3d") @RequestParam String bluetooth_address,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthMobileToken(user_name, gcm_id, imei, package_name, mac_address,
				bluetooth_address, request, response);
		return message;
	}

	

}