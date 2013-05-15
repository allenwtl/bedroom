package com.pojo;

import java.io.Serializable;

public class City implements Serializable {
private int serialId ;
private String cityId ;
private String cityName ;
private String cityUpId ;
private String cityType ;


public int getSerialId() {
return serialId;
}
public void setSerialId(int serialId) {
this.serialId = serialId;
}
public String getCityId() {
return cityId;
}
public void setCityId(String cityId) {
this.cityId = cityId;
}
public String getCityName() {
return cityName;
}
public void setCityName(String cityName) {
this.cityName = cityName;
}
public String getCityUpId() {
return cityUpId;
}
public void setCityUpId(String cityUpId) {
this.cityUpId = cityUpId;
}
public String getCityType() {
return cityType;
}
public void setCityType(String cityType) {
this.cityType = cityType;
}



}