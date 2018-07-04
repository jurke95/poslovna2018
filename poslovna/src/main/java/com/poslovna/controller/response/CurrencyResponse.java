package com.poslovna.controller.response;

import java.util.List;

import com.poslovna.model.Currency;

public class CurrencyResponse {

	private List<Currency>currencies;
	
	
	public CurrencyResponse(List<Currency> currencies) {
	
		this.currencies = currencies;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	
	
	
}
