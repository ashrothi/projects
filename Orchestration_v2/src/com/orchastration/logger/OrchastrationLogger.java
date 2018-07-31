/**
 * This package contains the class in which the process done to initialize and write into the log files.
 */
package com.orchastration.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

/**
 * This class is used for writing logs into the external files at provided path.
 * 
 * @author Sachin Nahar
 *
 */
public class OrchastrationLogger {

	/**
	 * Initializing the logger object.
	 */
	public static Logger logger;
	/**
	 * Initializing the logger object.
	 */
	public static PrintStream printStream;

	/**
	 * This is the default constructor of the class.
	 */
	public OrchastrationLogger() {

	}

	/**
	 * This method is used for starting the logger. This will create the log files and
	 * error log files and set the name of file with current date and time into the name.
	 * Also this method initialize the logger and printstream objects. 
	 * @return logger object to writing information into files.
	 */
	public static Logger startLogger() {

		/**
		 * Generating the format in which date is required.
		 */
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
		Date date = new Date();
		String datefor = dateFormat.format(date);

		logger = Logger.getLogger("MyLog");

		/**
		 * Checking the logger status and Initializing the logger for writing the logs information to the files.
		 */
		if (getLoggerStatus()) {

			PropertyConfigurator.configure(System.getenv("Orchastration_Engine")
					+ "/" + "log4j.properties");
			Appender appender = null;
			try {
				appender = new FileAppender(new SimpleLayout(), System.getenv("Orchastration_Engine") 
						+ "/log/MyLogFile" + datefor + ".log");
				logger.addAppender(appender);
				appender.setLayout(new SimpleLayout());
			} catch (SecurityException exception) {
					exception.printStackTrace();
			} catch (IOException exception) {
					exception.printStackTrace();
			}
		}

		try {

			/**
			 * Initializing the logger for writing the errors information to the files.
			 */
			printStream = new PrintStream(new FileOutputStream(new File(System.getenv("Orchastration_Engine") 
					+ "/log/MyErrorLogFile" + datefor + ".log")));
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		return logger;
	}

	/**
	 * This method is used to get the status from the config file and returning permission either for writing or for not.
	 * @return, logger status true or false to allow writing into files.
	 */
	private static boolean getLoggerStatus() {

		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(System.getenv("Orchastration_Engine")
						+ "/template/sample.conf"));
			String loggerStatus = properties.getProperty(
						"logger.status").trim();
			System.out.println("logger status:-" + loggerStatus);
			if (loggerStatus.equals("1")) {
				return true;
			}

			return false;

		} catch (Exception exception) {

			exception.printStackTrace();
			return false;
		}
	}
}