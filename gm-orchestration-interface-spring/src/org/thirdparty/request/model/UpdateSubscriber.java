package org.thirdparty.request.model;

public class UpdateSubscriber {
	private String requestId;
	private String returnUrl;

	private UpdateSubscriberDetails subscriberDetails;
	private String preferredLanguageCode;

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
	 * @return the subscriberDetails
	 */
	public UpdateSubscriberDetails getSubscriberDetails() {
		return subscriberDetails;
	}

	/**
	 * @param subscriberDetails
	 *            the subscriberDetails to set
	 */
	public void setSubscriberDetails(UpdateSubscriberDetails subscriberDetails) {
		this.subscriberDetails = subscriberDetails;
	}

	/**
	 * @return the preferredLanguageCode
	 */
	public String getPreferredLanguageCode() {
		return preferredLanguageCode;
	}

	/**
	 * @param preferredLanguageCode
	 *            the preferredLanguageCode to set
	 */
	public void setPreferredLanguageCode(String preferredLanguageCode) {
		this.preferredLanguageCode = preferredLanguageCode;
	}

}
