/**
 * This package contains the class which is used as a controller to create apis for Different Kind Of File Upload.
 */
package com.springiot.controllers;

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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 *  This class work as a controller which is used to create apis for Different Kind Of File Upload.
 * @author Ankita Shrothi
 *
 */
@Controller
public class FileUploadController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * To Upload File For inserting it in Server
	 * 
	 * @param file
	 * @return File Path which is uploaded on server
	 */
	@ApiOperation(value = "/uploadFile", notes = "To Upload File  For inserting Data in Server",response=UploadFileSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadFileHandler(@RequestParam("file") MultipartFile file) {
		Message message = fileUploadService.uploadFile(file);
		return message;
	}

	/**
	 * To Upload Multiple File For inserting it in Server
	 * 
	 * @param files
	 * @return Array for file paths which are uploaded on server
	 */

	@ApiOperation(value = "/uploadMultipleFile", notes = "To Upload File  For inserting Data in Database",response=UploadMultipleFileSwagger.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Record created successfully"),
			@ApiResponse(code = 201, message = " created successfully"),
			@ApiResponse(code = 400, response = Error.class, responseContainer = "List", message = "There was something wrong in the request and therefore could not be processed (headers, json syntax/content)"),
			@ApiResponse(code = 409, message = "ID already taken") })
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {
		Message message = fileUploadService.uploadMultipleFile(files);
		return message;

	}


}
