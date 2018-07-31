
/**
 * This package contain the class which is used to create and provide organization mapping.
 */
package com.springiot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.controllers.ignoreControllers.OrganizationControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.CityGetCitySwagger;
import com.springiot.swagger.response.*;
import com.springiot.swagger.response.OrganizationGetAllSwagger;
import com.springiot.swagger.response.OrganizationGetAllUserSwagger;
import com.springiot.swagger.response.StateGetSwagger;
import com.springiot.swagger.response.UsersGetAllByUserOrganizationSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class is used to create and provide organization mapping using different
 * URLs.
 */
@Controller
@Api(value = "/", description = "For organization of users and devices")
public class OrganizationController extends OrganizationControllerCUD {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To get the details of user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/organization/get/all/user", notes = "To retrieve all users based on user organization", response = OrganizationGetAllUserSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"), })

	@RequestMapping(value = "/organization/get/all/user", method = RequestMethod.POST)
	public @ResponseBody Message organizationGetAllUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("8", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To all the organization on basis of user.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/get/all", notes = "Get all the orzanization on basis of user", response = OrganizationGetAllSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"), })

	@RequestMapping(value = "/organization/get/all", method = RequestMethod.POST)
	public @ResponseBody Message OrgnizationGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("28", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To update the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/city/get/city", notes = "Returns cities based on state", response = CityGetCitySwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "state_id", value = "Requires the id of state"), })

	@RequestMapping(value = "/city/get/city", method = RequestMethod.POST)
	public @ResponseBody Message cityGetCity(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Calling of procedure
		Message message = genericProcess.GenericProcedureCallingMetaData("86", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To update the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/country/get/country", notes = "Returns countries", response = GetChartsCountrySwagger.class)

	@RequestMapping(value = "/country/get/country", method = RequestMethod.POST)
	public @ResponseBody Message countryGetCountry(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCallingMetaData("88", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To update the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/state/get/state", notes = "Returns state based on country", response = StateGetSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "country_id", value = "Requires the id of country") })

	@RequestMapping(value = "/state/get/state", method = RequestMethod.POST)
	public @ResponseBody Message stateGetState(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCallingMetaData("89", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To update the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/users/get/all/by/user/organization", notes = "Returns state based on country", response = UsersGetAllByUserOrganizationSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user") })

	@RequestMapping(value = "/users/get/all/by/user/organization", method = RequestMethod.POST)
	public @ResponseBody Message xfusionUsersGetAllByUserOrganization(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("405", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To retrieve the organization based on the user
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/get/by/user", notes = "Retrieve the organization based on the user", response = OrganizationGetByUserSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"), })

	@RequestMapping(value = "/organization/get/by/user", method = RequestMethod.POST)
	public @ResponseBody Message OrganizationGetByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("423", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
