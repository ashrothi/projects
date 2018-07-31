/**
 * This package contain the controller class for Third Party Application apis.
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
import com.springiot.services.ThirdPartyService;
import com.springiot.services.DownloadServices;
import com.springiot.services.ThirdPartyService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class ThirdPartyController {

	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private ThirdPartyService downloadDeviceDetailsService;

	/**
	 * To download excel for Device Model Details Page.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/details/excel/downnload", notes = "To download excel file for Subscription details")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "report_api_url", value = "Requires url of api", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "report_name", value = "Requires name of report", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model id", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "timezone", value = "Requires the timezone", required = true, access = "header", paramType = "header", dataType = "String"), })

	@RequestMapping(value = "/organization/details/excel/downnload", method = RequestMethod.POST)
	public @ResponseBody Message DeviceModelDetailsExcelDownload(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Call the method to get the list of applications
		 */
		Message message = downloadDeviceDetailsService.DownloadSuscriptionDetails(map, request,
				response);

		/*
		 * Return the response message.
		 */
		return message;
	}

}
