package com.property.propertyManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.propertyManagementSystem.Repository.PropertyRepo;
import com.property.propertyManagementSystem.Repository.UserRepo;
import com.property.propertyManagementSystem.exception.ResourceNotFoundException;
import com.property.propertyManagementSystem.models.Property;
import com.property.propertyManagementSystem.models.User;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	private PropertyRepo propertyRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Property addProperty(Property property) {
		
		return propertyRepo.save(property);
	}

	@Override
	public List<Property> getAllProperty() {
		
		return propertyRepo.findAll();
	}

	@Override
	public Property getProperty(Integer id) throws RuntimeException {
		
		if(propertyRepo.findById(id)==null) throw new ResourceNotFoundException("Property not found");
		else
//		Optional<User> user = userRepo.findById(id);
//        return user.get().orElseThrow(() -> new ResourceNotFoundException("Property not found"));
 
		return propertyRepo.findById(id).get();
	}

	@Override
	public Property updateProperty(Property property, Integer id) {
		if(propertyRepo.findById(id).get()==null) throw new ResourceNotFoundException("Property not found");
		else {
			Property oldProperty = propertyRepo.findById(id).get();
			oldProperty.setName(property.getName());
			oldProperty.setDescription(property.getDescription());
			oldProperty.setAddress(property.getAddress());
			oldProperty.setPricePerNight(property.getPricePerNight());
			oldProperty.setNumberOfBedrooms(property.getNumberOfBedrooms());
			oldProperty.setNumberOfBathrooms(property.getNumberOfBathrooms());
			oldProperty.setAvailable(property.isAvailable());
			oldProperty.setDrinkAllowed(property.isDrinkAllowed());
			oldProperty.setPetAllowed(property.isPetAllowed());
			oldProperty.setMaxCheckoutTimeInNights(property.getMaxCheckoutTimeInNights());
			oldProperty.setExtraCharges(property.getExtraCharges());
			oldProperty.setOwner(property.getOwner());
			return propertyRepo.save(oldProperty);
		}
		
		
	}

	@Override
	public void removeProperty(Integer id) {
		if(propertyRepo.findById(id).get()==null) throw new ResourceNotFoundException("Property not found");
		else
		propertyRepo.deleteById(id);
		
	}

	@Override
	public List<Property> userProperty(Integer id) {
		User user = userRepo.findById(id).get();
		return propertyRepo.findByOwner(user);
	}

}
