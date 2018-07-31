/**
 * This package contain the Service class for All Third Party Application for Flint
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

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.response.Message;

/**
 * To Import Classes to access their functionality
 */

/**
 * 
 * This class work as a Service class for Customer Controller contains all the
 * services of Customers APui
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class CustomerServices {
	@Autowired
	Environment environment;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */

	@Autowired
	private OAUTHTokenServices tokenServices;
	@Autowired
	private GenericProcess genericProcess;
	/**
	 * Registeration of customer
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "serial", "unused" })

	public Message flintCustomerCreate(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * To create customer user in OAUTH and Map It into Platform
			 */

			map.put("password", String.valueOf(environment.getProperty("customer.password")));
			map.put("password_question", String.valueOf(environment.getProperty("customer.password_question")));
			map.put("password_answer", String.valueOf(environment.getProperty("customer.password_answer")));
			map.put("is_approved", String.valueOf(environment.getProperty("customer.is_approved")));
			map.put("application_id", String.valueOf(environment.getProperty("customer.application.id")));
			map.put("role_id", String.valueOf(environment.getProperty("customer.role.id")));
			map.put("creation_date", String.valueOf(environment.getProperty("customer.creation_date")));
			map.put("is_permanent_address", String.valueOf(environment.getProperty("customer.is_permanent_address")));
			map.put("image_path", String.valueOf(environment.getProperty("customer.image_path")));
			map.put("thumbail_image_path", String.valueOf(environment.getProperty("customer.thumbail_image_path")));
			map.put("csv_attributes_id", String.valueOf(environment.getProperty("customer.csv_attributes_id")));
			map.put("csv_attributes_alias", String.valueOf(environment.getProperty("customer.csv_attributes_alias")));
			map.put("csv_attributes_value", String.valueOf(environment.getProperty("customer.csv_attributes_value")));

			Message message = tokenServices.UserCreate(map, request, response);
			// to check if the user created successfully
			if (message.isValid()) {
				/**
				 * to get customer_id and customer_key to add customer in ThihrdParty DB
				 */
				Map<String, Object> UserCreateResponse = (Map<String, Object>) message.getObject();
				if (UserCreateResponse.containsKey("isUserCreated")) {
					/**
					 * Adding parameter to add customer
					 */
					map.put("customer_id", UserCreateResponse.get("user_id").toString());
					map.put("customer_key", UserCreateResponse.get("user_key").toString());
					/**
					 * Calling Generic Procedure to add Customer
					 */
					Message CustomerResponsemessage = genericProcess.GenericProcedureCalling("77", map, null, request,
							response);
					/**
					 * if response is valid
					 */
					if (CustomerResponsemessage.isValid()) {
						List<Map<String, Object>> CustomerResponsemessageList = (List<Map<String, Object>>) CustomerResponsemessage
								.getObject();

						/**
						 * if response from procedure is null
						 */
						if (CustomerResponsemessageList.size() > 0) {
							if (map.get("consignee_detail") != null) {
								/*
								 * Casting data in List<Map<String, String>> format
								 */
								Type type = new TypeToken<List<Map<String, String>>>() {
								}.getType();
								/*
								 * To get consignee data which need to be update
								 */
								String consigneeDataToUpdate = map.get("consignee_detail").toString();

								/*
								 * To get data in formatted form
								 */

								List<Map<String, String>> consigneeDataList = new Gson().fromJson(consigneeDataToUpdate,
										type);
								for (Map<String, String> map2 : consigneeDataList) {
									map2.put("customer_id",
											CustomerResponsemessageList.get(0).get("customer_id").toString());
									Message consigneeResponsemessage = genericProcess.GenericProcedureCalling("76",
											map2, null, request, response);
								}

								CustomerResponsemessageList.get(0).putAll(UserCreateResponse);
								responseMessage.setDescription("Customer Added  Successfully");
								responseMessage.setObject(CustomerResponsemessageList);
								responseMessage.setValid(true);
								return responseMessage;
							}
						} else {
							/**
							 * if response is null
							 */
							responseMessage.setDescription("Error in Response from Adding Customer in ThirdParty");
							responseMessage.setValid(false);
							return responseMessage;
						}
					} else {
						/**
						 * Error in adding customer
						 */
						responseMessage.setDescription("Error in Adding Customer in ThirdParty");
						responseMessage.setValid(false);
						return responseMessage;
					}

				} else {
					/**
					 * Error in adding customer user
					 */
					responseMessage.setDescription("Error in Adding Customer user ");
					responseMessage.setObject(message.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}

			} else {
				/**
				 * Error in creating customer user
				 */
				responseMessage.setDescription("Error in Creating Customer user");
				responseMessage.setObject(message);
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/**
			 * If exception occur
			 */
			e.printStackTrace();
			throw e;

		}
		return responseMessage;
	}

	/**
	 * To get all the Driver information.
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
	 * @throws Exception
	 */
	public Message flintGetCustomer(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("81", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			} else {
				/*
				 * Response Message of API when some errors occurred in API.
				 */
				responseMessage.setDescription("Not Get Any Data");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			/*
			 * Response Message of API when some errors occurred in API.
			 */
			responseMessage.setDescription("ERROR:- " + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	@SuppressWarnings({ "unchecked", "serial" })
	public Message flintCustomerUpdate(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * To update customer user in OAUTH and Map It into Platform
			 */

			List<Object> consigneeResponsemessageList = new LinkedList<>();
			/**
			 * Calling Generic Procedure to add Customer
			 */
			Message CustomerResponsemessage = genericProcess.GenericProcedureCalling("80", map, null, request,
					response);
			/**
			 * if response is valid
			 */
			if (CustomerResponsemessage.isValid()) {
				List<Map<String, Object>> CustomerResponsemessageList = (List<Map<String, Object>>) CustomerResponsemessage
						.getObject();

				/**
				 * if response from procedure is null
				 */
				if (CustomerResponsemessageList.size() > 0) {
					if (map.get("consignee_detail") != null) {
						/*
						 * Casting data in List<Map<String, String>> format
						 */
						Type type = new TypeToken<List<Map<String, String>>>() {
						}.getType();
						/*
						 * To get consignee data which need to be update
						 */
						String consigneeDataToUpdate = map.get("consignee_detail").toString();

						/*
						 * To get data in formatted form
						 */

						List<Map<String, String>> consigneeDataList = new Gson().fromJson(consigneeDataToUpdate, type);
						for (Map<String, String> map2 : consigneeDataList) {

							Message consigneeResponsemessage = genericProcess.GenericProcedureCalling("79", map2, null,
									request, response);
							if (consigneeResponsemessage.isValid()) {
								consigneeResponsemessageList.add(consigneeResponsemessage.getObject());
							}
						}

						CustomerResponsemessageList.get(0).put("consigneeResponsemessageList",
								consigneeResponsemessageList);
						responseMessage.setDescription("Customer Updating  Successfully");
						responseMessage.setObject(CustomerResponsemessageList);
						responseMessage.setValid(true);
						return responseMessage;
					}
				} else {
					/**
					 * if response is null
					 */
					responseMessage.setDescription("Error in Response from Updating Customer in ThirdParty");
					responseMessage.setValid(false);
					return responseMessage;
				}
			} else {
				/**
				 * Error in adding customer
				 */
				responseMessage.setDescription("Error in Updating Customer in ThirdParty");
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/**
			 * If exception occur
			 */
			e.printStackTrace();
			/*
			 * Response Message of API when some errors occurred in API.
			 */
			responseMessage.setDescription("ERROR:- " + e.getMessage());
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

	public Message flintGetCustomerSearch(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("89", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			}

		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			/*
			 * Response Message of API when some errors occurred in API.
			 */
			responseMessage.setDescription("ERROR:- " + e.getMessage());
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

	public Message flintGetConsigneeConsignerSearch(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {

			/*
			 * Adding some parameters to the map.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			/*
			 * Calling stored procedure api to call the data in Message response format
			 */
			Message finalProductResponseMessage = genericProcess.GenericProcedureCalling("91", passingMap, null,
					request, response);
			/*
			 * to check if response is valid
			 */
			if (finalProductResponseMessage.isValid()) {
				/*
				 * Response Message from API when role_name is broker.
				 */

				return finalProductResponseMessage;
			}

		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			/*
			 * Response Message of API when some errors occurred in API.
			 */
			responseMessage.setDescription("ERROR:- " + e.getMessage());
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
