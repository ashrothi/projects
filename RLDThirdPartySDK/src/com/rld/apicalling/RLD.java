package com.rld.apicalling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.json.JSONException;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.rld.accessapi.AccessRestAPI;
import com.rld.common.CommonInterface;
import com.rld.dBConnection.dBMySql;
import com.rld.dBConnection.insertSqlserver;
import com.rld.main.*;
import com.rld.message.Message;
import com.rld.systemConfigurations.SystemConfiguration;
import com.rld.usergetdata.getData;

import rld.common.RLDEncryption;
import rld.common.impl.RLDEncrytionImpl;

public class RLD {
	/*
	 * This method is used to retreive Demographic data after calling API.
	 * Firstly,loading the config file and retrieving the encrypted url and then
	 * decrypt it. Then,API is being called and again decrypts response of API
	 * and pushs/inserts data in respective databases.
	 */
	public static Object GetDemographicData(String email, String vendorId) throws IOException, JSONException {
		System.out.println("---------Inside Get Demographic Data--------");

		HashMap<String, String> mapdbApi = new HashMap<>();
		Properties properties = new Properties();
		String Directory = System.getProperty("user.dir");

		// Loading of Config File with exception handling.
		try {
			properties.load(new InputStreamReader(new FileInputStream(Directory + "/config/SDKConfig.txt")));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Reading the required variables from Config File.
		String getDabasePropertyURL = properties.getProperty("databasePropertyURL");
		// String vendorId = properties.getProperty("vendorId");

		/*
		 * Decryption Process for the Database Property URL.
		 */
		SystemConfiguration system_configuration = new SystemConfiguration();
		RLDEncryption url_decrypt = new RLDEncrytionImpl();

		String macAddress = "";
		macAddress = system_configuration.SystemProperties();
		System.out.println("mac:" + macAddress);
		String decrypt_mac = macAddress.replace("-", "");
		String mac = decrypt_mac + "0000";
		System.out.println(mapdbApi);
		System.out.println("mac:" + macAddress + ", master url:" + getDabasePropertyURL);
		String decrypted_url = url_decrypt.getDecryptData(getDabasePropertyURL, mac);

		// Input Parameters required for calling of API.
		mapdbApi.put("vendorId", vendorId);
		mapdbApi.put("macAddress", macAddress);

		SDKExecution object = new SDKExecution();
		mapdbApi.put("email", email);
		System.out.println("Email id: " + email);

		// Calling of API.
		CommonInterface api = new AccessRestAPI();
		String outputApi = api.callingRestAPI(decrypted_url, mapdbApi);

		Type listTypeJson = new TypeToken<Message>() {
		}.getType();
		Message urlResponseJsonMessage = new Gson().fromJson(outputApi.toString(), listTypeJson);

		Object objectOutput = urlResponseJsonMessage.getDatabaseproperties();
		String data = objectOutput.toString();
		System.out.println("Encrypted Response from API: " + data);

		// API Response is decrypted considering mac address as key.
		String decryptData = url_decrypt.getDecryptData(data, mac);

		Type dBProperties = new TypeToken<List<HashMap<String, String>>>() {
		}.getType();
		List<HashMap<String, String>> map_db = new Gson().fromJson(decryptData.toString(), dBProperties);

		HashMap<String, String> dbMap = new HashMap<>();
		for (HashMap<String, String> hashMap : map_db) {
			dbMap.put(hashMap.get("Key"), hashMap.get("Value"));
		}

		// System.out.println("map:" + dbMap);

		// FOR SQL SERVER DATABASE TYPE
		if (dbMap.get("Database_Type").equalsIgnoreCase("SQL Server")) {
			getData.dbConnection(dbMap);
			String encriptData = getData.retrieveDataSQLServer(email);
			// System.out.println("Encripted Data:- " + encriptData);

			return encriptData;

		}
		// For MySQL DATABASE TYPE
		else {
			getData.dbConnection(dbMap);
			getData.retrieveData(email);
		}

		// Returning the response from API being called.
		if (urlResponseJsonMessage.isSuccess() == true) {

			// System.out.println(urlResponseJsonMessage.getDescription());
			// System.out.println("MAP DB API" + mapdbApi);
			return mapdbApi;
		} else {
			objectOutput = urlResponseJsonMessage.getData();
			data = objectOutput.toString();
			// System.out.println(urlResponseJsonMessage.getDescription());
			// System.out.println("Inavlid Response from Api :" + data);
			// System.out.println("No response from Api.");
			return new HashMap<>();
		}
	}
}
