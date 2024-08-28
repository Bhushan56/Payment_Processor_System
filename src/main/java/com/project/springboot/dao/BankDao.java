package com.project.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.beans.BankInfo;
import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;

public interface BankDao {

	public BankInfo checkBankCredentials(String bic,String password);
	
	public List<Transaction> getPendingTransaction(String bic,String status);
	
	public void approveTransaction(int ref_id);
	
	public List<Transaction> getApprovedTransaction(String bic, String status);
	
	public void rejectTransaction(int ref_id);
	
	public List<Transaction> getRejectedTransaction(String bic, String status);
	
	public void payment(String S_bic,double availableBalance ,String R_bic,String bankName,double amount);
//	public void register(UserInfo userInfo);
	
}
