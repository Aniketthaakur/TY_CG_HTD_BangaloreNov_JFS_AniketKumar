package com.cap.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="./currentDate";
	 // for forward request we don't have any method so we have to create method using interface
	 RequestDispatcher dispatcher= req.getRequestDispatcher(url);
	 dispatcher.forward(req, resp);
		
		
	}//end of do get()

}//end of class
