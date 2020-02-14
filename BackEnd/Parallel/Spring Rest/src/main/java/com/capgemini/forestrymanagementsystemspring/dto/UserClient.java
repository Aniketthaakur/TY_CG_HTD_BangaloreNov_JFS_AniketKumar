package com.capgemini.forestrymanagementsystemspring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class UserClient {
@Id	
@Column	
private int customerId;
@Column(name="phoneNo")
private long phoneNumber;
@Column(name="customerName")
private String customerName;
@Column(name="StreetAddress1")
private String streetAddess1;
@Column(name="StreetAddress2")
private String streetAddess2;
@Column
private String town;
@Column
private int postalCode;
@Column(name="emailId")
private String email;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getStreetAddess1() {
	return streetAddess1;
}
public void setStreetAddess1(String streetAddess1) {
	this.streetAddess1 = streetAddess1;
}
public String getStreetAddess2() {
	return streetAddess2;
}
public void setStreetAddess2(String streetAddess2) {
	this.streetAddess2 = streetAddess2;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public int getPostalCode() {
	return postalCode;
}
public void setPostalCode(int postalCode) {
	this.postalCode = postalCode;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Client --customerId=" + customerId + ", phoneNumber=" + phoneNumber + ", customerName=" + customerName
			+ ", streetAddess1=" + streetAddess1 + ", streetAddess2=" + streetAddess2 + ", town=" + town
			+ ", postalCode=" + postalCode + ", email=" + email + ".";
}



}
