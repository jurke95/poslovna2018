package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Clearing;


@Repository
public interface ClearingRepository  extends JpaRepository<Clearing, Long> {
	 Clearing findByBankfromIdAndBanktoIdAndDone(Long bankfromid ,Long banktoid, boolean done);
	Clearing findOneById(Long id);
}
