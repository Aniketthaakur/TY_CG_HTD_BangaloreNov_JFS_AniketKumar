package com.cap.forestrymanagementsystem.dto;

public class UserHaulier {
private int	HaulierId;
private String  haulierName;
private long haulierPhoneNo;
private String haulierTown;
public int getHaulierId() {
	return HaulierId;
}
public void setHaulierId(int haulierId) {
	HaulierId = haulierId;
}
public String getHaulierName() {
	return haulierName;
}
public void setHaulierName(String haulierName) {
	this.haulierName = haulierName;
}
public long getHaulierPhoneNo() {
	return haulierPhoneNo;
}
public void setHaulierPhoneNo(long haulierPhoneNo) {
	this.haulierPhoneNo = haulierPhoneNo;
}
public String getHaulierTown() {
	return haulierTown;
}
public void setHaulierTown(String haulierTown) {
	this.haulierTown = haulierTown;
}
@Override
public String toString() {
	return "Transportation Details ====> HaulierId=" + HaulierId + ", haulierName=" + haulierName + ", haulierPhoneNo=" + haulierPhoneNo
			+ ", haulierTown=" + haulierTown + "]";
}
}
