/**
 * This package contain class for Process Parameter to get Parameters for Calling Api as Map
 */
package org.orchestration.constant;

/**
 * To Import Classes to access their functionality
 * @author Ankita Shrothi
 */
import java.util.Map;

/**
 * 
 * This class defines the format of the storing procedure names with their key
 * values.Every unique key has mapped to their respective procedure call method string
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class OrchestrationProcessParameter {

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
