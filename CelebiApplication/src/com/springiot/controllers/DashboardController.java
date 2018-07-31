/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used for CRUD for Customer and
 * manage Customer details
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@EnableAsync
public class DashboardController {
	@Autowired
	private GenericProcess genericProcess;

	@ApiOperation(value = "/flint/get/export/import/count", notes = "To get all the User Tag", response = FlintGetCustomerUserTagSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"), })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/export/import/count", method = RequestMethod.POST)
	public @ResponseBody Message flintgetbookingservicedetails(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("102", map, null, request, response);
		return message;
	}
}
