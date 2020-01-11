package com.capgimini.retailermaintenanceapp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="order_info")
public class OrderInfo {
	@Id
	@Column
	@GeneratedValue
	private int id;
//	@ManyToOne(optional=false)
//	@JsonIgnore 
//	@JoinColumn(name="user_id",referencedColumnName="id")
//	private UserInfo bean;
//	@ManyToOne(optional=false)
//	@JsonIgnore 
//	@JoinColumn(name="user_id",referencedColumnName="id")
//	private ProductInfo productbean;
	
}
