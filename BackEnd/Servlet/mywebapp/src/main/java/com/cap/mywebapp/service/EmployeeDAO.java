package com.cap.mywebapp.service;


import com.cap.mywebapp.beans.EmployeeInfoBean;

public interface EmployeeDAO {
	public EmployeeInfoBean authenticate(int empid,String password);
public EmployeeInfoBean searchEmployee(int empid);
public boolean addEmployee();
}
