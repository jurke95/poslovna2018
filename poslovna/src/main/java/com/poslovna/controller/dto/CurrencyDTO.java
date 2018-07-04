package com.poslovna.controller.dto;

public class CurrencyDTO {

	
	private String password;
	
	private String name;
	
	private boolean domicile;
	
	private String country;
	
	public CurrencyDTO(){
		
	}

	public CurrencyDTO(String password, String name, boolean domicile, String country) {
		super();
		this.password = password;
		this.name = name;
		this.domicile = domicile;
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDomicile() {
		return domicile;
	}

	public void setDomicile(boolean domicile) {
		this.domicile = domicile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
	
}
