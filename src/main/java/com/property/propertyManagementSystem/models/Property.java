package com.property.propertyManagementSystem.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pro-Table")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String address;
    private BigDecimal pricePerNight;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private boolean isAvailable;
    private boolean drinkAllowed;
    private boolean petAllowed;
    private int maxCheckoutTimeInNights;
    private BigDecimal extraCharges;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(BigDecimal pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public int getNumberOfBathrooms() {
		return numberOfBathrooms;
	}

	public void setNumberOfBathrooms(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isDrinkAllowed() {
		return drinkAllowed;
	}

	public void setDrinkAllowed(boolean drinkAllowed) {
		this.drinkAllowed = drinkAllowed;
	}

	public boolean isPetAllowed() {
		return petAllowed;
	}

	public void setPetAllowed(boolean petAllowed) {
		this.petAllowed = petAllowed;
	}

	public int getMaxCheckoutTimeInNights() {
		return maxCheckoutTimeInNights;
	}

	public void setMaxCheckoutTimeInNights(int maxCheckoutTimeInNights) {
		this.maxCheckoutTimeInNights = maxCheckoutTimeInNights;
	}

	public BigDecimal getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(BigDecimal extraCharges) {
		this.extraCharges = extraCharges;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Property(Long id, String name, String description, String address, BigDecimal pricePerNight,
			int numberOfBedrooms, int numberOfBathrooms, boolean isAvailable, boolean drinkAllowed, boolean petAllowed,
			int maxCheckoutTimeInNights, BigDecimal extraCharges, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.pricePerNight = pricePerNight;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.isAvailable = isAvailable;
		this.drinkAllowed = drinkAllowed;
		this.petAllowed = petAllowed;
		this.maxCheckoutTimeInNights = maxCheckoutTimeInNights;
		this.extraCharges = extraCharges;
		this.owner = owner;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

