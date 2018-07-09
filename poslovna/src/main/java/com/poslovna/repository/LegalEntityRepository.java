package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.LegalEntity;

@Repository
public interface LegalEntityRepository extends JpaRepository<LegalEntity, Long>{
	
	LegalEntity findByIdEquals(Long id);
	
	List<LegalEntity> findByBank_idEquals(Long id);
	
}
