package LambdaExpression;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NewTest {
	public static void main(String[] args) {
		String string = "[{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"19.8\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_IgnitionStatus\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_IgnitionStatus\",\"current_value\":\"OFF\",\"service_servicedatasource_alias\":\"Ignition Status\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Ignition Status\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Longitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Longitude\",\"current_value\":\"77.533325\",\"service_servicedatasource_alias\":\"Longitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Longitude\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Humidity\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"RH\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Humidity\",\"current_value\":\"0.43\",\"service_servicedatasource_alias\":\"Humidity\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Humidity\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Latitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Latitude\",\"current_value\":\"23.0775566667\",\"service_servicedatasource_alias\":\"Latitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Latitude\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_gpsTracker_Speed\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"km/h\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_gpsTracker_Speed\",\"current_value\":\"0.19\",\"service_servicedatasource_alias\":\"Speed\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Speed\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Humidity\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"RH\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Humidity\",\"current_value\":\"0.43\",\"service_servicedatasource_alias\":\"Humidity\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Humidity\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Latitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Latitude\",\"current_value\":\"23.0775566667\",\"service_servicedatasource_alias\":\"Latitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Latitude\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_gpsTracker_Speed\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"km/h\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_gpsTracker_Speed\",\"current_value\":\"0.74\",\"service_servicedatasource_alias\":\"Speed\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Speed\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"}]";
		Type type = new TypeToken<ArrayList<Map<String, Object>>>() {
		}.getType();
		ArrayList<Map<String, Object>> data = new Gson().fromJson(string, type);

		System.out.println(data.toString());

		data.sort((Map<String, Object> o1, Map<String, Object> o2) -> o1.get("device_id").toString()
				.compareTo(o2.get("device_id").toString()));
		System.out.println("After Sort" + data);
		// Comparator<Map<String, Object>> salaryComparator = (o1, o2) ->
		// o1.get("check_timestamp").toString()
		// .compareTo(o2.get("check_timestamp").toString());
		// data.sort(salaryComparator.reversed());
		// System.out.println(data);

		// Object groupByPriceMap = data.stream().map(p
		// ->p.get("check_timestamp"))
		//
		// .collect(Collectors.groupingBy(Function.identity()));
		//
		// System.out.println(groupByPriceMap);
		Map<Object, List<Object>> mapItem = data.stream().flatMap(m -> m.entrySet().stream())
				.collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
		
		
		List<Object> groupByPriceMap = data.stream().map(p -> p).collect(Collectors.toList());
		for (Object map : groupByPriceMap) {
			System.out.println(map);
		}
		System.out.println(mapItem);

	}
}
