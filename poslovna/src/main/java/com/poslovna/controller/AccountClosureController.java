package com.poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.AccountClosureDTO;
import com.poslovna.controller.dto.CurrencyDTO;
import com.poslovna.model.Account;
import com.poslovna.model.AccountClosure;
import com.poslovna.model.Currency;
import com.poslovna.repository.AccountClosureRepository;
import com.poslovna.service.AccountClosureService;
import com.poslovna.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping(value = "/closure")
public class AccountClosureController {
	
	
	@Autowired
    private AccountClosureService accountClosureService;
	
	@Autowired
	private AccountClosureRepository accountClosureRepository;
	
	
	
	@Autowired
    private AccountService accountService;
	
	
	
	@PostMapping("/addClosure")
	public AccountClosure addCurrency(@RequestBody AccountClosureDTO closureDTO) {
		
		
		Account accountnew=accountService.findAccountByAccountnum(closureDTO.getAccountto());
		Account accountf=accountService.findAccountByAccountnum(closureDTO.getAccountfrom());
		
		AccountClosure closure=new AccountClosure();
		closure.setClosuredate(closureDTO.getClosuredate());
		closure.setAccountfrom(accountf);
		System.out.println("aaaaaaaaa " + closureDTO.getAccountto());
		closure.setAccountto(accountnew);
		
		accountClosureService.addClosure(closure,closureDTO);
		
		
		return closure;	
		
	}
	
	
	

}
