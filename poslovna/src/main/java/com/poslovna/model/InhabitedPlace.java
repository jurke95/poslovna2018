package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InhabitedPlace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(columnDefinition="VARCHAR(60)")
	private String name;
	
	@Column(columnDefinition="VARCHAR(12)")
	private String PTTCode;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPTTCode() {
		return PTTCode;
	}

	public void setPTTCode(String pTTCode) {
		PTTCode = pTTCode;
	}
	
	
	

}
