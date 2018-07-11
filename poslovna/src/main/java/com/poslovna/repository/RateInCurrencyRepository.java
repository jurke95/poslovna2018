package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.ExchangeRate;
import com.poslovna.model.RateInCurrency;



@Repository
public interface RateInCurrencyRepository extends JpaRepository<RateInCurrency,Long> {
	
	List<RateInCurrency> findByExchangeRate(ExchangeRate exchangeRate);

}
