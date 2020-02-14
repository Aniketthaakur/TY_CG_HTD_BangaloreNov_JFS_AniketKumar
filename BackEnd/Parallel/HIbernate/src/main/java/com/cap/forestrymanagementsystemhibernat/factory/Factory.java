package com.cap.forestrymanagementsystemhibernat.factory;

import com.cap.forestrymanagementsystemhibernat.dao.AdminDAO;
import com.cap.forestrymanagementsystemhibernat.dao.AdminDAOImpl;
import com.cap.forestrymanagementsystemhibernat.service.AdminService;
import com.cap.forestrymanagementsystemhibernat.service.AdminServiceImpl;
import com.cap.forestrymanagementsystemhibernat.service.ClientService;
import com.cap.forestrymanagementsystemhibernat.service.ClientServiceImpl;
import com.cap.forestrymanagementsystemhibernat.service.LandService;
import com.cap.forestrymanagementsystemhibernat.service.LandServiceImpl;
import com.cap.forestrymanagementsystemhibernat.service.SchedulerService;
import com.cap.forestrymanagementsystemhibernat.service.SchedulerServiceImpl;

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
