/**
 * This package contain the controller class for Android API.
 */
package com.springiot.controllers;
/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.AndroidService;
import com.springiot.swagger.response.HeroNotificationGetAllAlertPhoneSwagger;
import com.springiot.swagger.response.HeroNotificationGetAllPhoneSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for  Phone Notification
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class AndroidController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private AndroidService androidService;
	/**
	 * To get all notification on Android Application
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/get/all/phone", notes = "To get all notification on Android Application",response=HeroNotificationGetAllPhoneSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userKey", value = "Required user key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Required user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Required From Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "to_date ", value = "Required to Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "filter_type ", value = "Required filter_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/get/all/phone", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationGetAll(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = androidService.notificationForHero( map);
		return message;
	}

	/**
	 * To get all Alerts on Android Application
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/hero/notification/get/all/alert/phone", notes = "To get all Alerts on Android Application",response=HeroNotificationGetAllAlertPhoneSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "userKey", value = "Required user key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Required user ID", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Required From Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "to_date ", value = "Required to Date", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "filter_type ", value = "Required filter_type", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/notification/get/all/alert/phone", method = RequestMethod.POST)
	public @ResponseBody Message heroNotificationGetAllAlert(@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = androidService.alertsForHero( map);
		return message;
	}


}
