package com.poslovna.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Account;
import com.poslovna.model.DailyAccountBalance;

@Repository
public interface DailyAccountBalanceRepository extends JpaRepository<DailyAccountBalance,Long> {
	
	DailyAccountBalance findOneByDateAndBankAccount(String date, Account bankAccount);
	ArrayList<DailyAccountBalance> findAllByBankAccount(Account bankAccount);

}
