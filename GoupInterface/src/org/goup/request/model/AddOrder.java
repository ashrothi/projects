package org.goup.request.model;

public class AddOrder {

	private String requestId;
	private String returnUrl;

	private OnboardingDevice deviceDetails;
	private OnBoardingsubscriberDetails subscriberDetails;
	private OnboardingTermsAndConditions termsAndConditions;
	private AddOrderServicePlan servicePlan;
	private AddOrderPaymentDetails paymentDetails;
	private AddOrderPaymentMethod paymentMethod;

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
	 * @param deviceDetails
	 *            the deviceDetails to set
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

	/**
	 * @return the termsAndConditions
	 */
	public OnboardingTermsAndConditions getTermsAndConditions() {
		return termsAndConditions;
	}

	/**
	 * @param termsAndConditions
	 *            the termsAndConditions to set
	 */
	public void setTermsAndConditions(OnboardingTermsAndConditions termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	/**
	 * @return the servicePlan
	 */
	public AddOrderServicePlan getServicePlan() {
		return servicePlan;
	}

	/**
	 * @param servicePlan
	 *            the servicePlan to set
	 */
	public void setServicePlan(AddOrderServicePlan servicePlan) {
		this.servicePlan = servicePlan;
	}

	/**
	 * @return the paymentDetails
	 */
	public AddOrderPaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	/**
	 * @param paymentDetails
	 *            the paymentDetails to set
	 */
	public void setPaymentDetails(AddOrderPaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	/**
	 * @return the paymentMethod
	 */
	public AddOrderPaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod
	 *            the paymentMethod to set
	 */
	public void setPaymentMethod(AddOrderPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
