/**
 * This package contain  class for Generating Token for ThirdParty Application for user and store their Oauth anf XfusionPlateform Token and their details
 */
package com.springiot.constant;

/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
	 * To Store Oauth Token
	 */
	public static Map<String, Object> oauthmap = new HashMap<>();
	/**
	 * To Store XfusionPlatform Token
	 */
	public static Map<String, Object> xfusionPaleteform = new HashMap<>();

	/**
	 * To Generate the Token
	 * 
	 * @return uuid
	 */
	public static Object genrateToken() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	/**
	 * To add the Token
	 * 
	 * @param Token
	 * @param object
	 */
	public static void addTokon(String Token, Object object) {
	
		map.put(Token, object);
	}

	/**
	 * To Manage OAuthEngine Token
	 * 
	 * @param Token
	 * @param object
	 */
	public static void addAOuthTokon(String Token, Object object) {
		
		oauthmap.put(Token, object);
	}

	/**
	 * To Manage the XfusionPlateform Token
	 * 
	 * @param Token
	 * @param object
	 */
	public static void addXfusionTokon(String Token, Object object) {
	
		xfusionPaleteform.put(Token, object);
	}

}
