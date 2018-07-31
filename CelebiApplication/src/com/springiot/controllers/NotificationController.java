/**
 * This package contain the controller class for Third Party Application for Flint
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
import com.springiot.services.GenericProcess;
import com.springiot.services.ThirdPartyServices;
import com.springiot.swagger.response.FlintGlobalSearchSwagger;
import com.springiot.swagger.response.FlintNotificationGetAllSwagger;
import com.springiot.swagger.response.FlintNotificationUpdateSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used ,used for retrieving of
 * notifications or any updation in notifications.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class NotificationController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private ThirdPartyServices thirdPartyServices;

	/*
	 * This Api is used to retrieve all the notifications meant for Driver
	 */
	@ApiOperation(value = "/flint/notification/get/all", notes = "Retrieve all the notifications ", response = FlintNotificationGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "Requires role name ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires from date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date", value = "Requires end date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/notification/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintNotificationGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = thirdPartyServices.flintNotificationGetAll("21", map, null, request, response);
		return message;
	}

	/*
	 * This Api is used for updating the notifications.
	 */
	@ApiOperation(value = "/flint/notification/update", notes = "To Update notification ", response = FlintNotificationUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "Requires role name ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id", value = "Requires the id of task ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id", value = "Requires the id of ticket", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_gcm_pushed", value = "Requires the boolean value", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/notification/update", method = RequestMethod.POST)
	public @ResponseBody Message flintNotificationUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("22", map, null, request, response);
		return message;
	}

	/*
	 * This Api is used for Global search
	 */
	@ApiOperation(value = "/flint/global/search", notes = "For Global search  ", response = FlintGlobalSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "Requires role name ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "keyword_to_search", value = "Requires keyword_to_search ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/global/search", method = RequestMethod.POST)
	public @ResponseBody Message flintGlobalSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = thirdPartyServices.flintGlobalSearch("69", map, null, request, response);
		return message;
	}

}
