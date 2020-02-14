package com.cap.forestrymanagementsystem.dto;

public class UserContractor {
	
	private int customerId;
	private int contractorNo;
	private int haulierId;
	private int productId;
	private int quantity;
	private String deliveryDate;
	private String deliveryDay;
	private int parcelId;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryDay() {
		return deliveryDay;
	}
	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}
	public int getParcelId() {
		return parcelId;
	}
	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}
	public int getContractorNo() {
		return contractorNo;
	}
	public void setContractorNo(int contractorNo) {
		this.contractorNo = contractorNo;
	}
	
	@Override
	public String toString() {
		return "Contractor---> customerId=" + customerId + ", contractorNo=" + contractorNo + ", haulierId=" + haulierId
				+ ", productId=" + productId + ", quantity=" + quantity + ", deliveryDate=" + deliveryDate
				+ ", deliveryDay=" + deliveryDay + ", parcelId=" + parcelId + ".";
	}
}
