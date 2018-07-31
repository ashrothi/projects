package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

/**
 * This Class to Define XFusionService services For API's.
 * 
 * @author Teramatrix
 *
 */
@Service
@Transactional
@SuppressWarnings({ "unchecked" })
public class XFusionService {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * performanceDeviceGetAllServiceStatus() method used to retrieve the
	 * passingParameter of respective API
	 * 
	 * @param map
	 *            : Here pass the parameters to be passed into the API.
	 * @return response for this controller in message format.
	 */
	public Message performanceDeviceGetAllServiceStatus(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		/**
		 * Store the data source we want to show in API response.
		 */
		String[] statusDataSources = { "latitude", "longitude", "speed", "engine_speed", "running_speed",
				"battery_voltage", "throttle_opening_width", "engine_load", "coolant_temperature",
				"instantaneous_fuel_Consumption", "average_fuel_consumption", "total_fuel_consumption_volume",
				"single_fuel_volume", "driving_range", "total_mileage", "current_Error_code_numbers",
				"harsh_acceleration_no", "harsh_brake_no", "total_ignition_no", "total_driving_time",
				"total_idling_time", "average_hot_start_time", "average_speed", "history_highest_speed",
				"history_highest_rotation", "total_harsh_acceleration_no", "engine_status", "total_harsh", "score" };

		/**
		 * convert the array into the set.
		 */
		Set<String> statusResponse = new HashSet<>(Arrays.asList(statusDataSources));

		try {
			/**
			 * Initialize the required objects.
			 */
			StringBuilder passingParameter = new StringBuilder();
			
			map.put("token", request.getHeader("token"));
			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));
			
