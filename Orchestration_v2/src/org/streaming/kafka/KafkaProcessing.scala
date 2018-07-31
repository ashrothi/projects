/**
 * This package is containing Kafka processing object which set all
 * object of spark conetext and set master for initiate streaming with kafka library
 */
package org.streaming.kafka

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka.KafkaUtils
import kafka.utils.ZkUtils
import org.apache.spark.streaming.kafka.HasOffsetRanges

import org.streaming.rule.config.Configuration

import java.sql.Connection
import org.streaming.execute.process.ExecuteProcess
//import com.orchastration.logger.OrchastrationLoggerHourly;

import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.streaming.rule.processing.RuleProcess
import org.apache.spark.sql;
import org.apache.spark.sql.hive._
import java.lang.Long
import org.apache.hadoop.mapred.AuditLogger
import org.kafka.publish.AuditLogPublisher
import com.java.main.StreamingMain
import com.orchastration.logger.TCPLogger

/**
 * Object is created to retrieve data from Kafka and and create RDD's for the same.
 * The functionality of RDD's to stored data from topic into its temporary table.
 */
object KafkaProcessing {

  /**
   * Initializing Spark Conf and streaming context()
   */
  var conf = new SparkConf().setAppName(Configuration.appName).setMaster(Configuration.appMaster)
  conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
  conf.set("spark.rdd.compress","true");
 // conf.set("spark.memory.offHeap.enabled","true")
//conf.set("spark.memory.offHeap.size","2")
//   conf.set("spark.kryoserializer.buffer.mb","24")  
//   conf.set("spark.executor.memory","150M")
//  conf.set("spark.executor.cores","4")
//conf.set("spark.cores.max","16")
/*conf.set("spark.executor.instances","15")*/
/*conf.set("spark.shuffle.memoryFraction","0.2")
conf.set("spark.storage.memoryFraction","0.02")*/
//conf.registerKryoClasses(Array(classOf[RuleProcess], classOf[AuditLogPublisher]))
  var sc = new SparkContext(conf)

  /**
   * create object of sql context
   */
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)

  //time(Seconds) in which streaming create new treads 
  var ssc = new StreamingContext(sc, Seconds(Long.valueOf(Configuration.second)))

  /*
   * kafkaProcess method is use for
   * 1)Set Logger condition
   * 2)create kafka stream with given topic name and create instance of Rule process class
   * 3)Loop for fetching data from kafka topic in RDD[String] Formate
   * 
   */
  def kafkaProcess(): Boolean = {

    try {

      /**
       * set Logger Condition
       */
      Logger.getLogger("org").setLevel(Level.OFF)
      Logger.getLogger("akka").setLevel(Level.OFF)

      //Fetch Request Topic name where api publish data 
      var topicMap = Configuration.notificationTopic.split(",").map((_, 1)).toMap

      /**
       * Create kafka stream through KafkaUtils library input parameter is
       * 1)Streaming context
       * 2)Zookeeper Connection(i.e:- localhost:2181)
       * 3)Consumer Group Name (i.e:- orchestration layer)
       * 4)kafka topic in form of Map
       * Return: DStream[String] which is collection of message from API
       */
      var kafkaStreams = KafkaUtils.createStream(ssc, Configuration.zkpConnection, Configuration.consumerGroup, topicMap).map(_._2)

      //Initiate Rule Process
      var ruleProcess: RuleProcess = new RuleProcess

      /**
       * Each array of object is considered as individual RDD and rule query execution is applied on each and every RDD
       * Each RDD Contain Array of objects. like [{}] [{}] [{}],
       */
      kafkaStreams.foreachRDD(rdd => {

        //count total number of Rdd from kafka stream
        var count = rdd.count();

        if (count > 0) {
          TCPLogger.logger.info("======================================  Start Orchastration Processing=================================")

          /**
           * Invoke createJsonRdd Method with given parameter RDD[String] .which apply process on single RDD of string
           */
          ruleProcess.createJsonRdd(rdd.cache())
          TCPLogger.logger.info("======================================End Orchastration Processing=================================")
        }

      })

      /*
       * Close connection with spark conf and streaming context
       */
      ssc.start()
      ssc.awaitTermination()

      return true;
    } catch {
      case t: Throwable =>
        t.printStackTrace()
        TCPLogger.printStream.append(t.getMessage);
        return false;
    }

  }

}