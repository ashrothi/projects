/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for getting device frame.
 * 
 * @author Mandeep Singh
 * @creation_date 05-04-2018
 */
public class DeviceFrameGetSwagger {
	private String description;
	private List<DeviceFrameGet> object;
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
	public List<DeviceFrameGet> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<DeviceFrameGet> object) {
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

/**
 * This class is used for setting data into the object.
 */
class DeviceFrameGet {
	// Initializing the variables.
	private Integer id;
	private Integer device_id;
	private String trip_start;
	private Integer number_of_frames;
	private String folder_path;
	private String file_name;
	private String end_time;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the trip_start
	 */
	public String getTrip_start() {
		return trip_start;
	}
	/**
	 * @param trip_start the trip_start to set
	 */
	public void setTrip_start(String trip_start) {
		this.trip_start = trip_start;
	}
	/**
	 * @return the number_of_frames
	 */
	public Integer getNumber_of_frames() {
		return number_of_frames;
	}
	/**
	 * @param number_of_frames the number_of_frames to set
	 */
	public void setNumber_of_frames(Integer number_of_frames) {
		this.number_of_frames = number_of_frames;
	}
	/**
	 * @return the folder_path
	 */
	public String getFolder_path() {
		return folder_path;
	}
	/**
	 * @param folder_path the folder_path to set
	 */
	public void setFolder_path(String folder_path) {
		this.folder_path = folder_path;
	}
	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}
	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	/**
	 * @return the end_time
	 */
	public String getEnd_time() {
		return end_time;
	}
	/**
	 * @param end_time the end_time to set
	 */
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
}