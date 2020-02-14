package com.cap.forestrymanagementsystem.dto;

public class UserProduct {
	private int productId;
	private String productName;
	private String productDescription;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	@Override
	public String toString() {
		return "Product Details --->productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ".";
	}

}
