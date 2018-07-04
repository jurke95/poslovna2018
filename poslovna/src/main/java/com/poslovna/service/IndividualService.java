package com.poslovna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Individual;
import com.poslovna.repository.IndividualRepositroy;

@Service
public class IndividualService {
	
	@Autowired
	private IndividualRepositroy individualRepositroy;
	
	
	public Individual addIndividual(Individual indi) {
				
		return individualRepositroy.save(indi);
	}
	
	
	public Individual deleteIndividual(Long id) {
		Individual individual = individualRepositroy.findByIdEquals(id);
		if(individual!=null) {
			individualRepositroy.delete(individual);
			return individual;
		}
		return null;
	}
	
	public List<Individual> findAllIndividual(){
		List<Individual> ret =  individualRepositroy.findAll();
		
		return ret;
	}
	
	
	
	
	
	
}
