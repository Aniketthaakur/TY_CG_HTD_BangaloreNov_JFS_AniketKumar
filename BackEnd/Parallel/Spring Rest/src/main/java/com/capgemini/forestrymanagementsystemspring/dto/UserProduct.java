package com.capgemini.forestrymanagementsystemspring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class UserProduct {
	@Id
	@Column
	private int productId;
	@Column
	private String productName;
	@Column
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
