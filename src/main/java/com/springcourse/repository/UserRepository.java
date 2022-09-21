package com.springcourse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM user u WHERE email = ?1 AND password = ?2")
	public Optional<User> login(String email, String password);
	
	
//	public Optional<User> getByName(String nome); // Busca um usuáriio pelo nome
//	public Optional<User> getByEmail(String email); // Busca um usuario pelo e-mail
//	public Optional<User> findById(Long id); // Busca um usuário pelo ID
//	public Optional<User> findByAll();  // Busca todos os usuário

}
