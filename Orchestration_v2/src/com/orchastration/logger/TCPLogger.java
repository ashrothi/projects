package com.orchastration.logger;

/**
 * This is basic class for project, here defined all basic variables, like logger, printstream object.
 */


import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
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
 */
public class TCPLogger {

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
	 * This is default constructor for class PdsnLogger which initialize the
	 * class which defined the basic variables like logger, print stream etc.
	 * Here Initialize the logger and create the log file as according to date
	 * and time. Here used apache lib. for logger. Here also initialize the
	 * printstream object for write the error in log file. This object is used
	 * in "exception.printStrakTrace()" for write the Exception in error log
	 * file.
	 */
	public TCPLogger() {

	}

	/**
	 * In this method defined the logger and print stream object. Here also
	 * initialize the path where log and error log file will be create. File
	 * will create with date time, so here get the current date and date append
	 * with log file name.
	 */
	public static Logger startLogger() {

		// Get the current date and time.
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String datefor = dateFormat.format(date);

		// Initialize the logger
		logger = Logger.getLogger("MyLog");

		if (getLoggerStatus()) {

			// Set the log4j.properties file
			PropertyConfigurator.configure(System.getenv("Orchastration_Engine") + "/" + "log4j.properties");
			Appender appender = null;
			try {

				// Append the created log file
				appender = new FileAppender(new SimpleLayout(),
						System.getenv("Orchastration_Engine") + "/log/MyLogFile" + datefor + ".log");
				// Add in appender.
				logger.addAppender(appender);
				appender.setLayout(new SimpleLayout());
			} catch (SecurityException exception) {
				exception.printStackTrace();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		try {

			// Initialize the PrintStream class. with error log file.
			printStream = new PrintStream(new FileOutputStream(
					new File(System.getenv("Orchastration_Engine") + "/log/MyErrorLogFile" + datefor + ".log")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return logger;

	}

	public static Logger startLoggerUpdate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String datefor = dateFormat.format(date);
		// Get the current date and time.
		PatternLayout layout = new PatternLayout();
		String conversionPattern = "[%p] %d %c %M - %m%n";
		layout.setConversionPattern(conversionPattern);

		// creates daily rolling file appender
		DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
		DailyRollingFileAppender errorRollingAppender = new DailyRollingFileAppender();
		rollingAppender.setFile(System.getenv("Orchastration_Engine") + "/log/MyLogFile");
		errorRollingAppender.setFile(System.getenv("Orchastration_Engine") + "/log/MyErrorLogFile");
		rollingAppender.setDatePattern("'_'yyyy-MM-dd'.log'");
		errorRollingAppender.setDatePattern("'_'yyyy-MM-dd'.log'");

		rollingAppender.setLayout(layout);
		errorRollingAppender.setLayout(layout);
		rollingAppender.activateOptions();
		errorRollingAppender.activateOptions();
		// configures the root logger
		logger = Logger.getLogger(TCPLogger.class);
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);
		rootLogger.addAppender(rollingAppender);

		

		// creates a custom logger and log messages

		try {

			// Initialize the printstream class. with error log file.
			printStream = new PrintStream(new FileOutputStream(
					new File(System.getenv("Orchastration_Engine") + "/log/MyErrorLogFile" + datefor + ".log")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("this is a information log message:" + datefor);
		printStream.append("Logger initiate for error");
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

//			Properties properties = new Properties();

			// get the environment variables and read the config file.

		//	properties.load(new FileInputStream(System.getenv("Orchastration_Engine") + "/templates/vota_details.config"));
			String loggerStatus = "1";
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
