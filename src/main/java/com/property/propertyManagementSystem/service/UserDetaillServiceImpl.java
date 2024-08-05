package com.property.propertyManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.property.propertyManagementSystem.Repository.UserRepo;
import com.property.propertyManagementSystem.models.Property;
import com.property.propertyManagementSystem.models.User;

@Service
public class UserDetaillServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo repository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByUsername(username);

		return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
				.password(user.getPassword()).roles(user.getRole().split(",")).build();
	}
	
	
	public void registerUser(User user) {
		if (user == null) {
			throw new RuntimeException("invalid user name password");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		repository.save(user);
	}

}
