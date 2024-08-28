package com.project.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author geete_p
 *20 Sender's Reference nor-auto;
50a: ordering customer=userID,accountNo,Name;
51A Sending Institution=BIC, Bank Name;
57a: Account With Institution=Recivers BIC and Bank  Name
59a Beneficiary Customer=Recivers userID,accountNo,Name

32A: Date =date
Amount=double
Status=String=p/r/a

 */

@Entity
@Table(name= "Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int senderReference ;
	
	 
	private String orderingCustomer ;
	
	 
	private String sendingInstitution;
	
	 
	private String accountWithInstitution ;
	 
	private String beneficiaryCustomer ;
	
 
	private String date ;
	
	 
	private Double amount ;
	
	 
	private String Status ;
	
	public Transaction(int senderReference, String orderingCustomer, String sendingInstitution,
			String accountWithInstitution, String beneficiaryCustomer, String date, Double amount, String status) {
		super();
		this.senderReference = senderReference;
		this.orderingCustomer = orderingCustomer;
		this.sendingInstitution = sendingInstitution;
		this.accountWithInstitution = accountWithInstitution;
		this.beneficiaryCustomer = beneficiaryCustomer;
		this.date = date;
		this.amount = amount;
		Status = status;
	}
	
	public Transaction() {
		
	}
	
	public int getSenderReference() {
		return senderReference;
	}
	public void setSenderReference(int senderReference) {
		this.senderReference = senderReference;
	}
	public String getOrderingCustomer() {
		return orderingCustomer;
	}
	public void setOrderingCustomer(String orderingCustomer) {
		this.orderingCustomer = orderingCustomer;
	}
	public String getSendingInstitution() {
		return sendingInstitution;
	}
	public void setSendingInstitution(String sendingInstitution) {
		this.sendingInstitution = sendingInstitution;
	}
	public String getAccountWithInstitution() {
		return accountWithInstitution;
	}
	public void setAccountWithInstitution(String accountWithInstitution) {
		this.accountWithInstitution = accountWithInstitution;
	}
	public String getBeneficiaryCustomer() {
		return beneficiaryCustomer;
	}
	public void setBeneficiaryCustomer(String beneficiaryCustomer) {
		this.beneficiaryCustomer = beneficiaryCustomer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
