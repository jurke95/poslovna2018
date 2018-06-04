package com.poslovna.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeRate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private Date date;
	
	@Column(columnDefinition="NUMBER(3)")
	private Long numberExchangeRate;
	
	private Date startsOn;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public Long getNumberExchangeRate() {
		return numberExchangeRate;
	}

	public void setNumberExchangeRate(Long numberExchangeRate) {
		this.numberExchangeRate = numberExchangeRate;
	}

	public Date getStartsOn() {
		return startsOn;
	}

	public void setStartsOn(Date startsOn) {
		this.startsOn = startsOn;
	}
	
	
	
	
	
	

}
