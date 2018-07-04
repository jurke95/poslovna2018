package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {

}
