//package com.springiot.services;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.springiot.response.Message;
//
//@Service
//@Transactional
//public class AdyenServices {
//	public Message insertPaymentStatus(String group_id) {
//		/**
//		 * To Initialize the response Message
//		 */
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
//	}
//	
//	public Message checkStatus(String group_id) {
//		/**
//		 * To Initialize the response Message
//		 */
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
//	}
//}
