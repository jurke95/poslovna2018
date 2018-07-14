package com.poslovna.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.poslovna.controller.dto.ClientReportDTO;
import com.poslovna.model.Account;
import com.poslovna.model.StatementAnalysis;
import com.poslovna.repository.AccountRepository;
import com.poslovna.repository.BankRepository;
import com.poslovna.repository.StatementAnalysisRepository;
import com.poslovna.service.ReportsService;







@CrossOrigin
@RestController
@RequestMapping(value = "/reports")
public class ReportsController {

	
	@Autowired
	private StatementAnalysisRepository statementAnalysisRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	
	public List<Account> getBankAccountsByBank(Long id) {
		
		
		List<Account> accounts = new ArrayList<Account>();
		
		accounts = accountRepository.findAllByBank(bankRepository.findByIdEquals(id));
		
		return accounts;
	}
	
	
	
	@RequestMapping(value = "/getAccounts/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getAccountsReport(@PathVariable Long id) throws IOException{
		
		
		
		
		ArrayList<Account> accounts = (ArrayList<Account>) getBankAccountsByBank(id);
		
		String bankName = bankRepository.findByIdEquals(id).getName();

        ByteArrayInputStream bis = ReportsService.accountsReport(accounts,bankName);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

		
}
	

	@RequestMapping(value = "/getClientReport", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getAccountsReport(@RequestBody ClientReportDTO crDTO) throws IOException{
		
		
		
		List<StatementAnalysis>sa=statementAnalysisRepository.findAll();
		

        ByteArrayInputStream bis = ReportsService.clientReport(sa,crDTO.getAccountnum(), crDTO.getDatefrom(), crDTO.getDateto());
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

		
}
	
	
	@RequestMapping(value="/get-client-report", method=RequestMethod.POST,
			produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> clientReport(@RequestBody ClientReportDTO rep) throws ParseException, TransformerException {
		List<StatementAnalysis> analyticsCred = new ArrayList<StatementAnalysis>();
		List<StatementAnalysis> analyticsDebt = new ArrayList<StatementAnalysis>();
		List<StatementAnalysis> analytics = new ArrayList<StatementAnalysis>();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	    
	    
		
		analyticsCred = statementAnalysisRepository.findAllByAccountCreditor(accountRepository.findOneByAccountnum(rep.getAccountnum()));
		analyticsDebt = statementAnalysisRepository.findAllByDebtorAccount(accountRepository.findOneByAccountnum(rep.getAccountnum()));
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date from = format.parse(rep.getDatefrom());
		Date to = format.parse(rep.getDateto());
		
		for(StatementAnalysis a : analyticsCred) {
			Date receipt = format.parse(a.getDateOfReceipt());
			System.out.println(receipt.toString());
			if( receipt.after(from) && receipt.before(to)) {
				analytics.add(a);
			}
		}
		
		for(StatementAnalysis a : analyticsDebt) {
			Date receipt = format.parse(a.getDateOfReceipt());
			System.out.println(receipt.toString());
			if( receipt.after(from) && receipt.before(to)) {
				analytics.add(a);
			}
		}
		
		Double initial;
		StatementAnalysis a = analytics.get(0);
		Date minDate = format.parse(a.getDateOfReceipt());
		for(int i = 1; i < analytics.size(); ++i) {
			Date receipt = format.parse(analytics.get(i).getDateOfReceipt());		
			if(receipt.before(minDate)){
				a = analytics.get(i);
				minDate = format.parse(a.getDateOfReceipt());
			}
		}
		initial = a.getDailyAccountBalance().getPreviousState();
		
		Double endState;
		StatementAnalysis ma = analytics.get(0);
		Date maxDate = format.parse(ma.getDateOfReceipt());
		for(int i = 1; i < analytics.size(); ++i) {
			Date receipt = format.parse(analytics.get(i).getDateOfReceipt());		
			if(receipt.after(maxDate)){
				ma = analytics.get(i);
				minDate = format.parse(ma.getDateOfReceipt());
			}
		}
		endState = ma.getDailyAccountBalance().getNewState();
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement =
	             doc.createElementNS("https://www.journaldev.com/employee", "Report");
			doc.appendChild(rootElement);
			
			Element e = doc.createElement("initialState");
			e.appendChild(doc.createTextNode(String.valueOf(initial)));
			rootElement.appendChild(e);
			
			Element e1 = doc.createElement("endState");
			e1.appendChild(doc.createTextNode(String.valueOf(endState)));
			rootElement.appendChild(e1);
			
			Element e2 = doc.createElement("client");
			if(accountRepository.findOneByAccountnum(rep.getAccountnum()).getIndividual() != null)
				e2.appendChild(doc.createTextNode(accountRepository.findOneByAccountnum(rep.getAccountnum()).getIndividual().getName()));
			else
				e2.appendChild(doc.createTextNode(accountRepository.findOneByAccountnum(rep.getAccountnum()).getLegalEntity().getName()));
			rootElement.appendChild(e2);
			
			Element e3 = doc.createElement("analytics");
			for(StatementAnalysis an : analytics) {
				Element temp = doc.createElement("analytic");
				Element sum = doc.createElement("sum");
				Element type = doc.createElement("type");
				sum.appendChild(doc.createTextNode(String.valueOf(an.getSum())));
				type.appendChild(doc.createTextNode(an.getType()));
				temp.appendChild(sum);
				temp.appendChild(type);
				e3.appendChild(temp);
			}
			
			rootElement.appendChild(e3);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
			
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("filesxml/clientReport/" + accountRepository.findOneByAccountnum(rep.getAccountnum()).getAccountnum() + ".xml"));
			
			transformer.transform(source, console);
			transformer.transform(source, file);
			
			System.out.println("DONE");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		List<StatementAnalysis>sa=statementAnalysisRepository.findAll();
		
        ByteArrayInputStream bis = ReportsService.clientReport(sa,rep.getAccountnum(),rep.getDatefrom(), rep.getDateto());
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=accounts.pdf");
		
		
		return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(bis));

	}
	
	
	
	
	
	
	
	
	
	
	
}
