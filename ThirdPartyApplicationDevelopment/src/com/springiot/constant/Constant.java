/**
 * This package contains the classes for maintaining the values which 
 * remains same in complete project and their getters and setters.
 */
package com.springiot.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used for making the token map constant for the whole project.
 * 
 * @author Mandeep Singh
 *
 */
public class Constant {

	/**
	 * Initialized the map for storing the token map.
	 */
	public static Map<String, Object> tokenMap = new HashMap<>();


	/**
	 * This method is used for adding the Token to the map.
	 * 
	 * @param Token : Here pass the object of the token class.
	 * @param object : Here pass the value of token as object.
	 */
	public static void addToken(String Token, Object object) {

		tokenMap.put(Token, object);
	}
	
}
