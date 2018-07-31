/**
 * This Package contains controllers of Third Party Orchestration API.
 */
package org.goup.controllers;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
/**
 * 
 * This class use as @Controller to call all API's Defined In Orchestration Interface for Authentication
 * responses
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@ApiIgnore
public class AuthController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private AuthService authService;
	/**
	 * This API is used to Authenticate the user.User Needs to Pass user_name and password 
	 * @param user_name
	 * @param password
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/subscriber/auth/token", notes = "This API is used for authenticating the user.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "user_name", value = "Here pass authenticated user_name  to access API in headers.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "Here pass authenticated password  to access API in headers.", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/subscriber/auth/token", method = RequestMethod.POST)
	public ResponseEntity<?> deviceRegister(@RequestParam String user_name, 
			@RequestParam String password, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

	
		ResponseEntity<?> responseMessage = authService.authenticateUser(user_name, password, request, response);

		return responseMessage;

	}
}
