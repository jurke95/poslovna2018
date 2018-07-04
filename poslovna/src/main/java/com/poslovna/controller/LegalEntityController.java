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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.model.LegalEntity;
import com.poslovna.service.LegalEntityService;

@CrossOrigin
@RestController
@RequestMapping("/legalEntity")
public class LegalEntityController {
	
	@Autowired
	private LegalEntityService legalEntityService;
	
	@PostMapping("/addLegEntity")
	public ResponseEntity<LegalEntity> addNewLegalEntity(@RequestBody LegalEntity legEnt){
		
		LegalEntity legalEntity = legalEntityService.addLegalEntity(legEnt);
		
		if(legalEntity==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(legalEntity, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLegEnt/{id}")
	public ResponseEntity<LegalEntity> deleteLegalEnt(@PathVariable Long id){
		
		LegalEntity legEnt = legalEntityService.deleteLegalEntity(id);
		
		if(legEnt==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(legEnt, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllLegEntities")
	public ResponseEntity<List<LegalEntity>> findAllLegalEntity(){
		
		List<LegalEntity> legEntities = legalEntityService.findAllLenEnt();
		
		if(legEntities==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(legEntities, HttpStatus.OK);
	}

}