			//String accesskey = "";
			Map<String, String> headerMap = new LinkedHashMap<>();
			/**
			 * Iterate over the keys of the parameter's map.
			 */
			for (String key : map.keySet()) {

				if (key.trim().equals("token")) {
					Token token = (Token) Constant.tokenMap.get(map.get(key).trim());

					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}

					headerMap.put("token", token.getAccess_token());
					//accesskey = token.getAccess_key();
					continue;
				}

				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, map.get(key));

				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}

			}
			//passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			//System.out.println("Send Data:- " + passingParameter);

			// Calling the api xfusionperformanceDeviceStatusDeviceGetAll for
			// getting the data.
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionperformanceDeviceStatusDeviceGetAll(),
					passingParameter.toString(), headerMap);
			//System.out.println("result Object:- " + urlResponseResult);

			/**
			 * Check if the response is not null.
			 */
			if (urlResponseResult != null) {

				/**
				 * Cast the received response into the message object.
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				/**
				 * Check if the response is valid or not.
				 */
				if (urlMessage.isValid()) {

					/**
					 * Getting the object section from the API response.
					 */
					if (urlMessage.getObject() != null) {
						List<Map<String, Object>> responseList = (List<Map<String, Object>>) urlMessage.getObject();
						List<Map<String, Object>> finalStatusResponse = new LinkedList<Map<String, Object>>();

						/**
						 * Iterate over each map of the response.
						 */
						for (Map<String, Object> map2 : responseList) {
							/**
							 * Check if the data source in the response is
							 * engine_status and the value is 0.
							 */
							if (map2.get("data_source").toString().equalsIgnoreCase("engine_status")
									&& map2.get("current_value").toString().equalsIgnoreCase("0")) {
								for (Map<String, Object> map3 : responseList) {
									/**
									 * Check if data source is engine_speed then
									 * set required value to the map.
									 */
									if (map3.get("data_source").toString().equalsIgnoreCase("engine_speed")) {
										map3.remove("current_value");
										map3.put("current_value", 0);
									}
									/**
									 * Check if data source is engine_load then
									 * set required value to the map.
									 */
									if (map3.get("data_source").toString().equalsIgnoreCase("engine_load")) {
										map3.remove("current_value");
										map3.put("current_value", 0);
									}
									/**
									 * Check if data source is running_speed
									 * then set required value to the map.
									 */
									if (map3.get("data_source").toString().equalsIgnoreCase("running_speed")) {
										map3.remove("current_value");
										map3.put("current_value", 0);
									}
								}
							}
						}
						// System.out.println("SET: " + statusResponse);

						/**
						 * Iterate over map again to filter the unwanted
						 * data_sources from the set.
						 */
						for (Map<String, Object> map2 : responseList) {
							if (statusResponse.contains(map2.get("data_source").toString())) {
								// System.out.println(map2.get("data_source".toString()));
								finalStatusResponse.add(map2);
							}
						}

						responseMessage.setDescription("Get Performance Device Get All Service Status");
						responseMessage.setObject(finalStatusResponse);

						responseMessage.setValid(true);

						return responseMessage;
					} else {
						responseMessage.setDescription("Get Performance Device Get All Service Status");
						responseMessage.setObject(urlMessage.getObject());

						responseMessage.setValid(true);

						return responseMessage;
					}

				} else {
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		responseMessage.setDescription("Cannot Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	
	
	/**
	 * performanceDeviceGetAllStatus() method used to retreive the
	 * passingParameter of respective API
	 * 
	 * @param map
	 * @return responseMessage
	 */
	@SuppressWarnings("serial")
	public Message performanceDeviceGetAllStatus(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		
		/**
		 * Store the data source we want to show in API response.
		 */
		String[] statusDataSources = { "latitude", "longitude", "speed", "engine_speed", "running_speed",
				"battery_voltage", "throttle_opening_width", "engine_load", "coolant_temperature",
				"instantaneous_fuel_Consumption", "average_fuel_consumption", "total_fuel_consumption_volume",
				"single_fuel_volume", "driving_range", "total_mileage", "current_Error_code_numbers",
				"harsh_acceleration_no", "harsh_brake_no", "total_ignition_no", "total_driving_time",
				"total_idling_time", "average_hot_start_time", "average_speed", "history_highest_speed",
				"history_highest_rotation", "total_harsh_acceleration_no", "engine_status", "total_harsh", "score" };
		/**
		 * convert the array into the set.
		 */
		Set<String> statusResponse = new HashSet<>(Arrays.asList(statusDataSources));
		
		try {
			StringBuilder passingParameter = new StringBuilder();
			//String accesskey = "";
			Map<String, String> headerMap = new LinkedHashMap<>();
			
			map.put("token", request.getHeader("token"));
			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));
			
			for (String key : map.keySet()) {
				if (key.trim().equalsIgnoreCase("token")) {
					Token token = (Token) Constant.tokenMap.get(map.get(key).trim());

					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}

					headerMap.put("token", token.getAccess_token());
					//accesskey = token.getAccess_key();
					continue;
				}

				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, map.get(key));

				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			// System.out.println("Send Data:- " + passingParameter);

			Object urlResponseResult = urlCalling.getData(
					urlParameter.getXfusionperformanceDeviceStatusDeviceGetAll(), passingParameter.toString(),
					headerMap);

			// System.out.println("result Object:- " + urlResponseResult);

			if (urlResponseResult != null) {

				Type type = new com.google.common.reflect.TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();

				GenericMessages<Map<String, String>> genericMessages = new Gson().fromJson(urlResponseResult.toString(),
						type);

				List<Map<String, String>> resultUrlList = genericMessages.getObject();
				List<Map<String, String>> finalStatusResponse = new LinkedList<Map<String, String>>();
				// System.out.println("SET: " + statusResponse);

				/**
				 * Iterate over map again to filter the unwanted
				 * data_sources from the set.
				 */
				for (Map<String, String> map2 : resultUrlList) {
					if (statusResponse.contains(map2.get("data_source").toString())) {
						// System.out.println(map2.get("data_source".toString()));
						finalStatusResponse.add(map2);
					}
				}
				
				Object parameter = genericService.executeProcesure(null,
						processParameter.getMaps().get("4").toString());

				List<Map<String, String>> parameterList = new Gson().fromJson(parameter.toString(), List.class);

				Object finalData = getFinalData(finalStatusResponse, parameterList);

				//System.out.println(finalData);

				if (finalData != null) {

					responseMessage.setDescription("Get Performance Device Get All Service Status");
					responseMessage.setObject(finalData);
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(finalData);
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		responseMessage.setDescription("Can Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * getFinalData() method used to retreive the passingParameter of respective
	 * API
	 * 
	 * @param resultUrlList
	 * @param parameterList
	 * @return responseMessage
	 */
	private Object getFinalData(List<Map<String, String>> resultUrlList, List<Map<String, String>> parameterList) {

		try {

			System.out.println("resultUrlList: \n " + resultUrlList);
			System.out.println("parameter resultUrlList \n" + parameterList);
			List<Map<String, String>> updatedList = new ArrayList<Map<String, String>>();

			if (!finalData(resultUrlList, parameterList)) {

				return resultUrlList;
			} else {

				for (Map<String, String> map : resultUrlList) {
					boolean checkDataSource = false;

					for (String key : map.keySet()) {

						if (key.equalsIgnoreCase("service_name")) {

							for (Map<String, String> paramMap : parameterList) {
								if (map.get(key).toString().trim().equalsIgnoreCase(paramMap.get(key).toString().trim())
										&& map.get("data_source").toString().trim()
												.equalsIgnoreCase(paramMap.get("data_source").toString().trim())) {
									checkDataSource = true;
								}
							}
						}
					}

					if (checkDataSource) {
						map.put("current_value", "0");
					}
					updatedList.add(map);
				}

				return updatedList;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultUrlList;
	}

	/**
	 * finalData() method used to retreive the passingParameter of respective
	 * API
	 * 
	 * @param resultUrlList
	 * @param parameterList
	 * @return responseMessage
	 */
	private boolean finalData(List<Map<String, String>> resultUrlList, List<Map<String, String>> parameterList) {

		try {

			if (parameterList.size() > 0) {

				Map<String, String> mapPara = parameterList.get(0);

				for (Map<String, String> mapOfListData : resultUrlList) {

					for (String key : mapOfListData.keySet()) {

						if (key.equalsIgnoreCase("service_name")) {

							String valueService = mapOfListData.get(key).toString().trim();
							String valueDataSource = mapOfListData.get("data_source").toString().trim();

							if (valueService.equalsIgnoreCase(mapPara.get(key).toString().trim())
									&& valueDataSource.equalsIgnoreCase(mapPara.get("data_source").toString().trim())) {
								if (mapOfListData.get("current_value").toString().trim().equalsIgnoreCase("0")) {
									return true;
								}
							}

						}
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * DeviceGetAllByUser() method used to retreive the passingParameter of
	 * respective API
	 * 
	 * @param map
	 * @return responseMessage
	 */
	public Message DeviceGetAllByUser(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			List resultUrlList = new ArrayList<>();
			StringBuilder passingParameter = new StringBuilder();
			
			map.put("token", request.getHeader("token"));
			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));
			
			//String accesskey = "";
			Map<String, String> headerMap = new LinkedHashMap<>();
			Map<String, String> procMap = new LinkedHashMap<>();
			for (String key : map.keySet()) {
				if (key.trim().equals("token")) {
					Token token = (Token) Constant.tokenMap.get(map.get(key).trim());

					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token.getAccess_token());
					//accesskey = token.getAccess_key();
					continue;
				}

				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, map.get(key));
					procMap.put(key, map.get(key));

				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}

			}
			//passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			// System.out.println("Send Data:- " + passingParameter);

			Object vehicleDevices = urlCalling.getData(urlParameter.getXfusionDeviceGetByUser(),
					passingParameter.toString(), headerMap);

			//System.out.println("result vehicleDevices:- " + vehicleDevices);
			// System.out.println("result userDevices:- " + userDevices);

			if (vehicleDevices != null) {

				Type listType = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();

				GenericMessages<Map<String, Object>> vehicleDeviceMessage = new Gson()
						.fromJson(vehicleDevices.toString(), listType);

				if (vehicleDeviceMessage.isValid()) {

					for (Map<String, Object> deviceFromPlatformMap : vehicleDeviceMessage.getObject()) {
						if (deviceFromPlatformMap.get("device_device_device_id") != null) {

							String id = deviceFromPlatformMap.get("device_device_device_id").toString().replaceAll(".0", "");

							/**
							 * Adding device id which is not assigned to any user in
							 * deviceProcessingList
							 */
							if (id.equalsIgnoreCase(map.get("device_id"))) {
								resultUrlList.add(deviceFromPlatformMap);
							}

						}
					}

					responseMessage.setDescription("Get Device By Users.");
					responseMessage.setObject(resultUrlList);
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					responseMessage.setDescription("Not Found.");
					responseMessage.setObject(vehicleDeviceMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		responseMessage.setDescription("Can Not Get Data.");
		responseMessage.setValid(false);
		return responseMessage;

	}

}
