/**
 * This package contain  class as Component is used to call the Other API's of OauthEngine and XfusionPlatForm
 */
package com.springiot.http.client;

/**
 * To Import Classes to access their functionality
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.stereotype.Component;

/**
 * 
 * This class use as Component to call all API's of OauthEngine and
 * XfusionPlatForm and return their responses
 * 
 * @author Ankita Shrothi
 *
 */
@Component
public class HttpURLCalling {

	/**
	 * getData() to get the url and passingParameter to call API's
	 * 
	 * @param url
	 * @param passingParameter
	 * @return response
	 */
	public String getData(String url, String passingParameter, Map<String, String> headerMap) {

		try {

			URL urlToCall = new URL(url);
			// HttpsURLConnection httpConectionWithUrl = (HttpsURLConnection)
			// urlToCall.openConnection();
			HttpURLConnection httpConectionWithUrl = (HttpURLConnection) urlToCall.openConnection();

			// add reuqest header
			httpConectionWithUrl.setRequestMethod("POST");
			httpConectionWithUrl.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			if (headerMap != null) {
				for (String Key : headerMap.keySet()) {
					// System.out.println("Key" + Key + " " +
					// headerMap.get(Key));
					httpConectionWithUrl.setRequestProperty(Key, headerMap.get(Key));
				}

			}
			// System.out.println("!!!!!" +
			// httpConectionWithUrl.getRequestProperty("token"));
			// String urlParameters = passingParameter;

			// Send post request
			httpConectionWithUrl.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
			wr.writeBytes(passingParameter);
			wr.flush();
			wr.close();
			/**
			 * To Get Response Code from called API
			 */
			int responseCode = httpConectionWithUrl.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("headerMap" + headerMap);
			System.out.println("Post parameters : " + passingParameter);
			System.out.println("Response Code : " + responseCode);
			/**
			 * If dosen't get success code than return null
			 */
			if (responseCode != 200) {
				return null;
			}
			/**
			 * To get the response from the API which was called
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConectionWithUrl.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			/**
			 * To Return the Response
			 */
			// System.out.println("response ================= " + response);
			return response.toString();

		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			 * 
			 */
			e.printStackTrace();
			return e.getMessage();
		}

	}

	/**
	 * This method is used to call the APIs on https url.
	 * 
	 * @param url : Here pass the api url.
	 * @param passingParameters : Here pass the parameters for calling API.
	 * @param headerMap : Here pass the headerMap to call the api.
	 * @return response : Returns the response in string format.
	 */
	public String getDataHttps(String apiUrl, String passingParameters, Map<String, String> headerMap) {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					// TODO Auto-generated method stub
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					// TODO Auto-generated method stub
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
	
			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	
			URL url = new URL(apiUrl);
			//URL url = new URL("https://192.168.1.108:8443/BARC/barc/ping/server");
			//String param = "media_url=https%3A%2F%2Fredirector.gvt1.com%2Fvideoplayback%2Fid%2Fa33fc5b2685eb16e%2Fitag%2F15%2Fsource%2Fgfp_video_ads%2Frequiressl%2Fyes%2Facao%2Fyes%2Fmime%2Fvideo%252Fmp4%2Fip%2F0.0.0.0%2Fipbits%2F0%2Fexpire%2F1512061692%2Fsparams%2Fip%2Cipbits%2Cexpire%2Cid%2Citag%2Csource%2Crequiressl%2Cacao%2Cmime%2Fsignature%2F17CE9CC877B760D07AE4EAF880F7566F32E353D3.B1178EAED037B2CE61E71704395A24AFF9171E97%2Fkey%2Fck2%2Ffile%2Ffile.mp4&ad_click_url=https%3A%2F%2Fpubads.g.doubleclick.net%2Fpcs%2Fclick%3Fxai%3DAKAOjssWLNRh9Gk9KCkiLCrmdMwtu7CFTFEh2I6nhyN05G0yocRqjW5AZSrNbRNWYXW4iMB6aKFjbWmZxBD3QEFZQhthw07bfxD-1QIj2eV-feAgb1tYkCjyHkhTHF4iwAHZHT0_edaRSdjzF0iPO35rioE6ZcwXm8BHCrS-v8PSe3OOGk6lJSIL8oNnuQcf2Fnx6n9B6-QQ5J7lht2Nd4Y7lUNU6R0E6rPbJ0xVn5FCYrgIl7WK500lF2tG%26sig%3DCg0ArKJSzPZ8AMsidwvM&adurl=https%3A%2F%2Fdevelopers.google.com%2Finteractive-media-ads%2Fdocs%2Fvastinspector_dual&app_name=Barc%20Demo%20App&app_version=1.0&ad_duration=10&user_agent=Mozilla%2F5.0%20(Linux%3B%20Android%206.0.1%3B%20A0001%20Build%2FMHC19Q%3B%20wv)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Version%2F4.0%20Chrome%2F55.0.2883.91%20Mobile%20Safari%2F537.36&latitude=26.9009009009009&longitude=75.74599185128507&hash_code=25367816899133443&tiny_url=http%3A%2F%2Fi.teramatrix.in%3A511%2F%3F25367816899133443";
		
			HttpsURLConnection httpConectionWithUrl = (HttpsURLConnection) url.openConnection();

			// add reuqest header
			httpConectionWithUrl.setRequestMethod("POST");
			httpConectionWithUrl.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			if (headerMap != null) {
				for (String Key : headerMap.keySet()) {
					// System.out.println("Key" + Key + " " +
					// headerMap.get(Key));
					httpConectionWithUrl.setRequestProperty(Key, headerMap.get(Key));
				}
			}

			/**
			 * To Get Response Code from called API
			 */
			httpConectionWithUrl.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
			wr.writeBytes(passingParameters);
			wr.flush();
			wr.close();
			int responseCode = httpConectionWithUrl.getResponseCode();
	
			if (responseCode != 200) {
				return null;
			}
			/**
			 * To get the response from the API which was called
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConectionWithUrl.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			response.append(String.valueOf("responseCode:" + responseCode));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	
			/**
			 * To Return the Response
			 */
			//System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			 */
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
