package com.cap.forestrymanagementsystemhibernat.service;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dao.LandDAO;
import com.cap.forestrymanagementsystemhibernat.dao.LandDAOImpl;
import com.cap.forestrymanagementsystemhibernat.dto.UserLand;



public class LandServiceImpl implements LandService{
	LandDAO dao=new LandDAOImpl();
	
	public boolean addLandRecord(UserLand land) {
		return dao.addLandRecord(land);
	}

	public boolean paymentStatus(String parcelPaymentSlip, int parcelID) {
		return dao.paymentStatus(parcelPaymentSlip, parcelID);
	}

	public boolean updatePaymentDescription(String paymentDescription, int parcelID) {
		return dao.updatePaymentDescription(paymentDescription, parcelID);
	}

	public Set<UserLand> getAllLandDetails() {
		return dao.getAllLandDetails();
	}

}
