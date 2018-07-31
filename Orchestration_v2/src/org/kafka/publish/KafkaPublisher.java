/**
 * Thise package contain two classes which is use to publish data to kafka topic
 * 1)AuditLogPublisher:-This class is use to check response code and accordingly publish data to kafka Topic through
 * 	KafkaPublisher Class.
 * 2)KafkaPublisher Class:- It set connection with zookeeper and topic and having method to push data to kafka topic
 */

package org.kafka.publish;

import java.util.Properties;
import org.streaming.rule.config.Configuration;

//import com.orchastration.logger.OrchastrationLogger;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import com.orchastration.logger.TCPLogger;
/**
 * KafkaPublisher class is use to set connection with zookeeper and Metadata
 * broker list and help to publish data to kafka Topic
 * 
 * @author sachin
 *
 */
public class KafkaPublisher {

	
	public static final Properties KAFKAPROPERTIES = new Properties();// set final variable of Properties which use to set all kafka properties

	// declare static variable of ProducerConfig which is use to publish data to
	// kafka topic
	public static ProducerConfig producerConfig;

	/**
	 * setProperties method use to set all kafka properties
	 */
	public void setProperties() {

		// set properties of ZOOKEEPER connection
		KAFKAPROPERTIES.put("zookeeper.connect", Configuration.zkpConnection());

		// set properties of metadata broker list
		KAFKAPROPERTIES.put("metadata.broker.list", Configuration.brokerList());
		KAFKAPROPERTIES.put("serializer.class", "kafka.serializer.StringEncoder");
		KAFKAPROPERTIES.put("request.required.acks", "1");

		// define producer config
		producerConfig = new ProducerConfig(KAFKAPROPERTIES);

	}

	/**
	 * publishToKafka this method use to publish data to given kafka topic
	 * @param topicName:Topic name of kafka topic
	 * @param data:data which is going to publish
	 * @return :true if publish successfully and false for unccessful
	 */
	public boolean publishToKafka(final String topicName,final String data) {
		Boolean returnStatus=true;
		
		try {
			System.out.println("topic where data is published:-" + topicName);
			TCPLogger.logger.info("topic where data is published:-" + topicName);

			// create keyed message from given data
		final	KeyedMessage<String, String> messageToPublish = new KeyedMessage<String, String>(topicName, data);

			// set Producer instance which publish data to kafka topic with help
			// of producerConfig
		final	Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
			kafkaProducer.send(messageToPublish); // publish data to kafka topic

		} catch (Exception e) {
			e.printStackTrace();
			TCPLogger.printStream.append(e.getMessage());
			returnStatus=false;
		}
		return returnStatus;
	}

}
