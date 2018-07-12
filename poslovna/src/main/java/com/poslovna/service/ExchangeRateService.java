package com.poslovna.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.ExchangeRateDTO;
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


public ExchangeRate newExchangeRate(ExchangeRateDTO exchangeRateDTO) throws ParseException {
	
	ExchangeRate exchangeRate = new ExchangeRate();
	
	exchangeRate.setStartsOn(exchangeRateDTO.getStartsOn());
	exchangeRate.setBank(bankRepository.findByIdEquals(exchangeRateDTO.getIdbank()));
	
	List<ExchangeRate> exr = this.getAllExchangeRatesByBank(exchangeRateDTO.getIdbank());
	
	int num = Integer.parseInt(exchangeRateDTO.getNumberExchangeRate());
	exchangeRate.setNumber(num);
	exchangeRate.setNumberExchangeRate(exchangeRateDTO.getNumberExchangeRate());
	
	Date date = new Date();
	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		
	exchangeRate.setDate(modifiedDate);
	
	exchangeRateRepository.save(exchangeRate);
			
	
	return exchangeRate;
}















	
}
