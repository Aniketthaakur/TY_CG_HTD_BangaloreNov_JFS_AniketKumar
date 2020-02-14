package com.cap.forestrymanagementsystem.factory;

import com.cap.forestrymanagementsystem.dao.AdminDAO;

import com.cap.forestrymanagementsystem.dao.AdminDAOImpl;
import com.cap.forestrymanagementsystem.service.AdminService;
import com.cap.forestrymanagementsystem.service.AdminServiceImpl;
import com.cap.forestrymanagementsystem.service.ClientService;
import com.cap.forestrymanagementsystem.service.ClientServiceImpl;
import com.cap.forestrymanagementsystem.service.LandService;
import com.cap.forestrymanagementsystem.service.LandServiceImpl;
import com.cap.forestrymanagementsystem.service.SchedulerService;
import com.cap.forestrymanagementsystem.service.SchedulerServiceImpl;

public class Factory {

	public static AdminDAO getAdmin() {
		
		AdminDAO dao=new AdminDAOImpl();
		return dao;
	}
	
	public static AdminService getAdminService() {
		AdminService service=new AdminServiceImpl();
		return service;
	}
	public static ClientService getClientObject() {
		ClientService service=new ClientServiceImpl();
		return service;
	}
	
	public static SchedulerService getInstanceOfScheduler() {
		SchedulerService service=new SchedulerServiceImpl();
		return service;
	}
	
	public static LandService getInstanceOfLand() {
		LandService service=new LandServiceImpl();
		return service;
	}
}
