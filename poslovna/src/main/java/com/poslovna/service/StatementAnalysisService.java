package com.poslovna.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.StatementAnalysis;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.CityRepository;
import com.poslovna.repository.CurrencyRepository;
import com.poslovna.repository.TypesOfPaymentsRepository;

@Service
public class StatementAnalysisService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CurrencyRepository currencyRepository;
	@Autowired
	private CityRepository cityRepository;
	
	
	@Autowired
	private TypesOfPaymentsRepository typesOfPaymentsRepository;
	
	
	
	private StatementAnalysis generateStatementAnalysis(StatementAnalysis xml) {
		StatementAnalysis s = new StatementAnalysis();
		s.setCity(cityRepository.findOneByName(xml.getCityXML()));
		s.setCreditorReceiver(xml.getCreditorReceiver());
		s.setDailyAccountBalance(xml.getDailyAccountBalance());
		s.setDateCurrency(xml.getDateCurrency());
		s.setAmount(xml.getAmount());
	    s.setItemNumber(xml.getItemNumber());
	    s.setDateOfReceipt(xml.getDateOfReceipt());
	    s.setDebtorAccount(accountRepository.findOneByAccountnum(xml.getDebtorAccountXML()));
	    s.setAccountCreditor(xml.getAccountCreditor());
	    s.setDebtorOrderer(xml.getDebtorOrderer());
	    s.setModelApproval(xml.getModelApproval());
	    s.setModelOfIndebtedness(xml.getModelOfIndebtedness());
	    s.setPaymentCurrency(currencyRepository.findOneByPassword(xml.getPaymentCurrencyXML()));
	    s.setPurposeOfPayment(xml.getPurposeOfPayment());
	    s.setPaymentType(typesOfPaymentsRepository.findOneByCode(xml.getPaymentTypeXML()));
	    s.setReferenceNumberCreditor(xml.getReferenceNumberCreditor());
	    s.setReferenceNumberOfIndebtedness(xml.getReferenceNumberOfIndebtedness());
	    s.setStatus(xml.getStatus());
	    s.setType(xml.getType());
	    s.setTypeOfError(xml.getTypeOfError());
	    s.setUrgent(xml.getUrgent());
	    
	

		return s;
	}

	
	
	
	
	
	
	
	
	public StatementAnalysis getAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(StatementAnalysis.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StatementAnalysis xml = (StatementAnalysis) jaxbUnmarshaller.unmarshal(file);
		StatementAnalysis a = generateStatementAnalysis(xml);
		return a;

	}
	
}
