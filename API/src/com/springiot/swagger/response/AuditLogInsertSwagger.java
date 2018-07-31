package com.springiot.swagger.response;

import java.util.List;

public class AuditLogInsertSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<AuditLogInsert> object;

	public List<AuditLogInsert> getObject() {
		return object;
	}

	public void setObject(List<AuditLogInsert> object) {
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

class AuditLogInsert {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
