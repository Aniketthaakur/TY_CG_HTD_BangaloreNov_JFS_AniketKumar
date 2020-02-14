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

import com.capgemini.forestrymanagementsystemspring.dto.UserHaulier;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;

@Repository
public class SchedulerDAOImpl implements SchedulerDAO{
	
	@PersistenceUnit
	EntityManagerFactory factory;
	EntityManager manager;
	EntityTransaction transaction;
	Set<UserHaulier> setHaulier;
	List<UserHaulier> listHaulier;
	
	public boolean addOrder(UserOrder order) {
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(order);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean addHaulier(UserHaulier haulier) {
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(haulier);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Set<UserHaulier> getAllHaulier() {
		listHaulier=new ArrayList<UserHaulier>();
		setHaulier=new  HashSet<UserHaulier>();
		manager=factory.createEntityManager();
		try {
			String jpql="from UserHaulier";
			Query query =manager.createQuery(jpql);
			listHaulier=query.getResultList();
			setHaulier.addAll(listHaulier);
			return setHaulier;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean updateHaulier(long haulierPhoneNo, String haulierName) {
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();

		UserHaulier haulier=manager.find(UserHaulier.class, haulierName);
		if(haulier!=null) {
			try {
				transaction.begin();
				haulier.setHaulierPhoneNo(haulierPhoneNo);
				haulier.setHaulierName(haulierName);
				transaction.commit();
				manager.close();
				return true;
			}catch (Exception e) {
			}
		}
		
		return false;
	}

}