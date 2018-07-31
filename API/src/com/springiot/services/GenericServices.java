package com.springiot.services;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.LatLng;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

@Service
@SuppressWarnings({ "unchecked", "serial" })
public class GenericServices {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private URLParameter urlParameter;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private TrackingServices trackingServices;

	/**
	 * This method is used to call Platform API
	 * 
	 * @param map,the
	 *            input paramters required to call the API
	 * @param request
	 * @return
	 */
	public Message getMetadataStatusByTypeLimit(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of message class
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			String accesskey = "";
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * to print each parameter with its value
				 */

				/**
				 * to check if parameter has token or not
				 */
				if (key.trim().equals("token")) {

					String token = request.getHeader("token");

					/**
					 * to check if token is null than terminate API with error
					 * message
					 */
					if (token == null) {
						responseMessage.setDescription("Platform Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/**
					 * to append platform token in query string
					 */

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					// accesskey = token.getAccess_key();
					continue;
				}
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(
					urlParameter.getXfusionPlatformDeviceGetMetadataStatusByTypeLimit(), passingParameter.toString(),
					headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(urlServiceMessage.getObject());
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

	/**
	 * This method is used to call Platform API
	 * 
	 * @param map,the
	 *            input parameters required to call the API
	 * @param request
	 * @return
	 */
	public Message alertDeviceTypeGetAllLimit(Map<String, String> map, HttpServletRequest request) {
		// Initialization of message class
		Message responseMessage = new Message();
		try {

			// Initialize StringBuilder passingParameter for query string
			StringBuilder passingParameter = new StringBuilder();

			// Initialization of map and adding paramters to it
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("device_id", map.get("device_id"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("from_date", map.get("from_date"));
			passingMap.put("end_date", map.get("end_date"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			passingMap.put("in_condition", map.get("in_condition"));

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * to print each parameter with its value
				 */

				/**
				 * to check if parameter has token or not
				 */
				if (key.trim().equals("token")) {
					/**
					 * to get platform token
					 */
					String token = request.getHeader("token");
					/**
					 * to print platform token
					 */

					/**
					 * to check if token is null than terminate API with error
					 * message
					 */
					if (token == null) {
						responseMessage.setDescription("Platform Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/**
					 * to append platform token in query string
					 */

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					// accesskey = token.getAccess_key();
					continue;
				}
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */

			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(
					urlParameter.getXfusionPerformanceEventstatusAlertDeviceGetAllLimit(), passingParameter.toString(),
					headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(urlServiceMessage.getObject());
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

	/**
	 * This method is used to call active alert from calling Platform API
	 * 
	 * @param map,the
	 *            input paramters required to call the API
	 * @param request
	 * @return
	 */
	public Message alertDeviceTypeGetAllLimitLiveTracking(Map<String, String> map, HttpServletRequest request) {
		// Initialization of message class
		Message responseMessage = new Message();
		try {

			// Initialize StringBuilder passingParameter for query string
			StringBuilder passingParameter = new StringBuilder();

			// Initialization of map and adding paramters to it
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("device_id", map.get("device_id"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			passingMap.put("in_condition", map.get("in_condition"));

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * to print each parameter with its value
				 */

				/**
				 * to check if parameter has token or not
				 */
				if (key.trim().equals("token")) {
					/**
					 * to get platform token
					 */
					String token = request.getHeader("token");
					/**
					 * to print platform token
					 */

					/**
					 * to check if token is null than terminate API with error
					 * message
					 */
					if (token == null) {
						responseMessage.setDescription("Platform Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/**
					 * to append platform token in query string
					 */

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					// accesskey = token.getAccess_key();
					continue;
				}
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */

			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(urlParameter.getEventstatusAlertDeviceGetAllLimit(),
					passingParameter.toString(), headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(urlServiceMessage.getObject());
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

	public Message excelDownload(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		// Initialization of message class
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * to print each parameter with its value
				 */

				/**
				 * to check if parameter has token or not
				 */
				if (key.trim().equals("token")) {
					/**
					 * to get platform token
					 */
					String token = request.getHeader("token");
					/**
					 * to print platform token
					 */

					/**
					 * to check if token is null than terminate API with error
					 * message
					 */
					if (token == null) {
						responseMessage.setDescription("Platform Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/**
					 * to append platform token in query string
					 */

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					// accesskey = token.getAccess_key();
					continue;
				}
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */

			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(
					urlParameter.getXfusionPlatformDeviceGetMetadataStatusByTypeLimit(), passingParameter.toString(),
					headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				List<Map<String, Object>> devicesList = (List<Map<String, Object>>) urlServiceMessage.getObject();

				Message message = genericProcess.GenericProcedureCalling("4", null, null, request, response);

				Object poiList = message.getObject();

				List<Map<String, Object>> poiListMap = (List<Map<String, Object>>) poiList;
				System.out.println("devicesList " + devicesList);
				for (Map<String, Object> mapDevices : devicesList) {
					int indexnew = 0;

					List<Double> getDistancesArray = new LinkedList<>();
					List<String> labelBuilderAraay = new LinkedList<>();
					// int i = 0;
					for (Map<String, Object> latLongMap : poiListMap) {

						String serviceAlias = mapDevices.get("additional_service_alias").toString();
						String currentValue = mapDevices.get("additional_current_value").toString();
						// String aliasUnit =
						// mapDevices.get("additional_datasource_unit").toString();

						String[] serviceAliasArray = serviceAlias.split(",");

						String[] currentValueArray = currentValue.split(",");

						// String[] aliasUnitArray = aliasUnit.split(",");

						// int indexOfHumidity =
						// ArrayUtils.indexOf(serviceAliasArray, "Humidity");

						// String humidityFinal =
						// currentValueArray[indexOfHumidity];

						// int indexOfTemperature =
						// ArrayUtils.indexOf(serviceAliasArray, "Temperature");

						// String temperatureFinal =
						// currentValueArray[indexOfTemperature];

						// int indexOfIgnition =
						// ArrayUtils.indexOf(serviceAliasArray, "Ignition
						// Status");

						int indexOfLatitude = ArrayUtils.indexOf(serviceAliasArray, "Latitude");

						String LatitudeFinal = currentValueArray[indexOfLatitude];

						int indexOfLongitude = ArrayUtils.indexOf(serviceAliasArray, "Longitude");

						System.out.println("indexOfLongitude" + indexOfLongitude);

						String LongitudeFinal = currentValueArray[indexOfLongitude];
						System.out.println("LongitudeFinal " + LongitudeFinal);

						System.out.println("serviceAliasArray" + serviceAlias);
						// String ignitionFinal =
						// currentValueArray[indexOfIgnition];

						StringBuilder labelBuilder = new StringBuilder();

						Double latitudeDevice = Double.parseDouble(LatitudeFinal);
						Double longitudeDevice = Double.parseDouble(LongitudeFinal);

						Double latitude = Double.parseDouble(latLongMap.get("latitude").toString());
						Double longitude = Double.parseDouble(latLongMap.get("longitude").toString());

						LatLng a = new LatLng(latitudeDevice, longitudeDevice);
						LatLng b = new LatLng(latitude, longitude);

						double getDistances = trackingServices.getDistance(a, b);

						getDistancesArray.add(getDistances);

						labelBuilder.append(latLongMap.get("label").toString());
						labelBuilderAraay.add(labelBuilder.toString());

						// i++;

					}

					indexnew = getDistancesArray.indexOf(Collections.min(getDistancesArray));

					String checkTimestamp = mapDevices.get("check_timestamp").toString();
					String sysTimestamp = mapDevices.get("status_timestamp").toString();

					Long idleHour = Long.parseLong(sysTimestamp) - Long.parseLong(checkTimestamp);

					mapDevices.put("idle_hour", idleHour);
					mapDevices.put("poi_label", labelBuilderAraay.get(indexnew));

					String serviceAlias = mapDevices.get("additional_service_alias").toString();
					String currentValue = mapDevices.get("additional_current_value").toString();
					// String aliasUnit =
					// mapDevices.get("additional_datasource_unit").toString();

					String[] serviceAliasArray = serviceAlias.split(",");

					String[] currentValueArray = currentValue.split(",");

					// String[] aliasUnitArray = aliasUnit.split(",");

					int indexOfHumidity = ArrayUtils.indexOf(serviceAliasArray, "Humidity");

					String humidityFinal = currentValueArray[indexOfHumidity];

					int indexOfTemperature = ArrayUtils.indexOf(serviceAliasArray, "Temperature");

					String temperatureFinal = currentValueArray[indexOfTemperature];

					int indexOfIgnition = ArrayUtils.indexOf(serviceAliasArray, "Ignition Status");

					int indexOfLatitude = ArrayUtils.indexOf(serviceAliasArray, "Latitude");

					String LatitudeFinal = currentValueArray[indexOfLatitude];

					int indexOfLongitude = ArrayUtils.indexOf(serviceAliasArray, "Longitude");

					String LongitudeFinal = currentValueArray[indexOfLongitude];

					String ignitionFinal = currentValueArray[indexOfIgnition];

					mapDevices.put("Humidity", humidityFinal);
					mapDevices.put("Temperature", temperatureFinal);
					mapDevices.put("Ignition", ignitionFinal);
					mapDevices.put("Latitude", LatitudeFinal);
					mapDevices.put("Longitude", LongitudeFinal);

				}

				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(devicesList);
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			exception.printStackTrace();
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

	public Message getDeviceByUser(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		// Initialization of message class
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * to print each parameter with its value
				 */

				/**
				 * to check if parameter has token or not
				 */
				if (key.trim().equals("token")) {
					/**
					 * to get platform token
					 */
					String token = request.getHeader("token");
					/**
					 * to print platform token
					 */

					/**
					 * to check if token is null than terminate API with error
					 * message
					 */
					if (token == null) {
						responseMessage.setDescription("Platform Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/**
					 * to append platform token in query string
					 */

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					// accesskey = token.getAccess_key();
					continue;
				}
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(urlParameter.getXfusionPlatformGetDeviceByUser(),
					passingParameter.toString(), headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(urlServiceMessage.getObject());
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

	public Message getMetadataStatusByTypeLimitByRegistrationNumber(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of message class
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * to print each parameter with its value
				 */

				/**
				 * to check if parameter has token or not
				 */
				if (key.trim().equals("token")) {
					/**
					 * to get platform token
					 */
					String token = request.getHeader("token");
					/**
					 * to print platform token
					 */

					/**
					 * to check if token is null than terminate API with error
					 * message
					 */
					if (token == null) {
						responseMessage.setDescription("Platform Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/**
					 * to append platform token in query string
					 */

					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					// accesskey = token.getAccess_key();
					continue;
				}
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			// passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(
					urlParameter.getXfusionPlatformDeviceGetMetadataStatusByTypeLimit(), passingParameter.toString(),
					headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				List<Map<String, Object>> responseList = urlServiceMessage.getObject();
				System.out.println("responseList " + responseList);
				List<Object> responseFinalList = new LinkedList<>();
				Map<String, Map<String, Object>> responseListMap = new LinkedHashMap<>();
				for (Map<String, Object> map2 : responseList) {

					responseListMap.put(map2.get("device_device_alias").toString(), map2);
				}
				System.out.println("responseListMap " + responseListMap);
				for (String map2 : responseListMap.keySet()) {

					if (map.get("reg_no").contains(map2)) {
						responseFinalList.add(responseListMap.get(map2));

					}

				}
				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(responseFinalList);
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			exception.printStackTrace();
			// Set the failure response
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}
}
