package com.springiot.services;

import java.lang.reflect.Type;
import java.util.Collections;
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
import com.springiot.constant.LatLng;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for ThirdParty Tracking APIs Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@SuppressWarnings({ "unchecked" })
public class TrackingServices {
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
	private GenericServices genericServices;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This method is used to retrieve history tracking of a vehicle
	 * 
	 * @param map,the
	 *            input paramters required to call an API
	 * @param request,the
	 *            resquest headers
	 * @param response
	 * @return
	 */
	public Message flintHistoryTrackingGetAll(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Message
		Message responseMessage = new Message();
		try {

			/*
			 * passingMap is used to store the input parameters from user which
			 * will be same as of the procedure being called upon.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();

			/*
			 * Adding some parameters to the map.
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("device_id", map.get("device_id"));
			passingMap.put("from_date", map.get("from_date"));
			passingMap.put("end_date", map.get("end_date"));

			// Initialization of Map and adding paramters to it
			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			passingNewMap.put("token", request.getHeader("token"));
			passingNewMap.put("device_id", passingMap.get("device_id"));
			passingNewMap.put("user_key", request.getHeader("user_key"));
			passingNewMap.put("user_id", request.getHeader("user_id"));
			passingNewMap.put("service_name",
					"gmr_Sensor_Latitude,gmr_Sensor_Longitude,gmr_Sensor_Humidity,gmr_Sensor_Temperature,gmr_IgnitionStatus,gmr_gpsTracker_Speed");
			passingNewMap.put("data_source",
					"gmr_Sensor_Latitude,gmr_Sensor_Longitude,gmr_Sensor_Humidity,gmr_Sensor_Temperature,gmr_IgnitionStatus,gmr_gpsTracker_Speed");
			passingNewMap.put("from_date", passingMap.get("from_date").toString());
			passingNewMap.put("end_date", passingMap.get("end_date").toString());
			passingNewMap.put("pivot_data_required", "1");
			passingNewMap.put("access_key", map.get("access_key"));
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			List<Map<String, String>> getPerformanceServiceStatusGetMany = getXfusionPerformanceServiceMultipleDevicesGetMany(
					passingNewMap, request, response);

			if (getPerformanceServiceStatusGetMany.size() > 0) {

				/*
				 * Temporary Map to store all Platform Details device wise
				 */
				Map<String, Object> liveTrackingData = new HashMap<>();
				/*
				 * To store all Manipulated Map in List
				 */
				List<Map<String, Object>> liveTrackingDataList = new LinkedList<>();

				/*
				 * To get each object and get the specific values to add in
				 * temporary map and than in list
				 */

				LinkedList<String> lat_long = new LinkedList<>();
				LinkedList<String> sysTimestamp = new LinkedList<>();
				List<Map<String, Object>> alertDataList = new LinkedList<>();
				// System.out.println("getPerformanceServiceStatusGetMany:-- " +
				// getPerformanceServiceStatusGetMany);
				for (Map<String, String> getPerformanceServiceStatusGetNewManyMap : getPerformanceServiceStatusGetMany) {

					lat_long.add("("
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_Sensor_Latitude_gmr_Sensor_Latitude")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_Sensor_Longitude_gmr_Sensor_Longitude")
							+ "," + getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_Sensor_Humidity_gmr_Sensor_Humidity")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap
									.get("gmr_Sensor_Temperature_gmr_Sensor_Temperature")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_IgnitionStatus_gmr_IgnitionStatus")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_gpsTracker_Speed_gmr_gpsTracker_Speed")
							+ ")");

					sysTimestamp.add(getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp").toString());

				}

				// Initialization of map and is used to put the alerts data into
				// that map
				LinkedHashMap<String, String> alertsMap = new LinkedHashMap<>();
				alertsMap.put("device_id", map.get("device_id"));
				alertsMap.put("from_date", map.get("from_date"));
				alertsMap.put("end_date", map.get("end_date"));
				alertsMap.put("limit", map.get("limit"));
				alertsMap.put("offset", map.get("offset"));
				alertsMap.put("in_condition", map.get("in_condition"));

				// Response retrieved after calling Platform Api is store into
				// message class
				Message alertsReponse = genericServices.alertDeviceTypeGetAllLimit(alertsMap, request);

				alertDataList = (List<Map<String, Object>>) alertsReponse.getObject();

				for (Map<String, Object> alertDataListMap : alertDataList) {

					// Get the sys timestamp of alerts
					Object time = alertDataListMap.get("sys_timestamp");

					int index = sysTimestamp.indexOf(time);

					// Check if index is greater then zero
					if (index > 0 || index == 0) {
						String alertLatLong = lat_long.get(index);
						alertDataListMap.put("alert_Lat_Long", alertLatLong);
						alertDataListMap.put("severity_colour", "Red");
					}
					// No alerts found for specific sys timestamp
					else {
						String alertLatLong = null;
						alertDataListMap.put("alert_Lat_Long", alertLatLong);
					}
				}

				// Adding parameters to the map
				liveTrackingData.put("lat_long", lat_long.toArray());
				liveTrackingData.put("alerts", alertDataList);

				liveTrackingDataList.add(liveTrackingData);

				// Set the success response
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(liveTrackingDataList);
				responseMessage.setValid(true);
				return responseMessage;
			}
			// Set the failure response
			else {
				responseMessage.setDescription("Error No Tracking Data From Platform");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to call Platform API which in turn returns
	 * performance data on the basis of devices
	 * 
	 * @param passingMap,the
	 *            input paramters required for the API Calling
	 * @return
	 */
	private List<Map<String, String>> getXfusionPerformanceServiceMultipleDevicesGetMany(
			LinkedHashMap<String, String> passingMap, HttpServletRequest request, HttpServletResponse response) {

		// Initialization of Message Class and string builder
		Message responseMessage = new Message();
		StringBuilder passingParameter = new StringBuilder();

		Map<String, String> headerMap = new LinkedHashMap<>();
		for (String key : passingMap.keySet()) {

			if (key.trim().equals("token")) {
				// get the platform token
				String token = request.getHeader("token");

				// Check the platform token is null or not
				if (token == null) {
					responseMessage.setDescription("Token is Null");
					responseMessage.setValid(false);
					return (List<Map<String, String>>) responseMessage;
				}
				// Append the parameters to string builder(passingParameter)
				// which are required to call the Platform API
				// passingParameter.append("token=" + token.getAccess_token());
				headerMap.put("token", token);

				continue;
			}
			// Append the parameters to the string builder
			if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
				headerMap.put(key, passingMap.get(key));

			} else {
				passingParameter.append("&" + key + "=" + passingMap.get(key));
			}
		}
		// Append the parameters to the string builder

		passingParameter.deleteCharAt(0);

		// Calling of Platform API and store the results into object class
		Object finalVehicleResponseMessage = urlCalling.getData(
				urlParameter.getXfusionPerformanceServiceMultipleDevicesGetMany(), passingParameter.toString(),
				headerMap);

		// Check if response retrieved from procedure is not null
		if (finalVehicleResponseMessage != null) {
			Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(finalVehicleResponseMessage.toString(), type);

			List<Map<String, String>> deviceModelObject = urlMessage.getObject();

			// Set the success response
			if (deviceModelObject != null) {
				return deviceModelObject;
			}
		}
		return null;
	}

