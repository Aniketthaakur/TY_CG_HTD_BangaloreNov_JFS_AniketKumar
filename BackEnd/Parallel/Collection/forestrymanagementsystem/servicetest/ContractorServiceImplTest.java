package com.capgimini.forestrymanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgimini.forestrymanagementsystem.dao.ContractorDAO;
import com.capgimini.forestrymanagementsystem.dao.ContractorDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserContractor;

class ContractorServiceImplTest {

	private UserContractor userContractor=null;
	private ContractorDAO dao=new ContractorDAOImpl();
	 Map<Integer, Set<UserContractor>> mapContractor=new  HashMap<Integer, Set<UserContractor>>();
	
	@BeforeEach
	void addContractor() {
		userContractor=new UserContractor();
		userContractor.setContractorId(101);
		userContractor.setContractorNo(102);
		userContractor.setDate("12/12/2020");
		userContractor.setDay("sun");
		userContractor.setProductId(101);
		userContractor.setQuantity(10);
		boolean check=dao.addContractor(userContractor);
		assertEquals(check,true);
	}
	@Test
	void testAddContractor() {
		userContractor=new UserContractor();
		userContractor.setContractorId(101);
		userContractor.setContractorNo(102);
		userContractor.setDate("12/12/2019");
		userContractor.setDay("sun");
		userContractor.setProductId(101);
		userContractor.setQuantity(10);
		boolean check=dao.addContractor(userContractor);
		assertEquals(check,true);
	}

	@Test
	void testGetAllContractor() {
		Set<UserContractor> setContractor=new HashSet<UserContractor>();
		setContractor=dao.getAllContractor();
		assertNotNull(setContractor);
	}

	@Test
	void testDeleteContactor() {
		userContractor=new UserContractor();
		userContractor.setContractorId(101);
		Set<UserContractor> setContractor=new HashSet<UserContractor>();
		setContractor=dao.getAllContractor();
		mapContractor.put(userContractor.getContractorId(), setContractor);
		boolean check=dao.deleteContactor(101, mapContractor);
		assertEquals(check, true);
		
		 
	}

}
