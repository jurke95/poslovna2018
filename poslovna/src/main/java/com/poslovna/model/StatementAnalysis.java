package com.poslovna.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "statementAnalysis")
public class StatementAnalysis implements Serializable{
	
	
	public StatementAnalysis(Long id, String type, String debtorOrderer, String purposeOfPayment,
			String creditorReceiver, String dateOfReceipt, String dateCurrency, Double amount, String debtorAccountXML,
			Integer modelOfIndebtedness, String referenceNumberOfIndebtedness, Boolean urgent, Integer typeOfError,
			String status, String paymentTypeXML, String paymentCurrencyXML, String cityXML, Account debtorAccount,
			String accountCreditorXML, Account accountCreditor, Integer modelApproval, String referenceNumberCreditor,
			Long itemNumber, City city, Currency paymentCurrency, DailyAccountBalance dailyAccountBalance,
			TypesOfPayments paymentType, Double sum, String code) {
		
		this.id = id;
		this.type = type;
		this.debtorOrderer = debtorOrderer;
		this.purposeOfPayment = purposeOfPayment;
		this.creditorReceiver = creditorReceiver;
		this.dateOfReceipt = dateOfReceipt;
		this.dateCurrency = dateCurrency;
		this.amount = amount;
		this.debtorAccountXML = debtorAccountXML;
		this.modelOfIndebtedness = modelOfIndebtedness;
		this.referenceNumberOfIndebtedness = referenceNumberOfIndebtedness;
		this.urgent = urgent;
		this.typeOfError = typeOfError;
		this.status = status;
		this.paymentTypeXML = paymentTypeXML;
		this.paymentCurrencyXML = paymentCurrencyXML;
		this.cityXML = cityXML;
		this.debtorAccount = debtorAccount;
		this.accountCreditorXML = accountCreditorXML;
		this.accountCreditor = accountCreditor;
		this.modelApproval = modelApproval;
		this.referenceNumberCreditor = referenceNumberCreditor;
		this.itemNumber = itemNumber;
		this.city = city;
		this.paymentCurrency = paymentCurrency;
		this.dailyAccountBalance = dailyAccountBalance;
		this.paymentType = paymentType;
		this.sum = sum;
		this.code = code;
	}

	public StatementAnalysis() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	
	
	
	@Column
	private String debtorOrderer; //uplatilac-isplatilac-duznik-nalogodavac
	
	@Column
	private String purposeOfPayment; //svrha placanja
	
	@Column
	private String creditorReceiver; //primalac-poverilac
	
	private String dateOfReceipt; //datum prijema
	
	private String dateCurrency; //datum valute
	
	@Column
	private Double amount; //suma
	
	@Transient
	private String debtorAccountXML; //racun duznika za XML
	
	@Column
	private Integer modelOfIndebtedness; //model zaduzenja
	
	@Column
	private String referenceNumberOfIndebtedness; //poziv na broj zaduzenja
	
	private Boolean urgent; //hitno?
	
	@Column
	private Integer typeOfError; //tip greske
	
	@Column(length = 1)
	private String status; //status
	
	@Transient
	private String paymentTypeXML;
	
	@Transient
	private String paymentCurrencyXML;
	
	@Transient
	private String cityXML;
	
	
	
	//------------------OVO IZNAD IDE NA NALOG ZA ISPLATU------------------
	
	
	@ManyToOne
	private Account debtorAccount; //racun duznika
	
	private String accountCreditorXML;
	
	@ManyToOne
	private Account accountCreditor; //racun poverioca
		
	//------------------------------------
		
	private Integer modelApproval; //model odobrenja
	
	private String referenceNumberCreditor; //poziv na broj odobrenja
	
	//------------------------------------
		
	private Long itemNumber; //ovo bi trebao da bude kljuc 

	@ManyToOne
	private City city;
	
	@ManyToOne
	private Currency paymentCurrency; //valuta placanja
	
	@OneToOne
	private DailyAccountBalance dailyAccountBalance;
	
	@ManyToOne
	private TypesOfPayments paymentType; //tip placanja
	
	private Double sum;
	
	private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDebtorOrderer() {
		return debtorOrderer;
	}

	public void setDebtorOrderer(String debtorOrderer) {
		this.debtorOrderer = debtorOrderer;
	}

	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	public String getCreditorReceiver() {
		return creditorReceiver;
	}

	public void setCreditorReceiver(String creditorReceiver) {
		this.creditorReceiver = creditorReceiver;
	}

	public String getDateOfReceipt() {
		return dateOfReceipt;
	}

	public void setDateOfReceipt(String dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	public String getDateCurrency() {
		return dateCurrency;
	}

	public void setDateCurrency(String dateCurrency) {
		this.dateCurrency = dateCurrency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDebtorAccountXML() {
		return debtorAccountXML;
	}

	public void setDebtorAccountXML(String debtorAccountXML) {
		this.debtorAccountXML = debtorAccountXML;
	}

	public Integer getModelOfIndebtedness() {
		return modelOfIndebtedness;
	}

	public void setModelOfIndebtedness(Integer modelOfIndebtedness) {
		this.modelOfIndebtedness = modelOfIndebtedness;
	}

	public String getReferenceNumberOfIndebtedness() {
		return referenceNumberOfIndebtedness;
	}

	public void setReferenceNumberOfIndebtedness(String referenceNumberOfIndebtedness) {
		this.referenceNumberOfIndebtedness = referenceNumberOfIndebtedness;
	}

	public Boolean getUrgent() {
		return urgent;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

	public Integer getTypeOfError() {
		return typeOfError;
	}

	public void setTypeOfError(Integer typeOfError) {
		this.typeOfError = typeOfError;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentTypeXML() {
		return paymentTypeXML;
	}

	public void setPaymentTypeXML(String paymentTypeXML) {
		this.paymentTypeXML = paymentTypeXML;
	}

	public String getPaymentCurrencyXML() {
		return paymentCurrencyXML;
	}

	public void setPaymentCurrencyXML(String paymentCurrencyXML) {
		this.paymentCurrencyXML = paymentCurrencyXML;
	}

	public String getCityXML() {
		return cityXML;
	}

	public void setCityXML(String cityXML) {
		this.cityXML = cityXML;
	}

	public Account getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(Account debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public String getAccountCreditorXML() {
		return accountCreditorXML;
	}

	public void setAccountCreditorXML(String accountCreditorXML) {
		this.accountCreditorXML = accountCreditorXML;
	}

	public Account getAccountCreditor() {
		return accountCreditor;
	}

	public void setAccountCreditor(Account accountCreditor) {
		this.accountCreditor = accountCreditor;
	}

	public Integer getModelApproval() {
		return modelApproval;
	}

	public void setModelApproval(Integer modelApproval) {
		this.modelApproval = modelApproval;
	}

	public String getReferenceNumberCreditor() {
		return referenceNumberCreditor;
	}

	public void setReferenceNumberCreditor(String referenceNumberCreditor) {
		this.referenceNumberCreditor = referenceNumberCreditor;
	}

	public Long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Currency getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(Currency paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public DailyAccountBalance getDailyAccountBalance() {
		return dailyAccountBalance;
	}

	public void setDailyAccountBalance(DailyAccountBalance dailyAccountBalance) {
		this.dailyAccountBalance = dailyAccountBalance;
	}

	public TypesOfPayments getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(TypesOfPayments paymentType) {
		this.paymentType = paymentType;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
}
