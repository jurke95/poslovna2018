package com.poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping("/addindividualaccount")
	public ResponseEntity<String> addindividualaccount(@RequestBody AccountDTO accountdto){
		
		Account account = accountService.addIndividualAccount(accountdto);
		
		if(account!=null) {
			return new ResponseEntity<>("successful",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("unsuccessful",HttpStatus.NOT_FOUND);
	}
	
}
