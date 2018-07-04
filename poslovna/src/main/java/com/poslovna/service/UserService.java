package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Bank;
import com.poslovna.model.User;
import com.poslovna.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public Bank login(User userl) {
		
		User u = userRepository.findByEmailEquals(userl.getEmail());
		
		if(u==null) {
			return null;
		}
		else {
			if(u.getPassword().equals(userl.getPassword())) {
				return u.getBank();
			}
			
		}
		return null;
	}
	
}
