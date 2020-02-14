package com.cap.forestrymanagementsystem.service;

import java.util.Set;


import com.cap.forestrymanagementsystem.dao.SchedulerDAO;
import com.cap.forestrymanagementsystem.dao.SchedulerDAOImpl;
import com.cap.forestrymanagementsystem.dto.UserHaulier;
import com.cap.forestrymanagementsystem.dto.UserOrder;

public  class SchedulerServiceImpl implements SchedulerService {
		SchedulerDAO dao=new SchedulerDAOImpl();
	

	@Override
	public boolean addOrder(UserOrder order) {
		return dao.addOrder(order);
	}

	
	
	@Override
	public boolean addHaulier(UserHaulier haulier) {
		return dao.addHaulier(haulier);
	}

	@Override
	public Set<UserHaulier> getAllHaulier() {
		return dao.getAllHaulier();
	}

	@Override
	public boolean updateHaulier(long haulierPhoneNo, String haulierName) {
		return dao.updateHaulier(haulierPhoneNo, haulierName);
	}

}
