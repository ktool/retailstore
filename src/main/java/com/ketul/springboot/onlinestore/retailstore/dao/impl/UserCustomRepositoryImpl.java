package com.ketul.springboot.onlinestore.retailstore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.util.ObjectUtils;

import com.ketul.springboot.onlinestore.retailstore.dao.UserCustomRepository;
import com.ketul.springboot.onlinestore.retailstore.entity.User;

public class UserCustomRepositoryImpl implements UserCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User findByUserName(String name) {
		List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.name=:name", User.class)
				.setParameter("name", name).getResultList();
		if (!(ObjectUtils.isEmpty(users) && users.isEmpty())) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByUserId(Long id) {
		List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class)
				.setParameter("id", id).getResultList();
		if (!(ObjectUtils.isEmpty(users) && users.isEmpty())) {
			return users.get(0);
		}
		return null;
	}

}
