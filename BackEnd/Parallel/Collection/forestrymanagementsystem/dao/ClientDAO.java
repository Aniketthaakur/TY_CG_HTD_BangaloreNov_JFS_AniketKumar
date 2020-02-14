package com.capgimini.forestrymanagementsystem.dao;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dto.UserClient;

public interface ClientDAO {
	
	public boolean addCustomer(UserClient bean);
	public boolean deleteCustomer(int customerId,Map<Integer, Set<UserClient>> map);
	public Set<UserClient> getAllCustomer(); 
	public boolean modifyCustomer(int customerId,UserClient bean);
	public boolean clientLogin(String name,String password);
}
