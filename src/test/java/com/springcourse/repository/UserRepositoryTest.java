package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Order(1)
	@Test
	public void saveTest() {
		User user = new User(null, "Kevin", "kevin.wingi@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L);
	}
	
	@Order(2)
	@Test
	public void uptadeTest() {
		User user = new User(1L, "Kevin Wingi", "kevin.wingi@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L);
	}
	
	@Order(3)
	@Test
	public void getTest() {
		Optional<User> result =  userRepository.findById(1L);
		User user = result.get();
		
		assertThat(user.getPassword()).isEqualTo("123");
	}
	
	@Order(4)
	@Test
	public void listTest() {
		List<User> users = userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(1);
	}
	
	@Order(5)
	@Test
	public void loginTest() {
		Optional<User> result =  userRepository.login("kevin.wingi@gmail.com", "123");
		User loggeUser = result.get();
		
		assertThat(loggeUser.getId()).isEqualTo(1L);
	}
}
