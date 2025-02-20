package com.revature.training.pms.service;

import java.util.List;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.dao.EmployeeDAO;
import com.revature.pms.dao.impl.CustomerDAOImpl;
import com.revature.pms.dao.impl.EmployeeDAOImpl;
import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}


	public boolean login(int employeeId, String password) {
		// TODO Auto-generated method stub
		return employeeDAO.login(employeeId, password);
	}

	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return employeeDAO.getCustomerById(customerId);
	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return employeeDAO.getCustomers();
	}

	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteCustomer(customerId);
	}
	
}
