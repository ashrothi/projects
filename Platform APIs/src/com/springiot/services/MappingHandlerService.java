/**
 * This package is used to provide permissions to particular users to access some API's and views on the application.
 */
package com.springiot.services;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.google.gson.Gson;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.Message;

/**
 * 
 * @author tanvigarg This class will handle all the mapping of API's and views
 *         on the application for the specific users on the basis of their role
 *         name.
 */
@Service
public class MappingHandlerService {
	/**
	 * To Initialize the response Message
	 */
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private HttpURLCalling urlCalling;

	public Message getAPIsMapping() throws Exception {

		Message message = new Message();

		try {
			/*
			 * To Initialize the response List
			 */
			List<Map<String, Object>> list = new ArrayList<>();

			/*
			 * To Get ALL the Methods and APIS from Controller
			 */
			Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();

			for (RequestMappingInfo mappingInfo : map.keySet()) {

				Map<String, Object> mapDetails = new HashMap<>();
				/*
				 * To get API URL from all controllers
				 */
				String patter = mappingInfo.getPatternsCondition().toString();

				String patterValue = patter.replace("[", "").replace("]", "");

				/*
				 * To Skip If Url we get in patternValue is Any Of the Following
				 */
				if (patterValue.equalsIgnoreCase("/getallurl")) {
					continue;
				}
				if (patterValue.equalsIgnoreCase("/v2/api-docs")) {
					continue;
				}
				if (patterValue.equalsIgnoreCase("/configuration/security")) {
					continue;
				}
				if (patterValue.equalsIgnoreCase("/configuration/ui")) {
					continue;
				}
				if (patterValue.equalsIgnoreCase("/swagger-resources")) {
					continue;
				}
				/*
				 * To Put all Url in mapDetails with their status
				 */
				mapDetails.put("url", patterValue);
				mapDetails.put("is_added", false);
				/*
				 * Add Url Map in List
				 */
				list.add(mapDetails);

			}
			/*
			 * Set response Message and return response with all urls
			 */
			message.setDescription("URL Details");
			message.setObject(list);
			message.setValid(true);

			return message;

		} catch (Exception e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	public Message mappingHandler(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To Initialize the response Message
		 */
		Message message = new Message();

		try {

			/*
			 * To Check It File Path is null send Error in Response
			 */
			if (map.get("file_path") == null) {
				message.setDescription("File Path is Required.");
				message.setValid(false);
				return message;
			}

			/*
			 * If file written Successfully than return Response with file Path
			 * in return
			 */
			FileWriter writer = new FileWriter(new File(map.get("file_path")));
			writer.write(map.get("auth_mapping"));
			writer.close();
			Constant.accessmap.remove(request.getAttribute("access_key"));
			String roleId = request.getAttribute("role_id").toString();
			// System.out.println("roleId" + roleId +
			// request.getHeader("user_id").toString()
			// + request.getHeader("user_key").toString());

			String getPermissionParam = "?role_id=" + roleId;
			Map<String, String> headerMap = new LinkedHashMap<>();

			// Get the Authorization Engine token
			headerMap.put("token", String.valueOf(request.getHeader("access_token")));

			headerMap.put("user_key", String.valueOf(request.getHeader("user_key")));
			headerMap.put("user_id", String.valueOf(request.getHeader("user_id")));

			Object accessPermision = urlCalling.getData(urlParameter.getGetAllPermisions(), getPermissionParam,
					headerMap);

			Message urlMessage = (Message) new Gson().fromJson(accessPermision.toString(), Message.class);
			Constant.accessmap.put(request.getAttribute("access_key").toString(), urlMessage.getObject());
			// System.out.println("------------------------******************************_______________________");
			// System.out.println(Constant.accessmap.get(request.getAttribute("access_key").toString()));
			message.setDescription("File Write Successfully");
			message.setObject(map.get("file_path"));
			message.setValid(true);

			return message;

		} catch (Exception e) {
			/*
			 * Error in writing the File with Error message in response
			 */
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}
}
