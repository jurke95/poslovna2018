package com.poslovna.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.poslovna.model.StatementAnalysis;

@Service
public class StatementAnalysisService {

	
	
	private StatementAnalysis generateStatementAnalysis(StatementAnalysis xml) {
		StatementAnalysis s = new StatementAnalysis();
		s.setCity(xml.getCity());
		s.setCreditorReceiver(xml.getCreditorReceiver());
		s.setDailyAccountBalance(xml.getDailyAccountBalance());
		s.setDateCurrency(xml.getDateCurrency());
		s.setAmount(xml.getAmount());
	    s.setItemNumber(xml.getItemNumber());
	    s.setCityXML(xml.getCityXML());
	    s.setDateOfReceipt(xml.getDateOfReceipt());
	    s.setDebtorAccount(xml.getDebtorAccount());
	    s.setDebtorAccountXML(xml.getDebtorAccountXML());
	    s.setAccountCreditor(xml.getAccountCreditor());
	    s.setAccountCreditorXML(xml.getAccountCreditorXML());
	    s.setDebtorOrderer(xml.getDebtorOrderer());
	    s.setModelApproval(xml.getModelApproval());
	    s.setModelOfIndebtedness(xml.getModelOfIndebtedness());
	    s.setPaymentCurrency(xml.getPaymentCurrency());
	    s.setPaymentCurrencyXML(xml.getPaymentCurrencyXML());
	    s.setPurposeOfPayment(xml.getPurposeOfPayment());
	    s.setPaymentType(xml.getPaymentType());
	    s.setPaymentTypeXML(xml.getPaymentTypeXML());
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
