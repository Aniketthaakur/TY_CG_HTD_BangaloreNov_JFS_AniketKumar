package com.capgimini.forestrymanagementsystem.service;

import com.capgimini.forestrymanagementsystem.dao.AdminDAO;
import com.capgimini.forestrymanagementsystem.dao.AdminDAOImpl;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao=new AdminDAOImpl();
	@Override
	public boolean login(String userName, String password) {
		return dao.login(userName, password);
	}

}
