package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Rtgs;


@Repository
public interface RtgsRepository extends JpaRepository<Rtgs, Long> {

}
