package org.thirdparty.request.model;

public class SIMActivated {
	private ErrorResponse error;
	private String ICCID;
	private String MSISDN;

	/**
	 * @return the error
	 */
	public ErrorResponse getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(ErrorResponse error) {
		this.error = error;
	}

	/**
	 * @return the iCCID
	 */
	public String getICCID() {
		return ICCID;
	}

	/**
	 * @param iCCID
	 *            the iCCID to set
	 */
	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}

	/**
	 * @return the mSISDN
	 */
	public String getMSISDN() {
		return MSISDN;
	}

	/**
	 * @param mSISDN
	 *            the mSISDN to set
	 */
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

}
