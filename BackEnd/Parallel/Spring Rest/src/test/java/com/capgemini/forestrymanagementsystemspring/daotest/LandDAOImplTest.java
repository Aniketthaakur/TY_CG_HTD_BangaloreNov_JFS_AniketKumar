package com.capgemini.forestrymanagementsystemspring.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspring.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspring.dao.LandDAO;
import com.capgemini.forestrymanagementsystemspring.dto.UserLand;
import com.capgemini.forestrymanagementsystemspring.springtest.SpringTest;

@SpringJUnitConfig(classes = { SpringTest.class, ORMConfig.class })
class LandDAOImplTest {

	@Autowired
	private LandDAO dao = null;
	private UserLand landBean = null;

//	@Test
//	void testAddLandRecord() {
//		landBean = new UserLand();
//		landBean.setParcelArea("Btm");
//		landBean.setParcelID(125);
//		landBean.setParcelPaymentSlip("Done");
//		landBean.setPaymentDescription("Complete");
//		boolean check = dao.addLandRecord(landBean);
//		assertEquals(check, true);
//	}

	@Test
	void testPaymentStatus() {
		landBean = new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(121);
		landBean.setParcelPaymentSlip("Not_Done");
		boolean check = dao.paymentStatus(landBean.getParcelPaymentSlip(), landBean.getParcelID());
		assertEquals(check, true);

	}

	@Test
	void testUpdatePaymentDescription() {
		landBean = new UserLand();
		landBean.setParcelArea("Btm");
		landBean.setParcelID(121);
		landBean.setPaymentDescription("Completed");
		boolean check = dao.updatePaymentDescription(landBean.getPaymentDescription(), landBean.getParcelID());
		assertEquals(check, true);
	}

	@Test
	void testGetAllLandDetails() {
		Set<UserLand> setLand = new HashSet<UserLand>();
		setLand = dao.getAllLandDetails();
		assertNotNull(setLand);
	}

}
