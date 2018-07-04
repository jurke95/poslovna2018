package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account implements Serializable {
	
	
	public Account() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	@Column(columnDefinition="VARCHAR(18)")
	private String accountnum;
	
	private Date openingdate;
	
	private Boolean isValid;

	@ManyToOne
	private Bank bank;
	
	@ManyToOne
	private Currency currency;
	
	@ManyToOne
	private Individual individual;
	
	@ManyToOne  
	private LegalEntity legalEntity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}

	public Date getOpeningdate() {
		return openingdate;
	}

	public void setOpeningdate(Date openingdate) {
		this.openingdate = openingdate;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}
	
	
	

}
