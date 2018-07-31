package org.thirdparty.request.model;

public class DeviceSetting {
	private String enableService;
	private String networkAttachRule;
	private String countryCode;

	/**
	 * @return the enableService
	 */
	public String getEnableService() {
		return enableService;
	}

	/**
	 * @param enableService
	 *            the enableService to set
	 */
	public void setEnableService(String enableService) {
		this.enableService = enableService;
	}

	/**
	 * @return the networkAttachRule
	 */
	public String getNetworkAttachRule() {
		return networkAttachRule;
	}

	/**
	 * @param networkAttachRule
	 *            the networkAttachRule to set
	 */
	public void setNetworkAttachRule(String networkAttachRule) {
		this.networkAttachRule = networkAttachRule;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
