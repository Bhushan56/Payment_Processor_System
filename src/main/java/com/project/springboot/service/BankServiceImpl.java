package com.project.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.springboot.beans.BankInfo;
import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;
import com.project.springboot.dao.BankDao;

@Service
public class BankServiceImpl implements BankService{

	private BankDao bankDao;
	
	public BankServiceImpl(BankDao bankDao) {
		this.bankDao=bankDao;
	}
	@Override
	public  BankInfo checkBankCredentials(String bic, String password) {
		return bankDao.checkBankCredentials(bic, password);
	}
	@Override
	public List<Transaction> getPendingTransaction(String bic, String status) {
		return bankDao.getPendingTransaction(bic, status);
	}
	@Override
	@Transactional
	public void approveTransaction(int ref_id) {
		 bankDao.approveTransaction(ref_id);
	}
   @Override
   public List<Transaction> getApprovedTransaction(String bic, String status){
	  return bankDao.getApprovedTransaction(bic,status);
   }
   @Override
   @Transactional
   public void  rejectTransaction(int ref_id) {
	   bankDao.rejectTransaction(ref_id);
   }
	@Override
	public List<Transaction> getRejectedTransaction(String bic,String status){
		return bankDao.getRejectedTransaction(bic,status);
	}
    @Override
    @Transactional
	public void payment(String S_bic, double availableBalance,String R_bic, String bankName, double amount) {
		  bankDao.payment(S_bic,availableBalance,R_bic,bankName,amount);	
	}
	
	
	
 
}
