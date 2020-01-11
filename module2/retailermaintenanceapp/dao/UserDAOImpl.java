package com.capgimini.retailermaintenanceapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgimini.retailermaintenanceapp.dto.OrderInfo;
import com.capgimini.retailermaintenanceapp.dto.ProductInfo;
import com.capgimini.retailermaintenanceapp.dto.UserInfo;

@Repository
public class UserDAOImpl implements UserDao {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean createProfile(UserInfo bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserInfo login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql1 = "from UserInfo where empId=:empId and password=:password";
		TypedQuery<UserInfo>  query= manager.createQuery(jpql1,UserInfo.class);
		query.setParameter("empId", email);
		query.setParameter("password", password);

		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) query.getSingleResult();
		} catch (Exception e) {
			e.getMessage();
		}

		manager.close();
		return userInfo;
	}// end of authenticate

	@Override
	public ProductInfo searchProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		ProductInfo product=manager.find(ProductInfo.class, id);
		return product;
		
	}

	@Override
	public boolean updatePassword(int id, String password) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		UserInfo bean=manager.find(UserInfo.class, id);
		bean.setPassword(password);
		transaction.commit();
		
		return true;
		
		
	}

	@Override
	public List<ProductInfo> totalAmountPayable(String name) {
		String jpql="from ProductInfo where name=:name ";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<ProductInfo> query=manager.createQuery(jpql, ProductInfo.class);
		query.setParameter("name",name);
	
		return  query.getResultList();
		
	}

	@Override
	public OrderInfo retreiveOrder(int id) {
		EntityManager manager = factory.createEntityManager();
		OrderInfo product=manager.find(OrderInfo.class, id);
		return product;
		
	}

}
