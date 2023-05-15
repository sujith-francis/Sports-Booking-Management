package com.bmg.beans;

import java.io.Serializable;

public class Admin implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private String pNumber;
private String email;
private String password;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getpNumber() {
	return pNumber;
}
public void setpNumber(String pNumber) {
	this.pNumber = pNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [name=" + name + ", pNumber=" + pNumber + ", email=" + email + ", password=" + password +  "]";
}

}
