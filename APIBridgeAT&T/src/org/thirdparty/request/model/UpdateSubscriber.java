package org.thirdparty.request.model;

public class UpdateSubscriber {

	private UpdateSubscriberDetails subscriberDetails;
	private String preferredLanguageCode;

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
