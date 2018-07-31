/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This service class is used to call the related procedure from database for
 * Particular API and used when data is required in chunks while calling APi
 * 
 * @author tanvigarg
 */
@Service
public class ProcessServices {
	/**
	 * To access the following service class method.
	 */
	@Autowired
	private ProcessParameter processParameter;
	/**
	 * To access the following service class method.
	 */
	@Autowired
	private GenericService genericService;

	/**
	 * This method is used for updating multiple(bulk) APi's which makes API
	 * response slow.For optimization,we need to break the input parameters in
	 * API sent by user for fast response retrieval.
	 * 
	 * @param map,
	 *            The input parameters specified by user
	 * @return message, The response message of API.
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public Message apiUpdateMultiple(Map<String, String> map) throws Exception {

		// Initializing the Message class
		Message message = new Message();

		// Initializing the String Builder
		StringBuilder apiId = new StringBuilder();
		StringBuilder apiName = new StringBuilder();
		StringBuilder apiUrl = new StringBuilder();
		StringBuilder isAdded = new StringBuilder();

		// Retrieval of specific values from map on the basis of key
		String apiIdMap = map.get("api_id").toString();
		String apiNameMap = map.get("api_name").toString();
		String apiUrlMap = map.get("url").toString();
		String isAddedMap = map.get("is_added").toString();

		// Arrays are created while dividing the data for input Parameters
		String apiIdArray[] = apiIdMap.split(",");
		String apiNameArray[] = apiNameMap.split(",");
		String apiUrlArray[] = apiUrlMap.split(",");
		String isAddedArray[] = isAddedMap.split(",");

		// Map is used to get all the procedures
		Map<String, Object> procedureMap = processParameter.getMaps();

		// Initializing the variable
		String sql = null;

		// Check if map contains particular procedure number
		if (procedureMap.get("44") != null) {
			sql = procedureMap.get("44").toString();
		}

		// Response Message when sql is null
		if (sql == null) {
			message.setDescription("Sql Not get");
			message.setValid(false);
			return message;
		}

		// For loop is used to append data in respective String Builders
		for (int i = 0; i < apiNameArray.length - 1; i++) {

			apiId.append(apiIdArray[i].toString().trim() + ",");
			apiName.append(apiNameArray[i].toString().trim() + ",");
			apiUrl.append(apiUrlArray[i].toString().trim() + ",");
			isAdded.append(isAddedArray[i].toString().trim() + ",");

			if ((i + 1) % 10 == 0) {

				// Check the length of parameter api_id
				if (apiId.length() > 0) {
					apiId.deleteCharAt(apiId.lastIndexOf(","));
				}

				// Check the length of parameter api_name
				if (apiName.length() > 0) {
					apiName.deleteCharAt(apiName.lastIndexOf(","));
				}

				// Check the length of parameter url
				if (apiUrl.length() > 0) {
					apiUrl.deleteCharAt(apiUrl.lastIndexOf(","));
				}

				// Check the length of parameter is_Added
				if (isAdded.length() > 0) {
					isAdded.deleteCharAt(isAdded.lastIndexOf(","));
				}

				// Response is retrieved in object from procedure
				Object objectResponse = genericService.executeProcesure(null, sql, map.get("user_key"),
						map.get("user_id"), apiId.toString().trim(), apiName.toString().trim(),
						apiUrl.toString().trim(), isAdded.toString().trim());

				apiId.delete(0, apiId.length());
				apiName.delete(0, apiName.length());
				apiUrl.delete(0, apiUrl.length());
				isAdded.delete(0, isAdded.length());

			}
		}

		// Check the length of parameter api_id
		if (apiId.length() > 0) {
			apiId.deleteCharAt(apiId.lastIndexOf(","));
		}

		// Check the length of parameter api_name
		if (apiName.length() > 0) {
			apiName.deleteCharAt(apiName.lastIndexOf(","));
		}

		// Check the length of parameter url
		if (apiUrl.length() > 0) {
			apiUrl.deleteCharAt(apiUrl.lastIndexOf(","));
		}

		// Check the length of parameter is_Added
		if (isAdded.length() > 0) {
			isAdded.deleteCharAt(isAdded.lastIndexOf(","));
		}

		// Response is retrieved in object from procedure
		Object objectOutput = genericService.executeProcesure(null, sql, map.get("user_key"), map.get("user_id"),
				apiId.toString().trim(), apiName.toString().trim(), apiUrl.toString().trim(),
				isAdded.toString().trim());
		// Check object response result is not null
		if (objectOutput != null) {
			// Set the Success response
			message.setDescription("Updated successfully");
			message.setObject(objectOutput);
			message.setValid(true);
			return message;
		} else {
			// set the failure response
			message.setDescription("Not Updated Successfully");
			message.setObject(objectOutput);
			message.setValid(false);
			return message;
		}
	}

	/**
	 * This method is used for setting Role for multiple(bulk) APi's which makes
	 * API response slow.For optimization,we need to break the input parameters
	 * in API sent by user for fast response retrieval.
	 * 
	 * @param map,
	 *            The input parameters specified by user
	 * @return message, The response message of API.
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public Message permissionAPIRoleSet(Map<String, String> map) throws Exception {

		// Initializing the Message class
		Message message = new Message();

		// Initializing the String Builder
		StringBuilder apiId = new StringBuilder();

		// Retrieval of specific values from map on the basis of key
		String apiIdMap = map.get("api_ids").toString();

		// Arrays are created while dividing the data for input Parameters
		String apiIdArray[] = apiIdMap.split(",");

		// Map is used to get all the procedures
		Map<String, Object> procedureMap = processParameter.getMaps();

		String sql = null;

		if (procedureMap.get("32") != null) {
			sql = procedureMap.get("32").toString();
		}

		// Response Message when sql is null
		if (sql == null) {
			message.setDescription("Sql Not get");
			message.setValid(false);
			return message;
		}

		// For loop is used to append data in respective String Builders
		for (int i = 0; i < apiIdArray.length - 1; i++) {

			apiId.append(apiIdArray[i].toString().trim() + ",");

			if ((i + 1) % 10 == 0) {

				// Check the length of parameter api_id
				if (apiId.length() > 0) {
					apiId.deleteCharAt(apiId.lastIndexOf(","));
				}

				// Response is retrieved in object from procedure
				Object objectResponse = genericService.executeProcesure(null, sql, map.get("user_key"),
						map.get("user_id"), map.get("role_id"), apiId.toString().trim(), map.get("is_bit"));

				apiId.delete(0, apiId.length());

			}
		}

		// Check the length of parameter api_id
		if (apiId.length() > 0) {
			apiId.deleteCharAt(apiId.lastIndexOf(","));
		}

		// Response is retrieved in object from procedure
		Object objectOutput = genericService.executeProcesure(null, sql, map.get("user_key"), map.get("user_id"),
				map.get("role_id"), apiId.toString().trim(), map.get("is_bit"));

		if (objectOutput != null) {
			// set the success response
			message.setDescription("Updated successfully");
			message.setObject(objectOutput);
			message.setValid(true);
			return message;
		} else {
			// set the failure response
			message.setDescription("Not Updated Successfully");
			message.setObject(objectOutput);
			message.setValid(false);
			return message;
		}
	}
}
