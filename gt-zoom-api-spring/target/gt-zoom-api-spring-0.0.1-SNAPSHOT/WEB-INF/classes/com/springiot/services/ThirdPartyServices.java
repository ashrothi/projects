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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.notification.NotificationByFcm;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;
import com.springiot.service.processing.GeoAddress;

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
@SuppressWarnings({ "unchecked", "unused" })
@PropertySource(value = "classpath:/UserCreate.properties")
public class ThirdPartyServices {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
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
	@Autowired
	Environment environment;
	@Autowired
	private TrackingServices trackingServices;

	/**
	 * tripServices() method to Get device_id and their corresponding Trip_no
	 * 
	 * @param requestType
	 *            : Here pass the type of request i.e. Post or get.
	 * @param map
	 *            : Here pass the required parameters.
	 * @return message : returns the response.
	 */

	public Message tripServices(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message message = new Message();

		try {

			/*List<Map<String, Object>> mergedList = new LinkedList<>();

			Message procedureMessage = genericProcess.GenericProcedureCalling("10", map, null, request, response);
			System.out.println("Proc Response: " + procedureMessage.getObject());
			// Storing the information of device into list retrieved from the procedure.
			List<Map<String, Object>> deviceInfoProcList = (List<Map<String, Object>>) procedureMessage.getObject();

			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("device_id", map.get("device_id"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("service_name", String.valueOf(environment.getProperty("service.name")));
			passingMap.put("data_source", String.valueOf(environment.getProperty("data.source")));
			passingMap.put("from_date", map.get("from_date"));
			passingMap.put("end_date", map.get("end_date"));
			passingMap.put("pivot_data_required", "1");

			
			// Calling Performance Service Status Get Many api of Platform
			List<Map<String, Object>> getPerformanceServiceStatusGetMany = trackingServices
					.getXfusionPerformanceServiceMultipleDevicesGetMany(passingMap, request, response);

			if (getPerformanceServiceStatusGetMany.size() > 0) {
				
				for (Map<String, Object> map2 : getPerformanceServiceStatusGetMany) {

					Map<String, Object> tripMap = new LinkedHashMap<>();

					String latString = Stream.of(String.valueOf(map2.get("score_lat_list_1")),
							String.valueOf(map2.get("score_lat_list_2")), String.valueOf(map2.get("score_lat_list_3")),
							String.valueOf(map2.get("score_lat_list_4")), String.valueOf(map2.get("score_lat_list_5")),
							String.valueOf(map2.get("score_lat_list_6")), String.valueOf(map2.get("score_lat_list_7")),
							String.valueOf(map2.get("score_lat_list_8")), String.valueOf(map2.get("score_lat_list_9")),
							String.valueOf(map2.get("score_lat_list_10")),
							String.valueOf(map2.get("score_lat_list_11")),
							String.valueOf(map2.get("score_lat_list_12")),
							String.valueOf(map2.get("score_lat_list_13")),
							String.valueOf(map2.get("score_lat_list_14")),
							String.valueOf(map2.get("score_lat_list_15")),
							String.valueOf(map2.get("score_lat_list_16")),
							String.valueOf(map2.get("score_lat_list_17")),
							String.valueOf(map2.get("score_lat_list_18")),
							String.valueOf(map2.get("score_lat_list_19")),
							String.valueOf(map2.get("score_lat_list_20")),
							String.valueOf(map2.get("score_lat_list_21")),
							String.valueOf(map2.get("score_lat_list_22")),
							String.valueOf(map2.get("score_lat_list_23")),
							String.valueOf(map2.get("score_lat_list_24")),
							String.valueOf(map2.get("score_lat_list_25")))

							.filter(s -> s != null && !s.equalsIgnoreCase("null")).collect(Collectors.joining(","));
					String longString = Stream.of(String.valueOf(map2.get("score_long_list_1")),
							String.valueOf(map2.get("score_long_list_2")),
							String.valueOf(map2.get("score_long_list_3")),
							String.valueOf(map2.get("score_long_list_4")),
							String.valueOf(map2.get("score_long_list_5")),
							String.valueOf(map2.get("score_long_list_6")),
							String.valueOf(map2.get("score_long_list_7")),
							String.valueOf(map2.get("score_long_list_8")),
							String.valueOf(map2.get("score_long_list_9")),
							String.valueOf(map2.get("score_long_list_10")),
							String.valueOf(map2.get("score_long_list_11")),
							String.valueOf(map2.get("score_long_list_12")),
							String.valueOf(map2.get("score_long_list_13")),
							String.valueOf(map2.get("score_long_list_14")),
							String.valueOf(map2.get("score_long_list_15")),
							String.valueOf(map2.get("score_long_list_16")),
							String.valueOf(map2.get("score_long_list_17")),
							String.valueOf(map2.get("score_long_list_18")),
							String.valueOf(map2.get("score_long_list_19")),
							String.valueOf(map2.get("score_long_list_20")),
							String.valueOf(map2.get("score_long_list_21")),
							String.valueOf(map2.get("score_long_list_22")),
							String.valueOf(map2.get("score_long_list_23")),
							String.valueOf(map2.get("score_long_list_24")),
							String.valueOf(map2.get("score_long_list_25")))

							.filter(s -> s != null && !s.equalsIgnoreCase("null")).collect(Collectors.joining(","));
					String timeString = Stream.of(String.valueOf(map2.get("score_time_list_1")),
							String.valueOf(map2.get("score_time_list_2")),
							String.valueOf(map2.get("score_time_list_3")),
							String.valueOf(map2.get("score_time_list_4")),
							String.valueOf(map2.get("score_time_list_5")),
							String.valueOf(map2.get("score_time_list_6")),
							String.valueOf(map2.get("score_time_list_7")),
							String.valueOf(map2.get("score_time_list_8")),
							String.valueOf(map2.get("score_time_list_9")),
							String.valueOf(map2.get("score_time_list_10")),
							String.valueOf(map2.get("score_time_list_11")),
							String.valueOf(map2.get("score_time_list_12")),
							String.valueOf(map2.get("score_time_list_13")),
							String.valueOf(map2.get("score_time_list_14")),
							String.valueOf(map2.get("score_time_list_15")),
							String.valueOf(map2.get("score_time_list_16")),
							String.valueOf(map2.get("score_time_list_17")),
							String.valueOf(map2.get("score_time_list_18")),
							String.valueOf(map2.get("score_time_list_19")),
							String.valueOf(map2.get("score_time_list_20")),
							String.valueOf(map2.get("score_time_list_21")),
							String.valueOf(map2.get("score_time_list_22")),
							String.valueOf(map2.get("score_time_list_23")),
							String.valueOf(map2.get("score_time_list_24")),
							String.valueOf(map2.get("score_time_list_25")))

							.filter(s -> s != null && !s.equalsIgnoreCase("null")).collect(Collectors.joining(","));

					tripMap.put("lat", latString);
					tripMap.put("long", longString);
					tripMap.put("time", timeString);
					tripMap.put("trip_total_time", Double.parseDouble(map2.get("score_total_time").toString()));
					tripMap.put("trip_score", Double.parseDouble(map2.get("score_score").toString()));
					tripMap.put("trip_start_time", Double.parseDouble(map2.get("score_start_time").toString()) * 1000);
					tripMap.put("trip_end_time", Double.parseDouble(map2.get("score_end_time").toString()) * 1000);
					tripMap.put("device_id", map2.get("device_id"));
					tripMap.put("total_distance", Double.parseDouble(map2.get("score_total_distance").toString()));
					tripMap.put("trip_harsh_brakes", map2.get("score_trip_harsh_brakes"));
					tripMap.put("trip_harsh_accelerations", map2.get("score_trip_harsh_accelerations"));
					tripMap.put("trip_overspeeding_time", map2.get("score_over_speeding_time"));
					
					double fuelConsumed = Double.parseDouble(map2.get("score_fuel_consumed").toString());
					double kmplValue = Double.parseDouble(map2.get("score_total_distance").toString()) / fuelConsumed;
					tripMap.put("kmpl", kmplValue);
//					System.out.println(
//							map2.get("score_start_time") + "--------------" + map2.get("device_id").toString());
					List<Map<String, String>> cost = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get("17").toString(), map2.get("score_start_time"),
							map2.get("device_id").toString());
//					System.out.println("cost " + cost);
					double costValue = Integer.parseInt(String.valueOf(cost.get(0).get("cost"))) * fuelConsumed;
					tripMap.put("cost", costValue);
					List<Map<String, String>> sourceAddList = (List<Map<String, String>>) genericService
							.executeProcesure(null, processParameter.getMaps().get("15").toString(),
									map2.get("score_start_lattitude"), map2.get("score_start_longitude"));

					if (String.valueOf(sourceAddList.get(0).get("is_exists")).equalsIgnoreCase("0")) {
						double latitude = Double.parseDouble(map2.get("score_start_lattitude").toString());

						double longitudeNew = Double.parseDouble(map2.get("score_start_longitude").toString());
						String destination_address = GeoAddress.getLocationInfo(latitude, longitudeNew).replaceAll("\"",
								"");
						Object add = genericService.executeProcesure(null,
								processParameter.getMaps().get("14").toString(), destination_address,
								map2.get("score_start_lattitude"), map2.get("score_start_longitude"));
						tripMap.put("start_add", destination_address);
					} else {
						tripMap.put("start_add", sourceAddList.get(0).get("address"));
					}
					List<Map<String, String>> destinationAddList = (List<Map<String, String>>) genericService
							.executeProcesure(null, processParameter.getMaps().get("15").toString(),
									map2.get("score_end_lattitude"), map2.get("score_end_longitude"));

					if (String.valueOf(destinationAddList.get(0).get("is_exists")).equalsIgnoreCase("0")) {
						double latitude = Double.parseDouble(map2.get("score_end_lattitude").toString());

						double longitudeNew = Double.parseDouble(map2.get("score_end_longitude").toString());
						String destination_address = GeoAddress.getLocationInfo(latitude, longitudeNew).replaceAll("\"",
								"");
						Object add = genericService.executeProcesure(null,
								processParameter.getMaps().get("14").toString(), destination_address,
								map2.get("score_end_lattitude"), map2.get("score_end_longitude"));
						tripMap.put("end_Addr", destination_address);
					} else {
						tripMap.put("end_Addr", destinationAddList.get(0).get("address"));
					}

					mergedList.add(tripMap);

				}

				for (Map<String, Object> map3 : mergedList) {
					for (Map<String, Object> deviceInfoProcListmap : deviceInfoProcList) {

						if (deviceInfoProcListmap.get("device_id").toString().replace(".0", "")
								.equalsIgnoreCase(map3.get("device_id").toString().replace(".0", ""))) {
							map3.putAll(deviceInfoProcListmap);
							map3.values().removeAll(Collections.singleton(null));
						}

					}

				}
				message.setDescription("Process Success");
				message.setValid(true);
				message.setObject(mergedList);
				return message;
			} else {

				message.setDescription("No Trip Data Available ");
				message.setValid(true);
				return message;
			}*/
			long startTime = Long.parseLong(map.get("from_date")) / 1000;
			long endTime = Long.parseLong(map.get("end_date")) / 1000;
			
			List<Map<String, String>> tripsList = (List<Map<String, String>>) genericService.executeProcesure(null,
					processParameter.getMaps().get("22").toString(), Long.toString(startTime),
					Long.toString(endTime));
System.out.println("Trip Data: "+tripsList);
			if(!tripsList.isEmpty()){
				message.setDescription("Process Success");
				message.setValid(true);
				message.setObject(tripsList);
				return message;
			} else {
				message.setDescription("No Trip Data Available ");
				message.setValid(true);
				return message;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process fail " + e.getMessage());
			message.setValid(true);

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
	

	private String convertFromEpoch(String string) throws Exception {
		String dateString = string;
		Date d = new Date(Long.parseLong(dateString));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String formatted = format.format(d);

		return formatted;
	}

	private Object convertDateInEpoch(String replace) throws ParseException {

		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask
		Date date = dF.parse(replace); // parsing the String into a Date using
										// the mask

		return date.getTime();
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

}