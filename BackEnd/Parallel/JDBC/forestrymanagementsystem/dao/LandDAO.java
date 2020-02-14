package com.cap.forestrymanagementsystem.dao;

import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserLand;

public interface LandDAO {
	
   public boolean addLandRecord(UserLand land);
   public boolean paymentStatus(String parcelPaymentSlip,int parcelID);
   public boolean updatePaymentDescription(String paymentDescription,int parcelID);
   public Set<UserLand> getAllLandDetails();
}
