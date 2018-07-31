package com.springiot.swagger.response;
import java.util.List;
public class XfusionUsersGetByRoleSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionUsersGetByRole> object;
public List<XfusionUsersGetByRole> getObject() {return object;}
public void setObject(List<XfusionUsersGetByRole> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionUsersGetByRole{
private String email;
public String getEmail() {return email;}
public void setEmail(String email) {this.email = email;}
public Object getIs_approved() {return is_approved;}
public void setIs_approved(Object is_approved) {this.is_approved = is_approved;}
private Object is_approved;
public Object getLast_activity_date() {return last_activity_date;}
public void setLast_activity_date(Object last_activity_date) {this.last_activity_date = last_activity_date;}
private Object last_activity_date;
public Object getLast_login_date() {return last_login_date;}
public void setLast_login_date(Object last_login_date) {this.last_login_date = last_login_date;}
private Object last_login_date;
public Object getCreation_date() {return creation_date;}
public void setCreation_date(Object creation_date) {this.creation_date = creation_date;}
private Object creation_date;
public Object getIs_locked_out() {return is_locked_out;}
public void setIs_locked_out(Object is_locked_out) {this.is_locked_out = is_locked_out;}
private Object is_locked_out;
private String user_key;
public String getUser_key() {return user_key;}
public void setUser_key(String user_key) {this.user_key = user_key;}
private Integer role_id;
public Integer getRole_id() {return role_id;}
public void setRole_id(Integer role_id) {this.role_id = role_id;}
private String role_name;
public String getRole_name() {return role_name;}
public void setRole_name(String role_name) {this.role_name = role_name;}
}
