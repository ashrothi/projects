/**
 * This package contain the Service class for Mapping Handler Service to get all API url and refresh API view
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class Mapping Handler Service to get all API url
 * and refresh API view
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@Transactional
public class MappingHandlerService {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;

	public Message getAPIsMapping() {
		/**
		 * To Inizialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * To Inizialize the response List
			 * 
			 */
			List<Map<String, Object>> responseList = new ArrayList<>();

			/**
			 * To Get ALL the Methods and APIS from Controller
			 */
			Map<RequestMappingInfo, HandlerMethod> passingMap = handlerMapping.getHandlerMethods();

			for (RequestMappingInfo mappingInfo : passingMap.keySet()) {

				Map<String, Object> mapDetails = new HashMap<>();
				/**
				 * To get API URL from all controllers
				 */
				String patter = mappingInfo.getPatternsCondition().toString();

				String patterValue = patter.replace("[", "").replace("]", "");
				/**
				 * To Print Url
				 */
				System.out.println(patterValue);
				/**
				 * To Skip If Url we get in patterValue is Any Of the Following
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
				/**
				 * To Put all Url in mapDetails with their status
				 */
				mapDetails.put("url", patterValue);
				mapDetails.put("is_added", false);
				/**
				 * Add Url Map in List
				 */
				responseList.add(mapDetails);

			}
			/**
			 * Set response Message and return response with all urls
			 */
			responseMessage.setDescription("URL Details");
			responseMessage.setObject(responseList);
			responseMessage.setValid(true);

			return responseMessage;

		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * If Url not Found Error Message
		 */
		responseMessage.setDescription("URL Details Not Found");
		responseMessage.setValid(false);
		return responseMessage;

	}

	public Message mappingHandler(Map<String, String> passingMap) {
		/**
		 * To Inizialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * To Print Parameter Message
			 */
			System.out.println("passingMap data:-" + passingMap);
			/*
			 * To Check It File Path is null send Error in Response
			 */
			if (passingMap.get("file_path") == null) {
				responseMessage.setDescription("File Path is Required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			/**
			 * To Write File with ALL the details
			 */
			FileWriter writer = new FileWriter(new File(passingMap.get("file_path")));
			writer.write(passingMap.get("auth_mapping"));
			writer.close();
			/**
			 * If file written Successfully than return Response with file Path
			 * in return
			 */
			responseMessage.setDescription("File Write Successfully");
			responseMessage.setObject(passingMap.get("file_path"));
			responseMessage.setValid(true);

			return responseMessage;

		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * Error in writing the File with Error message in response
		 */
		responseMessage.setDescription("File Not write");
		responseMessage.setValid(false);
		return responseMessage;
	}

}
