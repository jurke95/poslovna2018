package com.poslovna.service;

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
		Account creditorAccount = accountRepository.findOneByAccountnum(accdto.getAccountfrom());
		
		List<DailyAccountBalance> dailyAccountBalansdebtor = dabRepository.findByBankaccount_id(debtorAccount.getId());
		List<DailyAccountBalance> dailyAccountBalanscreditor = dabRepository.findByBankaccount_id(creditorAccount.getId());

		
		//onome kome se skida
		if(dailyAccountBalansdebtor.size()!=0) {
			
			DailyAccountBalance max = dailyAccountBalansdebtor.get(0);
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date maxDate = date.parse(dailyAccountBalansdebtor.get(0).getDate());
			//java.util.Date fromDate = date.parse(sa.getDateCurrency());

			for (int i = 1; i < dailyAccountBalansdebtor.size(); i++) {
				java.util.Date currentDate = date.parse(dailyAccountBalansdebtor.get(i).getDate());

				if (currentDate.after(maxDate)) {
					max = dailyAccountBalansdebtor.get(i);
				}
			}
			
			System.out.println("AAAAAAAAAAaa " + max.getBankaccount().getAccountnum());
			
		}
		
		
		
		
		
		
		
		
	}

	
	public void deleteClosure(AccountClosure closure){
		
		accountClosureRepository.delete(closure);
	}
	
}
