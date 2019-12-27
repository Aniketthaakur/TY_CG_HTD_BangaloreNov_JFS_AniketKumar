package com.cap.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cap.springboot.dao.EmployeeDAO;
import com.cap.springboot.dto.EmployeeAddressBean;
import com.cap.springboot.dto.EmployeeBean;
@Service
public class EmployeeServiceImlp implements EmployeeService{
 
	@Autowired //no need of factory method after Autowired
	private EmployeeDAO dao;
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Override
	public EmployeeBean auth(String email, String password) {
		
		return dao.auth(email, password);
	}

	@Override
	public boolean register(EmployeeBean bean) {
		
		String encoderPassword=encoder.encode(bean.getPassword());
		bean.setPassword(encoderPassword);
		
		List<EmployeeAddressBean> addressBeans=bean.getAdressBeans();
		for (EmployeeAddressBean employeeAddressBean : addressBeans) {
			employeeAddressBean.setBean(bean);
			
		}
		return dao.register(bean);
	}

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		
		return dao.getEmployees(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		
		return dao.changePassword(id, encoder.encode(password));
	}

	@Override
	public boolean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

}