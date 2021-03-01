package com.project.springboot.dao;

public interface BankDao {

	public boolean checkBankCredentials(String bic,String password);
}
