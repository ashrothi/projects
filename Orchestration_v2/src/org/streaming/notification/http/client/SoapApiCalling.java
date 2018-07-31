/**
 * This package contain  class HttpURLCalling is used to calling Rest API and SoapApiCalling use to calling SOAP API  
 */

package org.streaming.notification.http.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONObject;
import org.json.XML;
import org.streaming.json.JsonModification;

//import com.google.gson.JsonObject;

//import com.orchastration.logger.OrchastrationLogger;

/**
 * 
 * SoapApiCalling class use as Component to call all SOAP API and return Response of API with Response code 
 * 
 * 
 * @author Sachin
 *
 */
public class SoapApiCalling {
	
	/**
	 * getData(String url, String data, Map<String, String> headerMap) method use to call SOAP API with given parameter
	 * 
	 * @param url:API URL
	 * @param data: API body template with parameter and its value
	 * @param headerMap: Header parameter of API
	 * @return response with response code ie. #$#reponse_code#$#reponse
	 */
	public String getData(String url, String data, Map<String, String> headerMap) {

		StringBuilder builder = new StringBuilder();

		
		System.out.println("update url:"+url.substring(0,url.indexOf("?")));
//		System.out.println("parameters========" + url.substring(0,url.indexOf("?"))+ "------------------" + data + "----------------" + headerMap);
		System.out.println("parameters========" + url.substring(0,url.indexOf("?"))+ "------------------" + data + "----------------" + headerMap);
		try {
			String soapURL=url.substring(0,url.indexOf("?"));
			
			URL obj = new URL(soapURL); //To get URL
			
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			
			connection.setRequestMethod("POST");//set Request Method
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			connection.setRequestProperty("content-type", "text/xml; charset=utf-8"); //set Content Type XML
			connection.setRequestProperty("SOAPAction", headerMap.get("soapAction")); //set Content Type XML
			
//			System.out.println("Header map is " + headerMap);
			System.out.println("Header map is " + headerMap);
			//set request header
			/*if (headerMap != null) {
				for (String key : headerMap.keySet()) {
					connection.setRequestProperty(key, headerMap.get(key).trim());
				}

			}*/

			String urlParameters = data;// set body parameter through body template
			// Send post request
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			/**
			 * To Get Response Code from called API
			 */
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			String tmp_responseCode=String.valueOf(responseCode);
//			builder.append("#$#"+String.valueOf(responseCode));

			

			/**
			 * If dosen't get success code than return error response string
			 */
			if (responseCode != 200) {
				builder.append("#$#"+String.valueOf(responseCode)+" issue occure");
				return builder.toString();
			}
			/**
			 * To get the response from the API which was called
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			if(responseCode==200){
			      JSONObject obj1= XML.toJSONObject(StringEscapeUtils.unescapeXml(String.valueOf(response)));
			      System.out.println(obj1.toString());
			      HashMap<String, String> map=new HashMap<>();
					JsonModification.parse(String.valueOf(obj1.toString()), map);
					if(map.containsKey("responseCode")){
						responseCode=Integer.parseInt(map.get("responseCode"));
						tmp_responseCode=map.get("responseCode");
						System.out.println(responseCode);
					}
			}
			builder.append("#$#"+tmp_responseCode+"#$#"+StringEscapeUtils.unescapeXml(String.valueOf(response)));
			
			
			
			/**
			 * To Return the Response
			 */
			return builder.toString();

		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			 * 
			 */
			e.printStackTrace();
			builder.append("Error Msg: " + e.getMessage() + "\n");

			return builder.toString();
		}

	}
}
