package com.capgimini.forestrymanagementsystem.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.capgimini.forestrymanagementsystem.dto.UserContractor;

import java.util.Set;

public class ContractorDAOImpl implements ContractorDAO {

	Set<UserContractor> setContractor;
	@Override

	public boolean addContractor(UserContractor bean) {
		setContractor=new HashSet<UserContractor>();    
		setContractor.add(bean);
		return true;
	}

	@Override
	public Set<UserContractor> getAllContractor() {
		return setContractor;
	}

	@Override
	public boolean deleteContactor(int contractorId, Map<Integer, Set<UserContractor>> map) {

		Set<Entry<Integer,Set<UserContractor>>> entries=map.entrySet();
		for (Entry<Integer, Set<UserContractor>> entry : entries) {
			if(entry.getKey()==contractorId) {
				return true;
			}
		}

		return false;
	}

	



}
