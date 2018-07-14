package com.poslovna.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.ClientReportDTO;
import com.poslovna.model.Account;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.BankRepository;
import com.poslovna.service.ReportsService;






@CrossOrigin
@RestController
@RequestMapping(value = "/reports")
public class ReportsController {

	

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	
	public List<Account> getBankAccountsByBank(Long id) {
		
		
		List<Account> accounts = new ArrayList<Account>();
		
		accounts = accountRepository.findAllByBank(bankRepository.findByIdEquals(id));
		
		return accounts;
	}
	
	
	
	@RequestMapping(value = "/getAccounts/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getAccountsReport(@PathVariable Long id) throws IOException{
		
		
		
		
		ArrayList<Account> accounts = (ArrayList<Account>) getBankAccountsByBank(id);
		
		String bankName = bankRepository.findByIdEquals(id).getName();

        ByteArrayInputStream bis = ReportsService.accountsReport(accounts,bankName);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

		
}
	

	@RequestMapping(value = "/getClientReport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getAccountsReport(@RequestBody ClientReportDTO crDTO) throws IOException{
		
		
		
		
		

        ByteArrayInputStream bis = ReportsService.clientReport(crDTO.getAccountnum(), crDTO.getDatefrom(), crDTO.getDateto());
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

		
}
	
	
}
