package com.capgimini.forestrymanagementsystem.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.capgimini.forestrymanagementsystem.dto.UserClient;

import java.util.Set;

public class ClientDAOImpl implements ClientDAO{
		Set<UserClient> setClient;
	@Override
	public boolean addCustomer(UserClient bean) {
		setClient=new HashSet<UserClient>();
		setClient.add(bean);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId,Map<Integer, Set<UserClient>> map) {
		Set<Entry<Integer, Set<UserClient>>> entries=map.entrySet();
		for (Entry<Integer, Set<UserClient>> entry : entries) {
			if(entry.getKey()==customerId) {
				return true;
			}
			
		}
		return false;
	}

	@Override
	public Set<UserClient> getAllCustomer() {
		return setClient;
	}

	@Override
	public boolean modifyCustomer(int customerId,UserClient bean) {
		
		if(bean.getCustomerId()!=customerId)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean clientLogin(String name, String password) {

		String user="Rahul";
		String pass="qwerty";
		try {
		if(name.equals(user)) {
			if(password.equals(pass)) {
				
			return true;
		}
		}
		}catch(Exception e) {
		
			System.out.println("Credentials invalid.");
			return false;
		}
		
		return false;
	
	}

}
