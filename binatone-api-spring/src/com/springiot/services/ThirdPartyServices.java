/**
 * This package contain the Service class for Third Party Services Service to get all API with some manipulation and logic applied on api according to the user
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

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
@SuppressWarnings({ "unchecked", "serial" })
public class ThirdPartyServices {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private URLParameter urlParameter;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Service for the Api
	 * /service/inventory/status/device/get/many/without/data to merge service
	 * and inventory data from platform and send it in single list of map
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @return response Message
	 */
	public Message serviceInventory(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			// System.out.println("passing Map:- " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			LinkedHashMap<String, String> passingMapFinal = new LinkedHashMap<>();
			passingMapFinal.put("token", passingMap.get("token"));
			passingMapFinal.put("device_id", passingMap.get("device_id"));
			passingMapFinal.put("user_key", passingMap.get("user_key"));
			passingMapFinal.put("user_id", passingMap.get("user_id"));
			passingMapFinal.put("service_name", passingMap.get("service_name"));
			passingMapFinal.put("data_source", passingMap.get("data_source"));
			passingMapFinal.put("access_key", passingMap.get("access_key"));
			/**
			 * Printing the passing parameters
			 */
			// System.out.println("\n Passing Parameter" + passingMapFinal);
			/**
			 * to make query string to call platform api
			 */

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return (Message) responseMessage;
					}
					/*
					 * To append Token in query String
					 */
					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			// System.out.println(" \n Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(
					urlParameter.getXfusionServiceStatusDeviceGetManyWithoutData(), passingParameter.toString(),
					headerMap);
			/**
			 * Calling the Platform API's for inventory data
			 */
			Object urlResponseInventoryResult = urlCalling.getData(
					urlParameter.getXfusionInventoryStatusDeviceGetManyWithoutData(), passingParameter.toString(),
					headerMap);

			if (urlResponseServiceResult != null) {

				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);
				/**
				 * Casting response from platform of inventory API into json
				 */
				GenericMessages<Map<String, Object>> urlInventoryMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseInventoryResult.toString(), type);
				/**
				 * Printing both Service and inventory formatted data
				 */
				// System.out.println(
				// "\n urlServiceMessage" + urlServiceMessage +
				// "urlInventoryMessage" + urlInventoryMessage);
				/**
				 * to merge both response in formatted form
				 */
				List<Object> list = new ArrayList<>();
				/**
				 * Merging both responses in single list
				 */
				list.addAll(urlServiceMessage.getObject());
				list.addAll(urlInventoryMessage.getObject());
				/**
				 * Checking if both the responses are valid
				 */
				if (urlServiceMessage.isValid() && urlServiceMessage.isValid()) {
					/**
					 * Returning Response message with merged data of called
					 * apis
					 */
					responseMessage.setDescription("Get  Device  All Service Inventory Status");
					responseMessage.setObject(list);
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * if some error come in merging data or responses from
					 * called APIs
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(list);
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * Service for API /execute/command/tr069 to send command to device by
	 * calling platform API
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @return response Message
	 */
	public Message updateServiceInventoryCommand(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		Message urlMessage = new Message();
		try {

			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();

			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			/**
			 * to create Map to call API to get service and inventory data
			 */

			String deviceIds[] = passingMap.get("device_id").toString().split(",");
			String deviceNames[] = passingMap.get("device_name").toString().split(",");

			for (int i = 0; i < deviceIds.length; i++) {
				System.out.println(deviceIds.length);
				/*
				 * Initialize passingParameter for query string
				 */
				StringBuilder passingParameter = new StringBuilder();

				System.out.println(deviceIds[i] + "///" + deviceNames[i]);

				LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();

				finalPassingMap.put("token", passingMap.get("token"));
				finalPassingMap.put("device_id", deviceIds[i]);
				finalPassingMap.put("command_name", passingMap.get("command_name"));
				finalPassingMap.put("user_key", passingMap.get("user_key"));
				finalPassingMap.put("user_email", passingMap.get("user_id"));
				finalPassingMap.put("device_name", deviceNames[i]);
				finalPassingMap.put("access_key", passingMap.get("access_key"));
				finalPassingMap.put("data", passingMap.get("data"));

				// System.out.println("Final Passing map is- " +
				// finalPassingMap);

				/**
				 * To create Query String to call OAuth API
				 */
				Map<String, String> headerMap = new LinkedHashMap<>();
				for (String key : passingMap.keySet()) {

					if (key.trim().equals("token")) {
						/**
						 * TO get Platform Token
						 */
						String token = request.getHeader("token");
						/*
						 * Condition check on token if null or not
						 */
						if (token == null) {
							responseMessage.setDescription("Token is Null");
							responseMessage.setValid(false);
							return responseMessage;
						}
						/*
						 * To append Token in query String
						 */

						headerMap.put("token", token);

						continue;
					}
					/*
					 * To append rest Parameter
					 */
					if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
						headerMap.put(key, passingMap.get(key));

					} else {
						passingParameter.append("&" + key + "=" + passingMap.get(key));
					}

				}

				passingParameter.deleteCharAt(0);
				/**
				 * to print the query string
				 */
				// System.out.println("Send Data:- " + passingParameter);

				/**
				 * Calling the Platform API's for service data
				 */

				Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformDeviceExecuteCommand(),
						passingParameter.toString(), headerMap);

				/**
				 * Printing response from platform
				 */
				// System.out.println("result Object:- " + urlResponseResult);

				/**
				 * Checking if response is not null
				 */
				if (urlResponseResult != null) {
					urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
					/*
					 * Map<String, Object> mapResponse = new HashMap();
					 * mapResponse.put("device_id", deviceIds[i]);
					 * mapResponse.put("status", urlMessage.getDescription());
					 * listResult.add(mapResponse);
					 */
					/**
					 * Casting response from platform of API into json
					 */

					// Message urlMessage = (Message) new
					// Gson().fromJson(urlResponseResult.toString(),Message.class);
					/**
					 * Checking if the responses are valid
					 */
					/*
					 * if (urlMessage.isValid()) {
					 *//**
						 * Returning Response data of called api
						 */
					/*
					 * return urlMessage; } else {
					 *//**
						 * Returning Response data of called api
						 *//*
						 * return urlMessage; }
						 */
				}

			}

			responseMessage.setDescription(urlMessage.getDescription());
			// responseMessage.setObject(urlMessage);
			responseMessage.setValid(true);
			return responseMessage;
			// }

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * Service To get the Model,Category and Their Service and Data Source
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message deviceGetModelCategoryServicesDataSource(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			System.out.println("map" + map);

			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.putAll(map);

			System.out.println("passing map" + passingMap);
			/**
			 * To get Model Device Id
			 */
			String deviceModelId = getModelIdByDeviceId(passingMap, request, response);
			System.out.println("deviceModelId" + deviceModelId);
			/**
			 * To Print Device id of model
			 */
			// System.out.println("deviceModelId ===" + deviceModelId);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			Map<String, String> parameterDeviceMap = new HashMap<>();
			parameterDeviceMap.put("device_model_id", deviceModelId);
			// System.out.println("map is" + parameterDeviceMap);
			/*
			 * To check if device id is not null or empty
			 */
			if (!deviceModelId.isEmpty()) {

				/**
				 * Calling Stored Procedure to get response
				 */
				Message finalResponseMessage = genericProcess.GenericProcedureCalling("1", parameterDeviceMap, null,
						request, response);
				/**
				 * Returning response
				 */
				// System.out.println("final response is " +
				// finalResponseMessage);
				return finalResponseMessage;

			} else {
				/**
				 * Calling Stored Procedure to get response
				 */
				Message finalResponseMessage = genericProcess.GenericProcedureCalling("1", parameterDeviceMap, null,
						request, response);
				/**
				 * Returning response
				 */
				return finalResponseMessage;
			}

		} catch (Exception e) {
			/**
			 * To print Exception if any
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get Model Id by Device Id In Many api user just provide device id and
	 * to call procedure we need model id so to get model id we vall this medos
	 * and pass device id in this to get model id
	 * 
	 * @param passingMap
	 * @return device id
	 */
	private String getModelIdByDeviceId(LinkedHashMap<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		/*
		 * Initialize passingParameter for query string
		 */
		StringBuilder passingParameter = new StringBuilder();

		/**
		 * To create Query String to call OAuth API
		 */
		Map<String, String> headerMap = new LinkedHashMap<>();
		for (String key : passingMap.keySet()) {

			if (key.trim().equals("token")) {
				/**
				 * TO get Platform Token
				 */
				String token = request.getHeader("token");

				System.out.println("xfusion platform token" + token);

				/*
				 * Condition check on token if null or not
				 */
				if (token == null) {
					responseMessage.setDescription("Token is Null");
					responseMessage.setValid(false);
					return responseMessage.toString();
				}
				/*
				 * To append Token in query String
				 */

				headerMap.put("token", token);

				continue;
			}
			/*
			 * To append rest Parameter
			 */
			if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
				headerMap.put(key, passingMap.get(key));

			} else {
				passingParameter.append("&" + key + "=" + passingMap.get(key));
			}

		}

		System.out.println("headers map" + headerMap);

		passingParameter.deleteCharAt(0);
		/**
		 * to print the query string
		 */
		System.out.println("Send Data:- " + passingParameter);
		/**
		 * Calling the Platform API's for data
		 */
		Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformDeviceGetMetaData(),
				passingParameter.toString(), headerMap);
		/**
		 * Printing response from platform of API
		 */
		System.out.println("result Object:- " + urlResponseResult);
		/**
		 * Checking if response is null
		 */
		if (urlResponseResult != null) {

			Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
			}.getType();
			/**
			 * Casting response from platform of service API into json
			 */
			GenericMessages<Map<String, String>> urlMessage = (GenericMessages<Map<String, String>>) new Gson()
					.fromJson(urlResponseResult.toString(), type);
			/**
			 * Getting response from json in List Of Map
			 */
			List<Map<String, String>> deviceModelObject = urlMessage.getObject();
			/**
			 * Printing List Of Map data of response
			 */
			System.out.println("deviceModelId" + urlMessage.getObject());
			/**
			 * checking device_devicemodel_id of response is not null
			 */
			if (!(deviceModelObject.get(0).get("device_devicemodel_id") == null)) {
				/**
				 * Getting Model Id
				 */
				String deviceModelId = deviceModelObject.get(0).get("device_devicemodel_id").toString();
				/**
				 * Returning Model Id
				 */
				return deviceModelId;
			}

		}
		/**
		 * In case of any issue in process return null
		 */
		return null;
	}

	/**
	 * Service To Get the device Meta data
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message getXfusionMetaData(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize passingParameter for query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */

					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for to get XfusionPlatform Device Get
			 * Meta Data API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformDeviceGetMetaData(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			// System.out.println("result Object:- " + urlResponseResult);
			/**
			 * Check if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if both the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * Service to get Xfusion Get Info By user_key
	 * 
	 * @param map
	 *            contain parameter
	 * @param request
	 * @return
	 */
	public Message getXfusionGetInfoByUserKey(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.putAll(map);

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */

					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformThirdPartyIntegrationToken(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			// System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if both the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Add the model file
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message binatoneModelAddFile(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */

			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			passingMap.remove("file_name");
			/**
			 * to get model id
			 */
			String deviceModelId = getModelIdByDeviceId(passingMap, request, response);
			/**
			 * to print Model Id
			 */
			System.out.println("deviceModelId" + deviceModelId);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			Map<String, String> parameterDeviceMap = new HashMap<>();
			parameterDeviceMap.put("model_id", deviceModelId);
			parameterDeviceMap.put("file_name", map.get("file_name"));
			/**
			 * To Check If model is empty
			 */
			if (!deviceModelId.isEmpty()) {
				/**
				 * Calling Stored Procedure to get response
				 */
				Message finalResponseMessage = genericProcess.GenericProcedureCalling("6", parameterDeviceMap, null,
						request, response);
				/**
				 * return response
				 */
				return finalResponseMessage;

			} else {
				/**
				 * Calling Stored Procedure to get response
				 */
				Message finalResponseMessage = genericProcess.GenericProcedureCalling("6", parameterDeviceMap, null,
						request, response);
				/**
				 * return response
				 */
				return finalResponseMessage;
			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Get the device model file
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message binatoneModelGetFile(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/*
			 * To get Model Id
			 */
			String deviceModelId = getModelIdByDeviceId(passingMap, request, response);
			/*
			 * To print Model Id
			 */
			System.out.println("deviceModelId" + deviceModelId);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			Map<String, String> parameterDeviceMap = new HashMap<>();
			parameterDeviceMap.put("model_id", deviceModelId);

			if (!deviceModelId.isEmpty()) {
				/**
				 * Calling Stored Procedure to get response
				 */
				Message finalResponseMessage = genericProcess.GenericProcedureCalling("7", parameterDeviceMap, null,
						request, response);
				/**
				 * return response
				 */
				return finalResponseMessage;

			} else {
				/**
				 * Calling Stored Procedure to get response
				 */
				Message finalResponseMessage = genericProcess.GenericProcedureCalling("7", parameterDeviceMap, null,
						request, response);
				/**
				 * return response
				 */
				return finalResponseMessage;
			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Get Performance service status data of given device_id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message performanceDeviceGetAll(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize passingParameter for query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			System.out.println("passing map " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			finalPassingMap.put("token", passingMap.get("token"));
			finalPassingMap.put("device_id", passingMap.get("device_id"));
			finalPassingMap.put("user_key", passingMap.get("user_key"));
			finalPassingMap.put("user_id", passingMap.get("user_id"));
			finalPassingMap.put("access_key", passingMap.get("access_key"));

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */

					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for data
			 */

			System.out.println("!!!!!!!!" + urlParameter.getDeviceGetAll());

			Object urlResponseResult = urlCalling.getData(urlParameter.getDeviceGetAll(), passingParameter.toString(),
					headerMap);
			/**
			 * Printing response from platform of API
			 */
			System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To Get Performance Service Data of Single device data without Limit
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message singleLimitWithoutdata(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize passingParameter for query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();

			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			System.out.println("passing map " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			finalPassingMap.put("token", passingMap.get("token"));
			finalPassingMap.put("device_id", passingMap.get("device_id"));
			finalPassingMap.put("user_key", passingMap.get("user_key"));
			finalPassingMap.put("user_id", passingMap.get("user_id"));
			finalPassingMap.put("service_name", passingMap.get("service_name"));
			finalPassingMap.put("data_source", passingMap.get("data_source"));
			finalPassingMap.put("from_date", passingMap.get("from_date"));
			finalPassingMap.put("end_date", passingMap.get("end_date"));
			finalPassingMap.put("limit", passingMap.get("limit"));
			finalPassingMap.put("offset", passingMap.get("offset"));
			finalPassingMap.put("access_key", passingMap.get("access_key"));

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */

					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			System.out.println(" \n Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for data
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getSingleLimitWithoutData(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To Get the device's All model
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message DeviceModelGetAll(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize passingParameter for query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			System.out.println("passing map " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			finalPassingMap.put("token", passingMap.get("token"));
			finalPassingMap.put("user_key", passingMap.get("user_key"));
			finalPassingMap.put("user_id", passingMap.get("user_id"));

			/**
			 * to make query string to call platform api
			 */

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */
					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);

			/**
			 * to print the query string
			 */
			// System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for data
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformDeviceModelGetAll(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			// System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To Get the device file
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message deviceService(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			System.out.println("passing map " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			finalPassingMap.put("token", passingMap.get("token"));
			finalPassingMap.put("user_key", passingMap.get("user_key"));
			finalPassingMap.put("user_id", passingMap.get("user_id"));
			finalPassingMap.put("device_model", passingMap.get("device_model"));
			finalPassingMap.put("device_country", passingMap.get("device_country"));
			finalPassingMap.put("device_state", passingMap.get("device_state"));
			finalPassingMap.put("device_city", passingMap.get("device_city"));
			finalPassingMap.put("device_tags", passingMap.get("device_tags"));
			finalPassingMap.put("device_alias", passingMap.get("device_alias"));

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */

					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			// System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for data
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformDeviceSearch(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			// System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * This method is used to exceute profile command required for zero and one
	 * touch configuration.
	 * 
	 * @param map,contains
	 *            the input paramters specified by the user.
	 * @param request,
	 *            contains the request type(procedure number)
	 * @return response message
	 * 
	 * @author tanvigarg
	 */
	public Message executeProfileCommand(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			List<Map<String, Object>> commandResponseList = new LinkedList<>();
			/*
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			System.out.println("Passing MAP" + passingMap);

			/*
			 * Multiple input parameters are splitted by seperator comma, and
			 * then converted into repective arrays.
			 */
			String[] deviceIds = passingMap.get("device_id").split(",");
			String[] deviceName = passingMap.get("device_name").split(",");

			/*
			 * To check if call contains profile_type parameter
			 */
			if (passingMap.containsKey("profile_type")) {
				/*
				 * Parameter map to get model id of device
				 */
				LinkedHashMap<String, String> getDeviceModelMap = new LinkedHashMap<>();
				getDeviceModelMap.put("token", passingMap.get("token"));
				getDeviceModelMap.put("user_key", passingMap.get("user_key"));
				getDeviceModelMap.put("user_id", passingMap.get("user_id"));
				getDeviceModelMap.put("device_id", passingMap.get("device_id"));
				/*
				 * To check if profile_type is reset than proceed accordingly
				 */

				if (passingMap.get("profile_type").equalsIgnoreCase("RESET")) {
					/*
					 * checking id device_id is null
					 */
					if (passingMap.get("device_id").isEmpty()) {
						responseMessage.setDescription("device_id  is not their to execute command pass device_id ");
						responseMessage.setValid(false);
						return responseMessage;
					}

					/*
					 * To get model_id of device
					 */
					String deviceModelId = getModelIdByDeviceId(getDeviceModelMap, request, response);
					Map<String, String> parameterDeviceMap = new HashMap<>();
					parameterDeviceMap.put("model_id", deviceModelId);
					parameterDeviceMap.put("profile_type", passingMap.get("profile_type"));

					List<LinkedHashMap<String, Object>> parameterServiceDataSourceList = new LinkedList<>();
					if (!deviceModelId.isEmpty()) {
						/**
						 * Calling Stored Procedure to get response
						 */
						Message finalResponseMessage = genericProcess.GenericProcedureCalling("8", parameterDeviceMap,
								null, request, null);

						// The response retrieved from procedure is converted
						// into list<map>
						List<Map<String, Object>> serviceDatarouceListForCommand = (List<Map<String, Object>>) finalResponseMessage
								.getObject();

						/*
						 * [{profile_id=1, profile_name=Profile_RESET,
						 * model_id=2, profile_type=RESET, service_id=1,
						 * data_source_id=15, value_one_touch=, value_reset=,
						 * service_name=
						 * InternetGatewayDevice@LANDevice@1@WLANConfiguration@1,
						 * service_alias=WLAN Confriguration,
						 * servicedatasource_name=SSID,
						 * servicedatasource_alias=SSID, min_value=null,
						 * max_value=null, unit=null, is_editable=1,
						 * data_type=1, chart=1, colour=1, regex=null,
						 * formula=null, service_servicedatatypes_name=INT}]
						 */

						// ================================
						// Initialization of String Builder
						StringBuilder sevice_name = new StringBuilder();

						StringBuilder datasource_name = new StringBuilder();

						serviceDatarouceListForCommand.forEach((serviceDatarouceListMap) -> {
							sevice_name.append(serviceDatarouceListMap.get("service_name").toString() + ",");
							datasource_name
									.append(serviceDatarouceListMap.get("servicedatasource_name").toString() + ",");
						});
						sevice_name.deleteCharAt(sevice_name.lastIndexOf(","));
						datasource_name.deleteCharAt(datasource_name.lastIndexOf(","));

						// System.out.println("Service Names are :- " +
						// sevice_name.toString());
						// System.out.println("Data Source are :- " +
						// datasource_name.toString());

						for (int i = 0; i < deviceIds.length; i++) {
							/*
							 * Initialize passingParameter for query string
							 */
							StringBuilder passingParameter = new StringBuilder();
							LinkedHashMap<String, String> finalPlatformPassingMap = new LinkedHashMap<>();
							/*
							 * to create Map to call API to get response from
							 * platform
							 */
							finalPlatformPassingMap.put("token", passingMap.get("token"));
							finalPlatformPassingMap.put("device_id", deviceIds[i]);
							finalPlatformPassingMap.put("user_key", passingMap.get("user_key"));
							finalPlatformPassingMap.put("user_id", passingMap.get("user_id"));
							finalPlatformPassingMap.put("service_name", sevice_name.toString());
							finalPlatformPassingMap.put("data_source", datasource_name.toString());

							// System.out.println("Map is
							// finalPlatformPassingMap " +
							// finalPlatformPassingMap);

							/**
							 * To create Query String to call OAuth API
							 */
							Map<String, String> headerMap = new LinkedHashMap<>();
							for (String key : passingMap.keySet()) {

								if (key.trim().equals("token")) {
									/**
									 * TO get Platform Token
									 */
									String token = request.getHeader("token");
									/*
									 * Condition check on token if null or not
									 */
									if (token == null) {
										responseMessage.setDescription("Token is Null");
										responseMessage.setValid(false);
										return responseMessage;
									}
									/*
									 * To append Token in query String
									 */

									headerMap.put("token", token);

									continue;
								}
								/*
								 * To append rest Parameter
								 */
								if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
									headerMap.put(key, passingMap.get(key));

								} else {
									passingParameter.append("&" + key + "=" + passingMap.get(key));
								}

							}

							passingParameter.deleteCharAt(0);
							/*
							 * to print the query string
							 */
							// System.out.println("Send Data:- " +
							// passingParameter);
							/*
							 * Calling the Platform API's for data
							 */
							Object urlResponseResult = urlCalling.getData(
									urlParameter.getXfusionPlatformServicestatusDevicesGetMany(),
									passingParameter.toString(), headerMap);
							/*
							 * Printing response from platform of API
							 */
							// System.out.println("result Object:- " +
							// urlResponseResult);
							/*
							 * Checking if response is not null
							 */
							if (urlResponseResult != null) {
								/*
								 * Casting response from platform of service API
								 * into json
								 */
								Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(),
										Message.class);

								// The response retrieved from procedure is
								// converted into list<map>
								List<Map<String, Object>> platformDataToSetInCommand = (List<Map<String, Object>>) urlMessage
										.getObject();
								// System.out.println("Platform Response :- " +
								// platformDataToSetInCommand);
								// ================================

								for (int j = 0; j < serviceDatarouceListForCommand.size(); j++) {
									if (serviceDatarouceListForCommand.get(j).get("service_name").toString()
											.equalsIgnoreCase(
													platformDataToSetInCommand.get(j).get("service_name").toString())) {
										if (!serviceDatarouceListForCommand.get(j).get("service_name").toString()
												.isEmpty()
												&& !serviceDatarouceListForCommand.get(j).get("servicedatasource_name")
														.toString().isEmpty()) {
											LinkedHashMap<String, Object> parameterServiceDataSourceMap = new LinkedHashMap<>();

											String service_datasource = serviceDatarouceListForCommand.get(j)
													.get("service_name").toString().replaceAll("@", ".") + "."
													+ serviceDatarouceListForCommand.get(j)
															.get("servicedatasource_name").toString();

											// System.out.println("Data in
											// template " + service_datasource);
											int k = j + 1;
											String serviceDatasource = "service" + k + "-datasource" + k;
											String values = "value" + k;

											/*
											 * "service1-datasource1":
											 * "InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.SSID"
											 * ,"value1":"D-Link","type":
											 * "String"
											 */
											// parameterServiceDataSourceList.add(serviceDatasource);
											// parameterServiceDataSourceList.add(serviceDatasource);
											// parameterServiceDataSourceList.add(serviceDatasource);

											// System.out.println("Service data
											// source is" + serviceDatasource);
											parameterServiceDataSourceMap.put(serviceDatasource, service_datasource);
											parameterServiceDataSourceMap.put(values,
													platformDataToSetInCommand.get(j).get("current_value").toString());
											parameterServiceDataSourceMap.put("type", "String");

											// HashMap<String, Object>
											// responseMap = new
											// LinkedHashMap<>();
											// responseMap.putAll(parameterServiceDataSourceMap);

											// System.out.println("!!!!!!!!!!" +
											// parameterServiceDataSourceMap);
											parameterServiceDataSourceList.add(parameterServiceDataSourceMap);

										}
									}
								}

							}

							LinkedHashMap<String, Object> parameterServiceDataSourceMapProcess = new LinkedHashMap<>();

							for (LinkedHashMap<String, Object> mapProcess : parameterServiceDataSourceList) {
								parameterServiceDataSourceMapProcess.putAll(mapProcess);
							}

							parameterServiceDataSourceList.clear();

							System.gc();

							parameterServiceDataSourceList.add(parameterServiceDataSourceMapProcess);

							// Converts list data into json format to append in
							// platform API
							String dataJSON = new Gson().toJson(parameterServiceDataSourceList);
							// System.out.println("Data json will be :- " +
							// dataJSON);
							// Chek if parameterServiceDataSourceList is not
							// null
							if (parameterServiceDataSourceList != null) {
								Map<String, String> executeCommandMap = new LinkedHashMap<>();
								// Set the parameters to call ThirdParty API
								executeCommandMap.put("token", passingMap.get("token"));
								executeCommandMap.put("device_id", deviceIds[i]);
								executeCommandMap.put("command_name", passingMap.get("command_name"));
								executeCommandMap.put("user_key", passingMap.get("user_key"));
								executeCommandMap.put("user_email", passingMap.get("user_id"));
								executeCommandMap.put("device_name", deviceName[i]);
								executeCommandMap.put("access_key", passingMap.get("access_key"));
								executeCommandMap.put("data", dataJSON);

								// Get the response in message class
								Message message = updateServiceInventoryCommand(executeCommandMap, request);

								Map<String, Object> cammondResponse = new LinkedHashMap<>();
								// set the response message
								cammondResponse.put("device_id", deviceIds[i]);
								cammondResponse.put("status", message.getObject());
								commandResponseList.add(cammondResponse);
								/*
								 * Printing response from platform
								 */
								System.out.println("Command Response:- " + message);

							}

						}
						// Set the success message after calling API
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(commandResponseList);
						responseMessage.setValid(true);
						return responseMessage;

					}

				} else {
					// Initialization of list<map>
					List<Map<String, Object>> parameterServiceDataSourceList = new LinkedList<>();
					String deviceModelId = getModelIdByDeviceId(getDeviceModelMap, request, response);

					// Initialization of map
					Map<String, String> parameterDeviceMap = new HashMap<>();
					parameterDeviceMap.put("model_id", deviceModelId);
					parameterDeviceMap.put("profile_type", passingMap.get("profile_type"));
					/**
					 * Calling Stored Procedure to get response
					 */
					Message finalResponseMessage = genericProcess.GenericProcedureCalling("8", parameterDeviceMap, null,
							request, null);
					List<Map<String, Object>> serviceDatarouceListForCommand = (List<Map<String, Object>>) finalResponseMessage
							.getObject();

					for (int j = 0; j < serviceDatarouceListForCommand.size(); j++) {

						if (!serviceDatarouceListForCommand.get(j).get("service_name").toString().isEmpty()
								&& !serviceDatarouceListForCommand.get(j).get("servicedatasource_name").toString()
										.isEmpty()) {
							LinkedHashMap<String, Object> parameterServiceDataSourceMap = new LinkedHashMap<>();

							String service_datasource = serviceDatarouceListForCommand.get(j).get("service_name")
									.toString().replaceAll("@", ".") + "."
									+ serviceDatarouceListForCommand.get(j).get("servicedatasource_name").toString();

							System.out.println("Data in template " + service_datasource);
							int k = j + 1;
							String serviceDatasource = "service" + k + "-datasource" + k;
							String values = "value" + k;

							// System.out.println("Service data source is" +
							// serviceDatasource);
							parameterServiceDataSourceMap.put(serviceDatasource, service_datasource);
							parameterServiceDataSourceMap.put(values,
									serviceDatarouceListForCommand.get(j).get("value_one_touch").toString());
							parameterServiceDataSourceMap.put("type", "String");

							// System.out.println("!!!!!!!!!!" +
							// parameterServiceDataSourceMap);
							parameterServiceDataSourceList.add(parameterServiceDataSourceMap);

						}
					}

					LinkedHashMap<String, Object> parameterServiceDataSourceMapProcess = new LinkedHashMap<>();

					for (Map<String, Object> mapProcess : parameterServiceDataSourceList) {
						parameterServiceDataSourceMapProcess.putAll(mapProcess);
					}

					parameterServiceDataSourceList.clear();

					System.gc();

					parameterServiceDataSourceList.add(parameterServiceDataSourceMapProcess);

					// Converts list data into json format to append in platform
					// API
					String dataJSON = new Gson().toJson(parameterServiceDataSourceList);

					for (int j = 0; j < deviceIds.length; j++) {
						// Chek if parameterServiceDataSourceList is not null
						if (parameterServiceDataSourceList != null) {
							Map<String, String> executeCommandMap = new LinkedHashMap<>();
							// Set the parameters to call third party API
							executeCommandMap.put("token", passingMap.get("token"));
							executeCommandMap.put("device_id", deviceIds[j]);
							executeCommandMap.put("command_name", passingMap.get("command_name"));
							executeCommandMap.put("user_key", passingMap.get("user_key"));
							executeCommandMap.put("user_email", passingMap.get("user_id"));
							executeCommandMap.put("device_name", deviceName[j]);
							executeCommandMap.put("access_key", passingMap.get("access_key"));
							executeCommandMap.put("data", dataJSON);

							// Response is retrieved in message class after
							// calling third party API
							Message message = updateServiceInventoryCommand(executeCommandMap, request);

							Map<String, Object> cammondResponse = new LinkedHashMap<>();
							// set the response message
							cammondResponse.put("device_id", deviceIds[j]);
							cammondResponse.put("status", message.getDescription());
							// append the final data that needs to be displayed
							// in list
							commandResponseList.add(cammondResponse);

							System.out.println("result Object:- " + message);

						}
					}
					// Set the success message after calling API
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(commandResponseList);
					responseMessage.setValid(true);
					return responseMessage;
				}

			} else {
				// Set the failure response
				responseMessage.setDescription("Profile_name is not their to execute command pass profile_name ");
				responseMessage.setValid(false);
				return responseMessage;

			}
		} catch (

		Exception e)

		{
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	public Message DeviceGetTagsByModel(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			System.out.println("passing map " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			finalPassingMap.put("token", passingMap.get("token"));
			finalPassingMap.put("user_key", passingMap.get("user_key"));
			finalPassingMap.put("user_id", passingMap.get("user_id"));
			finalPassingMap.put("device_model", passingMap.get("device_model"));
			finalPassingMap.put("tags", passingMap.get("tags"));

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */
					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for data
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformDeviceGetTagsByModel(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	public Message ruleEngineDeviceGetByModel(Map<String, String> map, HttpServletRequest request) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize passing Map to store all the parameter from map to
			 * call platform's api
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			LinkedHashMap<String, String> finalPassingMap = new LinkedHashMap<>();
			/**
			 * Adding parameter to passingMap from header and map
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);
			/**
			 * To Print the passingMap
			 */
			// System.out.println("passing map " + passingMap);
			/**
			 * to create Map to call API to get service and inventory data
			 */
			finalPassingMap.put("token", passingMap.get("token"));
			finalPassingMap.put("user_key", passingMap.get("user_key"));
			finalPassingMap.put("user_id", passingMap.get("user_id"));
			finalPassingMap.put("device_model_id", passingMap.get("device_model_id"));

			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {

				if (key.trim().equals("token")) {
					/**
					 * TO get Platform Token
					 */
					String token = request.getHeader("token");
					/*
					 * Condition check on token if null or not
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * To append Token in query String
					 */

					headerMap.put("token", token);

					continue;
				}
				/*
				 * To append rest Parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}

			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			System.out.println("Send Data:- " + passingParameter);
			/**
			 * Calling the Platform API's for data
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformRuleEngineDeviceGetByModel(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing response from platform of API
			 */
			// System.out.println("result Object:- " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/**
				 * Casting response from platform of service API into json
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking if the responses are valid
				 */
				if (urlMessage.isValid()) {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				} else {
					/**
					 * Returning Response message
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
		}
		/**
		 * To return Error in response if something went wrong in process
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * This method is used to validate token from authorization engine respect
	 * to the persistent token.
	 * 
	 * @param parameterMap,the
	 *            map contains he input parameters required for the calling of
	 *            this procedure
	 * @param token_type,this
	 *            means that the token is for web or for mobile.
	 * @param request,the
	 *            http servlet request required for the headers.
	 * @param response,the
	 *            http servlet response required for the headers.
	 * @return responseMessage,the message class is returned as response.
	 */
	public Message validateToken(Map<String, String> parameterMap, Integer token_type, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();

		// Remove access key from the map.
		parameterMap.remove("access_key");

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		// Retrieve from where the request is coming to API
		String RequestType = request.getHeader("User-Agent");
		System.out.println("type" + RequestType);

		parameterMap.put("token_type", token_type.toString());

		try {
			// Initilaizing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : parameterMap.keySet()) {

				// Get the Authorization token
				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", parameterMap.get("user_key"));
					headerMap.put("user_id", parameterMap.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + parameterMap.get(key));
				}

			}
			passingParameter.delete(0, 1);

			/*
			 * Calling of Authorization Engine API and retrieve the results in
			 * Object urlResponseResult
			 */
			System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getValidateToken(), passingParameter.toString(),
					headerMap);

			System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

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
}
