package com.cap.springboot.dao;

import java.util.List;

import com.cap.springboot.dto.EmployeeBean;

public interface EmployeeDAO {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean> getEmployees(String key);
	public boolean changePassword(int id,String password);
	public boolean deleteEmployee(int id);
}
