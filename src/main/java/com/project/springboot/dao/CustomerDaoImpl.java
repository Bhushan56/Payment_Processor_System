package com.project.springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	
}
