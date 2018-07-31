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
public class PerformanceData implements ReportInitiator {

	@Override
	public void initial(String deviceId,Map<String, Object> platformData) {
		// TODO Auto-generated method stub
		DownlinkDataThroughputInKbps(deviceId);
		UplinkDataThroughputInKbps(deviceId);
	}

	static final GetData getData = new GetData();
	static final String tag = "Performance";

	public void DownlinkDataThroughputInKbps(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("from_date",HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.downlinkDataThroughput, map);

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
				String DownlinkDataThroughputInKbps = String.valueOf(response.get("data"));

				// String CSErlangsKPI =
				// String.valueOf(objectInArray.get("data"));

				double finaldata = (Double.parseDouble(DownlinkDataThroughputInKbps));
				if (finaldata != 0) {
					DecimalFormat df = new DecimalFormat("#.##");
					df.setRoundingMode(RoundingMode.CEILING);
					getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
							"Downlink Data Throughput In Kbps", deviceId, tag);
				} else {
					getData.insertKPI(String.valueOf(0), "Downlink Data Throughput In Kbps", deviceId, tag);
				}

				HfclLogger.logger.info("KPI value : " + finaldata);
			}

		} catch (

		Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

	public void UplinkDataThroughputInKbps(String deviceId) {

		try {
			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_id", deviceId);
			map.put("from_date", HfclEscalationApp.beforeTime);
			map.put("end_date", String.valueOf(HfclEscalationApp.currentTime));

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.uplinkDataThroughput, map);

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
				String UplinkDataThroughputInKbps = String.valueOf(response.get("data"));

				// String CSErlangsKPI =
				// String.valueOf(objectInArray.get("data"));

				double finaldata = (Double.parseDouble(UplinkDataThroughputInKbps));
				if (finaldata != 0) {

					getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
							"Uplink Data Throughput In Kbps", deviceId, tag);
				} else {
					getData.insertKPI(String.valueOf(0), "Uplink Data Throughput In Kbps", deviceId, tag);
				}

				HfclLogger.logger.info("KPI value : " + finaldata);
			}

		} catch (

		Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}
}
