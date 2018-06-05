package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountClosure implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	
	private Date closuredate;
	
	@Column(columnDefinition="VARCHAR(20)")
	private String newaccount;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getClosuredate() {
		return closuredate;
	}

	public void setClosuredate(Date closuredate) {
		this.closuredate = closuredate;
	}

	public String getNewaccount() {
		return newaccount;
	}

	public void setNewaccount(String newaccount) {
		this.newaccount = newaccount;
	}
	
	
	
	
	
	
	
	
	

}
