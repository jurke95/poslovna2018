package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.RateInCurrencyDTO;
import com.poslovna.model.Currency;
import com.poslovna.model.ExchangeRate;
import com.poslovna.model.RateInCurrency;
import com.poslovna.repository.CurrencyRepository;
import com.poslovna.repository.ExchangeRateRepository;
import com.poslovna.repository.RateInCurrencyRepository;






@Service
public class RateInCurrencyService {
	
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private RateInCurrencyRepository rateInCurrencyRepository;
	
	
	
	
      public RateInCurrency newRateInCurrency(RateInCurrencyDTO rateInCurrencyDTO) {
		
		RateInCurrency rateInCurrency = new RateInCurrency();
		
		ExchangeRate exchRate = exchangeRateRepository.findOneById(rateInCurrencyDTO.getExchangerateid());
		Currency primaryCurrency = currencyRepository.findByName(rateInCurrencyDTO.getPrimary());
		Currency toOtherCurrency = currencyRepository.findByName(rateInCurrencyDTO.getChangeto());
		
		rateInCurrency.setExchangeRate(exchRate);
		rateInCurrency.setPrimary(primaryCurrency);
		rateInCurrency.setChangeto(toOtherCurrency);
		
		rateInCurrency.setBuying(rateInCurrencyDTO.getBuying());
		rateInCurrency.setSelling(rateInCurrencyDTO.getSelling());
		rateInCurrency.setAverage(rateInCurrencyDTO.getAverage());
		
		rateInCurrencyRepository.save(rateInCurrency);
		
		return rateInCurrency;
	}
	
	
	
	
	
	
	
	
	
	
	
}
