package com.springiot.constant;

import java.util.Map;

/**
 * This class is used to store parameters to map while calling procedures.
 **/
public class ProcessParameter {

	/**
	 * Parameter to Store Map Details of procedures.
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
