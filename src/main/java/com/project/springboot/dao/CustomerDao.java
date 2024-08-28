package com.project.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;

public interface CustomerDao {

	public UserInfo checkCustomerCredentials(String email,String password);
	
	public void saveTransaction(Transaction transaction);
	
	public List<Transaction> getTransaction(int userId,String status);
	
	public  boolean validateBenificiary( int beneficiaryUserId,String beneficiaryName,String receiverMobileNumber, String bic,String beneficiaryAccountNumber);
}
