package com.capgemini.forestrymanagementsystemspring.dto;

import java.util.Set;

import lombok.Data;

@Data
public class ProductResponse {

	private int statusCode;
	private String message;
	private String description;
	private Set<UserProduct> beans;
	
	
	
}

