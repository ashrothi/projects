/**
 * This package contain the Service class for All GlobeTouch Application for Flint
 */
package org.gmonstar.notification.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;

import org.gmonstar.notification.constant.ProcessParameter;
import org.gmonstar.notification.genericService.GenericService;
import org.gmonstar.notification.response.model.Message;
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
public class GenericProcess {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * 
	 * @param requestType:-
	 *            Key to get Procedure Name
	 * @param map
	 *            :-Parameters to call procedure
	 * @param clz:-
	 *            to set the response
	 * @param request:-
	 *            to get UserKey and userId From https request along with token
	 * @param response
	 * @return Message Response
	 */
	@SuppressWarnings("rawtypes")
	public Message GenericProcedureCalling(String requestType, Map<String, String> map, Class clz,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To Inizialize the response Message
		 */
		Message message = new Message();

		try {
			// System.out.println(map);
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
			String sql = null;
			String params = null;

			/*
			 * This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
			 */
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

				if (map == null) {
					continue;
				}
				if (checkString.trim().equals("token")) {
					parameterList.add(
							request.getHeader(checkString) != null ? request.getHeader(checkString) : map.get("token"));
					continue;
				}
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
			/**
			 * To Print Parameters and stored Procedure which will be called
			 */
			// System.out.println("parameter parameterList:- " + parameterList +
			// ", requestedApi data:- " + sql);

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
						object = genericService.executeProcesure(clz, sql);
						System.out.println("Response with class no parameter" + object.toString());
					} else {
						object = genericService.executeProcesure(null, sql);
						System.out.println("Response without class no parameter" + object.toString());
					}

				} else {
					if (clz != null) {
						object = genericService.executeProcesure(clz, sql, storedProcedureParameter);
						System.out.println("Response with class" + object.toString());
					} else {
						object = genericService.executeProcesure(null, sql, storedProcedureParameter);
						System.out.println("Response without class" + object.toString());
					}
				}

				message.setDescription("Process Success");
				message.setObject(object);
				message.setValid(true);
				return message;
			} else {
				message.setDescription("Process Fail");
				message.setValid(false);
				return message;
			}

		}
		/*
		 * Catch Exception Block to handle all the exceptions occurring.
		 */
		catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process Fail");
			message.setValid(false);
			return message;
		}
	}
}
