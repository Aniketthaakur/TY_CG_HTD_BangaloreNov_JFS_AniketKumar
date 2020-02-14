package com.capgimini.forestrymanagementsystem.dto;

public class UserContractor {
	private int contractorNo;
	private int contractorId;
	private int productId;
	private String date;
	private String day;
	private int Quantity;

	public int getContractorNo() {
		return contractorNo;
	}

	public void setContractorNo(int contractorNo) {
		this.contractorNo = contractorNo;
	}

	public int getContractorId() {
		return contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "contractorNo=" + contractorNo + ", contractorId=" + contractorId + ", productId=" + productId + ""
				+ ", date=" + date + ", day=" + day + ", Quantity=" + Quantity + "]";
	}

}
