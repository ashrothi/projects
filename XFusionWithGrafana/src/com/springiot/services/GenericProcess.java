package com.springiot.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This Class is used to define the generic processes from Databases.
 * 
 * @author tanvigarg
 */
@Service
public class GenericProcess {
	/**
	 * To access functionality of Generic Service
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * Used to interact with the procedures.
	 */
	@Autowired
	private ProcessParameter processParameter;

	/**
	 * GenericProcedureCalling() method is used to check the data received from
	 * Performance Database.
	 */
	public Message GenericProcedureCalling(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("Generic Procedure Calling ");

		Message responseMessage = new Message();

		try {

			Object[] storedProcedureParameter = null;

			// Map is used to retrieve the lists of procedure from mvc
			// dispatcher servlet xml file
			Map<String, Object> procedureRequestMap = processParameter.getMaps();

			List<Object> parameterList = new ArrayList<>();

			// This particular map is used to call particular procedure on the
			// basis of request type
			Map<String, Object> responseForProcedureCall = procedureCall(procedureRequestMap, requestType);

			String sql = responseForProcedureCall.get("sql").toString();
			String params = responseForProcedureCall.get("params").toString();

			/*
			 * Firstly split the parameters with comma,and then trim user_key
			 * and userId and manipulate according to our requirements and store
			 * it in a map.
			 */
			for (String checkString : params.split(",")) {

				// Check if map is null
				if (map == null) {
					continue;
				}
				// Check if input parameter is token
				if (checkString.equals("token")) {
					continue;
				}

				// user_key Header
				if (checkString.trim().equals("user_key")) {

					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					continue;
				}

				// user_id Header
				if (checkString.trim().equals("user_id")) {
					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					continue;
				}

				// Check if input parameter is null and if it's null,then pass
				// null in procedure
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

			// Check the parameterList size is greater then zero
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			// Check if procedure string is not null
			if (sql != null) {

				Object responseFromProcedure = null;
				// Check input parameters parameterList is null
				if (storedProcedureParameter == null) {
					responseFromProcedure = genericService.executeProcesure(null, sql);

				} else {
					responseFromProcedure = genericService.executeProcesure(null, sql, storedProcedureParameter);

				}

				// Set the success response of API
				if (responseFromProcedure != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseFromProcedure);
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					responseMessage.setDescription("Process Fail ");
					responseMessage.setValid(false);
					return responseMessage;
				}
			} else {
				responseMessage.setDescription("Process Fail ");
				responseMessage.setValid(false);
				return responseMessage;
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			// e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
			// throw e;
		}
	}

	/**
	 * This method is used to retrieve procedure from mvc dispatcher servlet xml
	 * file on the basis of request type
	 * 
	 * @param procedureRequestMap,this
	 *            contains a list of all procedures from xml file
	 * @param requestType,this
	 *            contains the particular procedure which needs to be called.
	 * @return
	 */
	private Map<String, Object> procedureCall(Map<String, Object> procedureRequestMap, String requestType) {

		String params = null;
		String sql = null;

		if (procedureRequestMap.get(requestType) != null) {
			String value = procedureRequestMap.get(requestType).toString();

			// Manipulate sql procedure according to the parameter name wise
			params = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

			// Get the procedure values
			String sqlValue = value.substring(0, value.indexOf("("));
			String key = value.substring(value.indexOf("("));

			// Initialization of String Builder
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

		// Map is required to set the response
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("params", params);
		responseMap.put("sql", sql);

		return responseMap;

	}
}
