package com.cap.forestrymanagementsystemhibernat.service;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dao.AdminDAO;
import com.cap.forestrymanagementsystemhibernat.dto.UserAdmin;
import com.cap.forestrymanagementsystemhibernat.dto.UserClient;
import com.cap.forestrymanagementsystemhibernat.dto.UserContractor;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;
import com.cap.forestrymanagementsystemhibernat.factory.Factory;


public class AdminServiceImpl implements AdminService {
		AdminDAO dao=Factory.getAdmin();
 
	
	public String login(String username, String password) {
		return dao.login(username, password);
	}

	
	public boolean addClient(UserClient bean) {
		return dao.addClient(bean);
	}

	public Set<UserProduct> getAllProduct() {
		return dao.getAllProduct();
	}

	public Set<UserContractor> showContracts() {
		return dao.showContracts();
	}

	public boolean deleteClient(int customerId) {
		return dao.deleteClient(customerId);
	}

}
