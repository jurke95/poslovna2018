package com.poslovna.controller;

import java.util.List;

import org.apache.coyote.Response;
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

import com.poslovna.model.Country;
import com.poslovna.service.CountryService;


@CrossOrigin
@RestController
@RequestMapping("/countries")
public class CountryController {
	
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping(value="/getCountries")
	public ResponseEntity<List<Country>> getCountries(){
		
		List<Country> countries = countryService.getAllCountries();
		
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

	@GetMapping(value="/getCountry1/{name}")
	public ResponseEntity<Country> getCountry(@PathVariable String name){
		
		Country country = countryService.getCountry1(name);
		
		if(country==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(country,HttpStatus.OK);
	}
	
	@GetMapping(value="/getCountry2/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id){
		
		Country country = countryService.getCountry2(id);
		
		if(country==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(country,HttpStatus.OK);
	}
	
	@PostMapping(value="/addCountry")
	public ResponseEntity<Country> addCountry(@RequestBody Country country){
		
		Country country1 = countryService.save(country);
		
		if(country1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(country1, HttpStatus.OK);
	}
	
	@PutMapping(value="/editCountry/{id}")
	public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody Country country){
	
		Country country1 = countryService.edit(id, country);
		
		if(country1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(country1, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/deleteCountry/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable Long id){
		
		Country c = countryService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
