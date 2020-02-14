package com.capgemini.forestrymanagementsystemspring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspring.dao.AdminDAO;
import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;



@Service
public class AdminServiceImpl implements AdminService {
		
	@Autowired
	AdminDAO dao;
 
	
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
