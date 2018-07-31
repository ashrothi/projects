package com.springiot.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This class is used to generate tokens and maintaining tokens in Map.
 **/
public class Constant {
	/*
	 * Map is created,to store the value of Authentication token.
	 **/
	public static Map<String, Object> map = new HashMap<>();
	/*
	 * Map is created,to store the Authentication validation check parameter.
	 **/
	public static Map<String, Object> validateUserKey = new HashMap<>();

	/**
	 * Method is created to generate the above specified token.
	 **/
	public static Object genrateToken() {
		String uuid = UUID.randomUUID().toString();

		return uuid;
	}

	/**
	 * Method provides the username and password when application calls the
	 * OAuthEngine.
	 **/
	public static void addTokon(String Token, Object object) {
		/*
		 * This function will clear the garbage and release object when no loger
		 * require.
		 */
		// System.gc();

		map.put(Token, object);
	}

	/*
	 * This method is used to store parameter usefull to validate user.
	 */
	public static void validateUserKey(String Token, Object object) {
		validateUserKey.put(Token, object);
	}
}
