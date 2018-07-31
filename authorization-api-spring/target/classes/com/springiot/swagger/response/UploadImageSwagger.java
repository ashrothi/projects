package com.springiot.swagger.response;

import java.util.List;

public class UploadImageSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String object;

	public String getObject() {
		return object;
	}

	public void setObject(List<UploadImage> object) {
		String file_path = "/host_name../apache-tomcat-8.0.36/webapps/tmpFiles/File_name";
		this.object = file_path;
	}

	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

class UploadImage {

}