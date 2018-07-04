package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

	Bank findByIdEquals(Long id);
	
}
