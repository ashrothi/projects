/**
 * This package contains the class for apis of videos of trips.
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

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.DeviceFrameGetSwagger;
import com.springiot.swagger.response.FtpDetailsGetSwagger;
import com.springiot.swagger.response.GenericThirdPartyInsertUpdateDeleteSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class works as controller for APIs for managing the video of the TRIP.
 * 
 * @author Mandeep Singh
 * @creation_date : 27-03-2018 
 */
@Controller
public class VideoController {
	
	@Autowired
	private GenericProcess genericProcess;
	
	/**
	 * To get the device frames on the basis of device id and 
	 * trip start time and trip end time.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/frame/get", notes = "To get the device frames on the basis of vehicle id and trip start time.", response = DeviceFrameGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires device id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_start", value = "Requires trip start time.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_time", value = "Requires  start time.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_time", value = "Requires end time.", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/device/frame/get", method = RequestMethod.POST)
	public @ResponseBody Message deviceFrameGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("23", map, null, request, response);
		return message;
	}

	/**
	 * To insert the video of trip on the basis of vehicle id and trip start
	 * time and trip end time.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/device/frame/insert", notes = "To insert the device frames on the basis of vehicle id and trip start time.", response = GenericThirdPartyInsertUpdateDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Requires device id for which frame is inserting.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "number_of_frames", value = "Requires number of frames.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "folder_path", value = "Requires path of the folder.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "trip_start", value = "Requires trip start time.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "file_name", value = "Requires name of file to insert.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_time", value = "Requires end time of video frame.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/device/frame/insert", method = RequestMethod.POST)
	public @ResponseBody Message deviceFrameInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("24", map, null, request, response);
		return message;
	}
	
	/**
	 * To get the details of ftp server.
	 * time and trip end time.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/ftp/details/get", notes = "To get the details of ftp server.", response = FtpDetailsGetSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/ftp/details/get", method = RequestMethod.POST)
	public @ResponseBody Message ftpDetailsGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("22", map, null, request, response);
		return message;
	}
}
