package com.project.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.beans.Transaction;
import com.project.springboot.dao.BankDao;

@Service
public class BankServiceImpl implements BankService{

	private BankDao bankDao;
	
	public BankServiceImpl(BankDao bankDao) {
		this.bankDao=bankDao;
	}
	@Override
	public boolean checkBankCredentials(String bic, String password) {
		return bankDao.checkBankCredentials(bic, password);
	}
	@Override
	public List<Transaction> getPendingTransaction(String bic, String status) {
		return bankDao.getPendingTransaction(bic, status);
	}

}
