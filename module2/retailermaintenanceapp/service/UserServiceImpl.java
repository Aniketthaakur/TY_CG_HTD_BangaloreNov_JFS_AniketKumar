package com.capgimini.retailermaintenanceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.retailermaintenanceapp.dao.UserDao;
import com.capgimini.retailermaintenanceapp.dto.OrderInfo;
import com.capgimini.retailermaintenanceapp.dto.ProductInfo;
import com.capgimini.retailermaintenanceapp.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public boolean createProfile(UserInfo bean) {
		return dao.createProfile(bean);
	}

	@Override
	public UserInfo login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public ProductInfo searchProduct(int id) {
		return dao.searchProduct(id);
	}

	@Override
	public boolean updatePassword(int id, String password) {
		return dao.updatePassword(id, password);
	}

	@Override
	public List<ProductInfo> totalAmountPayable(String name) {
		 return dao.totalAmountPayable(name);
	}

	@Override
	public OrderInfo retreiveOrder(int id) {
		return dao.retreiveOrder(id);
	}

}
