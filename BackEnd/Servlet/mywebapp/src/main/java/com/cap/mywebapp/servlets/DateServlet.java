package com.cap.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Current System Date & Time
		Date date=new Date();//date class present inside util.date

		//GEt the context param
		ServletContext context=req.getServletContext();// here this is () present inside req 
		String contextParamval=context.getInitParameter("myContextParam");

		//get config param
		ServletConfig config=getServletConfig();//but here this () is not present inside req 
		String configParamval=   config.getInitParameter("myConfigParam");



		resp.setContentType("text/html");//resp is reference for  HttpServletResponse which get response in browser
		resp.setHeader("refresh", "1"); // refresh in every one sec automatically in browser header mean in header menu


		PrintWriter out=resp.getWriter();//print and println are present to print content
		out.print("<html>");//way to write in browser cz browser stood only html
		out.print("<h2>Current System Date & Time -<br>"+date+"</h2>");

		//displaying context param-value & config -param value
		out.println("<br> <br> Context Param Value ="+contextParamval);
		out.println("<br> <br> Context Param Value ="+configParamval);
		out.print("</html>");


	}

}// end of class
