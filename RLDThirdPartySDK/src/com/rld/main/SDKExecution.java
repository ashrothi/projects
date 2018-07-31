package com.rld.main;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.rld.apicalling.*;
import com.rld.dBConnection.dBMySql;
import com.rld.dBConnection.insertSqlserver;
import com.rld.parametersList.ApiCredentials;
import com.rld.systemConfigurations.SystemConfiguration;

import rld.common.RLDEncryption;
import rld.common.impl.RLDEncrytionImpl;

public class SDKExecution {
	public String Email;

	public Object pushDemographicData(String startDate, String endDate, String nccs, String ageGroup, boolean male,
			boolean female, boolean isAllIndia, String megaCities, String tenTo75Lac, String urban, String rural,
			String email, String vendorId) throws IOException, ClassNotFoundException, SQLException {
		System.out.println("---------Inside Push Demographic Data--------");
		/*
		 * The parameters entered by user are stored in HashMap for further use.
		 */
		try {
			Email = email;
			System.out.println("Email==" + Email);

			LinkedHashMap<String, String> map = new LinkedHashMap<>();
			map.put("urban", urban);
			map.put("endDate", endDate);
			map.put("nccs", nccs);
			map.put("megaCities", megaCities);
			map.put("tenTo75Lac", tenTo75Lac);
			map.put("rural", rural);
			map.put("ageGroup", ageGroup);
			map.put("female", String.valueOf(female));
			map.put("startDate", startDate);
			map.put("male", String.valueOf(male));
			map.put("isAllIndia", String.valueOf(isAllIndia));
			map.put("email", email);
			// map.put("ipAddress", SystemConfiguration.systemPublicIP());
			map.put("vendorid", vendorId);
			/*
			 * Calling of ApiParameters method of ApiCredentials class to
			 * validate the URL and add the process list as well as MAC address
			 * in parameters of Api.
			 */
			String apiResponse = ApiCredentials.ApiParameters(map);

			return apiResponse;
		} catch (Exception exception) {
			exception.getMessage();
			return exception.getMessage();
		}

	}

	/*
	 * This method is used to insert/push Master's Data in database where it can
	 * be MySQL or SQL Server. The input parameter required for this method is
	 * Email.
	 */
	public String pushMasters(String email, String vendorId) throws IOException {
		System.out.println("---------Inside Push Masters--------");
		// Accessing the method GetMaster's API and get the result after calling
		// API.
		HashMap<String, String> openApiresponse = AccessOpenAPI.GetMastersApi(email, vendorId);
		System.out.println("dbPoperties:" + openApiresponse.get("databaseProperties"));

		// Initializing other classes.
		SystemConfiguration system_configuration = new SystemConfiguration();
		RLDEncryption url_decrypt = new RLDEncrytionImpl();
		HashMap<String, String> dbMap = new HashMap<>();

		String macAddress;
		String mac = "";
		String dbProperty;
		macAddress = system_configuration.SystemProperties();
		String decrypt_mac = macAddress.replace("-", "");
		mac = decrypt_mac + "0000";

		// Decrypting the response retrieved from API,considering mac
		// address as a key.
		dbProperty = url_decrypt.getDecryptData(openApiresponse.get("databaseProperties"), mac);
		System.out.println(dbProperty);

		// Conversion of data into List of Hashmaps
		Type dBProperties = new TypeToken<List<HashMap<String, String>>>() {
		}.getType();
		List<HashMap<String, String>> map_db = new Gson().fromJson(dbProperty.toString(), dBProperties);

		for (HashMap<String, String> hashMap : map_db) {
			dbMap.put(hashMap.get("Key"), hashMap.get("Value"));
		}
		System.out.println(dbMap);

		for (String key : openApiresponse.keySet()) {
			System.out.println(key);
		}

		for (String key : openApiresponse.keySet()) {
			if (!key.equalsIgnoreCase("databaseProperties")) {
				String tableName = key;
				String encryptValue = openApiresponse.get(key);
				String decryptVlaue = url_decrypt.getDecryptData(encryptValue, mac);
				System.out.println(decryptVlaue);

				if (dbMap.size() > 0 && decryptVlaue.length() > 0) {
					Type dbType = new TypeToken<List<HashMap<String, String>>>() {
					}.getType();

					List<HashMap<String, String>> data = new Gson().fromJson(decryptVlaue, dbType);

					// FOR SQL SERVER DATABASE TYPE
					if (dbMap.get("Database_Type").equalsIgnoreCase("SQL Server")) {
						insertSqlserver insert = new insertSqlserver();
						insert.insertOpenDataSQL(dbMap, data, key);

					}
					// FOR MySQL DATABASE TYPE
					else {
						dBMySql Mysql = new dBMySql();
						Mysql.insertOpenDataSQL(dbMap, data, key);
					}
				}
			}
		}
		return "";
	}
}
