/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /final/report/insert/horn/observation API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class GenericFinalReportInsertObservationSwagger {
	private String description;
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

	private List<GenericFinalReportInsertObservationSwagger> object;

	/**
	 * @return the object
	 */
	public List<GenericFinalReportInsertObservationSwagger> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GenericFinalReportInsertObservationSwagger> object) {
		this.object = object;
	}

	private boolean valid;

	/**
	 * To get if object is Valid
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}
/**
	 * To set Object Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
/*
*TO get response parameter getter setter
*/
class GenericFinalReportObservation {
	private int in_id; 
	private String observation;
	/**
	 * @return the in_id
	 */
	public int getIn_id() {
		return in_id;
	}
	/**
	 * @param in_id the in_id to set
	 */
	public void setIn_id(int in_id) {
		this.in_id = in_id;
	}
	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}
	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

}
