package com.cap.forestrymanagementsystem.service;

import java.util.Set;

import com.cap.forestrymanagementsystem.dao.LandDAO;
import com.cap.forestrymanagementsystem.dao.LandDAOImpl;
import com.cap.forestrymanagementsystem.dto.UserLand;

public class LandServiceImpl implements LandService{
	LandDAO dao=new LandDAOImpl();
	@Override
	public boolean addLandRecord(UserLand land) {
		return dao.addLandRecord(land);
	}

	@Override
	public boolean paymentStatus(String parcelPaymentSlip, int parcelID) {
		return dao.paymentStatus(parcelPaymentSlip, parcelID);
	}

	@Override
	public boolean updatePaymentDescription(String paymentDescription, int parcelID) {
		return dao.updatePaymentDescription(paymentDescription, parcelID);
	}

	@Override
	public Set<UserLand> getAllLandDetails() {
		return dao.getAllLandDetails();
	}

}
