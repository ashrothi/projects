/**
 * This package contain the controller class for Third Party Application for Flint
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
import com.springiot.swagger.response.MappingHandlerSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private MappingHandlerService mappingHandlerService;

	/**
	 * To get API URLs.
	 * 
	 * @return Return the response message
	 * @throws Exception 
	 */
	@ApiOperation(value = "/getapiurl", notes = "To get API URLs.", response = GetapiurlSwagger.class)
	@ApiImplicitParams({})
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/getapiurl", method = RequestMethod.POST)
	public @ResponseBody Message getapiURL() throws Exception {

		/*
		 * getAPIsMapping() method is called upon for the mapping of API's.
		 */
		Message message = mappingHandlerService.getAPIsMapping();
		return message;
	}

	/**
	 * To Refresh view.
	 * 
	 * @param passingMap:::
	 *            Contains all the parameters.
	 * @return Return the response message
	 * @throws Exception 
	 */
	@ApiOperation(value = "/mapping/handler", notes = "To Refresh view.", response = MappingHandlerSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "filepath", value = "Requires the file path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "auth_mapping", value = "Requires the Auth Mapping", required = true, access = "query", paramType = "query") })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/mapping/handler", method = RequestMethod.POST)
	public @ResponseBody Message mappingHandler(@ApiIgnore @RequestParam Map<String, String> map) throws Exception {

		/*
		 * Calling of mapping handler() function which is required when mapping
		 * of uploaded and downloaded file is to be done.
		 */
		Message message = mappingHandlerService.mappingHandler(map);
		return message;
	}
	/*
	 * This API is used to retrieve all URL's of API's
	 */
	@ApiIgnore
	@ApiOperation(value = "/getapiurl/class", notes = "To get API URLs.")
	@ApiImplicitParams({})
	@RequestMapping(value = "/getapiurl/class", method = RequestMethod.POST)
	public @ResponseBody Message getapiURLClass() throws Exception {

		/*
		 * getAPIsMapping() method is called upon for the mapping of API's.
		 */
		Message message = mappingHandlerService.getAPIsMappingClass();
		return message;
	}

}
