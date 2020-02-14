package com.capgimini.forestrymanagementsystemhibernat.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cap.forestrymanagementsystemhibernat.dao.LandDAO;
import com.cap.forestrymanagementsystemhibernat.dao.LandDAOImpl;
import com.cap.forestrymanagementsystemhibernat.dto.UserLand;

class LandServiceImplTest {

	 private UserLand landBean=null;
	 private LandDAO dao=null;
	 
	 @BeforeEach
	 void load() {
		 dao=new LandDAOImpl();
	 }
	
	@Test
	void testAddLandRecord() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(122);
		landBean.setParcelPaymentSlip("Done");
		landBean.setPaymentDescription("Complete");
		boolean check=dao.addLandRecord(landBean);
		assertEquals(check,true);
	}

	@Test
	void testPaymentStatus() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(122);
		landBean.setParcelPaymentSlip("Not_Done");
		boolean check=dao.paymentStatus(landBean.getParcelPaymentSlip(), landBean.getParcelID());
		assertEquals(check,true);

	}

	@Test
	void testUpdatePaymentDescription() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(122);
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
