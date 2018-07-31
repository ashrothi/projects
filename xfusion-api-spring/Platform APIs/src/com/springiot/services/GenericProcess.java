package com.springiot.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.constant.ProcessParameter;
import com.springiot.filter.ServerSideFiltering;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This Class is used to define the generic processes from Databases.
 * 
 * @author tanvigarg
 */
@Service
public class GenericProcess {
	/**
	 * To access functionality of Generic Service
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * Used to interact with the procedures.
	 */
	@Autowired
	private ProcessParameter processParameter;
	@Autowired
	private DownloadServices downloadServices;
	@Autowired
	private UrlValidationKeyService urlValidationKeyService;

	/**
	 * GenericProcedureCalling() method is used to check the data received from
	 * Performance Database.
	 */

	public Message GenericProcedureCalling(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();

		try {

			Message validUrl = urlValidationKeyService.validateURL(request, response);
			if (!validUrl.isValid()) {
				return validUrl;
			}

			// This particular map is used to call particular procedure on the
			// basis of request type
			Map<String, Object> responseForProcedureCall = procedureCall(requestType, map, request, response);

			String sql = responseForProcedureCall.get("sql").toString();
			Object[] spParameter = (Object[]) responseForProcedureCall.get("params");

			// System.out.println("spParameter" +
			// spParameter.toString().trim());

			if (sql != null) {

				Object executeQuery = null;
				Object downloadResponse = null;

				if (!map.containsKey("report_api_url") && !map.containsKey("report_name")) {
					if (spParameter == null) {
						long initialTime = new Date().getTime();
						executeQuery = genericService.executeProcesure(null, sql);
						long finalTime = new Date().getTime();
						System.out.println("Genric query time :" + (finalTime - initialTime));
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(executeQuery);
						responseMessage.setValid(true);

						return responseMessage;
					} else {
						long initialTime = new Date().getTime();
						executeQuery = genericService.executeProcesure(null, sql, spParameter);
						long finalTime = new Date().getTime();
						System.out.println("Genric query time :" + (finalTime - initialTime));
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(executeQuery);
						responseMessage.setValid(true);

						return responseMessage;
					}
				} else {
					if (map.get("report_api_url") != null && map.get("report_name") != null) {

						List<Object> list = new ArrayList<Object>(Arrays.asList(spParameter));
						list.removeAll(Arrays.asList(map.get("report_api_url")));
						list.removeAll(Arrays.asList(map.get("report_name")));
						list.removeAll(Arrays.asList(map.get("timezone")));
						spParameter = list.toArray(new String[list.size()]);

						// System.out.println("spParameter in if condition " +
						// spParameter);
						executeQuery = genericService.executeProcesure(null, sql, spParameter);

						downloadResponse = downloadServices.DownloadGenericProcedureCallingPerformanceAPI(map,
								executeQuery);
						if (downloadResponse != null) {
							// System.out.println("executeQuery " +
							// downloadResponse);
							return (Message) downloadResponse;
						} else if (executeQuery != null) {
							responseMessage.setDescription("Process Success");
							responseMessage.setObject(executeQuery);
							responseMessage.setValid(true);

							return responseMessage;
						}
					}
				}

			}

		}
		// Handling all exceptions
		catch (Exception exception) {
			exception.printStackTrace();
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * GenericProcedureCalling() method is used to check the data received from
	 * Config Database.
	 */
	public Message GenericProcedureCallingConfig(String requestType, Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message responseMessage = new Message();

		try {
			Message validUrl = urlValidationKeyService.validateURL(request, response);
			if (!validUrl.isValid()) {
				return validUrl;
			}
			// This particular map is used to call particular procedure on the
			// basis of request type
			Map<String, Object> responseForProcedureCall = procedureCall(requestType, map, request, response);

			String sql = responseForProcedureCall.get("sql").toString();
			Object[] spParameter = (Object[]) responseForProcedureCall.get("params");

			// System.out.println("spParameter" + String.valueOf(spParameter));
			if (sql != null) {

				Object executeQuery = null;
				if (spParameter == null) {
					long initialTime = new Date().getTime();
					executeQuery = genericService.executeProcesureFromConfig(null, sql);
					long finalTime = new Date().getTime();
					System.out.println("Genric query time :" + (finalTime - initialTime));
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(executeQuery);
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					long initialTime = new Date().getTime();
					executeQuery = genericService.executeProcesureFromConfig(null, sql, spParameter);
					long finalTime = new Date().getTime();
					System.out.println("Genric query time :" + (finalTime - initialTime));
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(executeQuery);
					responseMessage.setValid(true);

					return responseMessage;
				}

			}

		}
		// Handling all exceptions
		catch (Exception exception) {
			exception.printStackTrace();
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * GenericProcedureCalling() method is used to check the data received from
	 * MetaData Database.
	 */
	@SuppressWarnings({ "unchecked" })
	public Message GenericProcedureCallingMetaData(String requestType, Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println("Generic Procedure Calling Metadata");
		Message responseMessage = new Message();

		try {
			Message validUrl = urlValidationKeyService.validateURL(request, response);
			if (!validUrl.isValid()) {
				return validUrl;
			}
			// This particular map is used to call particular procedure on the
			// basis of request type

			Map<String, Object> responseForProcedureCall = procedureCall(requestType, map, request, response);

			String sql = responseForProcedureCall.get("sql").toString();
			Object[] spParameter = (Object[]) responseForProcedureCall.get("params");
			// System.out.println("spParameter " + spParameter.toString() +
			// sql);

			if (sql != null) {

				Object executeQuery = null;
				Object downloadResponse = null;
				if (!map.containsKey("report_api_url") && !map.containsKey("report_name")) {

					if (spParameter == null) {
						long initialTime = new Date().getTime();
						executeQuery = genericService.executeProcesureFromMetaData(null, sql);
						long finalTime = new Date().getTime();
						System.out.println("Genric query time :" + (finalTime - initialTime));
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(executeQuery);
						responseMessage.setValid(true);

						return responseMessage;
					} else {
						long initialTime = new Date().getTime();
						executeQuery = genericService.executeProcesureFromMetaData(null, sql, spParameter);
						long finalTime = new Date().getTime();
						System.out.println("Genric query time :" + (finalTime - initialTime));
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(executeQuery);
						responseMessage.setValid(true);

						return responseMessage;
					}

				} else {
					if (map.get("report_api_url") != null && map.get("report_name") != null) {

						if (map.get("report_api_url").equalsIgnoreCase("device/get/metadata/status/by/type/limit")) {

							executeQuery = genericService.executeProcesureFromMetaData(null, sql, spParameter);

							// System.out.println("executeQuery in Generic
							// Process"
							// + executeQuery);

							downloadResponse = downloadServices.DownloadGenericProcedureCallingPerformance(map,
									executeQuery);
							if (downloadResponse != null) {
								// System.out.println("executeQuery " +
								// downloadResponse);
								return (Message) downloadResponse;
							} else if (executeQuery != null) {

								responseMessage.setDescription("Process Success");
								responseMessage.setObject(executeQuery);
								responseMessage.setValid(true);

								return responseMessage;
							}
						} else if (map.get("report_api_url").equalsIgnoreCase(
								"device/get/metadata/status/by/type/limit/without/additional/parameters")) {

							executeQuery = genericService.executeProcesureFromMetaData(null, sql, spParameter);

							// System.out.println("executeQuery in Generic
							// Process"
							// + executeQuery);

							downloadResponse = downloadServices.DownloadGenericProcedureCalling(map, executeQuery);
							if (downloadResponse != null) {
								// System.out.println("executeQuery " +
								// downloadResponse);
								return (Message) downloadResponse;
							} else if (executeQuery != null) {

								responseMessage.setDescription("Process Success");
								responseMessage.setObject(executeQuery);
								responseMessage.setValid(true);

								return responseMessage;
							}
						} else if (map.get("report_api_url").equalsIgnoreCase("device/get/metadata/status/by/type")) {

							executeQuery = genericService.executeProcesureFromMetaData(null, sql, spParameter);

							// System.out.println("executeQuery in Generic
							// Process"
							// + executeQuery);

							List<Map<String, Object>> gisList = (List<Map<String, Object>>) executeQuery;

							List<Object> GisObject = new ArrayList<>();

							for (Map<String, Object> gisMap : gisList) {

								// System.out.println("!!!!!!!!!!!!!!!!!" +
								// gisMap.get("device_device_lattitude"));

								if (gisMap.get("device_device_lattitude") == null
										|| String.valueOf(gisMap.get("device_device_lattitude")).equals("")
										|| gisMap.get("device_device_longitude") == null
										|| String.valueOf(gisMap.get("device_device_longitude")).equals("")) {

								} else {
									GisObject.add(gisMap);
								}
							}
							downloadResponse = downloadServices.DownloadGenericProcedureCalling(map, GisObject);
							if (downloadResponse != null) {
								// System.out.println("executeQuery " +
								// downloadResponse);
								return (Message) downloadResponse;
							} else if (executeQuery != null) {

								responseMessage.setDescription("Process Success");
								responseMessage.setObject(executeQuery);
								responseMessage.setValid(true);

								return responseMessage;
							}
						}

						else {
							executeQuery = genericService.executeProcesureFromMetaData(null, sql, spParameter);
							downloadResponse = downloadServices.DownloadGenericProcedureCalling(map, executeQuery);
							if (downloadResponse != null) {
								// System.out.println("executeQuery " +
								// downloadResponse);
								return (Message) downloadResponse;
							} else if (executeQuery != null) {

								responseMessage.setDescription("Process Success");
								responseMessage.setObject(executeQuery);
								responseMessage.setValid(true);

								return responseMessage;
							}
						}

					}

				}
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			exception.printStackTrace();
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * This method is used to call procedures for audit and error logs.This
	 * makes the connection with logs database.
	 * 
	 * @param requestType,the
	 *            procedure number which needs to be called.
	 * @param map,contains
	 *            the input parameters.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Message GenericProcedureLogs(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Message responseMessage = new Message();

		try {
			Message validUrl = urlValidationKeyService.validateURL(request, response);
			if (!validUrl.isValid()) {
				return validUrl;
			}
			// This particular map is used to call particular procedure on the
			// basis of request type
			Map<String, Object> responseForProcedureCall = procedureCall(requestType, map, request, response);

			String sql = responseForProcedureCall.get("sql").toString();
			Object[] spParameter = (Object[]) responseForProcedureCall.get("params");

			// Check if sql is not null
			if (sql != null) {

				// Initializing the variables
				Object executeQuery = null;
				Object downloadResponse = null;

				if (!map.containsKey("report_api_url") && !map.containsKey("report_name")) {
					if (spParameter == null) {
						executeQuery = genericService.executeProcesureFromLogs(null, sql);
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(executeQuery);
						responseMessage.setValid(true);

						return responseMessage;
					} else {
						executeQuery = genericService.executeProcesureFromLogs(null, sql, spParameter);
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(executeQuery);
						responseMessage.setValid(true);

						return responseMessage;
					}
				} else {
					if (map.get("report_api_url") != null && map.get("report_name") != null) {

						List<Object> list = new ArrayList<Object>(Arrays.asList(spParameter));
						list.removeAll(Arrays.asList(map.get("report_api_url")));
						list.removeAll(Arrays.asList(map.get("report_name")));
						list.removeAll(Arrays.asList(map.get("timezone")));
						spParameter = list.toArray(new String[list.size()]);

						// Calling of procedure
						executeQuery = genericService.executeProcesureFromLogs(null, sql, spParameter);

						// Calling of method for excel download
						downloadResponse = downloadServices.DownloadGenericProcedureCallingPerformanceAPI(map,
								executeQuery);

					}
				}

				// // Check if parameters are null or not
				//
				//
				// // Check if excel download parameters are present or not
				// if (map.get("report_api_url") != null &&
				// map.get("report_name") != null) {
				//
				// List<Object> list = new
				// ArrayList<Object>(Arrays.asList(spParameter));
				// list.removeAll(Arrays.asList(map.get("report_api_url")));
				// list.removeAll(Arrays.asList(map.get("report_name")));
				// list.removeAll(Arrays.asList(map.get("timezone")));
				// spParameter = list.toArray(new String[list.size()]);
				//
				// // Calling of procedure
				// executeQuery = genericService.executeProcesureFromLogs(null,
				// sql, spParameter);
				//
				// // Calling of method for excel download
				// downloadResponse =
				// downloadServices.DownloadGenericProcedureCallingPerformanceAPI(map,
				// executeQuery);
				//
				// }
				//
				// // Calling of generic procedure
				// else {
				// List<Object> list = new
				// ArrayList<Object>(Arrays.asList(spParameter));
				// list.removeAll(Arrays.asList(map.get("report_api_url")));
				// list.removeAll(Arrays.asList(map.get("report_name")));
				// list.removeAll(Arrays.asList(map.get("timezone")));
				// spParameter = list.toArray(spParameter);
				// // Calling of generic procedure
				// executeQuery = genericService.executeProcesureFromLogs(null,
				// sql, spParameter);
				// }
				if (downloadResponse != null) {

					return (Message) downloadResponse;
				} else if (executeQuery != null) {

					// set the response message
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(executeQuery);
					responseMessage.setValid(true);

					return responseMessage;
				}

			}

		}
		// Handling all exceptions
		catch (Exception exception) {
			exception.printStackTrace();
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	private String convertDate(String string) {
		if (string.equalsIgnoreCase("")) {
			return null;
		} else {
			Date date = new Date(Long.parseLong(string));

			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
			String formatted = format.format(date);

			// System.out.println("formatted data " + formatted);
			return formatted;
		}

	}

	/**
	 * This method is used to retrieve procedure from mvc dispatcher servlet xml
	 * file on the basis of request type
	 * 
	 * @param map
	 * @param response
	 * @param request
	 * 
	 * @param procedureRequestMap,this
	 *            contains a list of all procedures from xml file
	 * @param requestType,this
	 *            contains the particular procedure which needs to be called.
	 * @return
	 */
	private Map<String, Object> procedureCall(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Map is used to retrieve the lists of procedure from mvc
		// dispatcher servlet xml file
		// System.out.println("map " + map);
		Map<String, Object> procedureRequestMap = processParameter.getMaps();
		String params = null;
		String sql = null;
		List<Object> parameterList = new ArrayList<>();
		ServerSideFiltering filter = new ServerSideFiltering();
		Object[] spParameter = null;
		if (procedureRequestMap.get(requestType) != null) {
			String value = procedureRequestMap.get(requestType).toString();

			// Manipulate sql procedure according to the parameter name wise
			params = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

			// Get the procedure values
			String sqlValue = value.substring(0, value.indexOf("("));
			String key = value.substring(value.indexOf("("));

			// Initialization of String Builder
			StringBuilder builder = new StringBuilder(
					key.replaceAll("[^,()]", "").replace(")", ",)").replace(",", "?,"));
			/*
			 * Check the value of params if empty or not
			 */
			if (params.isEmpty()) {
				sql = sqlValue + "()";

			} else {
				sql = sqlValue + "" + builder.deleteCharAt(builder.lastIndexOf(",")).toString();
			}
			// System.out.println("\n Param :-" + params + "==" + sql);
		}

		// Map is required to set the response
		Map<String, Object> responseMap = new HashMap<>();

		responseMap.put("params", params);
		responseMap.put("sql", sql);

		for (String checkString : params.split(",")) {
			if (map == null) {
				continue;
			}
			switch (checkString) {
			case "token":

				break;
			case "user_key":
				parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);

				break;
			case "user_id":
				parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
				break;

			case "organization_id":
				Integer organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
				/**
				 * Putting it in input parameter map
				 */
				map.put("organization_id", organizationId.toString());

				parameterList.add(map.get(checkString.trim()) != null ? map.get(checkString.trim()) : null);
				break;

			case "in_condition":
				if (map.get(checkString) != null && !map.get(checkString).isEmpty()) {

					parameterList.add(filter.filterData(map.get(checkString.trim()).toString()));

					// parameterList.add(filter.filterData(map.get(string.trim()).toString()));

				} else {
					parameterList.add(null);
				}
				break;
			case "from_date":
				parameterList.add(convertDate(map.get(checkString.trim()).toString()));
				break;
			case "end_date":
				parameterList.add(convertDate(map.get(checkString.trim()).toString()));
				break;
			case "last_activity_date":
				parameterList.add(convertDate(map.get(checkString.trim()).toString()));
				break;
			case "password_change_date":
				parameterList.add(convertDate(map.get(checkString.trim()).toString()));
				break;

			default:
				if (map.get(checkString.trim()) != null) {
					String value = map.get(checkString.trim());

					if (value.toString().isEmpty()) {
						parameterList.add(null);
					} else {
						parameterList.add(value);
					}
				}
				break;
			}

		}

		// The input parameter list is converted into array
		if (parameterList.size() > 0) {
			spParameter = parameterList.toArray();

		} else {
			spParameter = null;
		}
		// System.out.println("parameter parameterList:- " +
		// parameterList.toString() + ", requestedApi data:- " + sql);

		responseMap.put("params", spParameter);
		return responseMap;

	}

	Map<String, Object> getOAuthQuery(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * Initialize string builder to make parameter string to pass in calling
		 * API
		 */
		Map<String, Object> passainMap = new LinkedHashMap<>();
		StringBuilder passingParameter = new StringBuilder();
		/**
		 * To create Query String to call OAuth API
		 */
		Map<String, String> headerMap = new LinkedHashMap<>();
		headerMap.put("token", request.getHeader("token"));
		headerMap.put("user_key", String.valueOf(request.getHeader("user_key")));
		headerMap.put("user_id", String.valueOf(request.getHeader("user_id")));
		for (String key : passingMap.keySet()) {

			/*
			 * To append Token in query String
			 */
			// passingParameter.append("token=" + token.getAccess_token());

			passingParameter.append("&" + key + "=" + passingMap.get(key));

		}

		passingParameter.deleteCharAt(0);
		/*
		 * Check if String is not empty
		 */
		if (!passingParameter.toString().isEmpty()) {

			/*
			 * return Passing String
			 */
			passainMap.put("passingHeader", headerMap);
			passainMap.put("passingString", passingParameter);

			return passainMap;
		}
		/**
		 * return null if something went wrong
		 */
		passainMap.put("passingHeader", headerMap);
		return passainMap;
	}
}
