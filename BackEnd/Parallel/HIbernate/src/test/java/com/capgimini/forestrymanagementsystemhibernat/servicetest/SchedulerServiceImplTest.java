package com.capgimini.forestrymanagementsystemhibernat.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cap.forestrymanagementsystemhibernat.dao.SchedulerDAO;
import com.cap.forestrymanagementsystemhibernat.dao.SchedulerDAOImpl;
import com.cap.forestrymanagementsystemhibernat.dto.UserHaulier;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;

class SchedulerServiceImplTest {

	private UserOrder orderBean=null;
	private UserHaulier haulierBean=null;
	private SchedulerDAO dao=null;
	
	@BeforeEach
	void load() {
		dao=new SchedulerDAOImpl();
	}
 
	@Test
	void testAddOrder() {
		orderBean=new UserOrder();
		orderBean.setCustomerId(104);
		orderBean.setDeliveryDate("20/12/2019");
		orderBean.setHaulierId(101);
		orderBean.setOrderNO(109);
		orderBean.setProductId(109);
		orderBean.setQuantity(122);
		boolean check=dao.addOrder(orderBean);
		assertEquals(check,true);
	}

	@Test
	void testAddHaulier() {
		haulierBean=new UserHaulier();
		haulierBean.setHaulierId(101);
		haulierBean.setHaulierName("Shyam");
		haulierBean.setHaulierPhoneNo(99627126);
		haulierBean.setHaulierTown("Bangalore");
		boolean check=dao.addHaulier(haulierBean);
		assertEquals(check,true);
	}

	@Test
	void testGetAllHaulier() {
		Set<UserHaulier> setHaulier=new HashSet<UserHaulier>();
		setHaulier=dao.getAllHaulier();
		assertNotNull(setHaulier);
	}

	@Test
	void testUpdateHaulier() {
		haulierBean=new UserHaulier();
		haulierBean.setHaulierName("Shyam");
		haulierBean.setHaulierPhoneNo(996026009);
		boolean check=dao.updateHaulier(haulierBean.getHaulierPhoneNo(), haulierBean.getHaulierName());
		assertEquals(check,true);
	}

}
