package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DailyAccountBalance implements Serializable {
	
	@Id
	private Long Excerpt;
	
	private Date date;
	
	@Column(precision=15, scale=2)
	private Long previousBalance;
	@Column(precision=15, scale=2)
	private Long profitOnAccount;
	@Column(precision=15, scale=2)
	private Long lossOnAccount;
	@Column(precision=15, scale=2)
	private Long newAccountBalance;
	public Long getExcerpt() {
		return Excerpt;
	}
	public void setExcerpt(Long excerpt) {
		Excerpt = excerpt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getPreviousBalance() {
		return previousBalance;
	}
	public void setPreviousBalance(Long previousBalance) {
		this.previousBalance = previousBalance;
	}
	public Long getProfitOnAccount() {
		return profitOnAccount;
	}
	public void setProfitOnAccount(Long profitOnAccount) {
		this.profitOnAccount = profitOnAccount;
	}
	public Long getLossOnAccount() {
		return lossOnAccount;
	}
	public void setLossOnAccount(Long lossOnAccount) {
		this.lossOnAccount = lossOnAccount;
	}
	public Long getNewAccountBalance() {
		return newAccountBalance;
	}
	public void setNewAccountBalance(Long newAccountBalance) {
		this.newAccountBalance = newAccountBalance;
	}
	
	

}
