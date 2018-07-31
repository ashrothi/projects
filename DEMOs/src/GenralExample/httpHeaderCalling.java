package GenralExample;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpHeaderCalling {
public static void main(String[] args) {
	try {
		URL urlToCall = new URL("http://localhost:2222/ThirdPartyFlintApplication/roles/get/all/user/application");

		HttpURLConnection httpConectionWithUrl = (HttpURLConnection) urlToCall.openConnection();

		// add reuqest header
		httpConectionWithUrl.setRequestMethod("POST");
		httpConectionWithUrl.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		httpConectionWithUrl.setRequestProperty("token", "225ab82a-bfdb-4f8c-b33f-d7f03e971caa");
		httpConectionWithUrl.setRequestProperty("userKey", "f44f3e0b-594a-11e6-9bb0-fe984cc15272");
		httpConectionWithUrl.setRequestProperty("user_id", "flint@teramatrix.in");
		

		String urlParameters = "application_id=47&calling_type=";

		// Send post request
		httpConectionWithUrl.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		/**
		 * To Get Response Code from called API
		 */
		int responseCode = httpConectionWithUrl.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + urlToCall);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		/**
		 * If dosen't get success code than return null
		 */
		if (responseCode != 200) {
			System.out.println("null");
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
		System.out.println(response.toString());

	} catch (Exception e) {
		/**
		 * To Catch the exception if it was unable to process the
		 * request
		 * 
		 */
		e.printStackTrace();
		
	}
}
	
}
