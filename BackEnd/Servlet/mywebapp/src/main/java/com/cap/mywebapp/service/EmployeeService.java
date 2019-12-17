package com.cap.mywebapp.service;

import com.cap.mywebapp.beans.EmployeeInfoBean;

public interface EmployeeService {
	public EmployeeInfoBean searchEmployee(int empid);
	public EmployeeInfoBean authenticate(int empid,String password);
}//end of DAO
