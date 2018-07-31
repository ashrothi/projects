/**
 * This package contains the class in which the main method of this project defined which is used to initialize all the process.
 */
package com.teramatrix.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.teramatrix.logger.FftLogger;
import com.teramatrix.processData.GetData;

/**
 * This class is main class of this project here initialize all required objects
 * like logger , printstream etc. In main method Initialize the process. The
 * environment variables are also set from here. All classes are invoked from
 * this class. Config file is also imported in this class.
 * 
 * @author Mandeep Singh
 *
 */
public class FftEscalationApp {

	/**
	 * Variable for storing Xfusion Authorization API url.
	 */
	public static String authApiUrl;
	/**
	 * Variable for storing Xfusion Authorized username.
	 */
	public static String authUserName;
	/**
	 * Variable for storing password of user.
	 */
	public static String authPassword;
	/**
	 * Variable for storing Xfusion application id.
	 */
	public static String applicationID;

	/**
	 * Variable for storing API url for getting devices of a user.
	 */
	public static String getDevicesApiUrl;
	/**
	 * Variable for storing API url for getting all the data.
	 */
	public static String getDataApiUrl;

	/**
	 * Variable for storing user key.
	 */
	public static String userKey;

	/**
	 * Variable for storing access key.
	 */
	public static String accessKey;

	/**
	 * Variable for storing service names.
	 */
	public static String serviceNames;
	/**
	 * Variable for storing data sources.
	 */
	public static String dataSources;

	/**
	 * Variable for storing data sources for trips.
	 */
	public static String authThirdPartyApiUrl;

	/**
	 * Variable for getting devices to send Escalation.
	 */
	public static String escalationDevicesApiUrl;
	/**
	 * Variable for inserting data after sending Escalation.
	 */

	public static String insertDevicesEscalationApiUrl;
	/**
	 * Variable for update device Online Time.
	 */
	public static String updateDevicesApiUrl;
	public static String deviceList;
	public static String deviceSendEscalation;

	/**
	 * Static block is used which will initialize before the main method and set
	 * and initialize the required objects by getting configuration file.
	 */
	static {

		/**
		 * Check Environment variable is null or not, if null then exit from
		 * program.
		 */
		if (System.getenv("FftReport") == null) {
			System.out.println("Enviourment variable is null.");
			System.exit(1);
		}
		System.out.println("Enviourment variable is:- " + System.getenv("FftReport"));

	}

	/**
	 * This is the main method of project. Here we get the argument variable.
	 * Then invoke all the methods defined in this class by making objects.
	 * 
	 * @param args
	 *            : Here pass path of config file
	 */
	public static void main(String[] args) {

		if (args[0] == null) {
			System.out.println("Argument is null, Give path of config file.");
			System.exit(1);
		}

		String template = args[0];

		System.out.println("Config file is :" + template);

		/**
		 * Calling method for starting the logger for writing logs to file.
		 */
		FftLogger.startLogger(template);

		/**
		 * Calling initialize method for getting data from the config file.
		 */
		FftEscalationApp test = new FftEscalationApp();
		test.initialize(template);

		/**
		 * Calling method for getting device names and organization details
		 * under a user.
		 */
		GetData getdata = new GetData();
		deviceList = getdata.devicesByUser();

		/**
		 * Calling method for getting complete data on a device.
		 */
		getdata.performaceServiceData(deviceList);

		getdata.sendEscalation();

		System.exit(0);

	}

	/**
	 * This method is used for initializing the project by getting the details
	 * from template file.
	 * 
	 * @param template
	 *            : path of template config file in which all dynamic data is
	 *            defined.
	 */
	public void initialize(String template) {

		/**
		 * Object creation of properties.
		 */
		Properties properties = new Properties();
		try {
			FftLogger.logger.info("Inside Initialize method");
			/**
			 * Load data into the code from config file using FileInputStream.
			 */
			properties.load(new FileInputStream(new File(template)));

			/**
			 * Getting all data from config file.
			 */
			authApiUrl = properties.getProperty("fft.auth.api.url").trim();
			authUserName = properties.getProperty("fft.auth.user.name").trim();
			authPassword = properties.getProperty("fft.auth.password").trim();
			applicationID = properties.getProperty("fft.auth.application.id").trim();
			authThirdPartyApiUrl = properties.getProperty("fft.auth.third.party.url").trim();
			getDevicesApiUrl = properties.getProperty("fft.get.devices.api.url").trim();
			getDataApiUrl = properties.getProperty("fft.get.data.api.url").trim();
			userKey = properties.getProperty("fft.user.key").trim();
			accessKey = properties.getProperty("fft.access.key").trim();
			serviceNames = properties.getProperty("fft.service.names");
			dataSources = properties.getProperty("fft.data.sources");
			escalationDevicesApiUrl = properties.getProperty("fft.get.escalation.devices.api.url").trim();
			insertDevicesEscalationApiUrl = properties.getProperty("fft.get.insert.devices.escalation.api.url").trim();
			updateDevicesApiUrl = properties.getProperty("fft.update.devices.api.url").trim();
			deviceSendEscalation = properties.getProperty("fft.devices.sos.api.url").trim();

		} catch (Exception exception) {

			FftLogger.logger.info("Exception in Initialize method: " + exception);
			exception.printStackTrace();
		}
	}
}