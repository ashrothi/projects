package com.springiot.swagger.response;

import java.util.List;
/**
 * This class contains response on /upload/firmware/file API response
 * @author Ankita Shrothi
 *
 */
public class UploadFirmwareFileSwagger {
	private String description;
	private List<UploadFirmwareFile> object;
	private boolean valid;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the object
	 */
	public List<UploadFirmwareFile> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<UploadFirmwareFile> object) {
		this.object = object;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
/*
*TO get response parameter getter setter
*/
class UploadFirmwareFile {
	private String path;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}