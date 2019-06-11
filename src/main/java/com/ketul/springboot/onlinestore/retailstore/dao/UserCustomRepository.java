package com.ketul.springboot.onlinestore.retailstore.dao;

import org.springframework.stereotype.Repository;

import com.ketul.springboot.onlinestore.retailstore.entity.User;

@Repository
public interface UserCustomRepository {

	User findByUserName(String name);

	User findByUserId(Long id);
}
