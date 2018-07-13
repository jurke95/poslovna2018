package com.poslovna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Rtgs {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@ManyToOne
	private Bank bankfrom;
	
	
	@ManyToOne
	private Bank bankto;
	
	
	@OneToOne
	private StatementAnalysis payment;
	
	
	
	


	public Rtgs(Bank bankfrom, Bank bankto, StatementAnalysis payment) {
		super();
		this.bankfrom = bankfrom;
		this.bankto = bankto;
		this.payment = payment;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Bank getBankfrom() {
		return bankfrom;
	}


	public void setBankfrom(Bank bankfrom) {
		this.bankfrom = bankfrom;
	}


	public Bank getBankto() {
		return bankto;
	}


	public void setBankto(Bank bankto) {
		this.bankto = bankto;
	}


	public StatementAnalysis getPayment() {
		return payment;
	}


	public void setPayment(StatementAnalysis payment) {
		this.payment = payment;
	}
	

	
	
	
}
