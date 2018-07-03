package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovna.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {

}
