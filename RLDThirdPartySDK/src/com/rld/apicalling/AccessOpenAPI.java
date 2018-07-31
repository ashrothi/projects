package com.rld.apicalling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Properties;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.rld.accessapi.AccessRestAPI;
import com.rld.common.CommonInterface;
import com.rld.main.SDKExecution;
import com.rld.message.Message;
import com.rld.systemConfigurations.SystemConfiguration;
import rld.common.RLDEncryption;
import rld.common.impl.RLDEncrytionImpl;

public class AccessOpenAPI {

	/*
	 * This Method is used to load config file to get Master's URL first and
	 * then decrypt the URL and get the response from API And pushes/inserts
	 * data into respective databases.
	 */
	public static HashMap<String, String> GetMastersApi(String email, String vendorId) {
		System.out.println("open api");

		// Loading of Config File with exception handling.
		Properties properties = new Properties();
		String Directory = System.getProperty("user.dir");

		String macAddress = "";

		SystemConfiguration system_configuration = new SystemConfiguration();
		RLDEncryption url_decrypt = new RLDEncrytionImpl();

		try {
			properties.load(new InputStreamReader(new FileInputStream(Directory + "/config/SDKConfig.txt")));

			String getMastersURL = properties.getProperty("mastersURL");
			// String vendorid = properties.getProperty("vendorId");
			// Reading the required variables from Config File.

			System.out.println("Encrypted url for open Api" + getMastersURL);

			/*
			 * Decryption Process for the Master's URL.
			 */
			macAddress = system_configuration.SystemProperties();
			System.out.println("mac:" + macAddress);

			String decrypt_mac = macAddress.replace("-", "");
			String mac = decrypt_mac + "0000";

			System.out.println("mac:" + macAddress + ", master url:" + getMastersURL);
			String decrypted_url = url_decrypt.getDecryptData(getMastersURL, mac);
			System.out.println("Decrypted url is:" + decrypted_url);

			HashMap<String, String> mapOpenApi = new HashMap<>();
			SDKExecution object = new SDKExecution();

			// Input Parameters required for calling of Master's API.
			mapOpenApi.put("vendorId", vendorId);
			mapOpenApi.put("macAddress", macAddress);
			mapOpenApi.put("email", email);

			// Calling of Master's API.
			CommonInterface api = new AccessRestAPI();
			String outputApi = api.callingRestAPI(decrypted_url, mapOpenApi);

			Type listTypeJson = new TypeToken<Message>() {
			}.getType();
			Message urlResponseJsonMessage = new Gson().fromJson(outputApi.toString(), listTypeJson);

			HashMap<String, String> map = new HashMap<>();

			if (urlResponseJsonMessage.isSuccess() == true) {
				map.put("NCCS", urlResponseJsonMessage.getNCCS());
				map.put("AgeGroup", urlResponseJsonMessage.getAgeGroup());
				map.put("StateGroup", urlResponseJsonMessage.getStateGroup());
				map.put("databaseProperties", urlResponseJsonMessage.getDatabaseproperties().toString());

			} else {
				System.out.println("No response from Api.");

			}
			return map;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}