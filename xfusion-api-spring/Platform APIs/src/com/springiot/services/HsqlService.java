/**
 * This package is used for Streaming Rule Engine to update any existing rule
 */
package com.springiot.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import com.springiot.response.Message;

/**
 * 
 * @author tanvigarg This class is used for interaction with HSQL database in
 *         streaming rule Engine to update any existing Rule.
 */
@Service
public class HsqlService {

	/**
	 * This Method is used to execute update query in hsql database.
	 * 
	 * @param driverName,
	 *            driver name for hsql
	 * @param connectionUrl,
	 *            Connection String for Hsql
	 * @param sql,
	 *            is the SQL Query needs to be exceuted in Hsql database
	 * @return
	 */
	public static Message update(String driverName, String connectionUrl, String sql) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;

		Statement statement = null;

		Message message = new Message();
		try {

			Class.forName(driverName);
			connection = DriverManager.getConnection(connectionUrl, "SA", "");

			statement = connection.createStatement();

			// System.out.println(connection);

			resultSet = statement.executeQuery(sql);

			message.setDescription("Process Success");
			message.setObject(resultSet);
			message.setValid(true);

		} catch (Exception e) {
			e.printStackTrace();

			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
		return message;

	}
}
