package com.revature.training.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.training.pms.service.EmployeeService;
import com.revature.training.pms.service.EmployeeServiceImpl;


/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeId=Integer.parseInt(request.getParameter("employeeid"));
	     String password=request.getParameter("password");
	     
	     response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
	     out.println("<body style='background-color:orange;'>");
	     
	     EmployeeService employeeService=new EmployeeServiceImpl();
	     if(employeeService.login(employeeId, password))
	     {
	    	 RequestDispatcher dispatcher=request.getRequestDispatcher("EmployeeHome.html");
	    	 dispatcher.forward(request, response);
	     }
	     else {
	    	 out.println("<a href=EmployeeLogin.html>Back</a>");
	    	 out.println("<br/><br/><br/><h3 align=center>Please enter correct employeeId and Password");
	     }
	}

}
