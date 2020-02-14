package com.cap.forestrymanagementsystem.dto;

public class UserLand {

	private int parcelID;
	private String parcelArea;
	private String parcelPaymentSlip;
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
