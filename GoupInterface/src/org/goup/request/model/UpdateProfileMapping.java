package org.goup.request.model;

public class UpdateProfileMapping {
	private String RequestID;
	private String MessageID;
	private String ICCID;
	
	/**
	 * @return the requestID
	 */
	public String getRequestID() {
		return RequestID;
	}

	/**
	 * @param requestID
	 *            the requestID to set
	 */
	public void setRequestID(String requestID) {
		RequestID = requestID;
	}

	/**
	 * @return the messageID
	 */
	public String getMessageID() {
		return MessageID;
	}

	/**
	 * @param messageID
	 *            the messageID to set
	 */
	public void setMessageID(String messageID) {
		MessageID = messageID;
	}

	/**
	 * @return the iCCID
	 */
	public String getICCID() {
		return ICCID;
	}

	/**
	 * @param iCCID the iCCID to set
	 */
	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}

	
}
