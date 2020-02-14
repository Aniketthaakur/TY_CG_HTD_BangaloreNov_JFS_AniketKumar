package com.capgimini.forestrymanagementsystem.dto;

public class UserProduct {
private int productId;
private String productName;
private double productMRP;
private String productDetail;
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
public double getProductMRP() {
	return productMRP;
}
public void setProductMRP(double productMRP) {
	this.productMRP = productMRP;
}
public String getProductDetail() {
	return productDetail;
}
public void setProductDetail(String productDetail) {
	this.productDetail = productDetail;
}
@Override
public String toString() {
	return "ProductInformation---> productId=" + productId + ", productName=" + productName + ", productMRP=" + productMRP
			+ ", productDetail=" + productDetail + ".";
}


}
