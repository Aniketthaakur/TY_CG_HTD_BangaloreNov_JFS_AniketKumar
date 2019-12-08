package com.caps.factory;

import com.caps.dao.ContractorDAO;
import com.caps.dao.ContractorDAOImpl;
import com.caps.dao.CustomerDAO;
import com.caps.dao.CustomerDAOImpl;
import com.caps.dao.ProductDAO;
import com.caps.dao.ProductDAOImpl;

public class Factory {
public static  ContractorDAO objectContractor()
{
	ContractorDAO contractor=new ContractorDAOImpl();
	return contractor;
}

public static CustomerDAO objectCustomer()
{
		CustomerDAO user=new CustomerDAOImpl();
		return user;
		
}
public static ProductDAO objectProduct()
{
	ProductDAO dao=new ProductDAOImpl();
	return dao;
}
}