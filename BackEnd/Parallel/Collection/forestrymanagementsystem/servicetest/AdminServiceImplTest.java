package com.capgimini.forestrymanagementsystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgimini.forestrymanagementsystem.dao.AdminDAO;
import com.capgimini.forestrymanagementsystem.dao.AdminDAOImpl;
import com.capgimini.forestrymanagementsystem.dto.UserAdmin;

class AdminServiceImplTest {
	private UserAdmin adminBean=null;
	private AdminDAO dao=new AdminDAOImpl();
	
	@BeforeEach
	void load() {
		dao=new AdminDAOImpl();
	}
	
	@Test
	void testLogin() {
		adminBean=new UserAdmin();
		adminBean.setUserName("Aniket");
		adminBean.setPassword("qwerty");
		boolean check=dao.login(adminBean.getUserName(), adminBean.getPassword());
		assertEquals(check,true);
	}

}
