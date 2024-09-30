package com.spring.implementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.implementation.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	@Override
	User save(User user);


    public User findByResetPasswordToken(String token);

    public boolean existsByEmail(String email);
}
