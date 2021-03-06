/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This Class to Define GenericProcess Service For API's,used widely when the
 * generic procedures are being called.
 * 
 * @author tanvigarg
 *
 */

@Service
public class GenericProcess {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private ProcessParameter processParameter;

	/**
	 * GenericProcedureCalling() method is used to return the Result when API is
	 * being hit and return the result. Generic Procedure calling is used for
	 * the procedures of development database.
	 * 
	 * @param requestType,the
	 *            input procedure number which will be fetched from
	 *            mvc-dispatcher-servlet.xml file.
	 * @param map,
	 *            the input parameters required for procedure calling.
	 * @return message, returns the failure and success responses
	 * @throws Exception
	 */
	public Message GenericProcedureCalling(String requestType, Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of Message class
		Message message = new Message();

		try {

			// System.out.println("input map is" + map);

			// Array of parameters
			Object[] parameterList = null;

			// Initialization of map
			Map<String, Object> proMap = processParameter.getMaps();

			// Initialization of ArrayList
			List<Object> list = new ArrayList<>();

			String getProcedure = null;

			// Get the sql from the procedure and use request type(procedure
			// number) for that
			if (proMap.get(requestType) != null) {
				getProcedure = proMap.get(requestType).toString();
			}
			Set<String> set = map.keySet();

			// The input parameters contains token or not
			for (String string : set) {
				/*
				 * if (string.equals("token")) { continue; }
				 */
				// If loop is used for server side filtering paramter
				// in_condition

				list.add(map.get(string));
			}

			// Check the list size is greater then zero
			if (list.size() > 0) {
				parameterList = list.toArray();
			}
			// System.out.println("Parameter List : - " + list.toString() + "
			// ------------ " + getProcedure);
			// Check if procedure string is not null
			if (getProcedure != null) {

				Object responseFromProcedure = null;
				// Check input parameters list is null
				if (parameterList == null) {
					responseFromProcedure = genericService.executeProcesure(null, getProcedure);
					// System.out.println(" responseFromProcedure" +
					// responseFromProcedure);
				} else {
					responseFromProcedure = genericService.executeProcesure(null, getProcedure, parameterList);
					// System.out.println(" responseFromProcedure" +
					// responseFromProcedure);
				}

				// Set the success response of API
				if (responseFromProcedure != null) {
					message.setDescription("Process Success");
					message.setObject(responseFromProcedure);
					message.setValid(true);
					return message;
				}
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			message.setDescription("Process Fail " + e.getMessage());
			message.setValid(false);
			return message;
		}
		// Set the failure response
		message.setDescription("Process Fail");
		message.setValid(false);
		return message;
	}

	/**
	 * GenericProcedureCalling() method is used to return the Result when API is
	 * being hit and return the result. Generic Procedure calling is used for
	 * the procedures of development database.
	 * 
	 * @param requestType,the
	 *            input procedure number which will be fetched from
	 *            mvc-dispatcher-servlet.xml file.
	 * @param map,
	 *            the input parameters required for procedure calling.
	 * @return message, returns the failure and success responses
	 * @throws Exception
	 */
	public Message GenericProcedureCallingPingServer(String requestType, Map<String, Object> map) {

		// Initialization of Message class
		Message message = new Message();

		try {

			// System.out.println("input param map is" + map);

			// Array of parameters
			Object[] parameterList = null;

			// Initialization of map
			Map<String, Object> proMap = processParameter.getMaps();

			// Initialization of ArrayList
			List<Object> list = new ArrayList<>();

			String getProcedure = null;

			// Get the sql from the procedure and use request type(procedure
			// number) for that
			if (proMap.get(requestType) != null) {
				getProcedure = proMap.get(requestType).toString();
			}
			Set<String> set = map.keySet();

			// The input parameters contains token or not
			for (String string : set) {
				if (string.equals("token")) {
					continue;
				}
				// If loop is used for server side filtering paramter
				// in_condition

				list.add(map.get(string));
			}

			// Check the list size is greater then zero
			if (list.size() > 0) {
				parameterList = list.toArray();
			}

			// Check if procedure string is not null
			if (getProcedure != null) {

				Object responseFromProcedure = null;
				// Check input parameters list is null
				if (parameterList == null) {
					responseFromProcedure = genericService.executeProcesurePingServer(null, getProcedure);
				} else {
					responseFromProcedure = genericService.executeProcesurePingServer(null, getProcedure,
							parameterList);
					// System.out.println("Object is :- " +
					// responseFromProcedure);
				}

				// Set the success response of API
				if (responseFromProcedure != null) {
					message.setDescription("Process Success");
					message.setObject(responseFromProcedure);
					message.setValid(true);
					return message;
				}
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
			// Set the failure response
			message.setDescription("Process Fail " + e.getMessage());
			message.setValid(false);
			return message;
		}
		// Set the failure response
		message.setDescription("Process Fail");
		message.setValid(false);
		return message;
	}

}