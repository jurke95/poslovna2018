package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypesOfPayments implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(3)") //Ovo treba da bude sifra sa tri broja...ne treba ID
	private String Code;
	
	@Column(columnDefinition="VARCHAR(120)")
	private String nameOfCurrency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getNameOfCurrency() {
		return nameOfCurrency;
	}

	public void setNameOfCurrency(String nameOfCurrency) {
		this.nameOfCurrency = nameOfCurrency;
	}

	
	
	

}
