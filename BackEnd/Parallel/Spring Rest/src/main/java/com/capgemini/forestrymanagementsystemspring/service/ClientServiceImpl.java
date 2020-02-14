package com.capgemini.forestrymanagementsystemspring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystemspring.dao.ClientDAO;
import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDAO dao; 

	public Set<UserClient> getAllClient() {
		return dao.getAllClient();
	}

	public boolean orderContracts(UserContractor contract) {
		return dao.orderContracts(contract);
	}

	public boolean updateContract(UserContractor contractor,int haulierId) {
		return dao.updateContract(contractor,haulierId);
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

}
