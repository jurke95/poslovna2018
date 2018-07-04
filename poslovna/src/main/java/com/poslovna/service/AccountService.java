package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Account;
import com.poslovna.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	
	public Account getAccount(Long id) {
		return accountRepository.findOneById(id);
	}
	
	public Account findAccountByAccountnum(String accountnum){
		
	return	accountRepository.findOneByAccountnum(accountnum);
	}

}
