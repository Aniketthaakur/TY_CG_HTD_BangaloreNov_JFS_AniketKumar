package com.cap.forestrymanagementsystemhibernat.dao;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dto.UserClient;
import com.cap.forestrymanagementsystemhibernat.dto.UserContractor;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;

public interface ClientDAO {
	public Set<UserClient> getAllClient();

	public boolean orderContracts(UserContractor contract);// add contract

	public boolean updateContract(int contractorNo, int haulierId);// update contract

	public boolean deleteContract(int haulierId);// delete contracts

	public Set<UserContractor> contractInformation();//get all contract

	public boolean addProduct(UserProduct prod);

	public boolean deleteProduct(int prouctId);

	public boolean updateProduct(String productName, int productId);

	public Set<UserOrder> showOrder(); //get all Order

	public String clientLogin(String username, String password);
	
	public boolean searchProduct(int productId);

	public boolean searchClient(int customerId);

	public boolean searchContractor(int haulierId);

	public boolean searchParcel(int parcelId);

}
