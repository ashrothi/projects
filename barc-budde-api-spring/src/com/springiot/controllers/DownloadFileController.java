package com.springiot.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.springiot.services.DownloadServices;
import com.springiot.services.GenericProcess;

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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

public class DownloadFileController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private DownloadServices downloadService;

	
	/**
	 * To download the config File contains ftp details.
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
	 *//*
	@ApiOperation(value = "/org/config/download", notes = "To download the config Fil contains ftp details.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Requires the org id", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/org/config/download", method = RequestMethod.POST)
	public @ResponseBody Message orgConfigDownload(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message=downloadService.downloadOrgConfig(map, request, response);

	//	Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
		return message;
	}
*/
}
