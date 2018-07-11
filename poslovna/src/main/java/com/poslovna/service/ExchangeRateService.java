package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.repository.BankRepository;
import com.poslovna.repository.ExchangeRateRepository;





@Service
public class ExchangeRateService {
	
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private BankRepository bankRepository;
	

}
