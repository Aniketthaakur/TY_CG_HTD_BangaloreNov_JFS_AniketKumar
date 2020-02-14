package com.cap.forestrymanagementsystem.dao;

import java.util.Set;


import com.cap.forestrymanagementsystem.dto.UserHaulier;
import com.cap.forestrymanagementsystem.dto.UserOrder;

public interface SchedulerDAO {

//	public Set<UserProduct> getAllProduct();  //get all product by admin part
	public boolean addOrder(UserOrder order);
//	public boolean addContract(UserContractor contractor); //add contracts by client
//	public Set<UserOrder> getAllOrder(); // //get all Order by client
	public boolean addHaulier(UserHaulier haulier); 
	public Set<UserHaulier> getAllHaulier();
	public boolean updateHaulier(long haulierPhoneNo,String haulierName); 
}
