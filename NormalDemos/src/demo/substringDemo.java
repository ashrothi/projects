package demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class substringDemo {
	public static void main(String[] args) {

		Map<String, String> a = new LinkedHashMap<>();
		Map<String, String> b = new LinkedHashMap<>();
		a.put("planDuration", "<validityTerm> , <validityTermUnit>");
		a.put("validityTerm", "test");
		a.put("validityTermUnit", "case ");

		for (String mapw : a.keySet()) {

			String value = a.get(mapw).toString().replaceAll("[<>]", "");
			System.out.println("11111 " + value);
			StringBuilder finalValue = new StringBuilder();
			if (value.contains(",")) {
				System.out.println("2222 " + value);
				String[] newValue = value.split(",");
				for (String string : newValue) {

					if (a.containsKey(string.trim())) {

						finalValue.append(a.get(string.trim()) + " ");
					} else {
						finalValue.append("");
					}
					b.put(mapw, finalValue.toString());
				}

			} else if (a.containsKey(value)) {
				b.put(mapw, a.get(value));
			} else {
				b.put(mapw, "");
			}

		}

		System.out.println("************************************** " + a);
		System.out.println("************************************** " + b);

		StringBuilder builder = new StringBuilder();
		;

		// builder.append("a,b,c,");
		if (builder.toString().contains(",")) {
			builder.deleteCharAt(builder.lastIndexOf(","));
		}
		System.out.println(builder.toString());
	}
}
