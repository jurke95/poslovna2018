package com.poslovna.controller.dto;


public class AccountDTO {

	


	public AccountDTO() {
		
	}
	


	private Long id;
	
	private String accountnum;
	
	private String openingdate;
	
	private boolean isValid;
	
	private Long currencyid;
	
	private Long individualid;
	
	private Long legalEntityid;
	
	private Long bankid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getOpeningdate() {
		return openingdate;
	}

	public void setOpeningdate(String openingdate) {
		this.openingdate = openingdate;
	}

	public Long getCurrencyid() {
		return currencyid;
	}

	public void setCurrencyid(Long currencyid) {
		this.currencyid = currencyid;
	}

	public Long getIndividualid() {
		return individualid;
	}

	public void setIndividualid(Long individualid) {
		this.individualid = individualid;
	}

	public Long getBankid() {
		return bankid;
	}

	public void setBankid(Long bankid) {
		this.bankid = bankid;
	}

	public Long getLegalEntityid() {
		return legalEntityid;
	}

	public void setLegalEntityid(Long legalEntityid) {
		this.legalEntityid = legalEntityid;
	}


	
	
	
}
