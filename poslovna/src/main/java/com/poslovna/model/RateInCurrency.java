package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class RateInCurrency implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String buying;
	
	@Column
	private String average;
	
	@Column
	private String selling;
	
	
	@ManyToOne
	private Currency primary;
	
	@ManyToOne
	private Currency changeto;
	
	@ManyToOne
	private ExchangeRate exchangeRate;
	
	public RateInCurrency(){
		
	}



	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	


	public String getBuying() {
		return buying;
	}





	public void setBuying(String buying) {
		this.buying = buying;
	}





	public String getAverage() {
		return average;
	}





	public void setAverage(String average) {
		this.average = average;
	}





	public String getSelling() {
		return selling;
	}





	public void setSelling(String selling) {
		this.selling = selling;
	}





	public Currency getPrimary() {
		return primary;
	}

	public void setPrimary(Currency primary) {
		this.primary = primary;
	}

	public Currency getChangeto() {
		return changeto;
	}

	public void setChangeto(Currency changeto) {
		this.changeto = changeto;
	}

	public ExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	
	

}
