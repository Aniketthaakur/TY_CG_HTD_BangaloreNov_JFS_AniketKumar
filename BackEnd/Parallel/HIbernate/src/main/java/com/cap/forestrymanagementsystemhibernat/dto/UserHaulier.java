package com.cap.forestrymanagementsystemhibernat.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="haulier")
public class UserHaulier {
@Id
@Column
private String  haulierName;
@Column
private int	HaulierId;
@Column
private long haulierPhoneNo;
@Column
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
