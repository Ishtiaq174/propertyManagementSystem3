package com.property.propertyManagementSystem.models;

public class AuthResponse {

	private String jwt;
	
	

    public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
