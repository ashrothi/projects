/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
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
import com.springiot.services.GenericProcess;
import com.springiot.services.ThirdPartyServices;
import com.springiot.swagger.response.FlintGetProductVehicleStateSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used retrieve all vehicles or state
 * of vehicle or the type of vehicle or retrieve all vehicles based on some
 * specific criteria
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class ThirdPartyController {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private ThirdPartyServices thirdPartyServices;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get all Product ,Vehicle and State
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/get/product/vehicle/state", notes = "To get all Product ,Vehicle and State", response = FlintGetProductVehicleStateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "country_id", value = "Requires country_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/product/vehicle/state", method = RequestMethod.POST)
	public @ResponseBody Message flintGetProductVehicleTypeState(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (map.containsKey("country_id")) {
			Message responseMessage = thirdPartyServices.flintGetProductVehicleTypeState(map, request, response);
			return responseMessage;
		}
		Message responseMessage = new Message();
		responseMessage.setDescription("Incorrect Parameters ");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To get all Product ,Vehicle and State
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/product/type/get/all", notes = "To get all Product ,Vehicle and State", response = FlintGetProductVehicleStateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "country_id", value = "Requires country_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/product/type/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintproducttypegetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = genericProcess.GenericProcedureCalling("6", map, null, request, response);
		return message;

	}

	/**
	 * To get all Product ,Vehicle and State
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/contact/us/email", notes = "To get all Product ,Vehicle and State", response = FlintGetProductVehicleStateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "Requires name of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "email", value = "Requires email of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contact_numberr", value = "Requires contact_numberr of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "query", value = "Requires query", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/contact/us/email", method = RequestMethod.POST)
	public @ResponseBody Message sendContactUsmail(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message message = thirdPartyServices.SendEmailContactUs(map, null, request, response);
		return message;

	}
}
