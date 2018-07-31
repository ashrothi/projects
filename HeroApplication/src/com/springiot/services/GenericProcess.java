/**
 * This package contain the Service class for Generic Process for API Calling to call Procedure and retrieve their data
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for Generic Process for API Calling to
 * call Procedure and retrieve their data by getting parameter in map and
 * requestType as key to get the procedure which is to be called.
 * 
 * @author Ankita Shrothi
 *
 */

@Service
public class GenericProcess {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * GenericProcedureCalling() method is used to return the Result when API is
	 * being hit and return the result
	 * 
	 * @param requestType
	 * @param map
	 * @param clz
	 * @return message
	 */
	public Message GenericProcedureCalling(String requestType, Map<String, String> map,
			@SuppressWarnings("rawtypes") Class clz) {
		System.out.println("Input Map : "+ map);
		
		/**
		 * To Inizialize the response Message
		 */
		Message message = new Message();

		try {
			/**
			 * to store stored Procedure Parameter in array of object
			 */
			Object[] storedProcedureParameter = null;
			/**
			 * To get Map of Stored Procedure
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * To get Parameter List in List Of Object
			 */
			List<Object> parameterList = new ArrayList<>();
			/**
			 * Initializing sql query and its param to call procedure
			 */
			String requestedApi = null;
			/*
			 * This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
			 */
			if (procedureRequestMap.get(requestType) != null) {
				requestedApi = procedureRequestMap.get(requestType).toString();
			}
			/**
			 * To all Map Parameteres
			 */
			Set<String> set = map.keySet();
			/**
			 * to get each parameter name
			 */
			for (String checkString : set) {
				/*
				 * To check if it contains token
				 */
				if (checkString.equals("token")) {
					continue;
				}
				/*
				 * To check if it contains access_key
				 */
				if (checkString.equals("access_key")) {
					continue;
				}
				/*
				 * To check if it contains requestType
				 */
				if (checkString.equals("requestType")) {

					/*
					 * This matches the input parameters with the parameters of
					 * procedure and replacing them with the parameters provided
					 * by the user.
					 */
					if (procedureRequestMap.get(requestType) != null) {
						requestedApi = procedureRequestMap.get(requestType).toString();
					}

					continue;
				}
				/*
				 * Check the value of params if empty or not
				 */
				if (map.get(checkString).toString().isEmpty()) {
					parameterList.add(null);
				} else {
					/*
					 * add parameters
					 */
					parameterList.add(map.get(checkString));
				}

			}
			/**
			 * To Print Parameters and stored Procedure which will be called
			 */
			System.out.println("parameter parameterList:- " + parameterList + ", requestedApi data:- " + requestedApi);
			/*
			 * All the parameters are added in a list of objects.
			 */
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			if (requestedApi != null) {

				Object object = null;
				/*
				 * The condition check if parameters received from procedure are
				 * null or not and call it according to the coming input
				 */
				if (storedProcedureParameter == null) {
					if (clz != null) {
						object = genericService.executeProcesure(clz, requestedApi);
						// System.out.println(object.toString());
					} else {
						object = genericService.executeProcesure(null, requestedApi);
						// System.out.println(object.toString());
					}

				} else {
					if (clz != null) {
						object = genericService.executeProcesure(clz, requestedApi, storedProcedureParameter);
						// System.out.println(object.toString());
					} else {
						object = genericService.executeProcesure(null, requestedApi, storedProcedureParameter);
						// System.out.println(object.toString());
					}

				}
				/**
				 * 
				 * return success message if object is not null
				 */
				if (object != null) {
					System.out.println(object.toString());
					message.setDescription("Process Success");
					message.setObject(object);
					message.setValid(true);

					return message;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * 
			 * return error message
			 */
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
		/**
		 * Return Error Message when issue with parameter or program issue
		 */
		message.setDescription("Process Fail");
		message.setValid(false);

		return message;
	}

	/**
	 * GenericProcedureCalling() method is used to return the Result when API is
	 * being hit and return the result
	 * 
	 * @param requestType
	 * @param map
	 * @param clz
	 * @return message
	 */
	@SuppressWarnings("unchecked")
	public Message GenericProcedureCallingMultipleResult(String requestType, Map<String, String> map,
			@SuppressWarnings("rawtypes") Class clz, int expectedResultSet) {
		/**
		 * To Inizialize the response Message
		 */
		Message message = new Message();

		try {
			/**
			 * to store stored Procedure Parameter in array of object
			 */
			Object[] storedProcedureParameter = null;
			/**
			 * To get Map of Stored Procedure
			 */
			Map<String, Object> procedureRequestMap = processParameter.getMaps();
			/**
			 * To get Parameter List in List Of Object
			 */
			List<Object> parameterList = new ArrayList<>();
			/**
			 * Initializing sql query and its param to call procedure
			 */
			String requestedApi = null;
			/*
			 * This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
			 */
			if (procedureRequestMap.get(requestType) != null) {
				requestedApi = procedureRequestMap.get(requestType).toString();
			}
			/**
			 * To all Map Parameteres
			 */
			Set<String> set = map.keySet();
			/**
			 * to get each parameter name
			 */
			for (String checkString : set) {
				/*
				 * To check if it contains token
				 */
				if (checkString.equals("token")) {
					continue;
				}
				/*
				 * To check if it contains access_key
				 */
				if (checkString.equals("access_key")) {
					continue;
				}
				/*
				 * To check if it contains requestType
				 */
				if (checkString.equals("requestType")) {

					// String requestType = map.get(checkString).trim();
					/*
					 * This matches the input parameters with the parameters of
					 * procedure and replacing them with the parameters provided
					 * by the user.
					 */
					if (procedureRequestMap.get(requestType) != null) {
						requestedApi = procedureRequestMap.get(requestType).toString();
					}

					continue;
				}
				/*
				 * Check the value of params if empty or not
				 */
				if (map.get(checkString).toString().isEmpty()) {
					parameterList.add(null);
				} else {
					/*
					 * add parameters
					 */
					parameterList.add(map.get(checkString));
				}

			}
			/**
			 * To Print Parameters and stored Procedure which will be called
			 */
			System.out.println("parameter parameterList:- " + parameterList + ", requestedApi data:- " + requestedApi);
			/*
			 * All the parameters are added in a list of objects.
			 */
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			if (requestedApi != null) {

				Object object = null;
				/*
				 * The condition check if parameters received from procedure are
				 * null or not and call it according to the coming input
				 */
				if (storedProcedureParameter == null) {
					if (clz != null) {
						object = genericService.executeProcedureMultipleResultSet(clz, requestedApi);
						// System.out.println(object.toString());
					} else {
						object = genericService.executeProcedureMultipleResultSet(null, requestedApi);
						// System.out.println(object.toString());
					}

				} else {
					if (clz != null) {
						object = genericService.executeProcedureMultipleResultSet(clz, requestedApi,
								storedProcedureParameter);
						// System.out.println(object.toString());
					} else {
						object = genericService.executeProcedureMultipleResultSet(null, requestedApi,
								storedProcedureParameter);
						// System.out.println(object.toString());
					}

				}
				/**
				 * 
				 * return success message if object is not null
				 */
				if (object != null) {

					List<List<Map<String, Object>>> list = (List<List<Map<String, Object>>>) object;
					/**
					 * if its zero then return all resultset
					 */
					if (expectedResultSet == 0) {
						message.setDescription("Process Success");
						message.setObject(list);
						message.setValid(true);
						return message;
					}
					/**
					 * Else return requested result set
					 */
					message.setDescription("Process Success");
					message.setObject(list.get(expectedResultSet - 1));
					message.setValid(true);

					return message;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * 
			 * return error message
			 */
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;

		}
		/**
		 * Return Error Message when issue with parameter or program issue
		 */
		message.setDescription("Process Fail");
		message.setValid(false);
		return message;
	}

}
