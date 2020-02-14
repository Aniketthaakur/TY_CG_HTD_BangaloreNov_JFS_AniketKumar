package com.cap.forestrymanagementsystemhibernat.service;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dao.SchedulerDAO;
import com.cap.forestrymanagementsystemhibernat.dao.SchedulerDAOImpl;
import com.cap.forestrymanagementsystemhibernat.dto.UserHaulier;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;




public  class SchedulerServiceImpl implements SchedulerService {
		SchedulerDAO dao=new SchedulerDAOImpl();
	

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
