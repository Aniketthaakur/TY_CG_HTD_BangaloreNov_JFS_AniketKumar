package com.caps.dao;

import java.util.Set;

import com.caps.userbean.dto.UserContractor;

public interface ContractorDAO {
	public boolean addContractor(UserContractor bean);
	public boolean   deleteContactor(int contractorId,UserContractor bean);
	public  Set<UserContractor> getUser();
}
