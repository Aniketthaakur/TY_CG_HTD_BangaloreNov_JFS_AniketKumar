package com.cap.mywebapp.service;

import com.cap.mywebapp.beans.EmployeeInfoBean;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao=new  EmployeeDAOImpl();
	@Override
	public EmployeeInfoBean searchEmployee(int empid) {
		return dao.searchEmployee(empid);
	}

	public EmployeeInfoBean authenticate(int empid,String password)
	{
		return dao.authenticate(empid, password);
		}
}