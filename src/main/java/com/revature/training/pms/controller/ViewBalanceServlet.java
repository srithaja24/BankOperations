package com.revature.training.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.training.pms.service.CustomerService;
import com.revature.training.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class ViewBalanceServlet
 */
public class ViewBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password=request.getParameter("password");
		
		 response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
	     out.println("<body style='background-color:orange;'>");
	     
	     CustomerService customerService=new CustomerServiceImpl();
	    
	     int balance=customerService.viewBalance(customerId);
	     if(customerService.viewBalance(customerId)!=0)
	     {
	     
	     out.println("<h2 align=center>Welcome"+" "+customerId);
	     out.println("<h3 align=center>Your Account Balance is:"+"  "+balance);
	     }
	     else
	     {
	    	 out.println("<br/><br/><br/><h2 align=center>Please enter correct ID or Password");
	     }
	     out.println("<h2><a href=ViewBalance.html> Go Back</a></h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
