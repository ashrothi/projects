package com.rld.message;

import java.util.List;

/**
 * This Class is used to Define Message For API's.
 * This is domain class required
 */
public class Message {

	private String description;
	private Object data;
	private List<Object> list;
	private boolean success;
	private Object databaseProperties;
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String NCCS;
	private String AgeGroup;
	private String StateGroup;
	/**
	 * To get the Message
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * To set the Message
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * To get the List
	 * 
	 * @return list
	 */
	public List<Object> getList() {
		return list;
	}

	/**
	 * To set the list
	 * 
	 * @param list
	 */
	public void setList(List<Object> list) {
		this.list = list;
	}

	/**
	 * To get the object
	 * 
	 * @return data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * To set the object
	 * 
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * To get the boolean value response
	 * 
	 * @return success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * To set the boolean value respnse
	 * 
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getDatabaseproperties() {
		return databaseProperties;
	}

	public void setDatabaseProperties(Object databaseProperties) {
		this.databaseProperties = databaseProperties;
	}

	public String getNCCS() {
		return NCCS;
	}

	public void setNCCS(String nCCS) {
		NCCS = nCCS;
	}

	public String getAgeGroup() {
		return AgeGroup;
	}

	public void setAgeGroup(String ageGroup) {
		AgeGroup = ageGroup;
	}

	public String getStateGroup() {
		return StateGroup;
	}

	public void setStateGroup(String stateGroup) {
		StateGroup = stateGroup;
	}
	
	
}