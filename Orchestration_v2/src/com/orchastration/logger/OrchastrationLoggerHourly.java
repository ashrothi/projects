/**
 * This is basic class for project, here defined all basic variables, like logger, printstream object.
 */
package com.orchastration.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

/**
 * In this class defined the basic variables like logger, print stream etc. Here
 * Initialize the logger and create the log file as according to date and time.
 * Here used apache lib. for logger. Here also initialize the printstream object
 * for write the error in log file. This object is used in
 * "exception.printStrakTrace()" for write the Exception in error log file.
 * 
 * @author sachin nahar
 */
public class OrchastrationLoggerHourly {

	/**
	 * This field is used for logger initialize, logger is used for append
	 * console output in file.
	 */
	public static Logger logger;

	/**
	 * This field is used for printstream object initialize, printstream is used
	 * for append Exceptions in error file.
	 */
	public static PrintStream printStream;

	/**
	 * This is default constructor for class Logger which initialize the
	 * class which defined the basic variables like logger, print stream etc.
	 */
	public OrchastrationLoggerHourly() {

	}

	/**
	 * 
	 * @return
	 */
	public static Logger startLoggerUpdate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH");
		Date date = new Date();
		String datefor = dateFormat.format(date);
		
		//logger = Logger.getLogger("MyLog");
		
		if (getLoggerStatus()) {
			
			/*// Set the log4j.properties file
			PropertyConfigurator.configure(System.getenv("Orchastration_Engine")
					+ "/" + "log4j.properties");
			try {
				// Get the current date and time.
				String conversionPattern = "[%p] %d{dd/MM/yyyy HH} %c %M - %m%n";
				
				PatternLayout layout = new PatternLayout();
				layout.setConversionPattern(conversionPattern);

				// creates daily rolling file appender
				DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
				rollingAppender.setFile(System.getenv("Orchastration_Engine") + "/log/MyLogFile");
				rollingAppender.setDatePattern("'_'yyyy-MM-dd-HH");
				rollingAppender.setLayout(layout);
				rollingAppender.activateOptions();

				// Add in appender.
				logger.addAppender(rollingAppender);
				rollingAppender.setLayout(new SimpleLayout());
			} catch (SecurityException exception) {
				exception.printStackTrace();
			}*/
			
			logger = Logger.getLogger(OrchastrationLoggerHourly.class);  
	        Layout layout = new PatternLayout("%d [%t] %-5p (%F:%L) - %m%n");  
	        Appender appender = new ConsoleAppender(layout);  
	        logger.addAppender(appender);  
	        logger.info("Logged this message!!!");
			
		}
		
		try {
			// Initialize the PrintStream class. with error log file.
			printStream = new PrintStream(new FileOutputStream(
					new File(System.getenv("Orchastration_Engine") + "/log/MyErrorLogFile" + datefor + ".log")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		logger.info("this is a information log message:" + datefor);
		// Return the logger object.
		return logger;

	}

	/**
	 * This method is used to get the status of the logger and return true if
	 * logger status is enable which define that log files will show else return
	 * false which disable the logs files.
	 */

	private static boolean getLoggerStatus() {

		try {

			// Initialize the properties class and get properties values.

			Properties properties = new Properties();

			// get the environment variables and read the config file.

			properties.load(new FileInputStream(System.getenv("Orchastration_Engine") + "/template/sample.conf"));
			String loggerStatus = properties.getProperty("logger.status").trim();
			System.out.println("logger status:-" + loggerStatus);
			if (loggerStatus.equals("1")) {
				// Return true
				return true;
			}
			// Return false
			return false;

		} catch (Exception exception) {

			exception.printStackTrace();
			return false;
		}

	}
}
