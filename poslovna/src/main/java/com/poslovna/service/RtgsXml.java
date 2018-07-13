package com.poslovna.service;

import javax.xml.bind.annotation.XmlRootElement;

import com.poslovna.model.Rtgs;



@XmlRootElement(name = "rtgs")
public class RtgsXml {

	private Long id;
	private String swiftbankfrom;
	private String accountbankform;

	private String swiftbankto;
	private String accountbankto;


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

	
	public RtgsXml() {
		
	}
	
	public RtgsXml(Rtgs rtgs) {
		this.id = rtgs.getId();
		this.accountbankform = rtgs.getBankfrom().getAccountnumber();
		this.accountbankto = rtgs.getBankto().getAccountnumber();
		this.swiftbankfrom = rtgs.getBankfrom().getSwiftcode();
		this.swiftbankto = rtgs.getBankto().getSwiftcode();
		this.debtor = rtgs.getPayment().getDebtorOrderer();
		this.purposeofpayment = rtgs.getPayment().getPurposeOfPayment();
		this.creditor = rtgs.getPayment().getCreditorReceiver();
		this.dateofreceipt = rtgs.getPayment().getDateOfReceipt();
		this.currencydate = rtgs.getPayment().getDateCurrency();
		this.modelassigments = rtgs.getPayment().getModelOfIndebtedness();
		this.referencenumberassigments = rtgs.getPayment().getReferenceNumberOfIndebtedness();
		this.debtoraccount = rtgs.getPayment().getDebtorAccount().getAccountnum();
		this.accountcreditor = rtgs.getPayment().getAccountCreditor().getAccountnum();
		this.modelapproval = rtgs.getPayment().getModelApproval();
		this.referencenumbercreditor = rtgs.getPayment().getReferenceNumberCreditor();
		this.sum = rtgs.getPayment().getSum();
		this.paymentcurrency = rtgs.getPayment().getPaymentCurrency().getPassword();
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSwiftbankfrom() {
		return swiftbankfrom;
	}


	public void setSwiftbankfrom(String swiftbankfrom) {
		this.swiftbankfrom = swiftbankfrom;
	}


	public String getAccountbankform() {
		return accountbankform;
	}


	public void setAccountbankform(String accountbankform) {
		this.accountbankform = accountbankform;
	}


	public String getSwiftbankto() {
		return swiftbankto;
	}


	public void setSwiftbankto(String swiftbankto) {
		this.swiftbankto = swiftbankto;
	}


	public String getAccountbankto() {
		return accountbankto;
	}


	public void setAccountbankto(String accountbankto) {
		this.accountbankto = accountbankto;
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