package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.poslovna.model.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
	
	Country findByNameEquals(String name);
	
	Country findByIdEquals(Long id);

}
