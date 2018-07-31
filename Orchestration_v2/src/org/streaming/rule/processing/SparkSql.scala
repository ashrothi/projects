/**
 * This package contain two class RuleProcess for main logic implementation . SparkSql for genrate dataset from json rdd
 */
package org.streaming.rule.processing

import org.apache.spark.sql.DataFrame
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.streaming.kafka.KafkaProcessing
import com.orchastration.logger.OrchastrationLogger
import com.orchastration.logger.TCPLogger

/**
 *SparkSql is use to create table in spark sql . This class extend further for implement more logic on Spark sql
 */
class SparkSql {

  /**
   *generateDataSet method is use to create spark sql table as per json RDD and return data frame
   * @param jsonRdd:RDD[String] contain RDD of json String
   * @param sqlContext:That is instance of Sql Context from Kafka processing class
   * @param tableName:table name which is going to create for json RDD 
   * @return DataFrame:this data frame is of SparkSql Table
   */
  def generateDataSet(jsonRdd: RDD[String], sqlContext: SQLContext, tableName: String): DataFrame = {

    try {
//      OrchastrationLogger.logger.info("json rdd:==================")

      var tabledatasql: DataFrame = sqlContext.read.json(jsonRdd)
//      OrchastrationLogger.logger.info("json rdd:=================="+tabledatasql.toString())
      TCPLogger.logger.info(tabledatasql.show())
      tabledatasql.registerTempTable(tableName)

      

      return tabledatasql;

    } catch {
      case t: Throwable => t.printStackTrace()
      TCPLogger.printStream.append(t.getMessage)
    }
    return null
  }


}