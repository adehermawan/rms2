package com.javabootcamp.rms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javabootcamp.rms2.model.User;

@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
