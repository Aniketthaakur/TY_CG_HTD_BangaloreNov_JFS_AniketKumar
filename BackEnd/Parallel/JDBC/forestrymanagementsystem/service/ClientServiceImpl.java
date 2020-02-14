package com.cap.forestrymanagementsystem.service;

import java.util.Set;

import com.cap.forestrymanagementsystem.dao.ClientDAO;
import com.cap.forestrymanagementsystem.dao.ClientDAOImpl;
import com.cap.forestrymanagementsystem.dto.UserAdmin;
import com.cap.forestrymanagementsystem.dto.UserClient;
import com.cap.forestrymanagementsystem.dto.UserContractor;
import com.cap.forestrymanagementsystem.dto.UserOrder;
import com.cap.forestrymanagementsystem.dto.UserProduct;

public class ClientServiceImpl implements ClientService{
		ClientDAO dao=new ClientDAOImpl();
	@Override
	public Set<UserClient> getAllClient() {
		return dao.getAllClient();
	}

	@Override
	public boolean orderContracts(UserContractor contract) {
		return dao.orderContracts(contract);
	}

	@Override
	public boolean updateContract(int contractorNo, int haulierId) {
		return dao.updateContract(contractorNo, haulierId);
	}

	@Override
	public boolean deleteContract(int haulierId) {
		return dao.deleteContract(haulierId);
	}

	@Override
	public boolean addProduct(UserProduct prod) {
		return dao.addProduct(prod);
	}

	@Override
	public boolean deleteProduct(int prouctId) {
		return dao.deleteProduct(prouctId);
	}

	@Override
	public boolean updateProduct(int productName, String productId) {
		return dao.updateProduct(productName, productId);
	}

	@Override
	public Set<UserOrder> showOrder() {

		return dao.showOrder();
	}

	@Override
	public String clientLogin(String name, String  password) {
		return dao.clientLogin(name, password);
	}

	@Override
	public Set<UserContractor> contractInformation() {
		return dao.contractInformation();
	}

	@Override
	public boolean searchProduct(int prouctId) {
		return dao.searchProduct(prouctId);
	}

	@Override
	public boolean searchClient(int customerId) {
		return dao.searchClient(customerId);
	}

	@Override
	public boolean searchContractor(int haulierId) {
		return dao.searchContractor(haulierId);
	}

	@Override
	public boolean searchParcel(int parcelId) {
		return dao.searchParcel(parcelId);
	}

}
