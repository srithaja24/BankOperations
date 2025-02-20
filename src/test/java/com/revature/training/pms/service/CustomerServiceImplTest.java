package com.revature.training.pms.service;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerServiceImplTest {
	
	CustomerService customerservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerservice=new CustomerServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		customerservice =null;
	}

	@Test
	public void testTransferAmount(){
		
		int senderId = 2;
		int receiverId=7;
		int amount=1000;
		assertEquals(true,customerservice.transferAmount(senderId, receiverId, amount));
		
	}

}
