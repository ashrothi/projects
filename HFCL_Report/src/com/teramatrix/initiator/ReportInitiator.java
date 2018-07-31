package com.teramatrix.initiator;

import java.util.Map;

public interface ReportInitiator {
	public void initial(String deviceId,Map<String, Object> platformData);

}
