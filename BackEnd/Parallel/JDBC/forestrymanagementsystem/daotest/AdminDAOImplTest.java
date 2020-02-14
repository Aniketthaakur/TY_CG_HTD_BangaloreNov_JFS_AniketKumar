package com.cap.forestrymanagementsystem.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cap.forestrymanagementsystem.dao.AdminDAO;
import com.cap.forestrymanagementsystem.dao.AdminDAOImpl;
import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserProduct;

class AdminDAOImplTest {
	private UserAdmin adminBean = null;
	private UserClient clientBean = null;
	private AdminDAO dao = null;

	@BeforeEach
	void load() {
		dao = new AdminDAOImpl();
	}

	// @Test
	// void testAdminDAOImpl() {
	//
	// }
	//
	@Test
	void testLogin() {
		adminBean = new UserAdmin();
		try {
			adminBean.setUser_type("Admin");
			adminBean.setUsername("Aniket");
			adminBean.setPassword("qwerty");
			String login = dao.login(adminBean.getUsername(), adminBean.getPassword());
			assertNotNull(login);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testAddClient() {
		clientBean = new UserClient();
		clientBean.setCustomerId(108);
		clientBean.setCustomerName("Aniket");
		clientBean.setEmail("Aniket@gmail.com");
		clientBean.setPhoneNumber(7076417);
		clientBean.setPostalCode(801512);
		clientBean.setStreetAddess1("Bada");
		clientBean.setStreetAddess2("CHowk");
		clientBean.setTown("Giridih");
		boolean check = dao.addClient(clientBean);
		assertEquals(check, true);
	}

	@Test
	void testGetAllProduct() {
		Set<UserProduct> setProduct = new HashSet<UserProduct>();
		setProduct = dao.getAllProduct();
		assertNotNull(setProduct);
	}

	@Test
	void testShowContracts() {
		Set<UserContractor> setContractor = new HashSet<UserContractor>();
		setContractor = dao.showContracts();
		assertNotNull(setContractor);
	}

	@Test
	void testDeleteClient() {
		clientBean = new UserClient();
		clientBean.setCustomerId(108);
		boolean check = dao.deleteClient(clientBean.getCustomerId());
		assertEquals(check, true);
	}

}
