/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

import java.lang.reflect.Type;
/**
 * To Import Classes to access their functionality
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for Generic Process for API Calling to
 * call Procedure and retrieve their data by getting parameter in map and
 * requestType as key to get the procedure which is to be called.
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class GenericProcess {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;
	@Autowired
	private DownloadServices downloadServices;
	@Autowired
	private HttpURLCalling urlCalling;

	/**
	 * 
	 * @param requestType:-
	 *            Key to get Procedure Name
	 * @param map
	 *            :-Parameters to call procedure
	 * @param clz:-
	 *            to set the response
	 * @param request:-
	 *            to get user_key and userId From https request along with token
	 * @param response
	 * @return Message Response
	 */
	@SuppressWarnings("rawtypes")
	public Message GenericProcedureCalling(String requestType, Map<String, String> map, Class clz,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To Inizialize the response Message
		 */
		Message message = new Message();
		try {
			/**
			 * to store stored Procedure Parameter in array of object
			 */
			Object[] storedProcedureParameter = null;
			/**
			 * To get Map of Stored Procedure
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * To get Parameter List in List Of Object
			 */
			List<Object> parameterList = new ArrayList<>();
			/**
			 * Initializing sql query and its param to call procedure
			 */
			String sql = null;
			String params = null;

			/*
			 * This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
			 */
			if (procedureRequestMap.get(requestType) != null) {
				String value = procedureRequestMap.get(requestType).toString();

				params = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

				String sqlValue = value.substring(0, value.indexOf("("));
				String key = value.substring(value.indexOf("("));

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
				System.out.println("\n Param :-" + params + "==" + sql);
			}

			/*
			 * Firstly split the parameters with comma,and then trim user_key
			 * and userId and manipulate according to our requirements and store
			 * it in a map.
			 */
			for (String checkString : params.split(",")) {

				if (map == null) {
					continue;
				}

				if (checkString.trim().equals("user_key")) {
					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					continue;
				}

				if (checkString.trim().equals("user_id")) {
					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					continue;
				}
				if (!params.isEmpty()) {
					if (map.get(checkString.trim()) != null) {
						String value = map.get(checkString.trim());

						if (value.toString().isEmpty()) {
							parameterList.add(null);
						} else {
							parameterList.add(value);
						}
					} else {
						parameterList.add(null);
					}
				}

			}

			/**
			 * To Print Parameters and stored Procedure which will be called
			 */
			System.out.println("parameter parameterList:- " + parameterList + ", requestedApi data:- " + sql);
			/*
			 * All the parameters are added in a list of objects.
			 */
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			if (sql != null) {

				Object object = null;
				Object downloadResponse = null;
				/*
				 * The condition check if parameters received from procedure are
				 * null or not and call it according to the coming input
				 */
				if (storedProcedureParameter == null) {
					if (clz != null) {
						object = genericService.executeProcesure(clz, sql);
					} else {
						object = genericService.executeProcesure(null, sql);
						System.out.println("Response " + object);
						if (map.get("report_api_url") != null && map.get("report_name") != null) {
							downloadResponse = downloadServices.DownloadGenericProcedureCalling(map, object);
						}
					}

				} else {
					if (clz != null) {
						object = genericService.executeProcesure(clz, sql, storedProcedureParameter);
					} else {
						object = genericService.executeProcesure(null, sql, storedProcedureParameter);
						System.out.println("Response " + object);
						if (map.get("report_api_url") != null && map.get("report_name") != null) {
							List<Object> list = new ArrayList<Object>(Arrays.asList(storedProcedureParameter));
							list.removeAll(Arrays.asList(map.get("report_api_url")));
							list.removeAll(Arrays.asList(map.get("report_name")));
							list.removeAll(Arrays.asList(map.get("timezone")));
							storedProcedureParameter = list.toArray(new String[list.size()]);
							downloadResponse = downloadServices.DownloadGenericProcedureCalling(map, object);
						}
					}
				}

				/**
				 * return success message
				 */
				if (downloadResponse != null) {
					return (Message) downloadResponse;
				}
				message.setObject(object);
				message.setValid(true);

				return message;
			} else {
				message.setDescription("Process Fail");
				message.setValid(false);
				return message;
			}

		}
		/*
		 * Catch Exception Block to handle all the exceptions occurring.
		 */
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * This method is used for getting data from the gFusion platform apis.
	 * 
	 * @param map : Here pass the map of body parameters.
	 * @param request : Here pass the header map for authenticating the request.
	 * @param methodName : Here pass the url of API to be called.
	 * @return Response of the API in the format of list of map.
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	public List<Map<String, String>> getPlatformData(Map<String, String> map, HttpServletRequest request,
			String methodName) {
		try {
			map.put("token", request.getHeader("token"));
			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));
			// passingMap.put("pivot_data_required", "1");

			/*
			 * Initialize Passing Query String to call platform API
			 */
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : map.keySet()) {
				// Retrieving the xFusion Platform Token
				headerMap.put("token", request.getHeader("token"));

				// To append rest of the parameters
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, map.get(key));

				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}
			}

			passingParameter.deleteCharAt(0);

			// Calling XfusionPlatform's API to get the data
			Object finalVehicleResponseMessage = urlCalling.getData(methodName, passingParameter.toString(), headerMap);

			if (finalVehicleResponseMessage != null) {
				/*
				 * Casting response in Generic Message format
				 */
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/*
				 * Getting response in formatted way
				 */
				GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				/*
				 * to get response in List of Map
				 */
				List<Map<String, String>> responseObject = urlMessage.getObject();

				/*
				 * to check if response is null
				 */
				if (responseObject != null) {
					/*
					 * returning response
					 */
					System.out.println("responseObject " + responseObject);
					return responseObject;
				}
			}
			/*
			 * if some error occurred in process it will return null
			 */
			return null;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
