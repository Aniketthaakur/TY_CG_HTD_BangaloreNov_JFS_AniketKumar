package com.capgimini.forestrymanagementsystem.service;

import java.util.Map;
import java.util.Set;

import com.capgimini.forestrymanagementsystem.dao.ContractorDAO;
import com.capgimini.forestrymanagementsystem.dao.ContractorDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserContractor;

public class ContractorServiceImpl implements ContractorService {

	ContractorDAO dao=new ContractorDAOImpl();
	@Override
	public boolean addContractor(UserContractor bean) {
		return dao.addContractor(bean);
	}

	@Override
	public boolean deleteContactor(int contractorId, Map<Integer,Set<UserContractor>> map) {
		return dao.deleteContactor(contractorId, map);
	}

	@Override
	public Set<UserContractor> getAllContractor() {
		return dao.getAllContractor();
	}

}
