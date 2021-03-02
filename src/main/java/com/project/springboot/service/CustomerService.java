package com.project.springboot.service;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;

public interface CustomerService {

	public UserInfo checkCustomerCredentials(String email,String password);
	
	public void saveTransaction(Transaction transaction);
}
