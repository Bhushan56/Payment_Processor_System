package com.project.springboot.beans;

 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
 

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
	@NotBlank(message = "can not be blank")
	private String name;
	
	@Column(name="address")
	@NotBlank(message = "can not be blank")
	private String address;
	
	@Column(name="mobile_number")
	@NotBlank(message = "can not be blank")
	private String mobileNumber;
	
	@Column(name="Email")
	@NotBlank(message = "can not be blank")
	@Email
	private String email;
	
	@Column(name="Password")
	@NotBlank(message = "can not be blank")
	private String password ;
	
	@Column(name="BIC")
	@NotBlank(message = "can not be blank")
	private String bic ;
	
	@Column(name="Account_number")
	@NotBlank(message = "can not be blank")
	private String accountNumber ;
	
	@Column(name="Amount")
	@NotBlank(message = "can not be blank")
	private double amount ;
	 
    
	 
	// Parameterized constructor
	public UserInfo(int userId, String name, String address, String mobieNumber, String email, String password,
			String bic, String accountNumber, double amount) {
		
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobieNumber;
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
		return mobileNumber;
	}
	public void setMobieNumber(String mobieNumber) {
		this.mobileNumber = mobieNumber;
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
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
}
