package com.revature.training.pms.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.training.pms.service.CustomerService;
import com.revature.training.pms.service.CustomerServiceImpl;
/**
 * Servlet implementation class AuthenticateUser
 */
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static AuthenticateUser authenticateUser = new AuthenticateUser();

	public static AuthenticateUser getInstance() {
		return authenticateUser;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean alreadyVisited = false;
		Cookie allCookies[] = request.getCookies();
		out.println("<html><body style='background-color:orange;'>");
		// authenticate user from a DB ???
		CustomerService customerService = new CustomerServiceImpl();
		if (customerService.validateCustomer(customerId, password)) {

			out.println("<h2>You have logged in at : " + new java.util.Date());

			out.println("Welcome" + customerId);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Transactions.html");
			dispatcher.forward(request, response);
			//

		} else {
			out.println("<h2>You have logged in at : " + new java.util.Date());
			out.println("Sorry customerid or password incorrect " + customerId);
			out.println("<br/><br/><a href=Userlogin.html>Try Again</a>");

		}
		out.println("</body></html>");
	}

}
