package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountClosure implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String closuredate;
	
	@ManyToOne
	@JoinColumn(name="accountto")
	private Account accountto;
	
	@ManyToOne
	@JoinColumn(name="accountfrom")
	private Account accountfrom;
	
	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public String getClosuredate() {
		return closuredate;
	}

	public void setClosuredate(String closuredate) {
		this.closuredate = closuredate;
	}

	public Account getAccountto() {
		return accountto;
	}

	public void setAccountto(Account accountto) {
		this.accountto = accountto;
	}

	public Account getAccountfrom() {
		return accountfrom;
	}

	public void setAccountfrom(Account accountfrom) {
		this.accountfrom = accountfrom;
	}

	

	
	
	
	
	
	
	
	
	
	

}
