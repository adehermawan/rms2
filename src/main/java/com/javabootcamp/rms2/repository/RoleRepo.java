package com.javabootcamp.rms2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javabootcamp.rms2.model.Role;

@Repository("roleRepo")
public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findByRole(String role);
}
