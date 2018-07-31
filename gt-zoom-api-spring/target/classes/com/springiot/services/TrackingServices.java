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
			passingNewMap.put("from_date", passingMap.get("from_date").toString());
			passingNewMap.put("end_date", passingMap.get("end_date").toString());
			passingNewMap.put("pivot_data_required", "1");
			passingNewMap.put("access_key", map.get("access_key"));
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			// List<Map<String, String>> getPerformanceServiceStatusGetMany =
			// getXfusionPerformanceServiceMultipleDevicesGetMany(
			// passingNewMap, request, response);
			List<Map<String, String>> getPerformanceServiceStatusGetMany = genericProcess.getPlatformData(passingMap,
					request, urlParameter.getXfusionPerformanceServiceMultipleDevicesGetMany());

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

					lat_long.add("(" + getPerformanceServiceStatusGetNewManyMap.get("location_latitude") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("location_longitude") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("host_status_host_status") + ")");

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
				Message alertsReponse = alertDeviceTypeGetAllLimit(alertsMap, request);

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
			passingNewMap.put("service_name", "location,location,host_status");
			passingNewMap.put("data_source", "latitude,longitude,host_status");
			passingNewMap.put("pivot_data_required", "1");

			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			// List<Map<String, String>> getPerformanceServiceStatusGetMany =
			// getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(
			// passingNewMap, request, response);
			//

			List<Map<String, String>> getPerformanceServiceStatusGetMany = genericProcess.getPlatformData(passingNewMap,
					request, urlParameter.getXfusionPlatformPerformanceServiceStatusDevicesGetMany());

			if (getPerformanceServiceStatusGetMany.size() > 0) {

				/*
				 * Temporary Map to store all Platform Details device wise
				 */
				Map<String, Object> liveTrackingData = new HashMap<>();
				/*
				 * To store all Manipulated Map in List
				 */
				List<Map<String, Object>> liveTrackingDataList = new LinkedList<>();

				LinkedList<Object> lat_long = new LinkedList<>();
				LinkedList<Object> sysTimestamp = new LinkedList<>();
				List<Map<String, Object>> alertDataList = new LinkedList<>();

				for (Map<String, String> getPerformanceServiceStatusGetNewManyMap : getPerformanceServiceStatusGetMany) {

					lat_long.add("(" + getPerformanceServiceStatusGetNewManyMap.get("location_latitude") + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("location_longitude") + ","
							+ String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp")) + ","
							+ getPerformanceServiceStatusGetNewManyMap.get("host_status_host_status") + ")");

					sysTimestamp.add(getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp"));

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
				Message alertsReponse = alertDeviceTypeGetAllLimitLiveTracking(alertsMap, request);
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
						String alertLatLong = (String) lat_long.get(index);
						alertDataListMap.put("alert_Lat_Long", alertLatLong);
						alertDataListMap.put("severity_colour", "Red");
					}
					// No alerts found for specific sys timestamp
					else {
						String alertLatLong = null;
						alertDataListMap.put("alert_Lat_Long", alertLatLong);
					}
				}

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

	List<Map<String, Object>> getXfusionPerformanceServiceMultipleDevicesGetMany(
			LinkedHashMap<String, String> passingMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			new Message();
			StringBuilder passingParameter = new StringBuilder();

			/**
			 * To Make query string to call platform API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * Retrieving the xFusion Platform Token
				 */

				headerMap.put("token", request.getHeader("token"));

				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);

			/*
			 * Calling Platform API
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(
					urlParameter.getXfusionPerformanceServiceMultipleDevicesGetMany(), passingParameter.toString(),
					headerMap);
			/**
			 * To check if response is not null
			 */
			System.out.println("finalVehicleResponseMessage:- " + finalVehicleResponseMessage);
			if (finalVehicleResponseMessage != null) {
				Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();
				/**
				 * Casting response in formatted way
				 */
				GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();

				/**
				 * Returning response
				 */
				if (deviceModelObject != null) {
					return deviceModelObject;
				}
			}
			return (List<Map<String, Object>>) finalVehicleResponseMessage;
		} catch (Exception e) {
			throw e;
		}

	}

	public Message trackingDeviceGetAll(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Message
		Message responseMessage = new Message();
		try {
			// List<Map<String, Object>> mergedList = new LinkedList<>();

			Message procedureMessage = genericProcess.GenericProcedureCalling("6", map, null, request, response);
			if (procedureMessage.isValid()) {
				List<Map<String, Object>> deviceInfoProcList = (List<Map<String, Object>>) procedureMessage.getObject();
				if (deviceInfoProcList.size() > 0) {
					/*
					 * passingMap is used to store the input parameters from
					 * user which will be same as of the procedure being called
					 * upon.
					 */
					LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();

					/*
					 * Adding some parameters to the map.
					 */
					passingMap.put("token", request.getHeader("token"));
					passingMap.put("user_key", request.getHeader("user_key"));
					passingMap.put("user_id", request.getHeader("user_id"));
					passingMap.put("device_id", String.valueOf(deviceInfoProcList.get(0).get("device_list")));
					passingMap.put("service_name", "location,location,host_status");
					passingMap.put("data_source", "latitude,longitude,host_status");
					passingMap.put("pivot_data_required", "1");

					// List<Map<String, String>> performanceStatusData =
					// getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(
					// passingMap, request, response);
					List<Map<String, String>> performanceStatusData = genericProcess.getPlatformData(passingMap,
							request, urlParameter.getXfusionPlatformPerformanceServiceStatusDevicesGetMany());

					for (Map<String, String> map2 : performanceStatusData) {
						for (Map<String, Object> deviceInfoProcListmap2 : deviceInfoProcList) {

							if (deviceInfoProcListmap2.get("mobile_device_id").toString()
									.equalsIgnoreCase(String.valueOf(map2.get("device_id")).replace(".0", ""))) {
								deviceInfoProcListmap2.putAll(map2);
							}
						}

					}

					responseMessage.setDescription("Process Success");
					responseMessage.setValid(true);
					responseMessage.setObject(deviceInfoProcList);

					return responseMessage;
				} else {
					responseMessage.setDescription("No Vehicle Data from DB");
					responseMessage.setValid(false);
					return responseMessage;
				}

			} else {
				responseMessage.setDescription("No Vehicle Data from DB");
				responseMessage.setValid(false);
				return responseMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
		Message message = new Message();
		try {
			List<Map<String, String>> deviceData = genericProcess.getPlatformData(map, request,
					urlParameter.getXfusionPerformanceEventstatusAlertDeviceGetAllLimit());

			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(deviceData);

			return message;

		} catch (Exception e) {
			message.setDescription("Process Fail " + e.getMessage());
			message.setValid(true);

			return message;

		}

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
		Message message = new Message();
		try {
			List<Map<String, String>> deviceData = genericProcess.getPlatformData(map, request,
					urlParameter.getEventstatusAlertDeviceGetAllLimit());

			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(deviceData);

			return message;

		} catch (Exception e) {
			message.setDescription("Process Fail " + e.getMessage());
			message.setValid(true);

			return message;

		}
	}
}
