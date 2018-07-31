package com.springiot.deleteTokens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TokenDeletion {

	public static void main(String[] args) {

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		// ResultSet resultSet3 = null;
		Statement statement = null;
		try {

			Class.forName("org.hsqldb.jdbcDriver");

			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1:9001/RuleEngine", "SA", "");

			statement = connection.createStatement();

			// resultSet3=statement.executeQuery("SELECT name FROM
			// "+"ABCD"+"."+"TEST"+";");

			resultSet = statement.executeQuery(
					"delete from TokenStorage.auth_token where TIMESTAMPDIFF(SQL_TSI_HOUR, cast(time as datetime),CURRENT_TIMESTAMP) > 8 and token_type=0;");

			System.out.println("Deleted Token successfully");

			resultSet1 = statement.executeQuery(
					"delete from TokenStorage.platform_token where TIMESTAMPDIFF(SQL_TSI_HOUR, cast(time as datetime),CURRENT_TIMESTAMP) > 8 and token_type=0;");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				resultSet1.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
