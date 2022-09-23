package com.springcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.User;
import com.springcourse.repository.UserRepository;
import com.springcourse.service.util.HashUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	public User updateUser(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User updateUser = userRepository.save(user);
		return updateUser;
	}

	public User getUserId(Long id) {
		Optional<User> getUser = userRepository.findById(id);
		return getUser.get();
	}
	
	public List<User> listUser(){
		List<User> listUser = userRepository.findAll();
		return listUser;
	}

	public User loginUser(String email, String password) {	
		password = HashUtil.getSecureHash(password);

		Optional<User> login = userRepository.login(email, password);
		return login.get();
	}

}
