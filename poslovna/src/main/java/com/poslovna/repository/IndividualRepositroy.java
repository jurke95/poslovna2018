package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Individual;

@Repository
public interface IndividualRepositroy extends JpaRepository<Individual, Long> {

	Individual findByIdEquals(Long id);
	
}
