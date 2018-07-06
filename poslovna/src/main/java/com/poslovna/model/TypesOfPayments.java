package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypesOfPayments implements Serializable{
	
	
	public TypesOfPayments() {
		
	}
	
	public TypesOfPayments(Long id, String code, String nameOfCurrency) {
	
		this.id = id;
		this.code=code;
		this.nameOfCurrency = nameOfCurrency;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(3)") //Ovo treba da bude sifra sa tri broja...ne treba ID
	private String code;
	
	@Column(columnDefinition="VARCHAR(120)")
	private String nameOfCurrency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameOfCurrency() {
		return nameOfCurrency;
	}

	public void setNameOfCurrency(String nameOfCurrency) {
		this.nameOfCurrency = nameOfCurrency;
	}

	
	
	

}
