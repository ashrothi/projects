/**
 * 
 */
package org.thirdparty.services;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * @author tanvigarg
 *
 */
@Service
@SuppressWarnings({ "unchecked", "rawtypes", "serial", "unused" })
public class GTServices {
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
	private ThirdPartyService thirdPartyService;
	Logger logger = Logger.getLogger(GTServices.class);

	static String apiEnd = "***********************************API End*****************************************************";
	static String description = "description";
	static String priority = "priority";
	static String processFail = "Process Fail";

	public ResponseEntity<?> gtSimProfile(Map<String, String> parameterMap, String deviceId, HttpServletRequest request,
			HttpServletResponse response) {
		/**
		 * to get custom error codes for respective api
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Esim profile switch", request, response);
		try {
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			parameterMap.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
			parameterMap.put("iccid", String.valueOf(deviceId));
			parameterMap.put("ICCID", String.valueOf(deviceId));
			parameterMap.put("country", String.valueOf(parameterMap.get("country_code")));
			parameterMap.put("RequestID", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("ReturnURL", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("host_address", request.getRemoteHost());
			/**
			 * Setting ProfileSwitchType as per targetProfile coming from client
			 */

			ResponseEntity<?> checkRequestId = methodService.checkRequestId("SimUpdateProfileMapping", parameterMap,
					request, response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}

			logger.info("ProfileType from Request " + parameterMap.get("targetProfile"));

			if (String.valueOf(parameterMap.get("targetProfile")).equalsIgnoreCase("bootstrap")) {

				parameterMap.put("ProfileType", "B");

			} else if (String.valueOf(parameterMap.get("targetProfile")).equalsIgnoreCase("local")) {

				parameterMap.put("ProfileType", "L");
			}
			logger.info("targetProfile from Request " + parameterMap.get("targetProfile") + " ProfileType fom OL : "
					+ parameterMap.get("ProfileType"));

			logger.info("Calling from Esim For SimProfile By calling PublishProfileMappingResp ");

			ResponseEntity<?> checkProfileExistence = thirdPartyService.getProfileMappingData("SimUpdateProfileMapping",
					parameterMap, request, response);
			if (!checkProfileExistence.getStatusCode().is2xxSuccessful()) {
				logger.info(apiEnd);
				return checkProfileExistence;
			}

			logger.info("responseCode from Esim For SimProfile By calling PublishProfileMappingResp::"
					+ parameterMap.get("responseCode"));
			if (!parameterMap.get("responseCode").equalsIgnoreCase("0")) {
				logger.info(apiEnd);
				return checkProfileExistence;
			}
			logger.info("parameterMap " + parameterMap);
			if (parameterMap.get("TYPE").equalsIgnoreCase("B")) {
				if (parameterMap.get("ProfileType").equalsIgnoreCase("B")) {
					logger.info(" Active Profile :" + parameterMap.get("TYPE") + " ProfileType "
							+ parameterMap.get("ProfileType"));

					parameterMap.put("ProfileSwitchType", "4");
					logger.info(" Active Profile :" + parameterMap.get("TYPE") + " ProfileType "
							+ parameterMap.get("ProfileType") + " ProfileSwitchType "
							+ parameterMap.get("ProfileSwitchType"));

				} else {
					parameterMap.put("ProfileSwitchType", "1");
					logger.info(" Active Profile :" + parameterMap.get("TYPE") + " ProfileType "
							+ parameterMap.get("ProfileType") + " ProfileSwitchType "
							+ parameterMap.get("ProfileSwitchType"));

				}
			}
			if (parameterMap.get("TYPE").equalsIgnoreCase("L")) {
				if (parameterMap.get("ProfileType").equalsIgnoreCase("B")) {

					parameterMap.put("ProfileSwitchType", "4");
					logger.info(" Active Profile :" + parameterMap.get("TYPE") + " ProfileType "
							+ parameterMap.get("ProfileType") + " ProfileSwitchType "
							+ parameterMap.get("ProfileSwitchType"));
					parameterMap.put("BootstrapICCID", String.valueOf(parameterMap.get("ICCID")));

				} else {
					/**
					 * If Country is same than ProfileSwitchType is 3
					 */
					if (parameterMap.get("COUNTRY").equalsIgnoreCase(parameterMap.get("countryCode").trim())) {

						parameterMap.put("ProfileSwitchType", "3");
						logger.info(" Active Profile :" + parameterMap.get("TYPE") + "ProfileType "
								+ parameterMap.get("ProfileType") + "ProfileSwitchType "
								+ parameterMap.get("ProfileSwitchType"));
					} else {
						/**
						 * If Country is not same than ProfileSwitchType is 2
						 */

						parameterMap.put("ProfileSwitchType", "2");
						logger.info(" Active Profile :" + parameterMap.get("TYPE") + "ProfileType "
								+ parameterMap.get("ProfileType") + "ProfileSwitchType "
								+ parameterMap.get("ProfileSwitchType"));
					}
				}
			}

			/**
			 * Inserting return url respective to request id in third party db
			 */

			parameterMap.put("data", new Gson().toJson(parameterMap));
			Message message = genericProcess.GenericProcedureCalling("4", parameterMap, null, request, response);

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Esim profile switch",
					parameterMap, request, response);
			/**
			 * Returning Response
			 */
			logger.info(apiEnd);
			return responseMessage;

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

