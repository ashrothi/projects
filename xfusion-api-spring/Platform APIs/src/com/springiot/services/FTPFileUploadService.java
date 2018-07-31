/**
 * This package contain the service class for uploading specific FTP files.
 */
package com.springiot.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springiot.response.Message;

/**
 * This class is defined as service which is used to upload files.
 * 
 * @author tanvigarg
 */
@Service
@PropertySource(value = "/WEB-INF/download.properties")
public class FTPFileUploadService {
	// FTPFileUploadService ftpobj=new FTPFileUploadService();
	@Autowired
	Environment env;

	FTPClient ftp = null;

	// Constructor to connect to the FTP Server
	public boolean FTPLogin(String host, int port, String username, String password) {
		try {
			ftp = new FTPClient();
			ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
			int reply;
			ftp.connect(host, port);

			reply = ftp.getReplyCode();
			ftp.login(username, password);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				// throw new Exception("Exception in connecting to FTP Server");
				return false;
			}

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

	}

	// Method to upload the File on the FTP Server
	public boolean uploadFTPFile(String localFileFullName, String fileName, String hostDir) throws Exception {

		try {
			InputStream is = new ByteArrayInputStream(localFileFullName.getBytes());
			// InputStream input = new FileInputStream(new
			// File(localFileFullName));

			boolean check = this.ftp.storeFile(hostDir + fileName, is);
			if (check) {

				disconnect();
				return true;

			} else {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void disconnect() {
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				// do nothing as file is already saved to server
			}
		}
	}

	public Message uploadFTPFile(MultipartFile file) throws Exception {
		/*
		 * Create the object of class Message.
		 */
		Message message = new Message();
		// get an ftpClient object
		// FTPClient ftpClient = new FTPClient();
		// FileInputStream inputStream = null;

		try {
			// String name = file.getName();

			/*
			 * To get Original Filename with Its Path
			 */
			String name = file.getOriginalFilename();

			String fileLocaltion = "./";
			if (!file.isEmpty()) {

				List<Object> dataFromConfigFile = readConfig();

				// Read the variables from config file
				String hostName = dataFromConfigFile.get(0).toString();
				int port = Integer.parseInt(dataFromConfigFile.get(1).toString());
				String username = dataFromConfigFile.get(2).toString();
				String password = dataFromConfigFile.get(3).toString();

				boolean check = FTPLogin(hostName, port, username, password);
				if (check) {
					boolean checkUpload = uploadFTPFile(name, name, fileLocaltion);
					if (checkUpload) {
						/*
						 * Set success message with new File location
						 */
						message.setDescription("You have successfully uploaded file");
						message.setObject("File Location " + fileLocaltion + name);
						message.setValid(true);
						/*
						 * Return the response message.
						 */
						return message;
					} else {
						/*
						 * Set success message with new File location
						 */
						message.setDescription("Fail to upload file");
						message.setObject("File Location " + fileLocaltion + name);
						message.setValid(true);
					}
				} else {
					/*
					 * Set failure message.
					 */
					message.setDescription("FTP Login Fail.. Please try again");
					message.setValid(false);
					/*
					 * Return the response message.
					 */
					return message;
				}

			} else {
				/*
				 * Set failure message.
				 */
				message.setDescription("Failed to upload " + name + " because the file was empty.");
				message.setValid(false);
				/*
				 * Return the response message.
				 */
				return message;
			}

		}
		// Handling all exceptions
		catch (Exception e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}

		// set the response message
		message.setDescription("Issues With File Upload");
		message.setValid(false);
		return message;
	}

	/**
	 * this method is used to read config file
	 * 
	 */
	public List<Object> readConfig() {

		List<Object> inputParameters = new ArrayList<>();
		String hostName = env.getProperty("host.name");
		String port = env.getProperty("port");
		String username = env.getProperty("username");
		String password = env.getProperty("password");

		// append the values in arraylist
		inputParameters.add(hostName);
		inputParameters.add(port);
		inputParameters.add(username);
		inputParameters.add(password);

		return inputParameters;

	}
}