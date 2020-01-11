package com.capgimini.retailermaintenanceapp.service;

import java.util.List;

import com.capgimini.retailermaintenanceapp.dto.OrderInfo;
import com.capgimini.retailermaintenanceapp.dto.ProductInfo;
import com.capgimini.retailermaintenanceapp.dto.UserInfo;

public interface UserService {
	
	public boolean createProfile(UserInfo bean);
	public UserInfo login(String email,String password);
	public ProductInfo searchProduct(int id);
	public boolean updatePassword(int id,String password);
	public List<ProductInfo> totalAmountPayable(String name);
	public OrderInfo retreiveOrder(int id);

}
