package com.poslovna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Bank;
import com.poslovna.model.ExchangeRate;
import com.poslovna.repository.BankRepository;
import com.poslovna.repository.ExchangeRateRepository;






@Service
public class ExchangeRateService {
	
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private BankRepository bankRepository;
	

	
public List<ExchangeRate> getAllExchangeRatesByBank(Long id) {
		
		List<ExchangeRate> exchangeRates = new ArrayList<ExchangeRate>();
		
		Bank bank = bankRepository.findByIdEquals(id);
		
		exchangeRates = exchangeRateRepository.findAllByBank(bank);
		
		return exchangeRates;
	}
	
}
