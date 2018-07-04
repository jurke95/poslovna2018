package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.dto.CityDTO;
import com.poslovna.model.City;
import com.poslovna.model.Country;
import com.poslovna.repository.CityRepository;
import com.poslovna.repository.CountryRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityReposiotry;
	
	@Autowired 
	private CountryRepository countryRepository;
	
	public List<City> getAllCities(Long id){
		
		List<City> cities = cityReposiotry.findByCountry_idEquals(id);
		
		return cities;
	}

	public List<City> getCities(){
		
		List<City> cities = cityReposiotry.findAll();
		
		return cities;
	}
	
	public City addOneCity(CityDTO city) {
		
		City c = new City();
		c.setName(city.getName());
		c.setCode(city.getCode());
		c.setPostNum(city.getPostNum());
		
		Country country = countryRepository.findByNameEquals(city.getCountry());
		c.setCountry(country);
		
		cityReposiotry.save(c);
		
		return c;
		
	}
	
	
}
