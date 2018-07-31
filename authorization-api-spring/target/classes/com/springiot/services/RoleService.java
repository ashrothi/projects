/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.response.Message;

/**
 * This class is used to get roles on the basis of applications user got the
 * permission.
 * 
 */
@Service
public class RoleService {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This method is used to get roles on the basis of applications user got
	 * the permission.
	 * 
	 * @param requestType,
	 *            the procedure number
	 * @param map,the
	 *            input parameters required for calling API
	 * @return
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	public Object rolesGetAllUserApplication(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Message class
		Message responseMessage = new Message();

		try {
			// Retrieve the response from procedure and store into message class
			Message roleResponsemessage = genericProcess.GenericProcedureCalling(requestType, map, request, response);

			// Check result retrieved from procedure is not null
			if (roleResponsemessage != null) {

				// Results retrieved is converted into list<map>
				Type type = new TypeToken<List<Map<String, Object>>>() {
				}.getType();

				String roleDataToUpdate = new Gson().toJson(roleResponsemessage.getObject());

				List<Map<String, Object>> roleDataList = new Gson().fromJson(roleDataToUpdate, type);

				// Creating a Multimap so that we can store Multiple value of
				// Single key in a map
				Multimap<String, Object> roleDataMultimap = ArrayListMultimap.create();

				for (Map<String, Object> inuploadListMap : roleDataList) {

					roleDataMultimap.put(inuploadListMap.get("roles_name").toString(), inuploadListMap);
				}

				// Initialization of list<object>
				List<Object> roleMapListFinal = new ArrayList<>();

				for (String key : roleDataMultimap.keySet()) {

					for (Object object : roleDataMultimap.get(key)) {
						// Initialization of map
						Map<String, Object> roleUpdateDataFinalMap = new HashMap<>();
						// Initialization of list<object>
						List<Object> roleMapList = new ArrayList<>();
						// Adding parameters to the map
						roleUpdateDataFinalMap.put(key, object.toString());

						// Initialization of map
						Map<String, Object> roleDataFinalMap = new HashMap<>();
						// Adding parameters to the map
						roleDataFinalMap.put("roles_name", key);

						// Convert the object into map
						Map<String, Object> itemObject = (Map<String, Object>) object;

						if (itemObject.get("attributes_data_types") != null) {
							roleDataFinalMap.put("applications_id", itemObject.get("applications_id"));
							roleDataFinalMap.put("roles_id", itemObject.get("roles_id"));
							roleDataFinalMap.put("roles_access_key", itemObject.get("roles_access_key"));
							List<Object> roleMapUpdateList = new ArrayList<>();

							// Response variables are splitted with comma and
							// get stored into Arrays
							String[] attributesDataTypes = itemObject.get("attributes_data_types").toString()
									.split("#x#f#", -1);

							int val = attributesDataTypes.length;

							// Check the value of parameter not null
							String[] dataTypeRegx = itemObject.get("datatypes_is_regex") != null
									? String.valueOf(itemObject.get("datatypes_is_regex")).split("#x#f#", -1)
									: new String[val];

							String[] attributesNames = itemObject.get("attributes_names") != null
									? itemObject.get("attributes_names").toString().split("#x#f#", -1)
									: new String[val];

							String[] attributesRegEx = itemObject.get("attributes_reg_ex") != null
									? itemObject.get("attributes_reg_ex").toString().split("#x#f#", -1)
									: new String[val];

							// The parameter value is splitted with splitter
							// '#x#f#'
							String[] attributesIds = itemObject.get("attributes_ids") != null
									? itemObject.get("attributes_ids").toString().split("#x#f#", -1) : new String[val];

							String[] attributesAlias = itemObject.get("attributes_alias") != null
									? itemObject.get("attributes_alias").toString().split("#x#f#", -1)
									: new String[val];

							String[] datatypesNames = itemObject.get("datatypes_names") != null
									? itemObject.get("datatypes_names").toString().split("#x#f#", -1) : new String[val];

							String[] roleAttributeIsRequired = itemObject.get("role_attribute_is_required") != null
									? String.valueOf(itemObject.get("role_attribute_is_required")).split("#x#f#", -1)
									: new String[0];

							for (int i = 0; i < attributesDataTypes.length; i++) {
								Map<String, Object> itemNewObject = new HashMap<>();

								// Adding parameters to the map
								itemNewObject.put("datatypes_is_regex", dataTypeRegx[i]);
								itemNewObject.put("attributes_names", attributesNames[i]);
								itemNewObject.put("attributes_reg_ex", attributesRegEx[i]);
								itemNewObject.put("attributes_ids", attributesIds[i]);
								itemNewObject.put("attributes_alias", attributesAlias[i]);
								itemNewObject.put("datatypes_names", datatypesNames[i]);
								itemNewObject.put("attributes_data_types", attributesDataTypes[i]);
								itemNewObject.put("role_attribute_is_required", roleAttributeIsRequired[i]);

								// add map to the arraylist
								roleMapUpdateList.add(itemNewObject);
							}

							roleDataFinalMap.put("items", roleMapUpdateList);

						} else {
							roleDataFinalMap.put("applications_id", itemObject.get("applications_id"));
							roleDataFinalMap.put("roles_id", itemObject.get("roles_id"));
							roleDataFinalMap.put("roles_access_key", itemObject.get("roles_access_key"));
							List<Object> roleMapUpdateList = new ArrayList<>();

							Map<String, Object> itemNewObject = new HashMap<>();
							// Adding parameters to the map
							itemNewObject.put("datatypes_is_regex", null);
							itemNewObject.put("attributes_names", null);
							itemNewObject.put("attributes_reg_ex", null);
							itemNewObject.put("attributes_ids", null);
							itemNewObject.put("attributes_alias", null);
							itemNewObject.put("datatypes_names", null);
							itemNewObject.put("attributes_data_types", null);
							itemNewObject.put("role_attribute_is_required", null);

							roleMapUpdateList.add(itemNewObject);
							roleDataFinalMap.put("items", roleMapUpdateList);
						}
						roleMapList.add(roleDataFinalMap);
						roleMapListFinal.addAll(roleMapList);
					}
				}

				// String finalRolewisePlannerResult = new
				// Gson().toJson(roleMapListFinal);

				if (roleMapListFinal != null) {
					// Set the success message
					responseMessage.setDescription("Final Otput");
					responseMessage.setObject(roleMapListFinal);
					responseMessage.setValid(true);
					return responseMessage;
				}
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			Message message = new Message();
			e.printStackTrace();
			message.setDescription(" Process Fail " + e.getMessage());
			message.setValid(false);
			return message;
		}
		return responseMessage;
	}
}