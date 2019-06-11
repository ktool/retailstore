package com.ketul.springboot.onlinestore.retailstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ketul.springboot.onlinestore.retailstore.dao.UserRepository;
import com.ketul.springboot.onlinestore.retailstore.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void whenFindByName_thenReturnEmployee() {
	
		// given
		User user = new User("Ketul", "AFFILITE", new Date());
		entityManager.persist(user);
		entityManager.flush();

		// when
		User found = userRepository.findByUserName("Ketul");

		// then
		assertThat(found.getName()).isEqualTo(user.getName());
	}
}
