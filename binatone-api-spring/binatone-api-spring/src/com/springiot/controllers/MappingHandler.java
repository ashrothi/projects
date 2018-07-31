/**
 * This package contain the controller class for Mapping Handler To Get API URL's .
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
import com.springiot.services.MappingHandlerService;
import com.springiot.swagger.response.GetapiurlSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis Mapping Handler
 * To Get API URL's .
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class MappingHandler {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private MappingHandlerService mappingHandlerService;

	/**
	 * To get API URLs.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/getapiurl", notes = "To get API URLs",response=GetapiurlSwagger.class)
	@ApiImplicitParams({})
	@RequestMapping(value = "/getapiurl", method = RequestMethod.POST)
	public @ResponseBody Message getapiURL() {

		Message message = mappingHandlerService.getAPIsMapping();

		return message;
	}

	/**
	 * To Refresh view.
	 * @param passingMap:::
	 *            Contains all the parameters.
	 * @return Return the response message
	 */
	@ApiOperation(value = "/mapping/handler", notes = "To Refresh view.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Requires the file path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "auth_mapping", value = "Requires the Auth Mapping", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/mapping/handler", method = RequestMethod.POST)
	public @ResponseBody Message mappingHandler(@ApiIgnore @RequestParam Map<String, String> passingMap) {

		Message message = mappingHandlerService.mappingHandler(passingMap);

		return message;
	}

}
