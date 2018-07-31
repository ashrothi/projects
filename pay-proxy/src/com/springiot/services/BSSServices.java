//package com.springiot.services;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.springiot.response.Message;
//
//@Service
//@Transactional
//public class BSSServices {
//	public Message bssGetUserBatchAPI(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response){
//		/**
//		 * To Initialize the response Message
//		 */
//		Message responseMessage = new Message();
//		passingMap.get("");
//		request.getHeader("");
//		try {
//			return responseMessage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseMessage.setDescription("Process Fail :- " + e.getMessage());
//			responseMessage.setValid(false);
//			return responseMessage;
//		}
//	}
//	
//	public Message bssUpdate(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response){
//		/**
//		 * To Initialize the response Message
//		 */
//		Message responseMessage = new Message();
//		passingMap.get("");
//		request.getHeader("");
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
