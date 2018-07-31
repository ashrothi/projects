package LambdaExpression;

public class ItemFormat {
	private String severity;
    private String device_id; 
    private String service_name;
    private String check_timestamp; 
    private String service_servicedatasource_unit;
    private String service_servicedatasource_max_value; 
    private String service_servicedatasource_min_value; 
    private String data_source;
    private String current_value; 
    private String service_servicedatasource_alias;
    private String device_name; 
    private String service_service_alias;
    private String sys_timestamp;
    private String device_alias;
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getCheck_timestamp() {
		return check_timestamp;
	}
	public void setCheck_timestamp(String check_timestamp) {
		this.check_timestamp = check_timestamp;
	}
	public String getService_servicedatasource_unit() {
		return service_servicedatasource_unit;
	}
	public void setService_servicedatasource_unit(String service_servicedatasource_unit) {
		this.service_servicedatasource_unit = service_servicedatasource_unit;
	}
	public String getService_servicedatasource_max_value() {
		return service_servicedatasource_max_value;
	}
	public void setService_servicedatasource_max_value(String service_servicedatasource_max_value) {
		this.service_servicedatasource_max_value = service_servicedatasource_max_value;
	}
	public String getService_servicedatasource_min_value() {
		return service_servicedatasource_min_value;
	}
	public void setService_servicedatasource_min_value(String service_servicedatasource_min_value) {
		this.service_servicedatasource_min_value = service_servicedatasource_min_value;
	}
	public String getData_source() {
		return data_source;
	}
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}
	public String getCurrent_value() {
		return current_value;
	}
	public void setCurrent_value(String current_value) {
		this.current_value = current_value;
	}
	public String getService_servicedatasource_alias() {
		return service_servicedatasource_alias;
	}
	public void setService_servicedatasource_alias(String service_servicedatasource_alias) {
		this.service_servicedatasource_alias = service_servicedatasource_alias;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getService_service_alias() {
		return service_service_alias;
	}
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
	}
	public String getSys_timestamp() {
		return sys_timestamp;
	}
	public void setSys_timestamp(String sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}
	public String getDevice_alias() {
		return device_alias;
	}
	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	}
	@Override
	public String toString() {
		return "ItemFormat [severity=" + severity + ", device_id=" + device_id + ", service_name=" + service_name
				+ ", check_timestamp=" + check_timestamp + ", service_servicedatasource_unit="
				+ service_servicedatasource_unit + ", service_servicedatasource_max_value="
				+ service_servicedatasource_max_value + ", service_servicedatasource_min_value="
				+ service_servicedatasource_min_value + ", data_source=" + data_source + ", current_value="
				+ current_value + ", service_servicedatasource_alias=" + service_servicedatasource_alias
				+ ", device_name=" + device_name + ", service_service_alias=" + service_service_alias
				+ ", sys_timestamp=" + sys_timestamp + ", device_alias=" + device_alias + "]";
	} 
    
    
}
