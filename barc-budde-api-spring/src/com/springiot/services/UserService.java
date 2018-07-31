/**
 * This package contain the Service class for Third Party Services Service to get all API with some manipulation and logic applied on api according to the user
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@PropertySource(value = "classpath:/UserCreate.properties")
@SuppressWarnings({ "serial", "unchecked" })
public class UserService {
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	Environment environment;
	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Service To Create User
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

	public Message UserCreate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */

			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("username", map.get("email"));
			passingMap.putAll(map);

			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserCreate(), queryString, headerMap);
			/*
			 * Printing response
			 */
			System.out.println("urlResponseResult " + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				/*
				 * Checking if response is valid or not
				 */
				// System.out.println("urlMessage:-" + urlMessage.getObject());

				if (urlMessage.isValid()) {
					List<Map<String, Object>> userCreateResponse = (List<Map<String, Object>>) urlMessage.getObject();

					// System.out.println("userCreateResponse " +
					// userCreateResponse
					// +
					// String.valueOf(userCreateResponse.get(0).get("code")).equalsIgnoreCase("13.0"));
					if (String.valueOf(userCreateResponse.get(0).get("code")).equalsIgnoreCase("13.0")) {

						LinkedHashMap<String, String> newPassingMap = new LinkedHashMap<>();
						newPassingMap.put("is_password_expire",
								String.valueOf(environment.getProperty("is.password.expire")));
						newPassingMap.put("password_expire_time",
								String.valueOf(environment.getProperty("password.expire.time")));
						newPassingMap.put("session_expire_time",
								String.valueOf(environment.getProperty("session.expire.time")));
						newPassingMap.put("is_session_enable",
								String.valueOf(environment.getProperty("is.session.enable")));
						newPassingMap.put("is_single_sign_on_enable",
								String.valueOf(environment.getProperty("is.single.sign.on.enable")));
						newPassingMap.put("user_list", String.valueOf(userCreateResponse.get(0).get("userKey")));
						Map<String, Object> queryStringMAp1 = genericProcess.getOAuthQuery(newPassingMap, request,
								response);
						String queryString1 = queryStringMAp1.get("passingString").toString();

						headerMap.put("user_key", String.valueOf(userCreateResponse.get(0).get("userKey")));
						headerMap.put("user_id", String.valueOf(userCreateResponse.get(0).get("user_id")));

						Object urlResponse = urlCalling.getData(urlParameter.getAuthSessionconfigure(), queryString1,
								headerMap);

						Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
						}.getType();

						System.out.println("urlResponse getAuthSessionconfigure::: " + urlResponse);
						// Convert the response retrieved after calling api is
						// stored //
						// into Map

						GenericMessages<Map<String, Object>> urlMessage1 = (GenericMessages<Map<String, Object>>) new Gson()
								.fromJson(urlResponse.toString(), type);

						List<Map<String, Object>> oauthResponse = urlMessage1.getObject();

						// Check if list of objects is not null and size greater
						// then zero
						if (oauthResponse.get(0).get("status").toString().equalsIgnoreCase("1.0")) {
							map.put("new_user_key", String.valueOf(userCreateResponse.get(0).get("userKey")));
							map.put("new_user_id", String.valueOf(userCreateResponse.get(0).get("user_id")));
							Message userCreate = genericProcess.GenericProcedureCalling("15", map, null, request,
									response);

							// System.out.println("userCreate " + userCreate);
							if (userCreate.isValid()) {
								return userCreate;

							} else {
								responseMessage.setDescription("Process fail");
								responseMessage.setObject(userCreate.getObject());
								responseMessage.setValid(false);
								return responseMessage;
							}
						}
					} else {
						return urlMessage;
					}

				}

				else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To update basic information of user.
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
	public Message UserUpdate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.putAll(map);
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserUpdate(), queryString, headerMap);
			/*
			 * Printing response
			 */
			// System.out.println(urlResponseResult);
			/*
			 * Checking if response is not null
			 */

			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				// System.out.println("urlResponseResult:-" +
				// urlResponseResult);
				if (urlMessage.isValid()) {

					Message userUpdate = genericProcess.GenericProcedureCalling("14", map, null, request, response);
					if (userUpdate.isValid()) {
						return userUpdate;

					} else {
						responseMessage.setDescription("Process fail");
						responseMessage.setObject(userUpdate.getObject());
						responseMessage.setValid(false);
						return responseMessage;
					}

				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To delete the user.
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
	public Message UserDelete(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.putAll(map);
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserDelete(), queryString, headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {

					Message userUpdate = genericProcess.GenericProcedureCalling("24", map, null, request, response);
					if (userUpdate.isValid()) {
						return userUpdate;

					} else {
						responseMessage.setDescription("Process fail");
						responseMessage.setObject(userUpdate.getObject());
						responseMessage.setValid(false);
						return responseMessage;
					}

				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * Service to Returns all the user and their details from all the
	 * application in which given user is present
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
	public Message UserGetALL(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {

			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.putAll(map);

			System.out.println(passingMap);
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserGetAll(), queryString, headerMap);

			System.out.println("urlResponseResult " + urlResponseResult);

			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */

				// System.out.println();
				List<Map<String, Object>> thirdPartyUserFinalList = new LinkedList<>();
				if (urlMessage.isValid()) {
					List<Map<String, Object>> userOauthList = (List<Map<String, Object>>) urlMessage.getObject();
					// System.out.println("userOauthList:- " + userOauthList);
					/*
					 * Response Message from API
					 */
					Message message = genericProcess.GenericProcedureCalling("17", map, null, request, response);

					if (message.isValid()) {
						List<Map<String, Object>> thirdPartyUserList = (List<Map<String, Object>>) message.getObject();
						for (Map<String, Object> thirdPartyUserMap : thirdPartyUserList) {
							for (Map<String, Object> userOauthMap : userOauthList) {

								if (String.valueOf(thirdPartyUserMap.get("user_id"))
										.equalsIgnoreCase(String.valueOf(userOauthMap.get("membership_email")))) {

									System.out.println();
									thirdPartyUserMap.putAll(userOauthMap);

								}
							}
							thirdPartyUserFinalList.add(thirdPartyUserMap);
						}
						System.out.println("thirdPartyUserFinalList " + thirdPartyUserFinalList);
						responseMessage.setDescription("Process Sucess");
						responseMessage.setObject(thirdPartyUserFinalList);
						responseMessage.setValid(true);
						return responseMessage;

					}

				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}

			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {

			e.printStackTrace();

			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}
}
