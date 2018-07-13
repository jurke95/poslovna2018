package com.poslovna.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Clearing {

	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@ManyToOne
	private Bank bankfrom;
	
	
	@ManyToOne
	private Bank bankto;
	
	
	@ManyToOne
	private Currency currency;


	
	private String dateofcurrency;
	
	@OneToMany
	private List<StatementAnalysis> payments;
	
	
	private boolean done;
	
	
	private double sumall;
	
	
	public Clearing() {
		this.sumall = 0;
	}
	
	
	

	public Clearing( Bank bankfrom, Bank bankto, Currency currency, String dateofcurrency,
			List<StatementAnalysis> payments, double sumAll) {
		super();
		this.bankfrom = bankfrom;
		this.bankto = bankto;
		this.currency = currency;
		this.dateofcurrency = dateofcurrency;
		this.payments = payments;
		this.sumall = sumall;
		this.done = false;
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getDateofcurrency() {
		return dateofcurrency;
	}

	public void setDateofcurrency(String dateofcurrency) {
		this.dateofcurrency = dateofcurrency;
	}

	public List<StatementAnalysis> getPayments() {
		return payments;
	}

	public void setPayments(List<StatementAnalysis> payments) {
		this.payments = payments;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public double getSumall() {
		return sumall;
	}

	public void setSumall(double sumall) {
		this.sumall = sumall;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
