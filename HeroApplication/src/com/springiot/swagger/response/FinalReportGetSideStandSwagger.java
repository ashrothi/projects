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
 * This class contains response on /final/report/get/side/stand API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportGetSideStandSwagger {
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

	private List<FinalReportGetSideStand> object;

	/**
	 * @return the object
	 */
	public List<FinalReportGetSideStand> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportGetSideStand> object) {
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
class FinalReportGetSideStand {
	private int id; 
	private int device_id; 
	private String device_name; 
	private String vendor_code; 
	private long report_date; 
	private String testing_version; 
	private String component; 
	private String slot; 
	private String condition_up_to_down_off_min_specification; 
	private String condition_up_to_down_off_max_specification; 
	private String condition_up_to_down_off_on_min_specification; 
	private String condition_up_to_down_off_on_max_specification; 
	private String condition_up_to_down_on_min_specification; 
	private String condition_up_to_down_on_max_specification; 
	private String condition_down_to_up_off_min_specification; 
	private String condition_down_to_up_off_max_specification; 
	private String condition_down_to_up_remain_off_min_specification; 
	private String condition_down_to_up_remain_off_max_specification; 
	private String voltage_drop_min_specification; 
	private String voltage_drop_max_specification; 
	private String max_dist_between_magnet_and_switch_min_specification; 
	private String max_dist_between_magnet_and_switch_max_specification; 
	private String consumption_current_min_specification; 
	private String consumption_current_max_specification; 
	private String insulation_resistance_min_specification; 
	private String insulation_resistance_max_specification; 
	private String condition_up_to_down_off_before;
	private String condition_up_to_down_off_after;
	private String condition_up_to_down_off_on_before; 
	private String condition_up_to_down_off_on_after; 
	private String condition_up_to_down_on_before;
	private String condition_up_to_down_on_after;
	private String condition_down_to_up_off_before; 
	private String condition_down_to_up_off_after; 
	private String condition_down_to_up_remain_off_before;
	private String condition_down_to_up_remain_off_after;
	private String voltage_drop_before; 
	private String voltage_drop_after; 
	private String max_dist_between_magnet_and_switch_before; 
	private String max_dist_between_magnet_and_switch_after; 
	private String consumption_current_before; 
	private String consumption_current_after; 
	private String insulation_resistance_before; 
	private String insulation_resistance_after; 
	private String cycle_before;
	private String cycle_after; 
	private String judgement_before;
	private String judgement_after;
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
	public int getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(int device_id) {
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
	public long getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(long report_date) {
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
	 * @return the condition_up_to_down_off_min_specification
	 */
	public String getCondition_up_to_down_off_min_specification() {
		return condition_up_to_down_off_min_specification;
	}
	/**
	 * @param condition_up_to_down_off_min_specification the condition_up_to_down_off_min_specification to set
	 */
	public void setCondition_up_to_down_off_min_specification(String condition_up_to_down_off_min_specification) {
		this.condition_up_to_down_off_min_specification = condition_up_to_down_off_min_specification;
	}
	/**
	 * @return the condition_up_to_down_off_max_specification
	 */
	public String getCondition_up_to_down_off_max_specification() {
		return condition_up_to_down_off_max_specification;
	}
	/**
	 * @param condition_up_to_down_off_max_specification the condition_up_to_down_off_max_specification to set
	 */
	public void setCondition_up_to_down_off_max_specification(String condition_up_to_down_off_max_specification) {
		this.condition_up_to_down_off_max_specification = condition_up_to_down_off_max_specification;
	}
	/**
	 * @return the condition_up_to_down_off_on_min_specification
	 */
	public String getCondition_up_to_down_off_on_min_specification() {
		return condition_up_to_down_off_on_min_specification;
	}
	/**
	 * @param condition_up_to_down_off_on_min_specification the condition_up_to_down_off_on_min_specification to set
	 */
	public void setCondition_up_to_down_off_on_min_specification(String condition_up_to_down_off_on_min_specification) {
		this.condition_up_to_down_off_on_min_specification = condition_up_to_down_off_on_min_specification;
	}
	/**
	 * @return the condition_up_to_down_off_on_max_specification
	 */
	public String getCondition_up_to_down_off_on_max_specification() {
		return condition_up_to_down_off_on_max_specification;
	}
	/**
	 * @param condition_up_to_down_off_on_max_specification the condition_up_to_down_off_on_max_specification to set
	 */
	public void setCondition_up_to_down_off_on_max_specification(String condition_up_to_down_off_on_max_specification) {
		this.condition_up_to_down_off_on_max_specification = condition_up_to_down_off_on_max_specification;
	}
	/**
	 * @return the condition_up_to_down_on_min_specification
	 */
	public String getCondition_up_to_down_on_min_specification() {
		return condition_up_to_down_on_min_specification;
	}
	/**
	 * @param condition_up_to_down_on_min_specification the condition_up_to_down_on_min_specification to set
	 */
	public void setCondition_up_to_down_on_min_specification(String condition_up_to_down_on_min_specification) {
		this.condition_up_to_down_on_min_specification = condition_up_to_down_on_min_specification;
	}
	/**
	 * @return the condition_up_to_down_on_max_specification
	 */
	public String getCondition_up_to_down_on_max_specification() {
		return condition_up_to_down_on_max_specification;
	}
	/**
	 * @param condition_up_to_down_on_max_specification the condition_up_to_down_on_max_specification to set
	 */
	public void setCondition_up_to_down_on_max_specification(String condition_up_to_down_on_max_specification) {
		this.condition_up_to_down_on_max_specification = condition_up_to_down_on_max_specification;
	}
	/**
	 * @return the condition_down_to_up_off_min_specification
	 */
	public String getCondition_down_to_up_off_min_specification() {
		return condition_down_to_up_off_min_specification;
	}
	/**
	 * @param condition_down_to_up_off_min_specification the condition_down_to_up_off_min_specification to set
	 */
	public void setCondition_down_to_up_off_min_specification(String condition_down_to_up_off_min_specification) {
		this.condition_down_to_up_off_min_specification = condition_down_to_up_off_min_specification;
	}
	/**
	 * @return the condition_down_to_up_off_max_specification
	 */
	public String getCondition_down_to_up_off_max_specification() {
		return condition_down_to_up_off_max_specification;
	}
	/**
	 * @param condition_down_to_up_off_max_specification the condition_down_to_up_off_max_specification to set
	 */
	public void setCondition_down_to_up_off_max_specification(String condition_down_to_up_off_max_specification) {
		this.condition_down_to_up_off_max_specification = condition_down_to_up_off_max_specification;
	}
	/**
	 * @return the condition_down_to_up_remain_off_min_specification
	 */
	public String getCondition_down_to_up_remain_off_min_specification() {
		return condition_down_to_up_remain_off_min_specification;
	}
	/**
	 * @param condition_down_to_up_remain_off_min_specification the condition_down_to_up_remain_off_min_specification to set
	 */
	public void setCondition_down_to_up_remain_off_min_specification(
			String condition_down_to_up_remain_off_min_specification) {
		this.condition_down_to_up_remain_off_min_specification = condition_down_to_up_remain_off_min_specification;
	}
	/**
	 * @return the condition_down_to_up_remain_off_max_specification
	 */
	public String getCondition_down_to_up_remain_off_max_specification() {
		return condition_down_to_up_remain_off_max_specification;
	}
	/**
	 * @param condition_down_to_up_remain_off_max_specification the condition_down_to_up_remain_off_max_specification to set
	 */
	public void setCondition_down_to_up_remain_off_max_specification(
			String condition_down_to_up_remain_off_max_specification) {
		this.condition_down_to_up_remain_off_max_specification = condition_down_to_up_remain_off_max_specification;
	}
	/**
	 * @return the voltage_drop_min_specification
	 */
	public String getVoltage_drop_min_specification() {
		return voltage_drop_min_specification;
	}
	/**
	 * @param voltage_drop_min_specification the voltage_drop_min_specification to set
	 */
	public void setVoltage_drop_min_specification(String voltage_drop_min_specification) {
		this.voltage_drop_min_specification = voltage_drop_min_specification;
	}
	/**
	 * @return the voltage_drop_max_specification
	 */
	public String getVoltage_drop_max_specification() {
		return voltage_drop_max_specification;
	}
	/**
	 * @param voltage_drop_max_specification the voltage_drop_max_specification to set
	 */
	public void setVoltage_drop_max_specification(String voltage_drop_max_specification) {
		this.voltage_drop_max_specification = voltage_drop_max_specification;
	}
	/**
	 * @return the max_dist_between_magnet_and_switch_min_specification
	 */
	public String getMax_dist_between_magnet_and_switch_min_specification() {
		return max_dist_between_magnet_and_switch_min_specification;
	}
	/**
	 * @param max_dist_between_magnet_and_switch_min_specification the max_dist_between_magnet_and_switch_min_specification to set
	 */
	public void setMax_dist_between_magnet_and_switch_min_specification(
			String max_dist_between_magnet_and_switch_min_specification) {
		this.max_dist_between_magnet_and_switch_min_specification = max_dist_between_magnet_and_switch_min_specification;
	}
	/**
	 * @return the max_dist_between_magnet_and_switch_max_specification
	 */
	public String getMax_dist_between_magnet_and_switch_max_specification() {
		return max_dist_between_magnet_and_switch_max_specification;
	}
	/**
	 * @param max_dist_between_magnet_and_switch_max_specification the max_dist_between_magnet_and_switch_max_specification to set
	 */
	public void setMax_dist_between_magnet_and_switch_max_specification(
			String max_dist_between_magnet_and_switch_max_specification) {
		this.max_dist_between_magnet_and_switch_max_specification = max_dist_between_magnet_and_switch_max_specification;
	}
	/**
	 * @return the consumption_current_min_specification
	 */
	public String getConsumption_current_min_specification() {
		return consumption_current_min_specification;
	}
	/**
	 * @param consumption_current_min_specification the consumption_current_min_specification to set
	 */
	public void setConsumption_current_min_specification(String consumption_current_min_specification) {
		this.consumption_current_min_specification = consumption_current_min_specification;
	}
	/**
	 * @return the consumption_current_max_specification
	 */
	public String getConsumption_current_max_specification() {
		return consumption_current_max_specification;
	}
	/**
	 * @param consumption_current_max_specification the consumption_current_max_specification to set
	 */
	public void setConsumption_current_max_specification(String consumption_current_max_specification) {
		this.consumption_current_max_specification = consumption_current_max_specification;
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
	 * @return the condition_up_to_down_off_before
	 */
	public String getCondition_up_to_down_off_before() {
		return condition_up_to_down_off_before;
	}
	/**
	 * @param condition_up_to_down_off_before the condition_up_to_down_off_before to set
	 */
	public void setCondition_up_to_down_off_before(String condition_up_to_down_off_before) {
		this.condition_up_to_down_off_before = condition_up_to_down_off_before;
	}
	/**
	 * @return the condition_up_to_down_off_after
	 */
	public String getCondition_up_to_down_off_after() {
		return condition_up_to_down_off_after;
	}
	/**
	 * @param condition_up_to_down_off_after the condition_up_to_down_off_after to set
	 */
	public void setCondition_up_to_down_off_after(String condition_up_to_down_off_after) {
		this.condition_up_to_down_off_after = condition_up_to_down_off_after;
	}
	/**
	 * @return the condition_up_to_down_off_on_before
	 */
	public String getCondition_up_to_down_off_on_before() {
		return condition_up_to_down_off_on_before;
	}
	/**
	 * @param condition_up_to_down_off_on_before the condition_up_to_down_off_on_before to set
	 */
	public void setCondition_up_to_down_off_on_before(String condition_up_to_down_off_on_before) {
		this.condition_up_to_down_off_on_before = condition_up_to_down_off_on_before;
	}
	/**
	 * @return the condition_up_to_down_off_on_after
	 */
	public String getCondition_up_to_down_off_on_after() {
		return condition_up_to_down_off_on_after;
	}
	/**
	 * @param condition_up_to_down_off_on_after the condition_up_to_down_off_on_after to set
	 */
	public void setCondition_up_to_down_off_on_after(String condition_up_to_down_off_on_after) {
		this.condition_up_to_down_off_on_after = condition_up_to_down_off_on_after;
	}
	/**
	 * @return the condition_up_to_down_on_before
	 */
	public String getCondition_up_to_down_on_before() {
		return condition_up_to_down_on_before;
	}
	/**
	 * @param condition_up_to_down_on_before the condition_up_to_down_on_before to set
	 */
	public void setCondition_up_to_down_on_before(String condition_up_to_down_on_before) {
		this.condition_up_to_down_on_before = condition_up_to_down_on_before;
	}
	/**
	 * @return the condition_up_to_down_on_after
	 */
	public String getCondition_up_to_down_on_after() {
		return condition_up_to_down_on_after;
	}
	/**
	 * @param condition_up_to_down_on_after the condition_up_to_down_on_after to set
	 */
	public void setCondition_up_to_down_on_after(String condition_up_to_down_on_after) {
		this.condition_up_to_down_on_after = condition_up_to_down_on_after;
	}
	/**
	 * @return the condition_down_to_up_off_before
	 */
	public String getCondition_down_to_up_off_before() {
		return condition_down_to_up_off_before;
	}
	/**
	 * @param condition_down_to_up_off_before the condition_down_to_up_off_before to set
	 */
	public void setCondition_down_to_up_off_before(String condition_down_to_up_off_before) {
		this.condition_down_to_up_off_before = condition_down_to_up_off_before;
	}
	/**
	 * @return the condition_down_to_up_off_after
	 */
	public String getCondition_down_to_up_off_after() {
		return condition_down_to_up_off_after;
	}
	/**
	 * @param condition_down_to_up_off_after the condition_down_to_up_off_after to set
	 */
	public void setCondition_down_to_up_off_after(String condition_down_to_up_off_after) {
		this.condition_down_to_up_off_after = condition_down_to_up_off_after;
	}
	/**
	 * @return the condition_down_to_up_remain_off_before
	 */
	public String getCondition_down_to_up_remain_off_before() {
		return condition_down_to_up_remain_off_before;
	}
	/**
	 * @param condition_down_to_up_remain_off_before the condition_down_to_up_remain_off_before to set
	 */
	public void setCondition_down_to_up_remain_off_before(String condition_down_to_up_remain_off_before) {
		this.condition_down_to_up_remain_off_before = condition_down_to_up_remain_off_before;
	}
	/**
	 * @return the condition_down_to_up_remain_off_after
	 */
	public String getCondition_down_to_up_remain_off_after() {
		return condition_down_to_up_remain_off_after;
	}
	/**
	 * @param condition_down_to_up_remain_off_after the condition_down_to_up_remain_off_after to set
	 */
	public void setCondition_down_to_up_remain_off_after(String condition_down_to_up_remain_off_after) {
		this.condition_down_to_up_remain_off_after = condition_down_to_up_remain_off_after;
	}
	/**
	 * @return the voltage_drop_before
	 */
	public String getVoltage_drop_before() {
		return voltage_drop_before;
	}
	/**
	 * @param voltage_drop_before the voltage_drop_before to set
	 */
	public void setVoltage_drop_before(String voltage_drop_before) {
		this.voltage_drop_before = voltage_drop_before;
	}
	/**
	 * @return the voltage_drop_after
	 */
	public String getVoltage_drop_after() {
		return voltage_drop_after;
	}
	/**
	 * @param voltage_drop_after the voltage_drop_after to set
	 */
	public void setVoltage_drop_after(String voltage_drop_after) {
		this.voltage_drop_after = voltage_drop_after;
	}
	/**
	 * @return the max_dist_between_magnet_and_switch_before
	 */
	public String getMax_dist_between_magnet_and_switch_before() {
		return max_dist_between_magnet_and_switch_before;
	}
	/**
	 * @param max_dist_between_magnet_and_switch_before the max_dist_between_magnet_and_switch_before to set
	 */
	public void setMax_dist_between_magnet_and_switch_before(String max_dist_between_magnet_and_switch_before) {
		this.max_dist_between_magnet_and_switch_before = max_dist_between_magnet_and_switch_before;
	}
	/**
	 * @return the max_dist_between_magnet_and_switch_after
	 */
	public String getMax_dist_between_magnet_and_switch_after() {
		return max_dist_between_magnet_and_switch_after;
	}
	/**
	 * @param max_dist_between_magnet_and_switch_after the max_dist_between_magnet_and_switch_after to set
	 */
	public void setMax_dist_between_magnet_and_switch_after(String max_dist_between_magnet_and_switch_after) {
		this.max_dist_between_magnet_and_switch_after = max_dist_between_magnet_and_switch_after;
	}
	/**
	 * @return the consumption_current_before
	 */
	public String getConsumption_current_before() {
		return consumption_current_before;
	}
	/**
	 * @param consumption_current_before the consumption_current_before to set
	 */
	public void setConsumption_current_before(String consumption_current_before) {
		this.consumption_current_before = consumption_current_before;
	}
	/**
	 * @return the consumption_current_after
	 */
	public String getConsumption_current_after() {
		return consumption_current_after;
	}
	/**
	 * @param consumption_current_after the consumption_current_after to set
	 */
	public void setConsumption_current_after(String consumption_current_after) {
		this.consumption_current_after = consumption_current_after;
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
	public String getJudgement_before() {
		return judgement_before;
	}
	/**
	 * @param judgement_before the judgement_before to set
	 */
	public void setJudgement_before(String judgement_before) {
		this.judgement_before = judgement_before;
	}
	/**
	 * @return the judgement_after
	 */
	public String getJudgement_after() {
		return judgement_after;
	}
	/**
	 * @param judgement_after the judgement_after to set
	 */
	public void setJudgement_after(String judgement_after) {
		this.judgement_after = judgement_after;
	} 

}
