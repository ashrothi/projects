package com.springiot.controllers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPOutputStream;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.io.BaseEncoding;

/**
 * This class is used for writing API's controller for handling the Adyen's payment gateway.
 * 
 * @author Mandeep Singh
 */
@Controller
@PropertySource(value = "classpath:/adyenConfig.properties")
public class AdyenPaymentGatewayController {
	@Autowired
	Environment environment;
	
	@RequestMapping(value = "/api/payment/{ammountToPay}/{shopperReference}/{recurringContract}/{shopperEmail}", method = RequestMethod.POST)
	@ResponseBody 
	 public String paymentGateway(HttpServletRequest request, HttpServletResponse response,HttpSession session,@PathVariable("ammountToPay") String ammountToPay, 
			 @PathVariable("shopperReference") String shopperRef, @PathVariable("recurringContract") String recurringContract,
			 @PathVariable("shopperEmail") String shopperMail){
		String testUrl = "";
		try {
			
		/**
		 * General HPP settings
		 * - hppUrl: URL of the Adyen HPP to submit the form to
		 * - hmacKey: shared secret key used to encrypt the signature
		 * 
		 * Both variables are dependent on the environment which should be used (Test/Live).
		 * HMAC key can be set up: Adyen CA >> Skins >> Choose your Skin >> Edit Tab >> Edit HMAC key for Test & Live.
		 */
		String hppUrl = String.valueOf(environment.getProperty("hpp.url"));;
		String hmacKey = String.valueOf(environment.getProperty("hmac.key"));

		/**
		 * Defining variables
		 * The HPP requires certain variables to be posted in order to create a payment possibility for the shopper.
		 * 
		 * The variables that you can post to the HPP are the following:
		 * 
		 * <pre>
		 * merchantReference    : Your reference for this payment.
		 * paymentAmount        : The transaction amount in minor units (e.g. EUR 1.00 = 100).
		 * currencyCode         : The three character ISO currency code.
		 * shipBeforeDate       : The date by which the goods or services specifed in the order must be shipped.
		 *                        Format: YYYY-MM-DD
		 * skinCode             : The code of the skin to be used for the payment.
		 * merchantAccount      : The merchant account for which you want to process the payment.
		 * sessionValidity      : The time by which a payment needs to have been made.
		 *                        Format: YYYY-MM-DDThh:mm:ssTZD
		 * shopperLocale        : A combination of language code and country code used to specify the language to be
		 *                        used in the payment session (e.g. en_GB).
		 * orderData            : A fragment of HTML/text that will be displayed on the HPP. (optional)
		 * countryCode          : Country code according to ISO_3166-1_alpha-2 standard. (optional)
		 * shopperEmail         : The shopper's email address. (recommended)
		 * shopperReference     : An ID that uniquely identifes the shopper, such as a customer id. (recommended)
		 * allowedMethods       : A comma-separated list of allowed payment methods, i.e. "ideal,mc,visa". (optional)
		 * blockedMethods       : A comma-separated list of blocked payment methods, i.e. "ideal,mc,visa". (optional)
		 * offset               : An integer that is added to the normal fraud score. (optional)
		 * merchantSig          : The HMAC signature used by Adyen to test the validy of the form.
		 * </pre>
		 */
		// Generate dates
		Calendar calendar = Calendar.getInstance();
		// current date
		Date currentDate = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		// current date + 1 day
		Date sessionDate = calendar.getTime();
		calendar.add(Calendar.DATE, 2);
		// current date + 3 days
		Date shippingDate = calendar.getTime();

		// Define variables
		String merchantReference = "TEST-PAYMENT-" + new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(currentDate);
		String paymentAmount = ammountToPay;
		String currencyCode = String.valueOf(environment.getProperty("currency.code"));
		String shipBeforeDate = new SimpleDateFormat("yyyy-MM-dd").format(shippingDate);
		String skinCode = String.valueOf(environment.getProperty("skin.code"));
		String merchantAccount = String.valueOf(environment.getProperty("merchant.account"));
		String sessionValidity = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(sessionDate);
		String shopperLocale = String.valueOf(environment.getProperty("shopper.locale"));
		String orderData = compressString("Orderdata to display on the HPP can be put here");
		String countryCode = String.valueOf(environment.getProperty("country.code"));
		String shopperEmail = "";
		String shopperReference = "";
		String allowedMethods = "";
		String blockedMethods = "";
		String offset = "";
		String merchantReturnData ="";
		String url = "purchaseView";
		String planStatus = "PURCHASE";
		
		
		Map<String, String> pairs = new HashMap<>();
		pairs.put("shopperLocale", shopperLocale);
		pairs.put("merchantReference", merchantReference);
		pairs.put("merchantAccount", merchantAccount);
		pairs.put("sessionValidity", sessionValidity/*"2018-07-25T10:31:06Z"*/);
		pairs.put("shipBeforeDate", shipBeforeDate);
		pairs.put("paymentAmount", paymentAmount);
		pairs.put("currencyCode", currencyCode);
		pairs.put("skinCode", skinCode);
		
		pairs.put("shopperReference", shopperRef);
		pairs.put("recurringContract", recurringContract);
		pairs.put("shopperEmail", shopperMail);
		
		System.out.println("pairs map: "+pairs);
		
	   //TO send back to purchase screen
		SortedMap<String, String> sortedPairs = new TreeMap<>(pairs);
		SortedMap<String, String> escapedPairs =
		        sortedPairs.entrySet().stream()
		                .collect(Collectors.toMap(
		                        e -> e.getKey(),
		                        e -> (e.getValue() == null) ? "" : e.getValue().replace("\\", "\\\\").replace(":", "\\:"),
		                        (k, v) -> k,
		                        TreeMap::new
		                ));
		
		String signingString = Stream.concat(escapedPairs.keySet().stream(), escapedPairs.values().stream())
		        .collect(Collectors.joining(":"));
		
		byte[] binaryHmacKey = BaseEncoding.base16().decode(hmacKey);
		
		SecretKeySpec signingKey = new SecretKeySpec(binaryHmacKey, "HmacSHA256");

		// Get an HMAC SHA-256 Mac instance and initialize with the signing key
		Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
		
		// calculate the hmac on the binary representation of the signing string
		byte[] binaryHmac = mac.doFinal(signingString.getBytes(Charset.forName("UTF8")));
		
		String signature = java.util.Base64.getEncoder().encodeToString(binaryHmac);
		pairs.put("merchantSig", signature);
		
		/**
		 * Generating the payment URL
		 * 
		 * All variables are appended to the query string of the provided hppUrl. Please note that not all browsers are
		 * capable of handling large URLs, and all parameters and their values should be URL-encoded using UTF-8
		 * character encoding.
		 */
		String queryString = pairs.keySet().stream()
		        .map(key -> {
		            try {
		                return key + "=" +  URLEncoder.encode(pairs.get(key), "UTF-8");
		            } catch (UnsupportedEncodingException e) {
		                e.printStackTrace();
		            }
		            return "Error: could not URL-encode value";
		        }).collect(Collectors.joining("&"));

		 testUrl = hppUrl + "?" + queryString;
		// Set correct character encoding
		response.setCharacterEncoding("UTF-8");

		System.out.println("test url: "+testUrl.toString());
		request.setAttribute("paymentUrl", testUrl.toString());

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return testUrl.toString();
	}
	
	/**
	 * Generates GZIP compressed and Base64 encoded string.
	 */
	private String compressString(String input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(output);

		gzip.write(input.getBytes("UTF-8"));
		gzip.close();
		output.close();

		return Base64.encodeBase64String(output.toByteArray());
	}
}
