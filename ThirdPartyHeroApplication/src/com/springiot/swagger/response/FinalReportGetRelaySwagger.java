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
 * This class contains response on /final/report/get/relay API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportGetRelaySwagger {
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

	private List<FinalReportGetRelay> object;

	/**
	 * @return the object
	 */
	public List<FinalReportGetRelay> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportGetRelay> object) {
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
class FinalReportGetRelay {
	private int id; 
	private String device_id; 
	private String device_name; 
	private String vendor_code; 
	private String report_date; 
	private String testing_version; 
	private String component; 
	private String slot; 
	private String contact_point_voltage_drop_min_specification; 
	private String contact_point_voltage_drop_max_specification; 
	private String coil_current_min_specification; 
	private String coil_current_max_specification; 
	private String starting_voltage_min_specification; 
	private String starting_voltage_max_specification; 
	private String recovery_voltage_min_specification; 
	private String recovery_voltage_max_specification; 
	private String insulation_resistance_min_specification; 
	private String insulation_resistance_max_specification; 
	private String load_current_min_specification; 
	private String load_current_max_specification; 
	private String appearance_min_specification;
	private String contact_point_voltage_drop_before; 
	private String contact_point_voltage_drop_after; 
	private String coil_current_before; 
	private String coil_current_after; 
	private String starting_voltage_before; 
	private String starting_voltage_after; 
	private String recovery_voltage_before; 
	private String recovery_voltage_after; 
	private String insulation_resistance_before; 
	private String insulation_resistance_after; 
	private String appearance_before; 
	private String appearance_after; 
	private String load_current_before; 
	private String load_current_after; 
	private String cycle_before;  
	private String cycle_after; 
	private int judgement_before; 
	private int judgement_after;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the device_id
	 */
	public String getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}
	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	/**
	 * @return the vendor_code
	 */
	public String getVendor_code() {
		return vendor_code;
	}
	/**
	 * @param vendor_code the vendor_code to set
	 */
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	/**
	 * @return the report_date
	 */
	public String getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	/**
	 * @return the testing_version
	 */
	public String getTesting_version() {
		return testing_version;
	}
	/**
	 * @param testing_version the testing_version to set
	 */
	public void setTesting_version(String testing_version) {
		this.testing_version = testing_version;
	}
	/**
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}
	/**
	 * @param component the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}
	/**
	 * @return the slot
	 */
	public String getSlot() {
		return slot;
	}
	/**
	 * @param slot the slot to set
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	/**
	 * @return the contact_point_voltage_drop_min_specification
	 */
	public String getContact_point_voltage_drop_min_specification() {
		return contact_point_voltage_drop_min_specification;
	}
	/**
	 * @param contact_point_voltage_drop_min_specification the contact_point_voltage_drop_min_specification to set
	 */
	public void setContact_point_voltage_drop_min_specification(String contact_point_voltage_drop_min_specification) {
		this.contact_point_voltage_drop_min_specification = contact_point_voltage_drop_min_specification;
	}
	/**
	 * @return the contact_point_voltage_drop_max_specification
	 */
	public String getContact_point_voltage_drop_max_specification() {
		return contact_point_voltage_drop_max_specification;
	}
	/**
	 * @param contact_point_voltage_drop_max_specification the contact_point_voltage_drop_max_specification to set
	 */
	public void setContact_point_voltage_drop_max_specification(String contact_point_voltage_drop_max_specification) {
		this.contact_point_voltage_drop_max_specification = contact_point_voltage_drop_max_specification;
	}
	/**
	 * @return the coil_current_min_specification
	 */
	public String getCoil_current_min_specification() {
		return coil_current_min_specification;
	}
	/**
	 * @param coil_current_min_specification the coil_current_min_specification to set
	 */
	public void setCoil_current_min_specification(String coil_current_min_specification) {
		this.coil_current_min_specification = coil_current_min_specification;
	}
	/**
	 * @return the coil_current_max_specification
	 */
	public String getCoil_current_max_specification() {
		return coil_current_max_specification;
	}
	/**
	 * @param coil_current_max_specification the coil_current_max_specification to set
	 */
	public void setCoil_current_max_specification(String coil_current_max_specification) {
		this.coil_current_max_specification = coil_current_max_specification;
	}
	/**
	 * @return the starting_voltage_min_specification
	 */
	public String getStarting_voltage_min_specification() {
		return starting_voltage_min_specification;
	}
	/**
	 * @param starting_voltage_min_specification the starting_voltage_min_specification to set
	 */
	public void setStarting_voltage_min_specification(String starting_voltage_min_specification) {
		this.starting_voltage_min_specification = starting_voltage_min_specification;
	}
	/**
	 * @return the starting_voltage_max_specification
	 */
	public String getStarting_voltage_max_specification() {
		return starting_voltage_max_specification;
	}
	/**
	 * @param starting_voltage_max_specification the starting_voltage_max_specification to set
	 */
	public void setStarting_voltage_max_specification(String starting_voltage_max_specification) {
		this.starting_voltage_max_specification = starting_voltage_max_specification;
	}
	/**
	 * @return the recovery_voltage_min_specification
	 */
	public String getRecovery_voltage_min_specification() {
		return recovery_voltage_min_specification;
	}
	/**
	 * @param recovery_voltage_min_specification the recovery_voltage_min_specification to set
	 */
	public void setRecovery_voltage_min_specification(String recovery_voltage_min_specification) {
		this.recovery_voltage_min_specification = recovery_voltage_min_specification;
	}
	/**
	 * @return the recovery_voltage_max_specification
	 */
	public String getRecovery_voltage_max_specification() {
		return recovery_voltage_max_specification;
	}
	/**
	 * @param recovery_voltage_max_specification the recovery_voltage_max_specification to set
	 */
	public void setRecovery_voltage_max_specification(String recovery_voltage_max_specification) {
		this.recovery_voltage_max_specification = recovery_voltage_max_specification;
	}
	/**
	 * @return the insulation_resistance_min_specification
	 */
	public String getInsulation_resistance_min_specification() {
		return insulation_resistance_min_specification;
	}
	/**
	 * @param insulation_resistance_min_specification the insulation_resistance_min_specification to set
	 */
	public void setInsulation_resistance_min_specification(String insulation_resistance_min_specification) {
		this.insulation_resistance_min_specification = insulation_resistance_min_specification;
	}
	/**
	 * @return the insulation_resistance_max_specification
	 */
	public String getInsulation_resistance_max_specification() {
		return insulation_resistance_max_specification;
	}
	/**
	 * @param insulation_resistance_max_specification the insulation_resistance_max_specification to set
	 */
	public void setInsulation_resistance_max_specification(String insulation_resistance_max_specification) {
		this.insulation_resistance_max_specification = insulation_resistance_max_specification;
	}
	/**
	 * @return the load_current_min_specification
	 */
	public String getLoad_current_min_specification() {
		return load_current_min_specification;
	}
	/**
	 * @param load_current_min_specification the load_current_min_specification to set
	 */
	public void setLoad_current_min_specification(String load_current_min_specification) {
		this.load_current_min_specification = load_current_min_specification;
	}
	/**
	 * @return the load_current_max_specification
	 */
	public String getLoad_current_max_specification() {
		return load_current_max_specification;
	}
	/**
	 * @param load_current_max_specification the load_current_max_specification to set
	 */
	public void setLoad_current_max_specification(String load_current_max_specification) {
		this.load_current_max_specification = load_current_max_specification;
	}
	/**
	 * @return the appearance_min_specification
	 */
	public String getAppearance_min_specification() {
		return appearance_min_specification;
	}
	/**
	 * @param appearance_min_specification the appearance_min_specification to set
	 */
	public void setAppearance_min_specification(String appearance_min_specification) {
		this.appearance_min_specification = appearance_min_specification;
	}
	/**
	 * @return the contact_point_voltage_drop_before
	 */
	public String getContact_point_voltage_drop_before() {
		return contact_point_voltage_drop_before;
	}
	/**
	 * @param contact_point_voltage_drop_before the contact_point_voltage_drop_before to set
	 */
	public void setContact_point_voltage_drop_before(String contact_point_voltage_drop_before) {
		this.contact_point_voltage_drop_before = contact_point_voltage_drop_before;
	}
	/**
	 * @return the contact_point_voltage_drop_after
	 */
	public String getContact_point_voltage_drop_after() {
		return contact_point_voltage_drop_after;
	}
	/**
	 * @param contact_point_voltage_drop_after the contact_point_voltage_drop_after to set
	 */
	public void setContact_point_voltage_drop_after(String contact_point_voltage_drop_after) {
		this.contact_point_voltage_drop_after = contact_point_voltage_drop_after;
	}
	/**
	 * @return the coil_current_before
	 */
	public String getCoil_current_before() {
		return coil_current_before;
	}
	/**
	 * @param coil_current_before the coil_current_before to set
	 */
	public void setCoil_current_before(String coil_current_before) {
		this.coil_current_before = coil_current_before;
	}
	/**
	 * @return the coil_current_after
	 */
	public String getCoil_current_after() {
		return coil_current_after;
	}
	/**
	 * @param coil_current_after the coil_current_after to set
	 */
	public void setCoil_current_after(String coil_current_after) {
		this.coil_current_after = coil_current_after;
	}
	/**
	 * @return the starting_voltage_before
	 */
	public String getStarting_voltage_before() {
		return starting_voltage_before;
	}
	/**
	 * @param starting_voltage_before the starting_voltage_before to set
	 */
	public void setStarting_voltage_before(String starting_voltage_before) {
		this.starting_voltage_before = starting_voltage_before;
	}
	/**
	 * @return the starting_voltage_after
	 */
	public String getStarting_voltage_after() {
		return starting_voltage_after;
	}
	/**
	 * @param starting_voltage_after the starting_voltage_after to set
	 */
	public void setStarting_voltage_after(String starting_voltage_after) {
		this.starting_voltage_after = starting_voltage_after;
	}
	/**
	 * @return the recovery_voltage_before
	 */
	public String getRecovery_voltage_before() {
		return recovery_voltage_before;
	}
	/**
	 * @param recovery_voltage_before the recovery_voltage_before to set
	 */
	public void setRecovery_voltage_before(String recovery_voltage_before) {
		this.recovery_voltage_before = recovery_voltage_before;
	}
	/**
	 * @return the recovery_voltage_after
	 */
	public String getRecovery_voltage_after() {
		return recovery_voltage_after;
	}
	/**
	 * @param recovery_voltage_after the recovery_voltage_after to set
	 */
	public void setRecovery_voltage_after(String recovery_voltage_after) {
		this.recovery_voltage_after = recovery_voltage_after;
	}
	/**
	 * @return the insulation_resistance_before
	 */
	public String getInsulation_resistance_before() {
		return insulation_resistance_before;
	}
	/**
	 * @param insulation_resistance_before the insulation_resistance_before to set
	 */
	public void setInsulation_resistance_before(String insulation_resistance_before) {
		this.insulation_resistance_before = insulation_resistance_before;
	}
	/**
	 * @return the insulation_resistance_after
	 */
	public String getInsulation_resistance_after() {
		return insulation_resistance_after;
	}
	/**
	 * @param insulation_resistance_after the insulation_resistance_after to set
	 */
	public void setInsulation_resistance_after(String insulation_resistance_after) {
		this.insulation_resistance_after = insulation_resistance_after;
	}
	/**
	 * @return the appearance_before
	 */
	public String getAppearance_before() {
		return appearance_before;
	}
	/**
	 * @param appearance_before the appearance_before to set
	 */
	public void setAppearance_before(String appearance_before) {
		this.appearance_before = appearance_before;
	}
	/**
	 * @return the appearance_after
	 */
	public String getAppearance_after() {
		return appearance_after;
	}
	/**
	 * @param appearance_after the appearance_after to set
	 */
	public void setAppearance_after(String appearance_after) {
		this.appearance_after = appearance_after;
	}
	/**
	 * @return the load_current_before
	 */
	public String getLoad_current_before() {
		return load_current_before;
	}
	/**
	 * @param load_current_before the load_current_before to set
	 */
	public void setLoad_current_before(String load_current_before) {
		this.load_current_before = load_current_before;
	}
	/**
	 * @return the load_current_after
	 */
	public String getLoad_current_after() {
		return load_current_after;
	}
	/**
	 * @param load_current_after the load_current_after to set
	 */
	public void setLoad_current_after(String load_current_after) {
		this.load_current_after = load_current_after;
	}
	/**
	 * @return the cycle_before
	 */
	public String getCycle_before() {
		return cycle_before;
	}
	/**
	 * @param cycle_before the cycle_before to set
	 */
	public void setCycle_before(String cycle_before) {
		this.cycle_before = cycle_before;
	}
	/**
	 * @return the cycle_after
	 */
	public String getCycle_after() {
		return cycle_after;
	}
	/**
	 * @param cycle_after the cycle_after to set
	 */
	public void setCycle_after(String cycle_after) {
		this.cycle_after = cycle_after;
	}
	/**
	 * @return the judgement_before
	 */
	public int getJudgement_before() {
		return judgement_before;
	}
	/**
	 * @param judgement_before the judgement_before to set
	 */
	public void setJudgement_before(int judgement_before) {
		this.judgement_before = judgement_before;
	}
	/**
	 * @return the judgement_after
	 */
	public int getJudgement_after() {
		return judgement_after;
	}
	/**
	 * @param judgement_after the judgement_after to set
	 */
	public void setJudgement_after(int judgement_after) {
		this.judgement_after = judgement_after;
	} 


}
