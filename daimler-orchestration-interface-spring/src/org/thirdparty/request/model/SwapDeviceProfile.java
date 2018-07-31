package org.thirdparty.request.model;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class SwapDeviceProfile {
	private String newICCID;

	/**
	 * @return the newICCID
	 */
	public String getNewICCID() {
		return newICCID;
	}

	/**
	 * @param newICCID the newICCID to set
	 */
	public void setNewICCID(String newICCID) {
		this.newICCID = newICCID;
	}
	


}
