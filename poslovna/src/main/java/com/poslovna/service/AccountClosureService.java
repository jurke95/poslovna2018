package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.AccountClosure;
import com.poslovna.repository.AccountClosureRepository;

@Service
public class AccountClosureService {
	
	
	
	
	@Autowired
	private AccountClosureRepository accountClosureRepository;
	
	
	
	public List<AccountClosure> getAllClosures(){
		
		return accountClosureRepository.findAll();
		
	}
	
	
	
	public void addClosure(AccountClosure closure){
		
		
		accountClosureRepository.save(closure);
	}

	
	public void deleteClosure(AccountClosure closure){
		
		accountClosureRepository.delete(closure);
	}
	
}
