package com.revature.training.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.pms.model.Employee;
import com.revature.training.pms.service.EmployeeService;
import com.revature.training.pms.service.EmployeeServiceImpl;


/**
 * Servlet implementation class EmployeeSignUpServlet
 */
public class EmployeeSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("EmployeeSignUpServlet");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSignUpServlet() {
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

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName = request.getParameter("employeeName");
		String password = request.getParameter("password");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailId = request.getParameter("emailId");
		
	
		
		Employee employee = new Employee(0, employeeName, password,mobileNumber, emailId, new Date());
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		int employeeId= employeeService.addEmployee(employee);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style='background-color:orange;'>");
		response.getWriter().println("<br/><br/><br/><h2 align=center>"+employeeName + ", congratulations you have successfully registerd as a Bank employee");
        
		out.println("<h3 align=center>This is your Employee ID for future Logins:"+" "+employeeId);
		out.println("<h4 align=center> please Login to Start your work "+"  "+"<a href=EmployeeLogin.html>Login</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

