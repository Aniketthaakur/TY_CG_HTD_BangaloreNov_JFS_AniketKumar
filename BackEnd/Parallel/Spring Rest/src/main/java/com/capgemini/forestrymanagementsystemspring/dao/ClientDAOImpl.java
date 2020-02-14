package com.capgemini.forestrymanagementsystemspring.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementsystemspring.dto.UserAdmin;
import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;

@Repository
public class ClientDAOImpl implements ClientDAO {
	@PersistenceUnit
	EntityManagerFactory factory;
	EntityManager manager;
	EntityTransaction transaction;
	List<UserClient> listClient;
	Set<UserClient> setClient;
	Set<UserContractor> setContractor;
	List<UserContractor> listContractor;
	Set<UserOrder> setOrder;
	List<UserOrder> listOrder;
	
	Scanner sc=new Scanner(System.in);

	public Set<UserClient> getAllClient() {
		setClient = new HashSet<UserClient>();
		listClient = new ArrayList<UserClient>();
		manager = factory.createEntityManager();
		try {
			String jpql = "from UserClient";
			Query query = manager.createQuery(jpql);
			listClient = query.getResultList();
			setClient.addAll(listClient);
			return setClient;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean orderContracts(UserContractor contract) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(contract);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean updateContract(UserContractor contractor,int haulierId) {
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		UserContractor contractor1 = manager.find(UserContractor.class,haulierId);
		if (contractor != null) {
			try {
				transaction.begin();
				
				contractor1.setContractorNo(contractor.getContractorNo());
				//int customerId=sc.nextInt();
				contractor1.setCustomerId(contractor.getCustomerId());
			//	int productId=sc.nextInt();
				contractor1.setProductId(contractor.getProductId());
			//	int quantity=sc.nextInt();
				contractor1.setQuantity(contractor.getQuantity());
			//	String deliverydate =sc.next();
				contractor1.setDeliveryDate(contractor.getDeliveryDate());
			//	String deliveryDay=sc.next();
				contractor1.setDeliveryDay(contractor.getDeliveryDay());
			//	int parcelId=sc.nextInt();
				contractor1.setParcelId(contractor.getParcelId());
				
				transaction.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean deleteContract(int haulierId) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		try {
			transaction.begin();
			UserContractor contractor = manager.find(UserContractor.class, haulierId);
			manager.remove(contractor);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Set<UserContractor> contractInformation() {
		setContractor = new HashSet<UserContractor>();
		listContractor = new ArrayList<UserContractor>();
		manager = factory.createEntityManager();
		String jpql = "from UserContractor";
		Query query = manager.createQuery(jpql);

		try {
			listContractor = query.getResultList();
			setContractor.addAll(listContractor);
			return setContractor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return null;
	}

	public boolean addProduct(UserProduct product) {
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Product Id Not Able To Modify..!!! ");
		}
		
		return false;
	}

	public boolean deleteProduct(int prouctId) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		try {
			transaction.begin();
			UserProduct product = manager.find(UserProduct.class, prouctId);
			manager.remove(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(String productName, int productId) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		UserProduct product = manager.find(UserProduct.class, productId);
		if (product != null) {
			try {
				transaction.begin();
				product.setProductName(productName);
				product.setProductId(productId);
				transaction.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Set<UserOrder> showOrder() {
		listOrder=new ArrayList<UserOrder>();
		setOrder =new HashSet<UserOrder>();
		manager=factory.createEntityManager();
		
		try {
			String jpql="from UserOrder";
			Query query=manager.createQuery(jpql);
			listOrder=query.getResultList();
			setOrder.addAll(listOrder);
			return setOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String clientLogin(String username, String  password) {
		UserAdmin admin=new UserAdmin();
		manager = factory.createEntityManager();
		String jpql1 = "from UserAdmin where username=:name and password=:password";
		Query query = manager.createQuery(jpql1);
		query.setParameter("name", username);
		query.setParameter("password", password);

		try {
			admin =  (UserAdmin) query.getSingleResult();
		} catch (Exception e) {
		
		}
		String user=admin.getUsertype();
		manager.close();
		if(user!=null) {
		return user;
		}else {
			return null;
		}
	}

}