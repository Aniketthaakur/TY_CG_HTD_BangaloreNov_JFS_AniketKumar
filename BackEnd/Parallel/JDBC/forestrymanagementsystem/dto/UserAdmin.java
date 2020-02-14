package com.cap.forestrymanagementsystem.dto;

public class UserAdmin {
	
	private String username;
	private String password;
	private String user_type;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "UserAdmin [username=" + username + ", password=" + password + ", user_type=" + user_type + "]";
	}

}
