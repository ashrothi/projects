package org.gmonstar.notification.swagger.response;

import java.util.List;

public class NotificationResponseSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<XfusionViewGetByApplication> object;

	public List<XfusionViewGetByApplication> getObject() {
		return object;
	}

	public void setObject(List<XfusionViewGetByApplication> object) {
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

class XfusionViewGetByApplication {


	
	private String notification_id;

	/**
	 * @return the notification_id
	 */
	public String getNotification_id() {
		return notification_id;
	}

	/**
	 * @param notification_id the notification_id to set
	 */
	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}

	
}
