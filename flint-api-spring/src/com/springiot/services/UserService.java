package com.springiot.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

/**
 * @author Pooja Singh
 * @since 24-may-2018
 * @version 1.0
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
@SuppressWarnings({"unchecked"})
public class UserService {

	@Autowired
	private OAUTHTokenServices tokenServices;

	@Autowired
	private GenericProcess genericProcess;

	public Message flintCreateUser(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = new Message();
		try {
			/**
			 * To create customer user in OAUTH and Map It into Platform
			 */

			Message message = tokenServices.UserCreate(map, request, response);
			// to check if the user created successfully
			if (message.isValid()) {
				/**
				 * to get customer_id and customer_key to add customer in ThihrdParty DB
				 */
				Map<String, Object> UserCreateResponse = (Map<String, Object>) message.getObject();
				if (UserCreateResponse.containsKey("isUserCreated")) {

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
							CustomerResponsemessageList.get(0).putAll(UserCreateResponse);
							responseMessage.setDescription("user Added  Successfully");
							responseMessage.setObject(CustomerResponsemessageList);
							responseMessage.setValid(true);
						}
					} else {
						/**
						 * Error in adding customer user
						 */
						responseMessage.setDescription("Error in Adding user ");
						responseMessage.setObject(message.getObject());
						responseMessage.setValid(false);
						return responseMessage;
					}

				}
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
