/**
 * 
 */
package com.springiot.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * @author tanvigarg
 *
 */
@Service
@PropertySource(value = "classpath:/config.properties")
public class KafkaServices {
	@Autowired
	Environment environment;

	/**
	 * To Push the notification to kafka queue with the configuration coming
	 * from database
	 * 
	 * @param formattedData
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	Boolean executeNotificationtoKafka(List<Map<String, Object>> formattedData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			/**
			 * Transforming coming data in json string format
			 */
			String commandNotificationJson = new Gson().toJson(formattedData);
			/**
			 * To check if string is not null
			 */
			if (commandNotificationJson != null) {
				/**
				 * To get kafka config from database
				 */
				Map<String, String> map = new LinkedHashMap<>();
				map.put("kafka_type", "publisher");
				/**
				 * Calling generic Procedure to get kafka config
				 */
				String zookeperConnect = environment.getProperty("zookeeper.connect.data");

				String metadataBrokerList = environment.getProperty("metadata.broker.list.data");

				String topicName = environment.getProperty("topic.name.data");

				/*
				 * To transform response coming from database
				 */

				Properties kafkaProperties = new Properties();
				/**
				 * Defining kakfa config as per coming from database
				 */
				kafkaProperties.put("zookeeper.connect", zookeperConnect);

				kafkaProperties.put("metadata.broker.list", metadataBrokerList);
				kafkaProperties.put("serializer.class", "kafka.serializer.StringEncoder");

				kafkaProperties.put("request.required.acks", "1");
				/**
				 * Defining Kafka Producer Config
				 */
				ProducerConfig producerConfig = new ProducerConfig(kafkaProperties);
				/**
				 * KeyedMessage message with data to publish in kafka
				 */
				KeyedMessage<String, String> messageToPublish = new KeyedMessage<String, String>(topicName, "ip",
						commandNotificationJson);
				System.out.println("data after: \n" + messageToPublish);
				/*
				 * Send the data on kafka.
				 */
				Producer<String, String> kafkaProducer = new Producer<String, String>(producerConfig);
				/**
				 * To Send Data to Kafka
				 */

				kafkaProducer.send(messageToPublish);

				/*
				 * Close the kafka producer connection.
				 */
				kafkaProducer.close();
				/*
				 * If data published successfully it will send true in return
				 */
				return true;

			} else {
				/*
				 * If data is null , it will send false in return
				 */
				return false;
			}

		} catch (Exception e) {
			/**
			 * To get exception if it comes
			 */
			e.printStackTrace();
			return false;
		}
	}
}
