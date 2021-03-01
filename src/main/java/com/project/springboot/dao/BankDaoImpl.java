package com.project.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.beans.BankInfo;
import com.project.springboot.beans.Transaction;


@Repository
public class BankDaoImpl implements BankDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public BankDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public boolean checkBankCredentials(String bic, String password) {
		boolean result=false;
		
		Session session=entityManager.unwrap(Session.class);
		
		TypedQuery<BankInfo>query=session.createQuery("From BankInfo where bic=:bic and password=:password");
		query.setParameter("bic", bic);
		query.setParameter("password", password);
		
		BankInfo bank=query.getSingleResult();
		if(bank!=null) {
			result=true;
			
		}
		return result;
	}

	@Override
	public List<Transaction> getPendingTransaction(String bic, String status) {
		List<Transaction>pendingTransaction=new ArrayList<>();
		Session session=entityManager.unwrap(Session.class);
		
		TypedQuery<Transaction>query=session.createQuery("From Transaction where sending_institution=:sending_institution and status=:status");
		query.setParameter("sending_institution", bic);
		query.setParameter("status",status);
		
		pendingTransaction=query.getResultList();
		
		return pendingTransaction;
		
	}

	
}
