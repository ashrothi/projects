/**
 * This package contain the controller class for customized apis.
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
import com.springiot.swagger.response.ApplicationGetAllSwagger;
import com.springiot.swagger.response.ApplicationsByIdSwagger;
import com.springiot.swagger.response.GroupByPerformanceDeviceGetServicesSwagger;
import com.springiot.swagger.response.UploadImageSwagger;
import com.springiot.swagger.response.UserDetailsGetByUserIdSwagger;
import com.springiot.swagger.response.UsersListSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         apis for customized apis.
 */
@ApiIgnore
@Controller
@Api(value = "/", description = "Customize Api's for Web Apllication")
public class OperationalController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private OperationalService operationalService;


	/**
	 * To returns operational and non operational users list,based on users list
	 * of Oauth Engine and metadata db.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/users/list", notes = "Returns operational and non operational users list,based on users list of Oauth Engine and metadata db", response = UsersListSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "application_key", value = "Requires the application key of user") })

	@RequestMapping(value = "/users/list", method = RequestMethod.POST)
	public @ResponseBody Message UsersList(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Call the method to returns operational and non operational users
		 * list,based on users list of Oauth Engine and metadata db
		 */
		Message message = operationalService.UsersListDownload(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To returns services details based on service groups.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/group/by/performance/device/get/services", notes = "Retrieve services details based on service groups", response = GroupByPerformanceDeviceGetServicesSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the device ID"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"), })

	@RequestMapping(value = "/group/by/performance/device/get/services", method = RequestMethod.POST)
	public @ResponseBody Message groupByPerformanceDeviceGetServices(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = operationalService.getServices(map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get list of all applications.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/application/get/all", notes = "To get list of all applications", response = ApplicationGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user"), })

	@RequestMapping(value = "/application/get/all", method = RequestMethod.POST)
	public @ResponseBody Message applicationGetAll(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * Call the method to get the list of applications
		 */
		Message message = operationalService.getAllAppliction(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To download excel for Device Model Details Page.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/model/details/excel/downnload", notes = "To download excel file for device model details")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user"),
			@ApiImplicitParam(name = "report_api_url", value = "Requires url of api"),
			@ApiImplicitParam(name = "report_name", value = "Requires name of report"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model id"),
			@ApiImplicitParam(name = "timezone", value = "Requires the timezone"), })

	@RequestMapping(value = "/device/model/details/excel/downnload", method = RequestMethod.POST)
	public @ResponseBody Message DeviceModelDetailsExcelDownload(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Call the method to get the list of applications
		 */
		Message message = operationalService.DeviceModelDetailsExcelDownload(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To update the user Profile
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/profile/update", notes = "Updates the user profile")
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
			@ApiImplicitParam(name = "thumbail_image_path", value = "Requires the thumbail image path", required = true, access = "query", paramType = "query"), })

	@RequestMapping(value = "/user/profile/update", method = RequestMethod.POST)
	public @ResponseBody Message userProfileUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = operationalService.userProfileUpdate(map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To retrieve user details on the basis of user id
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/user/details/get/by/user/id", notes = "To retrieve user details specific to user", response = UserDetailsGetByUserIdSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user"), })

	@RequestMapping(value = "/user/details/get/by/user/id   ", method = RequestMethod.POST)
	public @ResponseBody Message userDetailsByuserId(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = operationalService.userDetailsByuserId(map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To upload image on Profile page
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/uploadImage", notes = "To retrieve user details specific to user", response = UploadImageSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "file_name", value = "Requires the name of file"),
			@ApiImplicitParam(name = "file_data", value = "Requires the file data"), })

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public @ResponseBody Message uploadImage(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * To check the url is validated or not for user.
		 */
		Message urlMessage =new Message();
//				urlValidationKeyService.validateURL("uploadImage", request, response);

		return urlMessage;
	}

	/**
	 * To retrieve applications of user
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/applications/by/id", notes = "To retrieve applications of user", response = ApplicationsByIdSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "UserKey", value = "Requires the key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user"), })

	@RequestMapping(value = "/applications/by/id", method = RequestMethod.POST)
	public @ResponseBody Message applicationsById(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = operationalService.applicationsById(map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To validate token from authorization engine
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/validate/token", notes = "To retrieve applications of user", response = ApplicationsByIdSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "User_key", value = "Requires the key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user"),
			@ApiImplicitParam(name = "application_key", value = "Requires the application key") })

	@RequestMapping(value = "/validate/token", method = RequestMethod.POST)
	public @ResponseBody Object validateToken(@RequestParam Map<String, String> map,
			@RequestParam(required = false) Integer token_type, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Message message = operationalService.validateToken(request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To returns operational and non operational users list,based on users list
	 * of Oauth Engine and metadata db.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/operational/users/list/download", notes = "Returns operational and non operational users list,based on users list of Oauth Engine and metadata db", response = UsersListSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "email_id", value = "Requires the email id"),
			@ApiImplicitParam(name = "application_key", value = "Requires the application key of user") })

	@RequestMapping(value = "/operational/users/list/download", method = RequestMethod.POST)
	public @ResponseBody Message OperationalUsersList(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Call the method to returns operational and non operational users
		 * list,based on users list of Oauth Engine and metadata db
		 */
		Message message = operationalService.OperationalUsersListDownload(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}
}
