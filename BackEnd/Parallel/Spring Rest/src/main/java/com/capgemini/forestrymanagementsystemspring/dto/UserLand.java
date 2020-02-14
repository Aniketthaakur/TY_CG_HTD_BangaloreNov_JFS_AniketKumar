package com.capgemini.forestrymanagementsystemspring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Land")
public class UserLand {
	@Id
	@Column
	private int parcelID;
	@Column
	private String parcelArea;
	@Column
	private String parcelPaymentSlip;
	@Column
	private String paymentDescription;
	public int getParcelID() {
		return parcelID;
	}
	public void setParcelID(int parcelID) {
		this.parcelID = parcelID;
	}
	public String getParcelArea() {
		return parcelArea;
	}
	public void setParcelArea(String parcelArea) {
		this.parcelArea = parcelArea;
	}
	public String getParcelPaymentSlip() {
		return parcelPaymentSlip;
	}
	public void setParcelPaymentSlip(String parcelPaymentSlip) {
		this.parcelPaymentSlip = parcelPaymentSlip;
	}
	public String getPaymentDescription() {
		return paymentDescription;
	}
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}
	@Override
	public String toString() {
		return "Land Details ====> parcelID=" + parcelID + ", parcelArea=" + parcelArea + ", parcelPaymentSlip="
				+ parcelPaymentSlip + ", paymentDescription=" + paymentDescription + "]";
	}
	
	
}
