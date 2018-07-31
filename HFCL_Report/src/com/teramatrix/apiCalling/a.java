package com.teramatrix.apiCalling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class a {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		StringBuilder result = new StringBuilder("");
		try {

			/**
			 * Initialize the URL and create connection.
			 */
			HashMap<String, String> params = new HashMap<>();

			params.put("device_id", "103");
			params.put("service_name", "");
			params.put("data_source", "");
			params.put("from_date", "1524133034000");
			params.put("end_date", "1524271453000");

			System.out.println("\n ** Api Url:"
					+ "http://192.168.1.88:7878/XFusionPlatform/performance/service/multipledevices/get/many");

			URL url = new URL("http://192.168.1.88:7878/XFusionPlatform/performance/service/multipledevices/get/many");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("token", "28f59a74-2e97-4726-8160-dbfd7f7f21c3");
			connection.setRequestProperty("user_id", "hfcl@xfusion.in");
			connection.setRequestProperty("userKey", "db4c4236-30c3-11e7-be7d-000c29e31674");

			StringBuilder urlParams = new StringBuilder();
			/**
			 * Split the parameters in key value parameters.
			 */
			// if (params.size() != 0) {
			//
			// for (String key : params.keySet()) {
			// urlParams.append(key + "=" + params.get(key) + "&");
			// }
			// urlParams.deleteCharAt(urlParams.lastIndexOf("&"));
			//
			// }

			urlParams.append(
					"device_id=103&data_source=%20&service_name=%20&from_date=1524133034000&end_date=1524271453000&access_key=d3cd4e3f-5946-11e6-9bb0-fe984cc15272");
			// String string =
			// "data={\"deviceDetails\":\"{\\\"iccid\\\":\\\"8946270044400165760\\\",\\\"imsi\\\":\\\"240276440016576\\\",\\\"msisdn\\\":\\\"46769802126\\\"}\",\"iccid\":\"8946270044400165760\",\"imsi\":\"240276440016576\",\"msisdn\":\"46769802126\",\"subscriberDetails\":\"{\\\"accountType\\\":\\\"FL\\\",\\\"title\\\":\\\"Prof\\\",\\\"firstName\\\":\\\"Ashutosh\\\",\\\"lastName\\\":\\\"Mathur\\\",\\\"preferredLanguageCode\\\":\\\"en-UK\\\",\\\"address\\\":{\\\"addressLine1\\\":\\\"B-313,Ashok
			// Nagar\\\",\\\"addressLine2\\\":\\\"\\\",\\\"city\\\":\\\"Greater
			// Noida\\\",\\\"state\\\":\\\"Uttar
			// Pradesh\\\",\\\"postalCode\\\":\\\"110096\\\",\\\"countryCode\\\":\\\"AU\\\"},\\\"communication\\\":{\\\"emailAddress\\\":\\\"ashutoshpmathur@gmail.com\\\",\\\"mobilePhone\\\":\\\"+91
			// 7838846854\\\"}}\",\"accountType\":\"FL\",\"title\":\"Prof\",\"firstName\":\"Ashutosh\",\"lastName\":\"Mathur\",\"preferredLanguageCode\":\"en-UK\",\"address\":\"B-313
			// Ashok Nagar \",\"addressLine1\":\"B-313 Ashok
			// Nagar\",\"addressLine2\":\"\",\"city\":\"Greater Noida\",\"state\":\"Uttar
			// Pradesh\",\"postalCode\":\"110096\",\"countryCode\":\"AU\",\"communication\":\"{\\\"emailAddress\\\":\\\"ashutoshpmathur@gmail.com\\\",\\\"mobilePhone\\\":\\\"+91
			// 7838846854\\\"}\",\"emailAddress\":\"ashutoshpmathur@gmail.com\",\"mobilePhone\":\"+91
			// 7838846854\",\"DateTimeStamp\":\"1526895089\",\"streetNo\":\"B-313 Ashok
			// Nagar\",\"tracking_message_header\":\"onboardingTest_83\",\"requestId\":\"onboardingTest_83\",\"returnUrl\":\"http://35.159.5.214:8280/\",\"RequestID\":\"onboardingTest_83\",\"Accept\":\"application/json\",\"country\":\"defaults|#@|NILL\",\"soapenv:Envelope\":\"{\\\"xmlns:xsd\\\":\\\"http://www.w3.org/2001/XMLSchema\\\",\\\"soapenv:Body\\\":{\\\"PublishProfileMappingResp\\\":{\\\"xmlns\\\":\\\"eSIMSubAPIService\\\",\\\"responseDescription\\\":\\\"The
			// Operation was successfully
			// completed\\\",\\\"requestID\\\":\\\"onboardingTest_83\\\",\\\"messageID\\\":\\\"ESIM
			// Controller\\\",\\\"EUICCID\\\":\\\"89033024208001090800000000100263\\\",\\\"imsiProfileList\\\":{\\\"ImsiProfileData\\\":[{\\\"ICCID\\\":8946270044400161240,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"Global\\\",\\\"FALLBACK_Type\\\":\\\"Y\\\",\\\"IMSI\\\":234509999999124,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"B\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"IN\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"A\\\",\\\"TYPE\\\":\\\"L\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"AU\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"L\\\"}]},\\\"responseCode\\\":0}},\\\"xmlns:soapenv\\\":\\\"http://schemas.xmlsoap.org/soap/envelope/\\\",\\\"xmlns:xsi\\\":\\\"http://www.w3.org/2001/XMLSchema-instance\\\"}\",\"xmlns:xsd\":\"http://www.w3.org/2001/XMLSchema\",\"soapenv:Body\":\"{\\\"PublishProfileMappingResp\\\":{\\\"xmlns\\\":\\\"eSIMSubAPIService\\\",\\\"responseDescription\\\":\\\"The
			// Operation was successfully
			// completed\\\",\\\"requestID\\\":\\\"onboardingTest_83\\\",\\\"messageID\\\":\\\"ESIM
			// Controller\\\",\\\"EUICCID\\\":\\\"89033024208001090800000000100263\\\",\\\"imsiProfileList\\\":{\\\"ImsiProfileData\\\":[{\\\"ICCID\\\":8946270044400161240,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"Global\\\",\\\"FALLBACK_Type\\\":\\\"Y\\\",\\\"IMSI\\\":234509999999124,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"B\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"IN\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"A\\\",\\\"TYPE\\\":\\\"L\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"AU\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"L\\\"}]},\\\"responseCode\\\":0}}\",\"PublishProfileMappingResp\":\"{\\\"xmlns\\\":\\\"eSIMSubAPIService\\\",\\\"responseDescription\\\":\\\"The
			// Operation was successfully
			// completed\\\",\\\"requestID\\\":\\\"onboardingTest_83\\\",\\\"messageID\\\":\\\"ESIM
			// Controller\\\",\\\"EUICCID\\\":\\\"89033024208001090800000000100263\\\",\\\"imsiProfileList\\\":{\\\"ImsiProfileData\\\":[{\\\"ICCID\\\":8946270044400161240,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"Global\\\",\\\"FALLBACK_Type\\\":\\\"Y\\\",\\\"IMSI\\\":234509999999124,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"B\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"IN\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"A\\\",\\\"TYPE\\\":\\\"L\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"AU\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"L\\\"}]},\\\"responseCode\\\":0}\",\"xmlns\":\"\",\"responseDescription\":\"The
			// Operation was successfully
			// completed\",\"requestID\":\"onboardingTest_83\",\"messageID\":\"ESIM
			// Controller\",\"EUICCID\":\"89033024208001090800000000100263\",\"imsiProfileList\":\"{\\\"ImsiProfileData\\\":[{\\\"ICCID\\\":8946270044400161240,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"Global\\\",\\\"FALLBACK_Type\\\":\\\"Y\\\",\\\"IMSI\\\":234509999999124,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"B\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"IN\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"A\\\",\\\"TYPE\\\":\\\"L\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"AU\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"L\\\"}]}\",\"ImsiProfileData\":\"[{\\\"ICCID\\\":8946270044400161240,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"Global\\\",\\\"FALLBACK_Type\\\":\\\"Y\\\",\\\"IMSI\\\":234509999999124,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"B\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"IN\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"A\\\",\\\"TYPE\\\":\\\"L\\\"},{\\\"ICCID\\\":8946270044400165760,\\\"xmlns\\\":\\\"\\\",\\\"COUNTRY\\\":\\\"AU\\\",\\\"FALLBACK_Type\\\":\\\"N\\\",\\\"IMSI\\\":240276440016576,\\\"STATE\\\":\\\"D\\\",\\\"TYPE\\\":\\\"L\\\"}]\",\"ICCID\":\"8946270044400165760\",\"COUNTRY\":\"IN\",\"FALLBACK_Type\":\"N\",\"IMSI\":\"240276440016576\",\"STATE\":\"A\",\"TYPE\":\"L\",\"responseCode\":\"0\",\"xmlns:soapenv\":\"http://schemas.xmlsoap.org/soap/envelope/\",\"xmlns:xsi\":\"http://www.w3.org/2001/XMLSchema-instance\",\"BootstrapICCID\":\"8946270044400161240\",\"ProfileSwitchType\":\"2\",\"targetProfile\":\"local\",\"responseData\":\"[{\\\"iccid\\\":\\\"8946270044400165760\\\",\\\"imsi\\\":\\\"240276440016576\\\",\\\"registrationEnabled\\\":false,\\\"userExists\\\":true,\\\"userIdentifier\\\":\\\"defaultsbaf7c4aab11a4bc99222b577a2cfc905\\\"}]\",\"registrationEnabled\":\"false\",\"userExists\":\"true\",\"userIdentifier\":\"defaultsbaf7c4aab11a4bc99222b577a2cfc905\",\"restrictedOperation\":\"CHECK_USER_EXISTS_BATCH_API\",\"purchaseExist\":\"false\",\"onb_bit\":\"1\"}";
			System.out.println("Para:   " + urlParams);
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(urlParams.toString().getBytes());
			outputStream.flush();

			/**
			 * Check for response code.
			 */
			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

				System.out.println("Response Code is:   " + connection.getResponseCode());
			} else {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			/**
			 * Store output of API into the buffer reader and print it line by line.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			String output = "";
			while ((output = reader.readLine()) != null) {
				// System.out.println(output);
				result.append(output);
			}

			/**
			 * Close the connection
			 */
			connection.disconnect();

			// System.out.println("API called.");
			// System.out.println("************************** \n" + result.toString());

			Type type1 = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();
			/**
			 * Getting Response in formatted way
			 */
			GenericMessages<Map<String, String>> urlMessageFinal = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(result.toString(), type1);
			if (urlMessageFinal.isValid()) {
				List<Map<String, String>> deviceModelObject = urlMessageFinal.getObject();

				System.out.println(deviceModelObject.size());
				Map<String, Long> sumMap = new LinkedHashMap<>();
				for (Map<String, String> map : deviceModelObject) {

					for (String string : map.keySet()) {

						// System.out.println("string ->" + string);
						if (sumMap.containsKey(string.concat("_sum")) && !string.equalsIgnoreCase("device_id")) {
							if (map.get(string) == null) {
								// System.out.println("key " + string + " value->" + map.get(string));
								map.put(string, "0");

							}
							try {
								long sum = Long.parseLong(sumMap.get(string.concat("_sum")).toString())
										+ Long.parseLong(map.get(string).toString());
								sumMap.put(string.concat("_sum"), sum);
							} catch (Exception e) {
								sumMap.put(string.concat("_sum"), (long) 0);
							}

						} else {
							try {
								sumMap.put(string.concat("_sum"), Long.parseLong(map.get(string).toString()));
							} catch (Exception e) {
								sumMap.put(string.concat("_sum"), (long) 0.0);
							}

						}

					}
					sumMap.put("device_id",
							Long.parseLong(String.valueOf(map.get("device_id")).replaceAll("\\.0", "")));
				}
				System.out.println(sumMap);
			}

		} catch (Exception exception) {
			System.out.println("API Connection Refused: " + exception);
			exception.printStackTrace();

		}
	}

}
