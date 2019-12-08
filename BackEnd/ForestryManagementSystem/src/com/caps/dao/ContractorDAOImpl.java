package com.caps.dao;

import java.util.HashSet;
import java.util.Set;

import com.caps.userbean.dto.UserContractor;

public class ContractorDAOImpl implements ContractorDAO {

	Set<UserContractor> h;
	@Override

	public boolean addContractor(UserContractor bean) {
		h=new HashSet<UserContractor>();    
		h.add(bean);
		return true;
	}

	@Override
	public boolean deleteContactor(int contractorId,UserContractor bean) {

		System.out.println(contractorId);

		if(bean.getContractorId()!=contractorId)
		{

			return true;
		}

		return false;
	}

	@Override
	public Set<UserContractor> getUser() {
		return h;
	}



}
