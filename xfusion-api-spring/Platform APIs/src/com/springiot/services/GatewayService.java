/**
 * This package contains the class which is used for Gateway data processing.
 */
package com.springiot.services;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.springiot.response.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class is used when gateway interacts with xFusion Platform,it inserts and
 * updates Parameters to the xFusion dB.
 * 
 * @author tanvigarg
 */
@Service
public class GatewayService {
	/**
	 * To access functionality of Generic Service.
	 */

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Method for the registration of device.
	 * 
	 * @param map,
	 *            Contains the parameter map. @return, Return the response
	 *            message.
	 */
	@SuppressWarnings("unchecked")
	public Message deviceRegister(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Create the object of class Message.
		 */
		Message responseMessage = new Message();

		try {
			/*
			 * Call the method to execute the procedure of metadata procedures.
			 */

			// map.put("user_id", request.getHeader("user_id"));
			// map.put("user_key", request.getHeader("user_key"));

			Message organization_id = genericProcess.GenericProcedureCallingMetaData("24", map, request, response);
			/*
			 * Create the list of map which stores the organization id.
			 */
			List<Map<String, Object>> list_device = (List<Map<String, Object>>) organization_id.getObject();

			String organizationIdFromProcedure = "";

			if (list_device.size() > 0) {
				Map<String, Object> device_organization = list_device.get(0);
				/*
				 * Check if organization id in map is not null.
				 */
				if (device_organization.get("organization_id") != null) {
					/*
					 * If organization id is not null, then get the id and store
					 * it.
					 */
					organizationIdFromProcedure = device_organization.get("organization_id").toString();

				}
			}

			if (organizationIdFromProcedure != null) {

				map.put("organization_id", organizationIdFromProcedure);

				Message device_parameters = genericProcess.GenericProcedureCallingConfig("6", map, request, response);
				/*
				 * Set the response message.
				 */
				responseMessage.setDescription("Successfull");
				responseMessage.setObject(device_parameters.getObject());
				responseMessage.setValid(true);
				/*
				 * Return the response message.
				 */
				return responseMessage;

			}
		} catch (Exception exception) {
			/*
			 * Set the response message.
			 */
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);
			/*
			 * Return the response message.
			 */
			return responseMessage;
		}

		/*
		 * Set the response message.
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		/*
		 * Return the response message.
		 */
		return responseMessage;
	}
}