package com.cap.forestrymanagementsystemhibernat.service;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dto.UserLand;



public interface LandService {
	  public boolean addLandRecord(UserLand land);
	   public boolean paymentStatus(String parcelPaymentSlip,int parcelID);
	   public boolean updatePaymentDescription(String paymentDescription,int parcelID);
	   public Set<UserLand> getAllLandDetails();
}
