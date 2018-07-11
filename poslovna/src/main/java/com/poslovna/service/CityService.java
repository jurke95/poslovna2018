package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.CityDTO;
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
		
		Country country = countryRepository.findByNameEquals(city.getCountryS());
		c.setCountry(country);
		
		cityReposiotry.save(c);
		
		return c;
		
	}
	
	
	public City editCity(Long id, CityDTO city) {
		
		City c = cityReposiotry.findByIdEquals(id);
		
		c.setName(city.getName());
		c.setCode(city.getCode());
		c.setPostNum(city.getPostNum());
		
		Country country = countryRepository.findByNameEquals(city.getCountryS());
		c.setCountry(country);
		
		cityReposiotry.save(c);
		
		return c;
	}
	
	public City deleteCity(Long id) {
		
		City city = cityReposiotry.findByIdEquals(id);
		
		cityReposiotry.delete(city);
		
		return city;
		
	}
	
	public City getCity2(Long id) {
		City city = cityReposiotry.findByIdEquals(id);
		
		return city;
	}
	
	public List<City> searchCity(City city){
		
		List<City> cities = cityReposiotry.findByNameContainingIgnoreCaseAndCodeContainingIgnoreCaseAndPostNumContainingIgnoreCase(city.getName(), city.getCode(), city.getPostNum());
		
		if(cities!=null) {
			
			return cities;
		}
		
		return null;
	}
	
	
}
