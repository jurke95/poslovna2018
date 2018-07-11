package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.CityDTO;
import com.poslovna.model.City;
import com.poslovna.model.Country;
import com.poslovna.repository.CityRepository;
import com.poslovna.repository.CountryRepository;
import com.poslovna.service.CityService;

@CrossOrigin
@RestController
@RequestMapping(value="/cities")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	
	@GetMapping("/getAllCities/{id}")
	public ResponseEntity<List<City>> getCities(@PathVariable Long id){
	
	List<City> cities = cityService.getAllCities(id);
	
	if(cities==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	return new ResponseEntity<>(cities, HttpStatus.OK);
		
	}
	
	@GetMapping("/getCities")
	public ResponseEntity<List<City>> getAllCities(){
		
		List<City> cities = cityService.getCities();
		
		if(cities==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}
	
	@PostMapping("/addCity")
	public ResponseEntity<City> addCity(@RequestBody CityDTO city){
		
		City city1 = cityService.addOneCity(city);
		
		if(city1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(city1, HttpStatus.OK);
		
	}
	
	@PutMapping("/editCity/{id}")
	public ResponseEntity<City> editCity(@PathVariable Long id, @RequestBody CityDTO city){
		System.out.println("aaaaaaa");
		City city1 = cityService.editCity(id, city);
		
		if(city1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(city1, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCity/{id}")
	public ResponseEntity<City> deleteCity(@PathVariable Long id){
		
		City city1 = cityService.deleteCity(id);
		
		if(city1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(city1, HttpStatus.OK);
	}
	
	@GetMapping(value="/getCity2/{id}")
	public ResponseEntity<City> getCountry(@PathVariable Long id){
		
		City city = cityService.getCity2(id);
		
		if(city==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(city,HttpStatus.OK);
	}
	
	@PutMapping(value="/searchCities")
	public ResponseEntity<List<City>> searchCountries(@RequestBody City city){
		
		List<City> cities = cityService.searchCity(city);
		
		if(cities==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(cities, HttpStatus.OK);
		
	}
	
	

}
