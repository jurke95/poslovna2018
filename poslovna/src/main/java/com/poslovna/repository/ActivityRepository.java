package com.poslovna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.Activity;


@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
	
	
	Activity findByIdEquals(Long id);
	List<Activity> findAll();
}
