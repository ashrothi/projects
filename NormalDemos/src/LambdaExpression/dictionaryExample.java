package LambdaExpression;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class dictionaryExample {
	public static void main(String[] args) {
		JsonParser parser = new JsonParser();

		String string = "[{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"19.8\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_IgnitionStatus\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_IgnitionStatus\",\"current_value\":\"OFF\",\"service_servicedatasource_alias\":\"Ignition Status\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Ignition Status\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Longitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Longitude\",\"current_value\":\"77.533325\",\"service_servicedatasource_alias\":\"Longitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Longitude\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Humidity\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"RH\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Humidity\",\"current_value\":\"0.43\",\"service_servicedatasource_alias\":\"Humidity\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Humidity\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Latitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Latitude\",\"current_value\":\"23.0775566667\",\"service_servicedatasource_alias\":\"Latitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Latitude\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_gpsTracker_Speed\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"km/h\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_gpsTracker_Speed\",\"current_value\":\"0.19\",\"service_servicedatasource_alias\":\"Speed\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Speed\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Humidity\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"RH\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Humidity\",\"current_value\":\"0.43\",\"service_servicedatasource_alias\":\"Humidity\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Humidity\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Latitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Latitude\",\"current_value\":\"23.0775566667\",\"service_servicedatasource_alias\":\"Latitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Latitude\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_gpsTracker_Speed\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"km/h\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_gpsTracker_Speed\",\"current_value\":\"0.74\",\"service_servicedatasource_alias\":\"Speed\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Speed\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"}]"
				.toString();

		JsonArray jsonArray = parser.parse(string).getAsJsonArray();

		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();

		for (JsonElement element : jsonArray) {
			JsonObject object = element.getAsJsonObject();
			String key = object.get("sys_timestamp").getAsString() + "-" + object.get("device_id").getAsString();
			if (map.get(key) == null) {
				map.put(key, new HashMap<>());
			}

			map.get(key).put(object.get("data_source").getAsString(), object.get("current_value").getAsString());
			map.get(key).put("sys_timestamp", object.get("sys_timestamp").getAsString());

		}

		System.out.println(map);
	}
}