	public ResponseEntity<?> gtDeviceSetting(Map<String, String> parameterMap, String deviceId,
			HttpServletRequest request, HttpServletResponse response) {
		/**
		 * to get custom error codes for respective api
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Esim device setting", request, response);
		try {
			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */

			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
			parameterMap.put("ICCID", String.valueOf(deviceId));
			parameterMap.put("iccid", String.valueOf(deviceId));
			parameterMap.put("RequestID", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("ReturnURL", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("host_address", request.getRemoteHost());
			parameterMap.put("country", String.valueOf(parameterMap.get("country_code")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			ResponseEntity<?> checkRequestId = methodService.checkRequestId("Esim device setting", parameterMap,
					request, response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			List<Map<String, String>> deviceSettingDataList = new LinkedList<>();
			String deviceSettingsData = parameterMap.get("deviceSettings").replace(":,", ":\"\",").replace(":}",
					"\"\"}");

			/**
			 * Parse imsiProfileData in json format
			 */
			String imsiProfileDataJson = new JsonParser().parse(deviceSettingsData).toString();
			if (String.valueOf(parameterMap.get("deviceSettings")).startsWith("[{")
					&& String.valueOf(parameterMap.get("deviceSettings")).endsWith("}]")) {
				/**
				 * Define type to format imsiProfileData in List of Map
				 */
				Type listType = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				deviceSettingDataList = new Gson().fromJson(imsiProfileDataJson, listType);
			}
			for (Map<String, String> map : deviceSettingDataList) {

				parameterMap.put(map.get("name"), map.get("value"));
			}

			/**
			 * Inserting returnUrl with requestId which will be used in Sending Notification
			 * to GM endnode.
			 */
			Message message = genericProcess.GenericProcedureCalling("3", parameterMap, null, request, response);
			ResponseEntity<?> responseMessage = null;
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			if (parameterMap.containsKey("networkAttachRule")) {
				responseMessage = methodService.genericExecuteApiMethod("Esim device setting", parameterMap, request,
						response);
				// /**
				// * Returning Response
				// *
				// */
				// logger.info(apiEnd);
				// return responseMessage;
			} else {
				if (parameterMap.containsKey("moveSimToAccount") && parameterMap.containsKey("changeRatingProfile")
						&& parameterMap.containsKey("changeCommunicationProfile")) {
					responseMessage = methodService.genericExecuteApiMethod("UpdateDeviceSettingGC", parameterMap,
							request, response);
					// /**
					// * Returning Response
					// *
					// */
					// logger.info(apiEnd);
					// return responseMessage;
				}
				if (parameterMap.containsKey("moveSimToAccount")) {
					responseMessage = methodService.genericExecuteApiMethod("moveSimToAccountGC", parameterMap, request,
							response);
					// /**
					// * Returning Response
					// *
					// */
					// logger.info(apiEnd);
					// return responseMessage;
				}
				if (parameterMap.containsKey("changeRatingProfile")) {
					responseMessage = methodService.genericExecuteApiMethod("changeRatingProfileGC", parameterMap,
							request, response);
					// /**
					// * Returning Response
					// *
					// */
					// logger.info(apiEnd);
					// return responseMessage;
				}

			}
			logger.info(apiEnd);
			return responseMessage;
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

	public ResponseEntity<?> gtOnboarding(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		/**
		 * To get custom error code for Onboarding API
		 */
		logger.info("Getting Error Code For Onboarding");
		Map<String, Object> errorMap = methodService.getErrorCodes("OnBoardSubscriber", request, response);
		/**
		 * To check if consent passed from user is true or yes else send failure
		 * response to user.
		 */
		try {
			logger.info("-------------------- " + parameterMap);
			parameterMap.put("address", String.valueOf(parameterMap.get("addressLine1"))
					.concat(" " + String.valueOf(parameterMap.get("addressLine2"))).replace(",", " "));
			parameterMap.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
			parameterMap.put("streetNo", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("addressLine1", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("addressLine2", String.valueOf(parameterMap.get("addressLine2").replace(",", " ")));
			parameterMap.put("RequestID", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			ResponseEntity<?> checkRequestId = methodService.checkRequestId("PublishProfileMappingReq", parameterMap,
					request, response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			/**
			 * Calling checkProfileExistence Sync API to validate value from end nodes
			 */
			logger.info("Getting Data from Esim For Onboarding By calling PublishProfileMappingResp");
			ResponseEntity<?> checkProfileExistence = thirdPartyService
					.getProfileMappingData("PublishProfileMappingReq", parameterMap, request, response);

			/**
			 * To parse the requestBody parameter in MAP <String,String> format
			 */
			if (!checkProfileExistence.getStatusCode().is2xxSuccessful()) {
				logger.info(apiEnd);
				return checkProfileExistence;
			}

			logger.info("responseCode from Esim For Onboarding By calling PublishProfileMappingResp :"
					+ parameterMap.get("responseCode"));
			if (!parameterMap.get("responseCode").equalsIgnoreCase("0")) {
				logger.info(apiEnd);
				return checkProfileExistence;
			}
			logger.info("Success Response  from Esim For Onboarding By calling PublishProfileMappingResp ");

			Map<String, String> profileMappingResponseParameter = (Map<String, String>) checkProfileExistence.getBody();
			/**
			 * Calling RedShift API to get home imsi,iccid and msisdn
			 */
			parameterMap.put("donor_imsi", String.valueOf(parameterMap.get("imsi")));
			parameterMap.put("donor_iccid", String.valueOf(parameterMap.get("iccid")));
			parameterMap.put("donor_msisdn", String.valueOf(parameterMap.get("msisdn")));

			ResponseEntity<?> redShiftAPIResponse = methodService.genericExecuteApiMethod("OnboardingRedshift",
					parameterMap, request, response);
			if (!redShiftAPIResponse.getStatusCode().is2xxSuccessful()) {
				return redShiftAPIResponse;
			} else {
				Map<String, String> redShiftParam = new LinkedHashMap<>();
				JsonModification.parse(String.valueOf(redShiftAPIResponse.getBody()), redShiftParam);
				parameterMap.put("home_imsi", String.valueOf(redShiftParam.get("imsi")));
				parameterMap.put("home_iccid", String.valueOf(redShiftParam.get("iccid")));
				parameterMap.put("home_msisdn", String.valueOf(redShiftParam.get("msisdn")));

			}
			/**
			 * Calling checkUserExistence Sync API to validate value from end nodes
			 */
			logger.info(" Calling Check User Existence from BSS");
			parameterMap.put("country", String.valueOf(parameterMap.get("countryCode")).trim());
			ResponseEntity<?> checkUserExistence = getCheckUserExistence("CheckUserExistsBatchAPI", parameterMap,
					request, response);
			logger.info(" Response of Check User Existence from BSS: " + checkUserExistence.getBody().toString());
			/**
			 * To check if response of sync api is success else send failure response to
			 * client
			 */
			if (!checkUserExistence.getStatusCode().is2xxSuccessful()) {
				logger.info(apiEnd);
				return checkUserExistence;
			}

			/**
			 * If the country is same than to call 1st and second owner respectively as per
			 * condition
			 */

			if (parameterMap.get("ProfileSwitchType").equalsIgnoreCase("3")) {
				if (parameterMap.get("COUNTRY").equalsIgnoreCase(parameterMap.get("countryCode"))) {
					if (String.valueOf(parameterMap.get("userExists")).equalsIgnoreCase("false")) {

						logger.info("1st Owner Same Country in ESim and Bss");

						ResponseEntity<?> responseMessage = methodService
								.genericExecuteApiMethod("OnboardingFalseConsent", parameterMap, request, response);
						logger.info(apiEnd);
						return responseMessage;

					} else {

						if (parameterMap.get("purchaseExist").equalsIgnoreCase("true")) {
							logger.info("2nd Owner Same Country in ESim and Bss and Purchase Exist ");
							ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("2ndOwnerCoOffCF",
									parameterMap, request, response);
							logger.info(apiEnd);
							return responseMessage;
						} else {
							logger.info("2nd Owner Same Country in ESim and Bss and Purchase Dosen't Exist ");
							ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
									"OnbSecondOwnerFalseConsent", parameterMap, request, response);
							logger.info(apiEnd);
							return responseMessage;
						}

					}
				} else {
					if (String.valueOf(parameterMap.get("userExists")).equalsIgnoreCase("false")) {

						logger.info("1st Owner Same Country and Same Alias in ESim and Bss");

						ResponseEntity<?> responseMessage = methodService
								.genericExecuteApiMethod("OnboardingFalseConsent", parameterMap, request, response);
						logger.info(apiEnd);
						return responseMessage;

					}
					parameterMap.put("country", String.valueOf(parameterMap.get("userIdentifier")).substring(0, 8)
							.trim().concat("|#@|" + parameterMap.get("countryCode")));
					parameterMap.put("operator_name", String.valueOf(parameterMap.get("operator_name")).trim()
							.concat("|#@|" + parameterMap.get("operator_name")));

					if (parameterMap.get("purchaseExist").equalsIgnoreCase("true")) {
						logger.info(
								"2nd Owner Different Country in ESim and Bss But Same Alias (i.e same Esim profile in Both Country) and Purchase  Exist ");
						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
								"ONBRemovePurchase|#@|OnboardingFalseConsent", parameterMap, request, response);
						logger.info(apiEnd);
						return responseMessage;
					} else {
						logger.info(
								"2nd Owner Different Country in ESim and Bss But Same Alias (i.e same Esim profile in Both Country) and Purchase Dosen't Exist ");

						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
								"ONBRemoveUser|#@|OnboardingFalseConsent", parameterMap, request, response);
						logger.info(apiEnd);
						return responseMessage;
					}
				}

			} else {

				if (parameterMap.get("ProfileSwitchType").equalsIgnoreCase("2")) {

					ResponseEntity<?> responseMessage = null;
					if (String.valueOf(parameterMap.get("userExists")).equalsIgnoreCase("false")) {
						logger.info(
								"1st Owner Different Country in ESim and Bss and Different Alias (i.e Different Esim profile in Both Country) ");

						parameterMap.put("country", String.valueOf(parameterMap.get("country_code")));
						responseMessage = methodService.genericExecuteApiMethod("New ONB", parameterMap, request,
								response);

					} else {

						/**
						 * If user doesn't exist than 1st Owner Onboarding will be done else 2nd Owner
						 * Onboarding will be done This will be recognized by onb_bit 1 or 2 for 1st
						 * Owner Onboarding and 2nd Owner Onboarding respectively
						 */

						/**
						 * Calling OL Core genericExecuteApiMethod Method to execute the API
						 */
						parameterMap.put("country", String.valueOf(parameterMap.get("userIdentifier")).substring(0, 8)
								.trim().concat("|#@|NILL"));
						parameterMap.put("operator_name", String.valueOf(parameterMap.get("operator_name")).trim()
								.concat("|#@|" + parameterMap.get("operator_name")));
						if (parameterMap.get("purchaseExist").equalsIgnoreCase("true")) {
							logger.info(
									"2nd Owner Different Country in ESim and Bss But Different Alias (i.e Different Esim profile in Both Country) and Purchase  Exist ");

							responseMessage = methodService.genericExecuteApiMethod("ONBRemovePurchase|#@|New ONB",
									parameterMap, request, response);

						} else {
							logger.info(
									"2nd Owner Different Country in ESim and Bss But Different Alias (i.e Different Esim profile in Both Country) and Purchase Dosen't Exist ");

							responseMessage = methodService.genericExecuteApiMethod("ONBRemoveUser|#@|New ONB",
									parameterMap, request, response);

						}

					}

					if (responseMessage.getStatusCode().is2xxSuccessful()) {
						parameterMap.put("onb_bit", String.valueOf("1"));
						parameterMap.put("data", new Gson().toJson(parameterMap));
						/**
						 * Inserting return url respective to request id in third party db
						 */
						logger.info("Data to be inserted in db ");
						Message dataInsertToDb = genericProcess.GenericProcedureCalling("4", parameterMap, null,
								request, response);
						logger.info("Data  inserted in db " + new Gson().toJson(parameterMap));

						if (dataInsertToDb.isValid()) {
							/**
							 * In data successfully insert in db than send response
							 */
							logger.info(apiEnd);
							return responseMessage;
						} else {
							/**
							 * Send Error If Process Fails
							 */
							Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

							Map<String, Object> errorMessage = new HashMap<String, Object>((Map) errorMessageMap);
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

					} else {
						/**
						 * To send failure response
						 */
						logger.info(apiEnd);
						return responseMessage;
					}
				}

			}

			if (parameterMap.get("ProfileSwitchType").equalsIgnoreCase("1")) {

				/**
				 * If user doesn't exist than 1st Owner Onboarding will be done else 2nd Owner
				 * Onboarding will be done This will be recognized by onb_bit 1 or 2 for 1st
				 * Owner Onboarding and 2nd Owner Onboarding respectively
				 */

				if (String.valueOf(parameterMap.get("userExists")).equalsIgnoreCase("false")) {
					logger.info("Bootstrap Profile is Active and 1st Owner Onboarding ");
					parameterMap.put("onb_bit", String.valueOf("1"));
				} else {
					logger.info("Bootstrap Profile is Active and 2nd Owner Onboarding ");
					parameterMap.put("onb_bit", String.valueOf("2"));
				}
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				parameterMap.put("country", String.valueOf(parameterMap.get("country_code")));

				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("New ONB", parameterMap,
						request, response);

				if (responseMessage.getStatusCode().is2xxSuccessful()) {

					parameterMap.put("data", new Gson().toJson(parameterMap));

					/**
					 * Inserting return url respective to request id in third party db
					 */

					Message message = genericProcess.GenericProcedureCalling("4", parameterMap, null, request,
							response);
					if (message.isValid()) {
						/**
						 * In data successfully insert in db than send response
						 */
						logger.info(apiEnd);
						return responseMessage;
					} else {
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

				} else {
					/**
					 * To send failure response
					 */
					logger.info(apiEnd);
					return responseMessage;
				}
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
		/**
		 * Send Error If Process Fails
		 */
		Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

		Map<String, Object> errorMessage = new HashMap<String, Object>((Map) errorMessageMap);
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

	public ResponseEntity<?> gtOffBoarding(Optional<String> deviceId, String ban, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get custom error codes for OffBoarding
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Offboard Subscriber", request, response);
		try {

			parameterMap.put("country", ban.substring(0, 8).trim());

			parameterMap.put("ban", ban);
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("userIdentifier", ban);
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			ResponseEntity<?> checkRequestId = methodService.checkRequestId("CheckUserExistsOffboarding", parameterMap,
					request, response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info("To Check if User Exist at Bss Node ");
			ResponseEntity<?> checkUserExistenceResponse = methodService
					.genericExecuteApiMethod("CheckUserExistsOffboarding", parameterMap, request, response);
			logger.info("To Check if Bss Node API called successfully : "
					+ checkUserExistenceResponse.getStatusCode().is2xxSuccessful());
			if (!checkUserExistenceResponse.getStatusCode().is2xxSuccessful()) {
				logger.info("Error Response from Bss Node API  than sending INTERNAL_SERVER_ERROR response to user. "
						+ checkUserExistenceResponse.getStatusCode().is2xxSuccessful());
				/**
				 * Returning Response
				 */
				return checkUserExistenceResponse;

			}
			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> responseParameterMap = JsonModification
					.parse(checkUserExistenceResponse.getBody().toString(), new LinkedHashMap<>());

			if (responseParameterMap.get("userExists") == null) {
				logger.info(
						"userExists Response is null from Bss Node API  than sending INTERNAL_SERVER_ERROR response to user. "
								+ checkUserExistenceResponse.getStatusCode().is2xxSuccessful());
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description,
						errorMessage.get(description).toString().concat("No response from endnode."));
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

			if (deviceId.isPresent()) {
				parameterMap.put("iccid", deviceId.get());
			}
			logger.info("userExists value from Bss End Node --> " + responseParameterMap.get("userExists"));
			if (responseParameterMap.get("userExists").equalsIgnoreCase("false")) {
				if (parameterMap.containsKey("iccid")
						&& !responseParameterMap.get("iccid").equalsIgnoreCase(parameterMap.get("iccid"))) {
					logger.info("If no user detail from Bss Node than sending Internal Server Error");
					parameterMap.put("api_group_id", "CheckUserExistsOffboarding");
					parameterMap.put("response_code", "635");

					ResponseEntity<?> checkUserExistenceFailureResponse = methodService
							.genericApiFailureNotifactionMethod("CheckUserExistsOffboarding", parameterMap, request,
									response);
					logger.info(apiEnd);
					return checkUserExistenceFailureResponse;
				} else {
					logger.info("If no user detail from Bss Node than sending Internal Server Error");
					parameterMap.put("api_group_id", "CheckUserExistsOffboarding");
					parameterMap.put("response_code", "634");

					ResponseEntity<?> checkUserExistenceFailureResponse = methodService
							.genericApiFailureNotifactionMethod("CheckUserExistsOffboarding", parameterMap, request,
									response);
					logger.info(apiEnd);
					return checkUserExistenceFailureResponse;
				}

			}
			parameterMap.putAll(responseParameterMap);
			parameterMap.put("home_imsi", String.valueOf(responseParameterMap.get("imsi")));
			parameterMap.put("home_iccid", String.valueOf(responseParameterMap.get("iccid")));
			parameterMap.put("home_msisdn", String.valueOf(responseParameterMap.get("msisdn")));
			ResponseEntity<?> redShiftAPIResponse = methodService.genericExecuteApiMethod("OffboardingRedshift",
					parameterMap, request, response);
			if (!redShiftAPIResponse.getStatusCode().is2xxSuccessful()) {
				return redShiftAPIResponse;
			} else {
				Map<String, String> redShiftParam = new LinkedHashMap<>();
				JsonModification.parse(String.valueOf(redShiftAPIResponse.getBody()), redShiftParam);
				if (String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("null")
						|| String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("")) {
					/**
					 * Returning Response
					 */
					Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("0");
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
				} else {
					if (String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("null")
							|| String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("")) {
						/**
						 * Returning Response
						 */
						Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("0");
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
					} else {
						parameterMap.put("donor_imsi", String.valueOf(redShiftParam.get("staticDonorImsi")));
						parameterMap.put("donor_iccid", String.valueOf(redShiftParam.get("staticDonorIccid")));
						parameterMap.put("donor_msisdn", String.valueOf(redShiftParam.get("staticDonorMsisdn")));
					}
				}

			}

			if (parameterMap.containsKey("iccid")
					&& !responseParameterMap.get("iccid").equalsIgnoreCase(parameterMap.get("iccid"))) {
				logger.info("If no user detail from Bss Node than sending Internal Server Error");
				parameterMap.put("api_group_id", "CheckUserExistsOffboarding");
				parameterMap.put("response_code", "635");

				ResponseEntity<?> checkUserExistenceFailureResponse = methodService
						.genericApiFailureNotifactionMethod("UpdateSubscriberGetUser", parameterMap, request, response);
				logger.info(apiEnd);
				return checkUserExistenceFailureResponse;
			}
			if (parameterMap.containsKey("userIdentifier") && !responseParameterMap.get("userIdentifier")
					.equalsIgnoreCase(parameterMap.get("userIdentifier"))) {
				logger.info("If no user detail from Bss Node than sending Internal Server Error");
				parameterMap.put("api_group_id", "CheckUserExistsOffboarding");
				parameterMap.put("response_code", "634");

				ResponseEntity<?> checkUserExistenceFailureResponse = methodService
						.genericApiFailureNotifactionMethod("UpdateSubscriberGetUser", parameterMap, request, response);
				logger.info(apiEnd);
				return checkUserExistenceFailureResponse;
			}

			/**
			 * Putting response parameter from Bss to parameter Map
			 */
			parameterMap.putAll(responseParameterMap);
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info("Calling API to check User Purchase at Bss Node. ");
			ResponseEntity<?> checkUserPurchaseExistenceResponse = methodService
					.genericExecuteApiMethod("GetExpireUserPurchase", parameterMap, request, response);
			logger.info("Response of API Check User Purchase at Bss Node. "
					+ checkUserPurchaseExistenceResponse.getStatusCode());
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
			 * Initialize responseParameterMap to get Check User Purchase response
			 * parameters
			 */
			Map<String, String> responsePurchaseParameterMap = JsonModification
					.parse(checkUserPurchaseExistenceResponse.getBody().toString(), new LinkedHashMap<>());
			/**
			 * to check if entries feild is not null .
			 */
			logger.info("Purchase data from Check User Purchase API " + responsePurchaseParameterMap.get("entries"));
			if (responsePurchaseParameterMap.get("entries") != null) {

				/**
				 * Parse entries in json format
				 */
				String purchaseData = new JsonParser().parse(responsePurchaseParameterMap.get("entries")).toString();
				/**
				 * Initialize List to get purchaseData
				 */
				List<Map<String, String>> purchaseDataList = new LinkedList<>();

				/**
				 * Define type to format purchaseData in List of Map
				 */
				Type listType = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				purchaseDataList = new Gson().fromJson(purchaseData, listType);
				if (purchaseDataList.size() == 0) {
					ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Offboard Subscriber",
							parameterMap, request, response);
					logger.info(apiEnd);
					return responseMessage;
				}
				/**
				 * Concating different plan ids to cancel them and send notification for each
				 * plan id from streaming
				 */
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

				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("CancelOrderOffboarding",
						parameterMap, request, response);
				logger.info(apiEnd);
				return responseMessage;

			} else {
				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Offboard Subscriber",
						parameterMap, request, response);
				logger.info(apiEnd);
				return responseMessage;
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
	public ResponseEntity<?> gtGetSubscriptionDetail(String ban, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get Subscription Details API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Get Current Subscriber Orders", request, response);
		try {

			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("userIdentifier", ban);
			long epoch = System.currentTimeMillis();
			parameterMap.put("tracking_message_header", String.valueOf(epoch));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			/**
			 * to check if user exist at bss node
			 */
			logger.info("To Check if user Exist at Bss End Node ");
			ResponseEntity<?> checkUserExistenceResponse = methodService
					.genericExecuteApiMethod("CheckUserExistsGetSubsDetails", parameterMap, request, response);
			/**
			 * Checking its response
			 */
			logger.info("Response of user Exist API from Bss End Node ");
			if (!checkUserExistenceResponse.getStatusCode().is2xxSuccessful()) {

				/**
				 * Returning Response
				 */

				logger.info("Error Response from Bss Node API  than sending INTERNAL_SERVER_ERROR response to user. "
						+ checkUserExistenceResponse.getStatusCode().is2xxSuccessful());
				logger.info(apiEnd);
				return checkUserExistenceResponse;
			}
			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> responseParameterMap = JsonModification
					.parse(checkUserExistenceResponse.getBody().toString(), new LinkedHashMap<>());

			if (responseParameterMap.get("userExists") == null) {
				logger.info(
						"userExists Response is null from Bss Node API  than sending INTERNAL_SERVER_ERROR response to user. "
								+ checkUserExistenceResponse.getStatusCode().is2xxSuccessful());
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");

				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description,
						errorMessage.get(description).toString().concat("No response from endnode."));
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
			logger.info("userExists value from Bss End Node --> " + responseParameterMap.get("userExists"));
			if (responseParameterMap.get("userExists").equalsIgnoreCase("false")) {
				/**
				 * Returning Customize code if some Exception comes
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description,
						" Invalid Parameter ban -".concat(errorMessage.get(description).toString()));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				logger.info(apiEnd);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);
			}

			/**
			 * Checking includeCancelled value to call the EndNode SYNC API accordingly
			 */
			Type listType = new TypeToken<Map<String, Object>>() {
			}.getType();
			/**
			 * Calling OL Core to get Notification Template
			 */
			List<Map<String, Object>> templateMap = (List<Map<String, Object>>) methodService
					.getNotificationTemplate("Get All Subscriber Orders", request, response);
			/**
			 * Initializing responseMessage
			 */
			ResponseEntity<?> responseMessage = null;
			/**
			 * Putting Condition as per requirement
			 */
			if (request.getParameter("includeCancelled").equalsIgnoreCase("false")) {
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				logger.info("Calling Bss Node API for includeCancelled false condition .............. ");
				responseMessage = methodService.genericExecuteApiMethod("Get All Subscriber Orders", parameterMap,
						request, response);

			}
			if (request.getParameter("includeCancelled").equalsIgnoreCase("true")) {
				/**
				 * Calling OL Core genericExecuteApiMethod Method to execute the API
				 */
				logger.info("Calling Bss Node API for includeCancelled true condition .............. ");
				responseMessage = methodService.genericExecuteApiMethod("Get Current Subscriber Orders", parameterMap,
						request, response);

			}
			/**
			 * If response is success
			 */
			if (responseMessage.getStatusCode().is2xxSuccessful()) {
				/**
				 * Initializing Final response
				 */
				Map<String, Object> apiResponse = new LinkedHashMap<>();
				/**
				 * Initializing final List to store all the data
				 */
				List<Map<String, Object>> FinalResponse = new LinkedList<>();
				/**
				 * To Store response parameter from End Node
				 */
				Map<String, String> responseParameterFromEndNode = new LinkedHashMap<>();
				JsonModification.parse(String.valueOf(responseMessage.getBody()), responseParameterFromEndNode);
				/**
				 * Assigning data to apiResponse
				 */
				apiResponse = new Gson().fromJson(String.valueOf(responseMessage.getBody().toString()), listType);
				/**
				 * Casting data in List<Map<String, Object>> format
				 */
				Type castingType = new TypeToken<List<Map<String, Object>>>() {
				}.getType();
				List<Map<String, Object>> responseListToManipulate = new Gson()
						.fromJson(responseParameterFromEndNode.get("entries"), castingType);
				/**
				 * Iterating List to manipulate date in requested format
				 */

				if (responseListToManipulate != null && responseListToManipulate.size() > 0) {
					for (Map<String, Object> map2 : responseListToManipulate) {
						StringBuffer responseStringBuilder = new StringBuffer();
						/**
						 * calculating volume in GB which is coming in bytes
						 */
						double volume = 0;
						try {
							volume = Double.parseDouble((map2.get("volume").toString()));
							map2.put("newVol", Math.round(volume / (1024 * 1024)) / 100);
						} catch (Exception e) {
							map2.put("newVol", 0);
						}

						/**
						 * Condition to manipulate data
						 */

						map2.put("planStatus", "Active");
						if (map2.get("suspended").toString().equalsIgnoreCase("true")) {
							map2.put("planStatus", "Suspended");
						}
						if (map2.get("expired").toString().equalsIgnoreCase("true")) {
							map2.put("planStatus", "Expired");
						}
						if (map2.get("removed").toString().equalsIgnoreCase("true")) {
							map2.put("planStatus", "Removed");
						}

						parameterMap.put("planId", map2.get("typeEntryId").toString().replaceAll("\\.0", ""));

						Message message = genericProcess.GenericProcedureCalling("6", parameterMap, null, request,
								response);
						if (message.isValid()) {
							List<Map<String, Object>> planIdResponse = (List<Map<String, Object>>) message.getObject();
							if (planIdResponse.size() > 0) {
								map2.put("typeEntryId", String.valueOf(planIdResponse.get(0).get("gm_plan_id")));
								map2.put("planDuration", String.valueOf(planIdResponse.get(0).get("plan_duration")));

							} else {
								/**
								 * plan_duration Returning Customize code if some Exception comes
								 */
								Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
								Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
								errorMessage.remove(priority);
								errorMessage.put("code", errorMessage.get("code"));
								errorMessage.put(description, errorMessage.get(description).toString()
										.concat(":" + "planId value not supported."));
								/**
								 * Returning Response
								 */
								List<Map<String, Object>> errorList = new LinkedList<>();
								errorList.add(errorMessage);
								Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
								finalErrorMessageMap.put("errors", errorList);
								logger.info(apiEnd);
								return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);
							}
						}
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

						if (map2.get("activationDate") != null) {
							try {
								Date activeDate = sdf.parse(map2.get("activationDate").toString());
								map2.put("activationDate", sdf.format(activeDate));
							} catch (Exception e) {
								map2.put("activationDate", "");
							}

						}

						try {
							Date purchaseDate = sdf.parse(map2.get("created").toString());
							map2.put("created", sdf.format(purchaseDate));
						} catch (Exception e) {
							map2.put("created", "");
						}
						try {
							Date expirationDate = sdf.parse(map2.get("expirationDate").toString());
							map2.put("expirationDate", sdf.format(expirationDate));
						} catch (Exception e) {

							map2.put("expirationDate", "");
						}

						if (map2.get("removed").toString().equalsIgnoreCase("false")
								&& map2.get("suspended").toString().equalsIgnoreCase("false")
								&& map2.get("networkActivated").toString().equalsIgnoreCase("false")
								&& map2.get("activationDate") == null) {
							map2.put("activationDate", "");
							map2.put("planStatus", "Queued");
						}
						map2.put("id", map2.get("id").toString().replaceAll("\\.0", ""));
						/**
						 * To compile the template and set the required response
						 */
						Pattern pattern = Pattern.compile("<.+?>");
						Matcher matcher = pattern
								.matcher(String.valueOf(templateMap.get(0).get("notifiation_template_template")));
						/**
						 * To set the template and store it in
						 */
						if (responseStringBuilder.length() == 0) {
							while (matcher.find()) {
								String match_case = matcher.group(0);

								if (map2.containsKey(match_case.replaceAll("[<,>]", ""))) {
									String match_case_value = String
											.valueOf(map2.get(match_case.replaceAll("[<,>]", "")));
									matcher.appendReplacement(responseStringBuilder, match_case_value);
								} else {
									String match_case_value = "";
									matcher.appendReplacement(responseStringBuilder, match_case_value);
								}

							}
							matcher.appendTail(responseStringBuilder);
						}
						/**
						 * Casting String in Map to add in FinalResponse List
						 */
						Map<String, Object> urlResponseMessage = new Gson()
								.fromJson(String.valueOf(responseStringBuilder), listType);
						/**
						 * Adding response in List
						 */
						FinalResponse.add(urlResponseMessage);
					}

				}
				/**
				 * Returning Response By Adding Final List in apiResponse
				 */
				logger.info("Response After all modification and manipulation : " + FinalResponse);
				apiResponse = new LinkedHashMap<>();
				apiResponse.put("orderDetails", FinalResponse);
				logger.info(apiEnd);
				return new ResponseEntity<>(apiResponse, responseMessage.getStatusCode());
			} else {

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
	public ResponseEntity<?> gtGetOffer(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get Offer Details API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Get Available Offers", request, response);

		List<Map<String, Object>> finalResponseList = new LinkedList<>();
		try {

			parameterMap.put("country", String.valueOf(request.getParameter("country").trim()));
			long epoch = System.currentTimeMillis();
			parameterMap.put("tracking_message_header", String.valueOf(epoch));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			/**
			 * Calling OL Core Method to get the API Response template
			 */
			List<Map<String, Object>> templateMap = (List<Map<String, Object>>) methodService
					.getNotificationTemplate("Get Available Offers", request, response);

			Type listType = new TypeToken<Map<String, Object>>() {
			}.getType();
			
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Get Available Offers",
					parameterMap, request, response);
			Map<String, Object> templateMapParam = new Gson().fromJson(
					String.valueOf(templateMap.get(0).get("notifiation_template_template").toString()), listType);
			List<Map<String, Object>> templateOfferList = (List<Map<String, Object>>) templateMapParam.get("offers");
			/**
			 * Initializing api Response
			 */
			if (!responseMessage.getStatusCode().is2xxSuccessful()) {
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
			Map<String, Object> apiResponse = new LinkedHashMap<>();
			apiResponse = new Gson().fromJson(String.valueOf(responseMessage.getBody().toString()), listType);
			/**
			 * Casting externalExtraPasses field from apiResponse in List<Map<String,
			 * Object>>
			 */

			logger.info("Response From Bss Node " + responseMessage.getBody().toString());
			List<Map<String, Object>> responseListToManipulate = (List<Map<String, Object>>) apiResponse.get("offers");

			if (responseListToManipulate != null && responseListToManipulate.size() > 0) {

				for (Map<String, Object> map2 : responseListToManipulate) {
					System.out.println(map2);
					parameterMap.put("planId", map2.get("planId").toString().replaceAll("\\.0", ""));

					Message message = genericProcess.GenericProcedureCalling("6", parameterMap, null, request,
							response);
					if (message.isValid()) {
						List<Map<String, Object>> planIdResponse = (List<Map<String, Object>>) message.getObject();
						if (planIdResponse.size() > 0) {
							map2.put("planId", String.valueOf(planIdResponse.get(0).get("gm_plan_id")));
							/**
							 * Manipulating Data as per requested data
							 */
							// map2.put("planDuration", map2.get("planDuration").toString());
							if (map2.get("planQuotaUnit").toString().equalsIgnoreCase("GB")) {
								double volume = Double.parseDouble((map2.get("planQuotaValue").toString()));

								map2.put("planQuotaValue", Math.round(volume / (1024 * 1024 * 1024)) / 100);
							}
							if (map2.get("planQuotaUnit").toString().equalsIgnoreCase("MB")) {
								double volume = Double.parseDouble((map2.get("planQuotaValue").toString()));

								map2.put("planQuotaValue", Math.round(volume / (1024 * 1024)) / 100);
							}
							// /**
							// * Map to store response Parameter
							// */
							// Map<String, Object> responseParameterMap = new LinkedHashMap<>();
							// /**
							// * Too add all template parameter
							// */
							// responseParameterMap.putAll(templateOfferList.get(0));
							// /**
							// * templateOfferList Parameter to get expected Response
							// */
							// for (String mapw : templateOfferList.get(0).keySet()) {
							// String value =
							// templateOfferList.get(0).get(mapw).toString().replaceAll("[<,>]", "");
							// if (map2.containsKey(value)) {
							// responseParameterMap.put(mapw, map2.get(value));
							// }
							// }
							/**
							 * Adding responseParameterMap in finalResponseList
							 */
							finalResponseList.add(map2);
						}
					}

				}

			}
			/**
			 * Returning Response after adding finalResponseList in apiResponse
			 */
			apiResponse = new LinkedHashMap<>();
			apiResponse.put("offers", finalResponseList);
			logger.info("Response after manipulation and modification...... " + responseMessage.getBody().toString());
			logger.info(apiEnd);
			return new ResponseEntity<>(apiResponse, responseMessage.getStatusCode());
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
	public ResponseEntity<?> gtAddOrder(String ban, Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * To get Add Order API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Add Order", request, response);
		try {

			if (parameterMap.get("consent").equalsIgnoreCase("false")) {

				/**
				 * Returning Customize code if some Exception comes
				 */
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description, "consent : ".concat(errorMessage.get(description).toString()));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);

			}

			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("ban", ban);
			parameterMap.put("addressLine1", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("addressLine2", String.valueOf(parameterMap.get("addressLine2").replace(",", " ")));
			parameterMap.put("address", String.valueOf(parameterMap.get("addressLine1").replace(",", " "))
					.concat(" " + String.valueOf(parameterMap.get("addressLine2").replace(",", " "))));
			parameterMap.put("streetNo", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("userIdentifier", ban);
			parameterMap.put("newPlanId", String.valueOf(parameterMap.get("planId")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));

			if (parameterMap.get("transactionReference") == null
					|| parameterMap.get("transactionReference").trim().isEmpty()
					|| parameterMap.get("transactionReference").trim().equalsIgnoreCase("")) {
				String uuid = UUID.randomUUID().toString();

				parameterMap.put("transactionReference", uuid);
			}

			ResponseEntity<?> checkRequestId = methodService.checkRequestId("Add Order", parameterMap, request,
					response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			parameterMap.put("donor_imsi", String.valueOf(parameterMap.get("imsi")));
			parameterMap.put("donor_iccid", String.valueOf(parameterMap.get("iccid")));
			parameterMap.put("donor_msisdn", String.valueOf(parameterMap.get("msisdn")));

			ResponseEntity<?> redShiftAPIResponse = methodService.genericExecuteApiMethod("AddOrderRedshift",
					parameterMap, request, response);
			if (!redShiftAPIResponse.getStatusCode().is2xxSuccessful()) {
				return redShiftAPIResponse;
			} else {
				Map<String, String> redShiftParam = new LinkedHashMap<>();
				JsonModification.parse(String.valueOf(redShiftAPIResponse.getBody()), redShiftParam);
				parameterMap.put("home_imsi", String.valueOf(redShiftParam.get("imsi")));
				parameterMap.put("home_iccid", String.valueOf(redShiftParam.get("iccid")));
				parameterMap.put("home_msisdn", String.valueOf(redShiftParam.get("msisdn")));

			}
			logger.info(
					"To Get Bss Plan Id from Gm Plan Id From the ThirdParty Db where the Mapping between two is present.");
			Message message = genericProcess.GenericProcedureCalling("5", parameterMap, null, request, response);
			if (message.isValid()) {
				List<Map<String, Object>> planIdResponse = (List<Map<String, Object>>) message.getObject();
				if (!planIdResponse.isEmpty()) {
					parameterMap.put("planId", String.valueOf(planIdResponse.get(0).get("bss_plan_id")));

				} else {
					/**
					 * Returning Customize code if some Exception comes
					 */
					/**
					 * Returning Customize code if some Exception comes
					 */
					Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
					Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
					errorMessage.remove(priority);
					errorMessage.put("code", errorMessage.get("code"));
					errorMessage.put(description,
							"Invalid Parameter: PlanId  ".concat(errorMessage.get(description).toString()));
					/**
					 * Returning Response
					 */
					List<Map<String, Object>> errorList = new LinkedList<>();
					errorList.add(errorMessage);
					Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
					finalErrorMessageMap.put("errors", errorList);
					return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);

				}
			}

			// logger.info("parameterMap " + parameterMap);

			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */

			if (String.valueOf(parameterMap.get("idType")).equalsIgnoreCase("null")
					|| String.valueOf(parameterMap.get("idType")).equalsIgnoreCase("")) {
				logger.info("Calling Group of Add Order API without idType. ");
				// changes 109 to Add Order.
				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Add Order", parameterMap,
						request, response);
				/**
				 * Returning Response
				 */
				logger.info(
						"*********************************** Response from Core***************************************************** \n "
								+ responseMessage);

				logger.info(apiEnd);
				return responseMessage;
			} else {
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

					Date date = format.parse(parameterMap.get("dateOfBirth"));
					Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
					calendar.setTime(date);

					parameterMap.put("year", String.valueOf(calendar.get(Calendar.YEAR)));
					parameterMap.put("month", String.valueOf(new SimpleDateFormat("MM").format(calendar.getTime())));
					parameterMap.put("day", String.valueOf(new SimpleDateFormat("dd").format(calendar.getTime())));

					logger.info(new SimpleDateFormat("MM").format(calendar.getTime()));
					logger.info(new SimpleDateFormat("dd").format(calendar.getTime()));
				} catch (Exception e) {

					parameterMap.put("year", String.valueOf("0000"));
					parameterMap.put("month", String.valueOf("00"));
					parameterMap.put("day", String.valueOf("00"));

				}

				ResponseEntity<?> responseMessageIdValidation;
				if (String.valueOf(parameterMap.get("idType")).equalsIgnoreCase("AUS_DRIVERS_LICENSE")) {
					responseMessageIdValidation = methodService.genericExecuteApiMethod("IdValidationDriverLicence",
							parameterMap, request, response);
					logger.info(
							"*********************************** Response from Core***************************************************** \n "
									+ responseMessageIdValidation);
				} else if (String.valueOf(parameterMap.get("idType")).equalsIgnoreCase("AUS_PASSPORT")) {
					responseMessageIdValidation = methodService.genericExecuteApiMethod("IdValidationAusPassport",
							parameterMap, request, response);
					logger.info(
							"*********************************** Response from Core***************************************************** \n "
									+ responseMessageIdValidation);

				} else if (String.valueOf(parameterMap.get("idType")).equalsIgnoreCase("MEDICARE_CARD")) {
					responseMessageIdValidation = methodService.genericExecuteApiMethod("IdValidationMedicareCard",
							parameterMap, request, response);
					logger.info(
							"*********************************** Response from Core***************************************************** \n "
									+ responseMessageIdValidation);

				} else if (String.valueOf(parameterMap.get("idType")).equalsIgnoreCase("AUS_VISA")) {
					responseMessageIdValidation = methodService.genericExecuteApiMethod("IdValidationInternationalVisa",
							parameterMap, request, response);
					logger.info(
							"*********************************** Response from Core***************************************************** \n "
									+ responseMessageIdValidation);
				} else {

					/**
					 * Returning Customize code if some Exception comes
					 */
					Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
					Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
					errorMessage.remove(priority);
					errorMessage.put("code", errorMessage.get("code"));
					errorMessage.put(description,
							"Invalid Parameter: idType  ".concat(errorMessage.get(description).toString()));
					/**
					 * Returning Response
					 */
					List<Map<String, Object>> errorList = new LinkedList<>();
					errorList.add(errorMessage);
					Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
					finalErrorMessageMap.put("errors", errorList);
					return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);
				}

				if (!responseMessageIdValidation.getStatusCode().is2xxSuccessful()) {
					if (responseMessageIdValidation.getStatusCode().is5xxServerError()) {
						/**
						 * Returning Customize code if some Exception comes
						 */
						Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("3");
						Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
						errorMessage.remove(priority);
						errorMessage.put("code", errorMessage.get("code"));
						errorMessage.put(description, errorMessage.get(description).toString());
						/**
						 * Returning Response
						 */
						List<Map<String, Object>> errorList = new LinkedList<>();
						errorList.add(errorMessage);
						Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
						finalErrorMessageMap.put("errors", errorList);
						return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.INTERNAL_SERVER_ERROR);
					} else {

						logger.info(
								"*********************************** Response from Core***************************************************** \n "
										+ responseMessageIdValidation);
						return responseMessageIdValidation;
					}

				}
				logger.info("Calling Group of Add Order API with idType. ");
				ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Add Order", parameterMap,
						request, response);
				/**
				 * Returning Response
				 */
				logger.info(
						"*********************************** Response from Core***************************************************** \n "
								+ responseMessage);
				logger.info(apiEnd);
				return responseMessage;
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
	public ResponseEntity<?> gtCancelOrder(String ban, String orderId, Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get Cancel Order API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Cancel Order", request, response);
		try {

			/**
			 * Putting Additional Parameter in MAP which will be used by OL core to send the
			 * call to endnodes.
			 */
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("ban", ban);
			parameterMap.put("orderId", orderId);
			parameterMap.put("userPurchaseId", orderId);
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("instanceId", String.valueOf(request.getParameter("instanceId")));
			parameterMap.put("refundType", String.valueOf(request.getParameter("refundType")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			parameterMap.put("userIdentifier", ban);
			ResponseEntity<?> checkRequestId = methodService.checkRequestId("Cancel Order", parameterMap, request,
					response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info("Calling Group for Cancel Order  API.");
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Cancel Order", parameterMap,
					request, response);
			/**
			 * Returning Response
			 */
			logger.info(apiEnd);
			return responseMessage;

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

	public ResponseEntity<?> gtUpdateSubscriber(Map<String, String> parameterMap, String ban,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To get update Subscriber API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("Update Subscriber", request, response);
		try {

			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("country", ban.substring(0, 8).trim());
			parameterMap.put("ban", ban);
			parameterMap.put("RequestID", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("userIdentifier", ban);
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			ResponseEntity<?> checkRequestId = methodService.checkRequestId("UpdateSubscriberGetUser", parameterMap,
					request, response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			logger.info("Calling Sync Group for Bss Get User Detail API of Bss End Node.");
			ResponseEntity<?> updateSubscriberGetUserResponse = methodService
					.genericExecuteApiMethod("UpdateSubscriberGetUser", parameterMap, request, response);

			logger.info("Response from Bss Node -> " + updateSubscriberGetUserResponse.getBody());
			if (!updateSubscriberGetUserResponse.getStatusCode().is2xxSuccessful()) {
				logger.info(apiEnd);
				return updateSubscriberGetUserResponse;
			}
			/**
			 * Initialize responseParameterMap to get checkUserExistence response parameters
			 */
			Map<String, String> updateSubscriberGetUserResponseParameterMap = JsonModification
					.parse(updateSubscriberGetUserResponse.getBody().toString(), new LinkedHashMap<>());
			/**
			 * Parse imsiProfileData in json format
			 */

			logger.info("USERS --> " + updateSubscriberGetUserResponseParameterMap.get("users"));

			String getUserData = new JsonParser().parse(updateSubscriberGetUserResponseParameterMap.get("users"))
					.toString();

			/**
			 * Define type to format imsiProfileData in List of Map
			 */
			Type listType = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			/**
			 * Initialize List to get imsiProfileData
			 */

			List<Map<String, String>> getUserDataList = new Gson().fromJson(getUserData, listType);

			parameterMap.put("address", String.valueOf(parameterMap.get("addressLine1").replace(",", " "))
					.concat(" " + String.valueOf(parameterMap.get("addressLine2").replace(",", " "))));
			parameterMap.put("streetNo", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));

			parameterMap.put("addressLine1", String.valueOf(parameterMap.get("addressLine1").replace(",", " ")));
			parameterMap.put("addressLine2", String.valueOf(parameterMap.get("addressLine2").replace(",", " ")));
			if (getUserDataList.size() == 0) {
				logger.info("If no user detail from Bss Node than sending Internal Server Error");
				parameterMap.put("api_group_id", "UpdateSubscriberGetUser");
				parameterMap.put("response_code", "634");

				ResponseEntity<?> checkUserExistenceFailureResponse = methodService
						.genericApiFailureNotifactionMethod("UpdateSubscriberGetUser", parameterMap, request, response);
				logger.info(apiEnd);
				return checkUserExistenceFailureResponse;
			} else {
				/**
				 * Comparing the country passed by user and the country coming from bss node
				 */

				parameterMap.put("home_imsi", String.valueOf(getUserDataList.get(0).get("imsi")));
				parameterMap.put("home_iccid", String.valueOf(getUserDataList.get(0).get("iccid")));
				parameterMap.put("home_msisdn", String.valueOf(getUserDataList.get(0).get("msisdn")));

				parameterMap.put("IMSI", String.valueOf(getUserDataList.get(0).get("imsi")));
				parameterMap.put("ICCID", String.valueOf(getUserDataList.get(0).get("iccid")));
				parameterMap.put("imsi", String.valueOf(getUserDataList.get(0).get("imsi")));
				parameterMap.put("iccid", String.valueOf(getUserDataList.get(0).get("iccid")));
				parameterMap.put("msisdn", String.valueOf(getUserDataList.get(0).get("msisdn")));

				parameterMap.put("accountType", String.valueOf(getUserDataList.get(0).get("accountType")));
				// parameterMap.get("accountType")
				ResponseEntity<?> redShiftAPIResponse = methodService
						.genericExecuteApiMethod("UpdateSubscriberRedshift", parameterMap, request, response);
				if (!redShiftAPIResponse.getStatusCode().is2xxSuccessful()) {
					return redShiftAPIResponse;
				} else {
					Map<String, String> redShiftParam = new LinkedHashMap<>();
					JsonModification.parse(String.valueOf(redShiftAPIResponse.getBody()), redShiftParam);
					if (String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("null")
							|| String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("")) {
						/**
						 * Returning Response
						 */
						Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("0");
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
					} else {
						parameterMap.put("donor_imsi", String.valueOf(redShiftParam.get("staticDonorImsi")));
						parameterMap.put("donor_iccid", String.valueOf(redShiftParam.get("staticDonorIccid")));
						parameterMap.put("donor_msisdn", String.valueOf(redShiftParam.get("staticDonorMsisdn")));
					}

				}

				if (parameterMap.get("countryCode")
						.equalsIgnoreCase(updateSubscriberGetUserResponseParameterMap.get("countryIsoCode"))) {
					logger.info(
							"Update Subscriber Calling When User Country from Bss  and Country passes by User is same.");

					ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("Update Subscriber",
							parameterMap, request, response);
					/**
					 * Returning Response
					 */
					logger.info(apiEnd);
					return responseMessage;
				} else {
					/**
					 * Checking User Purchase
					 */
					logger.info("Calling check User Purchase API of Bss node .");
					ResponseEntity<?> updateSubscriberCheckUserPurchaseResponse = methodService
							.genericExecuteApiMethod("101", parameterMap, request, response);
					logger.info("Response of  check User Purchase API of Bss node ."
							+ updateSubscriberCheckUserPurchaseResponse.getBody());
					if (updateSubscriberCheckUserPurchaseResponse.getStatusCode().is2xxSuccessful()) {

						/**
						 * Initialize responseParameterMap to get checkUserExistence response parameters
						 */
						Map<String, String> responsePurchaseParameterMap = JsonModification.parse(
								updateSubscriberCheckUserPurchaseResponse.getBody().toString(), new LinkedHashMap<>());

						if (responsePurchaseParameterMap.get("entries") != null) {

							/**
							 * Parse imsiProfileData in json format
							 */
							String purchaseData = new JsonParser().parse(responsePurchaseParameterMap.get("entries"))
									.toString();
							/**
							 * Initialize List to get imsiProfileData
							 */
							List<Map<String, String>> purchaseDataList = new LinkedList<>();

							/**
							 * Casting Json In List Of Map
							 */
							purchaseDataList = new Gson().fromJson(purchaseData, listType);
							if (purchaseDataList.size() == 0) {
								parameterMap.put("purchaseExist", "false");
								logger.info("purchaseExist Status " + parameterMap.get("purchaseExist"));
							} else {
								parameterMap.put("purchaseExist", "true");
								logger.info("purchaseExist Status " + parameterMap.get("purchaseExist"));
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
							}

						}
					} else {
						/**
						 * Returning Response
						 */
						logger.info("No Success Response From Bss End Node for Check Puchase Existence.");

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
					 * Getting Profile Mapping Data
					 */
					ResponseEntity<?> checkProfileExistence = thirdPartyService.getProfileMappingData("99",
							parameterMap, request, response);
					/**
					 * Sending Response if Failure response from Esim
					 */

					if (!checkProfileExistence.getStatusCode().is2xxSuccessful()) {
						logger.info(apiEnd);
						return checkProfileExistence;
					}
					/**
					 * Sending Response if responseCode is 0 in response from Esim
					 */
					if (!parameterMap.get("responseCode").equalsIgnoreCase("0")) {
						logger.info(apiEnd);
						return checkProfileExistence;
					}

					Map<String, String> profileMappingResponseParameter = (Map<String, String>) checkProfileExistence
							.getBody();
					if (parameterMap.get("purchaseExist").equalsIgnoreCase("false")
							&& parameterMap.get("ProfileSwitchType").equalsIgnoreCase("3")) {

						logger.info(
								"Update Subscriber Calling When purchaseExist is false and ProfileSwitchType is 3 that is same country ");
						parameterMap.put("country", String.valueOf(parameterMap.get("userIdentifier")).substring(0, 8)
								.trim().concat("|#@|" + parameterMap.get("countryCode")));
						parameterMap.put("operator_name", String.valueOf(parameterMap.get("operator_name")).trim()
								.concat("|#@|" + parameterMap.get("operator_name")));
						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
								"UpdateSubscriberRemoveUser|#@|UpdateSubscriberRegisterUser", parameterMap, request,
								response);
						logger.info(apiEnd);
						return responseMessage;
					}
					if (parameterMap.get("purchaseExist").equalsIgnoreCase("true")
							&& parameterMap.get("ProfileSwitchType").equalsIgnoreCase("3")) {
						logger.info(
								"Update Subscriber Calling When purchaseExist is true and ProfileSwitchType is 3 that is same country ");
						parameterMap.put("country", String.valueOf(parameterMap.get("userIdentifier")).substring(0, 8)
								.trim().concat("|#@|" + parameterMap.get("countryCode")));
						parameterMap.put("operator_name", String.valueOf(parameterMap.get("operator_name")).trim()
								.concat("|#@|" + parameterMap.get("operator_name")));
						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
								"UpdateSubscriberRemovePurchase|#@|UpdateSubscriberRegisterUser", parameterMap, request,
								response);
						logger.info(apiEnd);
						return responseMessage;
					}
					if (parameterMap.get("purchaseExist").equalsIgnoreCase("false")

							&& parameterMap.get("ProfileSwitchType").equalsIgnoreCase("2")) {
						parameterMap.put("onb_bit", String.valueOf("1"));
						String accoutType = parameterMap.get("accountType");

						String data = new Gson().toJson(parameterMap).replaceAll(accoutType, "PN");
						parameterMap.put("accountType", String.valueOf("PN"));
						parameterMap.put("data", data);
						/**
						 * Inserting return url respective to request id in third party db
						 */
						logger.info("Data to be inserted in db ");
						Message dataInsertToDb = genericProcess.GenericProcedureCalling("4", parameterMap, null,
								request, response);
						logger.info("Data  inserted in db " + new Gson().toJson(parameterMap));
						logger.info(
								"Update Subscriber Calling When purchaseExist is false and ProfileSwitchType is 2 that is different country ");
						parameterMap.put("country", String.valueOf(parameterMap.get("userIdentifier")).substring(0, 8)
								.trim().concat("|#@|" + String.valueOf(parameterMap.get("country_code"))));
						parameterMap.put("operator_name", String.valueOf(parameterMap.get("operator_name")).trim()
								.concat("|#@|" + parameterMap.get("operator_name")));
						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
								"UpdateSubscriberRemoveUser|#@|UpdateSubscriberUSP", parameterMap, request, response);
						logger.info(apiEnd);
						return responseMessage;
					}
					if (parameterMap.get("purchaseExist").equalsIgnoreCase("true")
							&& parameterMap.get("ProfileSwitchType").equalsIgnoreCase("2")) {
						parameterMap.put("onb_bit", String.valueOf("1"));
						String accoutType = parameterMap.get("accountType");

						String data = new Gson().toJson(parameterMap).replaceAll(accoutType, "PN");
						parameterMap.put("accountType", String.valueOf("PN"));
						parameterMap.put("data", data);
						/**
						 * Inserting return url respective to request id in third party db
						 */
						logger.info("Data to be inserted in db ");
						Message dataInsertToDb = genericProcess.GenericProcedureCalling("4", parameterMap, null,
								request, response);
						logger.info("Data  inserted in db " + new Gson().toJson(parameterMap));
						logger.info(
								"Update Subscriber Calling When purchaseExist is true and ProfileSwitchType is 2 that is different country ");
						parameterMap.put("country", String.valueOf(parameterMap.get("userIdentifier")).substring(0, 8)
								.trim().concat("|#@|" + String.valueOf(parameterMap.get("country_code"))));
						parameterMap.put("operator_name", String.valueOf(parameterMap.get("operator_name")).trim()
								.concat("|#@|" + parameterMap.get("operator_name")));
						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod(
								"UpdateSubscriberRemovePurchase|#@|UpdateSubscriberUSP", parameterMap, request,
								response);
						logger.info(apiEnd);
						return responseMessage;
					}

				}
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

	public ResponseEntity<?> gtSwapOnstarHardware(Map<String, String> parameterMap, String ban,
			HttpServletRequest request, HttpServletResponse response) {
		/**
		 * To get Onboarding API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("HardwareSwapEsim", request, response);
		try {

			/**
			 * Calling checkProfileExistence Sync API to validate value from end nodes
			 */

			if ((String.valueOf(parameterMap.get("originalDeviceId")).startsWith("{")
					&& String.valueOf(parameterMap.get("originalDeviceId")).endsWith("}"))
					&& (String.valueOf(parameterMap.get("newDeviceId")).startsWith("{")
							&& String.valueOf(parameterMap.get("newDeviceId")).endsWith("}"))) {

				Type listType = new TypeToken<Map<String, String>>() {
				}.getType();
				/**
				 * Casting Json In List Of Map
				 */
				Map<String, String> originalDeviceIdDataMap = new Gson().fromJson(parameterMap.get("originalDeviceId"),
						listType);
				parameterMap.put("originalDeviceId", originalDeviceIdDataMap.get("iccid"));
				Map<String, String> newDeviceIdDataMap = new Gson().fromJson(parameterMap.get("newDeviceId"), listType);
				parameterMap.put("newDeviceId", newDeviceIdDataMap.get("iccid"));

			}

			parameterMap.put("country", String.valueOf(parameterMap.get("country_code")));
			parameterMap.put("tracking_message_header", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("requestId", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("returnUrl", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("Accept", String.valueOf(request.getHeader("Accept")));
			parameterMap.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
			parameterMap.put("RequestID", String.valueOf(request.getHeader("requestId")));
			parameterMap.put("ReturnURL", String.valueOf(request.getHeader("returnUrl")));
			parameterMap.put("host_address", request.getRemoteHost());
			parameterMap.put("targetProfile", "local");

			parameterMap.put("swap_bit", String.valueOf("1"));
			parameterMap.put("ban", ban);
			parameterMap.put("userIdentifier", ban);

			/**
			 * Inserting return url respective to request id in third party db
			 */
			logger.info("Calling Esim Profile Switch API.");
			/**
			 * Getting Profile Mapping Data
			 */
			ResponseEntity<?> checkRequestId = methodService.checkRequestId("103", parameterMap, request, response);
			if (checkRequestId.getStatusCode().is5xxServerError()) {
				return checkRequestId;
			}
			logger.info("Param Map for  Esim Profile Switch API." + parameterMap);
			ResponseEntity<?> checkProfileExistence = thirdPartyService
					.getProfileMappingData("HardwareSwapProfileMapping", parameterMap, request, response);
			/**
			 * Sending Response if Failure response from Esim
			 */

			if (!checkProfileExistence.getStatusCode().is2xxSuccessful()) {
				logger.info(apiEnd);
				return checkProfileExistence;
			}
			/**
			 * Sending Response if responseCode is 0 in response from Esim
			 */
			if (!parameterMap.get("responseCode").equalsIgnoreCase("0")) {
				logger.info(apiEnd);
				return checkProfileExistence;
			}

			parameterMap.put("countryCode", parameterMap.get("ICCIDCountry"));

			if (parameterMap.get("TYPE").equalsIgnoreCase("B")) {

				parameterMap.put("country", ban.substring(0, 8).trim());

				ResponseEntity<?> getUserDetailMessage = methodService.genericExecuteApiMethod("HardwareSwapGetUser",
						parameterMap, request, response);
				if (!getUserDetailMessage.getStatusCode().is2xxSuccessful()) {
					return getUserDetailMessage;

				} else {
					JsonModification.parse(getUserDetailMessage.getBody().toString(), parameterMap);
					/**
					 * Initialize responseParameterMap to get checkUserExistence response parameters
					 */
					Map<String, String> GetUserResponseParameterMap = JsonModification
							.parse(getUserDetailMessage.getBody().toString(), new LinkedHashMap<>());
					/**
					 * Parse imsiProfileData in json format
					 */

					logger.info("USERS --> " + GetUserResponseParameterMap.get("users"));

					String getUserData = new JsonParser().parse(GetUserResponseParameterMap.get("users")).toString();
					/**
					 * Initialize List to get imsiProfileData
					 */
					List<Map<String, String>> getUserDataList = new LinkedList<>();

					/**
					 * Define type to format imsiProfileData in List of Map
					 */
					Type listType = new TypeToken<List<Map<String, String>>>() {
					}.getType();
					/**
					 * Casting Json In List Of Map
					 */
					getUserDataList = new Gson().fromJson(getUserData, listType);

					JsonModification.parse(getUserDetailMessage.getBody().toString(), parameterMap);

					if (getUserDataList.isEmpty()) {

						Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
						Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
						errorMessage.remove(priority);
						errorMessage.put("code", errorMessage.get("code"));
						errorMessage.put(description,
								"Invalid Parameter: ban ".concat(errorMessage.get(description).toString()));
						/**
						 * Returning Response
						 */
						List<Map<String, Object>> errorList = new LinkedList<>();
						errorList.add(errorMessage);
						Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
						finalErrorMessageMap.put("errors", errorList);
						return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);

					}
					parameterMap.put("home_imsi", String.valueOf(parameterMap.get("imsi")));
					parameterMap.put("home_iccid", String.valueOf(parameterMap.get("iccid")));
					parameterMap.put("home_msisdn", String.valueOf(parameterMap.get("msisdn")));
					ResponseEntity<?> redShiftAPIResponse = methodService
							.genericExecuteApiMethod("HardwareSwapRedswift", parameterMap, request, response);
					if (!redShiftAPIResponse.getStatusCode().is2xxSuccessful()) {
						return redShiftAPIResponse;
					} else {
						Map<String, String> redShiftParam = new LinkedHashMap<>();
						JsonModification.parse(String.valueOf(redShiftAPIResponse.getBody()), redShiftParam);
						if (String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("null")
								|| String.valueOf(redShiftParam.get("id")).equalsIgnoreCase("")) {
							/**
							 * Returning Response
							 */
							Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("0");
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
						} else {
							parameterMap.put("donor_imsi", String.valueOf(redShiftParam.get("staticDonorImsi")));
							parameterMap.put("donor_iccid", String.valueOf(redShiftParam.get("staticDonorIccid")));
							parameterMap.put("donor_msisdn", String.valueOf(redShiftParam.get("staticDonorMsisdn")));
						}
					}
					if (parameterMap.get("iccid").equalsIgnoreCase(parameterMap.get("originalDeviceId"))) {

						parameterMap.put("ICCIDCountry", parameterMap.get("countryIsoCode"));
						parameterMap.put("country", String.valueOf(parameterMap.get("country_code")));
						parameterMap.put("data", new Gson().toJson(parameterMap));
						Message message = genericProcess.GenericProcedureCalling("4", parameterMap, null, request,
								response);
						ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("HardwareSwapEsim",
								parameterMap, request, response);
						/**
						 * Returning Response
						 */
						logger.info(apiEnd);
						return responseMessage;
					} else {
						Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
						Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
						errorMessage.remove(priority);
						errorMessage.put("code", errorMessage.get("code"));
						errorMessage.put(description,
								"Invalid Parameter: Original Iccid  ".concat(errorMessage.get(description).toString()));
						/**
						 * Returning Response
						 */
						List<Map<String, Object>> errorList = new LinkedList<>();
						errorList.add(errorMessage);
						Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
						finalErrorMessageMap.put("errors", errorList);
						return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);
					}

				}

			} else {
				Map<String, Object> errorMessageMap = (Map<String, Object>) errorMap.get("2");
				Map<String, Object> errorMessage = new HashMap<>((Map) errorMessageMap);
				errorMessage.remove(priority);
				errorMessage.put("code", errorMessage.get("code"));
				errorMessage.put(description,
						"Invalid Parameter: New Iccid  ".concat(errorMessage.get(description).toString()));
				/**
				 * Returning Response
				 */
				List<Map<String, Object>> errorList = new LinkedList<>();
				errorList.add(errorMessage);
				Map<String, Object> finalErrorMessageMap = new LinkedHashMap<>();
				finalErrorMessageMap.put("errors", errorList);
				return new ResponseEntity<>(finalErrorMessageMap, HttpStatus.BAD_REQUEST);

			}
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */

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

	public ResponseEntity<?> gtOnboardingFromEsimNotification(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		/**
		 * To get Onboarding API error codes
		 */
		Map<String, Object> errorMap = methodService.getErrorCodes("OnBoardSubscriber", request, response);
		try {

			/**
			 * Checking onb_bit value to call !st Owner or Secand Owner
			 */
			logger.info("parameterMap " + parameterMap);

			parameterMap.put("country", parameterMap.get("countryCode"));

			parameterMap.put("donor_imsi", String.valueOf(parameterMap.get("IMSI")));
			parameterMap.put("donor_iccid", String.valueOf(parameterMap.get("ICCID")));
			parameterMap.put("donor_msisdn", String.valueOf(parameterMap.get("msisdn")));

			ResponseEntity<?> redShiftAPIResponse = methodService.genericExecuteApiMethod("EsimOnbRedShift",
					parameterMap, request, response);
			if (!redShiftAPIResponse.getStatusCode().is2xxSuccessful()) {
				return redShiftAPIResponse;
			} else {
				Map<String, String> redShiftParam = new LinkedHashMap<>();
				JsonModification.parse(String.valueOf(redShiftAPIResponse.getBody()), redShiftParam);
				parameterMap.put("home_imsi", String.valueOf(redShiftParam.get("imsi")));
				parameterMap.put("home_iccid", String.valueOf(redShiftParam.get("iccid")));
				parameterMap.put("home_msisdn", String.valueOf(redShiftParam.get("msisdn")));

			}

			logger.info("parameterMap accountType " + parameterMap.get("accountType"));
			/**
			 * Calling OL Core genericExecuteApiMethod Method to execute the API
			 */
			logger.info("Calling First owner Onboarding ");
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("EsimOnboarding", parameterMap,
					request, response);
			logger.info(
					"***********************************API Response From Core*****************************************************");
			logger.info("responseMessage " + responseMessage.getBody());

			logger.info(apiEnd);
			return responseMessage;

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

	public ResponseEntity<?> gtSwapHardwareRequestDataFromEsimNotification(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {

		try {

			logger.info("Calling group forSwap Hardware API after Profile switch completed API ");
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("HardwareSwap", parameterMap,
					request, response);
			logger.info(
					"***********************************API Response from Core***************************************************** \n"
							+ responseMessage);

			logger.info(apiEnd);
			return responseMessage;

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
}
