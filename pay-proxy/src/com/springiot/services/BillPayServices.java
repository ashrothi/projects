//package com.springiot.services;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.google.gson.Gson;
//import com.springiot.response.Message;
//
//@Service
//@Transactional
//public class BillPayServices {
//	/*public Message checkStatus(String group_id) {
//		// To Initialize the response Message
//		Message responseMessage = new Message();
//
//		try {
//			return responseMessage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseMessage.setDescription("Process Fail :- " + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//		}
//	}*/
//	
//	public Message GimmiSetupRegistration(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response) {
//		// To Initialize the response Message
//		Message responseMessage = new Message();
//		String authToken = request.getHeader("authToken");
//		String interfaceId = passingMap.get("interfaceId");
//		String securityEntity = passingMap.get("securityEntity");
//		String securityEntityValue = passingMap.get("securityEntityValue");
//		String action = passingMap.get("action");
//		String actionReference = passingMap.get("actionReference");
//		String consumerReturnUrl = passingMap.get("consumerReturnUrl");
//		String transactionDescription = passingMap.get("transactionDescription");
//		String accountNumber = passingMap.get("accountNumber");
//		String amount = passingMap.get("amount");
//		String domain = passingMap.get("domain");
//		
//		HashMap<String, String> headerMap = new HashMap<>();
//		headerMap.put("interfaceId", interfaceId);
//		headerMap.put("securityEntity", securityEntity);
//		headerMap.put("securityEntityValue", securityEntityValue);
//		headerMap.put("action", action);
//		headerMap.put("actionReference", actionReference);
//		
//		HashMap<String, String> gimmiConsumerSegmentMap = new HashMap<>();
//		gimmiConsumerSegmentMap.put("consumerReturnUrl", consumerReturnUrl);
//		gimmiConsumerSegmentMap.put("transactionDescription", transactionDescription);
//		
//		HashMap<String, String> serviceInfoMap = new HashMap<>();
//		serviceInfoMap.put("accountNumber", accountNumber);
//		serviceInfoMap.put("amount", amount);
//		serviceInfoMap.put("domain", domain);
//		
//		HashMap<String, Object> gimmiRequestMap = new HashMap<>();
//		gimmiRequestMap.put("header", headerMap);
//		gimmiRequestMap.put("gimmiConsumerSegment", gimmiConsumerSegmentMap);
//		gimmiRequestMap.put("serviceInfo", serviceInfoMap);
//
//		HashMap<String, Object> requestMap = new HashMap<>();
//		requestMap.put("gimmiRequest", gimmiRequestMap);
//		
//		System.out.println(new Gson().toJson(requestMap));
//
//		try {
//			responseMessage.setDescription("Process Success.");
//			responseMessage.setList((List<Object>) requestMap);
//			responseMessage.setValid(true);
//			return responseMessage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseMessage.setDescription("Process Fail :- " + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//		}
//	}
//	public Message GimmiEnquiry(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response) {
//		// To Initialize the response Message
//		Message responseMessage = new Message();
//		
//		String authToken = request.getHeader("authToken");
//		String interfaceId = passingMap.get("interfaceId");
//		String securityEntity = passingMap.get("securityEntity");
//		String securityEntityValue = passingMap.get("securityEntityValue");
//		String action = passingMap.get("action");
//		String billPayTokenId = passingMap.get("billPayTokenId");
//		
//		HashMap<String, String> headerMap = new HashMap<>();
//		headerMap.put("interfaceId", interfaceId);
//		headerMap.put("securityEntity", securityEntity);
//		headerMap.put("securityEntityValue", securityEntityValue);
//		headerMap.put("action", action);
//		
//		HashMap<String, String> enquirySegmentMap = new HashMap<>();
//		enquirySegmentMap.put("billPayTokenId", billPayTokenId);
//		
//		HashMap<String, Object> gimmiRequestMap = new HashMap<>();
//		gimmiRequestMap.put("header", headerMap);
//		gimmiRequestMap.put("enquirySegment", enquirySegmentMap);
//
//		HashMap<String, Object> requestMap = new HashMap<>();
//		requestMap.put("gimmiRequest", gimmiRequestMap);
//		
//		System.out.println(new Gson().toJson(requestMap));
//		
//		try {
//			return responseMessage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseMessage.setDescription("Process Fail :- " + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//		}
//	}
//	public Message PaymentOperation(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response) {
//		// To Initialize the response Message
//		Message responseMessage = new Message();
//		
//		String authToken = request.getHeader("authToken");
//		String interfaceId = passingMap.get("interfaceId");
//		String amount = passingMap.get("amount");
//		String accountNumber = passingMap.get("accountNumber");
//		String secondaryNumber = passingMap.get("secondaryNumber");
//		String paymentType = passingMap.get("paymentType");
//		String finInstrumentReferenceType = passingMap.get("finInstrumentReferenceType");
//		String finInstrumentReference = passingMap.get("finInstrumentReference");
//		
//		HashMap<String, String> headerMap = new HashMap<>();
//		headerMap.put("interfaceId", interfaceId);
//		
//		HashMap<String, String> serviceInfoMap = new HashMap<>();
//	    serviceInfoMap.put("amount", amount);
//		serviceInfoMap.put("accountNumber", accountNumber);
//		serviceInfoMap.put("secondaryNumber", secondaryNumber);
//		serviceInfoMap.put("paymentType", paymentType);
//		serviceInfoMap.put("finInstrumentReferenceType", finInstrumentReferenceType);
//		serviceInfoMap.put("finInstrumentReference", finInstrumentReference);
//		
//		HashMap<String, Object> paymentRequestMap = new HashMap<>();
//		paymentRequestMap.put("header", headerMap);
//		paymentRequestMap.put("serviceInfo", serviceInfoMap);
//
//		HashMap<String, Object> requestMap = new HashMap<>();
//		requestMap.put("paymentRequest", paymentRequestMap);
//		
//		System.out.println(new Gson().toJson(requestMap));
//		
//		try {
//			return responseMessage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseMessage.setDescription("Process Fail :- " + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//		}
//	}
//}
