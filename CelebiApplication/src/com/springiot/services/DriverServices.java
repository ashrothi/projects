/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

/**
 * To Import Classes to access their functionality
 */

/**
 * 
 * This class work as a Service class for Driver Controller contains all the
 * services of Drivers APi
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class DriverServices {
	@Autowired
	Environment environment;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private OAUTHTokenServices tokenServices;

	/**
	 * To create new driver and insert its detail
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
	@SuppressWarnings({ "unchecked" })
	public Message flintDriverCreate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			map.put("password", String.valueOf(environment.getProperty("driver.password")));
			map.put("password_question", String.valueOf(environment.getProperty("driver.password_question")));
			map.put("password_answer", String.valueOf(environment.getProperty("driver.password_answer")));
			map.put("is_approved", String.valueOf(environment.getProperty("driver.is_approved")));
			map.put("application_id", String.valueOf(environment.getProperty("driver.application.id")));
			map.put("role_id", String.valueOf(environment.getProperty("driver.role.id")));
			map.put("creation_date", String.valueOf(environment.getProperty("driver.creation_date")));
			map.put("is_permanent_address", String.valueOf(environment.getProperty("driver.is_permanent_address")));
			map.put("image_path", String.valueOf(environment.getProperty("driver.image_path")));
			map.put("thumbail_image_path", String.valueOf(environment.getProperty("driver.thumbail_image_path")));
			map.put("csv_attributes_id", String.valueOf(environment.getProperty("driver.csv_attributes_id")));
			map.put("csv_attributes_alias", String.valueOf(environment.getProperty("driver.csv_attributes_alias")));
			map.put("csv_attributes_value", String.valueOf(environment.getProperty("driver.csv_attributes_value")));

			Message message = tokenServices.UserCreate(map, request, response);
			/**
			 * to get customer_id and customer_key to add customer in ThihrdParty DB
			 */
			System.out.println(message.getObject());
			List<Map<String, Object>> UserCreateResponse = (List<Map<String, Object>>) message.getObject();
			if (UserCreateResponse.get(0).containsKey("isUserCreated")) {
				/**
				 * Adding parameter to add customer
				 */
				map.put("driver_id", UserCreateResponse.get(0).get("user_id").toString());
				map.put("driver_key", UserCreateResponse.get(0).get("userKey").toString());

				Message DriverResponsemessage = genericProcess.GenericProcedureCalling("65", map, null, request,
						response);
				if (DriverResponsemessage.isValid()) {
					List<Map<String, Object>> DriveResponsemessageList = (List<Map<String, Object>>) DriverResponsemessage
							.getObject();
					DriveResponsemessageList.get(0).putAll(UserCreateResponse.get(0));
					responseMessage.setDescription("Driver Added  Successfully");
					responseMessage.setObject(DriveResponsemessageList);
					responseMessage.setValid(true);
					return responseMessage;
				}

			} else {
				return message;
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

}
