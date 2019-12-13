package com.cap.appdevelopment.factory;

import com.cap.appdevelopment.dao.ContactDAO;
import com.cap.appdevelopment.dao.ContactDAOImpl;

public class Factory {

	public static ContactDAO objectContact()
	{
		ContactDAO dao =new ContactDAOImpl();
		return dao;
	}
}
