package com.revature.training.pms.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.training.pms.service.EmployeeService;
import com.revature.training.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ViewAllCustomerServlet
 */
public class ViewAllCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		List<Customer>customer=employeeService.getCustomers();
		
		HttpSession session=request.getSession();
		session.setAttribute("allCustomer",customer);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("ViewAllCustomer.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
