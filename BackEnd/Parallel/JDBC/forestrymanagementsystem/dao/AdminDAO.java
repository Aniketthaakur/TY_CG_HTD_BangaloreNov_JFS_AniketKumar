package com.cap.forestrymanagementsystem.dao;

import java.util.Set;


import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserProduct;
import com.cap.forestrymanagementsystem.dto.UserContractor;

public interface AdminDAO {
	
	public String login(String username,String password);
	public boolean addClient(UserClient bean);
	public Set<UserProduct> getAllProduct();
	public Set<UserContractor> showContracts();
	public boolean deleteClient(int customerId);

}
