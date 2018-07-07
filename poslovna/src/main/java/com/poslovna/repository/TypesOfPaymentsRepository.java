package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poslovna.model.TypesOfPayments;

public interface TypesOfPaymentsRepository extends JpaRepository<TypesOfPayments,Long> {
	
	TypesOfPayments findOneByCode(String code);

}
