package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.AccountClosure;


@Repository
public interface AccountClosureRepository extends JpaRepository<AccountClosure,Long> {

	AccountClosure findOneById(Long id);
	
}
