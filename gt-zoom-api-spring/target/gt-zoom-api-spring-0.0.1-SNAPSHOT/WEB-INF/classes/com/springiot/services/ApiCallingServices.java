package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;

@Service
public class ApiCallingServices {

	@Autowired
	private HttpURLCalling urlCalling;
	

	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * This method is used to call the platform API and returns the response of
	 * API as required json
	 * 
	 * @param targetList,contains
	 *            the input target list of json
	 * @param url,the
	 *            api url which needs to be called
	 * @param from_date
	 * @param end_date
	 * @return
	 */
	public Object GenericApiCallingQuery(List<Map<String, Object>> targetList, String url, Long from_date,
			Long end_date, HttpServletRequest request, HttpServletResponse response) {

		// Initializing the List<Object>
		List<Object> finalList = new ArrayList<>();

		try {

			for (Map<String, Object> targetMap : targetList) {

				LinkedHashMap<String, Object> outputMap = new LinkedHashMap<>();
				Map<String, Object> responseMap = new HashMap<>();

				System.out.println("SIZE of Target List-" + targetList.size());
				// String value = targetMap.get("type").toString();
				String metricValue = targetMap.get("target").toString();

				System.out.println("metric value" + metricValue);

				// Set the input parameters of calling API
				String metricArray[] = metricValue.split("%");

				for (int i = 0; i < metricArray.length; i++) {
					System.out.println("!!!!!!!" + metricArray[i]);
				}

				String deviceId = metricArray[0].substring(0, metricArray[0].indexOf("-"));

				System.out.println("deviceId" + deviceId);

				String device_id = deviceId;
				String service_name = metricArray[1];
				String data_source = metricArray[2];

				StringBuilder passingParameter = new StringBuilder();
				passingParameter
						.append("&device_id" + "=" + device_id + "&service_name" + "=" + service_name + "&data_source"
								+ "=" + data_source + "&from_date" + "=" + from_date + "&end_date" + "=" + end_date);
				passingParameter.delete(0, 1);

				Map<String, String> retrivedHeadersMap = retrievedHeadersPlatform(request, response);

				Map<String, String> headerMap = new HashMap<String, String>();
				headerMap.put("token", retrivedHeadersMap.get("accessToken"));
				headerMap.put("user_key", retrivedHeadersMap.get("userKey"));
				headerMap.put("user_id", retrivedHeadersMap.get("userId"));

				// Calling of Platform API
				Object responseFromAPI = urlCalling.getData(url, passingParameter.toString(), headerMap);

				@SuppressWarnings("serial")
				Type type2 = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();

				// Convert the response retrieved after calling api is stored
				// into Map
				@SuppressWarnings("unchecked")
				GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
						.fromJson(responseFromAPI.toString(), type2);

				// Initialization of StringBuilder
				StringBuilder currentValueBuilder = new StringBuilder();
				StringBuilder sysTimestampBuilder = new StringBuilder();

				if (urlMessage.isValid()) {

					List<Map<String, String>> apiResponseList = urlMessage.getObject();

					// Manipulate the result in required json
					for (Map<String, String> apiMap : apiResponseList) {

						String currentValue = String.valueOf(apiMap.get("current_value"));
						Object sysTimestamp = apiMap.get("sys_timestamp");

						currentValueBuilder.append(currentValue + ",");
						sysTimestampBuilder.append(sysTimestamp + ",");

					}

					System.out.println("currentValueBuilder " + currentValueBuilder);
					System.out.println("sysTimestampBuilder " + sysTimestampBuilder);

					// Arrays of sys_timestamp and current_value
					String currentValueArray[] = currentValueBuilder.toString().split(",");
					String sysTimestampArray[] = sysTimestampBuilder.toString().split(",");

					for (int i = 0; i < sysTimestampArray.length; i++) {

						outputMap.put(sysTimestampArray[i], currentValueArray[i]);
					}

					// Initializing the List<Object>
					List<Object> datapointsList = new ArrayList<>();

					// Internal arraylist of json creation process
					for (Object key : outputMap.keySet()) {

						List<Object> datanodes = new ArrayList<>();

						datanodes.add(outputMap.get(key));
						datanodes.add(key);

						datapointsList.add(datanodes);

					}

					System.out.println("datapointsList" + datapointsList);

					// Put the results of arraylist to map
					responseMap.put("datapoints", datapointsList);
					responseMap.put("target", metricValue);

					System.out.println("responseMap" + responseMap);

					// Adding the response to finalList
					finalList.add(responseMap);

				} else {
					return urlMessage.getObject();
				}
			}
			return finalList;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return finalList;
	}

	/**
	 * This method is used for searching on the basis of device_id and returns
	 * the result in respected array list
	 * 
	 * @param response
	 * @param request
	 * 
	 * @param apiUrl,the
	 *            url which needs to be called.
	 * @return
	 */
	public Object GenericApiCallingSearch(String apiUrl, HttpServletRequest request, HttpServletResponse response) {

		// Initialization of List<Object>
		List<Object> deviceIdList = new ArrayList<>();

		try {

			Map<String, String> retrivedHeadersMap = retrievedHeadersPlatform(request, response);
			// Calling Of Platform API and adjusting the parameters required to
			// call the API.
			StringBuilder passingParameter = new StringBuilder();
			passingParameter.append("&status_type=1" + "&limit=1000" + "&offset=0" + "&in_condition" + "=" + "");
			passingParameter.delete(0, 1);

			System.out.println("retrivedHeadersMap" + retrivedHeadersMap);

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("token", retrivedHeadersMap.get("accessToken"));
			headerMap.put("user_key", retrivedHeadersMap.get("userKey"));
			headerMap.put("user_id", retrivedHeadersMap.get("userId"));

			// Calling of Platform API
			Object responseFromAPI = urlCalling.getData(apiUrl, passingParameter.toString(), headerMap);

			@SuppressWarnings("serial")
			Type type2 = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored
			// into Map
			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(responseFromAPI.toString(), type2);

			StringBuilder deviceIdBuiler = new StringBuilder();

			if (urlMessage.isValid()) {

				List<Map<String, String>> apiResponseList = urlMessage.getObject();

				// Manipulate the result in required json
				for (Map<String, String> apiMap : apiResponseList) {

					String deviceId = String.valueOf(apiMap.get("device_device_device_id"));

					deviceIdBuiler.append(deviceId + ",");

				}

				System.out.println("deviceIdBuiler " + deviceIdBuiler);

				String deviceIdArray[] = deviceIdBuiler.toString().split(",");

				for (int i = 0; i < deviceIdArray.length; i++) {

					deviceIdList.add(deviceIdArray[i]);

				}

				System.out.println("deviceIdList" + deviceIdList);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return deviceIdList;
	}

	public Object GenericApiCallingSearchModel(String apiUrl, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object> ModelList = new ArrayList<>();

		try {
			StringBuilder passingParameter = new StringBuilder();
			passingParameter.append("&status_type=1" + "&limit=1000" + "&offset=0" + "&in_condition" + "=" + "");
			passingParameter.delete(0, 1);

			Map<String, String> retrivedHeadersMap = retrievedHeadersPlatform(request, response);
			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("token", retrivedHeadersMap.get("accessToken"));
			headerMap.put("user_key", retrivedHeadersMap.get("userKey"));
			headerMap.put("user_id", retrivedHeadersMap.get("userId"));

			// Calling of Platform API
			Object responseFromAPI = urlCalling.getData(apiUrl, passingParameter.toString(), headerMap);

			@SuppressWarnings("serial")
			Type type2 = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored
			// into Map
			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(responseFromAPI.toString(), type2);

			StringBuilder deviceIdBuiler = new StringBuilder();

			if (urlMessage.isValid()) {

				List<Map<String, String>> apiResponseList = urlMessage.getObject();

				// Manipulate the result in required json
				for (Map<String, String> apiMap : apiResponseList) {

					String ModelAlias = String.valueOf(apiMap.get("device_devicemodel_alias"));
					String ModelId = String.valueOf(apiMap.get("device_devicemodel_id"));

					String ModelInfo = ModelId + "-" + ModelAlias;
					deviceIdBuiler.append(ModelInfo + ",");

				}

				System.out.println("deviceIdBuiler " + deviceIdBuiler);

				String deviceIdArray[] = deviceIdBuiler.toString().split(",");

				for (int i = 0; i < deviceIdArray.length; i++) {

					ModelList.add(deviceIdArray[i]);

				}

				System.out.println("deviceIdList" + ModelList);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return ModelList;
	}

	public List<Map<String, Object>> GenericApiCallingAnnotation(String annotationList, String apiUrl,
			Long millisFromDate, Long millisEndDate, HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> dataResponseList = new ArrayList<>();
		try {

			JSONParser parser = new JSONParser();
			Object dataList = parser.parse(annotationList);
			System.out.println("json" + dataList);

			// Retrieving the target list from input json
			Type type1 = new TypeToken<Map<String, Object>>() {
			}.getType();

			Gson g1 = new Gson();

			// Cast json to List<Map<String, Object>>
			Map<String, Object> targetList = g1.fromJson(dataList.toString(), type1);

			String query = targetList.get("query").toString();
			System.out.println("query value--" + query);

			// Set the input parameters of calling API
			String metricArray[] = query.split("/");
			String device_id = metricArray[0];
			String service_name = metricArray[1];
			String data_source = metricArray[2];

			StringBuilder passingParameter = new StringBuilder();
			passingParameter
					.append("&device_id" + "=" + device_id + "&service_name" + "=" + service_name + "&data_source" + "="
							+ data_source + "&from_date" + "=" + millisFromDate + "&end_date" + "=" + millisEndDate);
			passingParameter.delete(0, 1);

			Map<String, String> retrivedHeadersMap = retrievedHeadersPlatform(request, response);

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("token", retrivedHeadersMap.get("accessToken"));
			headerMap.put("user_key", retrivedHeadersMap.get("userKey"));
			headerMap.put("user_id", retrivedHeadersMap.get("userId"));

			// Calling of Platform API
			Object responseFromAPI = urlCalling.getData(apiUrl, passingParameter.toString(), headerMap);

			@SuppressWarnings("serial")
			Type type2 = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored
			// into Map
			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(responseFromAPI.toString(), type2);

			// Initialization of StringBuilder
			StringBuilder sysTimestampBuilder = new StringBuilder();

			if (urlMessage.isValid()) {

				List<Map<String, String>> apiResponseList = urlMessage.getObject();
				System.out.println("api response List" + apiResponseList);

				// Manipulate the result in required json
				for (Map<String, String> apiMap : apiResponseList) {

					Object sysTimestamp = apiMap.get("sys_timestamp");
					sysTimestampBuilder.append(sysTimestamp + ",");

				}
				System.out.println("sysTimestampBuilder" + sysTimestampBuilder);

				Object sysTimestampArray[] = sysTimestampBuilder.toString().split(",");

				for (int i = 0; i < sysTimestampArray.length; i++) {

					Map<String, Object> responseMap = new LinkedHashMap<>();
					responseMap.put("annotation", query);
					responseMap.put("time", Long.parseLong(sysTimestampArray[i].toString()));
					responseMap.put("title", query);

					dataResponseList.add(responseMap);

				}

				System.out.println("dataResponseList" + dataResponseList);

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return dataResponseList;
	}

	public Object GenericApiCallingSearchTemplate(String apiUrl, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of List<Object>
		List<Object> deviceIdList = new ArrayList<>();

		try {

			Map<String, String> retrivedHeadersMap = retrievedHeadersPlatform(request, response);
			System.out.println("retrivedHeadersMap" + retrivedHeadersMap);

			// Calling Of Platform API and adjusting the parameters required to
			// call the API.
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("token", retrivedHeadersMap.get("accessToken"));
			headerMap.put("user_key", retrivedHeadersMap.get("userKey"));
			headerMap.put("user_id", retrivedHeadersMap.get("userId"));

			System.out.println("token" + retrivedHeadersMap.get("accessToken"));
			System.out.println("user_key" + retrivedHeadersMap.get("userKey"));
			System.out.println("user_id" + retrivedHeadersMap.get("userId"));

			// Calling of Platform API
			Object responseFromAPI = urlCalling.getData(apiUrl, passingParameter.toString(), headerMap);
			System.out.println("responseFromAPI" + responseFromAPI);

			@SuppressWarnings("serial")
			Type type2 = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored
			// into Map
			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(responseFromAPI.toString(), type2);

			StringBuilder modelIdBuilder = new StringBuilder();

			if (urlMessage.isValid()) {

				List<Map<String, String>> apiResponseList = urlMessage.getObject();

				// Manipulate the result in required json
				for (Map<String, String> apiMap : apiResponseList) {

					String modelId = String.valueOf(apiMap.get("device_devicetemplate_device_model"));
					String templateName = String.valueOf(apiMap.get("device_devicetemplate_name"));

					String ModelInfo = modelId + "-" + templateName;
					modelIdBuilder.append(ModelInfo + ",");

				}

				System.out.println("deviceIdBuiler " + modelIdBuilder);

				String deviceIdArray[] = modelIdBuilder.toString().split(",");

				for (int i = 0; i < deviceIdArray.length; i++) {

					deviceIdList.add(deviceIdArray[i]);

				}
				System.out.println("deviceIdList" + deviceIdList);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return deviceIdList;
	}

	public Object GenericApiCallingSearchModelWithDeviceId(String apiUrl, String searchOperation,
			HttpServletRequest request, HttpServletResponse response) {
		// Initialization of List<Object>
		List<Object> deviceIdList = new ArrayList<>();

		try {

			String modelDetails = searchOperation.substring(0, searchOperation.indexOf("."));
			System.out.println("modelDetails" + modelDetails);

			String modelName = modelDetails.substring(modelDetails.indexOf("-") + 1);
			System.out.println("modelName" + modelName);

			String modelNameModified = "\"" + modelName + "\"";

			String inConditionValue = "{\"data\":{\"take\":20,\"skip\":0,\"page\":1,\"pageSize\":20,\"filter\":{\"logic\":\"and\",\"filters\":[{\"field\":\"device_devicetemplate_name\",\"operator\":\"eq\",\"value\":"
					+ modelNameModified + "}]}}}";

			System.out.println("inConditionValue" + inConditionValue);

			// Calling Of Platform API and adjusting the parameters required to
			// call the API.
			StringBuilder passingParameter = new StringBuilder();
			passingParameter.append("&device_type=0" + "&host_status=0" + "&limit=1000" + "&offset=0" + "&in_condition"
					+ "=" + inConditionValue);
			passingParameter.delete(0, 1);

			Map<String, String> retrivedHeadersMap = retrievedHeadersPlatform(request, response);
			System.out.println("retrivedHeadersMap" + retrivedHeadersMap);

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("token", retrivedHeadersMap.get("accessToken"));
			headerMap.put("user_key", retrivedHeadersMap.get("userKey"));
			headerMap.put("user_id", retrivedHeadersMap.get("userId"));

			// Calling of Platform API
			Object responseFromAPI = urlCalling.getData(apiUrl, passingParameter.toString(), headerMap);

			@SuppressWarnings("serial")
			Type type2 = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored
			// into Map
			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(responseFromAPI.toString(), type2);

			StringBuilder deviceIdBuiler = new StringBuilder();

			if (urlMessage.isValid()) {

				List<Map<String, String>> apiResponseList = urlMessage.getObject();

				System.out.println("apiResponseList" + apiResponseList);

				// Manipulate the result in required json
				for (Map<String, String> apiMap : apiResponseList) {

					String deviceId = String.valueOf(apiMap.get("device_device_device_id"));
					String deviceName = String.valueOf(apiMap.get("device_device_alias"));

					String deviceDetails = deviceId + "-" + deviceName;

					deviceIdBuiler.append(deviceDetails + ",");

				}

				System.out.println("deviceIdBuiler " + deviceIdBuiler);

				String deviceIdArray[] = deviceIdBuiler.toString().split(",");

				for (int i = 0; i < deviceIdArray.length; i++) {

					deviceIdList.add(deviceIdArray[i]);

				}

				System.out.println("deviceIdList" + deviceIdList);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return deviceIdList;
	}
public Object GenericApiCallingSearhVehicle(String apiUrl, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of List<Object>
		List<Object> deviceIdList = new ArrayList<>();
		String user_key;
		String user_id;
		try {

			Map<String, String> headerData = retrievedHeadersPlatform(request, response);
			System.out.println("headerData " + headerData.isEmpty());
			System.out.println();
			if (!(headerData.isEmpty())) {
				System.out.println("inside if condition");
				user_key = headerData.get("userKey");
				user_id = headerData.get("userId");
			} else {
				user_key = request.getHeader("user_key");
				user_id = request.getHeader("user_id");
			}
			String limit = "1000";
			String offset = "0";
			System.out.println("user key " + user_key + "user id " + user_id);
			List<Object> ModelList = new ArrayList<>();
			List<Map<String, String>> responseObject = (List<Map<String, String>>) genericService.executeProcesure(null,
					processParameter.getMaps().get("6").toString(), user_key, user_id, limit, offset);

			System.out.println("responseObject " + responseObject);
			/*
			 * for (Map<String, String> map2 : responseObject) {
			 * 
			 * alertsMap.put("device_id", map2.get("obd_device_id"));
			 * alertsMap.put("device_name", map2.get("device_name")); //
			 * map2.remove(string); liveTrackingDataList.add(alertsMap); }
			 */
			StringBuilder deviceIdBuiler = new StringBuilder();
			for (Map<String, String> apiMap : responseObject) {

				String deviceID = String.valueOf(apiMap.get("obd_device_id"));
				String deviceName = String.valueOf(apiMap.get("device_name"));

				String ModelInfo = deviceID + "-" + deviceName;
				deviceIdBuiler.append(ModelInfo + ",");

			}
			System.out.println("deviceIdBuiler " + deviceIdBuiler);

			String deviceIdArray[] = deviceIdBuiler.toString().split(",");

			for (int i = 0; i < deviceIdArray.length; i++) {

				ModelList.add(deviceIdArray[i]);

			}

			System.out.println("deviceIdList" + ModelList);
			// Object res=ModelList;

			/// System.out.println("liveTrackingDataList " +
			/// liveTrackingDataList);

			// Set the success response

			return ModelList;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/**
	 * This method helps to retrieve headers of Platform APis like
	 * token,user_key and user_id required for calling the platform API
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	private Map<String, String> retrievedHeadersPlatform(HttpServletRequest request, HttpServletResponse response) {

		// Initializing the map
		Map<String, String> headersMap = new HashMap<>();

		try {

			// get the cookie value
			String cookieValue = request.getHeader("Cookie");

			// Split with ";" and take the values in array
			String cookieArray[] = cookieValue.split(";");

			for (int i = 0; i < cookieArray.length; i++) {

				// The keys of map
				String key = cookieArray[i].substring(0, cookieArray[i].indexOf("=")).trim();

				// The values of map
				String value = cookieArray[i].substring(cookieArray[i].indexOf("=") + 1).trim();

				headersMap.put(key, value);

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return headersMap;
	}
}
