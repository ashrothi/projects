/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.services.AuthTokenServices;
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.springiot.request.model.Message;

/**
 * This class is a controller class used for the retrieval of OAuth token and session of token.
 * 
 * @author Mandeep Singh
 */
@Controller
public class AuthTokenController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private AuthTokenServices tokenServices;

	/*
	 * This API is used to retrieve the token for security and authentication.
	 */
	@ApiOperation(value = "/getAuthorization/token", notes = "To login", response = OauthTokenSwagger.class)
	@RequestMapping(value = "/getAuthorization/token", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiParam(name = "merchant_key", defaultValue = "base64 encrypted(username:password)") @RequestParam String merchant_key)
			throws Exception {

		Message message = tokenServices.oauthToken(merchant_key, req, res);
		return message;
	}
}