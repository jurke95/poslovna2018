package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExchangeRate implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String date;
	
	@Column(columnDefinition="CHAR(3)")
	private String numberExchangeRate;
	
	private String startsOn; // date

	@ManyToOne
	@JoinColumn(name="bank_id")
	private Bank bank;
	
	private int number;
	
	public ExchangeRate() {
		// TODO Auto-generated constructor stub
	}

	


	
	public ExchangeRate(String date, String numberExchangeRate, String startsOn, Bank bank,int number) {
		super();
		
		this.date = date;
		this.numberExchangeRate = numberExchangeRate;
		this.startsOn = startsOn;
		this.bank = bank;
		this.number=number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStartsOn(String startsOn) {
		this.startsOn = startsOn;
	}

	public String getNumberExchangeRate() {
		return numberExchangeRate;
	}

	public void setNumberExchangeRate(String numberExchangeRate) {
		this.numberExchangeRate = numberExchangeRate;
	}

	public String getStartsOn() {
		return startsOn;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}





	public int getNumber() {
		return number;
	}





	public void setNumber(int number) {
		this.number = number;
	}

	

	
	
	
	
	
	
	

}
