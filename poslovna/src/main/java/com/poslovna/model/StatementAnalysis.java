package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatementAnalysis implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private Long itemNumber; //ovo bi trebao da bude kljuc
	
	@Column(columnDefinition="VARCHAR(256)")
	private String debtorOrderer;
	@Column(columnDefinition="VARCHAR(256)")
	private String PurposeOfPayment;
	@Column(columnDefinition="VARCHAR(256)")
	private String creditorReceiver;
	
	private Date dateOfReceipt;
	private Date dateCurrency;
	
	@Column(columnDefinition="VARCHAR(18)")
	private String debtorAccount;
	
	@Column(precision=2)
	private Long modelOfIndebtedness;
	
	@Column(columnDefinition="VARCHAR(20)")
	private String callNumberOfIndebtedness;
	
	@Column(columnDefinition="VARCHAR(18)")
	private String accountCreditor;
	
	@Column(precision=2)
	private Long modelOfApproval;
	
	@Column(columnDefinition="VARCHAR(20)")
	private String callForApprovalNumber;
	
	private Boolean urgent;
	@Column(precision=15, scale=2)
	private Long amount;
	@Column(precision=1)
	private Long typeOfError;
	
	private Boolean status;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getDebtorOrderer() {
		return debtorOrderer;
	}

	public void setDebtorOrderer(String debtorOrderer) {
		this.debtorOrderer = debtorOrderer;
	}

	public String getPurposeOfPayment() {
		return PurposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		PurposeOfPayment = purposeOfPayment;
	}

	public String getCreditorReceiver() {
		return creditorReceiver;
	}

	public void setCreditorReceiver(String creditorReceiver) {
		this.creditorReceiver = creditorReceiver;
	}

	public Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	public void setDateOfReceipt(Date dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	public Date getDateCurrency() {
		return dateCurrency;
	}

	public void setDateCurrency(Date dateCurrency) {
		this.dateCurrency = dateCurrency;
	}

	public String getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(String debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public Long getModelOfIndebtedness() {
		return modelOfIndebtedness;
	}

	public void setModelOfIndebtedness(Long modelOfIndebtedness) {
		this.modelOfIndebtedness = modelOfIndebtedness;
	}

	public String getCallNumberOfIndebtedness() {
		return callNumberOfIndebtedness;
	}

	public void setCallNumberOfIndebtedness(String callNumberOfIndebtedness) {
		this.callNumberOfIndebtedness = callNumberOfIndebtedness;
	}

	public String getAccountCreditor() {
		return accountCreditor;
	}

	public void setAccountCreditor(String accountCreditor) {
		this.accountCreditor = accountCreditor;
	}

	public Long getModelOfApproval() {
		return modelOfApproval;
	}

	public void setModelOfApproval(Long modelOfApproval) {
		this.modelOfApproval = modelOfApproval;
	}

	public String getCallForApprovalNumber() {
		return callForApprovalNumber;
	}

	public void setCallForApprovalNumber(String callForApprovalNumber) {
		this.callForApprovalNumber = callForApprovalNumber;
	}

	public Boolean getUrgent() {
		return urgent;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getTypeOfError() {
		return typeOfError;
	}

	public void setTypeOfError(Long typeOfError) {
		this.typeOfError = typeOfError;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	

}
