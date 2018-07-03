package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Currency implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	
	@Column(name="password",columnDefinition="CHAR(3)")
	private String password;
	
	@Column(columnDefinition="VARCHAR(30)")
	private String name;
	
	private Boolean domicile;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	
	

	public Currency(String password, String name, Boolean domicile, Country country) {
		super();
		this.password = password;
		this.name = name;
		this.domicile = domicile;
		this.country = country;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public Boolean getDomicile() {
		return domicile;
	}

	public void setDomicile(Boolean domicile) {
		this.domicile = domicile;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	

}
