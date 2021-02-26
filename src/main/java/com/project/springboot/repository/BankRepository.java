package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.beans.BankInfo;
import com.project.springboot.beans.Transaction;

public interface BankRepository extends JpaRepository<BankInfo,String> {

}
