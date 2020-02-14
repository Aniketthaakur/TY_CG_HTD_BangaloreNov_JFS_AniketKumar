package com.cap.forestrymanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cap.forestrymanagementsystem.dao.LandDAO;
import com.cap.forestrymanagementsystem.dao.LandDAOImpl;
import com.cap.forestrymanagementsystem.dto.UserLand;

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
		landBean.setParcelID(12);
		landBean.setParcelPaymentSlip("Done");
		landBean.setPaymentDescription("Complete");
		boolean check=dao.addLandRecord(landBean);
		assertEquals(check,true);
	}

	@Test
	void testPaymentStatus() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(102);
		landBean.setParcelPaymentSlip("Not_Done");
		boolean check=dao.paymentStatus(landBean.getParcelPaymentSlip(), landBean.getParcelID());
		assertEquals(check,true);

	}

	@Test
	void testUpdatePaymentDescription() {
		landBean=new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(102);
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
