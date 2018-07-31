/**
* @author Garima Joshi
 * This package contains the classes which is used as services in which business logic is implemented and to use these 
 * functionalities other classes autowired these service classes.
 */
package com.springiot.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.Message;

/**
 * @author Garima Joshi This Class is used as service to validate the user to
 *         access any API using user key validation.
 */
@Service
@Transactional
public class UrlValidationKeyService {
	/**
	 * To access functionality of urlCalling Class
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	/**
	 * To access functionality of urlParameter Class
	 */
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericService genericService;
	@Autowired
	private OperationalService operationalService;

	/**
	 * This method is used to check the validation of user on the basis of token
	 * and user key.
	 * 
	 * @param map,
	 *            Contains all the parameters passed during calling of API
	 * @param urlKey,
	 *            Contains the user key
	 * @return Message, Return the response message.
	 */
	@SuppressWarnings("unchecked")
	public Message validateURL(HttpServletRequest request, HttpServletResponse response) {

		Message message = new Message();

		try {

			// System.out.println("************************************** " +
			// request.getHeader("token"));
			String URIPatter = request.getRequestURI().substring(1);

			// Retrieve the url
			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			Boolean valid = false;

			if (request.getHeader("token") == null) {

				valid = true;
				message.setDescription("Process Success");
				message.setObject(valid);
				message.setValid(true);
				return message;
			}
			String hsqlQueryAccessKey = "select access_key,role_id,organization_id from TokenStorage.platform_token where access_token='"
					+ request.getHeader("token") + "' ";
			// Casting the response to List<Object>
			List<Map<String, Object>> getTokenQuery = (List<Map<String, Object>>) genericService
					.executeHSqlSelectQuery(hsqlQueryAccessKey);

			// System.out.println("getTokenQuery " + getTokenQuery);
			if (getTokenQuery.size() > 0) {

				request.setAttribute("access_key", String.valueOf(getTokenQuery.get(0).get("ACCESS_KEY")));
				request.setAttribute("role_id", String.valueOf(getTokenQuery.get(0).get("ROLE_ID")));
				request.setAttribute("organization_id", String.valueOf(getTokenQuery.get(0).get("ORGANIZATION_ID")));

			}
			// Check the access key is present in map or not
			if (!Constant.accessmap.containsKey(request.getAttribute("access_key").toString())) {

				// Calling of Authorization API to get the permissions
				String roleId = request.getAttribute("role_id").toString();

				String getPermissionParam = "role_id=" + roleId;
				Map<String, String> headerMap = new LinkedHashMap<>();

				// Get the Authorization Engine token

				headerMap.put("token", String.valueOf(request.getHeader("token")));
				headerMap.put("user_key", String.valueOf(request.getHeader("user_key")));
				headerMap.put("user_id", String.valueOf(request.getHeader("user_id")));
				/**
				 * Calling Oauth API to get Url Permission
				 */
				Object accessPermision = urlCalling.getData(urlParameter.getGetAllPermisions(), getPermissionParam,
						headerMap);
				System.out.println("accessPermision " + accessPermision);
				/**
				 * To check if response is not null
				 */
				if (accessPermision != null) {
					/**
					 * Storing Url permission in accessmap
					 */
					// System.out.println("-------********************-----------------"
					// + String.valueOf(request.getAttribute("access_key"))
					// + "-------********************-----------------" +
					// accessPermision);
					Constant.accessmap.put(String.valueOf(request.getAttribute("access_key")), accessPermision);

				}
			}
			/**
			 * To check if url has permission
			 */

			// System.out.println(Constant.accessmap.get(request.getAttribute("access_key")).toString());
			// System.out.println();

			if (Constant.accessmap.get(request.getAttribute("access_key")).toString().contains("\"" + URI + "\"")) {
				valid = true;
			}
			/**
			 * Return response as per value of valid
			 */

			if (!valid) {
				List<Map<String, Object>> responseMapList = new ArrayList<>();
				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("msg", "you don't have permission to access this api");
				responseMap.put("url_status", false);
				responseMap.put("code", 28);
				responseMapList.add(responseMap);

				// Set the failure response
				message.setDescription("Process Success");
				message.setObject(responseMapList);
				message.setValid(false);
			} else {// Set the success response
				message.setDescription("Process Success");
				message.setObject(valid);
				message.setValid(true);

			}

		} catch (Exception exception) {
			// Set the failure response
			exception.printStackTrace();
			message.setDescription(exception.getMessage());
			message.setValid(false);
			return message;
		}
		return message;

	}

	@SuppressWarnings("unchecked")
	public Message tokenValidateURL(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Boolean valid = false;
		String tokenFromHeader = request.getHeader("token");
		Message message = new Message();
		String updateQuery = "UPDATE TokenStorage.platform_token SET time=now() where access_token='" + tokenFromHeader
				+ "';";

		// Casting the response to List<Object>
		int getToken = (int) genericService.executeHSqlQuery(updateQuery);
		// System.out.println("getToken " + getToken);
		// Check the row size retrieved from HSQL
		if (getToken == 0) {

			// The parameter map is initialized to introduce the
			// input parameters required to pass in the procedure

			Message responseFromAuth = operationalService.validateToken(request, response);

			List<Map<String, Object>> tokenMap = (List<Map<String, Object>>) responseFromAuth.getObject();
			if (responseFromAuth.getObject() != null) {
				if (!tokenMap.get(0).get("status").toString().equalsIgnoreCase("1.0")) {
					response.sendError(401);
				} else {
					message.setDescription("Process Success");
					message.setObject(valid);
					message.setValid(true);
				}

			}
		} else {

			message.setDescription("Process Success");
			message.setObject(valid);
			message.setValid(true);
			// }
		}
		return message;
	}
}