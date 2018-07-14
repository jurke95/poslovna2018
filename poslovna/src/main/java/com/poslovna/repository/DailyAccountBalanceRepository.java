package com.poslovna.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Account;
import com.poslovna.model.DailyAccountBalance;


@Repository
public interface DailyAccountBalanceRepository extends JpaRepository<DailyAccountBalance,Long> {
	
	DailyAccountBalance findOneByDateAndBankaccount(String date, Account bankAccount);
	List<DailyAccountBalance> findByBankaccount_idEquals(Long id);
	ArrayList<DailyAccountBalance> findAllByBankaccount(Account bankAccount);

	List<DailyAccountBalance> findByBankaccount_id(Long id);

}
