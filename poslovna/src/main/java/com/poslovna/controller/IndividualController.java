package com.poslovna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.IndividualDTO;
import com.poslovna.model.Individual;
import com.poslovna.service.IndividualService;

@CrossOrigin
@RestController
@RequestMapping("/individual")
public class IndividualController {
	
	@Autowired
	private IndividualService individualService;
	
	@PostMapping("/addindividual")
	public ResponseEntity<Individual> addindividual(@RequestBody IndividualDTO indi){
		
		Individual individual = individualService.addIndividual(indi);
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/deleteindividual/{id}")
	public ResponseEntity<Individual> deleteindividual(@PathVariable Long id){
		
		Individual individual = individualService.deleteIndividual(id);
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getallindividual")
	public ResponseEntity<List<Individual>> getallindividual(){
		
		List<Individual> individual = individualService.findAllIndividual();
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/getallindividualofbank/{id}")
	public ResponseEntity<List<Individual>> getallindividualofbank(@PathVariable Long id){
		
		List<Individual> individual = individualService.getAllIndividualsOfBank(id);
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/editindividual")
	public ResponseEntity<Individual> editindividuals(@RequestBody IndividualDTO indi){
		
		Individual individual = individualService.editIndividual(indi);
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/findindividualofbank/{idindi}/{idbank}")
	public ResponseEntity<Individual> findindividualofbank(@PathVariable Long idindi,@PathVariable Long idbank ){
		
		Individual individual = individualService.findIndividualOBank(idindi, idbank);
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/findindividualjmbgofbank")
	public ResponseEntity<Individual> findindividualjmbgofbank(@RequestBody IndividualDTO indi){
		
		Individual individual = individualService.findIndividualJmbgOfBank(indi);
		
		if(individual!=null) {
			return new ResponseEntity<>(individual,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
