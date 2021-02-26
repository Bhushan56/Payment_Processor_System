package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.beans.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

}
