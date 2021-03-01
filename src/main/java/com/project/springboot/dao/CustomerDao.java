package com.project.springboot.dao;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;

public interface CustomerDao {

	public UserInfo checkCustomerCredentials(String email,String password);
	
	public void saveTransaction(Transaction transaction);
}
