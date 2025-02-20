package com.revature.training.pms.service;

import java.util.List;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;

public interface EmployeeService {
	
	public int addEmployee(Employee employee);
	public boolean login(int employeeId,String password);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean deleteCustomer(int customerId);


}
