package org.thirdparty.request.model;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class SimProfile {
	private String countryCode;
	private String targetProfile;
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the targetProfile
	 */
	public String getTargetProfile() {
		return targetProfile;
	}
	/**
	 * @param targetProfile the targetProfile to set
	 */
	public void setTargetProfile(String targetProfile) {
		this.targetProfile = targetProfile;
	}
	
	


}
