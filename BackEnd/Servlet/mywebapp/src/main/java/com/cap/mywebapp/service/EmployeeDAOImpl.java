package com.cap.mywebapp.service;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.mywebapp.beans.EmployeeInfoBean;

public class EmployeeDAOImpl implements EmployeeDAO {

private	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
	
@Override
	public EmployeeInfoBean searchEmployee(int empid) {
EntityManager entitymanager=entityManagerFactory.createEntityManager();
EmployeeInfoBean employeeInfoBean=entitymanager.find(EmployeeInfoBean.class, empid);
entitymanager.close();	
return employeeInfoBean;
	}//end of search emp

@Override
public EmployeeInfoBean authenticate(int empid, String password) {
   EntityManager manager=entityManagerFactory.createEntityManager();
   String jpql1="from EmployeeInfoBean where empId=:empId and password=:password";
   Query query=manager.createQuery(jpql1);
   query.setParameter("empId",empid);
   query.setParameter("password", password);
   
   EmployeeInfoBean employeeInfoBean=null;
   try {
	 employeeInfoBean=  (EmployeeInfoBean)query.getSingleResult();
   }
   catch(Exception e)
   {
	   e.getMessage();
   }
		
   manager.close();
   return employeeInfoBean;
}//end of authenticate

@Override
public boolean addEmployee() {
	EmployeeInfoBean emp=new EmployeeInfoBean();
	emp.setAge(23);
	emp.setEmpId(103);
	emp.setName("sunny");
	emp.setSalary(547);
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction transaction=entityManager.getTransaction();
	transaction.begin();
	entityManager.persist(emp);
	System.out.println("updated succesfully....");
	transaction.commit();
	return true;
}

}
