package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InhabitedPlace implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(60)")
	private String name;
	
	@Column(columnDefinition="VARCHAR(12)")
	private String PTTCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
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
