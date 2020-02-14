package com.capgemini.forestrymanagementsystemspring.dao;

import java.util.Set;

import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;

public interface AdminDAO {
	
	public String login(String username,String password);
	public boolean addClient(UserClient bean);
	public Set<UserProduct> getAllProduct();
	public Set<UserContractor> showContracts();
	public boolean deleteClient(int customerId);

}
