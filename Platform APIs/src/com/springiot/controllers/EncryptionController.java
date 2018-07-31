/**
 * This package contains the class which is used as a controller for encryption used for SSO
 */
package com.springiot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.EncryptionService;
import com.springiot.swagger.response.GenericPerformanceEventDeviceGetSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This class is used for the encryption of username and password for SSO.
 * 
 * @author tanvigarg
 *
 */
@Controller
public class EncryptionController {

	@Autowired
	private EncryptionService encryptionService;

	/**
	 * To Retrieve the token after the successful decrytption of data
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "Retrieve the token after the successful decrytption of data", notes = "Retrieve all active alerts of a particular device ", response = GenericPerformanceEventDeviceGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "encrypted_username", value = "Requires the username in encrypted format", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "encrypted_password", value = "Requires the password in encrypted format", required = true, access = "query", paramType = "query"), })
	@RequestMapping(value = "/encrypted/text/to/plain/format", method = RequestMethod.POST)
	public @ResponseBody Message encryptData(String encrypted_username, String encrypted_password,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message responseMessage = encryptionService.plainTextToEncryptedFormat(encrypted_username, encrypted_password,
				request, response);

		return responseMessage;

	}
}
