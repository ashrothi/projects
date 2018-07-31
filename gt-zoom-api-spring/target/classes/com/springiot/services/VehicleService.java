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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.springiot.reflection.Reflection;
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
@SuppressWarnings({ "unused" })
public class VehicleService {
	@Autowired
	private HttpURLCalling urlCalling;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private OAUTHTokenServices tokenServices;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private ThirdPartyServices thirdPartyServices;
	@Autowired
	private Reflection reflection;
	@Autowired
	private GenericService genericService;
	@Autowired
	private ProcessParameter processParameter;

	/**
	 * To Get Data from Platform to get Currents performance service status of
	 * device from Platform
	 * 
	 * @param passingMap
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Message getPerformanceServiceStatusGetMany(Map<String, String> passingMap, HttpServletRequest request)
			throws Exception {
		Message message = new Message();
		try {
			// Calling Platform api for getting data from status table.
			List<Map<String, String>> deviceData = genericProcess.getPlatformData(passingMap, request,
					urlParameter.getXfusionperformanceDeviceStatusDeviceGetAll());
			float fuelUsed = 0;
			float cost = 0;
			float fuelCost = 0;
			List<Map<String, String>> fuelExpList = new ArrayList<>();
			for (Map<String, String> map : deviceData) {
				Map<String, String> fuelexpenseMap = new HashMap<>();
				// Check if the map is for fuel_consumed data_source.
				if (map.get("data_source").equalsIgnoreCase("fuel_consumed")) {
					fuelUsed = Float.parseFloat(map.get("current_value"));
					long time = Long.parseLong(map.get("check_timestamp")) / 1000;

					// Calling the procedure for getting the fuel price.
					List<Map<String,  Object>> costList = (List<Map<String,  Object>>) genericService.executeProcesure(
							null, processParameter.getMaps().get("17").toString(), Long.toString(time),
							map.get("device_id").toString());
					for (Map<String, Object> map2 : costList) {
						cost = Float.parseFloat(map2.get("cost").toString());
					}
					// Calculating the cost of the fuel for a trip.
					fuelCost = fuelUsed * cost;

					fuelexpenseMap.put("severity", "");
					fuelexpenseMap.put("device_id", "379");
					fuelexpenseMap.put("charts_alias", "Line Chart");
					fuelexpenseMap.put("service_name", "score");
					fuelexpenseMap.put("check_timestamp", map.get("check_timestamp"));
					fuelexpenseMap.put("service_servicedatasource_unit", "$");
					fuelexpenseMap.put("service_servicedatasource_max_value", "1000");
					fuelexpenseMap.put("charts_id", "1");
					fuelexpenseMap.put("service_servicedatasource_min_value", "0");
					fuelexpenseMap.put("charts_name", "line");
					fuelexpenseMap.put("data_source", "fuel_cost");
					fuelexpenseMap.put("current_value", Float.toString(fuelCost));
					fuelexpenseMap.put("service_servicedatasource_alias", "Fuel Expenditure of a Trip");
					fuelexpenseMap.put("device_name", map.get("device_name"));
					fuelexpenseMap.put("service_service_alias", "Score");
					fuelexpenseMap.put("colours_id", "655");
					fuelexpenseMap.put("colours_name", "#0000FF");
					fuelexpenseMap.put("sys_timestamp", map.get("sys_timestamp"));
					fuelexpenseMap.put("device_alias", map.get("device_alias"));
					fuelexpenseMap.put("colours_code", "#bf55ec");
				}
				if (!fuelexpenseMap.isEmpty())
					fuelExpList.add(fuelexpenseMap);
			}
			// Setting the map of fuel_cost into the response object.
			if (!fuelExpList.isEmpty())
				deviceData.addAll(fuelExpList);

			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(deviceData);

			return message;

		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process Fail " + e.getMessage());
			message.setValid(true);
			return message;

		}

	}

	/**
	 * This method will calculate the KPI values for defined time interval and
	 * compute some arithmetic operations
	 * 
	 * @param map,
	 *            here pass the input parameters.
	 * @param request,
	 *            Here pas the request type @return, it will return the
	 *            response.
	 * @author garima.joshi
	 */
	@SuppressWarnings("unchecked")
	public Message deviceKpiGetAll(Map<String, String> map, HttpServletRequest request) {
		Message message = new Message();
		try {
			List<Map<String, String>> deviceData = genericProcess.getPlatformData(map, request,
					urlParameter.getXfusionPerformanceServicedailyDeviceGetManyLimitWithoutData());

			Multimap<String, Double> multiMap = ArrayListMultimap.create();
			for (Map<String, String> map2 : deviceData) {

				for (String string : map2.keySet()) {
					if (string.contains("avg_") && map2.get(string) != null) {

						if (string.contains("avg_score_fuel_consumed") && map2.get(string) != null) {

							double avgFuelConsumed = Double.parseDouble(map2.get("avg_score_fuel_consumed"));
							// System.out.println("avgFuelConsumed
							String time = String.valueOf((Long.parseLong(map2.get("sys_timestamp").toString()) / 1000));
							// System.out.println("time "+time);
							List<Map<String, String>> fuelCost = (List<Map<String, String>>) genericService
									.executeProcesure(null, processParameter.getMaps().get("17").toString(), time,
											map.get("device_id").toString());
							double costValue = Integer.parseInt(String.valueOf(fuelCost.get(0).get("cost")))
									* avgFuelConsumed;
							System.out.println("cost " + costValue);
							multiMap.put("fuel_cost", costValue);
						}
						multiMap.put(string, Double.parseDouble(map2.get(string)));
						// map2.remove(string);
					}

				}

			}
			// System.out.println("multiMap " + multiMap);
			Map<String, Object> finalMap = new LinkedHashMap<>();
			finalMap.putAll(deviceData.get(0));
			for (String string : multiMap.keySet()) {
				Collection<Double> value = multiMap.get(string);

				OptionalDouble finalvalue = value.stream().mapToDouble(a -> a).average();

				finalMap.put(string, finalvalue.toString().substring(finalvalue.toString().indexOf("[") + 1,
						finalvalue.toString().indexOf("]")));

			}

			List<Map<String, Object>> finalDeviceData = new LinkedList<>();
			finalDeviceData.add(finalMap);
			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(finalDeviceData);

			return message;
		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process Fail " + e.getMessage());
			message.setValid(true);

			return message;
		}
	}
}
