package com.springiot.swagger.response;

import java.util.List;

public class UploadMultipleFileSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<UploadMultipleFile> object;

	public List<UploadMultipleFile> getObject() {
		return object;
	}

	public void setObject(List<UploadMultipleFile> object) {
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

class UploadMultipleFile {
	private String name;
	private String path;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}