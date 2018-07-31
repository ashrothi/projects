/**
 * This package contains the class in which the main method of this project defined which is used to initialize all the process.
 */
package com.teramatrix.main;

import java.io.File;
import java.io.FileInputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.teramatrix.common.CommonMethods;
import com.teramatrix.initiator.ReportInitiatorClient;
import com.teramatrix.logger.HfclLogger;
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
public class HfclEscalationApp {

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
	 * Variable for storing user key.
	 */
	public static String userKey;
	public static String getDeviceType;
	public static String getDevicesHostStatus;

	public static String dbDriver;
	public static String dbUrl;
	public static String callAttemptPerTrx;
	public static List<String> deviceList;
	public static Boolean voiceStatus;
	public static Boolean dataStatus;
	public static Boolean voiceCapacityStatus;
	public static String sdcchDropRatePerBts;
	public static String uplinkDataThroughput;
	public static String downlinkDataThroughput;
	public static String platforAPI;
	public static long currentTime;
	public static String beforeTime;
	public static String tableName;
	public static String accessKey;
	public static int timeinterval;
	public static DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * Static block is used which will initialize before the main method and set
	 * and initialize the required objects by getting configuration file.
	 */
	static {
		df.setRoundingMode(RoundingMode.CEILING);
		/**
		 * Check Environment variable is null or not, if null then exit from
		 * program.
		 */
		if (System.getenv("HfclReport") == null) {
			System.out.println("Enviourment variable is null.");
			System.exit(1);
		}
		System.out.println("Enviourment variable is:- " + System.getenv("HfclReport"));

	}
	static final GetData getData = new GetData();

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

		if (args[1] == null) {
			System.out.println("Argument is null, Give KPI Time.");
			System.exit(1);
		}
		if (args[2] == null) {
			System.out.println("Argument is null,Table name required.");
			System.exit(1);
		}

		String template = args[0];

		try {
			timeinterval = Integer.parseInt(args[1]);
			tableName = args[2];
			currentTime = Long.parseLong(args[3]);

			System.out.println("End Time " + currentTime);
			beforeTime = args[4];
			System.out.println("From Time " + beforeTime);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("Config file is :" + template);

		/**
		 * Calling method for starting the logger for writing logs to file.
		 */
		HfclLogger.startLogger(template);

		/**
		 * Calling initialize method for getting data from the config file.
		 */
		HfclEscalationApp test = new HfclEscalationApp();
		test.initialize(template);

		/**
		 * Calling method for getting device names and organization details
		 * under a user.
		 */

		deviceList = getData.devicesByUser();
		HfclLogger.logger.info("Device List: " + deviceList);
		ReportInitiatorClient client = new ReportInitiatorClient();
		for (String string : deviceList) {

			CommonMethods commonMethod = new CommonMethods();
			Map<String, Object> platformData = commonMethod.serviceNameDataSourceSum(string);

			// client.start("Voice", string, platformData);
			// client.start("Performance", string, platformData);
			// client.start("VoiceCapacity", string, platformData);
			client.start("BTS", string, platformData);
			client.start("PCU", string, platformData);

		}

		/**
		 * Calling method for getting complete data on a device.
		 */

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
			HfclLogger.logger.info("Inside Initialize method");
			/**
			 * Load data into the code from config file using FileInputStream.
			 */
			properties.load(new FileInputStream(new File(template)));
			System.out.println(properties.stringPropertyNames());
			/**
			 * Getting all data from config file.
			 */
			authApiUrl = properties.getProperty("hfcl.auth.api.url").trim();
			authUserName = properties.getProperty("hfcl.auth.user.name").trim();
			authPassword = properties.getProperty("hfcl.auth.password").trim();
			applicationID = properties.getProperty("hfcl.auth.application.id").trim();
			getDevicesApiUrl = properties.getProperty("hfcl.get.devices.api.url").trim();
			getDeviceType = properties.getProperty("hfcl.get.devices.type").trim();
			getDevicesHostStatus = properties.getProperty("hfcl.get.devices.host.type").trim();
			userKey = properties.getProperty("hfcl.user.key").trim();
			dbDriver = properties.getProperty("hfcl.db.driver").trim();
			dbUrl = properties.getProperty("hfcl.db.url").trim();
			callAttemptPerTrx = properties.getProperty("hfcl.call.attempts.per.trx").trim();
			sdcchDropRatePerBts = properties.getProperty("hfcl.sdcch.drop.rate.per.bts").trim();
			downlinkDataThroughput = properties.getProperty("hfcl.downlink.data.throughput").trim();
			uplinkDataThroughput = properties.getProperty("hfcl.uplink.data.throughput").trim();
			platforAPI = properties.getProperty("hfcl.call.platform.performance.api").trim();
			accessKey = properties.getProperty("hfcl.access.key").trim();
			//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:00");
			//			String date = dateFormat.format(new Date());

			//currentTime = new Date().getTime() ;
			//beforeTime = getData.getBefore(currentTime, timeinterval);

			HfclLogger.logger.info("From Date : " + beforeTime + " End Time : " + currentTime);

		} catch (Exception exception) {

			HfclLogger.logger.info("Exception in Initialize method: " + exception);
			exception.printStackTrace();
		}
	}

}