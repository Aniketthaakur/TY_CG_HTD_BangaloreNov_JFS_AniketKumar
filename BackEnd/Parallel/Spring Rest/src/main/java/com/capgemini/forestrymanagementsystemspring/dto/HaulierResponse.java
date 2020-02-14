package com.capgemini.forestrymanagementsystemspring.dto;

import java.util.Set;

import lombok.Data;

@Data
public class HaulierResponse {

	private int statusCode;
	private String message;
	private String description;
	private Set<UserHaulier> beans;
	

}
