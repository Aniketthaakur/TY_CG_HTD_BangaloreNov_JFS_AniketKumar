package com.cap.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//get the query string
	String idval=req.getParameter("id");
	
	//GEt the context param
	  ServletContext context=getServletContext();//getServletContext() present in generic servlet  super class
	  String contextParamval=context.getInitParameter("myContextParam");
	

		//get config param
		ServletConfig config=getServletConfig();
		String configParamval=   config.getInitParameter("myConfigParam");
		
		
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("Employee Id ="+ idval);
	out.println("<br> Name=Omkar");
	out.println("<br> Salary = 84733");
	
	//displaying context param-value
	out.println("<br> <br> Context Param Value ="+contextParamval);
	out.println("<br> <br> Context Param Value ="+configParamval);
	out.println("</body>");
	out.println("</html>");
	
	}//end of doGet()

}// end of class
