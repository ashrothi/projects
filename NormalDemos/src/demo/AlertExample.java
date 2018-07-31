package demo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AlertExample {
	public static void main(String[] args) {
		String a = "[{\"severity\":\"High Temperature\",\"device_id\":\"582\",\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":\"1489746278000\",\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"severity_colour\":\"#c50e0e\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"9.4\",\"rule_id\":\"8\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160163861693033377490\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":\"1489746763000\",\"device_alias\":\"Singh Transport NL-01-L-5128\",\"severity_priority\":\"1\"},{\"severity\":\"CLEAR\",\"device_id\":\"582\",\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":\"1489746278000\",\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"severity_colour\":\"#c50e0e\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"9.4\",\"rule_id\":\"5\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160163861693033377490\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":\"1489746766000\",\"device_alias\":\"Singh Transport NL-01-L-5128\",\"severity_priority\":\"1\"},{\"severity\":\"High Temperature\",\"device_id\":\"582\",\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":\"1489746278000\",\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"severity_colour\":\"#c50e0e\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"9.4\",\"rule_id\":\"7\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160163861693033377490\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":\"1489746769000\",\"device_alias\":\"Singh Transport NL-01-L-5128\",\"severity_priority\":\"1\"},{\"severity\":\"CLEAR\",\"device_id\":\"582\",\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":\"1489746278000\",\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"severity_colour\":\"#c50e0e\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"9.4\",\"rule_id\":\"7\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160163861693033377490\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":\"1489746772000\",\"device_alias\":\"Singh Transport NL-01-L-5128\",\"severity_priority\":\"1\"}]";
		Type type = new TypeToken<ArrayList<Map<String, Object>>>() {
		}.getType();
		ArrayList<Map<String, Object>> data = new Gson().fromJson(a, type);
		System.out.println(a);
		data.sort((Map<String, Object> o1, Map<String, Object> o2) -> o1.get("rule_id").toString()
				.compareTo(o2.get("rule_id").toString()));
		System.out.println(data);

	}
}
