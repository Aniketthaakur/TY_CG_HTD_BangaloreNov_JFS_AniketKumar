package com.capgimini.retailermaintenanceapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
@Table(name="product_info")
public class ProductInfo {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(unique=true,nullable=false)
	private String name;
	@Column
	private int quantity;
	@Column
	private String details;
	@ManyToOne(optional=false)
	@JsonIgnore 
	@JoinColumn(name="user_id",referencedColumnName="id")
	private UserInfo bean;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="productbean")
	private List<OrderInfo> orderbean;
	
}
