
/**
 * This package contain the class which is used to create and provide organization mapping.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.OperationalService;
import com.springiot.swagger.response.OrganizationRootByUserSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for organization
 * related api's..
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
public class OrganizationControllerCUD {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To access functionality of following Class function.
	 */
	@Autowired
	private OperationalService operationalService;

	/**
	 * To insert the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/organization/insert", notes = "Insert the organization")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"),
			@ApiImplicitParam(name = "parent_organization", value = "Requires the parent organization"),
			@ApiImplicitParam(name = "organization_name ", value = "Requires the name of organization"),
			@ApiImplicitParam(name = "city", value = "Requires the name of city"),
			@ApiImplicitParam(name = "country", value = "Requires the name of country"),
			@ApiImplicitParam(name = "description", value = "Requires the description"),
			@ApiImplicitParam(name = "color_code", value = "Requires the color code"), })

	@RequestMapping(value = "/organization/insert", method = RequestMethod.POST)
	public @ResponseBody Message organizationInsert(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("27", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To insert the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/user/organization/insert", notes = "For mapping of users with organizations")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"),
			@ApiImplicitParam(name = "insert_userKey  ", value = "Requires the user key for insert"),
			@ApiImplicitParam(name = "insert_user_id ", value = "Requires the user ID for insert"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization id"), })

	@RequestMapping(value = "/user/organization/insert", method = RequestMethod.POST)
	public @ResponseBody Message userOrganizationInsert(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("29", map, request, response);
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
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/organization/update", notes = "To update an organization")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"),
			@ApiImplicitParam(name = "organization_id  ", value = "Requires the organization id of user"),
			@ApiImplicitParam(name = "organization_name ", value = "Requires the name of organization"),
			@ApiImplicitParam(name = "organization_alias", value = "Requires the alias of organization"),
			@ApiImplicitParam(name = "organization_city", value = "Requires the city of organization"),
			@ApiImplicitParam(name = "description", value = "Requires the description"),
			@ApiImplicitParam(name = "country_id", value = "Requires the country id"),
			@ApiImplicitParam(name = "color_code", value = "Requires the color code"), })

	@RequestMapping(value = "/organization/update", method = RequestMethod.POST)
	public @ResponseBody Message organizationUpdate(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("30", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To Delete the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/organization/delete", notes = "To delete an organization ")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"),
			@ApiImplicitParam(name = "organization_id  ", value = "Requires the organization id"), })

	@RequestMapping(value = "/organization/delete", method = RequestMethod.POST)
	public @ResponseBody Message organizationDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		
		System.out.println("Coming MAp "+map);
		Message message = operationalService.organizationDelete(map, request, response);
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
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/organization/root/by/user", notes = "Returns state based on country", response = OrganizationRootByUserSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"), })

	@RequestMapping(value = "/organization/root/by/user", method = RequestMethod.POST)
	public @ResponseBody Message organizationRootByUser(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */

		return genericProcess.GenericProcedureCallingMetaData("24", map, request, response);

	}

	/**
	 * To update the user"s organization.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/organization/setting/update", notes = "Returns state based on country")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the ID of user"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization id"),
			@ApiImplicitParam(name = "is_password_expire", value = "Requires int value of is password expire"),
			@ApiImplicitParam(name = "password_expire_time", value = "Requires the duration value of is password expire"),
			@ApiImplicitParam(name = "session_expire_time", value = "Requires int value of session expire time"),
			@ApiImplicitParam(name = "is_session_enable", value = "Requires the int value of is_session enable"),
			@ApiImplicitParam(name = "is_single_sign_on_enable", value = "Requires the int value of is session enable"), })

	@RequestMapping(value = "/organization/setting/update", method = RequestMethod.POST)
	public @ResponseBody Message organizationSettingupdate(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = operationalService.organizationSettingupdate(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}
}
