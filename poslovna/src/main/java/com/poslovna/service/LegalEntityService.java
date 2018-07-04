package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.LegalEntity;
import com.poslovna.repository.LegalEntityRepository;

@Service
public class LegalEntityService {
	
	@Autowired
	private LegalEntityRepository legalEntRepository;
	
	public LegalEntity addLegalEntity(LegalEntity legalEnt) {
		
		LegalEntity le = legalEntRepository.save(legalEnt);
		
		return le;		
	}

	
	public LegalEntity deleteLegalEntity(Long id) {
		
		LegalEntity legalEnt = legalEntRepository.findByIdEquals(id);
		
		legalEntRepository.delete(legalEnt);
		
		return legalEnt;
		
	}
	
	public List<LegalEntity> findAllLenEnt(){
		
		List<LegalEntity> legEntities = legalEntRepository.findAll();
		
		return legEntities;
	}
}
