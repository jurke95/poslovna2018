package com.poslovna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.IndividualDTO;
import com.poslovna.model.Bank;
import com.poslovna.model.Individual;
import com.poslovna.repository.BankRepository;
import com.poslovna.repository.IndividualRepositroy;

@Service
public class IndividualService {
	
	@Autowired
	private IndividualRepositroy individualRepositroy;
	
	@Autowired
	private BankRepository bankRepository;
	
	public Individual addIndividual(IndividualDTO indi) {
				
		Individual individual = new Individual();
		Bank bank = bankRepository.findByIdEquals(indi.getBankId());
		if(indi!=null && bank!=null) {
			individual.setName(indi.getName());
			individual.setSurname(indi.getSurname());
			individual.setAddress(indi.getAddress());
			individual.setEmail(indi.getEmail());
			individual.setJmbg(indi.getJmbg());
			individual.setPhonenumber(indi.getPhonenumber());
			individual.setBank2(bank);
			
			return individualRepositroy.save(individual);
		}
		return null;
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
	
	
	
	public List<Individual> getAllIndividualsOfBank(Long id){
		
		List<Individual> listIndi = individualRepositroy.findByBank_idEquals(id);
		
		return listIndi;
		
	}
	
	public Individual findIndividualOBank(Long idindi,Long idbank){
		
		List<Individual> listIndi = individualRepositroy.findByBank_idEquals(idbank);
		for(int i = 0; i<listIndi.size();i++) {
			if(listIndi.get(i).getId()==idindi) {
				return listIndi.get(i);
			}
			
		}
		
		return null;
		
	}
	
	public Individual editIndividual(IndividualDTO indidto) {
		
		Individual individual = individualRepositroy.findByIdEquals(indidto.getId());
		
		if(individual!=null) {
			
			individual.setName(indidto.getName());
			individual.setSurname(indidto.getSurname());
			individual.setAddress(indidto.getAddress());
			individual.setEmail(indidto.getEmail());
			individual.setJmbg(indidto.getJmbg());
			individual.setPhonenumber(indidto.getPhonenumber());
			
			return individualRepositroy.save(individual);
		}
		
		return null;
	}
	
	
}
