package com.springiot.services;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerMapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.springiot.constant.GrafanaParameter;
import com.springiot.response.JsonModification;
import com.springiot.response.Message;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrafanaServices {

	/*
	 * To access the functionality of this class
	 */
	@Autowired
	private ApiCallingServices apiCallingServices;

	/*
	 * To access the functionality of this class
	 */
	@Autowired
	private GrafanaParameter grafanaParameter;

	public Message testConnection(HttpServletRequest request, HttpServletResponse response) {
		String responseString = "Hi";

		Message responseMessage = new Message();

		try {
			String ipAddress = "127.0.0.1";

			InetAddress inet = InetAddress.getByName(ipAddress);

			System.out.println("Sending Ping Request to " + ipAddress);

			if (inet.isReachable(5000)) {
				System.out.println(ipAddress + " is reachable.");

			} else {
				System.out.println(ipAddress + " NOT reachable.");
				// responseString = ipAddress + " is not reachable.";

			}
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

		responseMessage.setDescription("Process Success");
		responseMessage.setObject(responseString);
		responseMessage.setValid(true);

		return responseMessage;
	}

	
	public Object findMetricOptions(HttpServletRequest request, HttpServletResponse response) {
		Object responseObject = "";

		try {
System.out.println("request "+request);
			// Initialization of Variables
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;

			// Reading the input json from HttpServletRequest request
			while ((line = reader.readLine()) != null) {
				System.out.println("line "+line);
				buffer.append(line);
			}
			String data = buffer.toString();
			System.out.println("data" + data);

			String searchOperationArray[] = data.split(":");
			String searchOperation = searchOperationArray[1].trim().toString().replaceAll("\"", "");

			System.out.println("searchOperation" + searchOperation);

			String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			System.out.println("restOfTheUrl" + restOfTheUrl);

			String restUrl = restOfTheUrl.substring(0, restOfTheUrl.lastIndexOf("/"));

			String apiBaseUrl = grafanaParameter.getGrafanaAPI();
			System.out.println("apiBaseUrl" + apiBaseUrl);

			String apiUrl = apiBaseUrl + restUrl;
			System.out.println("apiUrl--" + apiUrl);

			/*
			 * if (searchOperation.equalsIgnoreCase("device_id")) {
			 * responseObject =
			 * apiCallingServices.GenericApiCallingSearch(apiUrl, request,
			 * response);
			 * 
			 * System.out.println("deviceIdObject" + responseObject);
			 * 
			 * // responseMap.put("Response", deviceIdObject);
			 * 
			 * } else
			 */
			if (searchOperation.equalsIgnoreCase("vehicle_id")) {

				responseObject = apiCallingServices.GenericApiCallingSearhVehicle(apiUrl, request, response);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return responseObject;
	}
	/**
	 * This service method accepts the input as Request
	 * Payload(application/json)and then retrieve the device id,service
	 * name,data source,from data,end date. These are the basic parameters
	 * required to call the Platform API and then we call Platform API and then
	 * returns the response as required json(accepted by Grafana).
	 * 
	 * @param api
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */

	public List<Map<String, Object>> returnMetrics(HttpServletRequest request, HttpServletResponse response) {
		// This object is used for the final returning response.
		Object responseOfAPI = "";
		try {
			// Initialization of Variables
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			Map<String, String> parameterMap = new LinkedHashMap<>();

			// Reading the input json from HttpServletRequest request
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			System.out.println("data-- " + data);
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);

			// Retrieving the required values from the input request
			String rangeJson = parameterMap.get("range").toString();

			// Typecasting the values
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();

			Gson g = new Gson();
			Map<String, Object> rangeMap = g.fromJson(rangeJson, type);

			// Retrieving the required values from the input request
			String fromRange = rangeMap.get("from").toString();
			String toRange = rangeMap.get("to").toString();
			// String frequency =
			// String.valueOf(parameterMap.get("intervalMs"));

			// Modifying the retrieved from and end date to the epoch
			// milliseconds
			String fromDateNumbers = fromRange.substring(0, fromRange.indexOf("T"));
			String fromDateTimeNumbers = fromRange.substring(fromRange.indexOf("T") + 1, fromRange.indexOf("."));

			String finalFromDateString = fromDateNumbers + " " + fromDateTimeNumbers;

			System.out.println("finalFromDateString-" + finalFromDateString);

			Long millisFromDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(finalFromDateString).getTime();

			String endDateNumbers = toRange.substring(0, toRange.indexOf("T"));
			String endDateTimeNumbers = toRange.substring(toRange.indexOf("T") + 1, toRange.indexOf("."));

			String finalEndDateString = endDateNumbers + " " + endDateTimeNumbers;

			System.out.println("finalEndDateString-" + finalEndDateString);

			Long millisEndDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(finalEndDateString).getTime();

			System.out.println("millisEndDate" + millisEndDate);

			// using jsonParser to parse the json input
			JsonParser jsonParser = new JsonParser();

			System.out.println("!!!!!!" + parameterMap.get("targets").toString());

			String paramValue = parameterMap.get("targets").toString().replace("/", "%");
			System.out.println("paramValue " + paramValue);

			String finalJSON = paramValue.replace(" ", "^");
			System.out.println("finalJSON " + finalJSON);

			String targetsJson = jsonParser.parse(finalJSON).toString();
			System.out.println("targetsJson " + targetsJson);

			// Retrieving the target list from input json
			Type type1 = new TypeToken<List<Map<String, Object>>>() {
			}.getType();

			Gson g1 = new Gson();

			// Cast json to List<Map<String, Object>>
			List<Map<String, Object>> targetList = g1.fromJson(targetsJson, type1);
			System.out.println("targetList" + targetList);

			String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			System.out.println("restOfTheUrl" + restOfTheUrl);

			String restUrl = restOfTheUrl.substring(0, restOfTheUrl.lastIndexOf("/"));

			String apiBaseUrl = grafanaParameter.getGrafanaAPI();
			System.out.println("apiBaseUrl" + apiBaseUrl);

			String apiUrl = apiBaseUrl + restUrl;
			System.out.println("apiUrl--" + apiUrl);

			// The api which is to be called
			// String apiUrl =
			// "http://13.94.42.90:7878/XFusionPlatform/performanceservice/device/get/single";

			// GenericApiCalling Method is called to retrieve the response of
			// API
			responseOfAPI = apiCallingServices.GenericApiCallingQuery(targetList, apiUrl, millisFromDate, millisEndDate,
					request, response);

			// Cast the response retrieved to List<Map<String, Object>>
			List<Map<String, Object>> responseOfAPIlist = new Gson().fromJson(responseOfAPI.toString(), type1);
			System.out.println("responseOfAPIlist  " + responseOfAPIlist);

			for (Map<String, Object> map : responseOfAPIlist) {

				String MetricValue = map.get("target").toString();
				String updatedMetricValue = MetricValue.replace("%", "/");

				String finalValue = updatedMetricValue.replace("^", " ");

				map.put("target", finalValue);

			}
			System.out.println("responseOfAPIlist" + responseOfAPIlist);
			return responseOfAPIlist;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Map<String, Object>> annotations(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> responseOfAPI = new ArrayList<>();
		try {

			// Initialization of Variables
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			Map<String, String> parameterMap = new LinkedHashMap<>();

			// Reading the input json from HttpServletRequest request
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);

			// Retrieving the required values from the input request
			String rangeJson = parameterMap.get("range").toString();
			System.out.println("rangeJson" + rangeJson);

			// Typecasting the values
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();

			Gson g = new Gson();
			Map<String, Object> rangeMap = g.fromJson(rangeJson, type);

			// Retrieving the required values from the input request
			String fromRange = rangeMap.get("from").toString();
			String toRange = rangeMap.get("to").toString();

			// Modifying the retrieved from and end date to the epoch
			// milliseconds
			String fromDateNumbers = fromRange.substring(0, fromRange.indexOf("T"));
			String fromDateTimeNumbers = fromRange.substring(fromRange.indexOf("T") + 1, fromRange.indexOf("."));

			String finalFromDateString = fromDateNumbers + " " + fromDateTimeNumbers;

			System.out.println("finalFromDateString-" + finalFromDateString);

			Long millisFromDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(finalFromDateString).getTime();

			String endDateNumbers = toRange.substring(0, toRange.indexOf("T"));
			String endDateTimeNumbers = toRange.substring(toRange.indexOf("T") + 1, toRange.indexOf("."));

			String finalEndDateString = endDateNumbers + " " + endDateTimeNumbers;

			System.out.println("finalEndDateString-" + finalEndDateString);

			Long millisEndDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(finalEndDateString).getTime();

			System.out.println("millisEndDate" + millisEndDate);

			// using jsonParser to parse the json input
			JsonParser jsonParser = new JsonParser();
			System.out.println("parameterMap" + parameterMap);
			String annotationJson = jsonParser.parse(parameterMap.get("annotation").toString()).toString();
			System.out.println("annotationJson" + annotationJson);

			Map<String, String> annotationMap = new LinkedHashMap<>();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, annotationMap);
			System.out.println("annotationMap" + annotationMap);

			String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			System.out.println("restOfTheUrl" + restOfTheUrl);

			String restUrl = restOfTheUrl.substring(0, restOfTheUrl.lastIndexOf("/"));

			String apiBaseUrl = grafanaParameter.getGrafanaAPI();
			System.out.println("apiBaseUrl" + apiBaseUrl);

			String apiUrl = apiBaseUrl + restUrl;
			System.out.println("apiUrl--" + apiUrl);

			// The api which is to be called
			// String apiUrl =
			// "http://13.94.42.90:7878/XFusionPlatform/performanceservice/device/get/single";

			String annotationList = annotationMap.get("annotation").toString();
			System.out.println("annotationList" + annotationList);

			// GenericApiCalling Method is called to retrieve the response of
			// API
			responseOfAPI = apiCallingServices.GenericApiCallingAnnotation(annotationList, apiUrl, millisFromDate,
					millisEndDate, request, response);

			System.out.println("responseOfAPI" + responseOfAPI);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		// TODO Auto-generated method stub
		return responseOfAPI;
	}

}


