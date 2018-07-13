package com.poslovna.controller;

import java.io.File;
import java.text.ParseException;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.model.StatementAnalysis;
import com.poslovna.service.StatementAnalysisService;











@CrossOrigin
@RestController
@RequestMapping(value = "/analysis")
public class StatementAnalysisController {
	
	
	@Autowired
	private StatementAnalysisService saService;

	// ucitavanje naloga za isplatu
	@GetMapping("/payoff/{fileName}")
	public  StatementAnalysis loadXML(@PathVariable String fileName) throws JAXBException {
		
		File file = new File("filesxml\\" + fileName + ".xml");

		return  saService.getStatementAnalysis(file);

		
	

	}

	// cuvanje naloga za isplatu
	@GetMapping("/save/xml/{fileName}")
	public StatementAnalysis saveAnalysis(@PathVariable String fileName) throws JAXBException, ParseException {
		File file = new File("filesxml\\" + fileName + ".xml");
		return saService.saveStatementAnalysis(file);
	}
	
	// cuvanje naloga za naplatu
	@GetMapping("/save/payment/{fileName}")
	public StatementAnalysis saveStatementAnalysisPayment (@PathVariable String fileName) throws JAXBException, ParseException {
		File file = new File("filesxml\\" + fileName + ".xml");
			return saService.saveStatementAnalysisForPayment(file);
	}
    //ucitavanje naloga za naplatu
	@GetMapping("payment/{fileName}")
	public StatementAnalysis loadXMLPayment(@PathVariable String fileName) throws JAXBException {
		File file = new File("filesxml\\" + fileName + ".xml");
		return saService.getStatementAnalysisPayment(file);
	}
	
	
	//ucitavanje naloga za prenos
		@GetMapping("xml-prenos/{fileName}")
		public StatementAnalysis loadXMLTransfer(@PathVariable String fileName) throws JAXBException {
			File file = new File("filesxml\\" + fileName + ".xml");
			StatementAnalysis analysis = saService.getStatementAnalysisPayment(file);
			
			return analysis;
		}
	
		
		//cuvanje naloga za prenos
		@GetMapping("/save/xml-transfer/{fileName}")
		public StatementAnalysis saveAnalyticsTransfer(@PathVariable String fileName) throws JAXBException, ParseException {
			File file = new File("nalozi\\" + fileName + ".xml");
			StatementAnalysis analytic = saService.saveStatementAnalysisTransfer(file);
			saService.generateBankTransfer(analytic);
			return analytic;
		}
	
	
	
	
	
	
	
	
	

}
