package com.cap.forestrymanagementsystem.dto;

public class UserOrder {
private int orderNO;
private int customerId;
private int haulierId;
private int productId;
private int quantity;
private String deliveryDate;
public int getOrderNO() {
	return orderNO;
}
public void setOrderNO(int orderNO) {
	this.orderNO = orderNO;
}
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
@Override
public String toString() {
	return "orderNO=" + orderNO + ", customerId=" + customerId + ", haulierId=" + haulierId + ", productId="
			+ productId + ", quantity=" + quantity + ", deliveryDate=" + deliveryDate + ".";
}


}
