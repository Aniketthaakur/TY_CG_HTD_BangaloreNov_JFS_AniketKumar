package com.capgimini.forestrymanagementsystem.service;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dao.ClientDAO;
import com.capgimini.forestrymanagementsystem.dao.ClientDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserClient;

public class ClientServiceImpl implements  ClientService {
	ClientDAO dao=new ClientDAOImpl();
	@Override
	public boolean addCustomer(UserClient bean) {
		return dao.addCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int customerId,Map<Integer, Set<UserClient>> map) {
		return dao.deleteCustomer(customerId, map);
	}

	@Override
	public Set<UserClient> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public boolean modifyCustomer(int customerId, UserClient bean) {
		return dao.modifyCustomer(customerId, bean);
	}

	@Override
	public boolean clientLogin(String name, String password) {
		return dao.clientLogin(name, password);
	}

}
