/**
 * This package contain the controller class for File Upload of different type.
 */
package com.springiot.controllers;
/**
 * To Import Classes to access their functionality
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springiot.response.Message;
import com.springiot.services.FileUploadService;
import com.springiot.swagger.response.UploadFileSwagger;
import com.springiot.swagger.response.UploadMultipleFileSwagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * This class work as a controller which is used to create apis for File Upload of different type.
 * @author Ankita Shrothi
 *
 */
@Controller
@Api(value = "/", description = "Hero Application  For Uploading Files")
public class FileUploadController {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * To Upload File For inserting Data in Database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/uploadFile", notes = "To Upload File  For inserting Data in Database",response=UploadFileSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadFileHandler(@RequestParam("file") MultipartFile file) {
		Message message = fileUploadService.uploadFile(file);
		return message;
	}

	/**
	 * To Upload Multiple File For inserting Data in Database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */

	@ApiOperation(value = "/uploadMultipleFile", notes = "To Upload File  For inserting Data in Database",response=UploadMultipleFileSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {
		Message message = fileUploadService.uploadMultipleFile(files);
		return message;

	}

}