	public Message liveTrackingGetAll(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of Message
		Message responseMessage = new Message();
		try {

			/*
			 * passingMap is used to store the input parameters from user which
			 * will be same as of the procedure being called upon.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();

			/*
			 * Adding some parameters to the map.
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("device_id", map.get("device_id"));

			// Initialization of Map and adding paramters to it
			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			passingNewMap.put("token", request.getHeader("token"));
			passingNewMap.put("device_id", passingMap.get("device_id"));
			passingNewMap.put("user_key", request.getHeader("user_key"));
			passingNewMap.put("user_id", request.getHeader("user_id"));
			passingNewMap.put("service_name",
					"gmr_Sensor_Latitude,gmr_Sensor_Longitude,gmr_Sensor_Humidity,gmr_Sensor_Temperature,gmr_IgnitionStatus,gmr_gpsTracker_Speed");
			passingNewMap.put("data_source",
					"gmr_Sensor_Latitude,gmr_Sensor_Longitude,gmr_Sensor_Humidity,gmr_Sensor_Temperature,gmr_IgnitionStatus,gmr_gpsTracker_Speed");
			passingNewMap.put("pivot_data_required", "1");
			passingNewMap.put("access_key", map.get("access_key"));
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			List<Map<String, String>> getPerformanceServiceStatusGetMany = getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(
					passingNewMap, request, response);
			if (getPerformanceServiceStatusGetMany.size() > 0) {

				/*
				 * Temporary Map to store all Platform Details device wise
				 */
				Map<String, Object> liveTrackingData = new HashMap<>();
				/*
				 * To store all Manipulated Map in List
				 */
				List<Map<String, Object>> liveTrackingDataList = new LinkedList<>();

				LinkedList<String> lat_long = new LinkedList<>();
				LinkedList<String> sysTimestamp = new LinkedList<>();
				List<Map<String, Object>> alertDataList = new LinkedList<>();

				for (Map<String, String> getPerformanceServiceStatusGetNewManyMap : getPerformanceServiceStatusGetMany) {

					lat_long.add("("
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_Sensor_Latitude_gmr_Sensor_Latitude")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_Sensor_Longitude_gmr_Sensor_Longitude")
							+ "," + getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_Sensor_Humidity_gmr_Sensor_Humidity")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap
									.get("gmr_Sensor_Temperature_gmr_Sensor_Temperature")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_IgnitionStatus_gmr_IgnitionStatus")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("gmr_gpsTracker_Speed_gmr_gpsTracker_Speed")
							+ ")");

					sysTimestamp.add(getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp").toString());

				}

				Message message = genericProcess.GenericProcedureCalling("4", null, null, request, response);

				Object poiList = message.getObject();

				List<Map<String, Object>> poiListMap = (List<Map<String, Object>>) poiList;

				String[] latLongArray = lat_long.toString().split(",");
				List<Double> getDistancesArray = new LinkedList<>();
				List<String> labelBuilderAraay = new LinkedList<>();
				List<String> latLongBuilderAraay = new LinkedList<>();
				// int i = 0;
				for (Map<String, Object> latLongMap : poiListMap) {
					StringBuilder labelBuilder = new StringBuilder();
					StringBuilder latLongBuilder = new StringBuilder();
					Double latitude = Double.parseDouble(latLongMap.get("latitude").toString());
					Double longitude = Double.parseDouble(latLongMap.get("longitude").toString());

					LatLng a = new LatLng(latLongArray);
					LatLng b = new LatLng(latitude, longitude);

					double getDistances = getDistance(a, b);

					getDistancesArray.add(getDistances);
					labelBuilder.append(latLongMap.get("label").toString());
					latLongBuilder.append(
							latLongMap.get("latitude").toString() + "," + latLongMap.get("longitude").toString());
					labelBuilderAraay.add(labelBuilder.toString());
					latLongBuilderAraay.add(latLongBuilder.toString());
					// i++;

				}
				int indexnew = getDistancesArray.indexOf(Collections.min(getDistancesArray));

				// Initialization of map and is used to put the alerts data into
				// that map
				LinkedHashMap<String, String> alertsMap = new LinkedHashMap<>();
				alertsMap.put("device_id", map.get("device_id"));
				alertsMap.put("from_date", map.get("from_date"));
				alertsMap.put("end_date", map.get("end_date"));
				alertsMap.put("limit", map.get("limit"));
				alertsMap.put("offset", map.get("offset"));
				alertsMap.put("in_condition", map.get("in_condition"));

				// Response retrieved after calling Platform Api is store into
				// message class
				Message alertsReponse = genericServices.alertDeviceTypeGetAllLimitLiveTracking(alertsMap, request);
				System.out.println("alertsReponse" + alertsReponse.getDescription());
				System.out.println("alertsReponse" + alertsReponse.getObject());

				alertDataList = (List<Map<String, Object>>) alertsReponse.getObject();

				// int count = 0;
				for (Map<String, Object> alertDataListMap : alertDataList) {
					// count++;
					// Get the sys timestamp of alerts
					Object time = alertDataListMap.get("sys_timestamp");

					int index = sysTimestamp.indexOf(time);

					// Check if index is greater then zero
					if (index > 0 || index == 0) {
						String alertLatLong = lat_long.get(index);
						alertDataListMap.put("alert_Lat_Long", alertLatLong);
						alertDataListMap.put("severity_colour", "Red");
					}
					// No alerts found for specific sys timestamp
					else {
						String alertLatLong = null;
						alertDataListMap.put("alert_Lat_Long", alertLatLong);
					}
				}

				String newPOILatLong = lat_long.get(0).replaceAll("\\)", "")
						.concat("," + labelBuilderAraay.get(indexnew) + "," + latLongBuilderAraay.get(indexnew) + ")");
				lat_long.remove(0);
				lat_long.add(newPOILatLong);
				// Adding paramters to the map
				liveTrackingData.put("lat_long", lat_long.toArray());
				liveTrackingData.put("alerts", alertDataList);

				liveTrackingDataList.add(liveTrackingData);

				// Set the success response
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(liveTrackingDataList);
				responseMessage.setValid(true);
				return responseMessage;
			}
			// Set the failure response
			else {
				responseMessage.setDescription("Error No Tracking Data From Platform");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to call Platform API which in turn returns
	 * performance data on the basis of devices
	 * 
	 * @param passingMap,the
	 *            input paramters required for the API Calling
	 * @return
	 */
	private List<Map<String, String>> getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(
			LinkedHashMap<String, String> passingMap, HttpServletRequest request, HttpServletResponse response) {

		// Initialization of Message Class and string builder
		Message responseMessage = new Message();
		StringBuilder passingParameter = new StringBuilder();

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
					return (List<Map<String, String>>) responseMessage;
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
			 * Appending every parameter in passingParameter string builder to
			 * make query string
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

		// Calling of Platform API and store the results into object class
		Object finalVehicleResponseMessage = urlCalling.getData(
				urlParameter.getXfusionPlatformPerformanceServiceStatusDevicesGetMany(), passingParameter.toString(),
				headerMap);

		// Check if response retrieved from procedure is not null
		if (finalVehicleResponseMessage != null) {
			Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(finalVehicleResponseMessage.toString(), type);

			List<Map<String, String>> deviceModelObject = urlMessage.getObject();

			// Set the success response
			if (deviceModelObject != null) {
				return deviceModelObject;
			}
		}
		return null;
	}

	/**
	 * @param a
	 *            starting point
	 * @param b
	 *            ending point
	 * @return distance between these two points
	 */
	public double getDistance(LatLng a, LatLng b) {

		double earthRadius = 6371; // in kilometers
		double dLat = Math.toRadians(b.latitude - a.latitude);
		double dLng = Math.toRadians(b.longitude - a.longitude);
		double x = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(a.latitude))
				* Math.cos(Math.toRadians(b.latitude)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
		return earthRadius * y;

	}
}
