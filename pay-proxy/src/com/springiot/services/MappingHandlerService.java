///**
// * This package contain the Service class for All Third Party Application for Flint
// */
//package com.springiot.services;
//
///**
// * To Import Classes to access their functionality
// */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.springiot.domain.SwaggerClassGenerator;
//import com.springiot.domain.TemplateSwagger;
//import com.springiot.response.Message;
//
///**
// * This class work as a Service class Mapping Handler Service to get all API url
// * and refresh API view
// * 
// * @author Mandeep Singh
// */
//@Service
//@Transactional
//public class MappingHandlerService {
//	/**
//	 * To access functionality of following Class function
//	 */
//	@Autowired
//	private RequestMappingHandlerMapping handlerMapping;
//
//	public Message getAPIsMapping() throws Exception {
//		/**
//		 * To Inizialize the response Message
//		 */
//		Message responseMessage = new Message();
//
//		try {
//			/**
//			 * To Inizialize the response List
//			 * 
//			 */
//			List<Map<String, Object>> responseList = new ArrayList<>();
//
//			/**
//			 * To Get ALL the Methods and APIS from Controller
//			 */
//			Map<RequestMappingInfo, HandlerMethod> passingMap = handlerMapping.getHandlerMethods();
//
//			for (RequestMappingInfo mappingInfo : passingMap.keySet()) {
//
//				Map<String, Object> mapDetails = new HashMap<>();
//				/**
//				 * To get API URL from all controllers
//				 */
//				String patter = mappingInfo.getPatternsCondition().toString();
//
//				String patterValue = patter.replace("[", "").replace("]", "");
//				
//				/**
//				 * To Skip If Url we get in patterValue is Any Of the Following
//				 */
//				if (patterValue.equalsIgnoreCase("/getallurl")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/v2/api-docs")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/configuration/security")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/configuration/ui")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/swagger-resources")) {
//					continue;
//				}
//				/**
//				 * To Put all Url in mapDetails with their status
//				 */
//				mapDetails.put("url", patterValue);
//				mapDetails.put("is_added", false);
//				/**
//				 * Add Url Map in List
//				 */
//				responseList.add(mapDetails);
//
//			}
//			/**
//			 * Set response Message and return response with all urls
//			 */
//			responseMessage.setDescription("URL Details");
//			responseMessage.setObject(responseList);
//			responseMessage.setValid(true);
//
//			return responseMessage;
//
//		} catch (Exception e) {
//			/**
//			 * To Catch exception if it comes
//			 */
//			e.printStackTrace();
//			responseMessage.setDescription("URL Details Not Found" + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//
//		}
//		/**
//		 * If Url not Found Error Message
//		 */
//
//	}
//
//	public Message mappingHandler(Map<String, String> passingMap) throws Exception {
//		/**
//		 * To Inizialize the response Message
//		 */
//		Message responseMessage = new Message();
//
//		try {
//			/*
//			 * To Check It File Path is null send Error in Response
//			 */
//			if (passingMap.get("filepath") == null) {
//				responseMessage.setDescription("File Path is Required.");
//				responseMessage.setValid(false);
//				return responseMessage;
//			}
//			/**
//			 * To Write File with ALL the details
//			 */
//			FileWriter writer = new FileWriter(new File(passingMap.get("filepath")));
//			writer.write(passingMap.get("auth_mapping"));
//			writer.close();
//			/**
//			 * If file written Successfully than return Response with file Path
//			 * in return
//			 */
//			responseMessage.setDescription("File Write Successfully");
//			responseMessage.setObject(passingMap.get("filepath"));
//			responseMessage.setValid(true);
//
//			return responseMessage;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseMessage.setDescription("File Not write" + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//		}
//	}
//
//	@SuppressWarnings({ "static-access", "unused" })
//	public Message getAPIsMappingClass() throws Exception {
//		Message message = new Message();
//
//		try {
//
//			List<Map<String, Object>> list = new ArrayList<>();
//
//			Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();
//
//			for (RequestMappingInfo mappingInfo : map.keySet()) {
//
//				Map<String, Object> mapDetails = new HashMap<>();
//				String patter = mappingInfo.getPatternsCondition().toString();
//				String patterValue = patter.replace("[", "").replace("]", "");
//
//				/*
//				 * List of API URL's which does not require token as a
//				 * parameter.
//				 */
//				if (patterValue.equalsIgnoreCase("/getallurl")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/v2/api-docs")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/configuration/security")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/configuration/ui")) {
//					continue;
//				}
//				if (patterValue.equalsIgnoreCase("/swagger-resources")) {
//					continue;
//				}
//				mapDetails.put("url", patterValue);
//				mapDetails.put("is_added", false);
//				list.add(mapDetails);
//
//				String newname = patterValue.replaceFirst("/", "");
//				StringBuffer res = new StringBuffer();
//				String[] strArr = newname.split("/");
//				for (String str : strArr) {
//					
//					char[] stringArray = str.trim().toCharArray();
//					stringArray[0] = Character.toUpperCase(stringArray[0]);
//					str = new String(stringArray);
//
//					res.append(str).append("");
//				}
//				String name = res.toString();
//				res.append("Swagger");
//				String newName = res.toString();
//				
//				Map<String, String> templateMap = new HashMap<>();
//				templateMap.put("name", newName);
//				templateMap.put("newname", name);
//				templateMap.put("url", patterValue);
//				TemplateSwagger templateReport = new TemplateSwagger();
//				String responsedata = templateReport.TemplateReportFile("template/swagger.vm",
//						templateMap);
//
//				String path = "/home/mandeepsingh//workspace/pay-proxy/src/com/springiot/swagger/response/"
//						+ templateMap.get("name") + ".java";
//				
//				String value = SwaggerClassGenerator.generatePDF(responsedata, path);
//
//				
//				mapDetails.put("Class", newName);
//				list.add(mapDetails);
//			}
//
//			/*
//			 * Setting the response message of respective API's.
//			 */
//			message.setDescription("URL Details");
//			message.setObject(list);
//			message.setValid(true);
//			return message;
//
//		}
//		/*
//		 * Handling the occurring exceptions.
//		 */
//		catch (Exception e) {
//			e.printStackTrace();
//			message.setDescription("URL Details Not Found" + e.getMessage());
//			message.setValid(false);
//			return message;
//		}
//	}
//}
