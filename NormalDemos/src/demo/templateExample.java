package demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class templateExample {
	public static HashMap<String, String> parse(String json, HashMap<String, String> map) {
		try {

			JsonFactory factory = new JsonFactory();

			ObjectMapper mapper = new ObjectMapper(factory);
			JsonNode rootNode = mapper.readTree(json);

			Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.getFields();
			while (fieldsIterator.hasNext()) {

				Map.Entry<String, JsonNode> field = fieldsIterator.next();

				System.out.println("Key: " + field.getKey() + "Value:" + field.getValue());

				map.put("#&#" + field.getKey(), String.valueOf(field.getValue()));
				if ((field.getValue().toString().startsWith("{") && field.getValue().toString().endsWith("}"))) {

					parse(field.getValue().toString(), map);

				}
				if (field.getValue().toString().startsWith("[{") && field.getValue().toString().endsWith("}]")) {

					parseJsonArray(field.getValue().toString(), map);

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return map;
	}

	public static void parseJsonArray(String jsonArray, HashMap<String, String> map) {
		try {

			JSONArray jsonArray1 = new JSONArray(jsonArray);
			for (int i = 0; i < jsonArray1.length(); i++) {
				JSONObject json = jsonArray1.getJSONObject(i);
				Iterator<String> keys = json.keys();

				while (keys.hasNext()) {
					String key = keys.next();
					map.put( "#&#" + key , json.get(key).toString());
					System.out.println("**** Key :" + "#&#" + key + "  Value :" + json.get(key));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String string1 = "{\"description\":\"Process Success\",\"object\":[{\"name\":\"obd-II\",\"alias\":\"car obd\",\"id\":1},{\"name\":\"Automobile\",\"alias\":\"AutoOBD\",\"id\":2},{\"name\":\"Router\",\"alias\":\"Router\",\"id\":3},{\"name\":\"Automation Sensor\",\"alias\":\"Automation Sensor\",\"id\":4},{\"name\":\"Power_Cable\",\"alias\":\"Power Cable\",\"id\":5},{\"name\":\"GPS_Tracker\",\"alias\":\"GPS Tracker\",\"id\":6},{\"name\":\"TTPL_new\",\"alias\":\"TTPL New\",\"id\":7},{\"name\":\"Fleet Intelligence\",\"alias\":\"Fleet Intelligence\",\"id\":8},{\"name\":\"android\",\"alias\":\"Android\",\"id\":9},{\"name\":\"air_conditions\",\"alias\":\"AC\",\"id\":10},{\"name\":\"tech\",\"alias\":\"tech\",\"id\":11},{\"name\":\"addTech\",\"alias\":\"add Tech\",\"id\":12},{\"name\":\"techie\",\"alias\":\"Techie\",\"id\":13},{\"name\":\"techno\",\"alias\":\"Technology1\",\"id\":14},{\"name\":\"tech2\",\"alias\":\"tech2\",\"id\":15},{\"name\":\"new\",\"alias\":\"new\",\"id\":16},{\"name\":\"Test_Technology\",\"alias\":\"Test Technology\",\"id\":17},{\"name\":\"Orchestration\",\"alias\":\"Orchestration\",\"id\":18}],\"list\":null,\"valid\":true}";

		System.out.println(string1.replaceAll("\":\".*?\",\"", ","));

		Map<String, String> input_params_value1 = parse(string1, new LinkedHashMap());
		System.out.println("input_params_value1" + input_params_value1);
		// Map<String, String> input_params_value = new HashMap<String,
		// String>();
		// input_params_value.put("applicationid", "47");
		// String string = "applicationid=<applicationid>";
		//
		// Pattern pattern = Pattern.compile("<.+?>");
		// Matcher matcher = pattern.matcher(string);
		// StringBuffer sb = new StringBuffer();
		// System.out.println(string);
		//
		// while (matcher.find()) {
		// String match_case = matcher.group(0);
		// System.out.println("match_case: "+match_case);
		// String match_case_value =
		// input_params_value.get(match_case.replaceAll("[<,>]", ""));
		// matcher.appendReplacement(sb, match_case_value);
		// }
		// matcher.appendTail(sb);
		//
		// System.out.println(sb.toString());
	}

}
