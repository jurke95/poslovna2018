package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Id
	@Column(name="password", unique=true,columnDefinition="NUMBER(3)")
	private Long password;
	
	@Column(columnDefinition="VARCHAR(30)")
	private String name;
	
	private Boolean domicile;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getPassword() {
		return password;
	}

	public void setPassword(Long password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDomicile() {
		return domicile;
	}

	public void setDomicile(Boolean domicile) {
		this.domicile = domicile;
	}
	
	
	

}
