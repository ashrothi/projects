package demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoapTemplate {
	public static void main(String[] args) {
		Map<String, String> parameterMap = new LinkedHashMap<>();
		parameterMap.put("tracking_message_header", String.valueOf(System.currentTimeMillis() / 1000));
		parameterMap.put("DateTimeStamp", String.valueOf(System.currentTimeMillis() / 1000));
		parameterMap.put("ICCID", String.valueOf("8944200012789720400F"));
		parameterMap.put("country", "IN");
		parameterMap.put("RequestID", String.valueOf("8944200012789720400F"));
		parameterMap.put("returnUrl", "https://gtidtlab.gm.com:17115");
		parameterMap.put("host_address", "127.0.0.1");
		parameterMap.put("ProfileSwitchType", "1");
		StringBuffer sb = new StringBuffer();

		Map<String, String> staticParamMAp = new LinkedHashMap<>();

		Pattern pattern = Pattern.compile("@@.+?@@");
		Matcher matcher = pattern.matcher(String.valueOf(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:esim=\"eSIMSubAPIService\">   <soapenv:Header/>   <soapenv:Body>      <esim:ProfileDownloadReq>         <RequestID>@@RequestID@@</RequestID>         <MessageID>ESIM Controller</MessageID>         <Version>v1</Version>         <ReturnURL>http://35.159.5.214:7878/EsimSoapWS/services/eSIMSubWebService</ReturnURL>         <DateTimeStamp>@@DateTimeStamp@@</DateTimeStamp>         <TimeToLive></TimeToLive>         <eUICCID></eUICCID>         <ICCID>@@ICCID@@</ICCID>         <MSISDN></MSISDN>         <CurrentCountry>IN</CurrentCountry>         <ProfileSwitchType>@@ProfileSwitchType@@</ProfileSwitchType>      </esim:ProfileDownloadReq>   </soapenv:Body></soapenv:Envelope>"));

		// System.out.println("sb.length()" + sb.length());
		if (sb.length() == 0) {
			while (matcher.find()) {
				String match_case = matcher.group(0);

				if (match_case.replaceAll("[@@]", "").contains("#&#")) {
					String match_case_value = String.valueOf(parameterMap.get(match_case.replaceAll("[@@]", "")));
					matcher.appendReplacement(sb, match_case_value);
				} else if (parameterMap.containsKey(match_case.replaceAll("[@@]", ""))) {
					String match_case_value = String.valueOf(parameterMap.get(match_case.replaceAll("[@@]", "")));
					matcher.appendReplacement(sb, match_case_value);
				} else if (staticParamMAp.containsKey(match_case.replaceAll("[@@]", ""))) {

					String match_case_value = staticParamMAp.get(match_case.replaceAll("[@@]", ""));

					matcher.appendReplacement(sb, match_case_value);
				}

			}
			matcher.appendTail(sb);
		}

		System.out.println(sb);
	}
}
