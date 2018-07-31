package com.rld.dBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.rld.connection.ConnectdB;
import com.rld.constant.DynamicQuery;

/*
 * Class is used to create table and insert values into table of respective databases.
 */
public class dBMySql {

	public static String InsertData(HashMap<String, String> map, List<HashMap<String, String>> dataMap) {

		try {

			String hostName = map.get("Host_Name");
			String userName = map.get("User_Name");
			String port = map.get("Port");
			String database = map.get("Database");
			String tablename = map.get("Table_Name");
			String password = map.get("Password");
			/*
			 * Connection string of Mysql
			 */
			String connectionUrl = "jdbc:mysql://" + hostName + ":" + port + "/" + database + "?user=" + userName + "&password="
					+ password;

			// Create connection with MySQL with the driver and connection
			// String.
			Connection connectionMySQL = ConnectdB.getConnection("com.mysql.jdbc.Driver", connectionUrl);

			if (connectionMySQL == null) {
				// Creating Schema in MySQL.
				Connection newConn = ConnectdB.getConnection("com.mysql.jdbc.Driver",
						"jdbc:mysql://" + hostName + ":" + port + "/?user=" + userName + "&password=" + password);
				Integer integer = ConnectdB.createSchema(newConn, database);

				System.out.println("schema Created Successfully:- " + integer);

				if (integer > 0 && integer != null) {
					connectionMySQL = ConnectdB.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://" + hostName + ":"
							+ port + "/" + database + "?user=" + userName + "&password=" + password);
				}
			}

			System.out.println("latest:- " + connectionMySQL);
			/*
			 * Drop table if table exists else create table
			 */

			String sqlQueryMysql = "create table IF NOT EXISTS " + tablename + "(encrypted_data1 text,encrypted_data2 text)";

			boolean flagTable = ConnectdB.executeSQLQuery(connectionMySQL, sqlQueryMysql);

			if (flagTable) {
				System.out.println("Table Created Successfully.");
			}
			/*
			 * Insert query in table using Dynamic query class
			 */

			String queryMysql = "delete from " + tablename + " where encrypted_data1='"
					+ dataMap.get(0).get("encrypted_data1") + "';";
			boolean flagTable1 = ConnectdB.executeSQLQuery(connectionMySQL, queryMysql);

			if (flagTable1) {
				System.out.println("already existing value deleted");
			} else {
				System.out.println("No existing value ");
			}

			String insertQueryMysql = new DynamicQuery().createDynamicQuery(dataMap, tablename,
					"encrypted_data1,encrypted_data2");

			boolean insertStatus = ConnectdB.executeSQLQuery(connectionMySQL, insertQueryMysql);

			if (insertStatus) {
				System.out.println("Data inserted Successfully");
			}
			connectionMySQL.close();
			return null;

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	/*
	 * This method is used to insert data for Master's URL in MySQL.
	 */
	public static String insertOpenDataSQL(HashMap<String, String> map, List<HashMap<String, String>> dataMap,
			String tmptableName) {
		try {
			System.out.println("map is " + map);
			String hostName = map.get("Host_Name");
			String userName = map.get("User_Name");
			String port = map.get("Port");
			String database = map.get("Database");
			String tablename = tmptableName;
			String password = map.get("Password");
			/*
			 * Connection string of Mysql
			 */
			String connectionUrl = "jdbc:mysql://" + hostName + ":" + port + "/" + database + "?user=" + userName + "&password="
					+ password;
			// Create connection with MySql with the driver and connection string.
			Connection connectionMySQL = ConnectdB.getConnection("com.mysql.jdbc.Driver", connectionUrl);
			System.out.println("Connection:- " + connectionMySQL);

			if (connectionMySQL == null) {
				// Creating Schema in MySQL.
				Connection newConn = ConnectdB.getConnection("com.mysql.jdbc.Driver",
						"jdbc:mysql://" + hostName + ":" + port + "/?user=" + userName + "&password=" + password);
				Integer integer = ConnectdB.createSchema(newConn, database);
				System.out.println("schema Created Successfully:- " + integer);

				if (integer > 0 && integer != null) {
					connectionMySQL = ConnectdB.getConnection("com.mysql.jdbc.Driver", "jdbc:mysql://" + hostName + ":"
							+ port + "/" + database + "?user=" + userName + "&password=" + password);
				}
			}

			System.out.println("latest:- " + connectionMySQL);
			/*
			 * Drop table if table exists else create table
			 */
			System.out.println("Drop Table Status:- "
					+ ConnectdB.executeSQLQuery(connectionMySQL, "Drop table if exists " + tablename + ";"));

			StringBuilder builder = new StringBuilder();
			builder.append("create table " + tablename + " (");

			HashMap<String, String> tmpColumn = dataMap.get(0);

			for (String key : tmpColumn.keySet()) {
				builder.append("`" + key + "` varchar(40), ");
			}

			builder.deleteCharAt(builder.lastIndexOf(","));
			builder.append(")");
			
			boolean flagTable = ConnectdB.executeSQLQuery(connectionMySQL, builder.toString());
			System.out.println(flagTable);

			if (flagTable) {
				System.out.println("Table Created Successfully.");
			}
			/*
			 * Insert query in table using Dynamic query class
			 */

			String insertQueryMysql = new DynamicQuery().createDynamicQuery(dataMap, tablename,
					String.join(",", tmpColumn.keySet()));

			boolean insertStatus = ConnectdB.executeSQLQuery(connectionMySQL, insertQueryMysql);

			if (insertStatus) {
				System.out.println("Data inserted Successfully");
			}
			
			return null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
