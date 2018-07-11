package com.poslovna.controller;

import java.text.ParseException;
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

import com.poslovna.controller.dto.ExchangeRateDTO;
import com.poslovna.model.ExchangeRate;
import com.poslovna.service.ExchangeRateService;





@CrossOrigin
@RestController
@RequestMapping(value = "/exchangerate")
public class ExchangeRateController {

	
	@Autowired
	ExchangeRateService exchangeRateService;
	
	
	
	@GetMapping("/getExchangeRates/{id}")
	public ResponseEntity<List<ExchangeRate>> getExchangeRates(@PathVariable Long id) {
		
		List<ExchangeRate> exchangeRates = exchangeRateService.getAllExchangeRatesByBank(id);
		
		return new ResponseEntity<List<ExchangeRate>>(exchangeRates,HttpStatus.OK);
	}
	
	
	@PostMapping("/newExchangeRate")
	public ResponseEntity<ExchangeRate> newExchangeRate(@RequestBody ExchangeRateDTO exchangeRateDTO) throws ParseException {
		
		ExchangeRate exchangeRate = exchangeRateService.newExchangeRate(exchangeRateDTO);
	
		return new ResponseEntity<ExchangeRate>(exchangeRate,HttpStatus.OK);
	}
	
	
	
	
}
