package com.capgemini.forestrymanagementsystemspring.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspring.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspring.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystemspring.dao.SchedulerDAOImpl;
import com.capgemini.forestrymanagementsystemspring.dto.UserHaulier;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.springtest.SpringTest;


@SpringJUnitConfig(classes = { SpringTest.class, ORMConfig.class })
class SchedulerDAOImplTest {

	@Autowired
	private SchedulerDAO dao=null;
	private UserOrder orderBean=null;
	private UserHaulier haulierBean=null;
	
	
//	@Test
//	void testAddOrder() {
//		orderBean=new UserOrder();
//		orderBean.setCustomerId(104);
//		orderBean.setDeliveryDate("20/12/2019");
//		orderBean.setHaulierId(101);
//		orderBean.setOrderNO(111);
//		orderBean.setProductId(109);
//		orderBean.setQuantity(122);
//		boolean check=dao.addOrder(orderBean);
//		assertEquals(check,true);
//	}

//	@Test
//	void testAddHaulier() {
//		haulierBean=new UserHaulier();
//		haulierBean.setHaulierId(101);
//		haulierBean.setHaulierName("Shya");
//		haulierBean.setHaulierPhoneNo(99627126);
//		haulierBean.setHaulierTown("Bangalore");
//		boolean check=dao.addHaulier(haulierBean);
//		assertEquals(check,true);
//	}

	@Test
	void testGetAllHaulier() {
		Set<UserHaulier> setHaulier=new HashSet<UserHaulier>();
		setHaulier=dao.getAllHaulier();
		assertNotNull(setHaulier);
	}

	@Test
	void testUpdateHaulier() {
		haulierBean=new UserHaulier();
		haulierBean.setHaulierName("Shya");
		haulierBean.setHaulierPhoneNo(996026009);
		boolean check=dao.updateHaulier(haulierBean.getHaulierPhoneNo(), haulierBean.getHaulierName());
		assertEquals(check,true);
	}

}
