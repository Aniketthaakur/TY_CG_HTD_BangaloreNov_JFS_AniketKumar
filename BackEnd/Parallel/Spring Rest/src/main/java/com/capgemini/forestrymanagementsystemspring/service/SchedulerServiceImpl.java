package com.capgemini.forestrymanagementsystemspring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspring.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystemspring.dao.SchedulerDAOImpl;
import com.capgemini.forestrymanagementsystemspring.dto.UserHaulier;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;



@Service
public  class SchedulerServiceImpl implements SchedulerService {
		
	@Autowired
	SchedulerDAO dao;
	

	public boolean addOrder(UserOrder order) {
		return dao.addOrder(order);
	}

	
	
	public boolean addHaulier(UserHaulier haulier) {
		return dao.addHaulier(haulier);
	}

	public Set<UserHaulier> getAllHaulier() {
		return dao.getAllHaulier();
	}

	public boolean updateHaulier(long haulierPhoneNo, String haulierName) {
		return dao.updateHaulier(haulierPhoneNo, haulierName);
	}

}
