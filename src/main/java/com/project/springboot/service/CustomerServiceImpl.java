package com.project.springboot.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;
import com.project.springboot.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;
	
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao=customerDao;
	}

	@Override
	public UserInfo checkCustomerCredentials(String email, String password) {
		return customerDao.checkCustomerCredentials(email, password);
		
	}

	@Override
	@Transactional
	public void saveTransaction(Transaction transaction) {
		 customerDao.saveTransaction(transaction);
		
	}
	

}
