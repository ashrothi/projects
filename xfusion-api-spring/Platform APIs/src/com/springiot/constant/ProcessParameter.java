/**
 * This package contain the classes used to store parameters and required data for token management and user validation.
 */
package com.springiot.constant;

import java.util.Map;

/**
 *  @author Garima Joshi
 * This class is used to store parameters to map while calling procedures.
 **/
public class ProcessParameter {
	/**
	 * Parameter to Store Map Details of procedures.
	 */
	private Map<String, Object> maps;

	/**
	 * To get the Map value
	 * 
	 * @return maps
	 */
	public Map<String, Object> getMaps() {
		return maps;
	}

	/**
	 * To set the Map value
	 * 
	 * @param maps
	 */

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

}
