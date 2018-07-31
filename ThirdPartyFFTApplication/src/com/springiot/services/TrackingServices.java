package com.springiot.services;

import java.lang.reflect.Type;
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
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

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

			// Initialization of Map and adding paramters to it
			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			passingNewMap.put("token", request.getHeader("token"));
			passingNewMap.put("device_id", map.get("device_id"));
			passingNewMap.put("user_key", request.getHeader("user_key"));
			passingNewMap.put("user_id", request.getHeader("user_id"));
			passingNewMap.put("service_name",
					"location_parameters,location_parameters,location_parameters,phone_parameters,host_status,phone_parameters");
			passingNewMap.put("data_source",
					"latitude,longitude,location_accuracy,device_battery_percentage,host_status,device_charging_status");
			passingNewMap.put("from_date", map.get("from_date").toString());
			passingNewMap.put("end_date", map.get("end_date").toString());
			passingNewMap.put("pivot_data_required", "1");
			// passingNewMap.put("access_key", map.get("access_key"));
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			List<Map<String, String>> getPerformanceServiceStatusGetMany = getXfusionPerformanceServiceMultipleDevicesGetMany(
					passingNewMap, request, response);
			// System.out.println("getPerformanceServiceStatusGetMany:-- " +
			// getPerformanceServiceStatusGetMany);
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

				// System.out.println("getPerformanceServiceStatusGetMany:-- " +
				// getPerformanceServiceStatusGetMany);
				for (Map<String, String> getPerformanceServiceStatusGetNewManyMap : getPerformanceServiceStatusGetMany) {
					if (getPerformanceServiceStatusGetNewManyMap.get("location_parameters_latitude") != null
							&& getPerformanceServiceStatusGetNewManyMap.get("location_parameters_longitude") != null) {
						lat_long.add("(" + getPerformanceServiceStatusGetNewManyMap.get("location_parameters_latitude")
								+ "," + getPerformanceServiceStatusGetNewManyMap.get("location_parameters_longitude")
								+ "," + getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp") + ","
								+ getPerformanceServiceStatusGetNewManyMap.get("location_parameters_location_accuracy")
								+ ","
								+ getPerformanceServiceStatusGetNewManyMap
										.get("phone_parameters_device_battery_percentage")
								+ "," + getPerformanceServiceStatusGetNewManyMap.get("host_status_host_status") + ","
								+ getPerformanceServiceStatusGetNewManyMap
										.get("phone_parameters_device_charging_status")
								+ ")");
					}

				}

				// Adding paramters to the map
				liveTrackingData.put("lat_long", lat_long.toArray());

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

		new Message();
		StringBuilder passingParameter = new StringBuilder();

		Map<String, String> headerMap = new LinkedHashMap<>();
		for (String key : passingMap.keySet()) {

			headerMap.put("token", request.getHeader("token"));

			// Append the paramters to the string builder
			if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
				headerMap.put(key, passingMap.get(key));

			} else {
				passingParameter.append("&" + key + "=" + passingMap.get(key));
			}
		}
		// Append the paramters to the string builder

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

			// Initialization of Map and adding paramters to it
			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			passingNewMap.put("token", request.getHeader("token"));
			passingNewMap.put("device_id", map.get("device_id"));
			passingNewMap.put("user_key", request.getHeader("user_key"));
			passingNewMap.put("user_id", request.getHeader("user_id"));
			passingNewMap.put("service_name",
					"location_parameters,location_parameters,location_parameters,phone_parameters,host_status,phone_parameters");
			passingNewMap.put("data_source",
					"latitude,longitude,location_accuracy,device_battery_percentage,host_status,device_charging_status");
			passingNewMap.put("pivot_data_required", "1");
			// passingNewMap.put("access_key", map.get("access_key"));
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			List<Map<String, String>> getPerformanceServiceStatusGetMany = getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(
					passingNewMap, request, response);
			System.out.println("getPerformanceServiceStatusGetMany:-- " + getPerformanceServiceStatusGetMany);
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
				 * To update device id
				 */
				int geofenceId = 0;
				Message getGeoFenceId = genericProcess.GenericProcedureCalling("15", map, null, request, response);
				if (getGeoFenceId.isValid()) {

					List<Map<String, Object>> geofenceIdList = (List<Map<String, Object>>) getGeoFenceId.getObject();
					if (geofenceIdList.size() > 0) {
						geofenceId = Integer.parseInt(String.valueOf(geofenceIdList.get(0).get("geofence_id")));
					}

				}
				LinkedList<String> lat_long = new LinkedList<>();

				for (Map<String, String> getPerformanceServiceStatusGetNewManyMap : getPerformanceServiceStatusGetMany) {

					lat_long.add("(" + getPerformanceServiceStatusGetNewManyMap.get("location_parameters_latitude")
							+ "," + getPerformanceServiceStatusGetNewManyMap.get("location_parameters_longitude") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("location_parameters_location_accuracy")
							+ ","
							+ getPerformanceServiceStatusGetNewManyMap.get("phone_parameters_device_battery_percentage")
							+ "," + getPerformanceServiceStatusGetNewManyMap.get("host_status_host_status") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("phone_parameters_device_charging_status")
							+ "," + geofenceId + ")");

				}

				// Adding paramters to the map
				liveTrackingData.put("lat_long", lat_long.toArray());

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
	List<Map<String, String>> getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(
			LinkedHashMap<String, String> passingMap, HttpServletRequest request, HttpServletResponse response) {

		new Message();
		StringBuilder passingParameter = new StringBuilder();

		Map<String, String> headerMap = new LinkedHashMap<>();
		for (String key : passingMap.keySet()) {

			headerMap.put("token", request.getHeader("token"));

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

		passingParameter.deleteCharAt(0);
		/**
		 * to print the query string
		 */

		// Calling of Platform API and store the results into object class
		Object finalVehicleResponseMessage = urlCalling.getData(
				urlParameter.getXfusionPlatformPerformanceServiceStatusDevicesGetMany(), passingParameter.toString(),
				headerMap);
		// System.out.println("getPerformanceServiceStatusGetMany:-- " +
		// finalVehicleResponseMessage);
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

}
