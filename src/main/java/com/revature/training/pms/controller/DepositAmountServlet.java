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
 * Servlet implementation class DepositAmountServlet
 */
public class DepositAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositAmountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int  customerId = Integer.parseInt(request.getParameter("customerId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style='background-color:orange;'>");
		
		CustomerService customerService=new CustomerServiceImpl();
		if(customerService.deposit(amount, customerId)!=0)
		{
		 
	     out.println("<h2 align=center>Cogratulations"+" "+customerId);
	     out.println("<h3 align=center>Amount:"+"  "+amount+" "+"Successfully Deposited to you Account");
		}
		else
		{
			out.println("<br/><br/><br/><h2 align=center>Customer with"+" "+customerId+" does not exist");
		}	
		
		out.println("<br/><br/><h2><a href=Deposit.html>Go Back</a></h2>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
