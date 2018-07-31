package in.teramtrix.barc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

import in.teramatrix.barc.configuration.Configuration;
import in.teramatrix.barc.initialization.ConsumerInitialization;
import in.teramatrix.barc.kafkaService.KafkaService;
import in.teramatrix.barc.logger.BarcLogger;

/**
 * This class contains main method for this project.
 * This project will retrieve the records from the kafka then alter 
 * the records with the unique playback_id and hashcode. Then those
 * records will be sent to fingure print API of barc.
 *  
 * @author mandeepsingh
 *
 */
public class BarcMain {
	/**
	 * This is the main method of project which initialize all the configuration
	 * process are also starts from here. Here the connection with kafka
	 * established with zookeeper broker.
	 * 
	 * @param args : Pass config file detail in argument.
	 */
	public static void main(String[] args) {
System.out.println("start time" + new Date());
		// Check if argument passed or not.
		if (args.length == 0) {

			// If argument does not defined then exit from system.
			System.err.println("please give argument as template file location");
			System.exit(0);
		}

		String template = args[0];
		// Set the argument value in object of configuration.
		setConfiguration(template);
		
		// Initialize the object of logger by calling the startLogger method.
		Logger logger = BarcLogger.startLogger(template);
					
		ConsumerInitialization initialization = new ConsumerInitialization(Configuration.getKafkaBroker(),
				Configuration.getKafkaConsumerId());
		/*
		 * Initialize the kafka consumer object to connect with broker.
		 */
		KafkaConsumer<String, String> consumer = initialization.getConsumer();
		/*
		 * Initialize the class ServiceImpl to call the method which will
		 * consume data from kafka topics.
		 */
		KafkaService service = new KafkaService();
		List<String> subscriberTopic = new ArrayList<>();
		/*
		 * To consume data from multiple topics.
		 */
		String s[] = Configuration.getKafkaSubscriberTopic().split(",");
		for (int i = 0; i < s.length; i++) {
			String topic = s[i];
			subscriberTopic.add(topic);
		}
		logger.info("Kafka topics from data to be subscribed " + subscriberTopic);
		/*
		 * This method will consume data from all topics provided and listen on
		 * continuous mode.
		 */
			service.getFromTopic(consumer, subscriberTopic);
	}

	/**
	 * setConfiguration method is use set all parameters of config file to
	 * Configuration Class
	 * 
	 * @param configFileLocation : Here pass configuration file location.
	 */
	private static void setConfiguration(String configFileLocation) {
		/*
		 * Initialize the Properties class to retrieve all the configuration
		 * params value from config file.
		 */
		Properties config = new Properties();
		try {
			/*
			 * Load the config file using the location define for config file.
			 */
			config.load(new FileReader(new File(configFileLocation)));
			System.out.println(config);

			/*
			 * Set the param value for zookeeper connection url.
			 */
			Configuration.setZookeeperConnection(config.getProperty("barc.zookeeper.connection"));

			/*
			 * Set the param value for kafka consumer id.
			 */
			Configuration.setKafkaConsumerId(config.getProperty("barc.kafka.consumer.id"));

			/*
			 * Set the param value for kafka consumer topics.
			 */
			Configuration.setKafkaSubscriberTopic(config.getProperty("barc.consumer.topic"));

			/*
			 * Set the param value for kafka broker url.
			 */
			Configuration.setKafkaBroker(config.getProperty("barc.kafka.broker.connection"));
			
			Configuration.setDbDriver(config.getProperty("barc.db.driver.name"));
			Configuration.setDbUrl(config.getProperty("barc.db.url"));
			Configuration.setProcedureName(config.getProperty("barc.procedure.name"));
			
			Configuration.setLogsPath(config.getProperty("barc.logging.path"));
			Configuration.setApiUrl(config.getProperty("barc.advert.api.url"));
		}
		/*
		 * Handle if any exception occur.
		 */
		catch (FileNotFoundException e) {
			BarcLogger.logger.info("Config File not found ");
			e.printStackTrace(BarcLogger.printStream);
		} catch (IOException e) {
			BarcLogger.logger.info("there is some IO Exception");
			e.printStackTrace(BarcLogger.printStream);
		}
	}
}
