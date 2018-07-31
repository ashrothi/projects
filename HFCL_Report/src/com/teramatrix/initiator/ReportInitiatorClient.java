package com.teramatrix.initiator;

import java.util.Map;

import com.teramatrix.processData.BTS;
import com.teramatrix.processData.PCU;
import com.teramatrix.processData.PerformanceData;
import com.teramatrix.processData.VoiceCapacity;
import com.teramatrix.processData.VoiceData;

public class ReportInitiatorClient {

	public void start(String type, String deviceId, Map<String, Object> platformData) {
		switch (type) {
		case "Voice":
			VoiceData data = new VoiceData();
			data.initial(deviceId, platformData);
			break;
		case "Performance":
			PerformanceData performanceData = new PerformanceData();
			performanceData.initial(deviceId, platformData);
			break;
		case "VoiceCapacity":
			VoiceCapacity voiceCapacity = new VoiceCapacity();
			voiceCapacity.initial(deviceId, platformData);
			break;
		case "BTS":
			BTS bts = new BTS();
			bts.initial(deviceId, platformData);
			break;
		case "PCU":
			PCU pcu = new PCU();
			pcu.initial(deviceId, platformData);
			break;

		default:
			break;
		}
	}

}
