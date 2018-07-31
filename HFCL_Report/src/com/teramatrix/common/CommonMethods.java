package com.teramatrix.common;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teramatrix.apiCalling.AccessRestApi;
import com.teramatrix.main.HfclEscalationApp;
import com.teramatrix.response.GenericMessages;

public class CommonMethods {

	public Map<String, Object> serviceNameDataSourceSum(String deviceId) {

		try {

			/**
			 * Initialize the URL and create connection.
			 */
			HashMap<String, String> params = new HashMap<>();

			params.put("device_id", deviceId);
			params.put("service_name", " ");
			params.put("data_source", " ");

			System.out.println(
					"From Date : " + HfclEscalationApp.beforeTime + " End Time : " + HfclEscalationApp.currentTime);

			params.put("from_date", HfclEscalationApp.beforeTime);
			params.put("end_date", String.valueOf(HfclEscalationApp.currentTime));
			params.put("access_key", HfclEscalationApp.accessKey);
			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.platforAPI, params);
			Type type1 = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();
			/**
			 * Getting Response in formatted way
			 */
			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, String>> urlMessageFinal = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(apiResponse.toString(), type1);
			if (urlMessageFinal.isValid()) {
				List<Map<String, String>> deviceModelObject = urlMessageFinal.getObject();

				Map<String, Double> sumMap = new LinkedHashMap<>();
				for (Map<String, String> map : deviceModelObject) {

					for (String string : map.keySet()) {

						if (sumMap.containsKey(string.concat("_sum")) && !string.equalsIgnoreCase("device_id")) {
							// if (map.get(string) == null) {
							// map.put(string, "0");
							//
							// }
							try {
								double sum = Double.parseDouble(String.valueOf(sumMap.get(string.concat("_sum"))))
										+ Double.parseDouble(String.valueOf(map.get(string)));
								sumMap.put(string.concat("_sum"), sum);
							} catch (Exception e) {
								e.printStackTrace();
								System.exit(0);
								double sum = Double.parseDouble(String.valueOf(sumMap.get(string.concat("_sum")))) + 0;
								sumMap.put(string.concat("_sum"), sum);
							}

						} else {
							try {
								sumMap.put(string.concat("_sum"), Double.parseDouble(String.valueOf(map.get(string))));
							} catch (Exception e) {
								sumMap.put(string.concat("_sum"), Double.parseDouble("0.0"));
							}
						}
					}
					sumMap.put("device_id",
							Double.parseDouble(String.valueOf(map.get("device_id")).replaceAll("\\.0", "")));
				}
				Map<String, Object> responseMap = new LinkedHashMap<>();
				responseMap.put("platformResponse", deviceModelObject);
				responseMap.put("platformSumResponse", sumMap);

				System.out.println("sumMap " + sumMap);
				return responseMap;
			}

		} catch (Exception exception) {
			System.out.println("API Connection Refused: " + exception);
			exception.printStackTrace();

		}
		return null;
	}
}
