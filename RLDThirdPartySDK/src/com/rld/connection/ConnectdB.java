package com.rld.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

/*
 * Class is used to make connection string with databases and creating schema and executing query as well.
 */
public class ConnectdB {
	/*
	 * Method is used to make dynamic connection string with SQL SERVER and
	 * MySql.
	 */
	public static Connection getConnection(String driverName, String connectionUrl) {
		try {
			
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(connectionUrl);

			
			return connection;

		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

	/*
	 * Method is used to create schema(database) in SQL SERVER and MySql.
	 */
	public static Integer createSchema(Connection connection, String schemaName) {
		try {

			System.out.println("connection :"+connection+":-"+schemaName);
			Statement statement = connection.createStatement();
			int Result = statement.executeUpdate("CREATE DATABASE " + schemaName);
			System.out.println("result:" + Result );
			return Result;

		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/*
	 * Method is used to execute queries in SQL SERVER and MySql like creating
	 * table,inserting values into table
	 */
	public static boolean executeSQLQuery(Connection connection, String sql) {
		try {

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}

	}

	/*
	 * This method is used to store encrypted result in respective database type.
	 */
	public static String storeResult(Connection connection, String sql) {
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String data = rs.getString("encrypted_data2");
				return data;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
		return null;

	}

	/*
	 * This method is used to check if table already exists in SQL Server or not and return the result.
	 */
	public static String tableExistSQLServer(Connection connection, String sql) {
		String data = "0";
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				data = rs.getString(1);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return data;

	}
}
