package com.property.propertyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.property.propertyManagementSystem.models.Property;
import com.property.propertyManagementSystem.models.User;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer>{
	List<Property> findByOwner(User user);
}
