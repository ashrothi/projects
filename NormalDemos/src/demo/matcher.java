/**
 * 
 */
package demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tanvigarg
 *
 */
public class matcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("<.+?>");
		String string = "/activateSIM/<iccid>";
		StringBuffer url = new StringBuffer();
		Matcher matcherUrl = pattern.matcher(String.valueOf(string));
		if (matcherUrl.find()) {

			String match_case_url = matcherUrl.group(0);
			Map<String, String> requesParameterMap = new LinkedHashMap<>();
			requesParameterMap.put("iccid", "8944200012781000090");

			if (match_case_url.replaceAll("[<,>]", "").contains("#&#")) {
				String match_case_value = String
						.valueOf(requesParameterMap.get(match_case_url.replaceAll("[<,>]", "")));
				matcherUrl.appendReplacement(url, match_case_value);
			}
			if (requesParameterMap.containsKey(match_case_url.replaceAll("[<,>]", ""))) {
				String match_case_value = String
						.valueOf(requesParameterMap.get(match_case_url.replaceAll("[<,>]", "")));
				matcherUrl.appendReplacement(url, match_case_value);
			} else {
				String match_case_value = "";
				matcherUrl.appendReplacement(url, match_case_value);
			}
			System.out.println("url " + url);

		}
	}

}
