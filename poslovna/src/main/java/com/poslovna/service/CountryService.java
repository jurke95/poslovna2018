package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.City;
import com.poslovna.model.Country;
import com.poslovna.repository.CityRepository;
import com.poslovna.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
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
		
		if(country.getCode().length()==3) {
			Country country1 = countryRepository.save(country);
			return country1;
		}
		else {
			return null;
		}
	}
	
	public Country edit(Long id, Country country) {
		
		Country c = countryRepository.findByIdEquals(id);
		
		if(c!=null) {
			c.setName(country.getName());
			if(country.getCode().length()==3) {
				c.setCode(country.getCode());
			}
			else {
				return null;
			}
		
			countryRepository.save(c);
		
			return c;
		}
		
		return null;
	}
	
	public Country delete(Long id) {
		
		Country c = countryRepository.findByIdEquals(id);
		
		
		
		
		if(c!=null) {
			
			List<City> cities = cityRepository.findByCountry_idEquals(id);
			
			if(cities.size() ==0) {
			
				
				countryRepository.delete(c);
				return c;
			}
		}
		return null;
		
	}
	
	public List<Country> searchCounty(Country country){
		
		List<Country> countries = countryRepository.findByNameContainingIgnoreCaseAndCodeContainingIgnoreCase(country.getName(), country.getCode());
		
		if(countries!=null) {
			
			return countries;
		}
		
		return null;
	}
	

}
