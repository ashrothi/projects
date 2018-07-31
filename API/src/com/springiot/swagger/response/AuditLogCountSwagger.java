package com.springiot.swagger.response;

import java.util.List;

public class AuditLogCountSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<AuditLogCount> object;

	public List<AuditLogCount> getObject() {
		return object;
	}

	public void setObject(List<AuditLogCount> object) {
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

class AuditLogCount {

	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}