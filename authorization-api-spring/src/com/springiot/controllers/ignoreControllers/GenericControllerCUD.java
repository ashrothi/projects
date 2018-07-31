package com.springiot.controllers.ignoreControllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
import com.springiot.services.ForGotPasswordServices;
import com.springiot.services.GenericProcess;
import com.springiot.services.RegisterationService;
import com.springiot.swagger.response.UserCreationSignupSwagger;
import com.springiot.swagger.response.UserVerificationSwagger;
import com.springiot.swagger.response.XfusionApiDeleteSwagger;
import com.springiot.swagger.response.XfusionApiUpdateMultipleSwagger;
import com.springiot.swagger.response.XfusionApiUpdateSwagger;
import com.springiot.swagger.response.XfusionApplicationDeleteSwagger;
import com.springiot.swagger.response.XfusionApplicationUpdateSwagger;
import com.springiot.swagger.response.XfusionApplicationUserAddSwagger;
import com.springiot.swagger.response.XfusionPasswordResetSwagger;
import com.springiot.swagger.response.XfusionPasswordUpdateSwagger;
import com.springiot.swagger.response.XfusionPermissionApiRoleResetSwagger;
import com.springiot.swagger.response.XfusionPermissionViewRoleResetSwagger;
import com.springiot.swagger.response.XfusionRoleCreateSwagger;
import com.springiot.swagger.response.XfusionRoleDeleteSwagger;
import com.springiot.swagger.response.XfusionRoleUpdateSwagger;
import com.springiot.swagger.response.XfusionUserCreateSwagger;
import com.springiot.swagger.response.XfusionUserDeleteSwagger;
import com.springiot.swagger.response.XfusionUserUpdateLastActivityDateSwagger;
import com.springiot.swagger.response.XfusionUserUpdateLockStatusSwagger;
import com.springiot.swagger.response.XfusionUserUpdateSwagger;
import com.springiot.swagger.response.XfusionUsersGetByApplicationKeySwagger;
import com.springiot.swagger.response.XfusionViewDeleteSwagger;
import com.springiot.swagger.response.XfusionViewInsertSwagger;
import com.springiot.swagger.response.XfusionViewUpdateMultipleSwagger;
import com.springiot.swagger.response.XfusionViewUpdateSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

public class GenericControllerCUD {

	/**
	 * To access functionality of GenericProcess service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;
	/**
	 * To access functionality of ForGotPasswordServices service class method.
	 */
	@Autowired
	private ForGotPasswordServices forgotPasswordServices;

	/**
	 * To access functionality of roleService service class method.
	 */
	@Autowired
	private RegisterationService registerationService;

