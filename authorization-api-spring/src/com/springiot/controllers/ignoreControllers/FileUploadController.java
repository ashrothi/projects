/**
 * This package contain the controller class for uploading single or multiple files on server.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.LinkedHashMap;
import java.util.Map;

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
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used to create APIs for for
 * uploading files.
 */
@ApiIgnore
@Controller
@Api(value = "/", description = "Hero Application  For Uploading Files")
public class FileUploadController {
	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private FileUploadService fileUploadService;
	/**
	 * To access functionality of GenericProcess service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Upload File for inserting Data in Database or for reading purpose on
	 * server..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/uploadFile", notes = "To Upload File  For inserting Data in Database")

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadFileHandler(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		// Specific url has permissions
		Message urlValidateMessage = genericProcess.urlValidate(request, response);

		// Check response from message class is not valid
		if (!urlValidateMessage.isValid()) {

			// return the response
			return urlValidateMessage;
		} else {

			// To call the procedure required for data processing.
			Message message = fileUploadService.uploadFile(file);

			// return the response
			return message;
		}
	}

	/**
	 * To Upload multiple files for inserting Data in Database or for reading
	 * purpose on server.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/uploadMultipleFile", notes = "To Upload File  For inserting Data in Database")

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody Message uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	;
		// Specific url has permissions
		Message urlValidateMessage = genericProcess.urlValidate(request, response);

		// Check response from message class is not valid
		if (!urlValidateMessage.isValid()) {

			// return the response
			return urlValidateMessage;
		} else {

			// To call the procedure required for data processing.
			Message message = fileUploadService.uploadMultipleFile(files);

			// return the response
			return message;
		}

	}

	/**
	 * To Upload Image
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/uploadImage", notes = "To Upload Image for Profile", response = UploadImageSwagger.class)

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_name", value = "Requires the file name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "file_data", value = "Requires the file data(text)", required = true, access = "query", paramType = "query") })

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public @ResponseBody Message uploadImageHandler(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Specific url has permissions
		Message urlValidateMessage = genericProcess.urlValidate(request, response);

		// Check response from message class is not valid
		if (!urlValidateMessage.isValid()) {

			// return the response
			return urlValidateMessage;
		} else {

			// To call the procedure required for data processing.

			Message message = fileUploadService.uploadImage(map, request, response);

			// return the response
			return message;
		}
	}
}
