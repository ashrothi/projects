/**
 * This package contain main initiate class to initiate streaming layer 
 * and demo classes
 */
package com.java.main;

import org.streaming.kafka.KafkaProcessing;

import com.orchastration.logger.OrchastrationLoggerHourly;
import com.orchastration.logger.TCPLogger;
import org.apache.log4j.Logger;
import java.io.PrintStream;

/**
 * This class is required only when we deploy streaming jobs on different servers.
 * This invoke our application and start execute process of streaming job
 * 
 */
public class StreamingMain {
	/**
	 * Static block is used which will initialize before the main method and
	 * set and initialize the required objects by getting configuration file.
	 */
	
	public static Logger logger;
	

	// Declare the object of PrintStream.
	public static PrintStream printStream;
	
	static {

		/*
		 * Check Environment variable is null or not, if null then exit from
		 * program.
		 */
		if (System.getenv("Orchastration_Engine") == null) {
			System.out.println("Enviourment variable is null:- " + System.getenv("Orchastration_Engine"));
			System.exit(1);
		}
		System.out.println("Enviourment variable is:- " + System.getenv("Orchastration_Engine"));
		try {
			// Call startLogger method for initialize the logger.
			TCPLogger.startLoggerUpdate();

			/*
			 * Initialize Logger,logger object used for print logs detail in
			 * file.
			 */

			logger = TCPLogger.logger;

			/*
			 * Initialize PrintStream, PrintStream object used for print
			 * Exception's in error log file
			 */

			printStream = TCPLogger.printStream;

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws Exception {


		/**
		 * Here invoke process which which data from kafka and apply logic 
		 * accordingly and return status that connection with kafka is successfully and 
		 * no issue occure
		 */
		
		boolean flag = KafkaProcessing.kafkaProcess();
		
		logger.info("Execution Success:- " + flag);
	}

}
