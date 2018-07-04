package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Bank implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(columnDefinition="CHAR(3)")
	private String code;
	
	@NotNull
	@Column(columnDefinition="CHAR(10)")
	private String pib;
	
	@NotNull
	@Column(columnDefinition="VARCHAR(120)")
	private String name;
	
	@NotNull
	@Column(columnDefinition="VARCHAR(120)")
	private String address;
	
	@Column(columnDefinition="VARCHAR(128)")
	private String email;
	
	@Column(columnDefinition="VARCHAR(128)")
	private String web;
	
	@Column(columnDefinition="VARCHAR(20)")
	private String phonenumber;
	
	@Column(columnDefinition="VARCHAR(20)")
	private String fax;
	
	private Boolean bank;       // ?????

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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Boolean getBank() {
		return bank;
	}

	public void setBank(Boolean bank) {
		this.bank = bank;
	}
	
	
	
	
	
	
	
	
	
	

}
