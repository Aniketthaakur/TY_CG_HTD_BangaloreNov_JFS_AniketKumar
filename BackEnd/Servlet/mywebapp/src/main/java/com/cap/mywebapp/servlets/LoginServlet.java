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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the form data
		String empIdVal = req.getParameter("empId");
		String password = req.getParameter("password");

		int empId = Integer.parseInt(empIdVal);
		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (employeeInfoBean != null) {
			//valid credential
			HttpSession session=req.getSession(true) ;//creating the session becoz we have add delete and much more operation have to do  (always go for getSession(true))
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			out.println("<h2 style='color:blue'>Welcome "+employeeInfoBean.getName()+" </h2>");
			out.println("<br><a href='#'> Add Employee </a>");
			out.println("<br><a href='#'> Update Employee </a>");
			out.println("<br><a href='./searchEmpForm.html'> Search Employee </a>");
			out.println("<br><a href='#'> Delete Employee </a>");
			out.println("<br><a href='#'> See All Employee </a>");
			out.println("<br><br> <a href='./logout'> Logout </a>");
		} else {
			out.println("<h3 Style='color:red'>Invalid credential</h3>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}
		out.println("</body>");
		out.println("<html>");
	}// end of doPost()

}// end of class
