package com.project.springboot.service;

import java.util.List;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;

public interface CustomerService {

	public UserInfo checkCustomerCredentials(String email,String password);
	
	public void saveTransaction(Transaction transaction);
	
	public List<Transaction> getTransaction(int userId,String status);
	
	public boolean validateBenificiary(int beneficiaryUserId,String beneficiaryName,String receiverMobileNumber, String bic,String beneficiaryAccountNumber);
}
