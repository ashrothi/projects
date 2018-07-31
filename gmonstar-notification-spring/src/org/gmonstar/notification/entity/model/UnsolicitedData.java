package org.gmonstar.notification.entity.model;

public class UnsolicitedData {

	private String userIdentifier;
	private String messageUuid;
	private String typeEntryId;
	private String userPurchaseId;
	private String notificationUrl;
	private String notificationAuthToken;
	private String iccid;
	private String imsi;
	private String msisdn;

	/**
	 * @return the userIdentifier
	 */
	public String getUserIdentifier() {
		return userIdentifier;
	}

	/**
	 * @param userIdentifier
	 *            the userIdentifier to set
	 */
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	/**
	 * @return the messageUuid
	 */
	public String getMessageUuid() {
		return messageUuid;
	}

	/**
	 * @param messageUuid
	 *            the messageUuid to set
	 */
	public void setMessageUuid(String messageUuid) {
		this.messageUuid = messageUuid;
	}

	/**
	 * @return the typeEntryId
	 */
	public String getTypeEntryId() {
		return typeEntryId;
	}

	/**
	 * @param typeEntryId
	 *            the typeEntryId to set
	 */
	public void setTypeEntryId(String typeEntryId) {
		this.typeEntryId = typeEntryId;
	}

	/**
	 * @return the userPurchaseId
	 */
	public String getUserPurchaseId() {
		return userPurchaseId;
	}

	/**
	 * @param userPurchaseId
	 *            the userPurchaseId to set
	 */
	public void setUserPurchaseId(String userPurchaseId) {
		this.userPurchaseId = userPurchaseId;
	}

	/**
	 * @return the notificationUrl
	 */
	public String getNotificationUrl() {
		return notificationUrl;
	}

	/**
	 * @param notificationUrl
	 *            the notificationUrl to set
	 */
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	/**
	 * @return the notificationAuthToken
	 */
	public String getNotificationAuthToken() {
		return notificationAuthToken;
	}

	/**
	 * @param notificationAuthToken
	 *            the notificationAuthToken to set
	 */
	public void setNotificationAuthToken(String notificationAuthToken) {
		this.notificationAuthToken = notificationAuthToken;
	}

	/**
	 * @return the iccid
	 */
	public String getIccid() {
		return iccid;
	}

	/**
	 * @param iccid
	 *            the iccid to set
	 */
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	/**
	 * @return the imsi
	 */
	public String getImsi() {
		return imsi;
	}

	/**
	 * @param imsi
	 *            the imsi to set
	 */
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn
	 *            the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

}
