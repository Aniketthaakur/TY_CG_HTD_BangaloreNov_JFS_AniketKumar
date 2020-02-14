package com.capgemini.forestrymanagementsystemspring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspring.dao.LandDAO;
import com.capgemini.forestrymanagementsystemspring.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystemspring.dto.UserLand;


@Service
public class LandServiceImpl implements LandService{
	@Autowired
	LandDAO dao;
	
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
