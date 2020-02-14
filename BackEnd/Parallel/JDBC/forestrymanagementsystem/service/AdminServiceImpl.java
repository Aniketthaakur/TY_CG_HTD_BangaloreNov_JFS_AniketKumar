package com.cap.forestrymanagementsystem.service;

import java.util.Set;

import com.cap.forestrymanagementsystem.dao.AdminDAO;
import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserProduct;
import com.cap.forestrymanagementsystem.factory.Factory;

public class AdminServiceImpl implements AdminService {
		AdminDAO dao=Factory.getAdmin();
 
	@Override
	public String login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public boolean addClient(UserClient bean) {
		return dao.addClient(bean);
	}

	@Override
	public Set<UserProduct> getAllProduct() {
		return dao.getAllProduct();
	}

	@Override
	public Set<UserContractor> showContracts() {
		return dao.showContracts();
	}

	@Override
	public boolean deleteClient(int customerId) {
		return dao.deleteClient(customerId);
	}

}
