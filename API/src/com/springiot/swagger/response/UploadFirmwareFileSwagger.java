package com.springiot.swagger.response;

import java.util.List;

public class UploadFirmwareFileSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<UploadFirmwareFile> object;

	public List<UploadFirmwareFile> getObject() {
		return object;
	}

	public void setObject(List<UploadFirmwareFile> object) {
		this.object = object;
	}

	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

class UploadFirmwareFile {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}