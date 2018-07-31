package demo;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509KeyManager;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());
	private static final String LINE_BREAKER = System.getProperty("line.separator");

	private static final String CERTIFACATE_FILE = "/home/tanvigarg/Downloads/wildcard_gt_client.pem";
	private static final String CERTIFACATE_PASS = "ttpl@123";
	private static final String CERTIFACATE_ALIAS = "globetouch";
	private static final String TARGET_URL = "https://35.159.5.214:8281/carrierOutboundGateway/v1/subscribers";

	public static void main(String[] args) {

		// try {
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

			public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
				if (hostname.equals("35.159.5.214")) {
					return true;
				}
				return false;
			}
		});

		String targetURL = TARGET_URL;
		URL url;
		HttpsURLConnection connection = null;
		BufferedReader bufferedReader = null;
		InputStream is = null;

		try { // Create connection
			url = new URL(targetURL);
			// Uncomment } this in case server demands some unsafe operations
			// System.setProperty("sun.security.ssl.allowUnsafeRenegotiation",
			// // "true");

			String urlParameters = "{  \n   \"device\":{  \n      \"iccid\":\"8944200012781000069\",\n      \"imsi\":\"234208510100029\",\n      \"msisdn\":\"91342085104\"\n   },\n   \"subscriberDetails\":{  \n      \"title\":\"Colonel\",\n      \"firstName\":\"Ashutosh\",\n      \"lastName\":\"Mathur\",\n      \"address\":{  \n         \"addressLine1\":\"B-313,Ashok Nagar\",\n         \"addressLine2\":\"\",\n         \"city\":\"Greater Noida\",\n         \"state\":\"Uttar Pradesh\",\n         \"postalCode\":\"110096\",\n         \"countryCode\":\"UP\"\n      },\n      \"communication\":{  \n         \"emailAddress\":\"ashutosh@gmail.com\",\n         \"mobilePhone\":\"7838846854\"\n      },\n      \"preferredLanguageCode\":\"en-UK\"\n   },\n   \"termsAndConditions\":{  \n      \"consent\":\"true\",\n      \"consentTimestamp\":\"2017-05-18T18:13:57.076Z\",\n      \"documentCode\":\"sds\",\n      \"documentVersion\":\"1.0\",\n      \"documentLanguage\":\"en-UK\",\n      \"validationIdType\":\"email\",\n      \"additionalSubscriberDetails\":{  \n         \"dateOfBirth\":\"1986-02-02\",\n         \"placeOfBirth\":\"IN\",\n         \"idType\":\"PP\",\n         \"idNumber\":\"B123324N\"\n      }\n   },\n   \"servicePlan\":{  \n      \"planId\":\"58\"\n   }\n}";
			connection = (HttpsURLConnection) url.openConnection();
			SSLSocketFactory sslSocketFactory = getFactory(new File(CERTIFACATE_FILE), CERTIFACATE_PASS,
					CERTIFACATE_ALIAS);
			connection.setSSLSocketFactory(sslSocketFactory);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setRequestProperty("authorization", "Basic b2xfY29yZUBnbG9iZXRvdWNoLmNvbTpnbG9iZXRvdWNo");
			connection.setRequestProperty("content-type", "application/json");
			connection.setRequestProperty("accept-language", "EN");
			connection.setRequestProperty("requestid", "Onbaording0609047");
			connection.setRequestProperty("returnurl", "http://182.73.55.66:17151/carrierInboundGateway/v1");
			connection.setRequestProperty("accept", "application/json");

			
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			// Process response
			is = connection.getInputStream();

			bufferedReader = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer lines = new StringBuffer();
			while ((line = bufferedReader.readLine()) != null) {
				lines.append(line).append(LINE_BREAKER);
			}
			logger.info("response from " + targetURL + ":" + LINE_BREAKER + lines);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static SSLSocketFactory getFactory(File pKeyFile, String pKeyPassword, String certAlias) throws Exception {
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		KeyStore keyStore = KeyStore.getInstance("JKS");

		InputStream keyInput = new FileInputStream(pKeyFile);

		keyStore.load(keyInput, pKeyPassword.toCharArray());
		keyInput.close();
		keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());

		// Replace the original KeyManagers with the AliasForcingKeyManager
		KeyManager[] kms = keyManagerFactory.getKeyManagers();
		for (int i = 0; i < kms.length; i++) {
			if (kms[i] instanceof X509KeyManager) {
				kms[i] = new AliasForcingKeyManager((X509KeyManager) kms[i], certAlias);
			}
		}

		SSLContext context = SSLContext.getInstance("TLS");
		context.init(kms, null, null);
		return context.getSocketFactory();

	}

	/*
	 * This wrapper class overwrites the default behavior of a X509KeyManager
	 * and always render a specific certificate whose alias matches that
	 * provided in the constructor
	 */
	private static class AliasForcingKeyManager implements X509KeyManager {

		X509KeyManager baseKM = null;
		String alias = null;

		public AliasForcingKeyManager(X509KeyManager keyManager, String alias) {
			baseKM = keyManager;
			this.alias = alias;
		}

		/*
		 * Always render the specific alias provided in the constructor
		 */
		public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
			return alias;
		}

		public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
			return baseKM.chooseServerAlias(keyType, issuers, socket);
		}

		public X509Certificate[] getCertificateChain(String alias) {
			return baseKM.getCertificateChain(alias);
		}

		public String[] getClientAliases(String keyType, Principal[] issuers) {
			return baseKM.getClientAliases(keyType, issuers);
		}

		public PrivateKey getPrivateKey(String alias) {
			return baseKM.getPrivateKey(alias);
		}

		public String[] getServerAliases(String keyType, Principal[] issuers) {
			return baseKM.getServerAliases(keyType, issuers);
		}
	}
}
