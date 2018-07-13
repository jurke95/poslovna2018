package com.poslovna.service;

import com.poslovna.model.StatementAnalysis;

public class Analytic {
	
	private Long id;
	
	private String debtor; // isplatilac-platilac-duznik-nalogodavac

	private String purposeofpayment;

	private String creditor; // poverilac-primalac

	private String dateofreceipt; // datum prijema

	private String currencydate; // datum valute

	private Integer modelassigments; // model zaduzenja

	private String referencenumberassigments; // poziv na broj zaduzenja

	private String debtoraccount; // racun duznika za xml

	private String accountcreditor;

	private Integer modelapproval; // model odobrenja

	private String referencenumbercreditor; // poziv na broj odobrenja

	private Double sum;
	
	private String paymentcurrency;
	
	
  	
	
	public Analytic(StatementAnalysis analytic) {
		
		this.setId(analytic.getId());
		this.debtor = debtor;
		this.purposeofpayment = purposeofpayment;
		this.creditor = creditor;
		this.dateofreceipt = dateofreceipt;
		this.currencydate = currencydate;
		this.modelassigments = modelassigments;
		this.referencenumberassigments = referencenumberassigments;
		this.debtoraccount = debtoraccount;
		this.accountcreditor = accountcreditor;
		this.modelapproval = modelapproval;
		this.referencenumbercreditor = referencenumbercreditor;
		this.sum = sum;
		this.paymentcurrency = paymentcurrency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDebtor() {
		return debtor;
	}

	public void setDebtor(String debtor) {
		this.debtor = debtor;
	}

	public String getPurposeofpayment() {
		return purposeofpayment;
	}

	public void setPurposeofpayment(String purposeofpayment) {
		this.purposeofpayment = purposeofpayment;
	}

	public String getCreditor() {
		return creditor;
	}

	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}

	public String getDateofreceipt() {
		return dateofreceipt;
	}

	public void setDateofreceipt(String dateofreceipt) {
		this.dateofreceipt = dateofreceipt;
	}

	public String getCurrencydate() {
		return currencydate;
	}

	public void setCurrencydate(String currencydate) {
		this.currencydate = currencydate;
	}

	public Integer getModelassigments() {
		return modelassigments;
	}

	public void setModelassigments(Integer modelassigments) {
		this.modelassigments = modelassigments;
	}

	public String getReferencenumberassigments() {
		return referencenumberassigments;
	}

	public void setReferencenumberassigments(String referencenumberassigments) {
		this.referencenumberassigments = referencenumberassigments;
	}

	public String getDebtoraccount() {
		return debtoraccount;
	}

	public void setDebtoraccount(String debtoraccount) {
		this.debtoraccount = debtoraccount;
	}

	public String getAccountcreditor() {
		return accountcreditor;
	}

	public void setAccountcreditor(String accountcreditor) {
		this.accountcreditor = accountcreditor;
	}

	public Integer getModelapproval() {
		return modelapproval;
	}

	public void setModelapproval(Integer modelapproval) {
		this.modelapproval = modelapproval;
	}

	public String getReferencenumbercreditor() {
		return referencenumbercreditor;
	}

	public void setReferencenumbercreditor(String referencenumbercreditor) {
		this.referencenumbercreditor = referencenumbercreditor;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getPaymentcurrency() {
		return paymentcurrency;
	}

	public void setPaymentcurrency(String paymentcurrency) {
		this.paymentcurrency = paymentcurrency;
	}
	
	
	
	
	
	
	
	
}