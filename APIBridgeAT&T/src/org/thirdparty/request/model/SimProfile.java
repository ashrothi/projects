package org.thirdparty.request.model;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class SimProfile {
	private String name;
	private String lat_long;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lat_long
	 */
	public String getLat_long() {
		return lat_long;
	}
	/**
	 * @param lat_long the lat_long to set
	 */
	public void setLat_long(String lat_long) {
		this.lat_long = lat_long;
	}
	
	


}
