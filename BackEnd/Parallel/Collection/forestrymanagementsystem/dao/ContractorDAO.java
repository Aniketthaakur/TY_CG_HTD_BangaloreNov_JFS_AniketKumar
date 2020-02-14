package com.capgimini.forestrymanagementsystem.dao;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dto.UserContractor;

public interface ContractorDAO {
	public boolean addContractor(UserContractor bean);
	public boolean   deleteContactor(int contractorId, Map<Integer,Set<UserContractor>> map);
	public  Set<UserContractor> getAllContractor();
	}
