package com.ketul.springboot.onlinestore.retailstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.ketul.springboot.onlinestore.retailstore.dao" })
@EntityScan(basePackages = { "com.ketul.springboot.onlinestore.retailstore.entity" })
public class RetailstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailstoreApplication.class, args);
	}

}
