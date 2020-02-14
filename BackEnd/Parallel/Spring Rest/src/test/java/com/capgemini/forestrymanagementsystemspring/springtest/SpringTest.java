package com.capgemini.forestrymanagementsystemspring.springtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.forestrymanagementsystemspring.dao.AdminDAO;
import com.capgemini.forestrymanagementsystemspring.dao.AdminDAOImpl;
import com.capgemini.forestrymanagementsystemspring.dao.ClientDAO;
import com.capgemini.forestrymanagementsystemspring.dao.ClientDAOImpl;
import com.capgemini.forestrymanagementsystemspring.dao.LandDAO;
import com.capgemini.forestrymanagementsystemspring.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystemspring.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystemspring.dao.SchedulerDAOImpl;
import com.capgemini.forestrymanagementsystemspring.service.AdminService;
import com.capgemini.forestrymanagementsystemspring.service.AdminServiceImpl;
import com.capgemini.forestrymanagementsystemspring.service.ClientService;
import com.capgemini.forestrymanagementsystemspring.service.ClientServiceImpl;
import com.capgemini.forestrymanagementsystemspring.service.LandService;
import com.capgemini.forestrymanagementsystemspring.service.LandServiceImpl;
import com.capgemini.forestrymanagementsystemspring.service.SchedulerService;
import com.capgemini.forestrymanagementsystemspring.service.SchedulerServiceImpl;

@Configuration
public class SpringTest {

	@Bean
	public AdminDAO adminDao() {
		return new AdminDAOImpl();
	}

	@Bean
	public AdminService adminService() {
		return new AdminServiceImpl();
	}

	@Bean
	public ClientDAO clientDao() {
		return new ClientDAOImpl();
	}

	@Bean
	public ClientService clientService() {
		return new ClientServiceImpl();
	}

	@Bean
	public LandDAO landDao() {
		return new LandDAOImpl();
	}

	@Bean
	public LandService landService() {
		return new LandServiceImpl();
	}

	@Bean
	public SchedulerDAO schedulerDao() {
		return new SchedulerDAOImpl();
	}

	@Bean
	public SchedulerService schedulerService() {
		return new SchedulerServiceImpl();
	}
}
