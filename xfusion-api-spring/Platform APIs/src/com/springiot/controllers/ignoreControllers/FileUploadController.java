/**
 * This package contain the controller class for uploading files.
 */
package com.springiot.controllers.ignoreControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springiot.response.Message;
import com.springiot.services.FileUploadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         APIs for for uploading files.
 */
@ApiIgnore
@Controller
@Api(value = "/", description = "Xfusion platform controller for uploading files")
public class FileUploadController {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * To Upload File for inserting Data in Database.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/uploadFile", notes = "To Upload File for inserting Data in Database")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadFileHandler(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To upload the file, call the method which is created to upload the
		 * file.
		 */
		Message message = fileUploadService.uploadFile(file, request, response);

		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * To Upload multiple files for inserting Data in Database.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/uploadMultipleFile", notes = "To Upload multiple files for inserting Data in Database")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device") })

	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files)
			throws Exception {
		/*
		 * To upload multiple files, call the method which is created to upload
		 * multiple files.
		 */
		Message message = fileUploadService.uploadMultipleFile(files);
		/*
		 * Return the response message.
		 */
		return message;
	}
}