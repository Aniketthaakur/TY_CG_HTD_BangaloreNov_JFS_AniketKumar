package com.caps.dao;

import java.util.Set;

import com.caps.userbean.dto.UserCustomer;

public interface CustomerDAO {
	
	public boolean addCustomer(UserCustomer bean);
	public boolean deleteCustomer(int customerId,UserCustomer bean);
	public Set<UserCustomer> getAllCustomer(); 
	public boolean modifyCustomer(int customerId,UserCustomer bean);

}
