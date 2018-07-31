/**
 * This Package contains Services of Third Party Orchestration API.
 */
package org.thirdparty.services;

import java.lang.reflect.Type;

/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.orchestration.services.GenericMethodService;
import org.orchestration.services.OrchestrationGenericProcess;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thirdparty.request.model.Message;
import org.thirdparty.resources.JsonModification;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import com.google.gson.JsonParser;


/**
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@SuppressWarnings({ "unchecked", "rawtypes", "serial", "unused" })
public class ThirdPartyService {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	@Autowired(required = true)
	private OrchestrationGenericProcess orchestrationGenericProcess;

	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private GTServices gtServices;

	Logger logger = Logger.getLogger(ThirdPartyService.class);

	static String apiEnd = "***********************************API End*****************************************************";
	static String description = "description";
	static String priority = "priority";
	static String processFail = "Process Fail";

	/**
	 * This Method is to change SIM Profile on a device.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param simProfileData
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> simProfiles(String simProfileData, String deviceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * to get custom error codes for respective api
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Esim profile switch", request, response);
		try {
			logger.info(
					"***********************************Update SimProfile API*****************************************************");
			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(simProfileData, parameterMap);

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("iccid", String.valueOf(deviceId));

			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtSimProfile(parameterMap, deviceId, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {

			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Exception Error in Update SimProfile API ERROR ", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is Service to update settings on a device.1.Enable voice services
	 * (GMSA only) 2.Enable network attachment rule.
	 * 
	 * @param deviceId
	 *            SIM Number of the Device to be associated to account created for
	 *            the subscriber
	 * @param deviceSettingData
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> deviceSettings(String deviceSettingData, String deviceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * to get custom error codes for respective api
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Esim device setting", request, response);
		try {
			logger.info(
					"***********************************Update Device Seting API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(deviceSettingData, parameterMap);

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("iccid", String.valueOf(deviceId));

			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtDeviceSetting(parameterMap, deviceId, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Update Device Seting API Exception ERROR", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Service to Onboard a new subscriber with a device and maybe add a Demo or
	 * Trial WiFi plan.
	 * 
	 * @param onbordingRequestData
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */

	public ResponseEntity<?> onBoarding(String onbordingRequestData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get custom error code for Onboarding API
		 */
		logger.info("Getting Error Code For Onboarding");
		Map<String, Object> errorMap = methodService.getErrorCodes("OnBoardSubscriber", request, response);
		try {
			logger.info(
					"***********************************OnBoarding API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = JsonModification.parse(onbordingRequestData, new LinkedHashMap<>());

			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtOnboarding(parameterMap, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			/**
			 * Handle Exception If it Occurs
			 */

			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("OnBoarding API Exception ERROR", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is to offboard a specific Subscriber
	 * 
	 * @param offBoardingData
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> offBoarding(Optional<String> deviceId, String ban, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get custom error codes for OffBoarding
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Offboard Subscriber", request, response);
		try {
			logger.info(
					"***********************************OffBoarding API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			parameterMap.put("ban", ban);
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtOffBoarding(deviceId, ban, parameterMap, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("OffBoarding API Exception ERROR", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is used to get order details on a specific account including data
	 * usage.includeCancelled = true; returns details of all Active, Queued,
	 * Canceled, and Expired orders.IncludePending = true; returns details of any
	 * pending orders.Data usage details of the active order will always be returned
	 * if there is an active order
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getSubscriptionDetail(String ban, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To get Subscription Details API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Get Current Subscriber Orders", request, response);
		try {

			logger.info(
					"***********************************Get Subscription Detail API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("userIdentifier", ban);
			long epoch = System.currentTimeMillis();
			parameterMap.put("ban", ban);
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtGetSubscriptionDetail(ban, parameterMap, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			/**
			 * If Exception Occurs than to send Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Get Subscription Detail API  Exception ERROR", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This Method is used to get all offers applicable for a Country. This service
	 * returns the full product catalog.
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> getOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get Offer Details API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Get Available Offers", request, response);

		List<Map<String, Object>> finalResponseList = new LinkedList<>();
		try {
			logger.info(
					"***********************************Get Offer API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", String.valueOf(request.getParameter("country").trim()));
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtGetOffer(parameterMap, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			/**
			 * If Exception Occur than to return Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Get Offer API ERROR Exception", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Add Order on a specific account. Service can also be used on an existing
	 * account where carrier terms were never accepted before. As such, all
	 * subscriber details will be provided as done on Onboard API.
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param addOrder
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> addOrder(String ban, String addOrder, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get Add Order API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Add Order", request, response);
		try {
			logger.info(
					"***********************************Add Order API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(addOrder, parameterMap);
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtAddOrder(ban, parameterMap, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Add Order API ERROR Exception", e);
			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Cancel a specific order on a specific account. Carrier to lookup order
	 * details to get payment gateway details like transactionReference in order to
	 * apply any refund necessary to appropriate card
	 * 
	 * @param ban
	 *            billing account number created for the subscriber/device
	 * @param orderId
	 *            Order ID which has to be canceled
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the ‘user_name’
	 *            and ‘password’ separated by ‘:’, within a base64 and requestId and
	 *            returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	public ResponseEntity<?> cancelOrder(String ban, String orderId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get Cancel Order API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Cancel Order", request, response);
		try {
			logger.info(
					"***********************************Cancel Order API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("ban", ban);
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtCancelOrder(ban, orderId, parameterMap, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {

			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Cancel Order  API ERROR Exception", e);
			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * To Push the coming Data from ESIM Notification API to kafka queue
	 * 
	 * @param data
	 * @param request
	 * @param response
	 * @return
	 */

	public ResponseEntity<?> pushNotification(Object data, String kafka_type, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			logger.info(
					"***********************************Pushing Notification to Kafka Queue API*****************************************************");
			/**
			 * To Cast the data which need to push in kafka queue
			 */
			Type type = new TypeToken<List<Map<String, Object>>>() {
			}.getType();
			List<Map<String, Object>> dataToPush = new Gson().fromJson(data.toString(), type);
			/**
			 * Pushing Data in Kafka
			 */
			Boolean status = methodService.executeNotificationtoKafka(dataToPush, kafka_type, request, response);
			/**
			 * Checking Kafka status and sending response accordingly
			 */
			logger.info("Data Pushing to kafka Status " + status);

			if (status) {
				logger.info(apiEnd);
				return new ResponseEntity<>("True", HttpStatus.ACCEPTED);
			} else {
				logger.info(apiEnd);
				return new ResponseEntity<>("False", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			/**
			 * Handling Exception If it comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Pushing Notification to Kafka Queue API ERROR Exception", e);
			logger.info(apiEnd);
			return new ResponseEntity<>("False", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> gcProfileSwitch(String data, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * To get gc Profile Switch API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("GC switchProfile", request, response);
		try {
			logger.info(
					"***********************************GControl Profile Switch API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */

			parameterMap.put("tracking_message_header", String.valueOf(parameterMap.get("requestID")));
			parameterMap.put("requestId", String.valueOf(parameterMap.get("requestID")));
			parameterMap.put("ReturnURL", String.valueOf(parameterMap.get("returnUrl")));
			parameterMap.put("old_iccid", String.valueOf(parameterMap.get("targetICCID")));
			parameterMap.put("new_iccid", String.valueOf(parameterMap.get("currentICCID")));
			parameterMap.put("iccid", String.valueOf(parameterMap.get("currentICCID")));
			parameterMap.put("imsi", String.valueOf(parameterMap.get("targetIMSI")));
			parameterMap.put("msisdn", String.valueOf(parameterMap.get("targetMSISDN")));
			parameterMap.put("country", "GC");

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info("Calling Gcontrol API for Property changed after ESim Profile Switch Completed");

			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("GC switchProfile", parameterMap,
					request, response);
			/**
			 * Returning Response
			 */
			if (responseMessage.getStatusCode().is2xxSuccessful()) {
				Message message = genericProcess.GenericProcedureCalling("1", parameterMap, null, request, response);
			}
			logger.info(responseMessage);
			logger.info(apiEnd);
			return responseMessage;
		} catch (Exception e) {
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("GControl Profile Switch  API ERROR Exception", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description,
					errorMessage.get(description).toString().concat(e.getMessage()));/**
																						 * Returning Response
																						 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(finalErrorMessageMap);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> updateSubscriber(String updateSubscriberRequestData, String ban,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Update Subscriber", request, response);
		try {
			logger.info(
					"***********************************Update Subscriber API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = new LinkedHashMap<>();
			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(updateSubscriberRequestData, parameterMap);
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */

			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtUpdateSubscriber(parameterMap, ban, request, response);
			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Update Subscriber API ERROR Exception", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description,
					errorMessage.get(description).toString().concat(e.getMessage()));/**
																						 * Returning Response
																						 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> onboardingFromEsimNotification(String data, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * To get Onboarding API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("OnBoardSubscriber", request, response);
		try {
			logger.info(
					"***********************************Onboard Subscriber After Profile switch completed API*****************************************************");

			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);
			/**
			 * Checking onb_bit value to call !st Owner or Secand Owner
			 */
			logger.info("parameterMap " + parameterMap);
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtOnboardingFromEsimNotification(parameterMap, request, response);
			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			/**
			 * If Exception Occur than to return Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Onboard Subscriber After Profile switch completed API ERROR Exception ", e);
			logger.info(apiEnd);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> swapOnstarHardware(String swapOnstarHardwareRequestData, String ban,
			HttpServletRequest request, HttpServletResponse response) {
		/**
		 * To get Onboarding API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("HardwareSwapEsim", request, response);
		try {
			logger.info(
					"***********************************Swap Hardware API*****************************************************");

			/**
			 * Defining parameter Map which will be passing to OL core for validation and
			 * transformation and pushing data in kafka queue for ASYNC APIs or for SYNC
			 * API.
			 */
			Map<String, String> parameterMap = JsonModification.parse(swapOnstarHardwareRequestData,
					new LinkedHashMap<>());
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtSwapOnstarHardware(parameterMap, ban, request, response);

			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (

		Exception e) {
			/**
			 * Handle Exception If it Occurs
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Swap Hardware API ERROR Exception. ", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> swapHardwareRequestDataFromEsimNotification(String data, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> errorMap = methodService.getErrorCodes("HardwareSwap", request, response);
		try {
			logger.info(
					"***********************************Swap Hardware API after Profile switch completed*****************************************************");

			Map<String, String> parameterMap = new LinkedHashMap<>();

			/**
			 * To parse the requestBody parameter in MAP<String,String> format
			 */
			JsonModification.parse(data, parameterMap);
			ResponseEntity<?> getOperator = methodService.getOperatorConfig(parameterMap, request, response);

			if (!getOperator.getStatusCode().is2xxSuccessful()) {
				return getOperator;
			}
			logger.info(getOperator.getBody().toString());
			JsonModification.parse(getOperator.getBody().toString(), parameterMap);

			switch (String.valueOf(parameterMap.get("platform_name"))) {
			case "GT":
				return gtServices.gtSwapHardwareRequestDataFromEsimNotification(parameterMap, request, response);
			default:
				/**
				 * Send Error If Process Fails
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, errorMessage.get(description).toString().concat(processFail));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {
			/**
			 * If Exception Occur than to return Error Response
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Swap Hardware API after Profile switch completed ERROR Exception", e);
			logger.info(apiEnd);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> getProfileMappingData(String groupId, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errorMap = methodService.getErrorCodes(groupId, request, response);
		try {
			logger.info(
					"***********************************Publish Profile MappingResp API *****************************************************");

			logger.info("Getting Data from Esim  By calling PublishProfileMappingResp");
			parameterMap.put("country", "NILL");

			ResponseEntity<?> checkProfileExistence = methodService.genericExecuteApiMethod(groupId, parameterMap,
					request, response);

			logger.info("checkProfileExistence Response -->" + checkProfileExistence.getBody());

			Map<String, String> profileMappingResponseParameter = JsonModification
					.parse(checkProfileExistence.getBody().toString(), new LinkedHashMap<>());
			logger.info("Response Data from Esim  By calling PublishProfileMappingResp : \n"
					+ profileMappingResponseParameter);

			parameterMap.put("responseCode", profileMappingResponseParameter.get("responseCode"));

			/**
			 * To parse the requestBody parameter in MAP <String,String> format
			 */
			if (!checkProfileExistence.getStatusCode().is2xxSuccessful()) {
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				if (profileMappingResponseParameter.containsKey("responseDescription")) {
					errorMessage.put(description, errorMessage.get(description).toString()
							.concat(": " + profileMappingResponseParameter.get("responseDescription")));
					parameterMap.put("responseDescription", profileMappingResponseParameter.get("responseDescription"));
				} else {
					errorMessage.put(description, errorMessage.get(description).toString()
							.concat(": " + checkProfileExistence.getBody().toString()));

				}

				/**
				 * Returning Response
				 */

				logger.info(apiEnd);
				return checkProfileExistence;
			}
			logger.info("responseCode from Esim  By calling PublishProfileMappingResp::"
					+ profileMappingResponseParameter.get("responseCode"));
			if (!profileMappingResponseParameter.get("responseCode").equalsIgnoreCase("0")) {

				parameterMap.put("api_group_id", groupId);
				parameterMap.put("response_code", profileMappingResponseParameter.get("responseCode"));

				ResponseEntity<?> checkProfileExistenceFailureResponse = methodService
						.genericApiFailureNotifactionMethod("PublishProfileMappingReq", parameterMap, request, response);
				logger.info(apiEnd);
				return checkProfileExistenceFailureResponse;
			}

			/**
			 * To get List of imsiProfileData to fetch ICCID State
			 */
			String imsiProfileData = profileMappingResponseParameter.get("imsiProfileData").replace(":,", ":\"\",")
					.replace(":}", "\"\"}");

			/**
			 * Parse imsiProfileData in json format
			 */
			String imsiProfileDataJson = new JsonParser().parse(imsiProfileData).toString();
			/**
			 * Initialize List to get imsiProfileData
			 */
			List<Map<String, String>> imsiProfileDataList = new LinkedList<>();
			/**
			 * To check imsiProfileData is Array of json object
			 */
			if (String.valueOf(imsiProfileData).startsWith("[{") && String.valueOf(imsiProfileData).endsWith("}]")) {
				/**
				 * Define type to format imsiProfileData in List of Map
				 */
				Type listType = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				imsiProfileDataList = new Gson().fromJson(imsiProfileDataJson, listType);
			}
			/**
			 * To check imsiProfileData is json object
			 */
			if ((String.valueOf(imsiProfileData).startsWith("{") && String.valueOf(imsiProfileData).endsWith("}"))) {

				Type listType = new TypeToken<Map<String, String>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				Map<String, String> imsiProfileDataMap = new Gson().fromJson(imsiProfileDataJson, listType);
				imsiProfileDataList.add(imsiProfileDataMap);

			}

			/**
			 * Iterating List to get the Iccid state which has been Passed
			 */

			for (Map<String, String> map2 : imsiProfileDataList) {
				/**
				 * To get the state of iccid being passed by user.
				 */
				if (String.valueOf(map2.get("STATE")).equalsIgnoreCase("A")) {
					/**
					 * If iccid matches than add all parameter of that iccid in parameter map
					 */

					parameterMap.putAll(map2);

					logger.info("Active Profile Data : " + map2);

				}
				/**
				 * To get the bootstrap iccid to call profile switch API
				 */
				if (String.valueOf(map2.get("TYPE")).equalsIgnoreCase("B")) {

					parameterMap.put("BootstrapICCID", String.valueOf(map2.get("ICCID")));
					logger.info("BootstrapICCID : " + map2.get("ICCID"));
				}
				if (parameterMap.containsKey("originalDeviceId")
						&& String.valueOf(map2.get("ICCID")).equalsIgnoreCase(parameterMap.get("originalDeviceId"))) {
					parameterMap.put("ICCIDCountry", String.valueOf(map2.get("COUNTRY")));
					logger.info("ICCIDCountry : " + map2.get("COUNTRY"));
				}
			}

			if (parameterMap.get("STATE") == null) {

				logger.info("STATE is  " + parameterMap.get("STATE"));
				logger.setLevel(org.apache.log4j.Level.ERROR);

				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description,
						errorMessage.get(description).toString().concat(" ICCID is not configured at End Node."));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			/**
			 * To Check if iccid is bootstrap than put ProfileSwitchType 1.
			 */

			if (parameterMap.get("TYPE").equalsIgnoreCase("B")) {
				logger.info("TYPE is  " + parameterMap.get("TYPE"));
				parameterMap.put("ProfileSwitchType", "1");
				if (!parameterMap.containsKey("targetProfile")) {
					parameterMap.put("targetProfile", "bootstrap");
				}

			}
			/**
			 * To Check if iccid is Local than put ProfileSwitchType 2 or 3 as per country
			 * mismatch condition.
			 */
			if (parameterMap.get("TYPE").equalsIgnoreCase("L")) {
				/**
				 * If Country is same than ProfileSwitchType is 3
				 */
				logger.info("TYPE is  " + parameterMap.get("TYPE"));
				if (parameterMap.containsKey("countryCode")) {
					if (parameterMap.get("COUNTRY").equalsIgnoreCase(parameterMap.get("countryCode").trim())) {

						logger.info("TYPE is  " + parameterMap.get("TYPE") + " \n User's and Esim country are same "
								+ parameterMap.get("COUNTRY") + "---" + parameterMap.get("countryCode").trim());
						parameterMap.put("ProfileSwitchType", "3");
						if (!parameterMap.containsKey("targetProfile")) {
							parameterMap.put("targetProfile", "local");
						}

					} else {
						/**
						 * If Country is not same than ProfileSwitchType is 2
						 */

						logger.info(
								"TYPE is  " + parameterMap.get("TYPE") + " \n User's and Esim country are Different "
										+ parameterMap.get("COUNTRY") + "---" + parameterMap.get("countryCode").trim());
						Message message = genericProcess.GenericProcedureCalling("7", parameterMap, null, request,
								response);
						if (message.isValid()) {

							List<Map<String, Object>> profileStatusOfDiffCountry = (List<Map<String, Object>>) message
									.getObject();
							if (profileStatusOfDiffCountry.get(0).get("is_matched").toString().equalsIgnoreCase("1")) {
								logger.info("TYPE is  " + parameterMap.get("TYPE")
										+ " \n User's and Esim country are Different But Alias are same i.e both country have same profile "
										+ parameterMap.get("COUNTRY") + "---" + parameterMap.get("countryCode").trim());
								parameterMap.put("ProfileSwitchType", "3");
								if (!parameterMap.containsKey("targetProfile")) {
									parameterMap.put("targetProfile", "local");
								}
							} else {
								logger.info("TYPE is  " + parameterMap.get("TYPE")
										+ " \n User's and Esim country are Different But Alias are different i.e both country have different profile "
										+ parameterMap.get("COUNTRY") + "---" + parameterMap.get("countryCode").trim());
								parameterMap.put("ProfileSwitchType", "2");
								if (!parameterMap.containsKey("targetProfile")) {
									parameterMap.put("targetProfile", "local");
								}
							}
						}

					}
				}

			}
			logger.info(apiEnd);
			return new ResponseEntity<>(parameterMap, HttpStatus.ACCEPTED);
		} catch (

		Exception e) {
			/**
			 * Handle Exception If it Occurs
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Publish Profile MappingResp API ERROR Exception", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> getCheckUserExistence(String groupId, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errorMap = methodService.getErrorCodes(groupId, request, response);
		try {
			logger.info(
					"***********************************Check User Existence API *****************************************************");

			/**
			 * Calling checkUserExistence Sync API to validate value from end nodes
			 */
			logger.info(" Calling Check User Existence from BSS");
			parameterMap.put("country", String.valueOf(parameterMap.get("countryCode")).trim());
			ResponseEntity<?> checkUserExistence = methodService.genericExecuteApiMethod(groupId, parameterMap, request,
					response);
			logger.info(" Response of Check User Existence from BSS: " + checkUserExistence.getBody().toString());
			/**
			 * To check if response of sync api is success else send failure response to
			 * client
			 */
			if (!checkUserExistence.getStatusCode().is2xxSuccessful()) {
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");
				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> responseParameterMap = JsonModification.parse(checkUserExistence.getBody().toString(),
					new LinkedHashMap<>());
			/**
			 * To check the value of userExists
			 */
			logger.info("User Exist Status in Bss " + responseParameterMap.get("userExists"));
			if (checkUserExistence.getStatusCode() == HttpStatus.ACCEPTED) {
				parameterMap.putAll(responseParameterMap);

				if (String.valueOf(responseParameterMap.get("userExists")).equalsIgnoreCase("true")) {
					parameterMap.put("country", String.valueOf(parameterMap.get("countryCode")).trim());

					logger.info("User Exist Status in Bss " + responseParameterMap.get("userExists")
							+ " Calling User Purchase Existence API to check Purchase status");
					ResponseEntity<?> checkUserPurchaseExistenceResponse = methodService
							.genericExecuteApiMethod("ONBCheckPurchase", parameterMap, request, response);
					logger.info("Response User Purchase Existence API " + checkUserPurchaseExistenceResponse.getBody());
					if (!checkUserPurchaseExistenceResponse.getStatusCode().is2xxSuccessful()) {
						/**
						 * Returning Response
						 */
						Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");
						Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
						errorMessage.remove(priority);
						errorMessage.put("code", errorMessage.get("code"));
						/**
						 * Returning Response
						 */
						List<Map<String, Object>> errorList = new LinkedList<>();
						errorList.add(errorMessage);
						Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
						finalErrorMessageMap.put("errors", errorList);
						logger.info(apiEnd);
						return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
					}
					/**
					 * Initialize responseParameterMap to get checkUserExistence response parameters
					 */

					Map<String, String> responsePurchaseParameterMap = JsonModification
							.parse(checkUserPurchaseExistenceResponse.getBody().toString(), new LinkedHashMap<>());
					List<Map<String, String>> purchaseDataList;
					if (responsePurchaseParameterMap.get("entries") != null) {
						/**
						 * Parse purchaseData in json format
						 */
						String purchaseData = new JsonParser().parse(responsePurchaseParameterMap.get("entries"))
								.toString();

						Type listType = new TypeToken<List<Map<String, String>>>() {
						}.getType();
						/**
						 * Casting Json In List Of Map
						 */
						purchaseDataList = new Gson().fromJson(purchaseData, listType);
						if (purchaseDataList.isEmpty()) {

							parameterMap.put("purchaseExist", "false");
							logger.info("purchaseExist Status " + parameterMap.get("purchaseExist"));
						} else {
							parameterMap.put("purchaseExist", "true");
							StringBuilder planId = new StringBuilder();
							StringBuilder orderId = new StringBuilder();
							for (Map<String, String> map2 : purchaseDataList) {
								planId.append(String.valueOf(map2.get("id")) + "-#-");
								orderId.append(String.valueOf(map2.get("typeEntryId")) + "-#-");
							}
							planId.delete(planId.lastIndexOf("-#-"), planId.lastIndexOf("-#-") + 3);
							orderId.delete(orderId.lastIndexOf("-#-"), orderId.lastIndexOf("-#-") + 3);

							parameterMap.put("ids", planId.toString());
							parameterMap.put("orderId", orderId.toString());
							parameterMap.put("notificationParam", "ids-#-orderId");

							logger.info("purchaseExist Status " + parameterMap.get("purchaseExist"));
							logger.info("ids " + parameterMap.get("ids"));
							logger.info("orderId  " + parameterMap.get("orderId"));
							logger.info("notificationParam  " + parameterMap.get("notificationParam"));
						}

					}
				}
			}
			logger.info(apiEnd);
			return new ResponseEntity<>(parameterMap, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			/**
			 * Handle Exception If it Occurs
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);

			logger.error("Check User Existence API ERROR Exception", e);

			Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

			Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
			errorMessage.remove(priority);
			errorMessage.put("code", errorMessage.get("code"));
			errorMessage.put(description, errorMessage.get(description).toString().concat(e.getMessage()));
			/**
			 * Returning Response
			 */
			List<Map<String, Object>> errorList = new LinkedList<>();
			errorList.add(errorMessage);
			Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
			finalErrorMessageMap.put("errors", errorList);
			logger.info(apiEnd);
			return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
