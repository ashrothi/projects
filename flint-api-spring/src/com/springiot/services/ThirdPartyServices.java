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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.domain.TemplateSwagger;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.notification.NotificationByFcm;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

import in.teramatrix.mailing.SendEmail;

/**
 * 
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@SuppressWarnings({ "unchecked", "serial", "unused" })
@PropertySource(value = "classpath:/UserCreate.properties")
public class ThirdPartyServices {

	@Autowired
	Environment environment;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * To get all Product ,Vehicle and State * This method is used to retrieve state
	 * and vehicle type and product by calling respective xFuion Platform API's.
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
	public Message flintGetProductVehicleTypeState(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initializing response message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Boolean bit to set the validity of response
			 */
			Boolean boolean1 = false;
			/*
			 * To store the response
			 */
			Map<String, Object> finalResponseMap = new HashMap<>();
			/**
			 * To store the final response with all APi Called and Merging their data
			 */
			List<Map<String, Object>> finalResponseMessage = new LinkedList<>();

			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			try {
				/**
				 * Calling Procedure APi to get Product Details
				 */
				Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("6", null, null, request,
						response);

				/*
				 * Check condition if response is valid or not
				 */
				if (finalProductResponseMessage.isValid()) {
					/**
					 * To get data in List of Map Format
					 */
					List<Map<String, Object>> deviceModelObject = (List<Map<String, Object>>) finalProductResponseMessage
							.getObject();
					/*
					 * to print response
					 */
					finalResponseMap.put("Product", deviceModelObject);
					/*
					 * to set boolean bit
					 */
					boolean1 = true;
				}
			} catch (Exception exception) {
				/**
				 * to catch exception if any
				 */
				finalResponseMap.put("Product", exception);
				boolean1 = false;
			}

			try {
				/**
				 * Calling procedure to get the state
				 */
				Map<String, String> parameterStateMap = new HashMap<>();
				parameterStateMap.put("token", passingMap.get("token"));
				parameterStateMap.put("country_id", map.get("country_id"));
				Message finalStateResponseMessage = genericProcess.GenericProcedureCalling("9", parameterStateMap, null,
						request, response);
				/*
				 * Checking if response is valid
				 */
				if (finalStateResponseMessage.isValid()) {
					List<Map<String, Object>> deviceModelObject = (List<Map<String, Object>>) finalStateResponseMessage
							.getObject();
					/*
					 * Putting it in a final response map
					 */
					finalResponseMap.put("State", deviceModelObject);
					boolean1 = true;
				}
			} catch (Exception e) {
				/*
				 * Catching exception if it comes
				 */
				finalResponseMap.put("State", e);
				boolean1 = false;
			}

			passingMap.remove("country_id");

			try {
				/*
				 * to get the vehicle type on the basis of role_id
				 */
				LinkedHashMap<String, String> passingMapVehicleType = new LinkedHashMap<>();
				passingMapVehicleType.put("token", passingMap.get("token"));
				passingMapVehicleType.put("user_key", request.getHeader("user_key"));
				passingMapVehicleType.put("user_id", request.getHeader("user_id"));
				/*
				 * To get the organization_id
				 */
				String deviceModelObject = getUserIdsByOrganization(passingMapVehicleType, request, response);
				/**
				 * To get the organization id comma separated
				 */

				/*
				 * Passing user_ids_list to call the procedure
				 */
				passingMapVehicleType.put("user_ids_list", deviceModelObject);
				Message finalVehicleTypeResponseMessage = genericProcess.GenericProcedureCalling("17",
						passingMapVehicleType, null, request, response);

				/**
				 * Checking if response is valid or not
				 */
				if (finalVehicleTypeResponseMessage.isValid()) {

					List<Map<String, Object>> deviceModelObject1 = (List<Map<String, Object>>) finalVehicleTypeResponseMessage
							.getObject();
					/*
					 * Putting response in final response message
					 */
					finalResponseMap.put("Vehicle", deviceModelObject1);
					boolean1 = true;
				}
			} catch (Exception e) {
				/*
				 * Handle Exception if it comes
				 */
				finalResponseMap.put("Vehicle", e);
				boolean1 = false;
			}

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			/*
			 * Putting current date in final response Message
			 */
			finalResponseMap.put("currentDate", dateFormat.format(date));
			finalResponseMessage.add(finalResponseMap);
			/**
			 * Checking if final response is not null
			 */
			if (finalResponseMessage != null) {

				/*
				 * Response from API
				 */
				responseMessage.setDescription("Process Successfully.");
				responseMessage.setObject(finalResponseMessage);
				responseMessage.setValid(boolean1);
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

	/*
	 * This method is used to retrieve vehicle type on the basis of Role Name,When
	 * Role Name is Transporter or Vehicle then we'll use third party dB procedure
	 * else we'll use the xFUsion Platform API's to get the use keys list and user
	 * id's list on the basis of particular role name and then third party procedure
	 * is being called.
	 */

	/*
	 * This method is required to call xFusion Platform API providing user
	 * organizations ids.
	 */
	private List<Map<String, Object>> getUserCredentialByOrganization(LinkedHashMap<String, String> passingMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			/*
			 * Initialize response Message
			 */
			Message responseMessage = new Message();
			/*
			 * Initialize Passing Query String to call platform API
			 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			
			 */

			/*
			 * to create Passing Parameter Query String
			 */
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
			/*
			
			 */

			/*
			 * Printing passing parameter query string
			 */
			passingParameter.delete(0, 1);

			/*
			 * Calling XfusionPlatform Performance Service Status Devices Get Many API to
			 * get the data
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(
					urlParameter.getXfusionPlatformPerformanceOrganizationGetAll(), passingParameter.toString(),
					headerMap);
			/*
			 * to print response
			 */

			/*
			 * To check if response in null or not
			 */
			if (finalVehicleResponseMessage != null) {
				/*
				 * Casting response in Generic Message format
				 */
				Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();
				/*
				 * Getting response in formatted way
				 */
				GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				/*
				 * to get response in List of Map
				 */
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();
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
			return null;
		} catch (Exception e) {
			throw e;
		}

	}

	public String getUserIdsByOrganization(LinkedHashMap<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StringBuilder userIdListBuilder = new StringBuilder();
		try {
			/*
			 * Initialize response Message
			 */
			Message responseMessage = new Message();
			/*
			 * Initialize Passing Query String to call platform API
			 */
			StringBuilder passingParameter = new StringBuilder();

			/*
			 * to create Passing Parameter Query String
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : passingMap.keySet()) {
				/*
				 * Retrieving the xFusion Platform Token
				 */

				/*
				 * to append token in query string
				 */
				// passingParameter.append("token=" +
				// token.getAccess_token());
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

			passingParameter.delete(0, 1);
			/*
			 * Printing passing parameter query string
			 */

			/*
			 * Calling XfusionPlatform Performance Service Status Devices Get Many API to
			 * get the data
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(
					urlParameter.getXfusionPlatformUsersGetAllByUserOrganization(), passingParameter.toString(),
					headerMap);
			/*
			 * to print response
			 */

			/*
			 * To check if response in null or not
			 */
			System.out.println("finalVehicleResponseMessage:-" + finalVehicleResponseMessage);
			if (finalVehicleResponseMessage != null) {
				/*
				 * Casting response in Generic Message format
				 */
				Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();
				/*
				 * Getting response in formatted way
				 */
				GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				/*
				 * to get response in List of Map
				 */
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();
				// System.out.println("deviceModelObject + " +
				// deviceModelObject);
				/*
				 * to print response
				 */

				/*
				 * to check if response is null
				 */
				System.out.println("deviceModelObject:- " + deviceModelObject);
				/*
				 * To get organization id's comma separated
				 */
				if (deviceModelObject != null) {
					userIdListBuilder.append(String.valueOf(deviceModelObject.get(0).get("user_ids")));
				}

			}
			return userIdListBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return userIdListBuilder.toString();

	}

	/*
	 * This method is required to call xFusion Platform API providing user
	 * credentials on the basis of organization and retrieve list of device ids
	 */
	public Message getDeviceIds(LinkedHashMap<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();
		try {
			Map<String, String> passinParemeter = new HashMap<>();
			/**
			 * Parameters to call Procedure to get all Device ids
			 */

			passinParemeter.put("user_key", passingMap.get("user_key"));
			passinParemeter.put("user_id", passingMap.get("user_id"));
			/*
			 * To check if role_name is driver
			 */
			// if (passingMap.get("role_name").equalsIgnoreCase("Vehicle")) {
			// passinParemeter.put("user_ids_list ", null);

			responseMessage = genericProcess.GenericProcedureCalling("31", passinParemeter, null, request, response);
			/*
			 * to check if response is valid
			 */
			if (responseMessage.isValid()) {

				List<Map<String, Object>> deviceModelObject = (List<Map<String, Object>>) responseMessage.getObject();
				responseMessage.setDescription("Process Success ");
				responseMessage.setObject(deviceModelObject);
				responseMessage.setValid(true);
				return responseMessage;
			}

			// } else {
			// /*
			// * if Role is other than Vehicle
			// */
			// passingMap.remove("role_name");
			//
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			//
			// passinParemeter.put("user_ids_list", deviceModelObject);
			//
			// /*
			// * Calling Procedure To get data
			// */
			// responseMessage = genericProcess.GenericProcedureCalling("31",
			// passinParemeter, null, request,
			// response);
			// /*
			// * To check if the response is valid
			// */
			// if (responseMessage.isValid()) {
			// List<Map<String, Object>> deviceModelObject1 = (List<Map<String, Object>>)
			// responseMessage
			// .getObject();
			//
			// responseMessage.setDescription("Process Success ");
			// responseMessage.setObject(deviceModelObject1);
			// responseMessage.setValid(true);
			// return responseMessage;
			// }
			// }
			// return null;
			responseMessage.setDescription("Process fail ");
			responseMessage.setValid(false);
			return responseMessage;
		} catch (Exception e) {

			throw e;
		}

	}

	/*
	 * This method is required to retrieve closed tickets on the basis of Role
	 * Name,When Role Name is Transporter or Vehicle then we'll use third party dB
	 * procedure else we'll use the xFUsion Platform API's to get the use keys list
	 * and user id's list on the basis of particular role name and then third party
	 * procedure is being called.
	 */
	public Message flintCloseTicketsGetAll(String requestType, Map<String, String> map, Object object,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.putAll(map);
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("from_date", convertFromEpoch(map.get("from_date").toString()));
			passingMap.put("to_date", convertFromEpoch(map.get("to_date").toString()));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			
			
			
			/*
			 * Check condition whether role name is Transporter or Vehicle
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", null);
			// passingMap.put("from_date",
			// convertFromEpoch(map.get("from_date").toString()));
			// passingMap.put("to_date", convertFromEpoch(map.get("to_date").toString()));
			// passingMap.put("limit", map.get("limit"));
			// passingMap.put("offset", map.get("offset"));
			//
			// } else {
			// /*
			// * When role_name is other than Vehicle
			// */
			// passingMap.remove("role_name");
			// /**
			// * To get the user_ids of the users comes under their
			// * organization
			// */
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			// /*
			// * To get all user_ids
			// */
			// // System.out.println("deviceModelObject" + deviceModelObject);
			//
			// if (deviceModelObject != null) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", deviceModelObject.toString());
			//
			//
			// }
			// }

			/*
			 * Calling Procedure to get data
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);

			if (finalProductResponseMessage.isValid()) {
				List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) finalProductResponseMessage
						.getObject();

				StringBuilder builderNew = new StringBuilder();
				/**
				 * To manipulate data as required Send all first value of Array in formatted way
				 */
				for (int i = 0; i < list.size(); i++) {

					HashMap<String, Object> hashMap = list.get(i);

					if (hashMap.get("closed_tickets_id") != null) {
						builderNew.append(hashMap.get("closed_tickets_id") + ",");
						if (hashMap.get("pickup_address") != null) {

							if (hashMap.get("pickup_address").toString().contains("#x#f#")) {
								String value = hashMap.get("pickup_address").toString();
								String creation_time = value.substring(0, value.indexOf("#x#f#") + 1).replace("#x#f#",
										"");

								hashMap.put("pickup_address",
										value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", ""));

							} else {
								String value = hashMap.get("pickup_address").toString();

								hashMap.put("pickup_address", value);
							}

						} else {
							hashMap.put("pickup_address", hashMap.get("pickup_address"));
						}
						for (String key : hashMap.keySet()) {
							if (key.contains("pickup")) {
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

						if (hashMap.get("creation_time") != null) {

							if (hashMap.get("creation_time").toString().contains(",")) {
								String value = hashMap.get("creation_time").toString();
								String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

								hashMap.put("creation_time", convertDateInEpoch(creation_time));

							} else {
								String value = hashMap.get("creation_time").toString();

								hashMap.put("creation_time", convertDateInEpoch(value));
							}

						} else {
							hashMap.put("creation_time", hashMap.get("creation_time"));
						}
						if (hashMap.get("pickup_date") != null) {

							if (hashMap.get("pickup_date").toString().contains(",")) {
								String value = hashMap.get("pickup_date").toString();
								String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

								hashMap.put("pickup_date", convertDateInEpoch(creation_time));

							} else {
								String value = hashMap.get("pickup_date").toString();

								hashMap.put("pickup_date", convertDateInEpoch(value));
							}

						} else {
							hashMap.put("pickup_date", hashMap.get("pickup_date"));
						}

						if (hashMap.get("estimated_arrival_days") != null) {
							if (hashMap.get("estimated_arrival_days").toString().contains(",")) {
								String value = hashMap.get("estimated_arrival_days").toString();
								String estimated_arrival_days = value.substring(0, value.indexOf(",") + 1).replace(",",
										"");

								hashMap.put("estimated_arrival_days", convertDateInEpoch(estimated_arrival_days));

							} else {
								String value = hashMap.get("estimated_arrival_days").toString();

								hashMap.put("estimated_arrival_days", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("estimated_arrival_days", hashMap.get("estimated_arrival_days"));
						}
						if (hashMap.get("last_modified_by") != null) {
							if (hashMap.get("last_modified_by").toString().contains(",")) {
								String value = hashMap.get("last_modified_by").toString();

								hashMap.put("last_modified_by",
										value.substring(0, value.indexOf(",") + 1).replace(",", ""));
							} else {
								String value = hashMap.get("last_modified_by").toString();

								hashMap.put("last_modified_by", value);
							}
						} else {
							hashMap.put("last_modified_by", hashMap.get("last_modified_by"));
						}
						if (hashMap.get("dropoff_date") != null) {
							if (hashMap.get("dropoff_date").toString().contains(",")) {

								String[] dropoff_date = hashMap.get("dropoff_date").toString().split(",", -1);
								StringBuilder dropOffBuilder = new StringBuilder();
								dropOffBuilder.append("");
								for (int j = 0; j < dropoff_date.length; j++) {
									dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

								}
								dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
								hashMap.put("dropoff_date", dropOffBuilder);

							} else {
								String value = hashMap.get("dropoff_date").toString();

								hashMap.put("dropoff_date", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("dropoff_date", hashMap.get("dropoff_date"));
						}
						if (hashMap.get("time_stamp") != null) {
							if (hashMap.get("time_stamp").toString().contains(",")) {

								String[] dropoff_date = hashMap.get("time_stamp").toString().split(",", -1);
								StringBuilder dropOffBuilder = new StringBuilder();
								dropOffBuilder.append("");
								for (int j = 0; j < dropoff_date.length; j++) {
									dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

								}
								dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));

								hashMap.put("time_stamp", dropOffBuilder);

							} else {
								String value = hashMap.get("time_stamp").toString();

								hashMap.put("time_stamp", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("time_stamp", hashMap.get("time_stamp"));
						}
						if (hashMap.get("driver_first_name") != null) {
							if (hashMap.get("driver_first_name").toString().contains(",")) {

								String[] driver_first_name = hashMap.get("driver_first_name").toString().split(",", -1);
								String[] driver_middle_name = hashMap.get("driver_middle_name").toString().split(",",
										-1);
								String[] driver_last_name = hashMap.get("driver_last_name").toString().split(",", -1);
								StringBuilder nameBuilder = new StringBuilder();

								for (int j = 0; j < driver_first_name.length; j++) {
									nameBuilder.append(driver_first_name[j] + " " + driver_middle_name[j] + " "
											+ driver_last_name[j] + ",");

								}
								nameBuilder.deleteCharAt(nameBuilder.lastIndexOf(","));

								hashMap.put("driver_name", nameBuilder);

							} else {

								StringBuilder nameBuilder = new StringBuilder();
								nameBuilder.append(String.valueOf(hashMap.get("driver_first_name")) + " "
										+ String.valueOf(hashMap.get("driver_middle_name")) + " "
										+ String.valueOf(hashMap.get("driver_last_name")));
								hashMap.put("driver_name", nameBuilder.toString());

							}
						} else {
							hashMap.put("driver_name", null);
						}

					}
				}
				/*
				 * To send response
				 */
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(list);
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

	private String convertFromEpoch(String string) throws Exception {
		String dateString = string;
		Date d = new Date(Long.parseLong(dateString));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formatted = format.format(d);

		return formatted;
	}

	/*
	 * This method is required to retrieve all open tickets on the basis of Role
	 * Name,When Role Name is Transporter or Vehicle then we'll use third party dB
	 * procedure else we'll use the xFUsion Platform API's to get the use keys list
	 * and user id's list on the basis of particular role name and then third party
	 * procedure is being called.
	 */
	public Message flintOpenTicketsGetAll(String requestType, Map<String, String> map, Object object,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			/*
			 * Check condition whether role name is Transporter or Vehicle
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// map.remove("role_name");
			// passingMap.put("user_ids_list", null);
			// passingMap.put("limit", map.get("limit"));
			// passingMap.put("offset", map.get("offset"));
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			// /*
			// * To get all user_ids
			// */
			// // System.out.println("deviceModelObject" + deviceModelObject);
			//
			// if (deviceModelObject != null) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", deviceModelObject.toString());
			// passingMap.put("limit", map.get("limit"));
			// passingMap.put("offset", map.get("offset"));
			//
			// }
			// }
			passingMap.putAll(map);

			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);

			if (finalProductResponseMessage.isValid()) {
				List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) finalProductResponseMessage
						.getObject();

				StringBuilder builderNew = new StringBuilder();

				for (int i = 0; i < list.size(); i++) {

					HashMap<String, Object> hashMap = list.get(i);

					if (hashMap.get("open_tickets_id") != null) {
						builderNew.append(hashMap.get("open_tickets_id") + ",");
						if (hashMap.get("pickup_address") != null) {

							if (hashMap.get("pickup_address").toString().contains("#x#f#")) {
								String value = hashMap.get("pickup_address").toString();
								String creation_time = value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", "");

								hashMap.put("pickup_address", creation_time);

							} else {
								String value = hashMap.get("pickup_address").toString();

								hashMap.put("pickup_address", value);
							}

						} else {
							hashMap.put("pickup_address", hashMap.get("pickup_address"));
						}
						for (String key : hashMap.keySet()) {
							if (key.contains("pickup")) {
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

						if (hashMap.get("creation_time") != null) {

							if (hashMap.get("creation_time").toString().contains(",")) {
								String value = hashMap.get("creation_time").toString();
								String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

								hashMap.put("creation_time", convertDateInEpoch(creation_time));

							} else {
								String value = hashMap.get("creation_time").toString();

								hashMap.put("creation_time", convertDateInEpoch(value));
							}

						} else {
							hashMap.put("creation_time", hashMap.get("creation_time"));
						}
						if (hashMap.get("pickup_date") != null) {

							if (hashMap.get("pickup_date").toString().contains(",")) {
								String value = hashMap.get("pickup_date").toString();
								String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

								hashMap.put("pickup_date", convertDateInEpoch(creation_time));

							} else {
								String value = hashMap.get("pickup_date").toString();

								hashMap.put("pickup_date", convertDateInEpoch(value));
							}

						} else {
							hashMap.put("pickup_date", hashMap.get("pickup_date"));
						}
						if (hashMap.get("estimated_arrival_days") != null) {
							if (hashMap.get("estimated_arrival_days").toString().contains(",")) {
								String value = hashMap.get("estimated_arrival_days").toString();
								String estimated_arrival_days = value.substring(0, value.indexOf(",") + 1).replace(",",
										"");

								hashMap.put("estimated_arrival_days", convertDateInEpoch(estimated_arrival_days));

							} else {
								String value = hashMap.get("estimated_arrival_days").toString();

								hashMap.put("estimated_arrival_days", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("estimated_arrival_days", hashMap.get("estimated_arrival_days"));
						}
						if (hashMap.get("last_modified_by") != null) {
							if (hashMap.get("last_modified_by").toString().contains(",")) {
								String value = hashMap.get("last_modified_by").toString();

								hashMap.put("last_modified_by",
										value.substring(0, value.indexOf(",") + 1).replace(",", ""));
							} else {
								String value = hashMap.get("last_modified_by").toString();

								hashMap.put("last_modified_by", value);
							}
						} else {
							hashMap.put("last_modified_by", hashMap.get("last_modified_by"));
						}
						if (hashMap.get("dropoff_date") != null) {
							if (hashMap.get("dropoff_date").toString().contains(",")) {

								String[] dropoff_date = hashMap.get("dropoff_date").toString().split(",", -1);
								StringBuilder dropOffBuilder = new StringBuilder();
								dropOffBuilder.append("");
								for (int j = 0; j < dropoff_date.length; j++) {
									dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

								}
								dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
								hashMap.put("dropoff_date", dropOffBuilder);

							} else {
								String value = hashMap.get("dropoff_date").toString();

								hashMap.put("dropoff_date", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("dropoff_date", hashMap.get("dropoff_date"));
						}
						if (hashMap.get("time_stamp") != null) {
							if (hashMap.get("time_stamp").toString().contains(",")) {

								String[] dropoff_date = hashMap.get("time_stamp").toString().split(",", -1);
								StringBuilder dropOffBuilder = new StringBuilder();
								dropOffBuilder.append("");
								for (int j = 0; j < dropoff_date.length; j++) {
									dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

								}
								dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));

								hashMap.put("time_stamp", dropOffBuilder);

							} else {
								String value = hashMap.get("time_stamp").toString();

								hashMap.put("time_stamp", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("time_stamp", hashMap.get("time_stamp"));
						}
						if (hashMap.get("driver_first_name") != null) {
							if (hashMap.get("driver_first_name").toString().contains(",")) {

								String[] driver_first_name = hashMap.get("driver_first_name").toString().split(",", -1);
								String[] driver_middle_name = hashMap.get("driver_middle_name").toString().split(",",
										-1);
								String[] driver_last_name = hashMap.get("driver_last_name").toString().split(",", -1);
								StringBuilder nameBuilder = new StringBuilder();

								for (int j = 0; j < driver_first_name.length; j++) {
									nameBuilder.append(driver_first_name[j] + " " + driver_middle_name[j] + " "
											+ driver_last_name[j] + ",");

								}
								nameBuilder.deleteCharAt(nameBuilder.lastIndexOf(","));

								hashMap.put("driver_name", nameBuilder);

							} else {

								StringBuilder nameBuilder = new StringBuilder();
								nameBuilder.append(String.valueOf(hashMap.get("driver_first_name")) + " "
										+ String.valueOf(hashMap.get("driver_middle_name")) + " "
										+ String.valueOf(hashMap.get("driver_last_name")));
								hashMap.put("driver_name", nameBuilder.toString());

							}
						} else {
							hashMap.put("driver_name", null);
						}
						if (hashMap.get("total_volume_in_percentage") != null) {
							Float total_volume = Float.parseFloat(hashMap.get("total_volume_in_percentage").toString());
							hashMap.put("free_volume_in_percentage", 100 - total_volume);

						} else {
							hashMap.put("free_volume_in_percentage", null);
						}

					}
				}
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(list);
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

	private Object convertDateInEpoch(String replace) throws ParseException {

		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask
		Date date = dF.parse(replace); // parsing the String into a Date using
										// the mask

		return date.getTime();
	}

	/*
	 * This method is used to get all notifications on the basis of Role Name,When
	 * Role Name is Transporter or Vehicle then we'll use third party dB procedure
	 * else we'll use the xFUsion Platform API's to get the use keys list and user
	 * id's list on the basis of particular role name and then third party procedure
	 * is being called.
	 */
	public Message flintNotificationGetAll(String requestType, Map<String, String> map, Object object,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			/*
			 * Check condition whether role name is Transporter or Vehicle
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// map.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			// /*
			// * To get all user_ids
			// */
			// // System.out.println("deviceModelObject" + deviceModelObject);
			//
			// if (deviceModelObject != null) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", deviceModelObject.toString());
			//
			// }
			// }

			passingMap.put("from_date", map.get("from_date"));
			passingMap.put("end_date", map.get("end_date"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);

			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */
				return finalProductResponseMessage;
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

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get all Open Ticket for Mobile
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
	public Message flintOpenTicketsGetAllWeb(String requestType, Map<String, String> map, Object object,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Initializing the Message
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

			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			passingMap.putAll(map);
			/*
			 * Calling API to get close ticket
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);
			Map<String, Object> ResultTicketMap = new LinkedHashMap();
			if (finalProductResponseMessage.isValid()) {
				List<Map<String, Object>> ResultObject = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				/*
				 * Checking if tickets response is not null
				 */
				if (ResultObject.size() > 0) {
					for (Map<String, Object> resultMap : ResultObject) {
						Map<String, String> passingParameter = new HashMap<>();
						passingParameter.put("token", request.getHeader("token"));
						passingParameter.put("user_key", request.getHeader("user_key"));
						passingParameter.put("user_id", request.getHeader("user_id"));
						passingParameter.put("ticket_id", resultMap.get("ticket_id").toString());
						/**
						 * Calling GenericProcedureCalling to get task of each ticket
						 */
						Message resultTaskMessage = genericProcess.GenericProcedureCalling("23", passingParameter, null,
								request, response);
						/*
						 * Clubbing ticket id with its tasks
						 */
						if (resultTaskMessage.isValid()) {
							// List<Map<String, Object>> resultTaskMessageList = (List<Map<String, Object>>)
							// resultTaskMessage
							// .getObject();
							// resultTaskMessageList.get(0).putAll(resultMap);
							ResultTicketMap.put(resultMap.get("ticket_id").toString(), resultTaskMessage.getObject());
						}
						/*
						 * Putting data in response
						 */
						ResultTicketMap.putAll(ResultTicketMap);
					}
					/*
					 * Handling data and returning response with its valid bit
					 */
					List<Map<String, Object>> finalResultObject = new LinkedList<>();
					finalResultObject.add(ResultTicketMap);
					/*
					 * If final response size is greater than zero
					 */
					if (finalResultObject.size() > 0) {
						ResultTicketMap.put("Status", true);
						responseMessage.setDescription("Process Sucess");
						responseMessage.setObject(ResultTicketMap);
						responseMessage.setValid(true);
						return responseMessage;
					}
					/*
					 * if finalResultObject size is 0
					 */
					else {
						ResultTicketMap.put("Status", false);
						responseMessage.setDescription("Process Sucess");
						responseMessage.setObject(ResultTicketMap);
						responseMessage.setValid(false);
						return responseMessage;
					}

				} else {
					ResultTicketMap.put("Status", false);
					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(ResultTicketMap);
					responseMessage.setValid(false);
					return responseMessage;
				}

			}
			/*
			 * If didn't get ticket id
			 */
			else {
				ResultTicketMap.put("Status", false);
				responseMessage.setDescription("Process Sucess");
				responseMessage.setObject(ResultTicketMap);
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
	 * To get all close Ticket for Mobile
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
	public Message flintCloseTicketsGetAllMobile(String requestType, Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Initializing the Message
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
			passingMap.put("from_date", map.get("from_date"));
			passingMap.put("to_date", map.get("to_date"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			passingMap.putAll(map);

			/*
			 * Check condition whether role name is Transporter or Vehicle
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// map.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			// /*
			// * To get all user_ids
			// */
			// // System.out.println("deviceModelObject" + deviceModelObject);
			//
			// if (deviceModelObject != null) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", deviceModelObject.toString());
			// passingMap.put("from_date", map.get("from_date"));
			// passingMap.put("to_date", map.get("to_date"));
			// passingMap.put("limit", map.get("limit"));
			// passingMap.put("offset", map.get("offset"));
			//
			// }
			// }
			/*
			 * Calling API to get close ticket
			 */
			passingMap.putAll(map);
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);
			Map<String, Object> ResultTicketMap = new HashMap<>();
			if (finalProductResponseMessage.isValid()) {
				List<Map<String, Object>> ResultObject = (List<Map<String, Object>>) finalProductResponseMessage
						.getObject();
				/*
				 * Checking if tickets response is not null
				 */
				if (ResultObject.size() > 0) {
					for (Map<String, Object> resultMap : ResultObject) {
						Map<String, String> passingParameter = new HashMap<>();
						passingParameter.put("token", request.getHeader("token"));
						passingParameter.put("user_key", request.getHeader("user_key"));
						passingParameter.put("user_id", request.getHeader("user_id"));
						passingParameter.put("ticket_id", resultMap.get("ticket_id").toString());
						/**
						 * Calling GenericProcedureCalling to get task of each ticket
						 */
						Message resultTaskMessage = genericProcess.GenericProcedureCalling("29", passingParameter, null,
								request, response);
						/*
						 * Clubbing ticket id with its tasks
						 */
						if (resultTaskMessage.isValid()) {
							ResultTicketMap.put(resultMap.get("ticket_id").toString(), resultTaskMessage.getObject());
						}
						/*
						 * Putting data in response
						 */
						ResultTicketMap.putAll(ResultTicketMap);
					}
					/*
					 * Handling data and returning response with its valid bit
					 */
					List<Map<String, Object>> finalResultObject = new LinkedList<>();
					finalResultObject.add(ResultTicketMap);
					/*
					 * If final response size is greater than zero
					 */
					if (finalResultObject.size() > 0) {
						ResultTicketMap.put("Status", true);
						responseMessage.setDescription("Process Sucess");
						responseMessage.setObject(ResultTicketMap);
						responseMessage.setValid(true);
						return responseMessage;
					}
					/*
					 * if finalResultObject size is 0
					 */
					else {
						ResultTicketMap.put("Status", false);
						responseMessage.setDescription("Process Sucess");
						responseMessage.setObject(ResultTicketMap);
						responseMessage.setValid(false);
						return responseMessage;
					}

				}
				/*
				 * If didn't get ticket id
				 */
				else {
					ResultTicketMap.put("Status", false);
					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(ResultTicketMap);
					responseMessage.setValid(false);
					return responseMessage;
				}
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
	 * To send FCM Notification WHen the Ticket has been created to the assigned
	 * driver
	 * 
	 * @param object
	 * @param status
	 * @return
	 */
	public Boolean pushFCMNotificationOpenTicket(Object object) throws Exception {
		try {
			/**
			 * TO get all procedures with their key
			 */
			Map<String, Object> proParam = processParameter.getMaps();
			/**
			 * to get responseFromOpenTicket in List<Map<String, Object>> format
			 */
			List<Map<String, Object>> responseFromOpenTicket = (List<Map<String, Object>>) object;
			/*
			 * to print response
			 */

			/*
			 * Calling Procedure to get Fcm Id
			 */
			System.out.println("responseFromOpenTicket:-" + responseFromOpenTicket
					+ responseFromOpenTicket.get(0).get("user_key").toString()
					+ responseFromOpenTicket.get(0).get("user_id").toString()
					+ responseFromOpenTicket.get(0).get("vehicle_id").toString());

			Object message = genericService.executeProcesure(null, proParam.get("43").toString(),
					responseFromOpenTicket.get(0).get("user_key").toString(),
					responseFromOpenTicket.get(0).get("user_id").toString(),
					responseFromOpenTicket.get(0).get("vehicle_id").toString());
			/*
			 * To return date and time in formatted way in response
			 */

			// System.out.println("message:- " + message);
			if (responseFromOpenTicket.get(0).get("estimated_arrival_days") != null) {
				String timeToConvert = responseFromOpenTicket.get(0).get("estimated_arrival_days").toString()
						.replace(".0", "");
				Object convertedTime = convertDateInEpoch(timeToConvert);
				responseFromOpenTicket.get(0).remove("estimated_arrival_days");
				responseFromOpenTicket.get(0).put("estimated_arrival_days", convertedTime);
			}
			if (responseFromOpenTicket.get(0).get("creation_time") != null) {
				String timeToConvert = responseFromOpenTicket.get(0).get("creation_time").toString().replace(".0", "");
				Object convertedTime = convertDateInEpoch(timeToConvert);
				responseFromOpenTicket.get(0).remove("creation_time");
				responseFromOpenTicket.get(0).put("creation_time", convertedTime);
			}
			if (responseFromOpenTicket.get(0).get("pickup_date") != null) {
				String timeToConvert = responseFromOpenTicket.get(0).get("pickup_date").toString().replace(".0", "");
				Object convertedTime = convertDateInEpoch(timeToConvert);
				responseFromOpenTicket.get(0).remove("pickup_date");
				responseFromOpenTicket.get(0).put("pickup_date", convertedTime);
			}
			if (responseFromOpenTicket.get(0).get("dropoff_date") != null) {
				String timeToConvert = responseFromOpenTicket.get(0).get("dropoff_date").toString().replace(".0", "");
				Object convertedTime = convertDateInEpoch(timeToConvert);
				responseFromOpenTicket.get(0).remove("dropoff_date");
				responseFromOpenTicket.get(0).put("dropoff_date", convertedTime);
			}
			if (responseFromOpenTicket.get(0).get("time_stamp") != null) {
				String timeToConvert = responseFromOpenTicket.get(0).get("time_stamp").toString().replace(".0", "");
				Object convertedTime = convertDateInEpoch(timeToConvert);
				responseFromOpenTicket.get(0).remove("time_stamp");
				responseFromOpenTicket.get(0).put("time_stamp", convertedTime);
			}
			if (responseFromOpenTicket.get(0).get("last_modified_time") != null) {
				String timeToConvert = responseFromOpenTicket.get(0).get("last_modified_time").toString().replace(".0",
						"");
				Object convertedTime = convertDateInEpoch(timeToConvert);
				responseFromOpenTicket.get(0).remove("last_modified_time");
				responseFromOpenTicket.get(0).put("last_modified_time", convertedTime);
			}
			responseFromOpenTicket.get(0).put("status", 1);
			/**
			 * TO check if message is not null
			 */
			if (message != null) {
				/**
				 * to get FCM Id
				 */
				List<Map<String, Object>> responseForFCM = (List<Map<String, Object>>) message;
				System.out.println("responseForFCM  :- " + responseForFCM);
				String fcmID = String.valueOf(responseForFCM.get(0).get("gcm_id"));

				/**
				 * Calling push Notification Method
				 */
				NotificationByFcm.pushFCMNotification(fcmID, responseFromOpenTicket.get(0));
				return true;
			}
			return false;
		} catch (Exception e) {
			/*
			 * to catch exception if it comes
			 */

			throw e;
		}
	}

	public Message flintGlobalSearch(String requestType, Map<String, String> map, Object object,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			passingMap.put("keyword_to_search", map.get("keyword_to_search"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			/*
			 * Check condition whether role name is Transporter or Vehicle
			 */
			// if (map.get("role_name").equalsIgnoreCase("Vehicle")) {
			//
			// /*
			// * Again adding and removing some parameters from the map to call generic API
			// */
			// map.remove("role_name");
			// passingMap.put("user_ids_list", null);
			//
			//
			// } else {
			// /*
			// * When role_name is Broker
			// */
			// passingMap.remove("role_name");
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			// /*
			// * To get all user_ids
			// */
			// // System.out.println("deviceModelObject" + deviceModelObject);
			//
			// if (deviceModelObject != null) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", deviceModelObject.toString());
			// passingMap.put("keyword_to_search", map.get("keyword_to_search"));
			// passingMap.put("limit", map.get("limit"));
			// passingMap.put("offset", map.get("offset"));
			//
			// }
			// }

			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);

			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */
				return finalProductResponseMessage;
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

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message flintSavedOpenTicketGetAll(String requestType, Map<String, String> map, Object object,
			HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("limit", map.get("limit"));
			passingMap.put("offset", map.get("offset"));
			/*
			 * When role_name is Broker
			 */
			// passingMap.remove("role_name");
			// String deviceModelObject = getUserIdsByOrganization(passingMap, request,
			// response);
			// /*
			// * To get all user_ids
			// */
			// // System.out.println("deviceModelObject" + deviceModelObject);
			//
			// if (deviceModelObject != null) {
			//
			// /*
			// * Again adding and removing some parameters to the map.
			// */
			// passingMap.remove("role_name");
			// passingMap.put("user_ids_list", deviceModelObject.toString());
			//

			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling(requestType, passingMap, null,
					request, response);

			if (finalProductResponseMessage.isValid()) {
				List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) finalProductResponseMessage
						.getObject();

				StringBuilder builderNew = new StringBuilder();

				for (int i = 0; i < list.size(); i++) {

					HashMap<String, Object> hashMap = list.get(i);

					if (hashMap.get("open_tickets_id") != null) {
						builderNew.append(hashMap.get("open_tickets_id") + ",");
						if (hashMap.get("pickup_address") != null) {

							if (hashMap.get("pickup_address").toString().contains("#x#f#")) {
								String value = hashMap.get("pickup_address").toString();
								String creation_time = value.substring(0, value.indexOf("#x#f#")).replace("#x#f#", "");

								hashMap.put("pickup_address", creation_time);

							} else {
								String value = hashMap.get("pickup_address").toString();

								hashMap.put("pickup_address", value);
							}

						} else {
							hashMap.put("pickup_address", hashMap.get("pickup_address"));
						}
						for (String key : hashMap.keySet()) {
							if (key.contains("pickup")) {
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

						if (hashMap.get("creation_time") != null) {

							if (hashMap.get("creation_time").toString().contains(",")) {
								String value = hashMap.get("creation_time").toString();
								String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

								hashMap.put("creation_time", convertDateInEpoch(creation_time));

							} else {
								String value = hashMap.get("creation_time").toString();

								hashMap.put("creation_time", convertDateInEpoch(value));
							}

						} else {
							hashMap.put("creation_time", hashMap.get("creation_time"));
						}
						if (hashMap.get("pickup_date") != null) {

							if (hashMap.get("pickup_date").toString().contains(",")) {
								String value = hashMap.get("pickup_date").toString();
								String creation_time = value.substring(0, value.indexOf(",") + 1).replace(",", "");

								hashMap.put("pickup_date", convertDateInEpoch(creation_time));

							} else {
								String value = hashMap.get("pickup_date").toString();

								hashMap.put("pickup_date", convertDateInEpoch(value));
							}

						} else {
							hashMap.put("pickup_date", hashMap.get("pickup_date"));
						}
						if (hashMap.get("estimated_arrival_days") != null) {
							if (hashMap.get("estimated_arrival_days").toString().contains(",")) {
								String value = hashMap.get("estimated_arrival_days").toString();
								String estimated_arrival_days = value.substring(0, value.indexOf(",") + 1).replace(",",
										"");

								hashMap.put("estimated_arrival_days", convertDateInEpoch(estimated_arrival_days));

							} else {
								String value = hashMap.get("estimated_arrival_days").toString();

								hashMap.put("estimated_arrival_days", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("estimated_arrival_days", hashMap.get("estimated_arrival_days"));
						}
						if (hashMap.get("last_modified_by") != null) {
							if (hashMap.get("last_modified_by").toString().contains(",")) {
								String value = hashMap.get("last_modified_by").toString();

								hashMap.put("last_modified_by",
										value.substring(0, value.indexOf(",") + 1).replace(",", ""));
							} else {
								String value = hashMap.get("last_modified_by").toString();

								hashMap.put("last_modified_by", value);
							}
						} else {
							hashMap.put("last_modified_by", hashMap.get("last_modified_by"));
						}
						if (hashMap.get("dropoff_date") != null) {
							if (hashMap.get("dropoff_date").toString().contains(",")) {

								String[] dropoff_date = hashMap.get("dropoff_date").toString().split(",", -1);
								StringBuilder dropOffBuilder = new StringBuilder();
								dropOffBuilder.append("");
								for (int j = 0; j < dropoff_date.length; j++) {
									dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

								}
								dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));
								hashMap.put("dropoff_date", dropOffBuilder);

							} else {
								String value = hashMap.get("dropoff_date").toString();

								hashMap.put("dropoff_date", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("dropoff_date", hashMap.get("dropoff_date"));
						}
						if (hashMap.get("time_stamp") != null) {
							if (hashMap.get("time_stamp").toString().contains(",")) {

								String[] dropoff_date = hashMap.get("time_stamp").toString().split(",", -1);
								StringBuilder dropOffBuilder = new StringBuilder();
								dropOffBuilder.append("");
								for (int j = 0; j < dropoff_date.length; j++) {
									dropOffBuilder.append(convertDateInEpoch(dropoff_date[j]) + ",");

								}
								dropOffBuilder.deleteCharAt(dropOffBuilder.lastIndexOf(","));

								hashMap.put("time_stamp", dropOffBuilder);

							} else {
								String value = hashMap.get("time_stamp").toString();

								hashMap.put("time_stamp", convertDateInEpoch(value));

							}
						} else {
							hashMap.put("time_stamp", hashMap.get("time_stamp"));
						}
						if (hashMap.get("driver_first_name") != null) {
							if (hashMap.get("driver_first_name").toString().contains(",")) {

								String[] driver_first_name = hashMap.get("driver_first_name").toString().split(",", -1);
								String[] driver_middle_name = hashMap.get("driver_middle_name").toString().split(",",
										-1);
								String[] driver_last_name = hashMap.get("driver_last_name").toString().split(",", -1);
								StringBuilder nameBuilder = new StringBuilder();

								for (int j = 0; j < driver_first_name.length; j++) {
									nameBuilder.append(driver_first_name[j] + " " + driver_middle_name[j] + " "
											+ driver_last_name[j] + ",");

								}
								nameBuilder.deleteCharAt(nameBuilder.lastIndexOf(","));

								hashMap.put("driver_name", nameBuilder);

							} else {

								StringBuilder nameBuilder = new StringBuilder();
								nameBuilder.append(String.valueOf(hashMap.get("driver_first_name")) + " "
										+ String.valueOf(hashMap.get("driver_middle_name")) + " "
										+ String.valueOf(hashMap.get("driver_last_name")));
								hashMap.put("driver_name", nameBuilder.toString());

							}
						} else {
							hashMap.put("driver_name", null);
						}
						if (hashMap.get("total_volume_in_percentage") != null) {
							Float total_volume = Float.parseFloat(hashMap.get("total_volume_in_percentage").toString());
							hashMap.put("free_volume_in_percentage", 100 - total_volume);

						} else {
							hashMap.put("free_volume_in_percentage", 100);
						}

					}
				}
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(list);
				responseMessage.setValid(true);
				return responseMessage;
			}
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

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To getQuery from customer to administrator
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
	@SuppressWarnings("static-access")
	public Message contactUsEmail(Map<String, String> map, Object object, HttpServletRequest request,
			HttpServletResponse response) {
		Message message=new Message();
		boolean flag = false;
		boolean flag1 = false;
		String responsedataCustomer = null;
		String responsedataAdmin = null;
		try {
			// boolean flag = SendEmail.email(Username, Password, Socket
			// Port, Socket Class, AuthEmail, EmailHost, EmailPort,
			// builder, To, CC, BCC, Attachment, Subject, Message,
			// Message From Status, Message From, Message To, null);
			/**
			 * To send Email
			 */
			String[] toAdmin = new String[1];
			toAdmin[0] = environment.getProperty("mail.smtp.email.contact.admin");
			String[] bccAdmin = environment.getProperty("mail.smtp.email.cc").split(",");
			String[] cc = environment.getProperty("mail.smtp.email.bcc").split(",");

			String[] toCustomer = new String[1];
			toCustomer[0] = map.get("email");
			String[] bccCustomer = {};
			String[] ccCustomer = {};

			/**
			 * To set email template
			 */
			TemplateSwagger templateReport = new TemplateSwagger();
			StringBuilder builder = new StringBuilder();
			responsedataAdmin = templateReport.TemplateReportFile("template/admin-chelebi-Email.vm", map);
			flag = SendEmail.email("noreplycelebicargo@gmail.com",
					String.valueOf(environment.getProperty("mail.smtp.password")),
					String.valueOf(environment.getProperty("mail.socket.port")),
					String.valueOf(environment.getProperty("mail.socket.class")),
					String.valueOf(environment.getProperty("mail.smtp.auth")),
					String.valueOf(environment.getProperty("mail.smtp.detail")),
					String.valueOf(environment.getProperty("mail.smtp.port")), builder, toAdmin, cc, bccAdmin,
					null, String.valueOf(environment.getProperty("mail.smtp.email.subject.Query")), responsedataAdmin,
					String.valueOf(environment.getProperty("mail.smtp.email.status")),
					"noreplycelebicargo@gmail.com", "pooja.singh@teramatrix.co", null);
			System.out.println(flag1);

			responsedataCustomer = templateReport.TemplateReportFile("template/Thank-you-Email.vm", map);
			flag1 = SendEmail.email("noreplycelebicargo@gmail.com",
					String.valueOf(environment.getProperty("mail.smtp.password")),
					String.valueOf(environment.getProperty("mail.socket.port")),
					String.valueOf(environment.getProperty("mail.socket.class")),
					String.valueOf(environment.getProperty("mail.smtp.auth")),
					String.valueOf(environment.getProperty("mail.smtp.detail")),
					String.valueOf(environment.getProperty("mail.smtp.port")), builder, toCustomer, bccCustomer, ccCustomer,
					null, String.valueOf(environment.getProperty("mail.smtp.email.subject.acknowledgement")), responsedataCustomer,
					String.valueOf(environment.getProperty("mail.smtp.email.status")),
					"noreplycelebicargo@gmail.com", "pooja.singh@teramatrix.co", null);

			if (flag && flag1) {
				message.setDescription("Email Sent Successfully");
				message.setValid(true);
				return message;
			} else {
				message.setDescription("Issue in Sending Mail");
				message.setValid(false);
				return message;
			}

		} catch (Exception e) {
			message.setDescription("Issue in Sending Mail"+e.getMessage());
			message.setValid(false);
			return message;
		}
	}
}