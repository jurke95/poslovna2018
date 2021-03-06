package com.poslovna.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.AccountDTO;
import com.poslovna.model.Account;
import com.poslovna.model.Bank;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.BankRepository;
import com.poslovna.repository.CurrencyRepository;
import com.poslovna.repository.IndividualRepositroy;
import com.poslovna.repository.LegalEntityRepository;

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
	
	@Autowired
	private LegalEntityRepository legalEntityRepository;
	
	public Account getAccount(Long id) {
		return accountRepository.findOneById(id);
	}
	
	public Account findAccountByAccountnum(String accountnum){
		
	return	accountRepository.findOneByAccountnum(accountnum);
	}
	
	
	public Account addIndividualAccount(AccountDTO accountdto) {
		
		Account account = new Account();
		List<Account> listaAccounts = accountRepository.findAll();
		
		if(accountdto!=null) {
			Bank bank = bankRepository.findByIdEquals(accountdto.getBankid());
			String code = bank.getCode();
			
			for(Account acc: listaAccounts) {
				if(acc.getAccountnum().equals(code + "-" + accountdto.getAccountnum() + "-92")) {
					return account;
				}
			}
			
			account.setAccountnum(code + "-" + accountdto.getAccountnum() + "-92");
			account.setBank(bankRepository.findByIdEquals(accountdto.getBankid()));
			account.setCurrency(currencyRepository.findOneById(accountdto.getCurrencyid()));
			account.setIndividual(individualRepositroy.findByIdEquals(accountdto.getIndividualid()));
			account.setLegalEntity(null);
			account.setIsValid(true);
			Date date = new Date();
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String s = formatter.format(date);
			account.setOpeningdate(s);
			accountRepository.save(account);
		}
		return account;
	}
	
	
	public Account addLegalAccount(AccountDTO accountdto) {
		
		List<Account> listaAccounts = accountRepository.findAll();
		Account account = new Account();
		if(accountdto!=null) {
			
			Bank bank = bankRepository.findByIdEquals(accountdto.getBankid());
			String code = bank.getCode();
			
			for(Account acc: listaAccounts) {
				if(acc.getAccountnum().equals(code + "-" + accountdto.getAccountnum() + "-92")) {
					return account;
				}
			}
			
			
			account.setAccountnum(code + "-" + accountdto.getAccountnum() + "-92");
			account.setBank(bankRepository.findByIdEquals(accountdto.getBankid()));
			account.setCurrency(currencyRepository.findOneById(accountdto.getCurrencyid()));
			account.setIndividual(null);
			account.setLegalEntity(legalEntityRepository.findByIdEquals(accountdto.getLegalEntityid()));
			account.setIsValid(true);
			Date date = new Date();
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String s = formatter.format(date);
			account.setOpeningdate(s);
			accountRepository.save(account);
		}
		return account;
	}
	
	public List<Account> getAllIndividualAccount(){
		
		List<Account> listAccoount = accountRepository.findAll();
		List<Account> retList = new ArrayList<>();
		for(Account acc : listAccoount) {
			if(acc.getLegalEntity()==null && acc.getIndividual()!=null) {
				retList.add(acc);
			}
		}
		
		return retList;
	}
	
	
	public List<Account> getAllLegallAccount(){
		
		List<Account> listAccoount = accountRepository.findAll();
		List<Account> retList = new ArrayList<>();
		for(Account acc : listAccoount) {
			if(acc.getIndividual()==null && acc.getLegalEntity()!=null) {
				retList.add(acc);
			}
		}
		
		return retList;
	}
	
	public List<Account> getAllIndividualAccountOfBank(Long id){
		
		List<Account> listAccoount = accountRepository.findAll();
		List<Account> retList = new ArrayList<>();
		for(Account acc : listAccoount) {
			
			if(acc.getBank().getId()==id && acc.getIndividual()!=null && acc.getIsValid()) {
				
				retList.add(acc);
			}
		}
		
		return retList;
	}
	
	public List<Account> getAllLegalAccountOfBank(Long id){
		
		List<Account> listAccoount = accountRepository.findAll();
		List<Account> retList = new ArrayList<>();
		for(Account acc : listAccoount) {
			if(acc.getBank().getId()==id && acc.getLegalEntity()!=null && acc.getIsValid()) {
				retList.add(acc);
			}
		}
		
		return retList;
	}
	
	
	public List<Account> getAllIndividualAccount(Long idindividual,Long idbank){
		
		List<Account> listAccoount = accountRepository.findAll();
		List<Account> retList = new ArrayList<>();
		for(Account acc : listAccoount) {
			if(acc.getIndividual()!=null) {
				if(acc.getIndividual().getId()==idindividual && acc.getBank().getId()==idbank) {
					retList.add(acc);
				}
			}
			
		}
		
		return retList;
	}
	
	public List<Account> getAllLegalAccount(Long idlegal,Long idbank){
		
		List<Account> listAccoount = accountRepository.findAll();
		List<Account> retList = new ArrayList<>();
		for(Account acc : listAccoount) {
			if(acc.getLegalEntity()!=null) {
				if(acc.getLegalEntity().getId()==idlegal && acc.getBank().getId()==idbank) {
					retList.add(acc);
				}
			}
			
		}
		
		return retList;
	}
	
	
	public List<Account> findAccount(AccountDTO accountdto) {
		
		return accountRepository.findByAccountnumEquals(accountdto.getAccountnum());
		
		
	}
		
	
	
	
	
	
}
