package com.springiot.swagger.response;
import java.util.List;
public class XfusionUserUpdateApproveStatusSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionUserUpdateApproveStatus> object;
public List<XfusionUserUpdateApproveStatus> getObject() {return object;}
public void setObject(List<XfusionUserUpdateApproveStatus> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionUserUpdateApproveStatus{
public Object getAffected_rows() {return affected_rows;}
public void setAffected_rows(Object affected_rows) {this.affected_rows = affected_rows;}
private Object affected_rows;
}
