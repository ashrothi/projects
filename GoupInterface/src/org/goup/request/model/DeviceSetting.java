package org.goup.request.model;

import java.util.List;

public class DeviceSetting {

	private String countryCode;
	private List<DeviceSettingData> deviceSettings;

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

	/**
	 * @return the deviceSettings
	 */
	public List<DeviceSettingData> getDeviceSettings() {
		return deviceSettings;
	}

	/**
	 * @param deviceSettings
	 *            the deviceSettings to set
	 */
	public void setDeviceSettings(List<DeviceSettingData> deviceSettings) {
		this.deviceSettings = deviceSettings;
	}

}
