/**
 * 
 */
package com.teramatrix.processData;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;

import com.teramatrix.apiCalling.AccessRestApi;
import com.teramatrix.initiator.ReportInitiator;
import com.teramatrix.logger.HfclLogger;
import com.teramatrix.main.HfclEscalationApp;

/**
 * @author tanvigarg
 *
 */
public class VoiceData implements ReportInitiator {

	@Override
	public void initial(String deviceId, Map<String, Object> platformData) {
		CSErlangs(deviceId);
		SDCCHDropRate(deviceId);
		CallSetupSuccessRate(deviceId);
		NumberOfRadioConnectionFailuresTCH_H(deviceId);
		NumberOfRadioConnectionFailuresTCH_F(deviceId);

	}

	static final GetData getData = new GetData();
	static final String tag = "Voice";

	public void CSErlangs(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("data_source", "lm,bm");
			map.put("service_name", "geranBscTrxNumMeasurementReports,geranBscTrxNumMeasurementReports");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.callAttemptPerTrx, map);

			HfclLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);

			ObjectMapper mapper = new ObjectMapper();

			Map<String, String> response = mapper.readValue(String.valueOf(outerObject.getJSONObject("object")),
					new TypeReference<Map<String, String>>() {
					});
			HfclLogger.logger.info(" Response : " + outerObject.getJSONObject("object"));

			if (response.get("data") != null) {
				/**
				 * Retrieve required data from the response.
				 */
				String CSErlangs = String.valueOf(response.get("data"));

				// String CSErlangsKPI =
				// String.valueOf(objectInArray.get("data"));

				double finaldata = (Double.parseDouble(CSErlangs) * 0.48) / (60 * 60 * 24 * 12);

				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "CSErlangs", deviceId, tag);

				HfclLogger.logger.info("KPI value : " + finaldata);
			}

		} catch (

		Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

	public void SDCCHDropRate(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("data_source", "bm");
			map.put("service_name", "geranBscBtsChannelBlockingCount");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.callAttemptPerTrx, map);

			HfclLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);

			ObjectMapper mapper = new ObjectMapper();

			Map<String, String> response = mapper.readValue(String.valueOf(outerObject.getJSONObject("object")),
					new TypeReference<Map<String, String>>() {
					});
			HfclLogger.logger.info(" Response : " + outerObject.getJSONObject("object"));

			if (response.get("data") != null) {

				/**
				 * Retrieve required data from the response.
				 */
				String SDCCHDropRate = String.valueOf(response.get("data"));
				double finaldata = (Double.parseDouble(SDCCHDropRate));
				HfclLogger.logger
						.info(" \n \n ************************************* \n finaldata value : " + SDCCHDropRate);

				getData.insertKPI(String.valueOf(finaldata), "SDCCH Drop Rate", deviceId, tag);

				HfclLogger.logger.info("KPI value : " + SDCCHDropRate);
			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	public void CallSetupSuccessRate(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("data_source", "sdcch_lm,sdcch4_lm,sdcch_bm,sdcch4_bm");
			map.put("service_name",
					"geranBscTrxSubsequentAssignmentSuccessCount,geranBscTrxSubsequentAssignmentSuccessCount,geranBscTrxSubsequentAssignmentSuccessCount,geranBscTrxSubsequentAssignmentSuccessCount");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.callAttemptPerTrx, map);

			HfclLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);

			ObjectMapper mapper = new ObjectMapper();

			Map<String, String> response = mapper.readValue(String.valueOf(outerObject.getJSONObject("object")),
					new TypeReference<Map<String, String>>() {
					});
			HfclLogger.logger.info(" Response : " + outerObject.getJSONObject("object"));
			HashMap<String, String> map1 = new HashMap<>();
			map1.put("device_id", deviceId);
			map1.put("data_source", "sdcch_lm,sdcch4_lm,sdcch_bm,sdcch4_bm");
			map1.put("service_name",
					"geranBscTrxSubsequentAssignmentCommandCount,geranBscTrxSubsequentAssignmentCommandCount,geranBscTrxSubsequentAssignmentCommandCount,geranBscTrxSubsequentAssignmentCommandCount");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall1 = new AccessRestApi();
			String apiResponse1 = restApiCall1.callingRestAPIWithHeaders(HfclEscalationApp.callAttemptPerTrx, map1);

			HfclLogger.logger.info("Response : " + apiResponse1);

			JSONObject outerObject1;
			outerObject1 = new JSONObject(apiResponse1);

			ObjectMapper mapper1 = new ObjectMapper();

			Map<String, String> response1 = mapper1.readValue(String.valueOf(outerObject1.getJSONObject("object")),
					new TypeReference<Map<String, String>>() {
					});
			HfclLogger.logger.info(" Response : " + outerObject1.getJSONObject("object"));
			if (response.get("data") != null && response1.get("data") != null) {

				/**
				 * Retrieve required data from the response.
				 */
				double CallSetupSuccessRate = 0;
				double value1 = Double.parseDouble(String.valueOf(response.get("data")));
				double value2 = Double.parseDouble(String.valueOf(response1.get("data")));

				if (value1 == 0 || value2 == 0) {
					CallSetupSuccessRate = 0;
				} else {
					CallSetupSuccessRate = value1 / value2;
					CallSetupSuccessRate = CallSetupSuccessRate * 100;
				}

				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(CallSetupSuccessRate)),
						"Call Setup Success Rate", deviceId, tag);

				HfclLogger.logger.info("KPI value : " + CallSetupSuccessRate);
			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	public void NumberOfRadioConnectionFailuresTCH_H(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("data_source", "lm");
			map.put("service_name", "geranBscTrxNumRadioConnectionFailures");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.callAttemptPerTrx, map);

			HfclLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);

			ObjectMapper mapper = new ObjectMapper();

			Map<String, String> response = mapper.readValue(String.valueOf(outerObject.getJSONObject("object")),
					new TypeReference<Map<String, String>>() {
					});
			HfclLogger.logger.info(" Response : " + outerObject.getJSONObject("object"));

			if (response.get("data") != null) {
				/**
				 * Retrieve required data from the response.
				 */
				String NumberOfRadioConnectionFailuresTCH_H = String.valueOf(response.get("data"));
				double finaldata = (Double.parseDouble(NumberOfRadioConnectionFailuresTCH_H));
				getData.insertKPI(String.valueOf(finaldata), "Number Of Radio Connection Failures TCH_H", deviceId,
						tag);

				HfclLogger.logger.info("KPI value : " + NumberOfRadioConnectionFailuresTCH_H);
			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	public void NumberOfRadioConnectionFailuresTCH_F(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("data_source", "bm");
			map.put("service_name", "geranBscTrxNumRadioConnectionFailures");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.callAttemptPerTrx, map);

			HfclLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);

			ObjectMapper mapper = new ObjectMapper();

			Map<String, String> response = mapper.readValue(String.valueOf(outerObject.getJSONObject("object")),
					new TypeReference<Map<String, String>>() {
					});
			HfclLogger.logger.info(" Response : " + outerObject.getJSONObject("object"));

			if (response.get("data") != null) {
				/**
				 * Retrieve required data from the response.
				 */
				String NumberOfRadioConnectionFailuresTCH_F = String.valueOf(response.get("data"));
				double finaldata = (Double.parseDouble(NumberOfRadioConnectionFailuresTCH_F));
				getData.insertKPI(String.valueOf(finaldata), "Number Of Radio Connection Failures TCH_F", deviceId,
						tag);

				HfclLogger.logger.info("KPI value : " + NumberOfRadioConnectionFailuresTCH_F);
			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

}
