package LambdaExpression;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ListOfMapSort {
	public static void main(String[] args) {
		String string = "[{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Temperature\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"Degree Celsius\",\"service_servicedatasource_max_value\":\"100\",\"service_servicedatasource_min_value\":\"0\",\"data_source\":\"gmr_Sensor_Temperature\",\"current_value\":\"19.8\",\"service_servicedatasource_alias\":\"Temperature\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Temperature\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_IgnitionStatus\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_IgnitionStatus\",\"current_value\":\"OFF\",\"service_servicedatasource_alias\":\"Ignition Status\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Ignition Status\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Longitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Longitude\",\"current_value\":\"77.533325\",\"service_servicedatasource_alias\":\"Longitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Longitude\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Humidity\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"RH\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Humidity\",\"current_value\":\"0.43\",\"service_servicedatasource_alias\":\"Humidity\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Humidity\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Latitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Latitude\",\"current_value\":\"23.0775566667\",\"service_servicedatasource_alias\":\"Latitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Latitude\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_gpsTracker_Speed\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"km/h\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_gpsTracker_Speed\",\"current_value\":\"0.19\",\"service_servicedatasource_alias\":\"Speed\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Speed\",\"sys_timestamp\":1488825000000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Humidity\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"RH\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Humidity\",\"current_value\":\"0.43\",\"service_servicedatasource_alias\":\"Humidity\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Humidity\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_Sensor_Latitude\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_Sensor_Latitude\",\"current_value\":\"23.0775566667\",\"service_servicedatasource_alias\":\"Latitude\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Latitude\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"},{\"severity\":null,\"device_id\":578,\"service_name\":\"gmr_gpsTracker_Speed\",\"check_timestamp\":1488808756000,\"service_servicedatasource_unit\":\"km/h\",\"service_servicedatasource_max_value\":\"\",\"service_servicedatasource_min_value\":\"\",\"data_source\":\"gmr_gpsTracker_Speed\",\"current_value\":\"0.74\",\"service_servicedatasource_alias\":\"Speed\",\"device_name\":\"62160162861693033377821\",\"service_service_alias\":\"Speed\",\"sys_timestamp\":1488825062000,\"device_alias\":\"Singh Transport NL-01-Q-0946\"}]";
		Type type = new TypeToken<ArrayList<ItemFormat>>() {
		}.getType();
		ArrayList<ItemFormat> data = new Gson().fromJson(string, type);

		System.out.println(data.toString());
//		data.sort((Map<String, Object> o1, Map<String, Object> o2) -> Integer.parseInt(o1.get("id").toString())
//				- Integer.parseInt((o2.get("id")).toString()));
		data.sort((ItemFormat o1, ItemFormat o2) -> Integer
				.compare(Integer.parseInt(o1.getDevice_id()), Integer.parseInt(o2.getDevice_id())));
		System.out.println("After Sort" + data);
		Comparator<ItemFormat> salaryComparator = (o1, o2) -> o1.getCheck_timestamp().toString()
				.compareTo(o2.getCheck_timestamp().toString());
		data.sort(salaryComparator.reversed());
		System.out.println(data);
		
		 Map<String, List<ItemFormat>> groupByPriceMap =
				 data.stream().collect(Collectors.groupingBy(ItemFormat::getSys_timestamp));

		        System.out.println(groupByPriceMap);
		  
	}
	private static <K, V> Map<K, List<V>> groupByOrdered(List<V> list, Function<V, K> keyFunction) {
	    return list.stream()
	                .collect(Collectors.groupingBy(
	                    keyFunction,
	                    LinkedHashMap::new,
	                    Collectors.toList()
	                ));
	}
}
