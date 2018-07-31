/**
 * This package is use to create DB Connection
 */
package org.streaming.db

import java.sql._
import java.lang.Boolean
import java.util.ArrayList
import java.util.HashMap
import org.streaming.rule.config.Configuration
import com.orchastration.logger.TCPLogger;
//import com.orchastration.logger.OrchastrationLogger;
/*
 * Object is created to create connection with MySql database.
 */
class DBConnection {
  /*
   * Method is creating connection with Mysql database as well as Hsql with input parameters driver and connection url for dB.
   */
  def createConnection(driver: String, URL: String): Connection = {

    try {

      Class.forName(driver);
      /*
       * Get connection for MySql
       */
      var conn: Connection = DriverManager.getConnection(URL);
      return conn;

    } catch {
      case t: Throwable => t.printStackTrace()
    }
    return null;
  }


  
  
  /*
   * Method is used to execute as well as update queries in database and get the boolean result 
   */
  def executeUpdate(sql: String,conn: Connection): Boolean = {

    try {
       var tmpConnection=conn;
        if(conn.isClosed()){
         tmpConnection=createConnection(Configuration.driverName,Configuration.dbConnectionUrl);
        }
      // Initializing the statement for executing of Sql Queries
      var stmt: Statement = tmpConnection.createStatement();
      stmt.executeUpdate(sql);
      stmt.close();

      return true;

    } catch {
      case t: Throwable =>
        println("Error Message:- " + t.getMessage)
        TCPLogger.printStream.append("Error Message:- " + t.getMessage)
        return false;
    }
  }

  /*
   * Method is used to execute  queries in database and get the boolean result 
   */
   def executeSqlQuery(query: String, conn: Connection): java.util.List[java.util.Map[String, Object]] = {

    try {
      if (query != null) {
        var tmpConnection=conn;
        if(conn.isClosed()){
         tmpConnection=createConnection(Configuration.driverName,Configuration.dbConnectionUrl);
        }

        var list: java.util.List[java.util.Map[String, Object]] = new ArrayList();

        var st: Statement = tmpConnection.createStatement();

        var rs: ResultSet = st.executeQuery(query);

        var rsd: ResultSetMetaData = rs.getMetaData()

        var count = rsd.getColumnCount().toInt

        while (rs.next()) {
          var map: java.util.Map[String, Object] = new java.util.HashMap[String, Object]()

          var i: Int = 0
          for (i <- 1 to count) {
            map.put(rsd.getColumnName(i), rs.getObject(i))
          }

          list.add(map);
        }

        return list;
      }

    } catch {
      case t: Throwable => t.printStackTrace()
            var tmpConnection= createConnection(Configuration.driverName,Configuration.dbConnectionUrl);
      executeSqlQuery(query, tmpConnection);
      TCPLogger.printStream.append("Mysql Error Message:- " + t.getMessage)
      
    }

    return null;
  } 
 

}