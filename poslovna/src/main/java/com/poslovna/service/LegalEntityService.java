package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.LegalEntity;
import com.poslovna.repository.LegalEntityRepository;

@Service
public class LegalEntityService {
	
	@Autowired
	private LegalEntityRepository legalEntRepository;
	
	public LegalEntity addLegalEntity(LegalEntity legalEnt) {
		
		return legalEntRepository.save(legalEnt);
	}

}
