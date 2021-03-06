package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Account;
import com.poslovna.model.StatementAnalysis;



@Repository
public interface StatementAnalysisRepository extends JpaRepository<StatementAnalysis,Long> {
	
public List<StatementAnalysis> findAllByDebtorAccount(Account acc);
	
	public List<StatementAnalysis> findAllByAccountCreditor(Account acc);

}
