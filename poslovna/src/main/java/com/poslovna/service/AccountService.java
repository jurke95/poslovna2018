package com.poslovna.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.AccountDTO;
import com.poslovna.model.Account;
import com.poslovna.model.Bank;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.BankRepository;
import com.poslovna.repository.CurrencyRepository;
import com.poslovna.repository.IndividualRepositroy;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private BankRepository bankRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private IndividualRepositroy individualRepositroy;
	
	public Account getAccount(Long id) {
		return accountRepository.findOneById(id);
	}
	
	public Account findAccountByAccountnum(String accountnum){
		
	return	accountRepository.findOneByAccountnum(accountnum);
	}
	
	
	public Account addIndividualAccount(AccountDTO accountdto) {
		
		Account account = new Account();
		if(accountdto!=null) {
			account.setAccountnum(accountdto.getAccountnum());
			account.setBank(bankRepository.findByIdEquals(accountdto.getBankid()));
			account.setCurrency(currencyRepository.findOneById(accountdto.getCurrencyid()));
			account.setIndividual(individualRepositroy.findByIdEquals(accountdto.getIndividualid()));
			account.setIsValid(true);
			Date date = new Date();
			account.setOpeningdate(date);
			accountRepository.save(account);
		}
		return account;
	}
	
}
