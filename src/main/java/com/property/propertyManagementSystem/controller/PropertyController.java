package com.property.propertyManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.property.propertyManagementSystem.exception.ResourceNotFoundException;
import com.property.propertyManagementSystem.models.Property;
import com.property.propertyManagementSystem.service.PropertyService;
import com.property.propertyManagementSystem.service.PropertyServiceImpl;

@RestController
@RequestMapping("/")
public class PropertyController {

	@Autowired
	private PropertyServiceImpl propertyService;
	
	@GetMapping("/api/properties")
	public ResponseEntity<List<Property>> getAllProperty(){
		List<Property> properties=propertyService.getAllProperty();
		return ResponseEntity.ok(properties);
	}
	
	@GetMapping("/api/properties/{id}")
	public ResponseEntity<Property> getProperty(@PathVariable Integer id){
		Property property=propertyService.getProperty(id) ;
		if(property == null) throw new ResourceNotFoundException("Property not found");
		return ResponseEntity.ok(property);
	}
	
	@PostMapping("/api/properties")
	public ResponseEntity<Property> createProperty(@RequestBody Property property){
		Property emp = propertyService.addProperty(property) ;
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping("/api/properties/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		propertyService.removeProperty(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/api/properties/{id}")
	public ResponseEntity<Property> editProperty(@RequestBody Property property, @PathVariable Integer id){
		Property prop=propertyService.updateProperty(property, id);
		return ResponseEntity.ok(prop);
	}
	
	@GetMapping("/api/users/{userId}/properties")
	public ResponseEntity<List<Property>> getUserProperty(@PathVariable Integer userId){
		List<Property> property=propertyService.userProperty(userId) ;
		return ResponseEntity.ok(property);
	}
	
}
