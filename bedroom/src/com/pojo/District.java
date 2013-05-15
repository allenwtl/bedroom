package com.pojo;

import java.io.Serializable;

public class District implements Serializable {
private int serialId;
private String districtId ;
private String districtName;
private String districtUpId;
private String districtType;
private String postCode ;


public int getSerialId() {
return serialId;
}
public void setSerialId(int serialId) {
this.serialId = serialId;
}
public String getDistrictId() {
return districtId;
}
public void setDistrictId(String districtId) {
this.districtId = districtId;
}
public String getDistrictName() {
return districtName;
}
public void setDistrictName(String districtName) {
this.districtName = districtName;
}
public String getDistrictUpId() {
return districtUpId;
}
public void setDistrictUpId(String districtUpId) {
this.districtUpId = districtUpId;
}
public String getDistrictType() {
return districtType;
}
public void setDistrictType(String districtType) {
this.districtType = districtType;
}
public String getPostCode() {
return postCode;
}
public void setPostCode(String postCode) {
this.postCode = postCode;
}





}