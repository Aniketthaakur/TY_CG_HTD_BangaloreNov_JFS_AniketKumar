package com.capgemini.forestrymanagementsystemspring.dao;

import java.util.Set;

import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;

public interface ClientDAO {
	public Set<UserClient> getAllClient();

	public boolean orderContracts(UserContractor contract);// add contract

	public boolean updateContract(UserContractor contractor,int haulierId);// update contract

	public boolean deleteContract(int haulierId);// delete contracts

	public Set<UserContractor> contractInformation();//get all contract

	public boolean addProduct(UserProduct prod);

	public boolean deleteProduct(int prouctId);

	public boolean updateProduct(String productName, int productId);

	public Set<UserOrder> showOrder(); //get all Order

	public String clientLogin(String username, String password);


}
