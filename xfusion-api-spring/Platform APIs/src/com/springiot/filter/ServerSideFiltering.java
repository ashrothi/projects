/**
 * This package is used to apply Server Side Filtering on the generic basis on every page of the application.
 */
package com.springiot.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;

/**
 * 
 * @author tanvigarg This Method is used to apply filters on the specific data
 * @param filterValue,
 *            used to apply filters on data which will be considered an input
 *            paramater specified by the user.
 *
 */
public class ServerSideFiltering {
	public String filterData(String filterValue) {
		// String filterValue =
		// "{\"data\":{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"filters\":[{\"field\":\"device_device_alias\",\"operator\":\"eq\",\"value\":\"check\"},{\"field\":\"device_device_alias\",\"operator\":\"eq\",\"value\":\"Binatone\"},{\"logic\":\"and\",\"filters\":[{\"field\":\"device_device_ipaddress\",\"operator\":\"neq\",\"value\":\"192.168.1.1\"},{\"field\":\"device_device_ipaddress\",\"operator\":\"eq\",\"value\":\"192.168.20.1\"}]},{\"field\":\"device_devicetechnology_alias\",\"operator\":\"eq\",\"value\":\"Router\"},{\"logic\":\"or\",\"filters\":[{\"field\":\"device_devicemodel_alias\",\"operator\":\"startswith\",\"value\":\"Binatone
		// DT860W\"},{\"field\":\"device_devicemodel_alias\",\"operator\":\"endswith\",\"value\":\"WR3005N3\"}]}],\"logic\":\"and\"}}}";

		// Convert the json into Map.
		@SuppressWarnings("unchecked")
		Map<String, Object> listMap = new Gson().fromJson(filterValue, Map.class);

		// Get the response from data keyword from above mentioned map.
		@SuppressWarnings("unchecked")
		StringMap<Object> map = (StringMap<Object>) listMap.get("data");

		// Get the response from filter keyword from above mentioned map.
		@SuppressWarnings("unchecked")
		StringMap<Object> filtermap = (StringMap<Object>) map.get("filter");

		// Get the logical operation from the map.
		StringBuilder builder = new StringBuilder();
		String logic = filtermap.get("logic").toString();

		// Get the response from filters keyword from above mentioned map.
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) filtermap.get("filters");

		// For loop is used to create SQL queries for the condition which will
		// be specified in procedure
		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);

			if (object.toString().contains("filters")) {
				String data = filterReturn(object);
				// Check if data is null or not
				if (data == null) {
					continue;
				}
				// Check the size of list and then append it to the builder
				if (i == list.size() - 1) {
					builder.append(data);
					continue;
				}
				builder.append(data + " " + logic + " ");
				continue;
			}

			String data = objectReturn(object);
			// Check if data is null or not
			if (data == null) {
				continue;
			}
			// Check the size of list and then append it to the builder
			if (i == list.size() - 1) {
				builder.append(data);
				continue;
			}
			builder.append(data + " " + logic + " ");
		}

		return builder.toString();
	}

	// Create SQL queries for thr operations like contains,does not
	// contain,starts with,ends with.
	@SuppressWarnings("unchecked")
	public String objectReturn(Object object) {

		if (object instanceof StringMap) {
			StringMap<Object> map = (StringMap<Object>) object;

			String operator = operatorWise(map.get("operator").toString());

			String data = null;
			// All the possiblities for SQL Query
			if (operator == "startswith") {
				data = map.get("field").toString() + " like  '" + map.get("value").toString() + "%' ";
			} else if (operator == "endswith") {
				data = map.get("field").toString() + " like '%" + map.get("value").toString() + "' ";
			} else if (operator == "contains") {
				data = map.get("field").toString() + " like '%" + map.get("value").toString() + "%' ";
			} else if (operator == "doesnotcontain") {
				data = map.get("field").toString() + " not like '%" + map.get("value").toString() + "' ";
			} else {
				data = map.get("field").toString() + " " + operator + " '" + map.get("value").toString() + "'";
			}
			return data;
		}
		return null;

	}

	// Map is created to add all the possible operations that can be performed
	// while server side filtering.
	public String operatorWise(String operator) {

		Map<String, String> map = new HashMap<>();
		// Adding paramters to the map.
		map.put("eq", "=");
		map.put("neq", "!=");
		map.put("startswith", "startswith");
		map.put("endswith", "endswith");
		map.put("contains", "contains");
		map.put("doesnotcontain", "doesnotcontain");

		return map.get(operator.trim());
	}

	/*
	 * This method is used to create SQL Query for the data
	 */
	public String filterReturn(Object objectList) {

		if (objectList instanceof StringMap) {
			// Initializing the String Builder
			StringBuilder builder = new StringBuilder();

			@SuppressWarnings("unchecked")
			StringMap<Object> map = (StringMap<Object>) objectList;

			String logic = map.get("logic").toString();

			@SuppressWarnings("unchecked")
			List<Object> list = (List<Object>) map.get("filters");

			for (int i = 0; i < list.size(); i++) {
				Object object = list.get(i);

				if (object.toString().contains("filters")) {
					String data = filterReturn(object);
					// Chcek if data is null or not
					if (data == null) {
						continue;
					}
					// Check the size of list and then append it to the builder
					if (i == list.size() - 1) {
						builder.append(data);
						continue;
					}
					builder.append(data + " " + logic + " ");
					continue;
				}

				String data = objectReturn(object);
				// Chcek if data is null or not
				if (data == null) {
					continue;
				}
				// Check the size of list and then append it to the builder
				if (i == list.size() - 1) {
					builder.append(data);
					continue;
				}
				builder.append(data + " " + logic + " ");
			}

			return builder.toString();
		}
		return null;
	}
}