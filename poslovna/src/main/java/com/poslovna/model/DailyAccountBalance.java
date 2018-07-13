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
public class DailyAccountBalance implements Serializable {
	
	public DailyAccountBalance() {
		
	}
	
	public DailyAccountBalance(Long id, String date, Double previousState, Double newState, Double paymentTo,
			Double paymentFrom, Account bankaccount) {
		
		this.id = id;
		this.date = date;
		this.previousState = previousState;
		this.newState = newState;
		this.paymentTo = paymentTo;
		this.paymentFrom = paymentFrom;
		this.bankaccount = bankaccount;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String date;
	
	@Column
	private Double previousState;
	
	@Column
	private Double newState;
	
	@Column
	private Double paymentTo;
	
	@Column
	private Double paymentFrom;
	
	@ManyToOne
	@JoinColumn(name="bankaccount_id")
	private Account bankaccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPreviousState() {
		return previousState;
	}

	public void setPreviousState(Double previousState) {
		this.previousState = previousState;
	}

	public Double getNewState() {
		return newState;
	}

	public void setNewState(Double newState) {
		this.newState = newState;
	}

	public Double getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(Double paymentTo) {
		this.paymentTo = paymentTo;
	}

	public Double getPaymentFrom() {
		return paymentFrom;
	}

	public void setPaymentFrom(Double paymentFrom) {
		this.paymentFrom = paymentFrom;
	}

	public Account getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(Account bankaccount) {
		this.bankaccount = bankaccount;
	}
	
}
