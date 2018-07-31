package org.goup.request.model;

public class swapHardware {

	private NewIccid newDeviceId;
	private OriginalDeviceId originalDeviceId;

	/**
	 * @return the newDeviceId
	 */
	public NewIccid getNewDeviceId() {
		return newDeviceId;
	}

	/**
	 * @param newDeviceId
	 *            the newDeviceId to set
	 */
	public void setNewDeviceId(NewIccid newDeviceId) {
		this.newDeviceId = newDeviceId;
	}

	/**
	 * @return the originalDeviceId
	 */
	public OriginalDeviceId getOriginalDeviceId() {
		return originalDeviceId;
	}

	/**
	 * @param originalDeviceId
	 *            the originalDeviceId to set
	 */
	public void setOriginalDeviceId(OriginalDeviceId originalDeviceId) {
		this.originalDeviceId = originalDeviceId;
	}

}
