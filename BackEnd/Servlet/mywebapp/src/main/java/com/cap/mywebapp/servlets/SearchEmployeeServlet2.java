package com.cap.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cap.mywebapp.beans.EmployeeInfoBean;
import com.cap.mywebapp.service.EmployeeService;
import com.cap.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/searchEmployee2")
public class SearchEmployeeServlet2 extends HttpServlet {
	private EmployeeService employeeService=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// validate the session
		HttpSession session = req.getSession(false);// if seesion already created we dont want to create session that is
													// why false if user is not logged in then false part return null..
													//for session creation in add,delete or in  b/w the session after loggin  use alwys false as parameter
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if (session != null) {
			//Valid session
			  String empIdVal=req.getParameter("empId");
			  int empId=Integer.parseInt(empIdVal);
			  EmployeeInfoBean employeeInfoBean=employeeService.searchEmployee(empId);
			  if(employeeInfoBean!=null)
			  {
				  out.println("<h3 style='color:green'>Employee Id "+empId+"Found-</h3>");
				  out.println("<br>Name ="+employeeInfoBean.getName());
				  out.println("<br> Age = "+employeeInfoBean.getAge());
				  out.println("<br> Salary ="+employeeInfoBean.getSalary());
				  out.println("<br> designation ="+employeeInfoBean.getDegination());
			  }
			  else
			  {
				  out.println("<h3 style='color:red'> Employee ID "+empId+"Not Found!</h3>");  
			  }
			
		}else {
			//Invalid session
			out.println("Please login First");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
			
		}
		out.println("</body>");
		out.println("</html>");
	}// end of doGet()
}// end of class
