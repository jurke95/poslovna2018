package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.RateInCurrency;

@Repository
public interface RateInCurrencyRepository extends JpaRepository<RateInCurrency,Long> {

}
