package com.rld.usergetdata;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.rld.connection.ConnectdB;
import com.rld.systemConfigurations.SystemConfiguration;
import rld.common.RLDEncryption;
import rld.common.impl.RLDEncrytionImpl;

public class getData {
	static String hostName;
	static String userName;
	static String port;
	static String database;
	static String tablename;
	static String password;

	/*
	 * This method is used while creating connection with databases.
	 */
	public static String dbConnection(HashMap<String, String> map) {
		hostName = map.get("Host_Name");
		userName = map.get("User_Name");
		port = map.get("Port");
		database = map.get("Database");
		tablename = map.get("Table_Name");
		password = map.get("Password");

		return null;

	}

	/*
	 * This method is used to retrieve data from MySQL once and then
	 * Simultaneously delete that data.
	 */
	public static String retrieveData(String email) throws IOException {
		System.out.println("retrieve data");

		// User Entered email in plain text we need to first encrypt it then
		// only we'll be able to match it in database and get the results from
		// the encrypted email.
		SystemConfiguration system_configuration = new SystemConfiguration();
		String macAddress;
		String mac = null;
		macAddress = system_configuration.SystemProperties();
		String decrypt_mac = macAddress.replace("-", "");
		mac = decrypt_mac + "0000";

		RLDEncryption encrypt = new RLDEncrytionImpl();
		String actualEmail = encrypt.getEncryptedData(email, mac);

		String url = "jdbc:mysql://" + hostName + ":" + port + "/" + database + "?user=" + userName + "&password="
				+ password;
		System.out.println("URL for mysql string is " + url);

		Connection connection = ConnectdB.getConnection("com.mysql.jdbc.Driver", url);
		System.out.println("Connection:- " + connection);
		// Check if some data exists for the user entered email.
		String query = "select * from " + tablename + " where encrypted_data1='" + actualEmail + "';";
		System.out.println(query);

		String result = ConnectdB.storeResult(connection, query);
		// System.out.println("Final Result is: " + result);
		System.out.println(mac);
		String data = encrypt.getDecryptData(result, mac);
		System.out.println("---------" + data);

		// After once retrieval,delete the data so that no can misuse the same
		// data.
		String sql = "delete from " + tablename + " where encrypted_data1='" + actualEmail + "';";
		System.out.println("Delete query" + sql);
		boolean flagTable1 = ConnectdB.executeSQLQuery(connection, sql);

		if (flagTable1) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Data not deleted ");
		}
		return data;

	}

	/*
	 * This method is used to retrieve data from SQL SERVER once and then
	 * Simultaneously delete that data.
	 */
	public static String retrieveDataSQLServer(String email) throws IOException, JSONException {
		SystemConfiguration system_configuration = new SystemConfiguration();

		String macAddress;
		String mac = null;
		macAddress = system_configuration.SystemProperties();
		String decrypt_mac = macAddress.replace("-", "");
		mac = decrypt_mac + "0000";

		// User Entered email in plain text we need to first encrypt it then
		// only we'll be able to match it in database and get the results from
		// the encrypted email.
		RLDEncryption encrypt = new RLDEncrytionImpl();
		String actualEmail = encrypt.getEncryptedData(email, mac);

		System.out.println("Entered in retrieving data from SQL server");
		String url = "jdbc:sqlserver://" + hostName + ":" + port + ";user=" + userName + ";password=" + password
				+ ";database=" + database;
		System.out.println("url:" + url);

		Connection connection = ConnectdB.getConnection("com.microsoft.sqlserver.jdbc.SQLServerDriver", url);
		System.out.println("Connection:- " + connection);

		String query = "select * from " + tablename + " where encrypted_data1='" + actualEmail + "';";
		System.out.println(query);

		String result = ConnectdB.storeResult(connection, query);
		// System.out.println("Final Result is: " + result);

		String data = encrypt.getDecryptData(result, mac);
		// System.out.println("Encrypted Data:" + data);

		JSONArray jarray = new JSONArray(data);
		System.out.println("***SIZE of DATA*** : " + jarray.length());
		// After once retrieval,delete the data so that no can misuse the same
		// data.
		String sql = "delete from " + tablename + " where encrypted_data1='" + actualEmail + "';";
		// System.out.println("Delete query" + sql);
		boolean flagTable1 = ConnectdB.executeSQLQuery(connection, sql);

		if (flagTable1) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Data not deleted ");
		}
		return data;
	}
}
