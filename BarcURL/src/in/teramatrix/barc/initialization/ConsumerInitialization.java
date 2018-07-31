/**
 * This package contain the classes which are useful for server configuration and algorithm implementations.
 */
package in.teramatrix.barc.initialization;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import in.teramatrix.barc.logger.BarcLogger;

/**
 * This class contains the method which are useful to initialize the kafka
 * consumer by adding all configuration parameters.
 * 
 * @author Mandeep Singh
 */
public class ConsumerInitialization {

	private KafkaConsumer<String, String> consumer;
	private String topic[];

	/**
	 * This method initialize the kafka consumer on the basis of broker, group
	 * id and topics.
	 * 
	 * @param brokers :
	 *            The broker name
	 * @param groupId :
	 *            The unique group id
	 * @param topic :
	 *            The topic array of string
	 */
	public ConsumerInitialization(String brokers, String groupId, String... topic) {
		Properties prop = createConsumerConfig(brokers, groupId);
		this.consumer = new KafkaConsumer<>(prop);
		this.topic = topic;
		this.consumer.subscribe(Arrays.asList(this.topic));
	}

	/**
	 * This method initialize the kafka consumer on the basis of broker, group
	 * id.
	 * 
	 * @param brokers :
	 *            The broker name
	 * @param groupId :
	 *            The unique group id
	 */
	public ConsumerInitialization(String brokers, String groupId) {
		Properties prop = createConsumerConfig(brokers, groupId);
		try {
			this.consumer = new KafkaConsumer<>(prop);
		} catch (Exception e) {
			e.printStackTrace(BarcLogger.printStream);
		}

	}

	/**
	 * This method will create the consumer configuration setting to initialize
	 * the consumer.
	 * 
	 * @param brokers : The broker name
	 * @param groupId : The unique group id
	 * @return
	 */
	private static Properties createConsumerConfig(String brokers, String groupId) {
		Properties props = new Properties();
		props.put("bootstrap.servers", brokers);
		System.out.println(groupId);

		props.put("group.id", groupId);
//		props.put("enable.auto.commit", "true");
		
		props.put("zookeeper.session.timeout.ms", "4000");
		props.put("zookeeper.sync.time.ms", "2000");

		props.put("auto.commit.interval.ms", "10000");
		props.put("max.block.ms", "100");

		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		return props;
	}

	/**
	 * This method will provide the consumer which is initialized.
	 */
	public KafkaConsumer<String, String> getConsumer() {
		if (consumer != null) {
			BarcLogger.logger.info("Consumer object: " + consumer);

			return consumer;
		} else {
			BarcLogger.logger.info("consumer is not initialize properly");
			return null;
		}
	}
}