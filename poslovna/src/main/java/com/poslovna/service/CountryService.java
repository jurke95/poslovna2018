package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poslovna.model.Country;
import com.poslovna.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getAllCountries(){
		
		List<Country> countries = countryRepository.findAll();
		
		return countries;
	}
	
	public Country getCountry1(String name) {
		Country country = countryRepository.findByNameEquals(name);
		
		return country;
	}
	
	public Country getCountry2(Long id) {
		Country country = countryRepository.findByIdEquals(id);
		
		return country;
	}
	
	public Country save(Country country) {
		
		Country country1 = countryRepository.save(country);
		
		return country1;
	}
	
	public Country edit(Long id, Country country) {
		
		Country c = countryRepository.findByIdEquals(id);
		
		if(c!=null) {
			c.setName(country.getName());
			c.setCode(country.getCode());
		
			countryRepository.save(c);
		
			return c;
		}
		
		return null;
	}
	
	public Country delete(Long id) {
		
		Country c = countryRepository.findByIdEquals(id);
		
		countryRepository.delete(c);
		
		return c;
	}
	

}
