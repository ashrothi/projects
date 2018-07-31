/**
 * This package contain the controller class for uploading files using FTP connection.
 */
package com.springiot.controllers.ignoreControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springiot.response.Message;
import com.springiot.services.FTPFileUploadService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class is used for uploading files using FTP
 *         connection.
 *
 */

@ApiIgnore
@Controller
public class FTPFileUploadController {
	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private FTPFileUploadService fileUploadService;

	/**
	 * To Upload File for inserting Data in Database.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/upload/firmware/file", notes = "To Upload File for inserting Data in Database")
	
	@RequestMapping(value = "/upload/firmware/file", method = RequestMethod.POST)
	public @ResponseBody Message uploadFirmwareFileHandler(@RequestParam("file") MultipartFile file) throws Exception {
		Message message = fileUploadService.uploadFTPFile(file);

		return message;
	}
}
