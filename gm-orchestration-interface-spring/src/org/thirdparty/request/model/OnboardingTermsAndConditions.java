package org.thirdparty.request.model;

public class OnboardingTermsAndConditions {
	private String consent;
	private String consentTimestamp;
	private String documentCode;
	private String documentVersion;
	private String documentLanguage;
	private String validationIdType;
	private OnboardingMNOSubscriberDetails additionalSubscriberDetails;
	
	/**
	 * @return the consent
	 */
	public String getConsent() {
		return consent;
	}
	/**
	 * @param consent the consent to set
	 */
	public void setConsent(String consent) {
		this.consent = consent;
	}
	/**
	 * @return the consentTimestamp
	 */
	public String getConsentTimestamp() {
		return consentTimestamp;
	}
	/**
	 * @param consentTimestamp the consentTimestamp to set
	 */
	public void setConsentTimestamp(String consentTimestamp) {
		this.consentTimestamp = consentTimestamp;
	}
	/**
	 * @return the documentCode
	 */
	public String getDocumentCode() {
		return documentCode;
	}
	/**
	 * @param documentCode the documentCode to set
	 */
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	/**
	 * @return the documentVersion
	 */
	public String getDocumentVersion() {
		return documentVersion;
	}
	/**
	 * @param documentVersion the documentVersion to set
	 */
	public void setDocumentVersion(String documentVersion) {
		this.documentVersion = documentVersion;
	}
	/**
	 * @return the documentLanguage
	 */
	public String getDocumentLanguage() {
		return documentLanguage;
	}
	/**
	 * @param documentLanguage the documentLanguage to set
	 */
	public void setDocumentLanguage(String documentLanguage) {
		this.documentLanguage = documentLanguage;
	}
	/**
	 * @return the validationIdType
	 */
	public String getValidationIdType() {
		return validationIdType;
	}
	/**
	 * @param validationIdType the validationIdType to set
	 */
	public void setValidationIdType(String validationIdType) {
		this.validationIdType = validationIdType;
	}
	/**
	 * @return the additionalSubscriberDetails
	 */
	public OnboardingMNOSubscriberDetails getAdditionalSubscriberDetails() {
		return additionalSubscriberDetails;
	}
	/**
	 * @param additionalSubscriberDetails the additionalSubscriberDetails to set
	 */
	public void setAdditionalSubscriberDetails(OnboardingMNOSubscriberDetails additionalSubscriberDetails) {
		this.additionalSubscriberDetails = additionalSubscriberDetails;
	}
	
}
