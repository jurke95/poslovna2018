package com.poslovna.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.AccountClosureDTO;
import com.poslovna.model.Account;
import com.poslovna.model.AccountClosure;
import com.poslovna.model.DailyAccountBalance;
import com.poslovna.repository.AccountClosureRepository;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.DailyAccountBalanceRepository;

@Service
public class AccountClosureService {
	
	
	
	
	@Autowired
	private AccountClosureRepository accountClosureRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private DailyAccountBalanceRepository dabRepository;
	
	public List<AccountClosure> getAllClosures(){
		
		return accountClosureRepository.findAll();
		
	}
	
	
	
	public void addClosure(AccountClosure closure,AccountClosureDTO accdto) throws ParseException{
		
		Account account = accountRepository.findOneByAccountnum(accdto.getAccountfrom());
		if(account!=null){
			account.setIsValid(false);
			accountRepository.save(account);
		}
		accountClosureRepository.save(closure);
		
		
		Account debtorAccount = accountRepository.findOneByAccountnum(accdto.getAccountfrom());
		
		Account creditorAccount = accountRepository.findOneByAccountnum(accdto.getAccountto());
		
		List<DailyAccountBalance> dailyAccountBalansdebtor = dabRepository.findByBankaccount_id(debtorAccount.getId());
		List<DailyAccountBalance> dailyAccountBalanscreditor = dabRepository.findByBankaccount_id(creditorAccount.getId());

		
		
		
		
		
		DailyAccountBalance maxx = new DailyAccountBalance();
		//onome kome se skida
		if(dailyAccountBalansdebtor.size()!=0) {
			
			maxx = dailyAccountBalansdebtor.get(0);
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date maxDate = date.parse(dailyAccountBalansdebtor.get(0).getDate());
			//java.util.Date fromDate = date.parse(sa.getDateCurrency());

			for (int i = 0; i < dailyAccountBalansdebtor.size(); i++) {
				java.util.Date currentDate = date.parse(dailyAccountBalansdebtor.get(i).getDate());

				if (currentDate.after(maxDate)) {
					maxx = dailyAccountBalansdebtor.get(i);
				}
			}
			
	 
		//onome kome se prebacuje
				if(dailyAccountBalanscreditor.size()!=0) {
					
					DailyAccountBalance primac = dailyAccountBalanscreditor.get(0);
					SimpleDateFormat datee = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date maxDatee = datee.parse(dailyAccountBalanscreditor.get(0).getDate());
					//java.util.Date fromDate = date.parse(sa.getDateCurrency());

					for (int i = 0; i < dailyAccountBalanscreditor.size(); i++) {
						java.util.Date currentDate = date.parse(dailyAccountBalanscreditor.get(i).getDate());
						System.out.println("EEEEEEEEEE " + dailyAccountBalanscreditor.get(i).getNewState());
						if (currentDate.after(maxDatee)) {
							primac = dailyAccountBalanscreditor.get(i);
						}
					}
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date today = new Date();      
					String reportDate = df.format(today);
					
					
					
					primac.setPaymentFrom(0.0);
					primac.setPaymentTo(0.0);
					//max.setPreviousState(0.0);
					
					primac.setPaymentTo(maxx.getNewState());
			
					primac.setDate(reportDate);
					
					primac.setNewState(primac.getNewState() + primac.getPaymentTo() - primac.getPaymentFrom());
					dabRepository.save(primac);
					
					
					
					
					maxx.setNewState(0.0);
					maxx.setDate(reportDate);
					maxx.setPaymentFrom(0.0);
					maxx.setPaymentTo(0.0);
					maxx.setPreviousState(0.0);
					dabRepository.save(maxx);
				}
		
		
		}
		
		
		
		
	}

	
	public void deleteClosure(AccountClosure closure){
		
		accountClosureRepository.delete(closure);
	}
	
}
