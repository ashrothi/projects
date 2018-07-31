/**
 * This package contains classes for processing on data.
 */
package com.teramatrix.processData;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teramatrix.apiCalling.AccessRestApi;
import com.teramatrix.logger.FftLogger;
import com.teramatrix.main.FftEscalationApp;

/**
 * This class is used for fetching data from the platform using API. Then the
 * data is sent to database by required queries.
 *
 * @author mandeepsingh
 *
 */
public class GetData {

	/**
	 * This method is used for getting the devices for a user.
	 * 
	 * @param token
	 *            : Here pass the auth token for calling api.
	 * @return List of devices got from API.
	 */
	public String devicesByUser() {

		StringBuilder operationalDevices = new StringBuilder();

		// LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
		try {

			/**
			 * Calling API using the method call.
			 */
			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(FftEscalationApp.getDevicesApiUrl,
					new HashMap<>(), "ThirdParty");

			FftLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);
			JSONArray jsonArray = outerObject.getJSONArray("object");
			FftLogger.logger.info("Number of Devices  :  " + jsonArray.length());

			for (int i = 0, size = jsonArray.length(); i < size; i++) {
				JSONObject objectInArray = jsonArray.getJSONObject(i);

				if (objectInArray.get("device_id") != null) {
					/**
					 * Retrieve required data from the response.
					 */
					Object deviceId = objectInArray.get("device_id");

					/**
					 * Convert the response parameters into String and add it to
					 * List.
					 */
					operationalDevices.append(deviceId.toString() + ",");

				}
			}
			operationalDevices.deleteCharAt(operationalDevices.lastIndexOf(","));
			FftLogger.logger.info("Complete details : " + operationalDevices.toString());

		} catch (Exception e) {
			FftLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(FftLogger.printStream);
			e.printStackTrace();
		}
		return operationalDevices.toString();
	}

	/**
	 * This method is used for getting all the performance data of a device.
	 * 
	 * @param token
	 *            : Here pass the auth token for calling api.
	 * @param deviceId
	 *            : Device if for which device, user wants to get data.
	 */
	public void performaceServiceData(String deviceId) {
		LinkedHashMap<String, String> parameters = new LinkedHashMap<>();

		/**
		 * Append the SQL query to insert the data in log table.
		 */

		try {

			parameters.put("device_id", deviceId);
			parameters.put("service_name", FftEscalationApp.serviceNames);
			parameters.put("data_source", FftEscalationApp.dataSources);
			parameters.put("pivot_data_required", "1");
			parameters.put("access_key", FftEscalationApp.accessKey);

			/**
			 * Calling API using the method call.
			 */
			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(FftEscalationApp.getDataApiUrl, parameters, "");

			FftLogger.logger.info("apiResponse  : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);
			if (outerObject.get("valid").toString().equalsIgnoreCase("true")) {
				JSONArray jsonArray = outerObject.getJSONArray("object");
				FftLogger.logger.info("Number of Records for Performance data :  " + jsonArray.length());

				/**
				 * Type casting for adding more data into the map.
				 */
				Type type1 = new TypeToken<List<Map<String, String>>>() {
				}.getType();

				/**
				 * Converting data into List of map from the JSON.
				 */
				List<Map<String, String>> dataList = new Gson().fromJson(jsonArray.toString(), type1);
				if (dataList.size() > 0) {
					for (Map<String, String> map : dataList) {
						LinkedHashMap<String, String> updateParameters = new LinkedHashMap<>();
						updateParameters.putAll(map);
						updateParameters.put("last_online_time", map.get("sys_timestamp"));
						String apiUpdateResponse = restApiCall.callingRestAPIWithHeaders(
								FftEscalationApp.updateDevicesApiUrl, updateParameters, "ThirdParty");
						FftLogger.logger.info("apiUpdateResponse :  " + apiUpdateResponse);
					}
					// GmrLogger.logger.info("Data in object :- " + data);
					FftLogger.logger.info("List size : " + dataList.size());
				}

				/**
				 * Generating insert query.
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method will get the current time and convert it into UTC epoch time.
	 * 
	 * @param currentDate
	 *            : Here pass the current date.
	 * @return The date in epoch format.
	 */
	public static String getGMTTime(Date currentDate) {

		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			/**
			 * Parse the date into format defined into df object.
			 */
			currentDate = dateTime.parse(df.format(currentDate));
			FftLogger.logger.info("Current Date & Time as UTC::" + currentDate);
			/**
			 * Get epoch time in milliseconds.
			 */
			long date = (currentDate.getTime());
			// Return the epoch time.
			return Long.toString((date));
		} catch (Exception e) {
			long date = (new Date().getTime());
			FftLogger.logger.info("Epoch Time as UTC : " + Long.toString((date)));
			// Return the epoch time.
			return Long.toString((date));
		}
	}

	public void sendEscalation() {

		/**
		 * Append the SQL query to insert the data in log table.
		 */

		try {

			/**
			 * Calling API using the method call.
			 */
			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(FftEscalationApp.escalationDevicesApiUrl,
					new HashMap<>(), "ThirdParty");

			FftLogger.logger.info("apiResponse : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);
			if (outerObject.get("valid").toString().equalsIgnoreCase("true")) {
				JSONArray jsonArray = outerObject.getJSONArray("object");
				FftLogger.logger.info("Number of Records for Performance data :  " + jsonArray.length());

				/**
				 * Type casting for adding more data into the map.
				 */
				Type type1 = new TypeToken<List<Map<String, String>>>() {
				}.getType();

				/**
				 * Converting data into List of map from the JSON.
				 */
				List<Map<String, String>> dataList = new Gson().fromJson(jsonArray.toString(), type1);

				for (Map<String, String> map : dataList) {
					map.put("alert_type", "alert");
					
					LinkedHashMap<String, String> updateParameters = new LinkedHashMap<>();
					updateParameters.putAll(map);
					String apiEscalationResponse = restApiCall.callingRestAPIWithHeaders(
							FftEscalationApp.deviceSendEscalation, updateParameters, "ThirdParty");

					FftLogger.logger.info("apiEscalationResponse : " + apiEscalationResponse);
					JSONObject outerEscalationObject;
					outerEscalationObject = new JSONObject(apiEscalationResponse);
					if (outerEscalationObject.get("valid").toString().equalsIgnoreCase("true")) {
						JSONArray jsonEscalationArray = outerEscalationObject.getJSONArray("object");
						FftLogger.logger.info("Number of Records :  " + jsonEscalationArray.length());
						if (jsonEscalationArray.length() > 0) {
							updateParameters.put("is_escalated", "1");
							updateParameters.put("escalation_time", String.valueOf(new Date().getTime()));

							String apiTrueEscalationResponse = restApiCall.callingRestAPIWithHeaders(
									FftEscalationApp.insertDevicesEscalationApiUrl, updateParameters, "ThirdParty");
							FftLogger.logger.info("apiTrueEscalationResponse : " + apiTrueEscalationResponse);
						} else {
							updateParameters.put("is_escalated", "0");
							updateParameters.put("escalation_time", String.valueOf(new Date().getTime()));
							String apiFalseEscalationResponse = restApiCall.callingRestAPIWithHeaders(
									FftEscalationApp.insertDevicesEscalationApiUrl, updateParameters, "ThirdParty");
							FftLogger.logger.info("apiFalseEscalationResponse : " + apiFalseEscalationResponse);
						}
					}

				}
				// GmrLogger.logger.info("Data in object :- " + data);
				FftLogger.logger.info("List size : " + dataList.size());

				/**
				 * Generating insert query.
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
