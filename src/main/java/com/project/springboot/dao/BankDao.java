package com.project.springboot.dao;

import java.util.List;

import com.project.springboot.beans.Transaction;

public interface BankDao {

	public boolean checkBankCredentials(String bic,String password);
	
	public List<Transaction> getPendingTransaction(String bic,String status);
}
