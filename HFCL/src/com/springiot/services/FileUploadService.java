/**
 * This package contain the Service class for All Third Party Application for HFCL
 */
package com.springiot.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for fileUpload for different kind of Files
 * like Multipart file,Multiple Files or File uploaded to a ftp Location after
 * calling Platform API
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class FileUploadService {

	/**
	 * To Upload Single Multipart File
	 * 
	 * @param file
	 * @return file Path where file was uploaded
	 */
	public Message uploadFile(MultipartFile file) {

		/**
		 * Initializing Response Object
		 */
		Message message = new Message();

		try {
			// String name = file.getName();

			/**
			 * To get Original Filename with Its Path
			 */
			String name = file.getOriginalFilename();
			/**
			 * Printing its Original name
			 */
			System.out.println("File Name:- " + name);

			/**
			 * Check weather file is Empty or not
			 */
			if (!file.isEmpty()) {
				/**
				 * Getting file bytes in byte array
				 */
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				/**
				 * Get Path for Write File On Server
				 */
				String rootPath = System.getProperty("catalina.home");
				/**
				 * Printing the Root Path
				 */
				System.out.println("root Path:- " + rootPath);

				/**
				 * To create the File on server and Check if its Exist
				 */
				File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
				/**
				 * Checking If directory Exist if no than create new one else
				 * overwrite the file
				 */
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server and writes every byte in it
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				/**
				 * Success Message with New File Loacation
				 */
				System.out.println("Server File Location=" + serverFile.getCanonicalPath());

				message.setDescription("You successfully uploaded file=" + name);
				message.setObject(serverFile.getAbsolutePath());
				message.setValid(true);
				return message;

			} else {
				/**
				 * Error Response Message when file is Empty or format is not
				 * Write
				 */
				message.setDescription("You failed to upload " + name + " because the file was empty.");
				message.setValid(false);
				return message;
			}
		} catch (Exception e) {
			/**
			 * To Catch exception if it comes
			 */
			e.printStackTrace();

		}
		/**
		 * Error Message when issue in uploading File
		 */
		message.setDescription("Issues With File Upload");
		message.setValid(false);
		return message;
	}

	/**
	 * To Upload Multiple Files
	 * 
	 * @param files
	 * @return
	 */
	public Message uploadMultipleFile(MultipartFile[] files) {
		/**
		 * Initializing Response Object
		 */
		Message message = new Message();
		try {
			/**
			 * To Store Multiple Paths in array list
			 */
			List<Map<String, String>> FinalList = new ArrayList<>();
			/**
			 * To Get Each File To write it in Server
			 * 
			 */
			for (int i = 0; i < files.length; i++) {
				/**
				 * To get each file
				 */
				MultipartFile file = files[i];
				// String name = file.getName();

				/**
				 * To get Original Filename with Its Path
				 */
				Map<String, String> map = new HashMap<>();
				/**
				 * To get File Name
				 */
				String name = file.getOriginalFilename();
				/**
				 * To Print File Name
				 */
				System.out.println("File Name:- " + name);

				try {
					/**
					 * To get file bytes in byte array
					 */
					byte[] bytes = file.getBytes();

					/**
					 * Get Path for Write File On Server
					 */
					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					/**
					 * To Print root Path
					 */
					System.out.println("root Path:- " + rootPath);
					/**
					 * To create the File on server and Check if its Exist
					 */
					File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
					/**
					 * Checking If directory Exist if no than create new one
					 * else overwrite the file
					 */
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server and writes every byte in it
					File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					/**
					 * Success Message with New File Loacation
					 */
					System.out.println("Server File Location=" + serverFile.getAbsolutePath());

					map.put("name", name);
					map.put("path", serverFile.getAbsolutePath());
					FinalList.add(map);

				} catch (Exception e) {
					/**
					 * Error Response Message when file is Empty or format is
					 * not Write
					 */
					map.put(name, "Issues With File Upload" + "===" + e.getMessage());
					message.setDescription("You Files upload Error." + e.getMessage());
					message.setObject(map);
					message.setValid(false);
					return message;
				}

			}
			/**
			 * Success Message with New Multiple File Location with their
			 * locations
			 */
			message.setDescription("You Files upload Successfully.");
			message.setObject(FinalList);
			message.setValid(true);
			return message;

		} /**
			 * To Catch exception if it comes
			 */
		catch (Exception e) {

		}
		/**
		 * Error Message when issue in uploading File
		 */
		message.setDescription("Issues With File Upload");
		message.setValid(false);
		return message;
	}

}
