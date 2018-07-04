package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	
	List<City> findByCountry_idEquals(Long id);
	
	City findByIdEquals(Long id);

}
