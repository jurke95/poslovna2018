package com.poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.model.Bank;
import com.poslovna.model.User;
import com.poslovna.service.UserService;

@RestController
@RequestMapping("/login")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PutMapping("/loginuser")
	public ResponseEntity<Bank> loginuser(@RequestBody User userl){
		
		Bank bank = userService.login(userl);
		
		if(bank!=null) {
			return new ResponseEntity<>(bank ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
