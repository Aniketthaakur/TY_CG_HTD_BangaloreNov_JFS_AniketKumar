package com.cap.forestrymanagementsystem.service;

import java.util.Set;

import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserOrder;
import com.cap.forestrymanagementsystem.dto.UserProduct;

public interface ClientService {
	
	public Set<UserClient> getAllClient();

	public boolean orderContracts(UserContractor contract);// add

	public boolean updateContract(int contractorNo, int haulierId);// update

	public boolean deleteContract(int haulierId);// delete

	public boolean addProduct(UserProduct prod);

	public boolean deleteProduct(int prouctId);

	public boolean updateProduct(int productName, String productId);

	public Set<UserOrder> showOrder();

	public String clientLogin(String name, String password);

	public Set<UserContractor> contractInformation();
	
	public boolean searchProduct(int productId);

	public boolean searchClient(int customerId);

	public boolean searchContractor(int haulierId);

	public boolean searchParcel(int parcelId);
}
