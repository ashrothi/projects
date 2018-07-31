/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

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
import org.springframework.stereotype.Service;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

@Service
@SuppressWarnings({ "unchecked", "serial" })
public class TrackingServices {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private ThirdPartyServices thirdPartyServices;
	@Autowired
	private XFusionService xFusionService;

	public Message flintHistoryTrackingGetAll(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();
		try {

			/*
			 * passingMap is used to store the input parameters from user which will be same
			 * as of the procedure being called upon.
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

			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			passingNewMap.put("token", request.getHeader("token"));
			passingNewMap.put("device_id", passingMap.get("device_id"));
			passingNewMap.put("user_key", request.getHeader("user_key"));
			passingNewMap.put("user_id", request.getHeader("user_id"));
			passingNewMap.put("service_name", "mobileLocationService,mobileLocationService");
			passingNewMap.put("data_source", "Latitude,Longitude");
			passingNewMap.put("from_date", passingMap.get("from_date").toString());
			passingNewMap.put("end_date", passingMap.get("end_date").toString());
			passingNewMap.put("pivot_data_required", "1");

			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			List<Map<String, Object>> getPerformanceServiceStatusGetMany = getXfusionPerformanceServiceMultipleDevicesGetMany(
					passingNewMap, request, response);
			// System.out.println("getPerformanceServiceStatusGetMany" +
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
				 * To update device id
				 */
				String device_id = String.valueOf(getPerformanceServiceStatusGetMany.get(0).get("device_id"));
				/*
				 * To get each object and get the specific values to add in temporary map and
				 * than in list
				 */

				LinkedList<String> lat_long = new LinkedList<>();
				for (Map<String, Object> getPerformanceServiceStatusGetManyMap : getPerformanceServiceStatusGetMany) {
					/*
					 * To get the data of same device ids
					 */
					if (device_id.equalsIgnoreCase(getPerformanceServiceStatusGetManyMap.get("device_id").toString())) {
						/*
						 * to put device id in temporary map liveTrackingData
						 */
						liveTrackingData.put("device_id", device_id);

						lat_long.add("("
								+ String.valueOf(
										getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude"))
								+ ","
								+ String.valueOf(
										getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude"))
								+ ")");
						liveTrackingData.put("sys_timestamp",
								getPerformanceServiceStatusGetManyMap.get("sys_timestamp"));

					} else {
						/*
						 * if next device came then change device id and remove previous parameter
						 */
						liveTrackingData.put("lat_long", lat_long.toArray());
						Map<String, Object> map2 = new HashMap<>();
						map2.putAll(liveTrackingData);
						liveTrackingDataList.add(map2);
						liveTrackingData.remove("device_id");
						liveTrackingData.remove("lat_long");
						liveTrackingData.remove("sys_timestamp");

						lat_long.clear();
						device_id = getPerformanceServiceStatusGetManyMap.get("device_id").toString();
						lat_long.add("(" + getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude")
								+ "," + getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude")
								+ ")");

					}

				}

				liveTrackingData.put("lat_long", lat_long.toArray());

				liveTrackingDataList.add(liveTrackingData);
				/**
				 * Sucess response
				 */
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(liveTrackingDataList);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				responseMessage.setDescription("Error No Tracking Data From Platform");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Message flintLiveTrackingGetAll(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();
		try {

			/*
			 * passingMap is used to store the input parameters from user which will be same
			 * as of the procedure being called upon.
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
			String end_time = String.valueOf(new Date().getTime());

			LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
			passingNewMap.put("token", request.getHeader("token"));
			passingNewMap.put("device_id", passingMap.get("device_id"));
			passingNewMap.put("user_key", request.getHeader("user_key"));
			passingNewMap.put("user_id", request.getHeader("user_id"));
			passingNewMap.put("service_name", "mobileLocationService,mobileLocationService");
			passingNewMap.put("data_source", "Latitude,Longitude");
			passingNewMap.put("from_date", passingMap.get("from_date").toString());
			passingNewMap.put("end_date", end_time);
			passingNewMap.put("pivot_data_required", "1");
			/*
			 * Calling Performance Service Status Get Many api of Platform
			 */
			// List<Map<String, Object>> getPerformanceServiceGetMany =
			// getXfusionPerformanceServiceMultipleDevicesGetMany(
			// passingNewMap, request, response);
			List<Map<String, String>> getPerformanceServiceGetMany1 = vehicleService
					.getPerformanceServiceStatusGetMany(passingNewMap, request);
			// System.out.println("getPerformanceServiceGetMany" +
			// getPerformanceServiceGetMany);
			if (getPerformanceServiceGetMany1.size() > 0) {

				/*
				 * Temporary Map to store all Platform Details device wise
				 */
				Map<String, Object> liveTrackingData = new HashMap<>();
				// Map<String, Object> liveTrackingDataTemp = new HashMap<>();
				/**
				 * To store Latitude and longitude in array
				 */
				LinkedList<String> lat_long = new LinkedList<>();
				/**
				 * Iterator of List of map came in response
				 */

				// for (Map<String, Object> getPerformanceServiceStatusGetManyMap :
				// getPerformanceServiceGetMany) {
				//
				// // Getting latitude datasource to bind Lat in array
				//
				// lat_long.add("("
				// + String.valueOf(
				// getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude"))
				// + ","
				// + String.valueOf(
				// getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude"))
				// + ")");
				// }
				for (Map<String, String> getPerformance : getPerformanceServiceGetMany1) {

					// Getting latitude datasource to bind Lat in array

					lat_long.add("(" + String.valueOf(getPerformance.get("mobileLocationService_Latitude")) + ","
							+ String.valueOf(getPerformance.get("mobileLocationService_Longitude")) + ")");
					liveTrackingData.put("sys_timestamp", Long.parseLong(getPerformance.get("sys_timestamp")));

				}

				// to get tracking latLong

				liveTrackingData.put("lat_long", lat_long.toArray());

				// }

				/**
				 * Sending Success Response
				 */
				if (!liveTrackingData.isEmpty()) {

					List<Map<String, Object>> responseList = new LinkedList<>();
					responseList.add(liveTrackingData);
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseList);
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					/*
					 * Error response
					 */
					responseMessage.setDescription("Error in binding tracking data");
					responseMessage.setValid(false);
					return responseMessage;
				}

			} else {
				/*
				 * Error Response when Data is not coming from PlatForm
				 */
				responseMessage.setDescription(" No tracking Data from Platform");
				responseMessage.setValid(false);
				return responseMessage;
			}

		}
		/*
		 * Handling the occurring exceptions.
		 */catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private Object convertDateInEpoch(String replace) throws ParseException {

		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask
		Date date = dF.parse(replace); // parsing the String into a Date using
										// the mask

		return date.getTime();
	}

	/**
	 * To get the device ids by close ticket
	 * 
	 * @param passingMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private List<Map<String, Object>> getDeviceIdsByTicketId(LinkedHashMap<String, String> passingMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			/*
			 * Initialize Response message
			 */
			Message responseMessage = new Message();
			/*
			 * To get device ids on the basis of ticket id from procedure
			 */
			responseMessage = genericProcess.GenericProcedureCalling("33", passingMap, null, request, response);
			/**
			 * To check if response is valid
			 */
			if (responseMessage.isValid()) {

				List<Map<String, Object>> deviceModelObject = (List<Map<String, Object>>) responseMessage.getObject();

				return deviceModelObject;
			} else {

				return null;
			}
			/**
			 * To throw exception if something went wrong
			 */
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * To get Tracking data from Platform
	 * 
	 * @param passingMap
	 * @return List<Map<String, Object>> of platform data
	 * @throws Exception
	 */
	private List<Map<String, Object>> getXfusionPerformanceServiceMultipleDevicesGetMany(
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

	/**
	 * To get all details of Vehicle * This method is used to get all vehicles on
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
	 **/
	public Message flintLiveTrackingFilterByRole(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			// } else {
			// /*
			// * when role_name is broker
			// */
			// passingMap.remove("role_name");
			// /*
			// * To get Organization Id's
			// */
			//
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
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("18", passingMap, null,
					request, response);

			/*
			 * TO Check if it is valid
			 */
			List<Map<String, Object>> FinalResponseMessage = new LinkedList<>();
			StringBuilder builder = new StringBuilder();
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Return response Message
				 */

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				// System.out.println("ticketByVehicle:- " + ticketByVehicle);

				if (ticketByVehicle.size() > 0) {

					for (Map<String, Object> map2 : ticketByVehicle) {
						builder.append(map2.get("vehicle_device_id") + ",");
					}
					builder.deleteCharAt(builder.lastIndexOf(","));
					LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
					passingNewMap.put("device_id", String.valueOf(builder));

					/*
					 * Calling Performance Service Status Get Many api of Platform
					 */
					List<Map<String, String>> getPerformanceServiceStatusGetMany = new LinkedList<>();
					try {
						getPerformanceServiceStatusGetMany = vehicleService
								.getPerformanceServiceStatusGetMany(passingNewMap, request);
						// System.out.println("getPerformanceServiceStatusGetMany:-
						// " + getPerformanceServiceStatusGetMany
						// + "\n ### " +
						// getPerformanceServiceStatusGetMany.size());

						/**
						 * To add Tracking detail with their respective vehicle
						 */
						for (Map<String, Object> ticketByVehicleMap : ticketByVehicle) {
							// System.out.println("ticketByVehicleMap :-" +
							// ticketByVehicleMap);
							if (getPerformanceServiceStatusGetMany.size() > 0) {
								for (Map<String, String> getPerformanceServiceStatusGetManyMap : getPerformanceServiceStatusGetMany) {

									// System.out.println(getPerformanceServiceStatusGetManyMap.get("device_id").toString()
									// .replace(".0", "") + " _______"
									// +
									// ticketByVehicleMap.get("device_driver_vehicle_device_id"));
									if (String
											.valueOf(getPerformanceServiceStatusGetManyMap.get("device_id")
													.replace(".0", ""))
											.equalsIgnoreCase(
													String.valueOf(ticketByVehicleMap.get("vehicle_device_id")))) {

										ticketByVehicleMap.put("Battery",
												String.valueOf(getPerformanceServiceStatusGetManyMap
														.get("mobileLocationService_Battery")));

										ticketByVehicleMap.put("Accuracy",
												String.valueOf(getPerformanceServiceStatusGetManyMap
														.get("mobileLocationService_Accuracy")));

										ticketByVehicleMap.put("Latitude",
												Float.parseFloat(String.valueOf(getPerformanceServiceStatusGetManyMap
														.get("mobileLocationService_Latitude"))));

										ticketByVehicleMap.put("Longitude",
												Float.parseFloat(String.valueOf(getPerformanceServiceStatusGetManyMap
														.get("mobileLocationService_Longitude"))));

										ticketByVehicleMap.put("Rotation",
												String.valueOf(getPerformanceServiceStatusGetManyMap
														.get("mobileLocationService_Rotation")));

										ticketByVehicleMap.put("host_status", String.valueOf(
												getPerformanceServiceStatusGetManyMap.get("host_status_host_status")));
										ticketByVehicleMap.put("sys_timestamp", Double.parseDouble(String
												.valueOf(getPerformanceServiceStatusGetManyMap.get("sys_timestamp"))));

									} else {
										ticketByVehicleMap.put("Battery", 0);
										ticketByVehicleMap.put("Accuracy", 0);
										ticketByVehicleMap.put("Latitude", ticketByVehicleMap.get("vehicle_latitude"));
										ticketByVehicleMap.put("Longitude",
												ticketByVehicleMap.get("vehicle_longitude"));
										ticketByVehicleMap.put("Rotation", 0);
										ticketByVehicleMap.put("host_status", 0);
										ticketByVehicleMap.put("sys_timestamp", null);
									}
								}
							} else {
								ticketByVehicleMap.put("Battery", 0);
								ticketByVehicleMap.put("Accuracy", 0);
								ticketByVehicleMap.put("Latitude", null);
								ticketByVehicleMap.put("Longitude", null);
								ticketByVehicleMap.put("Rotation", 0);
								ticketByVehicleMap.put("host_status", 0);
								ticketByVehicleMap.put("sys_timestamp", null);
							}
							if (ticketByVehicleMap.get("transporter_organization_path") == null) {
								ticketByVehicleMap.put("transporter_organization_path", "NA");
							}

							ticketByVehicleMap.put("current_time", new Date().getTime());

							FinalResponseMessage.add(ticketByVehicleMap);
						}

						// System.out.println("FinalResponseMessage:- " +
						// FinalResponseMessage);
						Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
						Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
						List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

						if (userList.size() > 0) {
							for (Map<String, Object> map2 : FinalResponseMessage) {
								for (Map<String, Object> mapuserList : userList) {
									if (!map2.containsKey("Accuracy")) {
										map2.put("Battery", 0);
										map2.put("Accuracy", 0);
										map2.put("Latitude", null);
										map2.put("Longitude", null);
										map2.put("Rotation", 0);
										map2.put("sys_timestamp", null);
										map2.put("host_status", 0);
									}
									if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
											.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
										map2.remove("transporter_organization_path");
										map2.put("transporter_organization_path",
												mapuserList.get("organization_alias"));
									}
								}

							}
						}

					} catch (Exception e) {

						e.printStackTrace();
						throw e;
					}

					/*
					 * Success Message
					 */
					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;

				} else {
					/*
					 * When no data from Platform
					 */
					responseMessage.setDescription("No data from db ");
					responseMessage.setValid(false);
					return responseMessage;
				}

			} else {
				/*
				 * Error Message when no data from ticket id
				 */
				responseMessage.setDescription("No data from DB");
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
	 * to get flint iveTracking Filter By RegNo
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return Message
	 * @throws Exception
	 */
	public Message flintLiveTrackingFilterByRegNo(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("55", map, null, request,
					response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Return response Message
				 */

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();

				/**
				 * To Manipulate the open ticket details as requested
				 */
				List<Map<String, Object>> formattedTicketData = getFormatedOpenTicketData(ticketByVehicle);
				// System.out.println("formattedTicketData" +
				// formattedTicketData);
				Map<String, Object> statusMAp = new HashMap<>();
				List<Map<String, Object>> FinalResponseMessage = new LinkedList<>();
				if (formattedTicketData.size() > 0
						&& String.valueOf(formattedTicketData.get(0).get("device_driver_vehicle_device_id")) != null) {
					String device_id = String
							.valueOf(formattedTicketData.get(0).get("device_driver_vehicle_device_id"));

					// System.out
					// .println(String.valueOf(formattedTicketData.get(0).get("device_driver_vehicle_device_id")));
					/*
					 * Setting the parameters for calling Platform API
					 */

					if (device_id != null) {
						// To call Performance status API of platform

						LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();

						passingNewMap.put("device_id", device_id);
						/*
						 * Calling Performance Service Status Get Many api of Platform
						 */
						List<Map<String, String>> getPerformanceServiceStatusGetMany = vehicleService
								.getPerformanceServiceStatusGetMany(passingNewMap, request);
						System.out.println("getPerformanceServiceStatusGetMany:-" + getPerformanceServiceStatusGetMany);
						getPerformanceServiceStatusGetMany.forEach((getPerformanceServiceStatusGetManyMap) -> {
							statusMAp.put("device_id",
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("device_id")));
							statusMAp.put("Battery", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Battery"))));

							statusMAp.put("Accuracy", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Accuracy"))));

							statusMAp.put("Latitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude"))));

							statusMAp.put("Longitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude"))));

							statusMAp.put("Rotation", String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Rotation")));

							statusMAp.put("host_status", String
									.valueOf(getPerformanceServiceStatusGetManyMap.get("host_status_host_status")));
							statusMAp.put("sys_timestamp", Double.parseDouble(
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("sys_timestamp"))));

							statusMAp.put("current_time", new Date().getTime());
						});

						formattedTicketData.forEach((ticketByVehicleMap) -> {
							if (String.valueOf(ticketByVehicleMap.get("device_driver_vehicle_device_id")) != null
									&& String.valueOf(ticketByVehicleMap.get("device_driver_vehicle_device_id"))
											.equalsIgnoreCase(
													String.valueOf(statusMAp.get("device_id")).replace(".0", ""))) {
								ticketByVehicleMap.putAll(statusMAp);
								if (ticketByVehicleMap.get("transporter_organization_path") == null) {
									ticketByVehicleMap.put("transporter_organization_path", "NA");
								}
								FinalResponseMessage.add(ticketByVehicleMap);
							}
							if (!ticketByVehicleMap.containsKey("Accuracy")) {
								ticketByVehicleMap.put("Battery", 0);
								ticketByVehicleMap.put("Accuracy", 0);
								ticketByVehicleMap.put("Latitude", null);
								ticketByVehicleMap.put("Longitude", null);
								ticketByVehicleMap.put("Rotation", 0);
								ticketByVehicleMap.put("sys_timestamp", null);
								ticketByVehicleMap.put("host_status", 0);
								ticketByVehicleMap.put("current_time", new Date().getTime());
							}
							if (ticketByVehicleMap.get("transporter_organization_path") == null) {
								ticketByVehicleMap.put("transporter_organization_path", "NA");
							}
							FinalResponseMessage.add(ticketByVehicleMap);

						});

						Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
						Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
						List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

						if (userList.size() > 0) {
							for (Map<String, Object> map2 : FinalResponseMessage) {
								for (Map<String, Object> mapuserList : userList) {
									if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
											.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
										map2.remove("transporter_organization_path");
										map2.put("transporter_organization_path",
												mapuserList.get("organization_alias"));
									}
								}

							}
						}
						// Success Message
						responseMessage.setDescription("Process Sucess");
						responseMessage.setObject(FinalResponseMessage);
						responseMessage.setValid(true);
						return responseMessage;
					} else {
						/**
						 * When Device id is not their
						 */
						responseMessage
								.setDescription("device_driver_vehicle_device_id is not their Thats why no live data ");
						responseMessage.setObject(FinalResponseMessage);
						responseMessage.setValid(true);
						return responseMessage;
					}

				} else {
					/**
					 * When Device id is not their
					 */
					responseMessage
							.setDescription("device_driver_vehicle_device_id is not their Thats why no live data ");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				}
			} else {
				/**
				 * No Open ticket for respective Registration No
				 */
				responseMessage.setDescription("NO Open ticket to the Given Registration No");

				responseMessage.setValid(false);
				return responseMessage;
			}

		}

		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To get flint Live Tracking Filter By TicketId
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return Message
	 * @throws Exception
	 */
	public Message flintLiveTrackingFilterByTicketId(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("57", map, null, request,
					response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				List<Map<String, Object>> formattedTicketData = getFormatedOpenTicketData(ticketByVehicle);

				Map<String, Object> statusMAp = new HashMap<>();
				List<Map<String, Object>> FinalResponseMessage = new LinkedList<>();
				if (formattedTicketData != null) {
					String device_id = String
							.valueOf(formattedTicketData.get(0).get("device_driver_vehicle_device_id"));
					/*
					 * Setting the parameters for calling Platform API
					 */
					if (!device_id.equals(null)) {
						/**
						 * To get performance status data from platform
						 */
						LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();

						passingNewMap.put("device_id", device_id);
						/*
						 * Calling Performance Service Status Get Many api of Platform
						 */
						List<Map<String, String>> getPerformanceServiceStatusGetMany = vehicleService
								.getPerformanceServiceStatusGetMany(passingNewMap, request);

						getPerformanceServiceStatusGetMany.forEach((getPerformanceServiceStatusGetManyMap) -> {
							statusMAp.put("Battery", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Battery"))));

							statusMAp.put("Accuracy", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Accuracy"))));

							statusMAp.put("Latitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude"))));

							statusMAp.put("Longitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude"))));

							statusMAp.put("Rotation", String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Rotation")));

							statusMAp.put("host_status", String
									.valueOf(getPerformanceServiceStatusGetManyMap.get("host_status_host_status")));
							statusMAp.put("sys_timestamp", Double.parseDouble(
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("sys_timestamp"))));
							statusMAp.put("current_time", new Date().getTime());

						});

					}

					formattedTicketData.forEach((ticketByVehicleMap) -> {
						if (ticketByVehicleMap.get("device_driver_vehicle_device_id").toString()
								.equalsIgnoreCase(String.valueOf(statusMAp.get("device_id")).replace(".0", ""))) {
							ticketByVehicleMap.putAll(statusMAp);
							if (ticketByVehicleMap.get("transporter_organization_path") == null) {
								ticketByVehicleMap.put("transporter_organization_path", "NA");
							}
							FinalResponseMessage.add(ticketByVehicleMap);

						}
						if (!ticketByVehicleMap.containsKey("Accuracy")) {
							ticketByVehicleMap.put("Accuracy", 0);
							ticketByVehicleMap.put("Battery", 0);
							ticketByVehicleMap.put("Latitude", null);
							ticketByVehicleMap.put("host_status", 0);
							ticketByVehicleMap.put("sys_timestamp", null);
							ticketByVehicleMap.put("Longitude", null);
							ticketByVehicleMap.put("Rotation", 0);
							ticketByVehicleMap.put("current_time", new Date().getTime());
						}
						if (ticketByVehicleMap.get("transporter_organization_path") == null) {
							ticketByVehicleMap.put("transporter_organization_path", "NA");
						}

						FinalResponseMessage.add(ticketByVehicleMap);

					});

					Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
					Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
					List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

					if (userList.size() > 0) {
						for (Map<String, Object> map2 : FinalResponseMessage) {
							for (Map<String, Object> mapuserList : userList) {
								if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
										.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
									map2.remove("transporter_organization_path");
									map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
								}
							}

						}
					}
					/*
					 * Success Response
					 */
					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					/**
					 * Error response
					 */
					responseMessage.setDescription("device_driver_vehicle_device_id is Thats why now live data ");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				}
			} else {
				/**
				 * Error response
				 */
				responseMessage.setDescription("NO Open ticket to the Given Registration No");
				responseMessage.setValid(false);
				return responseMessage;
			}

		}

		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/***
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return Message
	 * @throws Exception
	 */
	public Message flintVehicleHistoryFilterByTicketId(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("60", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Return response Message
				 */

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				List<Map<String, Object>> formattedList = formattedCloseTicketData(ticketByVehicle);

				Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
				Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
				List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

				if (userList.size() > 0) {
					for (Map<String, Object> map2 : formattedList) {
						for (Map<String, Object> mapuserList : userList) {
							if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
									.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
								map2.remove("transporter_organization_path");
								map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
							}
						}

					}
				}
				responseMessage.setDescription("Process Sucess");
				responseMessage.setObject(ticketByVehicle);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				responseMessage.setDescription("NO Close ticket to the Given Registration No");

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

	private List<Map<String, Object>> formattedCloseTicketData(List<Map<String, Object>> ticketByVehicle) {
		try {
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < ticketByVehicle.size(); i++) {

				Map<String, Object> hashMap = ticketByVehicle.get(i);
				if (hashMap.get("transporter_organization_path") == null) {
					hashMap.put("transporter_organization_path", "NA");
				}

				if (hashMap.get("closed_tickets_id") != null) {
					builder.append(hashMap.get("closed_tickets_id") + ",");
					if (hashMap.get("closed_tickets_pickup_address") != null) {

						if (hashMap.get("closed_tickets_pickup_address").toString().contains("#x#f#")) {
							String value = hashMap.get("closed_tickets_pickup_address").toString();
							String creation_time = value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", "");

							hashMap.put("closed_tickets_pickup_address", creation_time);

						} else {
							String value = hashMap.get("closed_tickets_pickup_address").toString();

							hashMap.put("closed_tickets_pickup_address", value);
						}

					} else {
						hashMap.put("closed_tickets_pickup_address", hashMap.get("closed_tickets_pickup_address"));
					}
					for (String key : hashMap.keySet()) {
						if (key.contains("closed_tickets_pickup")) {
							if (hashMap.get(key) != null) {
								if (hashMap.get(key).toString().contains(",")) {
									String value = hashMap.get(key).toString();

									hashMap.put(key, value.substring(0, value.indexOf(",") + 1).replace(",", ""));

								} else {
									String value = hashMap.get(key).toString();

									hashMap.put(key, value);
								}
							} else {
								hashMap.put(key, hashMap.get(key));
							}
						}

					}

					if (hashMap.get("closed_tickets_creation_time") != null) {

						if (hashMap.get("closed_tickets_creation_time").toString().contains(",")) {
							String value = hashMap.get("closed_tickets_creation_time").toString();
							String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

							hashMap.put("closed_tickets_creation_time", convertDateInEpoch(creation_time));

						} else {
							String value = hashMap.get("closed_tickets_creation_time").toString();

							hashMap.put("closed_tickets_creation_time", convertDateInEpoch(value));
						}

					} else {
						hashMap.put("closed_tickets_creation_time", hashMap.get("creation_time"));
					}

					if (hashMap.get("closed_tickets_pickup_date") != null) {

						if (hashMap.get("closed_tickets_pickup_date").toString().contains(",")) {
							String value = hashMap.get("closed_tickets_pickup_date").toString();
							String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

							hashMap.put("closed_tickets_pickup_date", convertDateInEpoch(creation_time));

						} else {
							String value = hashMap.get("closed_tickets_pickup_date").toString();

							hashMap.put("closed_tickets_pickup_date", convertDateInEpoch(value));
						}

					} else {
						hashMap.put("closed_tickets_pickup_date", hashMap.get("pickup_date"));
					}
					if (hashMap.get("closed_tickets_estimated_arrival_days") != null) {
						if (hashMap.get("closed_tickets_estimated_arrival_days").toString().contains(",")) {
							String value = hashMap.get("closed_tickets_estimated_arrival_days").toString();
							String estimated_arrival_days = value.substring(0, value.indexOf(",") + 1).replace(",", "");

							hashMap.put("closed_tickets_estimated_arrival_days",
									convertDateInEpoch(estimated_arrival_days));

						} else {
							String value = hashMap.get("closed_tickets_estimated_arrival_days").toString();

							hashMap.put("closed_tickets_estimated_arrival_days", convertDateInEpoch(value));

						}
					} else {
						hashMap.put("closed_tickets_estimated_arrival_days",
								hashMap.get("closed_tickets_estimated_arrival_days"));
					}
					if (hashMap.get("closed_tickets_last_modified_by") != null) {
						if (hashMap.get("closed_tickets_last_modified_by").toString().contains(",")) {
							String value = hashMap.get("closed_tickets_last_modified_by").toString();

							hashMap.put("closed_tickets_last_modified_by",
									value.substring(0, value.indexOf(",") + 1).replace(",", ""));
						} else {
							String value = hashMap.get("closed_tickets_last_modified_by").toString();

							hashMap.put("closed_tickets_last_modified_by", value);
						}
					} else {
						hashMap.put("closed_tickets_last_modified_by", hashMap.get("last_modified_by"));
					}
					if (hashMap.get("closed_tickets_dropoff_date") != null) {
						if (hashMap.get("closed_tickets_dropoff_date").toString().contains(",")) {

							String[] dropoff_date = hashMap.get("closed_tickets_dropoff_date").toString().split(",",
									-1);
							StringBuilder dropOffBuilder = new StringBuilder();
							dropOffBuilder.append("");
							for (int j = 0; j < dropoff_date.length; j++) {
								dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

							}
							dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
							hashMap.put("closed_tickets_dropoff_date", dropOffBuilder);

						} else {
							String value = hashMap.get("closed_tickets_dropoff_date").toString();

							hashMap.put("closed_tickets_dropoff_date", convertDateInEpoch(value));

						}
					} else {
						hashMap.put("closed_tickets_dropoff_date", hashMap.get("closed_tickets_dropoff_date"));
					}
					if (hashMap.get("closed_tickets_time_stamp") != null) {
						if (hashMap.get("closed_tickets_time_stamp").toString().contains(",")) {

							String[] dropoff_date = hashMap.get("closed_tickets_time_stamp").toString().split(",", -1);
							StringBuilder dropOffBuilder = new StringBuilder();
							dropOffBuilder.append("");
							for (int j = 0; j < dropoff_date.length; j++) {
								dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

							}
							dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
							hashMap.remove("closed_tickets_time_stamp");
							hashMap.put("closed_tickets_time_stamp", dropOffBuilder);

						} else {
							String value = hashMap.get("closed_tickets_time_stamp").toString();

							hashMap.put("closed_tickets_time_stamp", convertDateInEpoch(value));

						}
					} else {
						hashMap.put("closed_tickets_time_stamp", hashMap.get("closed_tickets_time_stamp"));
					}

				}
				if (hashMap.get("closed_tickets_driver_first_name") != null) {
					if (hashMap.get("closed_tickets_driver_first_name").toString().contains(",")) {

						String[] driver_first_name = hashMap.get("closed_tickets_driver_first_name").toString()
								.split(",", -1);
						String[] driver_middle_name = hashMap.get("closed_tickets_driver_middle_name").toString()
								.split(",", -1);
						String[] driver_last_name = hashMap.get("closed_tickets_driver_last_name").toString().split(",",
								-1);
						StringBuilder nameBuilder = new StringBuilder();

						for (int j = 0; j < driver_first_name.length; j++) {
							nameBuilder.append(driver_first_name[j] + " " + driver_middle_name[j] + " "
									+ driver_last_name[j] + ",");

						}
						nameBuilder.deleteCharAt(nameBuilder.lastIndexOf(","));

						hashMap.put("closed_tickets_driver_name", nameBuilder);

					} else {

						StringBuilder nameBuilder = new StringBuilder();
						nameBuilder.append(String.valueOf(hashMap.get("closed_tickets_driver_first_name")) + " "
								+ String.valueOf(hashMap.get("closed_tickets_driver_middle_name")) + " "
								+ String.valueOf(hashMap.get("closed_tickets_driver_last_name")));
						hashMap.put("closed_tickets_driver_name", nameBuilder.toString());

					}
				} else {
					hashMap.put("closed_tickets_driver_name", null);
				}
				if (hashMap.get("closed_tickets_total_volume_in_percentage") != null) {
					Float total_volume = Float
							.parseFloat(hashMap.get("closed_tickets_total_volume_in_percentage").toString());
					hashMap.put("closed_tickets_free_volume_in_percentage", 100 - total_volume);

				} else {
					hashMap.put("closed_tickets_free_volume_in_percentage", null);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketByVehicle;
	}

	public Message flintVehicleHistoryFilterByRoleName(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			// } else {
			// /*
			// * when role_name is broker
			// */
			// passingMap.remove("role_name");
			//
			// LinkedHashMap<String, String> UserpassingMap = new LinkedHashMap<>();
			// UserpassingMap.put("token", request.getHeader("token"));
			// UserpassingMap.put("user_key", request.getHeader("user_key"));
			// UserpassingMap.put("user_id", request.getHeader("user_id"));
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
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("58", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			List<Map<String, Object>> finalResponseList = (List<Map<String, Object>>) finalProductResponseMessage
					.getObject();
			for (Map<String, Object> map2 : finalResponseList) {
				if (map2.get("transporter_organization_path") == null) {
					map2.put("transporter_organization_path", "NA");
				}
			}
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Return response Message
				 */
				Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
				Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
				List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

				if (userList.size() > 0) {
					for (Map<String, Object> map2 : finalResponseList) {
						for (Map<String, Object> mapuserList : userList) {
							if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
									.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
								map2.remove("transporter_organization_path");
								map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
							}
						}

					}
				}
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(finalResponseList);
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

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message flintVehicleHistoryFilterByRegNo(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("59", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Return response Message
				 */

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				List<Map<String, Object>> formattedList = formattedCloseTicketData(ticketByVehicle);
				Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
				Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
				List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

				if (userList.size() > 0) {
					for (Map<String, Object> map2 : formattedList) {
						for (Map<String, Object> mapuserList : userList) {
							if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
									.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
								map2.remove("transporter_organization_path");
								map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
							}
						}

					}
				}
				responseMessage.setDescription("Process Sucess");
				responseMessage.setObject(ticketByVehicle);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				responseMessage.setDescription("NO Close ticket to the Given Registration No");

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

	// private String convertFromEpoch(String string) {
	// String dateString = string;
	// Date d = new Date(Long.parseLong(dateString));
	// DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	// String formatted = format.format(d);
	//
	// return formatted;
	// }

	public Message flintLiveTrackingFilterByUserId(Map<String, String> map, HttpServletRequest request,
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
			if (passingMap.get("insert_user_id") != null) {
				LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
				passingNewMap.put("token", passingMap.get("token"));
				passingNewMap.put("user_key", passingMap.get("insert_user_key"));
				passingNewMap.put("user_id", passingMap.get("insert_user_id"));

				String deviceModelObject = thirdPartyServices.getUserIdsByOrganization(passingNewMap, request,
						response);
				// System.out.println("deviceModelObject:-" +
				// deviceModelObject);
				if (!deviceModelObject.isEmpty()) {

					passingMap.remove("inser_user_id");
					passingMap.put("insert_user_id", deviceModelObject);

				}

			}
			/**
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("62", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				List<Map<String, Object>> formattedTicketData = getFormatedOpenTicketData(ticketByVehicle);
				Map<String, Object> statusMAp = new HashMap<>();
				List<Map<String, Object>> FinalResponseMessage = new LinkedList<>();
				if (formattedTicketData.size() > 0) {
					String device_id = String
							.valueOf(formattedTicketData.get(0).get("device_driver_vehicle_device_id"));
					/*
					 * Setting the parameters for calling Platform API
					 */
					if (!device_id.equals(null)) {

						LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();

						passingNewMap.put("device_id", device_id);
						/*
						 * Calling Performance Service Status Get Many api of Platform
						 */
						List<Map<String, String>> getPerformanceServiceStatusGetMany = vehicleService
								.getPerformanceServiceStatusGetMany(passingNewMap, request);

						getPerformanceServiceStatusGetMany.forEach((getPerformanceServiceStatusGetManyMap) -> {
							statusMAp.put("device_id",
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("device_id")));
							statusMAp.put("Battery", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Battery"))));

							statusMAp.put("Accuracy", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Accuracy"))));

							statusMAp.put("Latitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude"))));

							statusMAp.put("Longitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude"))));

							statusMAp.put("Rotation", String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Rotation")));

							statusMAp.put("host_status", String
									.valueOf(getPerformanceServiceStatusGetManyMap.get("host_status_host_status")));
							statusMAp.put("sys_timestamp", Double.parseDouble(
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("sys_timestamp"))));
							statusMAp.put("current_time", new Date().getTime());
						});

					}

					formattedTicketData.forEach((ticketByVehicleMap) -> {
						if (ticketByVehicleMap.get("device_driver_vehicle_device_id").toString()
								.equalsIgnoreCase(String.valueOf(statusMAp.get("device_id")).replace(".0", ""))) {
							ticketByVehicleMap.putAll(statusMAp);
							if (ticketByVehicleMap.get("transporter_organization_path") == null) {
								ticketByVehicleMap.put("transporter_organization_path", "NA");
							}
							FinalResponseMessage.add(ticketByVehicleMap);
						}
						if (!ticketByVehicleMap.containsKey("Accuracy")) {
							ticketByVehicleMap.put("Battery", 0);
							ticketByVehicleMap.put("Accuracy", 0);
							ticketByVehicleMap.put("Latitude", null);
							ticketByVehicleMap.put("Longitude", null);
							ticketByVehicleMap.put("Rotation", 0);
							ticketByVehicleMap.put("sys_timestamp", null);
							ticketByVehicleMap.put("host_status", 0);
							ticketByVehicleMap.put("current_time", new Date().getTime());
						}
						if (ticketByVehicleMap.get("transporter_organization_path") == null) {
							ticketByVehicleMap.put("transporter_organization_path", "NA");
						}
						FinalResponseMessage.add(ticketByVehicleMap);

					});
					Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
					Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
					List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

					if (userList.size() > 0) {
						for (Map<String, Object> map2 : FinalResponseMessage) {
							for (Map<String, Object> mapuserList : userList) {
								if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
										.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
									map2.remove("transporter_organization_path");
									map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
								}
							}

						}
					}

					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					responseMessage.setDescription("No device id assigned to following user ");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				}
			} else {
				responseMessage.setDescription("No data for given user");
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

	public Message flintLiveTrackingFilterByOrderNo(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("61", map, null, request,
					response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();

				List<Map<String, Object>> formattedTicketData = getFormatedOpenTicketData(ticketByVehicle);

				Map<String, Object> statusMAp = new HashMap<>();
				List<Map<String, Object>> FinalResponseMessage = new LinkedList<>();
				if (formattedTicketData != null) {
					String device_id = String
							.valueOf(formattedTicketData.get(0).get("device_driver_vehicle_device_id"));
					/*
					 * Setting the parameters for calling Platform API
					 */
					if (!device_id.equals(null)) {

						LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();

						passingNewMap.put("device_id", device_id);
						/*
						 * Calling Performance Service Status Get Many api of Platform
						 */
						List<Map<String, String>> getPerformanceServiceStatusGetMany = vehicleService
								.getPerformanceServiceStatusGetMany(passingNewMap, request);
						// System.out.println("getPerformanceServiceStatusGetMany:-"
						// + getPerformanceServiceStatusGetMany);
						getPerformanceServiceStatusGetMany.forEach((getPerformanceServiceStatusGetManyMap) -> {
							statusMAp.put("device_id",
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("device_id")));
							statusMAp.put("Battery", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Battery"))));

							statusMAp.put("Accuracy", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Accuracy"))));

							statusMAp.put("Latitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Latitude"))));

							statusMAp.put("Longitude", Float.parseFloat(String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Longitude"))));

							statusMAp.put("Rotation", String.valueOf(
									getPerformanceServiceStatusGetManyMap.get("mobileLocationService_Rotation")));

							statusMAp.put("host_status", String
									.valueOf(getPerformanceServiceStatusGetManyMap.get("host_status_host_status")));
							statusMAp.put("sys_timestamp", Double.parseDouble(
									String.valueOf(getPerformanceServiceStatusGetManyMap.get("sys_timestamp"))));
							statusMAp.put("current_time", new Date().getTime());
						});

					}

					formattedTicketData.forEach((ticketByVehicleMap) -> {
						if (ticketByVehicleMap.get("device_driver_vehicle_device_id").toString()
								.equalsIgnoreCase(String.valueOf(statusMAp.get("device_id")).replace(".0", ""))) {
							ticketByVehicleMap.putAll(statusMAp);
							if (ticketByVehicleMap.get("transporter_organization_path") == null) {
								ticketByVehicleMap.put("transporter_organization_path", "NA");
							}
							FinalResponseMessage.add(ticketByVehicleMap);
						}

						if (!ticketByVehicleMap.containsKey("Accuracy")) {
							ticketByVehicleMap.put("Battery", 0);
							ticketByVehicleMap.put("Accuracy", 0);
							ticketByVehicleMap.put("Latitude", null);
							ticketByVehicleMap.put("Longitude", null);
							ticketByVehicleMap.put("Rotation", 0);
							ticketByVehicleMap.put("sys_timestamp", null);
							ticketByVehicleMap.put("host_status", 0);
							ticketByVehicleMap.put("current_time", new Date().getTime());
						}
						if (ticketByVehicleMap.get("transporter_organization_path") == null) {
							ticketByVehicleMap.put("transporter_organization_path", "NA");
						}
						FinalResponseMessage.add(ticketByVehicleMap);

					});
					Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
					Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
					List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

					if (userList.size() > 0) {
						for (Map<String, Object> map2 : FinalResponseMessage) {
							for (Map<String, Object> mapuserList : userList) {
								if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
										.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
									map2.remove("transporter_organization_path");
									map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
								}
							}

						}
					}

					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					responseMessage.setDescription("device_driver_vehicle_device_id is Thats why now live data ");
					responseMessage.setObject(FinalResponseMessage);
					responseMessage.setValid(true);
					return responseMessage;
				}
			} else {
				responseMessage.setDescription("NO Open ticket to the Given Registration No");

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

	private List<Map<String, Object>> getFormatedOpenTicketData(List<Map<String, Object>> ticketByVehicle) {
		try {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < ticketByVehicle.size(); i++) {

				Map<String, Object> hashMap = ticketByVehicle.get(i);

				if (hashMap.get("open_tickets_id") != null) {
					builder.append(hashMap.get("open_tickets_id") + ",");
					if (hashMap.get("open_tickets_pickup_address") != null) {

						if (hashMap.get("open_tickets_pickup_address").toString().contains("#x#f#")) {
							String value = hashMap.get("open_tickets_pickup_address").toString();
							String creation_time = value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", "");

							hashMap.put("open_tickets_pickup_address", creation_time);

						} else {
							String value = hashMap.get("open_tickets_pickup_address").toString();

							hashMap.put("open_tickets_pickup_address", value);
						}

					} else {
						hashMap.put("open_tickets_pickup_address", hashMap.get("open_tickets_pickup_address"));
					}
					for (String key : hashMap.keySet()) {
						if (key.contains("open_tickets_pickup")) {
							if (hashMap.get(key) != null) {
								if (hashMap.get(key).toString().contains(",")) {
									String value = hashMap.get(key).toString();

									hashMap.put(key, value.substring(0, value.indexOf(",") + 1).replace(",", ""));

								} else {
									String value = hashMap.get(key).toString();

									hashMap.put(key, value);
								}
							} else {
								hashMap.put(key, hashMap.get(key));
							}
						}

					}

					if (hashMap.get("open_tickets_creation_time") != null) {

						if (hashMap.get("open_tickets_creation_time").toString().contains(",")) {
							String value = hashMap.get("open_tickets_creation_time").toString();
							String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

							hashMap.put("open_tickets_creation_time", convertDateInEpoch(creation_time));

						} else {
							String value = hashMap.get("open_tickets_creation_time").toString();

							hashMap.put("open_tickets_creation_time", convertDateInEpoch(value));
						}

					} else {
						hashMap.put("open_tickets_creation_time", hashMap.get("creation_time"));
					}

					if (hashMap.get("open_tickets_pickup_date") != null) {

						if (hashMap.get("open_tickets_pickup_date").toString().contains(",")) {
							String value = hashMap.get("open_tickets_pickup_date").toString();
							String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

							hashMap.put("open_tickets_pickup_date", convertDateInEpoch(creation_time));

						} else {
							String value = hashMap.get("open_tickets_pickup_date").toString();

							hashMap.put("open_tickets_pickup_date", convertDateInEpoch(value));
						}

					} else {
						hashMap.put("open_tickets_pickup_date", hashMap.get("pickup_date"));
					}
					if (hashMap.get("open_tickets_estimated_arrival_days") != null) {
						if (hashMap.get("open_tickets_estimated_arrival_days").toString().contains(",")) {
							String value = hashMap.get("open_tickets_estimated_arrival_days").toString();
							String estimated_arrival_days = value.substring(0, value.indexOf(",") + 1).replace(",", "");

							hashMap.put("open_tickets_estimated_arrival_days",
									convertDateInEpoch(estimated_arrival_days));

						} else {
							String value = hashMap.get("open_tickets_estimated_arrival_days").toString();

							hashMap.put("open_tickets_estimated_arrival_days", convertDateInEpoch(value));

						}
					} else {
						hashMap.put("open_tickets_estimated_arrival_days",
								hashMap.get("open_tickets_estimated_arrival_days"));
					}
					if (hashMap.get("open_tickets_last_modified_by") != null) {
						if (hashMap.get("open_tickets_last_modified_by").toString().contains(",")) {
							String value = hashMap.get("open_tickets_last_modified_by").toString();

							hashMap.put("open_tickets_last_modified_by",
									value.substring(0, value.indexOf(",") + 1).replace(",", ""));
						} else {
							String value = hashMap.get("open_tickets_last_modified_by").toString();

							hashMap.put("open_tickets_last_modified_by", value);
						}
					} else {
						hashMap.put("open_tickets_last_modified_by", hashMap.get("last_modified_by"));
					}
					if (hashMap.get("open_tickets_dropoff_date") != null) {
						if (hashMap.get("open_tickets_dropoff_date").toString().contains(",")) {

							String[] dropoff_date = hashMap.get("open_tickets_dropoff_date").toString().split(",", -1);
							StringBuilder dropOffBuilder = new StringBuilder();
							dropOffBuilder.append("");
							for (int j = 0; j < dropoff_date.length; j++) {
								dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

							}
							dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
							hashMap.put("open_tickets_dropoff_date", dropOffBuilder);

						} else {
							String value = hashMap.get("open_tickets_dropoff_date").toString();

							hashMap.put("open_tickets_dropoff_date", convertDateInEpoch(value));

						}
					} else {
						hashMap.put("open_tickets_dropoff_date", hashMap.get("open_tickets_dropoff_date"));
					}
					if (hashMap.get("open_tickets_time_stamp") != null) {
						if (hashMap.get("open_tickets_time_stamp").toString().contains(",")) {

							String[] dropoff_date = hashMap.get("open_tickets_time_stamp").toString().split(",", -1);
							StringBuilder dropOffBuilder = new StringBuilder();
							dropOffBuilder.append("");
							for (int j = 0; j < dropoff_date.length; j++) {
								dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

							}
							dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
							hashMap.remove("open_tickets_time_stamp");
							hashMap.put("open_tickets_time_stamp", dropOffBuilder);

						} else {
							String value = hashMap.get("open_tickets_time_stamp").toString();

							hashMap.put("open_tickets_time_stamp", convertDateInEpoch(value));

						}
					} else {
						hashMap.put("open_tickets_time_stamp", hashMap.get("open_tickets_time_stamp"));
					}

				}
				if (hashMap.get("open_tickets_driver_first_name") != null) {
					if (hashMap.get("open_tickets_driver_first_name").toString().contains(",")) {

						String[] driver_first_name = hashMap.get("open_tickets_driver_first_name").toString().split(",",
								-1);
						String[] driver_middle_name = hashMap.get("open_tickets_driver_middle_name").toString()
								.split(",", -1);
						String[] driver_last_name = hashMap.get("open_tickets_driver_last_name").toString().split(",",
								-1);
						StringBuilder nameBuilder = new StringBuilder();

						for (int j = 0; j < driver_first_name.length; j++) {
							nameBuilder.append(driver_first_name[j] + " " + driver_middle_name[j] + " "
									+ driver_last_name[j] + ",");

						}
						nameBuilder.deleteCharAt(nameBuilder.lastIndexOf(","));

						hashMap.put("open_tickets_driver_name", nameBuilder);

					} else {

						StringBuilder nameBuilder = new StringBuilder();
						nameBuilder.append(String.valueOf(hashMap.get("open_tickets_driver_first_name")) + " "
								+ String.valueOf(hashMap.get("open_tickets_driver_middle_name")) + " "
								+ String.valueOf(hashMap.get("open_tickets_driver_last_name")));
						hashMap.put("open_tickets_driver_name", nameBuilder.toString());

					}
				} else {
					hashMap.put("open_tickets_driver_name", null);
				}
				if (hashMap.get("open_tickets_total_volume_in_percentage") != null) {
					Float total_volume = Float
							.parseFloat(hashMap.get("open_tickets_total_volume_in_percentage").toString());
					hashMap.put("open_tickets_free_volume_in_percentage", 100 - total_volume);

				} else {
					hashMap.put("open_tickets_free_volume_in_percentage", null);
				}

			}
			return ticketByVehicle;
		} catch (Exception e) {
			e.printStackTrace();
			return ticketByVehicle;
		}
	}

	public Message flintVehicleHistoryFilterByUserId(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */
			if (passingMap.get("insert_user_id") != null) {
				LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
				passingNewMap.put("token", passingMap.get("token"));
				passingNewMap.put("user_key", passingMap.get("insert_user_key"));
				passingNewMap.put("user_id", passingMap.get("insert_user_id"));

				String deviceModelObject = thirdPartyServices.getUserIdsByOrganization(passingNewMap, request,
						response);

				if (!deviceModelObject.isEmpty()) {

					passingMap.remove("inser_user_id");
					passingMap.put("insert_user_id", deviceModelObject);

				}

			}
			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("64", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				List<Map<String, Object>> formattedList = formattedCloseTicketData(ticketByVehicle);
				Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
				Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
				List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

				if (userList.size() > 0) {
					for (Map<String, Object> map2 : formattedList) {
						for (Map<String, Object> mapuserList : userList) {
							if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
									.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
								map2.remove("transporter_organization_path");
								map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
							}
						}

					}
				}
				responseMessage.setDescription("Process Sucess");
				responseMessage.setObject(ticketByVehicle);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				responseMessage.setDescription("NO Close ticket to the Given Registration No");

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

	public Message flintVehicleHistoryFilterByOrderNo(Map<String, String> map, HttpServletRequest request,
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
			 * To check whether the role name is Vehicle or Vehicle if it is one of them
			 * than add organiztion_id as null
			 */

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("63", passingMap, null,
					request, response);
			/*
			 * TO Check if it is valid
			 */
			if (finalProductResponseMessage.isValid()) {

				List<Map<String, Object>> ticketByVehicle = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				List<Map<String, Object>> formattedList = formattedCloseTicketData(ticketByVehicle);
				Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
				Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
				List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

				if (userList.size() > 0) {
					for (Map<String, Object> map2 : formattedList) {
						for (Map<String, Object> mapuserList : userList) {
							if (map2.get("vehicle_driver_mapping_vehicle_id").toString()
									.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
								map2.remove("transporter_organization_path");
								map2.put("transporter_organization_path", mapuserList.get("organization_alias"));
							}
						}

					}
				}
				responseMessage.setDescription("Process Sucess");
				responseMessage.setObject(ticketByVehicle);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				responseMessage.setDescription("NO Close ticket to the Given Registration No");

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

}
