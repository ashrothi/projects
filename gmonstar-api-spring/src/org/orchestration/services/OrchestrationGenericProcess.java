/**
 * This package contain the Service class for All GlobeTouch Application for Flint
 */
package org.orchestration.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.orchestration.constant.OrchestrationProcessParameter;
import org.orchestration.genericService.OrchestrationGenericService;
import org.orchestration.response.model.OrchestrationMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class OrchestrationGenericProcess {

	Logger logger = Logger.getLogger(OrchestrationGenericProcess.class);
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private OrchestrationGenericService genericService;

	@Autowired
	private OrchestrationProcessParameter processOLParameter;

	/**
	 * This method is to call the Procedures defined in
	 * mvc-orchestration-dispatcher-servlet.xml with their reference key and get
	 * the response in Message format
	 * 
	 * @param requestType:-
	 *            Key to get Procedure Name
	 * @param map
	 *            :-Parameters to call procedure
	 * @param clz:-
	 *            to set the response
	 * @param request:-
	 *            to get UserKey and userId From http request along with token
	 * @param response
	 * @return Message Response
	 */

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public OrchestrationMessage GenericOrchestrationProcedureCalling(String requestType, Map<String, String> map,
			Class clz, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To Inizialize the response Message
		 */
		// System.out.println("requestType" + requestType);
		OrchestrationMessage message = new OrchestrationMessage();

		try {

			/**
			 * to store stored Procedure Parameter in array of object
			 */
			Object[] storedProcedureParameter = null;
			/**
			 * To get Map of Stored Procedure
			 */
			Map<String, Object> procedureRequestMap = processOLParameter.getMaps();

			// System.out.println("procedureRequestMap " + procedureRequestMap);
			/**
			 * To get Parameter List in List Of Object
			 */
			List<Object> parameterList = new ArrayList<>();
			/**
			 * Initializing sql query and its param to call procedure
			 */
			String sql = null;
			String params = null;

			/*
			 * This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
			 */
			// System.out.println("procedureRequestMap" + procedureRequestMap);

			if (procedureRequestMap.get(requestType) != null) {
				String value = procedureRequestMap.get(requestType).toString();

				params = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

				String sqlValue = value.substring(0, value.indexOf("("));
				String key = value.substring(value.indexOf("("));

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

				// System.out.println("\n Param :-" + params + "==" + sql);

			}

			/*
			 * Firstly split the parameters with comma,and then trim userKey and
			 * userId and manipulate according to our requirements and store it
			 * in a map.
			 */
			for (String checkString : params.split(",")) {
				/**
				 * if procedure doesn't have any parameter to pass
				 */
				if (map == null) {
					continue;
				}
				/**
				 * If parameter name is user_name than get it from headers
				 */
				if (checkString.trim().equals("user_name")) {
					parameterList.add(request.getAttribute(checkString) != null ? request.getAttribute(checkString)
							: map.get(checkString));
					continue;
				}
				/**
				 * If parameter name is password than get it from headers
				 */

				if (checkString.trim().equals("password")) {
					parameterList.add(request.getAttribute(checkString) != null ? request.getAttribute(checkString)
							: map.get(checkString));
					continue;
				}
				/**
				 * to set the parameter as per procedure parameter value
				 */
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
			/**
			 * To Print Parameters and stored Procedure which will be called
			 */
			logger.info("parameter parameterList:- " + parameterList + ", requestedApi data:- " + sql);

			/*
			 * All the parameters are added in a list of objects.
			 */
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			if (sql != null) {
				Object object = null;

				/*
				 * The condition check if parameters received from procedure are
				 * null or not and call it according to the coming input
				 */
				if (storedProcedureParameter == null) {
					if (clz != null) {
						object = genericService.executeOrchestrationProcesure(clz, sql);
						// System.out.println(object);
					} else {
						object = genericService.executeOrchestrationProcesure(null, sql);
						// System.out.println(object);
					}

				} else {
					if (clz != null) {
						object = genericService.executeOrchestrationProcesure(clz, sql, storedProcedureParameter);
						// System.out.println(object);
					} else {
						object = genericService.executeOrchestrationProcesure(null, sql, storedProcedureParameter);
						logger.info(object);
					}
				}
				/**
				 * Success Response
				 */
				message.setDescription("Process Success");
				message.setObject(object);
				message.setValid(true);
				return message;
			} else {
				/**
				 * Failure Response
				 */
				message.setDescription("Process Fail");
				message.setValid(false);
				return message;
			}

		}
		/*
		 * Catch Exception Block to handle all the exceptions occurring.
		 */
		catch (Exception e) {
			logger.setPriority(Priority.ERROR);
			logger.error(e);
			e.printStackTrace();
			message.setDescription("Process Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}
}
