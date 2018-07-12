package com.poslovna.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public StatementAnalysis getStatementAnalysis(File file) throws JAXBException {

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
					.findOneByDateAndBankaccount(sa.getDateCurrency(), debtorAccount);

			if (dailyAccountBalance == null) {

				List<DailyAccountBalance> states = dabRepository.findByBankaccount_idEquals(debtorAccount.getBank().getId());
				System.out.println(states.size());
				if (states == null) {
					throw new IllegalArgumentException("Ne postoji dovoljno novca da bi se isplatilo !");
				} else {
					
					DailyAccountBalance max = states.get(0);
					System.out.println(max+"aaaaaaaa");
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date maxDate = date.parse(states.get(0).getDate());
					System.out.println(maxDate+"bbbbbbbbb");
					java.util.Date fromDate = date.parse(sa.getDateCurrency());

					for (int i = 1; i < states.size(); i++) {
						java.util.Date currentDate = date.parse(states.get(i).getDate());

						if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
							max = states.get(i);
						}
					}

					DailyAccountBalance dailyAccountBalanceNew = new DailyAccountBalance();
					dailyAccountBalanceNew.setBankaccount(debtorAccount);
					dailyAccountBalanceNew.setPreviousState(max.getNewState());
					dailyAccountBalanceNew.setNewState(0.0);
					dailyAccountBalanceNew.setPaymentTo(0.0);
					dailyAccountBalanceNew.setPaymentFrom(0.0);
					dailyAccountBalanceNew.setDate(sa.getDateCurrency());
					dabRepository.save(dailyAccountBalanceNew);
					dailyAccountBalanceNew.setPaymentFrom(dailyAccountBalanceNew.getPaymentFrom() + sa.getAmount());
					dailyAccountBalanceNew.setNewState(dailyAccountBalanceNew.getPreviousState()
							+ dailyAccountBalanceNew.getPaymentTo() - dailyAccountBalanceNew.getPaymentFrom());

					dabRepository.save(dailyAccountBalanceNew);

					sa.setDailyAccountBalance(dailyAccountBalanceNew);
					saRepository.save(sa);
				}

			} else {

				if (sa.getSum() > dailyAccountBalance.getNewState()) {

					throw new IllegalArgumentException("Ne postoji dovoljno novca za isplatu !");

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
	
	// cuvanje naloga za naplatu
		public StatementAnalysis saveStatementAnalysisForPayment(File file) throws JAXBException, ParseException {

			JAXBContext jaxbContext = JAXBContext.newInstance(StatementAnalysis.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StatementAnalysis xml = (StatementAnalysis) jaxbUnmarshaller.unmarshal(file);
			StatementAnalysis a = this.generateStatementAnalysisForPayment(xml);
			saRepository.save(a);

			if (a.getType().equals("Nalog za naplatu")) {
				Account debtorAccount = accountRepository.findOneById(a.getDebtorAccount().getId());
				Account creditorAccount = accountRepository.findOneById(a.getAccountCreditor().getId());
				DailyAccountBalance dailyAccountBalance = dabRepository
						.findOneByDateAndBankaccount(a.getDateOfReceipt(), debtorAccount);
				DailyAccountBalance dailyAccountBalanceCreditor = dabRepository
						.findOneByDateAndBankaccount(a.getDateOfReceipt(), creditorAccount);

				if (dailyAccountBalance == null) {
					List<DailyAccountBalance> balances =  dabRepository.findByBankaccount_idEquals(debtorAccount.getBank().getId());
					
					if (balances == null) {
						throw new IllegalArgumentException("Nema dovoljno sredstava za naplatu");
					} else {
						
						DailyAccountBalance max = balances.get(0);

						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						Date maxDate = date.parse(balances.get(0).getDate());

						Date fromDate = date.parse(a.getDateCurrency());

						for (int i = 1; i < balances.size(); i++) {
							Date currentDate = date.parse(balances.get(i).getDate());

							if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
								max = balances.get(i);
							}
						}

						DailyAccountBalance dailyAccountBalanceDebtor = new DailyAccountBalance();
					
						dailyAccountBalanceDebtor.setBankaccount(debtorAccount);
						dailyAccountBalanceDebtor.setPreviousState(max.getNewState());
						dailyAccountBalanceDebtor.setNewState(0.0);
						dailyAccountBalanceDebtor.setPaymentFrom(0.0);
						dailyAccountBalanceDebtor.setPaymentTo(0.0);
						dailyAccountBalanceDebtor.setDate(a.getDateCurrency());
						dabRepository.save(dailyAccountBalanceDebtor);

						dailyAccountBalanceDebtor.setPaymentFrom(dailyAccountBalanceDebtor.getPaymentFrom() + a.getSum());

						dailyAccountBalanceDebtor.setNewState(dailyAccountBalanceDebtor.getPreviousState()
								+ dailyAccountBalanceDebtor.getPaymentTo() - dailyAccountBalanceDebtor.getPaymentFrom());

						dabRepository.save(dailyAccountBalanceDebtor);

						a.setDailyAccountBalance(dailyAccountBalanceDebtor);
						saRepository.save(a);
					}

				} else {

					if (a.getSum() > dailyAccountBalance.getNewState()) {

						throw new IllegalArgumentException("Nema dovoljno sredstava za naplatu");

					}
					
					
					dailyAccountBalance.setPaymentFrom(dailyAccountBalance.getPaymentFrom() + a.getSum());
					dailyAccountBalance.setNewState(dailyAccountBalance.getPreviousState() + dailyAccountBalance.getPaymentTo()
							- dailyAccountBalance.getPaymentFrom());

					dabRepository.save(dailyAccountBalance);

					a.setDailyAccountBalance(dailyAccountBalance);
					saRepository.save(a);

				}

				if (dailyAccountBalanceCreditor == null) {
					List<DailyAccountBalance> states =  dabRepository.findByBankaccount_idEquals(debtorAccount.getBank().getId());
				
					if (states.size() != 0) {
						DailyAccountBalance max = states.get(0);

						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						Date maxDate = date.parse(states.get(0).getDate());

						Date fromDate = date.parse(a.getDateCurrency());

						for (int i = 1; i < states.size(); i++) {
							Date currentDate = date.parse(states.get(i).getDate());

							if (currentDate.after(maxDate) && currentDate.before(fromDate)) {
								max = states.get(i);
							}
						}

						DailyAccountBalance dailyAccountStateCred = new DailyAccountBalance();
						// setovanje dailyState za poverioca
						dailyAccountStateCred.setBankaccount(creditorAccount);
						dailyAccountStateCred.setPreviousState(max.getNewState());
						dailyAccountStateCred.setNewState(0.0);
						dailyAccountStateCred.setPaymentFrom(0.0);
						dailyAccountStateCred.setPaymentTo(0.0);
						dailyAccountStateCred.setDate(a.getDateCurrency());
						dabRepository.save(dailyAccountStateCred);

						dailyAccountStateCred.setPaymentTo(dailyAccountStateCred.getPaymentTo() + a.getSum());

						dailyAccountStateCred.setNewState(dailyAccountStateCred.getPreviousState()
								+ dailyAccountStateCred.getPaymentTo() - dailyAccountStateCred.getPaymentFrom());

						dabRepository.save(dailyAccountStateCred);

						a.setDailyAccountBalance(dailyAccountStateCred);
						saRepository.save(a);
					} else {
						DailyAccountBalance dailyAccountStateNewCreditor = new DailyAccountBalance();
					
						dailyAccountStateNewCreditor.setBankaccount(creditorAccount);
						dailyAccountStateNewCreditor.setPreviousState(0.0);
						dailyAccountStateNewCreditor.setNewState(0.0);
						dailyAccountStateNewCreditor.setPaymentFrom(0.0);
						dailyAccountStateNewCreditor.setPaymentTo(0.0);
						dailyAccountStateNewCreditor.setDate(a.getDateCurrency());
						dabRepository.save(dailyAccountStateNewCreditor);

						dailyAccountStateNewCreditor.setPaymentTo(dailyAccountStateNewCreditor.getPaymentTo() + a.getSum());

						dailyAccountStateNewCreditor.setNewState(dailyAccountStateNewCreditor.getPreviousState()
								+ dailyAccountStateNewCreditor.getPaymentTo() - dailyAccountStateNewCreditor.getPaymentFrom());

						dabRepository.save(dailyAccountStateNewCreditor);

						a.setDailyAccountBalance(dailyAccountStateNewCreditor);
						saRepository.save(a);
					}

				} else {


					dailyAccountBalanceCreditor.setPaymentTo(dailyAccountBalanceCreditor.getPaymentTo() + a.getSum());
					dailyAccountBalanceCreditor.setNewState(dailyAccountBalanceCreditor.getPreviousState() + dailyAccountBalanceCreditor.getPaymentTo()
							- dailyAccountBalanceCreditor.getPaymentFrom());

					dabRepository.save(dailyAccountBalanceCreditor);


					a.setDailyAccountBalance(dailyAccountBalanceCreditor);
					saRepository.save(a);

				}

			}

			return a;

		}
	
	
		// generisanje naloga za naplatu
		private StatementAnalysis generateStatementAnalysisForPayment(StatementAnalysis xml) {
			StatementAnalysis s = new StatementAnalysis();

			
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
		    s.setCode(xml.getCode());
		    

			return s;
		}


		public StatementAnalysis getStatementAnalysisPayment(File file) throws JAXBException {

			JAXBContext jaxbContext = JAXBContext.newInstance(StatementAnalysis.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StatementAnalysis xml = (StatementAnalysis) jaxbUnmarshaller.unmarshal(file);
			StatementAnalysis a = generateStatementAnalysisForPayment(xml);
			saRepository.save(a);

			return a;
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
