package com.rld.common;

import java.util.HashMap;
/*
 * Interface is made to call the method calingRestApi for getting the response from API.
*/
public interface CommonInterface {

	public String callingRestAPI(String url,HashMap<String, String> params);
}
