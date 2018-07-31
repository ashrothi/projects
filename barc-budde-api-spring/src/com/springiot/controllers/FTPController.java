/**
 * This package contain the controller class for Third Party Application apis.
 */
package com.springiot.controllers;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shell.ShellScriptExecutor;
import com.springiot.constant.CustomerService;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.CityGetByStateIdSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * for File Operations Application
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class FTPController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private CustomerService customerService;

	/**
	 * To insert the ftp server
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

	@ApiOperation(value = "/org/server/insert", notes = "To insert the ftp server ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "server_name", value = "Requires server_name of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_user", value = "Requires the ftp_user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_password", value = "Requires the ftp_password", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_url", value = "Requires the ftp_url", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_port", value = "Requires the ftp_port", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "mac_address", value = "Requires the mac_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ip_address", value = "Requires the ip_address", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/org/server/insert", method = RequestMethod.POST)
	public @ResponseBody Message orgServerInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("9", map, null, request, response);

		if (message.isValid()) {

			String[] argument = { map.get("ftp_user"), map.get("ftp_password"), "groupName" };

			String logo = customerService.getResource("classpath:template/group_user_genrator.sh").getFile()
					.getAbsolutePath();
			ShellScriptExecutor.runScript(logo, argument);
		}
		return message;
	}

	/**
	 * To update the ftp server detail
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

	@ApiOperation(value = "/org/server/update", notes = "To update the ftp server detail ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "server_name", value = "Requires org_idy of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_user", value = "Requires the ftp_user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_password", value = "Requires the ftp_password", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_url", value = "Requires the ftp_url", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ftp_port", value = "Requires the ftp_port", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "mac_address", value = "Requires the mac_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ip_address", value = "Requires the ip_address", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/org/server/update", method = RequestMethod.POST)
	public @ResponseBody Message orgServerUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */

		Message message = genericProcess.GenericProcedureCalling("10", map, null, request, response);
		if (message.isValid()) {
			String[] argument = { map.get("ftp_user"), map.get("ftp_password"), "groupName" };

			String logo = customerService.getResource("classpath:template/resetPassword.sh").getFile()
					.getAbsolutePath();
			ShellScriptExecutor.runScript(logo, argument);
		}
		return message;
	}

	/**
	 * To delete ftp server
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

	@ApiOperation(value = "/org/server/delete", notes = "To delete ftp server ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id of user", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/org/server/delete", method = RequestMethod.POST)
	public @ResponseBody Message orgServerDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("11", map, null, request, response);
		return message;
	}

	/**
	 * To get all ftp server details of the given organization.
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

	@ApiOperation(value = "/org/server/get/by/org/id", notes = "To get all ftp server details of the given organization. ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires org_id of user", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/org/server/get/by/org/id", method = RequestMethod.POST)
	public @ResponseBody Message orgServerGetByOrgId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("12", map, null, request, response);
		return message;
	}

	/**
	 * To get all Ftp server
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

	@ApiOperation(value = "/get/study/by/userkey", notes = "To get all Ftp server  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/get/study/by/userkey", method = RequestMethod.POST)
	public @ResponseBody Message getStudyByUserkey(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("50", map, null, request, response);
		List<Object> list = new LinkedList<>();

		Map<String, Object> time = new LinkedHashMap<>();
		time.put("currentTime", new Date().getTime());
		list.add(time);
		message.setList(list);
		return message;
	}

	/**
	 * To get all ftp server details of the given organization.
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

	@ApiOperation(value = "/is/ftp/user/exists", notes = "To get all ftp server details of the given organization. ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ftp_user", value = "Requires ftp_user of org", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/is/ftp/user/exists", method = RequestMethod.POST)
	public @ResponseBody Message isFtpUserExist(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("84", map, null, request, response);
		return message;
	}

}
