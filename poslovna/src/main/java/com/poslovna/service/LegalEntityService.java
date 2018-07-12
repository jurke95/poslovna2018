package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.IndividualDTO;
import com.poslovna.controller.dto.LegalEntityDTO;
import com.poslovna.model.Bank;
import com.poslovna.model.Individual;
import com.poslovna.model.LegalEntity;
import com.poslovna.repository.BankRepository;
import com.poslovna.repository.LegalEntityRepository;

@Service
public class LegalEntityService {
	
	@Autowired
	private LegalEntityRepository legalEntRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	public LegalEntity addLegalEntity(LegalEntityDTO legaldto) {

		LegalEntity legalentity = new LegalEntity();
		
		Bank  bank = bankRepository.findByIdEquals(legaldto.getBankid());

		if(legaldto!=null && bank!=null) {
			
			legalentity.setName(legaldto.getName());
			legalentity.setShortName(legaldto.getShortName());
			legalentity.setEmail(legaldto.getEmail());
			legalentity.setFax(legaldto.getFax());
			legalentity.setAddress(legaldto.getAddress());
			legalentity.setLocation(legaldto.getLocation());
			legalentity.setMbr(legaldto.getMbr());
			legalentity.setJmbg(legaldto.getJmbg());
			legalentity.setDeliveryAddress(legaldto.getDeliveryAddress());
			legalentity.setPhonenumber(legaldto.getPhonenumber());
			legalentity.setBank2(bank);
			legalEntRepository.save(legalentity);
			
			return legalentity;
			
			
		}
		
		
		return null;
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
	
	
	public List<LegalEntity> getAllLegalEntityOfBank (Long id){
		
		List<LegalEntity> legalentity = legalEntRepository.findByBank_idEquals(id);
		
		return legalentity;
	}
	
	
	public LegalEntity findLegalEntityOBank(Long idindi,Long idbank){
		
		List<LegalEntity> listLegal = legalEntRepository.findByBank_idEquals(idbank);
		for(int i = 0; i<listLegal.size();i++) {
			if(listLegal.get(i).getId()==idindi) {
				return listLegal.get(i);
			}
			
		}
		
		return null;
		
	}
	
	
	
	public LegalEntity editLegalEntity(LegalEntityDTO legaldto) {
		
		
		if(legaldto!=null) {
			
			LegalEntity legalentity = legalEntRepository.findByIdEquals(legaldto.getId());
			
			if(legalentity!=null) {
				legalentity.setName(legaldto.getName());
				legalentity.setShortName(legaldto.getShortName());
				legalentity.setEmail(legaldto.getEmail());
				legalentity.setFax(legaldto.getFax());
				legalentity.setAddress(legaldto.getAddress());
				legalentity.setLocation(legaldto.getLocation());
				legalentity.setMbr(legaldto.getMbr());
				legalentity.setJmbg(legaldto.getJmbg());
				legalentity.setDeliveryAddress(legaldto.getDeliveryAddress());
				legalentity.setPhonenumber(legaldto.getPhonenumber());
				legalEntRepository.save(legalentity);
				return legalentity;
			}
			
			
			
		}
		
		
		
		return null;
	}
	
	
	
	public LegalEntity findLegalJmbgOfBank(IndividualDTO indidto) {
		
		LegalEntity legalentity = legalEntRepository.findByJmbgEqualsAndBank_idEquals(indidto.getJmbg(), indidto.getBankId());
		
		
		return legalentity;
	}
	
	
	
	
}
