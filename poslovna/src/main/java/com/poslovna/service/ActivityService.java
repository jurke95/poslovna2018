package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.controller.dto.ActivityDTO;
import com.poslovna.model.Activity;
import com.poslovna.repository.ActivityRepository;

@Service
public class ActivityService {
	

	@Autowired
	private ActivityRepository activityRepository;
	
	public Activity addActivity(ActivityDTO activityDTO){
		 Activity a=new Activity();
		 a.setCode(activityDTO.getCode());
		 a.setName(activityDTO.getName());
		 return activityRepository.save(a);
		 
		 
	}
	
	
	public Activity editActivity(ActivityDTO activityDTO){
		 Activity a=activityRepository.findByIdEquals(activityDTO.getId());
		 a.setCode(activityDTO.getCode());
		 a.setName(activityDTO.getName());
		 return activityRepository.save(a);
		 
		 
	}
	
	public void deleteActivity(Long id){
		 activityRepository.delete(activityRepository.findByIdEquals(id));
	}

}
