package com.revature.pms.dao;

import java.util.List;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;

public interface EmployeeDAO {
	//crud operations
	public int addEmployee(Employee employee);
	public boolean login(int employeeId,String password);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean deleteCustomer(int customerId);
	

}
