package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Id
	@Column(name="password", unique=true,columnDefinition="NUMBER(3)")
	private Long password;
	
	@Column(columnDefinition="VARCHAR(30)")
	private String name;

}
