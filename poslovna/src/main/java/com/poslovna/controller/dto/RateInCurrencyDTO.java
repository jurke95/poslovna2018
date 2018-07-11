package com.poslovna.controller.dto;



public class RateInCurrencyDTO {
	
	
	private Long exchangerateid;
	
	private String buying;

	private String average;
	
	
	private String selling;
	
	
	
	private String primary;
	
	
	private String changeto;
	
	
	public RateInCurrencyDTO(){
		
	}

	
	

	public RateInCurrencyDTO(Long exchangerateid, String buying, String average, String selling, String primary,
			String changeto) {
		super();
		this.exchangerateid = exchangerateid;
		this.buying = buying;
		this.average = average;
		this.selling = selling;
		this.primary = primary;
		this.changeto = changeto;
	}




	public Long getExchangerateid() {
		return exchangerateid;
	}


	public void setExchangerateid(Long exchangerateid) {
		this.exchangerateid = exchangerateid;
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


	public String getPrimary() {
		return primary;
	}


	public void setPrimary(String primary) {
		this.primary = primary;
	}


	public String getChangeto() {
		return changeto;
	}


	public void setChangeto(String changeto) {
		this.changeto = changeto;
	}
	

	
	
	
	
	

}