	/**
	 * This API will helps to change the password of the user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/passwordupdate", notes = "Helps to change the password of the user", response = XfusionPasswordUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "current_password", value = "User's current password", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "new_password", value = "User's new password ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/passwordupdate", method = RequestMethod.POST)
	public @ResponseBody Message passwordUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// To call the procedure required for data processing.
		Message message = genericProcess.GenericProcedureCalling("3", map, request, response);

		// return the response
		return message;

	}

	/**
	 * This API will update the bit for user approval, it helps to approve and
	 * dis-approve the user for the login.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/users/update/approvestatus", notes = "To Update the bit for user approval, it helps to approve and dis-approve the user for the login ")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "approved", value = "is approved ? 1 or 0 ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/users/update/approvestatus", method = RequestMethod.POST)
	public @ResponseBody Message usersUpdateApproveStatus(@RequestParam Map<String, String> map,
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

		Message message = genericProcess.GenericProcedureCalling("4", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will update the Last activity date od the user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/update/lastactivitydate", notes = "To update the Last activity date od the user", response = XfusionUserUpdateLastActivityDateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/update/lastactivitydate", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateLastActivityDate(@RequestParam Map<String, String> map,
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

		Message message = genericProcess.GenericProcedureCalling("5", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will update the lock_status of the user. It can lock and unlock the
	 * user
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/update/lockstatus", notes = "To Update the lock_status of the user. It can lock and unlock the user", response = XfusionUserUpdateLockStatusSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "lock_status", value = "Boolean status of lock ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/update/lockstatus", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateLockstatus(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("6", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will update user's role.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/update/uploadrole", notes = " To update user's role")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/update/uploadrole", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateUploadRole(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("7", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will create new Application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/application/insert", notes = "To create new Application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the User ID of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "applications_name", value = "Requires the Applications Name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "alias", value = "Requires the Alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_url", value = "Requires the URL of Application", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Requires description ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_url", value = "Requires View URL ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_url", value = "Requires API URL ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_url", value = "Requires Service URL ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Requires Service URL ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "logo_file_path", value = "Requires the logo file path", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/application/insert", method = RequestMethod.POST)
	public @ResponseBody Message applicationInsert(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("15", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get the password reset code in the mail.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/forgotpassword", notes = "This helps to get the password reset code in the mail")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "user_id", value = "Requires user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "reset_url", value = "Requires the URL", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody Message forgotPassword(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(map, request,
		// response);

		// Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = forgotPasswordServices.forgotPassword("17", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to reset the password.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/passwordreset", notes = "This helps to reset the password", response = XfusionPasswordResetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access_code", value = "Access Code ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "new_password", value = "New Password ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody Message passwordReset(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(map, request,
		// response);
		//
		// // Check response from message class is not valid
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response
		// return urlValidateMessage;
		// } else {

		// To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("18", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to create new Role.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/role/create", notes = "To create new Role", response = XfusionRoleCreateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires application id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_name", value = "Requires role name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes", value = "Requires specific csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_data_types", value = "Requires csv data types", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_regex", value = "Requires csv regex value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_is_required", value = "Requires the value of csv is required", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/role/create", method = RequestMethod.POST)
	public @ResponseBody Message roleCreate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("20", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update the application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/application/update", notes = "Helps to update the application", response = XfusionApplicationUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires application id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_alias", value = "Requires the application alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_url", value = "Requires the specific application url", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "description", value = "Requires the appllication Description", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "service_url", value = "Requires Service URL", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_url", value = "Requires API URL", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_url", value = "Requires View URL.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Requires Service URL ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "logo_file_path", value = "Requires logo file path ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/application/update", method = RequestMethod.POST)
	public @ResponseBody Message ApplicationManage(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("22", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update the role.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/role/update", notes = "Helps to update the role", response = XfusionRoleUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_name", value = "Requires the role name of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes", value = "Requires specific csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_data_types", value = "Requires csv data types", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_regex", value = "Requires csv regex value", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_is_required", value = "Requires the value of csv is required", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/role/update", method = RequestMethod.POST)
	public @ResponseBody Message RoleUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("23", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to delete the application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/application/delete", notes = "Helps to delete  the application", response = XfusionApplicationDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/application/delete", method = RequestMethod.POST)
	public @ResponseBody Message ApplicationDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("24", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to delete the role.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/role/delete", notes = "Helps to delete  the role", response = XfusionRoleDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of owner", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/role/delete", method = RequestMethod.POST)
	public @ResponseBody Message RoleDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("25", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to create User.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/create", notes = "To Create User", response = XfusionUserCreateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the Email Address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "Requires the password", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_question", value = "Requires the password question", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_answer", value = "Requires the password answer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_approved", value = "Requires Is approved", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires specific csv attribute ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires specific csv attribute value", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public @ResponseBody Message userCreate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("26", map, request, response);

		// return the response
		return message;
		// }
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

	@ApiOperation(value = "/user/update", notes = "To update basic information of user.", response = XfusionUserUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id", value = "Requires the updated user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the email Address of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires specific csv attribute ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires alias of csv attributes", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires specific csv attribute value", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public @ResponseBody Message userUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("27", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to delete the user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/delete", notes = "To delete the user.", response = XfusionUserDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the UserKey of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "delete_user_id", value = "Requires to delete specific user id", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public @ResponseBody Message userDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("28", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to set the role and api access.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/permission/api/role/reset", notes = "To set the role and api access", response = XfusionPermissionApiRoleResetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_ids", value = "Requires the api id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_bit", value = "Requires is bit", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/permission/api/role/reset", method = RequestMethod.POST)
	public @ResponseBody Message XfusionPermissionAPIRoleSet(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("32", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to set the role and view access.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/permission/view/role/reset", notes = "To set the role and view access", response = XfusionPermissionViewRoleResetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id", value = "Requires the role id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_id", value = "Requires the view id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_bit", value = "Requires is bit", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/permission/view/role/reset", method = RequestMethod.POST)
	public @ResponseBody Message permissionViewRoleSet(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("35", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to insert the view.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/view/insert", notes = "Insert the view", response = XfusionViewInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_name", value = "Requires the view name of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_url", value = "Requires the view url", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_added", value = "Requires boolean is Added.", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/insert", method = RequestMethod.POST)
	public @ResponseBody Message viewInsert(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("36", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to retrieve all api's of the application used or unused.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/api/delete", notes = "Delete the api's", response = XfusionApiDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_id", value = "Requires the api id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/api/delete", method = RequestMethod.POST)
	public @ResponseBody Message apiDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		Message message = genericProcess.GenericProcedureCalling("39", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update the api.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/api/update", notes = "To update the api", response = XfusionApiUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_id", value = "Requires the api id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_name", value = "Requires the api name of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_url", value = "Requires the specific url", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/api/update", method = RequestMethod.POST)
	public @ResponseBody Message apiUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("40", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to delete the view.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/view/delete", notes = "To delete the view", response = XfusionViewDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_id", value = "Requires the api id", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/delete", method = RequestMethod.POST)
	public @ResponseBody Message viewDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("42", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update the view.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/view/update", notes = "To update the view", response = XfusionViewUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_id", value = "Requires the api id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_name", value = "Requires the api name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_url", value = "Requires the specific url", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/update", method = RequestMethod.POST)
	public @ResponseBody Message viewUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("43", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update multiple api(s at same time.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/api/update/multiple", notes = "Update multiple api(s at same time", response = XfusionApiUpdateMultipleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_id", value = "Requires the api id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_name", value = "Requires the api name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "api_url", value = "Requires the specific url", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_added", value = "Requires the boolean is added", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/api/update/multiple", method = RequestMethod.POST)
	public @ResponseBody Message apiUpdateMultiple(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		Message message = genericProcess.GenericProcedureCalling("44", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update multiple api's at same time.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/view/update/multiple", notes = "Update multiple view's at same time", response = XfusionViewUpdateMultipleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_id", value = "Requires the aoi id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_name", value = "Requires the api name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_url", value = "Requires the specific url", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_added", value = "Requires the boolean Is Added.", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/update/multiple", method = RequestMethod.POST)
	public @ResponseBody Message viewUpdateMultiple(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		Message message = genericProcess.GenericProcedureCalling("45", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get api's by application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/application/user/add", notes = "To get api's by application.", response = XfusionApplicationUserAddSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id", value = "Requires the edited user id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_role_id", value = "Requires the edited role id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/application/user/add", method = RequestMethod.POST)
	public @ResponseBody Message applicationUserAdd(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("49", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/application/user/remove", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id ", value = "Requires the User id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_role_id ", value = "Requires the Role id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/application/user/remove", method = RequestMethod.POST)
	public @ResponseBody Message applicationUserRemove(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("58", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/inactive", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "inactive_user_id ", value = "Requires the Inactive User id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "isactive_status ", value = "Requires the Is Active Status", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/inactive", method = RequestMethod.POST)
	public @ResponseBody Message userInactive(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("59", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/update/lock/status", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id ", value = "Requires the Edit User id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "lock_status ", value = "Requires the Lock Status", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/update/lock/status", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateLockStatus(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("60", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */
	@ApiOperation(value = "/user/profile/create", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username ", value = "Requires the username of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password ", value = "Requires the password of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_question ", value = "Requires the passwordQuestion of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_answer ", value = "Requires the passwordAnswer of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_approved ", value = "Requires the isApproved of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id ", value = "Requires the applicationid of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the roleid of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name ", value = "Requires the first_name of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name ", value = "Requires the last_name of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country ", value = "Requires the country of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state ", value = "Requires the state of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city ", value = "Requires the city of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number ", value = "Requires the preferred_number of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers ", value = "Requires the phone_numbers of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address ", value = "Requires the address of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "creation_date ", value = "Requires the creation_date of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_permanent_address ", value = "Requires the is_permanent_address of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path ", value = "Requires the path of image ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "thumbail_image_path", value = "Requires the thumbail image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires the csv attributes id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires the csv attributes alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires the csv attributes value", required = true, access = "query", paramType = "query")

	})

	@RequestMapping(value = "/user/profile/create", method = RequestMethod.POST)
	public @ResponseBody Message userProfileCreate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("61", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * This API will helps to get users on basis of application key.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/profile/update", notes = "To get users on basis of application key.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email", value = "Requires the email of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name ", value = "Requires the first_name of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name ", value = "Requires the last_name of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country ", value = "Requires the country of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state ", value = "Requires the state of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city ", value = "Requires the city of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number ", value = "Requires the preferred_number of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers ", value = "Requires the phone_numbers of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address ", value = "Requires the address of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_anonymous", value = "Requires the is_anonymous of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is_deleted of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_activity_date", value = "Requires the last_activity_date of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_permanent_address ", value = "Requires the is_permanent_address of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path ", value = "Requires the image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "thumbail_image_path", value = "Requires the thumbail image path", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/profile/update", method = RequestMethod.POST)
	public @ResponseBody Message userProfileUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCalling("65", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * This API will helps to delete role attribute.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/xfusion/role/attribute/delete", notes = "To delete role attribute.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_id ", value = "Requires the attribute_id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/role/attribute/delete", method = RequestMethod.POST)
	public @ResponseBody Message xfusionRoleAttributeDelete(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("68", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update role attribute.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/xfusion/role/update/attribute", notes = "To update role attribute.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_id ", value = "Requires the attribute_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_name ", value = "Requires the attribute_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_alias ", value = "Requires the attribute_alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_data_type ", value = "Requires the attribute_data_type ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_reg_ex ", value = "Requires the attribute_reg_ex", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_is_required ", value = "Requires the attribute_is_required", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/role/update/attribute", method = RequestMethod.POST)
	public @ResponseBody Message xfusionRoleUpdateAttribute(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("69", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update role.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/xfusion/role/update", notes = "To update role", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_name ", value = "Requires the role_name ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/role/update", method = RequestMethod.POST)
	public @ResponseBody Message xfusionRoleUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
		Message message = genericProcess.GenericProcedureCalling("70", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to add role Attribute.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/xfusion/role/add/attribute", notes = "To add role Attribute.", response = XfusionUsersGetByApplicationKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the role_id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_name ", value = "Requires the attribute_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_alias ", value = "Requires the attribute_alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_data_type ", value = "Requires the attribute_data_type ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_reg_ex ", value = "Requires the attribute_reg_ex", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "attribute_is_required ", value = "Requires the attribute_is_required", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/xfusion/role/add/attribute", method = RequestMethod.POST)
	public @ResponseBody Message xfusionRoleAddAttribute(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("71", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to update the user by user id.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/xfusion/user/update/by/user/id", notes = "To update the user by user id ")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_id ", value = "Requires the edit user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_user_key ", value = "Requires the edit user_key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id ", value = "Requires the application id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "edit_role_ids ", value = "Requires the edit role ids ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email ", value = "Requires the email", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name ", value = "Requires the first name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name ", value = "Requires the last name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country ", value = "Requires the country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state ", value = "Requires the state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city ", value = "Requires the city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number ", value = "Requires the preferred number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers ", value = "Requires the phone numbers", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address ", value = "Requires the address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_anonymous ", value = "Requires the is anonymous", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted ", value = "Requires the is deleted", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_activity_date ", value = "Requires the last activity date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_permanent_address ", value = "Requires the is permanent address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path ", value = "Requires the image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "thumbail_image_path ", value = "Requires the thumbail image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id ", value = "Requires the csv_attributes_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias ", value = "Requires the csv attributes alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value ", value = "Requires the csv attributes value", required = true, access = "query", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code") })
	@RequestMapping(value = "/xfusion/user/update/by/user/id", method = RequestMethod.POST)
	public @ResponseBody Message XfusionUserUpdateByUserId(@RequestParam Map<String, String> map,
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
		Message message = genericProcess.GenericProcedureCalling("75", map, request, response);

		// return the response
		return message;
		// }
	}

	/**
	 * This API will helps to verify user with the OTP and send email with the OTP
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/user/verification", notes = "To verify user on the basis of OTP", response = UserVerificationSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username ", value = "Requires the user id ", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/user/verification", method = RequestMethod.POST)
	public @ResponseBody Message userVerification(@RequestParam String username, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// To call the procedure required for data processing.

		Message message = registerationService.userVerification(username, request, response);

		// Return the response message.

		return message;
	}

	/**
	 * This API will helps to verify email and OTP is mapped in the respective and
	 * database and if it is mapped,then create user profile at the sign up time.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "Create user at the time of Sign up", notes = "To verify user and create user profile", response = UserCreationSignupSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username ", value = "Requires the username of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "OTP ", value = "Requires the password of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password ", value = "Requires the password of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_question ", value = "Requires the passwordQuestion of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "password_answer ", value = "Requires the passwordAnswer of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_approved ", value = "Requires the isApproved of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id ", value = "Requires the applicationid of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_id ", value = "Requires the roleid of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name ", value = "Requires the first_name of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name ", value = "Requires the last_name of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country ", value = "Requires the country of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state ", value = "Requires the state of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city ", value = "Requires the city of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number ", value = "Requires the preferred_number of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers ", value = "Requires the phone_numbers of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address ", value = "Requires the address of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "creation_date ", value = "Requires the creation_date of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_permanent_address ", value = "Requires the is_permanent_address of particular user ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "image_path ", value = "Requires the path of image ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "thumbail_image_path", value = "Requires the thumbail image path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_id", value = "Requires the csv attributes id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_alias", value = "Requires the csv attributes alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "csv_attributes_value", value = "Requires the csv attributes value", required = true, access = "query", paramType = "query")

	})
	@RequestMapping(value = "/user/creation/signup", method = RequestMethod.POST)
	public @ResponseBody Message userVerficiationProfileCreation(@RequestParam LinkedHashMap<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// To call the procedure required for data processing.

		Message message = registerationService.userCreationSignup(map, request, response);

		// Return the response message.

		return message;
	}

	/**
	 * To validate the token from the database on the basis of application key
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiOperation(value = "/oauth/validate/token", notes = "To validate token from database")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key", value = "Requires the application key", required = true, access = "query", paramType = "query")

	})
	@RequestMapping(value = "/oauth/validate/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthValidateToken(@ApiIgnore @RequestParam Map<String, String> map,
			@RequestParam(required = false) Integer token_type, HttpServletRequest request,
			HttpServletResponse response) {

		Message message = new Message();

		// Retrieve from where the request is coming to API
		String type = request.getHeader("User-Agent");

		try {

			// Calculation the token type
			Integer tokenType;
			if (token_type == null) {

				if (type.contains("okhttp")) {
					tokenType = 1;
				} else {
					tokenType = 0;
				}
			} else {
				tokenType = token_type;
			}

			// The response retrieved from procedure is stored in Object class
			Object responseFromprocedure = genericService.executeProcesure(null,
					processParameter.getMaps().get("82").toString(), request.getHeader("user_key"),
					request.getHeader("user_id"), request.getHeader("token"), map.get("application_key"), tokenType);

			// System.out.println("responseFromprocedure" +
			// responseFromprocedure);

			List<Map<String, Object>> listRespone = (List<Map<String, Object>>) responseFromprocedure;

			String hsql = "insert into TokenStorage.auth_token (access_token,role_id,user_key,user_id,access_key,token_type,application_key,time) values ('"
					+ request.getHeader("token") + "','" + String.valueOf(listRespone.get(0).get("roles_id")) + "','"
					+ request.getHeader("user_key") + "','" + request.getHeader("user_id") + "','"
					+ listRespone.get(0).get("access_key").toString() + "','" + tokenType + "','"
					+ map.get("application_key") + "',now())";
			// System.out.println("hsql is" + hsql);

			Object tokenPersistent = genericService.executeHSqlQuery(hsql);

			message.setDescription("token is validated");
			message.setObject(responseFromprocedure);
			message.setValid(true);

		} catch (Exception exception) {
			exception.printStackTrace();
			message.setDescription("token is not validated");
			message.setValid(false);
		}
		return message;
	}

	/**
	 * This API is used for calling of all Grafana user mapping APIs.This API is a
	 * wildcard API
	 * 
	 * @param Map,
	 *            Contains all the parameters.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	// @RequestMapping(value = "/**/", method = { RequestMethod.POST,
	// RequestMethod.GET })
	// public @ResponseBody Message xfusionSettingsGrafana(@RequestParam Map<String,
	// String> map,
	// HttpServletRequest request, HttpServletResponse response) throws Exception {
	//
	// // To call the procedure required for data processing.
	// Message message = grafanaServices.callGrafanaAPIs(map, request, response);
	//
	// // Return the response message.
	// return message;
	// }

	/**
	 * To get settings of xFusion Platform
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@RequestMapping(value = "/auth/settings", method = { RequestMethod.POST })
	public @ResponseBody Message authSettingsGrafana(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// // Specific url has permissions
		// Message urlValidateMessage = genericProcess.urlValidate(request,
		// response);
		//
		// // Check response from message class is not valid
		//
		// if (!urlValidateMessage.isValid()) {
		//
		// // return the response return urlValidateMessage; } else {
		//
		// // To call the procedure required for data processing.

		Message message = genericProcess.GenericProcedureCalling("93", map, request, response);

		// return the response
		return message;
		// }
		// return urlValidateMessage;

	}

}
