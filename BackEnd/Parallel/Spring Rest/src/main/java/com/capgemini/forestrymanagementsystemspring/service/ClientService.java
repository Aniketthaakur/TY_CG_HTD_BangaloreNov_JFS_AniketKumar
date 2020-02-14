package com.capgemini.forestrymanagementsystemspring.service;

import java.util.Set;

import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;

public interface ClientService {
	
	public Set<UserClient> getAllClient();

	public boolean orderContracts(UserContractor contract);// add

	public boolean updateContract(UserContractor contractor,int haulierId);// update

	public boolean deleteContract(int haulierId);// delete

	public boolean addProduct(UserProduct prod);

	public boolean deleteProduct(int prouctId);

	

	public Set<UserOrder> showOrder();

	public String clientLogin(String name, String password);

	public Set<UserContractor> contractInformation();

	public boolean updateProduct(String productName, int productId);

}
