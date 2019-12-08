package com.caps.dao;

import java.util.HashSet;
import java.util.Set;

import com.caps.userbean.dto.UserCustomer;

public class CustomerDAOImpl implements CustomerDAO{
		Set<UserCustomer> s;
	@Override
	public boolean addCustomer(UserCustomer bean) {
		s=new HashSet<UserCustomer>();
		s.add(bean);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId,UserCustomer bean) {
		
		if(bean.getCustomerId()!=customerId)
		{
			return true;
		}
		
		
		return false;
	}

	@Override
	public Set<UserCustomer> getAllCustomer() {
		return s;
	}

	@Override
	public boolean modifyCustomer(int customerId,UserCustomer bean) {
		
		if(bean.getCustomerId()!=customerId)
		{
			return true;
		}
		
		return false;
	}

}
