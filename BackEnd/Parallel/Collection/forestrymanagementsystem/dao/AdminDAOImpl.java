package com.capgimini.forestrymanagementsystem.dao;

import com.capgimini.forestrymanagementsystem.dto.UserAdmin;

public class AdminDAOImpl implements AdminDAO{
    UserAdmin admin=new UserAdmin();
	@Override
	public boolean login(String userName, String password)  {
		
		String user="Aniket";
		String pass="qwerty";
		try {
		if(userName.equals(user)) {
			if(password.equals(pass)) {
			
			return true;
		}
		}
		}catch(Exception e) {
		
			System.out.println("Credentials invalid.");
			return false;
		}
		
		return false;
	}
 
}
