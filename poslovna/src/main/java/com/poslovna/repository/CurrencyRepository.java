package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {

	Currency findByName(String name);
	Currency findOneByPassword(String password);
	Currency findOneById(Long id);
	
}
