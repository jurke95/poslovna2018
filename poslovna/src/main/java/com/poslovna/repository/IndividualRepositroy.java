package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Individual;

@Repository
public interface IndividualRepositroy extends JpaRepository<Individual, Long> {

	Individual findByIdEquals(Long id);
	
	List<Individual> findByBank_idEquals(Long id);
}
