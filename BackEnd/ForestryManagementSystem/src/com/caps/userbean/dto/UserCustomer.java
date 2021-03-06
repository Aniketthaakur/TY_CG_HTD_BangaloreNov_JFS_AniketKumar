package com.caps.userbean.dto;

public class UserCustomer {
   private int customerId;
   private String customerName;
   private String streetAddress1; 
   private String streetAddress2;
   private String town;
   private int pinCode;
   private String email;
   private long phNo;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getStreetAddress1() {
	return streetAddress1;
}
public void setStreetAddress1(String streetAddress1) {
	this.streetAddress1 = streetAddress1;
}
public String getStreetAddress2() {
	return streetAddress2;
}
public void setStreetAddress2(String streetAddress2) {
	this.streetAddress2 = streetAddress2;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public int getPinCode() {
	return pinCode;
}
public void setPinCode(int pinCode) {
	this.pinCode = pinCode;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhNo() {
	return phNo;
}
public void setPhNo(long phNo) {
	this.phNo = phNo;
}
@Override
public String toString() {
	return "UserCustomer [customerId=" + customerId + ", customerName=" + customerName + ", streetAddress1="
			+ streetAddress1 + ", streetAddress2=" + streetAddress2 + ", town=" + town + ", pinCode=" + pinCode
			+ ", email=" + email + ", phNo=" + phNo + "]";
}
   
   
   
   
}
