package com.poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.controller.dto.ActivityDTO;
import com.poslovna.model.Activity;
import com.poslovna.service.ActivityService;

@CrossOrigin
@RestController
@RequestMapping(value="/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	
	@PostMapping("/addActivity")
	public ResponseEntity<Activity> addActivity(@RequestBody ActivityDTO activityDTO){
		
		Activity activity = activityService.addActivity(activityDTO);
		
		if(activity==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(activity, HttpStatus.OK);
		
	}
	
	@PutMapping("/editActivity")
	public ResponseEntity<Activity> editActivity(@RequestBody ActivityDTO activityDTO){
		
		Activity activity = activityService.editActivity(activityDTO);
		
		if(activity==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(activity, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteActivity/{id}")
	public void deleteActivity(@PathVariable Long id){
		
		activityService.deleteActivity(id);
		
	}
	
	
}
