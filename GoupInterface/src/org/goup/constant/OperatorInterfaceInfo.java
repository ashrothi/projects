package org.goup.constant;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class OperatorInterfaceInfo {
	
	/**
	 * Parameter to Store Map
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
