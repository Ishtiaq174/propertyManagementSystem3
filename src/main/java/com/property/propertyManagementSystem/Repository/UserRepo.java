package com.property.propertyManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.property.propertyManagementSystem.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUsername(String myUserRepo);
}
