package com.capgemini.forestrymanagementsystemspring.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementsystemspring.config.ORMConfig;
import com.capgemini.forestrymanagementsystemspring.dao.AdminDAO;
import com.capgemini.forestrymanagementsystemspring.dto.UserAdmin;
import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;
import com.capgemini.forestrymanagementsystemspring.springtest.SpringTest;

@SpringJUnitConfig(classes= {SpringTest.class,ORMConfig.class})
class AdminServiceImplTest {
	@Autowired
	private AdminDAO dao = null;
	private UserAdmin adminBean = null;
	private UserClient clientBean = null;

	

	// @Test
	// void testAdminDAOImpl() {
	//
	// }
	//
	@Test
	void testLogin() {
		adminBean = new UserAdmin();
		try {
			adminBean.setName("Aniket");
			adminBean.setPassword("qwerty");
			adminBean.setUsertype("Admin");
			String login = dao.login(adminBean.getName(), adminBean.getPassword());
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
