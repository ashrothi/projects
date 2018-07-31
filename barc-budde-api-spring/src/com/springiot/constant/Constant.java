/**
 * This package contain  class for Generating Token for ThirdParty Application for user and store their Oauth anf XfusionPlateform Token and their details
 */
package com.springiot.constant;

/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class is for Generating Token for ThirdParty Application for user and
 * store their Oauth anf XfusionPlatform Token and their details Application
 * 
 * @author Ankita Shrothi
 *
 */
public class Constant {

	/**
	 * map::: To Generate and Store the ThirdParty Application Tokens
	 */
	public static Map<String, Object> map = new HashMap<>();

	/**
	 * To add the Token
	 * 
	 * @param Token
	 * @param object
	 */
	public static void addTokon(String Token, Object object) {
		map.put(Token, object);
	}

	/*
	 * Map is created,to store the value of Authentication token.
	 **/
	public static Map<String, Object> accessmap = new HashMap<>();

	/**
	 * Method provides the token management
	 **/
	public static void addAccessmap(String accessMap, Object object) {
		/*
		 * This function will clear the garbage and release object when no loger
		 * require.
		 */

		accessmap.put(accessMap, object);
	}

	/*
	 * Map is created,to store the value of Authentication token.
	 **/
	public static Map<String, Object> orgmap = new HashMap<>();

	/**
	 * Method provides the token management
	 **/
	public static void addOrgMap(String orgMap, Object object) {
		/*
		 * This function will clear the garbage and release object when no loger
		 * require.
		 */

		orgmap.put(orgMap, object);
	}
}
