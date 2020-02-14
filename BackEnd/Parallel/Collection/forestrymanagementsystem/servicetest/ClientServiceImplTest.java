package com.capgimini.forestrymanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgimini.forestrymanagementsystem.dao.ClientDAO;
import com.capgimini.forestrymanagementsystem.dao.ClientDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserClient;

class ClientServiceImplTest {

	private UserClient clientBean=null;
	private ClientDAO dao=new ClientDAOImpl();
	Map<Integer, Set<UserClient>> mapClient = new HashMap<Integer, Set<UserClient>>();
	

	@BeforeEach
	void addCustomer() {
		clientBean=new UserClient();
		clientBean.setCustomerId(101);
		clientBean.setCustomerName("Aniket");
		clientBean.setEmail("Aniket@gmail.com");
		clientBean.setPhNo(9988998);
		clientBean.setPinCode(888899);
		clientBean.setStreetAddress1("Bada");
		clientBean.setStreetAddress2("Chowk");
		clientBean.setTown("Giridih");
		boolean check=dao.addCustomer(clientBean);
		assertEquals(check,true);
	}
	@Test
	void testAddCustomer() {
		clientBean=new UserClient();
		clientBean.setCustomerId(101);
		clientBean.setCustomerName("Aniket");
		clientBean.setEmail("Aniket@gmail.com");
		clientBean.setPhNo(9988998);
		clientBean.setPinCode(888899);
		clientBean.setStreetAddress1("Bada");
		clientBean.setStreetAddress2("Chowk");
		clientBean.setTown("Giridih");
		boolean check=dao.addCustomer(clientBean);
		assertEquals(check,true);
	}

	@Test
	void testDeleteCustomer() {
		
		clientBean=new UserClient();
		clientBean.setCustomerId(101);
		 Set<UserClient> set=new HashSet<UserClient>();
		 set=dao.getAllCustomer();
		 mapClient.put(clientBean.getCustomerId(), set);
		 boolean check=dao.deleteCustomer(101, mapClient);
		assertEquals(check,true);
	}

	@Test
	void testGetAllCustomer() {
		Set<UserClient> setClient=new HashSet<UserClient>();
		setClient=dao.getAllCustomer();
		assertNotNull(setClient);
	}

	@Test
	void testModifyCustomer() {
		clientBean=new UserClient();
		clientBean.setCustomerId(101);
		Set<UserClient> set=new HashSet<UserClient>();
		 set=dao.getAllCustomer();
		 mapClient.remove(clientBean.getCustomerId());
		 clientBean.setCustomerId(101);
			clientBean.setCustomerName("Ani");
			clientBean.setEmail("Aniket@gmail.com");
			clientBean.setPhNo(9988998);
			clientBean.setPinCode(888899);
			clientBean.setStreetAddress1("Bada");
			clientBean.setStreetAddress2("Chowk");
			clientBean.setTown("Giridih");
			boolean check=dao.addCustomer(clientBean);
			assertEquals(check,true);
		 
	}

	@Test
	void testClientLogin() {
		clientBean=new UserClient();
		clientBean.setName("Rahul");
		clientBean.setPassword("qwerty");
		boolean check=dao.clientLogin(clientBean.getName(),clientBean.getPassword());
		assertEquals(check, true);
	}

}
