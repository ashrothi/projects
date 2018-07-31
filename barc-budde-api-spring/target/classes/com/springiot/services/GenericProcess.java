/**
 * This package contain the Service class for Generic Process for API Calling to call Procedure and retrieve their data
 */
package com.springiot.services;

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
import com.springiot.constant.ProcessParameter;
import com.springiot.filter.ServerSideFiltering;
import com.springiot.genericService.GenericService;
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
			HttpServletRequest request, HttpServletResponse response) {
		/**
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			// Instantiate the server filtering class
			ServerSideFiltering filter = new ServerSideFiltering();
			// Message urlValidate = validateURL(request, response);
			// if (!urlValidate.isValid()) {
			// return urlValidate;
			// }
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
				if (checkString.equalsIgnoreCase("condition")) {
					// Check map parameters is not null and should not be empty
					if (map.get(checkString) != null && !map.get(checkString).isEmpty()) {

						parameterList.add(filter.filterData(map.get(checkString.trim()).toString()));

						continue;
					}
					// If parameter in_condition is empty or null

					/*
					 * else { parameterList.add(null); System.out.println(
					 * "Parameter List :" + parameterList.toString()); continue;
					 * }
					 */

				}
				// System.out.println("checkString" + checkString);
				if (map == null) {
					continue;
				}

				if (checkString.trim().equals("user_key")) {
					// System.out.println("user_key" +
					// request.getAttribute(checkString));
					parameterList
							.add(request.getAttribute(checkString) != null ? request.getAttribute(checkString) : null);
					continue;
				}

				if (checkString.trim().equals("user_id")) {
					parameterList
							.add(request.getAttribute(checkString) != null ? request.getAttribute(checkString) : null);
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
			
			/*
			 * All the parameters are added in a list of objects.
			 */
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}
			System.out
			.println("parameter parameterList:- " + parameterList.toString() + ", requestedApi data:- " + sql);

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
				 * 
				 * return success message
				 */
				if (downloadResponse != null) {

					return (Message) downloadResponse;
				}

				responseMessage.setObject(object);
				responseMessage.setValid(true);

				return responseMessage;

			}

		} catch (Exception e) {
			/**
			 * 
			 * return error message
			 */
			e.printStackTrace();

			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		/**
		 * Return Error Message when issue with parameter or program issue
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);

		return responseMessage;
	}

	// /**
	// * This method is used to check the validation of user on the basis of
	// token
	// * and user key.
	// *
	// * @param map,
	// * Contains all the parameters passed during calling of API
	// * @param urlKey,
	// * Contains the user key
	// * @return Message, Return the response message.
	// */
	// public Message validateURL(HttpServletRequest request,
	// HttpServletResponse response) {
	// /**
	// * To Initialize the response Message
	// */
	// Message message = new Message();
	//
	// try {
	// /**
	// * to get API URL
	// */
	// String URIPatter = request.getRequestURI().substring(1);
	// Map<String, String> headerMap = new LinkedHashMap<>();
	//
	// String URI = URIPatter.substring(URIPatter.indexOf("/"));
	// /*
	// * default value of valid
	// */
	// Boolean valid = false;
	// System.out.println("URI " + URI);
	// if (URI.equalsIgnoreCase("/oauth/token")) {
	// headerMap.put("token", String.valueOf(request.getAttribute("token")));
	// headerMap.put("user_key",
	// String.valueOf(request.getAttribute("user_key")));
	// headerMap.put("user_id",
	// String.valueOf(request.getAttribute("user_id")));
	// // message.setDescription("Process Success");
	// // message.setObject(valid);
	// // message.setValid(true);
	// // return message;
	// }
	// /**
	// * If Access url map is empty than get url permission from auth
	// *
	// */
	// if (Constant.accessmap.get(request.getAttribute("access_key")) == null) {
	// /**
	// * to get role_id
	// */
	// String roleId = String.valueOf(request.getAttribute("role_id"));
	// // System.out.println("roleId" + roleId +
	// // request.getAttribute("user_id").toString()
	// // + request.getAttribute("user_key").toString());
	//
	// String getPermissionParam = "role_id=" + roleId;
	//
	// // Get the Authorization Engine token
	// headerMap.put("token", String.valueOf(request.getHeader("token")));
	// headerMap.put("user_key",
	// String.valueOf(request.getAttribute("user_key")));
	// headerMap.put("user_id",
	// String.valueOf(request.getAttribute("user_id")));
	// /**
	// * get API permissions url from auth
	// */
	// Object accessPermision =
	// urlCalling.getData(urlParameter.getGetAllPermisions(),
	// getPermissionParam,
	// headerMap);
	// /**
	// * check response from auth
	// */
	// if (accessPermision != null) {
	// Constant.accessmap.put(request.getAttribute("access_key").toString(),
	// accessPermision);
	//
	// }
	//
	// }
	// /**
	// * checking if url is valid
	// */
	// if
	// (Constant.accessmap.get(request.getAttribute("access_key")).toString().contains("\""
	// + URI + "\"")) {
	// valid = true;
	// }
	// /**
	// * Success response
	// */
	// if (valid) {
	// message.setDescription("Process Success");
	// message.setObject(valid);
	// message.setValid(true);
	// } else {
	// /**
	// * Error Response
	// */
	// List<Map<String, Object>> responseMapList = new ArrayList<>();
	// Map<String, Object> responseMap = new HashMap<>();
	// responseMap.put("msg", "you don't have permission to access this api");
	// responseMap.put("url_status", false);
	// responseMap.put("code", 28);
	// responseMapList.add(responseMap);
	// message.setDescription("Process Success");
	// message.setObject(responseMapList);
	// message.setValid(false);
	// }
	//
	// return message;
	//
	// } catch (Exception exception) {
	// // Set the failure response
	// exception.printStackTrace();
	// message.setDescription(exception.getMessage());
	// message.setValid(false);
	// return message;
	// }
	// }

	Map<String, Object> getOAuthQuery(LinkedHashMap<String, String> passingMap, HttpServletRequest request,
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
		for (String key : passingMap.keySet()) {

			/*
			 * To append Token in query String
			 */
			// passingParameter.append("token=" + token.getAccess_token());
			headerMap.put("token", request.getHeader("token"));
			headerMap.put("user_key", String.valueOf(request.getAttribute("user_key")));
			headerMap.put("user_id", String.valueOf(request.getAttribute("user_id")));
			/*
			 * 
			 * /* To append rest Parameter
			 */
			if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
				headerMap.put(key, String.valueOf(request.getAttribute(key)));

			} else {
				passingParameter.append("&" + key + "=" + passingMap.get(key));
			}

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
