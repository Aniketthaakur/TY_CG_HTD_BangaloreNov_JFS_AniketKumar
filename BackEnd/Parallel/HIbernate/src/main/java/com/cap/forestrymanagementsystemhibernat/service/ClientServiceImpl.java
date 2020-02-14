package com.cap.forestrymanagementsystemhibernat.service;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dao.ClientDAO;
import com.cap.forestrymanagementsystemhibernat.dao.ClientDAOImpl;
import com.cap.forestrymanagementsystemhibernat.dto.UserClient;
import com.cap.forestrymanagementsystemhibernat.dto.UserContractor;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;


public class ClientServiceImpl implements ClientService{
		ClientDAO dao=new ClientDAOImpl();
	public Set<UserClient> getAllClient() {
		return dao.getAllClient();
	}

	public boolean orderContracts(UserContractor contract) {
		return dao.orderContracts(contract);
	}

	public boolean updateContract(int contractorNo, int haulierId) {
		return dao.updateContract(contractorNo, haulierId);
	}

	public boolean deleteContract(int haulierId) {
		return dao.deleteContract(haulierId);
	}

	public boolean addProduct(UserProduct prod) {
		return dao.addProduct(prod);
	}

	public boolean deleteProduct(int prouctId) {
		return dao.deleteProduct(prouctId);
	}

	public boolean updateProduct(String productName, int productId) {
		return dao.updateProduct(productName, productId);
	}

	public Set<UserOrder> showOrder() {

		return dao.showOrder();
	}

	public String clientLogin(String name, String password) {
		return dao.clientLogin(name, password);
	}

	public Set<UserContractor> contractInformation() {
		return dao.contractInformation();
	}

	@Override
	public boolean searchProduct(int productId) {
			return dao.searchProduct(productId);
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
