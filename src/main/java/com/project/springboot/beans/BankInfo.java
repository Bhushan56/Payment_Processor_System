package com.project.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *BankInfo;
BIC=String(bank Code)
BankName=String;
BankAddress=String;
Password=String;
Country=String;

 * 
 */
@Entity
@Table(name= "BankInfo")
public class BankInfo {

	@Id
	@Column(name = "BIC",unique=true,columnDefinition="VARCHAR(64)")
	private String bic ;
	private String bankName ;
	private String bankAddress ;
	private String password ;
	private String country ;
	
	//parameterized constructor 
	public BankInfo(String bic, String bankName, String bankAddress, String password, String country) {
		super();
		this.bic = bic;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.password = password;
		this.country = country;
	}

	// default constructor
	public BankInfo() {
	
	}
	
	//getter Setter 

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
	
}
