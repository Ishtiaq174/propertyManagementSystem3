package com.property.propertyManagementSystem.service;

import java.util.List;

import com.property.propertyManagementSystem.models.Property;

public interface PropertyService {

	
	public Property addProperty(Property property);
	
	public List<Property> getAllProperty();
	
	public Property getProperty(Integer id);
	
	public Property updateProperty(Property property, Integer id);
	
	public void removeProperty(Integer id);
	
	public List<Property> userProperty(Integer id);
	
}
