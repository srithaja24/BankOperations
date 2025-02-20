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
 * Servlet implementation class TransferAmountServlet
 */
public class TransferAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferAmountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		int receiverId = Integer.parseInt(request.getParameter("receiverId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style='background-color:orange;'>");
		
		CustomerService customerService=new CustomerServiceImpl();
		customerService.transferAmount(senderId, receiverId, amount);
		
		out.println("<br/> <br/> <br/><h1 align=center>Amount-:"+" "+amount+" "+"Transferd Successfully");
		out.println("<h2 align=center>From Account No "+senderId+" to Account No "+receiverId);
		out.println("<br/><br/><h2><a href=Deposit.html>Back</a></h2>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
