package com.cap.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//String url="http://www.youtube.com";// for here http is mandatory cz if u dont give http then it think tht it is an internal resource
		String url="./currentDate";//it is internal resouces that no need of http here and ./ means current parent i.e(http://localhost:8080/mywebapp) whole thing and also it is called relative path
		String url1="http://localhost:8080/mywebapp/currentDate";// absolute path
		resp.sendRedirect(url);// sendRedirect() is used to redirect the page into other req page 
	}//end of do get()

}//end of class
