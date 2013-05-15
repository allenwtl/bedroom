package com.pojo;

import java.io.Serializable;

public class Province implements Serializable {
private int serialId;
private String provinceId;
private String provinceName;

public int getSerialId() {
return serialId;
}
public void setSerialId(int serialId) {
this.serialId = serialId;
}
public String getProvinceId() {
return provinceId;
}
public void setProvinceId(String provinceId) {
this.provinceId = provinceId;
}
public String getProvinceName() {
return provinceName;
}
public void setProvinceName(String provinceName) {
this.provinceName = provinceName;
}


}