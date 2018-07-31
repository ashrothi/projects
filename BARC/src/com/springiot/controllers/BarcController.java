package com.springiot.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.MediaUrlServices;
import com.springiot.swagger.response.UploadImageSwagger;
import com.springiot.swagger.response.XfusionUsersGetApiAccessSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class is a controller class used for the voot demo application.
 */
@Controller
@PropertySource(value = "classpath:/config.properties")
public class BarcController {
	@Autowired
	Environment environment;

	// Access the functionality of some other class.
	@Autowired
	private GenericProcess genericProcess;

	// Access the functionality of some other class.
	@Autowired
	private MediaUrlServices mediaUrlService;;

	/**
	 * This api is used to ping the barc server and returns the success or
	 * failure response.
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@ApiOperation(value = "/barc/ping/server", notes = "This API is used to ping server to inform that the media URL was accessed locally using cache ", response = XfusionUsersGetApiAccessSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "media_url", value = "Requires the media url", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_name", value = "Requires the application name", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_version", value = "Requires the version of app", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ad_duration", value = "Requires the duration of ad", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_agent", value = "Requires the agent of user", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires the location latitude", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the location longitude", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "hash_code", value = "Requires the hash code", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "tiny_url", value = "Requires the tiny url", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ad_click_url", value = "Requires the ad click through url", required = false, paramType = "query", dataType = "String") })

	@RequestMapping(value = "/barc/ping/server", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, String> map) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = mediaUrlService.pingServer(map, req, res);

		return message;

	}

	/**
	 * This API is used to return hashcode for the respective media url.
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "/barc/get/hashcode", notes = "This API helps to retrieve unique hash code and tiny url associated with media URL. ", response = UploadImageSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Requires the access tokem", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "media_url", value = "Requires the media url", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_name", value = "Requires the application name", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_version", value = "Requires the version of app", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ad_duration", value = "Requires the duration of ad", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_agent", value = "Requires the agent of user", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires the location latitude", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the location longitude", required = false, paramType = "query", dataType = "String") })

	@RequestMapping(value = "/barc/get/hashcode", method = RequestMethod.POST)
	public @ResponseBody Message getHashcode(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) throws Exception {

		Message message = mediaUrlService.getHashCode(map, req, res);
		return message;
	}

	/**
	 * This API is used to return hashcode for the respective media url.
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "/fingerprint/ack", notes = "This API helps to retrieve unique hash code and tiny url associated with media URL. ", response = UploadImageSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Requires the access tokem", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "Id", value = "Requires Id", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "RequestId", value = "Requires the RequestId", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "Url", value = "Requires Url", required = false, paramType = "query", dataType = "String") })

	@RequestMapping(value = "/fingerprint/ack", method = RequestMethod.POST)
	public @ResponseBody Message fingerPrintAck(@RequestBody String data, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Map<String, Object> map = new ObjectMapper().readValue(data, Map.class);

		LinkedHashMap<String, Object> finalMap = new LinkedHashMap<>();
		finalMap.put("hascode", map.get("RequestId"));
		finalMap.put("video_id", map.get("Id"));
		finalMap.put("Status", map.get("Status"));
		Message Responsemessage = genericProcess.GenericProcedureCalling("15", finalMap, req, res);
		return Responsemessage;
	}
}
