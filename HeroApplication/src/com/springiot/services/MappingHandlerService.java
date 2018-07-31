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

import com.springiot.modal.SwaggerClassGenerator;
import com.springiot.modal.TemplateSwagger;
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
			if (passingMap.get("filepath") == null) {
				responseMessage.setDescription("File Path is Required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			/**
			 * To Write File with ALL the details
			 */
			FileWriter writer = new FileWriter(new File(passingMap.get("filepath")));
			writer.write(passingMap.get("auth_mapping"));
			writer.close();
			/**
			 * If file written Successfully than return Response with file Path
			 * in return
			 */
			responseMessage.setDescription("File Write Successfully");
			responseMessage.setObject(passingMap.get("filepath"));
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

	@SuppressWarnings("static-access")
	public Message getAPIsMappingClass() {
		Message message = new Message();

		try {

			List<Map<String, Object>> list = new ArrayList<>();

			Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();

			for (RequestMappingInfo mappingInfo : map.keySet()) {

				Map<String, Object> mapDetails = new HashMap<>();

				String patter = mappingInfo.getPatternsCondition().toString();

				String patterValue = patter.replace("[", "").replace("]", "");

				System.out.println(patterValue);

				/*
				 * List of API URL's which does not require token as a
				 * parameter.
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
				mapDetails.put("url", patterValue);
				mapDetails.put("is_added", false);
				list.add(mapDetails);

				String newname = patterValue.replaceFirst("/", "");
				StringBuffer res = new StringBuffer();
				String[] strArr = newname.split("/");
				for (String str : strArr) {
					System.out.println(str);
					char[] stringArray = str.trim().toCharArray();
					stringArray[0] = Character.toUpperCase(stringArray[0]);
					str = new String(stringArray);

					res.append(str).append("");
				}
				String name = res.toString();
				res.append("Swagger");
				String newName = res.toString();
				System.out.print("Result: " + res.toString().trim());
				Map<String, String> templateMap = new HashMap<>();
				templateMap.put("name", newName);
				templateMap.put("newname", name);
				templateMap.put("url", patterValue);
				TemplateSwagger templateReport = new TemplateSwagger();
				String responsedata = templateReport.TemplateReportFile("template/swagger.vm",
						templateMap);

				String path = "/home/tanvigarg/Documents/eclipse-workspace/hero-api-spring/src/com/springiot/swagger/response/"
						+ templateMap.get("name") + ".java";
				System.out.println(responsedata);
				String value = SwaggerClassGenerator.generatePDF(responsedata, path);

				System.out.println(value);
				mapDetails.put("Class", newName);
				list.add(mapDetails);
			}

			/*
			 * Setting the response message of respective API's.
			 */
			message.setDescription("URL Details");
			message.setObject(list);
			message.setValid(true);
			return message;

		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		message.setDescription("URL Details Not Found");
		message.setValid(false);
		return message;
	}
}
