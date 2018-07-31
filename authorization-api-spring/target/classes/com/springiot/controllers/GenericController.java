/**
 * This package contain the controller class for API calling and publish response for each API. 
 * The swagger document is also initialized in this package which will list down all the API categorized by their controller. 
 */
package com.springiot.controllers;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.constant.ProcessParameter;
import com.springiot.controllers.ignoreControllers.GenericControllerCUD;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import com.springiot.swagger.response.*;

/**
 * This controller class contains the generic useful API which are useful for
 * authenticate user, provide application details, create and manage user's
 * roles, all password related functionalities etc.
 *
 */

@Controller
@Api(value = "/", description = "Registeration and Operations of other plateform and managing them")
public class GenericController extends GenericControllerCUD {

	/**
	 * To access functionality of GenericProcess service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To access functionality of roleService service class method.
	 */
	@Autowired
	private RoleService roleService;

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * This API will provide all the API URLs whose access is allowed for
	 * particular user.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/apiaccess", notes = "Get all the api's on which user have access ", response = XfusionUsersGetApiAccessSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/apiaccess", method = RequestMethod.POST)
	public @ResponseBody Message usersGetApiAccess(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("1", Map, request, response);
		// return the response
		return message;
		// }
	}

	/**
	 * This API will get all the view(s on which user have access.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/viewaccess", notes = "Get all the view(s on which user have access", response = XfusionUsersGetViewAccessSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/viewaccess", method = RequestMethod.POST)
	public @ResponseBody Message usersGetViewAccess(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("2", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will get the Api access right user having.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/user/get/apiaccess", notes = "To get the Api access right user having", response = XfusionUsersGetApiAccessSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/get/apiaccess", method = RequestMethod.POST)
	public @ResponseBody Message userGetApiAccess(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("8", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will get the access right user having.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/user/get/viewaccess", notes = "To get the access right user having", response = XfusionUsersGetViewAccessSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/get/viewaccess", method = RequestMethod.POST)
	public @ResponseBody Message userGetViewAccess(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("9", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will validate user's access_key with the URL.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/validate/accesskey/url", notes = "This validate user's access_key with the URL", response = XfusionValidateAccesskeyUrlSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "access_key", value = "Requires the access_key of URL", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "url", value = "Requires specific url", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires the application key", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/validate/accesskey/url", method = RequestMethod.POST)
	public @ResponseBody Message validateAccessKeyURL(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("16", Map, request, response);

		// return the response
		return message;

	}

	/**
	 * This API will get the Session Details.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/sessionmanager", notes = "To get the Session Details")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "session_id", value = "Requires the session id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "applicaton_key", value = "Requires the application key of specific user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/sessionmanager", method = RequestMethod.POST)
	public @ResponseBody Message sessionManager(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("10", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will get all roles in the application to which logged in user
	 * assigned.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/roles/get/all", notes = "To get all roles in the application to which logged in user assigned ", response = XfusionRolesGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/roles/get/all", method = RequestMethod.POST)
	public @ResponseBody Message rolesGetAll(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("11", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will get all the user list with their details for a given
	 * application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/application", notes = "To get all the user list with their details for a given application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "applicationid", value = "Requires application id of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/application", method = RequestMethod.POST)
	public @ResponseBody Object usersGetApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {
		//
		// // To call the procedure required for data processing.

		Object message = genericProcess.GenericProcedureCalling("12", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will get all the user list with their details for a given
	 * organization.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/organization", notes = "To get all the user list with their details for a given organization")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "organizationid", value = "Requires organization id of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/organization", method = RequestMethod.POST)
	public @ResponseBody Message usersGetOrganization(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {
		//
		// // To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("13", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will get all the user list with their details for a given role.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/role", notes = "To get all the user list with their details for a given role")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "roleid", value = "Requires role id of user ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/role", method = RequestMethod.POST)
	public @ResponseBody Message usersGetRole(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("14", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all applications of the particular user.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/application/get/all", notes = "Retrieve all applications of the particular user.", response = XfusionApplicationGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/application/get/all", method = RequestMethod.POST)
	public @ResponseBody Object applicationGetAll(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Object object = genericProcess.GenericProcedureCalling("19", Map, request, response);

		// return the response
		return object;
		// }
	}

	/**
	 * This API will helps to returns all roles of that application, if user is
	 * present in the specific application .
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/roles/get/all/user/application", notes = "If user is present in the specific application,then returns all roles of that application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires application id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "calling_type", value = "Requires calling_type It is Optional when you want modified data pass calling type in parameter with default value otherwise skip this parameter", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/roles/get/all/user/application", method = RequestMethod.POST)
	public @ResponseBody Object rolesGetALLBYUserApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {
		if (Map.containsKey("calling_type")) {

			Map.remove("calling_type");
			/*
			 * To call the procedure required for data processing.
			 */
			Object message = roleService.rolesGetAllUserApplication("21", Map, request, response);
			/*
			 * Return the response message.
			 */
			return message;
		} else {
			/*
			 * To call the procedure required for data processing.
			 */
			Object message = genericProcess.GenericProcedureCalling("21", Map, request, response);
			/*
			 * Return the response message.
			 */
			return message;
		}
		// }
	}

	/**
	 * This API will helps to return all the user and their details from all the
	 * application in which given user is present.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/all", notes = "Returns all the user and their details from all the application in which given user is present", response = XfusionUsersGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/all", method = RequestMethod.POST)
	public @ResponseBody Message usersGetALL(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("29", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all api's of the application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/api/get/by/application", notes = "retrieve all api's of the application", response = XfusionApiGetByApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the applicatiopn id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/api/get/by/application", method = RequestMethod.POST)
	public @ResponseBody Message XfusionApiGetByApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("31", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get all api(s by role.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/permission/api/get/all", notes = "To get all api(s by role", response = XfusionPermissionApiGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of particular user.", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/permission/api/get/all", method = RequestMethod.POST)
	public @ResponseBody Message permissionAPIGetAll(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("33", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get all view's by role.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/permission/view/get/all", notes = "To get all view's by role", response = XfusionPermissionViewGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/permission/view/get/all", method = RequestMethod.POST)
	public @ResponseBody Message permissionViewGetAll(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("34", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all view(s of the application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/view/get/by/application", notes = "Retrieve all view(s of the application", response = XfusionViewGetByApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/get/by/application", method = RequestMethod.POST)
	public @ResponseBody Message ViewGetByApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("37", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all api's of the application used or
	 * unused.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/api/get/all/by/application", notes = "Retrive all api's of the application used or unused", response = XfusionApiGetAllByApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/api/get/all/by/application", method = RequestMethod.POST)
	public @ResponseBody Message apiGetAllByApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {
		//
		// // To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("38", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all view(s of the application used or
	 * unused.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/view/get/all/by/application", notes = "Retrive all view(s of the application used or unused", response = XfusionViewGetAllByApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/get/all/by/application", method = RequestMethod.POST)
	public @ResponseBody Message viewGetAllByApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("41", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get all the views for the application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/permission/view/get/all/application", notes = "To get all the views for the application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/permission/view/get/all/application", method = RequestMethod.POST)
	public @ResponseBody Message permissionViewGetAllApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("46", Map, request, response);
		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get get all the apis for the application.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/permission/api/get/all/application", notes = "To get all the apis for the application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/permission/api/get/all/application", method = RequestMethod.POST)
	public @ResponseBody Message permissionAPIGetAllApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("47", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get all the users from all the application(except
	 * the given application in which given user is present).
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/all/except/application", notes = "To get all the users from all the application(except the given application in which given user is present", response = XfusionUsersGetAllExceptApplicationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/all/except/application", method = RequestMethod.POST)
	public @ResponseBody Message usersGetAllExceptApplication(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("48", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/by/application/key", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/by/application/key", method = RequestMethod.POST)
	public @ResponseBody Message UsersGetByApplicationKey(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {
		//
		// // To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("55", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/country/get", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)

	@RequestMapping(value = "/country/get", method = RequestMethod.POST)
	public @ResponseBody Message countryGet(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("62", Map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/state/get/by/country/id", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "country_id ", value = "Requires the country id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/state/get/by/country/id", method = RequestMethod.POST)
	public @ResponseBody Message stateGetByCountryId(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("63", Map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/city/get/by/state/id", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "state_id ", value = "Requires the state id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/city/get/by/state/id", method = RequestMethod.POST)
	public @ResponseBody Message cityGetBystateId(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("64", Map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/user/details/get/by/user/id", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/details/get/by/user/id", method = RequestMethod.POST)
	public @ResponseBody Message userDetailsGetByUserId(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("66", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get type of data.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/datatype/get/datatype", notes = "To get type of data.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/datatype/get/datatype", method = RequestMethod.POST)
	public @ResponseBody Message dataTypeGetDatatype(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("67", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get Attribute By role.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/xfusion/attributes/get/by/role", notes = "To Get Attribute By role", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/attributes/get/by/role", method = RequestMethod.POST)
	public @ResponseBody Message xfusionAttributeGetByRole(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("72", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update Attribute of User.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/xfusion/user/update/attribute", notes = "To Update Attribute of User.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_key", value = "Requires the member_user_key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_id", value = "Requires the member_user_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_id", value = "Requires the attribute_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_value", value = "Requires the attribute_value", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/user/update/attribute", method = RequestMethod.POST)
	public @ResponseBody Message xfusionUserUpdateAttribute(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("73", Map, request, response);

		// return the response
		return message;
		// /}
	}

	/**
	 * This API will helps to get User Attribute.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/xfusion/user/get/attribute", notes = "To Get User Attribute ", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_key ", value = "Requires the member_user_key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "member_user_id ", value = "Requires the member_user_id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/user/get/attribute", method = RequestMethod.POST)
	public @ResponseBody Message xfusionUserGetAttribute(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("74", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get User Attribute.
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/xfusion/applications/get/by/id", notes = "To get the applications based on user id ", response = XfusionApplicationsGetByIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/xfusion/applications/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message xfusionApplicationsGetById(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("76", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all the errors
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/xfusion/exception/log/get/all", notes = "To get the error logs on the exception basis ", response = XfusionExceptionLogGetAllSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Requires the from date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Requires the end date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit ", value = "Requires the limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset ", value = "Requires the offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition for server side filtering", required = true, access = "query", paramType = "query")

	})

	@RequestMapping(value = "/xfusion/exception/log/get/all", method = RequestMethod.POST)
	public @ResponseBody Message xfusioneExceptionLogGetAll(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("77", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve count of errors..
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/xfusion/exception/log/count", notes = "To get the errors count", response = XfusionExceptionLogCountSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Requires the from date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Requires the end date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition", value = "Requires the condition for Server Side Filtering", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/exception/log/count", method = RequestMethod.POST)
	public @ResponseBody Message xfusioneExceptionLogCount(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("80", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve number of logged in users
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/logged/in", notes = "To get the errors count", response = ValidateTokenSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/logged/in", method = RequestMethod.POST)
	public @ResponseBody Message usersLoggedIn(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("83", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to configure the authorization session
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/auth/session/configure", notes = "To configure the authorization session", response = AuthSessionConfigureSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_list ", value = "Requires the list of users", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_password_expire ", value = "Requires the bit to expire the password or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_expire_time ", value = "Requires the expiry time of password", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_session_enable ", value = "Requires the bit to enable session or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_single_sign_on_enable ", value = "Requires the bit to enable single sign on or not", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "session_expire_time ", value = "Requires the expiry time of session", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/auth/session/configure", method = RequestMethod.POST)
	public @ResponseBody Message authSessionConfigure(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("87", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to configure the authorization session
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/auth/session/delete/settings", notes = "To configure the authorization session", response = AuthSessionConfigureSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_list ", value = "Requires the list of users", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/auth/session/delete/settings", method = RequestMethod.POST)
	public @ResponseBody Message authSessionDeleteSettings(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("88", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * To check the session of user where session is enabled or disabled.
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
			@ApiImplicitParam(name = "application_key", value = "Requies the application key"),
			@ApiImplicitParam(name = "access_key", value = "Specific user has the URL permissions") })

	@RequestMapping(value = "/user/session/check", method = RequestMethod.POST)
	public @ResponseBody Message userSessionCheck(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//
		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		// /*
		// * Check if it is valid or not.
		// */
		// if (!urlValidateMessage.isValid()) {
		// return urlValidateMessage;
		// } else {

		Object object = genericService.executeProcesure(null, processParameter.getMaps().get("85").toString(),
				request.getHeader("user_key"), request.getHeader("user_id"), map.get("application_key"),
				request.getHeader("token"));

		Message message = new Message();
		message.setDescription("Process Success");
		message.setObject(object);
		message.setValid(true);
		/*
		 * Return the response message.
		 */
		return message;
		// }
	}

	/**
	 * To update the session of users.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiOperation(value = "/auth/session/update", notes = "To update the session of users", response = UserSessionCheckSwaggerResponse.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "delete_previous_session", value = "Requires the deleted previous session"),
			@ApiImplicitParam(name = "create_new_session", value = "Requires the current session"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "application_key", value = "Requies the application key"),
			@ApiImplicitParam(name = "last_activity_date", value = "Requies the last activity date"),
			@ApiImplicitParam(name = "last_password_change_date", value = "Requies the last password change date") })

	@RequestMapping(value = "/auth/session/update", method = RequestMethod.POST)
	public @ResponseBody Message authSessionUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // * Check if it is valid or not.
		//
		// if (!urlValidateMessage.isValid()) {
		// return urlValidateMessage;
		// } else {

		Object object = genericService.executeProcesure(null, processParameter.getMaps().get("86").toString(),
				map.get("delete_previous_session"), map.get("create_new_session"), request.getHeader("user_key"),
				request.getHeader("user_id"), map.get("application_key"), request.getHeader("token"));

		Message message = new Message();

		List<Map<String, Object>> responseFromProcedure = (List<Map<String, Object>>) object;

		if (responseFromProcedure.get(0).get("token") != null) {
			String tokenList = responseFromProcedure.get(0).get("token").toString();

			String arrayToken[] = tokenList.split(",");

			for (int i = 0; i < arrayToken.length; i++) {

				String query = "delete from TokenStorage.auth_token where access_token='" + arrayToken[i] + "';";

				Object getToken = genericService.executeHSqlQuery(query);

			}
		}

		message.setDescription("Process Success");
		message.setObject(object);
		message.setValid(true);
		return message;
		// }
	}

	/**
	 * This API will helps to get users on the basis of application key
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/users/get/all/by/application/key", notes = "To get users on the basis of application key", response = UsersGetAllByApplicationKeySwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/get/all/by/application/key", method = RequestMethod.POST)
	public @ResponseBody Message usersGetAllByApplicationKey(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("89", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get roles on the basis of user key and application
	 * id
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/roles/get/all/by/user/application/id", notes = "To get users on the basis of application id", response = RolesGetAllByUserApplicationIdSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application id", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/roles/get/all/by/user/application/id", method = RequestMethod.POST)
	public @ResponseBody Message rolesGetAllUserApplicationId(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("90", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get roles on the basis of user key and application
	 * key
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/roles/get/all/by/user/application/key", notes = "To get users on the basis of application key", response = RolesGetAllByUserApplicationIdSwagger.class)

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/roles/get/all/by/user/application/key", method = RequestMethod.POST)
	public @ResponseBody Message rolesGetAllByUserApplicationKey(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("91", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to inherit role permissions key
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/role/inherit/permissions", notes = "To inherit role permissions", response = RolesGetAllByUserApplicationIdSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role", value = "Requires the role", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "assign_to_role ", value = "Requires the assign to role parameter", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/role/inherit/permissions", method = RequestMethod.POST)
	public @ResponseBody Message roleInheritPermissions(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("92", Map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to inherit role permissions key
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/api/get/all/permissions", notes = "To inherit role permissions", response = RolesGetAllByUserApplicationIdSwagger.class)

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/api/get/all/permissions", method = RequestMethod.POST)
	public @ResponseBody Message apiGetAllPermissions(@ApiIgnore @RequestParam Map<String, String> Map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("94", Map, request, response);

		// return the response
		return message;
	}
}
