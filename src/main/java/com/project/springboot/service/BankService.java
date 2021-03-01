package com.project.springboot.service;

import java.util.List;

import com.project.springboot.beans.Transaction;

public interface BankService {

	public boolean checkBankCredentials(String bic,String password);
	
	public List<Transaction> getPendingTransaction(String bic,String status);
}
