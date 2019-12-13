package com.cap.appdevelopment.dao;

import java.util.List;

import com.cap.appdevelopment.dto.Contact;

public interface ContactDAO {
	
	public List<Contact> getAllContact();
	public boolean updateContact(String  name,int  number);
	public boolean deleteContact(String  name);
	public boolean addContact(Contact user);
	

}
