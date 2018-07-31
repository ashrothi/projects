package com.rld.parametersList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;
import com.rld.accessapi.AccessRestAPI;
import com.rld.common.CommonInterface;
import com.rld.dBConnection.dBMySql;
import com.rld.dBConnection.insertSqlserver;
import com.rld.message.Message;
import com.rld.systemConfigurations.SystemConfiguration;
import com.rld.vendorId.vendorId;

import rld.common.RLDEncryption;
import rld.common.impl.RLDEncrytionImpl;

/* 
 * Class is used to call the Api and get the response of Api.
 * And further check the response of Api.
 * 
 */
public class ApiCredentials {

	public static String ApiParameters(HashMap<String, String> map) {

		try {

			System.out.println("map is" + map);

			/*
			 * Accessing the Config file for the encrypted URL
			 */
			Properties properties = new Properties();
			String Directory = System.getProperty("user.dir");

			properties.load(new InputStreamReader(new FileInputStream(Directory + "/config/SDKConfig.txt")));

			for (Object key : properties.keySet()) {
				System.out.println("key:" + key);
			}
			String URL = properties.getProperty("demoGraphicHistoryReportURL");
			System.out.println("Demographic URL " + URL);

			// String vendorid = properties.getProperty("vendorId");

			/*
			 * Retrieve the system properties from SystemConfiguration class
			 * like mac address and decrypting the URL
			 */
			SystemConfiguration system_configuration = new SystemConfiguration();
			RLDEncryption url_decrypt = new RLDEncrytionImpl();

			String macAddress = system_configuration.SystemProperties();
			String decrypt_mac = macAddress.replace("-", "");
			String mac = decrypt_mac + "0000";
			System.out.println(macAddress + "," + URL);
			String decrypted_url = url_decrypt.getDecryptData(URL, mac);

			// Array for the input parameters of Api
			String inputParametersforAPI[] = { "urban", "endDate", "nccs", "megaCities", "tenTo75Lac", "rural",
					"ageGroup", "female", "startDate", "male", "isAllIndia", "email", "vendorid" };
			int count = 0;

			/**
			 * For loop is used to check that all parameters are valid for api
			 * calling,else parameters are missing
			 */
			for (int i = 0; i < inputParametersforAPI.length - 1; i++) {
				if (!map.containsKey(inputParametersforAPI[i])) {

					count = 1;
					System.out.println("Paramters by user are not specified.Please insert.. in for loop"
							+ inputParametersforAPI[i]);
				}
			}

			if (count == 0) {
				// One of the parameter of Api calling is Process list,that will
				// be
				// retrieved from System Configurations
				String OSType = System.getProperty("os.name");
				map.put("OSType", OSType);
				map.put("macAdress", macAddress);
				// map.put("vendorid", vendorid);

				/*
				 * try { ServerSocket soket = new ServerSocket(4444); } catch
				 * (UnknownHostException e) { e.printStackTrace(); } catch
				 * (IOException e) { e.printStackTrace(); }
				 */

				String processList = system_configuration.ProcessList();
				System.out.println("processList" + processList);

				Type type = new TypeToken<List<Map<String, Object>>>() {
				}.getType();

				List<Map<String, Object>> processListdata = new Gson().fromJson(processList, type);
				System.out.println("processListdata" + processListdata);

				// List<Map<String, Object>> finaldata = new LinkedList<>();

				// for (Map<String, Object> processListMap : processListdata) {
				// if
				// (processListMap.get("ProcessName").toString().contains("Tomcat"))
				// {
				// System.out.println("processListMap in if" + processListMap);
				// finaldata.add(processListMap);
				// } else {
				// System.out.println("processListMap in else" +
				// processListMap);
				//
				// }
				//
				// }

				System.out.println("finaldata" + processListdata);

				String updatedProcessList = new Gson().toJson(processListdata);
				System.out.println("updatedProcessList" + updatedProcessList);

				if (updatedProcessList != null) {
					map.put("processList", updatedProcessList);
				} else {
					System.out.println("Process List is empty");
				}
				/*
				 * Common Interface is used to call AccessRestApi class
				 */
				CommonInterface api = new AccessRestAPI();
				String output_api = api.callingRestAPI(decrypted_url, map);
				System.out.println("output_api :-" + output_api);
				/*
				 * Convert the response of Api from Json to String
				 */
				Type listTypeJson = new TypeToken<Message>() {
				}.getType();
				Message urlResponseJsonMessage = new Gson().fromJson(output_api.toString(), listTypeJson);

				/*
				 * Check the valid url response message
				 */
				if (urlResponseJsonMessage.isSuccess() == true) {
					Object objectOutputData = urlResponseJsonMessage.getData();
					Object objectOutputDatabaseProperties = urlResponseJsonMessage.getDatabaseproperties();
					Object objectOutputEmail = urlResponseJsonMessage.getEmail();

					// JSONObject jObject = new
					// JSONObject(urlResponseJsonMessage.getData().toString().trim());

					String decryptedData = url_decrypt.getDecryptData(objectOutputData.toString(), mac);

					Type listOutputData = new TypeToken<List<HashMap<String, Object>>>() {
					}.getType();
					List<HashMap<String, Object>> listData = new Gson().fromJson(decryptedData.toString(),
							listOutputData);

					List<HashMap<String, Object>> newList = new ArrayList<>();

					if (listData.size() > 500) {
						for (int i = 0; i < 5000; i++) {

							newList.add(listData.get(i));
						}
					} else {
						for (int i = 0; i < listData.size(); i++) {

							newList.add(listData.get(i));
						}
					}

					String listDataAPI = new Gson().toJson(newList);

					String encrptededData = url_decrypt.getEncryptedData(listDataAPI.toString(), mac);

					String datafromAPI = objectOutputData.toString();
					String dbPropertiesfromAPI = objectOutputDatabaseProperties.toString();
					String emailfromAPI = objectOutputEmail.toString();

					/*
					 * System.out.println("Data from API is: " + datafromAPI);
					 * System.out.println("Database Properties from API is: " +
					 * dbPropertiesfromAPI); System.out.println(
					 * "Email from API  is: " + emailfromAPI);
					 */

					HashMap<String, String> map_api = new HashMap<>();

					map_api.put("encrypted_data1", emailfromAPI);
					map_api.put("encrypted_data2", encrptededData);

					List<HashMap<String, String>> listInputParameters = new ArrayList<>();
					listInputParameters.add(map_api);
					// System.out.println("list" +
					// listInputParameters.toString());

					/**
					 * Api gives the encrypted data,there is a need to decrypt
					 * the same
					 */
					String decryptData = url_decrypt.getDecryptData(datafromAPI, mac);

					Type apiResult = new TypeToken<List<HashMap<String, String>>>() {
					}.getType();

					String apiResponse = url_decrypt.getDecryptData(dbPropertiesfromAPI, mac);

					Type dBProperties = new TypeToken<List<HashMap<String, String>>>() {
					}.getType();
					List<HashMap<String, String>> map_db = new Gson().fromJson(apiResponse.toString(), dBProperties);

					HashMap<String, String> dbMap = new HashMap<>();
					for (HashMap<String, String> hashMap : map_db) {
						dbMap.put(hashMap.get("Key"), hashMap.get("Value"));

					}
					// System.out.println(dbMap);

					// FOR SQL SERVER DATABASE TYPE
					if (dbMap.get("Database_Type").equalsIgnoreCase("SQL Server")) {
						insertSqlserver.InsertDataSQL(dbMap, listInputParameters);

					} else
					// FOR MySQL DATABASE TYPE
					{
						dBMySql.InsertData(dbMap, listInputParameters);
					}
					return apiResponse + "" + decryptData;
				}
				/*
				 * Invalid response from Api and returns invalid message from
				 * Api.
				 */

				else {
					Object objectOutput = urlResponseJsonMessage.getData();
					String data = objectOutput.toString();
					System.out.println(urlResponseJsonMessage.getDescription());
					System.out.println("Inavlid Response from Api :" + data);
					return data;

				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			return exception.getMessage();

		}
		return new String("Parameters by user are not sufficient.Please insert..");
	}
}