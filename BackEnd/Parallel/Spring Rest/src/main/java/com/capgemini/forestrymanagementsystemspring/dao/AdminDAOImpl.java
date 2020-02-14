package com.capgemini.forestrymanagementsystemspring.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceUnit
	EntityManagerFactory factory;
	EntityManager entityManager;
	EntityTransaction transaction;
	UserAdmin user;
	Set<UserProduct> productSet;
	List<UserProduct> listProduct;
	Set<UserContractor> setContractor;
	List<UserContractor> listContractor;

	public String login(String username, String password) {
		entityManager = factory.createEntityManager();
		user=new UserAdmin();
		String jpql1 = "from UserAdmin where name=:name and password=:password";
		Query query = entityManager.createQuery(jpql1);
		query.setParameter("name", username);
		query.setParameter("password", password);

		try {
			user = (UserAdmin) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Invalid data entered");
		}
		String useR=user.getUsertype();
		entityManager.close();
		if(useR!=null) {
		return useR;
		}else {
			return null;
		}
	}

	public boolean addClient(UserClient bean) {
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			return true;
		
			
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public Set<UserProduct> getAllProduct() {
		productSet = new HashSet<UserProduct>();
		listProduct = new ArrayList<UserProduct>();
		entityManager = factory.createEntityManager();
		String jpql = "from UserProduct";
		Query query = entityManager.createQuery(jpql);

		try {
			listProduct = query.getResultList();
			productSet.addAll(listProduct);
			return productSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();

		return null;
	}

	public Set<UserContractor> showContracts() {
		setContractor = new HashSet<UserContractor>();
		listContractor = new ArrayList<UserContractor>();
		entityManager = factory.createEntityManager();
		String jpql = "from UserContractor";
		Query query = entityManager.createQuery(jpql);

		try {
			listContractor = query.getResultList();
			setContractor.addAll(listContractor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return setContractor;
		// return null;
	}

	public boolean deleteClient(int customerId) {
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			UserClient client = entityManager.find(UserClient.class, customerId);
			entityManager.remove(client);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println("Not a valid Customer Id");
		}
		return false;
	}

}