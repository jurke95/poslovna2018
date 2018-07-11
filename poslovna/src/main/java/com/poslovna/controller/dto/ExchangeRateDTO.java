package com.poslovna.controller.dto;


public class ExchangeRateDTO {

	
	

	
	private String date;
	
	
	private String numberExchangeRate;
	
	private String startsOn; // date

	
	private Long idbank;

	
	public ExchangeRateDTO(){
		
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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


	public void setStartsOn(String startsOn) {
		this.startsOn = startsOn;
	}


	public Long getIdbank() {
		return idbank;
	}


	public void setIdbank(Long idbank) {
		this.idbank = idbank;
	}


	public ExchangeRateDTO(String date, String numberExchangeRate, String startsOn, Long idbank) {
		super();
		this.date = date;
		this.numberExchangeRate = numberExchangeRate;
		this.startsOn = startsOn;
		this.idbank = idbank;
	}
	
	
	
	
	
	
	
	
	
	
	
}
