package com.cap.forestrymanagementsystem.dao;

import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserOrder;
import com.cap.forestrymanagementsystem.dto.UserProduct;

public interface ClientDAO {
	public Set<UserClient> getAllClient();

	public boolean orderContracts(UserContractor contract);// add contract

	public boolean updateContract(int contractorNo, int haulierId);// update contract

	public boolean deleteContract(int haulierId);// delete contracts

	public Set<UserContractor> contractInformation();// get all contract

	public boolean addProduct(UserProduct prod);

	public boolean deleteProduct(int prouctId);

	public boolean updateProduct(int productName, String productId);

	public Set<UserOrder> showOrder(); // get all Order

	public String clientLogin(String name, String password);

	public boolean searchProduct(int productId);

	public boolean searchClient(int customerId);

	public boolean searchContractor(int haulierId);

	public boolean searchParcel(int parcelId);
}
