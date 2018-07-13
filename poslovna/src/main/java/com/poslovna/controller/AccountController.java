package com.poslovna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.AccountDTO;
import com.poslovna.model.Account;
import com.poslovna.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping(value = "/account")
public class AccountController {

	
	@Autowired
	private AccountService accountService;
	
	/**
	 * Add account of the individual
	 * @param accountdto
	 * @return
	 */
	@PostMapping("/addindividualaccount")
	public ResponseEntity<Account> addindividualaccount(@RequestBody AccountDTO accountdto){

		Account account = accountService.addIndividualAccount(accountdto);
		
		if(account!=null) {
			return new ResponseEntity<>(account,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * Add account of the legal entity
	 * @param accountdto
	 * @return
	 */
	@PostMapping("/addlegalaccount")
	public ResponseEntity<Account> addlegalaccount(@RequestBody AccountDTO accountdto){
		
		Account account = accountService.addLegalAccount(accountdto);

		if(account!=null) {
			return new ResponseEntity<>(account,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	/**
	 * Get all individual account
	 * @return
	 */
	@GetMapping("/getAllIndividualAccount")
	public ResponseEntity<List<Account>> getAllIndividualAccount(){
		
		List<Account> ListAccount = accountService.getAllIndividualAccount();
		
		if(ListAccount!=null) {
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * Get all legal account
	 * @return
	 */
	@GetMapping("/getAllLegalAccount")
	public ResponseEntity<List<Account>> getAllLegalAccount(){
		
		List<Account> ListAccount = accountService.getAllLegallAccount();
		
		if(ListAccount!=null) {
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * Get all individual accounts of the bank
	 * @param id
	 * @return
	 */
	@GetMapping("/getIndividualAccountsOfBank/{id}")
	public ResponseEntity<List<Account>> getIndividualAccountsOfBank(@PathVariable Long id){
		
		List<Account> ListAccount = accountService.getAllIndividualAccountOfBank(id);
		
		if(ListAccount!=null) {
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * Get all legal accounts of the bank
	 * @param id
	 * @return
	 */
	@GetMapping("/getLegalAccountsOfBank/{id}")
	public ResponseEntity<List<Account>> getLegalAccountsOfBank(@PathVariable Long id){
		
		List<Account> ListAccount = accountService.getAllLegalAccountOfBank(id);
		
		if(ListAccount!=null) {
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * Get all account of individual from the bank
	 * @param idIndividual
	 * @param idbank
	 * @return
	 */
	@GetMapping("/getIndividualAccount/{idIndividual}/{idbank}")
	public ResponseEntity<List<Account>> getIndividualAccount(@PathVariable Long idIndividual,@PathVariable Long idbank){
		
		List<Account> ListAccount = accountService.getAllIndividualAccount(idIndividual,idbank);
		
		if(ListAccount!=null) {
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Get account of legal entity from the bank
	 * @param idLegal
	 * @param idbank
	 * @return
	 */
	@GetMapping("/getLegalAccount/{idLegal}/{idbank}")
	public ResponseEntity<List<Account>> getLegalAccount(@PathVariable Long idLegal,@PathVariable Long idbank){
		
		List<Account> ListAccount = accountService.getAllLegalAccount(idLegal,idbank);
		
		if(ListAccount!=null) {
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("/findaccount")
	public ResponseEntity<List<Account>> findaccount(@RequestBody AccountDTO accountdto){
		
		List<Account> ListAccount = accountService.findAccount(accountdto);
		
		if(ListAccount!=null) {
			
			return new ResponseEntity<>(ListAccount,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
}
