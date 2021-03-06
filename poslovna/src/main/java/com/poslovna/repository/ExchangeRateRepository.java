package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Bank;
import com.poslovna.model.ExchangeRate;



@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
	
	List<ExchangeRate> findAllByBank(Bank bank);

	ExchangeRate findOneById(Long exchangerateid);

}
