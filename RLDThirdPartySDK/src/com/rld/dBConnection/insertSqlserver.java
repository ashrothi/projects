//SELECT COUNT(*) as count FROM sys.objects WHERE object_id = OBJECT_ID(N'NCCS') AND type in (N'U')

package com.rld.dBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.rld.connection.ConnectdB;
import com.rld.constant.DynamicQuery;

/*
 * Class is used to create table and insert values into table in SQL Server.
 */
public class insertSqlserver {
	public static String InsertDataSQL(HashMap<String, String> map, List<HashMap<String, String>> dataMap) {

		System.out.println("Map is: " + map);
		System.out.println("SQL SERVER");
		String hostName = map.get("Host_Name");
		String userName = map.get("User_Name");
		String port = map.get("Port");
		String database = map.get("Database");
		String tablename = map.get("Table_Name");
		String password = map.get("Password");

		try {
			/*
			 * Connection string of SQL Server
			 */
			String connectionUrl = "jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password
					+ ";database=" + database;

			System.out.println("DB Connection URL: " + connectionUrl);
			// Create connection with SQL Server with the driver and connection string.
			Connection connectionSQLServer = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", connectionUrl);

			if (connectionSQLServer == null) {
				// Creation of schema in SQL Server.
				Connection newConn = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver",
						"jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password);

				Integer integer = ConnectdB.createSchema(newConn, database);

				if (integer == 0) {
					System.out.println("schema  Created Successfully:- " + integer);
				} else {
					System.out.println("schema NOT Created Successfully:- " + integer);
				}

				if (integer == 0 && integer != null) {
					connectionSQLServer = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver",
							"jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password
									+ ";database=" + database);
				}
			}

			/*
			 * Drop table if table exists else create table
			 */

			String sqlQuerySQLServer = "SELECT COUNT(*) as count FROM sys.objects WHERE object_id = OBJECT_ID(N'" + tablename
					+ "') AND type in (N'U')";

			String TableExist = ConnectdB.tableExistSQLServer(connectionSQLServer, sqlQuerySQLServer);

			if (TableExist.equals("0")) {
				System.out.println("entered");
				String sqlServer = "create table " + tablename
						+ "(encrypted_data1 varchar(MAX),encrypted_data2 varchar(MAX))";

				boolean flagTable = ConnectdB.executeSQLQuery(connectionSQLServer, sqlServer);

				System.out.println(flagTable);

				if (flagTable) {
					System.out.println("Table Created Successfully.");
				}
				/*
				 * Delete the data for same email if exists delete it and then
				 * Insert query in table using Dynamic query class and inserts data into encrypted form,
				 */
				String query = "delete from " + tablename + " where encrypted_data1='"
						+ dataMap.get(0).get("encrypted_data1") + "';";
				boolean flagTable1 = ConnectdB.executeSQLQuery(connectionSQLServer, query);
				if (flagTable1) {
					System.out.println("deleted successfully");
				}

				String insertQuerySqlServer = new DynamicQuery().createDynamicQuery(dataMap, tablename,
						"encrypted_data1,encrypted_data2");

				boolean insertStatus = ConnectdB.executeSQLQuery(connectionSQLServer, insertQuerySqlServer);

				if (insertStatus) {
					System.out.println("Data inserted Successfully");
				}
			} else {
				// If table already exists,then firstly delete the contents from table of the same email_id.
				System.out.println("Table already exists");

				String querySqlServer = "delete from " + tablename + " where encrypted_data1='"
						+ dataMap.get(0).get("encrypted_data1") + "';";
				boolean flagTable1 = ConnectdB.executeSQLQuery(connectionSQLServer, querySqlServer);
				if (flagTable1) {
					System.out.println("deleted successfully");
				}

				String insertQuerySqlServer = new DynamicQuery().createDynamicQuery(dataMap, tablename,
						"encrypted_data1,encrypted_data2");

				boolean insertStatus = ConnectdB.executeSQLQuery(connectionSQLServer, insertQuerySqlServer);

				if (insertStatus) {
					System.out.println("Data inserted Successfully");
				}
			}

			// System.out.println(dataMap);
			return null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

	/*
	 * This method is used to insert data into SQL SERVER and inserts data in decrypted form.
	 */
	public static String insertOpenDataSQL(HashMap<String, String> map, List<HashMap<String, String>> dataMap,
			String tmpTableName) {

		System.out.println("map is " + map);
		System.out.println("SQL SERVER");
		String hostName = map.get("Host_Name");
		String userName = map.get("User_Name");
		String port = map.get("Port");
		String database = map.get("Database");
		String tablename = tmpTableName;
		String password = map.get("Password");

		try {
			/*
			 * Connection string of SQL Server
			 */
			String url = "jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password
					+ ";database=" + database;
			System.out.println("url:" + url);
	
			// Create connection with driver andconnection string.
			Connection connection = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", url);
			System.out.println("Connection:- " + connection);

			if (connection == null) {
				// Schema is create
				Connection newConn = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver",
						"jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password);

				System.out.println(
						"jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password);

				System.out.println("connection:" + newConn);

				Integer integer = ConnectdB.createSchema(newConn, database);
				if (integer == 0) {
					System.out.println("schema NOT Created Successfully:- " + integer);
				} else {
					System.out.println("schema Created Successfully:- " + integer);
				}

				if (integer > 0 && integer != null) {
					connection = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver",
							"jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password="
									+ password);
				}
			}

			/*
			 * Drop table if table exists else create table
			 */
			System.out.println("Drop Table Status:- " + ConnectdB.executeSQLQuery(connection,
					"if object_id('" + tablename + "') is not null drop table " + tablename));

			StringBuilder sb = new StringBuilder();
			sb.append("create table " + tablename + " (");

			HashMap<String, String> tmpColumn = dataMap.get(0);

			for (String key : tmpColumn.keySet()) {
				sb.append("" + key + " varchar(40), ");
			}

			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append(")");

			System.out.println(sb.toString());
			boolean flagTable = ConnectdB.executeSQLQuery(connection, sb.toString());

			System.out.println(flagTable);

			if (flagTable) {
				System.out.println("Table Created Successfully.");
			}
			/*
			 * Insert query in table using Dynamic query class
			 */
			String insertQuery = new DynamicQuery().createDynamicQuery(dataMap, tablename,
					String.join(",", tmpColumn.keySet()));

			System.out.println(insertQuery);
			boolean insertStatus = ConnectdB.executeSQLQuery(connection, insertQuery);

			if (insertStatus) {
				System.out.println("Data inserted Successfully");
			}
			// System.out.println(dataMap);
			return null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

}
