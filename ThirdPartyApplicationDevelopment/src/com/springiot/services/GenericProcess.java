/**
 * 
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
 * 
 * 
 * @author Mandeep Singh
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
	 * @return responseMessage
	 */
	public Message GenericProcedureCalling(String requestType, Map<String, String> map,
			@SuppressWarnings("rawtypes") Class clz, HttpServletRequest request, HttpServletResponse response) {

		Message responseMessage = new Message();

		try {

			Object[] storedProcedureParameter = null;

			Map<String, Object> procedureRequestMap = processParameter.getMaps();

			//System.out.println("procedureRequestMap:- " + procedureRequestMap);
			//System.out.println("parameter map:- " + map);

			List<Object> list = new ArrayList<>();

			list.add(request.getHeader("user_key"));
			list.add(request.getHeader("user_id"));
			
			String requestedApi = null;

			if (procedureRequestMap.get(requestType) != null) {
				requestedApi = procedureRequestMap.get(requestType).toString();
			}

			Set<String> set = map.keySet();

			for (String checkString : set) {
				/*if (checkString.equals("token")) {
					continue;
				}

				if (checkString.equals("access_key")) {
					continue;
				}*/

				if (checkString.equals("requestType")) {

					// String requestType = map.get(checkString).trim();

					if (procedureRequestMap.get(requestType) != null) {
						requestedApi = procedureRequestMap.get(requestType).toString();
					}

					continue;
				}

				list.add(map.get(checkString));

			}

			//System.out.println("parameter list:- " + list + ", requestedApi data:- " + requestedApi);

			if (list.size() > 0) {
				storedProcedureParameter = list.toArray();
			}

			if (requestedApi != null) {

				Object object = null;

				if (storedProcedureParameter == null) {
					if (clz != null) {
						object = genericService.executeProcesure(clz, requestedApi);
					} else {
						object = genericService.executeProcesure(null, requestedApi);
					}

				} else {
					if (clz != null) {
						object = genericService.executeProcesure(clz, requestedApi, storedProcedureParameter);
					} else {
						object = genericService.executeProcesure(null, requestedApi, storedProcedureParameter);
					}

				}

				if (object != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(object);
					responseMessage.setValid(true);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}

		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);

		return responseMessage;
	}

}
