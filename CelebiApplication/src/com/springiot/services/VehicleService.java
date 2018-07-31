/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

/**
 * 
 * This class work as a Service class for Vehicle Controller contains all the
 * services of Vehicles APui
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@SuppressWarnings({ "unchecked", "serial", "unused" })
@PropertySource(value = "classpath:/UserCreate.properties")
public class VehicleService {
	@Autowired
	Environment environment;
	@Autowired
	private HttpURLCalling urlCalling;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private OAUTHTokenServices tokenServices;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private ThirdPartyServices thirdPartyServices;

	/**
	 * To retrieve the vehicle type * This method is used to get all vehicles types
	 * the basis of Role Name,When Role Name is Vehicle or Vehicle then we'll use
	 * third party dB procedure else we'll use the xFUsion Platform API's to get the
	 * user_ids_list on the basis of particular role name and then third party
	 * procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetVehicleType(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list ", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// }
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("17", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			} else {

				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

	}

	/**
	 * To get all Vehicle Criteria * This method is used to get all notifications
	 * based in some criteria on the basis of Role Name,When Role Name is Vehicle or
	 * Vehicle then we'll use third party dB procedure else we'll use the xFUsion
	 * Platform API's to get the use keys list and user id's list on the basis of
	 * particular role name and then third party procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetAllCriteria(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		/*
		 * Initialize Passing parameter query string to call platform API
		 */
		StringBuilder passingParameter = new StringBuilder();
		try {

			/*
			 * Adding Parameters to Map
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			// /*
			// * Check condition whether role name is Vehicle or Vehicle
			// */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			// }
			// /*
			// * If Role name is other than Vehicle and Vehicle
			// */
			// else {
			// /*
			// * removing role_name parameter
			// */
			// passingMap.remove("role_name");
			// /**
			// * Getting organization ids
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// }
			// passingMap.putAll(map);
			// /*
			// * GenericProcedureCalling() method is called to check the accuracy
			// * of input parameters.
			// */
			passingMap.putAll(map);
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("19", passingMap, null,
					request, response);

			return finalProductResponseMessage;
			// /*
			// * Casting response in list of Map
			// */
			// List<Map<String, Object>> responseList = (List<Map<String, Object>>)
			// finalProductResponseMessage
			// .getObject();
			// /**
			// * Initialize StringBuilder deviceIdBuilder to get all device Ids
			// * comma separated
			// */
			// StringBuilder deviceIdBuilder1 = new StringBuilder();
			//
			// responseList.forEach((hashMap) -> {
			// if (hashMap.get("vehicle_device_device_id") != null) {
			// /*
			// * append Device Id in deviceIdBuilder
			// */
			// deviceIdBuilder1.append(hashMap.get("vehicle_device_device_id") + ",");
			// /*
			// * Manipulation of pickup_location
			// */
			// if (hashMap.get("pickup_location") != null) {
			//
			// String value = hashMap.get("pickup_location").toString();
			//
			// hashMap.put("pickup_location", value.substring(0, value.indexOf(")") + 1));
			//
			// } else {
			// hashMap.put("pickup_location", hashMap.get("pickup_location"));
			// }
			// /*
			// * Manipulation of pickup_date
			// */
			// if (hashMap.get("pickup_date") != null) {
			//
			// if (hashMap.get("pickup_date").toString().contains("#x#f#")) {
			// String value = hashMap.get("pickup_date").toString();
			// String creation_time = value.substring(0,
			// value.indexOf("#x#f#")).replace("#x#f#", "");
			//
			// try {
			// hashMap.put("pickup_date", convertDateInEpoch(creation_time));
			// } catch (Exception e) {
			//
			// e.printStackTrace();
			// }
			//
			// } else {
			// String value = hashMap.get("pickup_date").toString();
			//
			// try {
			// hashMap.put("pickup_date", convertDateInEpoch(value));
			// } catch (Exception e) {
			//
			// e.printStackTrace();
			// }
			// }
			//
			// } else {
			// hashMap.put("pickup_date", hashMap.get("pickup_date"));
			// }
			// /*
			// * Manipulation of all attributes star with pickup and
			// * sending them only first value of coming array in response
			// */
			// for (String key : hashMap.keySet()) {
			// if (key.contains("pickup")) {
			// if (hashMap.get(key) != null) {
			// if (hashMap.get(key).toString().contains("#x#f#")) {
			// String value = hashMap.get(key).toString();
			//
			// hashMap.put(key, value.substring(0, value.indexOf("#x#f#")).replace("#x#f#",
			// ""));
			//
			// } else {
			// String value = hashMap.get(key).toString();
			//
			// hashMap.put(key, value);
			// }
			// } else {
			// hashMap.put(key, hashMap.get(key));
			// }
			//
			// }
			//
			// }
			//
			// }
			// });
			//
			// /*
			// * Setting the parameters for calling Platform API
			// */
			// LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			//
			// passingNewMap.put("device_id", deviceIdBuilder1.toString());
			// /*
			// * Calling Performance Service Status Get Many api of Platform
			// */
			// List<Map<String, String>> getPerformanceServiceStatusGetMany =
			// getPerformanceServiceStatusGetMany(
			// passingNewMap, request);
			// /*
			// * Temporary Map to store all Platform Details device wise
			// */
			//
			// /*
			// * To store all Manipulated Map in List
			// */
			// List<Map<String, Object>> liveTrackingDataList = new LinkedList<>();
			// /*
			// * To update device id
			// */
			// // System.out.println("getPerformanceServiceStatusGetMany " +
			// // getPerformanceServiceStatusGetMany);
			//
			// liveTrackingDataList = new LinkedList<>();
			// if (getPerformanceServiceStatusGetMany.size() > 0) {
			// StringBuilder DeviceIdBuilder = new StringBuilder();
			// // String device_id =
			// // getPerformanceServiceStatusGetMany.get(0).get("device_id").toString();
			// for (Map<String, String> getPerformanceServiceStatusGetNewManyMap :
			// getPerformanceServiceStatusGetMany) {
			// /*
			// * To get the data of same device ids
			// */
			// Map<String, Object> liveTrackingData = new HashMap<>();
			// System.out.println(
			// "1221111 " +
			// String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("device_id")));
			// liveTrackingData.put("device_id",
			// String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("device_id")));
			// liveTrackingData.put("Battery", String
			// .valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Battery")));
			//
			// liveTrackingData.put("Accuracy", String
			// .valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Accuracy")));
			//
			// liveTrackingData.put("Latitude", String
			// .valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Latitude")));
			//
			// liveTrackingData.put("Longitude", String
			// .valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Longitude")));
			//
			// liveTrackingData.put("Rotation", String
			// .valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Rotation")));
			//
			// liveTrackingData.put("host_status",
			// String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("host_status_host_status")));
			//
			// liveTrackingData.put("sys_timestamp",
			// String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp")));
			// DeviceIdBuilder.append(liveTrackingData.get("device_id").toString().replace(".0",
			// "") + ",");
			// liveTrackingDataList.add(liveTrackingData);
			// }
			//
			// System.out.println("liveTrackingDataList++" + liveTrackingDataList);
			// /*
			// * Add Temporary map in List
			// */
			//
			// DeviceIdBuilder.deleteCharAt(DeviceIdBuilder.lastIndexOf(","));
			// /*
			// * To merge both Platform data with Temporary list with
			// * Thirdparty API on the Basis of same device _id
			// */
			// for (Map<String, Object> map2 : responseList) {
			// for (Map<String, Object> liveTrackingNewData : liveTrackingDataList) {
			// /**
			// * To merge data with certain test cases
			// */
			// if (String.valueOf(map2.get("vehicle_device_device_id")).replace(".0", "")
			// .equalsIgnoreCase(liveTrackingNewData.get("device_id").toString().replace(".0",
			// ""))) {
			// /*
			// * If ticket id is null than add default values in
			// * following parameters
			// */
			// if (map2.get("ticket_id") == null) {
			//
			// map2.putAll(liveTrackingNewData);
			// map2.remove("pickup_lat");
			// map2.remove("pickup_long");
			// map2.remove("dropoff_lat");
			// map2.remove("dropoff_long");
			// map2.remove("pickup_address");
			// map2.remove("dropoff_address");
			// map2.put("pickup_lat", String.valueOf(map2.get("vehicle_default_lat")));
			// map2.put("pickup_long", String.valueOf(map2.get("vehicle_default_long")));
			// map2.put("dropoff_lat", String.valueOf(map2.get("vehicle_default_lat")));
			// map2.put("dropoff_long", String.valueOf(map2.get("vehicle_default_long")));
			// map2.put("pickup_address",
			// String.valueOf(map2.get("vehicle_default_address")));
			// map2.put("dropoff_address",
			// String.valueOf(map2.get("vehicle_default_address")));
			// map2.put("current_lat",
			// Float.parseFloat(String.valueOf(map2.get("vehicle_default_lat"))));
			// map2.put("current_long",
			// Float.parseFloat(String.valueOf(map2.get("vehicle_default_long"))));
			//
			// } else {
			//
			// map2.putAll(liveTrackingNewData);
			//
			// }
			//
			// }
			// /*
			// * If no data came from the platform for device id than
			// * Add Default Parameter in Current Lat and Current long
			// */
			// else if (map2.get("vehicle_device_device_id") != null &&
			// !DeviceIdBuilder.toString()
			// .contains(map2.get("vehicle_device_device_id").toString())) {
			//
			// if (map2.get("ticket_id") == null)
			// map2.remove("pickup_lat");
			// map2.remove("pickup_long");
			// map2.remove("pickup_address");
			// map2.put("pickup_lat", String.valueOf(map2.get("vehicle_default_lat")));
			// map2.put("pickup_long", String.valueOf(map2.get("vehicle_default_long")));
			// map2.put("pickup_address",
			// String.valueOf(map2.get("vehicle_default_address")));
			// map2.put("current_lat",
			// Float.parseFloat(String.valueOf(map2.get("vehicle_default_lat"))));
			// map2.put("current_long",
			// Float.parseFloat(String.valueOf(map2.get("vehicle_default_long"))));
			// }
			// /*
			// * If Device id is null than Add default in all
			// * parameter
			// */
			// if (map2.get("vehicle_device_device_id") == null) {
			//
			// map2.remove("pickup_lat");
			// map2.remove("pickup_long");
			// map2.remove("dropoff_lat");
			// map2.remove("dropoff_long");
			// map2.remove("pickup_address");
			// map2.remove("dropoff_address");
			// map2.put("pickup_lat", String.valueOf(map2.get("vehicle_default_lat")));
			// map2.put("pickup_long", String.valueOf(map2.get("vehicle_default_long")));
			// map2.put("dropoff_lat", String.valueOf(map2.get("vehicle_default_lat")));
			// map2.put("dropoff_long", String.valueOf(map2.get("vehicle_default_long")));
			// map2.put("pickup_address",
			// String.valueOf(map2.get("vehicle_default_address")));
			// map2.put("dropoff_address",
			// String.valueOf(map2.get("vehicle_default_address")));
			// map2.put("current_lat",
			// Float.parseFloat(String.valueOf(map2.get("vehicle_default_lat"))));
			// map2.put("current_long",
			// Float.parseFloat(String.valueOf(map2.get("vehicle_default_long"))));
			// }
			// }
			// }
			//
			// /*
			// * Returning response
			// */
			// responseMessage.setDescription("Process Success");
			// responseMessage.setObject(responseList);
			// responseMessage.setValid(true);
			// return responseMessage;
			// } else {
			// for (Map<String, Object> map3 : responseList) {
			// map3.remove("pickup_lat");
			// map3.remove("pickup_long");
			// map3.remove("dropoff_lat");
			// map3.remove("dropoff_long");
			// map3.remove("pickup_address");
			// map3.remove("dropoff_address");
			// map3.put("pickup_lat", String.valueOf(map3.get("vehicle_default_lat")));
			// map3.put("pickup_long", String.valueOf(map3.get("vehicle_default_long")));
			// map3.put("dropoff_lat", String.valueOf(map3.get("vehicle_default_lat")));
			// map3.put("dropoff_long", String.valueOf(map3.get("vehicle_default_long")));
			// map3.put("pickup_address",
			// String.valueOf(map3.get("vehicle_default_address")));
			// map3.put("dropoff_address",
			// String.valueOf(map3.get("vehicle_default_address")));
			// map3.put("current_lat",
			// Float.parseFloat(String.valueOf(map3.get("vehicle_default_lat"))));
			// map3.put("current_long",
			// Float.parseFloat(String.valueOf(map3.get("vehicle_default_long"))));
			// }
			// responseMessage.setDescription("Process Success But No Data from Platform");
			// responseMessage.setObject(responseList);
			// responseMessage.setValid(true);
			// return responseMessage;
			// }
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * To get all Vehicle Criteria * This method is used to get all notifications
	 * based in some criteria on the basis of Role Name,When Role Name is Vehicle or
	 * Vehicle then we'll use third party dB procedure else we'll use the xFUsion
	 * Platform API's to get the use keys list and user id's list on the basis of
	 * particular role name and then third party procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetAllCriteria1(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		/*
		 * Initialize Passing parameter query string to call platform API
		 */
		StringBuilder passingParameter = new StringBuilder();
		try {

			/*
			 * Adding Parameters to Map
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			/*
			 * Check condition whether role name is Vehicle or Vehicle
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			// }
			// /*
			// * If Role name is other than Vehicle and Vehicle
			// */
			// else {
			// /*
			// * removing role_name parameter
			// */
			// passingMap.remove("role_name");
			// /**
			// * Getting organization ids
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// }
			passingMap.putAll(map);
			/*
			 * GenericProcedureCalling() method is called to check the accuracy of input
			 * parameters.
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("19", passingMap, null,
					request, response);
			/*
			 * Casting response in list of Map
			 */
			List<Map<String, Object>> responseList = (List<Map<String, Object>>) finalProductResponseMessage
					.getObject();
			/**
			 * Initialize StringBuilder deviceIdBuilder to get all device Ids comma
			 * separated
			 */
			StringBuilder deviceIdBuilder1 = new StringBuilder();

			responseList.forEach((hashMap) -> {
				if (hashMap.get("vehicle_device_device_id") != null) {
					/*
					 * append Device Id in deviceIdBuilder
					 */
					deviceIdBuilder1.append(hashMap.get("vehicle_device_device_id") + ",");
					/*
					 * Manipulation of pickup_location
					 */
					if (hashMap.get("pickup_location") != null) {

						String value = hashMap.get("pickup_location").toString();

						hashMap.put("pickup_location", value.substring(0, value.indexOf(")") + 1));

					} else {
						hashMap.put("pickup_location", hashMap.get("pickup_location"));
					}
					/*
					 * Manipulation of pickup_date
					 */
					if (hashMap.get("pickup_date") != null) {

						if (hashMap.get("pickup_date").toString().contains("#x#f#")) {
							String value = hashMap.get("pickup_date").toString();
							String creation_time = value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", "");

							try {
								hashMap.put("pickup_date", convertDateInEpoch(creation_time));
							} catch (Exception e) {

								e.printStackTrace();
							}

						} else {
							String value = hashMap.get("pickup_date").toString();

							try {
								hashMap.put("pickup_date", convertDateInEpoch(value));
							} catch (Exception e) {

								e.printStackTrace();
							}
						}

					} else {
						hashMap.put("pickup_date", hashMap.get("pickup_date"));
					}
					/*
					 * Manipulation of all attributes star with pickup and sending them only first
					 * value of coming array in response
					 */
					for (String key : hashMap.keySet()) {
						if (key.contains("pickup")) {
							if (hashMap.get(key) != null) {
								if (hashMap.get(key).toString().contains("#x#f#")) {
									String value = hashMap.get(key).toString();

									hashMap.put(key, value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", ""));

								} else {
									String value = hashMap.get(key).toString();

									hashMap.put(key, value);
								}
							} else {
								hashMap.put(key, hashMap.get(key));
							}

						}

					}

				}
			});

			/*
			 * Setting the parameters for calling Platform API
			 */
			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();

			passingNewMap.put("device_id", deviceIdBuilder1.toString());
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			List<Map<String, String>> getPerformanceServiceStatusGetMany = getPerformanceServiceStatusGetMany(
					passingNewMap, request);
			/*
			 * Temporary Map to store all Platform Details device wise
			 */

			/*
			 * To store all Manipulated Map in List
			 */
			List<Map<String, Object>> liveTrackingDataList = new LinkedList<>();
			/*
			 * To update device id
			 */
			// System.out.println("getPerformanceServiceStatusGetMany " +
			// getPerformanceServiceStatusGetMany);

			liveTrackingDataList = new LinkedList<>();
			if (getPerformanceServiceStatusGetMany.size() > 0) {
				StringBuilder DeviceIdBuilder = new StringBuilder();
				// String device_id =
				// getPerformanceServiceStatusGetMany.get(0).get("device_id").toString();
				for (Map<String, String> getPerformanceServiceStatusGetNewManyMap : getPerformanceServiceStatusGetMany) {
					/*
					 * To get the data of same device ids
					 */
					Map<String, Object> liveTrackingData = new HashMap<>();
					System.out.println(
							"1221111 " + String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("device_id")));
					liveTrackingData.put("device_id",
							String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("device_id")));
					liveTrackingData.put("Battery", String
							.valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Battery")));

					liveTrackingData.put("Accuracy", String
							.valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Accuracy")));

					liveTrackingData.put("Latitude", String
							.valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Latitude")));

					liveTrackingData.put("Longitude", String
							.valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Longitude")));

					liveTrackingData.put("Rotation", String
							.valueOf(getPerformanceServiceStatusGetNewManyMap.get("mobileLocationService_Rotation")));

					liveTrackingData.put("host_status",
							String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("host_status_host_status")));

					liveTrackingData.put("sys_timestamp",
							String.valueOf(getPerformanceServiceStatusGetNewManyMap.get("sys_timestamp")));
					DeviceIdBuilder.append(liveTrackingData.get("device_id").toString().replace(".0", "") + ",");
					liveTrackingDataList.add(liveTrackingData);
				}

				System.out.println("liveTrackingDataList++" + liveTrackingDataList);
				/*
				 * Add Temporary map in List
				 */

				DeviceIdBuilder.deleteCharAt(DeviceIdBuilder.lastIndexOf(","));
				/*
				 * To merge both Platform data with Temporary list with Thirdparty API on the
				 * Basis of same device _id
				 */
				for (Map<String, Object> map2 : responseList) {
					for (Map<String, Object> liveTrackingNewData : liveTrackingDataList) {
						/**
						 * To merge data with certain test cases
						 */
						if (String.valueOf(map2.get("vehicle_device_device_id")).replace(".0", "")
								.equalsIgnoreCase(liveTrackingNewData.get("device_id").toString().replace(".0", ""))) {
							/*
							 * If ticket id is null than add default values in following parameters
							 */
							if (map2.get("ticket_id") == null) {

								map2.putAll(liveTrackingNewData);
								map2.remove("pickup_lat");
								map2.remove("pickup_long");
								map2.remove("dropoff_lat");
								map2.remove("dropoff_long");
								map2.remove("pickup_address");
								map2.remove("dropoff_address");
								map2.put("pickup_lat", String.valueOf(map2.get("vehicle_default_lat")));
								map2.put("pickup_long", String.valueOf(map2.get("vehicle_default_long")));
								map2.put("dropoff_lat", String.valueOf(map2.get("vehicle_default_lat")));
								map2.put("dropoff_long", String.valueOf(map2.get("vehicle_default_long")));
								map2.put("pickup_address", String.valueOf(map2.get("vehicle_default_address")));
								map2.put("dropoff_address", String.valueOf(map2.get("vehicle_default_address")));
								map2.put("current_lat",
										Float.parseFloat(String.valueOf(map2.get("vehicle_default_lat"))));
								map2.put("current_long",
										Float.parseFloat(String.valueOf(map2.get("vehicle_default_long"))));

							} else {

								map2.putAll(liveTrackingNewData);

							}

						}
						/*
						 * If no data came from the platform for device id than Add Default Parameter in
						 * Current Lat and Current long
						 */
						else if (map2.get("vehicle_device_device_id") != null && !DeviceIdBuilder.toString()
								.contains(map2.get("vehicle_device_device_id").toString())) {

							if (map2.get("ticket_id") == null)
								map2.remove("pickup_lat");
							map2.remove("pickup_long");
							map2.remove("pickup_address");
							map2.put("pickup_lat", String.valueOf(map2.get("vehicle_default_lat")));
							map2.put("pickup_long", String.valueOf(map2.get("vehicle_default_long")));
							map2.put("pickup_address", String.valueOf(map2.get("vehicle_default_address")));
							map2.put("current_lat", Float.parseFloat(String.valueOf(map2.get("vehicle_default_lat"))));
							map2.put("current_long",
									Float.parseFloat(String.valueOf(map2.get("vehicle_default_long"))));
						}
						/*
						 * If Device id is null than Add default in all parameter
						 */
						if (map2.get("vehicle_device_device_id") == null) {

							map2.remove("pickup_lat");
							map2.remove("pickup_long");
							map2.remove("dropoff_lat");
							map2.remove("dropoff_long");
							map2.remove("pickup_address");
							map2.remove("dropoff_address");
							map2.put("pickup_lat", String.valueOf(map2.get("vehicle_default_lat")));
							map2.put("pickup_long", String.valueOf(map2.get("vehicle_default_long")));
							map2.put("dropoff_lat", String.valueOf(map2.get("vehicle_default_lat")));
							map2.put("dropoff_long", String.valueOf(map2.get("vehicle_default_long")));
							map2.put("pickup_address", String.valueOf(map2.get("vehicle_default_address")));
							map2.put("dropoff_address", String.valueOf(map2.get("vehicle_default_address")));
							map2.put("current_lat", Float.parseFloat(String.valueOf(map2.get("vehicle_default_lat"))));
							map2.put("current_long",
									Float.parseFloat(String.valueOf(map2.get("vehicle_default_long"))));
						}
					}
				}

				/*
				 * Returning response
				 */
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(responseList);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				for (Map<String, Object> map3 : responseList) {
					map3.remove("pickup_lat");
					map3.remove("pickup_long");
					map3.remove("dropoff_lat");
					map3.remove("dropoff_long");
					map3.remove("pickup_address");
					map3.remove("dropoff_address");
					map3.put("pickup_lat", String.valueOf(map3.get("vehicle_default_lat")));
					map3.put("pickup_long", String.valueOf(map3.get("vehicle_default_long")));
					map3.put("dropoff_lat", String.valueOf(map3.get("vehicle_default_lat")));
					map3.put("dropoff_long", String.valueOf(map3.get("vehicle_default_long")));
					map3.put("pickup_address", String.valueOf(map3.get("vehicle_default_address")));
					map3.put("dropoff_address", String.valueOf(map3.get("vehicle_default_address")));
					map3.put("current_lat", Float.parseFloat(String.valueOf(map3.get("vehicle_default_lat"))));
					map3.put("current_long", Float.parseFloat(String.valueOf(map3.get("vehicle_default_long"))));
				}
				responseMessage.setDescription("Process Success But No Data from Platform");
				responseMessage.setObject(responseList);
				responseMessage.setValid(true);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * To Get Data from Platform to get Currents performance service status of
	 * device from Platform
	 * 
	 * @param passingMap
	 * @param request
	 * @return
	 */
	public List<Map<String, String>> getPerformanceServiceStatusGetMany(LinkedHashMap<String, String> passingMap,
			HttpServletRequest request) throws Exception {
		try {
			/*
			 * Initialize response Message
			 */
			Message responseMessage = new Message();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("service_name",
					"mobileLocationService,mobileLocationService,host_status,mobileLocationService,mobileLocationService,mobileLocationService");
			passingMap.put("data_source", "Latitude,Longitude,host_status,Rotation,Accuracy,Battery");
			passingMap.put("pivot_data_required", "1");

			/*
			 * Initialize Passing Query String to call platform API
			 */
			StringBuilder passingParameter = new StringBuilder();

			String accessKey = null;
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * Retrieving the xFusion Platform Token
				 */

				headerMap.put("token", request.getHeader("token"));
				/*
				 * to get accessKey
				 */

				/*
				 * To append rest of the parameters
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}
			}

			passingParameter.deleteCharAt(0);
			/*
			 * Printing passing parameter query string
			 */

			/*
			 * Calling XfusionPlatform Performance Service Status Devices Get Many API to
			 * get the data
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(
					urlParameter.getXfusionPlatformPerformanceServiceStatusDevicesGetMany(),
					passingParameter.toString(), headerMap);
			System.out.println("finalVehicleResponseMessage :-" + finalVehicleResponseMessage);
			if (finalVehicleResponseMessage != null) {
				/*
				 * Casting response in Generic Message format
				 */
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/*
				 * Getting response in formatted way
				 */
				GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				/*
				 * to get response in List of Map
				 */
				List<Map<String, String>> deviceModelObject = urlMessage.getObject();
				/*
				 * to print response
				 */

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					/*
					 * returning response
					 */
					return deviceModelObject;
				}
			}
			/*
			 * if some error occurred in process it will return null
			 */
			return null;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * To get date in date format and convert it into EPoch time format
	 * 
	 * @param replace
	 * @return
	 * @throws ParseException
	 */
	private Object convertDateInEpoch(String replace) throws ParseException {

		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask
		Date date = dF.parse(replace); // parsing the String into a Date using
										// the mask

		return date.getTime();
	}

	/**
	 * To retrieve details the vehicles This method is used To retrieve details the
	 * vehicles on the basis of Role Name,When Role Name is Vehicle or Vehicle then
	 * we'll use third party dB procedure else we'll use the xFUsion Platform API's
	 * to get the user_ids_list on the basis of particular role name and then third
	 * party procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetVehicles(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list ", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// }
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("47", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			} else {

				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * To retrieve the vehicle engines details This method is used To retrieve the
	 * vehicle engines details on the basis of Role Name,When Role Name is Vehicle
	 * or Vehicle then we'll use third party dB procedure else we'll use the xFUsion
	 * Platform API's to get the user_ids_list on the basis of particular role name
	 * and then third party procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetVehicleEngine(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list ", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			//
			// }
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("48", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			}

		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Get All Device Details This method is used To Get All Device Details on
	 * the basis of Role Name,When Role Name is Vehicle or Vehicle then we'll use
	 * third party dB procedure else we'll use the xFUsion Platform API's to get the
	 * user_ids_list on the basis of particular role name and then third party
	 * procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetAllDetails(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list ", null);
			// /*
			// * Calling stored procedure api to call the data in Message response format
			// */
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// }
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("49", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			} else {
				/*
				 * Response Message of API when some errors occurred in API.
				 */
				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * * To Get Vehicle Transmission Wheels This method is used To Get Vehicle
	 * Transmission Wheel on the basis of Role Name,When Role Name is Vehicle or
	 * Vehicle then we'll use third party dB procedure else we'll use the xFUsion
	 * Platform API's to get the user_ids_list on the basis of particular role name
	 * and then third party procedure is being called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintVehicleGetTransmissionWheel(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list ", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// }
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("50", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			} else {
				/*
				 * Response Message of API when some errors occurred in API.
				 */
				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * To Delete Vehicle This method is used To Delete Vehicle on the basis of Role
	 * Name,When Role Name is Vehicle or Vehicle then we'll use third party dB
	 * procedure else we'll use the xFUsion Platform API's to get the user_ids_list
	 * on the basis of particular role name and then third party procedure is being
	 * called.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message flintDeleteVehicle(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list ", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			// String deviceModelObject =
			// thirdPartyServices.getUserIdsByOrganization(passingMap, request, response);
			//
			// /**
			// * To Check deviceModelObject is not null
			// */
			// if (!deviceModelObject.isEmpty()) {
			//
			// /*
			// * to pass user_ids_list in passing parameter map
			// */
			// passingMap.put("user_ids_list", deviceModelObject);
			// /*
			// * to print Passing parameter map
			// */
			//
			// }
			// passingMap.put("vehicle_key", map.get("vehicle_key"));
			// passingMap.put("vehicle_id", map.get("vehicle_id"));
			// passingMap.put("id", map.get("id"));
			// /*
			// * to print Passing parameter map
			// */
			//
			// }

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("44", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			} else {
				/*
				 * Response Message of API when some errors occurred in API.
				 */
				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	public Message flintVehicleGetAll(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To check weather the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */
		
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("49", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {

				return finalProductResponseMessage;

			} else {
				/*
				 * Response Message of API when some errors occurred in API.
				 */
				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * Registration of vehicle
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public Message flintVehicleCreateVehicle(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * To create vehicle user in OAUTH and Map It into Platform
			 */
			/**
			 * Passing Parameter for device registration
			 */
			String device_id = map.get("registration_number");
			String passingParameterMap = "device_id=" + device_id + "&gateway_id="
					+ String.valueOf(environment.getProperty("device.gateway_id")) + "&protocol="
					+ String.valueOf(environment.getProperty("device.protocol"));
			// to check if the user created successfully
			Type typeResponse = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();
			LinkedHashMap<String, String> headerMap = new LinkedHashMap<>();

			headerMap.put("token", request.getHeader("token"));
			headerMap.put("user_key", request.getHeader("user_key"));
			headerMap.put("user_id", request.getHeader("user_id"));
			/**
			 * Calling Platform api for device registration
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(urlParameter.getXfusionPlatformDeviceRegister(),
					passingParameterMap, headerMap);

			System.out.println("finalVehicleResponseMessage " + finalVehicleResponseMessage);
			/**
			 * To check if response is not null
			 */
			if (finalVehicleResponseMessage != null) {
				/*
				 * Casting of Response in Generic Message type
				 */

				GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), typeResponse);
				/**
				 * Getting Message in List of Map
				 */
				List<Map<String, String>> deviceModelObject = urlMessage.getObject();
				map.putAll(deviceModelObject.get(0));
				/*
				 * To check if device id is not null
				 */
				if (urlMessage.isValid()) {
					/**
					 * Calling Platform api for device Mapping
					 */
					String passingParameterForDeviceMappingMap = "name=" + device_id + "&alias=Celebi"
							+ map.get("registration_number").trim() + "&ip_address=" + request.getRemoteAddr()
							+ "&lattitude=" + "&longitutde=" + "&mac_address=" + "&description=" + "&elevation="
							+ "&hardware_version=" + "&software_version=" + "&device_id="
							+ deviceModelObject.get(0).get("id").toString().trim() + "&iccid=" + "&imei="
							+ "&is_movable=" + String.valueOf(environment.getProperty("device.is_movable"))
							+ "&template_id=" + String.valueOf(environment.getProperty("device.template.id"))
							+ "&device_country=" + String.valueOf(map.get("country")).trim() + "&device_state="
							+ String.valueOf(map.get("state")).trim() + "&device_city="
							+ String.valueOf(map.get("city")).trim() + "&parent_device=" + "&organization_ids="
							+ map.get("organization_id").trim() + "&properties_ids=" + "&properties_names="
							+ "&properties_values=" + "&is_configurable="
							+ String.valueOf(environment.getProperty("device.is_configurable")) + "&tags=";
					/**
					 * Calling Platform api for device mapping
					 */
					Object responseForDeviceMapping = urlCalling.getData(urlParameter.getXfusionPlatformDeviceMApping(),
							passingParameterForDeviceMappingMap, headerMap);

					System.out.println("responseForDeviceMapping " + responseForDeviceMapping);
					/**
					 * To check if response is not null
					 */
					if (responseForDeviceMapping != null) {
						/*
						 * Casting of Response in Generic Message type
						 */

						GenericMessages<Map<String, String>> urlDeviceMappingMessage = (GenericMessages<Map<String, String>>) new Gson()
								.fromJson(responseForDeviceMapping.toString(), typeResponse);
						/**
						 * Getting Message in List of Map
						 */
						List<Map<String, String>> deviceMappingObject = urlDeviceMappingMessage.getObject();

						map.putAll(deviceMappingObject.get(0));
						// System.out.println("deviceMappingObject:-
						// " + deviceMappingObject);
						/*
						 * To check if device id is not null
						 */
						if (deviceMappingObject != null) {
							/**
							 * Passing parameter map to call Flint APi to get Fcm id of Last Active device
							 * to disable it.
							 * 
							 */

							Message VehicleResponsemessage = genericProcess.GenericProcedureCalling("15", map, null,
									request, response);
							/**
							 * if response is valid
							 */
							if (VehicleResponsemessage.isValid()) {
								List<Map<String, Object>> VehicleResponsemessageList = (List<Map<String, Object>>) VehicleResponsemessage
										.getObject();

								/**
								 * if response from procedure is null
								 */
								if (VehicleResponsemessageList.size() > 0) {

									responseMessage.setDescription("Vehicle Added  Successfully");
									responseMessage.setObject(VehicleResponsemessageList);
									responseMessage.setValid(true);
									return responseMessage;

								} else {
									/**
									 * if response is null
									 */
									responseMessage
											.setDescription("Error in Response from Adding Vehicle in ThirdParty");
									responseMessage.setValid(false);
									return responseMessage;
								}
							} else {
								/**
								 * Error in adding vehicle
								 */
								responseMessage.setDescription("Error in Adding Vehicle in ThirdParty");
								responseMessage.setValid(false);
								return responseMessage;
							}

						} else {
							/**
							 * Error in adding vehicle user
							 */
							responseMessage.setDescription("Error in Adding Vehicle user ");

							responseMessage.setValid(false);
							return responseMessage;
						}

					} else {
						/**
						 * Error in creating vehicle user
						 */
						responseMessage.setDescription("Error in Creating Vehicle user");
						responseMessage.setValid(false);
						return responseMessage;
					}
				}
			}
		} catch (Exception e) {
			/**
			 * If exception occur
			 */
			throw e;

		}
		return responseMessage;
	}

}
