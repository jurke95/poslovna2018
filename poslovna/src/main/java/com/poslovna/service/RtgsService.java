package com.poslovna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Rtgs;
import com.poslovna.repository.RtgsRepository;



@Service
public class RtgsService {

	@Autowired
	private RtgsRepository rtgsRepository;
	
	public Rtgs addRtgs(Rtgs rtgs) {
		return rtgsRepository.save(rtgs);
	}
}