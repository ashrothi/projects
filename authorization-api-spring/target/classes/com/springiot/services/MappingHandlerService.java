/**
 * This package is used to provide permissions to particular users to access some API's and views on the application.
 */
package com.springiot.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;

import com.springiot.response.Message;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * This class will handle all the mapping of API's and views on the application
 * for the specific users on the basis of their role name.
 * 
 * @author tanvigarg
 *
 * 
 */
@Service
public class MappingHandlerService {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling httpURLCalling;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private ProcessParameter processParameter;

	/**
	 * This method is used to get the mapping of all API's.
	 * 
	 * @return
	 */
	public Message getAPIsMapping() {

		// Initialization of Message
		Message message = new Message();

		try {

			// To Initialize the response List
			List<Map<String, Object>> list = new ArrayList<>();

			// Initialization of map and get the method names
			Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();

			for (RequestMappingInfo mappingInfo : map.keySet()) {
				// Initialization of map
				Map<String, Object> mapDetails = new HashMap<>();

				// Retrieve the urls in
				String url = mappingInfo.getPatternsCondition().toString();

				String urlValues = url.replace("[", "").replace("]", "");

				// Skip these specific URL's
				if (urlValues.equalsIgnoreCase("/getallurl")) {
					continue;
				}
				if (urlValues.equalsIgnoreCase("/v2/api-docs")) {
					continue;
				}
				if (urlValues.equalsIgnoreCase("/configuration/security")) {
					continue;
				}
				if (urlValues.equalsIgnoreCase("/configuration/ui")) {
					continue;
				}
				if (urlValues.equalsIgnoreCase("/swagger-resources")) {
					continue;
				}

				// Adding parameters to the map
				mapDetails.put("url", urlValues);
				mapDetails.put("is_added", false);
				list.add(mapDetails);
			}

			// Set the success response
			message.setDescription("URL Details");
			message.setObject(list);
			message.setValid(true);
			return message;
		}
		// Handling all exceptions
		catch (Exception e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * This method is used to retrieve all URL's required at the time of
	 * assigning permissions on web page.
	 * 
	 * @param map,the
	 *            input parameters.
	 * @return
	 */
	public Object getAllURL(Map<String, String> map) {
		// Initialization of Message
		Message message = new Message();

		try {

			// Check if input parameter(url) from map is not null
			if (map.get("url") == null) {
				// Set the failure response
				message.setDescription("Issues With URL");
				message.setValid(false);
				return message;
			}

			// Retrieve the result in object class after calling specific URL
			Object object = httpURLCalling.getData(map.get("url"), "");

			// Check if object is not null
			if (object != null) {
				return object;
			}

		}
		// Handling Exceptions
		catch (Exception e) {
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
		// Set the failure response
		message.setDescription("Issues With URL");
		message.setValid(false);
		return message;
	}

	/**
	 * This method is used to retrieve view URL's
	 * 
	 * @param map,the
	 *            input parameters
	 * @return
	 */
	public Message getUrls(Map<String, String> map) {
		// Initialization of Message
		Message message = new Message();

		Set<String> uniqKey = new HashSet<>();

		try {
			// Check if input parameter(url) from map is not null
			if (map.get("url") == null) {
				message.setDescription("Issues With URL");
				message.setValid(false);
				return message;
			}

			// Initialization of array list
			List<Object> list = new ArrayList<>();

			// Creating objects of respective classes
			URL url = new URL(map.get("url"));
			InputStream inputStream = url.openStream();
			Scanner scanner = new Scanner(inputStream);

			while (scanner.hasNext()) {
				String string = scanner.nextLine();

				// Check string contains ./scripts
				if (string.contains("name:")) {

					// // initialization of map
					// Map<String, Object> urlMap = new HashMap<>();
					// Retrieve the url value
					String urlValue = string.substring(string.indexOf("name:'") + 6, string.lastIndexOf("'"));

					uniqKey.add(urlValue);

					// Adding parameters to map
					// urlMap.put("url", urlValue);
					// urlMap.put("is_added", false);
					// list.add(urlMap);
				}
			}
			scanner.close();

			Object[] obj = uniqKey.toArray();

			for (int i = 0; i < obj.length; i++) {
				// initialization of map
				Map<String, Object> urlMap = new HashMap<>();
				// Adding parameters to map
				urlMap.put("url", obj[i].toString());
				urlMap.put("is_added", false);
				list.add(urlMap);
			}

			// Set the success response of API
			message.setDescription("Results URL");
			message.setObject(list);
			message.setValid(true);
			return message;

		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * This method is used to refresh view's
	 * 
	 * @param map,the
	 *            input parameters
	 * @return
	 */
	@SuppressWarnings("unused")
	public Message viewRefreshURL(Map<String, String> map, HttpServletResponse response, HttpServletRequest request) {
		// Initialization of Message
		Message message = new Message();
		Set<String> uniqKey = new HashSet<>();

		try {
			// Check if input parameter(url) from map is not null
			if (map.get("view_url") == null) {
				message.setDescription("Issues With URL");
				message.setValid(false);
				return message;
			}
			// Initialization of List<Map>
			List<Map<String, Object>> list = new ArrayList<>();

			// Creating objects of respective classes
			URL url = new URL(map.get("view_url"));

			InputStream inputStream = url.openStream();
			Scanner scanner = new Scanner(inputStream);

			while (scanner.hasNext()) {
				String string = scanner.nextLine();

				// Check string contains ./scripts
				if (string.contains("name:")) {

					String urlValue = string.substring(string.indexOf("name:'") + 6, string.lastIndexOf("'"));

					uniqKey.add(urlValue);

				}
			}
			scanner.close();

			Object[] obj = uniqKey.toArray();

			for (int i = 0; i < obj.length; i++) {
				// initialization of map
				Map<String, Object> urlMap = new HashMap<>();
				// Adding parameters to map
				urlMap.put("view_url", obj[i].toString());
				urlMap.put("is_added", false);
				list.add(urlMap);
			}

			// Get the maps in proMap
			Map<String, Object> proMap = processParameter.getMaps();

			String getProcedure = null;

			// Calling of procedure string
			if (proMap.get("36") != null) {
				getProcedure = proMap.get("36").toString();
			}

			// Set the failure response
			if (getProcedure == null) {
				message.setDescription("Sql Not get");
				message.setValid(false);
				return message;
			}

			// Initialization of String Builder
			StringBuilder apiname = new StringBuilder();
			StringBuilder apiurl = new StringBuilder();
			StringBuilder isAdded = new StringBuilder();

			// Break the data into chunks
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> mapList = list.get(i);
				apiname.append(mapList.get("view_url").toString().trim() + ",");
				apiurl.append(mapList.get("view_url").toString().trim() + ",");
				isAdded.append("0,");

				// Break the data with limit 10
				if ((i + 1) % 10 == 0) {

					// Check the length and then append it to the String Builder
					if (apiname.length() > 0) {
						apiname.deleteCharAt(apiname.lastIndexOf(","));
					}
					// Check the length and then append it to the String Builder
					if (apiurl.length() > 0) {
						apiurl.deleteCharAt(apiurl.lastIndexOf(","));
					}
					// Check the length and then append it to the String Builder
					if (isAdded.length() > 0) {
						isAdded.deleteCharAt(isAdded.lastIndexOf(","));
					}

					// Calling of procedure and retrieve the result in object
					// class

					Object responseFromProcedure = genericService.executeProcesure(null, getProcedure,
							request.getHeader("user_key"), request.getHeader("user_id"), map.get("application_id"),
							apiname.toString().trim(), apiurl.toString().trim(), isAdded.toString().trim());

					// System.out.println("responseFromProcedure-- " +
					// responseFromProcedure);

					// Delete the last character in String Builder
					apiname.delete(0, apiname.length());
					apiurl.delete(0, apiurl.length());
					isAdded.delete(0, isAdded.length());
				}

			}
			// Check the length and then delete from the String Builder
			if (apiname.length() > 0) {
				apiname.deleteCharAt(apiname.lastIndexOf(","));
			}
			// Check the length and then delete from the String Builder
			if (apiurl.length() > 0) {
				apiurl.deleteCharAt(apiurl.lastIndexOf(","));
			}
			// Check the length and then delete from the String Builder
			if (isAdded.length() > 0) {
				isAdded.deleteCharAt(isAdded.lastIndexOf(","));
			}

			// Calling of procedure and retrieve the result in object
			// class
			Object responseProcedure = genericService.executeProcesure(null, getProcedure,
					request.getHeader("user_key"), request.getHeader("user_id"), map.get("application_id"),
					apiname.toString().trim(), apiurl.toString().trim(), isAdded.toString().trim());

			// Set the success response
			if (responseProcedure != null) {
				message.setDescription("Done");
				message.setObject(responseProcedure);
				message.setValid(true);
				return message;
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
		// Set the failure response
		message.setDescription("Not Done");
		message.setValid(false);
		return message;
	}

	/**
	 * This method is used to refresh APi's
	 * 
	 * @param map,the
	 *            input parameters
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public Message apiRefreshURL(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		// Initialization of Message
		Message message = new Message();

		try {

			// Calling of the method readURL,which reads the URL from Swagger
			// document
			Message genericMessage = readURL(map, request, response);

			// Check if genericMessage is valid
			if (genericMessage.isValid()) {

				Map<String, Object> proMap = processParameter.getMaps();

				String sql = null;
				// Calling of procedure number 30
				if (proMap.get("30") != null) {
					sql = proMap.get("30").toString();
				}

				// Set the failure response
				if (sql == null) {
					message.setDescription("Sql Not get");
					message.setValid(false);
					return message;
				}

				// Convert the response retrieved from procedure is converted
				// into map
				Map<String, Object> maps = (Map<String, Object>) genericMessage.getObject();
				Set<String> set = (Set<String>) maps.get("url");

				// Convert Set<String> to array
				Object[] string = set.toArray();

				// Initialization of String Builder
				StringBuilder apiname = new StringBuilder();
				StringBuilder apiurl = new StringBuilder();
				StringBuilder isAdded = new StringBuilder();

				// Break the data into chunks
				for (int i = 0; i < string.length; i++) {
					// Map<String, Object> mapList = maps.get(i);

					Object mapList = string[i];

					apiname.append(mapList.toString().trim() + ",");
					apiurl.append(mapList.toString().trim() + ",");
					isAdded.append("0,");

					// Break the data with limit 10
					if ((i + 1) % 10 == 0) {
						// Check the length and then append it to the String
						// Builder
						if (apiname.length() > 0) {
							apiname.deleteCharAt(apiname.lastIndexOf(","));
						}
						// Check the length and then append it to the String
						// Builder
						if (apiurl.length() > 0) {
							apiurl.deleteCharAt(apiurl.lastIndexOf(","));
						}
						// Check the length and then append it to the String
						// Builder
						if (isAdded.length() > 0) {
							isAdded.deleteCharAt(isAdded.lastIndexOf(","));
						}

						// Calling of procedure and retrieve the result in
						// object class
						Object responseFromProcedure = genericService.executeProcesure(null, sql, map.get("user_key"),
								map.get("user_id"), map.get("application_id"), apiname.toString().trim(),
								apiurl.toString().trim(), isAdded.toString().trim());

						// Delete the last character in String Builder
						apiname.delete(0, apiname.length());
						apiurl.delete(0, apiurl.length());
						isAdded.delete(0, isAdded.length());
					}

				}
				// Check the length and then delete from the String Builder
				if (apiname.length() > 0) {
					apiname.deleteCharAt(apiname.lastIndexOf(","));
				}
				// Check the length and then delete from the String Builder
				if (apiurl.length() > 0) {
					apiurl.deleteCharAt(apiurl.lastIndexOf(","));
				}
				// Check the length and then delete from the String Builder
				if (isAdded.length() > 0) {
					isAdded.deleteCharAt(isAdded.lastIndexOf(","));
				}
				// Calling of procedure and retrieve the result in object
				// class
				Object responseProcedure = genericService.executeProcesure(null, sql, map.get("user_key"),
						map.get("user_id"), map.get("application_id"), apiname.toString().trim(),
						apiurl.toString().trim(), isAdded.toString().trim());

				if (responseProcedure != null) {
					// Set the success response
					message.setDescription("Done");
					message.setObject(responseProcedure);
					message.setValid(true);
					return message;
				}
			}
			// }
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
		// Set the failure response
		message.setDescription("Not Done");
		message.setValid(false);
		return message;
	}

	/**
	 * This method is used to maintain Authorization mapping
	 * 
	 * @param map,the
	 *            input parameters.
	 * @return
	 */
	@SuppressWarnings({ "serial" })
	public Message oAuthMappingHandler(Map<String, String> map) {
		// Initialization of Message
		Message message = new Message();

		try {
			// Check if input parameter(url) from map is not null
			if (map.get("url") == null) {
				message.setDescription("Issues With URL");
				message.setValid(false);
				return message;
			}

			// Check if input parameter(application_id) from map is not null
			if (map.get("application_id") == null) {
				message.setDescription("Application Id is required.");
				message.setValid(false);
				return message;
			}

			// Check if input parameter(file_path) from map is not null
			if (map.get("file_path") == null) {
				message.setDescription("File Path Required.");
				message.setValid(false);
				return message;
			}

			// Calling of procedures and retrieve the object class
			Object apiAccess = genericService.executeProcesure(null, processParameter.getMaps().get("54").toString(),
					map.get("application_id"));

			// System.out.println("apiAccess- " + apiAccess);

			Object viewAccess = genericService.executeProcesure(null, processParameter.getMaps().get("53").toString(),
					map.get("application_id"));

			String finalString = "var PERMISSION_API=" + new Gson().toJson(apiAccess) + ";\n var PERMISSION_VIEW="
					+ new Gson().toJson(viewAccess) + ";";

			String data = "file_path=" + map.get("file_path") + "&auth_mapping=" + finalString;
			// String data = "role_id=" + map.get("role_id") + "&api_ids=" +
			// map.get("api_ids") + "&is_bit="
			// + map.get("is_bit") + "&file_path=" + map.get("file_path") +
			// "&auth_mapping=" + finalString;

			// Calling of particular URL and retrieve the object class
			Object object = httpURLCalling.getData(map.get("url"), data);

			if (object != null) {

				Type type = new com.google.common.reflect.TypeToken<Message>() {
				}.getType();

				// Set the success response
				Message objectMessage = new Gson().fromJson(object.toString(), type);
				return objectMessage;
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
		// Set the failure response
		message.setDescription("File Not write");
		message.setValid(false);
		return message;
	}

	/**
	 * This method is used to handle mapping of API's and views
	 * 
	 * @param response
	 * @param request
	 * 
	 * @param map,the
	 *            input parameters.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Message mappingHandler(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		// Initialization of Message
		Message message = new Message();

		try {
			Map<String, Object> proMap = processParameter.getMaps();
			// Check if input parameter(file_path) from map is not null
			if (map.get("file_path") == null) {
				message.setDescription("File Path is Required.");
				message.setValid(false);
				return message;
			}

			// Write file in tomcat server
			FileWriter writer = new FileWriter(new File(map.get("file_path")));
			writer.write(map.get("auth_mapping"));
			writer.close();
			Constant.accessmap.remove(request.getAttribute("access_key"));

			Object apiCall = genericService.executeProcesure(null, proMap.get("94").toString(),
					request.getHeader("user_key").toString(), request.getHeader("user_id").toString(),
					String.valueOf(request.getHeader("roles_id")));

			// Check result retrieved from procedure is not null
			if (apiCall != null) {
				ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(apiCall);
				// System.out.println("json" + json);
				Constant.accessmap.put(String.valueOf(request.getAttribute("access_key")), json);
			}
			// Set the success response
			message.setDescription("File Write Successfully");
			message.setObject(map.get("file_path"));
			message.setValid(true);
			return message;
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * This method is used to read all URL's specified in Swagger Document.
	 * 
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public Message readURL(Map<String, String> map, HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		// Initialize Message class
		Message message = new Message();
		try {

			/*
			 * Calling of Swagger URL
			 */
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder().url(map.get("url")).get().addHeader("cache-control", "no-cache")
					.build();

			// Get the response after calling swagger document url
			Response response = client.newCall(request).execute();

			// Convert the response in object class
			Object urlResponse = response.body().string();

			// Initialization of gson class
			Gson gson = new Gson();

			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			// Convert the response into map
			Map<String, Object> mapURL = gson.fromJson((String) urlResponse, type);
			// System.out.println("Response converted into map :- " + mapURL);

			// Get all the keysets of map
			Set<String> set = mapURL.keySet();

			if (set.contains("paths")) {

				Object object = mapURL.get("paths");
				// System.out.println("Paths are - " + object);
				// convert the object class into map
				Map<String, Object> mapPaths = (Map<String, Object>) object;

				Set<String> setUrl = mapPaths.keySet();

				Map<String, Object> mapResponse = new HashMap<>();
				mapResponse.put("url", setUrl);
				// objectURL = setUrl;

				// Set the success response
				message.setDescription("Process Success");
				message.setObject(mapResponse);
				message.setValid(true);
				return message;
			}

		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			exception.printStackTrace();
			message.setDescription(exception.getMessage());
			message.setValid(false);
			return message;
		}
		return message;
	}

	/**
	 * This method is used to retrieve all URL's required at the time of
	 * assigning permissions on web page.
	 * 
	 * @param map,the
	 *            input parameters.
	 * @return
	 */
	public Object getURL(Map<String, String> map) {
		// Initialization of Message
		Message message = new Message();

		try {

			// Check if input parameter(url) from map is not null
			if (map.get("url") == null) {
				// Set the failure response
				message.setDescription("Issues With URL");
				message.setValid(false);
				return message;
			}

			// Retrieve the result in object class after calling specific URL
			Object object = httpURLCalling.getData(map.get("url"), "");

			// Check if object is not null
			if (object != null) {
				return object;
			}

		}
		// Handling Exceptions
		catch (Exception e) {
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
		// Set the failure response
		message.setDescription("Issues With URL");
		message.setValid(false);
		return message;
	}
}
