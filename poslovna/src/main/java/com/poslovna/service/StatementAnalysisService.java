package com.poslovna.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.model.Account;
import com.poslovna.model.DailyAccountBalance;
import com.poslovna.model.StatementAnalysis;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.CityRepository;
import com.poslovna.repository.CurrencyRepository;
import com.poslovna.repository.DailyAccountBalanceRepository;
import com.poslovna.repository.StatementAnalysisRepository;
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
	private StatementAnalysisRepository saRepository;
	
	@Autowired
	private DailyAccountBalanceRepository dabRepository;
	
	
	@Autowired
	private TypesOfPaymentsRepository typesOfPaymentsRepository;
	
	
	//generisanje naloga za isplatu
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

	
	
   //ucitavanje naloga za isplatu
	public StatementAnalysis getAnalyticsOfStatements(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(StatementAnalysis.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StatementAnalysis xml = (StatementAnalysis) jaxbUnmarshaller.unmarshal(file);
		StatementAnalysis a = generateStatementAnalysis(xml);
		return a;

	}
	
	// cuvanje naloga za isplatu
	public StatementAnalysis saveStatementAnalysis(File file) throws JAXBException, ParseException {

		JAXBContext jaxbContext = JAXBContext.newInstance(StatementAnalysis.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StatementAnalysis xml = (StatementAnalysis) jaxbUnmarshaller.unmarshal(file);
		StatementAnalysis sa = generateStatementAnalysis(xml);
		saRepository.save(sa);

		if (sa.getType().equals("Nalog za isplatu")) {
			Account debtorAccount = accountRepository.findOneById(sa.getDebtorAccount().getId());
			DailyAccountBalance dailyAccountBalance = dabRepository
					.findOneByDateAndBankAccount(sa.getDateCurrency(), debtorAccount);

			if (dailyAccountBalance == null) {

				ArrayList<DailyAccountBalance> states = dabRepository.findAllByBankAccount(debtorAccount);
				
				if (states == null) {
					throw new IllegalArgumentException("Ne posotoji dovoljno novca da bi se isplatilo !");
				} else {
				
					DailyAccountBalance max = states.get(0);

					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date maxDate = date.parse(states.get(0).getDate());

					java.util.Date fromDate = date.parse(sa.getDateCurrency());

					for (int i = 1; i < states.size(); i++) {
						java.util.Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountBalance dailyAccountBalanceNew = new DailyAccountBalance();
					dailyAccountBalanceNew.setBankAccount(debtorAccount);
					dailyAccountBalanceNew.setPreviousState(max.getNewState());
					dailyAccountBalanceNew.setNewState(0.0);
					dailyAccountBalanceNew.setPaymentTo(0.0);
					dailyAccountBalanceNew.setDate(sa.getDateCurrency());
					dabRepository.save(dailyAccountBalanceNew);

					dailyAccountBalanceNew.setPaymentFrom(dailyAccountBalanceNew.getPaymentFrom() + sa.getSum());
					dailyAccountBalanceNew.setNewState(dailyAccountBalanceNew.getPreviousState()
							+ dailyAccountBalanceNew.getPaymentTo() - dailyAccountBalanceNew.getPaymentFrom());

					dabRepository.save(dailyAccountBalanceNew);

					sa.setDailyAccountBalance(dailyAccountBalanceNew);
					saRepository.save(sa);
				}

			} else {

				if (sa.getSum() > dailyAccountBalance.getNewState()) {

					throw new IllegalArgumentException("Ne posotoji dovoljno novca za isplatu !");

				}
				dailyAccountBalance.setPaymentFrom(dailyAccountBalance.getPaymentFrom() + sa.getSum());
				dailyAccountBalance.setNewState(dailyAccountBalance.getPreviousState() + dailyAccountBalance.getPaymentTo()
						- dailyAccountBalance.getPaymentFrom());

				dabRepository.save(dailyAccountBalance);

				sa.setDailyAccountBalance(dailyAccountBalance);
				saRepository.save(sa);

			}

		}

		return sa;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
