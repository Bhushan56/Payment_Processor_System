package com.project.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author geete_p
 *Userid=Integer(auto);
Password=string;
BIC=String(foreign key);
Accountnor=int;
Amount=double;
Name=string;
Address;
Mobile=string;
Email=string;

 */
@Entity
@Table(name= "UsersInfo")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId ;
	
	@Column(name="Name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="Mobile_Number")
	private String mobieNumber;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password ;
	@Column(name="BIC")
	private String bic ;
	@Column(name="AccountNumber")
	private int accountNumber ;
	@Column(name="Amount")
	private double amount ;
	
	// Parameterized constructor
	public UserInfo(int userId, String name, String address, String mobieNumber, String email, String password,
			String bic, int accountNumber, double amount) {
		
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.mobieNumber = mobieNumber;
		this.email = email;
		this.password = password;
		this.bic = bic;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	
	//default constructor
	
	public UserInfo() {
	}



// getter and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobieNumber() {
		return mobieNumber;
	}
	public void setMobieNumber(String mobieNumber) {
		this.mobieNumber = mobieNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
}
