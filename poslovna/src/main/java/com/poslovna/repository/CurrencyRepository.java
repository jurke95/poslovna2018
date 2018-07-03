package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovna.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {

	Currency findByName(String name);
	Currency findOneByPassword(String password);
	
}
