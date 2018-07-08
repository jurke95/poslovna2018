package com.poslovna.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Individual {

	

	public Individual() {
		
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String jmbg;
	
	private String address;
	
	private String email;
	
	private String phonenumber;
	
	@ManyToMany
	private Set<Bank> bank = new HashSet();

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}

	

	public List<Bank> getBank() {
		List<Bank> listanks = new ArrayList<>(bank);
		if(listanks.size()>0) {
			return listanks;
		}
		return null;
	}

	public void setBank(Set<Bank> bank) {
		this.bank = bank;
	}


	
	
}
