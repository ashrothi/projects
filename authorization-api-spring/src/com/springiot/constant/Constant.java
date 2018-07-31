package com.springiot.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to generate tokens and maintaining tokens in Map.
 **/
public class Constant {
	/*
	 * Map is created,to store the value of Authentication token.
	 **/
	public static Map<String, Object> accessmap = new HashMap<>();

	/**
	 * Method provides the token management
	 **/
	public static void addTokon(String accessMap, Object object) {
		/*
		 * This function will clear the garbage and release object when no loger
		 * require.
		 */

		accessmap.put(accessMap, object);
	}

}
