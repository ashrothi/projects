/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for Platform's API and ThirdParty
 * Integration with platform
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class XFusionService {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	Environment environment;

	/**
	 * Services To get all Country Code
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
	public Message xfusionOrganizationCountryGet(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token from header
			 */
			passingMap.put("token", request.getHeader("token"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.putAll(map);
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationCountryGet(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Map<String, Object> getPlatformQuery(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		new Message();
		/*
		 * Initialize string builder to make parameter string to pass in calling API
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
			/*
			 * 
			 * /* To append rest Parameter
			 */
			if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
				headerMap.put(key, passingMap.get(key));

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

	/**
	 * To get all Organization
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
	@SuppressWarnings("unchecked")
	public Message xfusionOrganizationGetAll(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationGetAll(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {

					Message message = genericProcess.GenericProcedureCalling("110", map, null, request, response);

					/*
					 * to get response in List of Map
					 */
					List<Map<String, Object>> userOrgObject = (List<Map<String, Object>>) urlMessage.getObject();
					List<Map<String, Object>> userOrgThirdPartyObject = (List<Map<String, Object>>) message.getObject();

					System.out.println("userOrgObject" + userOrgObject);
					System.out.println("userOrgThirdPartyObject" + userOrgThirdPartyObject);
					for (Map<String, Object> map2 : userOrgThirdPartyObject) {
						for (Map<String, Object> map21 : userOrgObject) {

							if (map2.get("name").toString()
									.equalsIgnoreCase(map21.get("organization_organization_name").toString())) {
								map21.putAll(map2);
							}

						}
					}

					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(userOrgObject);
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To get all State by Country Code
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
	public Message xfusionOrganizationStateGet(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.put("country_id", map.get("country_id"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationStateGet(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get all City by State Code
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
	public Message xfusionOrganizationCityGet(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.put("state_id", map.get("state_id"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */

			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationCityGet(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Insert New Organization
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
	@SuppressWarnings({ "unused", "unchecked" })
	public Message xfusionOrganizationInsert(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.put("parent_organization", map.get("parent_organization"));
			passingMap.put("organization_name", map.get("organization_name"));
			passingMap.put("city", map.get("in_city"));
			passingMap.put("country", map.get("in_country"));
			passingMap.put("description", map.get("description"));
			passingMap.put("color_code", map.get("color_code"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationInsert(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */

					List<Map<String, Object>> resultfromPlatform = (List<Map<String, Object>>) urlMessage.getObject();
					map.put("organization_id", String.valueOf(resultfromPlatform.get(0).get("organization_id")));
					Message message = genericProcess.GenericProcedureCalling("107", map, null, request, response);
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Update New Organization
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
	@SuppressWarnings("unused")
	public Message xfusionOrganizationUpdate(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.put("organization_id", map.get("organization_id"));
			passingMap.put("organization_name", map.get("organization_name"));
			passingMap.put("organization_alias", map.get("organization_alias"));
			passingMap.put("organization_city", map.get("organization_city"));
			passingMap.put("description", map.get("description"));
			passingMap.put("country_id", map.get("country_id"));
			passingMap.put("color_code", map.get("color_code"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationUpdate(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					Message message = genericProcess.GenericProcedureCalling("105", map, null, request, response);
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Delete Organization
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
	@SuppressWarnings("unused")
	public Message xfusionOrganizationDelete(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.put("organization_id", map.get("organization_id"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionOrganizationDelete(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					Message message = genericProcess.GenericProcedureCalling("104", map, null, request, response);
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message xfusionOrganizationUsersList(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/*
			 * Adding rest of the parameter from map
			 */
			passingMap.put("application_key", map.get("application_key"));
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformGetUserList(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message xfusionGetOrganizationByUser(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformGetOrganizationByUser(),
					queryString, headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message xfusionGetUserList(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Platform API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			/*
			 * Adding Token and other parameter from header from header
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", "dcfb5f5f-588e-11e6-85b9-fe984cc15272");
			passingMap.put("user_id", "preeti.burad@teramatrix.co");
			passingMap.put("application_key", String.valueOf(environment.getProperty("application.key")));

			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = getPlatformQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();
			@SuppressWarnings("unchecked")
			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			/*
			 * Printing query string
			 */

			/*
			 * Calling Platform API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getXfusionPlatformGetUserList(), queryString,
					headerMap);
			/**
			 * Printing Response
			 */

			/*
			 * Checkinf if response is not nul
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				} else {
					/*
					 * Response Message from API
					 */
					return urlMessage;
				}

			}

		} catch (Exception e) {
			/*
			 * Handling the occurring exceptions.
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Not Get Any Data");
		responseMessage.setValid(false);
		return responseMessage;
	}
}