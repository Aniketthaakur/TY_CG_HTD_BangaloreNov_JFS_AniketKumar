package com.cap.forestrymanagementsystem.service;

import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserProduct;

public interface AdminService {

	public String login(String username,String password);
	public boolean addClient(UserClient bean);
	public Set<UserProduct> getAllProduct();
	public Set<UserContractor> showContracts();
	public boolean deleteClient(int customerId);
}
