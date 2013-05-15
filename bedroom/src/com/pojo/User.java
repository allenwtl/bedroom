package com.pojo;


public class User implements java.io.Serializable {

// Fields

private String userNumber;
private String userPassword;

public String getUserNumber() {
return this.userNumber;
}

public void setUserNumber(String userNumber) {
this.userNumber = userNumber;
}

public String getUserPassword() {
return this.userPassword;
}

public void setUserPassword(String userPassword) {
this.userPassword = userPassword;
}


}