package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.RateInCurrencyDTO;
import com.poslovna.model.RateInCurrency;
import com.poslovna.service.RateInCurrencyService;



@CrossOrigin
@RestController
@RequestMapping(value = "/exchangerate")
class ExchangeRateController {
	
	
	@Autowired
	private RateInCurrencyService rateInCurrencyService;

	
	@PostMapping("/newrateincurrency")
	public ResponseEntity<RateInCurrency> newExchangeRateInCurrency(@RequestBody RateInCurrencyDTO rateInCurrencyDTO) {
		
		RateInCurrency rateInCurrency = rateInCurrencyService.newRateInCurrency(rateInCurrencyDTO);
		
		return new ResponseEntity<RateInCurrency>(rateInCurrency,HttpStatus.OK);
	}
	
	
	@GetMapping("/getChangesInCurrency/{id}")
	public ResponseEntity<List<RateInCurrency>> getExchangeRatesInCurrency(@PathVariable Long id) {
		
		List<RateInCurrency> exchangeRatesInCurrency = rateInCurrencyService.getRatesInCurrency(id);
		
		return new ResponseEntity<List<RateInCurrency>>(exchangeRatesInCurrency,HttpStatus.OK);
		
	}
	
}
