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
			@ApiParam(name = "user_name", defaultValue = "obd") @RequestParam String user_name,
			@ApiParam(name = "password", defaultValue = "Admin@123") @RequestParam String password,
			@ApiParam(name = "application_id", defaultValue = "e8c8bfed-3864-11e6-8051-00ff9de4742d") @RequestParam String application_id)
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
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })
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
	 * This API is used for forgot password.
	 */
	@ApiOperation(value = "/forgotpassword", notes = "When you Forgot Password", response = ForgotpasswordSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_id", value = "Required User Id") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody Message forgotPassword(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.forgotPassword(map, request, response);
		return message;
	}

	/*
	 * This API is used for updation in password.
	 */
	@ApiOperation(value = "/passwordupdate", notes = "To Expire Token", response = PasswordupdateSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "current_password", value = "Requires the current password of user"),
			@ApiImplicitParam(name = "new_password", value = "Requires the new password of user") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/passwordupdate", method = RequestMethod.POST)
	public @ResponseBody Message passwordUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.passwordUpdate(map, request, response);

		return message;
	}

	/*
	 * This specific API is used to reset the password.
	 */
	@ApiOperation(value = "/passwordreset", notes = "To Reset Password", response = PasswordresetSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "access_code", value = "Requires the reset code which recevied from forgot password API"),
			@ApiImplicitParam(name = "newpassword", value = "Requires the new password") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
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

	/**
	 * To Create User
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/create", notes = "To Create User", response = UserCreateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the Email Address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "Requires the password", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_question", value = "Requires the password question", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_answer", value = "Requires the password answer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_approved", value = "Requires Is approved", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name", value = "Requires first_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name", value = "Requires last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country", value = "Requires the country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state", value = "Requires the state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city", value = "Requires the city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number", value = "Requires preferred_number	", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers", value = "Requires phone_numbers", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "Requires address of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "creation_date", value = "Requires creation_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_permanent_address", value = "Requires the is_permanent_address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Requires the image_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "thumbail_image_path", value = "Requires the thumbail_image_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires specific csv attribute ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires specific csv attribute value", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public @ResponseBody Message userCreate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.UserCreate(map, request, response);
		return message;
	}

	/**
	 * To update basic information of user.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/update", notes = "To update basic information of user.", response = UserUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the email", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name", value = "Requires first_name ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name", value = "Requires last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country", value = "Requires country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state", value = "Requires state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city", value = "Requires city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number", value = "Requires preferred_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers", value = "Requires phone_numbers", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "Requires address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_anonymous", value = "Requires is_anonymous", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires is_deleted", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_activity_date", value = "Requires last_activity_date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_permanent_address", value = "Requires is_permanent_address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path", value = "Requires image_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "thumbail_image_path", value = "Requires thumbail_image_path", required = true, access = "query", paramType = "query"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public @ResponseBody Message userUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.UserUpdate(map, request, response);
		return message;
	}

	/**
	 * To delete the user.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/delete", notes = "To delete the user.", response = UserDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "delete_user_id", value = "Requires to delete specific user id", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public @ResponseBody Message userDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.UserDelete(map, request, response);
		return message;
	}

	/**
	 * Returns all the user and their details from all the application in which
	 * given user is present
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/users/get/all", notes = "Returns all the user and their details from all the application in which given user is present", response = UsersGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "applicationid", value = "Requires the application id of user", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/users/get/all", method = RequestMethod.POST)
	public @ResponseBody Message usersGetALL(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.UserGetALL(map, request, response);
		return message;
	}

	/**
	 * To get all roles in the application to which logged in user assigned
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/roles/get/all", notes = "To get all roles in the application to which logged in user assigned ", response = RolesGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/roles/get/all", method = RequestMethod.POST)
	public @ResponseBody Message rolesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.RoleGetAll(map, request, response);
		return message;
	}

	/**
	 * To Get Attribute By role
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/xfusion/attributes/get/by/role", notes = "To Get Attribute By role", response = XfusionAttributesGetByRoleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/xfusion/attributes/get/by/role", method = RequestMethod.POST)
	public @ResponseBody Message xfusionAttributeGetByRole(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = tokenServices.AttributeGetByRole(map, request, response);
		return message;
	}

	/**
	 * if user is present in the specific application,then returns all roles of
	 * that application
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/roles/get/all/user/application", notes = "if user is present in the specific application,then returns all roles of that application", response = RolesGetAllUserApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires application id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "calling_type", value = "Requires calling_type It is Optional when you want modified data pass calling type in parameter with default value otherwise skip this parameter", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/roles/get/all/user/application", method = RequestMethod.POST)
	public @ResponseBody Message rolesGetALLBYUserApplication(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthGetAllUserApplication(map, request, response);
		return message;
	}

	/**
	 * To Get User Attribute
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/xfusion/user/get/attribute", notes = "To Get User Attribute ", response = XfusionUserGetAttributeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_key ", value = "Requires the member_user_key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_id ", value = "Requires the member_user_id ", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/xfusion/user/get/attribute", method = RequestMethod.POST)
	public @ResponseBody Message xfusionUserGetAttribute(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = tokenServices.oauthUserGetAttribute(map, request, response);
		return message;
	}

	/**
	 * To get users update Lock Status..
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/update/lock/status", notes = "To get users update Lock Status.", response = UserUpdateLockStatusSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id", value = "Requires the Edit User id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "lock_status", value = "Requires the Lock Status", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/update/lock/status", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateLockStatus(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthUserUpdateLockStatus(map, request, response);

		return message;
	}

	/**
	 * To get users on basis of application key.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/application/user/remove", notes = "To get users on basis of application key.", response = ApplicationUserRemoveSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id ", value = "Requires the User id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_role_id ", value = "Requires the Role id of particular user", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/application/user/remove", method = RequestMethod.POST)
	public @ResponseBody Message oauthApplicationUserRemove(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthApplicationUserRemove(map, request, response);

		return message;
	}

	/**
	 * To get all the users from all the application(except the given
	 * application in which given user is present
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/users/get/all/except/application", notes = "To get all the users from all the application(except the given application in which given user is present  ", response = UsersGetAllExceptApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/users/get/all/except/application", method = RequestMethod.POST)
	public @ResponseBody Message usersGetAllExceptApplication(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthUserGetAllExceptApplication(map, request, response);
		return message;
	}

	/**
	 * To Update Attribute of User.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/xfusion/user/update/attribute", notes = "To Update Attribute of User.", response = XfusionUserUpdateAttributeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_key", value = "Requires the member_user_key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_id", value = "Requires the member_user_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_id", value = "Requires the attribute_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_value", value = "Requires the attribute_value", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/xfusion/user/update/attribute", method = RequestMethod.POST)
	public @ResponseBody Message xfusionUserUpdateAttribute(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = tokenServices.oauthUserUpdateAttribute(map, request, response);
		return message;
	}

	/**
	 * To get api's by application.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/application/user/add", notes = "To get api's by application.", response = ApplicationUserAddSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id", value = "Requires the edited user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_role_id", value = "Requires the edited role id of particular user", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/application/user/add", method = RequestMethod.POST)
	public @ResponseBody Message applicationUserAdd(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthUserAdd(map, request, response);
		return message;
	}

	/**
	 * To get users on basis of application key.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/inactive", notes = "To get users on basis of application key.", response = UserInactiveSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inactive_user_id ", value = "Requires the Inactive User id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "isactive_status ", value = "Requires the Is Active Status", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/user/inactive", method = RequestMethod.POST)
	public @ResponseBody Message userInactive(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.oauthUserInactive(map, request, response);

		return message;
	}

	/**
	 * To get coutries.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/country/get", notes = "To get coutries.", response = CountryGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/country/get", method = RequestMethod.POST)
	public @ResponseBody Message countryGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.countryGet(map, request, response);

		return message;
	}

	/**
	 * To get state by country id.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/state/get/by/country/id", notes = "To get state by country id.", response = StateGetByCountryIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country_id ", value = "Requires the country id ", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/state/get/by/country/id", method = RequestMethod.POST)
	public @ResponseBody Message stateGetByCountryId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.stateGetByCountryId(map, request, response);

		return message;
	}

	/**
	 * To get city by state id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/city/get/by/state/id", notes = "To get city by state id", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state_id ", value = "Requires the state id ", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/city/get/by/state/id", method = RequestMethod.POST)
	public @ResponseBody Message cityGetBystateId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = tokenServices.cityGetBystateId(map, request, response);

		return message;
	}

	/**
	 * This API will helps to update basic information of user..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/user/update/role/id", notes = "To update basic information of user.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id", value = "Requires the updated user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the email Address of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires specific csv attribute ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires specific csv attribute value", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	@RequestMapping(value = "/user/update/role/id", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateRoleId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = tokenServices.userUpdateRoleId(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

}