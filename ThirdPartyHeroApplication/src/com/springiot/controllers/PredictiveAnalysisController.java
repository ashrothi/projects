/**
 * This package contains the class which is used as a controller to create apis for Generic Procedure Calling.
 */
package com.springiot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.HeroMlGetHornSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to control APIs using Generic 
 * Procedure Calling for predictive analysis testing of Horn component.
 * 
 * @author Mandeep Singh
 */
@Controller
@Api(value = "/", description = "File Report Process.")
public class PredictiveAnalysisController {

	/**
	 * To access functionality of following Class function.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * API To get history of horn results and testing data.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/ml/get/horn/history", notes = "To get history of horn results and testing data.", response = HeroMlGetHornSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Here Pass device id for which user wants history.", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/ml/get/horn/history", method = RequestMethod.POST)
	public @ResponseBody Message heroMlGetHornHistory(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("407", map, null);
		return message;
	}

	/**
	 * Api To get current horn status.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/ml/get/horn/status", notes = "To get current horn status.", response = HeroMlGetHornSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/hero/ml/get/horn/status", method = RequestMethod.POST)
	public @ResponseBody Message heroMlGetHornStatus(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("408", map, null);
		return message;
	}

	/**
	 * API To get specification of horn component on given device id.
	 * 
	 * @param map : Here pass all the required parameters.
	 * @return Return the response message.
	 */
	@ApiOperation(value = "/hero/ml/get/horn/specification", notes = "To get specification of horn component on given device id.", response = HeroMlGetHornSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_id", value = "Here Pass device id for which user wants history.", required = true, access = "query", paramType = "query")})
	@RequestMapping(value = "/hero/ml/get/horn/specification", method = RequestMethod.POST)
	public @ResponseBody Message heroMlGetHornSpecification(
			@ApiIgnore @RequestParam Map<String, String> map) {
		Message message = genericProcess.GenericProcedureCalling("409", map, null);
		return message;
	}
}
