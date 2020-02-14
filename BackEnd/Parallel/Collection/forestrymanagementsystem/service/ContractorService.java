package com.capgimini.forestrymanagementsystem.service;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dto.UserContractor;

public interface ContractorService {
	public boolean addContractor(UserContractor bean);
	public boolean   deleteContactor(int contractorId,Map<Integer,Set<UserContractor>> map);
	public  Set<UserContractor> getAllContractor();

}
