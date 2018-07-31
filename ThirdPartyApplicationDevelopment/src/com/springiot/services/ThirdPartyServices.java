package com.springiot.services;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;
import com.springiot.service.processing.GeoAddress;

/**
 * This Class is used to Define ThirdPartyServices services For API's
 * 
 * @author Mandeep Singh
 *
 */
@Service
public class ThirdPartyServices {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * tripServices() method to Get device_id and their corresponding Trip_no
	 * 
	 * @param requestType
	 *            : Here pass the type of request i.e. Post or get.
	 * @param map
	 *            : Here pass the required parameters.
	 * @return message : returns the response.
	 */
	@SuppressWarnings("unchecked")
	public Message tripServices(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * Initialize the required objects.
		 */
		Message message = new Message();
		List<Map<Object, Object>> mergedList = new LinkedList<>();
		try {

			/**
			 * Setting values into the map for calling procedure.
			 */
			Map<String, String> procPassingMap = new LinkedHashMap<>();
			// procPassingMap.put("user_key", request.getHeader("user_key"));
			// procPassingMap.put("user_id", request.getHeader("user_id"));
			procPassingMap.put("device_id", map.get("device_id"));

			/**
			 * GenericProcedureCalling method is used for calling the stored
			 * procedure.
			 */
			Message procedureMessage = genericProcess.GenericProcedureCalling("3", procPassingMap, null, request,
					response);
			// System.out.println("Proc Response: " +
			// procedureMessage.getObject());

			/**
			 * Storing the information of device into list retrieved from the
			 * procedure.
			 */
			List<Map<String, Object>> deviceInfoProcList = (List<Map<String, Object>>) procedureMessage.getObject();

			/**
			 * Setting value into the map for calling xFusion Platform API.
			 */
			Map<String, String> passingTempMap = new LinkedHashMap<>();
			passingTempMap.put("token", request.getHeader("token"));
			passingTempMap.put("device_id", map.get("device_id"));
			passingTempMap.put("user_key", request.getHeader("user_key"));
			passingTempMap.put("user_id", request.getHeader("user_id"));
			passingTempMap.put("service_name", "score");
			passingTempMap.put("data_source", "list_count");
			passingTempMap.put("from_date", map.get("from_date"));
			passingTempMap.put("end_date", map.get("end_date"));

			StringBuilder passingTempParameter = new StringBuilder();
			String accesskey = "";
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingTempMap.keySet()) {

				if (key.trim().equals("token")) {
					Token token = (Token) Constant.tokenMap.get(passingTempMap.get(key).trim());

					if (token == null) {
						message.setDescription("Token is Null");
						message.setValid(false);
						return message;
					}

					headerMap.put("token", token.getAccess_token());
					accesskey = token.getAccess_key();
					continue;
				}

				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingTempMap.get(key));

				} else {
					passingTempParameter.append("&" + key + "=" + passingTempMap.get(key));
				}
			}
			passingTempParameter.append("&access_key=" + accesskey);
			passingTempParameter.deleteCharAt(0);

			System.out.println("Send Data:- " + passingTempParameter);

			// Calling API xfusionperformanceDeviceStatusDeviceGetAll.
			Object urlResponse = urlCalling.getData(urlParameter.getXfusionPerformanceServiceMultipleDevicesGetMany(),
					passingTempParameter.toString(), headerMap);
			System.out.println("urlResponseResult" + urlResponse);

			/**
			 * Casting response into the map of generic message.
			 */
			Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			/**
			 * Getting response in formatted way as requried.
			 */
			GenericMessages<Map<String, Object>> urlMessage1 = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);
			/**
			 * Getting response in List of Map.
			 */
			List<Map<String, Object>> listSize = urlMessage1.getObject();
			// System.out.println("Response from XFplatform API" + listSize);

			/**
			 * Check if response list is not empty.
			 */
			if (listSize != null) {

				/**
				 * Getting each map from the response for retrieving the
				 * required values.
				 */
				for (Map<String, Object> map2 : listSize) {
					List<Map<Object, Object>> trackingList = new LinkedList<>();
					List<Map<Object, Object>> tripList = new LinkedList<>();

					Object temporaryListNumbers = map2.get("current_value");
					StringBuilder strBuildDataSource = new StringBuilder();
					StringBuilder strBuildServiceName = new StringBuilder();

					/**
					 * Appending Service_Name and Data_Source into StringBuilder
					 * for calling API.
					 */
					for (int i = 0; i < Integer.parseInt(temporaryListNumbers.toString()); i++) {
						strBuildDataSource.append(
								"lat_list_" + (i + 1) + ",long_list_" + (i + 1) + ",time_list_" + (i + 1) + ",");
						strBuildServiceName.append("score" + ",score" + ",score" + ",");
					}

					String listDataSource = strBuildDataSource.substring(0, strBuildDataSource.lastIndexOf(","));
					String listServiceName = strBuildServiceName.substring(0, strBuildServiceName.lastIndexOf(","));

					System.out.println("DataSource: " + listDataSource);
					System.out.println("ServiceName: " + listServiceName);

					Map<String, Object> passingMap = new LinkedHashMap<>();
					passingMap.put("token", request.getHeader("token"));
					passingMap.put("device_id", map.get("device_id"));
					passingMap.put("user_key", request.getHeader("user_key"));
					passingMap.put("user_id", request.getHeader("user_id"));
					passingMap.put("service_name", "score,score,score,score," + listServiceName);
					passingMap.put("data_source", "total_distance,score,start_time,end_time," + listDataSource);
					passingMap.put("from_date", map2.get("sys_timestamp"));
					passingMap.put("end_date", map2.get("check_timestamp"));

					StringBuilder passingParameter = new StringBuilder();
					Message urlMessage = new Message();

					Map<String, String> headerNewMap = new LinkedHashMap<>();
					for (String key : passingMap.keySet()) {

						if (key.trim().equals("token")) {
							Token token = (Token) Constant.tokenMap.get(passingMap.get(key).toString().trim());

							if (token == null) {
								message.setDescription("Token is Null");
								message.setValid(false);
								return message;
							}

							headerNewMap.put("token", token.getAccess_token());

							continue;
						}

						if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
							headerNewMap.put(key, passingMap.get(key).toString());

						} else {
							passingParameter.append("&" + key + "=" + passingMap.get(key));
						}

					}
					passingParameter.append("&access_key=" + accesskey);
					passingParameter.deleteCharAt(0);
					System.out.println("Send Data:- " + passingParameter);

					// Calling xFusionperformanceDeviceStatusDeviceGetAll API.
					Object urlResponseResult = urlCalling.getData(
							urlParameter.getXfusionPerformanceServiceMultipleDevicesGetMany(),
							passingParameter.toString(), headerNewMap);
					System.out.println("API Response: " + urlResponseResult);

					/**
					 * Casting response into the Message format.
					 */
					urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
					/**
					 * Cast message into the List of map.
					 */
					trackingList = (List<Map<Object, Object>>) urlMessage.getObject();
					System.out.println("********************** \n \n " + trackingList);
					/**
					 * Check if tracking list is not empty.
					 */
					if (trackingList.size() > 0) {

						/**
						 * Initialize the required objects.
						 */
						StringBuilder tempLatList = new StringBuilder();
						StringBuilder tempLongList = new StringBuilder();
						StringBuilder tempTimeList = new StringBuilder();
						/**
						 * Initialize the required variables.
						 */
						String timeStamp = "";
						String distanceCovered = "";
						String driverScore = "";

						/**
						 * Iterate over the List of map.
						 */
						for (Map<Object, Object> map3 : trackingList) {

							/**
							 * Combining the lat_list, long_list and time_list
							 * from retrieved chunks of them.
							 */
							for (Object key : map3.keySet()) {
								if (key.equals("data_source")) {
									for (int i = 0; i < Integer.parseInt(temporaryListNumbers.toString()); i++) {
										if (map3.get("data_source").toString()
												.equalsIgnoreCase("lat_list_" + (i + 1))) {

											tempLatList.append(map3.get("current_value").toString() + ",");
										}

										if (map3.get("data_source").toString()
												.equalsIgnoreCase("long_list_" + (i + 1))) {

											tempLongList.append(map3.get("current_value").toString() + ",");
										}

										if (map3.get("data_source").toString()
												.equalsIgnoreCase("time_list_" + (i + 1))) {

											tempTimeList.append(map3.get("current_value").toString() + ",");
										}
										if (map3.get("data_source").toString().equalsIgnoreCase("score")) {
											timeStamp = map3.get("sys_timestamp").toString();
											driverScore = map3.get("current_value").toString();

										}
										if (map3.get("data_source").toString().equalsIgnoreCase("total_distance")) {
											distanceCovered = map3.get("current_value").toString();

										}
									}
								}
							}

						}
						HashMap<Object, Object> tmpMap = new HashMap<>();

						/**
						 * Put all values into the temporary map.
						 */

						System.out.println("tempLatList " + tempLatList);
						tmpMap.put("lat_list", tempLatList.toString().substring(0, tempLatList.lastIndexOf(",")));
						tmpMap.put("long_list", tempLongList.toString().substring(0, tempLongList.lastIndexOf(",")));
						tmpMap.put("time_list", tempTimeList.toString().substring(0, tempTimeList.lastIndexOf(",")));
						tmpMap.put("sys_timestamp", timeStamp);
						tmpMap.put("total_distance", distanceCovered);
						tmpMap.put("score", driverScore);

						tripList.add(tmpMap);
					}
					// System.out.println("tracking : " + tripList);
					/**
					 * Add temporary lists into the merged list.
					 */
					mergedList.addAll(tripList);
				}

			}
			// System.out.println("MergedList: " + mergedList);

			/**
			 * Check if mergedList is not empty.
			 */
			if (mergedList != null) {

				int trip_no = 1;

				/**
				 * Initialize the required objects.
				 */
				List<Map<Object, Object>> tripTempList = new LinkedList<>();
				List<List<Map<Object, Object>>> finaltripList = new LinkedList<>();

				/**
				 * Iterate over the merged list.
				 */
				for (Map<Object, Object> map2 : mergedList) {

					tripTempList = new LinkedList<>();

					/**
					 * Split comma separated values into the array.
					 */
					Object[] lattitude = map2.get("lat_list").toString().split(",");
					Object[] longitude = map2.get("long_list").toString().split(",");
					Object[] sys_timestamp = String.valueOf(map2.get("time_list")).split(",");
					// System.out.println("Lat: " + lattitude.length);
					// System.out.println("Long: " + longitude.length);
					// System.out.println("Time: " + sys_timestamp.length);

					/**
					 * Iterate over the numbers of values into the lat_list,
					 * long_list and time_list.
					 */
					for (int i = 0; i < longitude.length; i++) {
						Map<Object, Object> tempTripMap = new LinkedHashMap<>();

						int len = longitude.length - 1;
						/**
						 * Check if its first lat-long than determine the
						 * location in address.
						 */
						if (i == 0) {
							double latitude = Double.parseDouble(lattitude[i].toString());

							double longitudeNew = Double.parseDouble(longitude[i].toString());
							String destination_address = GeoAddress.getLocationInfo(latitude, longitudeNew)
									.replaceAll("\"", "");
							tempTripMap.put("latitude", lattitude[i]);
							tempTripMap.put("longitude", longitude[i]);
							tempTripMap.put("sys_timestamp", sys_timestamp[i]);
							tempTripMap.put("trip_no", trip_no);
							tempTripMap.put("address", destination_address);
							tempTripMap.put("distance", map2.get("total_distance"));
							tempTripMap.put("score", map2.get("score"));
						}
						/**
						 * Check if its last lat-long than determine the
						 * location in address.
						 */
						else if (i == len) {
							double latitude = Double.parseDouble(lattitude[i].toString());

							double longitudeNew = Double.parseDouble(longitude[i].toString());
							String destination_address = GeoAddress.getLocationInfo(latitude, longitudeNew)
									.replaceAll("\"", "");
							tempTripMap.put("latitude", lattitude[i]);
							tempTripMap.put("longitude", longitude[i]);
							tempTripMap.put("sys_timestamp", sys_timestamp[i]);
							tempTripMap.put("trip_no", trip_no);
							tempTripMap.put("address", destination_address);
							tempTripMap.put("distance", map2.get("total_distance"));
							tempTripMap.put("score", map2.get("score"));
						}
						/**
						 * Set lat-long without address expect first and last.
						 */
						else {
							tempTripMap.put("latitude", lattitude[i]);
							tempTripMap.put("longitude", longitude[i]);
							tempTripMap.put("sys_timestamp", sys_timestamp[i]);
							tempTripMap.put("trip_no", trip_no);
							tempTripMap.put("address", null);
							tempTripMap.put("distance", map2.get("total_distance"));
							tempTripMap.put("score", map2.get("score"));
						}

						tripTempList.add(tempTripMap);
					}

					/**
					 * Add single final trip list into this list.
					 */
					finaltripList.add(tripTempList);
					trip_no++;
				}
				/**
				 * Add final trips lists into this list for object.
				 */
				deviceInfoProcList.get(0).put("trips", finaltripList);

				message.setDescription("Success");
				message.setObject(deviceInfoProcList);
				message.setValid(true);
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();

			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
	}

	/**
	 * This method is used to convert date and time according to database
	 * format.
	 * 
	 * @param dateStr
	 *            : Here pass the date.
	 * @return date in required format.
	 */
	public String convertDate(String dateStr) {

		DateFormat readFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
		DateFormat writeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = readFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (date != null) {
			String formattedDate = writeFormat.format(date);

			return formattedDate;
		} else {
			return "";
		}
	}

	/**
	 * This method is used to validate token from authorization engine respect
	 * to the persistent token.
	 * 
	 * @param parameterMap
	 *            : Here pass the map contains he input parameters required for
	 *            the calling of this procedure
	 * @param token_type,this
	 *            means that the token is for web or for mobile.
	 * @param request,the
	 *            http servlet request required for the headers.
	 * @param response,the
	 *            http servlet response required for the headers.
	 * @return responseMessage,the message class is returned as response.
	 */
	@SuppressWarnings("unchecked")
	public Message validateToken(Map<String, String> parameterMap, Integer token_type, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();

		// Remove access key from the map.
		parameterMap.remove("access_key");

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		// Retrieve from where the request is coming to API
		String RequestType = request.getHeader("User-Agent");
		System.out.println("type" + RequestType);

		parameterMap.put("token_type", token_type.toString());

		try {
			// Initilaizing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : parameterMap.keySet()) {

				// Get the Authorization token
				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", parameterMap.get("user_key"));
					headerMap.put("user_id", parameterMap.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + parameterMap.get(key));
				}

			}
			passingParameter.delete(0, 1);

			/*
			 * Calling of Authorization Engine API and retrieve the results in
			 * Object urlResponseResult
			 */
			System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getOAuthValidateToken(), passingParameter.toString(),
					headerMap);

			System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}
}
