package com.capgemini.forestrymanagementsystemspring.dto;

import java.util.Set;


public class LandResponse {

	private int statusCode;
	private String message;
	private String description;
	private Set<UserLand> beans;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<UserLand> getBeans() {
		return beans;
	}
	public void setBeans(Set<UserLand> beans) {
		this.beans = beans;
	}
	

}
