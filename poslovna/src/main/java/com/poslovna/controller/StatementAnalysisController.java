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
<<<<<<< HEAD
		return  saService.getStatementAnalysis(file);
=======
		
		StatementAnalysis sa = saService.getAnalyticsOfStatements(file);
		
		return  sa;
>>>>>>> 2a45d39fab39ba25e663f6327509aa10679bbf3e
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
