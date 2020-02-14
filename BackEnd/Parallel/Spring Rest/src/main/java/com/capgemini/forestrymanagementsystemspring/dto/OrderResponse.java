package com.capgemini.forestrymanagementsystemspring.dto;

import java.util.Set;

import lombok.Data;

@Data
public class OrderResponse {

	private int statusCode;
	private String message;
	private String description;
	private Set<UserOrder> beans;
	

}
