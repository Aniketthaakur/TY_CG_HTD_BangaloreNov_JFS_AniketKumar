package com.cap.forestrymanagementsystemhibernat.dao;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dto.UserAdmin;
import com.cap.forestrymanagementsystemhibernat.dto.UserClient;
import com.cap.forestrymanagementsystemhibernat.dto.UserContractor;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;

public interface AdminDAO {
	
	public String login(String username,String password);
	public boolean addClient(UserClient bean);
	public Set<UserProduct> getAllProduct();
	public Set<UserContractor> showContracts();
	public boolean deleteClient(int customerId);

}
