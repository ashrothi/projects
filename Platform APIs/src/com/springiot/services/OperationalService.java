/**
 * @author tanvigarg
 * This package is used to call Authorization Engine API's and get the response from them,then manipulate as per the requirement
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessage;
import com.springiot.response.Message;

/**
 * 
 * This class is used to call Authorization Engine API's and return the response
 * retrieved from them.
 *
 */
@Service
@Transactional
@SuppressWarnings({ "unchecked", "unused", "serial" })
@PropertySource(value = "/WEB-INF/download.properties")
public class OperationalService {
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private URLParameter urlParameter;
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private DownloadServices downloadServices;
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private ProcessParameter processParameter;
	@Autowired
	Environment environment;
	@Autowired
	private GenericProcess genericProcess;
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private DownloadDeviceDetailsService downloadDeviceDetailsService;

	/**
	 * This method is used to get the users list from Authorization Engine
	 * 
	 * @param map,the
	 *            input parameters specified by the user
	 * @return
	 */

	public Message UsersList(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Initialization of Response Message
		Message responseMessage = new Message();

		// Initialization of
		String reportURL = "";
		String reportName = "";
		//
		// map.put("token", request.getHeader("token"));
		// map.put("user_key", request.getHeader("user_key"));
		// map.put("user_id", request.getHeader("user_id"));

		// check map contains report_api_url and report_name
		if (map.containsKey("report_api_url") && map.containsKey("report_name")) {

			/*
			 * To get the particular Report Api URL to generate Report
			 */
			if (map.get("report_api_url") == null) {
				responseMessage.setDescription("Report URL is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			reportURL = map.get("report_api_url");
			map.remove("report_api_url");

			/*
			 * To get the particular Report Name to generate Report
			 */
			if (map.get("report_name") == null) {
				responseMessage.setDescription("Report name  is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			reportName = map.get("report_name").toString();
			map.remove("report_name");
		}

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUsersList(), queryString, headerMap);
			// System.out.println("Users list from Authorization Engine" +
			// urlResponseResult);

			// Check if urlResponseResult is not null
			if (urlResponseResult != null) {

				Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
				}.getType();

				// Convert the response retrieved after calling api is stored
				// into Map
				GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
						.fromJson(urlResponseResult.toString(), type);

				if (urlMessage.isValid()) {

					/*
					 * Calling of procedure from metadata database and retrieve the results in
					 * List<map> userList
					 */
					List<Map<String, Object>> userList = (List<Map<String, Object>>) genericService
							.executeProcesureFromMetaData(null, processParameter.getMaps().get("85").toString(),
									request.getHeader("user_key"), request.getHeader("user_id"));

					// System.out.println("users list in platform " + userList);

					// Initialization of Map
					Map<String, Map<String, Object>> mapDetails = new HashMap<>();

					for (int j = 0; j < userList.size(); j++) {
						// Add the values to the map
						mapDetails.put(String.valueOf(userList.get(j).get("user_key")).trim(), userList.get(j));
					}
					// System.out.println("mapDetails " + mapDetails);
					// Initializing the list<object>
					List<Object> listOperational = new ArrayList<>();
					List<Object> listNonOperational = new ArrayList<>();

					// Convert the response retrieved from procedure calling
					// into list<map>
					List<Map<String, Object>> listData = urlMessage.getObject();

					for (int i = 0; i < listData.size(); i++) {

						String name = String.valueOf(listData.get(i).get("users_user_key"));
						// System.out.println("name " + name + "" +
						// String.valueOf(mapDetails.get(name.trim())));
						if (mapDetails.get(name.trim()) != null) {

							// Initialization of Map
							Map<String, String> operationalMap = new HashMap<>();
							// Adding values to the map
							operationalMap.put("user_key", name);
							operationalMap.put("users_id", listData.get(i).get("users_name").toString());
							operationalMap.put("role_name", listData.get(i).get("roles_name").toString());

							operationalMap.put("organization_alias",
									mapDetails.get(name.trim()).get("organization_alias").toString());
							operationalMap.put("organization_ids",
									mapDetails.get(name.trim()).get("organization_ids").toString());

							listOperational.add(operationalMap);
						}

						else {

							Map<String, String> nonOperationalMap = new HashMap<>();

							nonOperationalMap.put("user_key", name);
							nonOperationalMap.put("users_id", listData.get(i).get("users_name").toString());
							nonOperationalMap.put("role_name", listData.get(i).get("roles_name").toString());

							listNonOperational.add(nonOperationalMap);
						}
					}

					Map<String, Object> mapObject = new HashMap<>();
					mapObject.put("operational", listOperational);
					mapObject.put("nonoperational", listNonOperational);

					if (reportURL.equalsIgnoreCase("users/list/operational")) {
						// Set the response message for success
						responseMessage.setDescription("Operational List");
						responseMessage.setObject(listOperational);
						responseMessage.setValid(true);
						return responseMessage;
					}

					else if (reportURL.equalsIgnoreCase("users/list/nonoperational")) {
						// Set the response message for success
						responseMessage.setDescription("Non Operational List");
						responseMessage.setObject(listNonOperational);
						responseMessage.setValid(true);
						return responseMessage;
					}
					// Set the response message for failure
					else {
						responseMessage.setDescription("Updated Successfully");
						responseMessage.setObject(mapObject);
						responseMessage.setValid(true);
						return responseMessage;
					}

				} else {
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		// Set the failure response
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * This method is used to download the excel(users list Operational or non
	 * operational) on the application
	 * 
	 * @param map,the
	 *            input parameters specified by the user
	 * @return
	 * @throws Exception
	 */
	public Message UsersListDownload(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Initializing the variables
		String reportUrl = "";
		String reportName = "";

		// check map contains report_api_url and report_name
		if (map.containsKey("report_api_url") && map.containsKey("report_name")) {
			reportUrl = map.get("report_api_url");
			reportName = map.get("report_name");

			Message usersListMessage = UsersList(map, request, response);

			Object objectUsers = usersListMessage.getObject();

			// System.out.println("Object Users" + objectUsers);

			// Adding parameters to the map
			map.put("report_api_url", reportUrl);
			map.put("report_name", reportName);
			// Set the response message for success
			Message downloadMessage = downloadServices.DownloadGenericProcedureCalling(map, objectUsers);
			return downloadMessage;
		}
		// Set the response message for failure
		else {

			Message message = UsersList(map, request, response);
			return message;
		}
	}

	/**
	 * This method is used to get Services from Authorization Engine and set the
	 * response for calling API.
	 * 
	 * @param map,the
	 *            input parameters specified by the user
	 * @return
	 */
	public Message getServices(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// Initialization of Response Message
		Message responseMessage = new Message();

		try {
			// Initializing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			/*
			 * Calling of Procedure from Metadata and retrieve the results in Object
			 * urlResponseResult
			 */

			Message plannerName = genericProcess.GenericProcedureCallingMetaData("15", map, request, response);

			// System.out.println("planner name" + plannerName.getObject());

			Type type = new TypeToken<List<Map<String, Object>>>() {
			}.getType();

			Gson gson = new GsonBuilder().serializeNulls().create();
			String object = gson.toJson(plannerName.getObject());

			// Initialization of Multi Map
			Multimap<String, Object> multimap = ArrayListMultimap.create();

			// Convert the response retrieved from OAuth API to List<Map>
			List<Map<String, Object>> listResponseObjects = gson.fromJson(object, type);

			for (Map<String, Object> inMap : listResponseObjects) {

				/*
				 * if (inMap.get("service_service_category").toString().toLowerCase
				 * ().equalsIgnoreCase("service")) { if (inMap != null) {
				 * multimap.put("service", inMap); }
				 * 
				 * } else { multimap.put("service", null); }
				 * 
				 * if (inMap.get("service_service_category").toString().toLowerCase
				 * ().equalsIgnoreCase("inventory")) { if (inMap != null) {
				 * multimap.put("inventory", inMap); }
				 * 
				 * } else { multimap.put("inventory", null); }
				 */

				// Staging server
				/*
				 * for (Map<String, Object> inMap : listResponseObjects) {
				 * multimap.put(inMap.get("service_service_category").toString() .toLowerCase(),
				 * inMap);
				 * 
				 * }
				 */

				if (inMap.get("service_service_category").toString().toLowerCase().equalsIgnoreCase("service")) {
					multimap.put("service", inMap);
				} else if (inMap.get("service_service_category").toString().toLowerCase()
						.equalsIgnoreCase("inventory")) {
					multimap.put("inventory", inMap);
				}

			}

			// System.out.println("MULTI MAP" + multimap);

			List<Object> listObjects = new ArrayList<>();

			for (String key : multimap.keySet()) {
				// Initialization of Tree Map
				TreeMap<String, Object> finalMap = new TreeMap<>();

				// System.out.println("KEYSET OF MULTIMAP" + multimap.keySet());
				// System.out.println("Get key of multimap" + key);

				if (key != null) {
					// adding parameters to final map
					finalMap.put(key, multimap.get(key));
				}

				// System.out.println("FINAL MAP" + finalMap);

				listObjects.add(finalMap);
				String result = new Gson().toJson(listObjects);

			}

			if (listObjects != null) {
				// Set the response message for success
				responseMessage.setDescription("Final Otput");
				responseMessage.setObject(listObjects);
				responseMessage.setValid(true);
				return responseMessage;
			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("Not Found");
				responseMessage.setObject(plannerName.getObject());
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

	}

	/**
	 * This method is used to get all Application from Authorization Engine and set
	 * the response for calling API.
	 * 
	 * @param map,the
	 *            input parameters specified by the user
	 * @return
	 */
	public Message getAllAppliction(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Initialization of Response Message
		Message responseMessage = new Message();
		//
		// parameterMap.put("token", request.getHeader("token"));
		// parameterMap.put("user_key", request.getHeader("user_key"));
		// parameterMap.put("user_id", request.getHeader("user_id"));

		try {
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			Object urlResponse = urlCalling.getData(urlParameter.getApplicationGetAll(), queryString, headerMap);

			/*
			 * @SuppressWarnings("serial") Type type = new TypeToken<List<Map<String,
			 * Object>>>() { }.getType();
			 * 
			 * Gson gson = new GsonBuilder().serializeNulls().create();
			 * 
			 * // Convert the response retrieved from OAuth API to List<Map>
			 * List<Map<String, Object>> dataList = gson.fromJson(urlResponse.toString(),
			 * type);
			 */

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to download excel file for the Device Model Details Page
	 * which includes the response of three API's merged and needs to be displayed
	 * on excel file in different sheets
	 * 
	 * @param map,
	 *            Contains the parameter map(Input Parameters passed by
	 *            user) @return, Return the response message.
	 * 
	 */
	public Message DeviceModelDetailsExcelDownload(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// initialization of object downloadResponse
		Object downloadResponse = null;

		/*
		 * Calling of DownloadGenericProcedureCallingDeviceDetails() Method for the
		 * further process of calling four API's and set the data and headers
		 * accordingly in excel file.
		 */
		downloadResponse = downloadDeviceDetailsService.DownloadGenericProcedureCallingDeviceDetails(map, request,
				response);

		// Return the response message.
		return (Message) downloadResponse;
	}

	/**
	 * This method is used to update user's profile by calling Authorization
	 * Engine's API
	 * 
	 * @param map,the
	 *            input parameters required to call the API
	 * @return
	 */
	public Message userProfileUpdate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Initialization of Response Message
		Message responseMessage = new Message();
		//
		// map.put("token", request.getHeader("token"));
		// map.put("user_key", request.getHeader("user_key"));
		// map.put("user_id", request.getHeader("user_id"));

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserProfileUpdate(), queryString, headerMap);

			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();

			Gson gson = new GsonBuilder().serializeNulls().create();

			// Convert the response retrieved from OAuth API to map
			Map<String, Object> mapOauthResult = gson.fromJson(urlResponseResult.toString(), type);

			// Check if list of objects is not null and size greater then zero
			if (!mapOauthResult.isEmpty() || mapOauthResult.size() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(mapOauthResult.get("object"));
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(mapOauthResult.get("object"));
				responseMessage.setValid(false);
				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to retrieve user's details on the basis of user_id by
	 * calling Authorization Engine's API
	 * 
	 * @param map,the
	 *            input parameters required to call the API
	 * @return
	 */
	public Message userDetailsByuserId(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		// map.put("token", request.getHeader("token"));
		// map.put("user_key", request.getHeader("user_key"));
		// map.put("user_id", request.getHeader("user_id"));

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserDetails(), queryString, headerMap);

			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();

			Gson gson = new GsonBuilder().serializeNulls().create();

			// Convert the response retrieved from OAuth API to map
			Map<String, Object> mapOauthResult = gson.fromJson(urlResponseResult.toString(), type);

			// Check if list of objects is not null and size greater then zero
			if (!mapOauthResult.isEmpty() || mapOauthResult.size() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(mapOauthResult.get("object"));
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(mapOauthResult.get("object"));
				responseMessage.setValid(false);
				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to retrieve applications of specific user.
	 * 
	 * @param map,the
	 *            input parameters required to call the API
	 * @return
	 */
	public Message applicationsById(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();
		//
		// map.put("token", request.getHeader("token"));
		// map.put("user_key", request.getHeader("user_key"));
		// map.put("user_id", request.getHeader("user_id"));

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getApplicationsGetById(), queryString.toString(),
					headerMap);

			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();

			Gson gson = new GsonBuilder().serializeNulls().create();

			// Convert the response retrieved from OAuth API to map
			Map<String, Object> mapOauthResult = gson.fromJson(urlResponseResult.toString(), type);

			// Check if list of objects is not null and size greater then zero
			if (!mapOauthResult.isEmpty() || mapOauthResult.size() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(mapOauthResult.get("object"));
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(mapOauthResult.get("object"));
				responseMessage.setValid(false);
				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	public Message validateToken(HttpServletRequest request, HttpServletResponse response) {

		// Initialization of Response Message
		Message responseMessage = new Message();
		Map<String, String> parameterMap = new HashMap<>();

		// Retrieve from where the request is coming to API
		String Type = request.getHeader("User-Agent");
		Integer tokenType;
		if (Type.contains("okhttp")) {
			tokenType = 1;
		} else {
			tokenType = 0;
		}

		// System.out.println("type" + Type);
		String applicationKey = String.valueOf(environment.getProperty("application.key"));

		// Retrieve from where the request is coming to API
		String RequestType = request.getHeader("User-Agent");
		// System.out.println("type" + RequestType);
		parameterMap.put("application_key", applicationKey);
		parameterMap.put("token_type", tokenType.toString());

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */

			Object urlResponse = urlCalling.getData(urlParameter.getValidateToken(), queryString, headerMap);
			// System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				/*
				 * Check if genericMessage is valid or not.
				 */

				List<Map<String, Object>> oauthMap = (List<Map<String, Object>>) urlMessage.getObject();

				Object getOrganizationId = genericService.executeProcesureFromMetaData(null,
						processParameter.getMaps().get("24").toString(), oauthMap.get(0).get("user_id"),
						oauthMap.get(0).get("user_key"));

				// System.out.println("getOrganizationId" + getOrganizationId);

				List<Map<String, Object>> organizationMap = (List<Map<String, Object>>) getOrganizationId;

				Integer organisationId;

				if (organizationMap.size() > 0) {
					organisationId = (Integer) organizationMap.get(0).get("organization_id");
				} else {
					organisationId = 0;
				}

				String hsql = "insert into TokenStorage.platform_token (access_token,role_id,user_key,user_id,access_key,token_type,application_key,organization_id,time) values ('"
						+ oauthMap.get(0).get("access_token") + "','" + oauthMap.get(0).get("roles_id") + "','"
						+ oauthMap.get(0).get("user_key") + "','" + oauthMap.get(0).get("user_id") + "','"
						+ oauthMap.get(0).get("access_key") + "','" + tokenType + "','"
						+ "9a959887-5946-11e6-9bb0-fe984cc15272" + "','" + organisationId + "',now())";

				// System.out.println("hsql is" + hsql);
				request.setAttribute("organization_id", organisationId);
				request.setAttribute("access_key", String.valueOf(oauthMap.get(0).get("access_key")));
				request.setAttribute("role_id", String.valueOf(oauthMap.get(0).get("roles_id")));

				Object tokenPersistent = genericService.executeHSqlQuery(hsql);
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	public Message usersLogged(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		try {

			Object responseFromProcedure = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("441").toString(), request.getHeader("user_key"),
					request.getHeader("user_id"));

			List<Map<String, Object>> usersList = (List<Map<String, Object>>) responseFromProcedure;
			// System.out.println(usersList);

			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < usersList.size(); i++) {

				String userKey = usersList.get(i).get("user_key").toString();

				builder.append(userKey + ",");

			}
			builder.deleteCharAt(builder.lastIndexOf((",")));
			// System.out.println("Builder is" + builder);

			String userKeysList = builder.toString();

			String userKeysQuery = userKeysList.replace(",", "\',\'");
			// System.out.println("userKeysQuery" + userKeysQuery);

			// int mobileUsers = 0;
			// int webUsers = 0;

			Map<String, Object> responseMap = new HashMap<>();

			String webUsersQuery = "SELECT * FROM TokenStorage.platform_token where token_type=0 and user_key in ('"
					+ userKeysQuery + "');";

			List<Map<String, Object>> webUsersCount = (List<Map<String, Object>>) genericService
					.executeHSqlSelectQuery(webUsersQuery);
			// System.out.println("tokenPersistent" + webUsersCount.get(0));

			String mobileUsersQuery = "SELECT * FROM TokenStorage.platform_token where token_type=1 and user_key in ('"
					+ userKeysQuery + "');";

			List<Map<String, Object>> mobileUsersCount = (List<Map<String, Object>>) genericService
					.executeHSqlSelectQuery(mobileUsersQuery);

			// System.out.println("tokenPersistent" +
			// mobileUsersCount.get(0).get("C1"));
			// System.out.println("tokenPersistent" +
			// mobileUsersCount.get(0).get("C1"));
			responseMap.put("mobile_users", mobileUsersCount.size());
			responseMap.put("web_users", webUsersCount.size());

			responseMessage.setDescription("Process Success");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(true);
			return responseMessage;
		} catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

	}

	public Message userSessionCheck(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		// parameterMap.put("token", request.getHeader("token"));
		// parameterMap.put("user_key", request.getHeader("user_key"));
		// parameterMap.put("user_id", request.getHeader("user_id"));

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			// System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getUserSessionCheck(), queryString, headerMap);

			// System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	public Message userSessionUpdate(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		// parameterMap.put("token", request.getHeader("token"));
		// parameterMap.put("user_key", request.getHeader("user_key"));
		// parameterMap.put("user_id", request.getHeader("user_id"));

		try {
			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			// System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getUserSessionUpdate(), queryString, headerMap);

			// System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			// System.out.println("url message" + urlMessage.getObject());

			List<Map<String, Object>> map = (List<Map<String, Object>>) urlMessage.getObject();
			// System.out.println("map" + map.get(0).get("token"));

			if (map.get(0).get("token") != null) {
				String tokenList = map.get(0).get("token").toString();

				String arrayToken[] = tokenList.split(",");

				for (int i = 0; i < arrayToken.length; i++) {

					String query = "delete from TokenStorage.platform_token where access_token='" + arrayToken[i]
							+ "';";
					// System.out.println("!!!!!" + query);

					Object accessKeyQueryResponse = genericService.executeHSqlQuery(query);

				}
			}
			map.get(0).remove("token");
			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(map.get(0));
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is required to get all the users of the organization and pass the
	 * users list to the authorization api and then call the platform procedure to
	 * require the organization settings update
	 * 
	 * @param parameterMap,the
	 *            input parameters specified by the user
	 * @param request,this
	 *            is required for the headers in the API while calling.
	 * @param response,
	 *            this is required for the headers in the API while calling.
	 *
	 * @return
	 * @author tanvigarg
	 */

	public Message organizationSettingupdate(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		try {

			// Retrieve the users list from the procedure
			Object responseFromProcedure = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("441").toString(), request.getHeader("user_key"),
					request.getHeader("user_id"));

			// Convert the response retrieved into list of map
			List<Map<String, Object>> usersList = (List<Map<String, Object>>) responseFromProcedure;

			StringBuilder builder = new StringBuilder();

			// Get the users list in comma separated way
			for (Map<String, Object> map : usersList) {
				String userKey = request.getHeader("user_key").toString();

				// append the user key to builder
				builder.append(userKey + ",");

			}
			builder.deleteCharAt(builder.lastIndexOf(","));

			parameterMap.put("user_list", builder.toString());

			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */

			Object urlResponse = urlCalling.getData(urlParameter.getAuthSessionconfigure(), queryString, headerMap);

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			List<Map<String, Object>> oauthResponse = urlMessage.getObject();
			// System.out.println("urlMessage" +
			// oauthResponse.get(0).get("status"));

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (oauthResponse.get(0).get("status").toString().equalsIgnoreCase("1.0")) {

				responseMessage = genericProcess.GenericProcedureCallingMetaData("149", parameterMap, request,
						response);

				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(responseMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is required to get all the users of the organization and pass the
	 * users list to the authorization api and then call the platform procedure to
	 * require the organization settings delete.
	 * 
	 * @param parameterMap,the
	 *            input parameters specified by the user
	 * @param request,this
	 *            is required for the headers in the API while calling.
	 * @param response,
	 *            this is required for the headers in the API while calling.
	 *
	 * @return
	 * @author tanvigarg
	 */
	public Message organizationDelete(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		// parameterMap.put("token", request.getHeader("token"));
		// parameterMap.put("user_key", request.getHeader("user_key"));
		// parameterMap.put("user_id", request.getHeader("user_id"));

		try {
			System.out.println(" MAp before del organization" + parameterMap);
			// Retrieve the users list from the procedure
			Object responseFromProcedure = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("441").toString(), request.getHeader("user_key"),
					request.getHeader("user_id"));

			// Convert the response retrieved into list of map
			List<Map<String, Object>> usersList = (List<Map<String, Object>>) responseFromProcedure;

			StringBuilder builder = new StringBuilder();

			// Get the users list in comma separated way
			for (Map<String, Object> map : usersList) {
				String userKey = request.getHeader("user_key").toString();

				// append the user key to builder
				builder.append("," + userKey);
				builder.delete(0, 1);
			}

			parameterMap.put("user_list", builder.toString());
			parameterMap.put("org_id", parameterMap.get("organization_id"));

			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */

			Object urlResponse = urlCalling.getData(urlParameter.getAuthSessionDeleteSettings(), queryString,
					headerMap);

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			List<Map<String, Object>> oauthResponse = urlMessage.getObject();
			// System.out.println("urlMessage" +
			// oauthResponse.get(0).get("status"));

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (oauthResponse.get(0).get("status").toString().equalsIgnoreCase("1.0")) {
				System.out.println(" MAp before del organization" + parameterMap);
				responseMessage = genericProcess.GenericProcedureCallingMetaData("31", parameterMap, request, response);

				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(responseMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to download excel for User Group Mapping Page with the
	 * Grafana Role parameter
	 * 
	 * @param map,contains
	 *            the input parameters.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Message OperationalUsersListDownload(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Initializing the variables
		Message downloadMessage = new Message();
		String reportUrl = "";
		String reportName = "";

		reportUrl = map.get("report_api_url");
		reportName = map.get("report_name");

		// Calling of users list method
		Message usersListMessage = UsersList(map, request, response);

		Object objectUsers = usersListMessage.getObject();

		// Cast the response retrieved into list<Map<String,Object>>
		List<Map<String, Object>> OperationalUsersList = (List<Map<String, Object>>) objectUsers;
		// System.out.println("grafanaList- " + OperationalUsersList);

		try {
			// Initializing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			passingParameter.append("email_id=" + map.get("email_id"));

			// System.out.println("passingParameter" + passingParameter);

			// Calling of Grafana Interface API
			Object urlResponse = urlCalling.getData(urlParameter.getGrafanaRole(), passingParameter.toString(), null);

			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map
			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			List<Map<String, Object>> grafanaList = urlMessage.getObject();

			// Adding parameters to the map
			map.put("report_api_url", reportUrl);
			map.put("report_name", reportName);

			for (Map<String, Object> grafanaMap : grafanaList) {

				// Get user id from Grafana
				String userIdFromGrafana = String.valueOf(grafanaMap.get("email"));

				// Get user role from grafana
				String grafanaRole = String.valueOf(grafanaMap.get("role"));

				for (int i = 0; i < OperationalUsersList.size(); i++) {
					String userIdfromPlatform = String.valueOf(OperationalUsersList.get(i).get("users_id"));

					// check if same user exists in grafana or authorization
					// engine
					// System.out.println("userIdFromGrafana- " +
					// userIdFromGrafana);
					// System.out.println("userIdfromPlatform-
					// "+userIdfromPlatform);

					if (userIdFromGrafana.equalsIgnoreCase(userIdfromPlatform)) {

						// System.out.println("TRUE");

						OperationalUsersList.get(i).put("grafana_role", grafanaRole);
					}
				}
			}

			// System.out.println("OperationalUsersList-" +
			// OperationalUsersList);

			// Set the response message for success
			downloadMessage = downloadServices.DownloadGenericProcedureCalling(map, OperationalUsersList);

		} catch (Exception exception) {
			// Handling all exceptions
			exception.printStackTrace();
		}
		return downloadMessage;
	}
}
