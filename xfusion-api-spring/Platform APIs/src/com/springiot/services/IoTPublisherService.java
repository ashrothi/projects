/**
 * This package contain the service class for publishing data directly to IOT HUb.
 */
package com.springiot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.springiot.response.Message;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * This service class is used to publish data directly to iot hub
 * 
 * @author tanvigarg
 *
 */
@Service
@PropertySource(value = "/WEB-INF/Publisher.properties")
public class IoTPublisherService {

	@Autowired
	Environment environment;

	/**
	 * This method is used to publish data to Kafka.
	 * 
	 * @param apiParameters,requires
	 *            the input parameters.
	 * @return
	 * @throws Exception
	 */
	public Message Publisher(Map<String, String> apiParameters) throws Exception {
		Message message = new Message();

		try {

			String dataPacket = apiParameters.get("data");
			if (dataPacket != null) {
				Properties kafkaProperties = new Properties();

				/*
				 * Credentials for Azure
				 * kafkaProperties.put("zookeeper.connect", "10.1.0.4:2181");
				 * kafkaProperties.put("metadata.broker.list", "10.1.0.4:9092");
				 * kafkaProperties.put("serializer.class",
				 * "kafka.serializer.StringEncoder");
				 * kafkaProperties.put("request.required.acks", "1");
				 */

				// Reading Config File For Publishing data directly to IOT HUB
				List<Object> dataFromConfigFile = readConfig();

				String zookeeperConnectData = dataFromConfigFile.get(0).toString();

				String metadataBrokerListData = dataFromConfigFile.get(1).toString();

				String topicNameData = dataFromConfigFile.get(2).toString();

				// System.out.println("zookeeperConnectData " +
				// zookeeperConnectData);
				// System.out.println("metadataBrokerListData " +
				// metadataBrokerListData);
				// System.out.println("topicNameData " + topicNameData);

				/*
				 * Credentials for 97 kafkaProperties.put("zookeeper.connect",
				 * "13.94.42.90:9092"); kafkaProperties.put("serializer.class",
				 * "kafka.serializer.StringEncoder");
				 * kafkaProperties.put("request.required.acks", "1");
				 * 192.168.1.73:2181 192.168.1.73:9092 192-168-1-73-1883-HTTPS
				 */

				// Credentials for IOT HUB
				kafkaProperties.put("zookeeper.connect", zookeeperConnectData);
				kafkaProperties.put("metadata.broker.list", metadataBrokerListData);
				kafkaProperties.put("serializer.class", "kafka.serializer.StringEncoder");
				kafkaProperties.put("request.required.acks", "1");

				ProducerConfig producerConfig = new ProducerConfig(kafkaProperties);

				// 13-94-42-90-1883-HTTPS
				KeyedMessage<String, String> messageToPublish = new KeyedMessage<String, String>(topicNameData, "ip",
						dataPacket);

				/*
				 * Send the data on kafka.
				 */

				// System.out.println("messageToPublish " + messageToPublish);
				Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
				// System.out.println("kafkaProducer " + kafkaProducer);

				kafkaProducer.send(messageToPublish);

				/*
				 * Close the Kafka producer connection.
				 */
				kafkaProducer.close();

				message.setDescription("Data Published successfully");
				message.setValid(true);
				return message;
			} else {
				message.setDescription("Data not available");
				message.setValid(false);
				return message;
			}
		} catch (Exception exception) {
			// System.out.println(exception);
			exception.printStackTrace();
			message.setDescription(exception.getMessage());
			message.setValid(false);
			return message;
		}

	}

	private List<Object> readConfig() {

		List<Object> inputParameters = new ArrayList<>();

		String zookeperConnect = environment.getProperty("zookeeper.connect.data");

		String metadataBrokerList = environment.getProperty("metadata.broker.list.data");

		String topicName = environment.getProperty("topic.name.data");

		String geoFenceTopic = environment.getProperty("topic.name.data.geofence");

		inputParameters.add(zookeperConnect);
		inputParameters.add(metadataBrokerList);
		inputParameters.add(topicName);
		inputParameters.add(geoFenceTopic);

		return inputParameters;
	}

	/**
	 * This method will publish the geofencing based rules on kafka topic to
	 * notify gateways about crud operations.
	 * 
	 * @param data,
	 *            data packet. @return, response from kafka server.
	 * @throws Exception
	 */
	public Message rulePublisher(Object data) throws Exception {
		final Message message = new Message();

		try {
			/*
			 * Format the data.
			 */
			final String dataPacket = data.toString();
			if (dataPacket != null) {
				Properties kafkaProperties = new Properties();

				/*
				 * Credentials for Azure
				 * kafkaProperties.put("zookeeper.connect", "10.1.0.4:2181");
				 * kafkaProperties.put("metadata.broker.list", "10.1.0.4:9092");
				 * kafkaProperties.put("serializer.class",
				 * "kafka.serializer.StringEncoder");
				 * kafkaProperties.put("request.required.acks", "1");
				 */

				// Reading Config File For Publishing data directly to IOT HUB
				List<Object> dataFromConfigFile = readConfig();

				String zookeeperConnectData = dataFromConfigFile.get(0).toString();

				String metadataBrokerListData = dataFromConfigFile.get(1).toString();

				String topicNameData = dataFromConfigFile.get(3).toString();

				/*
				 * Credentials for 97 kafkaProperties.put("zookeeper.connect",
				 * "13.94.42.90:9092"); kafkaProperties.put("serializer.class",
				 * "kafka.serializer.StringEncoder");
				 * kafkaProperties.put("request.required.acks", "1");
				 * 192.168.1.73:2181 192.168.1.73:9092 192-168-1-73-1883-HTTPS
				 */

				// Credentials for IOT HUB testing server 73

				kafkaProperties.put("zookeeper.connect", zookeeperConnectData);
				kafkaProperties.put("metadata.broker.list", metadataBrokerListData);
				kafkaProperties.put("serializer.class", "kafka.serializer.StringEncoder");
				kafkaProperties.put("request.required.acks", "1");
				ProducerConfig producerConfig = new ProducerConfig(kafkaProperties);

//				System.out.println("Topic name -- " + topicNameData);

				// Initialize the object of producer.
				KeyedMessage<String, String> messageToPublish = new KeyedMessage<String, String>(topicNameData, "ip",
						dataPacket);

				// Send the data on kafka.

				Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
				kafkaProducer.send(messageToPublish);

				// Close the Kafka producer connection.

				kafkaProducer.close();

				message.setDescription("Data Published successfully");
				message.setValid(true);
				return message;
			} else {
				message.setDescription("Data not available");
				message.setValid(false);
				return message;
			}
		} catch (Exception exception) {
			message.setDescription(exception.getMessage());
			message.setValid(false);

//			System.out.println("Message " + message);

			return message;
		}
	}
}
