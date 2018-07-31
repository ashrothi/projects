/**
 * 
 */
package org.goup.request.model;

/**
 * @author Ankita Shrothi
 *
 */

public final class OnBoarding {

	private String requestId;
	private String returnUrl;
	private OnboardingDevice deviceDetails;
	private OnBoardingsubscriberDetails subscriberDetails;
	

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
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
	 * @param returnUrl
	 *            the returnUrl to set
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	
	
	/**
	 * @return the deviceDetails
	 */
	public OnboardingDevice getDeviceDetails() {
		return deviceDetails;
	}

	/**
	 * @param deviceDetails the deviceDetails to set
	 */
	public void setDeviceDetails(OnboardingDevice deviceDetails) {
		this.deviceDetails = deviceDetails;
	}

	/**
	 * @return the subscriberDetails
	 */
	public OnBoardingsubscriberDetails getSubscriberDetails() {
		return subscriberDetails;
	}

	/**
	 * @param subscriberDetails
	 *            the subscriberDetails to set
	 */
	public void setSubscriberDetails(OnBoardingsubscriberDetails subscriberDetails) {
		this.subscriberDetails = subscriberDetails;
	}

	

}
