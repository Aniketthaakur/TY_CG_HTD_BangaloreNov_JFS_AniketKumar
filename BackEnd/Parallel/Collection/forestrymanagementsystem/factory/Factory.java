package com.capgimini.forestrymanagementsystem.factory;

import com.capgimini.forestrymanagementsystem.service.AdminService;
import com.capgimini.forestrymanagementsystem.service.AdminServiceImpl;
import com.capgimini.forestrymanagementsystem.service.ClientService;
import com.capgimini.forestrymanagementsystem.service.ClientServiceImpl;
import com.capgimini.forestrymanagementsystem.service.ContractorService;
import com.capgimini.forestrymanagementsystem.service.ContractorServiceImpl;
import com.capgimini.forestrymanagementsystem.service.ProductService;
import com.capgimini.forestrymanagementsystem.service.ProductServiceImpl;

public class Factory {
public static  ContractorService objectContractor()
{
	ContractorService contractor=new ContractorServiceImpl();
	return contractor;
}

public static ClientService objectCustomer()
{
		ClientService user=new ClientServiceImpl();
		return user;
		
}
public static ProductService objectProduct()
{
	ProductService dao=new ProductServiceImpl();
	return dao;
}
public static AdminService objectAdmin() {
	AdminService dao=new AdminServiceImpl();
	return dao;
}
}