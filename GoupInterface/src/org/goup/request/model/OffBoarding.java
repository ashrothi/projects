package org.goup.request.model;

public class OffBoarding {
	private String requestId;
	private String returnUrl;
	private OffBoardingDevice device;
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the returnUrl
	 */
	public String getReturnUrl() {
		return returnUrl;
	}
	/**
	 * @param returnUrl the returnUrl to set
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	/**
	 * @return the device
	 */
	public OffBoardingDevice getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(OffBoardingDevice device) {
		this.device = device;
	}
	
	
}
