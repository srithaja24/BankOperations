package com.revature.pms.dao.impl;

import java.util.List;




import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.model.Customer;



public class CustomerDAOImpl implements CustomerDAO {

	private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	
	AnnotationConfiguration configuration=new AnnotationConfiguration().configure();
	SessionFactory factory=configuration.buildSessionFactory();
	Session session=factory.openSession();

	
	public int addCustomer(Customer customer) {
		Transaction transaction=session.beginTransaction();
		session.save(customer);
		int customerId = customer.getCustomerId();
		logger.info("customer added");
		transaction.commit();
		return customerId;
		
	}
	public boolean deleteCustomer(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);
		transaction.commit();
		return true;
	}
	public boolean updateCustomer(Customer customer) {
		
		Transaction transaction = session.beginTransaction();
		session.update(customer);
		transaction.commit();
		return true;
	}
	public Customer getCustomerById(int customerId) {
			Customer customer =(Customer) session.load(Customer.class, customerId);
			return customer;
	}
	public List<Customer> getCustomers() {
		Query query = (Query) session.createQuery("com.revature.pms.model.Customer");
		List<Customer> customers = query.list();
		System.out.println(customers);
		return customers;
	}
	public boolean isCustomerExists(int customerId) {
		
		Customer customer = (Customer) session.get(Customer.class, customerId);
		if(customer==null)
		{
			return false;
		}else
		{
			return true;
		}
		
	}
	public int viewBalance(int customerId) {
		Query query =session.createQuery("select balance from com.revature.pms.model.Customer where customerId = "+customerId);
		int balance = (Integer) query.list().get(0);
		logger.info("The balance for :"+customerId + " is "+balance);
		return balance;
	}
	public int deposit(int amount,int customerId) {
		
		Customer customer=(Customer) session.load(Customer.class,customerId);
		
		Transaction transaction = session.beginTransaction();	
		int balance= customer.getBalance();
		balance = balance + amount;
		customer.setBalance(balance);
		logger.info("Amount"+amount+"deposited");
		transaction.commit();
		return balance;
	}
	public int withdraw(int amount,int customerId) {
	
		Customer customer=(Customer) session.load(Customer.class,customerId);
		
		Transaction transaction = session.beginTransaction();	
		int balance= customer.getBalance();
		balance = balance - amount;
		customer.setBalance(balance);
		logger.info("Amount"+amount+"withdrawl");
		transaction.commit();
		return balance;
	}
	public int transferAmount(int senderId, int receiverId, int amount) {
		Customer customer=(Customer) session.load(Customer.class,senderId);
		Customer customer1=(Customer) session.load(Customer.class,receiverId);
		Transaction transaction=session.beginTransaction();
		logger.info("transfer successfull");
		int balance=customer.getBalance();
		balance=balance-amount;
		customer.setBalance(balance);
		int balance1=customer1.getBalance();
		balance1=balance1+amount;
		customer1.setBalance(balance1);
		transaction.commit();
		return balance;
	}
	public boolean validateCustomer(int customerId, String password) {
		
		 Query query = session.createQuery("from Customer where customerId = "+customerId+ " and password = '"+password + "'");
	        if (query.list().size() == 0)
	        {
	          return false;
	        }
	        else
	        {
	          return true;
	        }
		
	}
	
	
	
}
