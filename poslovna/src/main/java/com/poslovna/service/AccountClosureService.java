package com.poslovna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.AccountClosureDTO;
import com.poslovna.model.Account;
import com.poslovna.model.AccountClosure;
import com.poslovna.repository.AccountClosureRepository;
import com.poslovna.repository.AccountRepository;

@Service
public class AccountClosureService {
	
	
	
	
	@Autowired
	private AccountClosureRepository accountClosureRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<AccountClosure> getAllClosures(){
		
		return accountClosureRepository.findAll();
		
	}
	
	
	
	public void addClosure(AccountClosure closure,AccountClosureDTO accdto){
		
		Account account = accountRepository.findOneByAccountnum(accdto.getAccountfrom());
		if(account!=null){
			account.setIsValid(false);
			accountRepository.save(account);
		}
		
		
		accountClosureRepository.save(closure);
	}

	
	public void deleteClosure(AccountClosure closure){
		
		accountClosureRepository.delete(closure);
	}
	
}
