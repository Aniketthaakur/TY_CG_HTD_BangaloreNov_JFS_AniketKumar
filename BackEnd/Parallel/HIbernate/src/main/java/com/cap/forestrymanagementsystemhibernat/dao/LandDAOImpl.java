package com.cap.forestrymanagementsystemhibernat.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.forestrymanagementsystemhibernat.dto.UserLand;
import com.cap.forestrymanagementsystemhibernat.dto.UserProduct;

public class LandDAOImpl implements LandDAO {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Test");
	EntityManager manager;
	EntityTransaction transaction;
	List<UserLand> lands;
	Set<UserLand>  setLand;
	
	public boolean addLandRecord(UserLand land) {
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(land);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean paymentStatus(String parcelPaymentSlip, int parcelID) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		UserLand land = manager.find(UserLand.class, parcelID);
		if (land != null) {
			try {
				transaction.begin();
				land.setParcelPaymentSlip(parcelPaymentSlip);
				land.setParcelID(parcelID);
				transaction.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updatePaymentDescription(String paymentDescription, int parcelID) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		UserLand land = manager.find(UserLand.class, parcelID);
		if (land != null) {
			try {
				transaction.begin();
				land.setPaymentDescription(paymentDescription);
				land.setParcelID(parcelID);
				transaction.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Set<UserLand> getAllLandDetails() {
		lands=new ArrayList<UserLand>();
		setLand=new HashSet<UserLand>();
		manager=factory.createEntityManager();
		
		try {
			String jpql="from UserLand";
			Query query=manager.createQuery(jpql);
			lands=query.getResultList();
			setLand.addAll(lands);
			return setLand;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}