package com.cap.forestrymanagementsystemhibernat.dao;

import java.util.Set;

import com.cap.forestrymanagementsystemhibernat.dto.UserHaulier;
import com.cap.forestrymanagementsystemhibernat.dto.UserOrder;

public interface SchedulerDAO {

//	public Set<UserProduct> getAllProduct();  //get all product by admin part
	public boolean addOrder(UserOrder order);
//	public boolean addContract(UserContractor contractor); //add contracts by client
//	public Set<UserOrder> getAllOrder(); // //get all Order by client
	public boolean addHaulier(UserHaulier haulier); 
	public Set<UserHaulier> getAllHaulier();
	public boolean updateHaulier(long haulierPhoneNo,String haulierName); 
}
