/**
 * This package contain the controller class for API calling ans publish response for each API. 
 * The swagger document is also initialized in this package which will list down all the API categorized by their controller. 
 */
package com.springiot.controllers;

import java.io.IOException;
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
import com.springiot.services.MappingHandlerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This controller class is used to perform operation on mapping of APIs of all
 * application.
 */
@Controller
public class MappingHandler {
	/**
	 * To access functionality of MappingHandlerService service class method.
	 */
	@Autowired
	private MappingHandlerService mappingHandlerService;

	/**
	 * To get aLL URLs of applications from Swagger
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws IOException
	 */
	@ApiOperation(value = "/getallurl", notes = "To get aLL URLs of applications.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "url", value = "Required API Url", required = true, access = "query", paramType = "query") })
	// @RequestMapping(value = "/read/url/swagger", method = RequestMethod.POST)
	@RequestMapping(value = "/getallurl", method = RequestMethod.POST)
	public @ResponseBody Object getAllURLSwagger(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		// * To call the procedure required for data processing.

		// Object object = mappingHandlerService.getAllURL(map);

		Message message = mappingHandlerService.readURL(map, request, response);

		// * Return the response message.

		return message;
	}

	/**
	 * To Get view of all URLs..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/getviewurl", notes = "To Get view of all URLs.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "url", value = "Required View Url", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/getviewurl", method = RequestMethod.POST)
	public @ResponseBody Message getUrls(@ApiIgnore @RequestParam Map<String, String> map) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.getUrls(map);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To Get view of all URLs..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	/*
	 * @ApiOperation(value = "/getapiurl", notes = "To get API URLs.")
	 * 
	 * @ApiImplicitParams({})
	 * 
	 * @RequestMapping(value = "/getapiurl", method = RequestMethod.POST)
	 * public @ResponseBody Message getapiURL() {
	 * 
	 * To call the procedure required for data processing.
	 * 
	 * Message message = mappingHandlerService.getAPIsMapping();
	 * 
	 * Return the response message.
	 * 
	 * return message; }
	 */

	/**
	 * To refresh views of application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/view/refresh", notes = "To refresh views of application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "view_url", value = "Requires the specific url", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/view/refresh", method = RequestMethod.POST)
	public @ResponseBody Message viewRefreshURL(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.viewRefreshURL(map, response, request);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To Refresh api(s) of application.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/api/refresh", notes = "To Refresh api(s) of application")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of specific user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "url", value = "Requires the specific url", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/api/refresh", method = RequestMethod.POST)
	public @ResponseBody Message apiRefreshURL(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.apiRefreshURL(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To get all application mapping of oauth engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/oauth/mapping", notes = "To get all application mapping of oauth engine.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "url", value = "Requires the user key of particular user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Requires the file path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_id", value = "Requires the application id of particular user", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/oauth/mapping", method = RequestMethod.POST)
	public @ResponseBody Message oAuthMappingHandler(@ApiIgnore @RequestParam Map<String, String> map) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.oAuthMappingHandler(map);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To access the mapping handler..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws IOException
	 */
	@ApiOperation(value = "/mapping/handler", notes = "To access the mapping handler.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Requires the file path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "auth_mapping", value = "Requires the Auth Mapping", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/mapping/handler", method = RequestMethod.POST)
	public @ResponseBody Message mappingHandler(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.mappingHandler(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To get aLL URLs of applications from Swagger
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws IOException
	 */
	@ApiOperation(value = "/get/url", notes = "To get aLL URLs of applications.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "url", value = "Required API Url", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/get/url", method = RequestMethod.POST)
	public @ResponseBody Object getAllURL(@ApiIgnore @RequestParam Map<String, String> map) throws IOException {

		// * To call the procedure required for data processing.

		// Object object = mappingHandlerService.getAllURL(map);

		Object object = mappingHandlerService.getURL(map);

		// * Return the response message.

		return object;
	}
}