package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovna.model.RateInCurrency;

public interface RateInCurrencyRepository extends JpaRepository<RateInCurrency,Long> {

}
