/**
 * This package contains the classes for maintaining the values which 
 * remains same in complete project and their getters and setters.
 */
package com.springiot.constant;

import java.util.Map;

/**
 * This class is used for defining the getters and setters
 * for the map used for getting parameters for API call.
 * 
 * @author Mandeep Singh
 *
 */
public class ProcessParameter {

	/**
	 * Initialized the Map to store the passing parameters.
	 */
	private Map<String, Object> maps;

	/**
	 * To get the Map
	 * 
	 * @return maps
	 */
	public Map<String, Object> getMaps() {
		return maps;
	}

	/**
	 * To set the Map
	 * 
	 * @param maps
	 */
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
}