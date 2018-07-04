package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.CurrencyDTO;
import com.poslovna.controller.response.CurrencyResponse;
import com.poslovna.model.Currency;
import com.poslovna.service.CurrencyService;

@CrossOrigin
@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {
	
	
	@Autowired
	private CurrencyService currencyService;
	
	
	
	
	@GetMapping("/getCurrencies") 
	public CurrencyResponse getCurrencies() {

		
		List<Currency> currencies=currencyService.getAllCurrencies();

		return new CurrencyResponse(currencies);
	}
	
	
	
	@GetMapping("/getCurrency/{id}")
	public Currency getCurrency(@PathVariable Long id) {
		
		Currency currency = currencyService.getCurrency(id);
		
		return currency;
	}
	
	
	@PostMapping("/addCurrency")
	public Currency addCurrency(@RequestBody CurrencyDTO currencyDTO) {
		
		Currency currency = currencyService.addCurrency(currencyDTO);
		
		return currency;	
		
	}
	
	@DeleteMapping("/deleteCurrency/{id}") 
	public Currency deleteCurrency(@PathVariable Long id) {
		
		Currency currency = currencyService.deleteCurrency(id);
		
		return currency;
	}
	
	
	
	

}
