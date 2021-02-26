package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.beans.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo,Integer>{

}
