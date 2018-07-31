package org.goup.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.services.GoupB2BService;
import org.goup.swagger.response.ApiResponseSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
public class GoupB2BController {

	@Autowired
	private GoupB2BService goupB2BService;

	@ApiOperation(value = "/get/sim/details", notes = "This API is to get sim details.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "HTTP Basic authentication,where consumer sends the ‘user_name’ and ‘password’ separated by ‘:’, within a base64 ", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "iccid", value = "Unique ID for the transaction .  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String") })
	@RequestMapping(value = "/get/sim/details", method = RequestMethod.GET)
	public ResponseEntity<?> getSimDetails(@RequestParam Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> responseMessage = goupB2BService.getSimDetails(parameterMap,request, response);
		return responseMessage;

	}
	
	

}
