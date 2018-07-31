/**
 * This package is used for Streaming Rule Engine when we need to update any existing rule.
 */
package com.springiot.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 
 * @author tanvigarg This Class is used to make connection with HSQL database
 *         which is used in Spark Streaming as an internal database and used to
 *         Execute update Sql query in hsql.
 *
 */
public class ConnectDb {
	/**
	 * This method is used to make connection with HSQL database.
	 * 
	 * @param driverName,
	 *            Driver name for HSQL database
	 * @param connectionUrl,
	 *            Connection string for HSQL
	 * @return
	 */
	public static Connection getConnection(String driverName, String connectionUrl) {
		try {

			Class.forName(driverName);

			Connection connection = DriverManager.getConnection(connectionUrl);

//			System.out.println("connection:-" + connection);
			return connection;

		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * This Method is used to execute Update SQL Query in HSQL database.
	 * 
	 * @param connection,
	 *            Connection created from the above mentioned Method.
	 * 
	 * @param sql,
	 *            sql is SQL Query
	 * @return
	 */
	public static boolean executeSQLQuery(Connection connection, String sql) {
		try {

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
