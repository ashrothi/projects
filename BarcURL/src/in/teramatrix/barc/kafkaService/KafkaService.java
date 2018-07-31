/**
 * This package contains the class which implements the interface and overrides its method to consume data from kafka topics.
 */
package in.teramatrix.barc.kafkaService;

import java.util.Date;
import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import in.teramatrix.barc.data.process.PlaybackFilter;
import in.teramatrix.barc.logger.BarcLogger;

/**
 * This class is used for subscribing the data from the kafka.
 * 
 * @author Mandeep Singh
 *
 */
public class KafkaService {
	/**
	 * This method is used to get the kafka topics list and subscribe the topics
	 * and retrieve data from specific topic.
	 * 
	 * @param consumer : The object of kafka consumer.
	 * @param subscriberTopic : The list of topics from which data need to be consume.
	 * @param producerTopic : The kafka topic in which data to be store for aggregation.
	 * @throws InterruptedException 
	 */
	public String getFromTopic(KafkaConsumer<String, String> consumer, List<String> subscriberTopic){

		boolean isRunning = true;
		try {
			/*
			 * Here we use subscriber method instead of consuming data from
			 * partitions as we don't know about in which partition data is
			 * pushed by collection layer. So this method will consume all
			 * current data pushed in respective topics.
			 */
			consumer.subscribe(subscriberTopic);
			while (isRunning) {
				ConsumerRecords<String, String> records = consumer.poll(500);
				if(records.count() == 0){
					BarcLogger.logger.info("All records in Kafka are consumed.");
					isRunning = false;
					System.out.println("end time " + new Date());
				}
				
				/*
				 * Now after polling the data, it will continuously listen to
				 * the records in topics and never stop doing that.
				 */
				for (ConsumerRecord record : records) {
					try {
						String message = new String(record.value().toString());
						BarcLogger.logger.info("Message from Kafka: " + message);
						PlaybackFilter.dataFilter(message);
						//Thread.sleep(10000);
					} catch (Exception e) {
						e.printStackTrace(BarcLogger.printStream);
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace(BarcLogger.printStream);
		} finally {
			isRunning = false;
			consumer.close();
		}

		return null;
	}
}