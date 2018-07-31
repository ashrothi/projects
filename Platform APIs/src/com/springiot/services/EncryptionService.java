/**
 * This package contains the class which is used as a service class for encryption used for SSO
 */
package com.springiot.services;

import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

/**
 * This class is used to encrypt and decrypt username and password for
 * SSO(Single sign on)
 * 
 * @author tanvigarg
 *
 */
@Service
public class EncryptionService {

	// Access the functionality of token services class
	@Autowired
	private TokenServices tokenServices;

	/*
	 * This method will get the encrypted username and password, decrypt the
	 * same and if user exists in the database,it provides login credentials to
	 * access this platform.
	 */
	public Message plainTextToEncryptedFormat(String encrypted_username, String encrypted_password,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Initialization of message class
		Message message = new Message();

		try {

			// Key for the process of encryption and decryption
			String key = "teramatrixttpl12";

			// Decryption of username and password

			String usernameDecrypt = decrypt(encrypted_username, key);
			String passwordDecrypt = decrypt(encrypted_password, key);

			// Import the plain text of username and password in map
			Map<String, String> map = new HashMap<>();
			map.put("username", usernameDecrypt);
			map.put("password", passwordDecrypt);

			// Calling of token API
			Message responseMessage = tokenServices.oauthToken(usernameDecrypt, passwordDecrypt,
					"9a959887-5946-11e6-9bb0-fe984cc15272", request, response);

			// Set the success response
			message.setDescription("Process Succes");
			message.setObject(map);
			message.setValid(true);

			return responseMessage;
		}
		// Handling all exceptions
		catch (Exception exp) {
			exp.printStackTrace();
//			System.err.println(exp);
		}

		// set the message for response
		return message;
	}

	/**
	 * This method is used for the decryption process
	 * 
	 * @param data,the
	 *            input required to decrypt
	 * @param key,the
	 *            key required for encryption and decryption
	 * @return
	 */
	public static String decrypt(String data, String key) {
		try {
			byte[] b = Base64.decodeBase64(data.getBytes("UTF-8"));

			// The cipher instance with AES/ECB/PKCS5Padding
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"));
			return new String(c.doFinal(b));
		}
		// Handling all exceptions
		catch (Exception exp) {
			System.err.println(exp);
			return data;
		}
	}

}
