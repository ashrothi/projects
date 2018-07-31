/**
 * This is basic class for project, here defined all basic variables, like logger, PrintStream object.
 */
package in.teramatrix.barc.logger;

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

import in.teramatrix.barc.configuration.Configuration;

/**
 * In this class defined the basic variables like logger, print stream etc. Here
 * Initialize the logger and create the log file as according to date and time.
 * Here used Apache library for logger. Here also initialize the PrintStream
 * object for write the error in log file. This object is used in
 * "exception.printStrakTrace()" for write the Exception in error log file.
 * 
 * @author Mandeep Singh
 */
public class BarcLogger {

	/**
	 * This field is used for logger initialize, logger is used for append
	 * console output in file.
	 */
	public static Logger logger;

	/**
	 * This field is used for PrintStream object initialize, PrintStream is used
	 * for append Exceptions in error file.
	 */
	public static PrintStream printStream;

	/**
	 * This is default constructor for class PdsnLogger.
	 */
	public BarcLogger() {

	}

	/**
	 * In this method defined the logger and print stream object. Here also
	 * initialize the path where log and error log file will be create. File
	 * will create with date time, so here get the current date and date append
	 * with log file name.
	 */
	public static Logger startLogger(String templatePath) {

		// Get the current date and time.
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
		Date date = new Date();
		String datefor = dateFormat.format(date);

		// Initialize the logger
		logger = Logger.getLogger("MyLog");

		if (getLoggerStatus(templatePath)) {

			// Set the log4j.properties file
			PropertyConfigurator.configure(Configuration.getLogsPath() + "/" + "log4j.properties");
			Appender appender = null;
			try {

				// Append the created log file
				appender = new FileAppender(new SimpleLayout(),
						Configuration.getLogsPath() + "/log/MyLogFile" + datefor + ".log");
				// Add in appender.
				logger.addAppender(appender);
				appender.setLayout(new SimpleLayout());
			} catch (SecurityException exception) {
				exception.printStackTrace(BarcLogger.printStream);
			} catch (IOException exception) {
				exception.printStackTrace(BarcLogger.printStream);
			}
		}
		// creates a custom logger and log messages
		try {

			// Initialize the PrintStream class with error log file.
			printStream = new PrintStream(new FileOutputStream(
					new File(Configuration.getLogsPath() + "/log/MyErrorLogFile" + datefor + ".log")));
		} catch (FileNotFoundException e) {

			e.printStackTrace(BarcLogger.printStream);
		}
		// Return the object of logger.
		return logger;

	}

	/**
	 * This method is used to get the status of the logger and return true if
	 * logger status is enable which define that log files will show else return
	 * false which disable the logs files.
	 * 
	 * @param templatePath : Here pass the path of config file.
	 * @return true or false if logging is required or not by user.
	 */
	private static boolean getLoggerStatus(String templatePath) {

		try {
			// Initialize the properties class and get properties values.
			Properties properties = new Properties();

			// get the environment variables and read the config file.
			properties
					.load(new FileInputStream(templatePath));
			String loggerStatus = properties.getProperty("barc.logger.status").trim();
			System.out.println("logger status:-" + loggerStatus);
			if (loggerStatus.equals("1")) {
				// Return true
				return true;
			}
			// Return false
			return false;

		} catch (Exception exception) {
			exception.printStackTrace(BarcLogger.printStream);
			return false;
		}
	}
}