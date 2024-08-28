package com.project.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.beans.BankInfo;
import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;


@Repository
public class BankDaoImpl implements BankDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public BankDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public BankInfo checkBankCredentials(String bic, String password) {
		 
		
		Session session=entityManager.unwrap(Session.class);
		
		TypedQuery<BankInfo>query=session.createQuery("From BankInfo where bic=:bic and password=:password");
		query.setParameter("bic", bic);
		query.setParameter("password", password);
		
		BankInfo bank= (BankInfo)query.getSingleResult();
		return bank;
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
	@Transactional
	 void sub(int CustomerUid,double amount) {
		 Session session=entityManager.unwrap(Session.class);
		 TypedQuery<UserInfo>q1=session.createQuery("from UserInfo where userId=:CustomerUid");
		 q1.setParameter("CustomerUid",CustomerUid);
		 UserInfo Info1=q1.getSingleResult();
		 
		 Double amt= Info1.getAmount()-amount;
		 
		 TypedQuery<UserInfo>q3=session.createQuery("update UserInfo set amount=:amt  where userId=:CustomerUid");
		 q3.setParameter("amt",amt);
		 q3.setParameter("CustomerUid",CustomerUid);
		 q3.executeUpdate();
	 }
	@Transactional
	 void add(int BeneficiaryUid,double amount) {
		 Session session=entityManager.unwrap(Session.class);
		 TypedQuery<UserInfo>q1=session.createQuery("from UserInfo where userId=:BeneficiaryUid");
		 q1.setParameter("BeneficiaryUid",BeneficiaryUid);
		 UserInfo Info1=q1.getSingleResult();
		 
		 Double amt=amount+Info1.getAmount();
		 
		 TypedQuery<UserInfo>q3=session.createQuery("update UserInfo set amount=:amt where userId=:BeneficiaryUid");
		 q3.setParameter("amt",amt);
		 q3.setParameter("BeneficiaryUid",BeneficiaryUid);
		 q3.executeUpdate();
	 }
	
   @Override
   public void approveTransaction(int ref_id) {
	   Session session=entityManager.unwrap(Session.class);
	   TypedQuery<Transaction>query=session.createQuery("update Transaction set status=:status where sender_reference=:sender_reference");
		query.setParameter("status","Successful");
		query.setParameter("sender_reference",ref_id);
		query.executeUpdate();
		TypedQuery<Transaction>q1=session.createQuery("from Transaction where sender_reference=:sender_reference");
		q1.setParameter("sender_reference",ref_id);
		Transaction Info=q1.getSingleResult();
		 int BeneficiaryUid=Integer.parseInt(Info.getBeneficiaryCustomer().split(",")[2]);
		 int CustomerUid=Integer.parseInt(Info.getOrderingCustomer().split(",")[2]);
		 double amount=Info.getAmount();
		 add(BeneficiaryUid,amount);
		 sub(CustomerUid,amount);
		 
			 
   }
 
 @Override
 public List<Transaction> getApprovedTransaction(String bic, String status){
	List<Transaction>approvedTransaction = new ArrayList<>();
	Session session=entityManager.unwrap(Session.class);
	
	TypedQuery<Transaction>query=session.createQuery("From Transaction where sending_institution=:sending_institution and status=:status");
	query.setParameter("sending_institution", bic);
	query.setParameter("status",status);
	
	 approvedTransaction=query.getResultList();
	
	return  approvedTransaction;
	
}

 
@Override
public void rejectTransaction(int ref_id) {
	   Session session=entityManager.unwrap(Session.class);
	   TypedQuery<Transaction>query=session.createQuery("update Transaction set status=:status where sender_reference=:sender_reference");
		query.setParameter("status","Rejected");
		query.setParameter("sender_reference",ref_id);
		query.executeUpdate();
		 			 
}
 
@Override
public List<Transaction> getRejectedTransaction(String bic, String status){
	List<Transaction> rejectedTransaction = new ArrayList<>();
	Session session=entityManager.unwrap(Session.class);
	
	TypedQuery<Transaction>query=session.createQuery("From Transaction where sending_institution=:sending_institution and status=:status");
	query.setParameter("sending_institution", bic);
	query.setParameter("status",status);
	
	 rejectedTransaction=query.getResultList();
	
	return  rejectedTransaction;
	
}
 
void updateBalance(String bic,double amount,double availableBalance) {
	Session session=entityManager.unwrap(Session.class);
	TypedQuery<BankInfo>query=session.createQuery("update BankInfo set balance=:amount where bic=:bic");
	query.setParameter("amount",availableBalance+amount);
	query.setParameter("bic",bic);
	query.executeUpdate();
	System.out.print("2");
}
 
void addBalance(String bic,double amount) {
	Session session=entityManager.unwrap(Session.class);
	TypedQuery<BankInfo>query=session.createQuery("From BankInfo where bic=:bic");
	query.setParameter("bic",bic);
	BankInfo bank=(BankInfo)query.getSingleResult();
	System.out.print(bank.getBalance());
	updateBalance(bic,amount,bank.getBalance());
	 
}
@Override
public void payment(String S_bic,double availableBalance ,String R_bic, String bankName, double amount) {
	Session session=entityManager.unwrap(Session.class);
	TypedQuery<BankInfo>query=session.createQuery("update BankInfo set balance=:amount where bic=:bic");
	query.setParameter("amount",availableBalance-amount);
	query.setParameter("bic",S_bic);
	query.executeUpdate();
	System.out.print("1");
	addBalance(R_bic,amount);
	 
	 
	 
}


}
