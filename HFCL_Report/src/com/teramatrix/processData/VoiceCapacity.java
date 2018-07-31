/**
 * 
 */
package com.teramatrix.processData;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
public class VoiceCapacity implements ReportInitiator {

	@Override
	public void initial(String deviceId,Map<String, Object> platformData) {
		SDCCHBlockingRate(deviceId);
		TCHBlockingRate(deviceId);
		ImmediateAssignmentProcedureSuccessRate(deviceId);
	}

	static final GetData getData = new GetData();
	static final String tag = "VoiceCapacity";

	public void SDCCHBlockingRate(String deviceId) {
		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("service_name_numerator",
					"geranBscBtsImmAssignmentRejectCount_answerPaging,geranBscBtsImmAssignmentRejectCount_callOriginate,geranBscBtsImmAssignmentRejectCount_emergency,geranBscBtsImmAssignmentRejectCount_locUpd");
			map.put("data_source_numerator",
					"geranBscBtsImmAssignmentRejectCount_answerPaging,geranBscBtsImmAssignmentRejectCount_callOriginate,geranBscBtsImmAssignmentRejectCount_emergency,geranBscBtsImmAssignmentRejectCount_locUpd");
			map.put("service_name_denominator",
					"geranBscBtsImmAssignmentCommandCount_answerPaging,geranBscBtsImmAssignmentCommandCount_callOriginate,geranBscBtsImmAssignmentCommandCount_emergency,geranBscBtsImmAssignmentCommandCount_locUpd");
			map.put("data_source_denominator",
					"geranBscBtsImmAssignmentCommandCount_answerPaging,geranBscBtsImmAssignmentCommandCount_callOriginate,geranBscBtsImmAssignmentCommandCount_emergency,geranBscBtsImmAssignmentCommandCount_locUpd");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date",String.valueOf(HfclEscalationApp.currentTime));
			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.sdcchDropRatePerBts, map);

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
				String SDCCHBlockingRate = String.valueOf(response.get("data"));

				double finaldata = Double.parseDouble(SDCCHBlockingRate);
				if (finaldata != 0) {
					DecimalFormat df = new DecimalFormat("#.##");
					df.setRoundingMode(RoundingMode.CEILING);
					getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Blocking Rate", deviceId, tag);
				} else {
					getData.insertKPI(String.valueOf(0), "SDCCH Blocking Rate", deviceId, tag);
				}

				HfclLogger.logger.info("KPI value : " + finaldata);
			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

	public void TCHBlockingRate(String deviceId) {
		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("service_name_numerator", "geranBscBtsChannelBlockingCount,geranBscBtsChannelBlockingCount");
			map.put("data_source_numerator", "bm,lm");
			map.put("service_name_denominator",
					"geranBscBtsChannelBlockingCount,geranBscBtsChannelBlockingCount,geranBscTrxSubsequentAssignmentCommandCount,geranBscTrxSubsequentAssignmentCommandCount");
			map.put("data_source_denominator", "bm,lm");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date",String.valueOf(HfclEscalationApp.currentTime));
			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.sdcchDropRatePerBts, map);

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
				String TCHBlockingRate = String.valueOf(response.get("data"));
				double finaldata = (Double.parseDouble(TCHBlockingRate) );
				getData.insertKPI(String.valueOf(finaldata), "TCH Blocking Rate", deviceId, tag);

				HfclLogger.logger.info("KPI value : " + TCHBlockingRate);

			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

	public void ImmediateAssignmentProcedureSuccessRate(String deviceId) {
		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("service_name_numerator",
					"geranBscTrxImmAssignmentSuccessCount,geranBscTrxImmAssignmentSuccessCount");
			map.put("data_source_numerator", "sdcch,sdcch4");
			map.put("service_name_denominator",
					"geranBscTrxImmAssignmentCommandCount,geranBscTrxImmAssignmentCommandCount");
			map.put("data_source_denominator", "sdcch,sdcch4");
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date",String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.sdcchDropRatePerBts, map);

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
				String ImmediateAssignmentProcedureSuccessRate = String.valueOf(response.get("data"));

				double finaldata = (Double.parseDouble(ImmediateAssignmentProcedureSuccessRate) * 100);

				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Immediate Assignment Procedure Success Rate", deviceId,
						tag);

				HfclLogger.logger.info("KPI value : " + finaldata);
			}

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

}
