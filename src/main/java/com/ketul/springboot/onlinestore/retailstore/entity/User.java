package com.ketul.springboot.onlinestore.retailstore.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String userType;
	private Date registeredDate;

	public User() {
		super();
	}

	public User(String name, String userType, Date registeredDate) {
		super();
		this.name = name;
		this.userType = userType;
		this.registeredDate = registeredDate;
	}

	public User(Long id, String name, String userType, Date registeredDate) {
		super();
		this.id = id;
		this.name = name;
		this.userType = userType;
		this.registeredDate = registeredDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

}
