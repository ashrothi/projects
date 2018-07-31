/**
 * This package contain the service class for upload files.
 */
package com.springiot.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springiot.response.Message;

/**
 * This class is defined as service which is used to upload files.
 * 
 * @author tanvigarg
 */
@Service
public class FileUploadService {

	public Message uploadFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Create the object of class Message.
		 */
		Message message = new Message();

		try {
			// String name = file.getName();

			/*
			 * To get Original Filename with Its Path
			 */
			String name = file.getOriginalFilename();

			/*
			 * Check whether file is Empty or not
			 */
			if (!file.isEmpty()) {

				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				/*
				 * Get Path for Write File On Server
				 */
				String rootPath = System.getProperty("catalina.home");

				/*
				 * To create the File on server and Check if its Exist
				 */
				File dir = new File(rootPath + File.separator + "webapps/tmpFiles");

				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server and writes every byte in it
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				/*
				 * Set success message with new File location
				 */
				message.setDescription("You successfully uploaded file=" + name);
				message.setObject(serverFile.getAbsolutePath());
				message.setValid(true);
				/*
				 * Return the response message.
				 */
				return message;

			} else {
				/*
				 * Set failure message.
				 */
				message.setDescription("You failed to upload " + name + " because the file was empty.");
				message.setValid(false);
				/*
				 * Return the response message.
				 */
				return message;
			}
		} catch (Exception e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
	}

	/**
	 * This method is used to upload multiple files together.
	 * 
	 * @param files,contains
	 *            the files which needs to be uploaded.
	 * @return
	 * @throws Exception
	 */
	public Message uploadMultipleFile(MultipartFile[] files) throws Exception {

		Message message = new Message();
		try {

			List<Map<String, String>> FinalList = new ArrayList<>();

			for (int i = 0; i < files.length; i++) {

				MultipartFile file = files[i];
				// String name = file.getName();

				/*
				 * To get Original Filename with Its Path
				 */
				Map<String, String> map = new HashMap<>();
				String name = file.getOriginalFilename();

				try {
					byte[] bytes = file.getBytes();

					/*
					 * Get Path for Write File On Server
					 */
					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");

					/*
					 * To create the File on server and Check if its Exist
					 */
					File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server and writes every byte in it
					File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					/*
					 * Success Message with New File Location
					 */

					map.put("name", name);
					map.put("path", serverFile.getAbsolutePath());
					FinalList.add(map);

				} 
				// Handling all exceptions
				catch (Exception e) {
					map.put(name, "Issues With File Upload" + "===" + e.getMessage());
					message.setDescription(e.getMessage());
					message.setObject(map);
					message.setValid(false);
					return message;
				}

			}

			// Set the response message
			message.setDescription("You Files upload Successfully.");
			message.setObject(FinalList);
			message.setValid(true);
			return message;

		} 
		// Handling all exceptions
		catch (Exception e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}
}