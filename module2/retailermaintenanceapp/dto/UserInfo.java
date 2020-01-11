package com.capgimini.retailermaintenanceapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="user_info")
public class UserInfo {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column(unique=true,nullable=false)
	private String email;
	@Column
	private String password;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="bean")
	private List<ProductInfo> productbean;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="bean")
	private List<OrderInfo> orderbean;
	
}
