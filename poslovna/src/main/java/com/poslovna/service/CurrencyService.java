package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.CurrencyDTO;
import com.poslovna.model.Country;
import com.poslovna.model.Currency;
import com.poslovna.repository.CountryRepository;
import com.poslovna.repository.CurrencyRepository;

@Service
public class CurrencyService {

	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	
	
	
 public Currency getCurrency(Long id) {
		
		Currency currency = currencyRepository.findOneById(id);
		
		return currency;
	}
 
 
 
 
 public List<Currency> getAllCurrencies() {
		
		List<Currency> currencies = currencyRepository.findAll();
		
		return currencies;
	}
 
 
 
 public Currency addCurrency(CurrencyDTO currencyDTO) {
		
		
		
		
		Currency currency = new Currency();
		Country c=countryRepository.findByNameEquals(currencyDTO.getCountry());
		currency.setCountry(c);
		currency.setName(currencyDTO.getName());
		
		if(currencyDTO.isDomicile()==true) {
			currency.setDomicile(true);
		}else{
			currency.setDomicile(false);
		}	
		
		
		currencyRepository.save(currency);
		
		return currency;
		
	}
 
 
 
     public Currency deleteCurrency(Long id) {
		
		Currency currency = currencyRepository.findOneById(id);
		currencyRepository.delete(currency);
		
		return currency;
	}
 
 
 
     public Currency editCurrency(Long currencyId, CurrencyDTO currencyEditDTO) {
 		
 		Currency currency = currencyRepository.findOneById(currencyId);
 		
 		currency.setName(currencyEditDTO.getName());
 		currency.setPassword(currencyEditDTO.getPassword());
 		currency.setDomicile(currencyEditDTO.isDomicile());
 		
 		Country country = countryRepository.findByNameEquals(currencyEditDTO.getCountry());
 		currency.setCountry(country);
 		
 		currencyRepository.save(currency);
 			
 		return currency;
 		
 	}
 
	
}
