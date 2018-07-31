package com.springiot.swagger.response;
import java.util.List;
public class XfusionExceptionLogInsertSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionExceptionLogInsert> object;
public List<XfusionExceptionLogInsert> getObject() {return object;}
public void setObject(List<XfusionExceptionLogInsert> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionExceptionLogInsert{
private String type;
public String getType() {return type;}
public void setType(String type) {this.type = type;}
}
