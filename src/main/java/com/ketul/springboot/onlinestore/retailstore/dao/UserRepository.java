package com.ketul.springboot.onlinestore.retailstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ketul.springboot.onlinestore.retailstore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
	
}
