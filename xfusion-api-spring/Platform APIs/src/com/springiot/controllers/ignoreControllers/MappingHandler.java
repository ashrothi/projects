/**
 * This package contain the controller class for API calling and publish response for each API. 
 * The swagger document is also initialized in this package which will list down all the API categorized by their controller. 
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
import com.springiot.services.MappingHandlerService;
import com.springiot.swagger.response.GetapiurlSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This controller class is used to perform operation on
 *         mapping of APIs of all application.
 */

@ApiIgnore
@Controller
public class MappingHandler {
	/**
	 * To access functionality of MappingHandlerService service class method.
	 */
	@Autowired
	private MappingHandlerService mappingHandlerService;

	/**
	 * To get aLL URLs of applications.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/getapiurl", notes = "To get API URLs.", response = GetapiurlSwagger.class)
	@RequestMapping(value = "/getapiurl", method = RequestMethod.POST)
	public @ResponseBody Message getapiURL() throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.getAPIsMapping();
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
	 * @throws Exception
	 */
	@ApiOperation(value = "/mapping/handler", notes = "To Refresh view.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_path", value = "Requires the file path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "auth_mapping", value = "Requires the Auth Mapping", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/mapping/handler", method = RequestMethod.POST)
	public @ResponseBody Message mappingHandler(@ApiIgnore @RequestParam Map<String, String> map,HttpServletRequest request,HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mappingHandlerService.mappingHandler(map,request,response);
		/*
		 * Return the response message.
		 */
		return message;
	}

}
