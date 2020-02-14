package com.capgimini.forestrymanagementsystemhibernat.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cap.forestrymanagementsystemhibernat.dao.LandDAO;
import com.cap.forestrymanagementsystemhibernat.dao.LandDAOImpl;
import com.cap.forestrymanagementsystemhibernat.dto.UserLand;

class LandDAOImplTest {

	 private UserLand landBean=null;
	 private LandDAO dao=null;
	 
	 @BeforeEach
	 void load() {
		 dao=new LandDAOImpl();
	 }
	

	@Test
	void testPaymentStatus() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(121);
		landBean.setParcelPaymentSlip("Not_Done");
		boolean check=dao.paymentStatus(landBean.getParcelPaymentSlip(), landBean.getParcelID());
		assertEquals(check,true);

	}

	@Test
	void testUpdatePaymentDescription() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(121);
		landBean.setPaymentDescription("Completed");
		boolean check=dao.updatePaymentDescription(landBean.getPaymentDescription(), landBean.getParcelID());
		assertEquals(check,true);
	}

	@Test
	void testGetAllLandDetails() {
		Set<UserLand> setLand=new HashSet<UserLand>();
		setLand=dao.getAllLandDetails();
		assertNotNull(setLand);
	}


}
