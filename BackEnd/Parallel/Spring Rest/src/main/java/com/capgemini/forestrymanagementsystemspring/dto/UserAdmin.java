package com.capgemini.forestrymanagementsystemspring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class UserAdmin {
	@Id
	@Column(name="username")
	private String name;
	@Column
	private String password;
	@Column(name="user_type")
	private String usertype;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "UserAdmin [name=" + name + ", password=" + password + ", usertype=" + usertype + "]";
	}
	
	
}
