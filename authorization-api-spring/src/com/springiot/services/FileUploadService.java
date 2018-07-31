/**
 * This package contains the classes used to perform a service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springiot.response.Message;

/**
 * This service class is used to upload single or multiple files on server and
 * image on tomcat server.
 * 
 * @author tanvigarg
 *
 */
@Service
public class FileUploadService {

	/**
	 * This method is used to upload the single file on tomcat server
	 * 
	 * @param file,the
	 *            input file which needs to upload.
	 * 
	 * 			@return, return the file path if success,else return the
	 *            exception
	 */
	public Message uploadFile(MultipartFile file) {
		// Initializing of message class
		Message message = new Message();

		try {
			// Get the original file name
			String name = file.getOriginalFilename();

			// Check if file which needs to upload is not empty
			if (!file.isEmpty()) {

				byte[] bytes = file.getBytes();

				// Get the root path of tomcat server
				String rootPath = System.getProperty("catalina.home");
				// System.out.println("root Path:- " + rootPath);

				// Set the file Directory/Path on tomcat server
				File fileDirectory = new File(rootPath + File.separator + "webapps/tmpFiles");

				// If File Directory does not exists
				if (!fileDirectory.exists())
					fileDirectory.mkdirs();

				// Create the file on server and writes every byte in it
				File serverFile = new File(fileDirectory.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				// Set the success message
				message.setDescription("You successfully uploaded file=" + name);
				message.setObject(serverFile.getAbsolutePath());
				message.setValid(true);
				return message;

			} else {
				// Set the failure message
				message.setDescription("You failed to upload " + name + " because the file was empty.");
				message.setValid(false);
				return message;
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure message
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
	}

	/**
	 * This method is used to upload multiple files on tomcat server
	 * simultaneously.
	 * 
	 * @param files,the
	 *            input files which needs to be uploaded.
	 * 
	 * 			@return, return the file path if success,else return the
	 *            exception
	 */
	public Message uploadMultipleFile(MultipartFile[] files) {

		// Initializing of message class
		Message message = new Message();
		try {

			// Initializing of List<Map>
			List<Map<String, String>> FinalList = new ArrayList<>();

			// For lop is used to upload multiple files on tomcat server
			for (int i = 0; i < files.length; i++) {

				// Mutiple files to upload simultaneously
				MultipartFile file = files[i];

				// Initializing of map
				Map<String, String> map = new HashMap<>();

				// Get the original file name
				String name = file.getOriginalFilename();

				try {
					byte[] bytes = file.getBytes();

					// Get the root path of tomcat server
					String rootPath = System.getProperty("catalina.home");

					// System.out.println("root Path:- " + rootPath);

					// Set the file Directory/Path on tomcat server
					File fileDirectory = new File(rootPath + File.separator + "webapps/tmpFiles");
					if (!fileDirectory.exists())
						fileDirectory.mkdirs();

					// Create the file on server and writes every byte in it
					File serverFile = new File(fileDirectory.getAbsolutePath() + File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					// Set the success message
					map.put("name", name);
					map.put("path", serverFile.getAbsolutePath());
					FinalList.add(map);

				} catch (Exception e) {
					map.put(name, "Issues With File Upload" + "===" + e.getMessage());
					// Set the failure message
					message.setDescription("You Files upload Error." + e.getMessage());
					message.setObject(map);
					message.setValid(false);
					return message;
				}
			}

			// Set the success message
			message.setDescription("You Files upload Successfully.");
			message.setObject(FinalList);
			message.setValid(true);
			return message;

		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure message
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
	}

	/**
	 * This method is used to convert base64 input to an image.Base64 is
	 * input,which is actually a cropped image input.
	 * 
	 * @param map,
	 *            contains the input parameters including file_name and
	 *            file_data.
	 */
	public Message uploadImage(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		// Initializing the message
		Message message = new Message();

		try {

			// Get the file data
			String fileData = map.get("file_data");

			// Split the data with the comma
			String base64Image = fileData.split(",")[1];

			// Convert the base64 input to binary
			byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);

			BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

			// Manipulations in File Name
			String fileName = map.get("file_name");
			String file = fileName.substring(0, fileName.indexOf("."));
			String fileExtension = fileName.substring(fileName.indexOf("."));


			// Get the current time
			Long time = new Date().getTime();

			// Write the file name with the current time to avoid redundancy
			String maniputedFileName = file + "" + time + fileExtension;

			// Check if file name is not empty
			if (!maniputedFileName.isEmpty()) {

				// Get the root path of tomcat server
				String rootPath = System.getProperty("catalina.home");

				// System.out.println("root Path:- " + rootPath);

				// File Directory/Path on tomcat server
				File fileDirectory = new File(rootPath + File.separator + "webapps/tmpFiles");

				// System.out.println("fileDirectory" +
				// fileDirectory.getPath());
				// If file direcory does not exist
				if (!fileDirectory.exists())
					fileDirectory.mkdirs();

				File outputfile = new File(fileDirectory.getAbsolutePath() + File.separator + maniputedFileName);

				// File fileStoredinLocal = new File(rootPath + File.separator +
				// "webapps/" + request.getContextPath()
				// + File.separator + "resources/images/" + maniputedFileName);

				// Write created image on server
				// ImageIO.write(image, "png", fileStoredinLocal);
				ImageIO.write(image, "png", outputfile);

				// Set the success message
				message.setDescription("You successfully uploaded file=" + maniputedFileName);
				message.setObject(outputfile.getAbsolutePath());
				message.setValid(true);
				return message;

			}
			// Set the failure message
			else {
				message.setDescription("You failed to upload " + maniputedFileName + " because the file was empty.");
				message.setValid(false);
				return message;
			}
		}
		// Handling all exceptions
		catch (IOException e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}
}