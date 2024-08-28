package com.project.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public UserInfo checkCustomerCredentials(String email, String password) {
		
		Session session=entityManager.unwrap(Session.class);
		
		TypedQuery<UserInfo>query=session.createQuery("From UserInfo where email=:email and password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		UserInfo user=(UserInfo)query.getSingleResult();
		
		
		return user;
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		Session session=entityManager.unwrap(Session.class);
		session.save(transaction);
		
	}
	
@Override
public  boolean validateBenificiary(int beneficiaryUserId,String beneficiaryName,String receiverMobileNumber, 
		String bic,String beneficiaryAccountNumber) {
	 //int b_id=Integer.parseInt(beneficiaryUserId);
	 Session session=entityManager.unwrap(Session.class);
	
	TypedQuery<UserInfo>query=session.createQuery("From UserInfo where userId=:beneficiaryUserId");
	query.setParameter("beneficiaryUserId",beneficiaryUserId);
	/*query.setParameter("beneficiaryName",beneficiaryName);
	query.setParameter("receiverMobileNumber",receiverMobileNumber);
	query.setParameter("bic",bic);
	query.setParameter("beneficiaryAccountNumber",beneficiaryAccountNumber);*/
	
	UserInfo user=(UserInfo)query.getSingleResult();
	if(user!=null && user.getName().equals(beneficiaryName) && user.getMobieNumber().equals(receiverMobileNumber) && user.getBic().equals(bic)&& user.getAccountNumber().equals(beneficiaryAccountNumber))
		 return true;
	return false;
	 
}
@Override
public List<Transaction> getTransaction(int userId,String status){
	List<Transaction> approvedTransaction = new ArrayList<>();
	Session session=entityManager.unwrap(Session.class);
	String id= String.valueOf(userId);
	String q="From Transaction where orderingCustomer LIKE "+ "'" + "%" + id +"'" + "and status="+ "'"+ status + "'"+ "order by senderReference desc";
	System.out.print(q);
	TypedQuery<Transaction>query=session.createQuery(q);
	 
	 
	
	approvedTransaction=query.getResultList();
	System.out.print(approvedTransaction.size());
	return  approvedTransaction;
}
}
