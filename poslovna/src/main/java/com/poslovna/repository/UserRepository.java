package com.poslovna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poslovna.model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

	User findByIdEquals(Long id);
	
	User findByEmailEquals(String email);
}
